package com.waes.web.scalable.service;

import com.waes.web.scalable.domain.DiffResult;
import com.waes.web.scalable.enums.DataDiff;
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
        LeftRightData leftData = findById(id);
        if (leftData == null) {
            leftData = new LeftRightData();
            leftData.setId(id);
        }
        leftData.setLeft(data);
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

    public DiffResult returnLeftRightDiff(final Integer id) {
        DiffResult diffResult = new DiffResult();

        diffResult.setLeftRightData(findById(id));
        validateLeftRightData(diffResult);

        return diffResult;
    }

    private void validateLeftRightData(DiffResult diffResult) {
        if (diffResult.getLeftRightData() == null) {
            diffResult.setResult(DataDiff.NOT_FOUND.getText());

        } else if (diffResult.getLeftRightData().getLeft() == null && diffResult.getLeftRightData().getRight() != null
                || diffResult.getLeftRightData().getLeft() != null && diffResult.getLeftRightData().getRight() == null
                || diffResult.getLeftRightData().getLeft().length() != diffResult.getLeftRightData().getRight().length()) {
            diffResult.setResult(DataDiff.SIZE_DIFF.getText());

        } else if (diffResult.getLeftRightData().getLeft() != diffResult.getLeftRightData().getRight()) {
            diffResult.setResult(DataDiff.OFFSET.getText());

        } else {
            diffResult.setResult(DataDiff.EQUAL.getText());
        }
    }
}

