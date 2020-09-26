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
    private Integer idBuild;

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
}
