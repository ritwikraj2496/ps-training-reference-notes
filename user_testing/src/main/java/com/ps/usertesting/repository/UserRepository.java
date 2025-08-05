package com.ps.usertesting.repository;

import com.ps.usertesting.model.User;

public interface UserRepository {
    User findById(int id);
}
