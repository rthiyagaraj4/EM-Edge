<!DOCTYPE html>
<!--
	Created On	: 6/15/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Request of File
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eFM/js/FMRequestFile.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form>
<%
	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	
try
{
	stmt = con.createStatement();
	String p_patient_file_no = request.getParameter("p_patient_file_no");
	String facility_id = request.getParameter("facility_id");
	String file_type_appl_yn = request.getParameter("file_type_appl_yn");
	String sql				 = "";
	String facilityid 		 = (String) session.getValue("facility_id");
	int p_count				 = 0;
	int p_fs_locn_code_cnt   = 0,p_file_no_found=0;
	String p_enter_fcy		 = request.getParameter("p_enter_fcy");
	String p_req_fs_locn	 = request.getParameter("p_req_fs_locn");
	String conc_remarks		 = request.getParameter("conc_remarks");
	String p_new_string		 = "";		
	String p_display_files = "",p_file_no="";

	String fileno_name			= checkForNull(request.getParameter("fileno_name"));
	String filetype_name		= checkForNull(request.getParameter("filetype_name"));
	String file_no_function		= checkForNull(request.getParameter("file_no_function"));
	String file_type_function	= checkForNull(request.getParameter("file_type_function"));
	String frame_name			= checkForNull(request.getParameter("frame_name"));
	String form_name			= checkForNull(request.getParameter("form_name"));
	String volumeno_name		= checkForNull(request.getParameter("volumeno_name"));
	java.util.Hashtable message;


	if (p_enter_fcy.equals("null") || p_enter_fcy.equals("")) p_enter_fcy=facilityid ;

		sql = "select count(a.file_no) rec_cnt from fm_curr_locn a , mr_pat_file_index b where a.facility_id=b.facility_id and a.file_no=b.file_no and b.patient_id='"+p_patient_file_no+"' and b.facility_id='"+p_enter_fcy+"' ";

		rs = stmt.executeQuery(sql);

		while (rs.next())
		{
			p_count = rs.getInt("rec_cnt");
		}
		if (rs!=null) rs.close();

		if (p_count > 0)
		{
			
			if(file_type_appl_yn.equals("Y"))
			{
			try {

			String code = "";
			String desc = "";
			//String strsql = "Select a.short_desc short_desc, b.file_type_code file_type_code from mr_file_type a, mr_pat_file_index b where a.facility_id = b.facility_id and a.file_type_code = b.file_type_code and a.facility_id = '"+facility_id+"' and patient_id = '"+p_patient_file_no+"'";		
			String strsql = "SELECT"
							  +"  MR_GET_DESC.MR_FILE_TYPE(FACILITY_ID, FILE_TYPE_CODE,'"+localeName+"','2') Short_desc"
							  +"  , File_Type_Code File_Type_Code "
							  +"FROM"
							  +"  mr_Pat_File_Index "
							  +"WHERE Facility_Id = '"+facility_id+"' "
							  +"  AND Patient_Id = '"+p_patient_file_no+"'";

			pstmt = con.prepareStatement(strsql);
			rset = pstmt.executeQuery();
			if (rset!=null)
		    {	
			%><script>
				if ((parent.frames[3].document.forms[0].file_type != null ) && (parent.frames[3].document.forms[0].file_type.type != "text"))
				{
				var n = parent.frames[3].document.forms[0].file_type.options.length;
				for(var i=0;i<n;i++)
						{	parent.frames[3].document.forms[0].file_type.remove("file_type");
						}
				var temp2 ='';
				var temp3='----'+getLabel("Common.defaultSelect.label","Common")+'----';
				var opt=parent.frames[3].document.createElement("OPTION");								
					 opt.text=temp3;
					 opt.value=temp2;
				parent.frames[3].document.forms[0].file_type.add(opt);
				}
			</script><%
				while(rset.next())
				{				
				code = rset.getString("file_type_code")==null?"":rset.getString("file_type_code");
				desc = rset.getString("short_desc")==null?"":rset.getString("short_desc");%>
				<script>
				if ((parent.frames[3].document.forms[0].file_type != null )&&(parent.frames[3].document.forms[0].file_type.type != "text"))
				{
					var temp = "<%=code%>";
					var temp1="<%=desc%>";
					var opt=parent.frames[3].document.createElement("OPTION");									

						opt.text=temp1;
						opt.value=temp;
					
					parent.frames[3].document.forms[0].file_type.add(opt);
				}
				</script><%
				}
			}
			}catch(Exception e){out.println("Exception in File Type");}
			finally { if(pstmt!=null)pstmt.close(); if(rset!=null)rset.close();}
			}

			sql = "select b.file_no , b.perm_fs_locn_code,b.curr_file_status from fm_curr_locn b where b.patient_id='"+p_patient_file_no+"' and b.facility_id='"+p_enter_fcy+"'";

			rs = stmt.executeQuery(sql);

		while (rs.next())
		{
			p_file_no = rs.getString("file_no");

			if (rs.getString("perm_fs_locn_code").equals(p_req_fs_locn) && p_enter_fcy.equals(facilityid))
			{
				if (p_display_files.equals(""))
				{
					p_display_files = p_display_files + "" + rs.getString("file_no");
				}
				else
				{
					p_display_files = p_display_files + ","+ rs.getString("file_no");
				}
			}
			else
			{
				p_new_string = p_new_string + "|" + rs.getString("file_no") ;
			}

		}
		if (rs!=null) rs.close();

		sql = "select count(*) rec_cnt from mr_pat_file_index where patient_id='"+p_patient_file_no+"' and facility_id='"+p_enter_fcy+"' and fs_locn_code is not null";

		rs = stmt.executeQuery(sql);

		while (rs.next())
		{
			p_fs_locn_code_cnt = rs.getInt("rec_cnt");
		}
		if (rs!=null) rs.close();

			if (p_fs_locn_code_cnt > 0)
			{

			sql = "SELECT to_char(A.SENT_DATE_TIME,'dd/mm/rrrr hh:mi AM') FROM FM_TRANSIT_FILE A WHERE A.FACILITY_ID='"+p_enter_fcy+"' AND A.FILE_NO='"+p_file_no+"' AND DEST_FACILITY_ID='"+p_enter_fcy+"' AND DEST_FS_LOCN_CODE='"+p_req_fs_locn+"' ";

			rs1 = stmt.executeQuery(sql);

			String p_error_message = "", p_sent_date_time="";
			while (rs1.next())
			{
				p_file_no_found++;			
				p_sent_date_time = rs1.getString(1);
			}		

				if (p_file_no_found ==0)	
				{

					//sql = "SELECT A.REQ_FS_LOCN_DESC || ' (' || A.REQ_FACILITY_NAME || ')', TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM'),A.REQ_BY_NAME FROM FM_REQ_HDR_VW A, FM_REQ_DTL B WHERE A.REQ_NO=B.REQ_NO AND A.REQ_FS_LOCN_CODE='"+p_req_fs_locn+"' AND A.REQ_FACILITY_ID='"+p_enter_fcy+"' AND B.FILE_NO='"+p_file_no+"' AND B.ISS_YN='N' AND B.CANCEL_YN='N'";
					sql = "SELECT"
									  +"  fm_Get_desc.Fm_storage_locn('"+facility_id+"',a.REQ_FS_LOCN_CODE,'"+localeName+"',2) ||' (' ||sm_Get_desc.SM_FACILITY_PARAM(a.REQ_FACILITY_ID,'"+localeName+"',1) ||')'"
									  +"  , TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM')"
									  +"  , sm_Get_desc.SM_APPL_USER(A.REQ_USER_ID,'"+localeName+"',1) "
									  +"FROM"
									  +"  FM_REQ_HDR A"
									  +"  , FM_REQ_DTL B "
									  +"WHERE A.REQ_NO = B.REQ_NO "
									  +"  AND A.REQ_FS_LOCN_CODE = '"+p_req_fs_locn+"' "
									  +"  AND A.REQ_FACILITY_ID = '"+p_enter_fcy+"' "
									  +"  AND B.FILE_NO = '"+p_file_no+"' "
									  +"  AND B.ISS_YN = 'N' "
									  +"  AND B.CANCEL_YN = 'N'";


					rs = stmt.executeQuery(sql);

					while (rs.next())
					{
						p_file_no_found++;

						//p_error_message =" File no " + p_file_no + " already requested by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
						//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_REQUSTED","fm_messages");

						message = MessageManager.getMessage(localeName,"FILE_ALREADY_REQUSTED","FM");
						p_error_message = (String) message.get("message");


						p_error_message=p_error_message.replace("$",p_file_no);
						p_error_message=p_error_message.replace("#",rs.getString(1));
						p_error_message=p_error_message.replace("~",rs.getString(2));
						p_error_message=p_error_message.replace("%",rs.getString(3));
					}
				}
				else
				{					
					//p_error_message =" File no " + p_file_no + " is already been issued on " + p_sent_date_time  ;
					//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_ISSUED","fm_messages");

					message = MessageManager.getMessage(localeName,"FILE_ALREADY_ISSUED","FM");
					p_error_message = (String) message.get("message");


					p_error_message=p_error_message.replace("$",p_file_no);
					p_error_message=p_error_message.replace("#",p_sent_date_time);
				}
			
			%>
				<script>
					if 	(parseInt('<%=p_file_no_found%>') > 0 )
					{
					alert(getMessage('FILE_ALREADY_REQUESTED','FM')+"\n"+"<%=p_error_message%>");
					parent.frames[3].document.forms[0].p_patient_id.value='';
					if ((parent.frames[3].document.forms[0].file_type != null ) && (parent.frames[3].document.forms[0].file_type.type != "text"))
					{
					var n = parent.frames[3].document.forms[0].file_type.options.length;
					for(var i=0;i<n;i++)
						{	parent.frames[3].document.forms[0].file_type.remove("file_type");
						}
					var temp2 ='';
					var temp3='----'+getLabel("Common.defaultSelect.label","Common")+'----';
					var opt=parent.frames[3].document.createElement("OPTION");								opt.text=temp3;
										opt.value=temp2;
					parent.frames[3].document.forms[0].file_type.add(opt);

					}					

					parent.frames[3].document.forms[0].p_patient_id.focus();
					}
				</script>
				<script>			
			if 	(parseInt('<%=p_file_no_found%>') == 0 )
			{

				if (parent.frames[3].document.forms[0].p_select_values.value.length==0)
				{
					parent.frames[3].document.forms[0].p_select_values.value = '<%=p_new_string%>';
				}
				else
				{
					parent.frames[3].document.forms[0].p_select_values.value = parent.frames[3].document.forms[0].p_select_values.value + '|' + '<%=p_new_string%>';

				}

					var p_old_string = parent.frames[3].document.forms[0].p_select_values.value ;
					
					var p_deselect_file_no = "";
					var p_select_file_no = parent.frames[3].document.forms[0].p_select_files.value +'|' + parent.frames[3].document.forms[0].p_select_values.value;

					if (parent.frames[2].document.forms[0].logged_fcy.value=='L')
					{
						parent.frames[2].document.forms[0].logged_fcy.disabled=true;
					}
					else
					{
						parent.frames[2].document.forms[0].logged_fcy.disabled=true;
						parent.frames[2].document.forms[0].enter_fcy.disabled=true;
					}

					HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMRequestSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value='"+p_select_file_no+"'><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"><input name='p_valtype' id='p_valtype' type='hidden' value='F'><input name='conc_remarks' id='conc_remarks' type='hidden' value=<%=conc_remarks%>><input name='p_enter_fcy' id='p_enter_fcy' type='hidden' value=<%=p_enter_fcy%>><input name='p_req_fs_locn' id='p_req_fs_locn' type='hidden' value=<%=p_req_fs_locn%><input name='fileno_name' id='fileno_name' type='hidden' value='<%=fileno_name%>'><input name='filetype_name' id='filetype_name' type='hidden' value='<%=filetype_name%>'><input name='file_no_function' id='file_no_function' type='hidden' value='<%=file_no_function%>'><input name='file_type_function' id='file_type_function' type='hidden' value='<%=file_type_function%>'><input name='frame_name' id='frame_name' type='hidden' value='<%=frame_name%>'><input name='form_name' id='form_name' type='hidden' value='<%=form_name%>'><input name='volumeno_name' id='volumeno_name' type='hidden' value='<%=volumeno_name%>'></form></BODY></HTML>";
					parent.frames[4].document.write(HTMLVal);
					parent.frames[4].document.form1.submit();

					parent.frames[1].document.forms[0].FS_LOCN_ID.disabled=true;
					parent.frames[1].document.forms[0].req_location.disabled=true;

					var p_disp_files = '<%=p_display_files%>';

					if (p_disp_files.length>0)
					{
						var errors = getMessage('REQUEST_EQUALS_CURRENT','FM')+ ' . Files are : ' + p_disp_files;
						parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					}
					parent.frames[3].document.forms[0].p_patient_id.value='';
					parent.frames[3].document.forms[0].p_patient_id.focus();
				}
				</script>
				<%
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
			%>
			<script>
				parent.frames[3].document.forms[0].patient_id.value='<%=p_patient_file_no%>'; 
			</script>
		<%
		}
		else
		{
			if(!p_patient_file_no.equals("null"))
			{
				%>
				<script>
					var errors = getMessage('PATIENT_NOT_EXIST','FM');				
					parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					parent.frames[3].document.forms[0].p_patient_id.focus();
					parent.frames[3].document.forms[0].p_patient_id.select();
				</script>
				<%
			}
		}
		%>
		<script>
			parent.frames[3].document.forms[0].flag.value='';	
		</script>
		<%
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(stmt!=null) stmt.close();	
	}
	catch(Exception e)
	{
	//	out.println("Exception e :"+e);
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

