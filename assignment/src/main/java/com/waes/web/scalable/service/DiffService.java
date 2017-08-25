package com.waes.web.scalable.service;

import com.waes.web.scalable.persistence.LeftRightData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Class for Diff operations
 */
@Transactional
@Service
@Component
public class DiffService {

    @PersistenceContext
    private EntityManager entityManager;

    public LeftRightData inputLeftData(final Integer id, String data) {
        System.out.println("Data got here: " + data);
        LeftRightData leftData = findById(id);
        if (leftData == null) {
            leftData = new LeftRightData();
            leftData.setId(id);
        }
        leftData.setLeft(data);
        System.out.println("and here!!");
        return update(leftData);
    }

    public LeftRightData inputRightData(final Integer id, String data) {
        LeftRightData rightData = findById(id);
        if (rightData == null) {
            rightData = new LeftRightData();
            rightData.setId(id);
        }
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
