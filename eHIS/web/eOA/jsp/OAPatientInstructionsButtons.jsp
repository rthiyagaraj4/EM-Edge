<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.* ,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//String locale=(String)session.getAttribute("LOCALE");
	//String facilityId = (String) session.getValue( "facility_id" ) ;
	//Connection connection = null;
	//Statement stmt = null;
	//ResultSet rset = null;
	//int recCount=0;

%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	  
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>       
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eOA/js/OAPatientInstructions.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String viewinsdtlsYN=request.getParameter("viewinsdtlsYN")==null?"N":request.getParameter("viewinsdtlsYN");
	String clinicInsYN=request.getParameter("clinicInsYN")==null?"N":request.getParameter("clinicInsYN");
	//String orderInsYN=request.getParameter("orderInsYN")==null?"N":request.getParameter("orderInsYN");
	String from_page=request.getParameter("from_page")==null?"":request.getParameter("from_page");
	String addID_display="";
	String addID_visibility="";
	if(clinicInsYN.equals("N")){
		addID_display="None";
		addID_visibility="hidden";
	}else{
		addID_display="";
		addID_visibility="visible";
	}
	if(from_page.equals("view_dtls")){
		addID_display="None";
		addID_visibility="hidden";
	}

%>
<body onKeyDown='lockKey()'>
	<form name='patInsButtonForm' id='patInsButtonForm'>	
	<div id='buttonID1'>
		<table>
			<tr rowspan='5'><td colspan='2'></td></tr>
			<tr>
				<td width='550'><div id='addID' ><input type='button'  style='visibility:<%=addID_visibility%>;display:<%=addID_display%>' class="BUTTON" name='addinstructionbutton' value='add Instructions' onClick="addInstruction()"></input></div></td><td align='right'><div id='closeID'><input type='button' class="BUTTON" name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='closeWindow("1")'></input></div></td>
			</tr>
		</table>
	</div>
	<script>
     if('<%=viewinsdtlsYN%>'=='view_dtls')
	   document.forms[0].addinstructionbutton.style.visibility='hidden';
	</script>
	</form>
</body>
</html>

