package com.edu.school.courses.api.group;

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
    public Poll createPoll() {
        return pollService.createPoll();
    }

    @GetMapping(path = "polls/{pollId}", produces = APPLICATION_JSON_VALUE)
    public Poll getPoll(@PathVariable Long pollId) {
        return pollService.getPoll(pollId);
    }

    @GetMapping(path = "polls/all", produces = APPLICATION_JSON_VALUE)
    public List<Poll> getAllPoll() {
        return pollService.getAllPoll();
    }
}
