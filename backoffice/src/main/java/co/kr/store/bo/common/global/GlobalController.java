package co.kr.store.bo.common.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.kr.store.bo.common.utils.CodeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GlobalController {

	@RequestMapping({ "/" })
	public ModelAndView mainView() {

		log.info("XXXXXXXXXX11111111111 :: {}" ,CodeUtils.getCommonCodeList("T_0001"));
		log.info("XXXXXXXXXX22222222222 :: {}" ,CodeUtils.getCommonCodeList("T_0001"));
		log.info("XXXXXXXXXX33333333333 :: {}" ,CodeUtils.getAllCommonCodeList("T_0001"));
		log.info("XXXXXXXXXX44444444444 :: {}" ,CodeUtils.getAllCommonCodeList("T_0001"));

		return new ModelAndView("/view/main/mainView");
	}

}
