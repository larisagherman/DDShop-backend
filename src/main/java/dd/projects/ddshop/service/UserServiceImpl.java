package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.UserDTORequest;
import dd.projects.ddshop.dto.UserDTOResponse;
import dd.projects.ddshop.entity.User;
import dd.projects.ddshop.mapper.AddressMapper;
import dd.projects.ddshop.mapper.UserMapper;
import dd.projects.ddshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    public void createUser(UserDTORequest userDTORequest) {
        User newUser = userMapper.dtoRequestToEntity(userDTORequest);
        userRepository.save(newUser);
    }

    public List<UserDTOResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::entityToDTOResponse).collect(Collectors.toList());
    }

    public UserDTOResponse getUserById(Integer id) {
        User foundUser = userRepository.findById(id).orElse(null);
        return userMapper.entityToDTOResponse(foundUser);
    }
    public UserDTOResponse update(Integer id, UserDTORequest userDTORequest) {
        User existingUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        existingUser.setFirstName(userDTORequest.getFirstName());
        existingUser.setLastName(userDTORequest.getLastName());
        existingUser.setEmail(userDTORequest.getEmail());
        existingUser.setPhoneNumber(userDTORequest.getPhoneNumber());
        existingUser.setPassword(userDTORequest.getPassword());
        existingUser.setDefaultDeliveryAddress(addressMapper.dtoRequestToEntity(userDTORequest.getDeliveryAddress()));
        existingUser.setDefaultBillingAddress(addressMapper.dtoRequestToEntity(userDTORequest.getBillingAddress()));

        User updatedUser = userRepository.save(existingUser);

        return userMapper.entityToDTOResponse(updatedUser);
    }
    public UserDTOResponse delete(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        userRepository.delete(user);
        return userMapper.entityToDTOResponse(user);
    }
}
