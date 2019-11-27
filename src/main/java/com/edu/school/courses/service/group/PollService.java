package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.dao.group.PollDao;
import com.edu.school.courses.model.dto.group.PollDto;
import com.edu.school.courses.model.group.Group;
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

    public PollDto createPoll(Long courseId, PollDto pollDto) {
        Group group = courseService.getCourse(courseId).getGroup();
        pollDto.setGroup(group);
        return pollDao.createPoll(pollDto);
    }

    public PollDto getPoll(Long pollId) {
        return pollDao.getPoll(pollId);
    }

    public List<PollDto> getAllPoll() {
        return pollDao.getAllPoll();
    }

    public void incrementPollCounter(Long pollId, String optionId) {
        PollDto pollDto = pollDao.getPoll(pollId);
        pollDto.getOptions().forEach(option -> {
            if (option.getUidPk().equals(optionId)) {
                int optionCount = option.getCounter();
                option.setCounter(++optionCount);
            }
        });
        pollDao.updatePoll(pollDto);
    }

    public void incrementLike(Long pollId) {
        PollDto pollDto = pollDao.getPoll(pollId);
        int likes = pollDto.getLikes();
        pollDto.setLikes(++likes);
        pollDao.updatePoll(pollDto);
    }
}
