package br.com.playground.repository;

import br.com.playground.model.User;
import br.com.playground.repository.generic.BaseRepository;

import java.util.UUID;

public interface UserRepository extends BaseRepository<User, UUID> {

}
