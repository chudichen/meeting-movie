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
 * 用户表
 * </p>
 *
 * @author Michael.Chu
 * @since 2019-03-19
 */
@TableName("user_t")
public class UserT extends Model<UserT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
	@TableId(value="UUID", type= IdType.AUTO)
	private Integer uuid;
    /**
     * 用户账号
     */
	@TableField("user_name")
	private String userName;
    /**
     * 用户密码
     */
	@TableField("user_pwd")
	private String userPwd;
    /**
     * 用户昵称
     */
	@TableField("nick_name")
	private String nickName;
    /**
     * 用户性别 0-男, 1-女
     */
	@TableField("user_sex")
	private Integer userSex;
    /**
     * 出生日期
     */
	private String birthday;
    /**
     * 用户邮箱
     */
	private String email;
    /**
     * 用户手机号
     */
	@TableField("user_phone")
	private String userPhone;
    /**
     * 用户住址
     */
	private String address;
    /**
     * 用户头像
     */
	@TableField("head_url")
	private String headUrl;
    /**
     * 创建时间
     */
	@TableField("begin_time")
	private Date beginTime;
    /**
     * 修改时间
     */
	@TableField("update_time")
	private Date updateTime;
	@TableField("life_state")
	private Integer lifeState;
	private String biography;


	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getLifeState() {
		return lifeState;
	}

	public void setLifeState(Integer lifeState) {
		this.lifeState = lifeState;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	@Override
	protected Serializable pkVal() {
		return this.uuid;
	}

	@Override
	public String toString() {
		return "UserT{" +
			"uuid=" + uuid +
			", userName=" + userName +
			", userPwd=" + userPwd +
			", nickName=" + nickName +
			", userSex=" + userSex +
			", birthday=" + birthday +
			", email=" + email +
			", userPhone=" + userPhone +
			", address=" + address +
			", headUrl=" + headUrl +
			", beginTime=" + beginTime +
			", updateTime=" + updateTime +
			", lifeState=" + lifeState +
			", biography=" + biography +
			"}";
	}
}
