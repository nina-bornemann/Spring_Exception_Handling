package de.neuefische.springexceptionhandlingtask;

import java.time.Instant;

public record ErrorMessage(String errorMessage, Instant instant) {
}
