package com.example.travelAgency.travelService.bo.boImpl;

import com.example.travelAgency.travelService.bo.TravelBO;
import com.example.travelAgency.travelService.dto.TravelDTO;
import com.example.travelAgency.travelService.entity.Travel;
import com.example.travelAgency.travelService.repository.TravelRepo;
import com.example.travelAgency.travelService.util.EntityDTOConversion;
import com.example.travelAgency.userService.bo.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;
import java.util.List;

public class TravelBOImpl implements TravelBO {

    private final TravelRepo travelRepo;
    private final ModelMapper modelMapper;
    private final WebClient.Builder webClientBuilder;
    private final EntityDTOConversion entityDTOConversion;

    public TravelBOImpl(TravelRepo travelRepo, ModelMapper modelMapper, WebClient.Builder webClientBuilder, EntityDTOConversion entityDTOConversion) {
        this.travelRepo = travelRepo;
        this.modelMapper = modelMapper;
        this.webClientBuilder = webClientBuilder;
        this.entityDTOConversion = entityDTOConversion;
    }

    @Override
    public void saveTravel(TravelDTO travelDTO) {
        WebClient webClient = webClientBuilder.build();

        // Check if the required fields in travelDTO are not null
        if (travelDTO.getUserId() == null || travelDTO.getVehicleId() == null || travelDTO.getHotelId() == null) {
            throw new NotFoundException("Invalid or missing parameters in TravelDTO.");
        }

        // Check user existence
        Boolean isExistUser = webClient
                .get()
                .uri("http://localhost:8081/api/v1/user/userId", builder -> builder.queryParam("userId", travelDTO.getUserId()).build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if (!Boolean.TRUE.equals(isExistUser)) {
            throw new NotFoundException("User is Not Found: " + travelDTO.getUserId());
        }

        // Check vehicle existence
        Boolean isExistVehicle = webClient
                .get()
                .uri("http://localhost:8086/api/v1/vehicle/vehicleId", builder -> builder.queryParam("vehicleId", travelDTO.getVehicleId()).build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if (!Boolean.TRUE.equals(isExistVehicle)) {
            throw new NotFoundException("Vehicle is Not Found: " + travelDTO.getVehicleId());
        }

        // Check hotel existence
        Boolean isExistHotel = webClient
                .get()
                .uri("http://localhost:8084/api/v1/hotel/hotelId", builder -> builder.queryParam("hotelId", travelDTO.getHotelId()).build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if (!Boolean.TRUE.equals(isExistHotel)) {
            throw new NotFoundException("Hotel is Not Found: " + travelDTO.getHotelId());
        }

        // Check guide if needed
        if (guideIsNeeded(travelDTO)) {
            Boolean isExistGuide = webClient
                    .get()
                    .uri("http://localhost:8082/api/v1/guide/guideId", builder -> builder.queryParam("guideId", travelDTO.getGuideId()).build())
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

            if (!Boolean.TRUE.equals(isExistGuide)) {
                throw new NotFoundException("Guide is Not Found: " + travelDTO.getGuideId());
            }
        }

        // Save to the database
        travelRepo.save(modelMapper.map(travelDTO, Travel.class));

        if (!travelRepo.existsById(travelDTO.getPackageId())){
            Travel travel = travelRepo.save(entityDTOConversion.getTravelEntity(travelDTO));
            byte[] base64 = Base64.getEncoder().encodeToString(travelDTO.getUserNIC_images()).getBytes();
            travel.setUserNIC_images(base64);
            travelRepo.save(travel);

        }
    }

    @Override
    public TravelDTO searchTravel(String id) {
        if (travelRepo.existsById(String.valueOf(id))) {
            Travel travel = travelRepo.findById(String.valueOf(id)).get();
            TravelDTO travelDTO = entityDTOConversion.getTravelDTO(travel);
            return travelDTO;
        }
        return null;
    }

    @Override
    public void deleteTravel(String id) {
        if (travelRepo.existsById(String.valueOf(id))) {
            travelRepo.deleteById(String.valueOf(id));
        }
    }

    @Override
    public List<TravelDTO> getAllTravel() {
        List<Travel> all = travelRepo.findAll();
        List<TravelDTO> travelDTOList = modelMapper.map(all, new TypeToken<List<TravelDTO>>() {
        }.getType());
        return travelDTOList;
    }


    @Override
    public void updateTravel(TravelDTO travelDTO, String id) {
        if (travelRepo.existsById(String.valueOf(id))){
            byte[] base64 = Base64.getEncoder().encodeToString(travelDTO.getUserNIC_images()).getBytes();
            entityDTOConversion.getTravelEntity(travelDTO).setUserNIC_images(base64);
            travelRepo.save(entityDTOConversion.getTravelEntity(travelDTO));

        }
    }

    private boolean guideIsNeeded(TravelDTO travelDTO) {
        // For example, check if travelDTO.getGuideId() is not null or another condition.
        return travelDTO.getGuideId() != null;
    }
}

