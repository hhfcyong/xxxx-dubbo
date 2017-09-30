package com.xxxx.service.Domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TreeRepository extends JpaRepository<Tree,Integer>,JpaSpecificationExecutor<Tree>{

	Tree findByName(String name);
	Tree findByNameAndAge(String name,Integer age);
	
	@Query("select t from Tree t where t.name=:name")
	Tree findTree(@Param("name") String name);
}
