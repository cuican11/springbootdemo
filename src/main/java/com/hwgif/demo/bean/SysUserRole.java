package com.hwgif.demo.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hwgif.common.db.bean.BaseEntity;

import java.util.Date;


/**
 * 
 * @author lc.huang
 * @date 2019-12-6 17:49:43
 */
public class SysUserRole extends BaseEntity {


			private Integer id;  // 

			private Integer sysUserId;  // 

			private Integer sysRoleId;  // 

	public SysUserRole(){
	}

	public SysUserRole(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}


	public void setSysUserId(Integer value) {
		this.sysUserId = value;
	}

	public Integer getSysUserId() {
		return this.sysUserId;
	}


	public void setSysRoleId(Integer value) {
		this.sysRoleId = value;
	}

	public Integer getSysRoleId() {
		return this.sysRoleId;
	}






	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("SysUserId",getSysUserId())
			.append("SysRoleId",getSysRoleId())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysUserRole == false) return false;
		if(this == obj) return true;
		SysUserRole other = (SysUserRole)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

