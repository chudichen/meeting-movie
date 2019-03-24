package com.stylefeng.guns.film.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 演员表
 * </p>
 *
 * @author Michael.Chu
 * @since 2019-03-24
 */
@TableName("actor_t")
public class ActorT extends Model<ActorT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId("UUID")
	private Integer uuid;
    /**
     * 演员
     */
	@TableField("actor_name")
	private String actorName;
    /**
     * 演员照片
     */
	@TableField("actor_img")
	private String actorImg;


	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorImg() {
		return actorImg;
	}

	public void setActorImg(String actorImg) {
		this.actorImg = actorImg;
	}

	@Override
	protected Serializable pkVal() {
		return this.uuid;
	}

	@Override
	public String toString() {
		return "ActorT{" +
			"uuid=" + uuid +
			", actorName=" + actorName +
			", actorImg=" + actorImg +
			"}";
	}
}
