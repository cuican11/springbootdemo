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
public class SysPermission extends BaseEntity {


			private Integer id;  // 

			private String name;  // 

			private String description;  // 

			private String url;  // 

			private Integer pid;  // 

	public SysPermission(){
	}

	public SysPermission(Integer id){
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


	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
	}


	public void setUrl(String value) {
		this.url = value;
	}

	public String getUrl() {
		return this.url;
	}


	public void setPid(Integer value) {
		this.pid = value;
	}

	public Integer getPid() {
		return this.pid;
	}






	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("Description",getDescription())
			.append("Url",getUrl())
			.append("Pid",getPid())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof SysPermission == false) return false;
		if(this == obj) return true;
		SysPermission other = (SysPermission)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

