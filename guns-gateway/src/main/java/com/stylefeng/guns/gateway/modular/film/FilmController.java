package com.stylefeng.guns.gateway.modular.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.api.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.CatVO;
import com.stylefeng.guns.api.film.vo.FilmIndexVO;
import com.stylefeng.guns.api.film.vo.SourceVO;
import com.stylefeng.guns.api.film.vo.YearVO;
import com.stylefeng.guns.gateway.modular.auth.vo.ResponseVO;
import com.stylefeng.guns.gateway.modular.film.vo.FilmConditionVO;
import com.stylefeng.guns.gateway.modular.film.vo.FilmRequestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author Michael.Chu
 * @date 2019-03-23 19:26
 */
@RestController
@RequestMapping("/film/")
public class FilmController {

    private static final String IMG_PRE = "http://img.meetingshop.cn/";

    @Reference(interfaceClass = FilmServiceApi.class)
    private FilmServiceApi filmServiceApi;

    /**
     * 获取首页信息的接口
     * API网关：
     * 1. 接口聚合
     * 2.
     * @return 首页
     */
    @GetMapping(value = "getIndex")
    public ResponseVO getIndex() {
        FilmIndexVO filmIndexVO = new FilmIndexVO();
        // 获取Banner信息
        filmIndexVO.setBanners(filmServiceApi.getBanners());
        // 获取正在热映的电影
        filmIndexVO.setHotFilms(filmServiceApi.getHotFilms(true, 8));
        // 即将上映的电影
        filmIndexVO.setSoonFilms(filmServiceApi.getSoonFilms(true, 8));
        // 票房排行榜
        filmIndexVO.setBoxRanking(filmServiceApi.getBoxRanking());
        // 获受欢迎的榜单
        filmIndexVO.setExpectRanking(filmServiceApi.getExpectRanking());
        // 获取前评分前100的影片
        filmIndexVO.setTop100(filmServiceApi.getTop());

        return ResponseVO.success(filmIndexVO, IMG_PRE);
    }

    /**
     * 获取影片状态信息，如果传递的有选择参数，则将所选择的信息的状态设置为active，
     * 如果没有选择，则按照默认选择全部。
     *
     * @param catId 分类Id
     * @param sourceId 影片Id
     * @param yearId 年代Id
     * @return 影片状态
     */
    @GetMapping(value = "getConditionList")
    public ResponseVO getConditionList(@RequestParam(name = "catId", required = false, defaultValue = "99") String catId,
                                       @RequestParam(name = "sourceId", required = false, defaultValue = "99") String sourceId,
                                       @RequestParam(name = "yearId", required = false, defaultValue = "99") String yearId) {
        FilmConditionVO filmConditionVO = new FilmConditionVO();

        List<CatVO> cats = filmServiceApi.getCats();

        boolean flag = false;
        // 判断结果集中是否存在catId，如果存在则将对应实体的active状态设置为true
        for (CatVO catVO : cats) {
            if (Objects.equals(catVO.getCatId(), catId)) {
                catVO.setIsActive(true);
                flag = true;
            }
        }
        if (flag) {
            CatVO catVO = new CatVO();
            catVO.setCatId("99");
            catVO.setCatName("其他");
            catVO.setIsActive(true);
            cats.add(catVO);
        }
        filmConditionVO.setCatInfo(cats);

        flag = false;
        List<SourceVO> sources = filmServiceApi.getSources();
        for (SourceVO sourceVO : sources) {
            if (Objects.equals(sourceVO.getSourceId(), sourceId)) {
                sourceVO.setIsActive(true);
                flag = true;
            }
        }
        if (flag) {
            SourceVO sourceVO = new SourceVO();
            sourceVO.setSourceId("99");
            sourceVO.setSourceName("其他");
            sourceVO.setIsActive(true);
            sources.add(sourceVO);
        }
        filmConditionVO.setSourceInfo(sources);

        flag = false;
        List<YearVO> years = filmServiceApi.getYears();
        for (YearVO yearVO : years) {
            if (Objects.equals(yearVO.getYearId(), yearId)) {
                yearVO.setIsActive(true);
                flag = true;
            }
        }
        if (flag) {
            YearVO yearVO = new YearVO();
            yearVO.setYearId("99");
            yearVO.setYearName("其他");
            yearVO.setIsActive(true);
            years.add(yearVO);
        }
        filmConditionVO.setYearInfo(years);

        return ResponseVO.success(filmConditionVO);
    }

    @GetMapping(value = "getFilms")
    public ResponseVO getFilms(FilmRequestVO filmRequestVO) {
        return null;
    }
}
