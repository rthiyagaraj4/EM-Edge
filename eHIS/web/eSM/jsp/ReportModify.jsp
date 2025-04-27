<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<title><fmt:message key="eSM.ReportDetails.label" bundle="${sm_labels}"/></title>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<% 
	Connection con=null;
	try{
		  request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);

	Statement stmt=con.createStatement();
	ResultSet rs=null;
	ResultSet rs2=null;

	String Module_Id = request.getParameter("Module_ID")==null ? "" : request.getParameter("Module_ID");
	String Report_Id = request.getParameter("Report_ID")==null ? "" : request.getParameter("Report_ID");
	String Report_Desc = "";
	String Report_Class ="" ;
	String Dflt_Report_Mode ="";
	String Gen_File_Yn = "";
	String Report_Tool_Bm ="";
	String Executable_Name_Bm ="";
	String Report_Tool_Ch ="";
	//String Executable_Name_Ch ="";
	String Dflt_File_Format_Bm ="";
	//String Dflt_File_Format_Ch ="";
	String Status_Change_Yn ="";
	String Transaction_Based_Yn=""; 
	String Internal_Request_Yn ="";
	String Facility_Based_Yn ="";
	String facility_Yn ="";
	String Report_Group_Id ="";	

	int counter = 0;
	
	rs = stmt.executeQuery("Select * from Sm_Report where Module_Id='" + Module_Id + "' and Report_Id='" + Report_Id + "'");	
	if(rs !=null) {
		if(rs.next()) {
			Report_Desc =rs.getString("Report_Desc")==null ? "" : rs.getString("Report_Desc");
			Report_Class = rs.getString("Report_Class")==null ? "" : rs.getString("Report_Class");
			Dflt_Report_Mode =rs.getString("Dflt_Report_Mode")==null ? "" : rs.getString("Dflt_Report_Mode");
			Gen_File_Yn =rs.getString("Gen_File_Yn")==null ? "N" : rs.getString("Gen_File_Yn");
			Report_Tool_Bm = rs.getString("Report_Tool_Bm")==null ? "" : rs.getString("Report_Tool_Bm");
			Executable_Name_Bm =rs.getString("Executable_Name_Bm")==null ? "" : rs.getString("Executable_Name_Bm");
			Report_Tool_Ch = rs.getString("Report_Tool_Ch")==null ? "" : rs.getString("Report_Tool_Ch");
			//Executable_Name_Ch =rs.getString("Executable_Name_Ch")==null ? "" : rs.getString("Executable_Name_Ch");
			Dflt_File_Format_Bm =rs.getString("Dflt_File_Format_Bm")==null ? "" : rs.getString("Dflt_File_Format_Bm");
			//Dflt_File_Format_Ch =rs.getString("Dflt_File_Format_Ch")==null ? "" : rs.getString("Dflt_File_Format_Ch");
			Status_Change_Yn =rs.getString("Status_Change_Yn")==null ? "" : rs.getString("Status_Change_Yn");
			Transaction_Based_Yn =rs.getString("Transaction_Based_Yn")==null ? "N" : rs.getString("Transaction_Based_Yn");
			Internal_Request_Yn =rs.getString("Internal_Request_Yn")==null ? "N" : rs.getString("Internal_Request_Yn");
			Facility_Based_Yn =rs.getString("Facility_Based_Yn")==null ? "N" : rs.getString("Facility_Based_Yn");
			Report_Group_Id =rs.getString("Report_Group_Id")==null ? "" : rs.getString("Report_Group_Id");
		}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	}	
	stmt = con.createStatement();
	rs2 = stmt.executeQuery("select count(*) from sm_report_for_fcy where module_id = '" + Module_Id + "' and report_id = '" + Report_Id + "'");
	if(rs2.next()) counter = rs2.getInt(1);
	if(rs2!=null)rs2.close();
	if(stmt!=null)stmt.close();
	
%>	

	<head>
		<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		
		<Script Language="JavaScript">
			function SelectOption(dfltvalue) {
				if(dfltvalue == "B") report_modify_form.Dflt_Report_Mode.item(1).selected = true;
				else if(dfltvalue == "C") report_modify_form.Dflt_Report_Mode.item(2).selected = true; 
				else report_modify_form.Dflt_Report_Mode.item(0).selected = true;
			}
			
			function CheckOption(dfltvalue,executablech,executablebm) {
				if(dfltvalue=="B" && executablech=="") SelectOption(dfltvalue);
				if(dfltvalue=="C" && executablebm=="") SelectOption(dfltvalue);
			}			
			
			function CheckFacilityBased() {
				if(report_modify_form.Facility_Based_Yn.checked==true) {
					report_modify_form.Report_Group.item(0).selected=true;
					report_modify_form.Report_Group.disabled=true;
					report_modify_form.man.height=0
					report_modify_form.man.width=0
					report_modify_form.man.src ='';
					report_modify_form.facility_based_yn.value='Y'; 					
				}else {
					report_modify_form.Report_Group.item(0).selected=true;
					report_modify_form.Report_Group.disabled=false;
					report_modify_form.man.height=10
					report_modify_form.man.width=10
					report_modify_form.man.src ='../../eCommon/images/mandatory.gif';
					report_modify_form.facility_based_yn.value='N';
				}				
			}
			function reportfacility(){
				
				var counter = document.report_modify_form.counter.value;
				var facility_Yn = document.report_modify_form.facility_Yn.value;
				if(counter>0){
					alert(getMessage("FCY_RPT_AVAILABLE",'SM'));
					if(facility_Yn == "Y")
						document.report_modify_form.Facility_Based_Yn.checked = true;
					else
						document.report_modify_form.Facility_Based_Yn.checked = false;
				}

				
			
			}

			function TransFacBased(val){
				if(val == 'Y'){
					//document.report_modify_form.Facility_Based_Yn.checked = true;
					document.report_modify_form.Facility_Based_Yn.disabled = true;
				}
			}
		</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  onLoad="javascript:FocusFirstElement()">
	<form name="report_modify_form" id="report_modify_form" action="../../servlet/eSM.ReportServlet" method="post" target="messageFrame">
	<center><br><br><br>
		  <table border="0" cellpadding="0" cellspacing="0" width="98%">
		  	<tr>
    				<td width="100%" class="BORDER">
    					<table border="0" cellpadding="0" cellspacing="0" width="100%">
    						<tr><td colspan="4">&nbsp;</td></tr>
    						<tr>
    							<td class="label" width="31%"><fmt:message key="Common.ModuleId.label" bundle="${common_labels}"/></td>
    							<td width="20%" class='QUERYDATA'>&nbsp;&nbsp;<input type="hidden" name="Module_Id" id="Module_Id" value="<%=Module_Id%>"  size="2" ><%=Module_Id%></td>
    							<td class="label" width="5%"><fmt:message key="Common.ReportID.label" bundle="${common_labels}"/></td>
    							<td class='QUERYDATA'>&nbsp;&nbsp;<input type="hidden" name="Report_Id" id="Report_Id" value="<%=Report_Id%>" size="30" ><%=Report_Id%></td>
    						</tr>
    						<tr><td class='BLANK_ROW_DISP' colspan='4'>&nbsp;</td></tr>
    						<tr>
    							<td class="label" ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
    							<td colspan="3" class='QUERYDATA'>&nbsp;&nbsp;<input type="hidden" name="Report_Desc" id="Report_Desc" value="<%=Report_Desc%>" size="65" maxlength=70 ><%=Report_Desc%></td>
    						</tr>
    						<tr><td class='BLANK_ROW_DISP' colspan='4'>&nbsp;</td></tr>
    						<tr>
    							<td class="label" ><fmt:message key="Common.Class.label" bundle="${common_labels}"/></td>
    							<td class='QUERYDATA'>&nbsp;&nbsp;<input type="hidden" name="Report_Class" id="Report_Class" value="<%=Report_Class%>" size="1" ><%=Report_Class%></td>
    							<td class="label" >&nbsp;</td>
    							<td >&nbsp;</td>
    						</tr>
    						<tr><td class='BLANK_ROW_DISP' colspan='4'>&nbsp;</td></tr>
    						<tr>
    							<td class="label" nowrap><fmt:message key="eSM.DefaultReportMode.label" bundle="${sm_labels}"/></td>
    							<td class='QUERYDATA'>&nbsp;<input type='hidden' name="Dflt_Report_Mode" id="Dflt_Report_Mode" value="<%=Dflt_Report_Mode%>">
    							
								<%if(Dflt_Report_Mode.equals("C")) out.println("Character");
    							else
    								if(Dflt_Report_Mode.equals("B")) out.println("Bitmapped");
    							%>
    							</td>
    							<td class="label" nowrap>&nbsp;&nbsp;<fmt:message key="eSM.GenerateFile.label" bundle="${sm_labels}"/></td>
    							<%
    								if(Gen_File_Yn.equals("Y"))
									{%>
										<td >&nbsp;<img src='../../eCommon/images/enabled.gif'></img></td>
									<%}
    								else										
									{%>
									<td >&nbsp;<img src='../../eCommon/images/disabled.gif'></img></td>
    								<%}%>	
    						</tr>
    						<tr><td colspan="4">&nbsp;</td></tr>
    					</table>
    				</td>
    			</tr>
    		</table><br>    		
    				<table border="0" cellpadding="0" cellspacing="0" width="98%">
		    			<tr>
		    				<td width="100%" class="BORDER">
		    					<table border="0" cellpadding="0" cellspacing="0" width="100%">		    						
		    						
		    						<th colspan=2 align="center"><fmt:message key="eSM.BitMappedReports.label" bundle="${sm_labels}"/></th>
		    						<th colspan=2 align="left">&nbsp;&nbsp;&nbsp;</th>		    						
		    						<tr>
		    							<td class="label" width="29.5%"><fmt:message key="eSM.Tool.label" bundle="${sm_labels}"/></td>
		    							<td class='QUERYDATA'  width='18%'>&nbsp;&nbsp;<input type="hidden" name="Report_Tool_Bm" id="Report_Tool_Bm" value="<%=Report_Tool_Bm%>" width='5%' size="2" readonly><%=Report_Tool_Bm%></td>
		    							<td class='QUERYDATA' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
											<td>&nbsp;</td>
		    						</tr>
		    						<tr><td class='BLANK_ROW_DISP' colspan='3'>&nbsp;</td></tr>
		    						<tr>
		    							<td  class="label" ><fmt:message key="eSM.Executable.label" bundle="${sm_labels}"/></td>
		    							<td  class='QUERYDATA'>&nbsp;&nbsp;<input type="hidden" name="Executable_Name_Bm" id="Executable_Name_Bm"  size="20" value="<%=Executable_Name_Bm%>" readonly><%=Executable_Name_Bm%></td>
		    							<td  class='QUERYDATA'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		    						</tr>
		    						<tr><td class='BLANK_ROW_DISP' colspan='3'>&nbsp;</td></tr>
		    						<tr>
		    							<td class="label" ><fmt:message key="eSM.DefaultFileFormat.label" bundle="${sm_labels}"/></td>		    							
									<%
			    						
										if(Report_Tool_Bm.equals(""))
											{}else {%>
											<td class='QUERYDATA'>&nbsp;
											<%
											if(Dflt_File_Format_Bm.equals(""))
											{}
											else{}
										if(Dflt_File_Format_Bm.equals("H")){
												
											out.println("HTML");
											}
											else{}
											if(Dflt_File_Format_Bm.equals("P")){
												out.println("PDF");
												
											}
											else{}
											if(Dflt_File_Format_Bm.equals("R")){
											out.println("RTF");
											}
											else{}
											if(Dflt_File_Format_Bm.equals("X")){
											out.println("XML");
												
											}			
											else{}		
											
										}	
			    						%>	
		    							</td>		    									    							
		    							<%
										if(Report_Tool_Ch.equals(""))
										{}else {%>
											<td class='QUERYDATA' >&nbsp;
											
										<%}	
		    							%>
		    							</td>
		    						</tr>
		    						<tr><td colspan="3">&nbsp;</td></tr>
		    					</table>
		    				</td>
		    			</tr>
		    		</table><br>   		
    		<table border="0" cellpadding="0" cellspacing="0" width="98%">
		  	<tr>
    				<td width="100%" class="BORDER">
    					<table border="0" cellpadding="0" cellspacing="0" width="100%">
    						<tr><td colspan="4">&nbsp;</td></tr>
    						<tr>
    							<td class="label" width="29.5%" nowrap><fmt:message key="eSM.StatusChangeAllowed.label" bundle="${sm_labels}"/></td>
    							<%
    								if(Status_Change_Yn.equals("Y")) {%>
    									<td width="18%"align='left' >&nbsp;&nbsp;<img src='../../eCommon/images/enabled.gif'></img></td>
    									<td class='label' nowrap ><fmt:message key="eSM.TransactionBased.label" bundle="${sm_labels}"/></td>
    									<%if(Transaction_Based_Yn.equals("Y"))
										{%>
											<td width="18%" >&nbsp;&nbsp;<img src='../../eCommon/images/enabled.gif'></img></td>
										<%}
    									else{%>
											<td width="18%" >&nbsp;&nbsp;<img src='../../eCommon/images/disabled.gif'></img></td>
										<%}
    								}	
    								else {%>
    									<td width="18%" >&nbsp;&nbsp;<img src='../../eCommon/images/enabled.gif'></img></td>
    									<td width="18%" class='label' nowrap ><fmt:message key="eSM.TransactionBased.label" bundle="${sm_labels}"/></td>
    									<%if(Transaction_Based_Yn.equals("Y")){%>
											<td >&nbsp;&nbsp;<img src='../../eCommon/images/enabled.gif'></img></td>
										<%}
    									else{%>
											<td >&nbsp;&nbsp;<img src='../../eCommon/images/disabled.gif'></img></td>
										<%}							
    								}	
    							%>    							
    						</tr>
    						<tr>
    							<td class="label" width="18%"><fmt:message key="eSM.InternalRequest.label" bundle="${sm_labels}"/></td>
    							<%
    								if(Internal_Request_Yn.equals("Y"))
									{%>
									<td >&nbsp;&nbsp;<img src='../../eCommon/images/enabled.gif'></img></td>
									<%}
    								else{%>
										<td >&nbsp;&nbsp;<img src='../../eCommon/images/disabled.gif'></img></td>
									<%}%>
    							<td class="label" width='16%'><fmt:message key="Common.FacilityBased.label" bundle="${common_labels}"/></td>
    							<%	
    								if(Facility_Based_Yn.equals("Y")){%>
											<td >&nbsp;&nbsp;<img src='../../eCommon/images/enabled.gif'></img></td>
									<%}
    								else {%>
										<td >&nbsp;&nbsp;<img src='../../eCommon/images/disabled.gif'></img></td>
									<%}%>
    						</tr>
    						<tr>
    							<td class="label" width="5%"><fmt:message key="eSM.ReportGroup.label" bundle="${sm_labels}"/></td>    							
    							<%	 stmt = con.createStatement();
									rs = stmt.executeQuery("Select Report_Group_Id,Short_Desc from Sm_Report_Group where eff_status='E' and ( trunc(eff_date_from) <= trunc(sysdate) and trunc(eff_date_to) >= trunc(sysdate) ) or ( trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null ) or ( trunc(eff_date_to) >= trunc(sysdate) and trunc(eff_date_from) is null) or ( eff_date_from is null and eff_date_to is null ) order by 1, 2" );
									StringBuffer str = new StringBuffer();
									if(rs!=null) {
										while(rs.next()){
											if(Report_Group_Id.equals(rs.getString("Report_Group_Id")))
												{ 
												 //String group_id=rs.getString("Report_Group_Id");  
												String desc=rs.getString("Short_Desc");%>
												
												<td class='QUERYDATA' READONLY nowrap>&nbsp;&nbsp;&nbsp;&nbsp;<%=desc%></td>
											<%}
											
											else 
												str.append("<Option value='" + rs.getString("Report_Group_Id") + "'>" + rs.getString("Short_Desc"));

										} 
									}
									if(rs!=null)rs.close();
									if(stmt!=null)stmt.close();
										
    								if(Facility_Based_Yn.equals("Y")){ 
										//out.println(str);%><input type='hidden' name='facility_based_yn' id='facility_based_yn' value='Y'>
									<%}else {%>
										<td nowrap  >&nbsp;&nbsp;
										
										<input type="hidden"
										name="facility_based_yn" id="facility_based_yn" value="N">
									<%}%>    							
								</td>
    							<td class="label" >&nbsp;</td>
    							<td >&nbsp;</td>
    						</tr>
    						<tr><td colspan="4">&nbsp;</td></tr>
    					</table>
    				</td>
    			<tr>
    		</table>	
	</center>
	<input type="hidden" name="gen_file_yn" id="gen_file_yn" value="N">
	<input type="hidden" name="status_change_yn" id="status_change_yn" value="N">
	<input type="hidden" name="transaction_based_yn" id="transaction_based_yn" value="N">
	<input type="hidden" name="internal_request_yn" id="internal_request_yn" value="N">	
	<input type="hidden" name="counter" id="counter" value="<%=counter%>">
	<input type="hidden" name="facility_Yn" id="facility_Yn" value="<%=facility_Yn%>">
	</form>


	<%
		if(rs != null) rs.close();
		if(stmt !=null) stmt.close();
		
	%>
	</body>
</html>
<%
}catch(Exception e){
		out.println(e);
		e.printStackTrace();
		}
finally { 
	ConnectionManager.returnConnection(con,request);
}		
%>

