package com.praca.manager.service;

import com.praca.manager.entity.Details;
import com.praca.manager.repository.DetailsRepository;
import com.praca.manager.repository.IDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DetailsService implements IDetailsService {

    private DetailsRepository detailsRepository;

    public DetailsService(DetailsRepository detailsRepository){
        this.detailsRepository = detailsRepository;
    }

    public void saveDetails(Details details){
        detailsRepository.save(details);
    }

    public void deleteDetails(Integer id){
        detailsRepository.deleteById(id);
    }

    public Details getDetails(Integer id){

        return detailsRepository.findById(id).get();
    }

    @Override
    public List<Details> findByCustomerId(int id) {
        var customerDetails = (List<Details>) detailsRepository.findByCustomerId(id);

        return customerDetails;
    }
}