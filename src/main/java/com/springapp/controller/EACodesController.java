package com.springapp.controller;

import com.springapp.service.EA14001Service;
import com.springapp.service.EA9001Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EACodesController {
    @Autowired
    EA9001Service ea9001Service;
    @Autowired
    EA14001Service ea14001Service;

    @RequestMapping(value= "/eaCodes", method = RequestMethod.GET)
    public String eaCodesMain() {
        return "eaCodes/eaCodes_main";
    }

    @RequestMapping(value= "/lista_ea9001_kodova", method = RequestMethod.GET)
    public String ea9001CodesList(@RequestParam(value = "success", required = false) String success,
                                  @RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("ea9001Codes", ea9001Service.getAllEACodes());
        model.addAttribute("success", success);
        model.addAttribute("error", error);
        return "eaCodes/lista_ea9001_kodova";
    }

    @RequestMapping(value= "/lista_ea14001_kodova", method = RequestMethod.GET)
    public String ea14001CodesList(@RequestParam(value = "success", required = false) String success,
                                  @RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("ea14001Codes", ea14001Service.getAllEACodes());
        model.addAttribute("success", success);
        model.addAttribute("error", error);
        return "eaCodes/lista_ea14001_kodova";
    }


    @RequestMapping(value= "/brisanje_ea9001_koda", method = RequestMethod.GET)
    public String deleteEA9001Code(@RequestParam("codeId") String codeId, Model model) {
        if(ea9001Service.deleteCode(codeId)) {
            model.addAttribute("success", "Code successfully deleted." );
        } else {
            model.addAttribute("error", "Code delete failed!");
        }
        return "redirect:/lista_ea9001_kodova";
    }

    @RequestMapping(value= "/brisanje_ea14001_koda", method = RequestMethod.GET)
    public String deleteEA14001Code(@RequestParam("codeId") String codeId, Model model) {
        if(ea14001Service.deleteCode(codeId)) {
            model.addAttribute("success", "Code successfully deleted." );
        } else {
            model.addAttribute("error", "Code delete failed!");
        }
        return "redirect:/lista_ea14001_kodova";
    }

    @RequestMapping(value= "/dodaj_ea9001_forma", method = RequestMethod.GET)
    public String createEA9001Form() {
        return "eaCodes/create_ea9001";
    }

    @RequestMapping(value= "/dodaj_ea9001", method = RequestMethod.POST)
    public String createEA9001(@RequestParam("codeName") String codeName, @RequestParam("codeNumber") String codeNumber, Model model) {
        if(ea9001Service.createEA9001Code(codeName, codeNumber)){
            model.addAttribute("success", "Code successfully added.");
            return "redirect:/lista_ea9001_kodova";
        } else {
            return "redirect:/eaCodes";
        }
    }

    @RequestMapping(value= "/dodaj_ea14001_forma", method = RequestMethod.GET)
    public String createEA14001Form() {
        return "eaCodes/create_ea14001";
    }

    @RequestMapping(value= "/dodaj_ea14001", method = RequestMethod.POST)
    public String createEA14001(@RequestParam("codeName") String codeName, @RequestParam("codeNumber") String codeNumber, Model model) {
        if(ea14001Service.createEA14001Code(codeName, codeNumber)){
            model.addAttribute("success", "Code successfully added.");
            return "redirect:/lista_ea14001_kodova";
        } else {
            return "redirect:/eaCodes";
        }
    }


    @RequestMapping(value= "/azuriraj_ea9001_forma", method = RequestMethod.GET)
    public String updateEA9001CodeForm(@RequestParam("codeId") String codeId, Model model) {
        model.addAttribute("eaCode", ea9001Service.getEaCodeById(Integer.parseInt(codeId)));
        return "eaCodes/updateEA9001Code";
    }

    @RequestMapping(value= "/azuriraj_ea9001", method = RequestMethod.POST)
    public String updateEA9001Code(@RequestParam("codeName") String codeName, @RequestParam("codeNumber") String codeNumber,
                                   @RequestParam("codeId") String codeId, Model model) {
        if(ea9001Service.updateEA9001Code(codeName, codeNumber, codeId)){
            model.addAttribute("success", "Code successfully updated.");
            return "redirect:/lista_ea9001_kodova";
        } else {
            model.addAttribute("error", "Code update failed.");
            return "redirect:/lista_ea9001_kodova";
        }
    }

    @RequestMapping(value= "/azuriraj_ea14001_forma", method = RequestMethod.GET)
    public String updateEA14001CodeForm(@RequestParam("codeId") String codeId, Model model) {
        model.addAttribute("eaCode", ea14001Service.getEaCodeById(Integer.parseInt(codeId)));
        return "eaCodes/updateEA14001Code";
    }

    @RequestMapping(value= "/azuriraj_ea14001", method = RequestMethod.POST)
    public String updateEA14001Code(@RequestParam("codeName") String codeName, @RequestParam("codeNumber") String codeNumber,
                                   @RequestParam("codeId") String codeId, Model model) {
        if(ea14001Service.updateEA14001Code(codeName, codeNumber, codeId)){
            model.addAttribute("success", "Code successfully updated.");
            return "redirect:/lista_ea14001_kodova";
        } else {
            model.addAttribute("error", "Code update failed.");
            return "redirect:/lista_ea14001_kodova";
        }
    }


}
