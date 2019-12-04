package com.edu.school.courses.Repository.dao.group.impl;

import com.edu.school.courses.Repository.dao.group.GroupDao;
import com.edu.school.courses.Repository.group.GroupRepository;
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
    public Group saveGroup(Group group) {
        Group savedGroupDto = groupRepository.save(group);
        return savedGroupDto;
    }

    @Override
    public Group getGroup(Long groupId) {
        Group domainGroup = groupRepository.getOne(groupId);
        return domainGroup;
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> domainGroups = groupRepository.findAll();
        return domainGroups;
    }

}
