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
public class SysRolePermission extends BaseEntity {


			private Integer id;  // 

			private Integer roleId;  // 

			private Integer permissionId;  // 

	public SysRolePermission(){
	}

	public SysRolePermission(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}


	public void setRoleId(Integer value) {
		this.roleId = value;
	}

	public Integer getRoleId() {
		return this.roleId;
	}


	public void setPermissionId(Integer value) {
		this.permissionId = value;
	}

	public Integer getPermissionId() {
		return this.permissionId;
	}






	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("RoleId",getRoleId())
			.append("PermissionId",getPermissionId())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysRolePermission == false) return false;
		if(this == obj) return true;
		SysRolePermission other = (SysRolePermission)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

