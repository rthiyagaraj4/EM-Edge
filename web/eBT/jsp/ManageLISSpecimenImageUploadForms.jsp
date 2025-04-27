<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
	<head>
		
		<% request.setCharacterEncoding("UTF-8");%>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	
		<%


			String locale1 =	request.getParameter("language_id") == null ? "" : request.getParameter("language_id");
			String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");;
			String user_id = request.getParameter("user_id") == null ? "" : request.getParameter("user_id");
			String ws_no = user_id;
			String jdbc_props = "";


session.putValue("LOCALE",locale1);
//session.putValue("responsibility_id",direct_resp_id);
session.putValue("facility_id",facility_id);
session.putValue("login_user",user_id);
session.putValue("connection_pooling_yn","Y");

//System.out.println("entere here Photo_capture look up main 6");
Properties p = new Properties();
p.setProperty("login_user",user_id) ;
p.setProperty("connection_pooling_yn","Y") ;
p.setProperty("client_ip_address",ws_no) ;
p.setProperty("jdbc_props",jdbc_props) ;
p.setProperty("LOCALE",locale1) ;
session.putValue("jdbc",p ) ;
			/*session.putValue("responsibility_id","RL_MANAGER");
			session.putValue("facility_id","HS");
			session.putValue("login_user","NAREN");
			session.putValue("connection_pooling_yn","Y");
			Properties p = new Properties() ;
			p.setProperty( "login_user","NAREN" ) ;
			p.setProperty("connection_pooling_yn","Y") ;
			p.setProperty("client_ip_address","PANDIAN") ;
			p.setProperty("jdbc_props","") ;
			p.setProperty("LOCALE","en") ;
			session.putValue( "jdbc",p ) ;
			*/

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			//System.out.println ("eBT ManageLISImageSpecimen "+request.getQueryString());
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />


			<%		//System.out.println ("eBT ManageLISImageSpecimen 12");  %>
		<title><fmt:message key="Common.Specimen.label" bundle="${common_labels}"/> <fmt:message key="Common.Image.label" bundle="${common_labels}"/></title>


		
					<%		//System.out.println ("eBT ManageLISImageSpecimen 13");  %>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



					<%		//System.out.println ("eBT ManageLISImageSpecimen 14");  %>

	</head>
	<iframe name='fileUploadLinksFrame' id='fileUploadLinksFrame' src='../../eBT/jsp/ManageLISSpecimenImageUploadLinkForms.jsp?<%=request.getQueryString()%>' frameborder='0'  style='height:65vh;width:100vw'></iframe>
		<iframe name='fileUploadFrame' id='fileUploadFrame' src='../../eCA/jsp/blank.jsp' frameborder='0' scrolling='no' style='height:25vh;width:100vw'></iframe>
		<iframe name='fileUploadBlankFrame' id='fileUploadBlankFrame' src='../../eCommon/html/blank.html' frameborder='0'  style='height:0vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0'  style='height:10vh;width:100vw'></iframe>
	
</html>

