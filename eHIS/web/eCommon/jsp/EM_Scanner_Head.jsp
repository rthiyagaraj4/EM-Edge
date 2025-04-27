<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, webbeans.eCommon.ConnectionManager, eMP.*" contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	System.out.println(" - - -  Inside EM_Scanner_Head.jsp  - - - ");

	Connection con	= null;
	ResultSet rs1 = null;
	PreparedStatement pstmt = null;

	String appPath = request.getRequestURL().toString();
	String contextPath = request.getContextPath();

	appPath = appPath.substring(0,appPath.indexOf(contextPath)+contextPath.length());

	String facilityId = "", patientid = "", encounterid = "", patientname = "";

	String document_id = "", doc_main_type = "", doc_type = "";

	facilityId	= (String)session.getValue("facility_id");
	patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

	document_id	= request.getParameter("document_id")==null?"":request.getParameter("document_id");;
	doc_main_type = request.getParameter("doc_main_type")==null?"":request.getParameter("doc_main_type");
	doc_type = request.getParameter("doc_type")==null?"":request.getParameter("doc_type");

	String sql = "";

	String docMainTypeCode = "";

	String sFacilityId = "";
	int iDocScanEnabled = 0;	
	int iDocScanUIEnabled = 0; 
	int iDocSaveAs = 0; 
	int iDocFolderOption = 0;
	String sDocType = "";
	String sDocSharedPath = "";
	String sWebServiceUrl = ""; 

	
	try {
		con = ConnectionManager.getConnection(request);

		sql = "select patient_name from mp_patient where patient_id = ? ";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,patientid);
		rs1 = pstmt.executeQuery();

		if(rs1 != null)
		{
			while(rs1.next())
			{
				patientname = rs1.getString(1);
			}	 
		}

		if(pstmt != null) pstmt.close();
		if(rs1 != null) rs1.close();

		}
	catch(Exception ex)
	{ 
		System.out.println("Exception raised while getting patient name "+ex.getMessage());
	}
	try {
		DocumentConfigOption docConfigOption = new DocumentConfigOption(); 		
	
		List<DocumentConfigBean> oDocConfigList = null;
		DocumentConfigBean oDocumentConfigBean = null;	
			
		oDocConfigList = new ArrayList<DocumentConfigBean>();

		if (doc_main_type.length() > 0)
		{
			if (doc_main_type.indexOf('~') > 0)
			{
				docMainTypeCode = doc_main_type.substring(0, doc_main_type.indexOf('~'));
			}
			else
			{
				docMainTypeCode = doc_main_type;
			}
			
		}

		oDocConfigList = docConfigOption.getDocumentConfigDetails(facilityId, docMainTypeCode);

		int nDocConfigListsize = oDocConfigList.size();
		if (nDocConfigListsize>0)
		{						
			oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
			
			sFacilityId 	= oDocumentConfigBean.getsFacilityId();
			iDocScanEnabled = oDocumentConfigBean.getiDocScanEnabled();
			iDocScanUIEnabled = oDocumentConfigBean.getiDocScanUIEnabled();
			iDocSaveAs = oDocumentConfigBean.getiDocSaveAs();  
			iDocFolderOption = oDocumentConfigBean.getiDocFolderOption();   
			sDocType = oDocumentConfigBean.getsDocType();   
			sDocSharedPath = oDocumentConfigBean.getsDocSharedPath();
			
		}	
		
	}
	catch(Exception ex)
	{ 
		System.out.println("Exception raised while getting configuration information "+ex.getMessage());
	}
	finally{
		if (con!=null) ConnectionManager.returnConnection(con,request);
	}

	System.out.println(" :::  facilityId: "+facilityId+" :::  patient_id: "+patientid+" :::  patient_name: "+patientname+" :::  encounterid: "+encounterid+" ::: document_id: "+document_id+" ::: doc_main_type: "+doc_main_type+" ::: doc_type: "+doc_type);

	System.out.println(" :::  iDocScanUIEnabled: "+iDocScanUIEnabled+" :::  iDocSaveAs: "+iDocSaveAs+" :::  iDocFolderOption: "+iDocFolderOption+" :::  sDocSharedPath: "+sDocSharedPath);


	//session.getServletContext().getRealPath("/");
%>
<html>
<head>
<title>Scan Documents</title>
</head>
<body>
	<table align="center" border="4" cellpadding="1" cellspacing="1" style="width: 700px;">
		<tr>
			<td>
				<!--<applet code="ScannerApplet.class" codebase="../Scanner/" archive="EMScanner.jar, JTwain.jar" width="400" height="300">-->
				<!--<applet code="ScanImageApplet.class" codebase="../Scanner/" archive="ScanImageDemo.jar, JTwain.jar" width="800" height="600">-->
				<!--<applet code="ScanImageApplet.class" codebase="../Scanner/" archive="ScanPatientDocument.jar, JTwain.jar, AspriseJavaPDF.jar" width="900" height="400">-->
				<applet code="ScanImageApplet.class" codebase="../Scanner/" archive="ScanPatientDocument.jar, asprise_scan.jar" width="900" height="400">		
				<PARAM name="servletPath" value="<%=appPath%>">
				<PARAM name="facility_id" value="<%=facilityId%>">
				<PARAM name="encounter_id" value="<%=encounterid%>">
				<PARAM name="patient_id" value="<%=patientid%>">
				<PARAM name="patient_name" value="<%=patientname%>">				
				<PARAM name="document_id" value="<%=document_id%>">
				<PARAM name="doc_main_type" value="<%=doc_main_type%>">
				<PARAM name="doc_type" value="<%=doc_type%>">

				<PARAM name="scan_ui_enabled" value="<%=iDocScanUIEnabled%>">				
				<PARAM name="doc_save_as" value="<%=iDocSaveAs%>">
				<PARAM name="doc_folder_option" value="<%=iDocFolderOption%>">
				<PARAM name="doc_shared_path" value="<%=sDocSharedPath%>">
				 Sorry, Your browser does not support Java applet!
				</applet>
			</td>
		</tr>
	</table>	
</body>
</html>
