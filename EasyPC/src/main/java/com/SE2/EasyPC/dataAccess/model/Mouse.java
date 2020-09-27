package com.SE2.EasyPC.dataAccess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table( name = "Mouse" )
public class Mouse {
    
    @Column(name="id_mouse")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMouse;

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

    public Long getIdMouse() {
        return idMouse;
    }

    public void setIdMouse(Long idMouse) {
        this.idMouse = idMouse;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
    
}
