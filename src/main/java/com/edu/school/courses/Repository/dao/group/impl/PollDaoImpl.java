package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.PollDao;
import com.edu.school.courses.Repository.group.PollRepository;
import com.edu.school.courses.model.group.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PollDaoImpl implements PollDao {

    private PollRepository pollRepository;

    @Autowired
    public PollDaoImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public Poll createPoll(Poll poll) {
        Poll newPoll = pollRepository.save(poll);
        return newPoll;
    }

    @Override
    public Poll getPoll(Long pollId) {
        Poll poll = pollRepository.getOne(pollId);
        return poll;
    }

    @Override
    public List<Poll> getAllPoll() {
        List<Poll> polls = pollRepository.findAll();
        return polls;
    }

    @Override
    public Poll updatePoll(Poll poll) {
        Poll updatedPoll = pollRepository.save(poll);
        return updatedPoll;
    }

}
