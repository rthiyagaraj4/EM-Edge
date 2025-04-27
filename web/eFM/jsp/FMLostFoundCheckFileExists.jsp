<!DOCTYPE html>
<!--
	Created On	: 6/21/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: File Lost / Found 
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>
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
	<script language='javascript' src='../../eFM/js/FMLostFound.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form>
<%
	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
try
{
	String sql 				 = "";
	String p_file_status	 = "";
	String volumeCriteria    = "";
	String more_Criteria     = "";
	String file_type_code	 = "";	
	String curr_facility_id="";
	int p_count				 = 0;

	String facilityid 				= (String) session.getValue("facility_id");

	String p_enter_fcy				= request.getParameter("p_enter_fcy");
	//String p_curr_location			= request.getParameter("p_curr_location");
	String patient_id				= request.getParameter("patient_id");
	String p_patient_file_no		= request.getParameter("p_patient_file_no");
	String p_patient_file_type_code = request.getParameter("p_patient_file_type_code");
	String volume_no				= request.getParameter("volume_no");
	String p_doc_file_no			= request.getParameter("p_doc_file_no");
	String doc_folder_id			= request.getParameter("doc_folder_id");
	String doc_type_code			= request.getParameter("doc_type_code");
	String file_type_appl_yn		= request.getParameter("file_type_appl_yn");
	String maintain_doc_or_file		= request.getParameter("maintain_doc_or_file");
	String appl_user_name			= request.getParameter("appl_user_name");
	String p_curr_location	 = request.getParameter("p_curr_location");

	if(p_enter_fcy==null || p_enter_fcy.equals("null")) p_enter_fcy=facilityid ;
	if(patient_id == null || patient_id.equals("null")) patient_id = "";
	if(p_patient_file_no == null || p_patient_file_no.equals("null")) p_patient_file_no = "";
	if(file_type_code == null || file_type_code.equals("null")) file_type_code = "";
	if(volume_no == null || volume_no.equals("null")) volume_no = "";
	if(p_doc_file_no == null || p_doc_file_no.equals("null")) p_doc_file_no = "";
	if(doc_folder_id == null || doc_folder_id.equals("null")) doc_folder_id = "";
	if(doc_type_code == null || doc_type_code.equals("null")) doc_type_code = "";
	if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) maintain_doc_or_file = "";
	if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "";
	if(appl_user_name == null || appl_user_name.equals("null")) appl_user_name = "";
	if(p_curr_location == null || p_curr_location.equals("null")) p_curr_location = "";	

	if((volume_no != null) && !(volume_no.equals(""))) 
	{
		volumeCriteria = " AND VOLUME_NO = "+volume_no+" ";
	}
	if(!p_curr_location.equals("")) 
	{		
		more_Criteria = " AND perm_fs_locn_code = '"+p_curr_location+"' ";
	}
	
	if(maintain_doc_or_file.equals("F")) 
	{
		if(file_type_appl_yn.equals("N")) 
		{
			more_Criteria = more_Criteria +" AND FILE_NO = '"+p_patient_file_no+"' ";
		}
		else if(file_type_appl_yn.equals("Y")) 
		{
			more_Criteria  =more_Criteria + " AND FILE_TYPE_CODE = '"+p_patient_file_type_code+"' ";
		}

		//sql = "select curr_file_status from fm_curr_locn_vw where patient_id = ? "+volumeCriteria+" "+more_Criteria+" and curr_facility_id = ?";
		sql = "select curr_file_status,curr_facility_id from fm_curr_locn where patient_id = ? "+volumeCriteria+" "+more_Criteria+"  and facility_id = ?";
			
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,p_enter_fcy);
		rs = pstmt.executeQuery();


		
		while(rs != null && rs.next()) 
		{
			p_file_status  = rs.getString(1);
			curr_facility_id= rs.getString(2);
			p_count++;
			}
		if(curr_facility_id==null) curr_facility_id="";
		
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();
		if(p_count > 0 && curr_facility_id.equals(p_enter_fcy))
		{
		%>
		<script>
			if('<%=p_file_status%>' == 'T' || '<%=p_file_status%>'=='R' || '<%=p_file_status%>' == 'E') 
			{
				var errors = getMessage('FILE_IN_TRANSIT_CANNOT_PROCEED','FM');
				parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			 parent.search_criteria.document.getElementById("hdr_tab").style.visibility = 'hidden';
			 parent.frames[2].location.href='../../eCommon/html/blank.html';
			 parent.frames[3].location.href='../../eCommon/html/blank.html';
			}
			else 
			{
				parent.frames[2].document.location.href='../../eFM/jsp/FMLostFoundRecordFrame.jsp?p_patient_file_no=<%=p_patient_file_no%>&volume_no=<%=volume_no%>&patient_id=<%=patient_id%>&file_type_code=<%=p_patient_file_type_code%>&file_type_appl_yn=<%=file_type_appl_yn%>&appl_user_name=<%=appl_user_name%>';
				
				parent.frames[3].document.location.href='../../eFM/jsp/FMLostFoundChangeStatus.jsp?p_patient_file_no=<%=p_patient_file_no%>&p_patient_file_type=<%=p_patient_file_type_code%>&file_type_appl_yn=<%=file_type_appl_yn%>&volume_no=<%=volume_no%>&appl_user_name=<%=appl_user_name%>';
			}
		</script>
		<%	
		}else
		{
				
			if(!curr_facility_id.equals("") && !curr_facility_id.equals(p_enter_fcy))
			{ %>
			<script>
			var errors = getMessage('FILE_STATUS_OTHER_CANNOT_CHANGE','FM');
			parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			parent.search_criteria.document.getElementById("hdr_tab").style.visibility = 'hidden';
			parent.frames[2].location.href='../../eCommon/html/blank.html';
			parent.frames[3].location.href='../../eCommon/html/blank.html';
			</script>
			<%}else if(!p_patient_file_no.equals(""))
				{
			%>
			<script>
				var errors = getMessage('FILE_STATUS_CANNOT_CHANGE','FM');
			parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			parent.search_criteria.document.getElementById("hdr_tab").style.visibility = 'hidden';
			parent.frames[2].location.href='../../eCommon/html/blank.html';
			parent.frames[3].location.href='../../eCommon/html/blank.html';
			</script>
			<%
				}else{
			%>
			<script>
				var errors = getMessage('PATIENT_FILE_NOT_EXIST','FM');
			parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			 parent.frames[1].location.href='../../eCommon/html/blank.html';
			parent.frames[2].location.href='../../eCommon/html/blank.html';
			parent.frames[3].location.href='../../eCommon/html/blank.html';
			</script>
			<%
			}
			}
	}
	else if(maintain_doc_or_file.equals("D")) 
	{
		if(!patient_id.equals("")) 
	{		
		more_Criteria = " AND patient_id = '"+patient_id+"' ";
	}
		
			//sql ="select curr_file_status from fm_curr_locn_vw where  curr_facility_id = ? and doc_folder_id = ? and doc_type_code = ? and  curr_facility_id = ? "+more_Criteria+" AND mr_pat_fs_locn_code = ? ";
			sql ="select curr_file_status from fm_curr_locn where  curr_facility_id = ? and doc_folder_id = ? and doc_type_code = ? and  curr_facility_id = ? "+more_Criteria+"AND perm_fs_locn_code = ?" ;
			//and file_no = ? 
			pstmt = con.prepareStatement(sql);

	//		pstmt.setString(1,patient_id);
			pstmt.setString(1,p_enter_fcy);
			pstmt.setString(2,doc_folder_id);
			pstmt.setString(3,doc_type_code);			
			pstmt.setString(4,p_enter_fcy);
			pstmt.setString(5,p_curr_location);
		//	pstmt.setString(6,p_doc_file_no);

			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{
				p_file_status  = rs.getString(1);
				p_count++;
			}
			if(p_count > 0)
		{
			%>
			<script>
				if('<%=p_file_status%>' == 'T' || '<%=p_file_status%>' == 'R')
				{
					var errors = getMessage('DOC_IN_TRANSIT_CANNOT_PROCEED','FM');
					parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				  parent.search_criteria.document.getElementById("hdr_tab").style.visibility = 'hidden';
				  parent.frames[2].location.href='../../eCommon/html/blank.html';
				  parent.frames[3].location.href='../../eCommon/html/blank.html';
				}
				else 
				{
					parent.frames[2].document.location.href='../../eFM/jsp/DTLostFoundRecordFrame.jsp?p_doc_file_no=<%=p_doc_file_no%>&patient_id=<%=patient_id%>&doc_type_code=<%=doc_type_code%>&doc_folder_id=<%=doc_folder_id%>&patient_id=<%=patient_id%>&appl_user_name=<%=appl_user_name%>';
				
					parent.frames[3].document.location.href='../../eFM/jsp/DTLostFoundChangeStatus.jsp?p_doc_file_no=<%=p_doc_file_no%>&doc_type_code=<%=doc_type_code%>&doc_folder_id=<%=doc_folder_id%>&patient_id=<%=patient_id%>&appl_user_name=<%=appl_user_name%>';
				}
			</script>
		<%	
			}
			else 
			{
				%>
				<script>
						var errors = getMessage('DOC_NOT_EXIST','FM');
						parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				      parent.search_criteria.document.getElementById("hdr_tab").style.visibility = 'hidden';
					  parent.frames[2].location.href='../../eCommon/html/blank.html';
					 parent.frames[3].location.href='../../eCommon/html/blank.html';
				   
				</script>
				<%			
			}
		}

		if(rs!=null) rs.close();	
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e);
	}
	finally
	{					
			ConnectionManager.returnConnection(con,request);	
	}
%>
	</form>
	</body>
</html>

