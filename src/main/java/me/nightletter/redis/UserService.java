package me.nightletter.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final CacheManager cacheManager;
    private final UserRepository userRepository;

    @Cacheable("findAll")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void add(String name, Integer age) {
        cacheManager.getCache("findAll").clear();
        userRepository.save(new User(name, age));
    }
}
