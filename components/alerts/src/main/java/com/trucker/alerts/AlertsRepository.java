package com.trucker.alerts;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlertsRepository extends CrudRepository<Alerts,String> {

    List<Alerts> findAllByVin(String vin);
}
