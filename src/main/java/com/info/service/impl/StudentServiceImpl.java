package com.info.service.impl;

import com.info.entities.IdProof;
import com.info.entities.Student;

import com.info.payload.StudentDTO;
import com.info.repository.IdProofRepository;
import com.info.repository.StudentRepository;
import com.info.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private IdProofRepository idproofRepository;

    @Override
    public StudentDTO saveStudent(StudentDTO studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setCourse(studentDto.getCourse());
        student.setFee(studentDto.getFee());

        IdProof idproof = new IdProof();
        idproof.setPancardnumber(studentDto.getIdProof().getPancardnumber());
        idproofRepository.save(idproof);

        student.setIdProof(idproof);
        student = studentRepository.save(student);

        studentDto.setId(student.getId());
        return studentDto;
    }



}
