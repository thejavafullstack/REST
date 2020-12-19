package com.thejavafullstack.Covid19ProfileRestProducer;

import com.thejavafullstack.Covid19ProfileRestProducer.dao.Covid19ProfileDto;
import com.thejavafullstack.Covid19ProfileRestProducer.dao.Covid19ProfilerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class RepoRunner  implements CommandLineRunner {
    @Autowired
    private Covid19ProfilerRepo covid19ProfilerRepo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        //Initialize our Repo with some dummy values for 3 country profiles to kickstart our API

        Covid19ProfileDto covid19ProfileDto = new Covid19ProfileDto();
        covid19ProfileDto.setCountryName("SA");
        covid19ProfileDto.setNumberOfCases(1000);
        covid19ProfileDto.setNumberOfDeaths(100);
        covid19ProfileDto.setNumberOfRecoveries(900);
        covid19ProfilerRepo.save(covid19ProfileDto);

        Covid19ProfileDto covid19ProfileDto2 = new Covid19ProfileDto();
        covid19ProfileDto2.setCountryName("India");
        covid19ProfileDto2.setNumberOfCases(3000);
        covid19ProfileDto2.setNumberOfDeaths(1000);
        covid19ProfileDto2.setNumberOfRecoveries(4000);
        covid19ProfilerRepo.save(covid19ProfileDto2);

        Covid19ProfileDto covid19ProfileDto3 = new Covid19ProfileDto();
        covid19ProfileDto3.setCountryName("USA");
        covid19ProfileDto3.setNumberOfCases(9000);
        covid19ProfileDto3.setNumberOfDeaths(2000);
        covid19ProfileDto3.setNumberOfRecoveries(7000);
        covid19ProfilerRepo.save(covid19ProfileDto3);

    }
}
