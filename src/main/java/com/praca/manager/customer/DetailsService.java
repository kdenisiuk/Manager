package com.praca.manager.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DetailsService implements IDetailsService {

    @Autowired
    private DetailsRepository detailsRepository;

    public List<Details> listAll(){
        return detailsRepository.findAll();
    }

    public void saveDetails(Details details){
        detailsRepository.save(details);
    }

    public Details getDetails(Integer id){
        return detailsRepository.findById(id).get();
    }

    public void deleteDetails(Integer id){
        detailsRepository.deleteById(id);
    }

    @Override
    public List<Details> findByCustomerId(int id) {
        var customerDetails = (List<Details>) detailsRepository.findByCustomerId(id);
        return customerDetails;
    }
}