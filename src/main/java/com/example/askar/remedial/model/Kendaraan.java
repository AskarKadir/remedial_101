/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.askar.remedial.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author askar
 */
@Entity
@Table(name = "kendaraan")
@NamedQueries({
    @NamedQuery(name = "Kendaraan.findAll", query = "SELECT k FROM Kendaraan k"),
    @NamedQuery(name = "Kendaraan.findById", query = "SELECT k FROM Kendaraan k WHERE k.id = :id"),
    @NamedQuery(name = "Kendaraan.findByNoKen", query = "SELECT k FROM Kendaraan k WHERE k.noKen = :noKen"),
    @NamedQuery(name = "Kendaraan.findByPemilik", query = "SELECT k FROM Kendaraan k WHERE k.pemilik = :pemilik"),
    @NamedQuery(name = "Kendaraan.findByTahun", query = "SELECT k FROM Kendaraan k WHERE k.tahun = :tahun")})
public class Kendaraan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "No_Ken")
    private String noKen;
    @Column(name = "Pemilik")
    private String pemilik;
    @Column(name = "Tahun")
    private String tahun;

    public Kendaraan() {
    }

    public Kendaraan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoKen() {
        return noKen;
    }

    public void setNoKen(String noKen) {
        this.noKen = noKen;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kendaraan)) {
            return false;
        }
        Kendaraan other = (Kendaraan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.askar.remedial.model.Kendaraan[ id=" + id + " ]";
    }
    
}
