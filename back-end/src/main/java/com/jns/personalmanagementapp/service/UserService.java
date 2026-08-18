package com.jns.personalmanagementapp.service;

import com.jns.personalmanagementapp.dto.UserCreateDTO;
import com.jns.personalmanagementapp.dto.UserResponseDTO;
import com.jns.personalmanagementapp.dto.UserUpdateDTO;
import com.jns.personalmanagementapp.exception.EmailAlreadyExistsException;
import com.jns.personalmanagementapp.exception.UserNotFoundException;
import com.jns.personalmanagementapp.model.User;
import com.jns.personalmanagementapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * This method persist a user into the database.
     */
    public UserResponseDTO create(UserCreateDTO dto){

        if (userRepository.existsByEmail(dto.email())) {
            throw new EmailAlreadyExistsException("Email already exists!");
        }

        User user = new User();

        user.setName(dto.name());
        user.setLastName(dto.lastName());
        user.setPasswordHash(passwordEncoder.encode(dto.password()));
        user.setEmail(dto.email());
        user.setBirthDate(dto.birthDate());

        if (user.getLastName() != null && user.getLastName().isBlank()) user.setLastName(null);
        userRepository.save(user);

        return createUserResponseDTO(user);
    }

    public UserResponseDTO findById(UUID id){

            return userRepository.findById(id)
                    .map(u -> new UserResponseDTO(
                            u.getId(),
                            u.getName(),
                            u.getLastName(),
                            u.getEmail(),
                            u.getBirthDate(),
                            u.getCreatedAt(),
                            u.getIsActive(),
                            u.getDeletedAt()
                    )
            ).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public List<UserResponseDTO> findAll(){

        List<User> users = userRepository.findAll();

        return users.stream().map(
                u ->
                        new UserResponseDTO(
                                u.getId(),
                                u.getName(),
                                u.getLastName(),
                                u.getEmail(),
                                u.getBirthDate(),
                                u.getCreatedAt(),
                                u.getIsActive(),
                                u.getDeletedAt())).toList();
    }

    public UserResponseDTO update(UUID id, UserUpdateDTO dto){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (dto.email() != null && !dto.email().isBlank()) {
            if (userRepository.existsByEmailAndIdNot(dto.email(), id)) {
                throw new EmailAlreadyExistsException("Email already exists!");
            }
            user.setEmail(dto.email());
        }
        if (dto.name() != null && !dto.name().isBlank()) user.setName(dto.name());
        // lastName: Is possible to be null because the database doesn't constraint it
        if (dto.lastName() != null && !dto.lastName().isBlank()) user.setLastName(dto.lastName());
        if (dto.birthDate() != null) user.setBirthDate(dto.birthDate());

        if (dto.password() != null && !dto.password().isBlank()) {
            user.setPasswordHash(passwordEncoder.encode(dto.password())
            );

        }
        userRepository.save(user);

        return  createUserResponseDTO(user);

    }

    public Boolean deleteById(UUID id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User doesn't exist"));

        user.setActive(false);
        user.setDeletedAt(LocalDateTime.now());

        userRepository.save(user);
        return true;

    }

    private UserResponseDTO createUserResponseDTO(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getBirthDate(),
                user.getCreatedAt(),
                user.getIsActive(),
                user.getDeletedAt());
    }
}
