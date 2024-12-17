package org.example.trouble.demo.Repository.db1;


import org.example.trouble.demo.Entities.db1.table1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface db1Repository extends JpaRepository<table1Entity, Integer> {
    @Query(nativeQuery = true, value = " SELECT id,name FROM table1 WHERE id = :id ")
    table1Entity findById(int id) ;

}
