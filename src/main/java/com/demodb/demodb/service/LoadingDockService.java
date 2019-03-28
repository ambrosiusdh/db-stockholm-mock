package com.demodb.demodb.service;

import com.demodb.demodb.model.LoadingDock;

import java.util.List;

public interface LoadingDockService {

    LoadingDock createLoadingDock(LoadingDock loadingDock);
    LoadingDock updateLoadingDock(LoadingDock loadingDock);
    List<LoadingDock> findAllLoadingDock();
    LoadingDock findById(Integer id);
    LoadingDock deleteLoadingDock(Integer id);

}
