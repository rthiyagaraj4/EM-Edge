<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import=" java.sql.*,java.text.*,webbeans.eCommon.* " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	<HEAD>
<%
			String facility_id	= (String) session.getValue("facility_id");
			Connection conn		= ConnectionManager.getConnection(request);
			Statement stmt      = null;
			ResultSet rst	    = null;
			
			String more_attribute			= "";
			String patient_id				= "";
			String from_period				= "";
			String to_period				= "";
			String patient_id_max_length    = "";
			String patient_attribute		= "";
			String period_attribute			= "";	
			String today					= "";

			stmt= conn.createStatement();
			String sql = "SELECT patient_id_length FROM mp_param";
			try
			{
				rst = stmt.executeQuery(sql);
				if(rst != null && rst.next())
				{
					patient_id_max_length = rst.getString("patient_id_length");
				}
				if(rst  != null) rst.close();
				String todaysql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
				rst = stmt.executeQuery(todaysql);
				if (rst != null && rst.next())
				{
					today = rst.getString("today");
				}
				if(rst  != null) rst.close();
			}
			catch(Exception e){}
%>
		<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
		<%
		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
		<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eFM/js/FMDocumentFolder.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<SCRIPT>
			function DateCompare(from,to,messageFrame,getVal) 
			{
				var getValue = getVal;
				var fromarray; var toarray;
				var fromdate = from.value ;
				var todate = to.value ;
				if(fromdate.length > 0 && todate.length > 0 ) 
				{
					fromarray = fromdate.split("/");
					toarray = todate.split("/");
					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(todt) < Date.parse(fromdt)) 
					{
						//alert("APP-SM0005 To Date should be Greater than or equal to From Date");
						alert(getMessage("TO_DATE_LESSER_FROM_DATE","FM"));
						to.select();
						return false;
					}
					else if(Date.parse(todt) >= Date.parse(fromdt)) 
					{
						return true;
					}
				}
				return true;
			}
			function CallPatPrd()
			{
				if(document.DocumentFolder_Form.doc_folder_type.value == 'P')
				{
					document.getElementById("tab1").innerHTML=getLabel("Common.patientId.label","common");
					document.getElementById("tab2").innerHTML="<input type='text' name='patient_id' id='patient_id' value='<%=patient_id%>' onKeyPress='return CheckForSpecChars(event)' maxlength='<%=patient_id_max_length%>' size=\"=patient_id_max_length+2>\" onBlur='ChangeUpperCase(this);'><input type='button' class='button' name='pat_search' id='pat_search' value='?' align=center onClick='patientSearch();'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
					document.getElementById("tab3").innerHTML="";
					document.getElementById("tab4").innerHTML="";
				}
				else if(document.DocumentFolder_Form.doc_folder_type.value == 'D')
				{	
					document.getElementById("tab1").innerHTML=getLabel("Common.periodfrom.label","common");
					document.getElementById("tab2").innerHTML="<input type='text' id='date_from' name='from' id='from' value='<%=from_period%>' size='10' maxlength='10' tabIndex='3' value='' onBlur='validDateObj(this,\"DMY\",localeName);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick=\"return  showCalendar('date_from');\"><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
					document.getElementById("tab3").innerHTML=getLabel("Common.periodto.label","common");
					document.getElementById("tab4").innerHTML="<input type='text' id='date_to' name='to' id='to' value='<%=to_period%>' size='10' maxlength='10'  tabIndex='4' onBlur='validDateObj(this,\"DMY\",localeName);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick=\"return  showCalendar('date_to');\"><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
				}
				else if(document.DocumentFolder_Form.doc_folder_type.value == '')
				{
					document.getElementById("tab1").innerHTML="";
					document.getElementById("tab2").innerHTML="";
					document.getElementById("tab3").innerHTML="";
					document.getElementById("tab4").innerHTML="";
				}
			}
			function ValidateString(event)
			{
				if((((event.keyCode>=48) && (event.keyCode<=57)) ||((event.keyCode>=65) && (event.keyCode<=90)) ||((event.keyCode>=97) && (event.keyCode<=122))
				||(event.keyCode==42)||(event.keyCode==95)||(event.keyCode==32)))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		</SCRIPT>
		</HEAD>
		<BODY onMouseDown='CodeArrest();' onLoad='curser_focus();' onKeyDown = 'lockKey();'>
<%		
		try
		{
			String mysql					= "";
			String mode						= "";
			String doc_folder_id			= "";
			String doc_folder_name			= "";
			String p_doc_fld_id				= "";
			String patient_period_specific	= "";
			String IDreadonly_attribute		= "";
			String Nameread_attribute		= "";
			String effstatus				= "E";
			String chk_attribute			= "checked";
						
			mode	= request.getParameter("operation");
			if(mode == null || mode.equals("null"))
				mode = "";
			if(mode.equals("modify"))
			{
				p_doc_fld_id	= request.getParameter("doc_fld_id");
				if(p_doc_fld_id == null || p_doc_fld_id.equals("null"))
					p_doc_fld_id = "";

				mysql = " SELECT doc_folder_id,doc_folder_name,patient_period_specific,patient_id,to_char(from_period,'DD/MM/YYYY') from_period,to_char(to_period,'DD/MM/YYYY') to_period,eff_status FROM fm_doc_folder where facility_id = '"+facility_id+"' and doc_folder_id = '"+p_doc_fld_id+"' ";
				
				rst  = stmt.executeQuery(mysql);
				while(rst !=null && rst.next())
				{
					doc_folder_id			= rst.getString("doc_folder_id");
					doc_folder_name			= rst.getString("doc_folder_name");
					patient_period_specific = rst.getString("patient_period_specific");
					patient_id				= rst.getString("patient_id");
					from_period				= rst.getString("from_period");
					to_period				= rst.getString("to_period");
					effstatus				= rst.getString("eff_status");
				}
				if(p_doc_fld_id == null || p_doc_fld_id.equals("null"))
					p_doc_fld_id = "";
				if(doc_folder_name == null || doc_folder_name.equals("null"))
					doc_folder_name = "";
				if(patient_period_specific == null || patient_period_specific.equals("null"))
					patient_period_specific = "";
				if(patient_id == null || patient_id.equals("null"))
					patient_id = "";
				if(from_period == null || from_period.equals("null"))
					from_period = "";
				if(to_period == null || to_period.equals("null"))
					to_period = "";
				if(effstatus == null || effstatus.equals("null"))
					effstatus = "";
				
				if(patient_period_specific.equals("P"))	
					patient_attribute = "selected";
				else if(patient_period_specific.equals("D"))
					period_attribute = "selected";
				
				if(effstatus.equals("E"))
				{
					chk_attribute = "checked";
				}
				else if(effstatus.equals("D"))
				{
					chk_attribute  = "";
					Nameread_attribute = "readonly";
				}
				IDreadonly_attribute = "readonly";
				more_attribute	   = "disabled";	
			}
%>
			<FORM name='DocumentFolder_Form' id='DocumentFolder_Form'>
			<BR><BR><BR><BR><BR><BR><BR><BR><BR>
				<TABLE border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
					<TR><TD colspan='4'>&nbsp;</TD></TR>
					<TR>
						<TD class='label' width='20%' ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></TD>
						<TD class='fields' width='30%' ><INPUT type='text' name='doc_folder_id' id='doc_folder_id' value='<%=doc_folder_id%>' onKeyPress='return CheckForSpecChars(event);'size='15' maxlength='10' <%=IDreadonly_attribute%>><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG></TD>
						<TD colspan='2'>&nbsp;</TD>
					</TR>
					<TR><TD colspan='4'>&nbsp;</TD></TR><TR>
						<TD class='label' width='20%' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></TD>
						<TD class='fields' width='30%' ><INPUT type='text' name='doc_folder_name' id='doc_folder_name' value='<%=doc_folder_name%>' size='32' maxlength='30' <%=Nameread_attribute%>><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG></TD>
						<TD colspan='2'>&nbsp;</TD>
					</TR>
					<TR><TD colspan='4'>&nbsp;</TD></TR>
					<TR>
						<TD class='label' width='20%' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></TD>
						<TD class='fields' width='30%'><SELECT name='doc_folder_type' id='doc_folder_type' onChange='CallPatPrd();' <%=more_attribute%>>&nbsp;
								<OPTION value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</OPTION>
								<OPTION value='P' <%=patient_attribute%>><fmt:message key="Common.patient.label" bundle="${common_labels}"/></OPTION> 
								<OPTION value='D' <%=period_attribute%>><fmt:message key="Common.Period.label" bundle="${common_labels}"/></OPTION>
							</SELECT><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG>
						</TD>
						<TD colspan='2'>&nbsp;</TD>
					</TR>
					<TR><TD colspan='4'>&nbsp;</TD></TR>
					<TR>
						<TD id='tab1' class='label' width='20%' ></TD>
						<TD id='tab2' class='label' width='30%' ></TD>
						<TD id='tab3' class='label' width='20%'></TD>
						<TD id='tab4' class='label' width='30%' ></TD>
					</TR>
					<TR><TD colspan='4'>&nbsp;</TD></TR>
					<TR>
						<TD class='label' width='20%' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
						<TD class='label' width='30%' ><INPUT type='checkbox' name='eff_status' id='eff_status' value='<%=effstatus%>' <%=chk_attribute%>></TD>
						<TD colspan='2'>&nbsp;</TD>
					</TR>
					<TR><TD colspan='4'>&nbsp;</TD></TR>
				</TABLE>
				<INPUT type='hidden' name='operation' id='operation' value='<%=mode%>'>
				<INPUT type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
				<INPUT type='hidden' name='chkParam' id='chkParam' value='Y'>
				<INPUT type='hidden' name='today' id='today' value='<%=today%>'>
			</FORM>
<%		
		if(patient_period_specific.equals("P"))
		{
%>
			<SCRIPT>
				document.getElementById("tab1").innerHTML=getLabel("Common.patientId.label","common");
				document.getElementById("tab2").innerHTML="<input type='text' name='patient_id' id='patient_id' value='<%=patient_id%>' onKeyPress='return CheckForSpecChars(event)' maxlength='<%=patient_id_max_length%>' size=\"=patient_id_max_length+2\" onBlur='ChangeUpperCase(this);'><input type='button' class='button' name='pat_search' id='pat_search' value='?' align=center onClick='patientSearch();'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
				document.getElementById("tab3").innerHTML="";
				document.getElementById("tab4").innerHTML="";
			</SCRIPT>			
<%
		}
		else if(patient_period_specific.equals("D"))
		{
%>
			<SCRIPT>
				document.getElementById("tab1").innerHTML=getLabel("Common.periodfrom.label","common");
				document.getElementById("tab2").innerHTML="<input type='text' id='date_from' name='from' id='from' value='<%=from_period%>' size='10' maxlength='10' tabIndex='3' value='' onBlur='validDateObj(this,\"DMY\",localeName);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('date_from');\"><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
				document.getElementById("tab3").innerHTML=getLabel("Common.periodto.label","common");
				document.getElementById("tab4").innerHTML="<input type='text' id='date_to' name='to' id='to' value='<%=to_period%>' size='10' maxlength='10'  tabIndex='4' onBlur='validDateObj(this,\"DMY\",localeName);'><input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('date_to');\"><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			</SCRIPT>
<%
		}

		}
		catch(Exception e)
		{
			out.println("Exception :"+e.toString());
		}
		finally
		{
			if(rst  != null) rst.close();
			if(stmt != null) stmt.close();

			ConnectionManager.returnConnection(conn,request);
		}
%>		
	</BODY>
</HTML>
	

