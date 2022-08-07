package io.github.anantharajuc.springbootrabbitmq.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name="person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@ToString
public class Person extends BaseEntity{

    @Column(name="name", nullable = false)
    String name;

    @Column(name="username", unique=false)
    String username;

    @JsonManagedReference
    @OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="address_id")
    Address address;
}
