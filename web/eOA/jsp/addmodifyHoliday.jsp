<!DOCTYPE html>
    <!-- 
		MODIFIED : Suman
		DATE : 19 April 2006
	--> 
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.* ,eCommon.Common.* ,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eOA/js/Holiday.js' language='javascript'></SCRIPT>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>






<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
	String dw=request.getParameter("dw");
	if(dw==null || dw.equals("null"))
		dw="D";

	String tabvalue=request.getParameter("tabvalue");
	if(tabvalue ==null) tabvalue="Location";

	String classvalue="",classvalue1="";

	if(tabvalue.equals("Location"))
	{
	classvalue="SECONDSELECTED";
	classvalue1="FIRSTNORMAL";
	}else
	{
	classvalue="FIRSTNORMAL";
	classvalue1="SECONDSELECTED";
	}
	Connection con =null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	Statement stsql1=null;
	Statement stsql2=null;
	ResultSet rset=null ;
	ResultSet rssql2 =null;	
	ResultSet rssql1=null;
				String locale=(String)session.getAttribute("LOCALE");

    	
	
	String locn_type="",short_desc="",reasonforhol = "",currentdate = "",rd ="",holdate ="", dsib="",fac_id ="";
	String fnval = "insert";
	String locnType=request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String cliniccode=request.getParameter("cliniccode")==null?"":request.getParameter("cliniccode");
	String clinicDesc=request.getParameter("clinicDesc")==null?"":request.getParameter("clinicDesc");
	String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String locnDesc1="";
	String action_on_holiday_schedule="";//Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543] 
	if (locnType.equals("C")){
		locnDesc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}else if (locnType.equals("D")){
		locnDesc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
	}else if (locnType.equals("E")){
		locnDesc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
	}

	
	String hday=request.getParameter("hday");
	if(hday==null)
	   hday = "";
	holdate = request.getParameter("holiday_date");
	String holdate_disp=DateUtils.convertDate(holdate,"DMY","en",locale);
	fac_id = request.getParameter("facility_id");
	HashMap ResultParamHashMap = new HashMap();

	try
	{
		con = ConnectionManager.getConnection(request);
		stsql1=con.createStatement();

		
		/*Added by Dharma on Apr 9th 2015 against HSA-CRF-0183 [IN:049543] Start*/
		HashMap sqlColumns = new HashMap();
		sqlColumns.put("ACTION_ON_HOLIDAY_SCHEDULE","S");
		String whereCondition	= "where module_id='OA'";
		ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,whereCondition,"OA_PARAM",con);
		action_on_holiday_schedule = (String) ResultParamHashMap.get("ACTION_ON_HOLIDAY_SCHEDULE");
		/*Added by Dharma on Apr 9th 2015 against HSA-CRF-0183 [IN:049543] End*/


	if(holdate!=null )
	{
		fnval="modify";
		rd = "READONLY";
		dsib="disabled";
		pstmt=con.prepareStatement("select REASON_FOR_HOLIDAY from OA_holiday where facility_id=? and holiday_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and locn_code=? ");
		pstmt.setString(1,fac_id);
		pstmt.setString(2,holdate);
		pstmt.setString(3,locnType);
		pstmt.setString(4,cliniccode);
		rset=pstmt.executeQuery();
		rset.next();
		reasonforhol=rset.getString("REASON_FOR_HOLIDAY");

	}
	else
		holdate = "";

			
			
%>
	</head>
	<body onload="foc()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='Holiday_form' id='Holiday_form' action='' method='post'  target='messageFrame'>
		
                      
			<br>
			
			<input type='hidden' name='dayweekvalue' id='dayweekvalue' value='<%=dw%>'>
			<%	stmt=con.createStatement();
				rset=stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
				rset.next();
				currentdate = rset.getString("d");
			if(rset !=null)rset.close();
			%>

    	    <input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>

		<table border='0' cellpadding='0' cellspacing='0' align='center' width='90%'>
			<%if(!fnval.equals("modify")) {%>
			
		<tr>
			 <td class='<%=classvalue%>' id='bydate' width='10%' align=center style='cursor:pointer; border: 1px solid black;' nowrap onclick="Location_search('tab1');"><font color='black'><fmt:message key="eOA.ExistingHoliday.label" bundle="${oa_labels}"/></font></td>
			 <td class='<%=classvalue1%>' id='bylocation' width='10%'  align=center style='cursor:pointer;background-color: #00000036;  border: 1px solid black;' nowrap onclick="Holiday_search('tab2');"><font color='black'><fmt:message key="eOA.HolidayForNewLocation.label" bundle="${oa_labels}"/></font></td> 
		</tr>
				 <%}%>
						
		<tr>
			
			<td width='25%' class='label'>&nbsp;</td>
			<td width = '25%' class='label'>&nbsp;</td>
			<td width='25%' class=label colspan=2>&nbsp;</td>
			
		</tr>
					<%if(tabvalue.equals("Location")) {%>
					
		<tr>
					<%if(!fnval.equals("modify")) {%>
		    <td  class=label  width='22%' nowrap><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<%	}else { %>
			<td  class=label  width='25%' nowrap><fmt:message key="Common.HolidayDate.label" bundle="${common_labels}"/></td>
						<% } %>
			<td class='fields' width='25%'><input width='15' type='text' 
			name='holiday' id='holiday' size='10' maxlength='10' value="<%=holdate_disp%>" <%=rd%> Onblur="validate_date_from(this);compare_from(this,holiday_end);month_Check1();" tabindex=1><input type='hidden' name='holdate' id='holdate' value='<%=holdate%>'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].holiday.select(); return showCalendar('holiday');" tabindex=2 <%=dsib%>><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					
					<%if(!fnval.equals("modify")){}%>
						<input type='hidden' name='holiday_date' id='holiday_date' size='10' maxlength='10' value=""  >
			      	    <input type='hidden' name='holiday_day' id='holiday_day' size='13' maxlength='9' value="<%=hday%>" readonly >							
						<%if(!fnval.equals("modify")){%>
			
			<td  class=label  width='25%' nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td class='fields'  width='25%'><input type='text' name='holiday_end'  value='' id='holiday_end' size='10' maxlength='10' Onblur='validate_date_to(this,holiday);month_Check1();' tabindex=3><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].holiday_end.select(); return showCalendar('holiday_end');" tabindex=4></td>
			 
							
						<%}else{%>
			<td class='label' colspan='1' ><font class="label" id='holiday_day1' width = '15%' ></font><input type='hidden' name='holiday_end'  value='' id='holiday_end' size='10' maxlength='10' Onblur='chk(this);' tabindex=3></td>
			<td width='25%' class=label>&nbsp;</td>
							<%}%>
										
		</tr>

		<tr>
			<td class='label' width='25%'>&nbsp;</td>
			<td class='label' width ='25%'>&nbsp;</td>
			<td class='label' width='25%' colspan='2'>&nbsp;</td>
		</tr>
					<%}%>
	

		<TR>
			<TD class="label"  width='22%' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></TD>

					<%
					if(!fnval.equals("modify")){
				
							String sql = " Select Locn_Type, Short_Desc, care_locn_type_ind from am_care_locn_type_lang_vw where language_id = '"+locale+"' and sys_user_def_ind = 'S' and locn_type in ('C','E','Y') order by 2";
							  rset = stmt.executeQuery(sql);

						if(tabvalue.equals("Location")) {%>	
				
				
			<TD class="fields"  width='25%'>
					<SELECT name='locationType' id='locationType'  onChange="populateClinic_date(this,'Holiday')"> 
					<option style='align:center' value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
					<%
						while(rset.next() && rset !=null)
						{
							locn_type=rset.getString("care_locn_type_ind");
							short_desc=rset.getString("short_desc");
							out.println("<option value='"+locn_type+"'>"+short_desc);
						}

						if(rset !=null) rset.close();
					%>
					</SELECT><img  src="../../eCommon/images/mandatory.gif"     align='center'></img></TD>
			
			<TD class="label"  width='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
			<TD class="fields" id='loc' width='25%'>
			<input type='text' name='b_loc_val' id='b_loc_val' value='' onblur='ena_loc_lookup(this);' size=30 maxlength=30 ><input type='button' value='?' onclick='open_loc_lookup();' class='button' name='b_loc_search' id='b_loc_search'>
			<input type="hidden" name="b_clinic" id="b_clinic" value="">
					<!--<SELECT name='b_clinic' id='b_clinic' onchange='clearvalue(this);'  >
					<OPTION value=''  style='align:center'>----------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------
					<option value='*A'>*All
					</SELECT>-->
					</TD>
		</tr>
	
					<%}else {%>
		
			<TD class="fields" width='22%'>
					<SELECT name='locationType' id='locationType' onChange="populateClinic_locn(this,'Holiday')" >
					<option style='align:center' value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
								<%
								while(rset.next() && rset !=null)
								{
									locn_type=rset.getString("care_locn_type_ind");
									short_desc=rset.getString("short_desc");
									out.println("<option value='"+locn_type+"'>"+short_desc);
								}

								if(rset !=null) rset.close();
							%>
							</SELECT><img  src="../../eCommon/images/mandatory.gif"     align='center'></img></TD>
			<TD class="label"  width='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
			<TD class="fields"  id='loc' width='25%'>
			<input type='text' name='b_loc_val' id='b_loc_val' value='' onblur='ena_loc_lookup(this);' size=30 maxlength=30 ><input type='button' value='?' onclick='open_loc_lookup();' class='button' name='b_loc_search' id='b_loc_search'>
			<input type="hidden" name="b_clinic" id="b_clinic" value="">
					<!--<SELECT name='b_clinic' id='b_clinic' onchange='chk_mand(this);clearvalue(this);' >
					<OPTION value=''  style='align:center'>----------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------
					<option value='*A'>*All
					</SELECT>-->
					</TD>
			
		</TR>
					<%}
					}else{%>
			<TD class="fields" colspan='1'>
						<SELECT name='locationType' id='locationType' readonly >
						<OPTION value='<%=locnType%>'  												style='align:center'><%=locnDesc1%></SELECT></td>
			<TD class="label"  width='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
			<TD class='fields' width='25%'>
						<SELECT name='b_clinic' id='b_clinic'  readonly >
						<OPTION value='<%=cliniccode%>'  style='align:center'><%=clinicDesc%>
						</SELECT><img  src="../../eCommon/images/mandatory.gif"     align='center'></img></TD>
			
		</TR>
				<%}%>
		

    	<tr>
    		<td  class='label'>&nbsp;</td>
			<td  class='label'>&nbsp;</td>
			<td  class='label' colspan=2>&nbsp;</td>
		</tr>
	
			<%if(dw.equals("D")){
				if(fnval.equals("modify")){
				%>

		<tr>				
			<td width='25%'  class='label' nowrap><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/></td>
			<td class='fields'  width='25%'><input type='text' name='reason_for_holiday' id='reason_for_holiday' onblur = 'makeValidString(this)' size='25' maxlength='25' value="<%=reasonforhol%>"  tabindex=5><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td class='label'  width='25%'>&nbsp;</td>
			<td class='label'  width='25%'>&nbsp;</td>
		</tr> 
		
			<%}else{
				
				if(tabvalue.equals("Location")) {%>
		<tr>				
			<td width='25%'  class='label' nowrap><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/></td>
			<td class='fields'  width='25%'><input type='text' name='reason_for_holiday' id='reason_for_holiday' onblur = 'makeValidString(this)' size='25' maxlength='25' value="<%=reasonforhol%>"  tabindex=5><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td class='label' width='25%'>&nbsp;</td>
			<td  class='button'  width='25%'>
			<input type='button' class='button' name='Select' id='Select' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onclick='call_result()'>
			<input type='button' class='button' name='Cancel' id='Cancel' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='refresh_result()'></td>
	    </tr>
			<%}else { %>
			<td  class="label" width='20%' nowrap ><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td> 
			<td class='fields' width='25%'>
			<input width='15' type='text' 
			name='holiday' id='holiday' size='10' maxlength='10' value="<%=holdate%>" <%=rd%> Onblur="validate_date_from(this);compare_from(this,holiday_end);year_check(this,holiday_end);" tabindex=1><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].holiday.select(); return showCalendar('holiday');" tabindex=2 <%=dsib%>><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			
			<td class='label' width='20%' nowrap><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
			
			<td class='fields' width='25%'><input type='text' name='holiday_end' id='holiday_end' value=''  size='10' maxlength='10' Onblur='validate_date_to(this,holiday);year_check(holiday,this);'  tabindex=3 disabled><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" disabled id='to_date_val' onClick="document.forms[0].holiday_end.select(); return showCalendar('holiday_end');" tabindex=4><img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' ID='mand_to_date' align='center'></img></td> 
		</tr>
		<tr>
    		<td  class='label'>&nbsp;</td>
			<td  class='label'>&nbsp;</td>
			<td  class='label' colspan=2>&nbsp;</td>
		</tr>

		<tr>
    		<td  class='label' id='reason_label'><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/></td>
    		<td  class='field'><input type="text" name="reason_for_holiday" id="reason_for_holiday" value=""  size='25' maxlength='25'>
			<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' ID='mand_reason' align='center'></img></td>
			<td  class='label' colspan='3'>&nbsp;</td>

		</tr>
		<tr>
			<td class='label'  width='22%'>&nbsp;</td>
			<td class='label'  width='25%'>&nbsp;</td>
			<td class='label'  width='25%'>&nbsp;</td>
			<td  class='button' >
			<input type='button' class='button' name='Select' id='Select' id='select' style='visibility:visible' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onclick='call_result_date()'>
			<input type='button' class='button' name='Cancel' id='Cancel' id='cancel' style='visibility:visible' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='refresh_result()'>
			</td>
		</tr>
				<%}
				}
				}%>
  		</table>

	<%
			session.removeAttribute("sel_val");
				if(rset!=null)	rset.close();

				if(rssql2 !=null) rssql2.close();

				if(rssql1 !=null) rssql1.close();
				if(stsql2 !=null) stsql2.close();
				if(stsql1 !=null) stsql1.close();
				if(stmt!=null)	stmt.close();
				if(pstmt!=null)	pstmt.close();

			}
			catch(Exception e){
//out.print(e+"here");
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}

			finally
			{
				  ConnectionManager.returnConnection(con,request);
	}%>
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		<input type='hidden' name='holiday_Dates' id='holiday_Dates' value=''>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
		<input type='hidden' name='schedule_exists' id='schedule_exists' value=''>
		<input type='hidden' name='tabvalue' id='tabvalue' value='<%=tabvalue%>'>
		<input type='hidden' name='selectedClinics' id='selectedClinics' value=''>
		<input type='hidden' name='chk_sel_val' id='chk_sel_val' value=''>
		<input type='hidden' name='fromWhere' id='fromWhere' value='singleDelete'>
		<input type='hidden' name='fromdate' id='fromdate' value=''>
		<input type='hidden' name='todate' id='todate' value=''>
		<input type='hidden' name='default_select' id='default_select' value='<%=default_select%>'>
		<input type="hidden" name="action_on_holiday_schedule" id="action_on_holiday_schedule" value="<%=action_on_holiday_schedule%>"><!--Added By Rameswar on 7th Apr 2015 Against HSA-CRF-0183 [IN:049543]-->
</form>
</body>
<%if(dw.equals("D")){%>
	<script>
	if (document.forms[0].tabvalue.value=="Location"){
	document.forms[0].holiday.focus(); 
	}else
	{
	document.forms[0].locationType.focus(); 
	}
	</script>
<%}%>
<%if(!hday.equals("")){%>
   <script>parent.frames[1].document.getElementById('holiday_day1').innerHTML = "<b><%=hday%></b>";</script>
<%}%>

</html>

<!--1. If schedule is already defined: APP-OA0150 Clinic Schedule(s) present for this or range of date(s). Cancel or Block the Schedule-->

