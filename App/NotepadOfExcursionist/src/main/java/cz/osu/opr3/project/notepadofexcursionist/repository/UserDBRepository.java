package cz.osu.opr3.project.notepadofexcursionist.repository;

import cz.osu.opr3.project.notepadofexcursionist.Constants;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class UserDBRepository {

    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    private void initialize() {

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_NAME);
        } catch (Exception e) {
            throw new DBException("Failed to create entity manager factory! ........" + e.getMessage(), e);
        }


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
            throw new DBException("Failed to find-all results of user-entity.", e);
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
            throw new DBException("Failed to find by id result of user with id " + userId, e);
        }

        return ret;
    }
}
