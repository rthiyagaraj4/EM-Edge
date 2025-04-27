<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<HEAD>
<TITLE> <fmt:message key="eIP.MedicalCertificate.label" bundle="${ip_labels}"/> </TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../js/DischargePatient.js' language='javascript'></script>

<script src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<script>

function apply()
{
	var fields=new Array();	
	fields[0]= document.medical_certificate_form.fit_for_duty_on;
	fields[1]= document.medical_certificate_form.issue_pract;	
	var names = new Array (	getLabel('eIP.FitForDutyon.label','IP'),
							getLabel('eIP.IssuingPractitioner.label','IP'));
	if(checkFields1( fields, names))
	{
		var p_facility_id		= document.forms[0].facilityId.value;
		var p_module_id			= "IP";
		var p_report_id			= "OAAFAPLST";

		var HtmlVal = "<html><head></head><body onKeyDown='lockKey()'><form name='dummy1_form' id='dummy1_form' action='../../eCommon/jsp/report_options.jsp'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'><input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'></form></body></html>"
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HtmlVal);
		parent.messageFrame.document.dummy1_form.submit();
	}

}

function checkFields1( fields, names)
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck1(fields[i].value)) {}
		else	
		{
			errors = errors + getMessage("CAN_NOT_BE_BLANK","Common") +"\n";
			errors = errors.replace("$",names[i]);

		}
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

async function getPractitioner(target_id,target_name)
{
	var retVal = new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var dispDescFirst="dispDescFirst";
	var tit="";
	var tit=getLabel('Common.practitioner.label','common')	
	var medicalteam = document.forms[0].medicalteam.value;
	sql = "select  practitioner_id,practitioner_name from am_practitioner where eff_Status = `E` and practitioner_id in (SELECT practitioner_id from am_medical_team where team_id = `"+medicalteam+"`) ";
	search_code="practitioner_id";
	search_desc= "practitioner_name";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst="+dispDescFirst,arguments,features);
	var arr=new Array();
	if (retVal != null)
	{ 
		if (!(unescape(retVal) == null))
		{
			arr=unescape(retVal).split("::");
			target_name.value=arr[0];
			target_id.value=arr[1];
		}
	}
	else
	{
		target_id.value="";
		target_name.value="";
	}

}

function doDateTimechk(obj)
{
	var objchk = obj.value;
	if(obj.value != '')
		{
		if(!self.doDateTimeChk(obj)){
			var msg = self.getMessage("INVALID_DATE_TIME","SM");
			alert(msg);
			obj.focus();
			return false;
		}
	}

	if(objchk != 0)
	{
		var comp=obj
		obj=obj.value
		var sysdat = document.forms[0].currdate.value;
		var dttime = obj.split(" ");
		var dt
		var time
		var retval=true
	
		if(dttime.length>1)
		{
			dt=dttime[0]
			time=dttime[1]	
			if(!checkDt(dt) )
			{
				retval= false
				comp.focus()
			}
			else
			{
				if(time==null || time=="")
				{	
					alert(getMessage("INVALID_DATE_TIME","SM"))
					retval= false;
					comp.focus()
				}
				else
				{
					if(!chkTime(time))
					{
						retval= false
						alert(getMessage("INVALID_DATE_TIME","SM"))
						comp.focus()
					}
				}
		   	}
		}
		else
		{
			retval= false
			alert(getMessage("INVALID_DATE_TIME","SM"))
			comp.focus()
		}

		

	
	if(retval != false)	
	{
		ValidateAmbDateTime(obj,sysdat);			
	}	

	return retval
	  }
	}
	
function ValidateAmbDateTime(from,to)
{
	
	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	 a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1]

	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")
	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	 if(Date.parse(from_date) < Date.parse(to_date))
	{
		alert(getMessage("F_DUTY_TIM_LT_CURDT","IP"));
		document.forms[0].fit_for_duty_on.focus();
		document.forms[0].fit_for_duty_on.select();		
		return false
	}
	else{		
		var fromval = from;
		var toval   = document.forms[0].dischdate.value;		
		ValidateDateTime12(fromval,toval)
		return true;
		
		}	
		
}

function ValidateDateTime12(from,to)
{	
	 var a=  from.split(" ")
	 splitdate=a[0];
	 splittime=a[1]
	 var splitdate1 =a[0].split("/")
	 var splittime1= a[1].split(":")
	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	 a=  to.split(" ")
	 splitdate=a[0];
	 splittime=a[1]
	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")
	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	 if(Date.parse(to_date) > Date.parse(from_date))
	{
		alert(getMessage("LT_DISCHG_DATE","IP"))
		document.forms[0].fit_for_duty_on.focus();
		document.forms[0].fit_for_duty_on.select();		
		return false;
	}
	else
		return true;

}		
</script>
</HEAD>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con 	= null;
	Statement stmt1 = null;
	ResultSet rs 	= null;
	String dischdate 	="";
	String medicalteam 	="";
	String sdate 	= "";
	String facilityId		= (String)session.getAttribute("facility_id");
%>
<BODY onLoad='document.forms[0].fit_for_duty_on.focus();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name = 'medical_certificate_form' action='../../eCommon/jsp/report_options.jsp'>
<%
	try{
		con = ConnectionManager.getConnection(request);
		dischdate = request.getParameter("dischdate");
		if(dischdate == null) dischdate ="";
		medicalteam = request.getParameter("medicalteam");
		if(medicalteam == null) medicalteam ="";		
		String sql="select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual";	
		stmt1= con.createStatement();
		rs=stmt1.executeQuery(sql);
		if(rs.next())
		{
			sdate= rs.getString("sdate");			
			if(sdate == null) sdate ="";
 			if(rs!=null)	rs.close();
			if(stmt1!= null)stmt1.close();		
		}	
%>

<TABLE cellpadding=2 cellspacing=0 width="100%" align = 'center'>
	<TR>
		<TD class= ' label' colspan='2'>&nbsp;</TD>
		
	</TR>	
	<TR>
		<TD class= ' label' colspan='2'>&nbsp;</TD>
		
	</TR>		
	<TR >
		<TD class= ' label' align ='right' width ='50%'><fmt:message key="eIP.FitForDutyon.label" bundle="${ip_labels}"/> </TD>
		<TD  width ='50%'>&nbsp;<INPUT TYPE="text" name="fit_for_duty_on" id="fit_for_duty_on" size = '15' Maxlength='16' onBlur='doDateTimechk(this)'>&nbsp<img align=center src="../../eCommon/images/mandatory.gif"></img></TD>
	</TR>
	<TR>
		<TD class= ' label' align ='right' width ='50%'><fmt:message key="eIP.IssuingPractitioner.label" bundle="${ip_labels}"/></TD>
		<TD width ='50%'>&nbsp;<input type=text Readonly name=pract_name id=pract_name value=""  size=30 maxlength=30><input type="button" name="pract_butt" id="pract_butt" value="?" class="button" onClick="getPractitioner(issue_pract,pract_name);" ><input type="hidden" name="issue_pract" id="issue_pract" value="">&nbsp;<img src ='../../eCommon/images/mandatory.gif'></img>
		</TD>
	</TR>
	<TR>
		<TD class= ' label' align ='right' width ='50%'><fmt:message key="eIP.HandedovertoPatient.label" bundle="${ip_labels}"/></TD>
		<TD width ='50%'>&nbsp;<INPUT TYPE="checkbox" name="handed_over_to_patient" id="handed_over_to_patient" size = '10' Maxlength='10'>&nbsp</TD>
	</TR>
	<TR>
		<TD class= ' label' align ='right' width ='50%'><fmt:message key="eIP.PrintCertificate.label" bundle="${ip_labels}"/></TD>
		<TD width ='50%'>&nbsp;<INPUT TYPE="checkbox" name="print_certificate" id="print_certificate" size = '10' Maxlength='10'>&nbsp</TD>
	</TR>	
	<TR>
		<TD class= ' label' colspan='2'>&nbsp;</TD>
		
	</TR>	
	<TR>
		<TD class= ' label' colspan='2'>&nbsp;</TD>
		
	</TR>		
</TABLE>
<br>

<TABLE align='center'>
	<TR>
		<TD align ='right' ><INPUT TYPE="button" class="button" name="OK" id="OK" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='apply()'></TD>
		<TD align ='left' ><INPUT TYPE="button" class="button" name="Cancel" id="Cancel" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='window.close()'></TD>
</TR>	
</TABLE>
<%

}catch(Exception e){out.println("err"+e);}
finally
{
 	ConnectionManager.returnConnection(con,request);
}
%>
<input type ='hidden' name ='dischdate' value ="<%=dischdate%>">
	<input type ='hidden' name ='currdate' value ="<%=sdate%>">
	<input type ='hidden' name ='medicalteam' value ="<%=medicalteam%>">
	<input type ='hidden' name ='facilityId' value ="<%=facilityId%>">
</BODY>
</HTML>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

