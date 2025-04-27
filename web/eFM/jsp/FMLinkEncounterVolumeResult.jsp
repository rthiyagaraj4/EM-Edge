<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet,java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager, java.util.*,com.ehis.util.*,org.json.simple.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>
<%
Connection connection			=	null;
PreparedStatement preStatement	=	null;
PreparedStatement pStatement	=	null;
PreparedStatement prStatement	=	null;
ResultSet	resultSet			=	null;
ResultSet	rSet				=	null;
ResultSet	resSet				=	null;

String facilityID 			=	"";
String patient_id 			=	"";
String file_no	 			=	"";
String file_type 			=	"";
String action_code 			=	"";
String from		 			=	"";
String to		 			=	"";
//String searchYN	 			=	"N";
String file_type_appl_yn	=	"N";
String valid_values			=	"";
//String selected_values		=	"";
String patient_class_code	=	"";
String appl_to_op			=	"N";
String appl_to_dc			=	"N";
String appl_to_ip			=	"N";
String appl_to_em			=	"N";
String old_volume_no="";
int old_volumeno=0;
HashMap		keepRecord		=	null;
keepRecord	= new HashMap();

int volume_no 				=	-1;
int record_count			=	0;
int start					=	0 ;
int end						=	0 ;
int count					=	1 ;
int cnt						=	0 ;
int len=0 ,lk=0;
int len1=0;
StringBuffer sqlBuffer		=	new StringBuffer();
StringBuffer sqlQuery		=	new StringBuffer();
StringBuffer whereBuffer	=	new StringBuffer();
StringBuffer volumeBuffer	=	new StringBuffer();

try
{
	connection			=	ConnectionManager.getConnection(request);
	
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	patient_id 			=	checkForNull(request.getParameter("patient_id"));
	file_no 			=	checkForNull(request.getParameter("file_no"));
	file_type 			=	checkForNull(request.getParameter("file_type"));
	action_code			=	checkForNull(request.getParameter("action_code"));
	file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"));
	from				=	checkForNull(request.getParameter("from"));
	to					=	checkForNull(request.getParameter("to"));
	//searchYN			=	checkForNull(request.getParameter("searchYN"));
	valid_values		=	checkForNull(request.getParameter("valid_values"));
	//selected_values		=	checkForNull(request.getParameter("selected_values"));
	
	if(from.equals("")) start = 1 ;
	else start = Integer.parseInt( from ) ;

	if(to.equals("")) end = 11 ;
	else end = Integer.parseInt( to ) ;

	if(!file_type.equals(""))
	{
		if(preStatement != null) preStatement = null;
		if(resultSet != null) resultSet = null;

		preStatement	= connection.prepareStatement("SELECT appl_to_op, appl_to_ip, appl_to_em, appl_to_dc FROM mr_file_type where facility_id = ? AND file_type_code = ? ");
		
		preStatement.setString(1, facilityID);
		preStatement.setString(2, file_type);

		resultSet		=	preStatement.executeQuery();
		
		if ((resultSet != null) && (resultSet.next()))
		{
			appl_to_op	=	checkForNull(resultSet.getString("appl_to_op"));	
			appl_to_ip	=	checkForNull(resultSet.getString("appl_to_ip"));	
			appl_to_em	=	checkForNull(resultSet.getString("appl_to_em"));	
			appl_to_dc	=	checkForNull(resultSet.getString("appl_to_dc"));	
		}

				if ((appl_to_ip.equals("Y"))&&(appl_to_op.equals("Y"))&&(appl_to_em.equals("Y"))&&(appl_to_dc.equals("Y")))
			patient_class_code	="";
		else{
			patient_class_code="('";
		if (appl_to_ip.equals("Y"))
			patient_class_code	=	patient_class_code+"IP";	
		if (appl_to_op.equals("Y")&& patient_class_code!="('")
			patient_class_code	=	patient_class_code+"','OP";	
		else if (appl_to_op.equals("Y"))
			patient_class_code	=	patient_class_code+"OP";	
		if (appl_to_em.equals("Y")&& patient_class_code!="('")
			patient_class_code	=	patient_class_code+"','EM";	
		else if (appl_to_em.equals("Y"))
			patient_class_code	=	patient_class_code+"EM";	
		if (appl_to_dc.equals("Y")&& patient_class_code!="('")
			patient_class_code	=	patient_class_code+"','DC";	
		else if (appl_to_dc.equals("Y"))
			patient_class_code	=	patient_class_code+"DC";	
		patient_class_code	=	patient_class_code+"')";
		}	
	}
		
	if(action_code.equals("L"))
	{
		if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
		sqlBuffer.delete(0, sqlBuffer.length());
		sqlBuffer.append("SELECT" );
		sqlBuffer.append("  AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+localeName+"','1') Encounter_Type" );
		sqlBuffer.append("  , A.Encounter_Id" );
		sqlBuffer.append("  , TO_CHAR(A.VISIT_ADM_DATE_TIME,'dd/mm/rrrr hh24:mi') Encounter_Date_Time" );
		sqlBuffer.append("  , AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') Practitioner_Name" );
		sqlBuffer.append("  , AM_GET_DESC.AM_SPECIALITY(A.specialty_code,'"+localeName+"','2') Specialty" );
		sqlBuffer.append("  , DECODE(A.ASSIGN_CARE_LOCN_TYPE,'N',IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+localeName+"','1'), OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+localeName+"','1')) Location" );
		sqlBuffer.append("  , a.assign_care_locn_type" );
		sqlBuffer.append("  , a.Assign_Care_Locn_Code" );
		sqlBuffer.append("  , a.Patient_Class Patient_Class_Code " );
		sqlBuffer.append("FROM" );
		sqlBuffer.append("  pr_Encounter a " );

		if ((whereBuffer != null) && (whereBuffer.length() > 0))
			whereBuffer.delete(0, whereBuffer.length());
		whereBuffer.append("WHERE a.Facility_Id = '"+facilityID+"' " );
		whereBuffer.append("  AND a.Patient_Id = '"+patient_id+"' ");
	   whereBuffer.append("  AND a.discharge_date_time IS NOT NULL ");
		if (!patient_class_code.equals(""))
		{
		whereBuffer.append("AND a.patient_class IN ");
		whereBuffer.append(patient_class_code  );
		}
		whereBuffer.append("  AND NOT EXISTS (" );
		whereBuffer.append("  SELECT" );
		whereBuffer.append("    FACILITY_ID" );
		whereBuffer.append("    , ENCOUNTER_ID " );
		whereBuffer.append("  FROM" );
		whereBuffer.append("    FM_ENCOUNTER_VOLUME_LINK " );
		whereBuffer.append("  WHERE FACILITY_ID = A.FACILITY_ID " );
		whereBuffer.append("    AND ENCOUNTER_ID = A.ENCOUNTER_ID" );
		whereBuffer.append("  ) " );
		
		sqlBuffer.append(whereBuffer.toString());
		sqlBuffer.append(" ORDER BY to_date(encounter_date_time, 'dd/mm/rrrr hh24:mi'), encounter_type, a.encounter_id");
	 		if ((sqlQuery != null) && (sqlQuery.length() > 0))
			sqlQuery.delete(0, sqlQuery.length());
	}
	else if((action_code.equals("D")) || (action_code.equals("C")))
	{
			if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
			sqlBuffer.delete(0, sqlBuffer.length());

		sqlBuffer.append("SELECT" );
		sqlBuffer.append("  AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+localeName+"','1') Encounter_Type" );
		sqlBuffer.append("  , e.Encounter_Id" );
		sqlBuffer.append("  , TO_CHAR(e.Encounter_Date_Time,'dd/mm/rrrr hh24:mi') Encounter_Date_Time" );
		sqlBuffer.append("  , AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') Practitioner_Name" );
		sqlBuffer.append("  , AM_GET_DESC.AM_SPECIALITY(A.specialty_code,'"+localeName+"','2') Specialty" );
		sqlBuffer.append("  , DECODE(A.ASSIGN_CARE_LOCN_TYPE,'N',IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+localeName+"','1'), OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+localeName+"','1')) Location" );
		sqlBuffer.append("  , a.Assign_Care_Locn_Code" );
		sqlBuffer.append("  , a.Assign_Care_Locn_Type" );
		sqlBuffer.append("  , a.Patient_Class Patient_Class_Code" );
		sqlBuffer.append("  , e.Volume_No File_Volume " );
		sqlBuffer.append("FROM" );
		sqlBuffer.append("  pr_Encounter a" );
		sqlBuffer.append("  , fm_Encounter_Volume_Link e  " );

		if ((whereBuffer != null) && (whereBuffer.length() > 0))
			whereBuffer.delete(0, whereBuffer.length());

		whereBuffer.append(" WHERE a.Encounter_Id = e.Encounter_Id (+) " );
		whereBuffer.append("  AND a.Facility_Id = e.Facility_Id (+) " );
		whereBuffer.append("  AND a.Facility_Id = '"+facilityID+"' " );
		whereBuffer.append("  AND a.Patient_Id = '"+patient_id+"' " );
		if (!patient_class_code.equals(""))
		{
		whereBuffer.append("  AND a.Patient_Class IN ");
		whereBuffer.append(patient_class_code);
		}

		if (!file_no.equals(""))
		{
			whereBuffer.append(" AND e.file_no = '");
			whereBuffer.append(file_no);
			whereBuffer.append("' ");
		}
		
		if (!file_type.equals(""))
		{
			whereBuffer.append(" AND e.file_type_code = '");
			whereBuffer.append(file_type);
			whereBuffer.append("' ");
		}
		sqlBuffer.append(whereBuffer.toString());
		sqlBuffer.append(" ORDER BY a.VISIT_ADM_DATE_TIME, a.encounter_id");
				if ((sqlQuery != null) && (sqlQuery.length() > 0))
			sqlQuery.delete(0, sqlQuery.length());
	}
%>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->


	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eFM/js/FMLinkEncounterVolume.js'></script>
</head>

<body onMouseDown = "CodeArrest();" onKeyDown = 'lockKey();' onKeyDown = 'lockKey();'> 
<form name='FMLinkEncounterResultForm' id='FMLinkEncounterResultForm' action='FMLinkEncounterVolumeResult.jsp' method='POST'>
<%
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();
	/*preStatement	=	connection.prepareStatement(sqlQuery.toString());
	resultSet		=	preStatement.executeQuery();
	if ((resultSet != null) && (resultSet.next()))
		record_count	=	resultSet.getInt("record_count");*/

//if ((!(start <= 1)) || (!( (start+11) > record_count )))
//{
	%>
	<table align='right'><tr>
	<%
	if ( !(start <= 1) )
	{
	%>
		<td align ='right' id='prev'><a href='javascript:submitPrevNext(<%=start-11%>, <%=end-11%>)'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
	<%
	}
			
	//if ( !( (start+11) > record_count ) )
//	{
	%>
		<td align ='right' id='next' style='visibility:hidden'><a href='javascript:submitPrevNext(<%=(start+11)%>, <%=end+11%>)'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
	<%
//	}
	%>
	</td></tr></table></p>
	<br><br>				
	<%
//}
%>
<table width="100%" cellpadding="0" cellspacing="0" border="1">
<tr>
	<td width="12%" class='COLUMNHEADER'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
	<td width="11%" class='COLUMNHEADER'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td width="17%" class='COLUMNHEADER'><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></td>
	<td width="20%" class='COLUMNHEADER'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td width="15%" class='COLUMNHEADER'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td width="15%" class='COLUMNHEADER'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td width="5%" class='COLUMNHEADER'><fmt:message key="eFM.FileVolume.label" bundle="${fm_labels}"/></td>
	<%
		if (action_code.equals("L"))
		{
	%>
	<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.Link.label" bundle="${common_labels}"/></td>
	<%
		}
		else if (action_code.equals("D"))
		{
	%>
	<td width="5%" nowrap class='COLUMNHEADER'><fmt:message key="eFM.De-Link.label" bundle="${fm_labels}"/></td>
	<%
		}
		else if (action_code.equals("C"))
		{
	%>
	<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.change.label" bundle="${common_labels}"/></td>
	<%
		}
	%>
</tr>
<%
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();

	String encounter_type_value			=	"&nbsp;";
	String encounter_id_value			=	"&nbsp;";
	String encounter_date_time_value	=	"&nbsp;";
	String class_value					=	"QRYEVEN";
	String practitioner					=	"&nbsp;";
	String specialty					=	"&nbsp;";
	String location						=	"&nbsp;";
	//String assign_care_locn_type		=	"";
	//String assign_care_locn_code		=	"";
	String patient_class				=	"";
	String check_attribute				=	"";
	String select_attribute				=	"";
	String disable_attribute			=	"";
	StringBuffer associate_value		=	new StringBuffer();
	
	preStatement	=	connection.prepareStatement(sqlBuffer.toString());
	resultSet		=	preStatement.executeQuery();
	
	if (resultSet != null)
	{
		if ( start != 1 )
			for( int j=1; j<start; count++,j++ )
				resultSet.next() ;
		int strCount					= 0;		
		int validCount					= 0;
		int volume_no_val				= -1;
		StringTokenizer strToken		= null;
		StringTokenizer validToken		= null;		
		
		String select_value	= "";
		String check_value	= "";
		String tokenValue	= "";		

		 len =keepRecord.size();
		
		if( (action_code.equals("L")) || (action_code.equals("C")))
		{
						
			if((volumeBuffer != null) && (volumeBuffer.length() > 0))
			volumeBuffer.delete(0, volumeBuffer.length());
			
			if(len==0)
			{
			volumeBuffer.append("SELECT volume_no FROM fm_curr_locn WHERE facility_id = '");
			volumeBuffer.append(facilityID);
			volumeBuffer.append("' and patient_id = '");
			volumeBuffer.append(patient_id);
			volumeBuffer.append("' ");
			if (!file_no.equals(""))
			{
				volumeBuffer.append(" AND file_no = '");
				volumeBuffer.append(file_no);
					if(file_type_appl_yn.equals("Y"))
				  {
					volumeBuffer.append("' ");
				}
				}
			if (!file_type.equals(""))
			{
				volumeBuffer.append(" AND file_type_code = '");
				volumeBuffer.append(file_type);
				}
			volumeBuffer.append("' ORDER BY volume_no");		
		
			prStatement	= connection.prepareStatement(volumeBuffer.toString());
		}
		}
		
		
		while(resultSet.next() && count <= end)
		{
			select_attribute = "";
			encounter_type_value		= checkForNull(resultSet.getString("encounter_type"));
			encounter_id_value			= checkForNull(resultSet.getString("encounter_id"));
			encounter_date_time_value	= checkForNull(resultSet.getString("encounter_date_time"));
			if(!encounter_date_time_value.equals(""))
			encounter_date_time_value=DateUtils.convertDate(encounter_date_time_value,"DMYHM","en",localeName);

			practitioner				= checkForNull(resultSet.getString("practitioner_name"), "&nbsp;");
			specialty					= checkForNull(resultSet.getString("specialty"));
			if ((action_code.equals("D")) || (action_code.equals("C")))
				volume_no				= resultSet.getInt("file_volume");
			
			//assign_care_locn_type	= checkForNull(resultSet.getString("assign_care_locn_type"));
			//assign_care_locn_code	= checkForNull(resultSet.getString("assign_care_locn_code"));
			patient_class			= checkForNull(resultSet.getString("patient_class_code"));
			location				= checkForNull(resultSet.getString("location"));

			if ((associate_value != null) && (associate_value.length() > 0))
				associate_value.delete(0, associate_value.length());
			
			associate_value.append(encounter_id_value);	
			associate_value.append("||");	
			if (file_no.equals(""))
				 associate_value.append("$$");
			else associate_value.append(file_no);	
			associate_value.append("||");	
			if (file_type.equals(""))
				 associate_value.append("$$");
			else associate_value.append(file_type);	
			associate_value.append("||");	
			associate_value.append(encounter_date_time_value);	
			associate_value.append("||");	
			associate_value.append(patient_class);	
			
			if ((!valid_values.equals("")) && (!valid_values.equals(",")))
			{
				strToken	=  new StringTokenizer(valid_values, ",");
				strCount = strToken.countTokens();
			}
			
			check_attribute = "";
			
			for (int i=0; i<strCount; i++)
			{
				tokenValue = checkForNull(strToken.nextToken());
				validToken = new StringTokenizer(tokenValue, "^^");
				validCount = validToken.countTokens();
				for (int j=0; j< validCount; j++)
				{
					select_value	=	"";
					if (validToken.hasMoreTokens())
					check_value		=	checkForNull(validToken.nextToken());
					if (validToken.hasMoreTokens())
						select_value =	checkForNull(validToken.nextToken());
					if (check_value.equals(associate_value.toString()))
						check_attribute = "Checked";
				}
			}
			
			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
			if (action_code.equals("D"))
				 disable_attribute	=	"Disabled";
			else disable_attribute	=	"";
		%>
			<tr>
			<td class="<%=class_value%>" nowrap><%=encounter_type_value%></td>
			<td class="<%=class_value%>" nowrap><%=encounter_id_value%></td>
			<td class="<%=class_value%>" nowrap><%=encounter_date_time_value%></td>
			<td class="<%=class_value%>" nowrap><%=practitioner%></td>
			<td class="<%=class_value%>" nowrap><%=specialty%></td>
			<td class="<%=class_value%>" nowrap><%=location%></td>
			<td class="<%=class_value%>" nowrap>
			<select name="file_volume<%=count%>" id="file_volume<%=count%>" onBlur="getSelectedValues(this, associate<%=count%>)" <%=disable_attribute%> >
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<%
				
			len1=keepRecord.size();
				if( (action_code.equals("L")) || (action_code.equals("C")) )
				{
					if(len1==0)
					resSet	= prStatement.executeQuery();
					
					if(resSet != null)
					{
						if(action_code.equals("C"))
						{
							if(len1==0)
							{
							
							while(resSet.next())
							{
								if(volume_no == resSet.getInt("volume_no"))
									select_attribute = "Selected";
								else
									select_attribute = "";
							%>
								<option value='<%=resSet.getInt("volume_no")%>' <%=select_attribute%> ><%=resSet.getInt("volume_no")%></option>
							<%
							keepRecord.put(lk ,resSet.getString("volume_no"));
								lk++;
								}
							}else{
                        
						 for(int k=0; k<len1 ;k++)
							   {
							   old_volume_no =(String) keepRecord.get(k);
								if(old_volume_no!=null)
								old_volumeno=Integer.parseInt(old_volume_no);
                                if(volume_no == old_volumeno)
									select_attribute = "Selected";
								else
									select_attribute = "";
							%>
								<option  value='<%=old_volumeno%>' <%=select_attribute%> ><%=old_volumeno%></option>
							<%

							   }
							}
											
						}
						else if(action_code.equals("L"))
						{
							if(len1==0)
							{
							while(resSet.next())
							{
								select_attribute = "";
								if ((!valid_values.equals("")) && (!valid_values.equals(",")))
								{
									strToken =  new StringTokenizer(valid_values, ",");
									strCount = strToken.countTokens();
								}
								
								for (int i=0; i<strCount; i++)
								{
									tokenValue = checkForNull(strToken.nextToken());
									validToken = new StringTokenizer(tokenValue, "^^");
									validCount = validToken.countTokens();
									for (int j=0; j< validCount; j++)
									{
										check_value		=	"";
										select_value	=	"";	
										if (validToken.hasMoreTokens())
											check_value =	checkForNull(validToken.nextToken());
										if (validToken.hasMoreTokens())
											select_value =	checkForNull(validToken.nextToken(), "@");
										
										if ((!select_value.equals("@")) && (!select_value.equals("")))
											volume_no_val = Integer.parseInt(select_value);
										else volume_no_val = -1;
										
										if ((check_value.equals(associate_value.toString())) && (resSet.getInt("volume_no")==volume_no_val))
												select_attribute = "Selected";
									}
								}
														
							%>
								<option value='<%=resSet.getInt("volume_no")%>' <%=select_attribute%> ><%=resSet.getInt("volume_no")%></option>
							<%
						  keepRecord.put(lk,resSet.getString("volume_no"));
							lk++;	
								}
						} else {
                     								
								for(int k=0; k<len1 ;k++)
							   {
							  old_volume_no =(String) keepRecord.get(k);
								if(old_volume_no!=null)
							old_volumeno=Integer.parseInt(old_volume_no);
							
								select_attribute = "";
								if ((!valid_values.equals("")) && (!valid_values.equals(",")))
								{
									strToken =  new StringTokenizer(valid_values, ",");
									strCount = strToken.countTokens();
								}
								for (int i=0; i<strCount; i++)
								{
									tokenValue = checkForNull(strToken.nextToken());
									validToken = new StringTokenizer(tokenValue, "^^");
									validCount = validToken.countTokens();
									for (int j=0; j< validCount; j++)
									{
										check_value		=	"";
										select_value	=	"";	
										if (validToken.hasMoreTokens())
											check_value =	checkForNull(validToken.nextToken());
										if (validToken.hasMoreTokens())
											select_value =	checkForNull(validToken.nextToken(), "@");
										
										if ((!select_value.equals("@")) && (!select_value.equals("")))
											volume_no_val = Integer.parseInt(select_value);
										else volume_no_val = -1;
										
										if ((check_value.equals(associate_value.toString())) && (old_volumeno == volume_no_val))
												select_attribute = "Selected";
									}
								}
							%>
								<option value='<%=old_volumeno%>' <%=select_attribute%> ><%=old_volumeno%></option>
							<%
							   }
                			}
						
								}
					}
				}
				else if(action_code.equals("D"))
				{
					%>
					<option value='<%=volume_no%>' selected disabled><%=volume_no%></option>
					<%
				}

			%>
			</select>
			</td>
			<td class="<%=class_value%>" align="CENTER" nowrap><input type="checkbox" name="associate<%=count%>" id="associate<%=count%>" value="<%=associate_value.toString()%>" onClick="getCheckedValues(this, file_volume<%=count%>)" <%=check_attribute%> ></td>
			</tr>
		<%
			count++;
			cnt++;
		}

		JSONObject jsonObj  =  eFM.FMLinkEncFileVolumeBean.getEncFileVolumeAuditDtls(connection,patient_id,file_no,file_type,localeName,1,14);
		JSONArray fileVolumeAuditDtlsArr 			= (JSONArray)jsonObj.get("fileVolumeAuditDtls");
		int fileVolumeAuditDtlCount					= fileVolumeAuditDtlsArr.size();
		String auditTrailDisplay					= "";
		if(fileVolumeAuditDtlCount==0){
			auditTrailDisplay	= "disabled";
		}

%>
		<tr ><td colspan="8" style='border:0px;'> &nbsp;</td></tr>
		<tr ><td colspan="8" align="right" style='border:0px;'><input type='button' class='button' value='<fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>' onclick="showAuditTrail();" <%=auditTrailDisplay%>/></td></tr>
<%	}
	if(cnt == 0)
	{
		%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.criteria_frame.document.forms[0].search.disabled = false;
			parent.criteria_frame.document.forms[0].clear_page.click();		parent.patient_line_frame.document.location.href="../../eCommon/html/blank.html";	parent.result_frame.document.location.href="../../eCommon/html/blank.html";		parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
		</script>
	<%
	}
		if(cnt<11){

%>
<SCRIPT >
document.getElementById("next").style.visibility='hidden';
</SCRIPT>
<%} else {%>
<SCRIPT >
document.getElementById("next").style.visibility='visible';
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}%>
</table>

	<input type="Hidden" name="from" id="from" value="<%=from%>">
	<input type="Hidden" name="to" id="to" value="<%=to%>">
	<input type="Hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="Hidden" name="file_no" id="file_no" value="<%=file_no%>">
	<input type="Hidden" name="file_type" id="file_type" value="<%=file_type%>">
	<input type="Hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
	<input type="Hidden" name="action_code" id="action_code" value="<%=action_code%>">
	<input type="Hidden" name="record_count" id="record_count" value="<%=record_count%>">
	<input type="Hidden" name="file_type_appl_yn" id="file_type_appl_yn" value="<%=file_type_appl_yn%>">
	<input type="Hidden" name="valid_values" id="valid_values" value="<%=valid_values%>">

<script>
	parent.patient_line_frame.document.location.href="../../eCommon/jsp/pline.jsp?Patient_ID="+"<%=patient_id%>";
	parent.criteria_frame.document.forms[0].search.disabled = false;
	parent.criteria_frame.document.forms[0].patient_id.disabled = true;
	parent.criteria_frame.document.forms[0].pat_search.disabled = true;
	/*if ("<%=file_type_appl_yn%>"=="N")
		parent.criteria_frame.document.forms[0].file_no.disabled = true;
	else if ("<%=file_type_appl_yn%>"=="Y")
		parent.criteria_frame.document.forms[0].file_type.disabled = true;*/
	parent.criteria_frame.document.forms[0].action_code.disabled = true;
</script>
<%
if(resultSet!=null)	resultSet.close();
if(rSet!=null)	rSet.close();
if(resSet!=null)	resSet.close();	
if(preStatement!=null) preStatement.close();
if(pStatement!=null) pStatement.close();
if(prStatement!=null) prStatement.close();
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}
%>
<input type="Hidden" name="patient_file_type" id="patient_file_type" value="" >
</form>
</body>
</html>

<%!

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("undefined"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) || (inputString.equals("undefined"))) ? defaultValue : inputString);
}

%>

