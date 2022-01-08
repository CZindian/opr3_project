package cz.osu.opr3.project.notepadofexcursionist.repository;

import cz.osu.opr3.project.notepadofexcursionist.utils.Constants;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.utils.DBException;

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
                throw new DBException(
                        "Failed to create entity manager factory for UserRepository! Message:" + e.getMessage(), e
                );
            }


        if (entityManager == null)
            try {
                entityManager = entityManagerFactory.createEntityManager();
            } catch (Exception e) {
                throw new DBException(
                        "Failed to create entity manager for UserRepository! Message: " + e.getMessage(), e
                );
            }

    }

    public void create(UserEntity userEntity) {
        initialize();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userEntity);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DBException(
                    "UserEntity could not be saved! Message: " + e.getMessage(), e
            );
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
            throw new DBException(
                    "Failed to find-all results of UserEntity! Message: " + e.getMessage(), e
            );
        }
        return ret;

    }

    public UserEntity findById(int userId) {
        initialize();
        TypedQuery<UserEntity> typedQuery = entityManager.createQuery(
                "SELECT user FROM UserEntity user WHERE user.userId = :userId",
                UserEntity.class);
        typedQuery.setParameter("userId", userId);

        UserEntity ret;
        try {
            ret = typedQuery.getSingleResult();
        } catch (Exception e) {
            throw new DBException(
                    "Failed to find-by-id result of user with id " + userId + " \nMessage: " + e.getMessage(), e
            );
        }
        return ret;
    }
}
