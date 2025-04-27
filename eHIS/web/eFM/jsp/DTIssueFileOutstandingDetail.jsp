<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import ="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="FMIssueFilesCart" scope="session" class="webbeans.eFM.FMFilesIssueCart"/>

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
	<script src='../../eFM/js/FMIssueFilesDoc.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
		Connection conn = null;
		java.sql.Statement stmt=null;
		PreparedStatement pstmt	 = null;
		PreparedStatement pstmt1=null;		
		ResultSet rs=null;
		ResultSet rs1=null;
		String resLocnIdentities = request.getParameter("resLocnIdentities");
		String ReqOn			= request.getParameter("ReqOn");
		String Reqno			= request.getParameter("Reqno");
		String Reqfacilityid	= request.getParameter("Reqfacilityid");
		String Reqfacilityname	= request.getParameter("Reqfacilityname");
		String Reqfslocncode	= request.getParameter("Reqfslocncode");
		String Reqfslocndesc	= request.getParameter("Reqfslocndesc");
		String Reqfslocnidentity= request.getParameter("Reqfslocnidentity");
		String Reqlocnismrlocnyn= request.getParameter("Reqlocnismrlocnyn");
		String Reqby			= request.getParameter("Reqby");
		String Reqbyname		= request.getParameter("Reqbyname");
		String Narrationcode	= request.getParameter("Narrationcode");
		String Narrationdesc	= request.getParameter("Narrationdesc");
		String NoOfdays			= request.getParameter("NoOfdays");	
		String issueLocn		= request.getParameter("issueLocn");
		String s_file_no		= request.getParameter("s_file_no");
		String s_file_type		= request.getParameter("s_file_type");
		String s_volume_no		= request.getParameter("s_volume_no");
		String facility_id = (String) session.getValue("facility_id");	
		
		String sql1 = "";
		String classValue = "";
		String classVal = "mediumaquamarine";
		String checkValue = "checked";
		String checkStatus = "";
		String chkVal = "Y";
		String Remarks = "Remarks";
		String req_remarks = "";
		String volume_no	=	"";
		String file_type	=	"";
		String file_type_appl_yn	=	"N";
		String doc_folder_id = "";
		String doc_folder_name = "";
		String doc_type_name = "";
		String doc_type = "";

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();

		int i=1;
		int temp = 1;
		int Other_rec_count = 0;
		boolean file_exist = false,p_same_file_no_exist=false;
try
{
		conn = ConnectionManager.getConnection(request);
		s_file_type	=	((s_file_type == null) || (s_file_type.equals("null"))) ? "" : s_file_type;
		s_volume_no	=	((s_volume_no == null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;

		if(resLocnIdentities == null || resLocnIdentities.equals("null"))
			resLocnIdentities = "N";

	//	String InvalidFiles = "&nbsp;";

		stmt = conn.createStatement();
		rs	 = stmt.executeQuery("SELECT file_type_appl_yn FROM mp_param ");
		if ((rs!=null) &&(rs.next()))
	{
			file_type_appl_yn = rs.getString("file_type_appl_yn");
	}
	if(rs!=null) rs.close();

		if ((file_type_appl_yn==null) || (file_type_appl_yn.equals("")) || (file_type_appl_yn.equals("null")))
			file_type_appl_yn = "N";
%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='IssueOutstandingDetail' id='IssueOutstandingDetail' method='post' target='messageFrame' action='../../eFM/jsp/FMIssueFilesUpdateBean.jsp'>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr><td colspan='8' class='label'><b><fmt:message key="eFM.DocumentsRequestedin.label" bundle="${fm_labels}"/> <%=Reqno%></b></td></tr>
	
	<th width='41%'><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></th>
	<th width='5%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>
	<th width='12%'><fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/></th>
	<th width='5%'><fmt:message key="eFM.RequestRemarks.label" bundle="${fm_labels}"/></th>
	<th width='22%'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></th>
	<th width='5%'><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></th>
	<th width='10%'><fmt:message key="Common.Issue.label" bundle="${common_labels}"/>?</th>
<%

		SelectSqlBuffer.append( "Select A.FILE_NO, D.CURR_FILE_STATUS, DECODE(D.CURR_FILE_STATUS,'A','Archive','T','In  Transit','I','Inside','O','Outside','L','Lost','E','Other Facility', 'R', 'Returned') FILE_STATUS, A.CURR_FS_LOCN_CODE, B.SHORT_DESC CURR_FS_LOCN_DESC, A.REQ_TO_FS_LOCN_CODE, B.LOCN_IDENTITY, DECODE(B.LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDEN_DESC, NVL(B.MR_LOCN_YN,'N') CURR_MR_LOCN_YN, A.PATIENT_ID, get_patient_line(A.PATIENT_ID,'"+localeName+"') PLINE, D.REMARKS, ltrim(rtrim(A.REMARKS)) REQ_REMARKS,TO_CHAR(D.ISS_DATE_TIME,'DD/MM/YYYY HH:MI AM')ISS_DATE_TIME, A.VOLUME_NO, a.file_type_code, e.short_desc file_type,d.doc_folder_id,d.doc_type_code,f.DOC_FOLDER_NAME,g.DOC_TYPE_NAME,(CASE WHEN f.PATIENT_PERIOD_SPECIFIC='D' THEN ' ,' || TO_CHAR(f.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(f.to_period,'dd/mm/rrrr ')  ELSE ' ' || get_patient_line(f.patient_id) END)doc_type,H.encounter_id from FM_REQ_DTL A,  FM_STORAGE_LOCN B, FM_CURR_LOCN D, mr_file_type e,fm_doc_folder f, fm_doc_type g, FM_ENCOUNTER_DOC_TYPE_LINK H Where A.REQ_NO = '"+Reqno+"' AND A.ISS_YN = 'N' AND A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+issueLocn+"' AND A.REQ_TO_FACILITY_ID = B.FACILITY_ID AND A.CURR_FS_LOCN_CODE = B.FS_LOCN_CODE  AND A.FILE_NO = D.FILE_NO (+) AND A.VOLUME_NO = D.VOLUME_NO  AND A.CURR_FACILITY_ID = D.CURR_FACILITY_ID (+) AND NVL(A.CANCEL_YN,'N')='N' AND d.file_type_code = e.file_type_code (+) AND d.facility_id = e.facility_id(+) AND d.doc_type_code = g.doc_type_code(+) and d.doc_folder_id = f.doc_folder_id AND d.facility_id = f.facility_id AND a.file_no=H.file_no and a.REQ_TO_FACILITY_ID = H.facility_id ");
		
		if (!(s_file_no.equals("null") || s_file_no.equals("") ))
		SelectSqlBuffer.append("AND A.FILE_NO = '"+s_file_no+"' ");

		if (!(s_volume_no.equals("null") || s_volume_no.equals("") ))
		SelectSqlBuffer.append("AND A.VOLUME_NO = '"+s_volume_no+"' ");
		
		SelectSqlBuffer.append(" order by A.FILE_NO");		
		
		pstmt = conn.prepareStatement(SelectSqlBuffer.toString());
		rs	  = pstmt.executeQuery();
		if(rs != null)
		{
			while ( rs.next() )
			{
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

					String cuurIden = rs.getString("LOCN_IDENTITY");
					if(cuurIden == null || cuurIden.equals("null")){
					cuurIden="";}
					String currStatus = rs.getString("CURR_FILE_STATUS");
					if(currStatus == null || currStatus.equals("null")){
					currStatus="";}					
					String currLocn = rs.getString("CURR_FS_LOCN_CODE");
					if(currLocn == null || currLocn.equals("null")){
					currLocn="";}
					String permLocn = rs.getString("REQ_TO_FS_LOCN_CODE");
					if(permLocn == null || permLocn.equals("null")){
					permLocn="";}
					req_remarks		= rs.getString("REQ_REMARKS");
					if(req_remarks == null || req_remarks.equals("null")){
					req_remarks="";
					}
					String encounter_id = rs.getString("encounter_id");
					if(encounter_id == null || encounter_id.equals("null")){
					encounter_id="";}
					volume_no	=	rs.getString("volume_no");
					file_type	=	rs.getString("file_type");

					if ((file_type == null) || (file_type.equals("null")))
						file_type	=	"&nbsp;";
					else file_type = file_type + " / ";
					if ((volume_no == null) || (volume_no.equals("null")))
						volume_no	=	"&nbsp;";
					doc_folder_id	=	rs.getString("doc_folder_id");

					if ((doc_folder_id == null) || (doc_folder_id.equals("null")))
						doc_folder_id	=	"&nbsp;";
					doc_folder_name	=	rs.getString("doc_folder_name");
					if ((doc_folder_name == null) || (doc_folder_name.equals("null")))
						doc_folder_name	=	"&nbsp;";
					doc_type_name	=	rs.getString("doc_type_name");
					if ((doc_type_name == null) || (doc_type_name.equals("null")))
						doc_type_name	=	"&nbsp;";
					doc_type	=	rs.getString("doc_type");
					if ((doc_type == null) || (doc_type.equals("null")))
						doc_type	=	"&nbsp;";
				
				if(currStatus.equals("I") && currLocn.equals(permLocn))
				{
						temp = 1;
						checkValue = "checked";
						checkStatus = "";
						chkVal = "Y";
						Remarks = "Remarks";
				}
				else
				{
						temp = 1;
						checkValue = "unchecked";
						checkStatus = "disabled";
						chkVal = "N";
				}
				
				file_exist = FMIssueFilesCart.FileNoExist(Reqno,rs.getString("FILE_NO"), s_volume_no);
				if(file_exist)
				{
					checkValue = "checked";
					checkStatus = "disabled";
					chkVal = "Y";
				}

				if (!file_exist)
				{
					p_same_file_no_exist = FMIssueFilesCart.SameFileNoExist(rs.getString("FILE_NO"));
					
					if (p_same_file_no_exist)
					{
						checkValue = "";
						checkStatus = "disabled";
						chkVal = "N";
					}
				}
				String FileNoValue = rs.getString("file_no");
				if(FileNoValue == null || FileNoValue.equals("null")) FileNoValue = "";

				sql1 = "select count(*) from fm_encounter_volume_link a,pr_encounter b where a.facility_id= ? and a.file_no= ? and b.facility_id=a.facility_id and  b.encounter_id=a.encounter_id and volume_no= ? and closed_date is null and b.mlc_yn='Y'";
						
						pstmt1 = conn.prepareStatement(sql1);
						pstmt1.setString(1,facility_id);
						pstmt1.setString(2,FileNoValue);
						pstmt1.setString(3,volume_no);
						rs1  = pstmt1.executeQuery();
				if ((rs1!=null) &&(rs1.next()))
				{					
					Other_rec_count = rs1.getInt(1);					
				}
				if(rs1!=null) rs1.close();
				if(pstmt1!=null) pstmt1.close();
%>
				<tr>
<%
					String tempstr = rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
					StringTokenizer st = new StringTokenizer(tempstr, ",");
					st.nextToken();
					st.nextToken();
					st.nextToken();
					//String patient_id = st.nextToken();
				if (file_type_appl_yn.equals("N"))	
				{
%>
				   <td class=<%=classValue%>><font size='1'><b><%=doc_folder_id%> </b></font> <br>&nbsp;&nbsp; <font size='1'><%=doc_folder_name%><%=doc_type%> </font></td>
				   <td class="<%=classValue%>" ><font size='1'><%=doc_type_name%>,<BR><A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="showEncounter('<%=encounter_id%>','<%=rs.getString("PATIENT_ID")%>','<%=rs.getString("FILE_NO")%>')"><%=rs.getString("PATIENT_ID")%>&nbsp;</A></font></td>
<%
				}else if (file_type_appl_yn.equals("Y"))	
				{
%>
				   <td class=<%=classValue%>><font size='1'><b><%=doc_folder_id%> </b></font><br>&nbsp;<font size='1'><%=doc_folder_name%> <%=doc_type%> </font></td>
				   <td class="<%=classValue%>" ><font size='1'><%=doc_type_name%>,<BR><A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="showEncounter('<%=encounter_id%>','<%=rs.getString("PATIENT_ID")%>','<%=rs.getString("FILE_NO")%>')"><%=rs.getString("PATIENT_ID")%>&nbsp;</A></font></td>

<%
				}
%> 
				<td class=<%=classValue%>><font size='1'> <%=rs.getString("FILE_STATUS")%></font></td>
					<td class=<%=classValue%>><font size='1'>
<%
					if (req_remarks==null)
						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>");
				   else
				{
%>
				   <a href='javascript:GetShowRemarks("ReqComm<%=i%>","<%=req_remarks%>","R")'>Remarks</a></font></td>
<%
				}
%>
<%
				if ((rs.getString("ISS_DATE_TIME")==null) || (rs.getString("ISS_DATE_TIME").equals("")))
				{
%>
				   <td class="<%=classValue%>"><font size='1'> <%=rs.getString("CURR_FS_LOCN_DESC")%><br>&nbsp; (<%=rs.getString("LOCN_IDEN_DESC")%>)</font></td>
<%				}
				else
				{
%>
				   <td class="<%=classValue%>" onMouseOver="displayToolTipDataChange('DATACHANGE','Document Issued on<br> <%=rs.getString("ISS_DATE_TIME")%>');" onMouseOut="disasbleToolTipDataChange('DATACHANGE');"><font size='1'> <%=rs.getString("CURR_FS_LOCN_DESC")%><br>&nbsp; (<%=rs.getString("LOCN_IDEN_DESC")%>)</font></td>
				<%
				}
			    %>
				   <td id='remarks<%=i%>' class=<%=classValue%> ><font size='1'>
<%
				if(checkStatus.equals("disabled"))
				{
					out.println("Remarks</font></td>");
				}
				else
				{
				   String RemarksValue  = rs.getString("REMARKS");

%>
				   <a href='javascript:GetShowRemarks("txtComm<%=i%>","<%=RemarksValue%>","I")'>Remarks</a>
				   </font></td>
<%
				}

// cyan, magenta, sandybrown, mediumvioletred, mediumaquamarine, orchid,
// mediumorchid,  violet, yellowgreen, darkseagreen, gold, lightseagreen
// mediumaquamarine, gold, lightseagreen, sandybrown

				if(temp == 2)
				{
					out.println("<td align='center' id='chbox"+i+"' class='"+classValue+"'>");
					
				}
				else if(file_exist)
				{
					out.println("<td align='center' style='background-color:"+classVal+"'>");
					
				}
				else
				{						
					out.println("<td align='center' id='chbox"+i+"' class='"+classValue+"'>");					
				}
%>
					<input type='checkbox' name="chk<%=i%>" id="chk<%=i%>" <%=checkValue%> <%=checkStatus%> value='<%=chkVal%>' onClick="setVal(this,<%=i%>);">
<%					
					if(Other_rec_count > 0)
					{
						out.println("&nbsp;<img src='../../eFM/images/stop.gif' align='center'></img>");
					}
%>	
	</td>
<%
					if(checkValue.equals("checked"))
					{
%>						<input type='hidden' name="select<%=i%>" id="select<%=i%>" value="Y">
<%					}
					else
					{
%>
						<input type='hidden' name="select<%=i%>" id="select<%=i%>" value="N">
<%					}
%>				</tr>
			<input type="hidden" name='fileno<%=i%>' id='fileno<%=i%>' value='<%=rs.getString("FILE_NO")%>'>
			<input type="hidden" name='file_type<%=i%>' id='file_type<%=i%>' value='<%=rs.getString("FILE_TYPE_CODE")%>'>
			<input type="hidden" name='volume_no<%=i%>' id='volume_no<%=i%>' value='<%=rs.getString("VOLUME_NO")%>'>
			<input type="hidden" name='patient<%=i%>' id='patient<%=i%>' value='<%=rs.getString("PATIENT_ID")%>'>
			<input type="hidden" name='pline<%=i%>' id='pline<%=i%>' value='<%=rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6)%>'>
			<input type="hidden" name='filestatus<%=i%>' id='filestatus<%=i%>' value='<%=rs.getString("FILE_STATUS")%>'>
			<input type="hidden" name='currlocn<%=i%>' id='currlocn<%=i%>' value='<%=rs.getString("CURR_FS_LOCN_CODE")%>'>
			<input type="hidden" name='currlocndesc<%=i%>' id='currlocndesc<%=i%>' value='<%=rs.getString("CURR_FS_LOCN_DESC")%>'>
			<input type="hidden" name='currlocniden<%=i%>' id='currlocniden<%=i%>' value='<%=rs.getString("LOCN_IDENTITY")%>'>
			<input type="hidden" name='currmrlocnyn<%=i%>' id='currmrlocnyn<%=i%>' value='<%=rs.getString("CURR_MR_LOCN_YN")%>'>
 			<input type="hidden" name='currfacility<%=i%>' id='currfacility<%=i%>' value='<%=facility_id%>'>
			<input type="hidden" name='txtComm<%=i%>' id='txtComm<%=i%>'>
			<input type="hidden" name='ReqComm<%=i%>' id='ReqComm<%=i%>'>
<%			i++;
			}
		}
	if(rs!=null)	rs.close();
	if(rs1!=null)	rs1.close();	
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();		
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
</table>
<input type='hidden' name='ManualReq' id='ManualReq' value='N'>
<input type='hidden' name='count' id='count' value='<%=(i-1)%>'>
<input type='hidden' name='iss_count' id='iss_count' value=''>
<input type='hidden' name='Req_on' id='Req_on' value='<%=ReqOn%>'>
<input type='hidden' name='Req_no' id='Req_no' value='<%=Reqno%>'>
<input type='hidden' name='Req_fac_id' id='Req_fac_id' value='<%=Reqfacilityid%>'>
<input type='hidden' name='Req_fac_name' id='Req_fac_name' value='<%=Reqfacilityname%>'>
<input type='hidden' name='Req_locn_code' id='Req_locn_code' value='<%=Reqfslocncode%>'>
<input type='hidden' name='Req_locn_desc' id='Req_locn_desc' value='<%=Reqfslocndesc%>'>
<input type='hidden' name='Req_locn_identity' id='Req_locn_identity' value='<%=Reqfslocnidentity%>'>
<input type='hidden' name='Req_locn_mrlocn_yn' id='Req_locn_mrlocn_yn' value='<%=Reqlocnismrlocnyn%>'>
<input type='hidden' name='Req_by' id='Req_by' value='<%=Reqby%>'>
<input type='hidden' name='Req_by_name' id='Req_by_name' value='<%=Reqbyname%>'>
<input type='hidden' name='Narration_code' id='Narration_code' value='<%=Narrationcode%>'>
<input type='hidden' name='Narration_desc' id='Narration_desc' value='<%=Narrationdesc%>'>
<input type='hidden' name='No_Of_Days' id='No_Of_Days' value='<%=NoOfdays%>'>
<input type='hidden' name='Issue_user_id' id='Issue_user_id' value=''>
<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
	<tr><td width="100%" id="t"></td></tr>
</table>
</div>	

</form>
</body>
</html>


