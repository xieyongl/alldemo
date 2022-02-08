package com.example.alldemo.es.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 作业详情表
 */
@Data
@TableName("training_activity_content_detail")
public class TrainingActivityContentDetail implements Serializable {

  @ApiModelProperty("Id")
  private String detailId;

  @ApiModelProperty("模板字段名")
  private String nodeName;

  @ApiModelProperty("模板字段类型")
  private String nodeType;

  @ApiModelProperty("模板字段内容")
  private String nodeContent;

  @ApiModelProperty("模板字段排序")
  private Integer orderNo;

  @ApiModelProperty("模板字段描述")
  private String nodeDesc;

  @ApiModelProperty("用户字段输入内容")
  private String content;

  @ApiModelProperty("作业id")
  private String contentId;

  @ApiModelProperty("模板id")
  private Long templateId;

}
