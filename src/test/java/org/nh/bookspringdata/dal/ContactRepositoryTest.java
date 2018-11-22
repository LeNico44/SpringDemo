package org.nh.bookspringdata.dal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nh.bookspringdata.domaine.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;

import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactRepositoryTest {

    @Autowired
    ContactRepository repository;

    @Test
    public void findByEmail() {
        Contact contact = repository.save(new Contact("Laurent", "Lecomte", "dynaouest@gmail.com"));
        Assert.assertThat(contact.getFirstName(), is(repository.findByEmail("dynaouest@gmail.com").getFirstName()));
    }
}