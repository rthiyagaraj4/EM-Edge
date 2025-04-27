<!DOCTYPE html>
<!--This JSP is newly added by lakshmi against CRF-0146-->
<%@ page contentType="text/html;charset=UTF-8"%>                              
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page import= "java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.*,eOT.Common.*,eCommon.Common.CommonBean" %>
<html>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>



<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script> 
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eOT/js/OTCommon.js" language="javascript"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>	
	<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/Booking.js" language="javascript"></script>
	<script src="../../eOT/js/PickList.js" language="javascript"></script>
	<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
String PatIDLen="";
String sql1="";
//Added By MuthuN CRF-268
String sql_pick_param ="";
String cssd_doc_type ="";
String cssd_store_req ="";
String cssd_store_ret ="";
String strPatientId1=checkForNull(request.getParameter("patientid"));
String strSourceType=checkForNull(request.getParameter("source_type"));
String strSourceDesc=checkForNull(request.getParameter("source_desc"));
String strSourceCode=checkForNull(request.getParameter("source_code")); 
String facilityId=(String) session.getValue("facility_id"); 

  Connection conn1=null;
  ResultSet rs1=null;
  Statement stmt1=null;
  ResultSet rs2=null;//Added By MuthuN CRF-268
  Statement stmt2=null;//Added By MuthuN CRF-268
  sql1 ="SELECT PATIENT_ID_LENGTH from  mp_param";		
		try{

			conn1=ConnectionManager.getConnection(request);
			stmt1 = conn1.createStatement();
			rs1 = stmt1.executeQuery(sql1);
			if (rs1!= null && rs1.next())
			{
				PatIDLen = (rs1.getString("PATIENT_ID_LENGTH")==null)?"0":rs1.getString("PATIENT_ID_LENGTH");
			}

		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();

		}finally{
			try{

			if(rs1!=null)       rs1.close();
			if(stmt1!=null)       stmt1.close();
			if(conn1!=null)  ConnectionManager.returnConnection(conn1,request);
			}catch(Exception e){}
		}

//Added newly by MuthuN against CRF-268 Starts
 sql_pick_param ="select CSSD_DOC_TYPE_REQ, CSSD_STORE_REQ, CSSD_STORE_RET from OT_PARAM_FOR_FACILITY where operating_facility_id ='"+facilityId+"'";
	try{
			conn1=ConnectionManager.getConnection(request);
			stmt2 = conn1.createStatement();
			rs2 = stmt2.executeQuery(sql_pick_param);
			if (rs2!= null && rs2.next())
			{
				cssd_doc_type=checkForNull(rs2.getString(1));
				cssd_store_req=checkForNull(rs2.getString(2));
				cssd_store_ret=checkForNull(rs2.getString(3));
				//System.out.println("ReviewFilter cssd_doc_type ===> "+cssd_doc_type);
				//System.out.println("ReviewFilter cssd_store_req ===> "+cssd_store_req);
				//System.out.println("ReviewFilter cssd_store_ret ===> "+cssd_store_ret);
			}
		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();
		}finally{
			try{
			if(rs2!=null)       rs2.close();
			if(stmt2!=null)       stmt2.close();
			if(conn1!=null)  ConnectionManager.returnConnection(conn1,request);
			}catch(Exception e){}
		}
//Added newly by MuthuN against CRF-268 Ends
%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='picklistReviewFilter' id='picklistReviewFilter' action='' method = 'post'> 

<table  border='0' width='100%' cellpadding=1  cellspacing=0>
<tr> <td class="label">
		<fmt:message 	key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
	<td  class="fields" >
		<input type='text' align='left' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>'  onBlur="if(this.value!='')callPatSearchFilter();else clearDesc();" value= "<%=strPatientId1%>" onkeypress="return CheckForSpecChars(event)">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatSearchFilter();">
	</td>

	<td class='label'>
			<fmt:message key="Common.SourceType.label" bundle="${common_labels}"/>  
		</td>
		<td class="fields" colspan='4'>
			<select class="fields" name='source_type' id='source_type' onchange="clearSource();" value="<%=strSourceType%>">
			<!--<option value=''>
				<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
			</option>-->
			<option value='W'>
				<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
			</option>
			<option value='C'>
				<fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
			</option>
			<option value='E'>
				<fmt:message key="Common.referral.label" bundle="${common_labels}"/>
			</option>
		</select>
		<input type='hidden' name='source_code' id='source_code'  value="<%=strSourceCode%>" >
		<input type='text' name='source_desc' id='source_desc' size='20' value="<%=strSourceDesc%>" class="fields" onBlur="if(this.value!='') searchSourceTypeSelectFilter(source_desc); else callchangeMoreIcon(); ">
		<input type='button' class='button' name='quest7' id='quest7' value='?' onClick="searchSourceTypeSelectFilter(source_desc);" >
		<div id='more_img' style='position:absolute;visibility:hidden;'><img src='../../eOT/images/more.gif' onmouseover="if(source_desc.value!='')Tip(getLongNameRefSrc());else Untip();" onmouseout="UnTip()"></img></div>
	</td>
	<td colspan="2" class='button'>
			<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="SearchPickListFilter()">
			<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' 	onClick="ClearFilter()" >
		</td>
</tr>

<input type='hidden' name='HLongRefSrcId' id='HLongRefSrcId' value="">
<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">	
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<!-- Added newly by MuthuN against CRF-268 Starts -->
<input type='hidden' name='cssd_doc_type' id='cssd_doc_type' value="<%=cssd_doc_type%>">
<input type='hidden' name='cssd_store_req' id='cssd_store_req' value="<%=cssd_store_req%>">
<input type='hidden' name='cssd_store_ret' id='cssd_store_ret' value="<%=cssd_store_ret%>">
<!-- Added newly by MuthuN against CRF-268 Ends -->

 </form>
</html>

