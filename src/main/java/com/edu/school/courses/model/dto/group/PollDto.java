package com.edu.school.courses.model.dto.group;

import com.edu.school.courses.model.group.Author;
import com.edu.school.courses.model.group.Group;
import com.edu.school.courses.model.group.Option;
import com.edu.school.courses.model.group.Poll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PollDto {

    private Long uidPk;
    private Group group;
    private Author author;
    private String content;
    private LocalDate createdDate;
    private int likes;
    private List<Option> options;

    public static Poll PollDtoToPollMapper(PollDto pollDto) {
        Poll poll = new Poll();
        if (pollDto != null) {
            poll.setUidPk(pollDto.getUidPk());
            poll.setGroup(pollDto.getGroup());
            poll.setContent(pollDto.getContent());
            poll.setOptions(pollDto.getOptions());
            poll.setLikes(pollDto.getLikes());
            poll.setAuthor(pollDto.getAuthor());
            poll.setCreatedDate(pollDto.getCreatedDate());
        }
        return poll;
    }

    public static PollDto PollToPollDtoMapper(Poll poll) {
        PollDto pollDto = new PollDto();
        if (poll != null) {
            pollDto.setUidPk(poll.getUidPk());
            pollDto.setContent(poll.getContent());
            pollDto.setAuthor(poll.getAuthor());
            pollDto.setGroup(poll.getGroup());
            pollDto.setCreatedDate(poll.getCreatedDate());
            pollDto.setOptions(poll.getOptions());
            pollDto.setLikes(poll.getLikes());
        }
        return pollDto;
    }

    public static List<PollDto> PollToPollDtoMapper(List<Poll> polls) {
        List<PollDto> pollDtoList = new ArrayList<>();
        for (Poll poll : polls) {
            PollDto pollDto = new PollDto();
            pollDto.setUidPk(poll.getUidPk());
            pollDto.setContent(poll.getContent());
            pollDto.setAuthor(poll.getAuthor());
            pollDto.setGroup(poll.getGroup());
            pollDto.setCreatedDate(poll.getCreatedDate());
            pollDto.setOptions(poll.getOptions());
            pollDto.setLikes(poll.getLikes());
            pollDtoList.add(pollDto);
        }
        return pollDtoList;
    }

    public Long getUidPk() {
        return uidPk;
    }

    public void setUidPk(Long uidPk) {
        this.uidPk = uidPk;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
