package com.example.alldemo.es.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.alldemo.es.pojo.TrainingActivityContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/1/10 15:01
 **/
@Repository
@Mapper
public interface TrainingActivityContentMapper extends BaseMapper<TrainingActivityContent> {

    /**
     * 获取作业
     */
    List<TrainingActivityContent> getContent();

}
