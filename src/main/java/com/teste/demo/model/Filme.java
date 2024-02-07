package com.teste.demo.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;



@Table(name = "filme")
@Entity(name = "filme")
@EqualsAndHashCode(of = "id")
public class Filme{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private String tipo;
    private String duration;
    private String categoria;
    private LocalDate data_estreia;
    private String image;

    public Filme(){}

    public Filme(String name, String description, String tipo, String duration, String categoria, LocalDate data_estreia, String image) {
        this.name = name;
        this.description = description;
        this.tipo = tipo;
        this.duration = duration;
        this.categoria = categoria;
        this.data_estreia = data_estreia;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData_estreia() {
        return data_estreia;
    }

    public void setData_estreia(LocalDate data_estreia) {
        this.data_estreia = data_estreia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
