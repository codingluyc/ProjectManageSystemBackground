package com.ruoyi.system.vo;

import com.ruoyi.system.domain.ModuleDO;
import lombok.Data;

@Data
public class ModuleVO {
    private Long id;
    private String moduleName;
    private String projectName;

    public static ModuleVO fromModule(ModuleDO d){
        if(d == null){
            return null;
        }
        ModuleVO vo = new ModuleVO();
        vo.setId(d.getId());
        vo.setModuleName(d.getName());
        vo.setProjectName(d.getProjectName());
        return vo;
    }

}
