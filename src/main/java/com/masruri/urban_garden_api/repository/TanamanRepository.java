package com.masruri.urban_garden_api.repository;

import com.masruri.urban_garden_api.entity.Tanaman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TanamanRepository extends JpaRepository<Tanaman, Integer> {

    List<Tanaman> findByJenisWadah(String jenisWadah);

    List<Tanaman> findByHidupTrue();
}
