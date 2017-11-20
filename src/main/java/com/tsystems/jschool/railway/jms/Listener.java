package com.tsystems.jschool.railway.jms;

import com.tsystems.jschool.railway.beans.BoardController;
import com.tsystems.jschool.railway.beans.PushBean;
import com.tsystems.jschool.railway.services.BoardService;
import org.jboss.ejb3.annotation.ResourceAdapter;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.*;

@MessageDriven(name = "TestMessageBean", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "testTopic"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
@ResourceAdapter("activemq")
public class Listener implements MessageListener {

    @Inject
    private PushBean pushBean;

    @EJB
    private BoardController boardController;

//    @Inject
//    private BoardService service;
//
//    @Inject
//    private Event<String> event;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = ((TextMessage) message);
            System.out.println(textMessage.getText());
            boardController.updateBoard();
            pushBean.handleEvent(textMessage.getText());
//            service.updateBoard("Sochi");
//            event.fire("");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
