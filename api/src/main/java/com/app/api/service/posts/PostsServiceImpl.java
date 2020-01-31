package com.app.api.service.posts;

import com.app.api.domain.posts.PostsRepository;
import com.app.api.domain.posts.support.PostsRepositorySupport;
import com.app.api.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsRepository postsRepository;
    private final PostsRepositorySupport postsRepositorySupport;



    @Override
    @Transactional
    public Long save(PostsResponseDto postsResponseDto) {
        return postsRepository.save(postsResponseDto.toEntity()).getId();
    }

    @Override
    @Transactional
    public Long update(Long id, PostsResponseDto responseDto) {
        postsRepositorySupport.update(id, responseDto);
        return id;
    }

    @Override
    @Transactional
    public Long deleteBy(Long id) {
        postsRepository.deleteById(id);
        return id;
    }


}