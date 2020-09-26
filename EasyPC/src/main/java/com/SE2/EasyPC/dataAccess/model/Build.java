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
    
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBuild;

    @Column
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idMouse")
    private Mouse mouse;

    @ManyToOne
    @JoinColumn(name = "idKeyboard")
    private Keyboard keyboard;

    @ManyToOne
    @JoinColumn(name = "idMonitor")
    private Monitor monitor;

    @ManyToOne
    @JoinColumn(name = "idMotherboard")
    private Motherboard motherboard;

    @ManyToOne
    @JoinColumn(name = "idCPU")
    private CPU cpu;

    @ManyToOne
    @JoinColumn(name = "idGPU")
    private GPU GPU;

    @ManyToOne
    @JoinColumn(name = "idRAM")
    private RAM ram;

    @ManyToOne
    @JoinColumn(name = "idCooling")
    private Cooling cooling;

    @ManyToOne
    @JoinColumn(name = "idSSD")
    private SSD ssd;

    @ManyToOne
    @JoinColumn(name = "idHDD")
    private HDD hdd;

    @ManyToOne
    @JoinColumn(name = "idPowerSupply")
    private PowerSupply powerSupply;

    @ManyToOne
    @JoinColumn(name = "idCase")
    private Case caseObj;
}
