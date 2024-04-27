package com.gradgateways.neu.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import com.gradgateways.neu.model.Feedback;

/**
*
* @author mrunalipawar
* class : FeedbackDAOimpl
*/

@Component
public class FeedbackDAOimpl extends ConnectionDAO implements FeedbackDao{

	@Override
    public List<Feedback> findAllFeedbacks() {
        getActiveSession();
        List<Feedback> feedbackList = null;
        try {
        	beginHibernateTransaction();
            Query<Feedback> query = getActiveSession().createQuery("FROM Feedback", Feedback.class);
            feedbackList = query.list();
            commitTransaction();
        } catch (HibernateException e) {
            rollbackTransaction();
            e.printStackTrace();
        } finally {
            closeTransaction();
        }
        return feedbackList;
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        getActiveSession();
        try {
        	beginHibernateTransaction();
            getActiveSession().saveOrUpdate(feedback);
            commitTransaction();
        } catch (HibernateException e) {
            rollbackTransaction();
            e.printStackTrace();
        } finally {
            closeTransaction();
        }
    }

}
