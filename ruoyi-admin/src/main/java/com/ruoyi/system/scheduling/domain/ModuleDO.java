package com.ruoyi.system.scheduling.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模块对象 module
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@Data
public class ModuleDO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 项目id */
    @Excel(name = "项目名称")
    private String projectName;

    /** 唯一编码 */
    @Excel(name = "唯一编码")
    private String code;

    /** 模块名称 */
    @Excel(name = "模块名称")
    private String name;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("code", getCode())
            .append("name", getName())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
