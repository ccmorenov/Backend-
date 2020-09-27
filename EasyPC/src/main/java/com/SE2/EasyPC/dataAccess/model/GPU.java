package com.SE2.EasyPC.dataAccess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table( name = "GPU" )
public class GPU {
    
    @Column(name = "id_gpu")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGPU;

    @Column
    private String model;

    @Column
    private Float power;

    @Column
    private Integer memory;

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

    public Long getIdGPU() {
        return idGPU;
    }

    public void setIdGPU(Long idGPU) {
        this.idGPU = idGPU;
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
    
}
