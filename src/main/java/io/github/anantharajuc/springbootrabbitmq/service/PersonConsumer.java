package io.github.anantharajuc.springbootrabbitmq.service;

import io.github.anantharajuc.springbootrabbitmq.config.PropertiesConfiguration;
import io.github.anantharajuc.springbootrabbitmq.model.Person;
import io.github.anantharajuc.springbootrabbitmq.model.PersonRequestStatus;
import io.github.anantharajuc.springbootrabbitmq.model.Status;
import io.github.anantharajuc.springbootrabbitmq.repository.PersonRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.UUID;

public class PersonConsumer {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Async
    @RabbitListener(queues = "person_processor")
    public void consumeMessageFromQueue(PersonRequestStatus personRequestStatus) throws InterruptedException {
        System.out.println("Message recieved from queue : " + personRequestStatus);
        String uuid = UUID.randomUUID().toString();
        Person person = personRequestStatus.getPerson();
        person.setUuid(uuid);
        person.getAddress().setUuid(uuid);
        person.getAddress().getGeo().setUuid(uuid);

        //TimeUnit.SECONDS.sleep(1);

        personRepository.save(person);

        PersonRequestStatus personRequestStatusProcessed = new PersonRequestStatus(person, Status.PROCESSED,null);

        rabbitTemplate.convertAndSend(propertiesConfiguration.getExchange(),
                "person_processed",
                personRequestStatusProcessed);

    }
}
