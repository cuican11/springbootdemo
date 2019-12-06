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
public class SysRole extends BaseEntity {


			private Integer id;  // 

			private String name;  // 

	public SysRole(){
	}

	public SysRole(Integer id){
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






	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysRole == false) return false;
		if(this == obj) return true;
		SysRole other = (SysRole)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

