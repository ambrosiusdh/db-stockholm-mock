package com.demodb.demodb.seeder;

import com.demodb.demodb.model.LoadingDock;
import com.demodb.demodb.service.LoadingDockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class LoadingDockSeeder {

    private LoadingDockService loadingDockService;
    private List<LoadingDock> loadingDockList;
    private List<String> loadingDockNameList;

    @Autowired
    public LoadingDockSeeder(LoadingDockService loadingDockService) {
        this.loadingDockService = loadingDockService;
        this.loadingDockList = new ArrayList<>();
        this.loadingDockNameList = new ArrayList<>();

        loadingDockNameList.add("Dock Medan");
        loadingDockNameList.add("Dock Jakarta");
        loadingDockNameList.add("Dock Makassar");
    }

    public void seedLoadingDockTable() {

        int i = 0;

        while (i < 10){
            loadingDockList.add(
                    new LoadingDock(
                        null,
                        loadingDockNameList.get(i%3),
                        new Random().nextInt(100) + 1
                    ));
            i++;
        }

        for (LoadingDock loadingDock : loadingDockList) {
            loadingDockService.createLoadingDock(loadingDock);
        }
    }
}
