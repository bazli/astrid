package com.thoughtworks.sql;

public class EqCriterion extends UnaryCriterion {
    EqCriterion(Field field, Object value) {
        super(field, Operator.eq, value);
    }
}
