package site.gamsung.controller.campbusiness;

import java.util.Map;
import java.io.File;
import java.sql.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import site.gamsung.service.common.Page;
import site.gamsung.service.common.Search;
import site.gamsung.service.domain.Camp;
import site.gamsung.service.domain.MainSite;
import site.gamsung.service.domain.SubSite;
import site.gamsung.service.domain.User;
import site.gamsung.service.campbusiness.CampBusinessService;
import site.gamsung.service.user.UserService;

//String methodName = new Object() { }.getClass().getEnclosingMethod().getName();
//System.out.println(" >> " + this.getClass().getName() + " : " + methodName);

@Controller
@RequestMapping("/campBusiness/*")
public class CampBusinessController {

	/// Field
	@Autowired
	@Qualifier("campBusinessServiceImpl")
	private CampBusinessService campBusinessService;

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	// @Value("#{commonProperties['pageUnit']}")
	@Value("#{commonProperties['pageUnit'] ?: 5}")
	int pageUnit;

	// @Value("#{commonProperties['pageSize']}")
	@Value("#{commonProperties['pageSize'] ?: 10}")
	int pageSize;
	
	public static final String FILE_PATH_CAMP = "C:\\Users\\Choi\\git\\GamsungPJT\\gamsung\\src\\main\\webapp\\uploadfiles\\campimg\\campbusiness\\camp";
	public static final String FILE_PATH_MAINSITE = "C:\\Users\\Choi\\git\\GamsungPJT\\gamsung\\src\\main\\webapp\\uploadfiles\\campimg\\campbusiness\\mainsite";
	public static final String FILE_PATH_SUBSITE = "C:\\Users\\Choi\\git\\GamsungPJT\\gamsung\\src\\main\\webapp\\uploadfiles\\campimg\\campbusiness\\subsite";
		
	public CampBusinessController() {
		System.out.println(this.getClass());
	}
	
	/*
	 * Common
	 */
	@RequestMapping(value = "goSubMainCampBusiness", method = RequestMethod.GET)
	public String goSubMainCampBusiness(HttpSession httpSession) throws Exception {

		/////////////////////////////////////////////////////////////////////// Session 완료시 삭제
		User tempSessionUser = new User();
		
		tempSessionUser.setId("businessuser1@gamsung.com"); // TS -3 저장
		//tempSessionUser.setId("businessuser6@gamsung.com"); // TS -2 임시저장
		//tempSessionUser.setId("businessuser9@gamsung.com"); // TS -1 발급 완료
		//tempSessionUser.setId("businessuser11@gamsung.com");  // TS -0 발급 미완료
		//tempSessionUser.setId("admin");					  // admin
		
		httpSession.setAttribute("user", tempSessionUser);
		System.out.println("tempSessionUser : " + tempSessionUser);
		/////////////////////////////////////////////////////////////////////// 여기까지 삭제

		
		Camp campSession = new Camp();
		User tempUser = null;

		if (httpSession != null) {
			
			// user 전체정보요청
			tempUser = userService.getUser(((User) httpSession.getAttribute("user")).getId());
			System.out.println("campSession tempUser : " + tempUser); // 테스트
			
			if (tempUser != null) {
				
				// role = business
				if (tempUser.getRole().equals("BUSINESS")) {
					
					// 캠핑장정보 미등록시 캠핑장 등록화면 이동
					if (campBusinessService.getCampTempSaveById(tempUser.getId()) < 3) {

						campSession.setUser(tempUser);
						httpSession.setAttribute("campSession", campSession);
						System.out.println("campSession x camp : " + campSession); // 테스트
						return "forward:/campBusiness/addCampView";
					}
				}
				
				// role = admin
				if (tempUser.getRole().equals("ADMIN")) {
					campSession.setUser(tempUser);
					httpSession.setAttribute("campSession", campSession);
					return "forward:/view/common/subMainCampBusiness.jsp";
				}
			}

		} else {
			return "redirect:/main.jsp";
		}

		// session 에 load
		campSession = campBusinessService.getCamp(campBusinessService.getCampNoById(tempUser.getId()));
		campSession.setUser(tempUser);
		httpSession.setAttribute("campSession", campSession);
		System.out.println("campSession o camp : " + campSession); // 테스트

		// 사업자 메인으로 이동
		return "forward:/view/common/subMainCampBusiness.jsp";
	}


	/*
	 * Camp
	 */
	@RequestMapping(value = "addCampView", method = RequestMethod.GET)
	public String addCampView(HttpSession httpSession, Model model) throws Exception {		
		
		Camp tempCamp = new Camp();		
		User tempUser = new User();
		String tempId = ((User)httpSession.getAttribute("user")).getId();
		tempUser.setId(tempId);
		tempCamp.setUser(tempUser);

		tempCamp.setCampRegDate(Date.valueOf("1111-11-11"));
		tempCamp.setCampTheme1(" ");
		tempCamp.setCampTheme2(" ");
		tempCamp.setCampNature1(" ");
		tempCamp.setCampNature2(" ");
		tempCamp.setCampOperation1(" ");
		tempCamp.setCampOperation2(" ");
		
		// 등록번호 발급
		int tempRegNum = campBusinessService.getCampNoById(tempId);
		System.out.println("tempRegNum1 : " + tempRegNum);
		if (tempRegNum == 0 ) {
			tempRegNum = campBusinessService.getRegNum("Camp", tempCamp);
		}
		System.out.println("tempRegNum2 : " + tempRegNum);
		tempCamp.setCampNo(tempRegNum);
		model.addAttribute("camp", tempCamp);		
		
		return "forward:/view/campbusiness/addCamp.jsp";
	}
	
	// 주소, 전화번호, 회원ID, 테마, 환경, 운영 Ajax 처리필요
	@RequestMapping(value = "listCamp", method = RequestMethod.POST)
	public String listCamp(@ModelAttribute("search") Search search, Model model, HttpServletRequest request)
			throws Exception {

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}

		search.setPageSize(pageSize);
		search.setSearchItemType("Camp");
		Map<String, Object> map = campBusinessService.listCamp(search);

		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);

		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);

		return "forward:/view/campbusiness/listCamp.jsp";
	}
	
	@RequestMapping(value = "getCamp", method = RequestMethod.GET)
	public String getCamp(@RequestParam("campNo") int campNo, Model model) throws Exception {

		Camp camp = campBusinessService.getCamp(campNo);
		model.addAttribute("camp", camp);

		return "forward:/view/campbusiness/getCamp.jsp";
	}
	
	@RequestMapping(value = "updateCampView", method = RequestMethod.POST)
	public String updateCampView(@RequestParam("campNo") int campNo, Model model) throws Exception {

		Camp camp = campBusinessService.getCamp(campNo);
		model.addAttribute("camp", camp);

		return "forward:/view/campbusiness/updateCamp.jsp";
	}
	

	@RequestMapping(value = "updateCamp", method = RequestMethod.POST)
	public String updateCamp(@ModelAttribute("camp") Camp camp) throws Exception {		
			
		String originfileName = ""; 
		String extension = "";
		String newfileName = ""; 		
		
		if(camp.getCampMapFile() != null) {
			originfileName = camp.getCampMapFile().getOriginalFilename().trim();
			
			if(!(originfileName.equals(""))) {
				extension = originfileName.split("\\.")[1];		
				newfileName = camp.getCampNo() + "_map" + "." + extension;
				camp.setCampMapImg(newfileName);
				camp.getCampMapFile().transferTo(new File(FILE_PATH_CAMP, newfileName)); 
			}
		}
		
		if(camp.getCampImgFile1() != null) {
			originfileName = camp.getCampImgFile1().getOriginalFilename().trim();
			
			if(!(originfileName.equals(""))) {
				System.out.println("cccccc" +originfileName + "aaa");
				extension = originfileName.split("\\.")[1];		
				newfileName = camp.getCampNo() + "_1" + "." + extension;
				camp.setCampImg1(newfileName);
				camp.getCampImgFile1().transferTo(new File(FILE_PATH_CAMP, newfileName));
			}
		}
		
		if(camp.getCampImgFile2() != null) {
			originfileName = camp.getCampImgFile2().getOriginalFilename().trim();
			
			if(!(originfileName.equals(""))) {
				extension = originfileName.split("\\.")[1];		
				newfileName = camp.getCampNo() + "_2" + "." + extension;
				camp.setCampImg2(newfileName);
				camp.getCampImgFile2().transferTo(new File(FILE_PATH_CAMP, newfileName));
			}
		}		
		
		if(camp.getCampImgFile3() != null) {
			originfileName = camp.getCampImgFile3().getOriginalFilename().trim();
			
			if(!(originfileName.equals(""))) {
				extension = originfileName.split("\\.")[1];		
				newfileName = camp.getCampNo() + "_3" + "." + extension;
				camp.setCampImg3(newfileName);
				camp.getCampImgFile3().transferTo(new File(FILE_PATH_CAMP, newfileName));
			}
		}
		
		if(camp.getCampImgFile4() != null) {
			originfileName = camp.getCampImgFile4().getOriginalFilename().trim();
			
			if(!(originfileName.equals(""))) {
				extension = originfileName.split("\\.")[1];		
				newfileName = camp.getCampNo() + "_4" + "." + extension;
				camp.setCampImg4(newfileName);
				camp.getCampImgFile4().transferTo(new File(FILE_PATH_CAMP, newfileName));
			}
		}		
		
		if(camp.getCampImgFile5() != null) {
			originfileName = camp.getCampImgFile5().getOriginalFilename().trim();
			
			if(!(originfileName.equals(""))) {
				extension = originfileName.split("\\.")[1];		
				newfileName = camp.getCampNo() + "_5" + "." + extension;
				camp.setCampImg5(newfileName);
				camp.getCampImgFile5().transferTo(new File(FILE_PATH_CAMP, newfileName)); 
			}
		}		
	
		System.out.println("c1 : " + camp);		
		campBusinessService.updateCamp(camp);
		
		return "forward:/view/campbusiness/getCamp.jsp";
	}
		
	@RequestMapping(value = "deleteCamp", method = RequestMethod.POST)
	public String deleteCamp(@RequestParam("campNo") int campNo) throws Exception {

		campBusinessService.deleteCamp(campNo);
		return "forward:/view/common/subMainCampBusiness.jsp";
	}

	
	/*
	 * MainSite
	 */
	@RequestMapping(value = "addMainSiteView", method = RequestMethod.GET)
	public String addMainSiteView(HttpSession httpSession, Model model) throws Exception {
		
		MainSite tempMainSite = new MainSite();		
		int tempCampNo = ((Camp)httpSession.getAttribute("campSession")).getCampNo();
		tempMainSite.setCampNo(tempCampNo);

		tempMainSite.setMainSiteType(" ");
		tempMainSite.setMainSiteName(tempCampNo+"");
		tempMainSite.setMainSiteMinCapacity(0);
		tempMainSite.setMainSiteMaxCapacity(0);
		tempMainSite.setMainSiteMinPrice(0);
		tempMainSite.setMainSiteAddPrice(0);		
		tempMainSite.setMainSiteRegDate(Date.valueOf("1111-11-11"));		
		
		// 등록번호 발급
		int tempRegNum = campBusinessService.getRegNum("MainSite", tempMainSite);		
		tempMainSite.setMainSiteNo(tempRegNum);
		model.addAttribute("mainSite", tempMainSite);			
		
		return "forward:/view/campbusiness/addMainSite.jsp";
	}

	// 구역크기, 기본인원, 최대인원, 기본인원사용금액, 추가인원금액 Ajax 처리필요
	@RequestMapping(value = "listMainSite", method = RequestMethod.POST)
	public String listMainSite(@ModelAttribute("search") Search search, Model model, HttpServletRequest request)
			throws Exception {

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}

		search.setPageSize(pageSize);
		search.setSearchItemType("MainSite");
		Map<String, Object> map = campBusinessService.listMainSite(search);

		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);
		System.out.println(resultPage);

		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);

		return "forward:/view/campbusiness/listMainSite.jsp";
	}

	@RequestMapping(value = "getMainSite", method = RequestMethod.GET)
	public String getMainSite(@RequestParam("mainSiteNo") int mainSiteNo, Model model) throws Exception {
		
		MainSite mainSite = campBusinessService.getMainSite(mainSiteNo);
		model.addAttribute("mainSite", mainSite);

		return "forward:/view/campbusiness/getMainSite.jsp";
	}

	@RequestMapping(value = "updateMainSiteView", method = RequestMethod.POST)
	public String updateMainSiteView(@RequestParam("mainSiteNo") int mainSiteNo, Model model) throws Exception {
		
		MainSite mainSite = campBusinessService.getMainSite(mainSiteNo);
		model.addAttribute("mainSite", mainSite);

		return "forward:/view/campbusiness/updateMainSite.jsp";
	}

	@RequestMapping(value = "updateMainSite", method = RequestMethod.POST)
	public String updateMainSite(@ModelAttribute("mainSite") MainSite mainSite) throws Exception {
		
		String originfileName = ""; 
		String extension = "";
		String newfileName = ""; 			
		
		if(mainSite.getMainSiteImgFile1() != null) {			
			originfileName = mainSite.getMainSiteImgFile1().getOriginalFilename().trim();
			
			if(!(originfileName.equals(""))) {
				
				extension = originfileName.split("\\.")[1];		
				newfileName = mainSite.getCampNo()+"-" + mainSite.getMainSiteNo() +"_1" + "." + extension;
				mainSite.setMainSiteImg1(newfileName);
				mainSite.getMainSiteImgFile1().transferTo(new File(FILE_PATH_MAINSITE, newfileName)); 
			}
		}
		
		if(mainSite.getMainSiteImgFile2() != null) {
			originfileName = mainSite.getMainSiteImgFile2().getOriginalFilename().trim();
			
			if(!(originfileName.equals(""))) {
				extension = originfileName.split("\\.")[1];		
				newfileName = mainSite.getCampNo()+"-" + mainSite.getMainSiteNo() +"_2" + "." + extension;
				mainSite.setMainSiteImg2(newfileName);
				mainSite.getMainSiteImgFile2().transferTo(new File(FILE_PATH_MAINSITE, newfileName)); 
			}
		}
		
		if(mainSite.getMainSiteImgFile3() != null) {
			originfileName = mainSite.getMainSiteImgFile3().getOriginalFilename().trim();
			
			if(!(originfileName.equals(""))) {
				extension = originfileName.split("\\.")[1];		
				newfileName = mainSite.getCampNo()+"-" + mainSite.getMainSiteNo() +"_3" + "." + extension;
				mainSite.setMainSiteImg3(newfileName);
				mainSite.getMainSiteImgFile3().transferTo(new File(FILE_PATH_MAINSITE, newfileName)); 
			}
		}
		
		campBusinessService.updateMainSite(mainSite);
		return "forward:/view/campbusiness/getMainSite.jsp";
	}

	@RequestMapping(value = "deleteMainSite", method = RequestMethod.POST)
	public String deleteMainSite(@RequestParam("mainSiteNo") int mainSiteNo) throws Exception {

		campBusinessService.deleteMainSite(mainSiteNo);
		return "forward:/view/common/subMainCampBusiness.jsp";
	}

	/*
	 * SubSite
	 */
	@RequestMapping(value = "addSubSiteView", method = RequestMethod.GET)
	public String addSubSiteView(HttpSession httpSession, Model model) throws Exception {
				
		SubSite tempSubSite = new SubSite();		
		int tempCampNo = ((Camp)httpSession.getAttribute("campSession")).getCampNo();
		tempSubSite.setCampNo(tempCampNo);

		tempSubSite.setSubSiteType(" ");
		tempSubSite.setSubSiteName(tempCampNo+"");
		tempSubSite.setSubSiteRegDate(Date.valueOf("1111-11-11"));
		
		// 등록번호 발급
		int tempRegNum = campBusinessService.getRegNum("SubSite", tempSubSite);		
		tempSubSite.setSubSiteNo(tempRegNum);
		model.addAttribute("subSite", tempSubSite);		
		
		return "forward:/view/campbusiness/addSubSite.jsp";
	}

	@RequestMapping(value = "listSubSite", method = RequestMethod.POST)
	public String listSubSite(@ModelAttribute("search") Search search, Model model, HttpServletRequest request)
			throws Exception {

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}

		search.setPageSize(pageSize);
		search.setSearchItemType("SubSite");
		Map<String, Object> map = campBusinessService.listSubSite(search);

		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);
		System.out.println(resultPage);

		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);

		return "forward:/view/campbusiness/listSubSite.jsp";
	}

	@RequestMapping(value = "getSubSite", method = RequestMethod.GET)
	public String getSubSite(@RequestParam("subSiteNo") int subSiteNo, Model model) throws Exception {
		SubSite subSite = campBusinessService.getSubSite(subSiteNo);
		model.addAttribute("subSite", subSite);

		return "forward:/view/campbusiness/getSubSite.jsp";
	}

	@RequestMapping(value = "updateSubSiteView", method = RequestMethod.POST)
	public String updateSubSiteView(@RequestParam("subSiteNo") int subSiteNo, Model model) throws Exception {

		SubSite subSite = campBusinessService.getSubSite(subSiteNo);
		model.addAttribute("subSite", subSite);

		return "forward:/view/campbusiness/updateSubSite.jsp";
	}

	@RequestMapping(value = "updateSubSite", method = RequestMethod.POST)
	public String updateSubSite(@ModelAttribute("subSite") SubSite subSite, HttpServletRequest httpServletRequest) throws Exception {
				
		String originfileName = ""; 
		String extension = "";
		String newfileName = ""; 			

		if(subSite.getSubSiteImgFile() != null) {
			originfileName = subSite.getSubSiteImgFile().getOriginalFilename().trim();
					
			if(!(originfileName.equals(""))) {
				extension = originfileName.split("\\.")[1];		
				newfileName = subSite.getCampNo() + "-" + subSite.getSubSiteNo() + "." + extension;
				subSite.setSubSiteImg(newfileName);
				subSite.getSubSiteImgFile().transferTo(new File(FILE_PATH_SUBSITE, newfileName)); 
			}
		}
		
		campBusinessService.updateSubSite(subSite);
		return "forward:/view/campbusiness/getSubSite.jsp";
	}

	@RequestMapping(value = "deleteSubSite", method = RequestMethod.POST)
	public String deleteSubSite(@RequestParam("subSiteNo") int subSiteNo) throws Exception {

		campBusinessService.deleteSubSite(subSiteNo);
		return "forward:/view/common/subMainCampBusiness.jsp";
	}

} // end of class
