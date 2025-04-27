<!DOCTYPE html>
 <!--

	Created On	: 6/15/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Request of File
	
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMRequestFile.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form>
<%
	
	
	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	PreparedStatement preStatement	= null;
    ResultSet	resultSet			= null;
	ResultSet rs			= null;
	ResultSet rs1			= null;
	
	int file_volume_count=0; // Added this CRF PMG2013-MMS-CRF-0005 [IN:045278]
	
	try
	{
		
		request.setCharacterEncoding("UTF-8");
		stmt = con.createStatement();
		String p_patient_file_no	= "";
		String file_no="";
		p_patient_file_no	= request.getParameter("p_patient_file_no");
		//String p_patient_id	= checkForNull(request.getParameter("p_patient_id"));
	
		String file_type	= request.getParameter("file_type");
		String volume_no	= request.getParameter("volume_no");
		String added_volume	= request.getParameter("added_volume");
		
		//Added for this CRF PMG2013-MMS-CRF-0005 [IN:045278]
		int reasonfor_browing=0;
		String count_reason= checkForNull(request.getParameter("count_reason")); 
		if(!count_reason.equals(""))reasonfor_browing= Integer.parseInt(count_reason);
		
		

		String fileno_name			= checkForNull(request.getParameter("fileno_name"));
		String filetype_name		= checkForNull(request.getParameter("filetype_name"));
		String file_no_function		= checkForNull(request.getParameter("file_no_function"));
		String file_type_function	= checkForNull(request.getParameter("file_type_function"));
		String frame_name			= checkForNull(request.getParameter("frame_name"));
		String form_name			= checkForNull(request.getParameter("form_name"));
		String volumeno_name		= checkForNull(request.getParameter("volumeno_name"));
        String patient_id	= checkForNull(request.getParameter("patient_id"));
		String file_type_code= checkForNull(request.getParameter("file_type_code"));
		String flag_status =checkForNull(request.getParameter("flag_status"));
		file_type	= ((file_type == null) || (file_type.equals("null"))) ? "" : file_type;
		volume_no	= ((volume_no == null) || (volume_no.equals("null"))) ? "" : volume_no;
		
		StringBuffer sqlBuffer		=	new StringBuffer();

		String facilityid 		 = (String) session.getValue("facility_id");

		String p_old_string		 = request.getParameter("p_old_string");
		String p_enter_fcy		 = request.getParameter("p_enter_fcy");
		String p_req_fs_locn	 = request.getParameter("p_req_fs_locn");
		String conc_remarks	   ="";	
		if(!flag_status.equals("AUTO_REQ"))
		 {
		conc_remarks= checkForNull(request.getParameter("conc_remarks")).trim();
		  }
		
		String added_values		 = request.getParameter("added_values");
		String file_type_appl_yn = request.getParameter("file_type_appl_yn");
       String file_type_appl_yn1   = request.getParameter("file_type_appl_yn1");
	   String perm_fs_locn_code =request.getParameter("perm_fs_locn_code");
	   String sqlString="";
		String volumeno="";
		
		if (perm_fs_locn_code==null) perm_fs_locn_code = "";
		if (file_type_appl_yn==null) file_type_appl_yn = "N";
		if (file_type_appl_yn1==null) file_type_appl_yn1 ="N";
		if (added_values==null) added_values = "";
		if (added_volume==null) added_volume = "";
		if (p_old_string==null) p_old_string = "";
		if (p_enter_fcy==null) p_enter_fcy = "";
		if (p_req_fs_locn==null) p_req_fs_locn = "";
		if (conc_remarks==null) conc_remarks = "";
			
		// code commnet for 19717

		//added_volume = java.net.URLDecoder.decode(added_volume);	
     	
		//conc_remarks= java.net.URLDecoder.decode(conc_remarks,"UTF-8");	
      
		if(conc_remarks !=null || !conc_remarks.equals("null") || !conc_remarks.equals(""))
		{
		session.setAttribute("conc_remarks",conc_remarks);
			}
		
		String p_new_string		= "";		
		String p_error_message	= "";
		String p_sent_date_time	= "";
		String added_date_time	= "";
		String added_date_time1	= "";
		java.util.Hashtable message;
	
	if(flag_status.equals("AUTO_REQ"))
		{

	if(file_type_appl_yn1.equals("Y"))
			{
	  sqlString = "SELECT DISTINCT volume_no,file_no  FROM fm_curr_locn WHERE facility_id = ?  AND patient_id = ? and file_type_code=?  order by volume_no desc ";
	       preStatement	=	 con.prepareStatement(sqlString);
			preStatement.setString(1, facilityid );
			preStatement.setString(2, patient_id);
			preStatement.setString(3, file_type_code);
					}
			
		if(file_type_appl_yn1.equals("N"))
			{
            sqlString = "SELECT DISTINCT volume_no,file_no  FROM fm_curr_locn WHERE facility_id = ?  AND patient_id = ? and perm_fs_locn_code=?  order by volume_no desc ";
	       preStatement	=	 con.prepareStatement(sqlString);
			preStatement.setString(1, facilityid );
			preStatement.setString(2, patient_id);
			preStatement.setString(3, perm_fs_locn_code);

			}
			resultSet		=	preStatement.executeQuery();
				
			if(resultSet != null) 
			{
				while(resultSet.next())
				{
				
				file_volume_count++; //Added  this CRF PMG2013-MMS-CRF-0005 [IN:045278]
				
				volumeno=resultSet.getString("volume_no");
				file_no  =resultSet.getString("file_no");
				%>
				
				<script>
							
				var temp = "<%=volumeno%>";
				var temp1="<%=volumeno%>";
				var opt=parent.document.frames[0].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				parent.document.frames[0].document.forms[0].volume_no.add(opt);
						
			</script>
								
				<%
				}
			} %>
<!--below line added this CRF PMG2013-MMS-CRF-0005 [IN:045278] -->
				<script>
				if('<%=file_volume_count%>'==1){
				parent.document.frames[0].document.forms[0].count_volumeno.value = 1; // Modified for MMS-QH-CRF-0148
				parent.document.frames[0].document.forms[0].volume_no.selectedIndex = 1;				
                 if(parent.document.frames[0].document.forms[0].file_type_code&&parent.document.frames[0].document.forms[0].file_type_code.value!="" && parent.document.frames[0].document.forms[0].volume_no.value!="" && parent.document.frames[0].document.forms[0].narration_code.value!=""){
				  parent.document.frames[0].document.forms[0].ok_button.disabled = false;
				 }
                 if(parent.document.frames[0].document.forms[0].fs_locn_code_1&&parent.document.frames[0].document.forms[0].fs_locn_code_1.value!="" && parent.document.frames[0].document.forms[0].volume_no.value!="" && parent.document.frames[0].document.forms[0].narration_code.value!=""){
				  parent.document.frames[0].document.forms[0].ok_button.disabled = false;
				 } 				 
				}else{
				parent.document.frames[0].document.forms[0].volume_no.selectedIndex = 0;
				}				
				if('<%=reasonfor_browing%>'==1){ 
		//		parent.document.frames[0].document.forms[0].count_reason.value = 1; // Modified for MMS-QH-CRF-0148
			     if(parent.document.frames[0].document.forms[0].file_type_code&&parent.document.frames[0].document.forms[0].file_type_code.value!="" &&       parent.document.frames[0].document.forms[0].volume_no.value!=""){ 
                  parent.document.frames[0].document.forms[0].narration_code.selectedIndex = 1;    				
				 }             				
                  if(parent.document.frames[0].document.forms[0].file_type_code&&parent.document.frames[0].document.forms[0].file_type_code.value!="" && parent.document.frames[0].document.forms[0].volume_no.value!="" && parent.document.frames[0].document.forms[0].narration_code.value!=""){ 
                  parent.document.frames[0].document.forms[0].ok_button.disabled = false;				 
				 }
                 if(parent.document.frames[0].document.forms[0].fs_locn_code_1&&parent.document.frames[0].document.forms[0].fs_locn_code_1.value!="" &&       parent.document.frames[0].document.forms[0].volume_no.value!="" ){ 
				  parent.document.frames[0].document.forms[0].narration_code.selectedIndex = 1; 
				 
				 }if(parent.document.frames[0].document.forms[0].fs_locn_code_1&&parent.document.frames[0].document.forms[0].fs_locn_code_1.value!="" && parent.document.frames[0].document.forms[0].volume_no.value!="" && parent.document.frames[0].document.forms[0].narration_code.value!=""){	  
				  parent.document.frames[0].document.forms[0].ok_button.disabled = false;
				 }
                 if((parent.document.frames[0].document.forms[0].file_type_code&&parent.document.frames[0].document.forms[0].file_type_code.value=="" &&       parent.document.frames[0].document.forms[0].volume_no.value=="") || (parent.document.frames[0].document.forms[0].fs_locn_code_1&&parent.document.frames[0].document.forms[0].fs_locn_code_1.value==""&& parent.document.frames[0].document.forms[0].volume_no.value=="")){
				 parent.document.frames[0].document.forms[0].narration_code.selectedIndex = 0;
				 }				 
				}else{
				parent.document.frames[0].document.forms[0].narration_code.selectedIndex = 0;
				} 
				
				</script>
   <!--End PMG2013-MMS-CRF-0005 [IN:045278]	-->
	   <script>
			parent.document.frames[0].document.forms[0].file_no1.value="<%=file_no%>";
			//Added for MMS-QH-CRF-0148 -- TO submit the request if it has only single record 
			if (parent.document.frames[0].document.forms[0].sitespecific_autofilereq.value == "true")
			{
			if(parent.document.frames[0].document.forms[0].count_reason.value == 1 && parent.document.frames[0].document.forms[0].count_filetype.value == 1)
				{
					if (parent.document.frames[0].document.forms[0].volume_no && parent.document.frames[0].document.forms[0].volume_no.length == 2)
					{
						parent.document.frames[0].document.getElementById("ok_button").click();
					}		
				}
			}
		</script>
	
	
	<% }	
		
if(!flag_status.equals("AUTO_REQ"))
		{	
int p_fs_locn_code_cnt	 = 0,p_file_no_found=0;
		int p_count				 = 0;

		boolean p_load_frame	 = true;
		boolean p_fs_locn_equal   = false;

		String doc_or_file = request.getParameter("doc_or_file")==null?"":request.getParameter("doc_or_file");
		String doctype_appl_yn = request.getParameter("doctype_appl_yn")==null?"Y":request.getParameter("doctype_appl_yn");
		String p_separate_file_no = p_patient_file_no;	
		StringTokenizer token1=new StringTokenizer(p_separate_file_no,",");

		int counter = 0;
		while(token1.hasMoreTokens())
		{
			counter ++;
			p_patient_file_no = "";
			p_patient_file_no = token1.nextToken();

			if(p_req_fs_locn==null)p_req_fs_locn="";
			if(p_enter_fcy.equals("null") || p_enter_fcy.equals("")) p_enter_fcy=facilityid ;

			sqlBuffer.append("select count(*) rec_cnt from fm_curr_locn where facility_id='"+p_enter_fcy+"' ");

			if(!p_patient_file_no.equals(""))
				sqlBuffer.append(" and file_no='"+p_patient_file_no+"' ");
			if(!file_type.equals(""))
				sqlBuffer.append(" and file_type_code ='"+file_type+"' ");
	//		if(!p_patient_id.equals(""))
	//			sqlBuffer.append(" and patient_id ='"+p_patient_id+"' ");

			if(!doc_or_file.equals("D"))
			{
				if (!volume_no.equals(""))
					sqlBuffer.append(" and volume_no = '"+volume_no+"' ");
			}
			rs = stmt.executeQuery(sqlBuffer.toString());
		
			while (rs.next())
			{
				p_count = rs.getInt("rec_cnt");
				
			}			
			if(rs!=null)	rs.close();

			if(p_count > 0)
			{
				
				String chekString = "";
				p_new_string = p_patient_file_no;

				chekString = p_patient_file_no+"$$"+volume_no ;
				if(!added_values.equals(""))
				{
					StringTokenizer token = new StringTokenizer(added_values,"|");
					String chkValue = "";
					while(token.hasMoreTokens())
					{
						chkValue = token.nextToken();
						if (chekString.equals(chkValue))
						{
							p_load_frame = false;
							%>
							<script>						
								var errors = getMessage('FILE_ALREADY_ENTERED','FM');
								parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
							</script>
							<%
						}
					}
				}
				if((sqlBuffer != null) && (sqlBuffer.length() > 0))
				{
					sqlBuffer.delete(0,sqlBuffer.length());
				}
				if(p_enter_fcy.equals(facilityid))
				{
					sqlBuffer.append("select count(*) rec_cnt from mr_pat_file_index where facility_id='"+facilityid+"' and fs_locn_code is not null");
					if (!p_patient_file_no.equals(""))
						sqlBuffer.append(" and file_no='"+p_patient_file_no+"' ");
					if (!file_type.equals(""))
						sqlBuffer.append(" and file_type_code ='"+file_type+"' ");
				}
				else
				{
					sqlBuffer.append("select count(*) rec_cnt from fm_curr_locn where facility_id='"+p_enter_fcy+"' ");
					if (!p_patient_file_no.equals(""))
						sqlBuffer.append(" and file_no='"+p_patient_file_no+"' ");
					if (!file_type.equals(""))
						sqlBuffer.append(" and file_type_code = '"+file_type+"' ");
					if (!volume_no.equals(""))
						sqlBuffer.append(" and VOLUME_NO = "+volume_no+" ");
				}

				rs = stmt.executeQuery(sqlBuffer.toString());
				
				while (rs.next())
				{
					p_fs_locn_code_cnt = rs.getInt("rec_cnt");
				}
				if(rs!=null)	rs.close();
				if((sqlBuffer != null) && (sqlBuffer.length() > 0))
				{
					sqlBuffer.delete(0,sqlBuffer.length());
				}
				if(p_load_frame==true)
				{
					if (p_fs_locn_code_cnt > 0)
					{
						sqlBuffer.append("select fs_locn_code from mr_pat_file_index where facility_id='"+p_enter_fcy+"' ");
						if (!p_patient_file_no.equals(""))
							sqlBuffer.append(" and file_no='"+p_patient_file_no+"'");
						if (!file_type.equals(""))
							sqlBuffer.append(" and file_type_code ='"+file_type+"'");
					
						rs = stmt.executeQuery(sqlBuffer.toString());
						rs.next();
						if(rs.getString("fs_locn_code").equals(p_req_fs_locn) && 							p_enter_fcy.equals(facilityid))
						{
							p_fs_locn_equal	= true;
						}
						if(rs!=null)	rs.close();
						if((sqlBuffer != null) && (sqlBuffer.length() > 0))
						{
						sqlBuffer.delete(0,sqlBuffer.length());
						}
						if (!p_fs_locn_equal)
						{
	/* Adding for checking for the file whether already requested or in transit 08012003 */

							sqlBuffer.append("SELECT to_char(A.SENT_DATE_TIME,'dd/mm/rrrr hh:mi AM') FROM FM_TRANSIT_FILE A WHERE A.FACILITY_ID='"+p_enter_fcy+"' AND DEST_FACILITY_ID='"+p_enter_fcy+"' AND DEST_FS_LOCN_CODE='"+p_req_fs_locn+"' ");
							if (!p_patient_file_no.equals(""))
								sqlBuffer.append(" AND A.FILE_NO='"+p_patient_file_no+"' ");
							if (!file_type.equals(""))
								sqlBuffer.append(" AND A.FILE_TYPE_CODE='"+file_type+"' ");
							if(!doc_or_file.equals("D"))
							{
								if (!volume_no.equals(""))
									sqlBuffer.append(" AND A.volume_no="+volume_no+" ");
							}				
							rs1 = stmt.executeQuery(sqlBuffer.toString());
					
							if((sqlBuffer != null) && (sqlBuffer.length() > 0))
							{
								sqlBuffer.delete(0,sqlBuffer.length());
							}
							while (rs1.next())
							{
								p_file_no_found++;			
								p_sent_date_time = rs1.getString(1);
							}
							
						if(p_sent_date_time != null)
							{
								p_sent_date_time=DateUtils.convertDate(p_sent_date_time,"DMYHMA","en",localeName);
							}
							else
								p_sent_date_time="";
							if (p_file_no_found ==0)	
							{
								//sqlBuffer.append("SELECT A.REQ_FS_LOCN_DESC || ' (' || A.REQ_FACILITY_NAME || ')', TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM'),A.REQ_BY_NAME FROM FM_REQ_HDR_VW A, FM_REQ_DTL B WHERE A.REQ_NO=B.REQ_NO AND A.REQ_FS_LOCN_CODE='"+p_req_fs_locn+"' AND A.REQ_FACILITY_ID='"+p_enter_fcy+"' AND B.ISS_YN='N' AND B.CANCEL_YN='N'");
								sqlBuffer.append("SELECT" );
								sqlBuffer.append("  fm_Get_desc.Fm_storage_locn('"+facilityid+"',a.REQ_FS_LOCN_CODE,'"+localeName+"',2) ||' (' ||sm_Get_desc.SM_FACILITY_PARAM(a.REQ_FACILITY_ID,'"+localeName+"',1) ||')'" );
								sqlBuffer.append("  , TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM')" );
								sqlBuffer.append("  , sm_Get_desc.SM_APPL_USER(A.REQ_USER_ID,'"+localeName+"',1) " );
								sqlBuffer.append("FROM" );
								sqlBuffer.append("  FM_REQ_HDR A" );
								sqlBuffer.append("  , FM_REQ_DTL B " );
								sqlBuffer.append("WHERE A.REQ_NO = B.REQ_NO " );
								sqlBuffer.append("  AND A.REQ_FS_LOCN_CODE = '"+p_req_fs_locn+"' " );
							//	sqlBuffer.append("  AND A.REQ_FACILITY_ID = '"+p_enter_fcy+"' " );
								sqlBuffer.append("  AND B.ISS_YN = 'N' " );
								sqlBuffer.append("  AND B.CANCEL_YN = 'N'" );
								if (!p_patient_file_no.equals(""))
									sqlBuffer.append(" AND B.FILE_NO='"+p_patient_file_no+"' ");
								if (!file_type.equals(""))
									sqlBuffer.append(" AND B.FILE_TYPE_CODE='"+file_type+"' ");
								if(!doc_or_file.equals("D"))
								{
									if (!volume_no.equals(""))
										sqlBuffer.append(" AND B.volume_no="+volume_no+" ");
								}
							
														
								rs = stmt.executeQuery(sqlBuffer.toString());
								while (rs.next())
								{
									p_file_no_found++;
									if(doc_or_file.equals("D"))
									{
										p_error_message =" by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
									}
									else
									{
										if(file_type_appl_yn.equals("N"))
									{
										//p_error_message =" File no " + p_patient_file_no + " already requested by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
										message = MessageManager.getMessage(localeName,"FILE_ALREADY_REQUSTED","FM");
										p_error_message = (String) message.get("message");
										//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_REQUSTED","fm_messages");
										p_error_message=p_error_message.replace("$",p_patient_file_no);
										p_error_message=p_error_message.replace("#",rs.getString(1));
									added_date_time=rs.getString(2);
									if(added_date_time != null)
									{
										added_date_time=DateUtils.convertDate(added_date_time,"DMYHMA","en",localeName);
									}
									else
										added_date_time="";	p_error_message=p_error_message.replace("~",added_date_time);
										p_error_message=p_error_message.replace("%",rs.getString(3));
									}
									else
										{
										//p_error_message =" Selected File already requested by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
										//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"SEL_FILE_REQUESTED","fm_messages");

										message = MessageManager.getMessage(localeName,"SEL_FILE_REQUESTED","FM");
										p_error_message = (String) message.get("message");

										p_error_message=p_error_message.replace("$",rs.getString(1));

										added_date_time1=rs.getString(2);
										if(added_date_time1 != null)
										{
											added_date_time1=DateUtils.convertDate(added_date_time1,"DMYHMA","en",localeName);
										}
										else
											added_date_time="";
										p_error_message=p_error_message.replace("#",added_date_time1);
										p_error_message=p_error_message.replace("~",rs.getString(3));
									}
									}
								}
							}
							else
							{					
								if(!doc_or_file.equals("D"))
								{
									if(file_type_appl_yn.equals("N"))
									{
									//p_error_message =" File no " + p_patient_file_no + " is already issued on " + p_sent_date_time ;
									//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_ISSUED","fm_messages");

									message = MessageManager.getMessage(localeName,"FILE_ALREADY_ISSUED","FM");
										p_error_message = (String) message.get("message");

									p_error_message=p_error_message.replace("$",p_patient_file_no);
									p_error_message=p_error_message.replace("#",p_sent_date_time);

									}else
									{
									//p_error_message =" Selected File is already issued on " + p_sent_date_time ;

									//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"SEL_FILE_ISSUED","fm_messages");
									message = MessageManager.getMessage(localeName,"SEL_FILE_ISSUED","FM");
									p_error_message = (String) message.get("message");

								p_error_message=p_error_message.replace("#",p_sent_date_time);
									}
								}
							}
							%>
							<script>
								if(parseInt('<%=p_file_no_found%>') > 0 )
								{	
									var doc_or_file = '<%=doc_or_file%>';
									var volume_no = "'"+"<%=volume_no%>"+"'"
									parent.frames[3].document.forms[0].invalid_volumes.value=volume_no;

									if(doc_or_file == 'D')
									{
										var temp_counter = "<%=counter%>";
										if(temp_counter < 2)
										alert(getMessage('DOC_ALREADY_REQUESTED','FM')+"\n"+"<%=p_error_message%>");
										/*var err_msg=getMessage('DOC_ALREADY_REQUESTED','FM')+ "<br>";
										err_msg=err_msg + "<%=p_error_message%>";
										alert(err_msg);*/
	
									}
									else
									{
										alert(getMessage('FILE_ALREADY_REQUESTED','FM')+"\n"+"<%=p_error_message%>");
										/*var err_msg1=getMessage('FILE_ALREADY_REQUESTED','FM');
										err_msg1=err_msg1 + '<br>' ;//+ "<%=p_error_message%>";
										err_msg1=err_msg1 + "<%=p_error_message%>";
										alert(err_msg1);*/
										parent.frames[3].document.forms[0].p_patient_id.value="";
									//	parent.frames[3].document.getElementById("patientid1").onblur();
										parent.frames[3].document.getElementById("p_patient_id").onblur();
									}
									
									if(doc_or_file == 'D')
									{
										parent.frames[3].document.forms[0].doc_folder_id.value="";
										parent.frames[3].document.forms[0].doc_folder_desc.value="";						
										if('<%=doctype_appl_yn%>' == 'Y')
										{
											parent.frames[3].getDocTypeVolumeNo();
										}
									}
									else if(doc_or_file == 'F')
									{   
										parent.frames[3].populateDynamicValues("");
									}
								}
							</script>
				<!-- End of Checking -->
							<script>
								if(parseInt('<%=p_file_no_found%>') == 0 )
								{
									if (parent.frames[3].document.forms[0].p_select_values.value.length==0)
									{
										parent.frames[3].document.forms[0].p_select_values.value = '<%=p_new_string%>';
									}
									else
									{
										parent.frames[3].document.forms[0].p_select_values.value = parent.frames[3].document.forms[0].p_select_values.value + '|' + '<%=p_new_string%>';
									}
								}
							</script>
							<script>
								if(parseInt('<%=p_file_no_found%>') == 0 )
								{
									var p_old_string = parent.frames[3].document.forms[0].p_select_values.value ;
									var p_deselect_file_no = parent.frames[3].document.forms[0].p_deselect_files.value;
									var volume_no = "<%=volume_no%>";
									var file_type = "<%=file_type%>";
									var added_volume = "<%=added_volume%>";
									var file_type_appl_yn = "<%=file_type_appl_yn%>";
                                   	var p_select_file_no = 
																		
									parent.frames[3].document.forms[0].p_select_files.value +'|' + 
									parent.frames[3].document.forms[0].p_select_values.value+'`'+volume_no;
									if(parent.frames[2].document.forms[0].logged_fcy.value=='L')
									{
										parent.frames[2].document.forms[0].logged_fcy.disabled=true;
									}
									else
									{
										parent.frames[2].document.forms[0].logged_fcy.disabled=true;
										parent.frames[2].document.forms[0].enter_fcy.disabled=true;
									}
									var doc_or_file = '<%=doc_or_file%>';
									
									var conc_remarks="";
								
									if(doc_or_file == 'D')
									{	
										HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='dummy_form<%=counter%>' id='dummy_form<%=counter%>' method='post' action='../../eFM/jsp/DTRequestSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value='"+p_select_file_no+"'><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='volume_no' id='volume_no' type='hidden' value="+volume_no+"><input name='file_type' id='file_type' type='hidden' value="+file_type+"><input name='added_volumes' id='added_volumes' type='hidden' value="+escape(added_volume)+"><input name='p_enter_fcy' id='p_enter_fcy' type='hidden' value=<%=p_enter_fcy%>><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='conc_remarks' id='conc_remarks' type='hidden' value="+conc_remarks+"><input name='p_req_fs_locn' id='p_req_fs_locn' type='hidden' value=<%=p_req_fs_locn%>><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"></form></BODY></HTML>";
									}
									else
									{
										HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' method='post' action='../../eFM/jsp/FMRequestSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value='"+p_select_file_no+"'><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='volume_no' id='volume_no' type='hidden' value="+volume_no+"><input name='file_type' id='file_type' type='hidden' value="+file_type+"><input name='added_volumes' id='added_volumes' type='hidden' value="+escape(added_volume)+"><input name='p_enter_fcy' id='p_enter_fcy' type='hidden' value=<%=p_enter_fcy%>><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='conc_remarks' id='conc_remarks' type='hidden' value="+conc_remarks+"><input name='p_req_fs_locn' id='p_req_fs_locn' type='hidden' value=<%=p_req_fs_locn%>><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='fileno_name' id='fileno_name' type='hidden' value='<%=fileno_name%>'><input name='filetype_name' id='filetype_name' type='hidden' value='<%=filetype_name%>'><input name='file_no_function' id='file_no_function' type='hidden' value='<%=file_no_function%>'><input name='file_type_function' id='file_type_function' type='hidden' value='<%=file_type_function%>'><input name='frame_name' id='frame_name' type='hidden' value='<%=frame_name%>'><input name='form_name' id='form_name' type='hidden' value='<%=form_name%>'><input name='volumeno_name' id='volumeno_name' type='hidden' value='<%=volumeno_name%>'></form></BODY></HTML>";
									}
									if(parent.frames[4].document.body)
									{
										parent.frames[4].document.write(HTMLVal);
									}
									if(doc_or_file == 'D')
									{
										if(parent.frames[4].document.dummy_form<%=counter%>)
										{
											parent.frames[4].document.dummy_form<%=counter%>.submit();		
										}
									}
									else
									{
										parent.frames[4].document.dummy_form.submit();			
									}

									parent.frames[1].document.forms[0].FS_LOCN_ID.disabled=true;
									parent.frames[1].document.forms[0].req_location.disabled=true;
									parent.frames[3].document.forms[0].p_file_no.value='';
									if (parent.frames[3].document.forms[0].p_file_no.type != 'hidden')
										parent.frames[3].document.forms[0].p_file_no.focus();
								}
							</script>
							<%	
						}
						else
						{
							%>
							<script>
								var errors = getMessage('REQUEST_EQUALS_CURRENT','FM');
								parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
							</script>
							<%
						}
					}
					else
					{
						%>
						<script>
							var errors = getMessage('FILES_NO_STORAGE_LOCATION','FM');		
							parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
						</script>
						<%		
					}
				}
			}
			else
			{
				if(!p_patient_file_no.equals("null"))
				{
					%>		
					<script>		
						var errors = getMessage('PATIENT_NOT_EXIST','FM');			
						parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
						parent.frames[3].document.forms[0].p_file_no.select();
						if(parent.frames[3].document.forms[0].p_file_no.type != 'hidden')
							parent.frames[3].document.forms[0].p_file_no.focus();
					</script>
					<%
				}
			}
			%>
			<script>
				parent.frames[3].document.forms[0].flag.value='';	
			</script>
			<%
		}
			if(p_count==0)
				{
					%>		
					<script>
						var doc_or_file = '<%=doc_or_file%>';
						if(doc_or_file == 'D')
						var errors = getMessage('DOC_NOT_EXIST','FM');	
					else
						var errors = getMessage('PATIENT_NOT_EXIST','FM');	parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;			
						
					</script>
					<%
				}
	}
		
		if (rs!=null) rs.close();
		if (rs1!=null) rs1.close();
		if (stmt!=null) stmt.close();
	     if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</form>
</body>
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

