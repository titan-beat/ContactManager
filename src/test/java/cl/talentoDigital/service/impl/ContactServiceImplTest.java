package cl.talentoDigital.service.impl;

import cl.talentoDigital.model.Contacto;
import cl.talentoDigital.service.IContactService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ContactServiceImplTest {

    @Test
    public void addContactTest() {

        Contacto contacto = new Contacto();
        contacto.setNombre("Pepe");
        contacto.setApellidoMaterno("Lota");
        contacto.setApellidoPaterno("Rojas");
        contacto.setDireccion("Av. Poinga Poinga");
        contacto.setTelefono("5674758393");
        System.out.println("despues de la clase contacto");

        IContactService contactService = new ContactServiceImpl();
        contactService.addContact(contacto);

        assertEquals(contactService.getContactList().size(), 1);
        assertEquals(contactService.getContactList().get(0).getNombre(), "Pepe");

    }

    @Test
    public void deleteContactGTest() {
        Contacto contacto = new Contacto();
        contacto.setNombre("Pepe");
        contacto.setApellidoMaterno("Lota");
        contacto.setApellidoPaterno("Rojas");
        contacto.setDireccion("Av. Poinga Poinga");
        contacto.setTelefono("5674758393");
        IContactService contactService = new ContactServiceImpl();
        contactService.addContact(contacto);

        assertEquals(contactService.getContactList().size(), 1);
        contactService.deleteContact("1");
        assertEquals(contactService.getContactList().size(), 0);


    }

}