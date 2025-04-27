<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>           
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='StyleSheet' href='../../eCommon/html/CommonCalendar.css' type='text/css'/>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script type='text/javascript' src='../../eOT/js/BookingQuery.js'></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
</head>

<body onLoad="setInitialData(),selectStatus(),selectOrderby(),selectSourceType()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name="addlSearchCriteriaForm" id="addlSearchCriteriaForm" method='post' action='../../eOT/jsp/BookingQrySearch.jsp'>

<%	
String facilityid=(String)session.getValue("facility_id");

String sql="";

String strPatientName="";
String strAge="";
String strSex="";


Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String strPatientId="";
String strSysDate="";
String strAneasthetist="";
String strAneasthetistCode="";

String strTheatreDesc="";
String strTheatreTypeCode="";

String strTheatre="";
String strRoomCode="";
String strSurgeonCode="";
String strSurgeon="";

String strSpecialityCode="";
String strSpeciality="";
String strOperationDesc="";
String strOperationCode="";
String strToDate="";
String strSourceType="";
String strStatus="";
String strPreOperDiag="";
String strOrderBy="";
String strSourceDesc="";
String PatIDLen="";




strPatientId=checkForNull(request.getParameter("patientid"));

strTheatreDesc=checkForNull(request.getParameter("theatre_type_desc"));
strTheatreTypeCode=checkForNull(request.getParameter("theatre_type_code"));
strTheatre=checkForNull(request.getParameter("theatre"));
strRoomCode=checkForNull(request.getParameter("room_code"));
strSurgeonCode=checkForNull(request.getParameter("SURGEON_CODE"));
strSurgeon=checkForNull(request.getParameter("SURGEON"));
strSpecialityCode=checkForNull(request.getParameter("SPECIALITY_CODE"));
strSpeciality=checkForNull(request.getParameter("SPECIALITY_DESC"));
strOperationCode=checkForNull(request.getParameter("oper_code"));
strOperationDesc=checkForNull(request.getParameter("operation_desc"));
strAneasthetistCode=checkForNull(request.getParameter("Anaesthetiest1_code"));
strAneasthetist=checkForNull(request.getParameter("Anaesthetiest2_code"));
strToDate=checkForNull(request.getParameter("to_date"));
strOrderBy=checkForNull(request.getParameter("orderby"));
strSourceType=checkForNull(request.getParameter("source_type"));
strSourceDesc=checkForNull(request.getParameter("source_desc"));
strStatus=checkForNull(request.getParameter("status"));
strPreOperDiag=checkForNull(request.getParameter("pre_oper_diag"));

if(strTheatre.length()==0) 
{
//strTheatre="All Theatres";
	strTheatre=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllTheatres.Label","ot_labels");
	strRoomCode="*ALL";
}
try
{
conn = ConnectionManager.getConnection(request);

	try{
	String sqlLen ="SELECT PATIENT_ID_LENGTH,to_char(SYSDATE,'dd/mm/yyyy') SYSDATE1 FROM MP_PARAM ";
	pstmt=conn.prepareStatement(sqlLen);
	rs=pstmt.executeQuery();
	while(rs.next() && rs!=null)
	{
	PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
	strSysDate =com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMY","en",locale);

	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception  ee){}

/*pstmt=conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') SYSDATE1 from dual");

rs=pstmt.executeQuery();
if(rs!=null &&rs.next()==true)
{
//strSysDate=rs.getString("SYSDATE1");
//Buddhist date conversion (Thai Locale)
strSysDate =com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMY","en",locale);

}
if(rs!=null)
rs.close();*/
pstmt.close();

if(strPatientId.length()>0)
	{
 sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT10");
pstmt=conn.prepareStatement(sql);
pstmt.setString(1,strPatientId);
rs=pstmt.executeQuery();

if(rs.next())
{
strPatientName=checkForNull(rs.getString("SHORT_NAME1"));
//strAge=checkForNull(rs.getString("DATE_OF_BIRTH1")); modified by rajesh for SCF on 05/06/2007
strAge=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale));
strSex=checkForNull(rs.getString("SEX1"));
}
pstmt.close();
rs.close();
}

//sql=" select STAGE_CODE STAGE_CODE1,PRE_STAGE_DESC PRE_STAGE_DESC1 from OT_BOOKING_FIN_STAGES";

sql=" select STAGE_CODE STAGE_CODE1,PRE_STAGE_DESC PRE_STAGE_DESC1 from OT_BOOKING_FIN_STAGES_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ";


pstmt=conn.prepareStatement(sql);
rs=pstmt.executeQuery();
%>

<table cellpadding="3" cellspacing="0" border="0" width="100%" align="center">
<tr>
		<td width="13%" class="label">
			<fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/>  <fmt:message key="Common.from.label" bundle="${common_labels}"/>
		</td>
		<td width="45%" class='fields' >
			<input type='text' name='from_date' id='from_date' size='11'   value='<%=strSysDate%>'  maxlength='10' onblur='checkDateFormat(this)'>
			<img src="../../eCommon/images/CommonCalendar.gif"	
			onClick="return showCalendar('from_date','dd/mm/y');">
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td width="12%" class='label' >
		  <fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/>	<fmt:message key="Common.to.label" bundle="${common_labels}"/>
		</td>
		<td width="30%" class='fields' >
			<input type='text' name='to_date' id='to_date' size='11'   value='<%=strToDate%>' maxlength='10' onblur='checkDateFormat(this)'>
			<img src="../../eCommon/images/CommonCalendar.gif" 
			Onblur="javascript:checkDate('2')"
			onClick="return showCalendar('to_date','dd/mm/y');">
		</td>
	</tr>
<tr>
	<td class="label">
		<fmt:message key="eOT.TheatreType.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type='text' name='theatre_type_desc' id='theatre_type_desc' maxlength='20' size='20' value= "<%=strTheatreDesc%>" onBlur="if(this.value!='') searchTheatreType(theatre_type_desc); else theatre_type_code.value=''" >
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="searchTheatreType(theatre_type_desc);">	
	</td>
	
	<td class="label">
		<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	</td>
	<td  class="fields">
		<input type='text' name='theatre' id='theatre' maxlength='20' size='20' value= "<%=strTheatre%>" onBlur="if(this.value!='') searchTheatre(theatre); else theatre.value='' ">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="searchTheatre(theatre);">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td class="label">
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
	<td  class="fields">
		<input type='text' name='SURGEON' id='SURGEON' maxlength='20' size='20' value= "<%=strSurgeon%>"  onBlur="if(this.value!='') searchSurgeon(SURGEON); else SURGEON_CODE.value=''">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="searchSurgeon(SURGEON);">
	</td>
	<td class="label">
		<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> 
	</td>
	<td class="fields">
		<input type='text' name='Anaesthetiest2_code' id='Anaesthetiest2_code' size='20' value="<%=strAneasthetist%>" onBlur="if(this.value!='') searchAnaesthetist(Anaesthetiest2_code); else Anaesthetiest1_code.value=''" >
		<input type='button' class='button' name='quest3' id='quest3' value='?' onClick="searchAnaesthetist(Anaesthetiest2_code)">
	</td>
</tr>

<tr>
	<td class="label">
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td  class="fields">
		<input type='text' name='SPECIALITY_DESC' id='SPECIALITY_DESC' maxlength='20' size='20' value= "<%=strSpeciality%>"  onBlur="if(this.value!='') searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value='' ">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="searchSpeciality(SPECIALITY_DESC);">
	</td>
	<td class="label">
		<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
	</td> 
	<td class='fields'>
		<input type='hidden' name='oper_code' id='oper_code' value="<%=strOperationCode%>"> 
		<input type='text' name='operation_desc' id='operation_desc' size='20'  value=
		"<%=strOperationDesc%>" maxlength='20' onBlur="if(this.value!='') searchBookingQryOperation(oper_code,operation_desc); else oper_code.value=''" >
		<input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' onClick="searchBookingQryOperation(oper_code,operation_desc)" ></td>
</tr>

<tr>
	<td class="label">
		<fmt:message 	key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
	<td  class="fields" >
		<input type='text' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' value= "<%=strPatientId%>" onBlur="if(this.value!='')callPatSearch();else clearDesc();" onKeyPress="return CheckForSpecChars(event)">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatSearch();">
	</td>
	<td class="label">
		<fmt:message 	key="Common.PatientName.label" bundle="${common_labels}"/>
	</td>
	<td  class="fields" >
		<input type='text' name='patientName' id='patientName' maxlength='40' size='30' value= "<%=strPatientName%>"  readonly>	</td>
</tr>

<tr>
	<td class="label">
		<fmt:message key="Common.gender.label" bundle="${common_labels}"/>
	</td>
	<td class="fields" >
		<select name='sex' id='sex' class="fields" selected='<%=strSex%>'>
			<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value='F'><fmt:message key="Common.female.label" 	bundle="${common_labels}"/></option>
			<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select>
	</td>
	<td class="label">
		<fmt:message key="Common.birthDate.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>           
		<input type='text' name='date_of_birth' id='date_of_birth' size='10' align='right' value='<%=strAge%>'  readonly>
		<!-- <input type='text' name='date_of_birth' id='date_of_birth' size='10' maxlength='10' align='right' value='<%=strAge%>'  onblur='checkDateFormat(this)' > -->
	</td>
</tr>
	
<tr>
		<td class="label">
			<fmt:message key="eOT.Stages.Label" bundle="${ot_labels}"/>
		</td>
		<td class="fields">
			<select class="fields" name='stage' id='stage' disabled>
			<!-- <select class="fields" name='stage' id='stage' > -->
			<option value=''></option>
			<%
			while(rs.next()){
			out.println("<option value='"+rs.getString("STAGE_CODE1")+"'>"+rs.getString("PRE_STAGE_DESC1")+"</option>");
			}
			rs.close();
			pstmt.close();
			%>
			</select>
	   </td>
		<td class="label">
			<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>
		</td>
		<td class="fields">
			<select name='orderby' id='orderby' >
				<option value='1'>
					<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
				</option>
				<option value='2'>
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</option>
				<option value='3'>
					<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
				</option>
				<option value='4'>
					<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
				</option>
				<option value='5'>
					<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/>
				</option>
				<option value='6'>
					<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
				</option>
				<option value='7'>
					<fmt:message key="eOT.BookingNO.Label" bundle="${ot_labels}"/>
				</option>
				<option value='8'>
					<fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/>
				</option>
				<option value='9'>
					<fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/>
				</option>
				<option value='A'>
					<fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/>
				</option>
				<option value='B'>
					<fmt:message key="Common.status.label" bundle="${common_labels}"/>
				</option>
			</select>
				<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>
	<tr>
		<td class='label'>
			<fmt:message key="Common.SourceType.label" bundle="${common_labels}"/>  
		</td>
		<td class="fields" colspan='4'>
			<select class="fields" name='source_type' id='source_type' onChange="clearSource();" value="<%=strSourceType%>">
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
		<div id='more_img' style='position:absolute;visibility:hidden;'><img src='../../eOT/images/more.gif' onMouseOver="if(source_desc.value!='')Tip(getLongNameRefSrc());else Untip();" onMouseOut="UnTip()"></img></div>
	</td>
	</tr>
	<tr>
	  <td class="label">&nbsp;</td>
	  <td class='fields'><input type='text' name='source_desc' id='source_desc' size='67' value="<%=strSourceDesc%>" class="fields" onBlur="if(this.value!='') searchSourceTypeSelect(source_desc); else callchangeMoreIcon(); ">
      <input type='button' class='button' name='quest6' id='quest6' value='?' onClick="searchSourceTypeSelect(source_desc);" ></td>
	  <td class="label">&nbsp;</td>
	  <td class="fields">&nbsp;</td>
    </tr>
	<tr>
		<td class="label">
			<fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/>
		</td>
		<td class='fields'>
			<input type='text' name='pre_oper_diag' id='pre_oper_diag' size='28' value="<%=strPreOperDiag%>" class="fields" >
		</td>
		<td class="label">
			<fmt:message key="Common.status.label" bundle="${common_labels}"/>
		</td>
		<td class="fields">
			<select class="fields" name='status' id='status' >
			<option value='A'>
				<fmt:message key="Common.AllCases.label" bundle="${common_labels}"/>
			</option>
			<option value='B'>
				<fmt:message key="Common.booked.label" bundle="${common_labels}"/>
			</option>
			<option value='W'>
				<fmt:message key="Common.WaitList.label" bundle="${common_labels}"/>
			</option>
			<option value='C'>
				<fmt:message key="Common.cancelled.label" bundle="${common_labels}"/>
			</option>
			<option value='R'>
				<fmt:message key="eOT.ReScheduleCases.Label" bundle="${ot_labels}"/>
			</option>
			</select>
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>

	<tr>
		<td colspan="4" class='button' align='right'>
			<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="bookingQuerySearch()">
			<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' 	onClick="funResetAll()" >

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
  catch(Exception ee) 
  {
//	  eOT.LogFile.log("OTDebugger","Exception"+ee,this);
  }
  finally 
  {
	  if(pstmt!=null)	  pstmt.close();
	  if(conn!=null)ConnectionManager.returnConnection(conn,request);
  }
  %>


<input type='hidden' name='Anaesthetiest1_code' id='Anaesthetiest1_code' value="<%=strAneasthetistCode%>">
<input type='hidden' name='room_code' id='room_code' value="<%=strRoomCode%>">
<input type='hidden' name='theatre_type' id='theatre_type' value="">
<input type='hidden' name='theatre_type_code' id='theatre_type_code' value="<%=strTheatreTypeCode%>">
<input type='hidden' name='orderiddate' id='orderiddate' value="">
<input type='hidden' name='date_compare' id='date_compare' value="">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityid%>">
<input type='hidden' name='SPECIALITY_CODE' id='SPECIALITY_CODE' value="<%=strSpecialityCode%>">
<input type='hidden' name='SURGEON_CODE' id='SURGEON_CODE' value="<%=strSurgeonCode%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='HLongRefSrcId' id='HLongRefSrcId' value="">
<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="from_date##Booking Date" disabled>
<input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="to_date" disabled>



</form>
</body>
</html>

