package br.com.playground.repository;

import br.com.playground.model.User;
import br.com.playground.repository.generic.BaseRepositoryImpl;

import java.util.UUID;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, UUID> implements UserRepository {
    public UserRepositoryImpl() {
        super(User.class);
    }
}
