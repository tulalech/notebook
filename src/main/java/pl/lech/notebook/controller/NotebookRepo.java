package pl.lech.notebook.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lech.notebook.model.Notebook;

@Repository
public interface NotebookRepo extends JpaRepository <Notebook, Long> {
}
