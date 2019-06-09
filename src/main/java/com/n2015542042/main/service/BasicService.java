package com.n2015542042.main.service;

import com.n2015542042.main.domain.Basic;
import com.n2015542042.main.repository.BasicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicService {

    private final BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    public List<Basic> findAllBasic() {
        return basicRepository.findAll();
    }

    public Basic findByIdxBasic(Long idx) {
        return basicRepository.findById(idx).orElse(new Basic());
    }

    public Basic makeNewBasic(Basic basic) {
        Basic newBasic = basicRepository.save(basic);
        return newBasic;
    }

    public Basic updateBasic(Basic basic) {
        Basic updateBasic = basicRepository.save(basic);
        return updateBasic;
    }

    public void deleteByIdxBasic(Long idx) {
        if (idx == null) System.out.println("idx cannot be null");
        else    basicRepository.deleteById(idx);
    }
}

