package cl.talentoDigital.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.talentoDigital.model.Contacto;
import cl.talentoDigital.service.IContactService;

@Controller
@RequestMapping("/contactManager")

public class ContactController {
	
	@Autowired
	IContactService contactoServicio;

	@Autowired
	Contacto contacto;
	
	@RequestMapping({"","/"})
	public String getContactList(ModelMap model) {
		
		
		model.put("listaContactos", contactoServicio.getContactList());
	return "contactManager";
	}

	@RequestMapping(value="/addContact", method=RequestMethod.POST)
	public String addContact(ModelMap model, @ModelAttribute("contactoVista") Contacto contactoEntrante) {
		
		contactoServicio.addContact(contactoEntrante);
		
		model.put("listaContactos", contactoServicio.getContactList());

		
	return "contactManager";
	}
	
	@RequestMapping(value="/deleteContact", method=RequestMethod.GET)
	public String deleteContact(ModelMap model, @RequestParam("id") String idEntrante) {
		contactoServicio.deleteContact(idEntrante);
		
		model.put("listaContactos", contactoServicio.getContactList());			
		return "contactManager";
	}
}
