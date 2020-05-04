package com.springapp.controller;

import com.springapp.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;


@Controller
@Transactional
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @RequestMapping(value="/", method = RequestMethod.POST)
    public void sendEmails() {
        notificationService.sendEmails();
    }

    @RequestMapping(value="/notifications_dashboard", method = RequestMethod.GET)
    public String notificationPanel(Model model) {
        model.addAttribute("oneYear", notificationService.sendEmail1Year());
        model.addAttribute("sixMonths", notificationService.sendEmail6Months());
        model.addAttribute("threeMonths", notificationService.sendEmail3Months());
        if (LoginController.isUserLoggedIn())
            return "notification/notificationPanel";
        return "login";
    }


    @RequestMapping(value="/oneYearNotifications", method = RequestMethod.GET)
    public String oneYearNotifications(Model model) {
        model.addAttribute("oneYear", notificationService.sendEmail1Year());
        model.addAttribute("oneYearMessage", "Certificate expires in 1 year");
        if (LoginController.isUserLoggedIn())
            return "notification/oneYearNotifications";
        return "login";
    }

    @RequestMapping(value="/sixMonthsNotifications", method = RequestMethod.GET)
    public String sixMonthsNotifications(Model model) {
        model.addAttribute("sixMonths", notificationService.sendEmail6Months());
        model.addAttribute("sixMonthsMessage", "Certificate expires in 6 months");
        if (LoginController.isUserLoggedIn())
            return "notification/sixMonthsNotifications";
        return "login";
    }

    @RequestMapping(value="/threeMonthsNotifications", method = RequestMethod.GET)
    public String threeMonthsNotifications(Model model) {
        model.addAttribute("threeMonths", notificationService.sendEmail3Months());
        model.addAttribute("threeMonthsMessage", "Certificate expires in 3 months");
        if (LoginController.isUserLoggedIn())
            return "notification/threeMonthsNotifications";
        return "login";
    }

}
