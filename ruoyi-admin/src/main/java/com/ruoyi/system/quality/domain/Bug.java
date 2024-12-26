package com.ruoyi.system.quality.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * bug对象 bugs
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
@Data
public class Bug extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 具体描述 */
    @Excel(name = "具体描述")
    private String description;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;
    @Excel(name = "项目名称")
    private String projectName;

    /** 模块id */
    @Excel(name = "模块id")
    private Long moduleId;
    @Excel(name = "模块名称")
    private String moduleName;

    /** 版本 */
    @Excel(name = "版本")
    private String version;

    /** 发现人id */
    @Excel(name = "发现人id")
    private Long proposerId;

    @Excel(name = "发现人姓名")
    private String proposerName;

    /** 解决人id */
    @Excel(name = "解决人id")
    private Long solverId;

    @Excel(name = "解决人姓名")
    private String solverName;

    /** 来源 */
    @Excel(name = "来源")
    private Integer source;

    /** 优先级 */
    @Excel(name = "优先级")
    private Integer priority;

    /** 严重程度 */
    @Excel(name = "严重程度")
    private Integer severity;

    /** 自定义级别 */
    @Excel(name = "自定义级别")
    private Integer customized;

    /** 解决方案 */
    @Excel(name = "解决方案")
    private String solution;

    /** 原因 */
    @Excel(name = "原因")
    private String reason;

    /** 发现时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发现时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date discoverTime;

    /** 分配时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "分配时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date assignTime;

    /** 确认时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "确认时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date confirmTime;

    /** 实际解决时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际解决时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualTime;


    @Override
    public String toString() {
        return "Bug{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", projectId=" + projectId +
                ", projectName=" + projectName +
                ", moduleId=" + moduleId +
                ", moduleName=" + moduleName +
                ", version='" + version + '\'' +
                ", proposerId=" + proposerId +
                ", proposerName=" + proposerName +
                ", solverId=" + solverId +
                ", solverName=" + solverName +
                ", source=" + source +
                ", priority=" + priority +
                ", severity=" + severity +
                ", customized=" + customized +
                ", solution='" + solution + '\'' +
                ", reason='" + reason + '\'' +
                ", discoverTime=" + discoverTime +
                ", assignTime=" + assignTime +
                ", confirmTime=" + confirmTime +
                ", actualTime=" + actualTime +
                '}';
    }
}
