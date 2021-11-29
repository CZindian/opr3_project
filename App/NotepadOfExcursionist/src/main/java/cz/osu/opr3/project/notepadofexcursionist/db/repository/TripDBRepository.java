package cz.osu.opr3.project.notepadofexcursionist.db.repository;

import cz.osu.opr3.project.notepadofexcursionist.db.DBException;
import cz.osu.opr3.project.notepadofexcursionist.db.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.db.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TripDBRepository {

    private static EntityManager entityManager = null;
    private static EntityManagerFactory entityManagerFactory = null;
    private static final String PU_NAME = "tripPU";

    private void initialize() {
        if (entityManagerFactory == null)
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory(PU_NAME);
            } catch (Exception e) {
                throw new DBException("Failed to create entity manager factory!", e);
            }

        if (entityManager == null)
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
