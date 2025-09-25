package es.upm.miw.devops.functionaltests.code;

import es.upm.miw.devops.code.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void testFullName() {
        User user = new User("1", "Carlos", "Pérez", null);
        assertEquals("Carlos Pérez", user.fullName(), "El nombre completo no es correcto");
    }

    @Test
    void testInitials() {
        User user = new User("2", "María", "López", null);
        assertEquals("M.", user.initials(), "Las iniciales no son correctas");
    }

}
