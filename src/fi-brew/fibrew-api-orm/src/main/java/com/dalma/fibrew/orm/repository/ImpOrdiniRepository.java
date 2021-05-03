package com.dalma.fibrew.orm.repository;

import com.dalma.fibrew.orm.entity.ImpOrdini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpOrdiniRepository extends JpaRepository<ImpOrdini, Long> {
    
}
