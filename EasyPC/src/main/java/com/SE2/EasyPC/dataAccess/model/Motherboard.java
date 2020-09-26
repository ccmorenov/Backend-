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
    
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMotherboard;

    @Column
    private String model;

    @Column
    private Float power;

    @Column
    private String priceSL;
    
    @Column
    private String priceTauret;

    @Column
    private String priceCyP;

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

    public String getPriceSL() {
        return priceSL;
    }

    public void setPriceSL(String priceSL) {
        this.priceSL = priceSL;
    }

    public String getPriceTauret() {
        return priceTauret;
    }

    public void setPriceTauret(String priceTauret) {
        this.priceTauret = priceTauret;
    }

    public String getPriceCyP() {
        return priceCyP;
    }

    public void setPriceCyP(String priceCyP) {
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
