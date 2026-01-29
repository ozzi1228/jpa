package com.inflearn.jpa.practice.jpashop.entity;

import jakarta.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    private Date createdAt;
    private Date lastModifiedAt;
}
