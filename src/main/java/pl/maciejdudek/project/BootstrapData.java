package pl.maciejdudek.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.maciejdudek.project.model.Note;
import pl.maciejdudek.project.model.User;
import pl.maciejdudek.project.repositories.NoteRepository;
import pl.maciejdudek.project.repositories.UserRepository;

import java.time.LocalDateTime;

@Configuration
public class BootstrapData {

    @Autowired
    public BootstrapData(UserRepository userRepository, NoteRepository noteRepository, PasswordEncoder passwordEncoder) {
        User kamil = new User();
        kamil.setUsername("Kamil");
        kamil.setPassword(passwordEncoder.encode("Kamil123"));
        kamil.setRole("ROLE_ADMIN");

        User marcin = new User();
        marcin.setUsername("Marcin");
        marcin.setPassword(passwordEncoder.encode("Marcin123"));
        marcin.setRole("ROLE_USER");

        userRepository.save(kamil);
        userRepository.save(marcin);

        Note note1 = new Note();
        note1.setContent("Pierwsza notatka");
        note1.setCreatedAt(LocalDateTime.now());

        noteRepository.save(note1);
    }
}
