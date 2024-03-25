package com.company.sport.admin.member;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.lang.model.element.Element;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.company.sport.admin.api.WeatherApi;
import com.company.sport.admin.api.WeatherForcastApi;
import com.company.sport.admin.member.AdminMemberVo;

@Controller

@RequestMapping("/admin/member")
public class AdminMemberController {
	@Autowired
	AdminMemberService adminMemberService;
	@Autowired
	WeatherApi weatherApi;
	@Autowired
	WeatherForcastApi weatherForApi;

	@RequestMapping(value = "/createAccountForm", method = RequestMethod.GET)
	public String createAccountForm() {
		String nextPage = "admin/member/create_account_form";

		return nextPage;
	}

	@PostMapping("/createAccountConfirm")
	public String createAccountConfirm(AdminMemberVo adminMemberVo) {
		String nextPage = "admin/member/create_account_ok";

		int result = adminMemberService.createAccountConfirm(adminMemberVo);

		if (result <= 0) {
			nextPage = "admin/member/create_account_ng";

		}

		return nextPage;
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		String nextPage = "admin/member/login_form";

		return nextPage;
	}

	@PostMapping("/loginConfirm")
	public String loginConfirm(AdminMemberVo adminMemberVo, HttpSession session) {

		String nextPage = "admin/member/login_ok";

		AdminMemberVo loginedAdminMemberVo = adminMemberService.loginConfirm(adminMemberVo);

		if (loginedAdminMemberVo == null) {
			nextPage = "admin/member/login_ng";
		} else {
			session.setAttribute("loginedAdminMemberVo", loginedAdminMemberVo);
			session.setMaxInactiveInterval(60 * 30);
		}

		return nextPage;
	}

	@RequestMapping(value = "/logoutConfirm", method = RequestMethod.GET)
	public String logoutConfirm(HttpSession session) {
		System.out.println("[AdminMemberController] logoutConfirm()");

		String nextPage = "redirect:/admin";

		session.invalidate();
		return nextPage;
	}

	@RequestMapping(value = "/listupAdmin", method = RequestMethod.GET)
	public String listupAdmin(Model model) {
		System.out.println("[AdminMemberController] modifyAccountConfirm()");

		String nextPage = "admin/member/listup_admins";
		List<AdminMemberVo> adminMemberVos = adminMemberService.listupAdmin();

		model.addAttribute("adminMemberVos", adminMemberVos);

		return nextPage;

	}

	@RequestMapping(value = "/setAdminApproval", method = RequestMethod.GET)
	public String setAdminApproval(@RequestParam("a_m_no") int a_m_no) {
		System.out.println("[AdminMemberController] setAdminApproval()");

		String nextPage = "redirect:/admin/member/listupAdmin";

		adminMemberService.setAdminApproval(a_m_no);
		return nextPage;
	}

	@GetMapping("/modifyAccountForm")
	public String modifyAccountForm(HttpSession session) {
		System.out.println("[AdminMemberController] modifyAccountForm()");

		String nextPage = "admin/member/modify_account_form";

		AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
		if (loginedAdminMemberVo == null)
			nextPage = "redirect:/admin/member/loginForm";

		return nextPage;

	}

	@PostMapping("/modifyAccountConfirm")
	public String modifyAccountConfirm(AdminMemberVo adminMemberVo, HttpSession session) {
		System.out.println("[AdminMemberController] modifyAccountConfirm()");

		String nextPage = "admin/member/modify_account_ok";

		int result = adminMemberService.modifyAccountConfirm(adminMemberVo);

		if (result > 0) {
			AdminMemberVo loginedAdminMemberVo = adminMemberService.getLoginedAdminMemberVo(adminMemberVo.getA_m_no());

			session.setAttribute("loginedAdminMemberVo", loginedAdminMemberVo);
			session.setMaxInactiveInterval(60 * 30);

		} else {
			nextPage = "admin/member/modify_account_ng";

		}

		return nextPage;

	}

	@GetMapping("/getPlaceWeather")
	public String getPlaceWeather(Model model,AdminMemberSportVo adminMemberSportVo) {
	    String nextPage = "admin/member/weather";

	    try {
	        
	        String weatherInfo1 = weatherApi.getWeather(55, 125);
	        String weatherInfo2 = weatherApi.getWeather(55, 124);
	        String weatherInfo3 = weatherApi.getWeather(58, 125);
	        String weatherInfo4 = weatherApi.getWeather(60, 121);
	        String weatherInfo5 = weatherApi.getWeather(90, 77);
	        String weatherInfo6 = weatherApi.getWeather(98, 76);
	        String weatherInfo7 = weatherApi.getWeather(89, 90);
	        String weatherInfo8 = weatherApi.getWeather(67, 100);
	        String weatherInfo9 = weatherApi.getWeather(58, 74);
	        String weatherFor1 = weatherForApi.getWeather(55, 125);
	        

	        
	        processWeatherInfo(model, "Location1", weatherInfo1);
	        processWeatherInfo(model, "Location2", weatherInfo2);
	        processWeatherInfo(model, "Location3", weatherInfo3);
	        processWeatherInfo(model, "Location4", weatherInfo4);
	        processWeatherInfo(model, "Location5", weatherInfo5);
	        processWeatherInfo(model, "Location6", weatherInfo6);
	        processWeatherInfo(model, "Location7", weatherInfo7);
	        processWeatherInfo(model, "Location8", weatherInfo8);
	        processWeatherInfo(model, "Location9", weatherInfo9);
	       
	        
	        processWeatherFor(model,"Location1",weatherFor1);
	        
	        List<String> recommendedSports = adminMemberService.getRecommendedSports(adminMemberSportVo,model);
	        model.addAttribute("recommendedSports", recommendedSports);
	        System.out.println(recommendedSports);
	        String weatherDate = weatherApi.toString();
	        model.addAttribute("date",weatherDate);
	    } catch (IOException e) {
	        e.printStackTrace();
	        model.addAttribute("weatherError", "날씨 정보를 가져오는 중에 오류가 발생했습니다.");
	    }

	    return nextPage;
	}
	private void processWeatherFor(Model model, String location, String weatherInfo) {
	    List<String> fcstValue = extValues(weatherInfo, "fcstValue");
	    List<String> fcstTimeValue = extValues(weatherInfo, "fcstTime");
	    List<String> baseDateValue = extValues(weatherInfo, "baseDate");
	    
	    
	    model.addAttribute(location + "_fcstValue", fcstValue);
	    model.addAttribute(location + "_fcstTime", fcstTimeValue);
	    model.addAttribute(location + "_baseDate", baseDateValue);
	    


	}
	public List<String> extValues(String xml, String tagname) {
	    List<String> values = new ArrayList<>();
	    int limit = 6;
	    int count = 0;
	    String patternString = "<" + tagname + ">(.*?)</" + tagname + ">";
	    Pattern pattern = Pattern.compile(patternString);
	    Matcher matcher = pattern.matcher(xml);

	    while (matcher.find() && count<limit) {
	        values.add(matcher.group(1));
	        count++;
	    }

	    return values;
	}

	
	private void processWeatherInfo(Model model, String location, String weatherInfo) {
	    String t1hValue = extractValue(weatherInfo, "T1H");
	    String ptyValue = extractValue(weatherInfo, "PTY");
	    String rn1Value = extractValue(weatherInfo, "RN1");
	    String vecValue = extractValue(weatherInfo, "VEC");
	    String wsdValue = extractValue(weatherInfo, "WSD");
	    
	    model.addAttribute(location + "_Temperature", t1hValue);
	    model.addAttribute(location + "_PrecipitationType", ptyValue);
	    model.addAttribute(location + "_Rainfall1h", rn1Value);
	    model.addAttribute(location + "_WindDirection", vecValue);
	    model.addAttribute(location + "_WindSpeed", wsdValue);


	}
	
	private static String extractValue(String input, String dataType) {
	    String obsrValueTag = "<obsrValue>";
	    int startIndex = input.indexOf(dataType);
	    int obsrValueStartIndex = input.indexOf(obsrValueTag, startIndex) + obsrValueTag.length();
	    int obsrValueEndIndex = input.indexOf("</obsrValue>", obsrValueStartIndex);

	    if (startIndex == -1 || obsrValueStartIndex == -1 || obsrValueEndIndex == -1) {
	        return "";
	    }

	    return input.substring(obsrValueStartIndex, obsrValueEndIndex);
	}
	

	
	

}
