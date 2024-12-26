package com.ruoyi.system.scheduling.vo;

import com.ruoyi.system.scheduling.domain.ProjectDO;
import lombok.Data;

@Data
public class ProjectVO {
    private Long id;
    private String name;

    public static ProjectVO fromProject(ProjectDO d){
        if(d == null){
            return null;
        }
        ProjectVO vo = new ProjectVO();
        vo.setId(d.getId());
        vo.setName(d.getProjectName());
        return vo;
    }
}
