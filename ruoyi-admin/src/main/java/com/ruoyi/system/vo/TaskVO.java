package com.ruoyi.system.vo;

import com.ruoyi.system.domain.TaskDO;
import lombok.Data;

@Data
public class TaskVO {
    private Long id;
    private String name;
    public static TaskVO fromTask(TaskDO d){
        if(d == null){
            return null;
        }
        TaskVO vo = new TaskVO();
        vo.setId(d.getId());
        vo.setName(d.getName());
        return vo;
    }
}
