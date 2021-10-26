package com.hwgif.example.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Description:
 * date: 2020/3/19 11:22
 *
 * @author zuoqiwen
 */
@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "syptRequest")
public class TaxData {
    /**
     * 申请序号
     */
    @NotBlank(message="申请序号不能为空")
    private String sqxh;
    /**
     * 纳税人识别号
     */
    @NotBlank(message="纳税人识别号不能为空")
    private String nsrsbh;
    /**
     * 年度
     */
    @NotBlank(message="年度不能为空")
    private String nd;
    /**
     * 欠税年度
     */
    @NotBlank(message="欠税年度不能为空")
    private String qsnd;
    /**
     * 银行代码
     */
    @NotBlank(message="银行代码不能为空")
    private String bankCode;
    /**
     * 授权编码
     */
    @NotBlank(message="授权编码不能为空")
    private String grantCode;
    /**
     * 银行名称
     */
    @NotBlank(message="银行名称为空")
    private String tbpName;
    /**
     * 产品代码
     */
    @NotBlank(message="产品代码不能为空")
    private String businessType;
    /**
     * 银行账号
     */
    @NotBlank(message="银行账号不能为空")
    private String bankaccount;
    /**
     * 银行密码
     */
    @NotBlank(message="银行密码不能为空")
    private String bankpassword;
    /**
     * 交换类型
     */
    @NotBlank(message="交换类型不能为空")
    private String exchangetype;
    /**
     * 纳税人类型
     */
    private String nsrlx;
    /**
     * 纳税人身份证号
     */
    private String nsr_sfzh;

}
