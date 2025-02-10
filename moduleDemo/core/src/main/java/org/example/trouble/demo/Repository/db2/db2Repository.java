package org.example.trouble.demo.Repository.db2;


import org.example.trouble.demo.Entities.db2.table1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface db2Repository extends JpaRepository<table1Entity, Integer> {

    @Query(nativeQuery = true, value = " SELECT id,name FROM table1 WHERE id = :id ")
    org.example.trouble.demo.Entities.db1.table1Entity findById(@Param("id") int Id) ;


}
