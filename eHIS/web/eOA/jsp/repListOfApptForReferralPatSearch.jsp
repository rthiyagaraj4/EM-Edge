<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<%@ page contentType="text/html;charset=UTF-8"  import = "java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*" %>
<HTML>
<HEAD>
			<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eOA/js/repListOfApptForReferralPatients.js'></script>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
		String facilityId = (String) session.getValue("facility_id");
		Connection con = null;  
		//java.util.Properties p = (Properties) session.getValue("jdbc");
		//String user_name = (String) p.getProperty("login_user");
		String p_passing_local_date="";
		String locale = (String)session.getAttribute("LOCALE");
		if(locale.equals("th")){
			p_passing_local_date="Y";
		}else{
			p_passing_local_date="N";
		}
		Statement stmt=null;
		ResultSet rs = null;
		try{
			con = ConnectionManager.getConnection(request);
		}catch(Exception e){
			//out.println("failed to get connection due to oa-->"+e.toString());
			e.printStackTrace();
		}
%>
<body onmousedown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="list_appt_form" id="list_appt_form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
 <table cellspacing='0' cellpadding='2' border='0' align='center' width='70%'>
 <TR>
		<td  width='30%'>&nbsp;</td>
		<td class='querydata' ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</TR>
 <TR>
		<TD class="label" width="30%"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
		<TD class='fields' width='30%'><input type='text' id='peroddatefm'  name='P_FM_VISIT_DATE' id='P_FM_VISIT_DATE' size='10' maxlength='10' value='' OnBlur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('peroddatefm');"></input><img src='../../eCommon/images/mandatory.gif' align='center'></img></TD>
		<TD class='fields' width='30%'><input type='text' id='peroddateto'  name='P_TO_VISIT_DATE' id='P_TO_VISIT_DATE' size='10' maxlength='10' value='' OnBlur='ValidateDate(this)'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('peroddateto');"></input><img src='../../eCommon/images/mandatory.gif' align='center'></img></TD>
</TR>
 <TR><!--location Type-->
		<TD class='Label' width='30%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></TD> 
		<TD class='fields' width='30%'>
		<SELECT name='P_LOCN_TYPE' id='P_LOCN_TYPE' onchange="changeLocn(this)">
		<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
		<%
		try{
		String loc_sql="Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id='"+locale+"' and locn_type in ('C','E','Y') order by 2";
		stmt = con.createStatement();
		rs = stmt.executeQuery(loc_sql);
		String locnTypeCode="";
		String locnTypeDesc="";
		while(rs!=null && rs.next()){
			locnTypeCode=rs.getString("care_locn_type_ind");
			locnTypeDesc=rs.getString("Short_Desc");
		%>
		
		<option value='<%=locnTypeCode%>'><%=locnTypeDesc%></option>
		<%}
		}catch(Exception e){
			//out.println("Failed due to OA-->"+e);
			e.printStackTrace();
		}
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		 if(con!=null)  ConnectionManager.returnConnection(con,request);
		%>
		</SELECT>
		</TD>
		<TD class='fields' width='30%'></TD>
 </TR>
 <TR><!--location -->
		<TD class='Label' width='30%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width='30%'><input type="text" name="P_LOCATION_CODE_FROM" id="P_LOCATION_CODE_FROM" size="4" maxlength="4"   onblur='if(this.value !="") searchLocn(this, P_LOCATION_CODE_FROM,P_FM_LOCN_CODE)'><input type="hidden" name="P_FM_LOCN_CODE" id="P_FM_LOCN_CODE"><input type='button' name='locn_fm' id='locn_fm'  value='?' class='button'  onclick='searchLocn(this, P_LOCATION_CODE_FROM,P_FM_LOCN_CODE)'></TD>
		<TD class='fields' width='30%'><input type="text" name="P_LOCATION_CODE_TO" id="P_LOCATION_CODE_TO"   size="4" maxlength="4"   onblur='if(this.value !="") searchLocn(this, P_LOCATION_CODE_TO,P_TO_LOCN_CODE)'><input type="hidden" name="P_TO_LOCN_CODE" id="P_TO_LOCN_CODE"><input type='button' name='locn_to' id='locn_to'    value='?' class='button'  onclick='searchLocn(this, P_LOCATION_CODE_TO,P_TO_LOCN_CODE)'></TD>
 </TR>
<!--practitioner -->
	   <jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
	   <jsp:param name ="from_page" value= "reports_listappt" />
	   <jsp:param name ="pract_value" value= "" />
	   </jsp:include>

  <TR><!--service code -->
		<TD class='Label' width='25%' ><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width='30%'><input type="text" name="P_SERVICE_CODE_FROM" id="P_SERVICE_CODE_FROM" size="4" maxlength="4"   onblur='if(this.value !="") searchService(this, P_SERVICE_CODE_FROM,P_FM_SERVICE_CODE)'><input type="hidden" name="P_FM_SERVICE_CODE" id="P_FM_SERVICE_CODE"><input type='button' name='srvc_fm' id='srvc_fm'  value='?' class='button'  onclick='searchService(this, P_SERVICE_CODE_FROM,P_FM_SERVICE_CODE)'></TD>
		<TD class='fields' width='30%'><input type="text" name="P_SERVICE_CODE_TO" id="P_SERVICE_CODE_TO"   size="4" maxlength="4"   onblur='if(this.value !="") searchService(this, P_SERVICE_CODE_TO,P_TO_SERVICE_CODE)'><input type="hidden" name="P_TO_SERVICE_CODE" id="P_TO_SERVICE_CODE"><input type='button' name='srvc_to' id='srvc_to'    value='?' class='button'  onclick='searchService(this, P_SERVICE_CODE_TO,P_TO_SERVICE_CODE)'></TD>
 </TR>
 <TR><!--Referral type -->
		<TD class='Label' width='25%' ><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width='30%'>
		<select name='p_ref_type' id='p_ref_type' onchange='setreferral()'>	
		<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
		<option value='L'><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>
		<option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
		<option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>		
		</select>
		</TD>
		<TD class='fields' width='30%'></TD>
 </TR>
  <TR><!--Referral source -->
		<TD class='Label' width='25%' ><fmt:message key="Common.referralsource.label" bundle="${common_labels}"/></TD>
		<TD class='fields' width='30%'>
		<SELECT name='P_FM_REF_SOURCE' id='P_FM_REF_SOURCE'>
		<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		</SELECT>
		</TD>
		<TD class='fields' width='30%'>
		<SELECT name='P_TO_REF_SOURCE' id='P_TO_REF_SOURCE'>
		<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		</SELECT>
		</TD>
 </TR>
 </table>
<input type= 'hidden' name='P_FACILITY_ID' id='P_FACILITY_ID' value='<%=facilityId%>'/>
<input type= 'hidden' name='locale' id='locale' value='<%=locale%>'/>
<input type= 'hidden' name='P_LANGUAGE_ID' id='P_LANGUAGE_ID' value='<%=locale%>'/>
</form>
</body>

</HTML>

