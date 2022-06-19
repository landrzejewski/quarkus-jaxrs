package pl.training.shop.payments.adapters.generator;

import pl.training.shop.payments.ports.output.IdGenerator;

import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class UuidGenerator implements IdGenerator {

    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }

}
