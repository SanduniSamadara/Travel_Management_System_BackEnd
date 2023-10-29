package com.example.travelAgency.travelService.bo;

import com.example.travelAgency.travelService.dto.TravelDTO;

import java.util.List;

public interface TravelBO {
    public void saveTravel(TravelDTO travelDTO);

    public void updateTravel(TravelDTO travelDTO);

    public TravelDTO searchTravel(String id);

    public void deleteTravel(String id);

    public List<TravelDTO> getAllTravel();

}
