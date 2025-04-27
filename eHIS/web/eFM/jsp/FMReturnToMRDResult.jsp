<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet,java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager, java.util.StringTokenizer,com.ehis.util.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="FMreturnToMRDResult" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMReturnToMRD.js'></script>
	
</head>

<%
Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

String facility_id				=	"";
String patient_id				=	"";
String fs_location				=	"";
String fs_req_location			=	"";
String returning_code			=	"";
String date_time				=	"";
String transport_mode			=	"";
String transport_mode_desc		=	"";
String file_no					=	"";
String file_type				=	"";
String volume_no				=	"";
String from		 				=	"";
String to		 				=	"";
String added_items				=	"";
String added_patients			=	"";
String added_volumes			=	"";
String file_type_appl_yn		=	"N";
String show_all_yn				=	"Y";
String valid_records			=	"Y";
String class_value				=	"QRYEVEN";
String Iss_Date_Time			=	"";
//String identity                     ="";
String locn_identity             ="";
String	req_start			= ""; 
String  req_end			= "";
String flagSelect= "";
String  checkedOnes		= "";
//String patient_line="";
String selectvalue="";
String chkall="";
String check_attribute		=	"";
String p_stored_val="";
//String pagesClicked		=	"";
//int record_count				=	0;
int start						=	0 ;
int end							=	0 ;
int count						=	1 ;
int	i						= 1;
int	pagecount			= 0;
StringBuffer sqlBuffer		=	new StringBuffer();
StringBuffer whereBuffer	=	new StringBuffer();
//StringBuffer queryBuffer	=	new StringBuffer();

try
{
	facility_id 		=	checkForNull((String) session.getValue("facility_id"));
	fs_location			=	checkForNull(request.getParameter("fs_location"));
	fs_req_location		=	checkForNull(request.getParameter("fs_req_location"));
	returning_code		=	checkForNull(request.getParameter("returning_code"));
	date_time			=	checkForNull(request.getParameter("date_time"));
	transport_mode		=	checkForNull(request.getParameter("transport_mode"));
	transport_mode_desc	=	checkForNull(request.getParameter("transport_mode_desc"));
	patient_id			=	checkForNull(request.getParameter("patient_id"));
	file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"));
	file_no				=	checkForNull(request.getParameter("file_no"));
	file_type			=	checkForNull(request.getParameter("file_type"));
	volume_no			=	checkForNull(request.getParameter("volume_no"));
	from				=	checkForNull(request.getParameter("from"));
	to					=	checkForNull(request.getParameter("to"));
	added_items			=	checkForNull(request.getParameter("added_items"));
	
	added_patients		=	checkForNull(request.getParameter("added_patients"));
	added_volumes		=	checkForNull(request.getParameter("added_volumes"));
	valid_records		=	checkForNull(request.getParameter("valid_records"));
	show_all_yn			=	checkForNull(request.getParameter("show_all_yn"), "Y");
	flagSelect = checkForNull(request.getParameter("fromSelect"));
	p_stored_val=checkForNull(request.getParameter("p_stored_val"));
	String pageflag = checkForNull(request.getParameter("pageflag"));
	String pagesClicked = checkForNull(request.getParameter("pagesClicked"));
	String patientno_volume="";
	String pat_id="";
	String vol_no="";
	String sqlString="";
	String file_creat_fac_id="";
	String curr_fs_locn_identity="";
	int count_tokens=0; 
	boolean executeYN = true;

	//out.println("pagesClicked-->"+pagesClicked);
	//out.println("pageflag-->"+pageflag);

	if(!pagesClicked.equals("")) {
		StringTokenizer st = new StringTokenizer(pagesClicked,"#");
			while(st.hasMoreTokens()) {
				String element = st.nextToken();
				if(element.equals(pageflag))
					executeYN = false;
			}
	} 		

	if(from.equals(""))
		start = 1 ;			
	else 
		start = Integer.parseInt( from );	

	if(to.equals("")) 
		end = 10 ;
	else 
		end = Integer.parseInt( to ) ;

	if(pageflag.equals(""))
		pagecount=1;
	else
		pagecount=Integer.parseInt(pageflag);

	   req_start       =   checkForNull(request.getParameter("start"),"0");
       req_end         =   checkForNull(request.getParameter("end"),"0");
	
		if(!flagSelect.equals(""))
				FMreturnToMRDResult.clearAll();
		
			if(from != null && to != null)
			{
				int j=0;
				for( i=(Integer.parseInt(req_start)); i<= (Integer.parseInt(req_end)); i++)
				{
					if(request.getParameter("confirm"+(i)) != null)
					{
						checkedOnes = request.getParameter("confirm"+(i));
						
						if(!(FMreturnToMRDResult.containsObject(checkedOnes)))
							FMreturnToMRDResult.putObject(checkedOnes);

						j++;
					}
				}
		          
        }
		
	connection	= ConnectionManager.getConnection(request);	

	//sqlBuffer.append("SELECT file_no, file_type_code, file_type_desc, volume_no, patient_id, get_patient_line (patient_id) patient_line, to_char(iss_date_time, 'dd/mm/rrrr hh24:mi') iss_date_time, curr_fs_locn_code, curr_fs_locn_short_desc, volume_no FROM fm_curr_locn_vw ");
    sqlString  =" SELECT facility_id,PERM_FS_LOCN_CODE fs_locn_code FROM fm_curr_locn WHERE  patient_id ='"+patient_id+"' and CURR_FILE_STATUS='I' and CURR_FS_LOCN_IDENTITY='D' and PERM_FS_LOCN_CODE <>CURR_FS_LOCN_CODE and  curr_facility_id='"+facility_id+"' " ;

//	sqlString = "SELECT FACILITY_ID  FROM mr_pat_file_index WHERE  patient_id ='"+patient_id+"' and doc_folder_id is null ";
	if(preStatement!=null) preStatement.close();
	if(resultSet!=null)	resultSet.close(); 
	preStatement	=	connection.prepareStatement(sqlString);
	resultSet		=	preStatement.executeQuery();
	if ((resultSet != null) && (resultSet.next()))
	{
		file_creat_fac_id= resultSet.getString("FACILITY_ID");
	}
	  if(preStatement!=null) preStatement.close();
	  if(resultSet!=null)	resultSet.close(); 
	  	
	 if(!file_creat_fac_id.equals(facility_id))
					{
	preStatement	=connection.prepareStatement(" SELECT curr_fs_locn_identity  FROM fm_curr_locn WHERE  patient_id ='"+patient_id+"' and facility_id='"+file_creat_fac_id+"' and curr_file_status='I' and curr_fs_locn_code='"+fs_req_location+"' ");
		
		resultSet = preStatement.executeQuery();
	
	if ((resultSet != null) && (resultSet.next()))
	{
			curr_fs_locn_identity = resultSet.getString("curr_fs_locn_identity");
           }
		   if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		if(curr_fs_locn_identity==null)	 curr_fs_locn_identity="";		
					
					}
		
	
		
		sqlBuffer.append("SELECT" );
		sqlBuffer.append("  File_No" );
		sqlBuffer.append("  , File_Type_Code" );
		sqlBuffer.append("  , mr_get_desc.MR_FILE_TYPE(FACILITY_ID,File_Type_Code,'"+localeName+"',2) file_type_desc" );
		sqlBuffer.append("  , Volume_No" );
		sqlBuffer.append("  , Patient_Id" );
	   sqlBuffer.append("  , Get_patient_line(Patient_Id,'"+localeName+"') Patient_Line" );
		sqlBuffer.append("  , TO_CHAR(Iss_Date_Time,'dd/mm/rrrr hh24:mi') Iss_Date_Time" );
		sqlBuffer.append("  , Iss_Date_Time Iss_Date_Time1" );
		//sqlBuffer.append("  , Curr_fs_Locn_Code" );
		//sqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',Curr_fs_Locn_Code,'"+localeName+"',2) curr_fs_locn_short_desc" );
		sqlBuffer.append("  , PERM_FS_LOCN_CODE" );
		sqlBuffer.append("  , fm_Get_desc.Fm_storage_locn(FACILITY_ID,PERM_FS_LOCN_CODE,'"+localeName+"',2) curr_fs_locn_short_desc" );
	sqlBuffer.append(",(select locn_identity from fm_storage_locn where facility_id = fm_curr_locn.facility_id and fs_locn_code = fm_curr_locn.perm_fs_locn_code) locn_identity " );
		sqlBuffer.append("FROM" );
		sqlBuffer.append("  fm_Curr_Locn " );

	//queryBuffer.append("SELECT COUNT(*) record_count FROM fm_curr_locn_vw ");


	//whereBuffer.append(" WHERE curr_file_status = 'O' and doc_folder_id is  null AND facility_id = '");
whereBuffer.append(" where curr_fs_locn_code = '");
	whereBuffer.append(fs_req_location);
	whereBuffer.append("' "); 

if(!file_creat_fac_id.equals(facility_id) && curr_fs_locn_identity.equals("D"))
	{
	whereBuffer.append(" AND curr_file_status ='I' and doc_folder_id is  null AND facility_id = '");
	whereBuffer.append(file_creat_fac_id);
	whereBuffer.append("' ");
	}else{
   whereBuffer.append("  AND curr_file_status in('O','I') and  perm_fs_locn_code <> curr_fs_locn_code and doc_folder_id is  null AND curr_facility_id = '");
	whereBuffer.append(facility_id); 
	whereBuffer.append("' ");
	}
	
	/*whereBuffer.append("' AND curr_fs_locn_code = '");
	whereBuffer.append(fs_req_location);
	whereBuffer.append("' ");*/

	if (!returning_code.equals(""))
	{
		whereBuffer.append(" AND CURR_LOCN_ID = '");
		whereBuffer.append(returning_code);
		whereBuffer.append("' ");
	}
	
	if (!show_all_yn.equals("Y"))
	{
		
		whereBuffer.append(" AND file_no IN (");
		whereBuffer.append(added_items);
		/*whereBuffer.append(") AND patient_id IN (");
		whereBuffer.append(added_patients);
		whereBuffer.append(") ");
		
		if (!volume_no.equals(""))
		{
			whereBuffer.append(" AND volume_no IN (");
			whereBuffer.append(added_volumes);
			whereBuffer.append(") ");
		} */
	StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	    count_tokens=pat_volumeno.countTokens();
	   int P_cnt=0;
	 whereBuffer.append( ") AND ( ");
	  while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	vol_no	=fileno1.nextToken();
	}
	// SelectSqlString.append("  (a.patient_id ='"+pat_id+"' ");
	 whereBuffer.append( " ( patient_id ='"+pat_id+"' ");
	 if (!vol_no.equals(""))
			{
		if(count_tokens >P_cnt){
   // SelectSqlString.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
		whereBuffer.append(" AND volume_no ='"+vol_no+"' ) OR ");	
			} else{
              //   SelectSqlString.append("AND a.volume_no ='"+vol_no +"' )");	
		     	whereBuffer.append(" AND volume_no ='"+vol_no +"' ) ) ");	
			}
			
			}
		}	
		
	}
	whereBuffer.append(" order by Iss_Date_Time1 desc ,File_No asc,Volume_No asc ");
	//whereBuffer.append(" order by Iss_Date_Time1 desc");
	//preStatement	=	connection.prepareStatement(queryBuffer.toString());
	//resultSet		=	preStatement.executeQuery();
	
	//if ((resultSet != null) && (resultSet.next()))
	//	record_count = resultSet.getInt("record_count");


	sqlBuffer.append(whereBuffer.toString());
	
	if(preStatement!=null) preStatement.close();
	if(resultSet!=null)	resultSet.close(); 
	
	preStatement	=	connection.prepareStatement(sqlBuffer.toString());
	resultSet		=	preStatement.executeQuery();
	%>
		<body onMouseDown = "CodeArrest();" onKeyDown = 'lockKey();'> 
		<form name='FMReturnToMRDResultForm' id='FMReturnToMRDResultForm' action='FMReturnToMRDResult.jsp' method='POST'>

		<%// if ((!(start <= 1)) || (!( (start+3) > record_count ))) { %>

			<table align='right' ><tr>

			<%// if ( !(start <= 1) ) { %>
			<!--	<td align ='right' id='prev'>
				<a href='javascript:submitPrev(<%=start-10%>, <%=end-10%>)' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>

			<%// } //if ( !( (start+3) > record_count ) ) { %>
				<td align ='right' id='next' style='visibility:hidden'>
				<a href='javascript:submitNext(<%=(start+10)%>, <%=end+10%>)' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
				</td> --> 

			<% //} %>

			</tr></table></p>
			<br><br>				
			<%
		//}
		int cnt = 0;
		int rowcount= 0;
		if (resultSet != null)
		{
		 
		%>
		<table width="98%" cellpadding="0" cellspacing="0" border="1" align="CENTER">
		<tr>
		<% if (file_type_appl_yn.equals("Y")) { %>

			<th width="30%"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
			<th width="8%" ><fmt:message key="eFM.FileTypeVolumeNo.label" bundle="${fm_labels}"/></th>

		<% } else if (file_type_appl_yn.equals("N")) { %>

			<th width="30%"><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></th>
			<th width="8%"> <fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></th>

		<% } %>

			<th width="13%"><fmt:message key="Common.issueddate.label" bundle="${common_labels}"/></th>
			<th width="17%"><fmt:message key="eFM.IssuedFSLocation.label" bundle="${fm_labels}"/></th>
			<th width="10%"><fmt:message key="eFM.ConfirmReturn.label" bundle="${fm_labels}"/></th>
		</tr>
		<%
			int strCount				=	0;
			//int inc						=	0;
			String confirm_values		=	"";
			StringTokenizer strToken	=	null;
		//	if ( start != 1 )
		//		for( int j=1; j<start; count++,j++ )
			//		resultSet.next() ;
			//int i=0;
			//while (resultSet.next() && count<=end)
			while (resultSet.next())
			{
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
				check_attribute = "";
				strToken	=	new StringTokenizer(valid_records, ",");
				strCount	=	strToken.countTokens();
				confirm_values	=	checkForNull(resultSet.getString("file_no"));
				 locn_identity = 			(resultSet.getString("locn_identity")==null)?"&nbsp":resultSet.getString("locn_identity");
				
		if(!locn_identity.equals(""))
		{
			switch(locn_identity.charAt(0))
			{
				case 'D' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' :locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
				confirm_values	=confirm_values +  "||" + checkForNull(resultSet.getString("volume_no"));
			/*	for (inc=0; inc<strCount; inc++)
				{
					if (strToken.hasMoreTokens())
						if ((checkForNull(strToken.nextToken())).equals(confirm_values))
							check_attribute = "Checked";
			} */
			// selectvalue	= deficiency_code;
		 selectvalue=confirm_values;
				if(FMreturnToMRDResult.containsObject(selectvalue)) 
				{
					check_attribute = "CHECKED";
					chkall	= "CHECKED";
					//out.println("If");
				}
				else
				{
					check_attribute="";
					chkall	= "";
					//out.println("Else");
				}
			int recordIndex = FMreturnToMRDResult.indexOfObject(selectvalue);  			

			if(recordIndex!=-1)
				    if(check_attribute.equals("CHECKED"))   
					FMreturnToMRDResult.removeObject(recordIndex); 
			
			
			
			%>
			<tr>

			<% if(file_type_appl_yn.equals("Y")) { 
			
				%>

			<td class="<%=class_value%>"><font size="1"><%=checkForNull(resultSet.getString("patient_line"), "&nbsp;").substring(0,resultSet.getString("patient_line").length()-6)%></font></td>
			<td class="<%=class_value%>" align="CENTER"><font size="1"><%=(resultSet.getString("file_type_desc")==null?"":(resultSet.getString("file_type_desc")+" / "))%><%=checkForNull(resultSet.getString("volume_no"), "&nbsp;")%></font></td>	

			<% } else if (file_type_appl_yn.equals("N")) { %>

			<td class="<%=class_value%>"><font size="1"><b><%=checkForNull(resultSet.getString("file_no"), "&nbsp;")%></b><br><%=checkForNull(resultSet.getString("patient_line"), "&nbsp;").substring(0,resultSet.getString("patient_line").length()-6)%></font></td>
			<td class="<%=class_value%>" align="CENTER"><font size="1"><%=checkForNull(resultSet.getString("volume_no"), "&nbsp;")%></font></td>	

			<% } %>
			<%
				Iss_Date_Time=checkForNull(resultSet.getString("iss_date_time"), "&nbsp;");
				if(!Iss_Date_Time.equals("&nbsp;"))
				{
					Iss_Date_Time=DateUtils.convertDate(Iss_Date_Time,"DMYHM","en",localeName);
				}

				%>
			<td class="<%=class_value%>" align="CENTER"><font size="1"><%=Iss_Date_Time%></font></td>	
			<td class="<%=class_value%>"><font size="1"><%=checkForNull(resultSet.getString("curr_fs_locn_short_desc")+ "(" + locn_identity +")", "&nbsp;")%></font></td>	
			<td class="<%=class_value%>" align="CENTER"><font size="1"><input type="checkbox" name="confirm<%=count%>" id="confirm<%=count%>" id="confirmid<%=count%>" value='<%=selectvalue%>' onClick="markCheckedRecords(this);" <%=check_attribute%> ></font></td>	
			</tr>
						<%
				count++;
				cnt++;
			}
			rowcount=resultSet.getRow();
		}
		
		if(cnt == 0)
		{
			%>
			 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
				parent.result_frame.document.location.href="../../eCommon/html/blank.html";
				parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
				parent.criteria_frame.document.forms[0].all_button.disabled = false;
			    parent.criteria_frame.document.forms[0].add_button.disabled= false;
		    parent.criteria_frame.document.forms[0].clear_button.disabled= false;
				//parent.criteria_frame.document.forms[0].patient_id.value = '';
			</script> 
			<% 
		}
		else
		{ %>
			 <script>
				/*Below field namesare being sent dynamically to "FMFileSearchComponentValues.jsp"  in "FMReturnToMRDCriteria.jsp"*/
			parent.criteria_frame.document.forms[0].patient_id.value = '';
			parent.criteria_frame.document.forms[0].patient_id.onblur();
				parent.criteria_frame.document.forms[0].patient_id.focus();
			parent.criteria_frame.document.forms[0].blur();
			if (parent.criteria_frame.document.forms[0].file_type)
				parent.criteria_frame.document.forms[0].file_type.value = '';
			if (parent.criteria_frame.document.forms[0].volume_no)
				parent.criteria_frame.document.getElementById("volno").innerHTML="<select name=volume_no ><option value=''>---"+getLabel("Common.defaultSelect.label","common")+"---</select>";
			if (parent.criteria_frame.document.forms[0].file_no) {
				parent.criteria_frame.document.getElementById("file_no").value = "";
			}
				//parent.criteria_frame.document.forms[0].volume_no.value ='';
			/*var pat_id_name = parent.criteria_frame.document.forms[0].patientid_name.value;
			if (eval("parent.criteria_frame.document.forms[0]."+pat_id_name))
			{
			eval("parent.criteria_frame.document.forms[0]."+pat_id_name).value = "";
			eval("parent.criteria_frame.document.forms[0]."+pat_id_name).blur();
			}*/
			</script> 
	<%	}
		//	if(rowcount<10){
	%><SCRIPT>
//	document.getElementById("next").style.visibility='hidden'
	
	</SCRIPT>
<%//} else {%>
<SCRIPT>
	//document.getElementById("next").style.visibility='visible'
	</SCRIPT>
<%//}%>
		<script>
	  parent.criteria_frame.document.forms[0].all_button.disabled =false;
	  parent.criteria_frame.document.forms[0].add_button.disabled=false;
		parent.criteria_frame.document.forms[0].clear_button.disabled=false;
		
		</script>
	
	<input type="Hidden" name="from" id="from" value="<%=from%>">
		<input type="Hidden" name="to" id="to" value="<%=to%>">
		<input type="Hidden" name="fs_location" id="fs_location" value="<%=fs_location%>">
		<input type="Hidden" name="fs_req_location" id="fs_req_location" value="<%=fs_req_location%>">
		<input type="Hidden" name="returning_code" id="returning_code" value="<%=returning_code%>">
		<input type="Hidden" name="date_time" id="date_time" value="<%=date_time%>">
		<input type="Hidden" name="transport_mode" id="transport_mode" value="<%=transport_mode%>">
		<input type="Hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="Hidden" name="file_type_appl_yn" id="file_type_appl_yn" value="<%=file_type_appl_yn%>">
		<input type="Hidden" name="file_no" id="file_no" value="<%=file_no%>">
		<input type="Hidden" name="file_type" id="file_type" value="<%=file_type%>">
		<input type="Hidden" name="volume_no" id="volume_no" value="<%=volume_no%>">
		<input type="Hidden" name="added_items" id="added_items" value="<%=added_items%>">
		<input type="Hidden" name="added_patients" id="added_patients" value="<%=added_patients%>">
		<input type="Hidden" name="show_all_yn" id="show_all_yn" value="<%=show_all_yn%>">
		<input type="Hidden" name="valid_records" id="valid_records" value="<%=valid_records%>">
		<input type="Hidden" name="added_volumes" id="added_volumes" value="<%=added_volumes%>">
		<input type="Hidden" name="transport_mode_desc" id="transport_mode_desc" value="<%=transport_mode_desc%>">
		<input type="Hidden" name="pageflag" id="pageflag" value="<%=pagecount%>">
		<input type="Hidden" name="pagesClicked" id="pagesClicked" value="<%=pagesClicked%>">
	    <input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
    	<input type=hidden name='fromSelect' id='fromSelect' value=''>
	</form>
	<script>
		/*
		parent.criteria_frame.document.forms[0].fs_location1.disabled = true;
		parent.criteria_frame.document.forms[0].fs_req_location.disabled = true;
		parent.criteria_frame.document.forms[0].returning_desc.disabled = true;
		parent.criteria_frame.document.forms[0].ret_button.disabled = true;
		*/
		//parent.criteria_frame.document.forms[0].all_button.disabled = true;
		parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
	</script>
	<%
	if((sqlBuffer != null) && (sqlBuffer.length() >0))
	{
		sqlBuffer.delete(0,sqlBuffer.length());
	}
	if((whereBuffer != null) && (whereBuffer.length() >0))
	{
		whereBuffer.delete(0,whereBuffer.length());
	}
	
	int cnt2=start + cnt;
//	if(!flagSelect.equals("") || chkall.equals("CHECKED"))
	
	//{
	if(executeYN == true) {
		for(int cnt1=start;cnt1<cnt2;cnt1++)
		{%>
			   <SCRIPT LANGUAGE="JavaScript">
						
				<%-- document.getElementById("confirmid")<%=cnt1%>.checked=true;
				document.getElementById("confirmid")<%=cnt1%>.onclick(); --%>
				document.getElementById("confirmid" + <%= cnt1 %>).checked = true;
				document.getElementById("confirmid" + <%= cnt1 %>).onclick();	  
		</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%
		}
	}
	//}
if(preStatement!=null) preStatement.close();
if(resultSet!=null)	resultSet.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(connection,request);
   session.setAttribute("FMreturnToMRDResult", FMreturnToMRDResult);
}
%>
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}

%>

