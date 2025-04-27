<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.util.*,java.text.*,eMP.*,eBL.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@page import="org.json.simple.JSONObject"%>
<%!
private String checkNull(String inputString)
{
	if(inputString == null || inputString.equals("") ||  inputString.equalsIgnoreCase("null") )
		inputString = "";
	return inputString;
}
%>


<%
	String operation = request.getParameter("operation");
	JSONObject obj = new JSONObject();

	if (operation.equals("SCANNER_ENABLED")) {
		
		int iDocScanEnabled = 0;
		String sFacilityId = (String) session.getValue("facility_id");

		int iDocFolderOption = 0;

		List<DocumentConfigBean> oDocConfigList = null;
		List<DocumentTypeBean> oDocTypeList = null;
		DocumentConfigBean oDocumentConfigBean = null;

		DocumentConfigOption docConfigOption = new DocumentConfigOption();
		oDocConfigList = new ArrayList<DocumentConfigBean>();
		oDocConfigList = docConfigOption.getDocumentConfigDetails(sFacilityId);
		int nDocConfigListsize = oDocConfigList.size();
		if (nDocConfigListsize > 0) {
			oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize - 1);
			sFacilityId = oDocumentConfigBean.getsFacilityId();
			iDocScanEnabled = oDocumentConfigBean.getiDocScanEnabled();
			iDocFolderOption = oDocumentConfigBean.getiDocFolderOption();

		}
		System.out.println("iDocScanEnabled::::" + iDocScanEnabled);
		System.out.println(" iDocFolderOption::::" + iDocFolderOption);

		if (iDocScanEnabled > 0) {
			obj.put("Flag", "True");

		} else {
			obj.put("Flag", "False");
		}

		out.print(obj);
		out.flush();
		
	} 
%>
