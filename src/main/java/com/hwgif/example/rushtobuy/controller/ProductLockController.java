package com.hwgif.example.rushtobuy.controller;


import javax.servlet.http.HttpServletResponse;

import com.hwgif.common.CommonResult;
import com.hwgif.demo.service.ProductLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 产品信息表
 * @author lc.huang
 * @date 2021-10-29 9:27:31
 */
@Controller
@RequestMapping(value = "/public/productLock")
public class ProductLockController {

    @Autowired
    private ProductLockService productLockService;

    /**
     * 公共信息
     * @param model
     */
    private void addSharedAttr(Model model) {
    	
    }

    /**
     * 分页查询
     * @param vo
     * @param model
     * @return
     */
//    @RequestMapping("")
//    public String list(ProductLockConditionVo vo, Model model) {
//
//		List<ProductLockVo> list = productLockService.findProductLockPage(vo);
//		System.out.println(vo);
//
//		model.addAttribute("productLockList", list);
//		addSharedAttr(model);
//		model.addAttribute("vo", vo);// 回传信息
//		model.addAttribute("pageId", "ProductLock");// 区分页面
//
//		return "/admin/product/productLock/list.html";
//    }
//
//    @RequestMapping("/view")
//    public String view(int id, Model model) {
//
//    	ProductLockVo vo = productLockService.findById(id);
//    	addSharedAttr(model);
//    	model.addAttribute("vo", vo);
//
//    	return "/admin/product/productLock/view.html";
//    }

    /**
     * 
     * @param handler   show 展示页面  其他  新增
     * @param model
     * @param vo
     * @param response
     * @return
     */
/*    @RequestMapping(value = "/insert")
    public String insert(String handler, Model model, ProductLockVo vo, HttpServletResponse response) {

//		if (handler!=null&&handler.equals("show")) {
//		    addSharedAttr(model);
//		    return "/admin/product/productLock/add.html";
//		}
//		vo.setCreatorId(getLoginId());
//		productLockService.insert(vo);
//		writeDwzSignal("200", getMessage("msg.operation.success"), "productProductLockLiNav",
//			"closeCurrent", null, response);
		return null;
    }*/

    /**
     * 
     * @param handler show 显示编辑页面  其他  更新
     * @param model
     * @param vo
     * @param response
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/update")
    public CommonResult update(@RequestParam(value = "id",required = true) Integer id , @RequestParam(value = "stock" ,required = true) Integer stock) {

    	productLockService.updateStock(id,stock);

		return CommonResult.successResult("success");
    }

    /**
     * 假删除
     * @param ids  1,2,3
     * @param response
     */
    @RequestMapping("/delete")
    public void delete(String ids, HttpServletResponse response) {

//		if (ids!=null&&ids.length()>0) {
//			ProductLockVo model = new ProductLockVo();
//			model.setIsDel(1);
//			for (String id : ids.split(",")) {
//				// productLockService.delete(Integer.valueOf(id));
//				model.setId(Integer.valueOf(id));
//				model.setUpdateId(getLoginId());
//				productLockService.updateSelective(model);
//			}
//		}
//
//		writeDwzSignal("200", getMessage("msg.operation.success"), "productProductLockLiNav", null, null,
//			response);
	}
    
}
