package com.qf.dao;

import com.qf.pojo.TbMusic;
import com.qf.pojo.TbMusicExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TbMusicMapper {
    long countByExample(TbMusicExample example);

    int deleteByExample(TbMusicExample example);

    int deleteByPrimaryKey(String musicId);

    int insert(TbMusic record);

    int insertSelective(TbMusic record);

    List<TbMusic> selectByExample(TbMusicExample example);

    TbMusic selectByPrimaryKey(String musicId);

    int updateByExampleSelective(@Param("record") TbMusic record, @Param("example") TbMusicExample example);

    int updateByExample(@Param("record") TbMusic record, @Param("example") TbMusicExample example);

    int updateByPrimaryKeySelective(TbMusic record);

    int updateByPrimaryKey(TbMusic record);
}