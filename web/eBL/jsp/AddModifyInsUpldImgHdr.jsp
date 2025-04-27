<!-- 
Sr No        Version              TFS					SCF/CRF		           	    Developer Name
-------------------------------------------------------------------------------------------------------
1	    V220728		33245				RBU-GHL-CRF-0005 US001			MohanapriyaK
-->

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.text.SimpleDateFormat,eBL.Common.*, eBL.*,eBL.resources.*,eCommon.Common.*" contentType="text/html; charset=ISO-8859-1" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<% 
	String strPatientId = ""+request.getParameter("patient_id");
	strPatientId=(strPatientId==null)?"":strPatientId;
	//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
	String strModuleId= "";
	String strFunctionId = "";
	String Uindex=request.getParameter("index");				 
	session.setAttribute("uindex",Uindex );
	String params = request.getQueryString();
	//GHL-CRF-0550.1
	String totalRecords= checkForNull(request.getParameter("totalRecords"));
	session.setAttribute("totalRecords", totalRecords);
	//GHL-CRF-0550.1
	String strbilling_grp_Name=checkForNull(request.getParameter("billing_grp_Name"));
	session.setAttribute("strbilling_grp_Name", strbilling_grp_Name);
	strModuleId = request.getParameter("strModuleId");
	session.setAttribute("strModuleId", strModuleId);
	strFunctionId = request.getParameter("strfunction_id");
	if (strModuleId == null) strModuleId= ""; 
	if (strFunctionId == null) strFunctionId = "";
	String checkedRow=checkForNull(request.getParameter("checked_row"));
	//GHL-CRF-0550.1
	session.setAttribute("checkedRow", checkedRow);
	String policy_no=checkForNull(request.getParameter("policy_no"));
	session.setAttribute("policy_no", policy_no);
	//GHL-CRF-0550.1
	//Added by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
	String episode_type_ins ="";
	if (strModuleId.equals("OP"))  episode_type_ins = "O";
	if (strModuleId.equals("AE"))  episode_type_ins = "E";
	if (strModuleId.equals("IP"))  episode_type_ins = "I";
	if (strModuleId.equals("DC"))  episode_type_ins = "D";
	if (strModuleId.equals("MP"))  episode_type_ins = "R";
	//Ended by Shikha for GHL-CRF-0550 #9970 on 28-Apr-2020
	String smtind="";
	//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
%>

	<script language="javascript" src="../../eCommon/js/common.js"></script>	
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>		
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script Language="javascript" src="../../eCommon/js/ScanDocument.js"></script>	
	
	<script >

	$(document).ready(function(){
	$('#scanDoc').attr('disabled','disabled');
	$.ajax({
		type : 'POST',
		url : "../jsp/ScannerFunctionAjaxcall.jsp",
	    dataType : "text",
		data: { operation:'SCANNER_ENABLED' },
		async:false,
		success : function(data) {			
			var obj=jQuery.parseJSON(data);				
			if(obj.Flag=="True")
			{				
				$('#scanDoc').removeAttr('disabled');
			}else {
				$('#scanDoc').attr('disabled','disabled');
			}		
		}
	});
	
 	$("#scanDoc").click(function(){
  			var currentdate = new Date(); 
			var documentId =  "BL" + currentdate.getDate() 
			                + (currentdate.getMonth()+1)  
			                + currentdate.getFullYear()   
			                + currentdate.getHours()   
			                + currentdate.getMinutes() 
			                + currentdate.getSeconds()
							+ currentdate.getMilliseconds();
		
			if(validateForm()){
				//Scanner Interface is Called here with 4 Parameters{ Patient_ID(If present),Document Type,Document_ID, Validation Object }
				//alert($("#patient_id").val());
				var patientId=document.getElementById("patient_id").value;
				var retVal=ShowScanner(patientId,'FN',documentId,this);

				$.ajax({
					type : 'POST',
					url : "../jsp/ScannerImagePersistance.jsp",
				    dataType : "text",
					data: { 
						operation:'LOAD_SCANNED_IMAGE',
						docId: documentId,
						payrGrpCode: $('#payrGrpCode').val(),
						payrCode:$('#payrCode').val(),
						plcyCode:$('#plcyCode').val(),
						plcyNo:$('#plcyNo').val(),
						plcystartDate:$('#plcystartDate').val(),
						plcyExpryDate:$('#plcyExpryDate').val()	
					},
					async:false,
					success : function(data) {

							var obj=jQuery.parseJSON(data);
							
							if(obj.Flag=="SUCCESS")
							{	
								alert("Scanned Image loaded Successfully");
								parent.frames[1].document.location.href="../../eBL/jsp/AddModifyInsUpldImgDtl.jsp";	
								resetHdr();
							}else {
								alert("Scanned Image is not Loaded");
							}	 			
					}
				});				
			}
			else{
				alert("Some fields doesnt have values");
			}
	  });
});

function selectCheck(obj,obj1)	
{
	var objBut = document.forms[0].addBut;

	if (obj.checked)  	
	{
		obj1.value = 'Y';	
		objBut.value = 'Remove';
		document.getElementById('Add').name ='Remove';
		alert(document.getElementById('Add').name);
	}
	else
	{
		obj1.value = 'N';
		objBut.value = 'Add';
	}
}

</script>
<!--  ADDED FOR GHL_CRF_0550 PALANI NARAYANAN  STARTS-->
<script>

function ChooseContact(obj,creditAuthNo,creditAuthDate) {	
	if(obj.value=="" && creditAuthNo!=null)
	{
		document.getElementById ("docRemarks").value = getLabel("Common.Select.label","Common");
		if(document.getElementById ("docRemarks").value!=null)
		{
			document.getElementById ("docRemarks").value='';
		}//modified by Mohanapriya 21-04-20
		document.getElementById("astr").style.display = "none";
		document.getElementById("creditAuthNo").disabled=true;
		document.getElementById("creditAuthDate").disabled=false;
		document.getElementById ("creditAuthDate").value = "";
	}
	if(obj.value=="A")
	{
		document.getElementById ("docRemarks").value = getLabel("Common.AadharCard.label","Common");
		document.getElementById("astr").style.display = "none";
		document.getElementById("creditAuthNo").disabled=false;
		document.getElementById ("creditAuthNo").value = "";
		document.getElementById("creditAuthDate").disabled=false;
		document.getElementById ("creditAuthDate").value = "";
		//Added by Mohanapriya  21-04-20
		if(document.getElementById("credit_img").disabled=true){
			document.getElementById("credit_img").disabled=false;
		}
	}
	if(obj.value=="L")
	{
		document.getElementById("astr").style.display = "block";
		document.getElementById ("docRemarks").value = getLabel("eBL.AuthorizationLetter.label","eBL");
		document.getElementById("creditAuthNo").disabled=true;
		document.getElementById("creditAuthDate").disabled=true;
		document.getElementById("credit_img").disabled=true;//modified by Mohanapriya 21-04-20
		document.getElementById ("creditAuthNo").value = creditAuthNo;
		document.getElementById ("creditAuthDate").value = creditAuthDate;
	}
	if(obj.value=="P")
	{
		document.getElementById ("docRemarks").value = getLabel("eBL.PanCard.label","eBL");
		document.getElementById("astr").style.display = "none";
		document.getElementById("creditAuthNo").disabled=false;
		document.getElementById ("creditAuthNo").value = "";
		document.getElementById("creditAuthDate").disabled=false;
		document.getElementById ("creditAuthDate").value = "";	
		//Added by Mohanapriya  21-04-20
		if(document.getElementById("credit_img").disabled=true){
			document.getElementById("credit_img").disabled=false;
		}
	}
	if(obj.value=="T")
	{
		document.getElementById ("docRemarks").value = getLabel("eBL.Passport.label","eBL");
		document.getElementById("astr").style.display = "none";
		document.getElementById ("creditAuthNo").value = "";
		document.getElementById("creditAuthDate").disabled=false;
		document.getElementById ("creditAuthDate").value = "";
		//Added by Mohanapriya  21-04-20
		if(document.getElementById("credit_img").disabled=true){
			document.getElementById("credit_img").disabled=false;
		}
	}
	if(obj.value=="O")
	{
		document.getElementById ("docRemarks").value = getLabel("Common.others.label","Common");
		document.getElementById("astr").style.display = "none";
		document.getElementById("creditAuthNo").disabled=false;
		document.getElementById ("creditAuthNo").value = "";
		document.getElementById("creditAuthDate").disabled=false;
		document.getElementById ("creditAuthDate").value = "";
		//Added by Mohanapriya  21-04-20
		if(document.getElementById("credit_img").disabled=true){
			document.getElementById("credit_img").disabled=false;
		}
	}
}
</script>
<!--  ADDED FOR GHL_CRF_0550 PALANI NARAYANAN  ENDS-->

<script type="text/javascript">
function chkRemarksField(obj) {	
   if (obj.value=="" ) 
   {	   
	 alert("Doc Type Cannot Be Blank");
   }
}

//V220728
function getSize() {
     //var myFSO = new ActiveXObject("Scripting.FileSystemObject");
	 var myFSO = "";
     var filepath = document.IMG_UPLOAD.InsImage.value;
     var thefile = myFSO.getFile(filepath);
     var size = thefile.size;
     var sizeInMB = (size / (1024*1024)).toFixed(2);
     if(sizeInMB>2){
    	 alert("Uploading File size must be less than 2MB");
    	 return false;
     }else{
    	 return true;
     }
}
//V220728
</script>
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%> 

<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 

	Connection con = null;
	Statement stmt=null;
	ResultSet rs=null;

	String payerGroupCode="";  
	String  payerGroupDesc="";
	String payerCode="";
	String payerDesc="";
	String policyCode="";
	String policyDesc="";
	String policyNo="";
	String startDate="";
	String endDate="";
	String  strCancelChk ="";
	String chkValue="";
	//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
	String docRemarks="";
	String creditAuthNo="";
	String creditAuthNumber="";
	String creditAuthDate="";
	String docType="";
	String creditAuthDate1="";
	//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
	String billingGroupCode = "", billingGroupDesc = "";//Added V191114-Aravindh/GHL-CRF-0550
	boolean cancelChk;

	String index = request.getParameter("index");
	index= (index==null?"0":index);
	//Added Against Incident No:9983
	/* String index1 = request.getParameter("index1");
	index1= (index1==null?"0":index1); */
	//Added Against Incident No:9983

	String mode  = request.getParameter("mode");	
	mode= (mode==null?"I":mode);

	String sStyle 		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String locale 			= 	(String)session.getAttribute("LOCALE");
	String facilityId		= (String) session.getValue( "facility_id" ) ;
%>
<% 

	String strDisabled= "disabled";
	String strdisableBut= "";
	String strModDisabled="";
	String called_from = request.getParameter("callfrom");
	called_from = (called_from==null)?"":called_from;
	//Added V191028-Aravindh/GHL-CRF-0550
	boolean siteSpecUploadDocAll = false;
	
	try {
			con	=	ConnectionManager.getConnection(request);
			siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
		
	} catch(Exception ex) {
		System.err.println("Error in AddModifyInsUpldImgHdr.jsp for getting Connection: "+ex);
		ex.printStackTrace();
	}
	//Added V191028-Aravindh/GHL-CRF-0550

	if(called_from.equals("CH_PAT"))	
	{
		strModDisabled= "";	
		strdisableBut="";
	}
	else 	
	{
		strdisableBut= "";
		strModDisabled= "";
	}

   if (mode.equals("U"))
   {
	strdisableBut= "disabled";
	strDisabled="";
	strModDisabled= "readonly onfocus='this.blur()'";

	String    bean_id							= 	"bl_blinsuranceimagebean" ;
	String  bean_name						= 	"eBL.BLInsuranceImageBean";
	HashMap 	blInsuranceImageList							=	null;
	BLInsuranceImageBean blInsuranceImageBean 			= 	null;
	BLInsuranceImage	blInsuranceImage = null;	

	blInsuranceImageList	=	new HashMap();
	blInsuranceImageBean	= 	(BLInsuranceImageBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
	blInsuranceImageList	= 	(HashMap)blInsuranceImageBean.getInsuranceImageValues(); 

	//Added Against Incident No:9983 Starts
	/* BLInsuranceImage	blInsuranceImage1 = null;	
	blInsuranceImage1 	= (BLInsuranceImage)blInsuranceImageList.get(""+index1);
	if(blInsuranceImage1!=null)
	{			
		creditAuthNumber=blInsuranceImage1.getCreditAuthNo();	
		creditAuthNumber=(creditAuthNumber==null) ?  "" : creditAuthNumber;
		creditAuthDate1=blInsuranceImage1.getCreditAuthDate();
		creditAuthDate1=(creditAuthDate1==null) ? "" : creditAuthDate1;
	} */
	//Added Against Incident No:9983 Ends
	
	blInsuranceImage 	= (BLInsuranceImage)blInsuranceImageList.get(""+index);
	if(blInsuranceImage!=null)
	 {			
		 payerGroupCode = blInsuranceImage.getPayerGroupCode();  
		 payerCode    = blInsuranceImage.getPayerCode();  
		 policyCode   = blInsuranceImage.getPolicyCode();  
		 policyNo     = blInsuranceImage.getPolicyNo();  
		 startDate    = blInsuranceImage.getStartDate();  
		 endDate      = blInsuranceImage.getEndDate();  
		 cancelChk    = blInsuranceImage.getCancelMod();
		 //Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes 	
		 billingGroupCode = blInsuranceImage.getBillingGroup();
		 docRemarks=blInsuranceImage.getDocRemarks();			 
		 docRemarks=(docRemarks==null)?"":docRemarks;
		 creditAuthNo=blInsuranceImage.getCreditAuthNo();			 
		 creditAuthDate=blInsuranceImage.getCreditAuthDate();
		 docType=blInsuranceImage.getDocType();
		 //Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
		if(cancelChk==true)	 
		{
			strCancelChk="Y";
			chkValue ="checked";
		}
		else 
		{
			strCancelChk="N";
			chkValue ="";
		}
try  {
		//con	=	ConnectionManager.getConnection(request);
		String sql;

		stmt = con.createStatement();
		sql ="select long_desc description from ar_cust_group_lang_vw 	where status is null and language_id = '"+locale+"'  and cust_group_code ='"+payerGroupCode+"'";

		rs = stmt.executeQuery(sql);
		if(rs.next())
		{
			payerGroupDesc=rs.getString(1);		
		}

		sql="Select long_name description from ar_customer_lang_vw Where language_id = '"+locale+"'  and  cust_code='"+payerCode+"'";  //Modified Against ICN:9943
		rs = stmt.executeQuery(sql);
		if(rs.next())
		{
			payerDesc=rs.getString(1);		
		}

		sql="select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facilityId+"' and language_id= '"+locale+"' and policy_type_code ='"+policyCode+"'";

		rs = stmt.executeQuery(sql);
		if(rs.next())
		{
			policyDesc=rs.getString(1);		
		}

		if(siteSpecUploadDocAll){
			//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
			sql="select long_desc blng_grp_desc from bl_blng_grp_lang_vw where blng_grp_id = '"+billingGroupCode+"' and language_id = '"+locale+"'";

			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				billingGroupDesc = rs.getString("blng_grp_desc");		
			}
		}
		//Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes
	   }
	   catch(Exception ee)
	   {
			ee.printStackTrace();
	   }
	   finally
	   {
		if(rs != null)   rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(con, request);	
	   }
	   }
   }  
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src='../js/InsUpldImage.js'></script> 
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<form name="IMG_UPLOAD" id="IMG_UPLOAD"  id="IMG_UPLOAD" action="../../servlet/eBL.BLInsImageUploadServlet" method="post" enctype="multipart/form-data">
	    <table  align="center" cellpadding=3 cellspacing=0 border=0 width="100%"  scrolling="auto" >			
		<tr>
			<td class="label" nowrap>
				<fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/>
			</td>
			<td class="fields">
				&nbsp;<select id="episode_type" name="episode_type" id="episode_type"  style="width: 70px;" onchange='clearPayerFields();'>
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="eBL.OP.label" bundle="${bl_labels}"/></option>
					<option value="I"><fmt:message key="eBL.IP.label" bundle="${bl_labels}"/></option>
					<option value="D"><fmt:message key="eBL.DC.label" bundle="${bl_labels}"/></option>
					<option value="E"><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
					<option value="R"><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
				</select>
		 <% //Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes			  
				if((siteSpecUploadDocAll==true) && !(strModuleId.equals("IP")) && (!strFunctionId.equals("ADMISSION"))&& (!strModuleId.equals("OP")) &&(!strFunctionId.equals("VISIT_REGISTRATION"))) { 
		 %>				
			<img src='../../eCommon/images/mandatory.gif'>	
		<% } %>
			</td>
			<td class="label" ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<!--&nbsp;<input type="text" name="episode_id" id="episode_id" id="episode_id"  maxlength="30"  onBlur="if(this.value!=''){return episodetypevalidation(); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >-->
					&nbsp;<input type="text" name="episode_id" id="episode_id" id="episode_id"  maxlength="30"  onBlur="return episodetypevalidation();"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" > <!-- Modified Against ICN:74031-->
					<input type='hidden' name='hdnEpisode_id' id='hdnEpisode_id'>
					<input type='hidden' name='episode_type_ins' id='episode_type_ins' value='<%=episode_type_ins%>'>
					<input type='hidden' name='visit_id_ins' id='visit_id_ins'>
					<input type='hidden' name='episode_id_ins' id='episode_id_ins'>
					<input type='hidden' name='encounter_id_ins' id='encounter_id_ins'>
					<input type='button' class='button' name="episode_idbut" id="episode_idbut" value='?' onClick="episodeLookup(episode_id,hdnEpisode_id)"  tabindex='2' /> 
		  <%
			if((siteSpecUploadDocAll==true) && !(strModuleId.equals("IP")) && (!strFunctionId.equals("ADMISSION"))&& (!strModuleId.equals("OP")) &&(!strFunctionId.equals("VISIT_REGISTRATION"))) { 
		 %>
			<img src='../../eCommon/images/mandatory.gif'>	
		  <%  }%>
			</td>
			<% if(siteSpecUploadDocAll) { %>
				<!-- Added V191112-Aravindh/GHL-CRF-0550/Starts -->
				<td class="label" ><fmt:message key="eBL.BillingGroupId.label" bundle="${bl_labels}"/></td>
				<td class="label" align="right">
					<input type="text" name="blngGroupDesc" id="blngGroupDesc" id="blngGroupDesc" size="30" maxlength="30"  value="<%=checkForNull(billingGroupCode)%>"  onBlur="" <%=strModDisabled%> />
					<input type='hidden' name='blngGrpCode' id='blngGrpCode' id='blngGrpCode' value='<%=billingGroupCode%>' />
					<input type="button" class="button" name="blngGroupCls" id="blngGroupCls" value="?" style="visibility:hidden" onClick="callPlcyLookup(1,payerGroupDesc,payrGrpCode)" <%=strdisableBut%> />
				</td>
				<!-- Added V191112-Aravindh/GHL-CRF-0550/Ends -->
			<% } %>
		</tr>

		<tr>
			<td class="label" 	align="right" nowrap><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/> &nbsp;</td><td class="label" 	align="right">
			<input type="text" name="payerGroupDesc" id="payerGroupDesc" size="25" maxlength="30"  value="<%=payerGroupDesc%>"  onBlur="" <%=strModDisabled%>>
			<input type= 'hidden'  name='payrGrpCode' id='payrGrpCode' id='payrGrpCode'   value='<%=payerGroupCode%>'><input type="button" class="button" name="payerGroupCls" id="payerGroupCls" value="?" style="visibility:hidden" onClick="callPlcyLookup(1,payerGroupDesc,payrGrpCode)" <%=strdisableBut%> />
			</td>

			<td class="label" 	align="left"><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/>&nbsp;</td><td class="label" 	align="right">
			<input type="text" name="payer" id="payer" size="30" maxlength="30"  value="<%=payerDesc%>"	  onBlur="" <%=strModDisabled%>><input type= "hidden"  name="payrCode" id="payrCode" id='payrCode' value="<%=payerCode%>" ><input type="button" class="button" style="visibility:hidden" name="payerCls" id="payerCls" value="?" onClick="callPlcyLookup(2,payer,payrCode,payrGrpCode)"  <%=strdisableBut%>></td>				

			<td class="label"  align="left"><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>
			&nbsp;</td>
			<td class="label" 	align="right">
			<input type="text" name="plcy" id="plcy" size="30" maxlength="30"  value="<%=policyDesc%>"	  onBlur="" <%=strModDisabled%>><input type= "hidden"  name="plcyCode" id="plcyCode" id="plcyCode"  value="<%=policyCode%>" ><input type="button" style="visibility:hidden" class="button" name="plcyCls" id="plcyCls" value="?" onClick="callPlcyLookup(3,plcy,plcyCode)" <%=strdisableBut%>></td>		
		</tr>

		<tr>
			<td class="label" 	align="left"><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/>&nbsp;</td><td class="label" 	align="right"><input type="text" id='plcyNo' name="plcyNo" id="plcyNo" size="10" maxlength="10"  value="<%=policyNo%>"  onBlur="" <%=strModDisabled%>>
			</td>			

			<td class="label" 	align="left"><fmt:message key="eBL.POLICY_START_DATE.label" bundle="${bl_labels}"/>&nbsp;</td><td class="label" 	align="right">
			<input type="text" name="plcystartDate" id="plcystartDate" id="plcystartDate" size="10" maxlength="10"  value="<%=startDate%>"   onBlur="" <%=strModDisabled%>><img id = "start_img" name="start_img"	  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('plcystartDate');" <%=strdisableBut%>></td>
			
			<td class="label" width="15%"	align="left"><fmt:message key="eBL.POLICY_EXPIRY_DATE.label" bundle="${bl_labels}"/>&nbsp;</td><td class="label" 	align="right">
			<input type=""text" name="plcyExpryDate" id="plcyExpryDate" id="plcyExpryDate" size="10" maxlength="10"  value="<%=endDate%>"   onBlur=""  <%=strModDisabled%>><img id = "start_img" name="start_img"	  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('plcyExpryDate');" <%=strdisableBut%>></td>
			<input type = 'hidden' name ='cancel' value ="<%=strCancelChk%>">
		</tr>
		<!-- Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes -->
		<% if(siteSpecUploadDocAll) { %>		
		<tr>
			<td class="label" 	align="right" nowrap><fmt:message key="Common.DocType.label" bundle="${common_labels}"/> &nbsp;</td>
			<td class="label" 	align="right">
				<select onchange="ChooseContact(this,'<%=creditAuthNo%>','<%=creditAuthDate%>')" name="docType" id="docType"  style="width: 150px;" >
					<option value="" ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
					<option value="A"><fmt:message key="Common.AadharCard.label" bundle="${common_labels}"/></option>
					<option value="L"><fmt:message key="eBL.AuthorizationLetter.label" bundle="${bl_labels}"/></option>
					<option value="P"><fmt:message key="eBL.PanCard.label" bundle="${bl_labels}"/></option>
					<option value="T"><fmt:message key="eBL.Passport.label" bundle="${bl_labels}"/></option>
					<option value="O"><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
				</select><img src='../../eCommon/images/mandatory.gif'>
			</td>
			
			<td class="label" align="left"><fmt:message key="Common.Document.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eBL.Remarks.label" bundle="${bl_labels}"/></td>
			<td class="label" align="right" >
				 <input type="text" name="docRemarks" id="docRemarks" id="docRemarks" size="20" maxlength="20" value="<%=docRemarks%>" onclick="chkRemarksField(this);"  />
				 
			<!-- <input type="text" name="docRemarks" id="docRemarks" id="docRemarks" size="35" /> -->	
			</td>
				
			<td class="label" align="left"><fmt:message key="eBL.CreditAuthNoDate.label" bundle="${bl_labels}"/>&nbsp;</td>
			<td class="label" align="right" >&nbsp;
			<input type="text" name="creditAuthNo" id="creditAuthNo" id="creditAuthNo" size="20" maxlength="15" value="<%=creditAuthNo%>"  >
		 
			<!-- modified by Mohanapriya 21-04-20 -->
			<input type="text" name="creditAuthDate" id="creditAuthDate" id="creditAuthDate" size="10" maxlength="10" value="<%=creditAuthDate%>"  ><img id="credit_img" name="credit_img" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('creditAuthDate');" >
		    </td>
			<td>
				<img  id="astr" src="../../eCommon/images/mandatory.gif" style="display:none;" cellspaceing="0">
			</td>
		</tr>		
		<% } %>
		<!-- Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes -->	
		<tr>
			<td colspan='2' class="label"><fmt:message key="Common.cancel.label" bundle="${common_labels}"/> 			
				<input type='checkbox' name='CancelChk' id='CancelChk' value="N" Onclick="selectCheck(this,cancel);" <%=chkValue%>  <%=strDisabled%>>
			</td>
				
			<td colspan='2'>
				<input type="button" name='scanDoc' id='scanDoc' id='scanDoc' value="Scan Document">
			</td> 			

			<td class="label" 	align="right" >
				<input type="file" name="InsImage" id="InsImage"  id="InsImage" value="" > 			
			</td>			
			<!-- Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes -->
			<td class="label" align="right" nowrap>			
			<% if(siteSpecUploadDocAll) { %>				
				<input type="button" name="addBut" id="addBut" class="button" value="Add" id="Add" onclick="if(getSize()){uploadFile_ghl(this);showImage_ghl();disableButton(this);}" /><!-- //V220728 -->				
				<input type="button" name="updateBut" id="updateBut" class="button" value="Update"  onclick="if(getSize()){uploadFile_ghl(this);showImage_ghl();disableButton(this);}" /><!-- Added V191112-Aravindh/GHL-CRF-0550 //V220728-->
			<% } else{%>
				<input type="button" name="addBut" id="addBut"  class="button"	value="Add" id="Add" onclick="uploadFile();showImage();" />
			<% }%>
				
				<input type="button" class="button"	 value="Close"  onclick="closw();" />
			</td>			
		</tr>	
</table>
 
<input type= "hidden" name="mode" id="mode"  value='<%=mode%>'>
<input type="hidden" name="dbload" id="dbload"  value="N">
<input type='hidden' id='facility_id' name='facility_id' id='facility_id'  value='<%=facilityId%>'>		
<input type='hidden' id='locale' name='locale' id='locale'  value='<%=locale%>' >
<input type='hidden' name='patient_id' id='patient_id'  id='patient_id'   value="<%=strPatientId%>" >
<input type='hidden' name='totRec' id='totRec'  value='1'>
<!-- Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes -->
<input type='hidden' name='strModuleId' id='strModuleId'  id='strModuleId'   value="<%=strModuleId%>" >
<input type='hidden' name='strfunction_id' id='strfunction_id'  id='strfunction_id'   value="<%=strFunctionId%>" >
<input type='hidden' name='smt_ind' id='smt_ind'  id='smt_ind'   value="<%=strbilling_grp_Name%>" >
<input type="hidden" name="clicked_button" id="clicked_button" id="clicked_button" value=""/>
<script>
</script>
<input type="hidden" name="checked_row" id="checked_row" id="checked_row" value="<%=checkedRow%>"/>
<!-- Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes -->
</form>
</body>
</html>
<script>
function closw(){
	 
	 const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();
}
</script>

