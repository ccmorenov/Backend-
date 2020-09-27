package com.SE2.EasyPC.dataAccess.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Build" )
public class Build {
    
    @Column(name = "id_build")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBuild;

    @Column
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_mouse")
    private Mouse mouse;

    @ManyToOne
    @JoinColumn(name = "id_keyboard")
    private Keyboard keyboard;

    @ManyToOne
    @JoinColumn(name = "id_monitor")
    private Monitor monitor;

    @ManyToOne
    @JoinColumn(name = "id_motherboard")
    private Motherboard motherboard;

    @ManyToOne
    @JoinColumn(name = "id_cpu")
    private CPU cpu;

    @ManyToOne
    @JoinColumn(name = "id_gpu")
    private GPU GPU;

    @ManyToOne
    @JoinColumn(name = "id_ram")
    private RAM ram;

    @ManyToOne
    @JoinColumn(name = "id_cooling")
    private Cooling cooling;

    @ManyToOne
    @JoinColumn(name = "id_ssd")
    private SSD ssd;

    @ManyToOne
    @JoinColumn(name = "id_hdd")
    private HDD hdd;

    @ManyToOne
    @JoinColumn(name = "id_powersupply")
    private PowerSupply powerSupply;

    @ManyToOne
    @JoinColumn(name = "id_case")
    private Case caseObj;

    public Long getIdBuild() {
        return idBuild;
    }

    public void setIdBuild(Long idBuild) {
        this.idBuild = idBuild;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGPU() {
        return GPU;
    }

    public void setGPU(GPU gPU) {
        GPU = gPU;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Cooling getCooling() {
        return cooling;
    }

    public void setCooling(Cooling cooling) {
        this.cooling = cooling;
    }

    public SSD getSsd() {
        return ssd;
    }

    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Case getCaseObj() {
        return caseObj;
    }

    public void setCaseObj(Case caseObj) {
        this.caseObj = caseObj;
    }
}
