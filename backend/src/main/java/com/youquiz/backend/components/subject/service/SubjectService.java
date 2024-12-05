package com.youquiz.backend.components.subject.service;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.subject.dto.request.CreateSubjectDTO;
import com.youquiz.backend.components.subject.dto.request.UpdateSubjectDTO;
import com.youquiz.backend.components.subject.dto.response.SubjectResponseDTO;
import com.youquiz.backend.components.subject.mapper.SubjectMapper;
import com.youquiz.backend.components.subject.repository.SubjectRepository;
import com.youquiz.backend.entities.Subject;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SubjectService extends EntityServiceImpl<Subject, Long, CreateSubjectDTO, UpdateSubjectDTO, SubjectResponseDTO> {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectService(
            SubjectRepository subjectRepository,
            SubjectMapper subjectMapper,
            ApplicationContext applicationContext) {
        super(subjectRepository, subjectMapper, applicationContext);
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }
}