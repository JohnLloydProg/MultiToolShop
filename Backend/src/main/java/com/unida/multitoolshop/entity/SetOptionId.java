package com.unida.multitoolshop.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SetOptionId implements Serializable {
    private long multiToolSetId;
    private long multiToolOptionId;

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
