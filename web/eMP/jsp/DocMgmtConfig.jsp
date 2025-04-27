<!DOCTYPE html>

<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
24/09/2014     		1   		Sethuraman      Created for Document Configuration   changed.
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,eMP.*,webbeans.eCommon.*,eCommon.Common.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");	
	String mode="";
	String readOnly = "";
	String status = "";		
	String signatureStatus = "";		
	String enabled_checked="";
	String disabledStatus = "disabled";
	int doc_scan_enabled = 0;
	String sFacilityId = "",sFacilityId_df = "";
	int iDocScanEnabled = 0;	
	int iDocSaveAs = 0; 
	int iDocFolderOption = 0; 
	String sDocSharedPath = "";
	String sWebServiceUrl = "";
	int iPhotoFolderOption = 0;

	int iDocScanUIEnabled = 0; // Added by prithivi on 24/2/2016
	//int iDocCheckStatus = 0; 
	
	mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
	sFacilityId = (request.getParameter("facilityId")==null)?"":request.getParameter("facilityId");	
	sFacilityId_df = (request.getParameter("facilityId_df")==null)?"":request.getParameter("facilityId_df");	
	
	//Added by Bhuvana on 23/05/2019
	int iPhotoStorageOption= 0;
	boolean isDebugYN = false; 
	boolean isDocumentOption = false;
	boolean isPhotoOption = false;
	boolean isScanningOption = false;
	boolean isFinancialDocument = false;//Added by Santhosh for GHL-CRF-0648

	int iInvFolderOption = 0;//Added by Kamatchi S for MO-CRF-20171.1      
	boolean isInventoryOption = false;//Added by Kamatchi S for MO-CRF-20171.1
	Connection conn	= null;
	conn = ConnectionManager.getConnection(request); 
	
	isDebugYN = (eXH.XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

	System.out.println("DocMgmtConfig isDebugYN--> "+isDebugYN);

	//Ended by Bhuvana on 23/05/2019
	
	System.out.println("sFacilityId --> "+sFacilityId+" sFacilityId_df --> "+sFacilityId_df);
	try{

		isDocumentOption = CommonBean.isSiteSpecific(conn, "SM","DOCUMENTATION");
		if (isDebugYN) System.out.println("isDocumentOption"+isDocumentOption+".");

		isPhotoOption = CommonBean.isSiteSpecific(conn, "SM","PATIENT_PHOTO");
		if (isDebugYN) System.out.println("isPhotoOption"+isPhotoOption);

		isScanningOption = CommonBean.isSiteSpecific(conn, "SM","SCANNING" );
		if (isDebugYN) System.out.println("isScanningOption"+isScanningOption);
		//Ended by Bhuvana on 23/05/2019
		
		//Added by kamatchi S for MO-CRF-20171.1
		isInventoryOption = CommonBean.isSiteSpecific(conn, "SM","INVENTORY" );//Added by Kamatchi S for MO-CRF-20171.1
		if (isDebugYN) System.out.println("isInventoryOption"+isInventoryOption);//Added by Kamatchi S for MO-CRF-20171.1

		DocumentConfigOption docConfigOption = new DocumentConfigOption(); 	

		List<DocumentConfigBean> oDocConfigList = null;
		//DocumentConfigBean sDocumentConfigBean = null;	

		List<DocumentTypeBean> oDocTypeList = null;   // Added by prithvi on 24/08/2015

		DocumentConfigBean oDocumentConfigBean = null;	
			
		oDocConfigList = new ArrayList<DocumentConfigBean>();
		//sDocumentConfigBean = new DocumentConfigBean();		

		oDocConfigList = docConfigOption.getDocumentConfigDetails(sFacilityId_df);
		if (isDebugYN) System.out.println("oDocConfigList..."+oDocConfigList);

		int nDocConfigListsize = oDocConfigList.size();
		
		//Added by Santhosh for GHL-CRF-0648
		isFinancialDocument = CommonBean.isSiteSpecific(conn, "SM","DOCUMENTATION_FIN");

		if (nDocConfigListsize>0)
		{						
			oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
			
			//sFacilityId 	= oDocumentConfigBean.getsFacilityId();
			iDocScanEnabled = oDocumentConfigBean.getiDocScanEnabled();
			if (isDebugYN) System.out.println("iDocScanEnabled......."+iDocScanEnabled);

			iDocScanUIEnabled = oDocumentConfigBean.getiDocScanUIEnabled();
			if (isDebugYN) System.out.println("iDocScanUIEnabled......."+iDocScanUIEnabled);

			iDocSaveAs = oDocumentConfigBean.getiDocSaveAs();  
			iDocFolderOption = oDocumentConfigBean.getiDocFolderOption();
			iInvFolderOption = oDocumentConfigBean.getiInvFolderOption();//Added by Kamatchi S for MO-CRF-20171.1
			
			iPhotoFolderOption = oDocumentConfigBean.getsPhotoDocOption(); //Added by bhuvana 23/05/2019.
			
			if (isDebugYN) System.out.println("iPhotoFolderOption.."+iPhotoFolderOption);
			if (isDebugYN) System.out.println("sFacilityId.."+sFacilityId);
			if (isDebugYN) System.out.println("iDocFolderOption......."+iDocFolderOption);
			if (isDebugYN) System.out.println("iInvFolderOption......."+iInvFolderOption);//Added by kamatchi S MO-CRF-20171.1
			//iDocCheckStatus = oDocumentConfigBean.getiDocCheckStatus();
			oDocTypeList=oDocumentConfigBean.getiDocTypeList();          // Added by prithvi on 24/08/2015
		}	

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../js/DocMgmtConfig.js' language='javascript' ></script>
<Script src='../../eCommon/js/CommonLookup.js' language="JavaScript" ></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<body onscroll='scrollTitleTop()' class='CONTENT' OnMouseDown="CodeArrest()"
	onload='FocusFirstElement();' onKeyDown="lockKey()">
	<form name="DocMgmtConfigForm" id="DocMgmtConfigForm"
		action="../../servlet/eMP.DocMgmtConfigServlet" method="post"
		target="messageFrame">
	
<%          
if (isScanningOption) 
{ 
%>
		<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
			style="width: 800px;">
			<tbody>
				<tr>
					<td class='columnheadercenter' colspan="3">Scan Document Option&nbsp;</td>
				</tr>
				<tr>
					<td class='gridData' width="45%">Scanning Enabled&nbsp;</td>
					<td class='Fields' colspan="2"><input type="checkbox"
									name="doc_scan_enabled" id="doc_scan_enabled" id="doc_scan_enabled"
									<%= iDocScanEnabled == 1 ? "checked" : "" %>
									onclick='setScanEnabled(this)'></td>
				</tr>
				<tr>
					<td class='gridData' width="45%">Scan UI Enabled&nbsp;</td>
					<td class='Fields' colspan="2"><input type="checkbox"
									name="doc_scan_ui_enabled" id="doc_scan_ui_enabled" id="doc_scan_ui_enabled"
									<%= ((iDocScanUIEnabled == 1 && iDocScanEnabled == 1) ? "checked" : "") %>
									<%= iDocScanEnabled == 0 ? "disabled" : "" %> ></td>
				</tr>
				<tr>
					<td class='gridData' width="45%">Document to be saved as&nbsp;</td>
					<td class='Fields' ><input type="radio"
									name="doc_save_as" id="doc_save_as" value="0"
									<%= iDocSaveAs == 0 ? "checked='checked'" : "" %>
									<%= iDocScanEnabled == 0 ? "disabled" : "" %>>PDF</td>
					<td class='Fields'><input type="radio"
									name="doc_save_as" id="doc_save_as" value="1"
									<%= iDocSaveAs == 1 ? "checked='checked'" : "" %>
									<%= iDocScanEnabled == 0 ? "disabled" : "" %>>IMAGE</td>
				</tr>
				</tbody>
		</table>
<% 
} 
%>


<% 
if (isDocumentOption) 
{ 
%>
										
		<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
			style="width: 800px;">
			<tbody>
				<tr>
					<td class='columnheadercenter' colspan="3">Document Option&nbsp;</td>
				</tr>
				<tr>
					<td class='gridData' width="50%">Document Storage Option&nbsp;</td>
					<td class='Fields'   width="25%" ><input type="radio"
									name="doc_folder_option" id="doc_folder_option" value="0"
									<%= iDocFolderOption == 0 ? "checked='checked'" : "" %>
									onclick='setDocPathEnabled(this)'>Database(Existing)</td>						
					<td class='Fields' width="25%"><input type="radio"
									name="doc_folder_option" id="doc_folder_option" value="1"
									<%= iDocFolderOption == 1 ? "checked='checked'" : "" %>
									onclick='setDocPathEnabled(this)'>Shared Path</td>
				</tr>	

		<% 
			 for(int i=0; i<oDocTypeList.size();i++)       // Added by prithvi on 24/08/2015
			 {
				System.out.println("Bhuvi: "+oDocTypeList.get(i).getsFileCategory()+".");
				if ("D".equals(oDocTypeList.get(i).getsFileCategory()) && !"GRN Documents".equals(oDocTypeList.get(i).getsDocumentName())) //Condition changed by kamatchi S for MO-CRF-20171.1
		{ 
		//Added by Santhosh for GHL-CRF-0648
			if(isFinancialDocument && "FN".equals(oDocTypeList.get(i).getsDocumentType())){
			}
			else {
 
		%>
		 
				<tr>
					<td class='gridData'  width="50%" >
					<input type="hidden" name="doc_types" id="doc_types" value="<%=oDocTypeList.get(i).getsDocumentType() %>">
					<%=oDocTypeList.get(i).getsDocumentName() %>
						<img src='../../eCommon/images/mandatory.gif' id="sharedPathMandatoryImg" name="sharedPathMandatoryImg" <%= iDocFolderOption == 1 ? "style='visibility: visible;'" : "style='visibility: hidden;'" %>>
					&nbsp;</td>
					<td class='Fields'  colspan="2"  width="50%" ><input type="text"
									name="doc_shared_path" id="doc_shared_path" value="<%=oDocTypeList.get(i).getsDocumentSharedPath() %>"
									size=90 maxlength=128 
									onkeypress="return CheckForSpecCharsWithSpaceBlur(event)"
									<%= iDocFolderOption == 1 ? "enabled" : "readonly " %> >
													
									</td>
				</tr>	
		<% } 
		}
		%>
	 
			<% 
			}
			%>
		

			</tbody>
		</table>
<% 
}
%>


<% 	
if (isPhotoOption) 
{ 
%>
										
		<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
			style="width: 800px;">
			<tbody>
				<tr>
					<td class='columnheadercenter' colspan="3">Photo Option&nbsp;</td>
				</tr>
				<tr>
					<td class='gridData' width="50%">Photo Storage Option&nbsp;</td>
					<td class='Fields'   width="25%" ><input type="radio"
									name="doc_photo_option" id="doc_photo_option" value="0"
									<%= iPhotoFolderOption == 0 ? "checked='checked'" : "" %>
									onclick='setDocPathEnabled(this)'>Database(Existing)</td>						
					<td class='Fields' width="25%"><input type="radio"
									name="doc_photo_option" id="doc_photo_option" value="1"
									<%= iPhotoFolderOption == 1 ? "checked='checked'" : "" %>
									onclick='setDocPathEnabled(this)'>Shared Path</td>
					
				</tr>
				
		<% 
		
			 for(int i=0; i<oDocTypeList.size();i++)       // Added by prithvi on 24/08/2015
			 {
				System.out.println("Bhuvi: "+oDocTypeList.get(i).getsFileCategory()+".");
				if ("P".equals(oDocTypeList.get(i).getsFileCategory())) 
		{ 
		%>
			 
					<tr>
						<td class='gridData'  width="50%" >
						<input type="hidden" name="photo_types" id="photo_types" value="<%=oDocTypeList.get(i).getsDocumentType() %>">
						<%=oDocTypeList.get(i).getsDocumentName() %>
							<img src='../../eCommon/images/mandatory.gif' id="photoPathMandatoryImg" name="photoPathMandatoryImg" <%= iPhotoFolderOption == 1 ? "style='visibility: visible;'" : "style='visibility: hidden;'" %>>
						&nbsp;</td>
						<td class='Fields'  colspan="2"  width="50%" ><input type="text"
										name="photo_shared_path" id="photo_shared_path" value="<%=oDocTypeList.get(i).getsDocumentSharedPath() %>"
										size=90 maxlength=128 
										onkeypress="return CheckForSpecCharsWithSpaceBlur(event)"
										<%= iPhotoFolderOption == 1 ? "enabled" : "readonly " %> >				
						</td>

					</tr>	
		<% 
		 }
		%>
	 
			<% 
			 }
			%>
	
			<%--
			<tr>
				<td class='gridData' width="50%">Check Upload Status Enabled&nbsp;</td>
				<td class='Fields' colspan="2"  width="50%" ><input type="checkbox"
								name="doc_check_status" id="doc_check_status"
								<%= iDocCheckStatus == 1 ? "checked" : "" %>>Yes/No</td>
			</tr>	
			 --%>
			</tbody>
		</table>
<% 
} 
%>	

<% //Added by Kamatchi S for MO-CRF-20171.1
if(isInventoryOption) 
{ 
%>
										
		<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
			style="width: 800px;">
			<tbody>
				<tr>
					<td class='columnheadercenter' colspan="3"><fmt:message key="eSM.InventoryDocOption.label" bundle="${sm_labels}"/></td>	
				</tr>
				<tr>
					<td class='gridData' width="50%"><fmt:message key="eSM.DocStorageOption.label" bundle="${sm_labels}"/></td>
					<td class='Fields'   width="25%">
					<input type="radio" name="inventory_folder_option" id="inventory_folder_option" value="0" <%= iInvFolderOption == 0 ? "checked='checked'" : "" %>onclick='setDocPathEnabled(this)'><fmt:message key="eSM.DataBaseExist.label" bundle="${sm_labels}"/></td>				
					<td class='Fields' width="25%">					
					<input type="radio" name="inventory_folder_option" id="inventory_folder_option" value="1" <%= iInvFolderOption == 1 ? "checked='checked'" : "" %>onclick='setDocPathEnabled(this)'><fmt:message key="eSM.SharedPath.label" bundle="${sm_labels}"/></td>
				</tr>	
				
				<% 
			 for(int i=0; i<oDocTypeList.size();i++)       
			 {
				System.out.println("Bhuvi: "+oDocTypeList.get(i).getsFileCategory()+".");
				String DocType = "";
				String DocName = "";
				DocType = oDocTypeList.get(i).getsFileCategory();
				DocName = oDocTypeList.get(i).getsDocumentName();

				if (DocType.equals("D") && DocName.equals("GRN Documents"))
				{ 
					%>
		 
				<tr>
					<td class='gridData'  width="50%" >
					<input type="hidden" name="inv_types" id="inv_types" value="<%=oDocTypeList.get(i).getsDocumentType() %>">
					<%=oDocTypeList.get(i).getsDocumentName() %>
						<img src='../../eCommon/images/mandatory.gif' id="sharePathMandImg" name="sharePathMandImg" <%= iInvFolderOption == 1 ? "style='visibility: visible;'" : "style='visibility: hidden;'" %>>
					&nbsp;</td>
					<td class='Fields'  colspan="2"  width="50%" ><input type="text"
									name="inventory_shared_path" id="inventory_shared_path" value="<%=oDocTypeList.get(i).getsInventorySharedPath()%>""
									size=90 maxlength=128 
									onkeypress="return CheckForSpecCharsWithSpaceBlur(event)"
									<%= iInvFolderOption == 1 ? "enabled" : "readonly " %> >
													
									</td>
				</tr>	
		<% 
		 }
		%>
	 
			<% 
			 }
			%>
		

			</tbody>
		</table>
<% 
}
%>


										
		<br>

		<input type=hidden name="mode" id="mode" value="<%=mode%>">		
		<input type=hidden name="ScanningUIEnabled" id="ScanningUIEnabled" value="">
		<input type=hidden name="ScanningEnabled" id="ScanningEnabled" value=""> 
		<input type=hidden name="DocSaveAs" id="DocSaveAs" value=""> 
		<input type=hidden name="DocFolderOption" id="DocFolderOption" value=""> 
		<input type=hidden name="DocSharedPath" id="DocSharedPath" value=""> 
		<input type=hidden name="WebServiceUrl" id="WebServiceUrl" value=""> 
		<input type=hidden name="DocCheckStatus" id="DocCheckStatus" value=""> 
		<input type=hidden name="isDocumentOption" id="isDocumentOption" value="<%=isDocumentOption%>"> 
		<input type=hidden name="isScanningOption" id="isScanningOption" value="<%=isScanningOption%>"> 
		<input type=hidden name="isPhotoOption" id="isPhotoOption" value="<%=isPhotoOption%>"> 
		<!--Added by kamatchi s for MO-CRF-20171.1-->
		<input type=hidden name="isInventoryOption" id="isInventoryOption" value="<%=isInventoryOption%>">
		<input type=hidden name="InvFolderOption" id="InvFolderOption" value=""> 
		<input type=hidden name="invSharedPath" id="invSharedPath" value="">
		<input type=hidden name="PhotoDocOption" id="PhotoDocOption" value="">
		<input type=hidden name="PhotoSharedpath" id="PhotoSharedpath" value="">
		<input type=hidden name="facilityId" id="facilityId" value=<%=sFacilityId%>>
		<input type=hidden name="facilityId_df" id="facilityId_df" value=<%=sFacilityId_df%>>

<%
}catch(Exception e1)
			{
			 out.println("(DocMgmtConfig.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}
%>
	
	</form>
</body>
</html>

