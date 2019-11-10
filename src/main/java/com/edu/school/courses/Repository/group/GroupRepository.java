package com.edu.school.courses.Repository.group;

import com.edu.school.courses.model.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
