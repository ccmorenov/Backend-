package com.SE2.EasyPC.dataAccess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table( name = "Monitor" )
public class Monitor {
    
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMonitor;

    @Column
    private String model;

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
    private String linkPicture;

    public Integer getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(Integer idMonitor) {
        this.idMonitor = idMonitor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getLinkPicture() {
        return linkPicture;
    }

    public void setLinkPicture(String linkPicture) {
        this.linkPicture = linkPicture;
    }

}
