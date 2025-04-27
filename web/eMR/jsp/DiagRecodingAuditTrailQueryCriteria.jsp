<!DOCTYPE html>
<!--
	Developed by 	:	Rajesh
	Created on 	:	1/4/2005 
	Module		:	mr
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "java.util.*,java.sql.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
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
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eMR/js/QueryDiagRecodingAuditTrail.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
	<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


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
	if(document.forms[0].age_from.value=="")
	{
		document.forms[0].age_from.focus();
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
			document.forms[0].encounter1_exp_date.focus();
			document.forms[0].encounter1_exp_date.select();
		}
		else if(!isBeforeNow(greg_tdt,"DMY","en"))
		{
			var msg=getMessage("MRDATE1_GT_DATE2",'MR');
			msg=msg.replace('$',getLabel("Common.todate.label","Common"));
			msg=msg.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(msg);
			document.forms[0].encounter2_exp_date.focus();
			document.forms[0].encounter2_exp_date.select();
		}
		else if(!isBefore(greg_frdt,greg_tdt,"DMY","en"))
		{
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].encounter2_exp_date.focus();
			document.forms[0].encounter2_exp_date.select();
		}
	}
}

</script>
	
</head>
	
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='Diagcodecriteria' id='Diagcodecriteria'  method="post" target="Dummy_frame">
	<table border='0' cellpadding='2' cellspacing='0' width="100%">
	<%
		SimpleDateFormat dateFormat1 = new SimpleDateFormat( "dd/MM/yyyy" ) ;
		String currentdate 		= dateFormat1.format(new java.util.Date()) ;
	%>
	<tr>
		<td class=label  ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td  class=fields><input type='text' name='patient_id' id='patient_id'  value="" size='12' maxlength="10" onBlur="makeValidString(this);ChangeUpperCase(this);" onKeypress='makeValidString(this);return CheckForSpecChars(event);'  ><input type='button' class='button' value='?' name='pat_id' id='pat_id' onClick="funPatient();" ></td>
		<td class='label'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
	</tr>
	<tr>
		<td  class=label><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class=fields><select name="location_sel" id="location_sel" onChange="clear_desc();"><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
		<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		</select>/<input type='text' name='location_desc' id='location_desc' onblur="searchCode_new();"  disabled value="" size='20' maxlength='20'><input type='button' disabled class='button' value='?' name='location' id='location' onClick="searchCode_new();" >
		<input type="hidden" name="location_hidden" id="location_hidden"></td>
		<td  class=label><fmt:message key="eMR.RecodedBy.label" bundle="${mr_labels}"/></td>
		<td  class=fields><input type='text' name='update_by_text' id='update_by_text' value="" onBlur='callSearch(this,update_by_text)' size='17' maxlength='20' ><input type='button' class='button' value='?' name='upd_by' id='upd_by' onClick="callSearch(this,update_by_text)" ><input type='hidden' name='update_by' id='update_by' value=""></td>
	</tr>
	<tr>
		<td class=label nowrap><fmt:message key="eMR.OrigDiagCode.label" bundle="${mr_labels}"/></td>
		<td class=fields><input type='text' name='mr_diagnosis_code' id='mr_diagnosis_code' value="" size='20' maxlength='20'><input type='button' class='button' value='?' name='diag_button' id='diag_button' onClick="callDiagnosis(mr_diagnosis_code,this);"></td>
		<td class=label ><fmt:message key="eMR.DiagStage.label" bundle="${mr_labels}"/></td>
		<td class=fields><select name="diagnosis_stage" id="diagnosis_stage"><option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
		<option value="A"><fmt:message key="Common.admission.label" bundle="${common_labels}"/></option>
		<option value="D"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></option>
		<option value="I"><fmt:message key="Common.Intermediate.label" bundle="${common_labels}"/></option>
		</select></td>
	</tr>
	<tr>
		<td    class=label><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
		<td    class=fields><input type='text' name='age_from' id='age_from'  value="" size='4' maxlength='3' onKeyPress="return allowPositiveNumber();" onblur="callagevalid(this,document.forms[0].age_to);"><fmt:message key="Common.Years.label" bundle="${common_labels}"/> - <input type='text' name='age_to' id='age_to'  onkeypress="return allowPositiveNumber1();" onblur="callagevalid(document.forms[0].age_from,this);" value="" size='4' maxlength='3' ><fmt:message key="Common.Years.label" bundle="${common_labels}"/>
		</td>
		<td     class=label><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td   class=fields ><select name="gender_val" id="gender_val"><option >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
		<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
		<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select>
		</td>
	</tr>
	<tr>
		<td class=label    nowrap><fmt:message key="eMR.EncPeriod.label" bundle="${mr_labels}"/></td>
		<td class=fields  >
		<input type="text" name="encounter1_exp_date" id="encounter1_exp_date" size="8" maxlength='10' id='altidexpdt1'  onblur="validDateObj(this,'DMY','en');ComparePeriodFromToTime(this,encounter2_exp_date);" ></input><img src='../../eCommon/images/CommonCalendar.gif'  onClick="document.forms[0].encounter1_exp_date.focus();return showCalendar('encounter1_exp_date');"/> - <input type="text" name="encounter2_exp_date" id="encounter2_exp_date" size="8" maxlength='10' id='altidexpdate2'  onblur="validDateObj(this,'DMY','en');ComparePeriodFromToTime(encounter2_exp_date,this);"  ></input><img src='../../eCommon/images/CommonCalendar.gif'   onClick="document.forms[0].encounter2_exp_date.focus();return showCalendar('encounter2_exp_date');"/>
		</td>
		<td class=label   nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
		<td class=fields><select name="encounter_type_sel" id="encounter_type_sel"><option >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
		<%	rset = stmt.executeQuery("select PATIENT_CLASS, short_desc from am_patient_class order by 1")  ;
			if(rset != null)
			{									
				while (rset.next())
				{	%>
					<option value='<%=rset.getString("PATIENT_CLASS")%>'><%=rset.getString("short_desc")%></option>
		<%     }
			}
			if(rset != null) rset.close();
			%>
		</select></td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class=fields ><input type='text' name='encounter_id' id='encounter_id' value=""  size='12' maxlength='12' ></td>
		<td class='label'>&nbsp;</td>
		<td  class='button'> <INPUT TYPE="button" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%> "  onClick='callSearch1()' class='BUTTON'>	<INPUT TYPE="button" value="  <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%> " class='BUTTON' onClick='clearScreen()';><td>
	</tr>
	<input type='hidden' name='diag_code' id='diag_code' value = "<%=diag_code%>"></input>
	<input type='hidden' name='diag_desc' id='diag_desc' value = "<%=diag_desc%>"></input>
	<input type='hidden' name='facility_id' id='facility_id' value = "<%=p_facility_id%>"></input>
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

