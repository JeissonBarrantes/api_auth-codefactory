package com.authb.api_auth.service;

import com.authb.api_auth.dto.UserDto;
import com.authb.api_auth.entity.User;
import com.authb.api_auth.interfaces.UserInterface;
import com.authb.api_auth.repository.*;

import org.springframework.stereotype.Service;

@Service
public class UserService implements UserInterface {

    private static GenderRepository genderRepository;
    private static IdTypeRepository idTypeRepository;
    private static CityRepository cityRepository;
    private static RoleRepository roleRepository;
    private static UserRepository userRepository;



    public UserService(GenderRepository genderRepository, IdTypeRepository idTypeRepository, CityRepository cityRepository, RoleRepository roleRepository, UserRepository userRepository) {
        UserService.genderRepository = genderRepository;
        UserService.idTypeRepository = idTypeRepository;
        UserService.cityRepository = cityRepository;
        UserService.roleRepository = roleRepository;
        UserService.userRepository = userRepository;
    }


    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getId(),
                user.getId(),
                user.getId(),
                user.getId(),
                user.getIdentificationNumber(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getPassword(),
                user.getAvatarUrl(),
                user.getAddress()
        );
    }
    public static User toUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                idTypeRepository.findById(userDto.getId()).orElse(null) ,
                cityRepository.findById(userDto.getId()).orElse(null) ,
                genderRepository.findById(userDto.getId()).orElse(null),
                roleRepository.findById(userDto.getId()).orElse(null),
                userDto.getIdentificationNumber(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getBirthDate(),
                userDto.getPhoneNumber(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getAvatarUrl(),
                userDto.getAddress()
        );
    }
    @Override
    public User SignUp(UserDto userDto) {
        return userRepository.save(toUser(userDto));
    }

    public User findById(Long id){
        return (userRepository.findById(id).orElse(null));
    }

}
