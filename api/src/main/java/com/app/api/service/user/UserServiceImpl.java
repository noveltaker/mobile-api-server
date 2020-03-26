package com.app.api.service.user;

import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import com.app.api.domain.user.support.UserRepositorySupport;
import com.app.api.web.dto.UserRespoenseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRepositorySupport userRepositorySupport;

    @Override
    public void saveBy(UserRespoenseDto dto) {
        userRepository.save(dto.toEntity());
    }

    @Override
    public Long updateFrom(long seq, UserRespoenseDto dto) {
        return userRepositorySupport.update(seq, dto);
    }

    @Override
    public Page<User> getPageList(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}