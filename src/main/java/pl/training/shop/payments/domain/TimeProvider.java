package pl.training.shop.payments.domain;

import java.time.Instant;

interface TimeProvider {

    Instant getTimestamp();

}
