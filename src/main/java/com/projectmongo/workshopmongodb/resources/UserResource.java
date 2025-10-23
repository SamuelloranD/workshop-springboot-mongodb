package com.projectmongo.workshopmongodb.resources;

import com.projectmongo.workshopmongodb.domain.User;
import com.projectmongo.workshopmongodb.dto.UserDTO;
import com.projectmongo.workshopmongodb.dto.UsernameDTO;
import com.projectmongo.workshopmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/names")
    public ResponseEntity<List<UsernameDTO>> findAllNames() {
        List<User> list = userService.findAll();
        List<UsernameDTO> listDtoName = list.stream().map(x -> new UsernameDTO(x)).toList();
        return ResponseEntity.ok().body(listDtoName);
    }

}
