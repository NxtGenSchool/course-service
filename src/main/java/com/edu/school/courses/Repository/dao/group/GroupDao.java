package com.edu.school.courses.Repository.dao.group;

import com.edu.school.courses.model.dto.group.GroupDto;

import java.util.List;

public interface GroupDao {

    GroupDto saveGroup(GroupDto group);

    GroupDto getGroup(Long groupId);

    List<GroupDto> getAllGroups();
}
