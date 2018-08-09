package com.ryl.ssm.controller;

import com.ryl.ssm.po.Items;
import com.ryl.ssm.po.QueryVo;
import com.ryl.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping("/itemList")
    public ModelAndView itemList(Items items){
        List<Items> list = itemService.getItemList(items);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList",list);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }
    @RequestMapping("/editItem")
    //传参与形参不一致时使用@RequestParam 这里传参是id,形参是myid
    //public String editItem(@RequestParam(value="id",defaultValue="2",required=true) String myid,Model model)
    public String editItem(int id, Model model) {
        Items items = itemService.getItemById(id);
        model.addAttribute("items",items);
        return "editItem";
    }
    @RequestMapping("/updateItem")
    public String updateItem(Items items){
        itemService.updateItem(items);
        return "success";
    }
}
