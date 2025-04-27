<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rset		= null;
	Statement medstmt	= null;
	ResultSet medrs		= null;
	boolean isCnrmReqPatOutChngAppl = false;
	try
	{
		con						=	ConnectionManager.getConnection(request);
		String facilityId		=	checkForNull((String)session.getValue("facility_id"));
		String eid				=	checkForNull(request.getParameter("encounter_id"));
		long    encounterid		=	Long.parseLong(eid);
		String call_function =  request.getParameter("function_name");
		call_function = (call_function==null) ? "" : call_function;
		StringBuffer strBuffer	= new StringBuffer();
		//	Tuesday, June 29, 2010 , modified for PMG20089-CRF-0851-IN022285 , to default Transferring Practitioner with Attending Practitioner 

		String frpractitionerid	=  request.getParameter("frpract_id");
		frpractitionerid = (frpractitionerid==null) ? "" : frpractitionerid;
		String frpractdesc		=  request.getParameter("frpract_desc");
		frpractdesc = (frpractdesc==null) ? "" : frpractdesc;

		isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");//Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617

%>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../js/TransferPatient.js" language="javascript"></script> 
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</script>
	<script>
/*
	var isShift = false;
	function setShift(){
		
		var keyCode=window.event.keyCode;
			if(keyCode == 16) isShift=true;
		
	}
	var isTab = false
	function setTab1()
	{
		var keyCode = window.event.keyCode;
		if(keyCode == 9){
		//document.forms[0].auth_date_time.focus();

		}
	}
	

function shift_tab1(){
		var keyCode=window.event.keyCode;
		if(keyCode == 9 && isShift == true){
		parent.frames[5].button_c.focus();
		}
		
	}	
	function shift_tab2(){
		var keyCode=window.event.keyCode;
		if(keyCode == 9 ){
		parent.frames[5].button_c.focus();
		}
		
	}	

	*/
	function FirstElement()
	{
		
		document.forms[0].practitioner_desc.focus();
	}
	</script>
</head>
<%
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt = new java.util.Date();
	String d = dateFormat.format( dt ) ;
	String min = String.valueOf(dt.getMinutes()) ;
	if(min.length() == 1)   min = "0"+min ;

	d=d + " "+String.valueOf(dt.getHours())+":"+min;
	
	String checkVal						= "";
	String selecVal						= "";
	String informed_yn					= "";
	String informed_to					= "";
	String informed_date_time			= "";
	String informed_name_value			= "";
	String auth_trf_date_time			= "";
	String blocked_until_date_time		= "";
	String auth_pract_name				= "";
	String blocking_remarks				= "";
	String blocking_type_code			= "";
	String auth_trf_date_time_converted	= "";
	String informed_date_time_converted = "";
	String sdate						= "";
	String locale						= (String)session.getAttribute("LOCALE");
		/*Tuesday, May 04, 2010 , condition added for PE ,since this query will be applicable for Transfer Patient IN */
		if(call_function.equals("TransferPatientIn"))
		{
			strBuffer.delete(0, strBuffer.length());
			strBuffer.append("select to_char(informed_date_time, 'dd/mm/rrrr hh24:mi') informed_date_time, informed_name, informed_to, informed_yn,bed_blk_period_hrs,blocking_type_code,blocking_remarks,to_char(auth_trf_date_time,'dd/mm/rrrr hh24:mi') auth_trf_date_time,(case when auth_practitioner_id is not null then (am_get_desc.am_practitioner(auth_practitioner_id,'"+locale+"',1)) end) auth_pract_name,to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from ip_transfer_request where tfr_req_status = '3' and encounter_id =");
			strBuffer.append(encounterid);
			strBuffer.append("  and facility_id = '");
			strBuffer.append(facilityId);
			strBuffer.append("'");

			stmt  = con.createStatement();
			rset  = stmt.executeQuery(strBuffer.toString());
			if(rset.next())
			{
				informed_yn					= checkForNull(rset.getString("INFORMED_YN"));
				informed_to					= checkForNull(rset.getString("INFORMED_TO"));
				blocked_until_date_time		= checkForNull(rset.getString("BED_BLK_PERIOD_HRS"));
				blocking_type_code			= checkForNull(rset.getString("BLOCKING_TYPE_CODE"));
				blocking_remarks			= checkForNull(rset.getString("BLOCKING_REMARKS"));
				informed_date_time			= checkForNull(rset.getString("INFORMED_DATE_TIME"));
				if(!(informed_date_time.equals("") || informed_date_time == null))
						informed_date_time_converted = DateUtils.convertDate(informed_date_time,"DMYHM","en",locale); 	
				informed_name_value			= checkForNull(rset.getString("INFORMED_NAME"));
				auth_trf_date_time			= checkForNull(rset.getString("AUTH_TRF_DATE_TIME"));
				if(!(auth_trf_date_time.equals("") || auth_trf_date_time == null))
						auth_trf_date_time_converted = DateUtils.convertDate(auth_trf_date_time,"DMYHM","en",locale); 
		
				auth_pract_name				= checkForNull(rset.getString("AUTH_PRACT_NAME"));
				sdate = rset.getString("sdate");
				if(rset	!= null)   rset.close();
				if(stmt  != null)   stmt.close();		
			}
		}
			//Tuesday, May 04, 2010 , commnted for PE
			/*
			String sdatsql = "Select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual";    
			stmt  = con.createStatement();
			rset    = stmt.executeQuery(sdatsql);
			if(rset != null)
			{
			if(rset.next())
			   {
				sdate = rset.getString("sdate");
				if(sdate == null) sdate = "";
			   }    
			if(rset	!= null)   rset.close();
			if(stmt  != null)   stmt.close();		
			}*/
%>

<body onload='FirstElement1()' onMouseDown='CodeArrest()' onKeyDown='lockKey();'>
	<form name="OtherDetaisl_form" id="OtherDetaisl_form"  method=" " action="" target="">
	<table border="0" width="100%" cellpadding="0" cellspacing="0">		
<tr>
<%
	if(call_function.equals("TransferPatientIn"))
	{
	
		if (informed_yn.equals("Y"))
			checkVal = "Checked";
		else checkVal = "";
%>
	<td class='label' width='25%' onkeyDown=''><fmt:message key="eIP.TransferringPractitioner.label" bundle="${ip_labels}"/></td>
	<td width='25%' class='fields' onkeyDown=''><input type='hidden' name='practitioner_id' id='practitioner_id' align="left"><input type='text' name='practitioner_desc' id='practitioner_desc' value='<%=auth_pract_name%>'  readOnly size='25' maxlength='30'  ><input type='button' name='pract_id_search' id='pract_id_search' value='?' disabled class='button' onClick="checkPractTextVal(document.forms[0].practitioner_id,practitioner_desc, '<%=facilityId%>');" ><img align="center" src="../../eCommon/images/mandatory.gif"><input type=hidden align="left" name="practitioner_desc_hid" id="practitioner_desc_hid" value=""></td>
	<td class='label' width='25%' onkeyDown=''>&nbsp;</td>
	<td class='label' width='25%' onkeyDown=''>&nbsp;</td>
	<%}
	else
	{%>
	<td class='label'  width='25%' ><fmt:message key="eIP.TransferringPractitioner.label" bundle="${ip_labels}"/></td>
	<td width='25%' class='fields'><input type='hidden' name='practitioner_id' id='practitioner_id' align="left" value="<%=frpractitionerid%>"><input type='text' name='practitioner_desc' id='practitioner_desc'  size='25' maxlength='30'  onblur="beforeGetTransPractitioner(practitioner_id,this,'<%=facilityId%>');"  value="<%=frpractdesc%>"><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="checkPractTextVal(document.forms[0].practitioner_id,practitioner_desc, '<%=facilityId%>');" ><img align="center" src="../../eCommon/images/mandatory.gif"><input type=hidden align="left" name="practitioner_desc_hid" id="practitioner_desc_hid" value="<%=frpractitionerid%>"></td>
	<td class='label' width='25%'>&nbsp;</td>
	<td class='label' width='25%'>&nbsp;</td>
	<%}%>
	
</tr>
<tr>
	<td class='label' onkeyDown=''><fmt:message key="eIP.AuthorizationDateTime.label" bundle="${ip_labels}"/></td>
	<td class='fields' onkeyDown=''><input type=text name='auth_date_time' id='auth_date_time' value="<%=auth_trf_date_time_converted%>"  maxlength="16" size="14" onBlur="compareSystemDate_tout(this);" onKeyPress='return(ChkNumberInput(this,event,2))' ><img src='../../eCommon/images/CommonCalendar.gif' id='ondate2'  onClick="document.forms[0].auth_date_time.select();return showCalendar('auth_date_time',null,'hh:mm');"/><img id="img_auth_date" align="center" src="../../eCommon/images/mandatory.gif"></td>
		<td class='label'  >&nbsp;</td>
		<td class='label'  >&nbsp;</td>
</tr>
<%if(call_function.equals("TransferPatientOut"))
{%>
<tr>
	<th align="left" style=" color: white;" colspan='4' class='columnheader' ><fmt:message key="eIP.BedBlockDetails.label" bundle="${ip_labels}"/></th>
</tr>
</table>
<jsp:include page="../../eIP/jsp/BlockingDetails.jsp" flush="true">
	<jsp:param name ="called_from"  value="tfr_out" />
	</jsp:include>
<%}%>

<table border="0" width="100%" cellpadding="2" cellspacing="0">	
	<tr>
		<th align="left" style=" color: white;" colspan='4' class='columnheader' width="100%" ><fmt:message key="eIP.InformedDetails.label" bundle="${ip_labels}"/></th>
	</tr>
	</table>
	<table border="0" width="100%" cellpadding="2" cellspacing="0">	
	<tr>
	<td class='label' width='25%' onkeyDown=''><fmt:message key="eIP.Informed.label" bundle="${ip_labels}"/></td><td width='25%' class='fields' onkeyDown=''><input type='checkbox' name='info_pat_relatives' id='info_pat_relatives' onClick="enableInform();" value="N" <%=checkVal%> ></td>
	<td class='label' colspan='3' onkeyDown=''>&nbsp;</td>
	
</tr>
</table>
<table border="0" width="100%" cellpadding="2" cellspacing="0">	
	<tr>
	<td class='label'  width='25%'  ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td width='25%' class='fields' ><SELECT name='inform_to' id='inform_to'   onChange = "enabledInformDate();"  disabled >
	<%if(call_function.equals("TransferPatientIn"))
	{%>
	<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<%
				if (informed_to.equals("01"))
					 selecVal = "Selected";
				else selecVal = "";
			%>
		  <option value="01" <%=selecVal%> ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option>
			<%
				if (informed_to.equals("02"))
					 selecVal = "Selected";
				else selecVal = "";
			%>
		  <option value="02"  <%=selecVal%> ><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></option>
			<%
				if (informed_to.equals("03"))
					 selecVal = "Selected";
				else selecVal = "";
			%>
		  <option value="03"  <%=selecVal%> ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		<SELECT>
	<%}
	else
	{%>
		<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		  <option value="01" ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option>
		  <option value="02" ><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></option>
		  <option value="03" ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		<SELECT><img id="img_informed_to" align="center" src="../../eCommon/images/mandatory.gif" style="visibility:hidden"><!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617-->
	<%
	}%>
	</td>
		<td class='label' onkeyDown=''>&nbsp;</td>
		</tr>
		<tr>
	<td class='label' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type='text' <%if(call_function.equals("TransferPatientIn"))
	{%>name='info_pat_name'  id='info_pat_name'<%}else{%>name='info_pat_name' id='info_pat_name' <%}%> value="<%=informed_name_value%>"  maxlength="30" size="25" disabled ></input><img id="img_informed_name" align="center" src="../../eCommon/images/mandatory.gif" style="visibility:hidden"><!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617--></td>	
	<td class='label' colspan='2' >&nbsp;</td>
	</tr>
<tr><!-- 17956 Thursday, January 07, 2010 -->
	<td class='label' ><fmt:message key="Common.InformedDate/Time.label" bundle="${common_labels}"/></td>
	<td class="fields">
<input type="text" name="info_date_time" id="info_date_time" value="" maxlength="16" 
           onblur="compareSystemDate1(this);" 
           onkeypress="return(ChkNumberInput(this,event,2));" size="14" disabled="">
<img src="../../eCommon/images/CommonCalendar.gif" id="ondate1" 
         onclick="if (!document.getElementById('info_date_time').disabled) { document.forms[0].info_date_time.select(); return showCalendar('info_date_time',null,'hh:mm'); }" 
         disabled="">
    <img id="img_informed_date" align="center" src="../../eCommon/images/mandatory.gif" style="visibility: hidden;">
</td>
	<td class='label' colspan='2' onkeyDown=''>&nbsp;</td>
		</tr>
	<tr>
	<td class='label'  >&nbsp;</td>
	<td align=right colspan='2' ><input type="button" class="button" name="inform_button" id="inform_button" value='<fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/>/<fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/><fmt:message key="Common.details.label" bundle="${common_labels}"/>' onclick="getNotifyDetail();" disabled ></td>	
</tr>
<!--<tr>
	<td class='label' >&nbsp;</td>
	<td align=right colspan='3'><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>"  onclick="submit_Form();"><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="cancel()" onblur="tab_click('other_details')"></td>
</tr> -->
</table>

<input type="hidden" name="block_date_time" id="block_date_time" value="<%=blocked_until_date_time%>">
<input type="hidden" name="bed_blocking_ok" id="bed_blocking_ok" value="Y">
<input type="hidden" name="isCnrmReqPatOutChngAppl" id="isCnrmReqPatOutChngAppl" value="<%=isCnrmReqPatOutChngAppl%>"><!--Added by Thamizh selvi on 10th May 2017 for ML-MMOH-CRF-0617-->


<%if(call_function.equals("TransferPatientIn"))
{%>
<input type="hidden" name="blocking_type_code" id="blocking_type_code" value="<%=blocking_type_code%>">
<input type="hidden" name="blocking_remarks" id="blocking_remarks" value="<%=blocking_remarks%>">
<%}%>
<input type="hidden" name="override_yn" id="override_yn" value="">

</form>
<%		
		if(stmt   != null)			stmt.close();
		if(rset	  != null)			rset.close();
		if(medstmt   != null)		medstmt.close();
		if(medrs	  != null)		medrs.close();
	}catch(Exception e){
		
		e.printStackTrace();
	}
	finally {
		ConnectionManager.returnConnection(con,request);
	}
	 %>
	 
<script>
enabledDisabled();
var Rec_type_value=document.forms[0].book_conf_yn.value;
var call_function=document.forms[0].call_function_name.value;
if(eval(Rec_type_value)>0 && call_function == 'TransferPatientOut')
{
	document.forms[0].blocking_type_code.value=document.forms[0].temp_blocking_code.value;
	if(document.forms[0].blocking_type_code.value !='')
	{
		document.forms[0].blocking_type.value=document.forms[0].temp_blocking_type.value;
		document.forms[0].bed_blocking_period.value=document.forms[0].temp_block_period.value;
		//document.forms[0].bed_block_until.value=document.forms[0].temp_blocked_until_date.value;
		document.forms[0].bed_block_until.value=convertDate(document.forms[0].temp_blocked_until_date.value,'DMYHM','en',localeName);
		document.forms[0].blocking_type_code.value=document.forms[0].temp_blocking_code.value;
		document.forms[0].override_yn.value=document.forms[0].temp_override_yn.value;

	}
	else
	{
		document.forms[0].blocking_type.value='';
		document.forms[0].blocking_type.disabled=true;
		document.forms[0].bed_blocking_period.value='';
		document.forms[0].bed_blocking_period.disabled=true;
		document.forms[0].bed_block_until.value='';
		document.forms[0].bed_block_until.disabled=true;
	}
	
}
parent.frames[2].src = "../../eCommon/html/blank.html";
</script>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

