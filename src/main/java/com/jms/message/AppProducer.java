package com.jms.message;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AppProducer {
	
	private static final String URL = "tcp://localhost:61616";
	
	private static final String QUEUENAME = "queue-test";
	
	public static void main(String[] args) {
		
		//创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
		
		//创建连接
		Connection connection = null;
		
		try {
			
			connection = connectionFactory.createConnection();
			
			connection.start();
		//创建会话
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
		//创建目标Destination
			Destination destination = session.createQueue(QUEUENAME);
		
		//创建生产者
			MessageProducer producer = session.createProducer(destination);
		
			for (int i = 0; i <100; i++) {
			
			//创建消息
				TextMessage textMessage = session.createTextMessage("test" + i);
			
			//发布消息
				producer.send(textMessage);
				
				System.out.println("发送消息：" +  textMessage.getText());
			
			}
			
		} catch (JMSException e) {
			
			e.printStackTrace();
			
		}finally {
			
			if(connection != null){
				
				//关闭连接
				try {
					connection.close();
					
				} catch (JMSException e) {
					
					e.printStackTrace();
				}
				
			}
		}
		
	}

}
