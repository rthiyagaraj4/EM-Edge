<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCA/js/ManageLISSpecimenImage.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
</head>
<body class='message'>
<%
String dept = request.getParameter("dept") == null ? "" : request.getParameter("dept");
String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");
String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
String recCnt = request.getParameter("recCount") == null ? "0" : request.getParameter("recCount");
String p_resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
String error = request.getParameter("error") == null ? "" : request.getParameter("error");
int recCount = Integer.parseInt(recCnt);

Connection con = null;
PreparedStatement pstmt = null;
ResultSet res = null;

String catCode = "";
String appServerURL = "";

if(facilityId.equals("")) 
facilityId = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");

try
{
	if(p_resp_id.equals("RL_MANAGER"))
	{
		con = ConnectionManager.getConnection();
	}
	else
	{
		con = ConnectionManager.getConnection(request);
	}
	
	if(!calledFrom.equals("Servlet") && !calledFrom.equals("viewImage"))
	{		
		pstmt = con.prepareStatement("SELECT short_desc, category_code FROM RL_CATEGORY_CODE_LANG_VW WHERE operating_facility_id = ? AND section_code = ? AND LANGUAGE_ID = ? ORDER BY 1");

		pstmt.setString(1,facilityId);
		pstmt.setString(2,dept);
		pstmt.setString(3,locale);
		res = pstmt.executeQuery();

		out.println("<script>");
		out.println("var tempCnt = parseInt(parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.options.length,10)");
		out.println("for(var t=0;t<tempCnt;t++)");
		out.println("{");			out.println("parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.remove(\"parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.options[LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.option(t)]\"); ");
		out.println("parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.remove(\"parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.options[LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.option(t)]\"); ");
		out.println("}");

		out.println("var selObj = document.createElement(\"Option\");");
		out.println("selObj.value='' ");
		out.println("selObj.text='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"'");
		out.println("parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.add(selObj)");
		out.println("var selObj = document.createElement(\"Option\");");
		out.println("selObj.value='' ");			out.println("selObj.text='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"'");
		out.println("parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.add(selObj)");
		out.println("</script>");
		while(res.next())
		{
			catCode = res.getString("category_code") == null ? "" : res.getString("category_code");
			out.println("<script>var selObj = parent.LISSpecQueryFrame.document.createElement(\"Option\")</script>");
			out.println("<script>selObj.value = \""+catCode+"\"</script>");
			out.println("<script>selObj.text = \""+catCode+"\"</script>");	
			out.println("<script>parent.LISSpecQueryFrame.document.LISSpecQueryForm.fromCatNum.add(selObj)</script>");
			out.println("<script>var selObj = parent.LISSpecQueryFrame.document.createElement(\"Option\")</script>");
			out.println("<script>selObj.value = \""+catCode+"\"</script>");
			out.println("<script>selObj.text = \""+catCode+"\"</script>");				
			out.println("<script>parent.LISSpecQueryFrame.document.LISSpecQueryForm.toCatNum.add(selObj)</script>");
		}
		if(res != null) res.close();
		if(pstmt != null) pstmt.close();
	}			
	else if(calledFrom.equals("Servlet"))
	{
		if(!error.equals("Y"))
		{
			out.println("APP-SM0001 Operation Completed Successfully ...");					
			out.println("<script>parent.window.fileUploadLinksFrame.location.href = parent.window.fileUploadLinksFrame.location.href</script>");
			out.println("<script>parent.window.fileUploadFrame.location.href = '../../eCommon/html/blank.html'</script>");
		}
		else
		{
			out.println("<script>alert(getCAMessage('INVALID_IMAGE'));</script>");
		}
	}// added by Sanjay for Delete Image Functionality on 17-May-13
	else if(calledFrom.equals("ServletDelete"))
	{
		if(!error.equals("Y"))
		{
			//out.println("APP-SM0001 Operation Completed Successfully ...");
			//out.println("<script>alert('ServletDelete');</script>");
			out.println("APP-SM0001 Deleted ...");
			out.println("<script>parent.parent.window.fileUploadLinksFrame.location.href = parent.window.fileUploadLinksFrame.location.href</script>");
			//out.println("<script>parent.window.fileUploadFrame.location.href = '../../eCommon/html/blank.html'</script>");
		}
		else
		{
			out.println("<script>alert(getCAMessage('INVALID_IMAGE'));</script>");
		}
	}
	else if(calledFrom.equals("viewImage"))
	{
		String specNum = request.getParameter("specNum") == null ? "" : request.getParameter("specNum");
		String test = request.getParameter("test") == null ? "" : request.getParameter("test");
		String sampleId = request.getParameter("sampleId") == null ? "" : request.getParameter("sampleId");
		String anatomy = request.getParameter("anatomy") == null ? "" : request.getParameter("anatomy");
		String calledFromForms = request.getParameter("calledFromForms") == null ? "" : request.getParameter("calledFromForms");
		//Added by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
		String secCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");

		pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM RL_EXT_INTERFACE_PARAM where EXT_APPL_ID='LBIMG'  ");
		res = pstmt.executeQuery();

		while(res.next())
		{
			appServerURL = res.getString("APP_SERVER_URL") == null ? "" : res.getString("APP_SERVER_URL");
		}

		if(res != null) res.close();
		if(pstmt != null) pstmt.close();

		// added by Sanjay for Image Delete Logic on 07-May-13
		out.println("<script>");		
		//Sanjay for removing Delete Option when viewed from Review

		//Modified by Sanjay on 17-Mar-15 against ML-BRU-SCF-1502(IN052800)
		out.println("window.showModalDialog(\"../../eBT/jsp/ManageLISSpecimenImageLinksForImage.jsp?specNum="+specNum+"&p_resp_id="+p_resp_id+"&test="+test+"&sampleId="+sampleId+"&secCode="+secCode+"&calledFromForms="+calledFromForms+"&anatomy="+anatomy+"&recCount="+recCount+"&facility_id="+facilityId+"\",'Document','dialogHeight:15;dialogWidth:25;dialogTop:200;location:no;menubar:no;status:no;scrollbars:yes');");
		out.println("parent.frames[0].document.location.reload()");
		out.println("</script>");
		
	}
}//end of try
catch(Exception e)
{
	//System.out.println("Exception in try of ManageLISSpecimenImageIntermediate.jsp --"+e.toString());
	e.printStackTrace(System.err);
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

<form name='LISImageForm' id='LISImageForm'>
</form>
</body>
</html>

