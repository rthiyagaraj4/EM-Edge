<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/* 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
22/01/2018  	IN062606            Sharanraj         01/02/2018              Ramesh G        ML-MMOH-CRF-0726
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.SignNotes.label" bundle="${ca_labels}"/></title>
	
	<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/PendDiscSummNotes.js'></script>
	<script language='javascript' src='../js/ReferralPatList.js'></script>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src='../js/MyRefToPerform.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con  = null;
	PreparedStatement stmtLen = null,pstmt = null;
	ResultSet rsetLen= null, rs = null;
	String PatIDLen ="";
	try
	{
		String sqlLen ="Select PATIENT_ID_LENGTH from mp_param";
		con = ConnectionManager.getConnection(request);
		stmtLen = con.prepareStatement(sqlLen);
		rsetLen	= stmtLen.executeQuery();
		while(rsetLen.next())
			{
			PatIDLen   = (rsetLen.getString("PATIENT_ID_LENGTH")==null)?"0":rsetLen.getString("PATIENT_ID_LENGTH");
			}
		if(rsetLen !=null) rsetLen.close();
		if(stmtLen !=null)stmtLen.close();
		
		String 	clinicianid	=	(String)	session.getValue("ca_practitioner_id");
		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");
		String toDate = "";
		String frDate = "";
		String dt = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		String dt1 = com.ehis.util.DateUtils.minusDate(dt,"DMY",locale,7,"d");
		
%>
<form name="MyRefNotSeenCriteria_form" id="MyRefNotSeenCriteria_form">
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<table  border="0" width="100%" cellspacing='0' cellpadding='3' align='center'>
<tr>
	<td  width='15%' class='label' align="right"	><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td width='25%' class='fields'> <input type='text' width='15%' name='patientId' id='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='checkDuplicate(this)' size='<%=PatIDLen%>' maxlength='<%=PatIDLen%>' ><input type='button' name='patSearch' id='patSearch' class='button' value='?' tabIndex="4" onClick="callPatientSearch()"></td>
	
	<td class='label' width ='25%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class ='fields' width ='30%' nowrap>
						<input class = 'fields' id="from_date"  type="text" name="from_date" id="from_date" size=10 maxlength=10 value='<%=dt1%>' onBlur='doDateCheckLoc(this,to_date,"<%=toDate%>","DMY","<%=locale%>",this);'>
						<input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv" onclick="return showCalendarValidate('from_date');" >
						<input class = 'fields' id="to_date" type="text" name="to_date" id="to_date" size=10 maxlength=10 title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")%>' onBlur='doDateCheckLoc(from_date,this,"<%=toDate%>","DMY","<%=locale%>",this);' value='<%=dt%>'>
						<input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv1" title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")%>'; onclick="return showCalendarValidate('to_date');"><img src='../../eCommon/images/mandatory.gif'></img>
					</td>
	<tr>
	<td width='25%' >&nbsp;</td>
	<td  align='right' width='100%' colspan='5'>						
						<input type='button' class='button' name='search' id='search' id='searchID' onclick="javascript:searchClick1()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'>&nbsp;<input type='button' class='button' name='clear' id='clear' onclick="javascript:clearClick1()"value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
	
</tr>
</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="note_type_code" id="note_type_code" value="">	
<input type="hidden" name="ca_practitioner_id" id="ca_practitioner_id" value="<%=clinicianid%>">	
<input type="hidden" name="locale" id="locale"  value="<%=locale%>">	
<input type='hidden' name='url' id='url' value=''>
<input type="hidden" name="order_by" id="order_by" value="">
<input type="hidden" name="re_order" id="re_order" value="">
<input type="hidden" name="anchor_id" id="anchor_id" value="">
</body>
</form>
<%
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
catch (Exception e)	
{
	//out.println(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
	finally    
	{
         if(con!=null)
			 ConnectionManager.returnConnection(con,request);
    }
%>
</html>

