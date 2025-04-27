<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='Javascript'></script>
<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 
<%  
	Connection connection			=	null;
	PreparedStatement pStatement	=	null;
	ResultSet		resultSet		=	null;
	PreparedStatement pstat			=	null;
	ResultSet		rs				=	null;

	StringBuffer sqlBuffer			=	new StringBuffer();
	String		function_name		=	""; 
	String		sub_function_name	=	"";
	String		field1				=	"";
	String		field2				=	"";
	String		field3				=	"";
	String		field4				=	"";
	String patient_id="";
	String caInstalled = "";
	String reg_flag = "";
	String called_from_ca = "";
	String calledFrom="";
	String eff_status ="";
	String selection_mode="";
	String func_source="";
	request.setCharacterEncoding("UTF-8");

	boolean submit_flag = true;
	boolean proceed = true;

	boolean submit_flag1 =true;
	try
	{
		function_name		=	checkForNull(request.getParameter("function_name"));
		sub_function_name	=	checkForNull(request.getParameter("sub_function_name"));
		field1				=	checkForNull(request.getParameter("field1"));
		field2				=	checkForNull(request.getParameter("field2"));
		field3				=	checkForNull(request.getParameter("field3"));
		field4				=	checkForNull(request.getParameter("field4"));
		func_source       = request.getParameter("func_source");
        func_source 		         = (func_source == null)?"":func_source; 
		session.putValue("queryString",func_source);
		connection			= ConnectionManager.getConnection(request);
		patient_id=checkForNull(request.getParameter("patient_id"));
        caInstalled=checkForNull(request.getParameter("caInstalled"));
		reg_flag=checkForNull(request.getParameter("reg_flag"));
        called_from_ca =checkForNull(request.getParameter("called_from_ca"));
        calledFrom =checkForNull(request.getParameter("calledFrom"));
		selection_mode=checkForNull(request.getParameter("selection_mode")); 
		if ((function_name.equals("ManagePatGITreatArea")) && (sub_function_name.equals("ValidBed")))
		{
			String treatment_area	=	field1;
			String bed				=	field2;
			String facility_id		=	field3;
			String clinic			=	field4;

			int countValue			= 0;
			if (sqlBuffer.length() > 0)
				sqlBuffer.delete(0, sqlBuffer.length());
			sqlBuffer.append("select count(*) countValue from ae_bed_for_trmt_area where clinic_code ");
			sqlBuffer.append("= ? and treatment_area_code = ? and bed_no = ? and facility_id = ? ");
			
			if (pStatement != null)	pStatement	= null;
			if (resultSet != null)	resultSet	= null;

			pStatement	= connection.prepareStatement(sqlBuffer.toString());
			
			pStatement.setString(1, clinic);
			pStatement.setString(2, treatment_area);
			pStatement.setString(3, bed);
			pStatement.setString(4, facility_id);

			resultSet	= pStatement.executeQuery();
			if ((resultSet != null) && (resultSet.next()))
				countValue	=	resultSet.getInt("countValue");
			if(pStatement!=null)pStatement.close();
            if(resultSet!=null)resultSet.close();
			if (countValue == 0)
			{
				proceed = false;
				if (caInstalled.equals("Y")){
					if(selection_mode.equals("triage")){%>
                    <script>
						alert(getMessage('INVALID_BED','AE'));
						top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	
					   	top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value="";
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						
						</script>
					<%}else{%>
					    <script>
						alert(getMessage('INVALID_BED','AE'));
						if (parent.frames[1].document.forms[0].bed_bay_no!=null){
							parent.frames[1].document.forms[0].bed_bay_no.value="";
							parent.frames[1].document.forms[0].bed_bay_no.select();
							parent.frames[1].document.forms[0].ok.disabled=true;

						}else{
							
						parent.frames[2].document.forms[0].bed_bay_no.select();
						parent.frames[2].document.forms[0].bed_bay_no.value="";
						parent.frames[2].document.forms[0].bed_bay_no.select();
						parent.frames[2].document.forms[0].ok.disabled=true;

						}
					</script>
					<%submit_flag = false;}
                }else if (selection_mode.equals("triage")){%>
                    <script>
						alert(getMessage('INVALID_BED','AE'));
						if (parent.frames[2].document.forms[0].bed_bay_no!=null){
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
					    parent.frames[2].document.forms[0].bed_bay_no.select();
					    parent.frames[2].document.forms[0].bed_bay_no.value="";
						parent.frames[2].document.forms[0].bed_bay_no.select();
						parent.frames[2].document.forms[0].bed_bay_no.select();
						parent.TriageButtonsFrame.SecondaryTriageButtonsForm.Record.disabled=false;
                        }
						else{
							
                        top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('INVALID_BED','AE'));
					   	top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value="";
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						
						}
					</script>
				<%submit_flag1= false;}else if (reg_flag.equals("Y")){ %>
					<script>
                        parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
						top.content.frames[1].frames[2].document.getElementById("tab1").scrollIntoView();
						alert(getMessage('INVALID_BED','AE'));
					    top.content.frames[1].frames[2].document.forms[0].bed_bay_no.select();
						top.content.frames[1].frames[2].document.forms[0].bed_bay_no.value="";
						top.content.frames[1].frames[2].document.forms[0].bed_bay_no.select();
						
					</script>
                   <%submit_flag= false;}else if (called_from_ca.equals("Y")){
                     %>
					<script>
                      top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('INVALID_BED','AE'));
					   	top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value="";
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
					
					    if (top.content.workAreaFrame.frames[2].document.forms[0].ok!=null){
						top.content.workAreaFrame.frames[2].document.forms[0].ok.disabled=true;
						}
					</script>
					<%}else{%>
					<script>
                        parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('INVALID_BED','AE'));
						if (parent.frames[1].document.forms[0].bed_bay_no!=null){
						parent.frames[1].document.forms[0].bed_bay_no.select();
					    parent.frames[1].document.forms[0].bed_bay_no.value="";
						parent.frames[1].document.forms[0].bed_bay_no.select();
						if (parent.frames[1].document.forms[0].ok!=null){
						parent.frames[1].document.forms[0].ok.disabled=true;
						 }
                        }else{
						parent.frames[2].document.forms[0].bed_bay_no.select();
						parent.frames[2].document.forms[0].bed_bay_no.value="";
						parent.frames[2].document.forms[0].bed_bay_no.select();
						if (parent.frames[0].document.forms[0].ok!=null){
						parent.frames[2].document.forms[0].ok.disabled=true;
						 }
						}
					</script>
				<%} 
			}
			if (countValue > 0)
			{
				int maxRecord = 0 ;
				String occupying_patient_id	 = "";
				String current_status		 = "";
				String occupying_bed_no		 = "";
				if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
				    sqlBuffer.append("select occupying_patient_id, current_status,bed_no,eff_status from ");
				    sqlBuffer.append("ae_bed_for_trmt_area where clinic_code = ? and treatment_area_code ");
				    sqlBuffer.append("= ? and bed_no = ? and facility_id = ? ");
				
				if (pStatement != null)	pStatement	= null;
				if (resultSet != null)	resultSet	= null;

				pStatement	= connection.prepareStatement(sqlBuffer.toString());

				pStatement.setString(1, clinic);
				pStatement.setString(2, treatment_area);
				pStatement.setString(3, bed);
				pStatement.setString(4, facility_id);

				resultSet	= pStatement.executeQuery();
				if ((resultSet != null) && (resultSet.next()))
				{
					occupying_patient_id = checkForNull(resultSet.getString("occupying_patient_id"));
					current_status		 = checkForNull(resultSet.getString("current_status"));
					occupying_bed_no =
                    checkForNull(resultSet.getString("bed_no"));
				eff_status =                    checkForNull(resultSet.getString("eff_status"));
				} 
				if(pStatement!=null)pStatement.close();
                if(resultSet!=null)resultSet.close();
				if (eff_status.equals("D"))
				{
                  if (caInstalled.equals("Y")){
					  if(selection_mode.equals("triage")){%>
                    <script>
				%>       
					    top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('INVALID_BED','AE'));
					   	top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value="";
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						</script>
					<%}else{%>
				    	<script>
						alert(getMessage('INVALID_BED','AE'));
						 if (parent.frames[1].document.forms[0].bed_bay_no!=null){
							
							parent.frames[1].document.forms[0].bed_bay_no.value="";
							parent.frames[1].document.forms[0].bed_bay_no.select();
						    parent.frames[1].document.forms[0].ok.disabled=true;
					}else{
							
						parent.frames[2].document.forms[0].bed_bay_no.select();
						parent.frames[2].document.forms[0].bed_bay_no.value="";
						parent.frames[2].document.forms[0].bed_bay_no.select();
						if (parent.frames[2].document.forms[0].ok!=null){
						parent.frames[2].document.forms[0].ok.disabled=true;
						}
					 }
					</script>
					
					 <%}
					}else if (reg_flag.equals("Y")){ %>
					<script>
						alert(getMessage('INVALID_BED','AE'));
						top.content.frames[1].frames[2].document.forms[0].bed_bay_no.select();
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					</script>
				    <%submit_flag= false;}else if (called_from_ca.equals("Y")){ %>
					<script>
                       top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('INVALID_BED','AE'));
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value="";
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
					if (top.content.workAreaFrame.frames[2].document.forms[0].ok!=null){	top.content.workAreaFrame.frames[2].document.forms[0].ok.disabled=true;
                    }
					</script>
					<%}else{%>
						<script>
                       parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('INVALID_BED','AE'));
						parent.frames[1].document.forms[0].bed_bay_no.select();
						parent.frames[1].document.forms[0].bed_bay_no.value="";
						parent.frames[1].document.forms[0].bed_bay_no.select();
                        parent.frames[1].document.forms[0].ok.disabled=true;
					</script>
				   <% } 
			    }
				if ((!occupying_patient_id.equals("")) && (!occupying_bed_no.equals("")))
				if ((!occupying_patient_id.equals(patient_id)) &&  (current_status.equals("O")) )
				{
				proceed = false;
                if (caInstalled.equals("Y")){
				 if(selection_mode.equals("triage")){%>
                    <script>
                      top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('BED_OCCUPIED','AE'));
					   	top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value="";
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						</script>
					<%}else{%>
					<script>
							
						alert(getMessage('BED_OCCUPIED','AE'));
						if (parent.frames[1].document.forms[0].bed_bay_no!=null){
							parent.frames[1].document.forms[0].bed_bay_no.value="";
							parent.frames[1].document.forms[0].bed_bay_no.select();
						    parent.frames[1].document.forms[0].ok.disabled=true;

						}else{
							
						parent.frames[2].document.forms[0].bed_bay_no.select();
						parent.frames[2].document.forms[0].bed_bay_no.value="";
						parent.frames[2].document.forms[0].bed_bay_no.select();
						if (parent.frames[2].document.forms[0].ok!=null){
						parent.frames[2].document.forms[0].ok.disabled=true;
						}
						}
					</script>
					<%}
						}else if (selection_mode.equals("triage")){%>
                    <script>
                        parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('BED_OCCUPIED','AE'));
						if (parent.frames[2].document.forms[0].bed_bay_no!=null){
						parent.frames[2].document.forms[0].bed_bay_no.select();
					    parent.frames[2].document.forms[0].bed_bay_no.value="";
						//parent.frames[2].document.forms[0].bed_bay_no.select();
						parent.TriageButtonsFrame.SecondaryTriageButtonsForm.Record.disabled=false;
                        }
					</script>
				<%submit_flag1= false;
					}else if (reg_flag.equals("Y")){ %>
					<script>
						alert(getMessage('BED_OCCUPIED','AE'));						top.content.frames[1].frames[2].document.forms[0].bed_bay_no.select();
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					</script>
				    <%submit_flag= false;}else if (called_from_ca.equals("Y")){ %>
					<script>
					  top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('BED_OCCUPIED','AE'));						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value="";
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
					 if (top.content.workAreaFrame.frames[2].document.forms[0].ok!=null){
						top.content.workAreaFrame.frames[2].document.forms[0].ok.disabled=true;
					 }
					</script>
					<%}else{%>
						<script>
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('BED_OCCUPIED','AE'));						if (parent.frames[1].document.forms[0].bed_bay_no!=null){
							
						parent.frames[1].document.forms[0].bed_bay_no.value="";
						parent.frames[1].document.forms[0].bed_bay_no.select();
                        parent.frames[1].document.forms[0].ok.disabled=true;
						}else if(parent.frames[2].document.forms[0].bed_bay_no!=null) {
							
						parent.frames[2].document.forms[0].bed_bay_no.value="";
						parent.frames[2].document.forms[0].bed_bay_no.select();
                        parent.frames[0].document.forms[0].ok.disabled=true;
						}

					</script>
				   <% }
				}
				if (current_status.equals("R"))
				{
                pstat  = connection.prepareStatement("select (1) from ae_bed_for_trmt_area where occupied_until_date_time >= sysdate and clinic_code = ? and treatment_area_code = ? and bed_no = ? and facility_id = ?");
					pstat.setString(1, clinic);
				    pstat.setString(2, treatment_area);
				    pstat.setString(3, bed);
				    pstat.setString(4, facility_id);
                    rs = pstat.executeQuery();
                   if (rs!=null)
                   {
                    while (rs.next())
                    {
                     maxRecord = rs.getInt(1);
                    }
				   }
				    if(rs != null) rs.close(); 
	            	if(pstat != null) pstat.close();
					if (!(maxRecord==0))
					{
					proceed = false;
		         	if (caInstalled.equals("Y")){
						if(selection_mode.equals("triage")){%>
                       <script>
							
							top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('BED_RESERVED','AE'));	
					   	top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value="";
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						</script>
					<%}else{%>
					<script>
							
						alert(getMessage('BED_RESERVED','AE'));	
                        if (parent.frames[1].document.forms[0].bed_bay_no!=null){
							
							parent.frames[1].document.forms[0].bed_bay_no.value="";
							parent.frames[1].document.forms[0].bed_bay_no.select();
                            parent.frames[1].document.forms[0].ok.disabled=true;
						}else{
							
						parent.frames[2].document.forms[0].bed_bay_no.select();
						parent.frames[2].document.forms[0].bed_bay_no.value="";
						parent.frames[2].document.forms[0].bed_bay_no.select();
						if (parent.frames[2].document.forms[0].ok!=null){
                        parent.frames[2].document.forms[0].ok.disabled=true;
						}
						}
					</script>
					<% }
						}else if (selection_mode.equals("triage")){%>
                    <script>
                       parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('BED_RESERVED','AE'));	
						if (parent.frames[2].document.forms[0].bed_bay_no!=null){
					    parent.frames[2].document.forms[0].bed_bay_no.select();
					    parent.frames[2].document.forms[0].bed_bay_no.value="";
						parent.frames[2].document.forms[0].bed_bay_no.select();
                        }
					</script>
				<%submit_flag1= false;
				 }else if (reg_flag.equals("Y")){ %>
					<script>
					
						alert(getMessage('BED_RESERVED','AE'));							top.content.frames[1].frames[2].document.forms[0].bed_bay_no.select();
						parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
					</script>
				    <%submit_flag= false;}else if (called_from_ca.equals("Y")){ %>
					<script>
						top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('BED_RESERVED','AE'));							top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.value="";
						top.content.workAreaFrame.frames[2].document.forms[0].bed_bay_no.select();
						if (top.content.workAreaFrame.frames[2].document.forms[0].ok!=null){
                        top.content.workAreaFrame.frames[2].document.forms[0].ok.disabled=true;
                        }
					</script>
					<%}else{%>
						<script>
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
						alert(getMessage('BED_RESERVED','AE'));	
						if (parent.frames[1].document.forms[0].bed_bay_no!=null){
							
						parent.frames[1].document.forms[0].bed_bay_no.value="";
						parent.frames[1].document.forms[0].bed_bay_no.select();
                        parent.frames[1].document.forms[0].ok.disabled=true;
						}else if(parent.frames[2].document.forms[0].bed_bay_no!=null) {
							
						parent.frames[2].document.forms[0].bed_bay_no.value="";
						parent.frames[2].document.forms[0].bed_bay_no.select();
                        parent.frames[2].document.forms[0].ok.disabled=true;
						}
					</script>
				   <% } 
				    }
				}

                if (called_from_ca.equals("Y")){ %>
					<script>
                     top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
					</script>
				<%}else if ((reg_flag.equals("")) && (caInstalled.equals("")) ){ %>{%>
                    <script>
                      parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
					</script>
		<%	}			
		  }
		}
		
		if ((submit_flag) && reg_flag.equals("Y")){%>
			<script>
				parent.f_query_add_mod.patientDetailsFrame.document.forms[0].action='../../servlet/eAE.AERegisterAttnServlet';
				parent.f_query_add_mod.patientDetailsFrame.document.forms[0].target='messageFrame';
			     parent.f_query_add_mod.patientDetailsFrame.document.forms[0].submit();
		    </script>
       <%
		}
        else if ((submit_flag) && caInstalled.equals("Y") && (selection_mode.equals("triage")) && (proceed) ){%>
        <script>
						top.content.workAreaFrame.frames[2].document.forms[0].submit();
		</script>
		<%}
		else if ((submit_flag) && caInstalled.equals("Y") && (proceed)){%>
         <script>
         async function toSubmit(){
						 var proceed1 = true; 
		  if (parent.frames[1].document.getElementById('practitioner_id')!=null){
		  /*var practitioner_id		=	parent.frames[1].document.forms[0].practitioner_id.value;
	         if(practitioner_id=='' || practitioner_id=='*ALL')
			 {
				 
			  parent.frames[1].document.forms[0].practitioner_desc.select();
			  proceed1 = false;
			 }*/
		 if(proceed1){ 
			 if(await parent.funQry1())
	         {
						parent.frames[1].document.forms[0].target = "messageFrame";
						parent.frames[1].document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";
						parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;
						parent.frames[1].document.forms[0].submit();
						parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;
			 }
		 }
		}else{
					//var dialogFrame = parent.document.getElementById('dialog-body').contentWindow
					var dialogFrame=top.window.document.getElementById('dialog-body').contentWindow;
					dialogFrame.frames[1].document.forms[0].treatment_area_code.disabled = false;
					dialogFrame.frames[1].document.forms[0].priority_value.disabled = false;
					dialogFrame.frames[1].document.forms[0].assign_tmt_area_time.disabled = false;
					
					/*top.content.workAreaFrame.document.getElementById("treatment_area_code").disabled = false;
					top.content.workAreaFrame.document.getElementById("priority_value").disabled=false;
					top.content.workAreaFrame.document.getElementById('assign_tmt_area_time').disabled=false;*/
					
					if(top.messageframe==null){
					dialogFrame.frames[1].document.forms[0].target = "messageFrame";
					//top.content.workAreaFrame.document.forms[0].target = "messageFrame";
					}
					else {
					dialogFrame.frames[1].document.forms[0].target = "messageframe";
					//top.content.workAreaFrame.document.forms[0].target = "messageframe";
					}
					/*var practitioner_id		=	top.content.workAreaFrame.document.forms[0].practitioner_id.value;

						if(practitioner_id=='' || practitioner_id=='*ALL')
						 {
							alert('1.....');
						  alert(getAEMessage("AE_PRACTITIONER_BLANK"));
						  top.content.workAreaFrame.document.forms[0].practitioner_desc.select();
						  proceed1 = false;
						 }*/
					 if(proceed1){
						
						var check = await dialogFrame.funQry1();
						 if(check)
							{
					        dialogFrame.frames[1].document.forms[0].method = "POST";

							dialogFrame.frames[1].document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";

							dialogFrame.frames[1].document.forms[0].submit();

							dialogFrame.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;

							/*top.content.workAreaFrame.document.forms[0].method = "POST";

							top.content.workAreaFrame.document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";

							top.content.workAreaFrame.document.forms[0].submit();

							top.content.workAreaFrame.document.forms[0].assign_tmt_area_time.disabled=true;*/
							}
		          }
			 }
		}
         toSubmit();
		 </script>
		<%
		}
		else if ((submit_flag) && selection_mode.equals("AssignTreatmentArea")){%>
         <script>
         async function toSubmit(){
        	 
        	var ret = await parent.funQry1();
			 if(ret)
				{
						parent.frames[1].document.forms[0].target = "messageFrame";
					    parent.frames[1].document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";
					    parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;
					    parent.frames[1].document.forms[0].submit();
					    parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;
				}}
         toSubmit();
		 </script>
		<%
		}
		 else if ((submit_flag) && selection_mode.equals("ReassignTreatmentArea")){%>
         <script>
		 if(parent.funQry1())
			{
			 	parent.frames[1].document.forms[0].target = "messageFrame";
				parent.frames[1].document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";
				parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;
				parent.frames[1].document.forms[0].submit();
				parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;
			}
		 </script>
		<%
		}
		else if ((submit_flag) && selection_mode.equals("AssignReassignPractitioner")){%>
		<script>
		async function toSubmit(){
				var practitioner_id		=	parent.frames[1].document.getElementById('practitioner_id').value;
		 var proceed1 = true;
         if(practitioner_id=='' || practitioner_id=='*ALL')
			 {
			  alert(getMessage("AE_PRACTITIONER_BLANK",'AE'));
			  parent.frames[1].document.forms[0].practitioner_desc.select();
			  proceed1 = false;
			 }
		 if(proceed1){
			if(await parent.funQry1())
			{

			 	 parent.frames[1].document.forms[0].target = "messageFrame";
				 parent.frames[1].document.forms[0].treatment_area_code.disabled = false;
				 parent.frames[1].document.forms[0].priority_value.disabled=false;
				 parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;
				 parent.frames[1].document.forms[0].method = "POST";
				 parent.frames[1].document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";
			     parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;
				 parent.frames[1].document.forms[0].submit();
			     parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;
			}
		 }
		}
		toSubmit();
		</script>
		<%}
        else if ((submit_flag1) && (selection_mode.equals("triage"))){
			 if (caInstalled.equals("Y") && (proceed)){%>
			 <script>
				// top.content.workAreaFrame.document.forms[0].submit();
				 top.content.frames[2].frames[2].document.forms[0].submit();
			  </script>
			 <%}else{%>
			<script>
				  parent.frames[2].document.forms[0].submit();
		    </script>
		<%}
		}
        else if(( proceed) && calledFrom.equals("bedValidY"))
		{
			 if (caInstalled.equals("Y") && (!(selection_mode.equals("triage")))){
		     %>
                <script>
               async function toSubmit(){
				    var proceed1 = true;
                    if (parent.frames[1].document.forms[0].treatment_area_code !=null){
					parent.frames[1].document.forms[0].treatment_area_code.disabled = false;
					parent.frames[1].document.forms[0].priority_value.disabled=false;
					parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;

					if(top.messageframe==null){
					parent.frames[1].document.forms[0].target = "messageFrame";}
					else {
						
					parent.frames[1].document.forms[0].target = "messageframe";
					}
                    var practitioner_id		=	parent.frames[1].document.getElementById('practitioner_id').value;

					if(practitioner_id=='' || practitioner_id=='*ALL')
	                 {
			          alert(getMessage("AE_PRACTITIONER_BLANK",'AE'));
                      parent.frames[1].document.forms[0].practitioner_desc.select();
					  proceed1 = false;
		             }
					 if(proceed1){
					   if(await parent.funQry1())
			            {

							parent.frames[1].document.forms[0].method = "POST";
						    parent.frames[1].document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";

							parent.frames[1].document.forms[0].submit();

							parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;
						}
					  }
					}else{
					parent.frames[2].document.forms[0].treatment_area_code.disabled = false;
					parent.frames[2].document.forms[0].priority_value.disabled=false;
					parent.frames[2].document.forms[0].assign_tmt_area_time.disabled=false;

					if(top.messageframe==null){
					parent.frames[2].document.forms[0].target = "messageFrame";}
					else {
					parent.frames[2].document.forms[0].target = "messageframe";
					}
                    var practitioner_id		=	parent.frames[2].document.getElementById('practitioner_id').value;
				
						if(practitioner_id=='' || practitioner_id=='*ALL')
						 {
						  alert(getMessage("AE_PRACTITIONER_BLANK",'AE'));
						  parent.frames[2].document.forms[0].practitioner_desc.select();
						  proceed1= false;
						 }
					 if(proceed1){
					  if(await parent.funQry1())
			             {
						    parent.frames[2].document.forms[0].method = "POST";

							//cument.forms[0].ok.disabled = true;
							parent.frames[2].document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";

							parent.frames[2].document.forms[0].submit();

							parent.frames[2].document.forms[0].assign_tmt_area_time.disabled=true;
						 }
					  }
					}
               }
               toSubmit();
					</script>
				<%}else if (called_from_ca.equals("Y") ){ %>
                  	<script>
                  	async function toSubmit(){
					var proceed1=true;
				 	top.content.workAreaFrame.frames[2].document.forms[0].treatment_area_code.disabled = false;
					top.content.workAreaFrame.frames[2].document.forms[0].priority_value.disabled=false;
					top.content.workAreaFrame.frames[2].document.forms[0].assign_tmt_area_time.disabled=false;

					if(top.messageframe==null){
					top.content.workAreaFrame.frames[2].document.forms[0].target = "messageFrame";}
					else {
					top.content.workAreaFrame.frames[2].document.forms[0].target = "messageframe";
					}
                    var practitioner_id		=	top.content.workAreaFrame.frames[2].document.getElementById('practitioner_id').value;

						if(practitioner_id=='' || practitioner_id=='*ALL')
						 {
						  alert(getMessage("AE_PRACTITIONER_BLANK",'AE'));
						  top.content.workAreaFrame.frames[2].document.forms[0].practitioner_desc.select();
						  proceed1 = false;
						 }
					 if(proceed1){
					   if(await parent.funQry1())
			             {
						    top.content.workAreaFrame.frames[2].document.forms[0].method = "POST";

							//cument.forms[0].ok.disabled = true;
							top.content.workAreaFrame.frames[2].document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";

							top.content.workAreaFrame.frames[2].document.forms[0].submit();

							top.content.workAreaFrame.frames[2].document.forms[0].assign_tmt_area_time.disabled=true;
						 }
					 }
                  	}
                  	toSubmit();
				</script>
                 <%}else if (!submit_flag1){	
           %>
					<script>
					async function toSubmit(){
			        var proceed1=true;
					parent.frames[1].document.forms[0].treatment_area_code.disabled = false;
					parent.frames[1].document.forms[0].priority_value.disabled=false;
					parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=false;
					if(top.messageframe==null){
					parent.frames[1].document.forms[0].target = "messageFrame";}
					else {
					parent.frames[1].document.forms[0].target = "messageframe";
					}
                    var practitioner_id		=	parent.frames[1].document.getElementById('practitioner_id')value;
				<%if (selection_mode.equals("AssignReassignPractitioner")){%>
						if(practitioner_id=='' || practitioner_id=='*ALL')
						 {
						  alert(getMessage("AE_PRACTITIONER_BLANK",'AE'));
						  parent.frames[1].document.forms[0].practitioner_desc.select();
						  proceed1 = false;
						 }
					 <%}%>
					 if(proceed1){
						 if(await parent.funQry1())
			             {
						    parent.frames[1].document.forms[0].method = "POST";
							parent.frames[1].document.forms[0].action = "../../servlet/eAE.AEManagePatientServlet";
							parent.frames[1].document.forms[0].submit();
							parent.frames[1].document.forms[0].assign_tmt_area_time.disabled=true;
						 }
					 }
					}
					toSubmit();
				</script>
	            <%}
				if (sqlBuffer.length() > 0)
				sqlBuffer.delete(0, sqlBuffer.length());
		}
	}catch(Exception exception)
	{
		exception.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(connection, request);
	}
%>
<!-- <script>
parent.frames[1].location.href="../../eCommon/jsp/error.jsp?err_num=";</script> -->
</html>
<%!
/** To Handle java.lang.NullPointerException. **/

	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString ); 
	}
%> 

