package app.books.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.books.exceptions.ExistingUser;
import app.books.exceptions.NotFoundUser;
import app.books.exceptions.UserErrorFields;
import app.books.models.User;
import app.books.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {

        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null ) {

            throw new UserErrorFields();
            
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {

            throw new ExistingUser();

        }


        userRepository.save(user);
    
    }

    public void updateUser(Long id, User userDatas) {

        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundUser());

        if (userDatas.getName() == null || userDatas.getEmail() == null || userDatas.getPassword() == null ) {

            throw new UserErrorFields();
            
        }
        
        user.setName(userDatas.getName());

        user.setEmail(userDatas.getEmail());

        user.setPassword(userDatas.getPassword());


        userRepository.save(user);
    
    }


    
}
