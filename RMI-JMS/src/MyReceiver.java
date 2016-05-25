import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by user on 25/05/2016.
 */
public class MyReceiver implements MessageListener {


    public static void main(String[] args) {
        MyReceiver m = new MyReceiver();
        m.init();
    }

    public void init() {
        try {
            javax.jms.ConnectionFactory connectionFactory;
            connectionFactory = new ActiveMQConnectionFactory("user", "user", "tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection("user", "user");

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = session.createQueue("newQueue");
            connection.start();


            MessageConsumer messageConsumer = session.createConsumer(queue);
            messageConsumer.setMessageListener(this);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}

