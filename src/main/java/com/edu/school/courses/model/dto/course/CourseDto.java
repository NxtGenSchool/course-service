package com.edu.school.courses.model.dto.course;

import com.edu.school.courses.model.CourseSchedule;
import com.edu.school.courses.model.group.Group;

import java.time.LocalDate;
import java.util.List;

public class CourseDto {

    private Long uidPk;

    private Group group;

    private LocalDate startDate;
    private LocalDate endDate;
    private List<CourseSchedule> courseSchedules;

    public Long getUidPk() {
        return uidPk;
    }

    public void setUidPk(Long uidPk) {
        this.uidPk = uidPk;
    }
}
