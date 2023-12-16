package br.com.playground.repository.generic;

import br.com.playground.infra.ConnectionFactory;
import br.com.playground.model.BaseEntity;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class BaseRepositoryImpl<T extends BaseEntity, ID extends UUID> implements BaseRepository<T, ID> {
    private final Class<T> clazz;
    public BaseRepositoryImpl(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public T findBy(ID uuid) {
        var entityManager = ConnectionFactory.getEntityManager();
        var entity = entityManager.find(this.clazz, uuid);
        entityManager.close();
        return entity;
    }

    @Override
    public List<T> findAll() {
        var entityManager = ConnectionFactory.getEntityManager();
        var query = entityManager.createQuery(
                "SELECT e FROM ".concat(clazz.getSimpleName()).concat(" e"), clazz);
        var list = query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public T create(T entity) {
        var entityManager = ConnectionFactory.getEntityManager();
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public T update(T entity) {
        var entityManager = ConnectionFactory.getEntityManager();
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            var updated = entityManager.merge(entity);
            transaction.commit();
            return updated;
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(T entity) {
        var entityManager = ConnectionFactory.getEntityManager();
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(ID uuid) {
        var entityManager = ConnectionFactory.getEntityManager();
        var transaction = entityManager.getTransaction();
        try {
            var entity = findBy(uuid);
            if (Objects.nonNull(entity))
                entityManager.remove(entity);

        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }
}
