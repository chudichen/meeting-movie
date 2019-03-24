package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Michael.Chu
 * @date 2019-03-24 12:16
 */
@Data
public class SourceVO implements Serializable {

    private String sourceId;
    private String sourceName;
    /** 被选中的选项 */
    private Boolean isActive;
}
