<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>     
<html>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*" %>
 <%
   String facilityId = (String) session.getValue("facility_id");
  %>

 <head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
   <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
   <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
   <script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
   <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
   <script language='javascript' src='../../eCommon/js/common.js'></script>
   <script language='javascript' src='../../eOA/js/ChangePractitionerforGenSch.js'></script>
   <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>

 <%
   Connection con = null;
   Statement stmt=null;
   Statement stmt_t=null;
   Statement stmt1=null;
   ResultSet rs=null;
   ResultSet rs_t=null;

   String datval1 ="";
   String currentdate="";
   String from_date ="";
   String to_date ="";
   String from_day ="";	 
   String remarks    ="";
   String p_user_name= (String) session.getValue( "login_user" ) ;
   String locale=(String)session.getAttribute("LOCALE");


	Statement stsql1=null;
	ResultSet rssql1=null ;
	Statement stsql2=null;
	ResultSet rssql2=null ;

	//String oper_stn_access_rule="";
	String oper_stn_id="";

   try {
		con = ConnectionManager.getConnection(request);
		
	//	stsql1=con.createStatement();

	//		rssql1 = stsql1.executeQuery("select oper_stn_access_rule from op_param where operating_facility_id='"+facilityId+"'");
		//	if (rssql1!=null &&  rssql1.next()){
		//		oper_stn_access_rule=rssql1.getString("oper_stn_access_rule");

		//		if(oper_stn_access_rule.equals("U"))
		//		{

				
		//	stsql2=con.createStatement();	
		//	rssql2=stsql2.executeQuery("SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+p_user_name+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))");
			//	if (rssql2!=null &&  rssql2.next())
			//	{
			//	oper_stn_id=rssql2.getString("oper_stn_id");
			//	}
			//	else{ %>					
			<!--	<script>alert(getMessage('NO_OPER_STN_FOR_USER','OA'));
				history.back(1);</script>-->
					<%
		//}
	//	}		
	//}else{%>	
			<!--	<script>
					alert(getMessage('OP_PARAM_NOT_FOUND','Common'));
					location.href='../../eCommon/jsp/home.jsp';
					history.back(1);
					</script>-->
	<%//} 	 %>

 
 <body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload='disableFields()'>
 <form name='ChangePract_form' id='ChangePract_form' > 
 
	 <div>
     <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
      
      <tr>
        <td class='Label' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>

        <td class='fields'><select name='location1' id='location1' onchange='locationreturn(this)' tabindex=1>
				<option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>;
				<%
				   stmt = con.createStatement();
				   rs = stmt.executeQuery("select locn_type, short_desc, care_locn_type_ind, to_char(sysdate,'dd/mm/yyyyhh24miss')date1, to_char(sysdate,'dd/mm/yyyy') d from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and language_id = '"+locale+"' and locn_type in ('C','E','Y')  order by short_desc ");

					String locn_type="";
					String short_desc1="";
					  if(rs!=null) {
					while(rs.next()) {
					
					locn_type=rs.getString("care_locn_type_ind");
					short_desc1=rs.getString("short_desc");
					datval1 =rs.getString("date1");
					currentdate = rs.getString("d");

				%>
					<option value='<%=locn_type%>'><%=short_desc1%></option>
				<%
					}
				}
			%>
			  </select></td>

			<td class='Label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='fields' width='10%'>
			<input type='text' name='b_loc_val' id='b_loc_val' value='' onblur='ena_loc_lookup(this);' size=30 maxlength=30 ><input type='button' value='?' onclick='open_loc_lookup();' class='button' name='b_loc_search' id='b_loc_search'><img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='location' id='location' value=''></td>
			<!--<SELECT id='loc'  name='location' id='location'  onChange='Loc_Change(this);clearDetail();enablepr();validateTbs();' tabindex=2>
			<OPTION value=''  style='align:center'>----------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------</SELECT><img  src="../../eCommon/images/mandatory.gif"     align='center'></img>-->
			</TD>
		</tr>

	
		<tr>
            <td class='Label' NOWRAP><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>

				<td class='fields'><input type='text' id='practfrom' name='from_date' id='from_date' size='11' maxlength='10'  Onblur="validate_date_from(this,'<%=currentdate%>');compare_from(this,to_date);" onchange='from_date_change();clearDetail();' tabindex=4><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].from_date.select();return showCalendar('practfrom');"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					 
				<td class='Label' NOWRAP><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td> 
				 <td class='fields'><input type='text' id='practto' name='to_date' id='to_date' size='10' maxlength='10'  Onblur="validate_date_to(this,from_date);" onchange='to_date_change();clearDetail();' tabindex=5><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].to_date.select();return showCalendar('practto');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
     </tr>
     
	<tr>
			 <td   class='Label'><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>

			 <td   class='fields'  nowrap>
				 <select name='day' id='day' maxlength='10' onchange='day_change();clearDetail();' tabindex=3>
				  <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
				 </select>
			</td>
			
			 <td class='label' ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
			
			 
			 <td class='fields'>
				 <SELECT name='resource' id='resource' id='res'  onchange='practValidate();' onblur='resourceOnBlur();' disabled tabindex=6><OPTION value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
				<OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
				<OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
				<OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
				<OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
				</SELECT><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>
		


      <tr>
			<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="from_page" value= "change_resource" />
			<jsp:param name ="pract_value" value= "" />
			</jsp:include>

						
			<!-- <td class='label' ><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		  
					
			<td class='fields'>
                <input type='text'  name='pract_from_desc' id='pract_from_desc' disabled onblur = " onblurcheck(this,pract_from_desc,document.forms[0].resourceType);enableto(); " size=30 maxlength=30 onChange='clearDetail();'tabindex=7><input type='hidden' name='pract_from' id='pract_from' value="" onChange='clearDetail();'><input type='button' class='button' name='from' id='from' value='?' disabled  onClick='callPractSearch(this,pract_from_desc,document.forms[0].resourceType);enableto();'><img src='../../eCommon/images/mandatory.gif'></img></td>
				
			<td class='label' ><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
				
			<td class='fields'><input type='text'  name='pract_to_desc' id='pract_to_desc' disabled  onblur = 'onblurcheck(this,pract_to_desc,document.forms[0].resourceType)' size=30 maxlength=30 onChange='clearDetail();' tabindex=8><input type='hidden' name='pract_to' id='pract_to' value="" onChange='clearDetail();'><input type='button' class='button' name='to' id='to' value='?' disabled  onClick='callPractSearch(this,pract_to_desc,document.forms[0].resourceType)'><img src='../../eCommon/images/mandatory.gif'></img>
			</td> -->
      </tr>
     
      
      <tr>
			<td  class='label' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>

			<td class='fields'>
			<input type='text' name='reason1' id='reason1' value='' onblur='reasonlookup(this);' size=30 maxlength=30 ><input type='button' value='?' onclick='reasonlookup(this);' class='button' name='reasonclick' id='reasonclick'><img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='reason_code' id='reason_code' value=''>
			<td class='fields'colspan='2' >&nbsp;</td>
	</tr>


	<tr>	  
		<td  class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields' NOWRAP colspan='2'>
		<input type='text' size='56' maxlength='75' onblur = 'makeValidString(this)' name='remarks' id='remarks' value='' tabindex=10>
		</td>
		<td class='button' width='22%'><input type='button' id='genRep1' value='<fmt:message key="Common.Generate.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/>' class='button' onClick='gen_report()' disabled tabindex=11>&nbsp;<input type='button' name='select' id='select' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' class='Button' title='Select' onclick="Select_Click('<%= facilityId %>')"></td>
	</tr>
	<input type="hidden" name='resourceType' id='resourceType' value="">		    
	<input type='hidden' name='genrep' id='genrep'    value=''></input>
    <input type='hidden' name='sys_date' id='sys_date'  value='<%=currentdate%>'>
	<input type='hidden' name='Recs_chkd' id='Recs_chkd' value=''>
	<input type='hidden' name='maxRecs' id='maxRecs'   value='' >
	<input type='hidden' name='date_str' id='date_str'  value='' >
	<input type='hidden' name='only_header' id='only_header' value='' >
	<input type="hidden" name="P_Facility_id" id="P_Facility_id" value='<%=facilityId%>'>
<!--	<input type="hidden" name="oper_stn_id" id="oper_stn_id" value='<%=oper_stn_id%>'>-->
	<input type="hidden" name="locale" id="locale" value='<%=locale%>'>
		
	<input type='hidden' name='P_Clinic_Code' id='P_Clinic_Code' value='' >
	<input type='hidden' name='P_Practitioner_Id' id='P_Practitioner_Id' value='' >
	<input type='hidden' name='P_To_Practitioner_Id' id='P_To_Practitioner_Id' value='' >
	<input type='hidden' name='p_user_id' id='p_user_id' value='<%=p_user_name%>'></input>
	<input type='hidden' name='eff_from' id='eff_from' value='<%=from_date%>'></input>
	<input type='hidden' name='eff_to' id='eff_to' value='<%=to_date%>'></input>
	<input type='hidden' name='reason' id='reason' value='<%=remarks%>'></input>
	<input type='hidden' name='P_Event_Date' id='P_Event_Date' value='<%=datval1%>'></input>
	<input type='hidden' name='P_Day_No' id='P_Day_No' value='<%=from_day%>'></input>
	<input type='hidden' name='P_Report_Title' id='P_Report_Title' value='List_of_Appointments_for_Change_of_Practitioner'></input>

</input>
     </table>
     </div>

   </form>

<%		if(rssql1 != null) rssql1.close();
		if(rs != null) rs.close();
		if(rs_t!= null) rs_t.close();
		if(stmt != null) stmt.close();
		if(stmt1 != null) stmt1.close();
		if(stmt_t != null) stmt_t.close();
		if(stsql1 !=null) stsql1.close();
		if(stsql2 !=null)stsql2.close();
		if(rssql2 != null) rssql2.close();
		if(rssql1 != null) rssql1.close();

} catch(Exception e) {
//out.print( e.toString() );
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally {

		ConnectionManager.returnConnection(con,request);
      }
    %>


 </body><script>document.forms[0].location1.focus();</script>

</html>




