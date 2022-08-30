package br.com.playground.repository;

import br.com.playground.model.User;

public interface UserRepository {
    User get(Long id);
}
