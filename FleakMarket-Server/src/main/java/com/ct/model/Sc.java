package com.ct.model;

import lombok.Data;

@Data
public class Sc {
    //二级分类id
    private Integer id;
    //二级分类名称
    private String name;
    //二级分类地址
    private String path;
    //所属一级分类id
    private Integer fcid;
}
