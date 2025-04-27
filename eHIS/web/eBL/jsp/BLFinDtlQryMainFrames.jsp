<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String strAllParam = "", strSetInd = "", strAdmFlag = ""; 
	String fin_class_flag_YN="N", strCaldFrmClassFinDtls="";

	try
	{
		strAllParam = request.getQueryString();
		if(strAllParam == null) strAllParam="";
//System.err.println("Query String in MainFrames.jsp:"+strAllParam);
		fin_class_flag_YN= request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="N";

		strCaldFrmClassFinDtls = request.getParameter("strCaldFrmClassFinDtls");
		if(strCaldFrmClassFinDtls == null) strCaldFrmClassFinDtls="";

		strSetInd = request.getParameter("strSetInd");
		if(strSetInd == null) strSetInd="";

		strAdmFlag = request.getParameter("strAdmFlag");
		if(strAdmFlag == null) strAdmFlag="";
%>			
<html>
<head>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<form>
</form>
</body>
<style>
textarea {
  resize: none;
}
</style>
<%
		if(fin_class_flag_YN.equals("N") ||(fin_class_flag_YN.equals("Y") && strCaldFrmClassFinDtls.equals("F")))
		{
//	System.err.println("Inside Financial Dtls Frames");
		    if((strSetInd.equals("X")) && (strAdmFlag.equals("2")))
			{
%>
	
<iframe name='query1' id='query1'	src="BLFinDtlQry1.jsp?<%=strAllParam%>"  frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' noresize style='height:0vh;width:100vw'></iframe>
<iframe name='query3' id='query3'	src="BLFinDtlQry2.jsp?<%=strAllParam%>"  frameborder=0 scrolling='auto' noresize style='height:25vh;width:100vw'></iframe>
<iframe name='query4' id='query4'	src="BLFinDtlQry3.jsp?<%=strAllParam%>"  frameborder=0 scrolling='auto' noresize style='height:28vh;width:100vw'></iframe>
<iframe name='query2' id='query2'	src="BLFinDtlQry4.jsp?<%=strAllParam%>"  frameborder=0 scrolling='auto' noresize style='height:11vh;width:100vw'></iframe>
<iframe name='query2' id='query2'	src="BLFinDtlQryBtn.jsp"  frameborder=0 scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>


<%
			}
			else
			{
%>

<iframe name='query1' id='query1'	src="BLFinDtlQry1.jsp?<%=strAllParam%>"  frameborder=0 scrolling='no' noresize  style='height:25vh;width:100vw'></iframe>
<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' noresize style='height:0vh;width:100vw'></iframe>
<iframe name='query3' id='query3'	src="BLFinDtlQry3.jsp?<%=strAllParam%>"  frameborder=0 scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>
<iframe name='query2' id='query2'	src="BLFinDtlQry4.jsp?<%=strAllParam%>"  frameborder=0 scrolling='auto' noresize style='height:11vh;width:100vw'></iframe>
<iframe name='query2' id='query2'	src="BLFinDtlQryBtn.jsp"  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>



<%
			}
		}
		else if(fin_class_flag_YN.equals("Y") && strCaldFrmClassFinDtls.equals("C"))
		{
//	System.err.println("Inside Financial Class Frames");
%>
	
<iframe name='query1' id='query1'	src="BLFinClassDtlQry.jsp?<%=strAllParam%>"  frameborder=0 scrolling='auto' noresize style='height:95vh;width:100vw'></iframe>
<iframe name='query2' id='query2'	src="BLFinDtlQryBtn.jsp"  frameborder=0 scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>


<%
		}
	}
	catch(Exception eX)
	{
		System.out.println("Error in QryMain.jsp= "+eX);
	}
%>
</html>

