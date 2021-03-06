package site.gamsung.service.user;

import java.util.HashMap;

import site.gamsung.service.common.Search;
import site.gamsung.service.domain.User;
import site.gamsung.service.domain.UserWrapper;

public interface UserService {
	
	//회원가입
	public void addUser(User user) throws Exception;
	
	public void addLoginDate(User user) throws Exception;
	
	// 내정보조회 / 로그인
	public User getUser(String id) throws Exception;
	
	//아이디 비밀번호 확인
	public User checkIdPassword(User user) throws Exception;
	
	//salt 값 가져오기
	public String getSaltById(String id) throws Exception;
	
	// 회원정보수정
	public void updateUser(User user) throws Exception;
	
	//회원 정보 리스트
	public UserWrapper listUser(Search search) throws Exception;
	
	//아이디, 닉네임, 휴대폰번호 중복체크
	public String checkDuplication(User user) throws Exception;
	
	//인증메일 발송
	public void sendEmailAuthNum(String id, String key) throws Exception;
	
	//인증문자 발송
	public void sendPhoneAuthNum(String phone, String phKey) throws Exception;
	
	//사업자회원 승인
	public void approvalBusinessUser(User user) throws Exception;
	
	//임시비밀번호 발송
	public void updateTempPassword(User user) throws Exception;
	
	//카카오 로그인 토큰 얻기
	public String getAccessToken(String code);
	
	//카카오 유저 정보 조회
	public HashMap<String, Object> getUserInfo (String accessToken);
	
	//아이디 찾기
	public String findId(String name, String phone) throws Exception;
	
	//비밀번호 찾기
	public User findPassword(User user) throws Exception;
	
	//이용정지 등록
	public void addSuspensionUser(User user) throws Exception;
	
	//회원탈퇴
	public boolean addSecessionUser(User user) throws Exception;
	
	//회원 휴면전환
	public void addDormantUser() throws Exception;
	
	//휴면회원 일반회원 전환
	public void updateDormantGeneralUserConvert(String id) throws Exception;

}
