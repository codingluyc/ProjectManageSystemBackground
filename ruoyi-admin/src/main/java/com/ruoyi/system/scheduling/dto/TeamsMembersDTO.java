package com.ruoyi.system.scheduling.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamsMembersDTO {
    private Long projectId;
    private List<Long> userIds;
}
