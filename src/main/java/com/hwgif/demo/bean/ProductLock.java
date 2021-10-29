package com.hwgif.demo.bean;

import com.hwgif.common.db.bean.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.util.Date;


/**
 * 产品信息表
 * @author lc.huang
 * @date 2021-10-29 9:27:31
 */
public class ProductLock extends BaseEntity {

	private Integer id;  // 主键
	//this is not null column
	private String productNo;  // 产品编号
	//this is not null column
	private Integer stock;  // 库存量
	//this is not null column
	private Integer version;  // 版本号
	//this is not null column
	private Date createTime;  // 
	//this is not null column
	private Date updateTime;  // 更新时间

	public ProductLock(){
	}

	public ProductLock(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}


	public void setProductNo(String value) {
		this.productNo = value;
	}

	public String getProductNo() {
		return this.productNo;
	}


	public void setStock(Integer value) {
		this.stock = value;
	}

	public Integer getStock() {
		return this.stock;
	}


	public void setVersion(Integer value) {
		this.version = value;
	}

	public Integer getVersion() {
		return this.version;
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






	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ProductNo",getProductNo())
			.append("Stock",getStock())
			.append("Version",getVersion())
			.append("CreateTime",getCreateTime())
			.append("UpdateTime",getUpdateTime())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof ProductLock == false) return false;
		if(this == obj) return true;
		ProductLock other = (ProductLock)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

