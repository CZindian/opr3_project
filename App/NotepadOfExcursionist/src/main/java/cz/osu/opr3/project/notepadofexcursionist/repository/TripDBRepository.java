package cz.osu.opr3.project.notepadofexcursionist.repository;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.utils.DBException;
import cz.osu.opr3.project.notepadofexcursionist.utils.Constants;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaDelete;
import java.util.ArrayList;
import java.util.List;

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
        }

    }

    public List<TripEntity> findAll() {
        initialize();
        TypedQuery<TripEntity> typedQuery = entityManager.createQuery(
                "SELECT trip FROM TripEntity trip ORDER BY trip.tripId",
                TripEntity.class);

        List<TripEntity> ret;
        try {
            ret = typedQuery.getResultList();
        } catch (NoResultException e) {
            ret = new ArrayList<>();
        } catch (Exception e) {
            throw new DBException(
                    "Failed to find-all results of TripEntity! Message: " + e.getMessage(), e
            );
        }
        return ret;
    }

    public TripEntity findById(int tripId) {
        initialize();
        TypedQuery<TripEntity> typedQuery = entityManager.createQuery(
                "SELECT tripEntity FROM TripEntity tripEntity WHERE tripEntity.tripId = :tripId",
                TripEntity.class);
        typedQuery.setParameter("tripId", tripId);

        TripEntity ret;
        try {
            ret = typedQuery.getSingleResult();
        } catch (Exception e) {
            throw new DBException(
                    "Failed to find-by-id result of trip with id " + tripId + " \nMessage: " + e.getMessage(), e
            );
        }
        return ret;
    }

    public void delete(int tripId) {
        initialize();

        try{
            entityManager.getTransaction().begin();
            TripEntity tripEntity = findById(tripId);
            entityManager.remove(tripEntity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DBException("Failed to delete trip with id '" + tripId + "'", e);
        }
    }
}
