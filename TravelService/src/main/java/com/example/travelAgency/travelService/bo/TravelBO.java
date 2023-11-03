package com.example.travelAgency.travelService.bo;

import com.example.travelAgency.travelService.dto.TravelDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TravelBO {
    public void saveTravel(TravelDTO travelDTO);

    public TravelDTO searchTravel(String id);

    public void deleteTravel(String id);

    public List<TravelDTO> getAllTravel();

    void updateTravel(TravelDTO travelDTO, String id);
}
