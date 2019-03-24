package com.stylefeng.guns.film.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 年份信息
 * </p>
 *
 * @author Michael.Chu
 * @since 2019-03-24
 */
@TableName("year_dict_t")
public class YearDictT extends Model<YearDictT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
	@TableId(value="UUID", type= IdType.AUTO)
	private Integer uuid;
    /**
     * 影片名称
     */
	@TableField("show_namne")
	private String showNamne;


	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public String getShowNamne() {
		return showNamne;
	}

	public void setShowNamne(String showNamne) {
		this.showNamne = showNamne;
	}

	@Override
	protected Serializable pkVal() {
		return this.uuid;
	}

	@Override
	public String toString() {
		return "YearDictT{" +
			"uuid=" + uuid +
			", showNamne=" + showNamne +
			"}";
	}
}
