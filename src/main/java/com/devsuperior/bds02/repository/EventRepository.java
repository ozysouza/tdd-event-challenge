package com.devsuperior.bds02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.bds02.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
