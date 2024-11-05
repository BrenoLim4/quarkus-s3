package edu.local;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepositoryImpl implements Repository {

    @Override
    public void persist(MyEntity myEntity) {

        Repository.super.persist(myEntity);
    }
}
