package com.example.guacnroll.repository;

import com.example.guacnroll.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping, Long> {
    List<Topping> findByCategory(String category);
}