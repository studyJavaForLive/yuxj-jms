package com.jms.message;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AppConsumer {
	
	private static final String URL = "tcp://localhost:61616"; 
	
	private static final String QUEUENAME = "queue-test";

	public static void main(String[] args) {
		
		//创建消息工厂
		ConnectionFactory connectionFatory = new ActiveMQConnectionFactory(URL);
		
		//创建连接
		Connection connection = null;
		try {
			connection = connectionFatory.createConnection();
			//启动连接
			connection.start();
		//创建session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
		//创建目标
			Destination destinaiton = session.createQueue(QUEUENAME);
			
		//创建消费者
			MessageConsumer consumer = session.createConsumer(destinaiton);
			
		//创建监听器
			consumer.setMessageListener(new MessageListener() {
				
				public void onMessage(Message paramMessage) {
					
					TextMessage textMessage = (TextMessage)paramMessage;
					
					try {
						
						System.out.println("接受到的消息" + textMessage.getText());
						
					} catch (JMSException e) {
						
						e.printStackTrace();
					}
					
				}
			});
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
