package cz.osu.opr3.project.notepadofexcursionist.repository;

import cz.osu.opr3.project.notepadofexcursionist.Constants;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TripDBRepository {

    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    private void initialize() {

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_NAME);
        } catch (Exception e) {
            throw new DBException("Failed to create entity manager factory!", e);
        }

        try {
            entityManager = entityManagerFactory.createEntityManager();
        } catch (Exception e) {
            throw new DBException("Failed to create entity manager!", e);
        }

    }

    public void create(TripEntity tripEntity) {
        initialize();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tripEntity);
            entityManager.getTransaction().commit();
        } catch (Exception commitException) {
            entityManager.getTransaction().rollback();

        }

    }
}
