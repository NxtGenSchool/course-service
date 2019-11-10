package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.group.GroupRepository;
import com.edu.school.courses.model.group.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group createGroup() {
        return groupRepository.save(new Group());
    }

    public Group getGroup(Long groupId) {
        return groupRepository.getOne(groupId);
    }

    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }
}
