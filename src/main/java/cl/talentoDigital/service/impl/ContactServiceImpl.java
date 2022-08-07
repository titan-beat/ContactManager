package cl.talentoDigital.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.talentoDigital.model.Contacto;
import cl.talentoDigital.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	private Contacto contacto;

	
	private List<Contacto> contactos;

	public ContactServiceImpl() {
		super();
		contactos = new ArrayList<Contacto>();
		contactos.clear();
	}

	@Override
	public List<Contacto> getContactList() {


		return contactos;
	}

	@Override
    public void addContact(Contacto contacto) {
        if (contacto.getNombre() != null) {
            if (contactos.size() > 0) {
                contacto.setIdContacto(contactos.get(contactos.size() - 1).getIdContacto() + 1);
            } else {
                contacto.setIdContacto(1);
            }

            contactos.add(contacto);
        }
    }

	@Override
	public void deleteContact(String idEntrante) {

		int id = Integer.parseInt(idEntrante);
		
		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i).getIdContacto() == id) {
				contactos.remove(i);
				break;
			}

		}
		
	}

}
