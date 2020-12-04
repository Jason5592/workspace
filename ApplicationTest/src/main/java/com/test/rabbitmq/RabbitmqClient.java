package com.test.rabbitmq;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;

public class RabbitmqClient {

    private final String QUEUE_HELLIWORLD = "helloworld";

    private final static ConnectionFactory factory;

    static {
        factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("virtualHost");
        factory.setHost("192.168.162.128");
        factory.setPort(5672);
    }

    @Test
    public void sendForHelloworld() throws Exception {
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        //创建队列,声明并创建一个队列，如果队列已存在，则使用这个队列
        //第一个参数：队列名称ID
        //第二个参数：是否持久化，false对应不持久化数据，MQ停掉数据就会丢失
        //第三个参数：是否队列私有化，false则代表所有消费者都可以访问，true代表只有第一次拥有它的消费者才能一直使用，其他消费者不让访问
        //第四个：是否自动删除,false代表连接停掉后不自动删除掉这个队列
        //其他额外的参数, null
        channel.queueDeclare(QUEUE_HELLIWORLD, false, false, false, null);

        String message = "hello world";
        //exchange 交换机，暂时用不到，在后面进行发布订阅时才会用到
        //队列名称
        //额外的设置属性
        //最后一个参数是要传递的消息字节数组
        channel.basicPublish(null, QUEUE_HELLIWORLD, null, message.getBytes());
        channel.close();
        System.out.println("发送成功！");
    }

    @Test
    public void receiveForHelloworld() throws Exception {
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        //创建队列,声明并创建一个队列，如果队列已存在，则使用这个队列
        //第一个参数：队列名称ID
        //第二个参数：是否持久化，false对应不持久化数据，MQ停掉数据就会丢失
        //第三个参数：是否队列私有化，false则代表所有消费者都可以访问，true代表只有第一次拥有它的消费者才能一直使用，其他消费者不让访问
        //第四个：是否自动删除,false代表连接停掉后不自动删除掉这个队列
        //其他额外的参数, null
        channel.queueDeclare(QUEUE_HELLIWORLD, false, false, false, null);

        //创建一个消息消费者
        //第一个参数：队列名
        //第二个参数代表是否自动确认收到消息，false代表手动编程来确认消息，这是MQ的推荐做法
        //第三个参数要传入DefaultConsumer的实现类
        channel.basicConsume(QUEUE_HELLIWORLD, false, new Receiver(channel));
    }
}

class Receiver extends DefaultConsumer {

    private final Channel channel;

    public Receiver(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String message = new String(body);
        System.out.println("消费者接收到的消息：" + message);

        System.out.println("消息的TagId：" + envelope.getDeliveryTag());
        //false只确认签收当前的消息，设置为true的时候则代表签收该消费者所有未签收的消息
        channel.basicAck(envelope.getDeliveryTag(), false);
    }
}
