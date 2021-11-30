package cz.osu.opr3.project.notepadofexcursionist.repository;

import cz.osu.opr3.project.notepadofexcursionist.Constants;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.utils.DBException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TripDBRepository {

    private static EntityManager entityManager = null;
    private static EntityManagerFactory entityManagerFactory = null;

    private void initialize() {

        if (entityManagerFactory == null)
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_NAME);
            } catch (Exception e) {
                throw new DBException(
                        "Failed to create entity manager factory for TripRepository! Message:" + e.getMessage(), e
                );
            }


        if (entityManager == null)
            try {
                entityManager = entityManagerFactory.createEntityManager();
            } catch (Exception e) {
                throw new DBException(
                        "Failed to create entity manager for TripRepository! Message: " + e.getMessage(), e
                );
            }

    }

    public void create(TripEntity tripEntity) {
        initialize();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tripEntity);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DBException(
                    "TripEntity could not be saved! Message: " + e.getMessage(), e
            );
        } finally {
            entityManager.close();
        }

    }

}
