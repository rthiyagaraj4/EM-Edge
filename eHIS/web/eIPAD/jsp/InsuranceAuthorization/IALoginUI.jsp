<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%> 
<% 

String path = request.getContextPath(); 

String locale = (String)session.getValue("LOCALE");
locale = (locale == null || locale.equals(""))?"en":locale;
Connection con =null ;
con = ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
String product_name="";
String product_description="";
String version_info="";
String copyright_info="";
String site_name="";
try{
	String inst_info="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.SITE_NAME  SITE_NAME from sm_installation a,SM_SITE_PARAM_LANG_VW b where b.language_id='"+locale+"'";
	if(pstmt!=null)
		pstmt.close();
	pstmt=con.prepareStatement(inst_info) ;
	if(rs!=null)rs=null;
	rs=pstmt.executeQuery() ;
	if(rs!=null && rs.next()){
		product_name=rs.getString("PRODUCT_NAME");
		product_description=rs.getString("PRODUCT_DESCRIPTION");
		version_info=rs.getString("VERSION_NO");
		copyright_info=rs.getString("COPYRIGHT_INFO");
		site_name=rs.getString("SITE_NAME");
		}
	if(version_info==null || version_info.equals(""))
		version_info="";
	if(copyright_info==null || copyright_info.equals(""))
		copyright_info="";
	session.setAttribute("version_no",version_info);
	session.setAttribute("product_description",product_description);
	
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
<!DOCTYPE html >
<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="apple-mobile-web-app-capable" content="yes" />   
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<!-- <link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  -->
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<%--   --%>
	<script src="<%=path%>/eIPAD/js/IALoginUI.js"></script> 
	<!--    -->
	<%-- <link rel="stylesheet" href="<%=path%>/eIPAD/css/iPADNew.css" /> 
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/iPADThemeA.css" />--%>
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/mLogin.css" /> 
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/mCommon.css" />
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/iPADThemeA.css" /> 
	<title>eHIS Mobile Login</title>
	
	<script type="text/javascript">
	var contextPath = "<%=path%>";
	document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
	
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
</head>


<body class="mbody">
	<div id="dvMez" class="blurPopup" date-popid="" onclick="popClose()"></div>
<!-- login html starts -->
	<form id='login_form' name='login_form' id='login_form' method="post" action="<%=path%>/ialogin" class="mform">
		<div class="login_bg_layout bg1-theme" >
   			<div class="login_header_area">
       			<div class="login_header_corner bgRight-theme"></div>
       		</div>
       
       		<div class="login_middle_area">
	        	<div class="login_middle_area_center bgMiddle-theme">
	            	<div class="login_layout loginFldsLayout-theme">
	                	<div class="login_header_title bg3-theme">
	                    	<div class="login_header_left bgHeaderLeft-theme"  ></div>                
	                    	<div class="login_header_right bgHeaderRight-theme"></div>
	                    </div>
                   
	                    <div class="login_black_title">
	                		<div class="login_black_left bgDropLeft-theme"></div>                
	                    	<div class="login_black_right bgDropRight-theme"></div>
	                    </div>
                    
                  		<div class="login_table_login bgLoginTable-theme">  
	                    	<div class="login_logo"> 
		                    	<div style="display:table;width:100%;height:100%">
		                    		<div style="display:table-row;">
		                    			<div style="display:table-cell;width:80px;vertical-align:middle;text-align:left">
		                    				<img src="<%=path%>/eCommon/jsp/DisplayImages.jsp?param=clientlogo" width="56" height="54" id='headerImageID' valign="middle">
		                    			</div>
		                    			<div style="display:table-cell;vertical-align:middle;text-align:center">
		                    				<div class="widgetHeaderHeadingTextTheme"><%=site_name%></div>
		                    			</div>
		                    		</div>
		                    	</div>
	                    	</div>
	                    	
	                		<div class="login_uname normText1-theme">Username</div>
	                 
			                <div class="login_uname_textbox normText1-theme">
		                    	<input class="login_textbox txtBox1-theme" id='name' name='name' id='name' type="text"/>
		                    </div>
	                  
	                		<div class="login_pwd"></div>
	                    
	                    	<div class="login_pwd normText1-theme" >Password</div>
	                 
		                	<div class="login_pwd_textbox normText1-theme">
		                    	<input class="login_textbox txtBox1-theme" type='password' id='password' name='password' id='password' />
		                    </div>
	                    
	                    	<div class="login_pwd"></div>
	                    
		                    <div class="login_login_butto">
		                    	<input type="submit" value="Login" class="login_classname btn1-theme" data-inline="true" onclick="submit_user_pwd()" />
		                    </div>

                    	</div>
                	</div>
				</div>
        	</div>
        
        	<div class="login_footer_area">
        		<div class="login_footer_area_corner bgLeft-theme"  >
            	<div class="login_footer_text footerText-theme" onclick="popOpen('CopyrightPop')">&copy; <%=copyright_info %> <span class="login_footer_text_image"> <img src="<%=path%>/eIPAD/images/CSC.png"/> </span></div></div>
        	</div>
        	<div style="" class="copyrightPop copyrightPopTheme" id="CopyrightPop">
        		<div class="copyrightCloseTheme" onclick="popIdClose('CopyrightPop')">x</div>
        		<div class="copyrightTextHeadTheme copyrightHead" style="">Copyright & License notice:</div>
        		<div class="copyrightTextTheme copyrightText">&copy; <%=copyright_info %></div>
        		<div class="copyrightTextTheme copyrightText">Use of this product is subject to the Enterprise Management license agreement.</div>
        		<div class="copyrightWarnTheme copyrightText"><span class="copyrightWarnHeadTheme">Warning: </span>This computer program is protected by copyright law and international treaties. Unauthorized reproduction or distribution of this program, or any portion of it, may result in severe civil and criminal penalties, and will be prosecuted to the maximum extent possible under the law.</div>
        		<div class="copyrightTextHeadTheme copyrightHead">Trademark notice:</div>
        		<div class="copyrightTextTheme copyrightText">&copy; CSC, the CSC logo, Enterprise Management, and csc.com are trademarks or registered trademarks of Computer Sciences Corporation, registered in the United States and other jurisdictions worldwide. Other product and service names might be trademarks of CSC or other companies.</div>
    		</div>
    	
    	
    	</div>
    	
	    <!-- login html ends -->
	    
		<input type="hidden" name="mode" id="mode" value="begin"/> 
		<input type="hidden" name="responsibility_id" id="responsibility_id" id="responsibility_id" value=""/>
		<input type="hidden" name="responsibility_name" id="responsibility_name" id="responsibility_name" value=""/> 
		<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value=""/> 
		<input type="hidden" name="login_user" id="login_user" id="login_user" value="null"/>
		<input type="hidden" name="facility_name" id="facility_name" id="facility_name" value=""/> 
		<input type="hidden" name="level" id="level" id="level" value="1"/> 
		<input type="hidden" name="clientIP" id="clientIP" id="clientIP" value=""/> 
		<input type="hidden" name="user" id="user" id="user" value=""/> 
		<input type="hidden" name="compname" id="compname" value="IPAD" id="compname"/> 
		<input type="hidden" name="domain" id="domain" id="domain" value=""/> 
		<input type="hidden" name="error_num" id="error_num" id="error_num" value="0"/> 
		<input type="hidden" name="locale" id="locale" id="locale" value="en"/>
		<input type="hidden" name="RespFaciList" id="RespFaciList" id="RespFaciList" value="en"/>
	</form>
</body>
</html>
    

