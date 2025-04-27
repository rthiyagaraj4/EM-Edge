<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBUNABD" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	StringBuffer sql = new StringBuffer();
	String isSpltyNurUnitToEnableYNAppl="";
	try
	{
		con = ConnectionManager.getConnection(request);
%>
<% Boolean isUnBedPatSearchAppl =eCommon.Common.CommonBean.isSiteSpecific(con, "IP","AD_UN_BD_REP_SER_CRT");  //Added by Shanmukh on 24-APR-2018 for ML-MMOH-CRF-1054 
isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115  %>
<html>	
<HEAD>
<TITLE></TITLE>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
<!--Modified by Shanmukh on 24th-Apr-2018 for ML-MMOH-CRF-1054 Start-->
function chkDateOf(Obj) { 
	if(Obj.value != '') {
		if(!validDateObj(Obj,"DMY",localeName)) {	
		    Obj.value = "";
			Obj.select();
			return false;			
		 } else if (isBeforeNow(Obj.value,"DMY",localeName) == false) {
			var err1 = getMessage("DATE_NOT_GREATER_SYSDATE","Common");			
			alert(err1);
			Obj.value = "";
			Obj.focus();
			return false;
		 }
		   var isUnBedPatSearchAppl=document.forms[0].isUnBedPatSearchAppl.value;
		  if(isUnBedPatSearchAppl=='true'){
			 var p_fm_admn_date=document.forms[0].p_fm_admn_date.value;
			 var p_to_admn_date=document.forms[0].p_to_admn_date.value;
			 if(Obj.name=='p_fm_admn_date'){
			  if(p_fm_admn_date !='' && p_to_admn_date !=''){
				if((!isBefore(p_fm_admn_date,p_to_admn_date,'DMY',localeName))) {
					alert(getMessage("FRDT_LTEQ_TODT","IP"));
					Obj.value=""; 
					Obj.select();
			    }
			}
		   }else{
		    if(document.forms[0].p_fm_admn_date.value !=''){
			   if((!isBefore(p_fm_admn_date,p_to_admn_date,'DMY',localeName))) {
				alert(getMessage("TO_DT_GR_EQ_FM_DT",'SM'));
				Obj.value="";
				Obj.select();
			    }
		   }
	  }
   
	}
	}	
}


async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var locale= "<%=locale%>"
			/* var dialogHeight= "28" ;
			var dialogWidth	= "43" ; */
			var dialogTop = "10px" ;
			var dialogHeight= "400px" ;
			var dialogWidth="900px";
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
                  
		if(obj.name=="speciality")
		{
				tit=getLabel('Common.speciality.label','common');
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
				search_code="speciality_code";
				search_desc= "short_desc";
		}else if(obj.name=="nursing_unit_code"){
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%= p_facility_id%>` ";
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
		}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

	function dateVal( obj )
	{
		if(obj.value !="")
		{
			if(!doDateTimeChk(obj))
			{
				obj.focus()
				alert( parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM") )
			}
		}
	}
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2UnassignedPatientsForm" id="Rep2UnassignedPatientsForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
	</tr>								
				<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursing_unit"/>
				<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
				</jsp:include>
				<%}else{%>
						<td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='20%'  >
							<input type=text  name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
						</td>
						<td width='40%'> 
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
						</td>
				<%}%>		
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>	

<tr>
<%
String sysdat	= "";
String sysdat_converted	= "";
sql.append("select to_char(sysdate,'dd/mm/rrrr') sys from dual");
stmt = con.createStatement();
rs = stmt.executeQuery(sql.toString());
	if(rs!=null)
		{
			if(rs.next())
			sysdat = rs.getString("sys");
		}
if(!(sysdat==null || sysdat.equals("")))
						sysdat_converted = DateUtils.convertDate(sysdat,"DMY","en",locale); 	
%>
<td align='left' width='30%' class="label"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td width='20%'><input align='left' type='text'  id='apptstatdate' name='p_fm_admn_date' id='p_fm_admn_date' size='10' maxlength='10'  value='' onBlur='chkDateOf(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptstatdate');"><img src='../../eCommon/images/mandatory.gif'></img></td>
</td> 
<!--Added by Shanmukh on 24th-Apr-2018 for ML-MMOH-CRF-1054 Start-->

<%if(isUnBedPatSearchAppl){%>
<td width='20%'><input align='left' type='text'  id='apptstatdate1' name='p_to_admn_date' id='p_to_admn_date' size='10' maxlength='10'  value='' onBlur='chkDateOf(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('apptstatdate1');"><img src='../../eCommon/images/mandatory.gif'></img></td>
</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr> 
<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
<jsp:include page="CommonSpecialityLookup.jsp">
<jsp:param name="speciality_code_Appl" value="p_spcialty_code"/>
</jsp:include>
<%}else{%>
	<td  class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type=text name='p_spcialty_code' id='p_spcialty_code'  size=15 maxlength='15' ><input type='button' name='speciality' id='speciality' value='?' class='button' onclick='searchCode(this, p_spcialty_code )'>
<%}%>	
</tr>
<%}%>

<!--End-->
</table>
	</td>
</tr>
</table>
	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	    value="<%= p_user_name %>">
	<input type="hidden" name="isUnBedPatSearchAppl" id="isUnBedPatSearchAppl"  value="<%= isUnBedPatSearchAppl %>"> 

</form>
<script>

if(document.forms[0].isUnBedPatSearchAppl.value=='false') document.forms[0].p_fm_admn_date.value='<%=sysdat_converted%>'
</script>
<%
	}
	catch (Exception e)
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		try
		{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{/* out.println("Exception in tryCatch : "+ e.toString()); */ e.printStackTrace();}
		ConnectionManager.returnConnection(con,request);
	}
%>
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
%>

