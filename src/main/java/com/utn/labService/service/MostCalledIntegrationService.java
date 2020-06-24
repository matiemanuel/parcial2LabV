package com.utn.labService.service;

import com.utn.labService.model.MostCalled;
import com.utn.labService.service.integrations.MostCalledIntegrationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MostCalledIntegrationService {

    @Autowired
    private MostCalledIntegrationComponent mostCalledIntegrationComponent;

    public ResponseEntity<MostCalled> getUsers(String userId) {

        MostCalled mostCalled = mostCalledIntegrationComponent.getMostCalled(userId);
        if(mostCalled == null){
            return ResponseEntity.notFound().build();
        }
        if(mostCalled.getMostCalled() == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mostCalled);
    }
}
