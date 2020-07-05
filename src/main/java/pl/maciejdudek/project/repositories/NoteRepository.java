package pl.maciejdudek.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maciejdudek.project.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
