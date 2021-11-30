package cz.osu.opr3.project.notepadofexcursionist.service;

import java.util.List;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.UserDBRepository;

public class DBService {

    public static UserEntity getCurrentUserEntity(String email, String password) {

        try {
            List<UserEntity> users = new UserDBRepository().findAll();
            for (UserEntity userEntity : users)
                if (userEntity.getUserEmail().equals(email) &&
                        userEntity.getUserPassword().equals(password))
                    return userEntity;

            throw new IllegalArgumentException("Password does not match!");
        } catch (Exception e) {
            throw new IllegalArgumentException("User could not be found!");
        }

    }


}
