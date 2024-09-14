package com.school.service;

import com.school.dto.SchoolDto;
import com.school.entity.SchoolEntity;
import com.school.repository.SchoolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService{

    private SchoolRepository schoolRepository;
    private ModelMapper modelMapper;

    public SchoolServiceImpl(SchoolRepository schoolRepository, ModelMapper modelMapper) {
        this.schoolRepository = schoolRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SchoolDto addStudent(SchoolDto dto) {
        SchoolEntity entity = modelMapper.map(dto, SchoolEntity.class);
        SchoolEntity saved = schoolRepository.save(entity);
        SchoolDto schoolDto = modelMapper.map(saved, SchoolDto.class);
        return schoolDto;
    }

    @Override
    public    List<SchoolEntity> getStudents() {
       return schoolRepository.findAll();

    }

    @Override
    public SchoolEntity getStudentById(Long id) {
       return schoolRepository.findById(id).get();
    }

    @Override
    public SchoolDto updataStudent(SchoolDto dto,long id) {
        Optional<SchoolEntity> byId = schoolRepository.findById(id);
        SchoolEntity schoolEntity = byId.get();
//        SchoolEntity saved = schoolRepository.save(schoolEntity);
//        SchoolDto schoolDto = modelMapper.map(saved, SchoolDto.class);
//        return schoolDto;

        schoolEntity.setName(dto.getName());
        schoolEntity.setGmail(dto.getGmail());
        schoolEntity.setStanderd(dto.getStanderd());
        SchoolEntity saved = schoolRepository.save(schoolEntity);

        SchoolDto sd=new SchoolDto();
        sd.setId(saved.getId());
        sd.setName(saved.getName());
        sd.setGmail(saved.getGmail());
        sd.setStanderd(saved.getStanderd());
        return sd;
    }

    @Override
    public void  deleteStudent(Long id) {
         schoolRepository.deleteById(id);

    }


}
