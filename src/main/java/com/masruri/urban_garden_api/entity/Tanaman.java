package com.masruri.urban_garden_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tanaman")
public class Tanaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nama tanaman wajib diisi!")
    @Column(name = "nama_tanaman")
    private String namaTanaman;

    @NotBlank(message = "Jenis wadah tidak boleh kosong!")
    @Column(name = "jenis_wadah")
    private String jenisWadah;

    @Min(value = 0, message = "Estimasi hari panen tidak boleh minus!")
    @NotNull(message = "Estimasi panen wajib diisi!")
    @Column(name = "estimasi_panen_hari")
    private Integer estimasiPanenHari;

    private Boolean isHidup;

    public Tanaman(){}

    public Tanaman(String namaTanaman, String jenisWadah, Integer estimasiPanenHari, Boolean isHidup) {
        this.namaTanaman = namaTanaman;
        this.jenisWadah = jenisWadah;
        this.estimasiPanenHari = estimasiPanenHari;
        this.isHidup = isHidup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaTanaman() {
        return namaTanaman;
    }

    public void setNamaTanaman(String namaTanaman) {
        this.namaTanaman = namaTanaman;
    }

    public String getJenisWadah() {
        return jenisWadah;
    }

    public void setJenisWadah(String jenisWadah) {
        this.jenisWadah = jenisWadah;
    }

    public Integer getEstimasiPanenHari() {
        return estimasiPanenHari;
    }

    public void setEstimasiPanenHari(Integer estimasiPanenHari) {
        this.estimasiPanenHari = estimasiPanenHari;
    }

    public Boolean getHidup() {
        return isHidup;
    }

    public void setHidup(Boolean hidup) {
        isHidup = hidup;
    }
}
