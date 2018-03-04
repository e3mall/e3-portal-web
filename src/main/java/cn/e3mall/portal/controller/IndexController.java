package cn.e3mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;

@Controller
public class IndexController {
	@Value("${CONTENT_LUNBO_ID}")
	private Long CONTENT_LUNBO_ID;
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index")
	public String showIndex(Model model){
		//显示首页前加载分类内容  有多少个分类就查询多少次
		List<TbContent> contentList = contentService.getContentListByCid(CONTENT_LUNBO_ID);
		//把结果传递给页面
		model.addAttribute("ad1List", contentList);
		return "index";
	}
}
