package co.kr.store.bo.common.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

	@GetMapping({ "/auth/login.view" })
	public ModelAndView loginView() {
		return new ModelAndView("/view/common/auth/loginFormView");
	}

}
