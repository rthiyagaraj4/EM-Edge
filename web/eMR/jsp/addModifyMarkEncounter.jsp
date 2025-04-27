<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<% 
	String locale = (String)session.getAttribute("LOCALE"); 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String EncounterId = request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
	String FacilityId = request.getParameter("FacilityId")==null?"":request.getParameter("FacilityId");
	String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");

	Connection con = ConnectionManager.getConnection(request);
	/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
	/*end ML-MMOH-CRF-0354 [IN057191] */
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	String 	mlc_yn				= "";
	String  oscc_yn				= "";
	String	marked_by_id		= "";
	String	marked_by			= "";
	String 	marked_date			= "";
	String  closed_by_id		= "";
	String  closed_by			= "";
	String 	closed_date			= "";
	String readonlyfields_marked= "";
	String readonlyfields_closed= "";
	String disable				= "";
	String disabledfields		= "";
	String disabledfield		= "";
	String disabledfields1		= "";
	String sys_date				="";
	String checked_mlc			= "";
	String checked_oscc			= "";
	String disable_mlc			= "";
	String disable_oscc			= "";
	String encounter_date		= "";

	//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
	String sql		= "";
	

	boolean isDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MLC_OSCC_DATE_TIME"); //Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140

	//Added by Ajay Hatwate for GHL-CRF-0650		
	Boolean isMLCAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"AE", "MLC_DTLS");
	String polRepNo = "";
	String polStnDtl = "";
	String outMlcNoDtl = "";
	String dateOfMlcCapt = "";
	String mlcRem = "";
	String checkedMlcDeath = "";
	String visitDateTime = "";
	String recordedDate = "";
	String mlcDeathYn = "N";
	String pClass = "";
	String aeType = "";
	String disMlcFld = " disabled ";
try 
{	
	//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
	if(!isDateTimeAppl)
	{
		 sql = "select mlc_yn, oscc_yn, marked_by_id,sm_get_desc.sm_appl_user (marked_by_id,?, 1) marked_by, to_char(marked_date,'dd/mm/yyyy'), closed_by_id,sm_get_desc.sm_appl_user (closed_by_id,?, 1) closed_by, to_char(closed_date,'dd/mm/yyyy'),to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy') encounter_date,to_char(sysdate,'dd/mm/yyyy')sys_date, POL_REP_NO, POL_STN_ID, patient_class,to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') visit_adm_date_time, mlc_death_yn, mlc_remarks, to_char(MLC_CAPTURE_DATE,'DD/MM/YYYY HH24:MI:SS') MLC_CAPTURE_DATE, MLC_NO_OUTSIDE_DTLS  from pr_encounter where facility_id =? and encounter_id =? ";
	}else
	{
		 sql = "select mlc_yn, oscc_yn, marked_by_id,sm_get_desc.sm_appl_user (marked_by_id,?, 1) marked_by, to_char(marked_date,'dd/mm/yyyy hh24:mi'), closed_by_id,sm_get_desc.sm_appl_user (closed_by_id,?, 1) closed_by, to_char(closed_date,'dd/mm/yyyy hh24:mi'),to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') encounter_date,to_char(sysdate,'dd/mm/yyyy hh24:mi')sys_date, POL_REP_NO, POL_STN_ID, patient_class, to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') visit_adm_date_time, mlc_death_yn, mlc_remarks, to_char(MLC_CAPTURE_DATE,'DD/MM/YYYY HH24:MI:SS') MLC_CAPTURE_DATE, MLC_NO_OUTSIDE_DTLS from pr_encounter where facility_id =? and encounter_id =? ";
	}

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,locale);
	pstmt.setString(3,FacilityId);
	pstmt.setString(4,EncounterId);
	rset = pstmt.executeQuery();
	while(rset.next()){
		mlc_yn				= rset.getString("mlc_yn")==null?"N":rset.getString("mlc_yn");
		oscc_yn			= rset.getString("oscc_yn")==null?"N":rset.getString("oscc_yn");
		marked_by_id  = rset.getString("marked_by_id")==null?"":rset.getString("marked_by_id");
		marked_by	= rset.getString("marked_by")==null?"":rset.getString("marked_by");
		marked_date    = rset.getString(5)==null?"":rset.getString(5);
		
		//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
		if(!isDateTimeAppl)
		{
			if(!(marked_date==null || marked_date.equals(""))){
				marked_date	= DateUtils.convertDate(marked_date,"DMY","en",locale);
			}
		}else
		{
			if(!(marked_date==null || marked_date.equals(""))){
				marked_date	= DateUtils.convertDate(marked_date,"DMYHM","en",locale);
			}
		}
		closed_by_id   = rset.getString("closed_by_id")==null?"":rset.getString("closed_by_id");
		closed_by		= rset.getString("closed_by")==null?"":rset.getString("closed_by");
		closed_date     = rset.getString(8)==null?"":rset.getString(8);

		//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
		if(!isDateTimeAppl)
		{
			if(!(closed_date==null || closed_date.equals(""))){
				closed_date		= DateUtils.convertDate(closed_date,"DMY","en",locale);
			}
		}else
		{
			if(!(closed_date==null || closed_date.equals(""))){
				closed_date		= DateUtils.convertDate(closed_date,"DMYHM","en",locale);
			}
		}
		encounter_date    = rset.getString(9)==null?"":rset.getString(9);
		
		//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
		if(isDateTimeAppl)
		{
		encounter_date	  = encounter_date.replace(' ','$');
		}

		sys_date		  = rset.getString("sys_date");

		/*Added by Ajay Hatwate for GHL-CRF-0650 */
		pClass 		  = rset.getString("patient_class")==null?"":rset.getString("patient_class") ;
		polRepNo 		  = rset.getString("POL_REP_NO")==null?"":rset.getString("POL_REP_NO") ;
		polStnDtl 		  = rset.getString("POL_STN_ID")==null?"":rset.getString("POL_STN_ID");
		visitDateTime = rset.getString("visit_adm_date_time")==null?"":rset.getString("visit_adm_date_time");
		outMlcNoDtl = rset.getString("MLC_NO_OUTSIDE_DTLS")==null?"":rset.getString("MLC_NO_OUTSIDE_DTLS");
		dateOfMlcCapt = rset.getString("MLC_CAPTURE_DATE")==null?"":rset.getString("MLC_CAPTURE_DATE");
		mlcRem = rset.getString("mlc_remarks")==null?"":rset.getString("mlc_remarks");
		mlcDeathYn = rset.getString("mlc_death_yn")==null?"N":rset.getString("mlc_death_yn");
		mlcRem = escapeHTML(mlcRem);
		outMlcNoDtl = escapeHTML(outMlcNoDtl);
		polRepNo = escapeHTML(polRepNo);
		polStnDtl = escapeHTML(polStnDtl);
		if(mlcDeathYn.equals("Y")){
			checkedMlcDeath = " Checked ";
		}
		/* End GHL-CRF-0650 */
	}
	visitDateTime = visitDateTime.replace(' ','$'); //Added by Ajay Hatwate for GHL-CRF-0650
	if(pstmt!=null){
		pstmt.close();
	}
	if(rset!=null){
		rset.close();
	}
}catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
}
finally{
	if(pstmt!=null){
		pstmt.close();
	}
	if(rset!=null){
		rset.close();
	}
	if(con != null)
	ConnectionManager.returnConnection(con,request);
}
/*
Commented on 6/15/2010 for PE
try 
{
	if (rset!=null) rset.close();
	if (pstmt!=null)pstmt.close();

	String sql1 = "select to_char(sysdate,'dd/mm/yyyy') from dual ";
	pstmt = con.prepareStatement(sql1);
	rset = pstmt.executeQuery();
	while(rset.next())
	{
		sys_date = rset.getString(1);
	}
	if (rset!=null) rset.close();
	if (pstmt!=null)pstmt.close();

}
catch (Exception e)
{
	out.println(e.toString());
}*/

if((mlc_yn.equals("Y"))||(oscc_yn.equals("Y"))){
	readonlyfields_marked = "disabled";
	disabledfields = "disabled";
	disabledfields1 = "";
	readonlyfields_closed = "";
	disable = "";
}
if ( ( (mlc_yn.equals("Y")) || (oscc_yn.equals("Y")) ) &&(!closed_date.equals(""))){
	readonlyfields_marked = "disabled";
	readonlyfields_closed = "disabled";
	disable = "disabled";
	disabledfields = "disabled";
	disabledfields1 = "disabled";
	disabledfield = "disabled";
}
if((mlc_yn.equals("N"))&&(oscc_yn.equals("N"))){ 
	readonlyfields_marked = "disabled";
	readonlyfields_closed = "disabled";
	disable = "disabled";
	disabledfields = "disabled";
	disabledfields1 = "disabled";
	disabledfield = "disabled";
}

if (mlc_yn.equals("Y")){ checked_mlc="checked"; disable_mlc="disabled";disable_oscc="disabled";}
if (oscc_yn.equals("Y")){ checked_oscc="checked"; disable_oscc="disabled";disable_mlc="disabled";}
/*if ((!( marked_by_id.equals("")))&&(!(marked_date.equals(""))))
{
	readonlyfields_marked = "disabled";
	disabledfields = "disabled";
}*/
if(checked_mlc.equals("checked")){
	disMlcFld = "";
}
if (call_from.equals("QUERY_MARK_MLC_OSCC")){
	readonlyfields_marked = "disabled";
	disabledfields = "disabled";
	disabledfield = "disabled";
	disabledfields1 = "disabled";
	readonlyfields_closed = "disabled";
	disable = "disabled";
	disable_mlc="disabled";
	disable_oscc="disabled";
} 
%>

<HTML>
<HEAD>
<TITLE> <fmt:message key="eMR.MarkingofMLCOSCC.label" bundle="${mr_labels}"/> </TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src="../../eCommon/js/CommonLookup.js"></script>
	<script src='../../eMR/js/MedRecRequest.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<script>
/// added by SRIDHAR R on 31 SEP 2004
	/*function compareDates0(obj)
	{
	if(!doDateCheckAlert(document.forms[0].from_date,document.forms[0].to_date))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT",'SM'));
			document.forms[0].to_date.select();
			document.forms[0].to_date.focus();
		}
	}
	*/
	</script>
</HEAD>
<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
 <form name='markencounter_Form' id='markencounter_Form' action='../../servlet/eMR.MarkEncounterServlet' method='post' target='messageFrame'>
<table cellspacing=0 cellpadding=2 align='center' width='100%' border='0'>
	<%if(!isMLCAppl){ %>
	<tr>
	<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
	       <%if(siteSpecific){%>
		  <td width="50%" class="label" nowrap><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
		  <%}else{%>
		<td width="50%" class="label" nowrap><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
		<%}%>
		<!--end ML-MMOH-CRF-0354 [IN057191 -->
		<td width="50%" class="fields"><INPUT TYPE="checkbox" name="mlc" id="mlc" value='<%=mlc_yn%>'onclick='setvalue(this);setImg();' <%=checked_mlc%> <%=disable_mlc%>></td>
	</tr>
	<tr>
		<td class="label" nowrap><fmt:message key="Common.oscc.label" bundle="${common_labels}"/></td>
		<td class="fields"><INPUT TYPE="checkbox" name="oscc" id="oscc" value='<%=oscc_yn%>' onclick='setvalue(this);setImg();' <%=checked_oscc%> <%=disable_oscc%>></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.MarkedBy.label" bundle="${common_labels}"/></td>
		<td class="fields"><INPUT TYPE="text" name="marked_by" id="marked_by" size='30' maxlength='30' value='<%=marked_by%>'<%=readonlyfields_marked%> onblur="beforeGetuser(document.forms[0].marked_by_hid,this)"><input type=button class=button name='search_user' id='search_user' value='?' disabled onclick="getuser(document.forms[0].marked_by_hid,document.forms[0].marked_by)"><img src='../../eCommon/images/mandatory.gif' id='img1' style='visibility:hidden'></img></td><input type=hidden name="marked_by_hid" id="marked_by_hid" value='<%=marked_by_id%>'>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="Common.MarkedDate.label" bundle="${common_labels}"/></td>
		<td class="fields">
		<!-- Below code is commented by Akhilesh because unnecessary functions are using.-->
		<!--<INPUT TYPE="text" name="marked_date" id="marked_date" size='15' maxlength='15' id='markingdate' onkeypress="return Valid_DT(event);"  value='<%=marked_date%>'  onblur='date_Validate(this);compareDates0(this);check_date_to_from(this);' <%=readonlyfields_marked%> >-->

		<!--Modified by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140-->
		<INPUT TYPE="text" name="marked_date" id="marked_date" size='16' maxlength='16' onkeypress="return Valid_DT(event);"  value='<%=marked_date%>'  onblur='date_Validate(this);' <%=readonlyfields_marked%> ><img id='cal1' src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].marked_date.select();<%if(isDateTimeAppl){%>return showCalendar('marked_date',null,'hh:mm');<%}else{%>return showCalendar('marked_date');<%}%>" <%=disabledfields%>/><img src='../../eCommon/images/mandatory.gif' id='img2' style='visibility:hidden'></img></td>
	</tr>
	<tr>
		<td  class="label"><fmt:message key="eMR.ClosedBy.label" bundle="${mr_labels}"/></td>
		<td class="fields"><INPUT TYPE="text" name="closed_by" id="closed_by" size='30' maxlength='30' onblur="beforeGetuser(document.forms[0].closed_by_hid,this)" value='<%=closed_by%>'<%=readonlyfields_closed%>><input type=button class=button name='search_closed_by' id='search_closed_by' value='?' <%=disable%> onclick="getuser(document.forms[0].closed_by_hid,document.forms[0].closed_by)"><img src='../../eCommon/images/mandatory.gif' id='img3' style='visibility:hidden'></td><input type=hidden name="closed_by_hid" id="closed_by_hid" value='<%=closed_by_id%>'>
	</tr>
	<tr>
		<td class="label"><fmt:message key="eMR.ClosedDate.label" bundle="${mr_labels}"/></td>
		<td class="fields">
		<!-- Below code is commented by Akhilesh because unnecessary functions are using.-->
		<!--<INPUT TYPE="text" name="closed_date" id="closed_date" size='15' maxlength='15' id='closeddate' onkeypress="return Valid_DT(event)"  value='<%=closed_date%>' onblur='check_date_to_from(this);compareDates0(this);compareDates1(this);' <%=readonlyfields_closed%>>-->
		<INPUT TYPE="text" name="closed_date" id="closed_date" size='16' maxlength='16' onkeypress="return Valid_DT(event)"  value='<%=closed_date%>' onblur='compareDates1(this);' <%=readonlyfields_closed%>><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].closed_date.select();<%if(isDateTimeAppl){%>return showCalendar('closed_date',null,'hh:mm');<%}else{%>return showCalendar('closed_date');<%}%>" <%=disabledfields1%>/><img src='../../eCommon/images/mandatory.gif' id='img4' style='visibility:hidden'></td>
	</tr>
	<%}else if(isMLCAppl){ %>
	<tr>
		<td class="label" nowrap><fmt:message key="Common.oscc.label" bundle="${common_labels}"/></td>
		<td class="fields"><INPUT TYPE="checkbox" name="oscc" id="oscc" value='<%=oscc_yn%>' onclick='setvalue(this)' <%=checked_oscc%> <%=disable_oscc %>></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name='mlc' id='mlc' value='N' onClick = "enableOthMlcFlds(this);setvalue(this)"  <%=checked_mlc%> ></td>
		<td class='label'  ><fmt:message key="Common.MlcDeath.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="checkbox" name='mlc_death' id='mlc_death' onClick="updateSelf(this)" value='<%=mlcDeathYn %>' <%=disMlcFld %> <%=checkedMlcDeath %>></td>			
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td>
					<td class='fields'>
					<input type='text' name="police_rep_no" id="police_rep_no" maxlength='100' onpaste="maxLengthPaste(this, '100')" value='<%=polRepNo%>' <%=disMlcFld %>></td>
		<td class='label'  ><fmt:message key="Common.PoliceStationDetails.label" bundle="${common_labels}"/></td>
					<td class='fields' ><input type='text' name="police_stn_dtls" id="police_stn_dtls" maxlength='100' onpaste="maxLengthPaste(this, '100')" value='<%=polStnDtl %>' <%=disMlcFld %>></td>			
	</tr>
	<tr>
		<td class='label' width='25%' ><fmt:message key="Common.OutMlcNoDtls.label" bundle="${common_labels}"/></td>
					<td class='fields' ><input type='text' name='outside_mlc_dtls' id='outside_mlc_dtls' value='<%=outMlcNoDtl %>' maxlength='100' onpaste="maxLengthPaste(this, '100')" <%=disMlcFld %>></td>	
		<td class='label'  ><fmt:message key="Common.DateOfMlcCapture.label" bundle="${common_labels}"/></td>
					<td class='fields' >
					<input type='text'  id='dateofmlccapture' name="date_of_mlc_capture" id="date_of_mlc_capture" value='<%=dateOfMlcCapt %>' onBlur="validateMlcCapture(this)" maxLength='19' size='19' <%=disMlcFld %>><img src="../../eCommon/images/CommonCalendar.gif" id="mlcCaptureDateCalendar" onClick="return showCalendar('dateofmlccapture','dd/mm/yyyy' ,'hh:mm:ss',null )" style='cursor:pointer'></img>
					</td>				
	</tr>
	<tr>
		<td class='label'  ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class='fields' >
					<textarea name='mlc_remarks' rows="3" cols="45" onKeyPress="checkMaxLimit(this, 500)" onpaste="maxLengthPaste(this, '500')" <%=disMlcFld %>><%=mlcRem %></textarea>
					</td>	
	</tr>
	<%} %>
	<tr>
		<td class="label">&nbsp;</td>
		<td class="button" ><INPUT TYPE=button class=button name='record_button' id='record_button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onclick="submitPage1();" <%=disabledfield%> ><INPUT TYPE=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick="closeWindow();"></td>
	</tr>
</table>

	<input type='hidden' name='ENCOUNTER_ID' id='ENCOUNTER_ID' value="<%=EncounterId%>">
	<input type='hidden' name='facility_id' id='facility_id' value="<%=FacilityId%>">
	<input type='hidden' name='hddBDate' id='hddBDate' >
	<input type='hidden' name='hddDate' id='hddDate' >
	<input type='hidden' name='locale' id='locale' value=<%=locale%>>
	<input type='hidden' name='mlc_yn_temp' id='mlc_yn_temp' value=<%=mlc_yn%>>
	<input type='hidden' name='oscc_yn_temp' id='oscc_yn_temp' value=<%=oscc_yn%>>
	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
	<input type='hidden' name='sys_date' id='sys_date' value=<%=sys_date%>>
	<input type='hidden' name='encounter_date' id='encounter_date' value=<%=encounter_date%>>
	<!--Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140-->
	<input type='hidden' name='isDateTimeAppl' id='isDateTimeAppl' value=<%=isDateTimeAppl%>>

	<!-- Added by Ajay Hatwate for GHL-CRF-0650 -->
	<input type='hidden' name='isMLCAppl' id='isMLCAppl' value='<%=isMLCAppl%>'>
	<%if(isMLCAppl){ %>
		<input type='hidden' name='visit_date_time' id='visit_date_time' value='<%=visitDateTime%>'>

	<%} %>

	<script>
		if(document.forms[0].isMLCAppl.checked){
			if(document.forms[0].mlc.checked){
				enableOthMlcFlds(document.forms[0].mlc);
			}
		}
		if(document.forms[0].isMLCAppl.value =='false'){
		if (document.forms[0].mlc_yn_temp.value=='Y' && document.forms[0].closed_date.value=='')
		{
			document.getElementById("img3").style.visibility='visible';		  document.getElementById("img4").style.visibility='visible';
		}
		if (document.forms[0].oscc_yn_temp.value=='Y' && document.forms[0].closed_date.value=='')
		{
			document.getElementById("img3").style.visibility='visible';		  document.getElementById("img4").style.visibility='visible';
		}
		}
	</script>
</form>
</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	//To handle HTML Special characters for GHL-CRF-0650 by Ajay Hatwate
	public static String escapeHTML(String s) {
	  StringBuilder procStr = new StringBuilder(Math.max(16, s.length()));
	  for (int i = 0; i < s.length(); i++) {
	      char c = s.charAt(i);
	      if (c > 127 || c == '"' || c == '\'' || c == '<' || c == '>' || c == '&') {
	      	procStr.append("&#");
	      	procStr.append((int) c);
	      	procStr.append(';');
	      } else {
	      	procStr.append(c);
	      }
	  }
	  return procStr.toString();
	}
%>

