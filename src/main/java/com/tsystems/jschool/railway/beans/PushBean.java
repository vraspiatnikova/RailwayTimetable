package com.tsystems.jschool.railway.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class PushBean {

    @Inject
    @Push(channel = "push")
    private PushContext push;

    public void handleEvent(@Observes String message){
        push.send("updateTable");
    }

}
