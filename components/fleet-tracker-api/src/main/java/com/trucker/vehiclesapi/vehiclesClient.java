package com.trucker.vehiclesapi;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class vehiclesClient {

    private String vehiclesUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<vehiclesInfo>> vehicleListType = new ParameterizedTypeReference<List<vehiclesInfo>>() {
    };

    public vehiclesClient(String vehiclesUrl, RestOperations restOperations){
        this.vehiclesUrl = vehiclesUrl;
        this.restOperations = restOperations;
    }

    public void addVehicle(vehiclesInfo vehiclesInfo){
        restOperations.postForEntity(vehiclesUrl,vehiclesInfo,vehiclesInfo.getClass());
    }

    public List<vehiclesInfo> find(String vin){
        UriComponentsBuilder uriComponentsBuilder =UriComponentsBuilder.fromHttpUrl(vehiclesUrl)
                .query(vin);

        return restOperations.exchange(uriComponentsBuilder.toUriString(),GET,null,vehicleListType).getBody();
    }

}
