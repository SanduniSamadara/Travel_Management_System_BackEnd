package com.example.travelAgency.guideService.bo.boImpl;

import com.example.travelAgency.guideService.bo.GuideBO;
import com.example.travelAgency.guideService.bo.exception.AlreadyExistException;
import com.example.travelAgency.guideService.bo.exception.NotFoundException;
import com.example.travelAgency.guideService.dto.GuideDTO;
import com.example.travelAgency.guideService.dto.ResponseDTO;
import com.example.travelAgency.guideService.entity.Guide;
import com.example.travelAgency.guideService.repository.GuideRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuideBOImpl implements GuideBO {
    private final ModelMapper mapper;
    private final GuideRepo repository;

    @Autowired
    public GuideBOImpl(ModelMapper mapper, GuideRepo repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public void updateGuide(GuideDTO guideDTO) {
        Guide guideEntity = mapper.map(guideDTO, Guide.class);
        if (repository.findByGuideName(guideDTO.getName()) == null) {
            throw new NotFoundException("Guide Name Not Found. Guide Name is +" + guideDTO.getName());
        } else {
            /*String imgBase64 = Base64.getEncoder().encodeToString(guideDTO.getGuide_id_image_front_view().getBytes());
            guideEntity.getGuide_id_image_front_view(imgBase64);*/
        }
    }


    public GuideDTO searchGuide(String id) {
        return null;
    }

    public void deleteGuide(String name) {
        Guide byName = mapper.map(name, Guide.class);
        if (byName==null){
            throw new NotFoundException("Guide Id is not Found.Guide Id is"+name);
        }else {
            repository.delete(byName);
        }

    }

    public List<ResponseDTO> getAllGuides() {
        return mapper.map(repository.findAll(),new TypeToken<List<ResponseDTO>>(){
        }.getType());
    }

    @Override
    public boolean isExistGuideByGuideName(String name) {
        return repository.existsByGuideName(name);
    }

    @Override
    public void saveGuide(GuideDTO guideDTO) {
        Guide guideEntity = mapper.map(guideDTO, Guide.class);
        if (repository.findByGuideName(guideDTO.getName()) != null) {
            throw new AlreadyExistException("Guide Name Already Exists. Guide Name is +" + guideDTO.getName());
        } else {
            /*String imgBase64 = Base64.getEncoder().encodeToString(guideDTO.getGuide_id_image_front_view().getBytes());
            guideEntity.getGuide_id_image_front_view(imgBase64);*/
        }
    }

   /* private Guide mapToGuide(Guide guide) {
        return Guide.builder()
                .guideId(guide.getGuideId())
                .name(guide.getName())
                .address(guide.getAddress())
                .experience(guide.getAddress())
                .gender(guide.getGender())
                .remarks(guide.getRemarks())
                .contact(guide.getContact())
                .manDayValues(guide.getManDayValues())
                .build();

    }*/
}


