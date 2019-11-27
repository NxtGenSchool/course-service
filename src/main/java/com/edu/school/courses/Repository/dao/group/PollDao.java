package com.edu.school.courses.Repository.dao.group;

import com.edu.school.courses.model.dto.group.PollDto;

import java.util.List;

public interface PollDao {
    PollDto createPoll(PollDto pollDto);

    PollDto getPoll(Long pollId);

    List<PollDto> getAllPoll();

    PollDto updatePoll(PollDto pollDto);
}
