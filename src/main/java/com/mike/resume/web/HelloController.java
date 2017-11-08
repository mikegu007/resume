package com.mike.resume.web;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.mike.common.BootGrid;
import com.mike.resume.entity.Lottery;
import com.mike.resume.service.impl.LotteryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private LotteryServiceImpl lotteryService;
//    @Autowired
//    private SUserTokenMapper sUserTokenMapper;
//    @Autowired
//    private LotteryMapper lotteryMapper;

    @RequestMapping("/hello")
	public String hello(Locale locale, Model model) {
		return "hello world";
	}
    
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    @RequestMapping("/selectLotteryAll")
    public String selectLotteryAll() {
        BootGrid<Lottery> lotteryBootGrid = lotteryService.selectSelectiveQuery(new BootGrid<>(),new Lottery());
        return JSON.toJSONString(lotteryBootGrid);
    }

}