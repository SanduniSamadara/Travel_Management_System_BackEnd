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
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class TravelBOImpl implements TravelBO {

     TravelRepo travelRepo;
     ModelMapper modelMapper;
     EntityDTOConversion conversion;
    /*private final TravelRepo travelRepo;
    private final ModelMapper modelMapper;
    private final WebClient.Builder webClientBuilder;

    public TravelBOImpl(TravelRepo travelRepo, ModelMapper modelMapper, WebClient.Builder webClientBuilder) {
        this.travelRepo = travelRepo;
        this.modelMapper = modelMapper;
        this.webClientBuilder = webClientBuilder;
    }*/

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
        return modelMapper.map(travelRepo.findAll(), new TypeToken<List<TravelDTO>>() {
        }.getType());
    }

    /*public void saveTravel(TravelDTO travelDTO) {
        WebClient webClient = webClientBuilder.build();
//        1 userId ?
        Boolean isExistUser = webClient.
                get()
                .uri("http://localhost:8081/api/v1/user/username"
                        , uriBuilder -> uriBuilder.queryParam("id", travelDTO.getUserId())
                                .build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();*/
}
