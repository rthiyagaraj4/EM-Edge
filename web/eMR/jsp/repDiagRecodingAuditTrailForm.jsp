<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "java.util.*,java.sql.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%

request.setCharacterEncoding("UTF-8");
Connection con=null;
Statement stmt=null;
ResultSet rset=null;
String diag_code="";
String diag_desc="";
String p_facility_id="";

try
  {
 
	 con =  ConnectionManager.getConnection(request);
	  stmt	= con.createStatement();
	   p_facility_id		= (String) session.getValue( "facility_id" ) ;
	    String resp_id     = (String) session.getValue("responsibility_id");
	String user_id     = (String) session.getValue("login_user");
	 rset	= stmt.executeQuery("SELECT DECODE(DIAG_CODE_SCHEME,'1','ICD10','2','ICD9CM') SCHEME_DESC, DIAG_CODE_SCHEME FROM MR_PARAMETER");
		
	if ((rset != null) && (rset.next()))
	{
		diag_code = rset.getString("DIAG_CODE_SCHEME");
		diag_desc = rset.getString("SCHEME_DESC");
	}
	if(rset != null) rset.close();

%>
	
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		
     <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eMR/js/repDiagRecodingAuditTrail.js' language='javascript'></script>
	<script src='../../eMR/js/QueryDiagRecodingAuditTrail.js' language='javascript'></script>
		
		 <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	         <script src="../../eCommon/js/DateUtils.js"></script>

		<!-- <script src='../../eMR/js/QueryDiagRecodingAuditTrail.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	<script>
	function allowPositiveNumber1() 
	{		
			callchk_toage();
			var key = window.event.keyCode;
			if(((key >=48 ) && (key<58))) 
			{
				return true;
			}
			else
				return false;
		
	}
    function callagevalid(obj,obj1)
	  {
       // alert(obj.value)
		//	alert(obj1.value)
		 if(obj1.value!='')
		 {
		 if(eval(obj.value) > eval(obj1.value))
		  {
			var error=getMessage("MRDATE1_LT_DATE2",'MR')
			error=error.replace('#',getLabel("Common.from.label","Common")+' '+getLabel("Common.age.label","Common"))
			error=error.replace('$',getLabel("Common.to.label","Common")+' '+getLabel("Common.age.label","Common"))
			 alert(error);
			 obj1.select();
			 obj1.focus();
		  }
		 }
	  }
	function callchk_toage()
	{
		if(document.forms[0].p_fm_age.value=="")
		{
			document.forms[0].p_fm_age.focus();
			return false;
		}
		else 
			return true;


	}

function ComparePeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";
	
	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
	
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(!isBeforeNow(greg_frdt,"DMY","en"))
		{
			var msg=getMessage("MRDATE1_GT_DATE2",'MR');
			msg=msg.replace('$',getLabel("Common.fromdate.label","Common"));
			msg=msg.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(msg);
			document.forms[0].p_fm_admn_date.focus();
			document.forms[0].p_fm_admn_date.select();
		}
		else if(!isBeforeNow(greg_tdt,"DMY","en"))
		{
			var msg=getMessage("MRDATE1_GT_DATE2",'MR');
			msg=msg.replace('$',getLabel("Common.todate.label","Common"));
			msg=msg.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(msg);
			document.forms[0].p_to_admn_date.focus();
			document.forms[0].p_to_admn_date.select();
		}
		else if(!isBefore(greg_frdt,greg_tdt,"DMY","en"))
		{
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].p_to_admn_date.focus();
			document.forms[0].p_to_admn_date.select();
		}
	}
}

</script>
	
</head>
	
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="AuditTrail" id="AuditTrail" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
	SimpleDateFormat dateFormat1 = new SimpleDateFormat( "dd/MM/yyyy" ) ;
   	String currentdate 		= dateFormat1.format(new java.util.Date()) ;
	%>    
<table border='0' cellpadding='3' cellspacing='0' width="80%" align='center'>
	<br>
	<br>
	<br>

	<!-- Newly added by shyam 17/09/2005 -->
	 <tr>
		<td colspan=1 width="15%">&nbsp;</td>
		<td colspan=1 width="40%">&nbsp;</td>
		<td colspan=1 width="15%">&nbsp;</td>
		<td colspan=1 width="30%">&nbsp;</td>
	</tr>
	<tr>
			<td colspan=1 class=label><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td  class='fields'>
				<select name="p_location" id="p_location" onChange="clear_desc1();"><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				</select>&nbsp;/&nbsp;<input type='text' name='location_desc' id='location_desc' onblur="searchCode_new11();"  disabled value="" size='20' maxlength='20'><input type='button' disabled class='button' value='?' name='location' id='location' onClick="searchCode_new11();" >
				<input type="hidden" name="p_location_code" id="p_location_code">
			</td>
			<td class=label><fmt:message key="eMR.DiagStage.label" bundle="${mr_labels}"/></td>
			<td class='fields'><select name="p_diag_stage" id="p_diag_stage"><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
			<option value="A"><fmt:message key="Common.admission.label" bundle="${common_labels}"/></option>
			<option value="D"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></option>
			<option value="I"><fmt:message key="Common.Intermediate.label" bundle="${common_labels}"/></option>
			</select>
			</td>
		
	</tr>
	<tr>
			<td class=label><fmt:message key="eMR.OriginalTermSet.label" bundle="${mr_labels}"/></td>
			<td class='fields'>
				<select name="original_set" id="original_set" onchange = "enable_code()"><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
				<%
					 
					String term_set_id   = "";
					String term_set_desc = "";
					String sql = " select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc ";

					rset = stmt.executeQuery(sql);
					if( rset != null )
					{
						while( rset.next())
						{
	        				term_set_id = rset.getString("term_set_id") ;
	        				term_set_desc=rset.getString("term_set_desc");
				%>
				
					<option value='<%= term_set_id %>'><%= term_set_desc %></option>

				<%
			  }
		  }
//out.println("<script>alert(\"term_set_id"+term_set_id+"\");</script>");
			%>

				</select>
				</td>
				
			
			<td class=label ><fmt:message key="eMR.OriginalCode.label" bundle="${mr_labels}"/></td>
			<td class='fields'><input type='text' name='p_diag_code' id='p_diag_code' value="" size='20' maxlength='20' disabled><input type='button' class='button' value='?' name='diag_button' id='diag_button' onClick="call_Diagnosis(p_diag_code,this);" disabled><img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id = 'i_diag_code'></img>
			</td>
			<!--<td class=label><fmt:message key="eMR.DiagStage.label" bundle="${mr_labels}"/></td>
			<td class='fields'><select name="p_diag_stage" id="p_diag_stage"><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
			<option value="A"><fmt:message key="Common.admission.label" bundle="${common_labels}"/></option>
			<option value="D"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></option>
			<option value="I"><fmt:message key="Common.Intermediate.label" bundle="${common_labels}"/></option>
			</select>
			</td>-->
	</tr>
    <tr>
			<td class=label><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='p_patient_id' id='p_patient_id'  value="" size='12' maxlength="10" onBlur="makeValidString(this);ChangeUpperCase(this);" onKeypress='makeValidString(this);return CheckForSpecChars(event);'  ><input type='button' class='button' value='?' name='pat_id' id='pat_id' onClick="funPatient1();" >
			</td>
			<td  class=label><fmt:message key="eMR.RecodedBy.label" bundle="${mr_labels}"/></td>
			<td class='fields'>
				<input type='text' name='update_by_text' id='update_by_text' value="" onBlur='callSearch2(this,update_by_text)' size='17' maxlength='20' ><input type='button' class='button' value='?' name='upd_by' id='upd_by' onClick=" callSearch2(this,update_by_text)" ><input type='hidden' name='p_recoded_by' id='p_recoded_by' value="">
			</td>
	</tr>
	<tr>
			<td class=label><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='p_fm_age' id='p_fm_age'  value="" size='4' maxlength='3' onblur="callagevalid(this,document.forms[0].p_to_age);" onKeyPress="return allowPositiveNumber();"><fmt:message key="Common.Years.label" bundle="${common_labels}"/>&nbsp;&nbsp;-&nbsp;&nbsp;<input type='text' name='p_to_age' id='p_to_age'  onblur="callagevalid(document.forms[0].p_fm_age,this);"  onkeypress="return allowPositiveNumber1();" value="" size='4' maxlength='3' ><fmt:message key="Common.Years.label" bundle="${common_labels}"/>
			</td>
			<td  class=label><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td  class='fields'><select name="p_gender" id="p_gender"> <option value="" >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
			<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
			<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			</select>
			</td>
  </tr>
  <tr>
			<td class=label><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='p_encounter_id' id='p_encounter_id' value=""  size='12' maxlength='12' >
			</td>
			<td class=label><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name="p_encounter_type" id="p_encounter_type"> <option value="" >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
			<%	
				rset = stmt.executeQuery("select PATIENT_CLASS, short_desc from am_patient_class order by 1")  ;
				if(rset != null)
				{									
					while (rset.next())
					{	%>
						<option value='<%=rset.getString("PATIENT_CLASS")%>'><%=rset.getString("short_desc")%></option>
			 <%     }
				}
				if(rset != null) rset.close();
			 %>
				</select>
			</td>
  </tr>
  <tr>
			<td class=label ><fmt:message key="eMR.EncPeriod.label" bundle="${mr_labels}"/></td>
			<td class='fields'>
			<input type="text" name="p_fm_admn_date" id="p_fm_admn_date"  size="8" maxlength='10'  onblur="validDateObj(this,'DMY','en');ComparePeriodFromToTime(this,p_fm_admn_date);" ></input><img src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].p_fm_admn_date.focus();return showCalendar('p_fm_admn_date');"/><img src='../../eCommon/images/mandatory.gif'></img>
			&nbsp;-&nbsp; 
			<input type="text" name="p_to_admn_date" id="p_to_admn_date" size="8" maxlength='10'  onblur="validDateObj(this,'DMY','en');ComparePeriodFromToTime(p_to_admn_date,this);"></input><img src='../../eCommon/images/CommonCalendar.gif'   onClick="document.forms[0].p_to_admn_date.focus();return showCalendar('p_to_admn_date');"/><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
			<!--Level has been added for the PMG20089-CRF-0409    --->
			<td class=label><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name="p_stage_no" id="p_stage_no"> <option value="" >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option> 
			<option value="1"  >1</option>
			<option value="2" >2</option>
			<option value="3" >3</option>
				</select>
			</td>
			<!--Level has been added for the PMG20089-CRF-0409    --->
			
  </tr>
	<tr>
		<td class='label' colspan=4>&nbsp;</td>
	</tr> 
			 	 	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
	<input type='hidden' name='p_facility_id' id='p_facility_id' value = "<%=p_facility_id%>"></input>
	 <input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="MRBAUDIT">
	 <input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
	<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
	<input type='hidden' name='diag_code' id='diag_code' value = "<%=diag_code%>"></input>
	<input type='hidden' name='diag_desc' id='diag_desc' value = "<%=diag_desc%>"></input>
	<input type='hidden' name='sysdate' id='sysdate' value = "<%=currentdate%>"></input>
</table>
</form>
	<%
	} catch(Exception e){
		//out.println("sub : "+e.toString());
		e.printStackTrace();
	}
   finally
    {
  		if(rset != null) rset = null;
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
    }
	%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

