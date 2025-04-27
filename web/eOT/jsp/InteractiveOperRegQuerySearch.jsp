<!DOCTYPE html>


<%@page  contentType="text/html;charset=UTF-8" %>                           
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eOT/js/OtReports.js" ></script>
<script src="../../eOT/js/InteractiveOperRegQuery.js" language="javascript"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="interactive_query_hdr_form" id="interactive_query_hdr_form">
<%	
String facility_id=(String)session.getValue("facility_id");
String strPatientId = checkForNull(request.getParameter("patientid"));
//String ward_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");	
	String sql_ward="SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) AND EFF_STATUS = 'E' ORDER BY 2 ";

String strSourceType="";
String strSourceDesc="";
strSourceType=checkForNull(request.getParameter("source_type"));
strSourceDesc=checkForNull(request.getParameter("source_desc"));
String strPatientName="";
Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
PreparedStatement pstmt=null;
ResultSet prs=null;
String sys_date="";
String PatIDLen="";
conn = ConnectionManager.getConnection(request);
	try{
	String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
	pstmt=conn.prepareStatement(sqlLen);
	rs=pstmt.executeQuery();
	while(rs.next() && rs!=null)
	{
	PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception  ee){}

try
{
	
	stmt=conn.createStatement();
	rs=stmt.executeQuery("SELECT to_char(SYSDATE,'dd/mm/yyyy') SYSDATE1 from dual");
	if(rs!=null && rs.next())
	{
		//sys_date=rs.getString("SYSDATE1");
		//Buddhist date conversion (Thai Locale)
		sys_date =com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMY","en",locale);
	}
	if(rs!=null)
	rs.close();
	stmt.close();
%>
<table cellpadding=3  cellspacing="0" border="0 " width="100%" align='center'>
<tr>
	<td width="25%"  class='label'>
			<fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields">
			<input type='text' name='from_date' id='from_date' size='11'   value='<%=sys_date%>'  maxlength='10' onBlur='checkDateFormat(this);' >
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date');">
			<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td width="25%" class="label">
			<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields">
			<input type='text' name='to_date' id='to_date' size='11' value='' maxlength='10' onBlur='checkDateFormat(this);'>
			<img src="../../eCommon/images/CommonCalendar.gif" Onblur="" onClick="return showCalendar('to_date');">
	</td>
</tr>

<tr>
		<td width="25%" class="label">
			<fmt:message key="eOT.TheatreType.Label" bundle="${ot_labels}"/></td>
		<td width="25%" class="fields">
			<input type='hidden' name='theatre_type' id='theatre_type'  value= "" > 
			<input type='text' name='theatre_type_desc' id='theatre_type_desc' maxlength='20' size='20' value= "" OnChange="" onBlur="if(this.value!='')searchTheatreTypeinOPreg(theatre_type_desc); else theatre_type.value=''; populateTheatres(); ">
			<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="searchTheatreTypeinOPreg(theatre_type_desc);populateTheatres();">	
	</td>
	<td class="label" width="25%" >
			<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
	<td  width="25%" class="fields">
			<select name='theatre' id='theatre' OnChange=''>
<%
		//String theatre_sql="SELECT 'All Theatres' theatre_name, '*ALL' code FROM DUAL UNION SELECT SHORT_DESC THEATRE_DESC, OPER_ROOM_CODE THEATRE_CODE FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID = ? ORDER BY 1";
		String theatre_sql="SELECT '*All Theatres' theatre_name, '*ALL' code FROM DUAL UNION SELECT SHORT_DESC THEATRE_DESC, OPER_ROOM_CODE THEATRE_CODE FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = ? ORDER BY 1";
			pstmt=conn.prepareStatement(theatre_sql);
			pstmt.setString(1,facility_id);
			prs=pstmt.executeQuery();
			while(prs!=null && prs.next())
			{
			%>
			<option value='<%=prs.getString("code")%>'><%=prs.getString("theatre_name")%></option>
			<%
			}
			if(prs!=null) 
			prs.close();
			pstmt.close();
			%>
				</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class="label" width="25%" >
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td  width="25%" class="fields">
			<input type='hidden' name='speciality_code' id='speciality_code' value=''>
			<input type='text' name='speciality_desc' id='speciality_desc' maxlength='20' size='20' value= "" onBlur="if(this.value!='')searchSpecialityinOPreg(speciality_desc); else speciality_code.value='' ">
			<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="searchSpecialityinOPreg(speciality_desc);">
	</td>

	<td class="label" width="25%" >
			<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
	<td  width="25%" class="fields">
			<input type='hidden' name='surgeon_code' id='surgeon_code' value= "" >
			<input type='text' name='surgeon_name' id='surgeon_name' maxlength='20' size='20' value= "" onBlur="if(this.value!='')searchSurgeoninOPreg(surgeon_name); else surgeon_code.value='';">
			<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="searchSurgeoninOPreg(surgeon_name);">
	</td>
</tr>
<tr>
	<td class='label' width='25%'>
			<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields">
			<input type='hidden' name='anaesthetist_code' id='anaesthetist_code'  value="" >
			<input type='text' name='anaesthetist_name' id='anaesthetist_name' size='20' value="" onBlur="if(this.value!='')searchAnaesthetistinOPreg(anaesthetist_name); else anaesthetist_code.value='';">
			<input type='button' class='button' name='quest3' id='quest3' value='?' onClick="searchAnaesthetistinOPreg(anaesthetist_name);">
	</td>
	<td class='label' width='25%'>
			<fmt:message key="Common.nurse.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields">
			<input type='hidden' name='nurse_code' id='nurse_code'  value="" >
			<input type='text' name='nurse_name' id='nurse_name' size='20' value="" 
			onBlur="if(this.value!='')searchNurseinOPreg(nurse_name); else nurse_code.value='';">
			<input type='button' class='button' name='quest3' id='quest3' value='?' onClick="searchNurseinOPreg(nurse_name)">
	</td>
</tr>

<tr >
<td  class='label'  width="25%">
<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<td align='left'>
<input type='text' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' value= "<%=strPatientId%>" onBlur="if(this.value!='')callPatSearch();clearDesc();" onkeypress="return CheckForSpecChars(event)">
<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatSearch();">
</td>
 
<td  class='label'  width="25%">
<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
</td>
<td align='left'>
<input type='hidden' name='p_patient_id' id='p_patient_id' value=''>
<input type='text' name='patientname' id='patientname' maxlength='60' size='30' value= "<%=strPatientName%>" readonly>
</td>
</tr>


<tr>
	<td class='label'width="25%">
			<fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>
	<td  width="25%" class="fields">
			<input type='hidden' name='oper_code' id='oper_code' value=''> 
			<input type='text' name='oper_desc' id='oper_desc' size='20'  value='' maxlength='20' onBlur="if(this.value!='')searchOperationinOPreg(oper_desc); else oper_code.value='' ;">
			<input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' onClick="searchOperationinOPreg(oper_desc);" >
	</td>
	<td class='label'width="25%">
			<fmt:message key="eOT.AnaesthesiaType.Label" bundle="${ot_labels}"/></td> 
	<td width="25%" class="fields">
			<input type='hidden' name='anaesthesia_code' id='anaesthesia_code' value=''> 
			<input type='text' name='anaesthesia_desc' id='anaesthesia_desc' size='20'  value='' maxlength='20' 
			onBlur="if(this.value!='')searchAnaesTypeinOPreg(anaesthesia_desc);else anaesthesia_code.value='' ;">
			<input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' onClick="searchAnaesTypeinOPreg(anaesthesia_desc);" >
	</td>
</tr>
<tr>
	<td class='label'width="25%">
			<fmt:message key="eOT.ImplantUsed.Label" bundle="${ot_labels}"/></td> 
	<td  width="25%" class="fields">
			<input type='hidden' name='implant_code' id='implant_code' value=''>
			<input type='text' name='implant_desc' id='implant_desc' size='20'  value='' maxlength='20' onBlur="if(this.value!='')callImplantUsed(implant_desc); else implant_code.value='' ;">
			<input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' onClick="callImplantUsed(implant_desc);" >
	</td>
	<td width="25%" class='label'>
			<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields">
			<select name='orderby' id='orderby'>
			<option value='1'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> </option>
			<option value='2'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
			<option value='3'><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></option>
			<option value='4'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></option>
			<option value='5'><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/></option>
			<option value='6'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
			<option value='7'><fmt:message key="eOT.OperationNo.Label" bundle="${ot_labels}"/></option>
			<option value='8'><fmt:message key="eOT.OperationDate.Label" bundle="${ot_labels}"/></option>
			<option value='9'><fmt:message key="Common.status.label" bundle="${common_labels}"/></option></select>
			<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	
</tr>
<tr>
		<td class='label'>
			<fmt:message key="Common.SourceType.label" bundle="${common_labels}"/>  
		</td>
		<td class="fields" colspan='4'>
			<select class="fields" name='source_type' id='source_type' onchange="clearSource();" value="<%=strSourceType%>">
			<option value=''>
				<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
			</option>
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
		<input type='hidden' name='source_code' id='source_code'  value="" >
		<!-- ML-MMOH-CRF-0752.3-US001 -->
		<input type='text' name='source_desc' id='source_desc' size='67' value="<%=strSourceDesc%>" class="fields" onBlur="if(this.value!='') searchSourceTypeSelect(source_desc); else callchangeMoreIcon();">
		<input type='button' class='button' name='quest6' id='quest6' value='?' onClick="searchSourceTypeSelect(source_desc);" >
		<div id='more_img' style='position:absolute;visibility:hidden;'><img src='../../eOT/images/more.gif' onmouseover="if(source_desc.value!='')Tip(getLongNameRefSrc());else UnTip()" onmouseout="UnTip()"></img></div>
	</td>
	</tr>
<tr>
	<td width="25%" class="label">
			<fmt:message key="eOT.StatusCode.Label" bundle="${ot_labels}"/></td>
		<td width="25%" class="fields">
			<select name='status' id='status' OnChange=''>
			<%
			//	String status_sql="SELECT STATUS_DESC, STATUS_CODE FROM OT_STATUS  UNION SELECT 'All', '*ALL' FROM DUAL ORDER BY 2";

			String status_sql="SELECT STATUS_DESC, STATUS_CODE FROM OT_STATUS_LANG_VW WHERE LANGUAGE_ID ='"+locale+"' AND STATUS_CODE NOT IN ('10','25','30','35') UNION SELECT 'All', '*ALL' FROM DUAL ORDER BY 2";

				pstmt=conn.prepareStatement(status_sql);
				prs=pstmt.executeQuery();
				while(prs!=null && prs.next())
				{
				%>
				<option value='<%=prs.getString("STATUS_CODE")%>'><%=prs.getString("STATUS_DESC")%></option>
				<%
				}
				if(prs!=null)
				prs.close();
				pstmt.close();
			%>
				</select><img src='../../eCommon/images/mandatory.gif'></img>
	</td>

	<td width="25%" class="fields"></td>
	<td width="25%" class="fields">
			<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="IntraOperRegDetails()">
			<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="funResetAll()" >
	</td>
</tr>

</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

<%
}
  catch(Exception e) 
  {
	System.err.println("Exception:"+e);
  }
  finally
  {
	  if(stmt!=null)	  stmt.close();
	  ConnectionManager.returnConnection(conn,request);
  }
  %>
<input type='hidden' name='facility_id' id='facility_id' value= "<%=facility_id%>" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type="hidden" name="sql_text_7" id="sql_text_7" value="<%=sql_ward%>" disabled>
<input type='hidden' name='HLongRefSrcId' id='HLongRefSrcId' value="">
</form>
</body>
</html>

