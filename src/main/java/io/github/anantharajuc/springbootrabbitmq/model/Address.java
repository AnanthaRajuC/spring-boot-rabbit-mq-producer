package io.github.anantharajuc.springbootrabbitmq.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name="address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@ToString
public class Address extends BaseEntity{

    @Column(name="street", nullable=true)
    String street;

    @Column(name="suite", nullable=true)
    String suite;

    @Column(name="city", nullable=true)
    String city;

    @Column(name="zipcode", nullable=true)
    String zipcode;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="geo_id")
    Geo geo;

    @JsonBackReference
    @OneToOne(mappedBy="address")
    Person person;
}
