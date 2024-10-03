package com.websystique.springmvc.controller;


import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping(value = {"/delete-office-{id}"}, method = RequestMethod.GET)
    public String deleteOffices(@PathVariable String id) {
        officeService.deleteOfficeById(Integer.parseInt(id));
        return "redirect:/offices";
    }

    @RequestMapping(value = { "/edit-office-{id}" }, method = RequestMethod.GET)
    public String updateOffice(@PathVariable Integer id, ModelMap model) {
        Office office = officeService.findById(id);
        model.addAttribute("office", office);
        model.addAttribute("edit", true);
        return "officereg";
    }


    @RequestMapping(value = { "/edit-office-{id}" }, method = RequestMethod.POST)
    public String updateOffice(@Valid Office office, BindingResult result,
                               ModelMap model, @PathVariable Integer id) {

        if (result.hasErrors()) {
            return "officereg";
        }

        /*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }*/
        officeService.updateOffice(office);
        model.addAttribute("success", "Office " + office.getId()+ " updated successfully");

        return "officeregsuccess";
    }
}
