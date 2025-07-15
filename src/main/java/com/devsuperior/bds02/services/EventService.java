package com.devsuperior.bds02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repository.CityRepository;
import com.devsuperior.bds02.repository.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public EventDTO update(Long id, EventDTO eventDTO) {
        try {
            Event event = eventRepository.getReferenceById(id);
            event.setName(eventDTO.getName());
            event.setDate(eventDTO.getDate());
            event.setUrl(eventDTO.getUrl());

            City city = cityRepository.getReferenceById(eventDTO.getCityId());
            event.setCity(city);

            return new EventDTO(event);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource with ID " + eventDTO.getId() + "was not found");
        }
    }

}
