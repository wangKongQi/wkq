package com.medcine.base.entity.file;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wkq
 * @date 2020/11/2 17:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FileInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long fileId;  //文件id

    private String fileName;  //文件名称

    private String fileType;  //文件类型

    private Long fileSize;  //文件大小

    private String path;  //路径

    private Integer isDelete;  //是否启用

    private Integer sort;  //排序
}