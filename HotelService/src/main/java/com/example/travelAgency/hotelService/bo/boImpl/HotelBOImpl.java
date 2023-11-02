package com.example.travelAgency.hotelService.bo.boImpl;

import com.example.travelAgency.hotelService.bo.HotelBO;
import com.example.travelAgency.hotelService.dto.HotelDTO;
import com.example.travelAgency.hotelService.entity.Hotel;
import com.example.travelAgency.hotelService.repository.HotelRepo;
import com.example.travelAgency.hotelService.util.EntityDTOConversion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelBOImpl implements HotelBO {

    ModelMapper modelMapper;


    HotelRepo hotelRepo;


    EntityDTOConversion conversion;

    @Override
    public void saveHotel(HotelDTO hotelDTO) {
        if (!hotelRepo.existsById(hotelDTO.getHotelId())) {
            hotelRepo.save(conversion.getHotelEntity(hotelDTO));
        }
    }

    @Override
    public void updateHotel(HotelDTO hotelDTO) {
        if (hotelRepo.existsById(hotelDTO.getHotelId())) {
            hotelRepo.save(conversion.getHotelEntity(hotelDTO));
        }
    }

    @Override
    public HotelDTO searchHotel(String id) {
        if (hotelRepo.existsById(id)) {
            Hotel hotel = hotelRepo.findById(id).get();
            return conversion.getHotelDTO(hotel);
        }
        return null;
    }

    @Override
    public void deleteHotel(String id) {
        if (hotelRepo.existsById(id)) {
            hotelRepo.deleteById(id);
        }
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return modelMapper.map(hotelRepo.findAll(), new TypeToken<List<HotelDTO>>() {
        }.getType());
    }
}
