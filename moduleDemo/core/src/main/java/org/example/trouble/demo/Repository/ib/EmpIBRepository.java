package org.example.trouble.demo.Repository.ib;


import org.example.trouble.demo.Entities.ib.EmpIBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmpIBRepository extends JpaRepository<EmpIBEntity, String>{

	@Query(nativeQuery = true, value = " SELECT * FROM BIZ.EMPIB WHERE EMPUID = :empUId ")
    List<EmpIBEntity> findByEmpUid(String empUId) ;

}
