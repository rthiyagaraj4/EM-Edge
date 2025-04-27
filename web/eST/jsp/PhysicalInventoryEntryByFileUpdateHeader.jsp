<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>  
<%@ page import="eST.PhysicalInventoryEntryBean,webbeans.eCommon.*,java.sql.*,eCommon.Common.*,eST.Common.*

" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>		
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/PhysicalInventoryEntryByFile.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    	</head>
	<%
		String bean_id = "PhysicalInventoryEntryBean";
		String bean_name = "eST.PhysicalInventoryEntryBean";
		String store_code= "";
		String ec= "";
		String default_store_code="";
		String default_store_desc="";
		String default_phy_inv_id="";
		String default_entry_complete="N";
		String default_file_name="";
		String mode= CommonRepository.getCommonKeyValue("MODE_INSERT");
		
		
	    Connection con				= null;
		try{		
	   	con						= ConnectionManager.getConnection(request);
	   	PhysicalInventoryEntryBean bean = (PhysicalInventoryEntryBean) getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clear_data_added();
		bean.setMode( mode ) ;
		System.out.println(mode);
		Enumeration<String> paramNames = request.getParameterNames();
		int count = 0;
		while (paramNames.hasMoreElements()) {
		  count++;
		  break;
		}
		if(count==1){
		
		 default_phy_inv_id=request.getParameter("phy_inv_id");}
	    // default_entry_complete=request.getParameter("entry_complete");
	    if(default_phy_inv_id==null)
		 {
	    	default_phy_inv_id="";
		 }
		//default_phy_inv_id=bean.getPhy_inv_id();

		else{
		default_entry_complete=bean.getEntry_completed_yn();
		 if(default_entry_complete==null)
		 {
	    	default_entry_complete="N";
		 }
		default_file_name=bean.getClient_file_name();
		if(default_file_name==null)
		 {
	    	default_file_name="";
		 }
		}
	    System.out.println("in2"+default_phy_inv_id+default_entry_complete+default_file_name);
		
	   	boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	   	bean.setSite_spec_yn(site);
	   	//Added for GHL-CRF-0413.7 ends
	   	String stores=bean.getStore();
	    String filePath=(application.getRealPath("/eST")+"\\");
	   	filePath=filePath.replace("\\","\\\\");
	   	/*for(int i=0;i<filePath.length();i++)
	   	{
	   		if (charAt(i)=='\')
	   		{
	   			filePath=filePath.substring(0,i)+"\\"+filePath.substring(i); 
	   		}
	   	}*/
		System.out.println(filePath);
	   String option=bean.getTempphyid();
	   //System.out.println(option);			
	   if(default_phy_inv_id!=""){ 
			int p=option.indexOf(default_phy_inv_id);
			if(p!=-1){
			option=option.substring(0, p-7) + "selected=\"selected\" " + option.substring(p-7);}
			System.out.println("option"+option);}
	%>	
	<body onLoad="FocusFirstElement();getStore();<%if(default_phy_inv_id=="Y"){ %>setEntryComplete();<%}%>" >
		 <form id="formId" name="formPhysicalInventoryEntryByFileUpdateHeader" id="formPhysicalInventoryEntryByFileUpdateHeader"  action="../../servlet/eST.CsvUploadServlet" method="post"  enctype='multipart/form-data'  ><!-- onsubmit="subForm();" -->
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='70%' align=center><tr><td>
				<table border="0" cellpadding="0" cellspacing="0" width='100%'  align=center>
				<tr>
				    <td  class="label"><fmt:message key="eST.PhyInventoryID.label" bundle="${st_labels}"/></td>
					<td class="fields" align = "right"><select id="pid" name="phy_inv_id" id="phy_inv_id"  onChange="getStore();"  >
					<%=option%>
					</select>
					<input type="hidden" name="file_path" id="file_path" value="<%=filePath%>">
					</td>
					</select>
					</td>
					<td class="LABEL" ><fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				    <td class="fields" align = "right" >&nbsp;&nbsp;<input type='text' size='15'  maxlength='15' id='desc' name='store_desc' id='store_desc'  value="" disabled></td>
				    <input type='hidden' id='code' name='store_code' id='store_code'  value="" <%=store_code%> ></td>
				    </tr>
				      </tr>
				    <tr>
					<td  class="label"><fmt:message key="eST.UploadFile.label" bundle="${st_labels}"/></td>
				    <td class="fields" align = "right"><input type='text' size='20'  maxlength='20' id='FN' name='file_name' id='file_name'  value="<%=default_file_name%>" ></td>
				    <td align='left'><input type="button" class="button" name="BrowseAndView" id="BrowseAndView" value='<fmt:message key="eST.BrowseAndView.label" bundle="${st_labels}"/>' onclick="document.getElementById('file').click();"/>  
					<input type="file" style="display:none;" id="file" name="fileName" id="fileName" onchange="fun_browse_file(this);"/>
				    </td>
				    <td class="label" align = "right"><fmt:message key="Common.EntryCompleted.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" value="" id='ec' name="entry_completed_yn" id="entry_completed_yn" onChange="setValue();" <% if(bean.getRemarks_count()>0) {%>disabled<% }%>  ></td>
				    <td class="fields">
					&nbsp;&nbsp;</td>
					  <td><input type=button class="button"  value="View" id="viewButton" name="viewData" id="viewData" onclick="view();" disabled="true"/>
					<!--  <td><input type=button class="button"  value="View" id="viewButton" name="viewData" id="viewData" onclick="submit();"/></td>-->
					<!--  <td><input type="submit" value="View" id="cServlet" name="callServlet" id="callServlet" formtarget="_self"/></td>-->
				    
				</tr>
				</table>
				</td>
				</tr>
			</table>
			 
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="bean" id="bean" value="<%= bean%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="store_code2" id="store_code2" value="<%=store_code%>">
			<input type="hidden" name="entry_comp" id="entry_comp" value="<%=default_entry_complete%>">
			
		</form>
		
		
<%
System.out.println("Sending bean");
putObjectInBean(bean_id,bean,request);
%>
<%
//Added for GHL-CRF-0413.7 starts
		}
	catch(Exception e)
		{
		
		}
finally{		
	if(con != null){
		ConnectionManager.returnConnection(con,request);}}
%>
</body>
</html>

