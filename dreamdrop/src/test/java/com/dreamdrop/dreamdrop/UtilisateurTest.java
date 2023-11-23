package com.dreamdrop.dreamdrop;

import com.dreamdrop.dreamdrop.model.Utilisateur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class UtilisateurTest {


   @Test
   public void testUtilisateurProperties() {
        // Create a Utilisateur instance
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1);
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setRole("Admin");
        utilisateur.setEmail("john.doe@example.com");
        utilisateur.setPassword("password123");
        utilisateur.setIsblocked(false);
        utilisateur.setIsarchived(false);
//        utilisateur.setCreated_date(new Date());
       utilisateur.setCreated_date(Date.from(Instant.now())); // Use Instant to get current time truncated to seconds

        // Test getters
        assertEquals(1, utilisateur.getId());
        assertEquals("John", utilisateur.getNom());
        assertEquals("Doe", utilisateur.getPrenom());
        assertEquals("Admin", utilisateur.getRole());
        assertEquals("john.doe@example.com", utilisateur.getEmail());
        assertEquals("password123", utilisateur.getPassword());
        assertEquals(false, utilisateur.isIsblocked());
        assertEquals(false, utilisateur.isIsarchived());

       Instant expectedInstant = utilisateur.getCreated_date().toInstant().truncatedTo(ChronoUnit.SECONDS);
       Instant actualInstant = Date.from(Instant.now()).toInstant().truncatedTo(ChronoUnit.SECONDS);
       //
//       assertEquals(Date.from(Instant.now().truncatedTo(ChronoUnit.SECONDS)), utilisateur.getCreated_date());
       assertEquals(Date.from(expectedInstant), Date.from(actualInstant));

   }
}
