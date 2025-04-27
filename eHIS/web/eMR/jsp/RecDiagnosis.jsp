<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper"%>
<% request.setCharacterEncoding("UTF-8"); 
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue%>

<html>
<head>
	<title><fmt:message key="eMR.RecordDiagnosis.label" bundle="${mr_labels}"/></title>
<%	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript'>
	
	/*function getMessageFrame()
	{
		if(top.content!=null){
			return top.content.messageFrame;
		}else{
			return top.messageframe;
		}
	}
	var messageFrameReference = getMessageFrame();
	function clearMessageFrame()
	{
		messageFrameReference.location.href = '../../eCommon/jsp/error.jsp';
	}*/
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
		request.setCharacterEncoding("UTF-8");
		String modal_yn				= request.getParameter("modal_yn");
		String queryString			= request.getQueryString();
		String function_id = request.getParameter("function_id"); //function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
		
	   

		String restorative_Chart=request.getParameter("called_from_OH");
		session.setAttribute("restorative_Chart",restorative_Chart);

		RecordSet OHDiagLinkConditionOBJ	=	(webbeans.eCommon.RecordSet)	session.getAttribute("OHDiagLinkConditionOBJ");
		if(OHDiagLinkConditionOBJ!=null)
		{
			OHDiagLinkConditionOBJ.clearAll();
			session.removeAttribute("OHDiagLinkConditionOBJ");
		}

		if(modal_yn==null)
		{
			modal_yn	=	"Y";
			queryString= "modal_yn="+modal_yn+"&"+queryString;
		}

		
		
		
	%>
</head>
<iframe name="RecDiagnosisFrame" id="RecDiagnosisFrame" frameborder="no" scrolling="no" noresize src="../../eMR/jsp/RecDiagnosisTabs.jsp?<%=queryString%>" style="height:0vh;width:100vw"></iframe>
<iframe name="RecDiagnosisMain" id="RecDiagnosisMain" frameborder="no" scrolling="auto" noresize src='../../eMR/jsp/RecDiagnosisMain.jsp?<%=queryString%>' style='height:97vh;width:100vw'></iframe>


</html>

