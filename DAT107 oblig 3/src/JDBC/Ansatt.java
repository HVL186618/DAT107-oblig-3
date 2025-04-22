package JDBC;

import jakarta.persistence.*;
import java.sql.Timestamp;

import filiptest.Avdeling;

@Entity
@Table(name = "Ansatt", schema = "SchemaAnsatt")
public class Ansatt {
	/*
    @Id
    @Column(name = "ansattID", length = 40)
    private String id;
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ansattID")
    private int id;

    @Column(name = "brukernavn", length = 4, nullable = false)
    private String brukernavn;

    @Column(name = "fornavn", length = 30)
    private String fornavn;

    @Column(name = "etternavn", length = 20)
    private String etternavn;

    @Column(name = "dato")
    private Timestamp dato;

    @Column(name = "stilling", length = 15)
    private String stilling;

    @Column(name = "månedslønn", length = 30)
    private String månedslønn;

    @Column(name = "prosjekter", length = 30)
    private String prosjekter;

//    @ManyToOne
  //  @JoinColumn(name = "avdelingid", referencedColumnName = "avdelingid")
   // private Avdeling avdeling;

    public Ansatt() {}

    public Ansatt(Integer id, String brukernavn, String fornavn, String etternavn, Timestamp dato,
                  String stilling, String månedslønn, Avdeling avdeling, String prosjekter) {
        this.id = id;
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.dato = dato;
        this.stilling = stilling;
        this.månedslønn = månedslønn;
       // this.avdeling = avdeling;
        this.prosjekter = prosjekter;
    }

    /* brukes ikke lengre */
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getBrukernavn() { return brukernavn; }
    public void setBrukernavn(String brukernavn) { this.brukernavn = brukernavn; }

    public String getFornavn() { return fornavn; }
    public void setFornavn(String fornavn) { this.fornavn = fornavn; }

    public String getEtternavn() { return etternavn; }
    public void setEtternavn(String etternavn) { this.etternavn = etternavn; }

    public Timestamp getDato() { return dato; }
    public void setDato(Timestamp dato) { this.dato = dato; }

    public String getStilling() { return stilling; }
    public void setStilling(String stilling) { this.stilling = stilling; }

    public String getMånedslønn() { return månedslønn; }
    public void setMånedslønn(String månedslønn) { this.månedslønn = månedslønn; }

    //public Avdeling getAvdeling() { return avdeling; }
    //public void setAvdeling(Avdeling avdeling) { this.avdeling = avdeling; }

    public String getProsjekter() { return prosjekter; }
    public void setProsjekter(String prosjekter) { this.prosjekter = prosjekter; }

   
}
