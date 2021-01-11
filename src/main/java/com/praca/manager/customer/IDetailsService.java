package com.praca.manager.customer;

import java.util.List;

public interface IDetailsService {

    List<Details> findByCustomerId(int id);
}