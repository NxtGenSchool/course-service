package com.edu.school.courses.model.Group;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class Answer {
    private Long authorUID;
    private String content;
    private LocalDate createdDate;
    private int likes;
}
