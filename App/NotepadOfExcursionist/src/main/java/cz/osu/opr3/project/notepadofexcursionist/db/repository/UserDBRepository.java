package cz.osu.opr3.project.notepadofexcursionist.db.repository;

import cz.osu.opr3.project.notepadofexcursionist.Constants;
import cz.osu.opr3.project.notepadofexcursionist.db.DBException;
import cz.osu.opr3.project.notepadofexcursionist.db.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class UserDBRepository {

    private static EntityManager entityManager = null;
    private static EntityManagerFactory entityManagerFactory = null;

    private void initialize() {
        if (entityManagerFactory == null)
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_NAME);
            } catch (Exception e) {
                throw new DBException("Failed to create entity manager factory! ........" + e.getMessage(), e);
            }

        if (entityManager == null)
            try {
                entityManager = entityManagerFactory.createEntityManager();
            } catch (Exception e) {
                throw new DBException("Failed to create entity manager!", e);
            }

    }

    public void create(UserEntity userEntity) {
        initialize();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userEntity);
            entityManager.getTransaction().commit();
        } catch (Exception commitException) {
            entityManager.getTransaction().rollback();

        }

    }


    public List<UserEntity> findAll() {
        initialize();

        TypedQuery<UserEntity> typedQuery = entityManager.createQuery(
                "SELECT user FROM UserEntity user ORDER BY user.userId",
                UserEntity.class);

        List<UserEntity> ret;
        try {
            ret = typedQuery.getResultList();
        } catch (NoResultException e) {
            ret = new ArrayList<>();
        } catch (Exception e) {
            throw new DBException("Failed to find-all results of product-entity.", e);
        }

        return ret;
    }
}
