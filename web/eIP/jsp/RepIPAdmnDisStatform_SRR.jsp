<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/DateUtils.js"></script>

<%
	request.setCharacterEncoding("UTF-8"); 
	Connection				con		=	null;
	PreparedStatement		pstmt	=	null ;
	ResultSet				rset	=	null ;
	Statement				stmt	=	null ;

	String p_module_id		= "IP" ;
	String p_report_id		= "IPBADDST" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");

	StringBuffer NationalityVal	= new StringBuffer();
%>
<script>
async function searchCode(obj,target){
	var retVal = 	new String();
			var locale= "<%=locale%>"
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			if(obj.name=="nursing")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code,short_desc from ip_nursing_unit ";
				sql="select nursing_unit_code,short_desc from ip_nursing_unit_lang_vw where language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}
			else if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code,short_desc from am_speciality ";
				sql="select speciality_code,short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
				search_code="speciality_code";
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
function chkWithSysDt(obj){
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
}
</script>
<html>
<center>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name="RepIPAdmnDisStatform" id="RepIPAdmnDisStatform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR>
<table width='80%' align='center' valign='top'>
<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
		<table width='100%' cellPadding="0" cellSpacing="0" align='center'  >
	<tr>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>	
	<!-- To Populate Facility List -->
	<tr>
		<td align="right" class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
		<td colspan ="3"> 
				<select name='p_for_facility_id' id='p_for_facility_id'>
			<%
				try
				{
					con		=	ConnectionManager.getConnection(request);
				stmt=con.createStatement();
				String fid;
				String fname;
				//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";		
				
				String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");

				String sql1 = "select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'  and p.language_id='"+locale+"'  and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";					

				rset=stmt.executeQuery(sql1);
				if(rset!=null)
				{
				   while(rset.next())
				   {
					fid=rset.getString("facility_id");
					fname=rset.getString("facility_name");
					if(fid.equals("All"))
					out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
					else
					out.println("<option value='"+fid+ "' >"+fname+"</option>");
				   }
				}
				if(rset!=null)rset.close();
				if(stmt!=null)stmt.close();

				//pstmt = con.prepareStatement("Select country_code, short_name from MP_COUNTRY Where Eff_status = 'E' Order by 2");
				pstmt = con.prepareStatement("Select country_code, LONG_NAME short_name from MP_COUNTRY_LANG_VW Where Eff_status = 'E' and language_id='"+locale+"' Order by 2");
				rset = pstmt.executeQuery();
				if(rset!=null)
				{
				   while(rset.next())
				   {
						NationalityVal.append(" <option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option> ");
				   }
				}
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
				

				}catch(Exception e)
				{
					out.println(e);
				}
				finally 
				{ 
					ConnectionManager.returnConnection(con,request);
				}
			%>	
			</select>
		</td>
	</tr>
	<tr>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>
	<tr>		
		<td align="right" class="label" > <fmt:message key="Common.nationality.label" bundle="${common_labels}"/> &nbsp;</td>
		<td colspan ="3"> 
				<select name='p_nationality' id='p_nationality'>
				<option value="">---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
				<%=NationalityVal.toString()%>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>		
	</tr>
	<tr>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>
	<tr>
		<td >&nbsp;</td>
		<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class="querydata" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td  width='40%' class="label" align='right' nowrap><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  width='20%' align='left'>
		       <input type=text id="p_date_from" name='p_fr_date' id='p_fr_date' size="10" maxlength="10" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){chkWithSysDt(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_from');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>
		<td  width='40%' align='left'>
		       <input type=text id="p_date_to"  name='p_to_date' id='p_to_date' size="10" maxlength="10" onblur='if(validDateObj(this,"DMY","<%=localeName%>")){chkWithSysDt(this);}'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_to');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>
	</tr>
	<tr>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>
	<tr>
		<td align='right' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
		<td width='40%'>
			<input type=text   name='P_NURSING_UNIT' id='P_NURSING_UNIT' size="6" maxlength="6" align="center"><input type='button' name='nursing' id='nursing' value='?' class='button' onclick='searchCode(this, P_NURSING_UNIT)'>
		</td>
		</tr>
		<tr>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
	</tr>
	<tr>
		<td align='right' width='30%' class="label"><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/> &nbsp;</td>
		<td width='40%'>
			<input type=text  name='P_SPECIALTY' id='P_SPECIALTY' size="6" maxlength="6" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this,P_SPECIALTY)'>
		</td>
	</tr>
</table>
</td>
</tr>
</table>
	<br>
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">

		<%if(localeName.equals("en"))
		{%>
		<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
		<%}
		else if(localeName.equals("th"))
		{%>
		<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
		<%}%>
			
</form>
</body>
</center>
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

