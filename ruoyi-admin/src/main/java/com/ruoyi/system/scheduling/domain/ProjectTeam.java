package com.ruoyi.system.scheduling.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目团队对象 project_team
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
@Data
public class ProjectTeam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;
    @Excel(name = "项目")
    private String projectName;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    @Excel(name = "用户名")
    private String userName;

    @Override
    public String toString() {
        return "ProjectTeam{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", userId=" + userId +
                ", userName=" + userName +
                '}';
    }
}
