<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>

<HEAD>
	<%	
	    request.setCharacterEncoding("UTF-8");
		String called_from = checkForNull(request.getParameter("called_from"));
		String locale	= (String)session.getAttribute("LOCALE");
		String facilityID		= (String)session.getValue("facility_id");
		String selec_val="";
		String informed_to=checkForNull(request.getParameter("informed_to"));
		String ip_Trn_Date="";
		String system_date_time_trn="";
		
		selec_val				= "";
		String informed_name=checkForNull(request.getParameter("informed_name"));
		String informed_date_time=checkForNull(request.getParameter("informed_date_time"));
		String admissiondatetime=checkForNull(request.getParameter("admissiondatetime"));
		String system_date_time=checkForNull(request.getParameter("system_date_time"));
		String encounterID=checkForNull(request.getParameter("encounterID"));
		
		String informed_date_time_display = "";
		if(informed_date_time == "" || informed_date_time.equals("null"))
			informed_date_time_display = "";
		else
			informed_date_time_display = DateUtils.convertDate(informed_date_time,"DMYHM","en",locale);
		//String chkDisable = "";
		Connection con			=	null;
		Statement stmt			=	null;
		ResultSet rs			=	null;

		StringBuffer sqlSB = new StringBuffer();
			try
		{
				con = ConnectionManager.getConnection(request);
				stmt=con.createStatement();

				if (sqlSB.length() > 0)	sqlSB.delete(0, sqlSB.length());
				sqlSB.append(" SELECT to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(MAX(trn_date_time),'dd/mm/rrrr hh24:mi') ip_trn_date FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ");
				rs		= stmt.executeQuery(sqlSB.toString());

				if ((rs != null) && (rs.next()))
				{
					ip_Trn_Date		= rs.getString("ip_Trn_Date");
					system_date_time_trn= rs.getString("system_date_time");
				}
				if (rs!=null) rs.close();
				if(stmt	!=	null) stmt.close();
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}


	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	
	
    
<script>

function ChkNumberInput1(fld, e, deci)
{
  if (parseInt(deci)>0)
     var strCheck = '.0123456789 /:';
  else
     var strCheck = '0123456789 /:';

     var whichCode = (window.Event) ? e.which : e.keyCode;
      if (whichCode == 13) return true;  // Enter
  	key = String.fromCharCode(whichCode);  // Get key value from key code
      if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function disablefield()
{
	document.getElementById("im").style.visibility	=	'hidden';
	document.getElementById("Ttype").style.visibility	=	'hidden';
}

/*  17956 Thursday, January 07, 2010 */
function datefun(obj)
{
	if(obj.value != "")
	{
		var flag = validDateObj(obj,"DMYHM",localeName);	
		if(!flag)
		{		
			if(obj.name == 'informed_date')
			{	
				document.getElementById('informed_date').value = "";
				//document.getElementById('informed_date').focus();
			}
			else if(obj.name == 'absconding_date')
			{
				document.getElementById('absconding_date').value="";
				//document.getElementById('absconding_date').focus();
			}
		}
		else
		{
				var greg_informedDate = convertDate(obj.value,"DMYHM",localeName,"en");	
				//if(greg_date!=""&& document.getElementById("infm_dtls_sysdate").value!="")
				if(greg_informedDate!="")
				{

					//if(isAfter(greg_date,document.getElementById("infm_dtls_sysdate").value,'DMYHM',localeName))
					//if(!isBeforeNow(greg_informedDate,'DMYHM','en'))
				//	if(!isBefore(greg_informedDate,document.getElementById("infm_dtls_sysdate").value,'DMYHM','en'))
					if(!isBeforeNow(greg_informedDate,'DMYHM','en'))
					{
			
						var error = getMessage("DATE1_GT_DATE2","IP");
						var object_name = obj.name;

						if(obj.name == "informed_date")					
							error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"))					
						else
							error = error.replace('$',getLabel("eIP.AbscondingDateTime.label","IP"))	
						
						error = error.replace('#',getLabel("Common.SystemDateTime.label","Common"))
						alert(error);
						obj.value = ''; 
						obj.focus();
						return false; 
					}
				}
				else if((greg_informedDate!="") && (document.getElementById('fromdate').value!=""))
				{
					if(isAfter(document.getElementById("infm_dtls_sysdate").value,greg_informedDate,'DMYHM','en'))
					{
					
						var error = getMessage("DATE1_LT_DATE2","IP"); 
						error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));
						if(document.getElementById('record_status').value=="02")
							error = error.replace('#',getLabel("eIP.AbscondingDateTime.label","IP"))
						else
							error = error.replace("#",getLabel("eIP.leavedatetime.label","IP"));
						alert(error);
						obj.value = "";
						obj.focus();
						return false; 
					}
				}
			if( "<%=admissiondatetime%>" != "" && greg_informedDate != null && greg_informedDate != "" )
			{
				
				var greg_admission_date_time;
				/*if(document.forms[0].admissiondatetime!=null)
					greg_admission_date_time = document.forms[0].admissiondatetime.value;
				else*/
					greg_admission_date_time = "<%=admissiondatetime%>";

				var greg_maxtfrDateTime = '<%=ip_Trn_Date%>';
				if(!isBefore(greg_admission_date_time,greg_informedDate,'DMYHM','en'))		
				{
					/*  17956 Thursday, January 07, 2010 */
					var error = getMessage('DATE1_LT_DATE2','IP');
					// added by mujafar for ML-MMOH-CRF-0659 start
					/*error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));*/ 
					
					if(obj.name == "informed_date")					
							error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));				
						else
							error = error.replace('$',getLabel("eIP.AbscondingDateTime.label","IP"));	
						
						// added by mujafar for ML-MMOH-CRF-0659 end
						
					error = error.replace('#',getLabel("Common.AdmissionDateTime.label","Common"));
					alert(error);
					obj.select();
					obj.focus;
					return false;
				}
				else if(!isBefore(greg_maxtfrDateTime,greg_informedDate,'DMYHM','en'))
				{
				/*  17956 Thursday, January 07, 2010 */
					var error = getMessage('DATE1_LT_DATE2','IP');
					var last_encounter = getLabel("eIP.LastTransactionDateTime.label",'IP');
					if(obj.name == "informed_date")	
						error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));
					else
						error = error.replace('$',getLabel("eIP.AbscondingDateTime.label",'IP'));
					error = error.replace('#',last_encounter);
					alert(error);
					obj.value = "";
					return false;
				}
				
			}
		}		
	}
	if(obj.name == 'absconding_date')
	{
		document.getElementById('absconding_rep_to').focus();	
	}
	else 
	{
		if('<%=called_from%>' == 'Discharge_Advice')/*4/21/2009 added condition for IN010016*/
		{
			if(document.forms[0].absconding_yn)
			{
				if(!document.forms[0].absconding_yn.checked)
				{
					document.forms[0].auth_pract_desc.focus();	
					
				}
				else
				{ 
					if(document.getElementById('ab_details').visibility == "visible")
					document.forms[0].absconding_yn.focus();
				}
			}
			else if(document.forms[0].Absconding_yn)
			{
				if(!document.forms[0].Absconding_yn.checked)
				{
					document.forms[0].auth_pract_desc.focus();
				}
				else
				{  
					document.forms[0].Absconding_yn.focus();
				}
			}
		}
		
	}
}




</script>
</HEAD>


<BODY onload='disablefield()' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<table border='0' cellpadding='2' cellspacing='0' width='100%' >
<tr >
	<td width='25%'></td>
	<td width='30%'></td>
	<td width='20%'></td>
	<td width='25%'></td>
</tr>
<tr>
	<td class='label' nowrap <%if(called_from.equals("record_leave")){%>width='' <%}else{%>width='' <%}%>><fmt:message key="eIP.InformedTo.label" bundle="${ip_labels}"/></td>
	<td nowrap class='fields' <%if(called_from.equals("record_leave")){ %>width='' <% }else{%>width='' <%}%> colspan=3><SELECT name='inform_to' id='inform_to' <%if(called_from.equals("dischage_patient")){%> onChange="enableInformName_disch()"  <%}else{%>onChange="enableInformName()" <%}%> <%if(called_from.equals("Discharge_Advice")){%>onblur="dis_adv_focus(this);"<%}%> tabindex = '14' >
			<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<%
				if (informed_to.equals("01")) selec_val = "Selected";
				else selec_val = "";	
		    %>
			<option value="01" <%=selec_val%> ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></option>
			<%
				if (informed_to.equals("02")) selec_val = "Selected";
				else selec_val = "";	
		    %>
			<option value="02"  <%=selec_val%> ><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></option>
			<%
				if (informed_to.equals("03")) selec_val = "Selected";
				else selec_val = "";	
		    %>
			<option value="03"  <%=selec_val%> ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		</SELECT>
	<img id="Ttype" src='../../eCommon/images/mandatory.gif' style="visibility:hidden" ></td>	
		</tr>

<tr>
	<td width='20%' nowrap class='label'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	<td nowrap class='fields' <%if(called_from.equals("record_leave")){%>width='' <%}else{%>width='' <%}%>><input type='text' name='informed_name' id='informed_name'  value="<%=informed_name%>" size='20' maxlength='200' disabled tabindex = '15'></td><!-- 17956 Thursday, January 07, 2010 -->
	<td width='20%' class='label'><fmt:message key="Common.InformedDate/Time.label" bundle="${common_labels}"/></td>
	<td width='20%' class='fields' >
		<input type='text' name='informed_date' id='informed_date'  value="<%=informed_date_time_display%>" disabled   onKeyPress='return(ChkNumberInput1(this,event,2));' size='15' maxlength='16' onblur="datefun(this);" tabindex='16'>
		<!-- <img  name="infocalimg" id="infocalimg"  src="../../eCommon/images/CommonCalendar.gif" onclick="document.forms[0].informed_date.focus();return showCalendar('informed_date',null,'hh:mm');" style="pointer-events: none;" tabindex = '17'/><img id="im" src='../../eCommon/images/mandatory.gif' style="visibility: hidden"> -->
				<img src="../../eCommon/images/CommonCalendar.gif" onclick="document.forms[0].informed_date.select(); if(! document.forms[0].informed_date.disabled){return showCalendar('informed_date',null,'hh:mm');}" tabindex="-1" name='infocalimg' id='infocalimg'> <img id="im" src='../../eCommon/images/mandatory.gif' style="visibility: hidden">
		</td>
</tr>
</table>

<input type='hidden' name='infm_dtls_sysdate' id='infm_dtls_sysdate' value="<%=system_date_time%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >


</BODY>
</script>

</script>

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

