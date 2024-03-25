package com.company.sport.Info.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.company.sport.Info.admin.util.UploadFileService;
import com.company.sport.admin.member.AdminMemberVo;
import com.company.sport.Info.InfoVo;

@Controller
@RequestMapping("/info/admin")
public class InfoController {
	@Autowired
	InfoService infoService;

	@Autowired
	UploadFileService uploadFileService;

	@GetMapping("/registerSportForm")
	public String registerSportForm() {
		String nextPage = "admin/sport/register_sport_form";

		return nextPage;
	}

	@PostMapping("/registerSportConfirm")
	public String registerSportConfirm(InfoVo infoVo, @RequestParam("file") MultipartFile file) {

		String nextPage = "admin/sport/register_sport_ok";

		String savedFileName = uploadFileService.upload(file);

		if (savedFileName != null) {
			infoVo.setThumbnail(savedFileName);
			int result = infoService.registerSportConfirm(infoVo);

			if (result <= 0)
				nextPage = "admin/sport/register_sport_ng";

		} else {
			nextPage = "admin/sport/register_sport_ng";

		}

		return nextPage;

	}
	@GetMapping("/searchSportConfirm")
	public String searchSportConfirm(InfoVo infoVo, Model model) {
		String nextPage ="admin/sport/search_sport";
		List<InfoVo> infoVos = infoService.searchSportsConfirm(infoVo);
		model.addAttribute("infoVos", infoVos);
		return nextPage;
	}
	@GetMapping("/sportDetail")
	public String sportDetail(@RequestParam("sport_name") String sport_name, Model model ) {
		String nextPage ="admin/sport/sport_detail";
		InfoVo infoVo = infoService.sportDetail(sport_name);
		model.addAttribute("infoVo", infoVo);
		
		return nextPage;
	}
	@GetMapping("/modifySportForm")
	public String modifySportForm(@RequestParam("sport_name") String sport_name, Model model ) {
		String nextPage ="admin/sport/modify_sport_form";
		InfoVo infoVo = infoService.modifySportForm(sport_name);
		model.addAttribute("infoVo", infoVo);
		
		return nextPage;
	}
	@PostMapping("/modifySportConfirm")
	public String modifySportConfirm(InfoVo infoVo, 
									@RequestParam("file") MultipartFile file, 
									HttpSession session) {
		
		String nextPage = "admin/sport/modify_sport_ok";
		
//		AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
//		if (loginedAdminMemberVo == null)
//			return "redirect:/admin/member//loginForm";
		
		if (!file.getOriginalFilename().equals("")) {
			String savedFileName = uploadFileService.upload(file);
			if (savedFileName != null)
				infoVo.setThumbnail(savedFileName);
			
		}
		
		int result = infoService.modifySportConfirm(infoVo);
		
		if (result <= 0)
			nextPage = "admin/sport/modify_sport_ng";
		
		return nextPage;
		
	}
	@GetMapping("/deleteSportConfirm")
	public String deleteSportConfirm(@RequestParam("sport_name") String sport_name, 
									HttpSession session) {
		
		String nextPage = "admin/sport/delete_sport_ok";
		
//		AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
//		if (loginedAdminMemberVo == null)
//			return "redirect:/admin/member//loginForm";
		
		int result = infoService.deleteSportConfirm(sport_name);
		
		if (result <= 0)
			nextPage = "admin/sport/delete_sport_ng";
		
		return nextPage;
		
	}
	@GetMapping("/showSport")
	public String showSport(InfoVo infoVo, Model model) {
		String nextPage ="admin/sport/show_sport";
		List<InfoVo> infoVos = infoService.showSport(infoVo);
		model.addAttribute("infoVos", infoVos);
		return nextPage;
	}

}
