package com.hwgif.demotwo.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hwgif.common.db.bean.BaseEntity;

import java.util.Date;


/**
 * 用户
 * @author lc.huang
 * @date 2019-11-20 14:37:23
 */
public class UserNd extends BaseEntity {


			private Integer id;  // id

			private String name;  // 真实姓名

              //this is not null column
			private String nick;  // 昵称

			private String password;  // 密码

			private String salt;  // 加密盐

			private String phone;  // 账号,手机号

              //this is not null column
			private String email;  // 邮箱

			private String status;  // 商家状态:冻结,激活

			private Date createTime;  // 创建时间

			private Date updateTime;  // 更新时间

			private Integer isDel = 0; // 是否删除：1是0否

	public UserNd(){
	}

	public UserNd(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}


	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}


	public void setNick(String value) {
		this.nick = value;
	}

	public String getNick() {
		return this.nick;
	}


	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return this.password;
	}


	public void setSalt(String value) {
		this.salt = value;
	}

	public String getSalt() {
		return this.salt;
	}


	public void setPhone(String value) {
		this.phone = value;
	}

	public String getPhone() {
		return this.phone;
	}


	public void setEmail(String value) {
		this.email = value;
	}

	public String getEmail() {
		return this.email;
	}


	public void setStatus(String value) {
		this.status = value;
	}

	public String getStatus() {
		return this.status;
	}



	public void setCreateTime(Date value) {
		this.createTime = value;
	}

	public Date getCreateTime() {
		return this.createTime;
	}



	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}


	public void setIsDel(Integer value) {
		this.isDel = value;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public Boolean getDeleted() {
		return isDel != null && isDel > 0;
	}

	public void setDeleted(Boolean del) {
		this.isDel = del != null && del ? 1 : 0;
	}





	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("Nick",getNick())
			.append("Password",getPassword())
			.append("Salt",getSalt())
			.append("Phone",getPhone())
			.append("Email",getEmail())
			.append("Status",getStatus())
			.append("CreateTime",getCreateTime())
			.append("UpdateTime",getUpdateTime())
			.append("IsDel",getIsDel())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof UserNd == false) return false;
		if(this == obj) return true;
		UserNd other = (UserNd)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

