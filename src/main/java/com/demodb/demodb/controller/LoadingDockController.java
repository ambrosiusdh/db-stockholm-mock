package com.demodb.demodb.controller;

import com.demodb.demodb.model.LoadingDock;
import com.demodb.demodb.service.LoadingDockService;
import com.demodb.demodb.service.LoadingDockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoadingDockController {

    private LoadingDockService loadingDockService;

    @Autowired
    public LoadingDockController(LoadingDockService loadingDockService) {
        this.loadingDockService = loadingDockService;
    }

    @RequestMapping(
            value = "/loading-dock",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public LoadingDock createLoadingDock(@RequestBody LoadingDock loadingDock){
        return loadingDockService.createLoadingDock(loadingDock);
    }

    @RequestMapping(
            value = "/loading-dock",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<LoadingDock> findAllLoadingDock(){
        return loadingDockService.findAllLoadingDock();
    }

}
