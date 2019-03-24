package com.stylefeng.guns.film.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 源信息表
 * </p>
 *
 * @author Michael.Chu
 * @since 2019-03-24
 */
@TableName("source_dict_t")
public class SourceDictT extends Model<SourceDictT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId("UUID")
	private Integer uuid;
    /**
     * 显示名称
     */
	@TableField("show_name")
	private String showName;


	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	@Override
	protected Serializable pkVal() {
		return this.uuid;
	}

	@Override
	public String toString() {
		return "SourceDictT{" +
			"uuid=" + uuid +
			", showName=" + showName +
			"}";
	}
}
