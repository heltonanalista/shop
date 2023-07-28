package com.bike.shop.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bike")
public class BikeModel implements Comparable<BikeModel> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private String year;
    @Column(name = "color")
    private String color;
    @Column(name = "price")
    private Double price;
    @Enumerated(EnumType.STRING)
    private bikeType bikeType;


    @Override
    public int compareTo(BikeModel bikeModel) {
        if (this.price < bikeModel.price) {
            return -1;
        }
        if (this.price > bikeModel.price) {
            return 1;
        }
        return 0;

    }


}