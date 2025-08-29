package com.sch.springboot.service;

import com.sch.springboot.dto.Dwitter;
import com.sch.springboot.repository.JpaDwitterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class DwitterService {

    private final JpaDwitterRepository dwitterRepository;

    @Autowired
    public DwitterService(JpaDwitterRepository dwitterRepository) {
        this.dwitterRepository = dwitterRepository;
    }

    /**
     * 리스트 조회
     */
    public List<Dwitter> findDwitters() {
        return dwitterRepository.findAll();
    }

    /**
     * 등록
     */
    public String register(Dwitter dwitter) {
        System.out.println(dwitter.getName());
        return dwitterRepository.insert(dwitter);
    }

    /**
     * 삭제
     */
    public String delete(Long id) {
        return dwitterRepository.delete(id);
    }
}
