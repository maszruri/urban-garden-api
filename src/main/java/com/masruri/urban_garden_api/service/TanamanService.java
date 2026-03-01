package com.masruri.urban_garden_api.service;

import com.masruri.urban_garden_api.entity.Tanaman;
import com.masruri.urban_garden_api.repository.TanamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TanamanService {
    @Autowired
    private TanamanRepository tanamanRepository;

    public List<Tanaman> ambilSemua() {
        return tanamanRepository.findAll();
    }

    public Tanaman ambil(Integer id){
        return tanamanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tidak ada tanaman dengan ID tersebut"));
    }

    public Tanaman tambah(Tanaman tanaman){
        tanaman.setHidup(true);
        return tanamanRepository.save(tanaman);
    }

    public Tanaman ubah(Integer id, Tanaman tanamanBaru){
        Tanaman tanamanLama = ambil(id);

        tanamanLama.setNamaTanaman(tanamanBaru.getNamaTanaman());
        tanamanLama.setJenisWadah(tanamanBaru.getJenisWadah());
        tanamanLama.setEstimasiPanenHari(tanamanBaru.getEstimasiPanenHari());
        tanamanLama.setHidup(tanamanBaru.getHidup());

        return tanamanRepository.save(tanamanLama);
    }

    public void hapus(Integer id){
        tanamanRepository.deleteById(id);
    }
}
