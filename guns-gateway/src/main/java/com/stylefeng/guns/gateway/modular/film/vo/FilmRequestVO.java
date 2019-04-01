package com.stylefeng.guns.gateway.modular.film.vo;

import lombok.Data;

/**
 * @author Michael.Chu
 * @date 2019-03-28 22:42
 */
@Data
public class FilmRequestVO {

    private Integer showType = 1;
    private Integer sortId = 1;
    private Integer sourceId = 99;
    private Integer catId = 99;
    private Integer yearId = 99;
    private Integer nowPage = 1;
    private Integer pageSize = 18;
}
