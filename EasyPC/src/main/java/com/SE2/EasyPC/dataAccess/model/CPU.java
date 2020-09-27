package com.SE2.EasyPC.dataAccess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Column;

@Entity
@Table( name = "CPU" )
public class CPU {
    
    @Column(name = "id_cpu")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCPU;

    @Column
    private String model;

    @Column
    private Float power;

    @Column
    private Integer cores;

    @Column
    private Float speed;

    @Column(name = "price_sl")
    private Integer priceSL;
    @Column(name = "price_tauret")
    private Integer priceTauret;
    @Column(name = "price_cyp")
    private Integer priceCyP;
    @Column(name = "link_sl")
    private String linkSL;
    @Column(name = "link_tauret")
    private String linkTauret;
    @Column(name = "link_cyp")
    private String linkCyP;
    @Column(name = "link_picture")
    private String linkPicture;

    @JsonIgnore
    @ManyToMany(mappedBy = "compatibleCPU")
    private List<Motherboard> compatibleMotherboard;

    public Long getIdCPU() {
        return idCPU;
    }

    public void setIdCPU(Long idCPU) {
        this.idCPU = idCPU;
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

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
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

    public String getLinkPicture() {
        return linkPicture;
    }

    public void setLinkPicture(String linkPicture) {
        this.linkPicture = linkPicture;
    }

    public List<Motherboard> getCompatibleMotherboard() {
        return compatibleMotherboard;
    }

    public void setCompatibleMotherboard(List<Motherboard> compatibleMotherboard) {
        this.compatibleMotherboard = compatibleMotherboard;
    }

    

}
