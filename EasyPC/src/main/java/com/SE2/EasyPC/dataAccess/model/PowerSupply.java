package com.SE2.EasyPC.dataAccess.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name="PowerSupply")
public class PowerSupply {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPowerSupply;

    @Column
    private String model;
    @Column
    private Float maxPower;
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
    private String linkPicture;

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

    public Integer getIdPowerSupply() {
        return idPowerSupply;
    }

    public void setIdPowerSupply(Integer idPowerSupply) {
        this.idPowerSupply = idPowerSupply;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(Float maxPower) {
        this.maxPower = maxPower;
    }
}
