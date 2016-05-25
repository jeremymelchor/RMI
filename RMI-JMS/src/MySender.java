import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MySender {

    public static void main(String[] args) {
        try {
            javax.jms.ConnectionFactory connectionFactory;
            connectionFactory = new ActiveMQConnectionFactory("user", "user", "tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection("user", "user");

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = session.createQueue("newQueue");

            MessageProducer messageProducer = session.createProducer(queue);
            connection.start();

            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("TEST1");
            messageProducer.send(queue, textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}  