package com.edu.school.courses.api.group;

import com.edu.school.courses.model.group.Group;
import com.edu.school.courses.service.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("courses/{courseId}/")
public class GroupController {

    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(path = "groups", produces = APPLICATION_JSON_VALUE)
    public Group createGroup() {
        return groupService.createGroup();
    }

    @GetMapping(path = "groups/{groupId}", produces = APPLICATION_JSON_VALUE)
    public Group getGroup(@PathVariable Long groupId) {
        return groupService.getGroup(groupId);
    }

    @GetMapping(path = "groups/all", produces = APPLICATION_JSON_VALUE)
    public List<Group> getAllGroup() {
        return groupService.getAllGroup();
    }
}
