package co.kr.store.bo.common.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GlobalController {

	@RequestMapping({ "/" })
	public ModelAndView mainView() {
		return new ModelAndView("/view/main/mainView");
	}

}
