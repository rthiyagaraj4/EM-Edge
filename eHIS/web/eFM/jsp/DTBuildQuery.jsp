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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMReturnMRDFile.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
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
	java.util.Hashtable message;

	try
	{
		stmt = con.createStatement();
		
		String facilityid 		 = (String) session.getValue("facility_id");

		String sql						= "";
		String p_file_status			= "";		
		
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
		String p_file_stat			= request.getParameter("p_file_stat");
		String buttonVal            = request.getParameter("buttonVal");
		if(buttonVal == null) buttonVal = "";

		//String doc_or_file			= request.getParameter("doc_or_file")==null?"":request.getParameter("doc_or_file");

		p_patient_file_no	= ((p_patient_file_no == null) || (p_patient_file_no.equals("null"))) ? "" : 						p_patient_file_no;
		p_pat_file_type		= ((p_pat_file_type == null) || (p_pat_file_type.equals("null"))) ? "" : 							p_pat_file_type;
		volume_no			= ((volume_no== null) || (volume_no.equals("null"))) ? "" : volume_no;
		file_type_appl_yn	= ((file_type_appl_yn== null) || (file_type_appl_yn.equals("null"))) ? "N" : 						file_type_appl_yn;
		p_file_stat = ((p_file_stat== null) || (p_file_stat.equals("null"))||(p_file_stat.equals("S"))) ? "" : p_file_stat;
		added_volumes		= ((added_volumes==null) || (added_volumes.equals("null")))?"":added_volumes;
		added_volumes		= java.net.URLDecoder.decode(added_volumes);
//out.println("<script language='JavaScript'>alert('"+p_file_stat+"');</script>");
		boolean p_load_frame	 = true;

		int  p_fs_locn_code_cnt	 = 0;
		int p_count				 = 0;

		if(p_display == null) p_display = "";
		if(p_fs_location == null) p_fs_location = "";
		if(record_value == null) record_value = "";

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

			if(p_count == 0)
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
						</script>
						<%
					}
				}
				StringTokenizer token1	= new StringTokenizer(p_patient_file_no,",");
			//	String tokenValue1		= "";
				while(token1.hasMoreTokens())
				{
					p_patient_file_no = token1.nextToken();
				CountSqlBuffer1.append("select count(*) rec_cnt from fm_curr_locn where facility_id = '"+facilityid+"' ");
			//	if(!p_patient_file_no.equals(""))
			//		CountSqlBuffer1.append(" and file_no = '"+p_patient_file_no+"' ");
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
						out.println("<script language='JavaScript'>alert('"+p_patient_file_no+"');</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
						SelectSqlBuffer.append("select perm_fs_locn_code, curr_file_status from fm_curr_locn where facility_id='"+facilityid+"' and perm_fs_locn_code != curr_fs_locn_code ");
			
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
							
							if(!rs.getString("perm_fs_locn_code").equals(p_receiving_fs_locn))
							{
								%>
								<script>					
									var msg = getMessage('REC_FS_LOCN_NOT_OWNER','FM') +  ' - ' + '<%=p_patient_file_no%>';
									parent.frames[2].document.forms[0].remove_volume.value = "<%=volume_no%>";
									parent.frames[5].document.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg ;
								</script>
								<%
							}
						}
						else
						{
							SelectSqlBuffer1.append("select curr_file_status from fm_curr_locn where facility_id = '"+facilityid+"' ");
								
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
							} if(rs!=null) rs.close();
							
							String err_message = "";
							
							if(p_file_status.equals("T"))
							{
								//err_message = "APP-FM0076 File is currently in Transit. Hence cannot proceed";
								//err_message = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_IN_TRANSIT_CANNOT_PROCEED","fm_messages");

								message = MessageManager.getMessage(localeName,"FILE_IN_TRANSIT_CANNOT_PROCEED","FM");
								err_message = (String) message.get("message");


							}
							else if(p_file_status.equals("A"))
							{
								  //err_message = "APP-FM0077 File is currently in Archive. Hence cannot proceed";	
								  //err_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_IN_ARCHIVE_CANNOT_PROCEED","fm_messages");

								  message = MessageManager.getMessage(localeName,"FILE_IN_ARCHIVE_CANNOT_PROCEED","FM");
								  err_message = (String) message.get("message");
								  

							}
							else if(p_file_status.equals("I"))
							{
								// err_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_IN_MRD","fm_messages");

								 message = MessageManager.getMessage(localeName,"FILE_ALREADY_IN_MRD","FM");
								 err_message = (String) message.get("message");
							}
							else if(p_file_status.equals("O"))
							{
								 //err_message = "APP-FM0078 File not Returned. Hence cannot proceed";
								// err_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_NOT_RETURNED","fm_messages");

								message = MessageManager.getMessage(localeName,"FILE_NOT_RETURNED","FM");
								 err_message = (String) message.get("message");
							}
							else
							{
								//err_message = "APP-FM0012 File already in Permanent FS Location. Hence cannot be returned";
								//err_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_IN_MRD","fm_messages");
								message = MessageManager.getMessage(localeName,"FILE_ALREADY_IN_MRD","FM");
								 err_message = (String) message.get("message");
								p_patient_file_no = "";
							}
							%>
							<script>						
								var errors = "<%=err_message%>";
								parent.frames[2].document.forms[0].remove_volume.value = "<%=volume_no%>";
								parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
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
							{
								 //error_message = "APP-FM0078 File is Lost. Hence cannot proceed";
								 //error_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_IS_LOST","fm_messages");
								 message = MessageManager.getMessage(localeName,"FILE_IS_LOST","FM");
								 error_message = (String) message.get("message");
							}
							else if(p_file_status.equals("A"))
							{
								 //error_message = "APP-FM0077 File is currently in Archive. Hence cannot proceed";
								// error_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_IN_ARCHIVE_CANNOT_PROCEED","fm_messages");
								 message = MessageManager.getMessage(localeName,"FILE_IN_ARCHIVE_CANNOT_PROCEED","FM");
								 error_message = (String) message.get("message");
							}
							else
							{
								//error_message = "APP-FM0008 File(s) Lost/ in Transit / Archived. File(s) cannot be received at Medical Record Department";
								//error_message =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"RETURN_FILE_STATUS","fm_messages");

								message = MessageManager.getMessage(localeName,"RETURN_FILE_STATUS","FM");
								 error_message = (String) message.get("message");
							}
							%>
							<script>						
								var errors = "<%=error_message%>";	
								parent.frames[2].document.forms[0].remove_volume.value = "<%=volume_no%>";
								parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
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
							
							if(doc_or_file == 'D')
							{
								HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/DTReturnMRDSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value='"+p_select_file_no+"'><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='curr_fstat' id='curr_fstat' type='hidden' value="+p_curr_fstat+"><input name='p_outst_fcy' id='p_outst_fcy' type='hidden' value="+p_outst_fcy+"><input name='p_fs_locn_id' id='p_fs_locn_id' type='hidden' value="+p_fs_locn_id+"><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value="+p_out_fsloc+"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='doc_or_file' id='doc_or_file' type='hidden' value="+doc_or_file+"><input name='p_fs_location' id='p_fs_location' type='hidden' value="+p_fs_location+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='added_volumes' id='added_volumes' type='hidden' value='"+escape(added_volumes)+"'><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'></form></BODY></HTML>";
							}
							else if(doc_or_file == 'F')
							{
								HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMReturnMRDSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value='"+p_select_file_no+"'><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='curr_fstat' id='curr_fstat' type='hidden' value="+p_curr_fstat+"><input name='p_outst_fcy' id='p_outst_fcy' type='hidden' value="+p_outst_fcy+"><input name='p_fs_locn_id' id='p_fs_locn_id' type='hidden' value="+p_fs_locn_id+"><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value="+p_out_fsloc+"><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value="+file_type_appl_yn+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='added_volumes' id='added_volumes' type='hidden' value='"+escape(added_volumes)+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value="+p_fs_location+"><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'></form></BODY></HTML>";
							}
							alert('HTMLVal 1 => '+HTMLVal);
							parent.frames[3].document.write(HTMLVal);
							parent.frames[3].document.form1.submit();
							parent.frames[1].document.forms[0].p_curr_fs_loc.disabled = true;
							if(parent.frames[2].document.forms[0].file_no != null)
							{
								parent.frames[2].document.forms[0].file_no.value = '';
								if(parent.frames[2].document.forms[0].file_no.type != "hidden")
									parent.frames[2].document.forms[0].file_no.focus();
							}
						</script>
						<%
					}
					else
					{
						%>
						<script>
							var errors = getMessage('FILES_NO_STORAGE_LOCATION','FM');
							parent.frames[2].document.forms[0].remove_volume.value = "<%=volume_no%>";
							parent.frames[5].document.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors;
							if (parent.frames[2].document.forms[0].file_no != null)
								if (parent.frames[2].document.forms[0].file_no.type != "hidden")
									parent.frames[2].document.forms[0].file_no.focus();
						</script>
						<%
					}
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
				%>
				<script>
					var p_check_file_status = '<%=p_file_status%>';
					if(parent.frames[1].document.forms[0].p_select_values.value.length==0)
					{
						parent.frames[1].document.forms[0].p_select_values.value = '<%=p_patient_file_no%>';
					}
					else
					{
						parent.frames[1].document.forms[0].p_select_values.value = parent.frames[1].document.forms[0].p_select_values.value + '|' + '<%=p_patient_file_no%>';
					}
				</script>
				<%
			} if(rs != null) rs.close();
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
				if(doc_or_file == 'D')
				{
					HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/DTReturnMRDSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value=''><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='curr_fstat' id='curr_fstat' type='hidden' value="+p_curr_fstat+"><input name='p_outst_fcy' id='p_outst_fcy' type='hidden' value="+p_outst_fcy+"><input name='p_fs_locn_id' id='p_fs_locn_id' type='hidden' value="+p_fs_locn_id+"><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value="+p_out_fsloc+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'><input name='doc_or_file' id='doc_or_file' type='hidden' value='"+doc_or_file+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value="+p_fs_location+"><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'></form></BODY></HTML>";
				}
				else
				{ 
					HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMReturnMRDSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value=''><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='curr_fstat' id='curr_fstat' type='hidden' value="+p_curr_fstat+"><input name='p_outst_fcy' id='p_outst_fcy' type='hidden' value="+p_outst_fcy+"><input name='p_fs_locn_id' id='p_fs_locn_id' type='hidden' value="+p_fs_locn_id+"><input name='p_out_fsloc' id='p_out_fsloc' type='hidden' value="+p_out_fsloc+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'><input name='p_fs_location' id='p_fs_location' type='hidden' value="+p_fs_location+"><input name='buttonVal' id='buttonVal' type='hidden' value='"+buttonVal+"'></form></BODY></HTML>";
				}
				alert('HTMLVal 2 => '+HTMLVal);
				parent.frames[3].document.write(HTMLVal);
				parent.frames[3].document.form1.submit();
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

