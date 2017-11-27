package com.tsystems.jschool.railway.jms;

import com.tsystems.jschool.railway.beans.BoardService;
import com.tsystems.jschool.railway.beans.PushBean;
import org.apache.log4j.Logger;
import org.jboss.ejb3.annotation.ResourceAdapter;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;

@MessageDriven(name = "TestMessageBean", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "testTopic"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
@ResourceAdapter("activemq")
public class Listener implements MessageListener {

    private static final Logger LOGGER = Logger.getLogger(Listener.class);

    @Inject
    private PushBean pushBean;

    @Inject
    private BoardService boardService;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = ((TextMessage) message);
            String msg = textMessage.getText();
            LOGGER.info("New message from topic: " + msg);
            if (msg.contains("edit")){
                boardService.updateOneBoard(msg);
                pushBean.handleEvent(textMessage.getText());
            }
            else if (msg.contains("delete")){
                if (boardService.isBoardsContainsId(msg)){
                    boardService.updateBoard();
                    pushBean.handleEvent(textMessage.getText());
                }
            }
            else {
                boardService.updateBoard();
                pushBean.handleEvent(textMessage.getText());
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
