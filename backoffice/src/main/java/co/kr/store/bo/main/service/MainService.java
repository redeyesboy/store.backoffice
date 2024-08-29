package co.kr.store.bo.main.service;

import org.springframework.stereotype.Service;

import co.kr.store.bo.main.main.MainDao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainService {

	private final MainDao mainDao;

}
