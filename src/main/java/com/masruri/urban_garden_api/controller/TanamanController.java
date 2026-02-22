package com.masruri.urban_garden_api.controller;

import com.masruri.urban_garden_api.entity.Tanaman;
import com.masruri.urban_garden_api.repository.TanamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/tanaman")
public class TanamanController {

    @Autowired
    private TanamanRepository tanamanRepository;

    @GetMapping
    public List<Tanaman> ambilSemuaTanaman() {
        return tanamanRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tanaman ambilTanaman(@PathVariable Integer id) {
        return tanamanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Waduh, tanaman dengan ID " + id + " tidak ditemukan!"));
    }

    @PostMapping
    public Tanaman tambahTanaman(@RequestBody Tanaman tanaman) {
        return tanamanRepository.save(tanaman);
    }

    @PutMapping("/{id}")
    public Tanaman ubahTanaman(@PathVariable Integer id, @RequestBody Tanaman tanamanBaru) {
        Tanaman tanamanLama = tanamanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gagal update! Tanaman ID " + id + " tidak ada."));;
        tanamanLama.setNamaTanaman(tanamanBaru.getNamaTanaman());
        tanamanLama.setJenisWadah(tanamanBaru.getJenisWadah());
        tanamanLama.setEstimasiPanenHari(tanamanBaru.getEstimasiPanenHari());
        tanamanLama.setHidup(tanamanBaru.getHidup());
        return tanamanRepository.save(tanamanLama);
    }

    @DeleteMapping("/{id}")
    public String hapusTanaman(@PathVariable Integer id) {
        tanamanRepository.deleteById(id);
        return "Tanaman berhasil dihapus!";
    }

}
