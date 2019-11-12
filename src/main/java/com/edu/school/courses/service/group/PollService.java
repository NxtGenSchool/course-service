package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.group.PollRepository;
import com.edu.school.courses.model.group.Group;
import com.edu.school.courses.model.group.Poll;
import com.edu.school.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    private PollRepository pollRepository;
    private CourseService courseService;

    @Autowired
    public PollService(PollRepository pollRepository, CourseService courseService) {
        this.pollRepository = pollRepository;
        this.courseService = courseService;
    }

    public Poll createPoll(Long courseId, Poll userPoll) {
        Poll newPoll = Poll.getInstance(userPoll);
        Group group = courseService.getCourse(courseId).getGroup();
        newPoll.setGroup(group);
        return pollRepository.save(newPoll);
    }

    public Poll getPoll(Long pollId) {
        return pollRepository.getOne(pollId);
    }

    public List<Poll> getAllPoll() {
        return pollRepository.findAll();
    }
}
