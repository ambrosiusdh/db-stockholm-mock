package com.demodb.demodb.service;

import com.demodb.demodb.model.LoadingDock;
import com.demodb.demodb.repository.LoadingDockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoadingDockServiceImpl implements LoadingDockService{

    private LoadingDockRepository loadingDockRepository;

    @Autowired
    public LoadingDockServiceImpl(LoadingDockRepository loadingDockRepository) {
        this.loadingDockRepository = loadingDockRepository;
    }

    @Override
    public LoadingDock createLoadingDock(LoadingDock loadingDock) {
        return loadingDockRepository.save(loadingDock);
    }

    @Override
    public LoadingDock updateLoadingDock(LoadingDock loadingDock) {
        if(loadingDockRepository.findById(loadingDock.getLoadingDockId()).isPresent())
            return loadingDockRepository.save(loadingDock);
        return null;
    }

    @Override
    public List<LoadingDock> findAllLoadingDock() {
        return loadingDockRepository.findAll();
    }

    @Override
    public LoadingDock findById(Integer id) {
        if(loadingDockRepository.findById(id).isPresent())
            return loadingDockRepository.findById(id).get();
        return null;
    }

    @Override
    public LoadingDock deleteLoadingDock(Integer id) {
        if(loadingDockRepository.findById(id).isPresent()) {
            LoadingDock temp = loadingDockRepository.findById(id).get();
            loadingDockRepository.deleteById(id);
            return temp;
        }
        return null;
    }
}
