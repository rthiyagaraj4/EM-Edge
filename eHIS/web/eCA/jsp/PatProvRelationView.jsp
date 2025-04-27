<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
   <!-- <link rel="stylesheet" type="text/css" href="/eCA/eCommon/html/IeStyle.css"> -->
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String reln_req_yn="";
	String firstFrameSrc  = "";
	String secondFrameSrc = "";

	reln_req_yn	=	request.getParameter("reln_req_yn");
	if(reln_req_yn == null || reln_req_yn.equals("null"))reln_req_yn="N";

	if(reln_req_yn.equals("Y"))
	{
		firstFrameSrc  = "../../eCA/jsp/PatProvRelationCreteria.jsp?";
		secondFrameSrc = "../../eCA/jsp/PatProvRelationResult.jsp?";
	}
	else
	{
		firstFrameSrc  = "../../eCA/jsp/PatProvRelationCreteria.jsp?";
		secondFrameSrc = "../../eCA/jsp/PatProvRelationResult.jsp?";
		/*out.println("<script>alert(getMessage('CA_ENC_RELN_NO'));</script>");
		firstFrameSrc  = "../../eCommon/html/blank.html?";
		secondFrameSrc = "../../eCommon/html/blank.html?";*/
	}

%>
<!-- Modified by Kihore Kumar N on 06/12/2008 
altered framset size-->
<iframe name="PatProvrelationCreteriaFrame" id="PatProvrelationCreteriaFrame" frameborder="no" noresize scrolling='no' src="<%=firstFrameSrc%><%=request.getQueryString()%>" style='height:22vh;width:100vw'></iframe>
	<iframe name="PatProvrelationResultFrame" id="PatProvrelationResultFrame" frameborder="no" noresize scrolling='auto'  src="<%=secondFrameSrc%><%=request.getQueryString()%>&lifetime=3&self=1&active=1&encounter=2" style='height:75vh;width:100vw'></iframe>

</html>

