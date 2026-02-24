package com.project.testApp.service;

import com.project.testApp.entity.hibirnate.PersonalOffice;
import com.project.testApp.repository.PersonalOfficeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PersonalService {
    PersonalOfficeRepository personalOfficeRepository;

    public PersonalService(PersonalOfficeRepository personalOfficeRepository) {
        this.personalOfficeRepository = personalOfficeRepository;
    }

    @Transactional
    public PersonalOffice savePerson (PersonalOffice personalOffice) {
        PersonalOffice personalOffice1 = personalOfficeRepository.save(personalOffice); //делает первый коммит
        throw new RuntimeException ("ошибка");
        //return personalOffice1;
    }

    @Transactional
    public void myFirstTransaction () {

    }
}
