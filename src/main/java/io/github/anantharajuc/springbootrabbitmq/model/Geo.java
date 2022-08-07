package io.github.anantharajuc.springbootrabbitmq.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name="geo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Geo extends BaseEntity{

    @Column(name="lat")
    String lat;

    @Column(name="lng")
    String lng;

    @JsonBackReference
    @OneToOne(mappedBy="geo")
    Address address;
}
