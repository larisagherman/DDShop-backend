package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.UserDTORequest;
import dd.projects.ddshop.dto.UserDTOResponse;

import java.util.List;

public interface UserService {
    public UserDTOResponse createUser(UserDTORequest userDTORequest);
    public List<UserDTOResponse> getAllUsers();
    public UserDTOResponse update(Integer id,UserDTORequest userDTORequest);
    public UserDTOResponse delete(Integer id);
    public UserDTOResponse getUserById(Integer id);
}

