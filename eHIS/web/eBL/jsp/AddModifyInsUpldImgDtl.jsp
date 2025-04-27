
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
10/12/12      100         Bmohankumar  created
Acts as create and Modify screen for PackageServicegroup
called on click of create button from common tool bar
on submission (apply) request will be submitted to  
-----------------------------------------------------------------------------------------------
-->
<%
/*
Sr No     Version        Incident			SCF/CRF								Developer Name
---------------------------------------------------------------------------------------------------------
1         V220818      	  35245        BL-RBU-GHL-CRF-0005 US001/02-
									Financial details-Upload Documents       Mohanapriya
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,java.util.*, java.util.Map.Entry,java.util.Set,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.*"  contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
<title>Upload Documents Window</title>
<%
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	String strModuleId=(String)session.getAttribute("calling_module_id");   //ADDED FOR GHL_0550_CRF
	strModuleId=(strModuleId==null?"":strModuleId);						//ADDED FOR GHL_0550_CRF
	String params = request.getQueryString();	
	
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	String strPatientId = request.getParameter("patient_id"); 
	String strepisode_id = request.getParameter("strepisodeid");
	String strvisit_id=request.getParameter("strvisitid");
	String checkedRow = (request.getParameter("checked_row"));
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	//GHL-CRF-0550.1
	String settlement_ind = (request.getParameter("settlement_ind"));
	settlement_ind=(settlement_ind==null?"":settlement_ind);
	String policy_no = (request.getParameter("policy_no"));
	policy_no=(policy_no==null?"":policy_no);
	boolean settlementIndFlag=false;
	//GHL-CRF-0550.1
%>
<script language='javascript'>
//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
function callNewImg(){
	var moduleId=document.getElementById("strModuleId").value;
	var patient_id=document.getElementById("patient_id").value;
	if(moduleId=="MP" &&(patient_id !="" && patient_id !==null)){
		document.location.href="../../eBL/jsp/AddModifyInsUpldImgDtlNew.jsp";	//GHL-CRF-0550.1	
	}
}
function viewImage_ghl(ind)
{
	//GHL-CRF-0550.1
	var smt_ind=document.getElementById("smt_ind").value;
	if(smt_ind=='X'){
		dat1=document.getElementById('line_'+ind).value ;
	}else{
		if(ind==0){
			dat1=document.getElementById('line_').value;
		}
		else{
			dat1=document.getElementById('line_').value + ind;
		}
	}
	/* if(ind==0){
		dat1=document.getElementById('line_').value;	
	}
	else{
		dat1=document.getElementById('line_').value + ind;
	}
 */	
	//GHL-CRF-0550.1
	var arguments = "";
	var dialogUrl       = "../../eBL/jsp/BLInsImgShow.jsp?index="+dat1+"&title=Insurance Image" ;
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "30" +" ; scroll=auto; ";
	window.open(dialogUrl);
}

function updateDetails1(ind,blgname,moduleid)
{
	var billing_grp_name=blgname;
	var strModuleId=moduleid;
	var dat1;
	//GHL-CRF-0550.1
	var smt_ind=document.getElementById("smt_ind").value;
	if(smt_ind=='X'){
		dat1=document.getElementById('line_'+ind).value ;
	}else{
		if(ind==0){
			dat1=document.getElementById('line_').value;
		}
		else{
			dat1=document.getElementById('line_').value + ind;
		}
	}
	//GHL-CRF-0550.1
	var checkedRow=document.getElementById("checkedRow").value;
	var policy_no=document.getElementById("policy_no").value;
	var patient_id= $('#patient_id').val();
	parent.baseDateDtl.document.location.href='../../eBL/jsp/AddModifyInsUpldImgHdr.jsp?index='+dat1+'&mode=U'+'&patient_id='+patient_id+'&billing_grp_Name='+billing_grp_name+'&strModuleId='+strModuleId+'&checked_row='+checkedRow+'&policy_no='+policy_no;//Added dat against Incident No:9983
	//GHL-CRF-0550.1	
}
//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550

async function viewImage(ind1)
{
	var dat =eval('document.forms[0].line_'+ind1).value;
	var dialogUrl       = "../../eBL/jsp/BLInsImgShow.jsp?index="+dat+"&title=Insurance Image" ;
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "30" +" ; scroll=auto; ";
	var returnVal = await window.showModalDialog(dialogUrl,null,dialogFeatures);	
}

function updateDetails(ind,billing_grp_name)//V220818 
{
	var dat =eval('document.forms[0].line_'+ind).value;
	var policy_no=document.getElementById("policy_no").value;
	var patient_id= $('#patient_id').val();
	parent.baseDateDtl.document.location.href='../../eBL/jsp/AddModifyInsUpldImgHdr.jsp?index='+dat+'&mode=U'+'&patient_id='+patient_id+'&billing_grp_Name='+billing_grp_name+'&policy_no='+policy_no;
}
</script>

<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

	int index=0;
	int cod=0;//GHL-CRF-0550.1
	String applyMode					=	new String();
	String locale						=	"";
	String facilityId					=	"";
	String loggedInUser					=	"";
	String mode							=	"";
	String isUserCanAcess				=	"";
	String bean_id						=	"";
	String bean_name					=	"";
	String modifyStatus     			=	"";
	String sStyle 						=	"";
	String authorized 					=	"";
	String disableAll					=	"";
	String visibilty					=	"";
	String modifyButton					=	"";
	String rowCount						=	"";
	String radVal			 			= 	"off";
	String initialGroupcode				=	""; 
	String initialShortDesc				=	"";
	HashMap 	blInsuranceImageList	=	null;
	BLInsuranceImageBean blInsuranceImageBean 			= 	null;
	BLInsuranceImage	blInsuranceImage = null;	
	String patView="N";
	String smtind = "";
	boolean siteSpecUploadDocAll = false;//Added V191028-Aravindh/GHL-CRF-0550
	Connection con	= null;

	sStyle 							=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	authorized 						=	request.getParameter("authorized")==null?"N":request.getParameter("authorized");
	mode							= 	request.getParameter("mode");
	patView							=	request.getParameter("pat_view")==null?"N":request.getParameter("pat_view");
	isUserCanAcess					= 	(String) session.getValue( "isUserCanAcess" );
	locale 							= 	(String)session.getAttribute("LOCALE");
	facilityId						 = (String) session.getValue( "facility_id" ) ;
	bean_id							= 	"bl_blinsuranceimagebean" ;
	bean_name						= 	"eBL.BLInsuranceImageBean"; 

	blInsuranceImageList	=	new HashMap();
	blInsuranceImageBean	= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request );

	/*	
	When the Page is Loaded check any Image/Data is Present in Cache
	If Data is not Present in Cache - Get Data From Database
	*/
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	con	=	ConnectionManager.getConnection(request);
	siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550

	if(siteSpecUploadDocAll) {
		if (blInsuranceImageBean.getSize() == 0) {
			blInsuranceImageBean.loadInsuranceDBvalues(strPatientId,strModuleId,patView,strepisode_id,strvisit_id);//Added against 9994
		}
	}
	else
	{
		if (blInsuranceImageBean.getSize() == 0) {
				blInsuranceImageBean.loadInsuranceDBvalues(strPatientId);
			}
	}	
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	
	/*	If Data is Present in Cache then Cache Data will be loaded */
	blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues(); 
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
	try
	{
		siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
	} catch(Exception ex) {
		System.err.println("Error in AddModifyInsUpldImgDtl.jsp for getting Connection: "+ex);
		ex.printStackTrace();
	}
	//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src='../js/BillingPackageServiceGroup.js'></script> 
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="callNewImg()" >
	<form name="PackageServicegroupHeaderForm" id="PackageServicegroupHeaderForm" method="post"  action="">  
	
	<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>
	<tr>				
	<% if(patView.equals("N")){%>
	<td class='COLUMNHEADER' nowrap><fmt:message key="Common.delete.label" bundle="${common_labels}"/></td>
	<%} 
	else{%>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.delete.label" bundle="${common_labels}"/></td>
	<%}%>
		
	<% 	if(siteSpecUploadDocAll) { %>
		<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.BillingGroupId.label" bundle="${bl_labels}"/></td><!-- Added V191114-Aravindh/GHL-CRF-0550 -->
	<% } %> 
	<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.POLICY_START_DATE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.POLICY_EXPIRY_DATE.label" bundle="${bl_labels}"/></td>
	<% if(siteSpecUploadDocAll) { %><!-- Added V191114-Aravindh/GHL-CRF-0550 -->
	<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.CreditAuthNo.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Date.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER'nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'nowrap><fmt:message key="eBL.Show_Documents.label" bundle="${bl_labels}"/></td>
	<% }else{ %>
	<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Show_Image.label" bundle="${bl_labels}"/></td>
	<%} %>
	<!-- Added 03-feb-20 palaniNarayanan/GHL-CRF-0550 -->
	</tr>		
<% 
	Object ob[] =(blInsuranceImageList.keySet()).toArray();
	Arrays.sort(ob); //Added V190612 DHANANAJAY/IN70646
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;//Added V191114-Aravindh/GHL-CRF-0550
	PreparedStatement pstmt4 = null;
	ResultSet rs = null;

try{
	String sql;		
	String strPayerGroupDesc ="";
	String strPayerDesc="";
	String strPolicyDesc="";
	String strBillingGroupDesc = "";//Added V191114-Aravindh/GHL-CRF-0550

	pstmt = con.prepareStatement("select long_desc description from ar_cust_group_lang_vw 	where status is null and language_id = '"+locale+"'  and cust_group_code =?");
	//pstmt1= con.prepareStatement("select long_name description from ar_customer_lang_vw Where cust_group_code =? and language_id = '"+locale+"'  and  cust_code=?"); 
	pstmt1= con.prepareStatement("select long_name description from ar_customer_lang_vw Where language_id = '"+locale+"'  and  cust_code=?");  //Modified Against ICN:9943
	pstmt2= con.prepareStatement("select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facilityId+"' and language_id= '"+locale+"' and policy_type_code =?");
	//Added V191114-Aravindh/GHL-CRF-0550
	pstmt3 = con.prepareStatement("select long_desc blng_grp_desc from bl_blng_grp_lang_vw where blng_grp_id = ? and language_id = '"+locale+"'");
	pstmt4 = con.prepareStatement("select SETTLEMENT_IND from BL_BLNG_GRP where SHORT_DESC=?");
	//Added V191114-Aravindh/GHL-CRF-0550	
	for(index=0;index<ob.length;index++)
	{
		/*Karthik added the below code to handle Session Record retain- Unique identifier for Records added in image Page  - starts */
		String addedFromImagePage="";
		String keyFormList=""+ob[index];
		if(keyFormList.contains("^^^")){
			addedFromImagePage="^^^";
		}
		/*Karthik added the below code to handle Session Record retain- Unique identifier for Records added in image Page  - ends */
		//if(blInsuranceImageList.containsValue(""+ob[index]))
		String arr = ob[index].toString();
		//GHL-CRF-0550.1
		if(siteSpecUploadDocAll){
		String[] val = arr.split("_");
		if(settlement_ind.equals("C") || settlement_ind.equals("R") )
		settlementIndFlag = true;
		 if(settlementIndFlag || val[0].equals(policy_no))
		{  
			
		blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+ob[index]);
		if(blInsuranceImage!=null)
		{		
			boolean strCancelChk		 =			blInsuranceImage.getCancelMod();
			String strPayerGroupCode =			blInsuranceImage.getPayerGroupCode();
			strPayerGroupCode=(strPayerGroupCode==null?"":strPayerGroupCode);
			String strPayerCode	=			    blInsuranceImage.getPayerCode();
			strPayerCode=(strPayerCode==null?"":strPayerCode);
			String strPolicyTypeCode=			blInsuranceImage.getPolicyCode();
			strPolicyTypeCode=(strPolicyTypeCode==null?"":strPolicyTypeCode);
			String strPolicyNo		=			blInsuranceImage.getPolicyNo();
			strPolicyNo=(strPolicyNo==null?"":strPolicyNo);
			String strPolicyStartdate=			blInsuranceImage.getStartDate();
			strPolicyStartdate=(strPolicyStartdate==null?"":strPolicyStartdate);
			String strPolicyExpiryDate=			blInsuranceImage.getEndDate();
			strPolicyExpiryDate=(strPolicyExpiryDate==null?"":strPolicyExpiryDate);
			//Added V191114-Aravindh/GHL-CRF-0550
			String strBillingGroup = blInsuranceImage.getBillingGroup();
			strBillingGroup = (strBillingGroup == null?"":strBillingGroup);
			String strdocType = blInsuranceImage.getDocType();
			strdocType = (strdocType==null?"":strdocType);
			String strdocRemarks = blInsuranceImage.getDocRemarks();
			strdocRemarks = (strdocRemarks==null?"":strdocRemarks);
			String strcreditAuthDate = blInsuranceImage.getCreditAuthDate();
			strcreditAuthDate = (strcreditAuthDate==null?"":strcreditAuthDate);
			String strcreditAuthNo= blInsuranceImage.getCreditAuthNo();
			strcreditAuthNo = (strcreditAuthNo==null ? "" : strcreditAuthNo);
			//Added V191114-Aravindh/GHL-CRF-0550
					
			//karthik added image loader for non image cases - starts
			if(blInsuranceImage.getImageLoaded()==false){
				//Modified V191118-Aravindh/GHL-CRF-0550/
					blInsuranceImageBean.loadInsuranceDBImage(strPatientId,strPayerGroupCode,strPayerCode,strPolicyTypeCode,strPolicyNo,strPolicyStartdate,strPolicyExpiryDate,strBillingGroup,strcreditAuthNo,strcreditAuthDate);	
							
				blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues(); 
				blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+ob[index]);
			}
			//karthik added image loader for non image cases - ends
					
			pstmt.setString(1,strPayerGroupCode);
			rs = pstmt.executeQuery();
			if(rs.next())					
				strPayerGroupDesc=rs.getString(1);		
					else
						strPayerGroupDesc="";
					
					
					/* pstmt1.setString(1,strPayerGroupCode); 
					pstmt1.setString(2,strPayerCode); */	//Commented Against ICN:9943 
					
					pstmt1.setString(1,strPayerCode); //Modified Against ICN:9943
					rs = pstmt1.executeQuery();
					if(rs.next())
						strPayerDesc=rs.getString(1);
					else
						strPayerDesc="";
		
					pstmt2.setString(1,strPolicyTypeCode);
					rs = pstmt2.executeQuery();	
					if(rs.next())		
						strPolicyDesc=rs.getString(1);	
					else
						strPolicyDesc="";
					
					//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550
					pstmt3.setString(1,strBillingGroup);
					rs = pstmt3.executeQuery();
					if(rs.next()) {
						strBillingGroupDesc = rs.getString("blng_grp_desc");
						}
						
					pstmt4.setString(1,strBillingGroup);
					rs=pstmt4.executeQuery();
							
					while(rs.next())
					{
						smtind=rs.getString(1);
					}
	
					//Added 03-feb-20 palaniNarayanan/GHL-CRF-0550

			int len;
			len = 1;	  

%>	
			<tr>		
						<% if(patView.equals("N"))		{%>
			<td  class='fields' >&nbsp;
				<%	if(strCancelChk==true)
					 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label" ,"common_labels"));
				else 
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label" ,"common_labels"));
				%>
				</td>
				<td class='fields' nowrap>&nbsp;<a href="javascript:updateDetails1(<%=index%>,'<%=strBillingGroup%>','<%=strModuleId%>')"><%=strBillingGroup%></a></td>
				<td  class='fields' nowrap >&nbsp;<a href="javascript:updateDetails(<%=index%>,'<%=strBillingGroup%>')"> &nbsp;<%=strPayerGroupDesc%></a></td>	<!--V220818-->
				<!-- 
				<td  class='fields'onclick="updateDetails(<%=index%>,this)" nowrap><%=strPayerGroupDesc%></td>
				 -->
				<%} 
				else if(patView.equals("Y"))		{ %>
				<td  class='fields' >&nbsp;
				<%
					if(strCancelChk==true)
						 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label" ,"common_labels"));
					else 
						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label" ,"common_labels"));
					%>
					</td>
				<td class='fields' nowrap>&nbsp;<%=strBillingGroup%></td>
				<td  class='fields' nowrap >&nbsp;<%=strPayerGroupDesc%></td>	
			<%} 
			else {%>
				<td  class='fields' nowrap>&nbsp;<%=strPayerGroupDesc%></a></td>
			<% } %>
			<td  class='fields' nowrap >&nbsp;<%=strPayerDesc%></td>
			<td  class='fields' nowrap  >&nbsp;<%=strPolicyDesc%></td>
			<td  class='fields' nowrap >&nbsp;<%=strPolicyNo%></td>
			<td  class='fields' nowrap >&nbsp;<%=strPolicyStartdate%></td>
			<td  class='fields' nowrap >&nbsp;<%=strPolicyExpiryDate%></td>
			<td  class='fields' nowrap>&nbsp;<%=strcreditAuthNo%></td>
			<td  class='fields' nowrap >&nbsp;<%=strcreditAuthDate%></td>
			<td  class='fields' nowrap>&nbsp;<%=strdocRemarks%></td>
			<td class='fields'  nowrap>
			
		 <% 
			 if(smtind.equals("X")){
		%>
		 	<input type="hidden"  name ="line_<%=index%>"  id="line_" value ="<%=""+policy_no+"_"+cod%>">&nbsp;<!-- GHL-CRF-0550.1 -->
		<%cod++;}
			 else{ //Other Billing Group
		%>
					 <input type="hidden"  name ="line_<%=index%>"  id="line_" value ="<%="^^^1110"%>">&nbsp;
		<%}	
		if(blInsuranceImage.getImageLoaded())
		{
		%>			
			<a href="javascript:viewImage_ghl(<%=index%>);" ><fmt:message key="eBL.ViewDocument.label" bundle="${bl_labels}"/></a>			
	  		
		<%} %>
			</td>	                 
		</tr>	
	<%
		}	
		}
		}
		//GHL-CRF-0550.1
		else{ ////Added Against Except GHL Site Ends
		blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+ob[index]);
		if(blInsuranceImage!=null)
		{		
			boolean strCancelChk		 =			blInsuranceImage.getCancelMod();
			String strPayerGroupCode =			blInsuranceImage.getPayerGroupCode();
			strPayerGroupCode=(strPayerGroupCode==null?"":strPayerGroupCode);
			String strPayerCode	=			    blInsuranceImage.getPayerCode();
			strPayerCode=(strPayerCode==null?"":strPayerCode);
			String strPolicyTypeCode=			blInsuranceImage.getPolicyCode();
			strPolicyTypeCode=(strPolicyTypeCode==null?"":strPolicyTypeCode);
			String strPolicyNo		=			blInsuranceImage.getPolicyNo();
			strPolicyNo=(strPolicyNo==null?"":strPolicyNo);
			String strPolicyStartdate=			blInsuranceImage.getStartDate();
			strPolicyStartdate=(strPolicyStartdate==null?"":strPolicyStartdate);
			String strPolicyExpiryDate=			blInsuranceImage.getEndDate();
			strPolicyExpiryDate=(strPolicyExpiryDate==null?"":strPolicyExpiryDate);
			//Added V191114-Aravindh/GHL-CRF-0550
			String strBillingGroup = blInsuranceImage.getBillingGroup();
			strBillingGroup = (strBillingGroup == null?"":strBillingGroup);
			String strdocType = blInsuranceImage.getDocType();
			strdocType = (strdocType==null?"":strdocType);
			String strdocRemarks = blInsuranceImage.getDocRemarks();
			strdocRemarks = (strdocRemarks==null?"":strdocRemarks);
			String strcreditAuthDate = blInsuranceImage.getCreditAuthDate();
			strcreditAuthDate = (strcreditAuthDate==null?"":strcreditAuthDate);
			String strcreditAuthNo= blInsuranceImage.getCreditAuthNo();
			strcreditAuthNo = (strcreditAuthNo==null ? "" : strcreditAuthNo);
			//Added V191114-Aravindh/GHL-CRF-0550
					
			//karthik added image loader for non image cases - starts
			if(blInsuranceImage.getImageLoaded()==false){
					blInsuranceImageBean.loadInsuranceDBImage(strPatientId,strPayerGroupCode,strPayerCode,strPolicyTypeCode,strPolicyNo,strPolicyStartdate,strPolicyExpiryDate);	
							
				blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues(); 
				blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+ob[index]);
			}
			//karthik added image loader for non image cases - ends
					
			pstmt.setString(1,strPayerGroupCode);
			rs = pstmt.executeQuery();
			if(rs.next())					
				strPayerGroupDesc=rs.getString(1);		
					else
						strPayerGroupDesc="";
								
					pstmt1.setString(1,strPayerCode); //Modified Against ICN:9943
					rs = pstmt1.executeQuery();
					if(rs.next())
						strPayerDesc=rs.getString(1);
					else
						strPayerDesc="";
		
					pstmt2.setString(1,strPolicyTypeCode);
					rs = pstmt2.executeQuery();	
					if(rs.next())		
						strPolicyDesc=rs.getString(1);	
					else
						strPolicyDesc="";
					pstmt3.setString(1,strBillingGroup);
					rs = pstmt3.executeQuery();
					if(rs.next()) {
						strBillingGroupDesc = rs.getString("blng_grp_desc");
						}
						
					pstmt4.setString(1,strBillingGroup);
					rs=pstmt4.executeQuery();
							
					while(rs.next())
					{
						smtind=rs.getString(1);
					}	

			int len;
			len = 1;	  

%>	
			<tr>		
						<% if(patView.equals("N"))		{%>
			<td  class='fields' >&nbsp;
				<%	if(strCancelChk==true)
					 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label" ,"common_labels"));
				else 
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label" ,"common_labels"));
				%>
				</td>
				<td  class='fields' nowrap >&nbsp;<a href="javascript:updateDetails(<%=index%>)"> &nbsp;<%=strPayerGroupDesc%></a></td>	
							<%} 
				else if(patView.equals("Y"))		{ %>
				<td  class='fields' >&nbsp;
				<%
					if(strCancelChk==true)
						 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label" ,"common_labels"));
					else 
						out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label" ,"common_labels"));
					%>
					</td>
				<td  class='fields' nowrap >&nbsp;<%=strPayerGroupDesc%></td>	
			<%} 
			else {%>
				<td  class='fields' nowrap>&nbsp;<%=strPayerGroupDesc%></a></td>
			<% } %>
			<td  class='fields' nowrap >&nbsp;<%=strPayerDesc%></td>
			<td  class='fields' nowrap  >&nbsp;<%=strPolicyDesc%></td>
			<td  class='fields' nowrap >&nbsp;<%=strPolicyNo%></td>
			<td  class='fields' nowrap >&nbsp;<%=strPolicyStartdate%></td>
			<td  class='fields' nowrap >&nbsp;<%=strPolicyExpiryDate%></td>
			<td class='fields'  nowrap>
			<input type="hidden"  name ="line_<%=index%>" value ="<%=""+strPayerGroupCode+strPayerCode+strPolicyTypeCode+strPolicyNo+strPolicyStartdate+strPolicyExpiryDate+addedFromImagePage%>">&nbsp;
					
			<%		
			if(blInsuranceImage.getImageLoaded())
			{
			%>
			  	<a href="javascript:viewImage(<%=index%>);" ><fmt:message key="eBL.View_Image.label" bundle="${bl_labels}"/></a>					
			<%
			} %>
				</td>	                 
		</tr>	
	<%
		}
		} //Added Against Except GHL Site Ends
	}
}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally
		{
			if (rs != null)   rs.close();
			if(pstmt!=null)		pstmt.close(); 
			if(pstmt1!=null)	pstmt1.close();
			if(pstmt2!=null)	pstmt2.close();
			if(pstmt4!=null)	pstmt4.close();
			ConnectionManager.returnConnection(con, request);	
		}
	%>
	</table>	
	<input type='hidden' name='smt_ind' id='smt_ind'  id='smt_ind'   value="<%=smtind%>" >
	<input type='hidden' name='strModuleId' id='strModuleId'  id='strModuleId'   value="<%=strModuleId%>" >
	<input type='hidden' name='patient_id' id='patient_id'  id='patient_id'   value="<%=strPatientId%>" >
	<input type='hidden' name='siteSpecUploadDocAll' id='siteSpecUploadDocAll'  id='siteSpecUploadDocAll'   value="<%=siteSpecUploadDocAll%>" >
	<input type = "hidden"   name ="totRec" value ='<%=index%>'>	
	<input type='hidden' name='patView' id='patView'  id='patView'   value="<%=patView%>" >
	<!-- GHL-CRF-0550.1 -->
	<input type='hidden' name='checkedRow' id='checkedRow'  id='checkedRow'   value="<%=checkedRow%>" >
	<input type='hidden' name='policy_no' id='policy_no'  id='policy_no'   value="<%=policy_no%>" >
	<!-- GHL-CRF-0550.1 -->
	</form>
	</body>
</html>

