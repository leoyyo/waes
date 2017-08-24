package com.waes.web.scalable.service;

import com.waes.web.scalable.persistence.LeftRightData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Class for Diff operations
 */
@Transactional
@Service
public class DiffService {

    @PersistenceContext
    private EntityManager entityManager;

    public LeftRightData inputLeftData(final Integer id, String data) {
        LeftRightData leftData = new LeftRightData();
        leftData.setId(id);
        leftData.setLeft(data);
        return update(leftData);
    }

    public LeftRightData inputRightData(final Integer id, String data) {
        LeftRightData rightData = new LeftRightData();
        rightData.setId(id);
        rightData.setRight(data);
        return update(rightData);
    }

    public LeftRightData update(LeftRightData leftRightData) {
        return entityManager.merge(leftRightData);
    }

    public LeftRightData findById(final Integer id) {
        return entityManager.find(LeftRightData.class, id);
    }

}
