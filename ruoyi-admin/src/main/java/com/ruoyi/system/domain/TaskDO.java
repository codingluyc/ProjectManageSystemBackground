package com.ruoyi.system.domain;

import java.time.LocalDate;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 任务对象 task
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@Data
public class TaskDO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    //自动分工
    private int auto;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 模块id */
    @Excel(name = "模块id")
    private Long moduleId;

    /** 模块id */
    private Long[] moduleIds;

    /**
     * 职责
     */
    private String[] duties;

    /** 项目id */
    @Excel(name = "项目名称")
    private String projectName;

    /** 模块id */
    @Excel(name = "模块名称")
    private String moduleName;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String name;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDateBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDateEnd;

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
            .append("name", getName())
            .append("remark", getRemark())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("state", getState())
            .toString();
    }
}
