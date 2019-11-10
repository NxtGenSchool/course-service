package com.edu.school.courses.model.group;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidPk;

    @ManyToOne(targetEntity = Group.class)
    private Long groupId;
    private Long memberUidPk;
    private String firstName;
    private String lastName;
}
