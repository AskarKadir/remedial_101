/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.askar.remedial.Controller;

import JPAController.KendaraanJpaController;
import com.example.askar.remedial.model.Kendaraan;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author askar
 */
@RestController
@CrossOrigin
@RequestMapping("/kendaraan")
public class MyContoller {

    Kendaraan kendaraan = new Kendaraan();

    KendaraanJpaController ctrl = new KendaraanJpaController();

    List<Kendaraan> data = new ArrayList<>();

    @GetMapping
    public List<Kendaraan> getData() {
        try {
            return ctrl.findKendaraanEntities();
        } catch (Exception e) {
            return null;
        }
    }

    //get mapping id
    @GetMapping("/{id}")
    public List<Kendaraan> getPendudukEntities(@PathVariable("id") int id) {
        try {
            kendaraan = ctrl.findKendaraan(id);
            data.clear();
            data.add(kendaraan);
            return data;
        } catch (Exception e) {
        }
        return List.of();
    }

    //post mapping
    @PostMapping
    public String insertData(HttpEntity<String> requestdata
    ) {
        String pesan = "Data berhasil ditambahkan";
        try {
            String json_receive = requestdata.getBody();
            ObjectMapper map = new ObjectMapper();
            kendaraan = map.readValue(json_receive, Kendaraan.class);
            ctrl.create(kendaraan);
        } catch (Exception e) {
            pesan = "Data gagal ditambahkan. Eror + " + e;
        }
        return pesan;
    }

    @PutMapping
    public String updateData(HttpEntity<String> requestdata
    ) {
        String pesan = "Data telah diperbaharui";
        try {
            String json_receive = requestdata.getBody();
            ObjectMapper map = new ObjectMapper();
            kendaraan = map.readValue(json_receive, Kendaraan.class);
            ctrl.edit(kendaraan);
        } catch (Exception e) {
            pesan = "Data gagal diperbaharui. Eror : + " + e;
        }
        return pesan;
    }

    @DeleteMapping
    public String deleteData(HttpEntity<String> requestdata) {
        String pesan = "Data telah dihapus";
        try {
            String json_receive = requestdata.getBody();
            ObjectMapper map = new ObjectMapper();
            kendaraan = map.readValue(json_receive,Kendaraan.class);
            ctrl.destroy(kendaraan.getId());
        } catch (Exception e) {
            pesan = "Data gagal dihapus. Eror : " + e;
        }
        return pesan;
    }
}
