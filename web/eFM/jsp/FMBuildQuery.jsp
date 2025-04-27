<!DOCTYPE html>
<!--
	Created On	: 6/15/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Return of File
-->
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMReturnMRDFile.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='message' onKeyDown = 'lockKey()'>
<form>
<%
	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	StringBuffer SelectSqlBuffer	= null;
	StringBuffer SelectSqlBuffer1	= null;
	StringBuffer CountSqlBuffer		= null;
	StringBuffer CountSqlBuffer1	= null;

	try
	{
		stmt = con.createStatement();
		
		String facilityid 		 = (String) session.getValue("facility_id");

		String sql						= "";
		String p_file_status			= "";	
		String deficiency_status        = "";
		
		String p_patient_file_no	= request.getParameter("p_patient_file_no");
		String p_pat_file_type		= request.getParameter("p_pat_file_type");
		String volume_no			= request.getParameter("volume_no");
		String file_type_appl_yn	= request.getParameter("file_type_appl_yn");
		String added_volumes		= request.getParameter("added_volumes");
		String p_search_type		= request.getParameter("p_search_type");	
		String record_value			= request.getParameter("record_value");
		String p_display			= request.getParameter("p_display");
		String p_fs_location		= request.getParameter("p_fs_location");
		String p_out_fcy			= request.getParameter("p_out_fcy");
		String p_out_fsloc			= request.getParameter("p_out_fsloc");
		String p_receiving_fs_locn	= request.getParameter("p_receiving_fs_locn");
		String p_file_stat = request.getParameter("p_file_stat");
		String accept_out_intransit_yn = request.getParameter("accept_out_intransit_yn");
		String vol_cnt = request.getParameter("vol_cnt");
		String p_stored_val = request.getParameter("p_stored_val");
		String patient_id= request.getParameter("patient_id");
		String buttonVal            = request.getParameter("buttonVal");
		String file_currfilesta="";
		if(buttonVal == null) buttonVal = "";
		
		//String doc_or_file			= request.getParameter("doc_or_file")==null?"":request.getParameter("doc_or_file");

	
		p_patient_file_no	= ((p_patient_file_no == null) || (p_patient_file_no.equals("null"))) ? "" : 						p_patient_file_no;
		p_pat_file_type		= ((p_pat_file_type == null) || (p_pat_file_type.equals("null"))) ? "" : 							p_pat_file_type;
		volume_no			= ((volume_no== null) || (volume_no.equals("null"))) ? "" : volume_no;
		file_type_appl_yn	= ((file_type_appl_yn== null) || (file_type_appl_yn.equals("null"))) ? "N" : 						file_type_appl_yn;
		p_file_stat = ((p_file_stat== null) || (p_file_stat.equals("null"))||(p_file_stat.equals("S"))) ? "" : p_file_stat;
		added_volumes		= ((added_volumes==null) || (added_volumes.equals("null")))?"":added_volumes;
		added_volumes		= java.net.URLDecoder.decode(added_volumes);
	
		if(!facilityid.equals(p_out_fcy) && p_file_stat.equals("T") )
		{
           p_file_stat="E";

		}
		
		boolean p_load_frame	 = true;

		int  p_fs_locn_code_cnt	 = 0;
		int p_count				 = 0;

		if(p_display == null) p_display = "";
		if(p_stored_val == null) p_stored_val = "";
		if(p_fs_location == null) p_fs_location = "";
		if(record_value == null) record_value = "";

		if(accept_out_intransit_yn == null) accept_out_intransit_yn="N";

		if(p_search_type.equals("F"))
		{
			SelectSqlBuffer		= new StringBuffer();
			SelectSqlBuffer1	 = new StringBuffer();
			CountSqlBuffer		= new StringBuffer(); 
			CountSqlBuffer1		= new StringBuffer();

			CountSqlBuffer.append("select count(*) rec_cnt from mr_pat_file_index where facility_id='"+facilityid+"' ");

			if(!p_patient_file_no.equals(""))
				CountSqlBuffer.append(" and file_no = '"+p_patient_file_no+"' ");
			if(!p_pat_file_type.equals(""))
				CountSqlBuffer.append(" and FILE_TYPE_CODE = '"+p_pat_file_type+"' ");
			
			rs = stmt.executeQuery(CountSqlBuffer.toString());
			

			while(rs != null && rs.next())
			{
				p_count	= rs.getInt("rec_cnt");
			} if(rs != null) rs.close();
          	if(p_count > 0)
			{
							

				StringTokenizer token	= new StringTokenizer(record_value,",");
				String tokenValue		= "";

				while(token.hasMoreTokens())
				{
					tokenValue = token.nextToken();
					if(p_patient_file_no.equals(tokenValue))
					{
						p_load_frame = false;
						%>
						<script>
							var errors = getMessage('FILE_RETURN_ALREADY_ENTERED','FM');
							parent.frames[2].document.forms[0].remove_volume.value = "<%=volume_no%>";
							parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					     parent.frames[2].document.forms[0].Add.disabled =false;
					    parent.frames[2].document.forms[0].flag.value="true";
						 parent.frames[2].document.forms[0].patientid.value="<%=patient_id%>";
				     	 parent.frames[2].document.forms[0].fileno.value="<%=p_patient_file_no%>";
					    parent.frames[2].document.forms[0].volno.value="<%=volume_no%>"; 
					  if("<%=accept_out_intransit_yn%>" == "N") 
					  {
                         parent.frames[2].document.forms[0].show_files.disabled  =false;
					  }
	                  parent.frames[2].document.forms[0].Clear.disabled =false;
							if("<%=vol_cnt%>" == "1") {
													parent.frames[2].document.forms[0].patient_id.value='';
							//parent.frames[2].document.getElementById("patientid1").onblur();
							parent.frames[2].document.forms[0].patient_id.onblur();
							}
						</script>
						<%
					}
				}

				CountSqlBuffer1.append("select count(*) rec_cnt from fm_curr_locn where facility_id = '"+facilityid+"' ");
				if(!p_patient_file_no.equals(""))
					CountSqlBuffer1.append(" and file_no = '"+p_patient_file_no+"' ");
				if(!p_pat_file_type.equals(""))
					CountSqlBuffer1.append(" and FILE_TYPE_CODE = '"+p_pat_file_type+"' ");
				if(!volume_no.equals(""))
					CountSqlBuffer1.append(" and volume_no = "+volume_no+" ");
					rs = stmt.executeQuery(CountSqlBuffer1.toString());
				
				while(rs.next())
				{
					p_fs_locn_code_cnt = rs.getInt("rec_cnt");
				} if(rs!=null) rs.close();
									
				if(p_load_frame == true)
				{
					if (p_fs_locn_code_cnt > 0)
					{
					

						SelectSqlBuffer.append("select perm_fs_locn_code, curr_file_status,deficiency_status from fm_curr_locn where facility_id='"+facilityid+"'  ");
						//SelectSqlBuffer.append("select perm_fs_locn_code, curr_file_status from fm_curr_locn where facility_id='"+facilityid+"' and perm_fs_locn_code != curr_fs_locn_code ");
			
						if(!p_patient_file_no.equals(""))
							SelectSqlBuffer.append(" and file_no = '"+p_patient_file_no+"' ") ;
						if (!p_pat_file_type.equals(""))
							SelectSqlBuffer.append(" and file_type_code = '"+p_pat_file_type+"' ");
						if(!volume_no.equals(""))
							SelectSqlBuffer.append(" and volume_no = "+volume_no+" ");
						if(!p_file_stat.equals(""))
							SelectSqlBuffer.append(" and curr_file_status = '"+p_file_stat+"' ");
										
						rs = stmt.executeQuery(SelectSqlBuffer.toString());
						if(rs.next())
						{ 

							p_file_status = rs.getString("curr_file_status");
							deficiency_status = rs.getString("deficiency_status");
							if(deficiency_status == null) deficiency_status = "";	

							if(!rs.getString("perm_fs_locn_code").equals(p_receiving_fs_locn))
							{
								%>
								<script>					
									var msg = getMessage('REC_FS_LOCN_NOT_OWNER','FM') +  ' - ' + '<%=p_patient_file_no%>';
									parent.frames[2].document.forms[0].remove_volume.value = "<%=volume_no%>";
									parent.frames[5].document.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg ;
									 parent.frames[2].document.forms[0].Add.disabled =false;
                              if("<%=accept_out_intransit_yn%>" == "N") {
                              parent.frames[2].document.forms[0].show_files.disabled  =false;
							  }
	                       parent.frames[2].document.forms[0].Clear.disabled =false;
									if("<%=vol_cnt%>" == "1") {
									parent.frames[2].document.forms[0].patient_id.value='';
									//parent.frames[2].document.getElementById("patientid1").onblur();
									parent.frames[2].document.forms[0].patient_id.onblur();
									}
								</script>
								<%
							}//if((p_file_status.equals("T") || p_file_status.equals("E") )&& accept_out_intransit_yn.equals("N"))
									//{
									%>								
					<!--	<script>
						 var err_message="";
						 err_message = getMessage("FILE_IN_TRANSIT_CANNOT_PROCEED","FM");
								if("<%=vol_cnt%>" == "1") {
								 parent.frames[2].document.forms[0].Add.disabled =false;
                               parent.frames[2].document.forms[0].show_files.disabled  =false;
	                          parent.frames[2].document.forms[0].Clear.disabled =false;
							  parent.frames[2].document.forms[0].patient_id.value='';
						   }
						parent.frames[5].document.location.href = "../../eCommon/jsp/error.jsp?err_num="+err_message ;
						</script>-->
						<%
						//}
						}
						else
						{
							SelectSqlBuffer1.append("select curr_file_status,deficiency_status from fm_curr_locn where facility_id = '"+facilityid+"' ");
							if(!p_patient_file_no.equals(""))
								SelectSqlBuffer1.append(" and file_no = '"+p_patient_file_no+"' ");
							if(!p_pat_file_type.equals(""))
								SelectSqlBuffer1.append(" and file_type_code = '"+p_pat_file_type+"' ");
							if(!volume_no.equals(""))
								SelectSqlBuffer1.append(" and volume_no = "+volume_no+" ");

													
							rs = stmt.executeQuery(SelectSqlBuffer1.toString());
							if(rs.next())
							{						
								p_file_status = rs.getString("curr_file_status");
								if(p_file_status == null) p_file_status = "1";
								deficiency_status = rs.getString("deficiency_status");
							   if(deficiency_status == null) deficiency_status = "";	

							} if(rs!=null) rs.close();
							
							//String err_message = "";
											
							if(p_file_status.equals("T") && accept_out_intransit_yn.equals("N"))
							{

								%>
								<script>	
								var	err_message ="";
								//err_message = "APP-FM0076 File is currently in Transit. Hence cannot proceed";
								
						  parent.frames[2].document.forms[0].flag.value="true";
						 parent.frames[2].document.forms[0].patientid.value="<%=patient_id%>";
				     	 parent.frames[2].document.forms[0].fileno.value="<%=p_patient_file_no%>";
					    parent.frames[2].document.forms[0].volno.value="<%=volume_no%>"; 
								err_message = getMessage("FILE_IN_TRANSIT_CANNOT_PROCEED","FM");
								if("<%=vol_cnt%>" == "1") {
									 parent.frames[2].document.forms[0].Add.disabled =false;
								  if("<%=accept_out_intransit_yn%>" == "N") 
								  {
									parent.frames[2].document.forms[0].show_files.disabled  =false;
								  }

	                                parent.frames[2].document.forms[0].Clear.disabled =false;
									parent.frames[2].document.forms[0].patient_id.value='';
									//parent.frames[2].document.getElementById("patientid1").onblur();
									parent.frames[2].document.forms[0].patient_id.onblur();
								}
								
								</script>		
								<%
							}
							else if(p_file_status.equals("A") )
							{
							
								%>
								<script>		
								  //err_message = "APP-FM0077 File is currently in Archive. Hence cannot proceed";	
								  var err_message = getMessage("FILE_IN_ARCHIVE_CANNOT_PROCEED","FM");
								 
						   parent.frames[2].document.forms[0].flag.value="true";
						 parent.frames[2].document.forms[0].patientid.value="<%=patient_id%>";
					 parent.frames[2].document.forms[0].fileno.value="<%=p_patient_file_no%>";
					 parent.frames[2].document.forms[0].volno.value="<%=volume_no%>"; 
								  if("<%=vol_cnt%>" == "1") {
									  parent.frames[2].document.forms[0].patient_id.value='';
									 // parent.frames[2].document.getElementById("patientid1").onblur();
									  parent.frames[2].document.forms[0].patient_id.onblur();
								  }
								  </script>		
								<%
							}
							else if(p_file_status.equals("I"))
							{
									%>
								<script>		
								 //err_message = "APP-FM0012 File already in Permanent FS Location. Hence cannot be returned";
								 var err_message = getMessage("FILE_ALREADY_IN_MRD","FM");
							   parent.frames[2].document.forms[0].flag.value="true";
					      	 parent.frames[2].document.forms[0].patientid.value="<%=patient_id%>";
					 parent.frames[2].document.forms[0].fileno.value="<%=p_patient_file_no%>";
								 parent.frames[2].document.forms[0].volno.value="<%=volume_no%>";
								 
								 if("<%=vol_cnt%>" == "1"){
								    parent.frames[2].document.forms[0].patient_id.value='';
									//parent.frames[2].document.getElementById("patientid1").onblur();
								    parent.frames[2].document.forms[0].patient_id.onblur();
								 }
								</script>		
								<%
							}
							else if(p_file_status.equals("O"))
							{  
								%>
								<script>		
								 //err_message = "APP-FM0078 File not Returned. Hence cannot proceed";
								 var err_message ="";
								
						    parent.frames[2].document.forms[0].flag.value="true";
						 parent.frames[2].document.forms[0].patientid.value="<%=patient_id%>";
						parent.frames[2].document.forms[0].fileno.value="<%=p_patient_file_no%>";
								 parent.frames[2].document.forms[0].volno.value="<%=volume_no%>";
								var err_message = getMessage("FILE_NOT_RETURNED","FM");
								if("<%=vol_cnt%>" == "1") {
									parent.frames[2].document.forms[0].patient_id.value='';
									//parent.frames[2].document.getElementById("patientid1").onblur();
									parent.frames[2].document.forms[0].patient_id.onblur();
								}
								
								 </script>		
								<%
							}
					else if(accept_out_intransit_yn.equals("N") && p_out_fcy.equals(facilityid) && (!p_file_stat.equals("E")) )
									
					{ 
								%>
								<script>		
								//err_message = "APP-FM0012 File already in Permanent FS Location. Hence cannot be returned";
								var p_patient_file_no="";
								var err_message = getMessage("FILE_ALREADY_IN_MRD","FM");
								p_patient_file_no = "";
                                 if("<%=vol_cnt%>" == "1") {
						    parent.frames[2].document.forms[0].flag.value="true";
						 parent.frames[2].document.forms[0].patientid.value="<%=patient_id%>";
				 parent.frames[2].document.forms[0].fileno.value="<%=p_patient_file_no%>";
					 parent.frames[2].document.forms[0].volno.value="<%=volume_no%>";
								
								parent.frames[2].document.forms[0].patient_id.value='';
								//parent.frames[2].document.getElementById("patientid1").onblur();
								parent.frames[2].document.forms[0].patient_id.onblur();
								 }
								</script>		
								<%
							}else{
										%>
							<script>		
								//err_message = "APP-FM0012 File already in Permanent FS Location. Hence cannot be returned";
								var err_message ="";
								</script>
							<%  } 
								%>
							<script>						
								parent.frames[2].document.forms[0].remove_volume.value = "<%=volume_no%>";
								//parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+err_message;
								 parent.frames[2].document.forms[0].Add.disabled =false;
								 if("<%=accept_out_intransit_yn%>" == "N") 
								  {
									 parent.frames[2].document.forms[0].show_files.disabled  =false;
								  }
	                            parent.frames[2].document.forms[0].Clear.disabled =false;
								if(parent.frames[2].document.forms[0].file_no != null)
									if(parent.frames[2].document.forms[0].file_no.type != "hidden")
										parent.frames[2].document.forms[0].file_no.focus();
							
							
							</script>
							<%
									} 
						if(rs != null) rs.close(); // for above if condition.
									

					if(p_file_status.equals("L") || p_file_status.equals("A"))
						{
							String error_message = "";
							if(p_file_status.equals("L"))
							{ %>
								<script>
								var p_patient_file_no="";
							error_message = getMessage("FILE_IS_LOST","FM");
							    parent.frames[2].document.forms[0].flag.value="true";
						 parent.frames[2].document.forms[0].patientid.value="<%=patient_id%>";
								 parent.frames[2].document.forms[0].fileno.value="<%=p_patient_file_no%>";
								 parent.frames[2].document.forms[0].volno.value="<%=volume_no%>";
								
								if("<%=vol_cnt%>" == "1") {
								 parent.frames[2].document.forms[0].Add.disabled =false;
								 if("<%=accept_out_intransit_yn%>" == "N") p_patient_file_no
								  {
									 parent.frames[2].document.forms[0].show_files.disabled  =false;
								  }

	                            parent.frames[2].document.forms[0].Clear.disabled =false;
								parent.frames[2].document.forms[0].patient_id.value='';
								//parent.frames[2].document.getElementById("patientid1").onblur();
								parent.frames[2].document.forms[0].patient_id.onblur();
								}
								</script>		
								<%
							}
							else if(p_file_status.equals("A"))
							{ %>
								<script>
								 //error_message = "APP-FM0077 File is currently in Archive. Hence cannot proceed";
								 error_message = getMessage("FILE_IN_ARCHIVE_CANNOT_PROCEED","FM");
								  parent.frames[2].document.forms[0].flag.value="true";
								parent.frames[2].document.forms[0].patientid.value="<%=patient_id%>";
								 parent.frames[2].document.forms[0].fileno.value="<%=p_patient_file_no%>";
								 parent.frames[2].document.forms[0].volno.value="<%=volume_no%>";
								 if("<%=vol_cnt%>" == "1") {
								 parent.frames[2].document.forms[0].patient_id.value='';
								 //parent.frames[2].document.getElementById("patientid1").onblur();
								 parent.frames[2].document.forms[0].patient_id.onblur();
								 }
								 </script>		
								<%
							}
							else
							{ %>
								<script>
							
								//error_message = "APP-FM0008 File(s) Lost/ in Transit / Archived. File(s) cannot be received at Medical Record Department";
								error_message = getMessage("RETURN_FILE_STATUS","FM");
                                  parent.frames[2].document.forms[0].flag.value="true";
								parent.frames[2].document.forms[0].patientid.value="<%=patient_id%>";
								 parent.frames[2].document.forms[0].fileno.value="<%=p_patient_file_no%>";
								 parent.frames[2].document.forms[0].volno.value="<%=volume_no%>";
								if("<%=vol_cnt%>" == "1") {
								parent.frames[2].document.forms[0].patient_id.value='';
								//parent.frames[2].document.getElementById("patientid1").onblur();
								parent.frames[2].document.forms[0].patient_id.onblur();
								}
								</script>		
								<%
							}
							%>
							<script>						
								//var errors = "<%=error_message%>";	
									parent.frames[2].document.forms[0].remove_volume.value = "<%=volume_no%>";
							parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+error_message ;
								 parent.frames[2].document.forms[0].Add.disabled =false;
								  if("<%=accept_out_intransit_yn%>" == "N") 
								  {
									 parent.frames[2].document.forms[0].show_files.disabled  =false;
								  }
	                           parent.frames[2].document.forms[0].Clear.disabled =false;
								if(parent.frames[2].document.forms[0].file_no != null)
									if(parent.frames[2].document.forms[0].file_no.type != "hidden")
										parent.frames[2].document.forms[0].file_no.focus();
							</script>
							<%
						}
						else
						{
													

							%>
							<script>

								/*var err_message = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");				parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+err_message;*/
								parent.frames[2].document.forms[0].Add.disabled =false;
								 if("<%=accept_out_intransit_yn%>" == "N") 
								  {
									 parent.frames[2].document.forms[0].show_files.disabled  =false;
								  }
	                            parent.frames[2].document.forms[0].Clear.disabled =false;
								if(parent.frames[1].document.forms[0].p_select_values.value.length == 0)
								{
									parent.frames[1].document.forms[0].p_select_values.value = '<%=p_patient_file_no%>';
								}
								else
								{
									parent.frames[1].document.forms[0].p_select_values.value = parent.frames[1].document.forms[0].p_select_values.value + '|' + '<%=p_patient_file_no%>';
								}
							</script>
							<%
						}
					  if(!deficiency_status.equals("")  && deficiency_status.equals("O"))	{ 
						%>
						<script>
                           var msg=getMessage("FM_DEFICIENCY_EXISTS","FM");
							if(window.confirm(msg)){

								var p_old_string	    = parent.frames[1].document.forms[0].p_select_values.value ;
								var p_deselect_file_no  = parent.frames[1].document.forms[0].p_deselect_files.value;
								var p_deselect_file_no;
								var p_select_file_no	= parent.frames[1].document.forms[0].p_select_files.value +'|' + parent.frames[1].document.forms[0].p_select_values.value;
								var p_curr_fstat		= parent.frames[1].document.forms[0].FILE_STAT.value;
								var p_outst_fcy			= parent.frames[2].document.forms[0].p_out_fcy.value;
								var p_fs_locn_id		= parent.frames[2].document.forms[0].FS_LOCN_ID.value;
								var p_out_fsloc			= parent.frames[2].document.forms[0].p_out_fsloc.value;
								var file_type_appl_yn	= parent.frames[2].document.forms[0].file_type_appl_yn.value;
								var doc_or_file			= parent.frames[2].document.forms[0].doc_or_file.value;
								var added_volumes		= "<%=added_volumes%>";
								var p_fs_location		= "<%=p_fs_location%>";
								var p_receiving_fs_locn= "<%=p_receiving_fs_locn%>";
								p_stored_val= "<%=p_stored_val%>";
								var buttonVal = "<%=buttonVal%>";
                             var patient_id= "<%=patient_id%>";
							var volume_no= "<%=volume_no%>";
							var p_patient_file_no="<%=p_patient_file_no%>";
								if(doc_or_file == 'D')
								{
									HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/DTReturnMRDSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value='"+p_select_file_no+"'><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='curr_fstat' id='curr_fstat' type='hidden' value="+p_curr_fstat+"><input name='p_outst_fcy' id='p_outst_fcy' type='hidden' value="+p_outst_fcy+"><input name='p_fs_locn_id' id='p_fs_locn_id' type='hidden' value="+p_fs_locn_id+"><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value="+p_out_fsloc+"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='doc_or_file' id='doc_or_file' type='hidden' value="+doc_or_file+"><input name='p_fs_location' id='p_fs_location' type='hidden' value="+p_fs_location+"><input name='p_receiving_fs_locn' id='p_receiving_fs_locn' type='hidden' value="+p_receiving_fs_locn+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='added_volumes' id='added_volumes' type='hidden' value='"+escape(added_volumes)+"'><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'><input name='patient_id' id='patient_id' type='hidden' value="+patient_id+"><input name='volume_no' id='volume_no' type='hidden' value="+volume_no+"><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value="+p_patient_file_no+"></form></BODY></HTML>";
								}
								else if(doc_or_file == 'F')
								{
								HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMReturnMRDSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value='"+p_select_file_no+"'><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='curr_fstat' id='curr_fstat' type='hidden' value="+p_curr_fstat+"><input name='p_outst_fcy' id='p_outst_fcy' type='hidden' value="+p_outst_fcy+"><input name='p_fs_locn_id' id='p_fs_locn_id' type='hidden' value="+p_fs_locn_id+"><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value="+p_out_fsloc+"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='added_volumes' id='added_volumes' type='hidden' value='"+escape(added_volumes)+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value="+p_fs_location+"><input name='p_receiving_fs_locn' id='p_receiving_fs_locn' type='hidden' value="+p_receiving_fs_locn+"><input name='p_stored_val' id='p_stored_val' type='hidden' value="+p_stored_val+"><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'><input name='patient_id' id='patient_id' type='hidden' value="+patient_id+"><input name='volume_no' id='volume_no' type='hidden' value="+volume_no+"><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value="+p_patient_file_no+"></form></BODY></HTML>";
								}

								parent.frames[3].document.write(HTMLVal);
								parent.frames[3].document.form1.submit();
								parent.frames[1].document.forms[0].p_curr_fs_loc.disabled = true;
								parent.frames[2].document.forms[0].flag.value="";
								if(parent.frames[2].document.forms[0].file_no != null)
								{
									parent.frames[2].document.forms[0].file_no.value = '';
									if(parent.frames[2].document.forms[0].file_no.type != "hidden")
									parent.frames[2].document.forms[0].file_no.focus();
								}
							}else {
					  	parent.frames[2].document.forms[0].flag.value="true";
				        parent.frames[2].document.forms[0].un_defcny.value="true";
					   parent.frames[2].document.forms[0].patientid.value="<%=patient_id%>";
					  parent.frames[2].document.forms[0].fileno.value="<%=p_patient_file_no%>";
					  parent.frames[2].document.forms[0].volno.value="<%=volume_no%>";
								  
								  parent.frames[2].document.forms[0].Add.disabled =false;
								  parent.frames[2].document.forms[0].patient_id.value='';
								  //parent.frames[2].document.getElementById("patientid1").onblur();
								  parent.frames[2].document.forms[0].patient_id.onblur();

							}
						</script>
						<%}else 
					          {
						%>
 						<script>
								var p_old_string	    = parent.frames[1].document.forms[0].p_select_values.value ;
							var p_deselect_file_no  = parent.frames[1].document.forms[0].p_deselect_files.value;
							var p_deselect_file_no;
							var p_select_file_no	= parent.frames[1].document.forms[0].p_select_files.value +'|' + parent.frames[1].document.forms[0].p_select_values.value;
							var p_curr_fstat		= parent.frames[1].document.forms[0].FILE_STAT.value;
							var p_outst_fcy			= parent.frames[2].document.forms[0].p_out_fcy.value;
							var p_fs_locn_id		= parent.frames[2].document.forms[0].FS_LOCN_ID.value;
							var p_out_fsloc			= parent.frames[2].document.forms[0].p_out_fsloc.value;
							var file_type_appl_yn	= parent.frames[2].document.forms[0].file_type_appl_yn.value;
							var doc_or_file			= parent.frames[2].document.forms[0].doc_or_file.value;
							var added_volumes		= "<%=added_volumes%>";
							var p_fs_location		= "<%=p_fs_location%>";
							var p_receiving_fs_locn= "<%=p_receiving_fs_locn%>";
							p_stored_val= "<%=p_stored_val%>";
							var buttonVal = "<%=buttonVal%>";
                            var patient_id= "<%=patient_id%>";
							var volume_no= "<%=volume_no%>";
							var p_patient_file_no="<%=p_patient_file_no%>";
							if(doc_or_file == 'D')
							{
								HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/DTReturnMRDSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value='"+p_select_file_no+"'><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='curr_fstat' id='curr_fstat' type='hidden' value="+p_curr_fstat+"><input name='p_outst_fcy' id='p_outst_fcy' type='hidden' value="+p_outst_fcy+"><input name='p_fs_locn_id' id='p_fs_locn_id' type='hidden' value="+p_fs_locn_id+"><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value="+p_out_fsloc+"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='doc_or_file' id='doc_or_file' type='hidden' value="+doc_or_file+"><input name='p_fs_location' id='p_fs_location' type='hidden' value="+p_fs_location+"><input name='p_receiving_fs_locn' id='p_receiving_fs_locn' type='hidden' value="+p_receiving_fs_locn+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='added_volumes' id='added_volumes' type='hidden' value='"+escape(added_volumes)+"'><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'><input name='patient_id' id='patient_id' type='hidden' value="+patient_id+"><input name='volume_no' id='volume_no' type='hidden' value="+volume_no+"><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value="+p_patient_file_no+"></form></BODY></HTML>";
							}
							else if(doc_or_file == 'F')
							{
											
								HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMReturnMRDSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value='"+p_select_file_no+"'><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='curr_fstat' id='curr_fstat' type='hidden' value="+p_curr_fstat+"><input name='p_outst_fcy' id='p_outst_fcy' type='hidden' value="+p_outst_fcy+"><input name='p_fs_locn_id' id='p_fs_locn_id' type='hidden' value="+p_fs_locn_id+"><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value="+p_out_fsloc+"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='added_volumes' id='added_volumes' type='hidden' value='"+escape(added_volumes)+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value="+p_fs_location+"><input name='p_receiving_fs_locn' id='p_receiving_fs_locn' type='hidden' value="+p_receiving_fs_locn+"><input name='p_stored_val' id='p_stored_val' type='hidden' value="+p_stored_val+"><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'><input name='patient_id' id='patient_id' type='hidden' value="+patient_id+"><input name='volume_no' id='volume_no' type='hidden' value="+volume_no+"><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value="+p_patient_file_no+"></form></BODY></HTML>";
							}

							parent.frames[3].document.write(HTMLVal);
							parent.frames[3].document.form1.submit();
							parent.frames[1].document.forms[0].p_curr_fs_loc.disabled = true;
							if(parent.frames[2].document.forms[0].file_no != null)
							{
								//parent.frames[2].document.forms[0].file_no.value = '';
								if(parent.frames[2].document.forms[0].file_no.type != "hidden")
									parent.frames[2].document.forms[0].file_no.focus();
							}
						</script>

						<%  } // Deficiency status is C 

					}
					else
					{
						%>
						<script>
							var errors = getMessage('FILES_NO_STORAGE_LOCATION','FM');
							parent.frames[2].document.forms[0].remove_volume.value = "<%=volume_no%>";
							parent.frames[5].document.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors;
							 parent.frames[2].document.forms[0].Add.disabled =false;
						  if("<%=accept_out_intransit_yn%>" == "N") 
						  {
							 parent.frames[2].document.forms[0].show_files.disabled  =false;
						  }

	                       parent.frames[2].document.forms[0].Clear.disabled =false;
							
							if (parent.frames[2].document.forms[0].file_no != null)
								if (parent.frames[2].document.forms[0].file_no.type != "hidden")
									parent.frames[2].document.forms[0].file_no.focus();
						</script>
						<%
					}
				}
			}
			else
			{
				
				if(!p_patient_file_no.equals(""))
				{
				
					%>
					<script>
						var errors = getMessage('FILE_NOT_EXIST','FM');
						parent.frames[2].document.forms[0].remove_volume.value = "<%=volume_no%>";
						parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
						 parent.frames[2].document.forms[0].Add.disabled =false;
					  if("<%=accept_out_intransit_yn%>" == "N") 
					  {
                         parent.frames[2].document.forms[0].show_files.disabled  =false;
					  }
	                 parent.frames[2].document.forms[0].Clear.disabled =false;
						if (parent.frames[2].document.forms[0].file_no != null)
							if (parent.frames[2].document.forms[0].file_no.type != "hidden")
								parent.frames[2].document.forms[0].file_no.focus();
					</script>
					<%
				}
			}
		}
		else if(p_search_type.equals("LF"))
		{
		sql = "select a.file_no,a.curr_fs_locn_code, a.curr_file_status from fm_curr_locn a where a.curr_facility_id='"+p_out_fcy+"' and a.curr_fs_locn_code = nvl('"+p_out_fsloc+"',a.curr_fs_locn_code) and a.perm_fs_locn_code != a.curr_fs_locn_code" ;
					
			rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				p_patient_file_no = rs.getString("file_no");
				p_file_status	  = rs.getString("curr_file_status");
				
				if(file_currfilesta.equals(""))				
				{
              file_currfilesta=p_patient_file_no;

				}else{
            file_currfilesta=file_currfilesta+ '|' +p_patient_file_no;
               
				}
				
				
				%>
				<!--<script>
					var p_check_file_status = '<%=p_file_status%>';
					if(parent.frames[1].document.forms[0].p_select_values.value.length==0)
					{
						parent.frames[1].document.forms[0].p_select_values.value = '<%=p_patient_file_no%>';
					}
					else
					{
						parent.frames[1].document.forms[0].p_select_values.value = parent.frames[1].document.forms[0].p_select_values.value + '|' + '<%=p_patient_file_no%>';
					}
				</script> -->
				<%
			
				
				} if(rs != null) rs.close();
			
			%>
			<script>
				
			parent.frames[1].document.forms[0].p_select_values.value = '<%=file_currfilesta%>';
			
			</script>
		<%	
			%>
			<script>
				var p_old_string		= parent.frames[1].document.forms[0].p_select_values.value ;
				var p_deselect_file_no	= parent.frames[1].document.forms[0].p_deselect_files.value;
				var p_deselect_file_no;
				
	//			var p_select_file_no	= parent.frames[1].document.forms[0].p_select_files.value +'|' + parent.frames[1].document.forms[0].p_select_values.value;
				
				var p_curr_fstat		= parent.frames[1].document.forms[0].FILE_STAT.value;
				var p_outst_fcy			= parent.frames[2].document.forms[0].p_out_fcy.value;
				var p_fs_locn_id		= parent.frames[2].document.forms[0].FS_LOCN_ID.value;
				var p_out_fsloc			= parent.frames[2].document.forms[0].p_out_fsloc.value;
				var file_type_appl_yn	= parent.frames[2].document.forms[0].file_type_appl_yn.value;
				var doc_or_file			= parent.frames[2].document.forms[0].doc_or_file.value;
				var p_fs_location		= "<%=p_fs_location%>";
				p_stored_val= "<%=p_stored_val%>";
				var buttonVal = "<%=buttonVal%>";
				var p_receiving_fs_locn= "<%=p_receiving_fs_locn%>";
				if(doc_or_file == 'D')
				{
					HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/DTReturnMRDSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value=''><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='curr_fstat' id='curr_fstat' type='hidden' value="+p_curr_fstat+"><input name='p_outst_fcy' id='p_outst_fcy' type='hidden' value="+p_outst_fcy+"><input name='p_fs_locn_id' id='p_fs_locn_id' type='hidden' value="+p_fs_locn_id+"><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value="+p_out_fsloc+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'><input name='doc_or_file' id='doc_or_file' type='hidden' value='"+doc_or_file+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value="+p_fs_location+"><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'><input name='p_receiving_fs_locn' id='p_receiving_fs_locn' type='hidden' value='"+p_receiving_fs_locn+"'></form></BODY></HTML>";
				}
				else
				{ 
					HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMReturnMRDSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value=''><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='curr_fstat' id='curr_fstat' type='hidden' value="+p_curr_fstat+"><input name='p_outst_fcy' id='p_outst_fcy' type='hidden' value="+p_outst_fcy+"><input name='p_fs_locn_id' id='p_fs_locn_id' type='hidden' value="+p_fs_locn_id+"><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value="+p_out_fsloc+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='p_stored_val' id='p_stored_val' type='hidden' value="+p_stored_val+"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value="+p_fs_location+"><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'><input name='p_receiving_fs_locn' id='p_receiving_fs_locn' type='hidden' value='"+p_receiving_fs_locn+"'></form></BODY></HTML>";
				}
				parent.frames[3].document.write(HTMLVal);
				parent.frames[3].document.form1.submit();
			    parent.frames[2].document.forms[0].Add.disabled =false;
				if("<%=accept_out_intransit_yn%>" == "N") 
					  {
                         parent.frames[2].document.forms[0].show_files.disabled  =false;
					  }
				parent.frames[2].document.forms[0].Clear.disabled =false;
				parent.frames[1].document.forms[0].p_curr_fs_loc.disabled = true;
			</script>
			<%
		}
		
		if(SelectSqlBuffer != null && SelectSqlBuffer.length() >0)
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}
		if(SelectSqlBuffer1 != null && SelectSqlBuffer1.length() >0)
		{
			SelectSqlBuffer1.delete(0,SelectSqlBuffer1.length());
		}
		if(CountSqlBuffer != null && CountSqlBuffer.length() >0)
		{
			CountSqlBuffer.delete(0,CountSqlBuffer.length());
		}
		if(CountSqlBuffer1 != null && CountSqlBuffer1.length() >0)
		{
			CountSqlBuffer1.delete(0,CountSqlBuffer1.length());
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	} catch(Exception e) { out.println("Exception ee :"+e.toString()); }
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</form>
</body>
</html>

