<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,org.json.simple.*" %>
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
<script src="../js/repRegnDistStat.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;
	String p_module_id		= "MP" ;
	String p_report_id		= "" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");
	//Below added by Suji Keerthi for MOHE-CRF-0098 US001
    String region_prompt="";
	Boolean isBasedOnBillGrpAppl = false;
	try
	{

	con=ConnectionManager.getConnection(request);
	JSONObject Json	= eSM.SMCommonBean.getSMSiteParamDetails(con);
	region_prompt = (String) Json.get("region_prompt");
	if(region_prompt==null || region_prompt.equals(""))
		region_prompt="";
	if(region_prompt.equals("")) 
		region_prompt=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.region.label","mp_labels");
	Boolean repBasedOnGovernorate = false;
	repBasedOnGovernorate = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "BASEDON_GOVERNORATE");
	if(repBasedOnGovernorate){
		p_report_id="MPFRSSDT";
	}else{
        p_report_id="MPBARRGS";
		}
	//Ended by Suji Keerthi for MOHE-CRF-0098 US001
	
	isBasedOnBillGrpAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "BASEDON_BILLGROUP");
%>
<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			//var dialogHeight= "28" ;
			//var dialogWidth	= "43" ;
			var dialogHeight= "400px" ;
	        	var dialogTop = "10px" ;
	        	var dialogWidth	= "700px" ;
			
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var repBasedOnGovernorate=""; //Added by Suji Keerthi for MOHE-CRF-0098 US001
			
			//alert(obj.name)
			//Below modified by Suji Keerthi for MOHE-CRF-0098 US001
			if(obj.name=="area")
			{
                repBasedOnGovernorate = repRegnDistStat.repBasedOnGovernorate.value;
				if(repBasedOnGovernorate=="true"){
				    tit=repRegnDistStat.p_reg_prompt.value;
				}else{
				    tit=getLabel('Common.State.label','common');
				}
				sql="select region_code, short_desc from mp_region_lang_vw where language_id=`"+localeName+"`";
				search_code="region_code";
				search_desc= "short_desc"
			}
			//Ended by Suji Keerthi for MOHE-CRF-0098 US001
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
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
</script>
<center>
	<form name="repRegnDistStat" id="repRegnDistStat" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR>
		<table cellspacing='0' cellpadding='3' width='60%'>

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
        <!--Below added by Suji Keerthi for MOHE-CRF-0098 US001-->
		<%if(repBasedOnGovernorate){%>
		<tr>
			<td class="label" nowrap><fmt:message key="Common.Basedon.label" bundle="${common_labels}"/>&nbsp;</td>
			
			<td class="fields"><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Address.label" bundle="${common_labels}"/> <input type='radio' align='left' id='p_facility' name='p_fac_pat_add' id='p_fac_pat_add' value = 'F' checked onClick="basedonoption(this);"></td>

			<td >&nbsp;</td>
			
            <td class="fields"><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Address.label" bundle="${common_labels}"/> <input type='radio' align='left' id='p_patient' name='p_fac_pat_add' id='p_fac_pat_add' value = 'P'  onClick="basedonoption(this);"></td>
        </tr>
		<%}%>
        <!--Ended by Suji Keerthi for MOHE-CRF-0098 US001-->
		  <tr>
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
			<td >&nbsp;</td>
			<td class="querydata" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		  </tr>
		  <%if(isBasedOnBillGrpAppl){%>
			<tr>
					<td class="label" ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
						<td class='fields'><select name="p_billing_group" id="p_billing_group">
			 <option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			 <option value="C"><fmt:message key="Common.Cash.label" bundle="${common_labels}"/></option>
			 <option value="I"><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/></option>
			</select>
						</td>
					</tr>
			<%}%>
		  	<tr>
				<td class="label"><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" id='regnagenatstatfrom' name="p_fm_regndate" id="p_fm_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatfrom');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" id='regnagenatstatto' name="p_to_regndate" id="p_to_regndate" size="10" maxlength="10" onBlur="validDateObj(this,'DMY',localeName)"><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatto');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
			    <%if(repBasedOnGovernorate){%>
			    <td class="label"><%= region_prompt %></td> <!--MOdified by Suji Keerthi for MOHE-CRF-0098 US001-->
				<%}else{%>
			    <td class="label"><fmt:message key="eMP.StateCode.label" bundle="${mp_labels}"/> </td>
				<%}%>
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
		<!--Below added by Suji Keerthi for MOHE-CRF-0098 US001-->
		<input type="hidden" name="p_reg_prompt" id="p_reg_prompt"	value="<%= region_prompt %>"> 
		<input type="hidden" name="repBasedOnGovernorate" id="repBasedOnGovernorate"	value="<%= repBasedOnGovernorate %>"> 
		<!--Ended by Suji Keerthi for MOHE-CRF-0098 US001-->
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
<!--Below added by Suji Keerthi for MOHE-CRF-0098 US001-->
<%
}catch(Exception e){out.println(e);}
finally { 
	ConnectionManager.returnConnection(con,request);
}
%>
<!--Ended by Suji Keerthi for MOHE-CRF-0098 US001-->

