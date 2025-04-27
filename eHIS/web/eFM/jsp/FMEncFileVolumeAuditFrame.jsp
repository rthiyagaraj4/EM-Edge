<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
      <%
      request.setCharacterEncoding("UTF-8");
       String sStyle	=
      (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	  %>
	  
	    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eFM/js/FMEncFileVolumeAudit.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<TITLE> <fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/> </TITLE>
<% 
	StringBuffer sourceBuffer = new StringBuffer();

	String url							= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params						= request.getQueryString() ;
	String facilityId					= (String)session.getValue("facility_id");
	String user_security_yn				= "N";
	String link_bet_file_and_enctr_yn	= "N";
	int userAccessCount					= 0;
	String showPline					= checkForNull( request.getParameter("showPline"),"Y");
		
	Connection con			=	null;
	sourceBuffer.append(url);
	sourceBuffer.append(params);

	try {
		
		con		=	ConnectionManager.getConnection(request);

		JSONObject jsonObj				= eFM.FMLinkEncFileVolumeBean.getFMParamValues(con,facilityId);
		user_security_yn				= checkForNull((String) jsonObj.get("user_security_yn"),"N");
		link_bet_file_and_enctr_yn		= checkForNull((String) jsonObj.get("link_bet_file_and_enctr_yn"),"N");
		if("Y".equals(user_security_yn)){
			if("Y".equals(link_bet_file_and_enctr_yn)){
				userAccessCount			= eFM.FMLinkEncFileVolumeBean.getFMUserAccessRightsCount(con,facilityId);
				if(userAccessCount == 0){
					%>
					<script> 
						alert(getMessage("FM_NO_USER_RIGHTS","FM")); 
						parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; 
					</script>
					<%
				}

			}else{
				%>
					<script> 
						alert(getMessage("FM_PARAM_NOT_AVAILABLE","FM")); 
						parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; 
					</script>
				<%
			}

		}
	}catch(Exception exception)	{
		
		out.println(exception.toString());
	
	}finally {		
		
		ConnectionManager.returnConnection(con,request);
	
	}
 %>
<%if(!showPline.equals("N")){%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=sourceBuffer.toString()%>' frameborder='0' scrolling=no noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='criteria_frame' id='criteria_frame' src='../../eFM/jsp/FMEncFileVolumeAuditCriteria.jsp' frameborder='0' scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
	<iframe name='patient_line_frame' id='patient_line_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='result_frame' id='result_frame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:64vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder='0' noresize style='height:8vh;width:100vw'></iframe>
 
 <%}else{%>
	<iframe name='criteria_frame' id='criteria_frame' src='../../eFM/jsp/FMEncFileVolumeAuditResult.jsp?<%=params%>' frameborder='0' scrolling='yes' noresize style='height:92vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder='0' noresize style='height:8vh;width:100vw'></iframe>
	 
 <%}%>
</html>

<%!
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

