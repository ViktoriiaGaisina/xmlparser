package com.example.xmlparser.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="cast_obce")
public class CastObce {
    @Id
    private String castObceId;
    private Integer kod;
    private String nazev;
    private String obecId;
    private LocalDate platiOd;
    private Long IdTransakce;
    private Long globalniIdNavrhZmeny;
    private String pad2;
    private String pad3;
    private String pad4;
    private String pad5;
    private String pad6;
    private String pad7;
}
