package com.project.testApp.service;

import com.project.testApp.entity.hibirnate.PersonalOffice;
import com.project.testApp.repository.PersonalOfficeRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalService {
    PersonalOfficeRepository personalOfficeRepository;

    public PersonalService(PersonalOfficeRepository personalOfficeRepository) {
        this.personalOfficeRepository = personalOfficeRepository;
    }

    public PersonalOffice savePerson (PersonalOffice personalOffice) {
        PersonalOffice personalOffice1 = personalOfficeRepository.save(personalOffice);
        return personalOffice1;
    }
}
