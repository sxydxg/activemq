file encoding=utf-8

ActivMq的目录虚拟机的centOS 64的/mymq 目录下（压缩文件和解压文件我都放在这下面）
netstat -anp| grep 61616
ps -aux| grep activemq
ps ef|grep acrviemq

activemq  ----后台界面默认端口8161   ，服务端默认端口61616
activemq 初始化密码都为 admin
1.activemq版本为 5.12 ---jdk7
2.教程的activemq版本为5.15-----jdk为8  (我不想重新安装jdk8所有就用老一点的mq版本)


lombok 原先没有使用过哦