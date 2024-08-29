package co.kr.store.bo.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import co.kr.store.bo.main.service.MainService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final MainService mainService;

	@GetMapping({ "/", "/main.view" })
	public ModelAndView mainView() {
		return new ModelAndView("/view/main/mainView");
	}


}
