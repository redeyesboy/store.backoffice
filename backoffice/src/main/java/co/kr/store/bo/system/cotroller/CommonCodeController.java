package co.kr.store.bo.system.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import co.kr.store.bo.system.dto.CommonCodeDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonCodeController {

	@GetMapping({ "/system/code/list.view" })
	public ModelAndView codeListView() {
		return new ModelAndView("/view/system/commonCodeListView");
	}

	@PostMapping({ "/system/code/detail.view" })
	public ModelAndView codeDetailView(CommonCodeDto reqDto) {
		ModelAndView mav = new ModelAndView("/view/system/commonCodeDetailView");
		mav.addObject("reqDto", reqDto);
		return mav;
	}



	//TODO openApi...
//	public


}
