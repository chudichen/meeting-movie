package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Michael.Chu
 * @date 2019-03-24 08:52
 */
@Data
public class BannerVO implements Serializable {

    private String bannerId;
    private String bannerAddress;
    /** 被选中的选项 */
    private String bannerUrl;
}
