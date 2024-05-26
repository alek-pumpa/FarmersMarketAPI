package uacs.edu.mk.FarmersMarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uacs.edu.mk.FarmersMarket.entity.Produce;

public interface ProduceRepository extends JpaRepository<Produce, Long> {}
