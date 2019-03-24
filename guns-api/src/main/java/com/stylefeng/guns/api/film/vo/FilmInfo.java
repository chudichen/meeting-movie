package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 影片信息
 * @author Michael.Chu
 * @date 2019-03-24 09:02
 */
@Data
public class FilmInfo implements Serializable {

    private String filmId;
    private Integer filmType;
    private String imgAddress;
    private String filmName;
    private String filmScore;
    private Integer expectNum;
    private String showTime;
    private Integer boxNum;
    private String score;
}
