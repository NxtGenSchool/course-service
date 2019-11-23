package com.edu.school.courses.service.group;

import com.edu.school.courses.Repository.dao.group.GroupDao;
import com.edu.school.courses.model.dto.group.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private GroupDao groupDao;

    @Autowired
    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public GroupDto createGroup(GroupDto userGroup) {
        return groupDao.saveGroup(userGroup);
    }

    public GroupDto getGroup(Long groupId) {
        return groupDao.getGroup(groupId);
    }

    public List<GroupDto> getAllGroup() {
        return groupDao.getAllGroups();
    }
}
