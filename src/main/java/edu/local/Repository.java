package edu.local;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface Repository extends PanacheRepository<MyEntity> {

}
