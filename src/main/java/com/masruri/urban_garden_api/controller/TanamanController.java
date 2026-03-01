package com.masruri.urban_garden_api.controller;

import com.masruri.urban_garden_api.entity.Tanaman;
import com.masruri.urban_garden_api.repository.TanamanRepository;
import com.masruri.urban_garden_api.service.TanamanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tanaman")
public class TanamanController {

    @Autowired
    private TanamanService tanamanService;

    @GetMapping
    public List<Tanaman> ambilSemuaTanaman() {
        return tanamanService.ambilSemua();
    }

    @GetMapping("/{id}")
    public Tanaman ambilTanaman(@PathVariable Integer id) {
        return tanamanService.ambil(id);
    }

    @PostMapping
    public Tanaman tambahTanaman(@Valid @RequestBody Tanaman tanaman) {
        return tanamanService.tambah(tanaman);
    }

    @PutMapping("/{id}")
    public Tanaman ubahTanaman(@PathVariable Integer id,@Valid @RequestBody Tanaman tanamanBaru) {
        return tanamanService.ubah(id,tanamanBaru);
    }

    @DeleteMapping("/{id}")
    public String hapusTanaman(@PathVariable Integer id) {
        tanamanService.hapus(id);
        return "Tanaman berhasil dihapus!";
    }

}
