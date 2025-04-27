<!DOCTYPE html>
<%
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
1			 V211020           25504	  COMMON-ICN-0073-TF		Mohanapriya K
 */ %>
<%@ page import="java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.net.URLEncoder,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<html>

<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String)session.getAttribute("facility_id");

Connection con=null;
PreparedStatement pstmt=null;
ResultSet rst=null;


String servClass="";
String servClassCode="";
String billing_group="";
String billingGrp_code="";
String payer_group="";
String payerGrp_code="";
String payer="";			
String payer_code="";
String policy="";
String policy_code="";	

String p_facility_id="";
//String priority="";
String pat_class="";
String pat_classQuery="";
String fac_Id="";
String fac_name="";

HttpSession httpSession = request.getSession(false);


locale	= (String)session.getAttribute("LOCALE");	
p_facility_id = (String)httpSession.getValue("facility_id");

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eBL/js/BLInsAgeLimit.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>


<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>


</head>

<script language='javascript'>

function enableAppy()
{
//	alert("load apply");
parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
}

function checkForSpecChars(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function checkNumeric(obj)
{
	
	var dat = obj.value;
	
	 
	if(dat.charAt(0)=='.'  || dat.charAt(1)== '.')
		 obj.value ='';
		
if(isNaN(obj.value) == false)
	{
	if(obj.value <= 0 && obj.value != '')
	{	
		alert('Priority value should be greater then  Zero');
		obj.value = '';
		}
	}
else
	{
	obj.value='';
	obj.focus();
	}
			
}



async function billGrpLkup(billGrp_desc,billGrp_id,empty_chk)
{		
	if(empty_chk=='Y' && billGrp_desc.value=='')
	{
		return false;
	}
	var locale  = document.forms[0].locale.value;			
	var facility_id  = document.forms[0].facility_id.value;			
	var target			= document.forms[0].billingGrp;		
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("eBL.BillingGroup.label","BL");
	//46197 - Karthik added condition as Cash and Credit Billing Group should not be displayed in Setup Payer by Billing Group function 
	var sql1="SELECT BLNG_GRP_ID code, SHORT_DESC description FROM BL_BLNG_GRP_LANG_VW WHERE status is null and settlement_ind = 'X' and LANGUAGE_ID = '"+locale+"' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 1 ";
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";	
   	argArray[5] = target.value;	    
	argArray[6] = DESC_LINK;	
	argArray[7] = DESC_CODE;
	
	//alert("argArray[5]"+argArray[5]);
	
	retArray = await CommonLookup( title, argArray );
	
	if(retArray != null && retArray !="")
	{					
			var ret1=unescape(retArray);
			var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		billGrp_id.value=arr[0];
		billGrp_desc.value=arr[1];	
		//alert(""+billGrp_id.value+"/"+billGrp_desc.value);
		
	}
	else
	{
		billGrp_id.value="";
		billGrp_desc.value="";	
	}
	
}

async function payerGrpLkup(pyrGrp_desc,pyrGrp_code,empty_chk)
{		
	if(empty_chk=='Y' && pyrGrp_desc.value=='')
	{
		return false;
	}
	

	var locale  = document.forms[0].locale.value;	
	var facility_id  = document.forms[0].facility_id.value;	
	var target			= document.forms[0].payerGroup;		
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("eBL.PAYER_GROUP.label","BL");

	var sql1="select cust_group_code code,short_desc description from ar_cust_group_lang_vw  where  language_id='"+locale+"' and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 1";
	
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";		
   	argArray[5] = target.value;   
	argArray[6] = DESC_LINK;
	//alert(argArray[6]);
	argArray[7] = DESC_CODE;
	
	//alert("argArray[5]"+argArray[5]);
	
	retArray = await CommonLookup( title, argArray );
	if(retArray != null && retArray !="")
	{	
		var ret1=unescape(retArray);
		var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
		 	arr[0]="";	
		 	arr[1]="";	
		}
		pyrGrp_code.value=arr[0];
		pyrGrp_desc.value=arr[1];		
	}
	else
	{		
		pyrGrp_code.value="";
		pyrGrp_desc.value="";	
	}
	
}


async function payerlkup(payer_desc,payer_code,empty_chk)
{				
	if(empty_chk=='Y' && payer_desc.value=='')
	{
		return false;
	}
	
	var target			= document.forms[0].payer;	
	
	//alert("target.value"+target.value);
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= encodeURIComponent(getLabel("Common.Payer.label","common"));
	var locale  = document.forms[0].locale.value;

	var cust_group_code=document.forms[0].payerGrpCode.value;
//	alert("cust_group_code"+cust_group_code);
	
		var sql1="select  cust_code  code,SHORT_NAME description from ar_customer_lang_vw where language_id = '"+locale+"'   and cust_group_code = '"+cust_group_code+"' and upper(cust_code) like upper(?) and upper(long_name) like upper(?) order by 1";
		
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql1;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;					
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;

		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;
		
		retArray = await CommonLookup( title, argArray );				
		if(retArray != null && retArray !="")
		{					
			var ret1=unescape(retArray);
			var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
			payer_code.value=arr[0];
			payer_desc.value=arr[1];		
			//alert("payer"+payer_code.value+"/"+payer_desc.value);
		}
		else
		{
			
			payer_code.value="";
			payer_desc.value="";			
		}
		
	
}


async function policyLkup(policy_desc,policy_code,empty_chk)
{		

	if(empty_chk=='Y' && policy_desc.value=='')
	{
		return false;
	}
	var locale  = document.forms[0].locale.value;			
	var facility_id  = document.forms[0].facility_id.value;			
	var target			= document.forms[0].policyType;		
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("eBL.POLICY.label","BL");
	
	var cust_group_code= document.forms[0].payerGrpCode.value;
	var cust_code= document.forms[0].payerCode.value;
	
//	alert("cust_group_code/cust_code"+cust_group_code+"/"+cust_code);

//	var sql1="select policy_type_code code,short_desc description from bl_ins_policy_types_lang_vw   where  language_id='"+locale+"'  and operating_facility_id = '"+facility_id+"' and upper(policy_type_code) like upper(?) and upper(short_desc) like upper(?) order by 1";
	
	var sql1=" select a.policy_type_code code,a.short_desc description from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id='"+locale+"' "+			
			" AND b.cust_group_code =  '"+cust_group_code+"'  AND (b.cust_code = '"+cust_code+"' OR b.cust_code = '**') "+
			" AND a.policy_type_code = b.policy_type_code "+
			" AND a.operating_facility_id = '"+facility_id+"'  AND UPPER (a.language_id) = UPPER ('"+locale+"') "+
			" AND upper(a.policy_type_code) like upper(?) and upper(short_desc) like upper(?) order by 1 ";
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql1;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";	
   	argArray[5] = target.value;	
  //  alert("1");
	argArray[6] = DESC_LINK;
//	alert(argArray[6]);
	argArray[7] = DESC_CODE;		
//	alert("8");
	retArray = await CommonLookup( title, argArray );
	var ret1=unescape(retArray);
				var arr=ret1.split(",");
						if(arr[1]==undefined) 
						{
							arr[0]="";	
							arr[1]="";	
						}		
//	alert("9");

	if(retArray != null && retArray !="")
	{					
		
		policy_code.value=arr[0];
		policy_desc.value=arr[1];			
	//	alert("policy"+policy_code.value+"/"+policy_desc.value);
	}
	else
	{
		//policy_code.value="";
		//policy_desc.value="";	
		policy_code.value = arr[0]; 
		policy_desc.value = arr[1]; 
	}
	
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body  OnLoad="enableAppy();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
// mode=modify&blngGroup="+ blngGroup+"&payerGroup="+payerGroup+"&payer="+payer+"&patientClass="+patientClass+"&policyType="+policyType+"' target='f_query_add_mod' >");

String mode=request.getParameter("mode");
//out.println(mode);
//String age_group_code=checkForNull(request.getParameter("age_group_code"));

// String billingGrpCode=checkForNull(request.getParameter("billingGrpCode"));
// String payerGrpCode=checkForNull(request.getParameter("payerGrpCode"));
// String payerCode=checkForNull(request.getParameter("payerCode"));
// String policyTypeCode=checkForNull(request.getParameter("policyTypeCode"));


String billingGrpCode=checkForNull(request.getParameter("blngGroup"));
String payerGrpCode=checkForNull(request.getParameter("payerGroup"));
String payerCode=checkForNull(request.getParameter("payer"));
String policyTypeCode=checkForNull(request.getParameter("policyType"));

String patient_class=checkForNull(request.getParameter("patientClass"));
String facility=checkForNull(request.getParameter("oprFacId"));
String priority=checkForNull(request.getParameter("priorNo"));
 

String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String short_desc_disable="";
String strLongDesc="";
String status="";
String sql="";

String facilityId="";
//String facility="";

String disabled = "";
String totaldisabled = "";
String readonly="";

System.out.println("mode>>>>>>>>>"+mode);

if(mode.equals("modify"))
{
	try{
		readonly = "readonly";
		disabled = "disabled";
		totaldisabled = "disabled";	
		con=ConnectionManager.getConnection(request);
		int column_count = 1;
	//	sql = "SELECT LONG_DESC,SHORT_DESC,FROM_YEAR,FROM_MONTH,FROM_DAY,TO_YEAR,TO_MONTH,TO_DAY,NVL(status,'E') status1 FROM BL_INS_AGE_GROUP where age_group_code =? ";

	//	sql = "SELECT OPERATING_FACILITY_ID,BLNG_GRP_ID,CUST_GROUP_CODE,CUST_CODE,PATIENT_CLASS,POLICY_TYPE_CODE,PRIORITY_NO,NVL(status,'E') status1 FROM BL_PAYERS_PRIORITY_BY_BG 	WHERE BLNG_GRP_ID=? AND CUST_GROUP_CODE=? AND CUST_CODE=? AND POLICY_TYPE_CODE=? ";
		
	  sql="SELECT decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, hdr.CUST_GROUP_CODE, "+
	      "decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, hdr.CUST_CODE, "+
	      "(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id ) policy_type, "+
		  "hdr.POLICY_TYPE_CODE,hdr.PRIORITY_NO,NVL(hdr.status,'E') status1,hdr.operating_facility_id, "+
		  "(select bil.SHORT_DESC  from BL_BLNG_GRP bil where bil.BLNG_GRP_ID = hdr.BLNG_GRP_ID)bill_desc, hdr.BLNG_GRP_ID, "+
		  "hdr.PATIENT_CLASS "+
	      "FROM BL_PAYERS_PRIORITY_BY_BG hdr	WHERE BLNG_GRP_ID=? AND CUST_GROUP_CODE=? "+
	      "AND OPERATING_FACILITY_ID=? AND PATIENT_CLASS=? ";
	  
	  if("".equals(payerCode)){
		  sql+=" AND CUST_CODE IS NULL ";
	  }
	  else{
		  sql+=" AND CUST_CODE =? ";
	  }
	  if("".equals(policyTypeCode)){
		  sql+=" AND POLICY_TYPE_CODE IS NULL ";
	  }
	  else{
		  sql+=" AND POLICY_TYPE_CODE =? ";
	  }
	  if("".equals(priority)){
		  sql+=" AND PRIORITY_NO IS NULL ";
	  }
	  else{
		  sql+=" AND PRIORITY_NO =? ";
	  }
	      
		pstmt=con.prepareStatement(sql);

		//pstmt.setString(1,age_group_code);
		System.out.println("billingGrpCode/payerGrpCode/payerCode/policyTypeCode/facility/patient_class/priority "+billingGrpCode+"/"+payerGrpCode+"/"+payerCode+"/"+policyTypeCode+"/"+facility+"/"+patient_class+"/"+priority);
		
		pstmt.setString(column_count, billingGrpCode);
		pstmt.setString(++column_count, payerGrpCode);
		pstmt.setString(++column_count, facility);
		pstmt.setString(++column_count, patient_class);
		
		 if(!"".equals(payerCode)){
			pstmt.setString(++column_count, payerCode);
		 }
		 if(!"".equals(policyTypeCode)){
			pstmt.setString(++column_count, policyTypeCode);
		 }
		 if(!"".equals(priority)){
			pstmt.setString(++column_count, priority);
		 }

		rst = pstmt.executeQuery();
		if(rst!=null && rst.next())
		{   			
			System.out.println("result set not null");			
	
			
			facility=rst.getString("operating_facility_id");
			billing_group=rst.getString("bill_desc");		
			billingGrp_code=rst.getString("BLNG_GRP_ID");		
			payer_group= rst.getString("payer_group");  
			payerGrp_code=rst.getString("CUST_GROUP_CODE");  

			payer= rst.getString("payer");  
			if (payer==null)		payer="";

			payer_code=rst.getString("CUST_CODE");
			policy_code =rst.getString("POLICY_TYPE_CODE");	
			policy=rst.getString("policy_type");
			if (policy==null)		policy="";
			
			pat_class = rst.getString("PATIENT_CLASS");	

			priority=rst.getString("PRIORITY_NO");	
			if (priority==null)		priority="";

			status=rst.getString("status1");
			
			
			System.out.println("policy/policy_code/facility>>>>>> "+policy+"/"+policy_code+"/"+facility);	
			System.out.println("payer_group/payerGrp_code>>>>>> "+payer_group+"/"+payerGrp_code);	
			System.out.println("payer/payer_code>>>>>> "+payer+"/"+payer_code);				
			
			
		}
		if(status.equals("E"))
		{
			System.out.println("status E");
			chk_checked="checked";
			disable_flag="";
		}
		else
		{
			System.out.println("ELSE PART ");
			chk_checked="";
			disable_flag="readonly onfocus='this.blur()'";
			chk_value="D";
		}
		
	short_desc_disable="disabled";	

}catch(Exception e)
	{
	System.out.println("Exception is "+e);
	e.printStackTrace();
		}
		finally{
			try{
			if(pstmt!=null) pstmt.close();
			if(rst!=null)rst.close();
			
		}catch(Exception e)
			{
			out.println("Exception is "+e);
			}
		
		}
}

%>
	
<form name="Insurance_BlngLinkForm" id="Insurance_BlngLinkForm"  onload='FocusFirstElement();'  action="../../servlet/eBL.BLInsuranceBlngLinkServlet" method="post" target="messageFrame">  
<br><br><br><br><br><br>
<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
			<tr >
				<th  class="columnheader" align='left'><fmt:message key="eBL.POLICY_DTL.label" bundle="${bl_labels}"/></th>
			</tr>	
</TABLE>	
<table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>
										
			
      		<tr>
      			<td width='20%'  nowrap class='label'>
      				<fmt:message key="Common.facility.label" bundle="${common_labels}"></fmt:message>
      			</td>
      			<td colspan='2' nowrap class='fields'>
      				<select name='facility' id='facility' id='facility' <%=disabled %> >

							<%
							try{
							String sqlFacility = "select facility_id, facility_name from Sm_Facility_Param where status = 'E' and facility_id = ? ";
							con = ConnectionManager.getConnection(request);
							pstmt = con.prepareStatement(sqlFacility);
							pstmt.setString(1,facility_id);
							rst = pstmt.executeQuery();

							
							if(rst != null){
								while(rst.next()){ 
									fac_Id=rst.getString("facility_id");
									fac_name=rst.getString("facility_name");
							%>
								
									<option value='<%=fac_Id %>'><%=fac_name %></option>
							<%
								
							}
							}
							}catch(Exception e) {
								System.out.println("currency="+e.toString());
								}
							finally{
							rst.close(); 
							pstmt.close();							
							}
						%>
						</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
      			</td>		
			 </tr>

			<tr>
			 	<td width='20%' class="label" ><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/></td>
				<td width="25%" class="fields" >
					<INPUT TYPE="TEXT"  name="billingGrp" id="billingGrp" SIZE="30"  MAXLENGTH='40'	 <%=disabled %>  VALUE="<%=billing_group%>" onBlur="billGrpLkup(this,document.forms[0].billingGrpCode,'Y')">
					<input type= 'hidden' name="billingGrpCode" id="billingGrpCode"  value="<%=billingGrp_code%>">
					<input type='button' class='button' name="billingGrpBut" id="billingGrpBut" value='?'  <%=disabled %> onClick="billGrpLkup(document.forms[0].billingGrp,document.forms[0].billingGrpCode)" tabindex='' >	
					<img src='../../eCommon/images/mandatory.gif'>			 
			   </td>		
			 </tr>

			 <tr>
			 	<td width='20%' nowrap class='label' ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
				<td width='25%' nowrap class='fields' >
					<input type='text' name='payerGroup' id='payerGroup' size='30' maxlength='40'   <%=disabled %>  value="<%=payer_group %>" onblur="payerGrpLkup(this,document.forms[0].payerGrpCode,'Y')"/>
					<input type='hidden' name='payerGrpCode' id='payerGrpCode' value='<%=payerGrp_code %>''>
					<input type='button' class='button' name="payerGroupBtn" id="payerGroupBtn" value='?'  <%=disabled %> onClick="payerGrpLkup(document.forms[0].payerGroup,document.forms[0].payerGrpCode)" tabindex='2'>
					<img src='../../eCommon/images/mandatory.gif'>
				</td> 	
			</tr>	
					 
			 <tr>						
				<td  width="20%" class="label" ><fmt:message key="Common.Payer.label"  bundle="${common_labels}"/></td>	
				<td  width="25%" class="fields" >
					<INPUT TYPE="TEXT"  name="payer" id="payer" SIZE="30"  MAXLENGTH='40'	 <%=disabled %>  VALUE="<%=payer%>" onBlur="payerlkup(this,document.forms[0].payerCode,'Y')"/>
					<input type= 'hidden' name="payerCode" id="payerCode"  value="<%=payer_code%>">
					<input type='button' class='button' name="payerBtn" id="payerBtn" value='?'  <%=disabled %> onClick="payerlkup(document.forms[0].payer,document.forms[0].payerCode)" tabindex='2' >									 
				</td>
			</tr>
			
			 <tr>
					   <td width='25%'  class='label'><fmt:message key="eBL.PatientClass.label" bundle="${bl_labels}"/></td>	
			   	<td width='25%'>
				<Select id="patient_class" name="patient_class" id="patient_class" <%=disabled %>>
			<%	
			try{		
				pstmt = con.prepareStatement( " SELECT  PATIENT_CLASS,SHORT_DESC  FROM AM_PATIENT_CLASS");
				rst = pstmt.executeQuery();	
				System.out.println("RESULT SET :"+rst);			
				
				
			while(rst.next())
			{				
			//	String patientClass  =  rst.getString(1);
				 pat_classQuery  =  rst.getString(1);
			//	pat_class=!patientClass.substring(0, 1).equalsIgnoreCase("X")?patientClass.substring(0, 1):"R";
				String patClassShortDesc  =  rst.getString(2);						
				
				out.println("Inside while loop >> patClassShortDesc :"+patClassShortDesc);

				%>
				<%if(pat_classQuery.equals(pat_class)){ %>
					<option value="<%=pat_classQuery%>" selected><%= patClassShortDesc %></option>
				<%}else{ %>
					<option value="<%=pat_classQuery%>"><%= patClassShortDesc %></option>
				<%} %>
				
			<% out.println("short desc >> patClassShortDesc :"+patClassShortDesc.substring(0, 2)); %>
			<%
			}
			}catch(Exception e) {
				System.out.println("currency="+e.toString());
				}
			finally{
			rst.close(); 
			pstmt.close();
			if(con!=null) {
				ConnectionManager.returnConnection(con, request);
			}
			}
			%>					  		
				</select>
				<img src='../../eCommon/images/mandatory.gif'>
				</td>	
			</tr>			
			
			<tr>
				<td width='20%' nowrap class='label' ><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
				<td width='25%' nowrap class='fields' >
					<input type='text' name='policyType' id='policyType' size='30' maxlength='40'  <%=disabled %>  value='<%= policy %>' onblur="policyLkup(this,document.forms[0].policyTypeCode,'Y')"/>
					<input type='hidden' name='policyTypeCode' id='policyTypeCode' value='<%=policy_code%>'>
					<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?' <%=disabled %> onClick="policyLkup(document.forms[0].policyType,document.forms[0].policyTypeCode)" tabindex='2'>
				</td>   
			</tr>
			
			<tr>
				<td width='20%' nowrap class='label' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
				<td width='25%' nowrap class='fields' >
					<input type='text' name='priority' id='priority'  size='30' maxlength='2'  value='<%= priority %>'  <%=disabled %> onblur ="checkNumeric(this);" onkeypress="return checkForSpecChars(event);" />
				</td>  			
				
			</tr>
			
<!-- 			<tr -->
<!-- 			<td class="fields" width="5%"><input type='checkbox' name='enabledYN' id='enabledYN' id='enabledYN' checked> -->
<%-- 			<fmt:message key="eBL.Status.label"  bundle="${bl_labels}"/></td>		 --%>
<!-- 			</tr> -->

			<tr>
				<td class=label >
					<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
				</td>
				<td class='fields'>
				<%
				if(!(mode.equals("modify")))	  chk_checked = "checked   readonly";
				%>
					<input type="checkbox" name="status" id="status" onClick='setCheckValue();'  <%=chk_checked%> >
					
					
						
				</td>
			</tr>
		</table>


<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<%-- <input type='hidden' name=age_group_code1 id=age_group_code1 value="<%=age_group_code%>"> --%>
<%-- <input type='hidden' name=long_desc1 id=long_desc1 value="<%=strLongDesc%>"> --%>
<input type='hidden' name='patClass_hid' id='patClass_hid' value="<%=pat_class%>">
<input type='hidden' name='facId_hid' id='facId_hid' value="<%=fac_Id%>">
<input type='hidden' name='prior_hid' id='prior_hid' value="<%=priority%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type= hidden name="facility_id" id="facility_id"  value="<%=p_facility_id %>">
</form>
</body>
</html>


