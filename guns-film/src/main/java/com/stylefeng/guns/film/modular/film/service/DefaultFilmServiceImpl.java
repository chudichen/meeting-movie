package com.stylefeng.guns.film.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.film.api.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.*;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.film.common.persistence.dao.*;
import com.stylefeng.guns.film.common.persistence.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 默认的影片实现
 * @author Michael.Chu
 * @date 2019-03-24 10:32
 */
@Component
@Service(interfaceClass = FilmServiceApi.class)
public class DefaultFilmServiceImpl implements FilmServiceApi {

    private final BannerTMapper bannerMapper;

    private final FilmTMapper filmMapper;

    private final CatDictTMapper catMapper;

    private final YearDictTMapper yearMapper;

    private final SourceDictTMapper sourceDictMapper;

    @Autowired
    public DefaultFilmServiceImpl(BannerTMapper bannerMapper, FilmTMapper filmMapper, CatDictTMapper catMapper, YearDictTMapper yearMapper, SourceDictTMapper sourceDictMapper) {
        this.bannerMapper = bannerMapper;
        this.filmMapper = filmMapper;
        this.catMapper = catMapper;
        this.yearMapper = yearMapper;
        this.sourceDictMapper = sourceDictMapper;
    }

    /**
     * 获取Banners
     *
     * @return 获取到到Banner
     */
    @Override
    public List<BannerVO> getBanners() {

        List<BannerT> bannerVOList = bannerMapper.selectList(null);
        ArrayList<BannerVO> arrayList = new ArrayList<>();
        bannerVOList.forEach(bannerDo -> arrayList.add(do2bannerVo(bannerDo)));
        return arrayList;
    }

    @Override
    public FilmVO getHotFilms(Boolean isLimit, Integer nums) {
        FilmVO filmVO = new FilmVO();
        EntityWrapper<FilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "1");
        // 判断是否需要限制条数
        if (isLimit) {
            Page<FilmT> page = new Page<>(1, nums);
            List<FilmT> filmList = filmMapper.selectPage(page, entityWrapper);
            List<FilmInfo> filmInfoList = filmDOList2FilmInfoList(filmList);
            filmVO.setFilmInfoList(filmInfoList);
            filmVO.setFilmNum(filmInfoList.size());
        }
        return filmVO;
    }

    @Override
    public FilmVO getSoonFilms(Boolean isLimit, Integer nums) {
        FilmVO filmVO = new FilmVO();
        EntityWrapper<FilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "2");
        // 判断是否需要限制条数
        if (isLimit) {
            Page<FilmT> page = new Page<>(1, nums);
            List<FilmT> filmList = filmMapper.selectPage(page, entityWrapper);
            List<FilmInfo> filmInfoList = filmDOList2FilmInfoList(filmList);
            filmVO.setFilmInfoList(filmInfoList);
            filmVO.setFilmNum(filmInfoList.size());
        }
        return filmVO;
    }

    /**
     * 已经上映到电影，票房前10名
     *
     * @return {@link List<FilmInfo>}
     */
    @Override
    public List<FilmInfo> getBoxRanking() {
        EntityWrapper<FilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "1");

        Page<FilmT> page = new Page<>(1, 10);
        List<FilmT> filmList = filmMapper.selectPage(page, entityWrapper);
        List<FilmInfo> filmInfoList = filmDOList2FilmInfoList(filmList);

        return filmInfoList;
    }

    /**
     * 最受期待的电影，前10名（未上映），预售的前10名电影
     *
     * @return {@link List<FilmInfo>}
     */
    @Override
    public List<FilmInfo> getExpectRanking() {

        EntityWrapper<FilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "2");
        Page<FilmT> page = new Page<>(1, 10, "film_preSaleNum");
        List<FilmT> filmDOList = filmMapper.selectPage(page, entityWrapper);
        return filmDOList2FilmInfoList(filmDOList);
    }

    /**
     * 打分的排名前10名
     *
     * @return {@link List<FilmInfo>}
     */
    @Override
    public List<FilmInfo> getTop() {
        EntityWrapper<FilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "1");
        Page<FilmT> page = new Page<>(1, 10, "film_score");
        List<FilmT> filmDOList = filmMapper.selectPage(page, entityWrapper);
        return filmDOList2FilmInfoList(filmDOList);
    }

    /**
     * 获取分类信息
     *
     * @return 分类信息
     */
    @Override
    public List<CatVO> getCats() {
        List<CatDictT> catDOList = catMapper.selectList(null);
        return catDOList2CatVOList(catDOList);
    }

    @Override
    public List<SourceVO> getSources() {
        List<SourceDictT> sourceDictList = sourceDictMapper.selectList(null);
        return sourceDOList2SourceVOList(sourceDictList);
    }

    @Override
    public List<YearVO> getYears() {
        List<YearDictT> yearDOTList = yearMapper.selectList(null);
        return yearDOList2yearVOList(yearDOTList);
    }

    private List<CatVO> catDOList2CatVOList(List<CatDictT> catDOList) {
        List<CatVO> catVOList = new ArrayList<>();
        catDOList.forEach(catDO -> {
            CatVO catVO = new CatVO();
            catDO.setUuid(catDO.getUuid());
            catVO.setCatName(catDO.getShowNamne());
            catVOList.add(catVO);
        });
        return catVOList;
    }

    private List<YearVO> yearDOList2yearVOList(List<YearDictT> yearDOList) {
        List<YearVO> yearVOList = new ArrayList<>();
        yearDOList.forEach(yearDO -> {
            YearVO yearVO = new YearVO();
            yearVO.setYearId(yearVO.getYearId());
            yearVO.setYearName(yearVO.getYearName());
            yearVOList.add(yearVO);
        });
        return yearVOList;
    }

    private List<SourceVO> sourceDOList2SourceVOList(List<SourceDictT> sourceDictList) {
        List<SourceVO> sourceVOList = new ArrayList<>();
        sourceDictList.forEach(sourceDO -> {
            SourceVO sourceVO = new SourceVO();
            sourceVO.setSourceId(Objects.toString(sourceDO.getUuid()));
            sourceVO.setSourceName(sourceDO.getShowName());
        });
        return sourceVOList;
    }

    /**
     * 将BannerDO转换成BannerVO
     *
     * @param bannerDO {@link BannerT}
     * @return {@link BannerVO}
     */
    private BannerVO do2bannerVo(BannerT bannerDO) {
        BannerVO bannerVO = new BannerVO();
        bannerVO.setBannerUrl(bannerDO.getBannerUrl());
        bannerVO.setBannerId(Objects.toString(bannerDO.getUuid()));
        bannerVO.setBannerAddress(bannerDO.getBannerAddress());
        return bannerVO;
    }

    /**
     * 将filmDO集合转换成FilmInfo集合
     *
     * @param filmDOList {@link List<FilmT> filmDOList}
     * @return {@link List<FilmInfo>}
     */
    private List<FilmInfo> filmDOList2FilmInfoList(List<FilmT> filmDOList) {
        List<FilmInfo> filmInfoList = new ArrayList<>();
        filmDOList.forEach(filmDO -> {
            FilmInfo filmInfo = new FilmInfo();
            filmInfo.setShowTime(DateUtil.getDay(filmDO.getFilmTime()));
            filmInfo.setScore(filmDO.getFilmScore());
            filmInfo.setImgAddress(filmDO.getImgAddress());
            filmInfo.setFilmType(filmDO.getFilmType());
            filmInfo.setFilmScore(filmDO.getFilmScore());
            filmInfo.setFilmName(filmDO.getFilmName());
            filmInfo.setFilmId(Objects.toString(filmDO.getUuid()));
            filmInfo.setExpectNum(filmDO.getFilmPreSaleNum());
            filmInfo.setBoxNum(filmDO.getFilmBoxOffice());
            filmInfoList.add(filmInfo);
        });
        return filmInfoList;
    }
}
