package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.group.PollRepository;
import com.edu.school.courses.model.group.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    private PollRepository pollRepository;

    @Autowired
    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll() {
        return pollRepository.save(new Poll());
    }

    public Poll getPoll(Long pollId) {
        return pollRepository.getOne(pollId);
    }

    public List<Poll> getAllPoll() {
        return pollRepository.findAll();
    }
}
