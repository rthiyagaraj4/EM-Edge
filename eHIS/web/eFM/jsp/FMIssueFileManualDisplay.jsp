<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form name="Dispalyvals" id="Dispalyvals">
<%
	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	ResultSet rs			= null;

	try
	{
		String currFacility = "";
		String currLocn		= "";
		String currDesc		= "";
		String currStatDesc = "";
		String currIden		= "";
		String currIdDesc	= "";
		String currMrLocn	= "";
		String remark		= "";
		String sysdate		= "";

		String facility_id = (String) session.getValue("facility_id");
		String FileNo = request.getParameter("FileNo");

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();

		//SelectSqlBuffer.append("Select CURR_FS_LOCN_CODE, CURR_FILE_STATUS, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN, CURR_FACILITY_ID,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , REMARKS, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW where FILE_NO = ? and FACILITY_ID = ?");
		SelectSqlBuffer.append("SELECT" );
		SelectSqlBuffer.append("  CURR_FS_LOCN_CODE" );
		SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
		SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
		SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
		SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
		SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
		SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
		SelectSqlBuffer.append("  , REMARKS" );
		SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
		SelectSqlBuffer.append("FROM" );
		SelectSqlBuffer.append("  FM_CURR_LOCN " );
		SelectSqlBuffer.append("WHERE FILE_NO = ? " );
		SelectSqlBuffer.append("  AND FACILITY_ID = ?" );
		
		pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		pstmt.setString(1,FileNo);
		pstmt.setString(2,facility_id);
		rs = pstmt.executeQuery();

		if(rs != null && rs.next())
		{
			currFacility	= rs.getString("CURR_FACILITY_ID");
			currLocn		= rs.getString("CURR_FS_LOCN_CODE");
			currMrLocn		= rs.getString("CURR_MR_LOCN_YN");
			currStatDesc	= rs.getString("FILE_STATUS_DESC"); 
			currDesc		= rs.getString("CURR_FS_LOCN_DESC");
			currIden		= rs.getString("CURR_FS_LOCN_IDENTITY");
			currIdDesc		= rs.getString("LOCN_IDENTITY_DESC");
			remark			= rs.getString("REMARKS");
			sysdate			= rs.getString("SYDATE");
		}

			if(!currStatDesc.equals(""))
			{
				switch(currStatDesc.charAt(0))
				{
					case 'T' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

					case 'E' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherFacility.label","common_labels"); break;
			
				}
			}

		if(!currIdDesc.equals(""))
		{
			switch(currIdDesc.charAt(0))
			{
				case 'D' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}

		if(remark == null || remark.equals("null")) remark = "";

		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}
		%>
		<script>
			parent.frames[3].document.forms[0].currfilelocn.value	= '<%=currDesc%> (<%=currIdDesc%>)';
			parent.frames[3].document.forms[0].filestat.value		= '<%=currStatDesc%>';
			parent.frames[3].document.forms[0].remarks.value		= '<%=remark%>';
			parent.frames[3].document.forms[0].Req_on.value			= '<%=sysdate%>';
			parent.frames[3].document.forms[0].Curr_facility_id.value	= '<%=currFacility%>';
			parent.frames[3].document.forms[0].Curr_locn_code.value		= '<%=currLocn%>';
			parent.frames[3].document.forms[0].Curr_locn_desc.value		= '<%=currDesc%>';
			parent.frames[3].document.forms[0].Curr_locn_iden.value		= '<%=currIden%>';
			parent.frames[3].document.forms[0].Curr_locn_mr_locn.value	= '<%=currMrLocn%>';	
		</script>
		<%
	if (rs!=null) rs.close();
	if (pstmt!=null) pstmt.close();
	}catch(Exception e){out.println("In Exception :"+e.toString()); e.printStackTrace();}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
	%>
</form>
</body>
</html>

