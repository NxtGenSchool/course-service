package com.edu.school.courses.api.group;

import com.edu.school.courses.model.dto.group.PollDto;
import com.edu.school.courses.model.group.Poll;
import com.edu.school.courses.service.group.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("courses/{courseId}/group/")
public class PollController {

    private PollService pollService;

    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping(path = "polls", produces = APPLICATION_JSON_VALUE)
    public PollDto createPoll(@PathVariable Long courseId, @RequestBody Poll poll) {
        Poll newPoll = pollService.createPoll(courseId, poll);
        return PollDto.PollToPollDtoMapper(newPoll);
    }

    @GetMapping(path = "polls/{pollId}", produces = APPLICATION_JSON_VALUE)
    public PollDto getPoll(@PathVariable Long pollId) {
        Poll poll = pollService.getPoll(pollId);
        return PollDto.PollToPollDtoMapper(poll);
    }

    @GetMapping(path = "polls/all", produces = APPLICATION_JSON_VALUE)
    public List<PollDto> getAllPoll() {
        List<Poll> polls = pollService.getAllPoll();
        return PollDto.PollToPollDtoMapper(polls);
    }

    @PutMapping(path = "polls/{pollId}/options/{optionId}")
    public void incrementOptionCounter(@PathVariable Long pollId, @PathVariable String optionId) {
        pollService.incrementPollCounter(pollId, optionId);
    }

    @PutMapping(path = "polls/{pollId}/likes")
    public void incrementLike(@PathVariable Long pollId) {
        pollService.incrementLike(pollId);
    }
}
