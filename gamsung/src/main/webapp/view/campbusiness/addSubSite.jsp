<%@ page contentType="text/html; charset=EUC-KR" %>

<!DOCTYPE html>

<html lang="ko">

<head>
	<meta charset="EUC-KR">

	<!-- Bootstrap, jQuery CDN -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	
	<script src="../../resources/lib/jquery/jquery.js"></script>
    <script src="../../resources/lib/bootstrap/js/bootstrap.min.js"></script>
  	<script src="../../resources/lib/imagesloaded/imagesloaded.pkgd.js"></script>
	
	<!-- CSS -->
	<style>
		body > div.container{
			margin-top: 70px;
		}
    </style>

	<!-- JavaScript -->
	<script type="text/javascript">

		// 버튼
		$(function() {
			//==> DOM Object GET 3가지 방법 ==> 1. $(tagName) : 2.(#id) : 3.$(.className)
			
			//등록일자 현재년월일 받아오기	
			document.getElementById('subSiteRegDate').value = new Date().toISOString().substring(0, 10);;
			
			$("#save").on("click" , function() {
				alert("부가시설이 등록 되었습니다.");			
				$("form").attr("method" , "POST").attr("action" , "/campBusiness/updateSubSite").attr("enctype","multipart/form-data").submit();
			});
					
			$("#cancle").on("click" , function() {
				alert("취소 되었습니다.");
				window.history.back();
			});
			
			$("#resetform").on("click" , function() {
				alert("초기화 되었습니다.");				
				$("form")[0].reset();				
			});
		
		});	

</script>		

</head>

<body>

	<!-- ToolBar -->
	<jsp:include page="/view/common/headerCampBusiness.jsp" />

	<!-- Page Start -->
	<div class="container">

		<div class="page-header">
	       <h1 class=" text-info">부가시설 등록</h1>
	    </div>

		<!-- Form Start -->
		<form class="form-horizontal" >
		
		<input type="hidden" name="campNo" id="campNo" value="${campSession.campNo}">
		
		<div class="form-group">
			<label for="subSiteNo" class="col-sm-offset-1 col-sm-3 control-label">등록 번호</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="subSiteNo" name="subSiteNo" value="${subSite.subSiteNo}" readonly>
				</div>
		</div>
			
		<div class="form-group">
			<label for="subSiteRegDate" class="col-sm-offset-1 col-sm-3 control-label">등록 일자</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="subSiteRegDate" name="subSiteRegDate" value="" readonly>
				</div>
		</div>

		<div class="form-group">
			<label for="subSiteType" class="col-sm-offset-1 col-sm-3 control-label">부가시설 유형</label>
			<div class="col-sm-4">
				<select name="subSiteType" class="form-control" >
					<option value="전기" selected="selected">전기</option>
					<option value="온수">온수</option>
					<option value="매점">매점</option>
					<option value="화장실">화장실</option>
					<option value="물놀이장">물놀이장</option>
					<option value="트램폴린">트램폴린</option>
					<option value="무선인터넷">무선인터넷</option>
					<option value="산책로">산책로</option>
				</select>
			</div>
		</div>
		
		
		<div class="form-group">
			<label for="subSiteName" class="col-sm-offset-1 col-sm-3 control-label">부가시설 이름</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="subSiteName" name="subSiteName" value="" placeholder="이름을 입력하세요">
				</div>
		</div>
		
		<div class="form-group">
			<label for="subSiteImgFile" class="col-sm-offset-1 col-sm-3 control-label">부가시설 이미지</label>				
				<div class="col-sm-4">
					<input type="file"  id="subSiteImgFile" name="subSiteImgFile">	
				</div>
		</div>
		
		<div class="form-group">
			<label for="subSiteInfo" class="col-sm-offset-1 col-sm-3 control-label">부가시설 설명</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="subSiteInfo" name="subSiteInfo" value="" placeholder="설명을 입력하세요">
				</div>
		</div>		

		<div class="form-group">
			<div class="col-sm-offset-4  col-sm-4 text-center">
				<button id="resetform" type="button" class="btn btn-primary">양식 초기화</button>
				<button id="cancle" type="button" class="btn btn-primary">취소</button>
				<button id="save" type="button" class="btn btn-primary">저장</button>
			</div>
		</div>

		</form>
		<!-- Form End -->
		
 	</div>
	<!-- Page End -->

</body>

</html>