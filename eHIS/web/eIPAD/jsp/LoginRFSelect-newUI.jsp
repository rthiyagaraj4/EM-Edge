<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%
String product_description = "";
String version_no = "";
String path = request.getContextPath();
ArrayList<String> RespIdArrayList = new ArrayList<String>();
ArrayList<String> RespNameArrayList = new ArrayList<String>();
ArrayList<String> FacilityIdArrayList = new ArrayList<String>();
ArrayList<String> FacilityNameArrayList = new ArrayList<String>();
int RespCount = 0;
int FacilityCount = 0;



if(request.getAttribute("LoginRespIdArray") != null)
{
	RespIdArrayList = (ArrayList<String>)request.getAttribute("LoginRespIdArray");
}
if(request.getAttribute("LoginRespNameArray") != null)
{
	RespNameArrayList = (ArrayList<String>)request.getAttribute("LoginRespNameArray");
}
if(request.getAttribute("LoginFacilityIdArray") != null)
{
	FacilityIdArrayList = (ArrayList<String>)request.getAttribute("LoginFacilityIdArray");
}
if(request.getAttribute("LoginFacilityNameArray") != null)
{
	FacilityNameArrayList = (ArrayList<String>)request.getAttribute("LoginFacilityNameArray");
}
if(request.getAttribute("LoginRespCount") != null)
{
	RespCount = (Integer)request.getAttribute("LoginRespCount");
}
if(request.getAttribute("LoginFacilityCount") != null)
{
	FacilityCount = (Integer)request.getAttribute("LoginFacilityCount");
}
if(session.getAttribute("version_no") != null)
{
	version_no = (String)session.getAttribute("version_no");
}
if(session.getAttribute("product_description") != null)
{
	product_description = (String)session.getAttribute("product_description");
}
%>

<%-- Code for getting copyright text --%>
<%
String locale = (String)session.getValue("LOCALE");
locale = (locale == null || locale.equals(""))?"en":locale;
Connection con =null ;
con = ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
String copyright_info="";
try{
	String inst_info="select a.COPYRIGHT_INFO COPYRIGHT_INFO from sm_installation a,SM_SITE_PARAM_LANG_VW b where b.language_id='"+locale+"'";
	if(pstmt!=null)
		pstmt.close();
	pstmt=con.prepareStatement(inst_info) ;
	if(rs!=null)rs=null;
	rs=pstmt.executeQuery() ;
	if(rs!=null && rs.next()){
		copyright_info=rs.getString("COPYRIGHT_INFO");
	}
	if(copyright_info==null || copyright_info.equals(""))
		copyright_info="";
	
}catch(Exception ex){
	ex.printStackTrace();
}finally{
	if(rs!=null)
		rs.close();
	if(pstmt!=null)
		pstmt.close();
	if(con!=null)
		con.close();
}

%>
<%-- Code for getting copyright text Ends--%>


<!DOCTYPE html> 
<html> 
<head> 
	<title>Login Responsibility Facility Select</title>   
	<meta name="apple-mobile-web-app-capable" content="yes" />   
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<link rel="stylesheet" href="<%=path%>/eIPAD/jquery.mobile-1.0a4.1.min.css" />
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	    
	<script src="<%=path%>/eIPAD/js/loginIpad-newUI.js"></script> 
	<script type="application/javascript" src="<%=path%>/eIPAD/js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%-- 	<link rel="stylesheet" href="<%=path%>/eIPAD/css/iPADNew.css"  /> 
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/iPADThemeA.css" />  --%>
		<link rel="stylesheet" href="<%=path%>/eIPAD/css/mLogin.css" /> 
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/mCommon.css" /> 
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/iPADThemeA.css" /> 
	<script>
	var contextPath = "<%=path%>";
	var totalItemsCount = "<%=RespNameArrayList.size()%>";
	
	
	document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
	var myScroll;
	 
	function AssignRespScroller() {
		myScroll = new iScroll('RespSelectWrapper', {
			snap: true,
			momentum: false,
			hScrollbar: false, 
			onScrollEnd: function () {
				document.querySelector('#RespSelectIndicator > li.active').className = '';
				document.querySelector('#RespSelectIndicator > li:nth-child(' + (this.currPageX+1) + ')').className = 'active'; 
			}
		 });
	}
	document.addEventListener('DOMContentLoaded', AssignRespScroller, false);
	function setPaginationDots(){
		var itemWidth = $(".loginRespSelectItemOuterBox").width() + 12; //12px for margin+border
		//alert("itemWidth "+itemWidth);
		var wrapperWidth = $("#RespSelectWrapper").width();
		//alert("wrapperWidth "+wrapperWidth);
		var itemHeight = $(".loginRespSelectItemOuterBox").height() + 12; //12px for margin+border
		//alert("itemHeight "+itemHeight);
		var wrapperHeight = $("#RespSelectWrapper").height();
		//alert("wrapperHeight "+wrapperHeight);
		var eachPageContainsRows = Math.floor(wrapperWidth/itemWidth);
		//alert("eachPageContainsRows "+eachPageContainsRows);
		var eachPageContainsCols = Math.floor(wrapperHeight/itemHeight);
		//alert("eachPageContainsCols "+eachPageContainsCols);
		var eachPageContains = eachPageContainsRows * eachPageContainsCols;
		//alert("eachPageContains "+eachPageContains);
		var totalPages = Math.ceil(totalItemsCount/eachPageContains);
		//alert("totalPages "+totalPages); 
		var scrollerWidth = wrapperWidth * totalPages;
		$("#RespSelectScroller").css("width",scrollerWidth+"px");
		$("#RespSelectIndicator").empty();
		for(var i=0;i<totalPages;i++){
			$("<li></li>").appendTo("#RespSelectIndicator");
		}
		$("#RespSelectIndicator li").first().addClass("active");
		myScroll.scrollToPage(0, 0);
	} 
	


	$(document).ready(function() {
		setPaginationDots();
		if (window.DeviceOrientationEvent) {
			window.addEventListener('orientationchange',
					setPaginationDots, false);
		}
	});
	
	function popOpen(id){
		$("#"+id).show();
		$("#dvMez").show();
		$("#dvMez").data("popid",id);
	}
	function popClose(){
		$("#dvMez").hide();
		var popid = $("#dvMez").data("popid");
		$("#"+popid).hide();
		$("#dvMez").data("popid","");
	}
	function popIdClose(id){
		$("#dvMez").hide();
		$("#"+id).hide();
		$("#dvMez").data("popid","");
	} 

	</script>
	
<style>


</style>

<% 
	int NUMBEROFROWS = 2;
%>
</head>

<body>
	<div id="divParent" class="mdivParent" data-role="page">
	<div id="dvMez" class="blurPopup" date-popid="" onclick="popClose()" data-role="none"></div>
	<div style="" class="copyrightPop copyrightPopTheme" id="CopyrightPop" data-role="none">
   		<div class="copyrightCloseTheme" onclick="popIdClose('CopyrightPop')" data-role="none">x</div>
   		<div class="copyrightTextHeadTheme copyrightHead" style="" data-role="none">Copyright & License notice:</div>
   		<div class="copyrightTextTheme copyrightText" data-role="none">&copy; <%=copyright_info%></div>
   		<div class="copyrightTextTheme copyrightText" data-role="none">Use of this product is subject to the Enterprise Management license agreement.</div>
   		<div class="copyrightWarnTheme copyrightText" data-role="none"><span class="copyrightWarnHeadTheme">Warning: </span>This computer program is protected by copyright law and international treaties. Unauthorized reproduction or distribution of this program, or any portion of it, may result in severe civil and criminal penalties, and will be prosecuted to the maximum extent possible under the law.</div>
   		<div class="copyrightTextHeadTheme copyrightHead" data-role="none">Trademark notice:</div>
   		<div class="copyrightTextTheme copyrightText" data-role="none">&copy; CSC, the CSC logo, Enterprise Management, and csc.com are trademarks or registered trademarks of Computer Sciences Corporation, registered in the United States and other jurisdictions worldwide. Other product and service names might be trademarks of CSC or other companies.</div>
    </div>
	  <form id='login_form' name='login_form' id='login_form' class="mform" method="post" action="<%=path%>/eIPAD/jsp/IPad.jsp">
		<div id="divTable" class = "mdivTable" data-role = "none">
		 	<div data-role = "none" class = "mheaderRow"><!-- header starts -->
				<table class="mheader grd1-theme" border = "0" cellspacing = "0" cellpadding = "0">
			        <tr style = "width:100%;height:100%">
						<td style = "width:90%;height:100%" align = "left" ><span class="mheaderText headerText1-theme"><%=product_description%> - <%=version_no%></span></td>
						<td style = "width:10%;height:100%" valign = "center" align = "right" onclick = "logout()">
							<img src = "<%=path%>/eIPAD/images/Logout1.png" class="mHeaderImgLogout" ></img>
						</td>
			        </tr>
		       </table>
		   </div><!-- div first row header ends  -->
		   	<div class="bg1-theme" style="display:table-row">
				<div class="loginRespSelectTxt headingText1-theme">Choose Responsibility and Facility</div>
			</div>


			<div data-role = "none" class = "loginRespRow2 bg1-theme">
		   		<div data-role="none" style="display:table-cell;vertical-align:middle;text-align:center;">
					<div id="RespSelectWrapper" class="loginRespSelWrapper">
						<div id="RespSelectScroller" style="height:100%;">
							<div class="loginRespSelectPage">
								<div style="display:table-row">
								<%for(int i= 0; i<RespNameArrayList.size(); i=i+NUMBEROFROWS){ %>
									<div style="display:table-cell">
										<div class="loginRespSelectItemOuterBox border1-theme" style="text-align: center;">
											<div class="loginFacilityBox grd2-theme border2-theme" id="FacilityBox_<%=RespIdArrayList.get(i)%>" style="display:none"></div>
											<div class="loginFaciImageBox grd2-theme border2-theme" id="RespSelectImage_<%=RespIdArrayList.get(i)%>">
												<div class="loginRoleProfileIconImage"><image src="<%=path%>/eIPAD/images/RoleProfileIcon.png"/></div>
											</div>
											<div class="loginRespSelectRespButton btn2-theme normText2-theme" id="RespSelectRespButton_<%=RespIdArrayList.get(i)%>" onclick="change_resp('<%=RespIdArrayList.get(i)%>','<%=RespNameArrayList.get(i)%>')" data-role = "none"> 
												<div style="display:table-cell;vertical-align:middle;width:195px;height:52px">
													<%= RespNameArrayList.get(i)%>
													<div id="FacilityShowImage_<%=RespIdArrayList.get(i)%>"><image src="<%=path%>/eIPAD/images/FacilityExpand.png"/></div>
												</div>
											</div>
										</div>
									</div>
								<%} %>
								</div>
								<div style="display:table-row">
								<%for(int i= 1; i<RespNameArrayList.size(); i=i+NUMBEROFROWS){ %>
									<div style="display:table-cell">
										<div class="loginRespSelectItemOuterBox border1-theme" style="text-align: center;">
											<div class="loginFacilityBox grd2-theme border2-theme" id="FacilityBox_<%=RespIdArrayList.get(i)%>" style="display:none"></div>
											<div class="loginFaciImageBox grd2-theme border2-theme" id="RespSelectImage_<%=RespIdArrayList.get(i)%>">
												<div class="loginRoleProfileIconImage"><image src="<%=path%>/eIPAD/images/RoleProfileIcon.png"/></div>
											</div>
											<div class="loginRespSelectRespButton btn2-theme normText2-theme" id="RespSelectRespButton_<%=RespIdArrayList.get(i)%>" onclick="change_resp('<%=RespIdArrayList.get(i)%>','<%=RespNameArrayList.get(i)%>')" data-role = "none"> 
												<div style="display:table-cell;vertical-align:middle;width:195px;height:52px">
													<%= RespNameArrayList.get(i)%>
													<div id="FacilityShowImage_<%=RespIdArrayList.get(i)%>"><image src="<%=path%>/eIPAD/images/FacilityExpand.png"/></div>
												</div>
											</div>
										</div>
									</div>
								<%} %>
								</div>
							</div>
			   			</div>
			   		</div>
				</div>
			</div>
		   
  
			<div class="loginRespSelectPageNav bg1-theme">
				<div style="display:table-cell;vertical-align:middle;text-align: center;" data-role="none">
					<div style="display:inline-block">
						<ul id="RespSelectIndicator" class="loginRespSelectIndicator pagi1-theme">
						
							<!-- <li class="active"></li> -->
								
						</ul>
					</div>
				</div>
			</div>

	
			<div data-role = "none" class = "mfooter" ><!-- Footer start  -->
				<div class = "mfooterContent border3Top-theme grd3-theme" data-role = "none">
					<table style = "width:100%;height:100%" border = "0" cellspacing = "0" cellpadding = "0">
				    	<tr style = "width:100%;height:100%">
				        	<td style = "width:50%;height:100%" valign = "top">
				         	</td>
				         	<td style = "width:50%;height:100%" align = "right" valign = "top" onclick="popOpen('CopyrightPop')">
				         		<span class="mcopyrightsText cpyRightTxt-theme" onclick="popOpen('CopyrightPop')">&copy; <%=copyright_info%></span>
				        		<img src="<%=path%>/eIPAD/images/CSC_Logo.png" class="mimgCopyRights"></img>
				         	</td>
				      	</tr>
				    </table>
				</div>    
		   	</div><!-- div footerends here -->
		</div> <!-- div table ends here -->
		 	<input type="hidden" name="RespCount" id="RespCount" value="<%=RespCount%>"/> 
			<input type="hidden" name="mode" id="mode" value="begin"/> 
			<input type="hidden" name="responsibility_id" id="responsibility_id" id="responsibility_id" value=""/>
			<input type="hidden" name="responsibility_name" id="responsibility_name" id="responsibility_name" value=""/> 
			<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value=""/> 
			<input type="hidden" name="login_user" id="login_user" id="login_user" value="null"/>
			<input type="hidden" name="facility_name" id="facility_name" id="facility_name" value=""/> 
			<input type="hidden" name="level" id="level" id="level" value=""/> 
			<input type="hidden" name="clientIP" id="clientIP" id="clientIP" value=""/> 
			<input type="hidden" name="user" id="user" id="user" value=""/> 
			<input type="hidden" name="compname" id="compname" value="IPAD" id="compname"/> 
			<input type="hidden" name="domain" id="domain" id="domain" value=""/> 
			<input type="hidden" name="error_num" id="error_num" id="error_num" value="0"/> 
			<input type="hidden" name="locale" id="locale" id="locale" value="en"/>
	  </form>
	</div>
</body>
</html>

