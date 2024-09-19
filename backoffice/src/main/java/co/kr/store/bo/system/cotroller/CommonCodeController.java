package co.kr.store.bo.system.cotroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.kr.store.bo.common.exception.BizException;
import co.kr.store.bo.core.dto.CommonAjaxResult;
import co.kr.store.bo.system.dto.CommonCodeDto;
import co.kr.store.bo.system.service.CommonCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommonCodeController {

	private final CommonCodeService commonCodeService;

	@PostMapping({ "/system/code/list.view" })
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
	@PostMapping({ "/system/code.do" })
	@ResponseBody
	public CommonAjaxResult getGroupCommonCode(@RequestBody CommonCodeDto reqDto) {
		CommonAjaxResult result = new CommonAjaxResult();
		try {
			CommonCodeDto resDto = commonCodeService.getGroupCommonCode(reqDto);
			result.set("reqDto", reqDto);
			result.set("resDto", resDto);
		} catch (Exception e) {
			log.error("", e);
			result.fail(e.getMessage());
		}
		return result;
	}

	@PostMapping({ "/system/code/list.do" })
	@ResponseBody
	public CommonAjaxResult getGroupCommonCodeList(@RequestBody CommonCodeDto reqDto) {
		CommonAjaxResult result = new CommonAjaxResult();
		try {
			List<CommonCodeDto> list = commonCodeService.getGroupCommonCodeList(reqDto);
			result.set("reqDto", reqDto);
			result.set("list", list);
		} catch (Exception e) {
			log.error("", e);
			result.fail(e.getMessage());
		}
		return result;
	}

	@PostMapping({ "/system/code/txn/list.do" })
	@ResponseBody
	public CommonAjaxResult getCommonCodeList(@RequestBody CommonCodeDto reqDto) {
		CommonAjaxResult result = new CommonAjaxResult();
		try {
			List<CommonCodeDto> list = commonCodeService.getCommonCodeList(reqDto);
			result.set("reqDto", reqDto);
			result.set("list", list);
		} catch (Exception e) {
			log.error("", e);
			result.fail(e.getMessage());
		}
		return result;
	}

	@PostMapping({ "/system/code/save.do" })
	@ResponseBody
	public CommonAjaxResult saveCommonCode(@RequestBody CommonCodeDto reqDto) {
		CommonAjaxResult result = new CommonAjaxResult();
		try {
			commonCodeService.saveCommonCode(reqDto);
		} catch (BizException e) {
			log.error("", e);
			result.fail(e.getCode(), e.getMessage());
		} catch (Exception e) {
			log.error("", e);
			result.fail();
		}
		return result;
	}

	@PostMapping({ "/system/code/delete.do" })
	@ResponseBody
	public CommonAjaxResult deleteCommonCode(@RequestBody List<CommonCodeDto> reqList) {
		CommonAjaxResult result = new CommonAjaxResult();
		try {
			for ( CommonCodeDto reqDto : reqList ) {
				commonCodeService.saveCommonCode(reqDto);
			}
		} catch (BizException e) {
			log.error("", e);
			result.fail(e.getCode(), e.getMessage());
		} catch (Exception e) {
			log.error("", e);
			result.fail();
		}
		return result;
	}

}
