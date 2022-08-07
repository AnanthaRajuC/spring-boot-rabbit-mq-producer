package io.github.anantharajuc.springbootrabbitmq.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level= AccessLevel.PRIVATE)
public class PersonRequestStatus {
    Person person;
    @Enumerated(EnumType.STRING)
    Status status;
    String uui;
}
