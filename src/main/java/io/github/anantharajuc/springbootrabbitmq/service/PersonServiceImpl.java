package io.github.anantharajuc.springbootrabbitmq.service;

import io.github.anantharajuc.springbootrabbitmq.config.PropertiesConfiguration;
import io.github.anantharajuc.springbootrabbitmq.model.Person;
import io.github.anantharajuc.springbootrabbitmq.model.PersonRequestStatus;
import io.github.anantharajuc.springbootrabbitmq.model.Status;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service()
@Log4j2
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Async
    @Override
    public void createPerson(Person person) {
        PersonRequestStatus personRequestStatus = new PersonRequestStatus(person, Status.UNPROCESSED,null);
        rabbitTemplate.convertAndSend(propertiesConfiguration.getExchange(),
                                      propertiesConfiguration.getRoutingKey(),
                                      personRequestStatus);
    }
}
