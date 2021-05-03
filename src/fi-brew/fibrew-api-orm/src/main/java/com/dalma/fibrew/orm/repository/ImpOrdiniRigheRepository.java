package com.dalma.fibrew.orm.repository;

import com.dalma.fibrew.orm.entity.ImpOrdiniRighe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpOrdiniRigheRepository extends JpaRepository<ImpOrdiniRighe, Long> {
    
}
