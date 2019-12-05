package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.dao.group.PollDao;
import com.edu.school.courses.model.group.Group;
import com.edu.school.courses.model.group.Poll;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    private PollDao pollDao;
    private CourseService courseService;

    @Autowired
    public PollService(PollDao pollDao, CourseService courseService) {
        this.pollDao = pollDao;
        this.courseService = courseService;
    }

    public Poll createPoll(Long courseId, Poll poll) {
        Group group = courseService.getCourse(courseId).getGroup();
        poll.setGroup(group);
        Poll newPoll = pollDao.createPoll(poll);
        return newPoll;
    }

    public Poll getPoll(Long pollId) {
        Poll poll = pollDao.getPoll(pollId);
        return poll;
    }

    public List<Poll> getAllPoll() {
        List<Poll> polls = pollDao.getAllPoll();
        return polls;
    }

    public void incrementPollCounter(Long pollId, String optionId) {
        Poll poll = pollDao.getPoll(pollId);
        poll.getOptions().forEach(option -> {
            if (option.getUidPk().equals(optionId)) {
                int optionCount = option.getCounter();
                option.setCounter(++optionCount);
            }
        });
        pollDao.updatePoll(poll);
    }

    public void incrementLike(Long pollId) {
        Poll poll = pollDao.getPoll(pollId);
        int likes = poll.getLikes();
        poll.setLikes(++likes);
        pollDao.updatePoll(poll);
    }
}
