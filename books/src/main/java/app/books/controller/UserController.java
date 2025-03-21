package app.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.books.dto.UserDTO;
import app.books.exceptions.NotFoundUser;
import app.books.models.User;
import app.books.repository.UserRepository;
import app.books.services.UserService;


@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {

        return userRepository.findAll().stream().map(user -> new UserDTO(

            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            user.getBooks().size(),
            user.getAuthors().size()
            )).toList();
    }

    @PostMapping
    public void createUser(@RequestBody @Validated User user) {

        
        userService.saveUser(user);

    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {

        User user = userRepository.findById(id).orElseThrow(() ->  new NotFoundUser());

        return new UserDTO(

            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            user.getBooks().size(),
            user.getAuthors().size()
        );

    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody @Validated User user) {

        userService.updateUser(id, user);


    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        userRepository.deleteById(id);

    }
    
}

