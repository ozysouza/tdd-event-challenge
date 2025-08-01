package com.devsuperior.bds02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repository.CityRepository;
import com.devsuperior.bds02.services.exceptions.DataBaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll(Pageable pageable) {
        Page<City> cities = cityRepository.findAll(pageable);
        return cities.map(CityDTO::new).getContent();
    }

    @Transactional
    public CityDTO insert(CityDTO cityDTO) {
        City city = new City(cityDTO.getId(), cityDTO.getName());
        city = cityRepository.save(city);
        return new CityDTO(city);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!cityRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource Not Found");
        }

        try {
            cityRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Referential integrity constraint violation");
        }

    }

}
