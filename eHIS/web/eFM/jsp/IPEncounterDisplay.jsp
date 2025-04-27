<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>	
<HEAD>
		<TITLE></TITLE>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js"></script>
		<script src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function sendtomain(encid)
		{
			//parent.window.returnValue=encid;
			let dialogBody = parent.parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = encid;
			const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		    dialogTag.close();       
		}
		</script>
		</HEAD>
		<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
		<form name="RepMovementHistForm" id="RepMovementHistForm">
<%
	Connection con  = null;
	Statement stmt  = null;
	ResultSet rs    = null;
	Statement stmt1 = null;
	ResultSet rs1   = null;
		
	String deficiency_status="";
	String deficiency_flag="";
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;	

	String called_from = request.getParameter("called_from"); // From QueryFMEncounterDetailsSearch.jsp
		
	if(called_from == null || called_from.equals("null"))
		called_from = "";
		
	try
	{
		con  =  ConnectionManager.getConnection(request);
		stmt=con.createStatement();

		if(called_from.equals("QFMED"))
		{
			String sql = "SELECT distinct encounter_id, TO_CHAR(encounter_date_time,'dd/mm/yyyy hh24:mi')encounter_date_time_date_time FROM fm_encounter_volume_link WHERE facility_id = '"+p_facility_id+"'";
			rs=stmt.executeQuery(sql);
%>
		<br>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<tr>
			<th width = '25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
			<th width = '25%'><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></th>
		</tr>
		<tr>
<%			int i = 0;
			String classValue="";
			String encounter_date_time="";
			while(rs!=null && rs.next())
			{
				i = i +1;
				encounter_date_time=rs.getString(2);
				 if(!localeName.equals("en"))
				{
					 encounter_date_time=DateUtils.convertDate(encounter_date_time,"DMYHM","en",localeName);
				}
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;		 
				out.println("<td width = '25%' class='"+classValue+"'><a href=\"javascript:sendtomain('"+rs.getString(1)+"')\">"+rs.getString(1)+"</a></td>");
				out.println("<td width = '25%' class='" + classValue + "'>"+encounter_date_time+"</td>");
%>
		</tr>
		
<%
			}
%>
		</TABLE>
<%
		}
		else
		{
			String sql="";
			String file_type = request.getParameter("file_type");	
			String patientid = request.getParameter("patient_id");	
			String file_no	 =	request.getParameter("file_no");		
			String file_type_appl_yn =	request.getParameter("file_type_appl_yn");		
			String volume_no =request.getParameter("volume_no");	
			
			file_no = ((file_no==null)||(file_no.equals("null"))) ? "" : file_no;
			file_type = ((file_type==null)||(file_type.equals("null"))) ? "" : file_type;
			patientid = ((patientid==null)||(patientid.equals("null"))) ? "" : patientid;
			volume_no = ((volume_no==null)||(volume_no.equals("null"))) ? "" : volume_no;
			file_type_appl_yn = ((file_type_appl_yn==null)||(file_type_appl_yn.equals("null"))) ? "N" : file_type_appl_yn;
			if(rs!=null)	rs.close();		
			if(called_from.equals("Report_encdetails"))
			{
			 if(file_type_appl_yn.equals("Y"))
				{
			if(file_no.equals(""))
					{
                      sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.patient_id ='"+patientid+"' and a.facility_id ='"+p_facility_id+"'  AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)   ORDER BY a.visit_adm_date_time DESC ";
					} else if(volume_no.equals(""))		
					{
       sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status  FROM fm_deficiency_hdr WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id  AND file_no ='"+file_no+"') deficiency_status   FROM pr_encounter a WHERE a.patient_id = '"+patientid+"' AND   a.facility_id = '"+p_facility_id+"'   order by a.visit_adm_date_time desc ";

					}
					
					else {			 
				 sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status  FROM fm_deficiency_hdr WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id  AND file_no ='"+file_no+"' AND volume_no ='"+volume_no+"') deficiency_status   FROM pr_encounter a WHERE a.patient_id = '"+patientid+"'  AND  a.facility_id = '"+p_facility_id+"'  order by a.visit_adm_date_time desc ";
					}
						
						}
				 if(file_type_appl_yn.equals("N"))
				{
			
			 if(file_no.equals(""))
					{
                      sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.patient_id ='"+patientid+"' AND  a.facility_id ='"+p_facility_id+"'     AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)   ORDER BY a.visit_adm_date_time DESC ";
					}else if(volume_no.equals(""))		
					{
					 sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.patient_id ='"+patientid+"' AND  a.facility_id = '"+p_facility_id+"'  AND b.file_no(+) ='"+file_no+"' AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)   ORDER BY a.visit_adm_date_time DESC ";
				}
					
					else{
				 
			 sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status  FROM fm_deficiency_hdr WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id  AND file_no ='"+file_no+"' AND volume_no ='"+volume_no+"') deficiency_status   FROM pr_encounter a WHERE  a.patient_id = '"+patientid+"'  AND  a.facility_id = '"+p_facility_id+"'   order by a.visit_adm_date_time desc ";
				}
				}
			}else if(called_from.equals("deficiecy_slip"))
			
			{
             if(file_type_appl_yn.equals("Y"))
				{
			 						  
			  if(file_no.equals(""))
					{
                      sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.facility_id ='"+p_facility_id+"'    AND a.patient_id ='"+patientid+"'  AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					}	else if(volume_no.equals(""))		
					{				
					 sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.facility_id ='"+p_facility_id+"'    AND a.patient_id ='"+patientid+"' AND b.file_no ='"+file_no+"' AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					}
					
					else{
				   sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status FROM fm_deficiency_hdr   WHERE facility_id = a.facility_id  AND encounter_id = a.encounter_id AND file_no = '"+file_no+"' AND volume_no ='"+volume_no+"') deficiency_status   FROM pr_encounter a WHERE a.facility_id = '"+p_facility_id+"' AND a.patient_id = '"+patientid+"' and discharge_date_time is not null order by a.visit_adm_date_time desc ";
					  
					
					}
				}
				 if(file_type_appl_yn.equals("N"))
				{
			       
				   if(file_no.equals(""))
					{
                    sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.facility_id ='"+p_facility_id+"'    AND a.patient_id ='"+patientid+"'  AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					} else if(volume_no.equals(""))		
					{	
					  sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.facility_id ='"+p_facility_id+"'    AND a.patient_id ='"+patientid+"' AND b.file_no ='"+file_no+"' AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					}
					else{
				   sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status FROM fm_deficiency_hdr       WHERE facility_id = a.facility_id  AND encounter_id = a.encounter_id AND file_no = '"+file_no+"' AND volume_no ='"+volume_no+"') deficiency_status   FROM pr_encounter a WHERE a.patient_id = '"+patientid+"' AND  a.facility_id = '"+p_facility_id+"'  and discharge_date_time is not null order by a.visit_adm_date_time desc ";
					}
					
					}

			}
			else if(called_from.equals("file_encounter"))
			{
      sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.patient_id ='"+patientid+"'  AND  a.facility_id ='"+p_facility_id+"'   AND   a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
			}
			
			else{
             if(file_type_appl_yn.equals("Y"))
				{
			  if(file_type.equals(""))
					{			  
			 sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.patient_id ='"+patientid+"'  AND  a.facility_id ='"+p_facility_id+"'   AND    a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					}else{
        sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class,(SELECT deficiency_status FROM fm_deficiency_hdr       WHERE facility_id = a.facility_id  AND encounter_id = a.encounter_id AND file_type = '"+file_type+"' AND volume_no ='"+volume_no+"') deficiency_status  FROM pr_encounter a WHERE a.patient_id = '"+patientid+"' AND  a.facility_id = '"+p_facility_id+"'   and discharge_date_time is not null order by a.visit_adm_date_time desc ";
					}
				
				
				}
				 if(file_type_appl_yn.equals("N"))
				{
			      
				    if(file_no.equals(""))
					{	 
				   sql = "SELECT   a.encounter_id,  TO_CHAR(a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date_time,  TO_CHAR(a.discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time,    am_get_desc.am_practitioner(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name,a.patient_class, b.deficiency_status   FROM pr_encounter a, fm_deficiency_hdr b  WHERE a.facility_id ='"+p_facility_id+"'    AND a.patient_id ='"+patientid+"'  AND a.facility_id = b.facility_id(+)  AND a.encounter_id =b.encounter_id(+)  AND discharge_date_time IS NOT NULL ORDER BY a.visit_adm_date_time DESC ";
					}else{
				   sql = "SELECT A.encounter_id, TO_CHAR (A.visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), TO_CHAR (A.discharge_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, patient_class, (SELECT deficiency_status FROM fm_deficiency_hdr       WHERE facility_id = a.facility_id  AND encounter_id = a.encounter_id AND file_no = '"+file_no+"' AND volume_no ='"+volume_no+"') deficiency_status   FROM pr_encounter a WHERE a.facility_id = '"+p_facility_id+"' AND a.patient_id = '"+patientid+"' and discharge_date_time is not null order by a.visit_adm_date_time desc ";
					}
					
					}
			
			
			}
		
			rs=stmt.executeQuery(sql);

%>
		<br>
		<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
		<tr>
		<th width = '10%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
		<th width = '15%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th width = '15%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></th>
		<th width = '15%'><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></th>
		<th width = '20%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<th width = '40%'><fmt:message key="eFM.DeficiencyStatus.label" bundle="${fm_labels}"/></th>
		</tr>
		<tr>
		<%	int i = 0;
			String classValue="";
			String visit_adm_date_time="";
			String visit_dis_date_time="";
			while(rs.next())
			{
				 i = i+1;
				 visit_adm_date_time=rs.getString(2);   
				 visit_dis_date_time=rs.getString(3);     
				 if(!localeName.equals("en"))
				{
					 visit_adm_date_time=DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",localeName);
					  visit_dis_date_time=DateUtils.convertDate(visit_dis_date_time,"DMYHM","en",localeName);
				}
				if(visit_dis_date_time==null) visit_dis_date_time="&nbsp;";
				 
				 if(i % 2 == 0)
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";	
				out.println("<td width = '10%' class='" + classValue + "'>"+rs.getString(5)+"</td>");
				out.println("<td width = '25%' class='"+classValue+"'><a href=\"javascript:sendtomain('"+rs.getString(1)+"')\">"+rs.getString(1)+"</a></td>");
				out.println("<td width = '25%' class='" + classValue + "'>"+visit_adm_date_time+"</td>");
				out.println("<td width = '25%' class='" + classValue + "'>"+visit_dis_date_time+"</td>");
				out.println("<td width = '50%' class='" + classValue + "'>"+(rs.getString(4)==null?"&nbsp;":rs.getString(4))+"</td>");
              deficiency_status=rs.getString("deficiency_status");
			deficiency_status = ((deficiency_status==null)||(deficiency_status.equals("null"))) ? "" : deficiency_status;  
			  
			  if(!deficiency_status.equals(""))
			{
				switch(deficiency_status.charAt(0))
				{
					case 'O' : deficiency_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels"); break;

					case 'C' : deficiency_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels"); break;

					case 'X' : deficiency_flag = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels"); break;
				   
				}
			}
				  
			    if(deficiency_status.equals(""))
				{
                   deficiency_flag="&nbsp;";
				}
		   out.println("<td width = '50%' class='" + classValue + "'>"+deficiency_flag+"</td>");
%>
		</tr>
<%
			}

%>
</table>
<br>
<table border="0" width="100%" cellspacing='0' cellpadding='0'>
<tr>
	<td class='button'  colspan='5' align='right'>
		<input type='button' class='BUTTON' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick="const dialogTag = parent.parent.document.getElementById('dialog_tag'); dialogTag.close();">
	 </td>
	</tr>
</table>
<%
	if(i==0)
			{	%>
		<script>
			var msg =	getMessage('NO_DISCHARGED_ENCOUTER','FM');
			alert(msg);
		window.close();
		</script>	
		
		<%}
		}
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
	if(rs1!=null)	rs1.close();
	if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</BODY>
</HTML>

