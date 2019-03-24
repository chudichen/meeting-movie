package com.stylefeng.guns.film.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 影片介绍
 * </p>
 *
 * @author Michael.Chu
 * @since 2019-03-24
 */
@TableName("film_info_t")
public class FilmInfoT extends Model<FilmInfoT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId("film_id")
	private String filmId;
    /**
     * 影片名称
     */
	@TableField("film_en_name")
	private String filmEnName;
    /**
     * 影片评分
     */
	@TableField("film_score")
	private String filmScore;
    /**
     * 影片评分数量
     */
	@TableField("film_score_num")
	private Integer filmScoreNum;
    /**
     * 影片长度
     */
	@TableField("film_length")
	private Integer filmLength;
    /**
     * 影片介绍
     */
	private String biography;
    /**
     * 导演
     */
	@TableField("director_id")
	private Integer directorId;
    /**
     * 影片图片
     */
	@TableField("film_imgs")
	private String filmImgs;


	public String getFilmId() {
		return filmId;
	}

	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public String getFilmEnName() {
		return filmEnName;
	}

	public void setFilmEnName(String filmEnName) {
		this.filmEnName = filmEnName;
	}

	public String getFilmScore() {
		return filmScore;
	}

	public void setFilmScore(String filmScore) {
		this.filmScore = filmScore;
	}

	public Integer getFilmScoreNum() {
		return filmScoreNum;
	}

	public void setFilmScoreNum(Integer filmScoreNum) {
		this.filmScoreNum = filmScoreNum;
	}

	public Integer getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(Integer filmLength) {
		this.filmLength = filmLength;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Integer getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}

	public String getFilmImgs() {
		return filmImgs;
	}

	public void setFilmImgs(String filmImgs) {
		this.filmImgs = filmImgs;
	}

	@Override
	protected Serializable pkVal() {
		return this.filmId;
	}

	@Override
	public String toString() {
		return "FilmInfoT{" +
			"filmId=" + filmId +
			", filmEnName=" + filmEnName +
			", filmScore=" + filmScore +
			", filmScoreNum=" + filmScoreNum +
			", filmLength=" + filmLength +
			", biography=" + biography +
			", directorId=" + directorId +
			", filmImgs=" + filmImgs +
			"}";
	}
}
