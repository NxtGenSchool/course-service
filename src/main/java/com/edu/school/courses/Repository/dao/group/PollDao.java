package com.edu.school.courses.Repository.dao.group;

import com.edu.school.courses.model.group.Poll;

import java.util.List;

public interface PollDao {
    Poll createPoll(Poll poll);

    Poll getPoll(Long pollId);

    List<Poll> getAllPoll();

    Poll updatePoll(Poll poll);
}
