package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Michael.Chu
 * @date 2019-03-24 12:18
 */
@Data
public class YearVO implements Serializable {

    private String yearId;
    private String yearName;
    /** 被选中的选项 */
    private Boolean isActive;
}
