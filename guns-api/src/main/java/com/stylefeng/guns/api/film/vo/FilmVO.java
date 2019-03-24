package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Michael.Chu
 * @date 2019-03-24 09:02
 */
@Data
public class FilmVO implements Serializable {

    private Integer filmNum;
    private List<FilmInfo> filmInfoList;
}
