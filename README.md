docker network create rocketmq-net



mkdir -p  /docker/rocketmq/data/namesrv/logs   /docker/rocketmq/data/namesrv/store



docker run -d \
--restart=always \
--name rmqnamesrv \
--network=rocketmq-net \
-p 9876:9876 \
-v /docker/rocketmq/data/namesrv/logs:/root/logs \
-v /docker/rocketmq/data/namesrv/store:/root/store \
-e "MAX_POSSIBLE_HEAP=100000000" \
-d apache/rocketmq:latest \
sh mqnamesrv

mkdir -p  /docker/rocketmq/data/broker/logs   /docker/rocketmq/data/broker/store /docker/rocketmq/conf


vi /docker/rocketmq/conf/broker.conf
#所属集群名称，如果节点较多可以配置多个
brokerClusterName = DefaultCluster
#broker名称，master和slave使用相同的名称，表明他们的主从关系
brokerName = broker-a
#0表示Master，大于0表示不同的slave
brokerId = 0
#表示几点做消息删除动作，默认是凌晨4点
deleteWhen = 04
#在磁盘上保留消息的时长，单位是小时
fileReservedTime = 48
#有三个值：SYNC_MASTER，ASYNC_MASTER，SLAVE；同步和异步表示Master和Slave之间同步数据的机制；
brokerRole = ASYNC_MASTER
#刷盘策略，取值为：ASYNC_FLUSH，SYNC_FLUSH表示同步刷盘和异步刷盘；SYNC_FLUSH消息写入磁盘后才返回成功状态，ASYNC_FLUSH不需要；
flushDiskType = ASYNC_FLUSH
#设置broker节点所在服务器的ip地址
brokerIP1 = 填容器地址
#磁盘使用达到95%之后,生产者再写入消息会报错 CODE: 14 DESC: service not available now, maybe disk full
diskMaxUsedSpaceRatio=95
#在发送消息时，自动创建服务器不存在的topic，默认创建的队列数
defaultTopicQueueNums= 8
#是否允许 Broker 自动创建Topic，建议线下开启，线上关闭
autoCreateTopicEnable= true
#是否允许 Broker 自动创建订阅组，建议线下开启，线上关闭
autoCreateSubscriptionGroup= true




docker run -d  \
--restart=always \
--name rmqbroker \
--link rmqnamesrv:namesrv \
--network=rocketmq-net \
-p 10911:10911 \
-p 10909:10909 \
-v  /docker/rocketmq/data/broker/logs:/root/logs \
-v  /docker/rocketmq/data/broker/store:/root/store \
-v /docker/rocketmq/conf/broker.conf:/opt/rocketmq-latest/conf/broker.conf \
-e "NAMESRV_ADDR=namesrv:9876" \
-e "JAVA_OPT_EXT=-Xms256m -Xmx256m" \
-e "MAX_POSSIBLE_HEAP=200000000" \
-d apache/rocketmq:latest \
sh mqbroker -c /opt/rocketmq-latest/conf/broker.conf 


docker pull pangliang/rocketmq-console-ng


docker run -d \
--restart=always \
--name rmqadmin \
--network=rocketmq-net \
-e "JAVA_OPTS=-Drocketmq.namesrv.addr=8.137.39.241:9876 \
-Dcom.rocketmq.sendMessageWithVIPChannel=false" \
-p 9999:8080 \
pangliang/rocketmq-console-ng

#开放指定端口
firewall-cmd --permanent --zone=public --add-port=9876/tcp
firewall-cmd --permanent --zone=public --add-port=10911/tcp
#立即生效
firewall-cmd --reload


