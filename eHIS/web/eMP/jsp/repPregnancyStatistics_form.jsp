<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/common.js"></script>
<!--	<script src="../../eCommon/js/messages.js"></script>-->
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>


<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;
	String p_module_id		= "MP";
	//String p_report_id			= "";
	String p_facility_id		= (String)session.getValue("facility_id");
	String p_user_name		= (String)session.getValue("login_user");
	String p_resp_id			= (String)session.getValue("responsibility_id");
	String p_language_id		= (String)session.getValue("LOCALE");
%>
<script>
function setDate(Object){ 
parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
    if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
			//alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			var error=getMessage("DATE_LESS_EQL_SYS_DATE",'FM');
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			Object.value="";
            Object.focus();  
			return false;
        }
    }
}

function CallCongenital()
{
	if (document.forms[0].p_report_id.value=='MPBIWGTP')
	 {	
		
		 document.forms[0].p_report_id.value="MPBIWGTP";	
 		 document.getElementById("conl").style.display='inline';
		  document.getElementById("conv").style.display='inline';
		 document.getElementById("conl").innerHTML=getLabel('eMP.CongenitalAnomalies.label','MP');	
		 document.getElementById("conv").innerHTML = "<input type='text' name='con_ana' id='con_ana' id='twin_brith' maxlength='10' size='10'><input type='button' name='con_anav' id='con_anav' value='?' class='button' onClick=\"document.repPregnancyStatistics.con_ana.select();searchCode(this, con_ana)\"> ";
		  }
	 else  if (document.forms[0].p_report_id.value=='MPBIWGMFP')
	 {	
		 
		
		 document.forms[0].p_report_id.value="MPBIWGMFP";	
		 document.getElementById("conl").style.display='inline';
		  document.getElementById("conv").style.display='inline';
		 document.getElementById("conl").innerHTML=getLabel('eMP.CongenitalAnomalies.label','MP');
		 document.getElementById("conv").innerHTML = "<input type='text' name='con_ana' id='con_ana' id='multi_brith' maxlength='10' size='10'><input type='button' name='con_anav' id='con_anav' value='?' class='button' onClick=\"document.repPregnancyStatistics.con_ana.select();searchCode(this, con_ana)\"> ";
	}
	else
	{
					
		 //document.getElementById("conl").innerHTML="";
		// document.getElementById("conv").innerHTML = ""
		 document.getElementById("conv").style.display='none';
		 document.getElementById("conl").style.display='none';
	
	}
}
async function searchCode(obj,target)
	{
	//	alert("Hello");
		
			var retVal = 	new String();
			var dialogHeight= "28px" ;
			var dialogWidth	= "43px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var con_ana = document.repPregnancyStatistics.con_ana.value;
			//var con_ana = document.repPregnancyStatistics.con_ana.value;
			var p_language_id = document.repPregnancyStatistics.p_language_id.value;
							
			
				tit="Congenital Anomalies";
			//	sql="select CONG_ANOMALIES_CODE,LONG_DESC from MP_CONGENITAL_ANOMALIES";

				sql="select cong_anomalies_code code, short_desc description from mp_cong_anomalies_lang_vw where eff_status = `E` and  language_id=`"+p_language_id+"`";
				search_code="CONG_ANOMALIES_CODE";
				search_desc= "SHORT_DESC";
		
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

</script>
<body>
<center>
	<form name="repPregnancyStatistics" id="repPregnancyStatistics" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<BR>
		<table cellspacing='0' cellpadding='3' width='80%' border='0'>
		<tr>
			    <td width='30%'>&nbsp;</td>
				<td width='30%'>&nbsp;</td>
				<td width='15%'>&nbsp;</td>
				<td width='35%'>&nbsp;</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='p_all_facility_id' id='p_all_facility_id'>
			<%
				try
				{					
					String fid;
					String fname;
					con = ConnectionManager.getConnection(request);
					String sql1 = "SELECT  'All' facility_id  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels")+"' facility_name  FROM  dual  UNION SELECT  u.facility_id facility_id  , sm_get_desc.sm_facility_param(u.facility_id, '"+localeName+"', 1) facility_name FROM  sm_facility_for_user u WHERE u.appl_user_id ='"+p_user_name+"'   AND u.facility_id IN (  SELECT  distinct facility_id   FROM  sm_facility_for_resp   WHERE resp_id = '"+p_resp_id+"'  )  ORDER BY  1";					
					pstmt=con.prepareStatement(sql1);

					rset=pstmt.executeQuery(sql1);
					if(rset!=null){
					   while(rset.next()){
							fid=rset.getString("facility_id");
							fname=rset.getString("facility_name");
							if(fid.equals("All"))
								out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
							else
								out.println("<option value='"+fid+ "' >"+fname+"</option>");
					   }
					}
				}catch(Exception e){}				
				finally{ 
					try	{
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null) ConnectionManager.returnConnection(con,request);					
					}
					catch(Exception e){}
				}
				%>
			</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		 <tr>
				<td>&nbsp;</td>
				<td class="querydata"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td> 
				<td>&nbsp;</td>
				<td class="querydata"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		 </tr>
		 <tr>
				<td class="label" nowrap><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" id='regnagenatstatfrom' name="p_regis_time_fm" id="p_regis_time_fm" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatfrom');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td class="label">&nbsp;</td>
				<td class='fields'><input type="text" id='regnagenatstatto' name="p_regis_time_to" id="p_regis_time_to" size="10" maxlength="10" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('regnagenatstatto');"><img src='../../eCommon/images/mandatory.gif'></img>
				</td>
		 </tr>
		 <tr>
			<td class="label" nowrap><fmt:message key="Common.reportname.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='p_report_id' id='p_report_id' onChange='CallCongenital();'>
			<option value='' selected>---------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------------------</option>
			<option value='MPSEXNESP'><fmt:message key="eMP.SexNeonatalSingletonPregnancy.label" bundle="${mp_labels}"/></option>
			<option value='MPBIWGSP'><fmt:message key="eMP.BirthWeightForSingletonPregnancy.label" bundle="${mp_labels}"/></option>
			<option value='MPSEXNMFP'><fmt:message key="eMP.SexOfNeonatalForMultiFoetalPregnancy.label" bundle="${mp_labels}"/></option>
			<option value='MPBIWGMFP'><fmt:message key="eMP.BirthWeightForMultiFoetalPregnancy.label" bundle="${mp_labels}"/></option>
			<option value='MPGESAGETP'><fmt:message key="eMP.GestationalAgeForTwinPregnancy.label" bundle="${mp_labels}"/></option>
			<option value='MPTDTWPC'><fmt:message key="eMP.TypeofDeliveryfortwinpregnancy.label" bundle="${mp_labels}"/></option>
			<option value='MPSEXBITP'><fmt:message key="eMP.SexOfBirthForTwinPregnancy.label" bundle="${mp_labels}"/></option>
			 <option value='MPGPTRIP'><fmt:message key="eMP.GestationTripletPregnancy.label" bundle="${mp_labels}"/></option>
			<option value='MPBIWGTP'><fmt:message key="eMP.BirthWeightForTwinPregnancy.label" bundle="${mp_labels}"/></option>
			<option value='MPSTFTPC'><fmt:message key="eMP.StatusofBirthfortwinpregnancy.label" bundle="${mp_labels}"/></option>
			<option value='MPGPTWIP'><fmt:message key="eMP.PresentationForTwinPregnancy.label" bundle="${mp_labels}"/></option>
			<!-- <option value='MPCONTWI'><fmt:message key="eMP.ConjoinedTwins.label" bundle="${mp_labels}"/></option>		 -->	
			<option value='MPDFOTRIP'><fmt:message key="eMP.DeliveryAndFoetalOutcomeForTripletPregnancy.label" bundle="${mp_labels}"/></option></select><img src='../../eCommon/images/mandatory.gif'></img>
		 </tr>
		 <tr>
		 <td align='left' id='conl' class="label" nowrap></td>
		 <td id='conv' class="fields" >
		 </tr>
		 </table>
		 <br>
			<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"			value="<%= p_facility_id %>">			
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%= p_language_id %>">			
			<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">			
	</form>
</center>
</body>


