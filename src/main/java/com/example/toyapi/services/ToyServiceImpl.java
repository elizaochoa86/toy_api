package com.example.toyapi.services;

import com.example.toyapi.dao.ToyRepository;
import com.example.toyapi.entities.Toy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToyServiceImpl implements ToyService {

    private ToyRepository toyRepository;

    public ToyServiceImpl(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    @Transactional
    @Override
    public List<Toy> findAll() {
        List<Toy> toys = new ArrayList<>();
        Iterable<Toy> toyRepositoryAll = toyRepository.findAll();
        for (Toy toy : toyRepositoryAll) {
            toys.add(toy);
        }
        return toys;
    }

    @Transactional
    @Override
    public Optional<Toy> findById(int id) {
        return toyRepository.findById(id);
    }

    @Transactional
    @Override
    public void save(Toy toy) {
        toyRepository.save(toy);
    }

    @Transactional
    @Override
    public void update(Toy toy) {
        toyRepository.save(toy);
    }

    @Transactional
    @Override
    public void delete(int id) {
        toyRepository.deleteById(id);

    }
}
