package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * category分类信息
 * @author Michael.Chu
 * @date 2019-03-24 12:15
 */
@Data
public class CatVO implements Serializable {

    private String catId;
    private String catName;
    /** 被选中的选项 */
    private Boolean isActive;
}
