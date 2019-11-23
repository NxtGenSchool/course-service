package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.GroupDao;
import com.edu.school.courses.Repository.group.GroupRepository;
import com.edu.school.courses.model.dto.group.GroupDto;
import com.edu.school.courses.model.group.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupDaoImpl implements GroupDao {

    private GroupRepository groupRepository;

    @Autowired
    public GroupDaoImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupDto saveGroup(GroupDto group) {
        Group domainGroup = GroupDto.GroupDtoToGroupMapper(group);
        return GroupDto.GroupToGroupDtoMapper(groupRepository.save(domainGroup));
    }

    @Override
    public GroupDto getGroup(Long groupId) {
        Group domainGroup = groupRepository.getOne(groupId);
        return GroupDto.GroupToGroupDtoMapper(domainGroup);
    }

    @Override
    public List<GroupDto> getAllGroups() {
        List<Group> domainGroups = groupRepository.findAll();
        return GroupDto.GroupToGroupDtoMapper(domainGroups);
    }

}
