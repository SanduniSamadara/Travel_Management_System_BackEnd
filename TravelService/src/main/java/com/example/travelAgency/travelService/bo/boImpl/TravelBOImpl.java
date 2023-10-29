package com.example.travelAgency.travelService.bo.boImpl;

import com.example.travelAgency.travelService.bo.TravelBO;
import com.example.travelAgency.travelService.dto.TravelDTO;
import com.example.travelAgency.travelService.entity.Travel;
import com.example.travelAgency.travelService.repository.TravelRepo;
import com.example.travelAgency.travelService.util.EntityDTOConversion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TravelBOImpl implements TravelBO {

    @Autowired
    TravelRepo travelRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    EntityDTOConversion conversion;

    @Override
    public void updateTravel(TravelDTO travelDTO) {
        if (travelRepo.existsById(travelDTO.getPackageId())) {
            travelRepo.save(conversion.getTravelEntity(travelDTO));
        }
    }

    @Override
    public void saveTravel(TravelDTO travelDTO) {
        if (!travelRepo.existsById(travelDTO.getPackageId())) {
            travelRepo.save(conversion.getTravelEntity(travelDTO));
        }
    }

    @Override
    public TravelDTO searchTravel(String id) {
        if (travelRepo.existsById(id)) {
            Travel travel = travelRepo.findById(id).get();
            return conversion.getTravelDTO(travel);
        }
        return null;
    }

    @Override
    public void deleteTravel(String id) {
        if (travelRepo.existsById(id)) {
            travelRepo.deleteById(id);
        }
    }

    @Override
    public List<TravelDTO> getAllTravel() {
        return modelMapper.map(travelRepo.findAll(), new TypeToken<List<TravelDTO>>() {}.getType());
    }
}
