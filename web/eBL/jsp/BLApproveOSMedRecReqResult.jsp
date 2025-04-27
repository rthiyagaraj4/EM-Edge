<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,eBL.BLMedRepOutStdAmtBean,oracle.jdbc.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*"  %>
<%
	request.setCharacterEncoding("UTF-8");
	BLMedRepOutStdAmtBean bLMedRepOutStdAmtBean=new BLMedRepOutStdAmtBean();
	Connection con				= null;
	Connection con1				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;
	Double patOutStdAmt=0.0;   
	String auth_start_time = ""; 
 
	String facilityId = (String) session.getValue("facility_id");  
	String patientId = request.getParameter("patientId");    
	String authorized_yn="";
	Double medReqAuthValidity=0.0;

	patOutStdAmt=bLMedRepOutStdAmtBean.fetchPatOutStdAmt(facilityId,patientId);	   
	    
	try
	{
    	con	=	ConnectionManager.getConnection(request);
    	
    	String sqlMedReqAuthValidity= BlRepository.getBlKeyValue("MED_REP_REQ_AUTH_VALIDITY"); 
    	pstmt=con.prepareStatement(sqlMedReqAuthValidity);
    	rs = pstmt.executeQuery() ;
    	if( rs != null ){
    		if( rs.next() ){
    			medReqAuthValidity=rs.getDouble(1);
    		}
    	}
    	if (rs != null) rs.close();
    	pstmt.close();   	
    	
    	String sqlMedRepOutStdAmtAuthYN =BlRepository.getBlKeyValue("MED_REP_OUTSTD_AMT_AUTH_YN_CHECK");   	
    	pstmt = con.prepareStatement(sqlMedRepOutStdAmtAuthYN);
    	pstmt.setString(1,facilityId);
    	pstmt.setString(2,patientId);
    	pstmt.setDouble(3,medReqAuthValidity);
    	rs = pstmt.executeQuery() ;

    	if( rs != null ) 
    	{		
    		if( rs.next() )
    		{    			
    			authorized_yn="Y";    						
    		}
    		else{
    			authorized_yn="N";
    		}    			
    	}
    	else{    		
    			authorized_yn="N";
    		}    		
    	}
    	catch(Exception e)
    	{
    		System.err.println("Exception in BLApproveOSMedRecReqResult.jsp :: "+e);
			e.printStackTrace();
    	}
    	finally
		{
    		if (rs != null) rs.close();
        	if (pstmt != null) pstmt.close();	
			ConnectionManager.returnConnection(con);
		}	    	
	 %>
<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String noOfDecimals = request.getParameter("noOfDecimal1");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eBL/js/BLApproveOSBalance.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function disable_but()
	{
		var patOutStdAmt = $('#patOutStdAmt').val();
		if(patOutStdAmt <= 0)
		{
			parent.parent.frames[0].document.forms[0].apply.disabled = true;
		}else{
			parent.parent.frames[0].document.forms[0].apply.disabled = false;
		}
	}
	$(document).ready(function(){
		var authorized_yn = $('#authorized_yn').val();
		if(authorized_yn == 'Y'){
			$("#approve").attr("checked", true);
		}else{
			$("#approve").attr("checked", false);
		}
			var noOfDecimal =<%=noOfDecimals%>;
			$('[id^=otherOutStnd]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text($(this),17,noOfDecimal);				
			}
		});
	});
	</script>	
<body onload="disable_but()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
	<form name="pat_outst_amt" id="pat_outst_amt" method=post action="">
	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
		<tr>	
			<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.Approve.label" bundle="${common_labels}"/></td>
		 </tr>
		<tr>	
			<td class='LABEL' width="10%"  id='otherOutStnd' name='otherOutStnd' style="font-weight: bold;text-align: left" background-color: #f2f7f8;><%=patOutStdAmt%></td>	
	<%if(patOutStdAmt <= 0){ %>
			<td width="10%"	class="label">
			<input type="checkbox" style='text-align:right' id ="approve" name="approve" id="approve"  value="" onclick="updateApproveFlag();" disabled>		
			</td>
	<%}else{%>
			<td width="10%"	class="label">
			<input type="checkbox" style='text-align:right' id ="approve" name="approve" id="approve"  value=""	onclick="updateApproveFlag();">		
		</td>
		<%} %>
			</tr>
		</table>
		<input type= hidden name="authorized_yn" id="authorized_yn"  id='authorized_yn' value="<%=authorized_yn %>">
		<%System.err.println("authorized_yn :: "+authorized_yn); %>		
		<input type= hidden name="patOutStdAmt" id="patOutStdAmt"  id='patOutStdAmt' value="<%=patOutStdAmt %>">	
	</form>
<center>
</body>
</html>

