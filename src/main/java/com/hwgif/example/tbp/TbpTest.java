package com.hwgif.example.tbp;

import com.hwgif.common.util.SpringUtils;
import com.hwgif.example.tbp.impl.ExampleOne;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * demo 收集☞   税银  根据配置项动态查询对应资源
 *
 *
 */
@Component
public class TbpTest {

//
//    TaxDataTest taxDataTest = SpringUtils.getBean(TaxDataTest.class);
//    Map<String, List<Map<String, Object>>> data = new LinkedHashMap<>();
//    //当前银行配置的所有节点
//    List<Map<String, String>> taxBankNodes = tbpMapper.selectBankTaxNodeByBank(taxData.getBankCode());
//    //银行节点字段分组信息
//    Map<String, LinkedHashSet<String>> taxNodesFileds = TaxDataUtil.groupTaxBankNode(taxBankNodes);
//
//        try {
//        Set<BankConfiger.Node> set = nodeFilter(taxData, taxNodesFileds.keySet());
//        if(taxDataTest == null){
//            //生产
//            final Map<String, Object> nsrxx = gsMapper.getNsrxx(taxData.getNsrsbh());
//            if (nsrxx == null) {
//                return Result.fail("N0205", "纳税人信息错误");
//            }
//            for (BankConfiger.Node node : set) {
//                Tax tax = (Tax) SpringUtils.getBean(node.getClazz());
//                if(tax !=null){
//                    data.put(node.getTaxNode(), tax.tax(taxData, nsrxx));
//                }else{
//                    log.error("没有对应节点配置 {}",node);
//                }
//            }
//        }else{
//            //测试
//            data = taxDataTest.getData(set);
//        }
    /**
     *  for (BankConfiger.Node node : set) {
     *      Tax tax = (Tax) SpringUtils.getBean(node.getClazz());
     *      if(tax !=null){
     *          data.put(node.getTaxNode(), tax.tax(taxData, nsrxx));
     *      }else{
     *          log.error("没有对应节点配置 {}",node);
     *      }
     *  }
     *  通过 SpringUtils.getBean() 根据set里的配置动态实例化
     *
     */

      InterClass a = (InterClass) SpringUtils.getBean(ExampleOne.class);

}
