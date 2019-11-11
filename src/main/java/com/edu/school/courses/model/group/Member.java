package com.edu.school.courses.model.group;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidPk;

    //TODO: change Group to groupId
    @ManyToOne(targetEntity = Group.class)
    @JsonIgnore
    private Group group;
    private Long memberUidPk;
    private String firstName;
    private String lastName;

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

    public Long getMemberUidPk() {
        return memberUidPk;
    }

    public void setMemberUidPk(Long memberUidPk) {
        this.memberUidPk = memberUidPk;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
