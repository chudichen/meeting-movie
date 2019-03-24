package com.stylefeng.guns.api.film.vo;

import lombok.Data;

import java.util.List;

/**
 * 影片首页VO
 *
 * @author Michael.Chu
 * @date 2019-03-24 08:51
 */
@Data
public class FilmIndexVO {

    private List<BannerVO> banners;
    private FilmVO hotFilms;
    private FilmVO soonFilms;
    private List<FilmInfo> boxRanking;
    private List<FilmInfo> expectRanking;
    private List<FilmInfo> top100;
}
