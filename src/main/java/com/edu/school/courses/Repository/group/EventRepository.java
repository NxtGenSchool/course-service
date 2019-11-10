package com.edu.school.courses.Repository.group;

import com.edu.school.courses.model.group.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
