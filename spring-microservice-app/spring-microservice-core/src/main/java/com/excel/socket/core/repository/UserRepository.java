package com.excel.socket.core.repository;

import com.excel.socket.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
