package com.praca.manager.repository;

import com.praca.manager.entity.Details;

import java.util.List;

public interface IDetailsService {

    List<Details> findByCustomerId(int id);
}