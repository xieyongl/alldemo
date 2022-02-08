package com.example.alldemo.es.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 内容作业表
 */
@Data
@TableName("training_activity_content")
public class TrainingActivityContent implements Serializable {

  @ApiModelProperty("Id")
  private String contentId;

  @ApiModelProperty("作业标题")
  private String title;

  @ApiModelProperty("如果有值就是发布内容id（该id复制品）")
  @TableField("`desc`")
  private String desc;

  @ApiModelProperty("训练营id")
  private String trainingId;

  @ApiModelProperty("模板id")
  private String templateId;

  @ApiModelProperty("模板名称")
  private String templateName;

  @ApiModelProperty("模板类型 1自定义 2基本 3进阶")
  private Integer templateType;

  @ApiModelProperty("用户id")
  private Integer userId;

  @ApiModelProperty("作业评级 0 未评级 1 TOP级 2 A级 3 B级 4 C级 5 D级 6 E级")
  private Integer level;

  @ApiModelProperty("是否点评")
  private Integer remark;

  @ApiModelProperty("作业状态 0发布 1隐藏 2草稿")
  @TableField("`status`")
  private Integer status;



  @TableField(exist = false)// 内容详情
  @ApiModelProperty("所填字段详情")
  private List<TrainingActivityContentDetail> contentDetails;

  /** 创建者 */
  public Long createdAt;
  /** 创建时间 */
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @TableField(fill = FieldFill.INSERT)
  public Date createTime;
  /** 更新者 */
  public Long updatedAt;
  /** 更新时间 */
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @TableField(fill = FieldFill.INSERT_UPDATE)
  public Date updatedTime;

}
