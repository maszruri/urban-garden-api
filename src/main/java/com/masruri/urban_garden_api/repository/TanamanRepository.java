package com.masruri.urban_garden_api.repository;

import com.masruri.urban_garden_api.entity.Tanaman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TanamanRepository extends JpaRepository<Tanaman, Integer> {
}
