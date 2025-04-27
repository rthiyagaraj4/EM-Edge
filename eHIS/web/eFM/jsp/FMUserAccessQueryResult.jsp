<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>

</head>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<%
	String whereClause = request.getParameter("whereclause");
	Connection conn = ConnectionManager.getConnection(request);
	String sql ="";
	String facilityid 			= (String) session.getValue("facility_id");
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql="";
		String cd = request.getParameter("APPL_USER_ID");
		String cd1= request.getParameter("APPL_USER_NAME");
		String fs_locn_code = request.getParameter("FS_LOCN_CODE");
		String fs_locn_desc = request.getParameter("FS_LOCN_DESC");
		String locn_identity = request.getParameter("LOCN_IDENTITY_DESC");
		String access_rights = request.getParameter("ACCESS_RIGHTS");
		
	int andCheck = 0;

	
	if ( !(cd == null || cd.equals("")) )
		{
			cd=cd.toUpperCase();
			sql = "where APPL_USER_ID like '"+cd+"%' and facility_id = '"+facilityid+"'";
			andCheck = 1;
		}

	if ( !(cd1 == null || cd1.equals("")) )
		{
			cd1=cd1.toUpperCase();

			if ( andCheck == 1 )
			{	sql = sql + " and ";
				sql = sql + "upper(APPL_USER_NAME) like '"+cd1+"%' " ; //Modified by S.Sathish for IN021089 on Friday, April 30, 2010
			}
			else
			{
				sql = "where upper(APPL_USER_NAME) like '"+cd1+"%' and facility_id = '"+facilityid+"'";
				andCheck = 1;
			}
		}
	
	if ( !(fs_locn_code == null || fs_locn_code.equals("")) )
		{
			fs_locn_code=fs_locn_code.toUpperCase();

			if ( andCheck == 1 )
			{	sql = sql + " and ";
				sql = sql + "upper(fs_locn_code) like '"+fs_locn_code+"%' " ;
			}
			else
			{
				sql = "where upper(fs_locn_code) like '"+fs_locn_code+"%' and facility_id = '"+facilityid+"'";
				andCheck = 1;
			}
		}
	
	if ( !(fs_locn_desc == null || fs_locn_desc.equals("")) )
		{
			fs_locn_desc=fs_locn_desc.toUpperCase();

			if ( andCheck == 1 )
			{	sql = sql + " and ";
				sql = sql + "upper(fs_locn_desc) like '"+fs_locn_desc+"%' " ;
			}
			else
			{
				sql = "where upper(fs_locn_desc) like '"+fs_locn_desc+"%' and facility_id = '"+facilityid+"'";
				andCheck = 1;
			}
		}

		if ( !(locn_identity == null || locn_identity.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql = sql + " and ";
					sql = sql + "nvl(LOCN_IDENTITY,'X') in  decode('"+locn_identity+"','D','D','C','C','N','N','T','T','E','E','Y','Y',nvl(LOCN_IDENTITY,'X'))" ;
				}
				else
				{
					sql = "where nvl(LOCN_IDENTITY,'X') in  decode('"+locn_identity+"','D','D','C','C','N','N','T','T','E','E','Y','Y',nvl(LOCN_IDENTITY,'X')) and facility_id = '"+facilityid+"'" ;
					andCheck = 1;
				}
			}
//added for access right criteria
	if ( !(access_rights == null || access_rights.equals("") || access_rights.equals("A")) )
	{
		if ( andCheck == 1 )
		{	sql = sql + " and ";
		}
		else{
			andCheck = 1;
		}
		
		if(access_rights.equals("B")){
			sql = sql + " assign_fs_locn='Y' " ;
		}
		else if(access_rights.equals("C")){
			sql = sql + " change_fs_locn='Y' " ;
		}
		else if(access_rights.equals("D")){
			sql = sql + " change_return_date_yn='Y' " ;
		}
		else if(access_rights.equals("E")){
			sql = sql + " deficiency_check_yn='Y' " ;
		}
		else if(access_rights.equals("F")){
			sql = sql + " change_file_status_yn='Y' " ;
		}
		else if(access_rights.equals("G")){
			sql = sql + " track_out_to_opd='Y' " ;
		}
		else if(access_rights.equals("H")){
			sql = sql + " RECEIVE_FILE_YN='Y' " ;
		}
		else if(access_rights.equals("R")){
			sql = sql + " RETURN_FILE_YN='Y' " ;
		}
		else if(access_rights.equals("I")){
			sql = sql + " CONFIRM_RECEIPT_FILE_YN='Y' " ;
		}
		else if(access_rights.equals("J")){
			sql = sql + " TRANSFER_FILE_YN='Y' " ;
		}
		else if(access_rights.equals("K")){
			sql = sql + " req_yn='Y' " ;
		}
		else if(access_rights.equals("L")){
			sql = sql + " req_across_facilities_yn='Y' " ;
		}
		else if(access_rights.equals("M")){
			sql = sql + " iss_yn='Y' " ;
		}
		else if(access_rights.equals("N")){
			sql = sql + " iss_across_facilities_yn='Y' " ;
		}
		else if(access_rights.equals("O")){
			sql = sql + " manual_request_yn='Y' " ;
		}
		else if(access_rights.equals("P")){
			sql = sql + " cancel_request_yn='Y' " ;
		}
		else if(access_rights.equals("Q")){
			sql = sql + " CREATE_FILE_VOLUME_YN='Y' " ;
		}
		else if(access_rights.equals("S")){
			sql = sql + " track_out_to_ipw='Y'  " ;
		}
	}
//addition for access rights over		
	}

//	appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql=sql+" order by ";

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql=sql+ord[i];
		else
			sql=sql+ord[i]+",";
		}
		//}
	} //end of where clause IF
	else {
		sql = whereClause;

	}

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;
//int maxRecord = 0;

try{

if (sql==null) 
{
	sql=" order by 1";
}

stmt = conn.createStatement();
/*String strsql1="select count(*) as total from FM_USER_ACCESS_RIGHTS_VW "+sql;

rs = stmt.executeQuery(strsql1);
if(rs.next())
	maxRecord = rs.getInt(1);

	   if (maxRecord== 0)
	  {*/
	  %>
	  	<script>
	//	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
	//	parent.frames[1]. location.href ="../../eFM/jsp/FMUserAccessQueryCriteria.jsp" ;
		</script>
	 <%
	 // }
		if (rs!=null) rs.close();
String strsql2="select * from FM_USER_ACCESS_RIGHTS_VW "+sql;
rs = stmt.executeQuery(strsql2);
%>



<%
	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue = "" ;
	  int cnt=0;
while ( i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<p>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eFM/jsp/FMUserAccessQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			%>
			<td align ='right' id='next' style='visibility:hidden'>
			<%
	//	if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eFM/jsp/FMUserAccessQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		%>
		</td>
		</tr>
		</table>
		<br>
		<br>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>

		<th class='columnheader' width='10%'><font size=1><fmt:message key="Common.user.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='12%'><font size=1><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='10%'><font size=1><fmt:message key="eFM.AssignFSLocation.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='10%'><font size=1><fmt:message key="eFM.ChangeFSLocation.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='10%'><font size=1><fmt:message key="eFM.ChangeFileReturnDate.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='10%'><font size=1><fmt:message key="eFM.MonitorFileDeficiency.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='5%'><font size=1><fmt:message key="eFM.ChangeFileStatus.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='5%'><font size=1><fmt:message key="eFM.TrackoutfilestoOPD.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='5%'><font size=1><fmt:message key="eFM.TrackoutfilestoIPW.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='5%'><font size=1><fmt:message key="eFM.RequestFileWithinFacility.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='10%'><font size=1><fmt:message key="eFM.RequestFileFromOtherFacilities.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='10%'><font size=1><fmt:message key="eFM.ManualRequestYN.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='10%'><font size=1><fmt:message key="Common.CancelRequest.label" bundle="${common_labels}"/> </th>
		<th class='columnheader' width='5%'><font size=1><fmt:message key="eFM.IssueFileWithinFacility.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='10%'><font size=1><fmt:message key="eFM.IssueFileToOtherFacilities.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='10%'><font size=1><fmt:message key="eFM.CreateFileVolume.label" bundle="${fm_labels}"/> </th>
		<th class='columnheader' width='10%'><font size=1><fmt:message key="eFM.TransferFile.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='5%'><font size=1><fmt:message key="eFM.ConfirmFileReceipt.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='5%'><font size=1><fmt:message key="eFM.ReceiveFileatMRD.label" bundle="${fm_labels}"/></th>
		<th class='columnheader' width='5%'><font size=1><fmt:message key="eFM.ReturnFileatMRD.label" bundle="${fm_labels}"/></th>
<%	}
	
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
	String code = rs.getString("APPL_USER_ID");
	String fs_locn_code = rs.getString("FS_LOCN_CODE");
	String fs_locn_desc = rs.getString("FS_LOCN_SHORT_DESC");
	String locn_identity = rs.getString("LOCN_IDENTITY_DESC");
	if (locn_identity==null) locn_identity="";
	String assign_fs_locn = rs.getString("ASSIGN_FS_LOCN");
	if(assign_fs_locn==null || assign_fs_locn.equals("null") || assign_fs_locn.equals(""))
	assign_fs_locn="";
	String change_fs_locn = rs.getString("CHANGE_FS_LOCN");
	if(change_fs_locn==null || change_fs_locn.equals("null") || change_fs_locn.equals(""))
	change_fs_locn="";
	String change_return_date_yn = rs.getString("CHANGE_RETURN_DATE_YN");
	if(change_return_date_yn==null || change_return_date_yn.equals("null") || change_return_date_yn.equals(""))
	change_return_date_yn="";
	String deficiency_check_yn = rs.getString("DEFICIENCY_CHECK_YN");
	if(deficiency_check_yn==null || deficiency_check_yn.equals("null") || deficiency_check_yn.equals(""))
	deficiency_check_yn="";
	String file_lost_found_yn = rs.getString("Change_file_status_yn");
	if(file_lost_found_yn==null || file_lost_found_yn.equals("null") || file_lost_found_yn.equals(""))
	file_lost_found_yn="";
	String track_out_to_opd_yn = rs.getString("TRACK_OUT_TO_OPD");
	if(track_out_to_opd_yn==null || track_out_to_opd_yn.equals("null") || track_out_to_opd_yn.equals(""))
	track_out_to_opd_yn="";
	String track_out_to_ipw_yn = rs.getString("TRACK_OUT_TO_IPW");
	if(track_out_to_ipw_yn==null || track_out_to_ipw_yn.equals("null") || track_out_to_ipw_yn.equals(""))
	track_out_to_ipw_yn="";
	String req_yn = rs.getString("REQ_YN");
	if(req_yn==null || req_yn.equals("null") || req_yn.equals(""))
	req_yn="";
	String req_across_facilities_yn = rs.getString("REQ_ACROSS_FACILITIES_YN");
	if(req_across_facilities_yn==null || req_across_facilities_yn.equals("null") || req_across_facilities_yn.equals(""))
	req_across_facilities_yn="";
	String manual_request_yn = rs.getString("MANUAL_REQUEST_YN");
	if(manual_request_yn==null || manual_request_yn.equals("null") || manual_request_yn.equals(""))
	manual_request_yn="";
	String cancel_request_yn = rs.getString("CANCEL_REQUEST_YN");
	if(cancel_request_yn==null || cancel_request_yn.equals("null") || cancel_request_yn.equals(""))
	cancel_request_yn="";
	String iss_yn = rs.getString("ISS_YN");
	if(iss_yn==null || iss_yn.equals("null") || iss_yn.equals(""))
	iss_yn="";

	String iss_across_facilities_yn = rs.getString("ISS_ACROSS_FACILITIES_YN");
	if(iss_across_facilities_yn==null || iss_across_facilities_yn.equals("null") || iss_across_facilities_yn.equals(""))
	iss_across_facilities_yn="";

	String CREATE_FILE_VOLUME_YN = rs.getString("CREATE_FILE_VOLUME_YN");
	if(CREATE_FILE_VOLUME_YN==null || CREATE_FILE_VOLUME_YN.equals("null") || CREATE_FILE_VOLUME_YN.equals(""))
	CREATE_FILE_VOLUME_YN="";

	String transfer_file_yn = rs.getString("transfer_file_yn");
	if(transfer_file_yn==null || transfer_file_yn.equals("null") || transfer_file_yn.equals(""))
	transfer_file_yn="";

	String confirm_receipt_file_yn = rs.getString("confirm_receipt_file_yn");
	if(confirm_receipt_file_yn==null || confirm_receipt_file_yn.equals("null") || confirm_receipt_file_yn.equals(""))
	confirm_receipt_file_yn="";

	String receive_file_yn = rs.getString("receive_file_yn");
	if(receive_file_yn==null || receive_file_yn.equals("null") || receive_file_yn.equals(""))
	receive_file_yn="";

	String return_file_yn = rs.getString("return_file_yn");
	if(return_file_yn==null || return_file_yn.equals("null") || return_file_yn.equals(""))
	return_file_yn="";


	out.println("<tr><td width=10% class='" + classValue + "'><font size=1>");
	out.println("<a href='../../eFM/jsp/FMUserAccessAddMod.jsp?appl_user_id="+ code + "&fs_locn_code="+fs_locn_code+"&target=f_query_add_mod&operation=modify' >");
	out.println(code+"</a></td><td class='" + classValue + "'><font size=1>");
	
	out.println(fs_locn_desc+" "+locn_identity+"</td><td align='center' width=12% class='" + classValue + "'>");
	
	
	if (assign_fs_locn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%	
		}
		}
	out.println("</td><td align='center' width=10% class='" + classValue + "'>");	

	if (change_fs_locn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}
	
	out.println("</td><td align='center' width=10% class='" + classValue + "'>");	

	if (change_return_date_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{

%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}

	out.println("</td><td align='center' width=10% class='" + classValue + "'>");	

	if (deficiency_check_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{

%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%	
		}
	}

out.println("</td><td align='center' width=5% class='" + classValue + "'>");	

	if (file_lost_found_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{

%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%	
		}
	}
out.println("</td><td align='center' width=5% class='" + classValue + "'>");	

	if (track_out_to_opd_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{

%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}	

out.println("</td><td align='center' width=5% class='" + classValue + "'>");	

if (track_out_to_ipw_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{

%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}	

out.println("</td><td align='center' width=5% class='" + classValue + "'>");	
	
	if (req_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}	

out.println("</td><td align='center' width=10% class='" + classValue + "'>");	


	if (req_across_facilities_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}	

out.println("</td><td align='center' width=5% class='" + classValue + "'>");

	if (manual_request_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}	

out.println("</td><td align='center' width=10% class='" + classValue + "'>");

	if (cancel_request_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}	

out.println("</td><td align='center' width=10% class='" + classValue + "'>");

	if (iss_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}	

out.println("</td><td align='center' width=10% class='" + classValue + "'>");	


	if (iss_across_facilities_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}

out.println("</td><td align='center' width=10% class='" + classValue + "'>");

	if (CREATE_FILE_VOLUME_YN.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}	

out.println("</td><td align='center' width=10% class='" + classValue + "'>");	

	if (transfer_file_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{

%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%	
		}
	}	

out.println("</td><td align='center' width=10% class='" + classValue + "'>");	

	if (confirm_receipt_file_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}

out.println("</td><td align='center' width=10% class='" + classValue + "'>");	

	if (receive_file_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}
out.println("</td><td align='center' width=10% class='" + classValue + "'>");

	if (return_file_yn.equals("Y"))
	{
%>
		<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG>
<%
	}
else 
	{
		if (fs_locn_code.equals("*ALL"))
		{
			out.println("&nbsp;");
		}
		else
		{
%>
		<IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG>
<%		}
	}

	out.println("</td></tr>");
//	out.println("</td><td align='center' class='" + classValue + "'>");

	i++;
	cnt++;

}
	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}

if (stmt!=null) stmt.close();
if (rset!=null) rset.close();
if (rs!=null) rs.close();
	}catch(Exception e){
		out.print(e.toString());
	}
	finally
	{

		ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br>
</BODY>
</HTML>

