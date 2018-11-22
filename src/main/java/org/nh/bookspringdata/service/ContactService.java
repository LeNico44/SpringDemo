package org.nh.bookspringdata.service;

import org.nh.bookspringdata.dal.ContactRepository;
import org.nh.bookspringdata.domaine.Contact;

public class ContactService extends GenericService<ContactRepository, Contact> {

    public Contact findByEmail(String email){
        return repository.findByEmail(email);
    }

    public int getContactBirthYear(Contact contact){
        //TODO recupération de la date et extraction de l'année de naissance
        return 0;
    }
}
