<!DOCTYPE html>
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
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
</head>
<body class='message' onKeyDown = 'lockKey()'>
<form name="checkvals" id="checkvals">
<%
	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	
	int p_file_no_found = 0;

	try
	{

		String facility_id	= (String) session.getValue("facility_id");
		String user_id		= (String) session.getValue("login_user");

		String sql				= "";
		String sql1				= "";
		String pat_id			= "";
		String pat_line			= "";
		String file_no			= "";
		String fs_locn			= "";
		String currFacility		= "";
		String currLocn			= "";
		String currDesc			= "";
		String currStat			= "";
		String currStatDesc		= "";
		String currIden			= "";
		String currIdDesc		= "";
		String currMrLocn		= "";
		String sysdate			= "";
		String remark			= "";		
		String moreCriteria		= "";
	String curr_faCILITY_ID="";
      java.util.Hashtable message;
		String userSecurity = request.getParameter("userSecurity");
		String FileNo = request.getParameter("FileNo");
		String issueLocn = request.getParameter("issueLocn");
		String Facility = request.getParameter("Facility");
		String selLocn	= request.getParameter("selLocn");
		String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
//		String doctype_appl_yn = request.getParameter("doctype_appl_yn")==null?"Y":request.getParameter("doctype_appl_yn");
		
		StringTokenizer token	= new StringTokenizer(FileNo,",");
		while(token.hasMoreTokens())
				{
					FileNo = token.nextToken();
				}
//out.println("<script language='JavaScript'>alert('"+FileNo+"');</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();
    
	   pstmt = con.prepareStatement("SELECT curr_faCILITY_ID FROM fm_curr_locn WHERE  file_no='"+FileNo+"' AND  FACILITY_ID='"+facility_id+"' ");
		rs = pstmt.executeQuery();
       	while(rs != null && rs.next())
		{
		curr_faCILITY_ID=rs.getString("curr_faCILITY_ID");
			}
		if(rs!=null) rs.close();
		
		if(userSecurity.equals("Y")) 
		{			

			if(access_all.equals("*ALL"))
			{
				//SelectSqlBuffer.append("Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, CURR_FACILITY_ID, get_patient_line(PATIENT_ID) PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost','E','Other Facility') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , REMARKS, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW where FILE_NO = ? and  CURR_FACILITY_ID = ? and CURR_FS_LOCN_CODE = MR_PAT_FS_LOCN_CODE ");

				SelectSqlBuffer.append("SELECT" );
				SelectSqlBuffer.append("  PATIENT_ID" );
				SelectSqlBuffer.append("  , FILE_NO" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_CODE" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
				SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
				SelectSqlBuffer.append("  , Get_patient_line(PATIENT_ID,'"+localeName+"') PLINE" );
				SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
				SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+curr_faCILITY_ID+"',Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
				SelectSqlBuffer.append("  , REMARKS" );
				SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
				SelectSqlBuffer.append("FROM" );
				SelectSqlBuffer.append("  FM_CURR_LOCN " );
				SelectSqlBuffer.append("WHERE FILE_NO = ? " );
				SelectSqlBuffer.append("  AND FACILITY_ID = ? " );
				SelectSqlBuffer.append("  AND CURR_FS_LOCN_CODE = PERM_FS_LOCN_CODE" );


				pstmt = con.prepareStatement(SelectSqlBuffer.toString());
				pstmt.setString(1,FileNo);
				pstmt.setString(2,facility_id);
			}
			else
			{
				if(Facility.equals(facility_id)) moreCriteria = " ISS_YN = 'Y' ";
				else moreCriteria = " ISS_ACROSS_FACILITIES_YN = 'Y' ";

				//SelectSqlBuffer.append("Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, CURR_FACILITY_ID, get_patient_line(PATIENT_ID) PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost','E','Other Facility') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC, REMARKS,  TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW A, FM_USER_ACCESS_RIGHTS B where FILE_NO = ? and  A.CURR_FACILITY_ID = ? AND A.CURR_FS_LOCN_CODE = A.MR_PAT_FS_LOCN_CODE AND A.CURR_FACILITY_ID = B.FACILITY_ID AND B.APPL_USER_ID = ? AND FS_LOCN_CODE = CURR_FS_LOCN_CODE AND "+moreCriteria+" ");

				SelectSqlBuffer.append("SELECT" );
				SelectSqlBuffer.append("  PATIENT_ID" );
				SelectSqlBuffer.append("  , FILE_NO" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_CODE" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
				SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
				SelectSqlBuffer.append("  , Get_patient_line(PATIENT_ID,'"+localeName+"') PLINE" );
				SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
				SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+curr_faCILITY_ID+"',Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
				SelectSqlBuffer.append("  , REMARKS" );
				SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
				SelectSqlBuffer.append("FROM" );
				SelectSqlBuffer.append("  FM_CURR_LOCN A" );
				SelectSqlBuffer.append("  , FM_USER_ACCESS_RIGHTS B " );
				SelectSqlBuffer.append("WHERE FILE_NO = ? " );
				SelectSqlBuffer.append("  AND A.CURR_FACILITY_ID = ? " );
				SelectSqlBuffer.append("  AND A.CURR_FS_LOCN_CODE = A.PERM_FS_LOCN_CODE " );
				SelectSqlBuffer.append("  AND A.CURR_FACILITY_ID = B.FACILITY_ID " );
				SelectSqlBuffer.append("  AND B.APPL_USER_ID = ? " );
				SelectSqlBuffer.append("  AND B.FS_LOCN_CODE = A.CURR_FS_LOCN_CODE " );
				SelectSqlBuffer.append(moreCriteria);
				
				if(pstmt != null) pstmt.close();

				pstmt = con.prepareStatement(SelectSqlBuffer.toString());
				pstmt.setString(1,FileNo);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,user_id);
			}
		}
		else if(userSecurity.equals("N"))
		{
			//SelectSqlBuffer.append("Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, CURR_FACILITY_ID, get_patient_line(PATIENT_ID) PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost','E','Other Facility') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , REMARKS, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW where FILE_NO = ? and  CURR_FACILITY_ID = ? and CURR_FS_LOCN_CODE = MR_PAT_FS_LOCN_CODE ");

			SelectSqlBuffer.append("SELECT" );
			SelectSqlBuffer.append("  PATIENT_ID" );
			SelectSqlBuffer.append("  , FILE_NO" );
			SelectSqlBuffer.append("  , CURR_FS_LOCN_CODE" );
			SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
			SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
			SelectSqlBuffer.append("  , Get_patient_line(PATIENT_ID,'"+localeName+"') PLINE" );
			SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
			SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
			SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+curr_faCILITY_ID+"',Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
			SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
			SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
			SelectSqlBuffer.append("  , REMARKS" );
			SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
			SelectSqlBuffer.append("FROM" );
			SelectSqlBuffer.append("  FM_CURR_LOCN " );
			SelectSqlBuffer.append("WHERE FILE_NO = ? " );
			SelectSqlBuffer.append("  AND FACILITY_ID = ? " );
			SelectSqlBuffer.append("  AND CURR_FS_LOCN_CODE = PERM_FS_LOCN_CODE" );

			
			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement(SelectSqlBuffer.toString());
			pstmt.setString(1,FileNo);
			pstmt.setString(2,facility_id);
		}
		rs = pstmt.executeQuery();
		if(rs != null)
		{
			while (rs.next())
			{
				pat_id			= rs.getString("PATIENT_ID");
				file_no			= rs.getString("FILE_NO");
				fs_locn			= rs.getString("CURR_FS_LOCN_CODE");
				currFacility	= rs.getString("CURR_FACILITY_ID");
				pat_line		= rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
				currMrLocn		= rs.getString("CURR_MR_LOCN_YN");
				currLocn		= rs.getString("CURR_FS_LOCN_CODE");
				currDesc		= rs.getString("CURR_FS_LOCN_DESC");
				currStat		= rs.getString("CURR_FILE_STATUS");
				currStatDesc	= rs.getString("FILE_STATUS_DESC"); 
				currIden		= rs.getString("CURR_FS_LOCN_IDENTITY");
				currIdDesc		= rs.getString("LOCN_IDENTITY_DESC");
				sysdate			= rs.getString("SYDATE");
				remark			= rs.getString("REMARKS");
			}
			
			if(fs_locn == null || fs_locn.equals("null")) fs_locn = "";
		}
		if(rs != null)    rs.close();
		if(pstmt != null) pstmt.close();

		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}

		if(remark == null || remark.equals("null")) remark = "";

		if(currStat.equals("I"))
		remark="";
		
		if(file_no.equals(""))
		{
			%>
			<script>
				var errors = getMessage('DOC_NOT_EXIST','FM');
				parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			//	parent.frames[3].document.forms[0].fileno.focus();
			</script>
			<%
		}
		else
		{
			if(rs != null)    rs=null;
			if(pstmt != null) pstmt=null;
			sql1 = "SELECT to_char(A.SENT_DATE_TIME,'dd/mm/rrrr hh:mi AM') sent_date_time FROM FM_TRANSIT_FILE A WHERE A.FACILITY_ID = '"+facility_id+"' AND A.FILE_NO ='"+file_no+"' AND DEST_FS_LOCN_CODE = '"+selLocn+"' ";
			pstmt = con.prepareStatement(sql1);
		//	pstmt.setString(1,facility_id);
		//	pstmt.setString(2,file_no);
		//	pstmt.setString(3,selLocn);
			rs = pstmt.executeQuery();
			String p_error_message = "", p_sent_date_time="";
			sql="";
			while(rs != null && rs.next())
			{
				p_file_no_found++;			
				p_sent_date_time = rs.getString(1);
			}
			if(rs != null)    rs.close();
			if(pstmt != null) pstmt.close();

			if(p_file_no_found ==0)	
			{
				sql = "SELECT A.REQ_FS_LOCN_DESC || ' (' || A.REQ_FACILITY_NAME || ')', TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM'),A.REQ_BY_NAME FROM FM_REQ_HDR_VW A, FM_REQ_DTL B WHERE A.REQ_NO=B.REQ_NO AND A.REQ_FS_LOCN_CODE='"+selLocn+"' AND A.REQ_FACILITY_ID='"+Facility+"' AND B.FILE_NO='"+file_no+"' AND B.ISS_YN='N' AND B.CANCEL_YN='N' ";
				
				pstmt = con.prepareStatement(sql);
		//		pstmt.setString(1,selLocn);
		//		pstmt.setString(2,Facility);
		//		pstmt.setString(3,file_no);
				rs = pstmt.executeQuery();
				
				while(rs != null && rs.next())
				{
					p_file_no_found++;
					//p_error_message =" File no " + FileNo + " already requested by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
					//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_REQUSTED","fm_messages");
					
					message = MessageManager.getMessage(localeName,"FILE_ALREADY_REQUSTED","FM");
					p_error_message = (String) message.get("message");

					p_error_message=p_error_message.replace("$",FileNo);
					p_error_message=p_error_message.replace("#",rs.getString(1));
					p_error_message=p_error_message.replace("~",rs.getString(2));
					p_error_message=p_error_message.replace("%",rs.getString(3));
				}
			}
			else
			{
				//p_error_message =" File no " + FileNo + " is already been issued on " + p_sent_date_time  ;
				//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_ISSUED","fm_messages");

				message = MessageManager.getMessage(localeName,"FILE_ALREADY_ISSUED","FM");
				p_error_message = (String) message.get("message");


				p_error_message=p_error_message.replace("$",FileNo);
				p_error_message=p_error_message.replace("#",p_sent_date_time);
			}
			%>
			<script>
				if('<%=fs_locn%>' == "")
				{
					var errors = getMessage('FILES_NO_STORAGE_LOCATION','FM');
					alert(errors);
					parent.frames[3].document.forms[0].fileno.focus();
				}
				var Obj = parent.frames[3].document.forms[0]
				var reqfacid = Obj.facility.options[Obj.facility.selectedIndex].value;
				var reqlocn = Obj.Req_locn_code.value;

				if(reqfacid == '<%=facility_id%>' && reqlocn == '<%=currLocn%>')
				{
					var errors = getMessage('REQUEST_EQUALS_CURRENT','FM');
					alert(errors);						
					parent.frames[3].document.forms[0].patientid.value = "";
					parent.frames[3].document.forms[0].patientid.onblur(); 
					parent.frames[3].document.forms[0].currfilelocn.value = "";
					parent.frames[3].document.forms[0].filestat.value = "";
					parent.frames[3].document.forms[0].remarks.value = "";
					parent.frames[3].document.forms[0].fileno.focus();
				}
				else if(reqfacid == '<%=facility_id%>' && '<%=issueLocn%>' != '<%=currLocn%>')
				{
					var errors = getMessage('FILE_IS_NOT_AT_ISS_LOCN','FM');
					alert(errors);						
					parent.frames[3].document.forms[0].patientid.value = "";
					parent.frames[3].document.forms[0].patientid.onblur(); 
					parent.frames[3].document.forms[0].currfilelocn.value = "";
					parent.frames[3].document.forms[0].filestat.value = "";
					parent.frames[3].document.forms[0].remarks.value = "";
					parent.frames[3].document.forms[0].fileno.focus();
				}
				else if('<%=currStat%>' == "O")
				{
					var errors = getMessage('FILE_STATUS_OUTSIDE','FM');
					alert(errors);		
					parent.frames[3].document.forms[0].patientid.value = "";
					parent.frames[3].document.forms[0].patientid.onblur(); 
					parent.frames[3].document.forms[0].currfilelocn.value = "";
					parent.frames[3].document.forms[0].filestat.value = "";
					parent.frames[3].document.forms[0].remarks.value = "";
					parent.frames[3].document.forms[0].fileno.focus();
				}
				else if('<%=currStat%>' == "A")
				{
					var errors = getMessage('FILE_STATUS_ARCHIVE','FM');
					alert(errors);		
					parent.frames[3].document.forms[0].patientid.value = "";
					parent.frames[3].document.forms[0].patientid.onblur(); 
					parent.frames[3].document.forms[0].currfilelocn.value = "";
					parent.frames[3].document.forms[0].filestat.value = "";
					parent.frames[3].document.forms[0].remarks.value = "";
					parent.frames[3].document.forms[0].fileno.focus();
				}
				else if('<%=currStat%>' == "L")
				{
					var errors = getMessage('FILE_STATUS_LOST','FM');
					alert(errors);						
					parent.frames[3].document.forms[0].patientid.value = "";
					parent.frames[3].document.forms[0].patientid.onblur(); 
					parent.frames[3].document.forms[0].currfilelocn.value = "";
					parent.frames[3].document.forms[0].filestat.value = "";
					parent.frames[3].document.forms[0].remarks.value = "";
					parent.frames[3].document.forms[0].fileno.focus();
				}
				else if('<%=currStat%>' == "T" || '<%=currStat%>' == "E" )
				{

					if 	(parseInt('<%=p_file_no_found%>') > 0 )
					{
						alert(getMessage('FILE_ALREADY_REQUESTED','FM')+"<%=p_error_message%>");
						var p_file_no_length = parent.frames[3].document.forms[0].p_file_no_length.value ;
						parent.frames[3].document.forms[0].patientid.value='';
						parent.frames[3].document.forms[0].patientid.onblur(); 
						parent.frames[3].document.forms[0].fileno.value='';
						parent.frames[3].document.getElementById('fileid').innerHTML="<input type=text name=fileno id=fileno size=20 value='' maxlength='"+p_file_no_length+"'>";
						parent.frames[3].document.forms[0].currfilelocn.value='';
						parent.frames[3].document.forms[0].filestat.value='';
						parent.frames[3].document.forms[0].remarks.value='';
						parent.frames[3].document.forms[0].fileno.focus();
					}
					else
						{
						var errors = getMessage('FILE_STATUS_TRANSIT','FM');
						alert(errors);						
						parent.frames[3].document.forms[0].fileno.value = "";
						parent.frames[3].document.forms[0].patientid.value = "";
						parent.frames[3].document.forms[0].patientid.onblur(); 
						parent.frames[3].document.forms[0].currfilelocn.value = "";
						parent.frames[3].document.forms[0].filestat.value = "";
						parent.frames[3].document.forms[0].remarks.value = "";
						parent.frames[3].document.forms[0].fileno.focus();
						}
				}
				else
				{
		
				if 	(parseInt('<%=p_file_no_found%>') > 0 )
				{
					alert(getMessage('FILE_ALREADY_REQUESTED','FM')+"\n"+  "<%=p_error_message%>");
					var p_file_no_length = parent.frames[3].document.forms[0].p_file_no_length.value ;
					parent.frames[3].document.forms[0].patientid.value='';
					parent.frames[3].document.forms[0].patientid.onblur(); 
					parent.frames[3].document.forms[0].fileno.value='';
					parent.frames[3].document.getElementById('fileid').innerHTML="<input type=text name=fileno id=fileno size=20 value='' maxlength='"+p_file_no_length+"'>";
					parent.frames[3].document.forms[0].currfilelocn.value='';
					parent.frames[3].document.forms[0].filestat.value='';
					parent.frames[3].document.forms[0].remarks.value='';
					parent.frames[3].document.forms[0].fileno.focus();
				}

				if 	(parseInt('<%=p_file_no_found%>') == 0 )
				{
					
				parent.frames[3].document.forms[0].patientid.value = '<%=pat_id%>';
				parent.frames[3].document.forms[0].currfilelocn.value = "<%=currDesc%> (<%=currIdDesc%>)";
				
				parent.frames[3].document.forms[0].filestat.value = '<%=currStatDesc%>';
				parent.frames[3].document.forms[0].remarks.value = '<%=remark%>';
				parent.frames[3].document.forms[0].Req_on.value = '<%=sysdate%>';
				parent.frames[3].document.forms[0].Curr_facility_id.value = '<%=currFacility%>';
				parent.frames[3].document.forms[0].Curr_locn_code.value = "<%=currLocn%>";
				parent.frames[3].document.forms[0].Curr_locn_desc.value = "<%=currDesc%>";
				parent.frames[3].document.forms[0].Curr_locn_iden.value = "<%=currIden%>";
				parent.frames[3].document.forms[0].Curr_locn_mr_locn.value = "<%=currMrLocn%>";			
				parent.frames[3].document.forms[0].Pat_line.value = "<%=pat_line%>";
				parent.frames[3].document.getElementById('patline').innerText = "<%=pat_line%>";
				parent.frames[3].document.forms[0].patientid.disabled = true;
		//		parent.frames[3].document.forms[0].fileno.disabled = true;
				parent.frames[3].document.forms[0].remarks.focus();
		//		parent.frames[3].AddDoc();
				}
				}
			</script>
<%
		}
if(rs!=null) rs.close();
if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{ out.println("In Exception :"+e.toString()); 
e.printStackTrace();}
finally
{	
	ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>
</html>

