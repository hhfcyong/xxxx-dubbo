package com.xxxx.service.Domain.Primary;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface Teacher1Repository  extends JpaRepository<Teacher1,Integer>,JpaSpecificationExecutor<Teacher1>{
  //可以用对应的命名规则去写一些特殊的方法

 List<Teacher1> findByName(String name);
}
