<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBMCSNN" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String BL_installed = (String)session.getValue("mp_bl_oper_yn");
	Connection con			= null;
%>

<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js" language='JavaScript'></script>	
	<script src="../../eCommon/js/common.js" language='JavaScript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language='JavaScript'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language='JavaScript'></script>
	<script src="../../eCommon/js/DateUtils.js" language='JavaScript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	async function searchCode(obj,target)
		{
				var retVal = 	new String();
				var dialogHeight= "400px" ;
				var dialogWidth="900px";
				/* var dialogHeight= "28" ;
				var dialogWidth	= "43" ; */
				var status = "no";
				var arguments	= "" ;
				var sql="";
				var search_code="";
				var search_desc="";
				var tit="";
				var locale= "<%=locale%>";
				var facilityid = document.forms[0].p_facility_id.value;
				var argumentArray  = new Array();
				var dataNameArray  = new Array();
				var dataValueArray = new Array();
				var dataTypeArray  = new Array();
	
				if(obj.name=="nursing_unit") 
				{
					tit=getLabel('Common.nursingUnit.label','common');
					argumentArray[0]="select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and facility_id like ? and upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";
					argumentArray[1]=new Array("facility_id");
					argumentArray[2]=new Array(facilityid);
					argumentArray[3]=new Array(STRING);
					argumentArray[4]="2,3";
					argumentArray[5]=target.value;
					argumentArray[6]=CODE_LINK;
					argumentArray[7]=CODE_DESC;

				}else if(obj.name=="billing_group"){
					tit=getLabel('Common.BillingGroup.label','common');
					argumentArray[0]="select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where  language_id='"+locale+"' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?)";
					argumentArray[1] = dataNameArray ;
					argumentArray[2] = dataValueArray ;
					argumentArray[3] = dataTypeArray ;
					argumentArray[4] = "1,2";
					argumentArray[5] = target.value;
					argumentArray[6] = CODE_LINK;
					argumentArray[7] = CODE_DESC;
				}else if(obj.name=="cust_grp_code"){
					tit=getLabel('Common.Customer.label','common'+''+'Common.GroupCode.label','common');
					argumentArray[0]="select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (cust_group_code) like upper(nvl(?,cust_group_code)) and upper(short_desc) like upper(nvl(?,short_desc)) ";
					argumentArray[1] = dataNameArray ;
					argumentArray[2] = dataValueArray ;
					argumentArray[3] = dataTypeArray ;
					argumentArray[4] = "1,2";
					argumentArray[5] = target.value;
					argumentArray[6] = CODE_LINK;
					argumentArray[7] = CODE_DESC;

				}else if(obj.name=="cust_code"){
					tit=getLabel('Common.CustomerCode.label','common');
					var group_id	= "";
					if(target.name=="P_FRM_CUST_CODE"){
						group_id	= document.forms[0].P_FRM_CUST_GROUP_CODE.value;
					}else{
						group_id	= document.forms[0].P_TO_CUST_GROUP_CODE.value;
					}
					if(group_id==""){
						argumentArray[0]="select cust_code code, long_name description from ar_customer_lang_vw where '1' like ? and language_id='"+locale+"' and upper(cust_code) like upper(nvl(?,cust_code)) and upper(long_name) like upper(nvl(?,long_name)) order by 2 ";
					}else{
						argumentArray[0]="select code,description from (SELECT a.cust_code code, a.long_name description FROM ar_customer_lang_vw a,ar_cust_group_lang_vw b, bl_cust_by_cust_group d  WHERE a.acc_entity_code =  b.acc_entity_code AND b.acc_entity_code =d.acc_entity_code AND a.language_id = b.language_id AND b.cust_group_code = d.cust_group_code AND a.cust_group_code = b.cust_group_code AND a.cust_code = d.cust_code AND b.cust_group_code = '"+group_id+"' AND a.language_id = '"+locale+"' AND a.acc_entity_code IN (SELECT d.acc_entity_code FROM sy_acc_entity d  WHERE acc_entity_id = d.acc_entity_id) ) where 1 like ? and UPPER (code) LIKE UPPER (NVL (?, code)) AND UPPER (description) LIKE UPPER (NVL (?, description)) ORDER BY 2"; 
					}	
					argumentArray[1]=new Array("1");
					argumentArray[2]=new Array("1");
					argumentArray[3]=new Array(STRING);
					argumentArray[4]="2,3";
					argumentArray[5]=target.value;
					argumentArray[6]=CODE_DESC_LINK;
					argumentArray[7]=CODE_DESC; 
				}

				retVal = await CommonLookup( tit, argumentArray ) ;

				if(retVal != null && retVal != "" )
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[0];
				}
				else
				{
					target.value='';
				}
		}
	</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<%
	String isSpltyNurUnitToEnableYNAppl="";
	try{
		con =ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
		Boolean isBillingFilterAvailable	= CommonBean.isSiteSpecific(con, "IP","REP_BILLING_GRP_FILTER"); 

%>
		<form name="Rep2MonthlyIPSummaryNursingUnitForm" id="Rep2MonthlyIPSummaryNursingUnitForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

			
						<tr>
							<td width='30%' class="label"><fmt:message key="eIP.CensusMonthYear.label" bundle="${ip_labels}"/>&nbsp;</td>
							<td class="fields" width='25%'  >
								<input type=text id="census_date"  name='p_trn_date' id='p_trn_date' size="7" maxlength="7" align="center" onblur='validDateObj(this,"MY",localeName);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('census_date','mm/y',null);">
								<img align='center' src='../../eMP/images/mandatory.gif'>
							</td>
							<td colspan ='2'>
						</tr>
						<tr>
							<td class="label">&nbsp;</td>
							<Td class="label">&nbsp;</td>
						</tr>
						<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
						<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
							<tr>
							<jsp:include page="CommonNursingUnitLookup.jsp">
							<jsp:param name="nursing_unit_code_Appl" value="p_fr_nursing_unit"/>
							<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
							</jsp:include>
							</tr>
						<%}else{%>
						<tr>
							<td align="center" width="35%">&nbsp;</td>
							<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
							<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						</tr>				
						<tr>
								<td  width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/>&nbsp;</td>
								<td class="fields" width='20%'  >
									<input type=text  name='p_fr_nursing_unit' id='p_fr_nursing_unit' size="4" maxlength="4" align="center"/><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, p_fr_nursing_unit)'>
								</td>
								<td class="fields" width='40%'>
									<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
								</td>
					</tr><%}%>


						<tr>
							<td class="label">&nbsp;</td>
							<Td class="label">&nbsp;</td>
						</tr>
						<%if(BL_installed.equals("Y") && isBillingFilterAvailable){%>
						<tr>
								<td  width='30%' class="label"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>&nbsp;</td>
								<td class="fields" width='20%'  >
									<input type=text  name='P_FRM_BLNG_GRP_ID' id='P_FRM_BLNG_GRP_ID' size="4" maxlength="4" align="center"><input type='button' name='billing_group' id='billing_group' value='?' class='button' onclick='searchCode(this, P_FRM_BLNG_GRP_ID)'>
								</td>
								<td class="fields" width='40%'>
									<input type=text  name='P_TO_BLNG_GRP_ID' id='P_TO_BLNG_GRP_ID' size="4" maxlength="4" align="center"><input type='button' name='billing_group' id='billing_group' value='?' class='button' onclick='searchCode(this,  P_TO_BLNG_GRP_ID)'>
								</td>
						</tr>
						<tr>
							<td class="label">&nbsp;</td>
							<Td class="label">&nbsp;</td>
						</tr>
						<tr>
								<td  width='30%' class="label"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
								<td class="fields" width='20%'  >
									<input type=text  name='P_FRM_CUST_GROUP_CODE' id='P_FRM_CUST_GROUP_CODE' size="2" maxlength="2" align="center"><input type='button' name='cust_grp_code' id='cust_grp_code' value='?' class='button' onclick='searchCode(this, P_FRM_CUST_GROUP_CODE)'>
								</td>
								<td class="fields" width='40%'>
									<input type=text  name='P_TO_CUST_GROUP_CODE' id='P_TO_CUST_GROUP_CODE' size="2" maxlength="2" align="center"><input type='button' name='cust_grp_code' id='cust_grp_code' value='?' class='button' onclick='searchCode(this, P_TO_CUST_GROUP_CODE)'>
								</td>
						</tr>
						<tr>
							<td class="label">&nbsp;</td>
							<Td class="label">&nbsp;</td>
						</tr>
						<tr>
								<td  width='30%' class="label"><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/>&nbsp;</td>
								<td class="fields" width='20%'  >
									<input type=text  name='P_FRM_CUST_CODE' id='P_FRM_CUST_CODE' size="8" maxlength="8" align="center"><input type='button' name='cust_code' id='cust_code' value='?' class='button' onclick='searchCode(this, P_FRM_CUST_CODE)'>
								</td>
								<td class="fields" width='40%'>
									<input type=text  name='P_TO_CUST_CODE' id='P_TO_CUST_CODE' size="8" maxlength="8" align="center"><input type='button' name='cust_code' id='cust_code' value='?' class='button' onclick='searchCode(this, P_TO_CUST_CODE)'>
								</td>
						</tr>

						
						<tr>
							<td class="label">&nbsp;</td>
							<Td class="label">&nbsp;</td>
						</tr>
						<%}else{%>
							<input type='hidden' name="P_FRM_BLNG_GRP_ID" id="P_FRM_BLNG_GRP_ID" value="" />
							<input type='hidden' name="P_TO_BLNG_GRP_ID" id="P_TO_BLNG_GRP_ID" value="" />
							<input type='hidden' name="P_FRM_CUST_GROUP_CODE" id="P_FRM_CUST_GROUP_CODE" value="" />
							<input type='hidden' name="P_TO_CUST_GROUP_CODE" id="P_TO_CUST_GROUP_CODE" value="" />
							<input type='hidden' name="P_FRM_CUST_CODE" id="P_FRM_CUST_CODE" value="" />
							<input type='hidden' name="P_TO_CUST_CODE" id="P_TO_CUST_CODE" value="" />
						<%}%>
						
				</table>
			</td>
		</tr>
		</table>
		</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">

			<%if(localeName.equals("en"))
			{%>
			<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
			<%}
			else if(localeName.equals("th"))
			{%>
			<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
			<%}%>
				
				
		</form>
<%
 }catch(Exception e)
		{
			out.println("Exception in Rep2MonthlyIPSummaryNursingUnit.jsp : "+e.toString());
            e.printStackTrace();

        }   
        finally   
        {
			if(con != null)
				if(con != null)ConnectionManager.returnConnection(con,request);  
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

