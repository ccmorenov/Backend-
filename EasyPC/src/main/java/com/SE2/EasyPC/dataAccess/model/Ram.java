package com.SE2.EasyPC.dataAccess.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ManyToMany;


@Entity
@Table(name = "RAM")
public class RAM {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idRAM;

    @Column
    private String model;

    @Column
    private Float power;

    @Column
    private Integer memory;

    @Column
    private Float speed;

    @Column
    private Integer priceSL;

    @Column
    private Integer priceTauret;

    @Column
    private Integer priceCyP;

    @Column
    private String linkSL;

    @Column
    private String linkTauret;

    @Column
    private String linkCyP;

    @Column
    private String linkBenchmark;

    @Column
    private String linkPicture;

    @JsonIgnore
    @ManyToMany(mappedBy = "compatibleRAM")
    private List<Motherboard> compatibleMotherboard;

    public Integer getIdRam() {
        return idRAM;
    }

    public void setIdRam(Integer idRam) {
        this.idRAM = idRam;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getPriceSL() {
        return priceSL;
    }

    public void setPriceSL(Integer priceSL) {
        this.priceSL = priceSL;
    }

    public Integer getPriceTauret() {
        return priceTauret;
    }

    public void setPriceTauret(Integer priceTauret) {
        this.priceTauret = priceTauret;
    }

    public Integer getPriceCyP() {
        return priceCyP;
    }

    public void setPriceCyP(Integer priceCyP) {
        this.priceCyP = priceCyP;
    }

    public String getLinkSL() {
        return linkSL;
    }

    public void setLinkSL(String linkSL) {
        this.linkSL = linkSL;
    }

    public String getLinkTauret() {
        return linkTauret;
    }

    public void setLinkTauret(String linkTauret) {
        this.linkTauret = linkTauret;
    }

    public String getLinkCyP() {
        return linkCyP;
    }

    public void setLinkCyP(String linkCyP) {
        this.linkCyP = linkCyP;
    }

    public String getLinkBenchmark() {
        return linkBenchmark;
    }

    public void setLinkBenchmark(String linkBenchmark) {
        this.linkBenchmark = linkBenchmark;
    }

    public String getLinkPicture() {
        return linkPicture;
    }

    public void setLinkPicture(String linkPicture) {
        this.linkPicture = linkPicture;
    }
}
