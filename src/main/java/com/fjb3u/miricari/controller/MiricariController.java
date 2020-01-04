package com.fjb3u.miricari.controller;

import com.fjb3u.miricari.dao.MiricariDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/miricari")
@Controller
public class MiricariController {

    @RequestMapping("/productlist")
    public String getProductList() {
        return "productlist";
    }

    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }

    @RequestMapping("/mypage")
    public String getMypage() {
        return "mypage";
    }

    @RequestMapping("/exhibit")
    public String getExhibit() {
        return "exhibit";
    }

    @RequestMapping("/logout")
    public String logout() {
        // ログアウト処理
        return getProductList();
    }

    @RequestMapping("/cart")
    public String getCart() {
        return "cart";
    }

    @RequestMapping("/auth")
    public String auth(
            @RequestParam final String id,
            @RequestParam final String password) {
        return MiricariDAO.auth(id, password) ? "mypage" : "login";
    }

    @RequestMapping("/accountinfo")
    public String getAccountinfo() {
        return "accountinfo";
    }

    @RequestMapping("/detail")
    public String getDetail() {
        return "productdetails";
    }

    @RequestMapping("/appendcart")
    public String appendCart() {
        return "cart";
    }

    @RequestMapping("/purchase")
    public String purchase() {
        return "purchase";
    }

    @RequestMapping("/complete")
    public String complete() {
        return "purchasecomplete";
    }
}
