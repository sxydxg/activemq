package dxg.a_hellomq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.xml.soap.Text;
/**
 *  如果将createSession该为true可以多次消费（学到后面看看为什么）
 */

/**
 * @auther 丁溪贵
 * @date 2019/9/1
 */
public class HelloMqComsumer {
    public static void main(String[] args) throws JMSException {
//        这个构造函数其实有三个参数，前2个参数是用户名和密码 ，默认为admin/admin
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
        Connection connection = factory.createConnection();
        connection.start(); // 开启连接
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//自动签收
        Queue queue = session.createQueue("testQueue4");// 创建目的地
        MessageConsumer consumer = session.createConsumer(queue);//创建消费者
        consumer.setMessageListener(new MessageListener() {

            public void onMessage(Message message) {
                TextMessage message1 = (TextMessage) message ;
                try {
                    System.out.println(message1.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

//        consumer.close();
//        session.close();
//        connection.close();
    }
}
