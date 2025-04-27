<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	request.setCharacterEncoding("UTF-8");
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/common.js"></script>
<script src="../js/repRegnDistStat_SRR.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBARRGS" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");
	String locale				  = (String)session.getValue("LOCALE");
%>
<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			
			if(obj.name=="area")
			{
				tit=getLabel('eMP.Province.label','MP');
				sql="select region_code, short_desc from mp_region_lang_vw where language_id=`"+localeName+"`";
				search_code="region_code";
				search_desc= "short_desc"
			}
			if(obj.name=="dist")
			{
				tit=getLabel('eMP.District.label','MP');
				sql="select RES_AREA_CODE, long_desc short_desc from mp_res_area_lang_vw where language_id=`"+localeName+"`";
				search_code="RES_AREA_CODE";
				search_desc= "short_desc"
			}
			if(obj.name=="town")
			{
				tit=getLabel('Common.Town.label','common');
				sql="select RES_TOWN_CODE, long_desc from mp_res_town_lang_vw where language_id=`"+localeName+"`";
				search_code="RES_TOWN_CODE";
				search_desc= "short_desc"
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

function setDate(Object){ 

       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
	}
</script>
<center>
	<form name="repRegnDistStat" id="repRegnDistStat" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR>
		<table cellspacing='0' cellpadding='3' width='70%'>

		<tr>
			<td width='25%'>&nbsp;</td>
				<td width='25%'>&nbsp;</td>
				<td width='15%'>&nbsp;</td>
				<td width='35%'>&nbsp;</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='facilityid' id='facilityid'>
				<%	try
				{
					
					String fid;
					String fname;
					con = ConnectionManager.getConnection(request);
					String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  1";					
					pstmt=con.prepareStatement(sql1);

					rset=pstmt.executeQuery(sql1);
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
				}catch(Exception e)
				{
					
				}
				finally { 
					try
					{
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null) ConnectionManager.returnConnection(con,request);					
					}
					catch(Exception e)
					{
					
					}
					}

				%>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		  <tr>
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		  </tr>
			<tr>
				<td class="label"><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" id='regnagenatstatfrom' name="p_fm_regndate" id="p_fm_regndate" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatfrom');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" id='regnagenatstatto' name="p_to_regndate" id="p_to_regndate" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatto');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<!-- <td class="label"><fmt:message key="eMP.StateCode.label" bundle="${mp_labels}"/> </td> -->
				<td class="label"><fmt:message key="eMP.Province.label" bundle="${mp_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="P_fm_region_code" id="P_fm_region_code" size="6" maxlength="6"><input type='button' name='area' id='area' value='?' class='button' onclick='searchCode(this, P_fm_region_code)'>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" name="P_to_region_code" id="P_to_region_code" size="6" maxlength="6"><input type='button' name='area' id='area' value='?' class='button' onclick='searchCode(this, P_to_region_code)'>
				</td>
			</tr>
            <tr>
				<td class="label"><fmt:message key="eMP.DistrictCode.label" bundle="${mp_labels}"/></td>
				<td class='fields'><input type="text" name="P_fm_area_code" id="P_fm_area_code" size="6" maxlength="6"><input type='button' name='dist' id='dist' value='?' class='button' onclick='searchCode(this, P_fm_area_code)'>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" name="P_to_area_code" id="P_to_area_code" size="6" maxlength="6"><input type='button' name='dist' id='dist' value='?' class='button' onclick='searchCode(this, P_to_area_code)'>
				</td>
			</tr>
		<tr>
				<td class="label"><fmt:message key="Common.TownCode.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="P_fm_town_code" id="P_fm_town_code" size="6" maxlength="6"><input type='button' name='town' id='town' value='?' class='button' onclick='searchCode(this, P_fm_town_code)'>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" name="P_to_town_code" id="P_to_town_code" size="6" maxlength="6"><input type='button' name='town' id='town' value='?' class='button' onclick='searchCode(this, P_to_town_code)'>
				</td>
			</tr>
			<tr>
					<td class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name='p_order_by' id='p_order_by'>
						<option value='Province'><fmt:message key="eMP.Province.label" bundle="${mp_labels}"/>
						<option value='District'><fmt:message key="eMP.District.label" bundle="${mp_labels}"/>
						<option value='Town'><fmt:message key="Common.Town.label" bundle="${common_labels}"/>
						</select>
					</td>
			</tr>
		
		
		<tr>
		    			<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
		</tr>
		</table>
		<br>
		<input type="hidden" name="p_facility_id" id="p_facility_id"			value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 			value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"				value="<%= p_resp_id %>">
		<input type="hidden" name="locale" id="locale"		value="<%=locale%>">
		<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
	</form>
</center>



<script src="../../eCommon/js/common.js"></script>


<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

