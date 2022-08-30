package br.com.playground.model;

import java.util.UUID;

public record User(UUID id, String name, Double salary) {
}
