package co.kr.store.bo.common.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GlobalController {

	@GetMapping({ "/" })
	public ModelAndView mainView() {
		return new ModelAndView("/view/main/mainView");
	}

}
