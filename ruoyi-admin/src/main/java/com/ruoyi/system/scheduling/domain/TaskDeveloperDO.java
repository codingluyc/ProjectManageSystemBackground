package com.ruoyi.system.scheduling.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务-开发者对象 task_developer
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@Data
public class TaskDeveloperDO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 模块id */
    @Excel(name = "模块id")
    private Long moduleId;

    /** 任务id */
    @Excel(name = "任务id")
    private Long taskId;

    /** 项目id */
    @Excel(name = "项目名称")
    private String projectName;

    /** 模块id */
    @Excel(name = "模块名称")
    private String moduleName;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 开发者id */
    @Excel(name = "开发者id")
    private Long developerId;

    /** 开发者名称 */
    @Excel(name = "开发者名称")
    private String developerName;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 1 未开始 2 进行中 3 已完成 4 已测试 */
    @Excel(name = "1 未开始 2 进行中 3 已完成 4 已测试")
    private String state;



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("projectId", getProjectId())
            .append("moduleId", getModuleId())
            .append("taskId", getTaskId())
            .append("developerId", getDeveloperId())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("state", getState())
            .toString();
    }
}
