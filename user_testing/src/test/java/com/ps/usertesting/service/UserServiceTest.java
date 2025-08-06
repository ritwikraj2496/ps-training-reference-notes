package com.ps.usertesting.service;

import com.ps.usertesting.model.User;
import com.ps.usertesting.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testGetUserNameById_returnsUserName_whenUserExists() {
        // 1. Create mock/fake for UserRepository
        UserRepository mockRepo = mock(UserRepository.class);

        // 2. Define mock behavior
        when(mockRepo.findById(1)).thenReturn(new User(1, "Alice"));

        // 3. Inject mock into service //dependency injection
        UserService userService = new UserService(mockRepo);

        // 4. Call and verify
        String result = userService.getUserNameById(1);
        assertEquals("Alice", result);

        // 5. Verify interaction with mock - verifying how many times did you call the method findById()
        verify(mockRepo).findById(1);
    }

    @Test
    void testGetUserNameById_returnsUnknown_whenUserNotFound() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(99)).thenReturn(null);

        UserService userService = new UserService(mockRepo);

        String result = userService.getUserNameById(99);
        assertEquals("Unknown User", result);
    }
}
