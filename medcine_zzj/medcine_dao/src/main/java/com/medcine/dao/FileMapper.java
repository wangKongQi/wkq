package com.medcine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medcine.base.entity.file.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wkq
 * @date 2020/11/2 17:20
 */
@Mapper
public interface FileMapper extends BaseMapper<FileInfo> {

    Long insertPK(FileInfo file);

    FileInfo getByName(@Param("fileName") String fileName);

    FileInfo getById(@Param("fileId") Long fileId);

}
