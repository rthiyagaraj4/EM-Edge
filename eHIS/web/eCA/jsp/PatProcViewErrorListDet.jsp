<!DOCTYPE html>
<% 
/*
-----------------------------------------------------------------------
Date       		Edit History     	Name        		Description
-----------------------------------------------------------------------

10/03/2022        36285            Hariharan k       	 MMs-DM-CRF-0221.v1.0(003)
-----------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
	<head>
	<title> <fmt:message key="eCA.DetailsofErrorRemarks.label" bundle="${ca_labels}"/> </title>
<% 	request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>

	<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="FocusFirstElement()">
<%
				Connection con	=null;
					//String locale=(String)session.getValue( "LOCALE" ) ;
					java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
					String locale = (String) p.getProperty("LOCALE");
					String patient_id = request.getParameter("patient_id");
					String facility_id		= (String) session.getValue("facility_id");
					String proCode=request.getParameter("proCode");
					String srl_no=request.getParameter("srl_no");
					String proc_code                      =""; 
					String proc_narration              ="";    
					String hpi                            =""; 
					String proc_summary                   =""; 
					String findings                       =""; 
					String impression                     =""; 
					String disposition                    =""; 
					String start_datetime       ="";  
					String end_datetime             ="";       
					String ass_practitioner1         ="";      
					String ass_practitioner2          ="";     
					String ass_practitioner3         ="";     
					String anaesthetist1           ="";        
					String anaesthetist2              ="";     
					String anaesthetist3              ="";     
					String anaesthesia_code      ="";          
					String anaesthesia_detail       ="";       
					String indication                   ="";   
					String monitoring              ="";        
					String events                        ="";  
					String post_proc_std_orders   ="";         
					String specimen_sent                 ="";  
					String error_marked_by_id           ="";   
					String error_marked_date             ="";  
					String error_remarks                 ="";  
					String scrub_nurse                  =""; 
					String laterality_ind = "";
					String locn_desc = "";
					String classifition_type = "";//36285
					PreparedStatement stmt=null;
					ResultSet  rs	=null;
				try{

					//String query="select  facility_id, encounter_id, srl_no,  a.practitioner_id practitioner_id,  patient_id,  proc_code,   proc_date,   record_type,    cause_indicator,  proc_code_scheme, proc_narration,   hpi,    proc_summary, findings,    impression,  disposition, patient_class,    a.added_by_id, a.added_date,     a.added_at_ws_no,   a.added_facility_id,    a.modified_by_id,   a.modified_date,    a.modified_at_ws_no,    a.modified_facility_id,      order_id,    order_line_num, to_char(start_datetime,'dd/mm/yyyy hh24:mi') start_datetime, to_char(end_datetime,'dd/mm/yyyy hh24:mi') end_datetime,    (select b.practitioner_name from am_practitioner b where b.practitioner_id=ass_practitioner1)    ass_practitioner1, (select b.practitioner_name from am_practitioner b where b.practitioner_id=ass_practitioner2) ass_practitioner2, (select b.practitioner_name from am_practitioner b where b.practitioner_id=anaesthetist1)   anaesthetist1,(select b.practitioner_name from am_practitioner b where b.practitioner_id=anaesthetist2)    anaesthetist2, (select b.practitioner_name from am_practitioner b where b.practitioner_id=anaesthetist3)   anaesthetist3,  ( Select long_desc from am_anaesthesia  where anaesthesia_code = a.anaesthesia_code )   anaesthesia_code, anaesthesia_detail,   indication,  monitoring,  events,      post_proc_std_orders,      specimen_sent,   c.APPL_USER_NAME  error_marked_by_id,   to_char(error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date,    error_remarks,    error_yn, (select b.practitioner_name from am_practitioner b where b.practitioner_id=scrub_nurse) scrub_nurse ,practitioner_name from	pr_encounter_procedure a,am_practitioner b,sm_appl_user c where  ERROR_YN='Y' and patient_id=? and proc_code=?  and SRL_NO =? and b.practitioner_id=a.practitioner_id and c.appl_user_id=a.ERROR_MARKED_BY_ID ";
					//String query="select  facility_id, encounter_id, srl_no,  a.practitioner_id practitioner_id,  patient_id,  proc_code,   proc_date,   record_type,    cause_indicator,  proc_code_scheme, proc_narration,   hpi,    proc_summary, findings,    impression,  disposition, patient_class,    a.added_by_id, a.added_date,     a.added_at_ws_no,   a.added_facility_id,    a.modified_by_id,   a.modified_date,    a.modified_at_ws_no,    a.modified_facility_id,      order_id,    order_line_num, to_char(start_datetime,'dd/mm/yyyy hh24:mi') start_datetime, to_char(end_datetime,'dd/mm/yyyy hh24:mi') end_datetime, AM_GET_DESC.AM_PRACTITIONER(ass_practitioner1,?,'1') ass_practitioner1,AM_GET_DESC.AM_PRACTITIONER(ass_practitioner2,?,'1') ass_practitioner2, AM_GET_DESC.AM_PRACTITIONER(ass_practitioner3,?,'1') ass_practitioner3, AM_GET_DESC.AM_PRACTITIONER(anaesthetist1,?,'1')  anaesthetist1,AM_GET_DESC.AM_PRACTITIONER(anaesthetist2,?,'1')  anaesthetist2, AM_GET_DESC.AM_PRACTITIONER(anaesthetist3,?,'1')  anaesthetist3,  AM_GET_DESC.AM_ANAESTHESIA(a.anaesthesia_code,?,'1') anaesthesia_code, anaesthesia_detail,   indication,  monitoring,  events,      post_proc_std_orders,      specimen_sent,SM_GET_DESC.SM_APPL_USER( a.ERROR_MARKED_BY_ID,?,'1') error_marked_by_id,  to_char(error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date,    error_remarks,    error_yn, AM_GET_DESC.AM_PRACTITIONER(scrub_nurse,?,'1') scrub_nurse,AM_GET_DESC.AM_PRACTITIONER(A.practitioner_id,?,'1') practitioner_name, proc_perf_locn_code, OP_GET_DESC.OP_CLINIC(?,proc_perf_locn_code,?,'2') locn_desc, laterality_ind from pr_encounter_procedure a where  ERROR_YN='Y' and patient_id=? and proc_code=?  and SRL_NO =?";
					String query="select  facility_id, encounter_id, srl_no,  a.practitioner_id practitioner_id,  patient_id,  proc_code,   proc_date,   record_type,    cause_indicator,  proc_code_scheme, proc_narration,   hpi,    proc_summary, findings,    impression,  disposition, patient_class,    a.added_by_id, a.added_date,     a.added_at_ws_no,   a.added_facility_id,    a.modified_by_id,   a.modified_date,    a.modified_at_ws_no,    a.modified_facility_id,      order_id,    order_line_num, to_char(start_datetime,'dd/mm/yyyy hh24:mi') start_datetime, to_char(end_datetime,'dd/mm/yyyy hh24:mi') end_datetime, AM_GET_DESC.AM_PRACTITIONER(ass_practitioner1,?,'1') ass_practitioner1,AM_GET_DESC.AM_PRACTITIONER(ass_practitioner2,?,'1') ass_practitioner2, AM_GET_DESC.AM_PRACTITIONER(ass_practitioner3,?,'1') ass_practitioner3, AM_GET_DESC.AM_PRACTITIONER(anaesthetist1,?,'1')  anaesthetist1,AM_GET_DESC.AM_PRACTITIONER(anaesthetist2,?,'1')  anaesthetist2, AM_GET_DESC.AM_PRACTITIONER(anaesthetist3,?,'1')  anaesthetist3,  AM_GET_DESC.AM_ANAESTHESIA(a.anaesthesia_code,?,'1') anaesthesia_code, anaesthesia_detail,   indication,  monitoring,  events,      post_proc_std_orders,      specimen_sent,SM_GET_DESC.SM_APPL_USER( a.ERROR_MARKED_BY_ID,?,'1') error_marked_by_id,  to_char(error_marked_date,'dd/mm/yyyy hh24:mi') error_marked_date,    error_remarks,    error_yn, AM_GET_DESC.AM_PRACTITIONER(scrub_nurse,?,'1') scrub_nurse,AM_GET_DESC.AM_PRACTITIONER(A.practitioner_id,?,'1') practitioner_name, proc_perf_locn_code, OP_GET_DESC.OP_CLINIC(?,proc_perf_locn_code,?,'2') locn_desc, laterality_ind,classifition_type from pr_encounter_procedure a where  ERROR_YN='Y' and patient_id=? and proc_code=?  and SRL_NO =?";//36285
					con=ConnectionManager.getConnection(request);
					stmt=con.prepareStatement(query);
					stmt.setString(1,locale);
					stmt.setString(2,locale);
					stmt.setString(3,locale);
					stmt.setString(4,locale);
					stmt.setString(5,locale);
					stmt.setString(6,locale);
					stmt.setString(7,locale);
					stmt.setString(8,locale);
					stmt.setString(9,locale);
					stmt.setString(10,locale);
					stmt.setString(11,facility_id);
					stmt.setString(12,locale);
					stmt.setString(13,patient_id);		
					stmt.setString(14,proCode);
					stmt.setString(15,srl_no);
					rs=stmt.executeQuery();
	%>

		<%
			while (rs.next()){
									proc_code		=rs.getString("proc_code")==null?" ":rs.getString("proc_code");                     
									proc_narration		=rs.getString("proc_narration")==null?" ":rs.getString("proc_narration");              
									hpi	=rs.getString("hpi")==null?" ":rs.getString("hpi");                                   
									proc_summary	=rs.getString("proc_summary")==null?" ":rs.getString("proc_summary");             
									findings	=rs.getString("findings")==null?" ":rs.getString("findings");                          
									impression	=rs.getString("impression")==null?" ":rs.getString("impression");                    
									disposition	=rs.getString("disposition")==null?" ":rs.getString("disposition");                     
									      
									start_datetime	=rs.getString("start_datetime")==null?" ":rs.getString("start_datetime"); 
									start_datetime = com.ehis.util.DateUtils.convertDate(start_datetime,"DMYHM","en",locale);
									end_datetime=rs.getString("end_datetime")==null?" ":rs.getString("end_datetime"); 
									end_datetime = com.ehis.util.DateUtils.convertDate(end_datetime,"DMYHM","en",locale);
									ass_practitioner1=rs.getString("ass_practitioner1")==null?" ":rs.getString("ass_practitioner1");         
									ass_practitioner2=rs.getString("ass_practitioner2")==null?" ":rs.getString("ass_practitioner2");         
									ass_practitioner3=rs.getString("ass_practitioner3")==null?" ":rs.getString("ass_practitioner3");         
									anaesthetist1=rs.getString("anaesthetist1")==null?" ":rs.getString("anaesthetist1");                
									anaesthetist2=rs.getString("anaesthetist2")==null?" ":rs.getString("anaesthetist2");                
									anaesthetist3=rs.getString("anaesthetist3")==null?" ":rs.getString("anaesthetist3");                
									anaesthesia_code=rs.getString("anaesthesia_code")==null?" ":rs.getString("anaesthesia_code");       
									anaesthesia_detail=rs.getString("anaesthesia_detail")==null?" ":rs.getString("anaesthesia_detail");      
									indication=rs.getString("indication")==null?" ":rs.getString("indication");                       
									monitoring=rs.getString("monitoring")==null?" ":rs.getString("monitoring");                     
									events=rs.getString("events")==null?" ":rs.getString("events");                             
									post_proc_std_orders=rs.getString("post_proc_std_orders")==null?" ":rs.getString("post_proc_std_orders"); 
									specimen_sent=rs.getString("specimen_sent")==null?" ":rs.getString("specimen_sent");            
									error_marked_by_id	=rs.getString("error_marked_by_id")==null?" ":rs.getString("error_marked_by_id");   
									error_marked_date	=rs.getString("error_marked_date")==null?" ":rs.getString("error_marked_date");
									error_marked_date = com.ehis.util.DateUtils.convertDate(error_marked_date,"DMYHM","en",locale);
									error_remarks=rs.getString("error_remarks")==null?" ":rs.getString("error_remarks");              
									scrub_nurse	=rs.getString("scrub_nurse")==null?" ":rs.getString("scrub_nurse");                  
									laterality_ind = rs.getString("laterality_ind")==null?"":rs.getString("laterality_ind");
									locn_desc = rs.getString("locn_desc")==null?" ":rs.getString("locn_desc");
									classifition_type = rs.getString("classifition_type")==null?" ":rs.getString("classifition_type");//36285
					}
					if(laterality_ind.equals("L"))
						laterality_ind = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
					else if(laterality_ind.equals("R"))
						laterality_ind = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Right.label","ca_labels");
					else if(laterality_ind.equals("B"))
						laterality_ind = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
					else if(laterality_ind.equals("N"))
						laterality_ind = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
					else
						laterality_ind = " ";
%>
<form>
<table name=tab1 width='100%' height='90%' align='center' border=1 rules=none cellpadding='3' cellspacing=1>
	<tr><td class='columnheader' colspan=2><font size=2><b> <fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>   <fmt:message key="Common.details.label" bundle="${common_labels}"/></b></font></td></tr>
<tr><td class=label  width='20%'><b><fmt:message key="Common.ProcedureCode.label" bundle="${common_labels}"/> </td><td  width='80%'><%=proc_code%></td> </tr>
<tr><td class=label  ><b><fmt:message key="eCA.ProcNarration.label" bundle="${ca_labels}"/></b></td><td ><%=proc_narration%></td></tr>
<tr><td class=label  ><b><fmt:message key="eCA.ClassificationType.label" bundle="${ca_labels}"/></b></td><td ><%=classifition_type%></td></tr><!-- 36285 -->
<tr><td class=label  ><b><fmt:message key="eCA.Laterality.label" bundle="${ca_labels}"/></b></td><td ><%=laterality_ind%></td></tr>
<tr><td class=label><b><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></b></td><td><%=start_datetime%></td>
<tr><td class=label><b><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td><td ><%=end_datetime%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></td><td ><%=locn_desc%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b>	</td><td ><%=ass_practitioner1%><% if (!ass_practitioner2.equals(" ")){ %><b>,</b><%}%><%=ass_practitioner2%><% if (!ass_practitioner3.equals(" ")){ %><b>,</b><%}%><%=ass_practitioner3%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/></b></td><td ><%=anaesthetist1%> <% if (!anaesthetist2.equals(" ")){ %> <b>,</b><%}%><%=anaesthetist2%><% if (!anaesthetist3.equals(" ")){ %><b>,</b><%}%><%=anaesthetist3%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.ScrubNurse.label" bundle="${common_labels}"/></b></td><td ><%=scrub_nurse%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.AnaesthesiaCode.label" bundle="${common_labels}"/></b></td><td ><%=anaesthesia_code%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.AnaesthesiaDetails.label" bundle="${common_labels}"/></b></td><td ><%=anaesthesia_detail%></td></tr>
<tr><td class=label  ><b><fmt:message key="eCA.Indication.label" bundle="${ca_labels}"/></b></td><td ><%=indication%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.Monitoring.label" bundle="${common_labels}"/></b></td><td ><%=monitoring%></td></tr>
<tr><td class=label  ><b>HPl</b>&nbsp;</td><td  ><%=hpi%></td></tr>
<tr><td class=label  ><b><fmt:message key="eCA.ProcedureSummary.label" bundle="${ca_labels}"/></b></td><td ><%=proc_summary%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.Findings.label" bundle="${common_labels}"/></b></td><td ><%=findings%></td></tr>
<tr><td class=label  ><b><fmt:message key="eCA.Impressions.label" bundle="${ca_labels}"/></b></td><td ><%=impression%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/></b></td><td ><%=disposition%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.Events.label" bundle="${common_labels}"/></b></td><td ><%=events%></td></tr>
<tr><td class=label  ><b><fmt:message key="eCA.PostProcStdOrders.label" bundle="${ca_labels}"/></b></td><td ><%=post_proc_std_orders%></td></tr>
<tr><td class=label  ><b><fmt:message key="eCA.SpecimenSent.label" bundle="${ca_labels}"/></b></td><td ><%=specimen_sent%></td></tr>
<tr><td class='columnheader' colspan=2><font size=2><b> <fmt:message key="eCA.ErrorDetails.label" bundle="${ca_labels}"/></b></font></td></tr>
<tr><td class=label  ><b><fmt:message key="eCA.ErrorMarkedBy.label" bundle="${ca_labels}"/></b></td><td><%=error_marked_by_id%></td></tr>
<tr><td class=label  ><b><fmt:message key="eCA.ErrorMarkedDate.label" bundle="${ca_labels}"/></b></td><td><%=error_marked_date%></td></tr>
<tr><td class=label  ><b><fmt:message key="Common.ErrorRemarks.label" bundle="${common_labels}"/></b></td><td><%=error_remarks%></td></tr>
</table>
<br>	 
<div align=right>
	 <input type=button class=button name='close' id='close'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick="parent.document.getElementById('dialog_tag').close();">
</div>
<%					
						if (rs!=null) rs.close();
						if (stmt!=null) stmt.close();
					}catch(Exception e){
						//out.println("Error Raised =>"+e.toString());//COMMON-ICN-0181
                                                   e.printStackTrace();//COMMON-ICN-0181
				}finally{
						
						
						if (con!=null) ConnectionManager.returnConnection(con);
				}
%>
	</form>
	</body>
	</html>

