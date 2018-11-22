package org.nh.bookspringdata.dal;

import org.nh.bookspringdata.domaine.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "contacts-list")
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	 Contact findByEmail(@Param("email") String email);

}
