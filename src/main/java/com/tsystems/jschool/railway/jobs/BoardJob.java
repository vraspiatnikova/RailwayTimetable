package com.tsystems.jschool.railway.jobs;

import com.tsystems.jschool.railway.beans.BoardService;
import com.tsystems.jschool.railway.beans.PushBean;

import javax.ejb.Schedule;
import javax.inject.Inject;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;

@Singleton
@ApplicationScoped
public class BoardJob {

    @Inject
    private BoardService boardService;

    @Inject
    private PushBean pushBean;

    @Schedule(minute="*/1", hour="*")
    public void deleteOldBoards() {
        if (boardService.checkForOldBoards()) {
            boardService.updateBoard();
            pushBean.handleEvent("it's time to update");
        }
    }
}
