package com.edu.school.courses.api.group;

import com.edu.school.courses.model.dto.group.GroupDto;
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

    @PostMapping(path = "groups/create", produces = APPLICATION_JSON_VALUE)
    public GroupDto createGroup(@PathVariable Long courseId, @RequestBody GroupDto userGroup) {
        Group newGroup = groupService.createGroup(courseId, GroupDto.GroupDtoToGroupMapper(userGroup));
        return GroupDto.GroupToGroupDtoMapper(newGroup);
    }

    @GetMapping(path = "groups/{groupId}", produces = APPLICATION_JSON_VALUE)
    public GroupDto getGroup(@PathVariable Long groupId) {
        Group group = groupService.getGroup(groupId);
        return GroupDto.GroupToGroupDtoMapper(group);
    }

    @GetMapping(path = "groups/all", produces = APPLICATION_JSON_VALUE)
    public List<GroupDto> getAllGroup() {
        List<Group> groups = groupService.getAllGroup();
        return GroupDto.GroupToGroupDtoMapper(groups);
    }
}
