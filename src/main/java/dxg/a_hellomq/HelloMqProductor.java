package dxg.a_hellomq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @auther 丁溪贵  ctrl+alt+v ==eclipse shift+alt+l 快速返回值
 * @date 2019/9/1
 */
public class HelloMqProductor {

    public static void main(String[] args) throws JMSException {
        //        这个构造函数其实有三个参数，前2个参数是用户名和密码 ，默认为admin/admin
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
        Connection connection = factory.createConnection();
        connection.start(); // 开启连接
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//自动签收
        Queue queue = session.createQueue("testQueue4");// 创建目的地
        MessageProducer producer = session.createProducer(queue);//创建消息生成者
        TextMessage textMessage = session.createTextMessage("你好啊！");//创建一个文本消息
        producer.send(textMessage); //发送消息 （这里可以发送多条消息）

//        关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
