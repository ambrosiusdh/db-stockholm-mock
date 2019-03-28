package com.demodb.demodb.repository;

import com.demodb.demodb.model.LoadingDock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadingDockRepository extends JpaRepository<LoadingDock, Integer> {

    List<LoadingDock> findAllByLoadingDockId(Integer loadingDockId);
    List<LoadingDock> findAllByLoadingDockName(String loadingDockName);

}
