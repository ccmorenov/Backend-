package com.SE2.EasyPC.dataAccess.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name="SSD")
public class SSD {
    @Column(name = "id_ssd")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSSD;
	@Column(name = "model")
    private String model;
    @Column(name = "power")
    private Float power;
    @Column(name = "memory")
    private Integer memory;
    @Column(name = "speed")
    private String speed;
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

	public Long getIdSSD() {
		return idSSD;
	}

	public void setIdSSD(Long idSSD) {
		this.idSSD = idSSD;
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

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getLinkBenchmark() {
		return linkBenchmark;
	}

	public void setLinkBenchmark(String linkBenchmark) {
		this.linkBenchmark = linkBenchmark;
	}
}
