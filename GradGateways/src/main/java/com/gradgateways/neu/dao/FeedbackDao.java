package com.gradgateways.neu.dao;

import java.util.List;
import com.gradgateways.neu.model.Feedback;

/**
*
* @author mrunalipawar
* interface : FeedbackDao
*/
public interface FeedbackDao {

	public List<Feedback> findAllFeedbacks();

	public void saveFeedback(Feedback feedback);
}
