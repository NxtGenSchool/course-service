package com.edu.school.courses.Repository.dao.group;

import com.edu.school.courses.model.group.Group;

import java.util.List;

public interface GroupDao {

    Group saveGroup(Group group);

    Group getGroup(Long groupId);

    List<Group> getAllGroups();
}
