package com.websystique.springmvc.controller;


import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.OfficeService;
import com.websystique.springmvc.service.UserProfileService;
import com.websystique.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/offices")
@SessionAttributes("roles")
public class OfficesController {

    @Autowired
    OfficeService officeService;

    @RequestMapping(method = RequestMethod.GET)
    public String listOffices(ModelMap model) {

        List<Office> offices = officeService.findAllOffices();
              model.addAttribute("offices", offices);
        return "offices";
    }

    @RequestMapping(value = { "/delete-office-{id}" }, method = RequestMethod.GET)
    public String deleteOffices(@PathVariable String id) {
        officeService.deleteOfficeById(Integer.parseInt(id));
        return "redirect:/offices";
    }
}
