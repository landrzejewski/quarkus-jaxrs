package pl.training.shop.payments.domain;

import java.time.Instant;

class SystemTimeProvider implements TimeProvider {

    @Override
    public Instant getTimestamp() {
        return Instant.now();
    }

}
