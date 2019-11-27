package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.PollDao;
import com.edu.school.courses.Repository.group.PollRepository;
import com.edu.school.courses.model.dto.group.PollDto;
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
    public PollDto createPoll(PollDto pollDto) {
        return PollDto.PollToPollDtoMapper(pollRepository.save(PollDto.PollDtoToPollMapper(pollDto)));
    }

    @Override
    public PollDto getPoll(Long pollId) {
        return PollDto.PollToPollDtoMapper(pollRepository.getOne(pollId));
    }

    @Override
    public List<PollDto> getAllPoll() {
        return PollDto.PollDtoToPollMapper(pollRepository.findAll());
    }

    @Override
    public PollDto updatePoll(PollDto pollDto) {
        return PollDto.PollToPollDtoMapper(pollRepository.save(PollDto.PollDtoToPollMapper(pollDto)));
    }

}
