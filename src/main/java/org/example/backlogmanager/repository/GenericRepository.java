package org.example.backlogmanager.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

// T: The Entity type (e.g., Project, Backlog)
// ID: The Primary Key type (e.g., Integer, Long, String)
public interface GenericRepository<T, ID extends Serializable> {

    T save(T entity);

    void update(T entity);

    void delete(ID id);

    List<T> getAll();

    Optional<T> getById(ID id);
}