package com.SE2.EasyPC.dataAccess.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;

@Entity
@Table( name = "Motherboard" )
public class Motherboard {
    
    @Column(name="id_motherboard")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMotherboard;

    @Column(name="model")
    private String model;

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
    @Column(name = "link_benchmark")
    private String linkBenchmark;
    @Column(name="power")
    private Float power;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "CompatibleRAM", joinColumns = {@JoinColumn(name = "idMotherboard")},
    inverseJoinColumns = {@JoinColumn(name = "idRAM")})
    private List<RAM> compatibleRAM;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "CompatibleCPU", joinColumns = {@JoinColumn(name = "idMotherboard")},
    inverseJoinColumns = {@JoinColumn(name = "idCPU")})
    private List<RAM> compatibleCPU;

    public Integer getIdMotherboard() {
        return idMotherboard;
    }

    public void setIdMotherboard(Integer idMotherboard) {
        this.idMotherboard = idMotherboard;
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

    public List<RAM> getCompatibleRAM() {
        return compatibleRAM;
    }

    public void setCompatibleRAM(List<RAM> compatibleRAM) {
        this.compatibleRAM = compatibleRAM;
    }

    public List<RAM> getCompatibleCPU() {
        return compatibleCPU;
    }

    public void setCompatibleCPU(List<RAM> compatibleCPU) {
        this.compatibleCPU = compatibleCPU;
    }

}
