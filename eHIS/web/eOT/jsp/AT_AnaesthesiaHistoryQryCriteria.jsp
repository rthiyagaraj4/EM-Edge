<!DOCTYPE html>
<html>                        
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff");	%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id=(String)session.getValue("facility_id");
	String called_from = checkForNull(request.getParameter("called_from"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String patient_name=checkForNull(request.getParameter("patient_name"));
%>

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

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/><link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/AT_AnaesthesiaHistory.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JavaScript">
var count = 0;
function localTrimString(sInString) {
   return sInString.replace(/^\s+|\s+$/g,"");
}
function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patient_id.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")
	formObj.patient_name.value="";
	
}

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="AnaesthesiaHistoryQryCriteriaForm" id="AnaesthesiaHistoryQryCriteriaForm">
<input type="hidden" name="facility_id" id="facility_id" value=<%=facility_id%> >
<input type="hidden" name="called_from" id="called_from" value=<%=called_from%> >
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<% 

	String cur_date = "";
	String PatIDLen="";
	String SQL="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') FROM DUAL";
	String disable_flag=("OT_SLATE".equals(called_from)||"REC_ANES".equals(called_from))?"disabled":"";
    Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst = null;
    con = ConnectionManager.getConnection(request);
    try{
		String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
		pstmt=con.prepareStatement(sqlLen);
		rst=pstmt.executeQuery();
		while(rst.next() && rst!=null)
		{
		PatIDLen   = (rst.getString("PATIENT_ID_LENGTH")==null)?"0":rst.getString("PATIENT_ID_LENGTH");
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		
		pstmt = con.prepareStatement(SQL);
		rst=pstmt.executeQuery();
		while (rst.next()){
			cur_date =com.ehis.util.DateUtils.convertDate(rst.getString(1),"DMY","en",locale);
		}
		cur_date=(disable_flag.equals(""))?cur_date:"";
	}catch(Exception e){
		 e.printStackTrace();
		 //System.err.println("Err Msg in SurgeryHistoryQryCriteria"+e.getMessage());
	}finally{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}


%>
<table cellpadding="3" cellspacing="0" border="0" width="100%" align="right">
<%
if(	!called_from.equals("OT_SLATE") && !called_from.equals("REC_ANES") ){
%>
<tr>		
	<td  width="25%"  class='label'>
	<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>
	</td>
	<td  width="25%" class='fields'>
		<input type='text' name='from_date' id='from_date' size='11' value="<%=cur_date%>" maxlength='10' onBlur="isValidDate(this);"  >
		<img src="../../eCommon/images/CommonCalendar.gif"	
		onClick="return showCalendar('from_date');">
	</td>
	<td  width="25%" class='label'>
	<fmt:message key="Common.todate.label"	 bundle="${common_labels}"/>
	</td>
	
	<td  width="25%" class='fields'>
	<input type='text' name='to_date' id='to_date' size='11'   value=''  maxlength='10' onBlur="isValidDate(this);">
	<img src="../../eCommon/images/CommonCalendar.gif"	
	onClick="return showCalendar('to_date');">
	</td>
	<td  width="25%" class='fields'>
	<td>
		
	</tr>
<tr>
	<td class="label" WIDTH="25%" >
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
		<td  class="fields" WIDTH="25%" >
		<input type='text' name='patient_id' id='patient_id' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' value= "<%=patient_id%>" 
		onBlur="if(this.value!='')callPatSearch();else clearDesc();" onkeypress="return CheckForSpecChars(event)">
		<input type='button' class='button' value='?' name='lkup_patient' id='lkup_patient' onClick="callPatSearch();" <%=disable_flag%> >
	</td>
<td class="label" WIDTH="25%" >
	<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
	</td>
		<td  class="fields" WIDTH="25%" >
		<input type='text' name='patient_name' id='patient_name'  size='30'  value= "<%=patient_name%>" readonly tabindex=-1>
	</td>
</tr>
<tr>
	<td class="label" WIDTH="25%" >
	<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/>
	</td>
	<td   WIDTH="25%" class="fields" >
		<input type='hidden' name='anaesthetist_code' id='anaesthetist_code' value="">
		<input name='anaesthetist_desc' id='anaesthetist_desc' maxlength='20' size='20' value='' onBlur="if(this.value!='')LookUpSearch(anaesthetist_code,anaesthetist_desc,lkup_anaesthetist); else anaesthetist_code.value='' ">
		<input type='button' class='button' value='?' name='lkup_anaesthetist' id='lkup_anaesthetist' onClick="LookUpSearch(anaesthetist_code,anaesthetist_desc,this);"> 
	</td>
	<td  class="label" WIDTH="25%">
			<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
</td>

		<td class="fields" WIDTH="25%">	
			<input type='hidden' name='surgeon_code' id='surgeon_code' value=''>
			<input type='text' name='surgeon_desc' id='surgeon_desc' size='20' onBlur="if(this.value!='')LookUpSearch(surgeon_code,surgeon_desc,lkup_surgeon); else surgeon_code.vlue='' ">
			<input type='button' class='button' value='?' name='lkup_surgeon' id='lkup_surgeon' onClick="LookUpSearch(surgeon_code,surgeon_desc,this);" >
		</td>
		<td class="label" WIDTH="25%" colspan="2" >
		</td>
		
</tr>


<tr>
<td class="label" width="25%" >
<fmt:message key="Common.speciality.label"	 bundle="${common_labels}"/>

</td>
		<td  width="25%" class="fields" colspan="2" >
			<input type='hidden' name='sptly_code' id='sptly_code' value="">
			<input type="text" name='splty_desc' id='splty_desc' maxlength='20' size='20' value= '' onBlur="if(this.value!='')LookUpSearch(sptly_code,splty_desc,lkup_speciality); else sptly_code.value='' " >
			<input type='button' class='button' value='?' name='lkup_speciality' id='lkup_speciality' onClick="LookUpSearch(sptly_code,splty_desc,this);">
		<td  width="25%" class="fields"  >
			<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label"	 bundle="${common_labels}"/>' onClick="callSearch();">
			<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' 	onClick="clearForm();" >
		</td>
		<td width="25%" class="fields" colspan="2">	
		</td>
	
	</td>
</tr>	

<%
	}else{
%>

<input type='hidden' name='patient_id' id='patient_id' size='12' value= "<%=patient_id%>" >
<input type='hidden' name='patient_name' id='patient_name'  size='30'  value= "<%=patient_name%>" readonly tabindex=-1>
<input type='hidden' class='button' value='?' name='lkup_patient' id='lkup_patient' onClick="callPatientSearch();" <%=disable_flag%> >

<input type='hidden' name='surgeon_code' id='surgeon_code' value=''>
<input type='hidden' name='surgeon_desc' id='surgeon_desc' size='25'>
<input type='hidden' class='button' value='?' name='lkup_surgeon' id='lkup_surgeon' onClick="LookUpSearch(surgeon_code,surgeon_desc,this);" >

<tr>
	<td class="label" WIDTH="25%" >
		<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/>
	</td>
	<td   WIDTH="25%" class="fields" >
		<input type='hidden' name='anaesthetist_code' id='anaesthetist_code' value="">
		<input name='anaesthetist_desc' id='anaesthetist_desc' maxlength='20' size='20' value='' onBlur="if(this.value!='')LookUpSearch(anaesthetist_code,anaesthetist_desc,lkup_anaesthetist); else anaesthetist_code.value='' ">
		<input type='button' class='button' value='?' name='lkup_anaesthetist' id='lkup_anaesthetist' onClick="LookUpSearch(anaesthetist_code,anaesthetist_desc,this);"> 
	</td>
	<td class="label" width="25%" >
		<fmt:message key="Common.speciality.label"	 bundle="${common_labels}"/></td>
	<td  width="25%" class="fields" colspan="2" >
			<input type='hidden' name='sptly_code' id='sptly_code' value="">
			<input name='splty_desc' id='splty_desc' maxlength='20' size='20' value= '' onBlur="if(this.value!='')LookUpSearch(sptly_code,splty_desc,lkup_speciality); else sptly_code.value='' " >
			<input type='button' class='button' value='?' name='lkup_speciality' id='lkup_speciality' onClick="LookUpSearch(sptly_code,splty_desc,this);">
	</td>
</tr>
<tr>		
	<td  width="25%"  class='label'>
	<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>
	</td>
	<td  width="25%" class='fields'>
		<input type='text' name='from_date' id='from_date' size='11' value="<%=cur_date%>" maxlength='10' onBlur="isValidDate(this);"  >
		<img src="../../eCommon/images/CommonCalendar.gif"	
		onClick="return showCalendar('from_date');">
	</td>
	<td  width="25%" class='label'>
	<fmt:message key="Common.todate.label"	 bundle="${common_labels}"/>
	</td>
	<td  width="25%" class='fields'>
	<input type='text' name='to_date' id='to_date' size='11'   value=''  maxlength='10' onBlur="isValidDate(this);">
	<img src="../../eCommon/images/CommonCalendar.gif"	
	onClick="return showCalendar('to_date');">
	</td>
</tr>
<tr>
<td  width="25%" class="fields"></td><td  width="25%" class="fields"></td>
<td  width="25%" class="fields" colspan=4>
		<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label"	 bundle="${common_labels}"/>' onClick="callSearch();">
		<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' 	onClick="clearForm();" >
</td>
</tr>	
<%
	}
%>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

<% 
if("OT_SLATE".equals(called_from) || "REC_ANES".equals(called_from)){
	 out.println("<script>autoCall('"+patient_id+"','"+patient_name+"')</script>");
	}

%>

</form>
</body>
</html>

