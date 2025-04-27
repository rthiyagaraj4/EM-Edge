<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eDR/js/MergedPatientIds.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<script language='Javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	/*function validateDate(obj)
	{		
		if(obj.value!='')
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
					alert(getMessage("INVALID_DATE_FMT","SM"));					
					obj.value='';
					obj.focus();
					return false;
			}			
		}		
	}*/
	
	/*function CheckTheDate(Object2) 
	{
		var datefield = Object2;
		if(ChkDate(Object2) == false) 
		{
			//alert("APP-SM0011 - Invalid Date Format");
			alert(getMessage("INVALID_DATE_FMT","SM"));

			if(focusflag == null)
			{
				if(datefield.name == 'p_fm_replace_date')
					document.forms[0].p_fm_replace_date.value = '';
				else if(datefield.name == 'p_to_replace_date')
					document.forms[0].p_to_replace_date.value = '';
		
				datefield.focus();
			}
			return false;
		}
		else
		{
			if(document.forms[0].p_fm_replace_date.value != '' && document.forms[0].p_to_replace_date.value != '')
			{
				if(!doDateCheckAlert(document.forms[0].p_fm_replace_date,document.forms[0].p_to_replace_date))
				{
					alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
					document.forms[0].p_to_replace_date.select();
				}
			}
			return true;
		}
	}*/
</script>

</head>
<body onLoad="search_form.patient_id.focus()" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
	Connection          con     = null;
	java.sql.Statement stmt	    = null;
	ResultSet	        rs		= null;

	String       patient_id     = "";
	String              str     = "";
	int       pat_id_length     = 0;

	//Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
	Boolean isMergeDeceasedPatIdAppl = false;
try
{
	con     =   ConnectionManager.getConnection(request);
	stmt	=   con.createStatement();
	
	isMergeDeceasedPatIdAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"DR","MERGE_DECEASED_PATIENTID");//Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815
	
	patient_id = request.getParameter("patient_id");
	if(patient_id==null || patient_id.equals("null"))patient_id="";
	
	str = "select patient_id_length from mp_param";
	rs = stmt.executeQuery(str);
	
	if(rs!=null)
	{
		while (rs.next())
	    {
		pat_id_length = rs.getInt("patient_id_length");
	    }
	}if(rs!=null)	rs.close();
	 

%>

 <form name='search_form' id='search_form'>
	<table border=0 width=100% cellspacing=0 id='query'>

 	<tr>
			<th class='columnheader' colspan='3' ><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></th>
	</tr>
		
	<tr>
			<td class=label colspan=1 ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields' >
			   <input type='text' size=20 maxlength='<%=pat_id_length%>' name='patient_id' value='<%=patient_id%>' onBlur="ChangeUpperCase(this);" ><input type='button' name='patient_search_button' id='patient_search_button' value='?' class='button' onClick="callPatientSearch()">
			</td>
		    <td class='label' >
			  <!-- <input type=button class=button name='search' id='search' value='Search' onClick="callDuplicatesGroups()"> -->&nbsp;
			</td>
	</tr>
				 
	<tr>
			<td class="label" width='15%' nowrap><fmt:message key="eDR.MergedDate.label" bundle="${dr_labels}"/></td>
			<td class='fields'  >
				<input type=text id='date_from' name='p_fm_replace_date' id='p_fm_replace_date' value='' maxlength=10 size=10 onBlur="validDateObj(this,'DMY',localeName);"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_fm_replace_date.focus();return showCalendar('date_from');">
					-
				<input type=text id="date_to" name='p_to_replace_date' id='p_to_replace_date' value='' maxlength=10 size=10 onBlur="validDateObj(this,'DMY',localeName);"><input type="image"  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_to_replace_date.focus();return showCalendar('date_to');"></td>
			 <td class='button' >
			    <input type=button class=button name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callDuplicatesGroups()">
			</td>
	</tr>
		<!-- <tr>
			<td class='label' colspan='3'>&nbsp;</td>
		</tr>
 -->
 	</table>

	<!--Added by Ashwini on 24-Sep-2024 for ML-MMOH-CRF-1815-->
	<input type='hidden' name='isMergeDeceasedPatIdAppl' id='isMergeDeceasedPatIdAppl' value='<%=isMergeDeceasedPatIdAppl%>'>

</form>
<%
    if(stmt!=null) stmt.close();
	if(rs!=null)	rs.close();
 }
catch(Exception e)
{
	e.printStackTrace();
  //out.println("Exception From The File MergedPatientIDSearch:"+e.toString());
 }
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

