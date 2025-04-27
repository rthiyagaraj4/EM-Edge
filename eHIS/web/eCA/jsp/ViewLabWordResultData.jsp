<!DOCTYPE html>
<%@page import="java.sql.*,java.io.*,java.util.*,webbeans.eCommon.*,org.apache.poi.hwpf.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="org.apache.poi.poifs.filesystem.DirectoryEntry,org.apache.poi.poifs.filesystem.DirectoryNode,org.apache.poi.poifs.filesystem.DocumentEntry,org.apache.poi.poifs.filesystem.DocumentInputStream,org.apache.poi.poifs.filesystem.POIFSFileSystem"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
	<body onKeyDown='lockKey()'>
	<form name='signRepCriteriaForm' id='signRepCriteriaForm'>
	<%
		Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;

		String patient_id	= "";
		String event_code	= "";
		String event_group	= "";
		String event_desc	= "";
		String facility_id	= "";
		String specimen_no	= "";
		String template_name = "";
		java.sql.Blob result_blob = null;
		
		patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		event_code = request.getParameter("event_code") == null ? "" : request.getParameter("event_code");
		event_group = request.getParameter("event_group") == null ? "" : request.getParameter("event_group");
		event_desc = request.getParameter("event_desc") == null ? "" : request.getParameter("event_desc");
		facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
		specimen_no = request.getParameter("specimen_no") == null ? "" : request.getParameter("specimen_no");
		template_name = request.getParameter("template_name") == null ? "" : request.getParameter("template_name");
		DirectoryNode dn = null;
		DirectoryEntry docDirNode = null;
		DocumentEntry wordDocument = null;
		DocumentEntry oneTable = null;
		DocumentEntry data  = null;
		POIFSFileSystem pfs   = null;
		
		try
		{
			con = ConnectionManager.getConnection();
			
			String sql = "select RESULT_FILE_ID, RESULT_DATA from RL_OLE_RESULT_TEXT where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and PATIENT_ID = ? and GROUP_TEST_CODE = ? and TEST_CODE = ? and TEMPLATE_NAME = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,specimen_no);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,event_group);
			pstmt.setString(5,event_code);
			pstmt.setString(6,template_name);
			
			rs = pstmt.executeQuery();
			
			while(rs != null  && rs.next())
			{
				result_blob  =  (java.sql.Blob)rs.getBlob("RESULT_DATA");
				POIFSFileSystem fs = new POIFSFileSystem(result_blob.getBinaryStream());
				dn = fs.getRoot();
				docDirNode = (DirectoryEntry) dn.getEntry("Tenant Object");
				wordDocument = (DocumentEntry) docDirNode.getEntry("WordDocument");
				oneTable = (DocumentEntry) docDirNode.getEntry("1Table");
				data = (DocumentEntry) docDirNode.getEntry("Data");
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch(FileNotFoundException ee)
		{
			
		}

		catch(Exception e)
		{			
			e.printStackTrace();
		}
		finally
		{
			if(wordDocument == null || oneTable == null)
			{
		%>
				<script>
					alert(getMessage("FILE_CORRUPTED","CA"));
				</script>
		<%
			}
			else
			{
				pfs = new POIFSFileSystem();
				if(wordDocument != null) pfs.createDocument(new DocumentInputStream(wordDocument),"WordDocument");
				if(oneTable != null) pfs.createDocument(new DocumentInputStream(oneTable), "1Table");
				if(data != null) pfs.createDocument(new DocumentInputStream(data), "Data");			
				response.setContentType("application/msword");
				response.setHeader("Content-Disposition","filename=test.doc");
				pfs.writeFilesystem(response.getOutputStream());
			}
			
			if (con != null)ConnectionManager.returnConnection(con,request);
		}
	%>
		</form>
	</body>
</html>

