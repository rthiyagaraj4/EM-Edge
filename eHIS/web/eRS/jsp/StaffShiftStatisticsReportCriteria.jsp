<!DOCTYPE html>
<!-- Created on 19 August 2009 -- Shyampriya -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%

		    request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
		    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

			<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
			<!-- import the calendar script -->
			<SCRIPT LANGUAGE="Javascript" src="../../eCommon/js/DateUtils.js"></SCRIPT>
			<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
			<SCRIPT LANGUAGE="javascript" src="../../eCommon/js/CommonCalendar.js"></SCRIPT>
			<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
			<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
			<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT> -->
			<SCRIPT LANGUAGE="javascript" SRC="../../eRS/js/StaffShiftStatisticsReport.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<script>
			function makemtstaffname()
			{
				//document.forms[0].staff_id.value='';
				//document.forms[0].staff_code.value ='';
			}
			function viewstaff(target,obj){
				//alert("Inside viewstaff--->");
				//alert("target--->" +target.value);
				//alert("target--->" +target.value +"obj---|" +obj);
			var url='../../eRS/jsp/SearchStaff.jsp?mode=call';
			var dialogHeight =window.screen.height ;
			var dialogWidth = window.screen.width ;
			var dialogTop	= 0;
			var dialogLeft = 0 ;
			
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
			var arguments = "";
			//alert(window.showModalDialog(url,arguments,features));
			var retVals = window.showModalDialog(url,arguments,features);
			//alert("retVals--->" +retVals);
			if(retVals !=null){
				//alert("if---");
				target.value=retVals[1];
				//alert("target.value--->" +target.value);
				if(obj=="from")
				{
					document.forms[0].p_staff_code_from.value=retVals[0];
					//alert("==1=="+document.forms[0].p_from_staff_code.value);
				}else if(obj=="to")
			
				{
					document.forms[0].p_staff_code_to.value=retVals[0];
					//alert("==2=="+document.forms[0].p_to_staff_code.value);
				}
				if(retVals[2]=='P'){
					document.forms[0].role_type.value='P';
					name.innerText="  "+"Practitioner";
					//alert(name.innerText.value);
				}
				else{	
					document.forms[0].role_type.value='O';
					name.innerText="  "+"Other Staff";
				}
			}
		}

			</script>
	</HEAD>
	<BODY>
	<%
		Connection con 	      = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs		      = null;
	  con = ConnectionManager.getConnection(request);
	  //String role_type	= request.getParameter( "role_type" )==null?"":request.getParameter("role_type");
	  //String p_staff_type	= request.getParameter( "p_staff_type" )==null?"":request.getParameter("p_staff_type");

	%>
		<!-- <FORM name="formLeaveDtlsReport" id="formLeaveDtlsReport" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"> -->
	 <FORM name="formStaffShiftStatisticsReport" id="formStaffShiftStatisticsReport" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"> 
			<TABLE WIDTH="98%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
				<TH WIDTH="100%" COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr ><td>&nbsp</td></tr>
				<tr>
				<td >&nbsp;</td>
				<td class="querydata" >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td class="querydata">&nbsp;</td>
				<td class="querydata" >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
				<td class="label">&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='label'><input type="text" name="p_date_from" id="p_date_from" size="10" maxlength="10" onBlur="validDateFormat(this,'<%=locale%>');" onKeyPress='return AllowDateFormat();'> <IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_date_from');">
				&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img>
				</td>
				<td class="label">&nbsp;</td>
				<td class='label'><input type="text" name="p_date_to" id="p_date_to" size="10" maxlength="10" onBlur="validDateFormat(this,'<%=locale%>');" onKeyPress='return AllowDateFormat();'> <IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_date_to'); ">
				&nbsp;<img src="../../eCommon/images/mandatory.gif"  ></img>
				</td>
			</tr>
			<tr><td>&nbsp</td></tr>
			<tr>
				<td class="label">&nbsp;<fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
					 <TD CLASS="label"><INPUT TYPE=text size=10  name="p_workplace_code_from" id="p_workplace_code_from" maxlength='10'readonly>  
					<!-- <TD ALIGN="left"> --><INPUT TYPE="button" name="wplcFrom" id="wplcFrom" VALUE="?" CLASS="button" onfocus="searchCode(p_workplace_code_from)" onclick="searchCode(p_workplace_code_from)"></TD>
					<td class="label">&nbsp;</td>
					<TD  CLASS="label"><INPUT TYPE=text name="p_workplace_code_to" id="p_workplace_code_to" SIZE="10" maxlength="10" readonly > <INPUT TYPE="button" name="wplcTo" id="wplcTo" VALUE="?" CLASS="button" onfocus="searchCode(p_workplace_code_to)" onclick="searchCode(p_workplace_code_to)"></TD>			
			</tr>
			<tr><td>&nbsp</td></tr>
			<tr>
			<td class="label">&nbsp;<fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
			<td class="label"><select name="p_position_code_from" id="p_position_code_from"style="width:150px">
			<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
					String togetposition ="";
					//togetlocn = "select locn_type,short_desc from am_care_locn_type order by short_desc";
					togetposition = "SELECT POSITION_CODE code, POSITION_DESC description FROM am_position_lang_vw WHERE LANGUAGE_ID=? ORDER BY POSITION_DESC ";
					pstmt =con.prepareStatement(togetposition);
					pstmt.setString(1,locale);
					rs = pstmt.executeQuery();
					while(rs!=null  && rs.next()){
						out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
					 }
					 if(pstmt != null)
						 pstmt.close();
					 if(rs!=null)
						 rs.close();
%>
				</select>
				</td>
				<td class="label">&nbsp;</td>
				<td class="label"><select name="p_position_code_to" id="p_position_code_to"style="width:150px">
			<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
					String frmgetposition ="";
					//togetlocn = "select locn_type,short_desc from am_care_locn_type order by short_desc";
					//frmgetposition = "SELECT POSITION_CODE code, POSITION_DESC description FROM am_position_lang_vw ";
					frmgetposition = "SELECT POSITION_CODE code, POSITION_DESC description FROM am_position_lang_vw WHERE LANGUAGE_ID=? ORDER BY POSITION_DESC ";
					pstmt =con.prepareStatement(frmgetposition);
					pstmt.setString(1,locale);
					rs = pstmt.executeQuery();
					while(rs!=null  && rs.next()){
						out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
					 }
					 if(pstmt != null)
						 pstmt.close();
					 if(rs!=null)
						 rs.close();
%>
				</select>
				</td>


			</tr>
			<tr><td>&nbsp</td></tr>
				<tr>
					<td class="label">&nbsp;<fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/></td>
					<td class="label"><input type=text name="p_from_staff_code" id="p_from_staff_code" value="" size="15"readonly><input class='button' type=button name="stafflookup_button" id="stafflookup_button" value="?" onclick='viewstaff(p_from_staff_code,"from");'>
					<td class="label">&nbsp;</td>
					<td class="label"><input type=text name="p_to_staff_code" id="p_to_staff_code" value="" size="15" readonly><input class='button' type=button name="stafflookup_button" id="stafflookup_button" value="?" onclick='viewstaff(p_to_staff_code,"to");'></td>
					<input TYPE='hidden' name='p_staff_code_from' id='p_staff_code_from' value=''>
					<input TYPE='hidden' name='p_staff_code_to' id='p_staff_code_to' value=''>
			</tr>
			<tr><td>&nbsp</td></tr> 
				<tr>
					<td class='label'>&nbsp;<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
					<td class="label"><select name="p_shift_code" id="p_shift_code" style="width:110px">
					<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
					String frmgetshift ="";
					//togetlocn = "select locn_type,short_desc from am_care_locn_type order by short_desc";
					frmgetshift = "select SHIFT_CODE,SHORT_DESC  from am_shift_lang_vw where language_id=? order by shift_code";
					pstmt =con.prepareStatement(frmgetshift);
					pstmt.setString(1,locale);
					rs = pstmt.executeQuery();
					while(rs!=null  && rs.next()){
						out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
					 }
					 if(pstmt != null)
						 pstmt.close();
					 if(rs!=null)
						 rs.close();
%>
				</select>
				</td>
					<td class="label"><fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/></td>
					&nbsp;<td>&nbsp;<select name="P_Report_By" id="P_Report_By" style="width:110px">
					<option value="A">---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---</option>
					<option value="S"><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/></option>
					<option value="W"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></option>
					<option value="F"><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></option>
					</td>
				</tr>		

</TABLE>
			
			<!-- <input TYPE='hidden' name='p_date_from1' id='p_date_from1' value=''>
			<input TYPE='hidden' name='p_date_to1' id='p_date_to1' value=''> -->
			<input TYPE='hidden' name='role_type' id='role_type' value=''>
			<input TYPE='hidden' name='staff_id' id='staff_id' value=''>
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="RS">
			<!-- <INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="RSLEAVEDET"> -->
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
		</FORM>
	</BODY>
</HTML>

