<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name	Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
22/01/2018	IN063931		Prakash C	23/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title>Recorded Previous Section Search Criteria</title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		
		String imgUrl="";

		if(sStyle.equals("IeStyle.css"))
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='RecPreviousSectionSrchCriteriaForm' id='RecPreviousSectionSrchCriteriaForm'>
<%
	
		
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;

	String	query_for_days		=	"";
	String	query_string		=	"";
	String	from_date_time		=	"";
	String	to_date_time		=	"";
	int 	allowedDays 		= 	0;

	String patient_class			=	(request.getParameter("patient_class")==null)	?	""	:	request.getParameter("patient_class");
	String curr_sec_hdg_code		=	(request.getParameter("curr_sec_hdg_code")==null)	?	""	:	request.getParameter("curr_sec_hdg_code");
	String curr_child_sec_hdg_code	=	(request.getParameter("curr_child_sec_hdg_code")==null)	?	""	:	request.getParameter("curr_child_sec_hdg_code");
	
	query_string = request.getQueryString();

	try
	{
		con				=	ConnectionManager.getConnection(request);		
	
		//query_for_days  =  "SELECT DURN_VAL FROM OR_PAT_APPLICABLE_FUNC WHERE FUNCTION_ID='COPY_PREVIOUS_NOTE' AND PATIENT_CLASS = decode(?,'EM','OP','DC','IP',"+"'"+patient_class+"'"+")";//common-icn-0180
		query_for_days  =  "SELECT DURN_VAL FROM OR_PAT_APPLICABLE_FUNC WHERE FUNCTION_ID='COPY_PREVIOUS_NOTE' AND PATIENT_CLASS = decode(?,'EM','OP','DC','IP',?)";//common-icn-0180
		
		pstmt			=	con.prepareStatement(query_for_days);
		
		pstmt.setString(1,patient_class);
		pstmt.setString(2,patient_class);//common-icn-0180
		
		rs				=	pstmt.executeQuery();
		if(rs.next()){
			allowedDays = 	Integer.parseInt((String)rs.getString("DURN_VAL"));
		}
		to_date_time	=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		from_date_time	=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,allowedDays,"d");
	}catch(Exception e){
		System.out.println("Exception@1: "+e);
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();

	}
%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
		<tr>
			<td class="LABEL"  width='10%' ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
			<td class="fields" width='40%' nowrap>
				<input type='text' name='from_date_time' id='from_date_time' value="<%=from_date_time%>" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,to_date_time, "DMYHM","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');">
				&nbsp;&nbsp;-&nbsp;&nbsp;<input type='text' name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16'  onBlur='CheckDateNew(this);checkPeriodFromTo(from_date_time,this,"DMYHM","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');">
			</td>
			<td  width='15%' class = button align ='right' ><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="return showPreviousSectionSearchResults();"></td>
		</tr>	
	</table>
		<input type='hidden' name='query_string' id='query_string'	value="<%=query_string%>">	
		<%if(!imgUrl.equals("")){ %>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
	
<input type='hidden' name="curr_sec_hdg_code" id="curr_sec_hdg_code" value="<%=curr_sec_hdg_code%>">
<input type='hidden' name="curr_child_sec_hdg_code" id="curr_child_sec_hdg_code" value="<%=curr_child_sec_hdg_code%>">
</form>
</center>
</body>
</html>
<script language='javascript'>	
	parent.RecPreviousSectionSrchResultsFrame.location.href = "../../eCA/jsp/RecPreviousSectionSrchResults.jsp?<%=query_string%>&from_date_time=<%=from_date_time%>&to_date_time=<%=to_date_time%>";
</script>
		


