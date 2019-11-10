package com.edu.school.courses.model.Group;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Embeddable
public class Comment {

    @OneToOne
    private Author author;
    private String content;
    private LocalDate createdDate;
}
