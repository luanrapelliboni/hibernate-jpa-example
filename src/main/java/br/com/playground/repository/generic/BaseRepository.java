package br.com.playground.repository.generic;

import br.com.playground.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface BaseRepository<T extends BaseEntity, ID extends Serializable> {
    T findBy(ID uuid);
    List<T> findAll();
    T create(T entity);
    T update(T entity);
    void delete(T entity);
    void delete(ID uuid);
}
