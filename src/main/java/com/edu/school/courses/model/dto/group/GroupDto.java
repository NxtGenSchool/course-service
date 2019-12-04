package com.edu.school.courses.model.dto.group;

import com.edu.school.courses.model.group.*;

import java.util.ArrayList;
import java.util.List;

public class GroupDto {

    private Long uidPk;
    private String admin;
    private List<String> moderator;
    private List<Member> members;
    private List<Post> posts;
    private List<Question> questions;
    private List<Poll> polls;
    private List<Event> events;

    public static Group GroupDtoToGroupMapper(GroupDto groupDto) {
        Group group = new Group();
        group.setAdmin(groupDto.getAdmin());
        group.setEvents(groupDto.getEvents());
        group.setMembers(groupDto.getMembers());
        group.setModerator(groupDto.getModerator());
        group.setPolls(groupDto.getPolls());
        group.setPosts(groupDto.getPosts());
        group.setQuestions(groupDto.getQuestions());
        return group;
    }

    public static GroupDto GroupToGroupDtoMapper(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setUidPk(group.getUidPk());
        groupDto.setAdmin(group.getAdmin());
        groupDto.setEvents(group.getEvents());
        groupDto.setMembers(group.getMembers());
        groupDto.setModerator(group.getModerator());
        groupDto.setPolls(group.getPolls());
        groupDto.setPosts(group.getPosts());
        groupDto.setQuestions(group.getQuestions());
        return groupDto;
    }

    public static List<GroupDto> GroupToGroupDtoMapper(List<Group> groupList) {
        List<GroupDto> groupDtoList = new ArrayList<>();
        for (Group group : groupList) {
            GroupDto groupDto = new GroupDto();
            groupDto.setAdmin(group.getAdmin());
            groupDto.setEvents(group.getEvents());
            groupDto.setMembers(group.getMembers());
            groupDto.setModerator(group.getModerator());
            groupDto.setPolls(group.getPolls());
            groupDto.setPosts(group.getPosts());
            groupDto.setQuestions(group.getQuestions());
            groupDtoList.add(groupDto);
        }
        return groupDtoList;
    }

    public Long getUidPk() {
        return uidPk;
    }

    public void setUidPk(Long uidPk) {
        this.uidPk = uidPk;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public List<String> getModerator() {
        return moderator;
    }

    public void setModerator(List<String> moderator) {
        this.moderator = moderator;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
