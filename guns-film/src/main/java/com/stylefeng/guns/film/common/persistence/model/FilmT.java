package com.stylefeng.guns.film.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 年份信息
 * </p>
 *
 * @author Michael.Chu
 * @since 2019-03-24
 */
@TableName("film_t")
public class FilmT extends Model<FilmT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
	@TableId(value="UUID", type= IdType.AUTO)
	private Integer uuid;
    /**
     * 影片名称
     */
	@TableField("film_name")
	private String filmName;
    /**
     * 影片名称
     */
	@TableField("film_type")
	private Integer filmType;
    /**
     * 图片地址
     */
	@TableField("img_address")
	private String imgAddress;
    /**
     * 影片评分
     */
	@TableField("film_score")
	private String filmScore;
    /**
     * 预售数量
     */
	@TableField("film_preSaleNum")
	private Integer filmPreSaleNum;
    /**
     * 票房
     */
	@TableField("film_box_office")
	private Integer filmBoxOffice;
    /**
     * 影片介绍
     */
	@TableField("film_cats")
	private String filmCats;
    /**
     * 地方
     */
	@TableField("film_area")
	private Integer filmArea;
    /**
     * 电影日期
     */
	@TableField("film_date")
	private Integer filmDate;
    /**
     * 电影时长
     */
	@TableField("film_time")
	private Date filmTime;
    /**
     * 电影状态,1为热映中，2为即将上映
     */
	@TableField("film_status")
	private Integer filmStatus;


	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public Integer getFilmType() {
		return filmType;
	}

	public void setFilmType(Integer filmType) {
		this.filmType = filmType;
	}

	public String getImgAddress() {
		return imgAddress;
	}

	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}

	public String getFilmScore() {
		return filmScore;
	}

	public void setFilmScore(String filmScore) {
		this.filmScore = filmScore;
	}

	public Integer getFilmPreSaleNum() {
		return filmPreSaleNum;
	}

	public void setFilmPreSaleNum(Integer filmPreSaleNum) {
		this.filmPreSaleNum = filmPreSaleNum;
	}

	public Integer getFilmBoxOffice() {
		return filmBoxOffice;
	}

	public void setFilmBoxOffice(Integer filmBoxOffice) {
		this.filmBoxOffice = filmBoxOffice;
	}

	public String getFilmCats() {
		return filmCats;
	}

	public void setFilmCats(String filmCats) {
		this.filmCats = filmCats;
	}

	public Integer getFilmArea() {
		return filmArea;
	}

	public void setFilmArea(Integer filmArea) {
		this.filmArea = filmArea;
	}

	public Integer getFilmDate() {
		return filmDate;
	}

	public void setFilmDate(Integer filmDate) {
		this.filmDate = filmDate;
	}

	public Date getFilmTime() {
		return filmTime;
	}

	public void setFilmTime(Date filmTime) {
		this.filmTime = filmTime;
	}

	public Integer getFilmStatus() {
		return filmStatus;
	}

	public void setFilmStatus(Integer filmStatus) {
		this.filmStatus = filmStatus;
	}

	@Override
	protected Serializable pkVal() {
		return this.uuid;
	}

	@Override
	public String toString() {
		return "FilmT{" +
			"uuid=" + uuid +
			", filmName=" + filmName +
			", filmType=" + filmType +
			", imgAddress=" + imgAddress +
			", filmScore=" + filmScore +
			", filmPreSaleNum=" + filmPreSaleNum +
			", filmBoxOffice=" + filmBoxOffice +
			", filmCats=" + filmCats +
			", filmArea=" + filmArea +
			", filmDate=" + filmDate +
			", filmTime=" + filmTime +
			", filmStatus=" + filmStatus +
			"}";
	}
}
