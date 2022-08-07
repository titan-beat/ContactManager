package cl.talentoDigital.service;

import java.util.List;

import cl.talentoDigital.model.Contacto;

public interface IContactService {

	public List<Contacto> getContactList();
	
	public void addContact(Contacto contactoEntrante);
	
	public void deleteContact(String idEntrante);
	
}
