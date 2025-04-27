<!DOCTYPE html>
<!--
Sr No        Version           TFS/Incident        SCF/CRF            		Developer Name
----------------------------------------------------------------------------------------------
1			 V210517			 17598			Common-ICN-0034				Mohana Priya K
2			 210720			    21718			 MOHE-SCF-0125-TF	    	Mohana Priya K
----------------------------------------------------------------------------------------------
-->
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query Criteria</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLShowRecalcJobs.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String PatIDLen = "";

	try{
			con = ConnectionManager.getConnection(request);
			String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
			pstmt=con.prepareStatement(sqlLen);
			rs=pstmt.executeQuery();
			while(rs.next() && rs!=null)
			{
				PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
			}
			//if(rs!=null) rs.close();//V210517
			//if(pstmt!=null) pstmt.close();//V210517
		}catch(Exception ee){  
			   ee.printStackTrace();
			   System.err.println("exception 2 in BLQueryForRecalc.jsp "+ee);
		 }finally{
			if(rs!=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(con!=null)  ConnectionManager.returnConnection(con, request); //V210517
		}
%>
</head>
<body>
<form name='srchFrm' id='srchFrm' id='srchFrm'> 
<TABLE width="90%" CELLSPACING=0 cellpadding=3 align='center'>
	<tr>
		<td  class="columnheader" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
		</td>
	</tr>
</TABLE>	
	<table cellpadding=3 cellspacing=0 width="90%" align="center" border=0>			
	<tr>
		<td style="width:25%;" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td style="width:25%;" class='fields'>
			<input type="text" name="patient_id" id="patient_id" maxlength="<%=PatIDLen%>" 
				onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onblur="if(this.value!=''){ChangeUpperCase( this ); callPatValidation(this);defaultEncounter('patId');} ">
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="PatientIdLookup();defaultEncounter();"  tabindex='2' />
			<img src='../../eCommon/images/mandatory.gif'>	
		</td>
		<td style="width:25%;" class="label" ><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
		<td style="width:25%;" class='fields'>
			<select id="episode_type" name="episode_type" id="episode_type"  style="width: 70px;" onchange='defaultEncounter("epsdType");'>
			<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<option value="O"><fmt:message key="eBL.OP.label" bundle="${bl_labels}"/></option>
			<option value="I"><fmt:message key="eBL.IP.label" bundle="${bl_labels}"/></option>
			<option value="D"><fmt:message key="eBL.DC.label" bundle="${bl_labels}"/></option>
			<option value="E"><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
			<option value="R"><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
			</select>						
		</td>			
	 </tr>			 
	  <tr>
		<td style="width:25%;" class="label" ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
		<td style="width:25%;" class='fields'>
			<input type="text" name="episode_id" id="episode_id"  maxlength="30"  onBlur="if(this.value!=''){ episodeLookup(episode_id,hdnEpisode_id); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
			<input type='hidden' name='hdnEpisode_id' id='hdnEpisode_id'>
			<input type='button' class='button' name="episode_idbut" id="episode_idbut" value='?' onClick="episodeLookup(episode_id,hdnEpisode_id)"  tabindex='2' />				
		</td>			
				
		<td style="width:25%;" class="label" ><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></td> <!-- 210720 -->
		<td style="width:25%;" class="fields" colspan="2">
			<input type="text" name="visit_id" id="visit_id"  maxlength="5" size='5'>
		</td>			
	 </tr>
	 <tr>	
		
			<td style="width:25%;" class="label" ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td> <!-- 210720 -->
			<td style="width:25%;" class='fields'>
			<input type='text' name='Effective_from' id='Effective_from'  maxlength="10"  size='10' onblur='isValidDate(this);'>
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_from');"  onKeyPress="return lockbackSpace();">
		</td>	
			<td style="width:25%;" class="label" ><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td> <!-- 210720 -->
		<td style="width:25%;" class='fields'>
			<input type='text' name='Effective_to' id='Effective_to'  maxlength="10"  size='10' onblur='isValidDate(this);'>
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_to');"  onKeyPress="return lockbackSpace();">
		</td>	
	 </tr>		
	 <tr>	
		<td style="width:25%;" class="label" >
			<input type='button' name='search' id='search'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>' onclick='loadRecalcJobs();'>  <!-- 210720 -->
		</td>
	</tr>		
	</table>
	<input type='hidden' name='facilityId' id='facilityId'  value='QF'>
	<input type='hidden' name='hdnEpisode_id' id='hdnEpisode_id' value=''>
	<input type='hidden' name='locale' id='locale'  value='en'>
	</form>
</body>
</html>

