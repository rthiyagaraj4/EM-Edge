<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet,java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

<%

request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<Script src="../../eFM/js/FMFileSearchComponents.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%



Connection connection			= null;
PreparedStatement preStatement	= null;
PreparedStatement volStatement	= null;
ResultSet	resultSet			= null;
ResultSet	volResultSet		= null;

String facilityID				= "";
String patientID				= "";
String operation				= "";

String sqlString				= "";
String file_no					= "";
String fileType					= "";
String file_type_code			= "";
String file_type_desc			= "";
String fileNo					= "";
String patient_file_type		= "";
String doc_patient_id			= "";
String frame_name               = "";
String form_name                = "";
String messageframe_name        = "";
String patientid_name			= "";
String fileno_name              = "";
String filetype_name            = "";
String volumeno_name            = "";
String file_no_function		    = "";
String file_type_function	    = "";
String patline_ID			    = "";
String external_facility	    = "";
String param_patient_id			= "";
String patient_period_specific  = "D";
String volume_no_appl_yn        = "Y";
String file_type_appl_yn		= "N";
String patline_yn			    = "N";
String patient_name			    = "&nbsp;";
String sqlString1="";
String curr_facility_id="";
String  dflt_file_type="";
String perm_fs_locn_code="";
String dflt_file_no="";
String dflt_flag="";
String file_creat_fac_id1="";
String file_mandatory_yn	= "";
//String search="search";
String selected="";
int rec_count=0;
int vol_cnt = 0;
int vol_cntt = 0;
int vol_cnt1= 0;
int  dfltslt_cnt=0;
int record_count = 0;
int dfltcnt=0;
StringBuffer volumeBuffer =	new StringBuffer();

// For Document Feature - 28/8/2004  starts
String function_type			= "";
String document_folder_id		= "";
String document_type_id			= "";
String document_type_name		= "";
// For Document Feature - 28/8/2004  End.
String doctype_appl_yn = "";

// Function Name
String function_name = "";
String file_mov_flag = "";
String file_creat_fac_id ="";
String curr_fs_locn_identity="";
String fs_req_location="";
String confaciliytid="";
String faciliyt_token="";
String file_token="";
String fileNo_old="";
boolean flag = true;

try
{
	connection = ConnectionManager.getConnection(request);	

	facilityID 			= checkForNull((String) session.getValue("facility_id"));
	patientID			= checkForNull(request.getParameter("patientID"));
	
	external_facility	= checkForNull(request.getParameter("facilityID"));
	operation			= checkForNull(request.getParameter("operation"));
	file_type_appl_yn	= checkForNull(request.getParameter("file_type_appl_yn"));
	fileNo				= checkForNull(request.getParameter("fileNo"));
	fileNo_old=fileNo;
	fileType			= checkForNull(request.getParameter("fileType"));
	patient_file_type	= checkForNull(request.getParameter("patient_file_type"));
	frame_name			= checkForNull(request.getParameter("frame_name"));
		form_name			= checkForNull(request.getParameter("form_name"));
		if(frame_name.equals("parent.cancel_criteria"))
	{
   form_name="FMCancelRequestCriteria_form";
	}
	 messageframe_name	= checkForNull(request.getParameter("messageframe_name"));
	fileno_name			= checkForNull(request.getParameter("fileno_name"));
	if(form_name.equals("fm_req_criteria") || form_name.equals("ConfirmPullingListForm"))
	{
   if(fileno_name.equals("undefined")) fileno_name="p_file_no"; 
	}else{	
	if(fileno_name.equals("undefined")) fileno_name="file_no"; 
	}
	patientid_name		= checkForNull(request.getParameter("patientid_name"));
	filetype_name		= checkForNull(request.getParameter("filetype_name"));
	if(filetype_name.equals("undefined")) filetype_name="file_type_code"; 
	volumeno_name		= checkForNull(request.getParameter("volumeno_name"));
	volume_no_appl_yn	= checkForNull(request.getParameter("volume_no_appl_yn"), "Y");
	file_no_function	= checkForNull(request.getParameter("file_no_function"));
	file_type_function	= checkForNull(request.getParameter("file_type_function"));
	patline_yn			= checkForNull(request.getParameter("patline_yn"), "N");
	patline_ID			= checkForNull(request.getParameter("patline_ID"));
	param_patient_id	= checkForNull(request.getParameter("param_patient_id"));

	// For Document Feature - 28/8/2004  starts
	function_type		= checkForNull(request.getParameter("function_type"));	
	document_folder_id	= checkForNull(request.getParameter("document_folder_id"));	
	document_type_id	= checkForNull(request.getParameter("document_type_id"));
	document_type_name	= checkForNull(request.getParameter("document_type_name"));
	// For Document Feature - 28/8/2004  End.
	doctype_appl_yn		= checkForNull(request.getParameter("doctype_appl_yn"));
	fs_req_location   =checkForNull(request.getParameter("fs_req_location"));
	dflt_flag   =checkForNull(request.getParameter("dflt_flag"));
	// Function Name
	function_name		= checkForNull(request.getParameter("function_name"));
	file_mov_flag		= checkForNull(request.getParameter("file_mov_flag"));
	
	file_mandatory_yn	= checkForNull(request.getParameter("file_mandatory_yn"), "Y");

	
	//if(form_name.equals("FMReturnToMRDCriteriaForm"))
	//{
		sqlString1 = "SELECT count(*) record_count FROM mr_pat_file_index WHERE  patient_id ='"+patientID+"' and doc_folder_id is null ";
	//sqlString1 = "SELECT count(*) record_count  FROM fm_curr_locn WHERE  patient_id ='"+patientID+"' and CURR_FILE_STATUS in('I','O' )  and PERM_FS_LOCN_CODE <>CURR_FS_LOCN_CODE  and  curr_facility_id='"+facilityID+"' ";

	//}else{
	//sqlString1 = "SELECT count(*) record_count FROM mr_pat_file_index WHERE  patient_id ='"+patientID+"' and doc_folder_id is null ";
	//} 
			preStatement	=	connection.prepareStatement(sqlString1);
			resultSet = preStatement.executeQuery();
	if ((resultSet != null) && (resultSet.next()))
	{
			rec_count = resultSet.getInt("record_count");
           }
				 
		   if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
		  			
		   if(form_name.equals("FMReturnToMRDCriteriaForm"))
	     {
		   preStatement	=	connection.prepareStatement(" SELECT facility_id,PERM_FS_LOCN_CODE fs_locn_code FROM fm_curr_locn WHERE  patient_id ='"+patientID+"' and CURR_FILE_STATUS='I' and CURR_FS_LOCN_IDENTITY='D' and PERM_FS_LOCN_CODE <>CURR_FS_LOCN_CODE and  curr_facility_id='"+facilityID+"' ");
	   
		}  else if((form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form")) && !fileNo.equals("") ) {
       preStatement	=	connection.prepareStatement(" SELECT facility_id,fs_locn_code FROM mr_pat_file_index WHERE  patient_id ='"+patientID+"' and file_no='"+fileNo+"'  and doc_folder_id is null ");
		}
	
		else
	   {
	     preStatement	=	connection.prepareStatement(" SELECT facility_id,fs_locn_code FROM mr_pat_file_index WHERE  patient_id ='"+patientID+"' and doc_folder_id is null ");
	   } 
			resultSet = preStatement.executeQuery();
	
	
	
	if ((resultSet != null) && (resultSet.next()))
	{
			file_creat_fac_id = resultSet.getString("facility_id");
        
		  if(form_name.equals("FMReturnToMRDCriteriaForm") || form_name.equals("FMChngStrLocnCriteriaForm"))
	     { 
		    file_creat_fac_id1=file_creat_fac_id;
		   }
		
			if((form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form")) && !fileNo.equals("")  )
		{
       file_creat_fac_id1=file_creat_fac_id;
		}
			
		perm_fs_locn_code = resultSet.getString("fs_locn_code");
	  }
		     if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
       
		 if(perm_fs_locn_code==null || perm_fs_locn_code.equals("null")) perm_fs_locn_code="";
	
			 if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
	
	
	if(file_type_appl_yn.equals("Y") && !fileType.equals(""))
	{
	 if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") || form_name.equals("FMReturnToMRDCriteriaForm"))
	  {
     StringTokenizer file_facility=new StringTokenizer(fileType,"~"); 
	 
		 while(file_facility.hasMoreTokens())
		{
	     file_token    =file_facility.nextToken() ;
	      faciliyt_token=file_facility.nextToken() ;
	   }
	file_creat_fac_id=faciliyt_token;
	fileType=file_token;
	patient_file_type=file_token;
	
	//file_type_code=file_token;
	}
	}
	
	
	if(dflt_flag.equals("true"))
	{
	
	preStatement	=	connection.prepareStatement(" SELECT a.file_type_code file_type_code, b.file_no file_no   FROM fm_file_type_for_fsl a, mr_pat_file_index b  WHERE a.eff_status = 'E'    AND a.fs_locn_code ='"+fs_req_location+"'    AND a.default_yn = 'Y'    AND b.patient_id = '"+patientID+"'    AND a.facility_id ='"+facilityID+"'     AND a.facility_id = b.facility_id  AND  a.file_type_code =b.file_type_code");
		
		resultSet = preStatement.executeQuery();
	if ((resultSet != null) && (resultSet.next()))
	{
			dflt_file_type = resultSet.getString("file_type_code");
            dflt_file_no  = resultSet.getString("file_no"); 
			   }
		   if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
		   if(dflt_file_type==null || dflt_file_type.equals("null")) dflt_file_type="";
		  if(dflt_file_no==null || dflt_file_no.equals("null")) dflt_file_no="";
	}
		 if(file_creat_fac_id==null) file_creat_fac_id="";

      if(!file_creat_fac_id1.equals(facilityID))
					{
		if(form_name.equals("FMChngStrLocnCriteriaForm"))
						{
	 preStatement	=	connection.prepareStatement(" SELECT curr_fs_locn_identity,curr_facility_id  FROM fm_curr_locn WHERE  patient_id ='"+patientID+"' and facility_id='"+file_creat_fac_id+"'  ");
		}else if(form_name.equals("FMReturnToMRDCriteriaForm")){
		preStatement	=	connection.prepareStatement(" SELECT curr_fs_locn_identity,curr_facility_id  FROM fm_curr_locn WHERE  patient_id ='"+patientID+"' and facility_id='"+file_creat_fac_id1+"' and curr_file_status='I' and curr_fs_locn_code='"+fs_req_location+"' ");	
				} else{
   preStatement	=	connection.prepareStatement(" SELECT curr_fs_locn_identity,curr_facility_id  FROM fm_curr_locn WHERE  patient_id ='"+patientID+"' and facility_id='"+file_creat_fac_id+"' and curr_file_status='I' and curr_fs_locn_code='"+fs_req_location+"' ");
							}
			resultSet = preStatement.executeQuery();
	
	if ((resultSet != null) && (resultSet.next()))
	{
			curr_fs_locn_identity = resultSet.getString("curr_fs_locn_identity");
           curr_facility_id = resultSet.getString("curr_facility_id");
		   }
		   if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
			if(curr_fs_locn_identity==null)	 curr_fs_locn_identity="";	
					
					}

%>

<%

	if(!external_facility.equals("")) facilityID = external_facility;

	if(function_type.equals("FileDetails"))
	{
		if(!param_patient_id.equals(""))
		{
			webbeans.op.PatientData patdata = new webbeans.op.PatientData();
			patdata.setFacility_id(facilityID);
			String patient_status = patdata.CheckStatus(connection,param_patient_id);
			if(patient_status.equals("INVALID_PATIENT"))
			{
				flag = false;
				%>
				<script>
					var msg = getMessage('INVALID_VALUE','Common'); 
					msg = msg.replace('#',getLabel('Common.patientId.label','Common'));
					alert(msg);
					eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).value="";
					eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).select();
				</script>
				<%
			}
		}
		
		if(flag)
		{
		//	sqlString = " SELECT file_no, file_type_code FROM fm_curr_locn WHERE facility_id = '"+facilityID+"' ";
			sqlString = " SELECT file_no, file_type_code FROM fm_curr_locn WHERE facility_id = '"+facilityID+"' ";
			if(!document_folder_id.equals(""))
				sqlString = sqlString + " AND doc_folder_id = '"+document_folder_id+"' ";
			if(doctype_appl_yn.equals("Y") && !document_type_id.equals(""))
			{
				sqlString = sqlString + " AND doc_type_code = '"+document_type_id+"' ";
			}
			if(!param_patient_id.equals(""))
			{
				sqlString = sqlString +  " AND patient_id = '"+param_patient_id+"' ";
			}
			sqlString = sqlString + " AND doc_folder_id is NOT NULL ";
	
			preStatement = connection.prepareStatement(sqlString);
			resultSet = preStatement.executeQuery();
			%>
			<script>
				if(eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>)!=undefined)
			eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value = '';
			</script>
			<% 
			while(resultSet.next())
			{
				%>
				<script>
					if(eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value == '')
					{
					eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value = '<%=checkForNull(resultSet.getString("file_no"))%>';
							}
					else
					{
						eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value = eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value + "," + '<%=checkForNull(resultSet.getString("file_no"))%>';
								}
					
					if(eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>).value == '')
					{
						eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>).value = '<%=checkForNull(resultSet.getString("file_type_code"))%>';
					}
					if(eval(<%=frame_name%>.document.<%=form_name%>).patient_file_type.value == '')
					{
						eval(<%=frame_name%>.document.<%=form_name%>).patient_file_type.value = '<%=checkForNull(resultSet.getString("file_type_code"))%>';
					}	
				</script>
				<%
			}
		}
	}
	else if(function_type.equals("DocumentOnly"))
	{
		sqlString = " SELECT patient_period_specific, patient_id FROM fm_doc_folder WHERE facility_id = ? AND doc_folder_id = ? ";
		
		preStatement = connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, document_folder_id);
		resultSet = preStatement.executeQuery();
		if((resultSet != null) && (resultSet.next()))
		{
			patient_period_specific = resultSet.getString("patient_period_specific");
			doc_patient_id = resultSet.getString("patient_id");
			if(patient_period_specific == null || patient_period_specific.equals("null")) 					patient_period_specific = "D";
			if(doc_patient_id == null || patient_period_specific.equals("null")) 	
				doc_patient_id = "";
		}

		if(resultSet != null) resultSet.close();
		if(preStatement != null) preStatement.close();
			
		%>
		<script>
			if('<%=patient_period_specific%>' == 'P')
			{
				eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).value = '<%=doc_patient_id%>';
				eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).readOnly = true;
				eval(<%=frame_name%>.document.<%=form_name%>).pat_search.disabled = true;
			}
			else
			{
			
				eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).value = '';
				eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).readOnly = false;
				eval(<%=frame_name%>.document.<%=form_name%>).pat_search.disabled = false;
			}
		</script>
		<%
		sqlString =	" SELECT a.doc_type_code, b.doc_type_name FROM fm_doc_type_in_folder a, fm_doc_type b WHERE a.doc_type_code = b.doc_type_code and facility_id = ? AND doc_folder_id = ? ";

		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();

		preStatement = connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, document_folder_id);
		resultSet = preStatement.executeQuery();

		int count = 0;

		if(resultSet != null)
		{
			%>
			<script>
				var selectBox =
				eval(<%=frame_name%>.document.<%=form_name%>.<%=document_type_name%>);
				var seletLen  =	Math.abs(selectBox.length);
				for (i=0; i<seletLen; i++)
					selectBox.remove(0);
				var selectOption   =  eval(<%=frame_name%>).document.createElement("OPTION");		
				selectOption.value =	"";
				selectOption.text  =	"-----"+getLabel("Common.defaultSelect.label","common")+"-----";
				selectBox.add(selectOption);
			</script>
			<%
			while(resultSet.next())
			{
				document_type_id	=	checkForNull(resultSet.getString("doc_type_code"));
				count++;
				%>
				<script>
					var selectBox   =
					eval(<%=frame_name%>.document.<%=form_name%>.<%=document_type_name%>);
					var selectOption	=  eval(<%=frame_name%>).document.createElement("OPTION");	
					var code = '<%=checkForNull(resultSet.getString("doc_type_code"))%>';
					var desc = '<%=checkForNull(resultSet.getString("doc_type_name"))%>';
					if(code != '')
					{
						selectOption.value	=	code;
						selectOption.text	=	desc;
						selectBox.add(selectOption);
					}
				</script>
				<%
			}
			%>
			<script>
				if ("<%=count%>"=="1")
				{
				eval(<%=frame_name%>.document.<%=form_name%>.<%=document_type_name%>).options[1].selected = true; 
				}
			</script>
			<%
		}	
		if(count == 1)
		{
			sqlString = " SELECT file_no, file_type_code FROM fm_curr_locn WHERE facility_id = '"+facilityID+"'  AND doc_folder_id = '"+document_folder_id+"' AND doc_type_code = '"+document_type_id+"' ";
		
			}
		else if(count > 1)
		{
			sqlString = " SELECT file_no, file_type_code FROM fm_curr_locn WHERE facility_id = '"+facilityID+"'  AND doc_folder_id = '"+document_folder_id+"' ";
		}
		if(!doc_patient_id.equals(""))
		{
			sqlString  = sqlString + " AND patient_id = '"+doc_patient_id+"' ";
		}

	
	
	
	if 	(count >= 1){		
		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		preStatement = connection.prepareStatement(sqlString);
		resultSet = preStatement.executeQuery();
	}

		if (count == 1)
		{
			if ((resultSet != null) && (resultSet.next()))
			{
				%>
				<script>
					eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value = '<%=checkForNull(resultSet.getString("file_no"))%>';
					eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>).value = '<%=checkForNull(resultSet.getString("file_type_code"))%>';
					eval(<%=frame_name%>.document.<%=form_name%>).patient_file_type.value = '<%=checkForNull(resultSet.getString("file_type_code"))%>';
					</script>
				<%
			}
		}
		else
		{
			while((resultSet != null) && (resultSet.next()))
			{
				%>
				<script>
					if(eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value == '')
					{
						eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value = '<%=checkForNull(resultSet.getString("file_no"))%>';
					}
					else
					{
						eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value = eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value + "," + '<%=checkForNull(resultSet.getString("file_no"))%>';
							}
					
					if(eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>).value == '')
					{
						eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>).value = '<%=checkForNull(resultSet.getString("file_type_code"))%>';
					}
					if(eval(<%=frame_name%>.document.<%=form_name%>).patient_file_type.value == '')
					{
						eval(<%=frame_name%>.document.<%=form_name%>).patient_file_type.value = '<%=checkForNull(resultSet.getString("file_type_code"))%>';
					}
				</script>
				<%
			}
		}
	}
	else
	{
		if(!patientID.equals(""))
		{
			webbeans.op.PatientData patdata = new webbeans.op.PatientData();
			patdata.setFacility_id(facilityID);
			String patient_status = patdata.CheckStatus(connection,patientID);
			if(patient_status.equals("INVALID_PATIENT"))
			{
				flag = false;
				%>
				<script>
					var msg = getMessage('INVALID_VALUE','Common'); 
					msg = msg.replace('#',getLabel('Common.patientId.label','Common'));
					alert(msg);
					eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).value="";
					eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).select();
					patientID="";
					if("<%=volume_no_appl_yn%>"=="Y")
					{
						var selectBox   =
						eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
						var seletLen	=	Math.abs(selectBox.length);
						for (i=0; i<seletLen; i++)
							selectBox.remove(0);
						var selectOption	=  eval(<%=frame_name%>).document.createElement("OPTION");		
						selectOption.value	=	"";
						selectOption.text	=	"-----"+getLabel("Common.defaultSelect.label","common")+"-----";
						selectBox.add(selectOption);
					}
				</script>
				<%		
			}
		}


if(flag)
		{
		  		if(function_name.equals("FileDeficiencyMonitoring"))
			{

		if(!patientID.equals(""))
					{
					%>
					<script>
					eval(<%=frame_name%>.document.<%=form_name%>.encounter_id).disabled=false;
					eval(<%=frame_name%>.document.<%=form_name%>.encounter_id_search).disabled=false;
					</script>
					<%
					}

			}
		}
      if(flag){			
		if(fileNo.equals("") && fileType.equals(""))
		{
		  if(file_type_appl_yn.equals("N")){
			 if(form_name.equals("FMReturnToMRDCriteriaForm")){
				if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D")){
					sqlString = "SELECT  count(*) record_count from mr_pat_file_index  WHERE  facility_id ='"+file_creat_fac_id1+"' and patient_id='"+patientID+"' ";
				}else{
				sqlString = "SELECT  count(*) record_count from fm_Curr_Locn  WHERE curr_file_status in ('O' ,'I') and perm_fs_locn_code <> curr_fs_locn_code and doc_folder_id is  null AND curr_facility_id ='"+facilityID+"' and patient_id= '"+patientID+"' ";
				}
			 }else if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){
                sqlString = "SELECT count(*) record_count FROM mr_pat_file_index WHERE  patient_id ='"+patientID+"' and doc_folder_id is null ";
			 }else{
			    sqlString = "SELECT count(*) record_count FROM mr_pat_file_index WHERE facility_id = '"+file_creat_fac_id+"' AND patient_id ='"+patientID+"' and doc_folder_id is null ";
			  }	
		  }	else if(file_type_appl_yn.equals("Y")){
				if(form_name.equals("FMConfirmRcptCriteria_form")){
					//sqlString = "SELECT  count(*) record_count FROM  fm_Transit_File a , fm_Curr_Locn c WHERE A.dest_Facility_Id = ?   AND a.File_No = c.File_No   AND a.src_Facility_Id = c.Curr_Facility_Id   AND a.Volume_No = c.Volume_No   AND c.Curr_File_Status IN ('T','E')   AND c.Doc_Folder_Id IS  NULL AND c.patient_id = ? ";
					sqlString = "SELECT  count(*) record_count FROM  fm_Transit_File a , fm_Curr_Locn c WHERE A.dest_Facility_Id = ?   AND a.File_No = c.File_No   AND a.Volume_No = c.Volume_No   AND c.Curr_File_Status IN ('T','E')  and c.Doc_Folder_Id IS  NULL AND c.patient_id = ? ";				
			   }else if(form_name.equals("FMReturnToMRDCriteriaForm")){
				  if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D")){
					sqlString = "SELECT  count(*) record_count from mr_pat_file_index  WHERE  facility_id =? and patient_id= ? ";
				  }else{
					sqlString = "SELECT  count(*) record_count from fm_Curr_Locn  WHERE curr_file_status in( 'O' ,'I') and  perm_fs_locn_code <> curr_fs_locn_code and doc_folder_id is  null AND curr_facility_id =? and patient_id= ? ";
				  }
				}else if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){
				 	sqlString = "SELECT count(*) record_count FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND  b.patient_id ='"+patientID+"' ";
				 }else	{
				  sqlString = "SELECT count(*) record_count FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND a.facility_id=? AND b.patient_id =? ";
				}
			}

			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
		    preStatement	=	connection.prepareStatement(sqlString);			
				//if(form_name.equals("FMCancelRequestCriteria_form") || //form_name.equals("FMTransferFileCriteria_form"))
			if(file_type_appl_yn.equals("N")){				
			}
			if(file_type_appl_yn.equals("Y")){
				if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form"))
				{
				}else{
					if(form_name.equals("FMChngStrLocnCriteriaForm")) {
						//preStatement.setString(1,file_creat_fac_id);
					}else if(form_name.equals("FMReturnToMRDCriteriaForm") && !file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D")){
						preStatement.setString(1, file_creat_fac_id1);
					    preStatement.setString(2, patientID);					
				    }else{
						preStatement.setString(1, facilityID);
					    preStatement.setString(2, patientID);
					}			
	       		} 
			}
			resultSet = preStatement.executeQuery();
			if ((resultSet != null) && (resultSet.next()))
			record_count = resultSet.getInt("record_count");				
			if((form_name.equals("FMReturnToMRDCriteriaForm") ||  form_name.equals("FMConfirmRcptCriteria_form")) && record_count>1 && rec_count==1)	{
              record_count=rec_count;
			}
			
			if(file_type_appl_yn.equals("N")){
				if(form_name.equals("FMReturnToMRDCriteriaForm")){		
				   if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D")){
					  sqlString = "SELECT DISTINCT File_no file_no  FROM  fm_Curr_Locn  WHERE curr_file_status ='I' and perm_fs_locn_code <> curr_fs_locn_code and   curr_fs_locn_code='"+fs_req_location+"'  and doc_folder_id is  null AND facility_id ='"+file_creat_fac_id1+"'  AND patient_id ='"+patientID+"' ";
					}else{
                      sqlString = "SELECT DISTINCT File_no file_no  FROM  fm_Curr_Locn  WHERE curr_file_status in('O','I') and  perm_fs_locn_code <> curr_fs_locn_code  and doc_folder_id is  null AND curr_facility_id ='"+facilityID+"'  AND patient_id ='"+patientID+"' ";
					}
				}else if(form_name.equals("FMConfirmRcptCriteria_form")){
				   sqlString ="SELECT  DISTINCT a.file_no file_no FROM  fm_Transit_File a  , fm_Curr_Locn c WHERE  A.dest_Facility_Id ='"+facilityID+"'  AND a.File_No = c.File_No AND a.volume_no = c.volume_no   AND c.Curr_File_Status IN ('T','E') AND c.Doc_Folder_Id IS  NULL AND c.patient_id ='"+patientID+"' ";
				}else if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){
				   sqlString = "SELECT file_no  FROM  mr_pat_file_index  WHERE patient_id ='"+patientID+"' ";
				}else{									
					//	sqlString = "SELECT b.file_no file_no  FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND a.facility_id ='"+facilityID+"' AND b.patient_id ='"+patientID+"' ";
					sqlString = "SELECT file_no  FROM  mr_pat_file_index WHERE  facility_id ='"+facilityID+"' AND patient_id ='"+patientID+"' ";
				}			
			}else if(file_type_appl_yn.equals("Y")){
				if(form_name.equals("FMConfirmRcptCriteria_form")){	
				   sqlString ="SELECT  DISTINCT a.File_Type_Code file_type_code,a.facility_id facility_id , MR_GET_DESC.MR_FILE_TYPE(A.FACILITY_ID, A.FILE_TYPE_CODE,'en','2') file_type_desc FROM  fm_Transit_File a  , fm_Curr_Locn c WHERE  A.dest_Facility_Id = ?  AND a.File_No = c.File_No AND a.volume_no = c.volume_no   AND c.Curr_File_Status IN ('T','E') AND c.Doc_Folder_Id IS  NULL AND c.patient_id = ? ";
				}else if(form_name.equals("FMReturnToMRDCriteriaForm")){							
					if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D")){
					  sqlString = "SELECT DISTINCT File_Type_Code file_type_code, facility_id , mr_get_desc.MR_FILE_TYPE(facility_id,File_Type_Code,'"+localeName+"',2) file_type_desc  FROM  fm_Curr_Locn  WHERE curr_file_status ='I' and  perm_fs_locn_code <> curr_fs_locn_code and doc_folder_id is  null AND curr_fs_locn_code='"+fs_req_location+"' and  facility_id = ?  AND patient_id= ? ";
					}else{
                       sqlString = "SELECT DISTINCT File_Type_Code file_type_code,facility_id , mr_get_desc.MR_FILE_TYPE(facility_id,File_Type_Code,'"+localeName+"',2) file_type_desc  FROM  fm_Curr_Locn  WHERE curr_file_status in ( 'O','I') and perm_fs_locn_code <> curr_fs_locn_code and  doc_folder_id is  null AND curr_facility_id = ?  AND patient_id= ? ";
					}				
				}else if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){				
					sqlString = "SELECT b.file_type_code file_type_code, a.short_desc file_type_desc , b.facility_id facility_id  FROM  mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code  AND b.patient_id ='"+patientID+"' ";
				}else{
					sqlString = "SELECT b.file_type_code file_type_code, a.short_desc file_type_desc FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND a.facility_id =? AND b.patient_id = ? ";
				}
			}		
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();	
			preStatement	=	connection.prepareStatement(sqlString);
			if(file_type_appl_yn.equals("N")){
			}
			if(file_type_appl_yn.equals("Y")){
				if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){             
			 }					
			if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D") && form_name.equals("FMReturnToMRDCriteriaForm"))
			{
			  preStatement.setString(1, file_creat_fac_id1);
		 	  preStatement.setString(2, patientID);
			}else if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm")){             
			 }else{
				preStatement.setString(1, facilityID);
				preStatement.setString(2, patientID);
			 }
		 }
		
		 resultSet = preStatement.executeQuery();
			
		
			if(resultSet != null){ 				
				if(form_name.equals("FMConfirmRcptCriteria_form")){
				  rec_count=record_count;
				}
				if(file_type_appl_yn.equals("N")){						
					if(record_count==0){%>
						<script>
							if("<%=form_name%>" == "FMChngStrLocnCriteriaForm")
							{
							eval(<%=frame_name%>.document.getElementById("FileNo")).innerHTML = "<input type='text' name='<%=fileno_name%>' id='<%=fileno_name%>' onKeyPress='return CheckForSpecChars(event)' value='' onBlur='getPatIDVolume(this.value);<%=file_no_function%>' maxlength='20' size='20'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
							}
							else
							{
								if("<%=form_name%>" == "FMChngStrLocnCriteriaForm")
								{
									eval(<%=frame_name%>.document.getElementById("FileNo")).innerHTML = "<input type='text' name='<%=fileno_name%>' id='<%=fileno_name%>' onKeyPress='return CheckForSpecChars(event)' value='' onBlur='getPatIDVolume(this.value);<%=file_no_function%>' maxlength='20' size='20'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
								}
								else
								{
									var filenoTxt	= "<input type='text' name='<%=fileno_name%>' id='<%=fileno_name%>' onKeyPress='return CheckForSpecChars(event)' value='' onBlur='getPatIDVolume(this.value);<%=file_no_function%>' maxlength='20' size='20'>";
									if("<%=file_mandatory_yn%>"=="Y"){
										filenoTxt += "<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
									}
									eval(<%=frame_name%>.document.getElementById("FileNo")).innerHTML = filenoTxt;
								}
							}
							if ("<%=volume_no_appl_yn%>"=="Y")
							{
							   var selectBox  =eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);							
								var seletLen	=	Math.abs(selectBox.length);
								for (i=0; i<seletLen; i++)
									selectBox.remove(0);
								var selectOption	=  eval(<%=frame_name%>).document.createElement("OPTION");		
								selectOption.value	=	"";
								selectOption.text	=	"-----"+getLabel("Common.defaultSelect.label","common")+"-----";
								selectBox.add(selectOption);
							}
						</script>
						<%
						}else if(record_count==1){
						  if(resultSet.next()){
							file_no = checkForNull(resultSet.getString("file_no"));
							%>
							<script>
							if("<%=form_name%>" == "FMChngStrLocnCriteriaForm")
							{
							eval(<%=frame_name%>.document.getElementById("FileNo")).innerHTML = "<input type='text' name='"+"<%=fileno_name%>"+"' id='"+"<%=fileno_name%>"+"' onKeyPress='return CheckForSpecChars(event)' value='"+"<%=file_no%>"+"' onBlur='getPatIDVolume(this.value);<%=file_no_function%>' maxlength='20' size='20'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
							}
							else
							{
								var filenoTxt	= "<input type='text' name='"+"<%=fileno_name%>"+"' id='"+"<%=fileno_name%>"+"' onKeyPress='return CheckForSpecChars(event)' value='"+"<%=file_no%>"+"' onBlur='getPatIDVolume(this.value);<%=file_no_function%>' maxlength='20' size='20'>";
								if("<%=file_mandatory_yn%>"=="Y"){
									filenoTxt +=  "<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
								}
								eval(<%=frame_name%>.document.getElementById("FileNo")).innerHTML = filenoTxt;
							}
							</script>
							<%
															
							if(volume_no_appl_yn.equals("Y"))
							{
								
								if((volumeBuffer != null) && (volumeBuffer.length() > 0))
									volumeBuffer.delete(0, volumeBuffer.length());
								
								volumeBuffer.append("SELECT distinct volume_no,VOLUME_STATUS FROM fm_curr_locn WHERE facility_id = '");
								
						       if(form_name.equals("FMReturnToMRDCriteriaForm") && !file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D"))
					        {
							volumeBuffer.append(file_creat_fac_id1);
								}else{
                               volumeBuffer.append(facilityID);
								}
								
								volumeBuffer.append("' and patient_id = '");
								volumeBuffer.append(patientID);
								volumeBuffer.append("' ");
								
								if(!file_no.equals(""))
								{
									volumeBuffer.append(" AND file_no = '");
									volumeBuffer.append(file_no);
									volumeBuffer.append("' ");
								}
								
							volumeBuffer.append("ORDER BY volume_no desc ");
								
							
								
								if(volStatement != null) volStatement = null;
								if(volResultSet != null) volResultSet = null;

										
								
								
								volStatement	=	connection.prepareStatement(volumeBuffer.toString());
														
								volResultSet	=	volStatement.executeQuery();	
								
								
								if(volResultSet != null)
								{
									%>
									<script>
								
								 var dfltslt_cnt="<%=dfltslt_cnt%>";
									var selectBox = eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
										
										
										var seletLen = Math.abs(selectBox.length);
										for (i=0; i<seletLen; i++)
											selectBox.remove(0);
										var selectOption =  eval(<%=frame_name%>).document.createElement("OPTION");		
								//	selectOption.value	=	"";
									//	selectOption.text	=	"-----"+getLabel('Common.defaultSelect.label','common')+"-----";
								//		selectBox.add(selectOption);
										<%
										while(volResultSet.next())
										{
											vol_cnt++;
                           						%>
												
											if(eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value !=""){
											selectOption		=  eval(<%=frame_name%>).document.createElement("OPTION");		
											selectOption.value	=	'<%=checkForNull(volResultSet.getString("volume_no"))%>';
											selectOption.text	=	'<%=checkForNull(volResultSet.getString("volume_no"))%>';
											selectBox.add(selectOption);
											}
											else{
                       
					             	 if(dfltslt_cnt==0)
					      	         {
					      	       selectOption.value	=	"";
							      selectOption.text	=	"-----"+getLabel('Common.defaultSelect.label','common')+"-----";
						            selectBox.add(selectOption);
						        }
				             	}
							<%
								dfltslt_cnt++;				
								}
										%>
									</script>
									<%
								}
							}
						}
							%>
						<script>
											
							if("<%=form_name%>"=="FMConfirmRcptCriteria_form")
							{								
								<%if(record_count == 1 && vol_cnt == 1){%>
									eval(<%=frame_name%>).AddFiles(<%=vol_cnt%>);
								<%}%>
							}
							if("<%=form_name%>"=="ConfirmPullingListForm")
							{
								<%if(record_count == 1 && vol_cnt == 1){%>
									eval(<%=frame_name%>).addFiles_confirm();
								<%}%>
							}
							if("<%=function_name%>" == "FMReceiveFileMRD"  )
							{
								<%if(record_count == 1 && vol_cnt == 1){%>
									eval(<%=frame_name%>).addFiles(<%=vol_cnt%>);
								<%}%>
							}
							else if("<%=function_name%>" == "FMRetutnToMRD")
							{
								<%if(record_count == 1 && vol_cnt == 1){%>
									eval(<%=frame_name%>).searchForRecord(<%=vol_cnt%>);
								<%}%>
							}
							else if("<%=form_name%>" == "FileIsuueTab")
							{															
								<%if(record_count == 1 && vol_cnt == 1){%>
									eval(<%=frame_name%>).submitAllDetails();
								<%}%>
							}
							
						else if("<%=form_name%>"=="FMCancelRequestCriteria_form")
				         {					
					<%if(record_count == 1 && vol_cnt == 1){%>
					eval(<%=frame_name%>).AddFiles();
					<%}%>
				       }	
						
							
						
							
							else if("<%=form_name%>" == "FMChngStrLocnCriteriaForm")
							{															
								var search='search';
								<%
									if(record_count == 1 && vol_cnt == 1){%>
									eval(<%=frame_name%>).fetchResults(search);
								<%}%>
							}
						</script>
						<%
					}
					else if(record_count > 1)
					{
																
						%>
						<script>
							var optionValue	= "";	
							<%
							while(resultSet.next())
							{
								file_no		=	checkForNull(resultSet.getString("file_no"));
								if(file_no.equals(dflt_file_no))
								{
								dfltcnt++;
								selected="selected";
								patient_file_type=file_type_code;
								%>
							  optionValue = optionValue + "<option value='"+"<%=file_no%>"+"' <%=selected%>>"+"<%=file_no%>"+"</option>";
							<% 
								} else{
								%>
								optionValue = optionValue + "<option value='"+"<%=file_no%>"+"'>"+"<%=file_no%>"+"</option>";
								<%
							}
								}
							%>
							var selectBox	= "<select name='<%=fileno_name%>' id='<%=fileno_name%>' value = '' onChange='populateFileVolume(\"<%=patientID%>\",this.value,\"<%=fileType%>\");<%=file_no_function%>' onmousewheel='return false;' ><option>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>";
							selectBox += optionValue;
							//if("<%=form_name%>" == "FMChngStrLocnCriteriaForm")
							//{
						//	selectBox += "</select>";
							//}
							//else
							//{
								selectBox += "</select>&nbsp;";
								if("<%=file_mandatory_yn%>"=="Y"){
									selectBox +="<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
								}
						//	}
							eval(<%=frame_name%>.document.getElementById("FileNo")).innerHTML = selectBox;
					
					eval(<%=frame_name%>).populateFileVolume("<%=patientID%>",eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value,"<%=fileType%>");
			
	//eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).onblur(); 
										
						</script>
						<%	}
						%>
							
			<%	}
				else
				if(file_type_appl_yn.equals("Y"))
				{						
					if(record_count == 0)
					{
						%>
						<script>
						if("<%=form_name%>" == "FMChngStrLocnCriteriaForm")
						{	
						//	console.log("942");
							eval(<%=frame_name%>.document.getElementById("FileType")).innerHTML = "<input type='text' name='<%=filetype_name%>' id='<%=filetype_name%>'  value='' readOnly onBlur='<%=file_type_function%>'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
						}
						else
						{
							var fileTypeTxt	= "<input type='text' name='<%=filetype_name%>' id='<%=filetype_name%>'  value='' readOnly onBlur='<%=file_type_function%>'>";
							if("<%=file_mandatory_yn%>"=="Y"){
								fileTypeTxt += "<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
							}
							eval(<%=frame_name%>.document.getElementById("FileType")).innerHTML = fileTypeTxt;
						}
							if ("<%=volume_no_appl_yn%>" == "Y")
							{
								var selectBox   =
								eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
								var seletLen	=	Math.abs(selectBox.length);
								for (i=0; i<seletLen; i++)
									selectBox.remove(0);
								var selectOption	=  eval(<%=frame_name%>).document.createElement("OPTION");		
								selectOption.value	=	"";
								selectOption.text	=	"-----"+getLabel("Common.defaultSelect.label","common")+"-----";
								selectBox.add(selectOption);
							}
						</script>
						<%
					}
					else if(record_count == 1)
					{
						if(resultSet.next())
						{
							file_type_code		=	checkForNull(resultSet.getString("file_type_code"));
						//	patient_file_type	=	checkForNull(resultSet.getString("file_type_code"));
							file_type_desc		=	checkForNull(resultSet.getString("file_type_desc"));
							patient_file_type=file_type_code;
						if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") || form_name.equals("FMReturnToMRDCriteriaForm"))
							  {
									confaciliytid=checkForNull(resultSet.getString("facility_id"));
									file_type_code=file_type_code+"~"+confaciliytid;			
							       file_creat_fac_id=confaciliytid;
							  }
										
										
										%>
							<script>
															
						if("<%=form_name%>" == "FMChngStrLocnCriteriaForm")
							{	eval(<%=frame_name%>.document.getElementById("FileType")).innerHTML = "<input type='text' name='"+"<%=filetype_name%>"+"' id='"+"<%=filetype_name%>"+"' readOnly value='"+"<%=file_type_desc%>"+"' onBlur=' <%=file_type_function%>'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
							}
							else
							{
								var fileTypeTxt	= "<input type='text' name='"+"<%=filetype_name%>"+"' id='"+"<%=filetype_name%>"+"' readOnly value='"+"<%=file_type_desc%>"+"' onBlur=' <%=file_type_function%>'>";
								if("<%=file_mandatory_yn%>"=="Y"){
									fileTypeTxt += "<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
								}
								eval(<%=frame_name%>.document.getElementById("FileType")).innerHTML = fileTypeTxt;
							}
								eval(<%=frame_name%>.document.<%=form_name%>).patient_file_type.value = "<%=file_type_code%>";	
								eval(<%=frame_name%>.document.<%=form_name%>).patient_file_type_desc.value = "<%=file_type_desc%>";	
							</script>
							<%
								
							if(volume_no_appl_yn.equals("Y"))
							{
								if((volumeBuffer != null) && (volumeBuffer.length() > 0))
									volumeBuffer.delete(0, volumeBuffer.length());
								
								
							if(form_name.equals("FMReturnToMRDCriteriaForm"))
									{
								volumeBuffer.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = '");
									}
									else
								{
								volumeBuffer.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = '");
									}
								//volumeBuffer.append(facilityID);
							//	volumeBuffer.append("' and patient_id = '");
								volumeBuffer.append(patientID);
								volumeBuffer.append("' ");
								
							
								if(!patient_file_type.equals("") && (!file_type_code.equals("undefined")))
								{
									volumeBuffer.append(" AND file_type_code = '");
									volumeBuffer.append(patient_file_type);
									volumeBuffer.append("' ");
								}
								volumeBuffer.append(" AND facility_id = '");
							if(form_name.equals("FMReturnToMRDCriteriaForm"))
			                   	{
				           	  if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D"))
					            {
								volumeBuffer.append(file_creat_fac_id1);
								} else{
                                 volumeBuffer.append(facilityID);
								   }
								} else if(form_name.equals("FMTransferFileCriteria_form")){
                                           if(file_creat_fac_id1.equals("")) file_creat_fac_id1=file_creat_fac_id;
											volumeBuffer.append(file_creat_fac_id1);
											} else  if(form_name.equals("FMChngStrLocnCriteriaForm")){
                                  	   volumeBuffer.append(file_creat_fac_id1);
								         } 										
											else{
                              volumeBuffer.append(facilityID);
								
								
								}
						    	volumeBuffer.append("' ");
								volumeBuffer.append("ORDER BY volume_no desc ");
									if(volResultSet!=null)	volResultSet.close();
								if(volStatement!=null) volStatement.close();
															
								volStatement	=	
								connection.prepareStatement(volumeBuffer.toString());
							volResultSet	=	volStatement.executeQuery();	
								if(volResultSet != null)
								{
									%>
									<script>
					var selectBox   = eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
					var seletLen	=	Math.abs(selectBox.length);
					for (i=0; i<seletLen; i++)
						selectBox.remove(0);
					var selectOption	=  eval(<%=frame_name%>.document).createElement("OPTION");		
				/*	selectOption.value	=	"";
					selectOption.text	=	"----"+getLabel("Common.defaultSelect.label","common")+"----";
					selectBox.add(selectOption);*/
			     	</script>
								
								
									
									
									<!--	<script>
										var selectBox = 										eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
										var seletLen	=	Math.abs(selectBox.length);
										for (i=0; i<seletLen; i++)
											selectBox.remove(0);
										var selectOption	=  eval(<%=frame_name%>.document).createElement("OPTION");		
								//		selectOption.value	=	"";
								//		selectOption.text	=	"-Select-";
								//		selectBox.add(selectOption);-->
										
									<%	while(volResultSet.next())
									{
									      vol_cnt++;
												%>
									<script>
					if(eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>).value !="")
					{
						var selectBox		= eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
						var selectOption	= eval(<%=frame_name%>.document).createElement("OPTION");		
						selectOption.value	= '<%=checkForNull(volResultSet.getString("volume_no"))%>';
						selectOption.text	= '<%=checkForNull(volResultSet.getString("volume_no"))%>';
						selectBox.add(selectOption);
								
					}
					else{
                       
					 	var dfltslt_cnt="<%=dfltslt_cnt%>";
						 if(dfltslt_cnt==0)
					       {
					     var selectBox		= eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
						var selectOption	= eval(<%=frame_name%>.document).createElement("OPTION");
						  
						  selectOption.value	=	"";
					     selectOption.text	=	"-----"+getLabel('Common.defaultSelect.label','common')+"-----";
						 selectBox.add(selectOption);
						   }
				         	}
					</script>
												
							<!--	selectOption =  eval(<%=frame_name%>.document).createElement("OPTION");	
							selectOption.value	=	<%=checkForNull(volResultSet.getString("volume_no"))%>';
								selectOption.text	=	'<%=checkForNull(volResultSet.getString("volume_no"))%>';
								selectBox.add(selectOption);-->
											<%
											dfltslt_cnt++;
											}
									%>
								<!--	</script>  -->
									<%
								}
							} 
						}
					}
					else if(record_count > 1)
					{%>
						<script>
							eval(<%=frame_name%>.document.<%=form_name%>).patient_file_type.value = "";	
							eval(<%=frame_name%>.document.<%=form_name%>).patient_file_type_desc.value = "";	
							var optionValue	= "";	
							<%
							while(resultSet.next())
							{
								file_type_code	=checkForNull(resultSet.getString("file_type_code"));										
								file_type_desc		=	checkForNull(resultSet.getString("file_type_desc"));
								if(dflt_file_type.equals(file_type_code))
								{
								dfltcnt=1;
								selected="selected";
								patient_file_type=file_type_code;
								file_creat_fac_id=facilityID;
								if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") || form_name.equals("FMReturnToMRDCriteriaForm"))
							  {
									confaciliytid=checkForNull(resultSet.getString("facility_id"));
									file_type_code=file_type_code+"~"+confaciliytid;			
							 		  }
								
								%>
							 
								optionValue = optionValue + "<option value='"+"<%=file_type_code%>"+"'<%=selected%> >"+"<%=file_type_desc%>"+"</option>";
								<% 
								}else{
									if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") || form_name.equals("FMReturnToMRDCriteriaForm") )
							  {
									confaciliytid=checkForNull(resultSet.getString("facility_id"));
									file_type_code=file_type_code+"~"+confaciliytid;			
							 		  }
									
									
									%>
                                optionValue = optionValue + "<option value='"+"<%=file_type_code%>"+"'>"+"<%=file_type_desc%>"+"</option>";
                            	<%}
							
							} 
							%>
														
							if("<%=form_name%>" == "FMChngStrLocnCriteriaForm")
							{
							var selectBox	= "<select name='<%=filetype_name%>' id='<%=filetype_name%>' onChange='setValues(this.value);populateFileVolume(\"<%=patientID%>\",\"<%=fileNo%>\",this.value);<%=file_type_function%>' onmousewheel='return false;'><option value = '' >----------"+getLabel('Common.defaultSelect.label' ,'common') + "---------</option>";
							selectBox += optionValue;
							selectBox += "</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
							}
							else
							{
								var selectBox	= "<select name='<%=filetype_name%>' id='<%=filetype_name%>' onChange='setValues(this.value);populateFileVolume(\"<%=patientID%>\",\"<%=fileNo%>\",this.value);<%=file_type_function%>' onmousewheel='return false;' ><option value = '' >----------"+getLabel('Common.defaultSelect.label' ,'common') + "---------</option>";
								selectBox += optionValue;

								if("<%=file_mandatory_yn%>"=="Y"){
									selectBox += "</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
								}
							}
							eval(<%=frame_name%>.document.getElementById("FileType")).innerHTML = selectBox;
								
						eval(<%=frame_name%>).setValues(eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>).value);
													
							</script>
						<%
					
							if(volume_no_appl_yn.equals("Y") && dfltcnt==1)
							{
								if((volumeBuffer != null) && (volumeBuffer.length() > 0))
									volumeBuffer.delete(0, volumeBuffer.length());
								
								
							if(form_name.equals("FMReturnToMRDCriteriaForm"))
									{
								volumeBuffer.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = '");
									}
									else
								{
								volumeBuffer.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = '");
									}
								//volumeBuffer.append(facilityID);
							//	volumeBuffer.append("' and patient_id = '");
								volumeBuffer.append(patientID);
								volumeBuffer.append("' ");
								
								if(!patient_file_type.equals("") && (!file_type_code.equals("undefined")))
								{
									volumeBuffer.append(" AND file_type_code = '");
									volumeBuffer.append(patient_file_type);
									volumeBuffer.append("' ");
								}
								if(form_name.equals("FMChngStrLocnCriteriaForm"))
								{
								volumeBuffer.append(" AND curr_facility_id = '");
								}else{
								volumeBuffer.append(" AND facility_id = '");
								}
								if(form_name.equals("FMReturnToMRDCriteriaForm"))
			                   	{
				           	  if(!file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D"))
					            {
								volumeBuffer.append(file_creat_fac_id1);
								} else{
                                   volumeBuffer.append(facilityID);
								}
										}else{
                              volumeBuffer.append(facilityID);
								
								
								}
									
									volumeBuffer.append("' ");
								volumeBuffer.append("ORDER BY volume_no desc ");
								if(volResultSet!=null)	volResultSet.close();
								if(volStatement!=null) volStatement.close();
					
														
								volStatement	=	connection.prepareStatement(volumeBuffer.toString());
								volResultSet	=	volStatement.executeQuery();	
								if(volResultSet != null)
								{
									%>
									<script>
					var selectBox   = eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
					var seletLen	=	Math.abs(selectBox.length);
					for (i=0; i<seletLen; i++)
						selectBox.remove(0);
					var selectOption	=  eval(<%=frame_name%>.document).createElement("OPTION");		
				
			     	</script>
					<%	while(volResultSet.next())
					{
				     vol_cnt++;
					%>
					
					
					<script>
					
				if(eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>).value !=""){
					
						var selectBox		= eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
						var selectOption	= eval(<%=frame_name%>.document).createElement("OPTION");		
						selectOption.value	= '<%=checkForNull(volResultSet.getString("volume_no"))%>';
						selectOption.text	= '<%=checkForNull(volResultSet.getString("volume_no"))%>';
						selectBox.add(selectOption);
								
					}else{
                       
					 	var dfltslt_cnt="<%=dfltslt_cnt%>";
						 if(dfltslt_cnt==0)
					       {
					     var selectBox		= eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
						var selectOption	= eval(<%=frame_name%>.document).createElement("OPTION");
						  
						  selectOption.value	=	"";
					     selectOption.text	=	"-----"+getLabel('Common.defaultSelect.label','common')+"-----";
						 selectBox.add(selectOption);
						   }
				         	}
					</script>
						<%
						dfltslt_cnt++;
						}
							%>
								<!--	</script>  -->
									<%
								}
							} 
							
							}
				}
			}
		}
		else if((!fileNo.equals("")) && (file_type_appl_yn.equals("N")))
		{
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
			
						
			sqlString = "SELECT patient_id FROM mr_pat_file_index WHERE facility_id = ? AND file_no = ? and doc_folder_id is null";
			
			
			preStatement	=	connection.prepareStatement(sqlString);
			
			
			if((form_name.equals("FMReturnToMRDCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form")) && !file_creat_fac_id1.equals(facilityID) && curr_fs_locn_identity.equals("D"))
					{
			preStatement.setString(1, file_creat_fac_id1);
						
					}else if((form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form"))  && !fileNo.equals(""))
				{
			     preStatement.setString(1, file_creat_fac_id1);
			    }
					else{
                  preStatement.setString(1, facilityID);
						
					}
			
			preStatement.setString(2, fileNo);
				
				resultSet =	preStatement.executeQuery();
				
			
			if((resultSet != null) && (resultSet.next()))
			{
				%>
				<script>
					eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).value = '<%=checkForNull(resultSet.getString("patient_id"))%>';
				</script>
				<%
				patientID =	checkForNull(resultSet.getString("patient_id"));
							}
			else
			{
				%>
				<script>
			eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).value = '';
				</script>
				<%
			}
		}
		if((patline_yn.equals("Y")) && (!patline_ID.equals("")))
		{
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();

			sqlString =	"SELECT decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name FROM mp_patient WHERE patient_id = ? ";

			preStatement = connection.prepareStatement(sqlString);
			preStatement.setString(1, patientID);
			resultSet =	preStatement.executeQuery();

			if((resultSet != null) && (resultSet.next()))
			patient_name = checkForNull(resultSet.getString("patient_name"));
			%>
			<script>
				eval(<%=frame_name%>.document.all.<%=patline_ID%>).innerHTML="<%=patient_name%>";
			</script>
			<%
		}
		
	if(((!patient_file_type.equals("")) && (file_type_appl_yn.equals("Y"))) || dflt_flag.equals("true"))
		{
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();

			if(form_name.equals("FMReturnToMRDCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") )
			{
		preStatement = connection.prepareStatement("SELECT file_no FROM fm_curr_locn where facility_id = ? AND file_type_code = ? AND patient_id = ?");
			
					}
		/*	 else if(form_name.equals("FMConfirmRcptCriteria_form"))
			{
             preStatement = connection.prepareStatement("SELECT file_no FROM fm_curr_locn where facility_id = ? AND file_type_code = ? AND patient_id = ?");

			} */
			else
			{
	//	preStatement = connection.prepareStatement("SELECT file_no FROM mr_pat_file_index where facility_id = ? AND file_type_code = ? AND patient_id = ?");
			preStatement = connection.prepareStatement("SELECT file_no FROM fm_curr_locn where facility_id = ? AND file_type_code = ? AND patient_id = ?");
			}
			
			//preStatement.setString(1, facilityID);
if(form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMReturnToMRDCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form"))
			 {
			preStatement.setString(1,file_creat_fac_id);
 			 }else if(form_name.equals("ManualEntry_form") || form_name.equals("FMReceiveFileMRDSearch") ||  form_name.equals("FMCreateFileVolumeSearchForm")){
			preStatement.setString(1,facilityID);
				  
		   } else
			{
           preStatement.setString(1, facilityID);
		
		//   preStatement.setString(1, facilityID);
			}
			preStatement.setString(2, patient_file_type);
			preStatement.setString(3, patientID);
			resultSet =	preStatement.executeQuery();
			
 		
	 
		if((resultSet != null))
			{
				while(resultSet.next())
				{
				fileNo	=	checkForNull(resultSet.getString("file_no"));
				vol_cntt++;
				
				}
			vol_cnt=vol_cntt;
			
				
				%>
				<script>
							
			if('<%=fileNo%>'!="")	eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value = '<%=fileNo%>';
					</script>
				<%
			}
								
				
					
					
					%>
			<script>
						
				if("<%=form_name%>"=="fm_req_criteria")
				{					
					<%if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){%>
					eval(<%=frame_name%>).addFiles();
					
					<%}%>
				}
				if("<%=form_name%>"=="FMCancelRequestCriteria_form")
				{					
					<%if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){%>
					eval(<%=frame_name%>).AddFiles();
					<%}%>
				}	
				if("<%=form_name%>"=="FMConfirmRcptCriteria_form")
				{					
					<%if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){%>
					eval(<%=frame_name%>).AddFiles(<%=vol_cnt%>);
					<%}%>
				}
				if("<%=form_name%>"=="ConfirmPullingListForm")
				{					
					//if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){
						<%if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1 && record_count <= 1){%>
						// Modified for IN:043804 by Dharma on 4th oct 2013
							eval(<%=frame_name%>).addFiles_confirm();
					<%}%>

				}				
			if("<%=form_name%>" =="FMTransferFileCriteria_form")
				{					
					<%if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){%>
						eval(<%=frame_name%>).AddFiles();
					<%}%>
				}
				if("<%=form_name%>" == "FMReceiveFileMRDSearch")
				{		
					
					<%if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){%>
						eval(<%=frame_name%>).addFiles(<%=vol_cnt%>);
					<%}%>
				}
				else if("<%=function_name%>" == "FMRetutnToMRD")
				{					
					<%if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){%>
						eval(<%=frame_name%>).searchForRecord(<%=vol_cnt%>);
					<%}%>
				}
				else if("<%=form_name%>" == "FileIsuueTab")
				{
					<%if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){%>
						eval(<%=frame_name%>).submitAllDetails();
					<%}%>
				}
				else if("<%=form_name%>" == "FMChngStrLocnCriteriaForm")
				{					
					<%if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){%>
						eval(<%=frame_name%>).fetchResults();
					<%}%>
				}
				else if("<%=form_name%>" =="FMChFileRetDateCriteriaForm")
				{					
					<%if((record_count == 1|| dfltcnt== 1) && vol_cnt == 1){%>
						eval(<%=frame_name%>).fetchResults("search");
					<%}%>
				}
				</script>
			<%
		}
				
		if((operation.equals("FILE_VOLUME")) && (volume_no_appl_yn.equals("Y")))
		{
			if((volumeBuffer != null) && (volumeBuffer.length() > 0))
				volumeBuffer.delete(0, volumeBuffer.length());
			
			if((file_type_appl_yn.equals("Y") && !patient_file_type.equals("")) || (file_type_appl_yn.equals("N") && !fileNo.equals("")) || (!dflt_file_type.equals("") && !dflt_file_no.equals("") && record_count>0) )	{

			volumeBuffer.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = '");
		
			
			volumeBuffer.append(patientID);
			volumeBuffer.append("' ");
				
			
			if(!fileNo.equals(""))
			{
				volumeBuffer.append(" AND file_no = '");
				volumeBuffer.append(fileNo);
				volumeBuffer.append("' ");
			}
           if(fileNo.equals("") && !dflt_file_no.equals(""))
			{
				volumeBuffer.append(" AND file_no = '");
				volumeBuffer.append(dflt_file_no);
				volumeBuffer.append("' ");
			}
			
			
			if(!patient_file_type.equals("") && (!patient_file_type.equals("undefined")))
			{
				volumeBuffer.append(" AND file_type_code = '");
				volumeBuffer.append(patient_file_type);
				volumeBuffer.append("' ");
			}
			if(patient_file_type.equals("") && (!dflt_file_type.equals("")))
			{
				volumeBuffer.append(" AND file_type_code = '");
				volumeBuffer.append(dflt_file_type);
				volumeBuffer.append("' ");
			}
			
	    	volumeBuffer.append(" AND facility_id = '");
						
			if((form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form")) && !fileNo_old.equals(""))
				{
				
		volumeBuffer.append(file_creat_fac_id1);
				} else if((form_name.equals("FMCancelRequestCriteria_form") || form_name.equals("FMTransferFileCriteria_form") || form_name.equals("FMChngStrLocnCriteriaForm") || form_name.equals("FMConfirmRcptCriteria_form") || form_name.equals("FMReturnToMRDCriteriaForm")) && fileNo_old.equals(""))
				{
               if(file_creat_fac_id.equals(""))  file_creat_fac_id=facilityID;
				
				volumeBuffer.append(file_creat_fac_id);
				}
				else
				{
        volumeBuffer.append(facilityID);

			}
			volumeBuffer.append("' ");
			volumeBuffer.append("ORDER BY volume_no desc ");
			if(volResultSet!=null)	volResultSet.close();
			if(volStatement!=null) volStatement.close();
        		volStatement	=	connection.prepareStatement(volumeBuffer.toString());
				
		volResultSet	=	volStatement.executeQuery();	
		
			if(volResultSet != null)
			{
				%>
				
				<script>
					var selectBox   = eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
					var seletLen	=	Math.abs(selectBox.length);
					for (i=0; i<seletLen; i++)
						selectBox.remove(0);
					var selectOption	=  eval(<%=frame_name%>.document).createElement("OPTION");		
				/*	selectOption.value	=	"";
					selectOption.text	=	"----"+getLabel("Common.defaultSelect.label","common")+"----";
					selectBox.add(selectOption);*/
				</script>
				<%
				while(volResultSet.next())
				{
					vol_cnt1++;
					%>		
					<script>
					dfltslt_cnt="<%=dfltslt_cnt%>";
					var dflt_file_type="<%=dflt_file_type%>";
					var dflt_file_no="<%=dflt_file_no%>";	
					var dflt_flag ="<%=dflt_flag%>";	
					var patient_file_type="<%=patient_file_type%>";
					var selectBox="";
				    var selectOption="";	
					var filenotype="";
                   var record_count="<%=record_count%>";	 
		  
		 	  if(eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>))
					{
			       filenotype=eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>).value;
					} 
				 if(eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>))
					{
             filenotype=eval(<%=frame_name%>.document.<%=form_name%>.<%=fileno_name%>).value;
					}
									 
						 if(filenotype !="" || patient_file_type!=""){
						 selectBox		= eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
						 selectOption	= eval(<%=frame_name%>.document).createElement("OPTION");		
						selectOption.value	= '<%=checkForNull(volResultSet.getString("volume_no"))%>';
						selectOption.text	= '<%=checkForNull(volResultSet.getString("volume_no"))%>';
						selectBox.add(selectOption);
						if(dflt_file_type=="" && dflt_file_no=="" && dflt_flag=="true" && record_count>1)
					 {
                 if(eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>))
	            removeitems(eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>));
                   
				   selectBox		= eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
						 selectOption	= eval(<%=frame_name%>.document).createElement("OPTION");	
						selectOption.value	=	"";
							selectOption.text	=	"-----"+getLabel('Common.defaultSelect.label','common')+"-----";
						selectBox.add(selectOption);

						 }
								
					}else{
                       
						if(dfltslt_cnt==0)
						{
						selectBox		= eval(<%=frame_name%>.document.<%=form_name%>.<%=volumeno_name%>);
						 selectOption	= eval(<%=frame_name%>.document).createElement("OPTION");	
						selectOption.value	=	"";
							selectOption.text	=	"-----"+getLabel('Common.defaultSelect.label','common')+"-----";
						selectBox.add(selectOption);
						}
					}
					</script>
					<%
				dfltslt_cnt++;
					}
			}
		}
			%>
			<script>
			
					var errors ="";
        if(eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).value !=""){
  		
		errors = getMessage('PATIENT_FILE_NOT_EXIST','FM');

	}
									
				if("<%=form_name%>"=="ManualEntry_form")
				{
					if("<%=file_mov_flag%>" == "Y")
					{
					
					if("<%=messageframe_name%>" != "parent.parent.messageFrame" && (<%=rec_count%>==0))
						eval(<%=messageframe_name%>).document.location.href='../../eCommon/jsp/error.jsp?err_num='+errors ;
					else if("<%=messageframe_name%>" != "parent.parent.messageFrame")
						parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
					else if("<%=messageframe_name%>" == "parent.parent.messageFrame")
						parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
					}
					else
					eval(<%=frame_name%>).CheckPatientExists1('<%=patientID%>','<%=vol_cnt1%>');
					
					
				}
				else
				{
					//if("<%=form_name%>"=="ConfirmPullingListForm" && '<%=record_count%>' == 0 ){
					// Modified for IN:043804 by Dharma on 4th oct 2013
					if("<%=form_name%>"=="ConfirmPullingListForm" && '<%=record_count%>' == 0 && ("<%=filetype_name%>"==null || "<%=filetype_name%>"=="")){	

						alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));					
						parent.frames[1].frames[0].document.forms[0].patient_id.value="";
						parent.frames[1].frames[0].document.forms[0].patient_id.onblur();					
			       }
				   
					
				if("<%=messageframe_name%>" != "parent.parent.messageFrame" && (<%=rec_count%>==0))
					eval(<%=messageframe_name%>).document.location.href='../../eCommon/jsp/error.jsp?err_num='+errors ;
				else if("<%=messageframe_name%>" != "parent.parent.messageFrame")
					parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
				else if("<%=messageframe_name%>" == "parent.parent.messageFrame")
					parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
				}
				if("<%=form_name%>"=="ManualEntry_form")
			  {
                if(errors !="")
				  {
					if(parent.searchResultFrame)
					  {					parent.searchResultFrame.document.location.href="../../eCommon/html/blank.html";
					  }
				  }
			  }
			
			</script>
			<%
		}
		//	if(record_count==0)
		//	{
				%>
				<!-- <script>
				//alert('APP-MP0112 Patient File not Created');
				</script> -->
					<%
		//	}
	}
	}
%>
</head>
<script>
	var errors ="";


if(eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>))
		{
if(eval(<%=frame_name%>.document.<%=form_name%>.<%=patientid_name%>).value !="" && eval(<%=frame_name%>.document.<%=form_name%>.<%=filetype_name%>).value !=""){
   // errors = getMessage('PATIENT_FILE_NOT_EXIST','FM');
if(eval(<%=messageframe_name%>))
eval(<%=messageframe_name%>).document.location.href='../../eCommon/jsp/error.jsp?err_num='+errors ;
}
	}

if("<%=form_name%>"=="ManualEntry_form")
{
	
	if("<%=file_mov_flag%>" == "Y")
	{
		if("<%=messageframe_name%>" != "parent.parent.messageFrame" && (<%=rec_count%>==0))
			eval(<%=messageframe_name%>).document.location.href='../../eCommon/jsp/error.jsp?err_num='+errors ;
		else if("<%=messageframe_name%>" == "parent.parent.messageFrame")
			parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}
	else
		eval(<%=frame_name%>).CheckPatientExists1('<%=patientID%>');
}
else
{

if("<%=messageframe_name%>" != "parent.parent.messageFrame" && (<%=rec_count%>==0))
	eval(<%=messageframe_name%>).document.location.href='../../eCommon/jsp/error.jsp?err_num='+errors ;
else if("<%=messageframe_name%>" == "parent.parent.messageFrame")
	parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


</script>
<%
}


catch(Exception e)
{
	out.println("Exception : " + e.toString());
	e.printStackTrace();
}
finally
{
	if(preStatement!=null) preStatement.close();
	if(volStatement!=null) volStatement.close();
	if(resultSet!=null)	resultSet.close();
	if(volResultSet!=null)	volResultSet.close();

	ConnectionManager.returnConnection(connection,request);
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

