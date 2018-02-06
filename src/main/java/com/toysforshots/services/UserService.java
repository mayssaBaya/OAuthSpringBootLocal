package com.toysforshots.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.toysforshots.dto.UserDTO;
import com.toysforshots.entities.User;
import com.toysforshots.error.UserAlreadyExistException;
import com.toysforshots.repositories.IUserRepository;

@Service
public class UserService implements IUserService, UserDetailsService {
	
	@Autowired
	IUserRepository repo_;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public UserService(IUserRepository repo_) {
		this.repo_ = repo_;
	}

	@Override
	public User findUserByUsername(String username) {
		return repo_.findByUserName(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findUserByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException("Invalid username or password.");
		return new MyUserDetails(user);
	}

	public User save(User user) {
		return repo_.save(user);
	}

	public List<User> findAll() {
		return (List<User>) repo_.findAll();
	}

	public void delete(int id) {
		repo_.delete(id);
	}

	@Override
	public User registerNewUserAccount(UserDTO accountDto) throws UserAlreadyExistException {
		if (findUserByUsername(accountDto.getUserName()) == null) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getUserName());
        }
        final User user = new User();

        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setUserName(accountDto.getUserName());
        //user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return repo_.save(user);
	}
}
