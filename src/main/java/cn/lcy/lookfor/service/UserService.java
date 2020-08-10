package cn.lcy.lookfor.service;


import cn.lcy.lookfor.dao.UserRepository;
import cn.lcy.lookfor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    public User getUserById(String identifyId) {
        return this.userRepository.findOne(identifyId);
    }

}
