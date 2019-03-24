package com.stylefeng.guns.api.film.api;

import com.stylefeng.guns.api.film.vo.*;

import java.util.List;

/**
 * @author Michael.Chu
 * @date 2019-03-24 09:19
 */
public interface FilmServiceApi {

    /**
     * 获取Banners
     *
     * @return banners
     */
    List<BannerVO> getBanners();

    /**
     * 获取热门影片，如果配置来限制，则获取nums张
     *
     * @param isLimit 是否需要限制
     * @param nums    获取多少张
     * @return 热门影片信息
     */
    FilmVO getHotFilms(Boolean isLimit, Integer nums);

    /**
     * 获取即将上映影片信息，如果配置来限制，则获取nums张
     *
     * @param isLimit 是否需要限制
     * @param nums    获取多少张
     * @return 热门影片信息
     */
    FilmVO getSoonFilms(Boolean isLimit, Integer nums);

    /**
     * 获取票房排行榜
     *
     * @return 影片信息
     */
    List<FilmInfo> getBoxRanking();

    /**
     * 获取人气排行榜
     *
     * @return 影片信息
     */
    List<FilmInfo> getExpectRanking();

    /**
     * 获取前100条
     *
     * @return 前100条影片信息
     */
    List<FilmInfo> getTop();

    /**
     * 获取分类条件
     *
     * @return 分类信息
     */
    List<CatVO> getCats();

    /**
     * 获取片源信息
     *
     * @return 片源信息
     */
    List<SourceVO> getSources();

    /**
     * 获取年份信息
     *
     * @return 年份信息
     */
    List<YearVO> getYears();
}
