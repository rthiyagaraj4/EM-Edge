<!DOCTYPE html>
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
String drugCode = "";
String drugDesc = "";
String calledFrm = "";

String p_facility_id="", strloggeduser = "", strclientip = "";

String pat_classQuery="";
String fac_Id="";
String fac_name="";

HttpSession httpSession = request.getSession(false);
Properties p = (Properties)httpSession.getValue("jdbc");


locale	= (String)session.getAttribute("LOCALE");	
p_facility_id = (String)httpSession.getValue("facility_id");

strloggeduser	=  (String) session.getValue("login_user");	
if (strloggeduser==null) strloggeduser = "";

strclientip = p.getProperty("client_ip_address");
if (strclientip==null) strclientip = "";

String OpYn				=	checkForNull("","N");
String EmYn				=	checkForNull("","N");
String IpYn				=	checkForNull("","N");
String DcYn				=	checkForNull("","N");
String AllYn			=   checkForNull("","N");
String enableEpiType	=   "enabled";

calledFrm = request.getParameter("calledFrm");
if(calledFrm == null) calledFrm = "";

session.removeAttribute("sel_drug_list");
System.err.println("sel_drug_list from session:"+session.getAttribute("sel_drug_list"));
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLInsuranceApprDrugs.js"></script>

</head>

<script language='javascript'>

function enableAppy()
{
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
		billGrp_id.value = '';
		return false;
	}

	var locale  = document.forms[0].locale.value;	
	var facility_id  = document.forms[0].facility_id.value;	
	var target			= document.forms[0].billingGrp;		
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("eBL.BillingGroup.label","BL");

	var sql1 = "select code, description from (SELECT SHORT_DESC description, BLNG_GRP_ID code FROM BL_BLNG_GRP_LANG_VW where status is null and " +
                " settlement_ind = 'X' AND upper(language_id) = upper('" + locale + "') union Select 'All Billing Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
	
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = sql1;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";		
   	argumentArray[5] = target.value;   
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retArray = await CommonLookup( title, argumentArray );		
	var ret1=unescape(retArray);
		var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}	
	if(retArray != null && retArray !="")
	{
		billGrp_id.value=arr[0];
		billGrp_desc.value=arr[1];		
	}
	else
	{
		//billGrp_id.value="";
		//billGrp_desc.value="";	
		billGrp_id.value = arr[0]; 
		billGrp_desc.value = arr[1];
	}	
	ChkForRecordAvail();
}

async function payerGrpLkup(pyrGrp_desc,pyrGrp_code,empty_chk)
{		
	if(empty_chk=='Y' && pyrGrp_desc.value=='')
	{
		pyrGrp_code.value = '';
		return false;
	}
	
	var chkForMandFields1 = chkForMandFields('PG');
	
	if(!chkForMandFields1)
		return false;

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

	var sql1 = "select code, description from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and " +
                "cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw " +
                "where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) " +
                "And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) " +
                " order by 2";
	
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = sql1;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";		
   	argumentArray[5] = target.value;   
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retArray = await CommonLookup( title, argumentArray );		
	var ret1=unescape(retArray);
		var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray !="")
	{
		pyrGrp_code.value=arr[0];
		pyrGrp_desc.value=arr[1];		
	}
	else
	{
		//pyrGrp_code.value="";
		//pyrGrp_desc.value="";	
		pyrGrp_code.value = arr[0]; 
		pyrGrp_desc.value = arr[1];
	}	
	ChkForRecordAvail();
}

async function payerlkup(payer_desc,payer_code,empty_chk)
{			
	if(empty_chk=='Y' && payer_desc.value=='')
	{
		payer_code.value = '';
		return false;
	}
	
	var chkForMandFields1 = chkForMandFields('P');
	
	if(!chkForMandFields1)
		return false;	
	
	var target			= document.forms[0].payer;	
	var locale  = document.forms[0].locale.value;	
	var facility_id  = document.forms[0].facility_id.value;		

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
	
	var sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
	"Where Cust_Code In ( SELECT cust_code " +
	"FROM bl_cust_by_cust_group " +
	"WHERE cust_group_code = " +
	"DECODE ('" +
	cust_group_code +
	"', " +
	"'**', cust_group_code, '" +
	cust_group_code +
	"')) " +
	"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
	facility_id +
	"') " +
	"and nvl(patient_flag,'N')  ='Y' " +
	"and nvl(pat_com_flag,'N')='N' " +
	"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
	"and upper(language_id) = upper('" +
	locale +
	"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";

	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	var returnedValues = await CommonLookup(title, argumentArray);	
	var ret1=unescape(retArray);
			var arr=ret1.split(",");
					if(arr[1]==undefined) 
					{
						arr[0]="";	
						arr[1]="";	
					}	
	
	if(returnedValues != null && returnedValues !="")
	{
		payer_code.value=arr[0];
		payer_desc.value=arr[1];		
	}
	else
	{	
		//payer_code.value="";
		//payer_desc.value="";	
		payer_code.value = arr[0]; 
		payer_desc.value = arr[1]; 
	}
	
	ChkForRecordAvail();
}

async function policyLkup(policy_desc,policy_code,empty_chk)
{		
	if(empty_chk=='Y' && policy_desc.value=='')
	{
		policy_code.value = '';
		return false;
	}
	
	var chkForMandFields1 = chkForMandFields('PL');
	
	if(!chkForMandFields1)
		return false;
	
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
	
	var sql="SELECT description,code from ( select a.long_desc description, a.policy_type_code code from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id='"+locale+		  "' AND (b.cust_group_code =  '"+cust_group_code+"' OR b.cust_group_code = '**') AND (b.cust_code = '"+cust_code+"' OR b.cust_code = '**') "+
			" AND a.policy_type_code = b.policy_type_code "+
			" AND a.operating_facility_id = '"+facility_id+"'  AND UPPER (a.language_id) = UPPER ('"+locale+"') "+
			" union  Select 'All Policy','**' From Dual)" +
			" WHERE upper(description) like upper(?) and upper(code) like upper(?) order by 2 ";
			
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = target.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    var returnedValues =await  CommonLookup(title, argumentArray);
	var ret1=unescape(returnedValues);
				var arr=ret1.split(",");
						if(arr[1]==undefined) 
						{
							arr[0]="";	
							arr[1]="";	
						}
    if ((returnedValues != null) && (returnedValues != ""))
	{
		policy_code.value=arr[0];
		policy_desc.value=arr[1];			
	}
	else
	{
		//policy_code.value="";
		//policy_desc.value="";	
		policy_code.value = arr[0]; 
		policy_desc.value = arr[1]; 
	}	
	
	ChkForRecordAvail();
}

function ChkForRecordAvail(){
	var facilityID = document.forms[0].facilityID.value;
	var billingGrpID = document.forms[0].billingGrpCode.value;
	var payerGroupCode = document.forms[0].payerGrpCode.value;
	var payerCode = document.forms[0].payerCode.value;
	var policyTypeCode = document.forms[0].policyTypeCode.value;
	
	if(facilityID != "" && billingGrpID != "" && payerGroupCode != "" && payerCode != "" && policyTypeCode != ""){
		var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ChkForRecordAvail&facilityID="+facilityID+"&billingGrpID="+billingGrpID+"&payerGroupCode="+payerGroupCode+"&payerCode="+payerCode+"&policyTypeCode="+policyTypeCode;

		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send();
	
		var retVal = trimString(xmlHttp.responseText);

		if(retVal == "Y"){
			alert(getMessage("CODE_ALREADY_EXISTS","common"));
			
			document.forms[0].billingGrp.value = "";
			document.forms[0].billingGrpCode.value = "";			
			document.forms[0].payerGroup.value = "";
			document.forms[0].payerGrpCode.value = "";			
			document.forms[0].payer.value = "";
			document.forms[0].payerCode.value = "";			
			document.forms[0].policyType.value = "";
			document.forms[0].policyTypeCode.value = "";
			document.forms[0].billingGrp.focus();
		}
	}	
}

async function drugLkup(drug_desc,drug_code,empty_chk)
{		
	if(empty_chk=='Y' && drug_desc.value=='')
	{
		var clickedTab = "";
		var qry_string = "clickedTab="+clickedTab+"&mode=1";	
		parent.ApprovedDrugsFrame.location.href = "../../eBL/jsp/BLInsuranceApprDrugsApproval.jsp?"+qry_string;
		
		drug_code.value = '';
		return false;
	}
	
	var chkForMandFields1 = chkForMandFields('D');
	
	if(!chkForMandFields1)
		return false;
	
	var locale  = document.forms[0].locale.value;			
	var facility_id  = document.forms[0].facility_id.value;			
	var target			= document.forms[0].drugDesc;		
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= getLabel("Common.item.label", "common");
	
	var cust_group_code= document.forms[0].payerGrpCode.value;
	var cust_code= document.forms[0].payerCode.value;
										
	var sql="SELECT description,code from ( select DRUG_DESC description, item_code code from ph_drug_lang_vw where language_id='"+locale+"' AND DRUG_YN='Y'" +
		    " union  Select 'All Drugs','**' From Dual)" +
			" WHERE upper(description) like upper(?) and upper(code) like upper(?) order by 2 ";										

	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = target.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;	
	
	var retArray = await CommonLookup(title, argumentArray);
	var ret1=unescape(retArray);
				var arr=ret1.split(",");
						if(arr[1]==undefined) 
						{
							arr[0]="";	
							arr[1]="";	
						}	

	if(retArray != null && retArray !="")
	{
		drug_code.value=arr[0];
		drug_desc.value=arr[1];			
		var row = "";
		
		loadInsApprovedDrugsSelDrug(drug_code.value, drug_desc.value);
	}
	else
	{
		//drug_code.value="";
		//drug_desc.value="";
		drug_code.value = arr[0]; 
		drug_desc.value = arr[1]; 
	}	
}

function loadInsApprovedDrugsList(calledFrm){
	var clickedTab = "SEARCH";
	var mode = document.forms[0].mode.value;
	var billingGrp = document.forms[0].billingGrpCode.value;
	var payerGroup = document.forms[0].payerGrpCode.value;
	var payer = document.forms[0].payerCode.value;
	var policyType = document.forms[0].policyTypeCode.value;		
	
	var qry_string = "clickedTab="+clickedTab+"&mode="+mode+"&billingGrp="+billingGrp+"&payerGroup="+payerGroup+"&payer="+payer+"&policyType="+policyType+"&calledFrm="+calledFrm;		

	parent.ApprovedDrugsFrame.location.href = "../../eBL/jsp/BLInsuranceApprDrugsApproval.jsp?"+qry_string;
}

	
function chkForMandFields(called_frm){
	var billingGrp = document.forms[0].billingGrp.value;
	var payerGroup = document.forms[0].payerGroup.value;
	var payer = document.forms[0].payer.value;
	var policyType = document.forms[0].policyType.value;
	var drugDesc = document.forms[0].drugDesc.value;
	
	if(called_frm == "PG"){
		if(billingGrp == ""){
			alert(getMessage("BL9301","BL"));
			document.forms[0].billingGrp.focus();
			document.forms[0].payerGroup.value = "";
			document.forms[0].payerGrpCode.value = "";
			return false;
		}
	}
	
	if(called_frm == "P"){
		if(billingGrp == ""){
			alert(getMessage("BL9301","BL"));
			document.forms[0].billingGrp.focus();
			document.forms[0].payer.value = "";
			document.forms[0].payerCode.value = "";
			return false;
		}
		
		if(payerGroup == ""){
			alert(getMessage("BL6277","BL"));
			document.forms[0].payerGroup.focus();
			document.forms[0].payer.value = "";
			document.forms[0].payerCode.value = "";
			return false;
		}		
	}	

	if(called_frm == "PL"){
		if(billingGrp == ""){
			alert(getMessage("BL9301","BL"));
			document.forms[0].billingGrp.focus();
			document.forms[0].policyType.value = "";
			document.forms[0].policyTypeCode.value = "";
			return false;
		}
		
		if(payerGroup == ""){
			alert(getMessage("BL6277","BL"));
			document.forms[0].payerGroup.focus();
			document.forms[0].policyType.value = "";
			document.forms[0].policyTypeCode.value = "";
			return false;
		}

		if(payer == ""){
			alert(getMessage("BL0746","BL"));
			document.forms[0].payer.focus();
			document.forms[0].policyType.value = "";
			document.forms[0].policyTypeCode.value = "";
			return false;
		}
	}		
	
	if(called_frm == "D"){
		if(billingGrp == ""){
			alert(getMessage("BL9301","BL"));
			document.forms[0].billingGrp.focus();
			document.forms[0].drugDesc.value = "";
			document.forms[0].drugCode.value = "";
			return false;
		}
		
		if(payerGroup == ""){
			alert(getMessage("BL6277","BL"));
			document.forms[0].payerGroup.focus();
			document.forms[0].drugDesc.value = "";
			document.forms[0].drugCode.value = "";
			return false;
		}

		if(payer == ""){
			alert(getMessage("BL0746","BL"));
			document.forms[0].payer.focus();
			document.forms[0].drugDesc.value = "";
			document.forms[0].drugCode.value = "";
			return false;
		}
		
		if(policyType == ""){
			alert(getMessage("BL9103","BL"));
			document.forms[0].policyType.focus();
			document.forms[0].drugDesc.value = "";
			document.forms[0].drugCode.value = "";
			return false;
		}		
	}
	
	return true;	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body  OnLoad="enableAppy();loadInsApprovedDrugsList('<%=calledFrm%>');" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<%
try
{
	con=ConnectionManager.getConnection(request);
	String mode=request.getParameter("mode");

	String billingGrpCode=checkForNull(request.getParameter("blngGroup"));
	String payerGrpCode=checkForNull(request.getParameter("payerGroup"));
	String payerCode=checkForNull(request.getParameter("payer"));
	String policyTypeCode=checkForNull(request.getParameter("policyType"));

	String patient_class=checkForNull(request.getParameter("patientClass"));
	String facility=checkForNull(request.getParameter("oprFacId"));
	 
	String strLongDesc="";
	String status="";
	String sql="";

	String disabled = "";

	System.err.println("mode>>>>>>>>>"+mode);

	if(mode.equals("modify"))
	{
		try
		{
			disabled = "disabled";			
			int column_count = 1;
			sql="SELECT decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, hdr.CUST_GROUP_CODE, "+
	        "decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, hdr.CUST_CODE, "+
	        "decode(hdr.policy_type_code,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )) policy_type, "+
		    "hdr.POLICY_TYPE_CODE,hdr.operating_facility_id, "+
		    "decode(hdr.BLNG_GRP_ID,'**','All Billing Group',(select bil.SHORT_DESC  from BL_BLNG_GRP bil where bil.BLNG_GRP_ID = hdr.BLNG_GRP_ID)) bill_desc, hdr.BLNG_GRP_ID "+
	        "FROM BL_PH_DRUG_AGREEMENT hdr	WHERE BLNG_GRP_ID=? AND CUST_GROUP_CODE=? "+
	        "AND OPERATING_FACILITY_ID=? ";
	  
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
			System.err.println("sql in modify:"+sql);
			
			pstmt=con.prepareStatement(sql);

			System.err.println("billingGrpCode/payerGrpCode/payerCode/policyTypeCode/facility "+billingGrpCode+"/"+payerGrpCode+"/"+payerCode+"/"+policyTypeCode+"/"+facility);
			/* Fixed SQL Injection for Common-ICN-0222 */
			pstmt.setString(column_count, billingGrpCode);
			pstmt.setString(++column_count, payerGrpCode);
			pstmt.setString(++column_count, facility);
			if(!"".equals(payerCode)){
				pstmt.setString(++column_count, payerCode);
			}
			if(!"".equals(policyTypeCode)){
				pstmt.setString(++column_count, policyTypeCode);
			}

			rst = pstmt.executeQuery();
			if(rst!=null && rst.next())
			{   			
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
			}
		}catch(Exception e)
		{
			//System.out.println("Exception is "+e);
			e.printStackTrace();
		}
	}
%>
	
	<form name="Insurance_BlngLinkForm" id="Insurance_BlngLinkForm">  
	<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
		<tr>
			<td  class="columnheader" >Insurance Approved Drugs</td>
		</tr>	
	</TABLE>	
	<table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>		
		<tr>
			<td width='20%'  nowrap class='label'>
				<fmt:message key="Common.facility.label" bundle="${common_labels}"></fmt:message>
			</td>
			<td colspan='2' nowrap class='fields'>
				<select name='facilityID' id='facilityID' id='facilityID' <%=disabled %> >
			<%
				try
				{
					String sqlFacility = "select facility_id, facility_name from sm_facility_param_lang_vw where status = 'E' and language_id = ? and facility_id = ?";
					pstmt = con.prepareStatement(sqlFacility);
					pstmt.setString(1,locale);
					pstmt.setString(2,facility_id);
					rst = pstmt.executeQuery();

					if(rst != null){
						while(rst.next()){ 
							fac_Id=rst.getString("facility_id");
							fac_name=rst.getString("facility_name");
			%>
					<option value='<%=fac_Id %>' <%=fac_Id.equals(p_facility_id) ? "selected" : ""%>><%=fac_name %></option>
			<%
						}
					}
				}catch(Exception e) 
				{
					System.err.println("facility list="+e.toString());
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
				<input type='button' class='button' name="billingGrpBut" id="billingGrpBut" value='?'  <%=disabled %> onClick="billGrpLkup(document.forms[0].billingGrp,document.forms[0].billingGrpCode)" tabindex='2' >	
				<img src='../../eCommon/images/mandatory.gif'>			 
			</td>
		</tr>

		<tr>
			<td width='20%' nowrap class='label' ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
			<td width='25%' nowrap class='fields' >
				<input type='text' name='payerGroup' id='payerGroup' size='30' maxlength='40'   <%=disabled %>  value="<%=payer_group %>" onblur="payerGrpLkup(this,document.forms[0].payerGrpCode,'Y')"/>
				<input type='hidden' name='payerGrpCode' id='payerGrpCode' value='<%=payerGrp_code %>'>
				<input type='button' class='button' name="payerGroupBtn" id="payerGroupBtn" value='?'  <%=disabled %> onClick="payerGrpLkup(document.forms[0].payerGroup,document.forms[0].payerGrpCode)" tabindex='2'>
				<img src='../../eCommon/images/mandatory.gif'>
			</td> 	
		</tr>	

		<tr>						
			<td  width="20%" class="label" ><fmt:message key="Common.Payer.label"  bundle="${common_labels}"/></td>	
			<td  width="25%" class="fields" >
				<INPUT TYPE="TEXT"  name="payer" id="payer" SIZE="30"  MAXLENGTH='40'	 <%=disabled %>  VALUE="<%=payer%>" onBlur="payerlkup(this,document.forms[0].payerCode,'Y')"/>
				<input type= 'hidden' name="payerCode" id="payerCode"  value="<%=payer_code%>">
				<input type='button' class='button' name="payerBtn" id="payerBtn" value='?'  <%=disabled %> onClick="payerlkup(document.forms[0].payer,document.forms[0].payerCode)" tabindex='2'>
				<img src='../../eCommon/images/mandatory.gif'>
			</td>
		</tr>

		<tr>
			<td width='20%' nowrap class='label' ><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
			<td width='25%' nowrap class='fields' >
				<input type='text' name='policyType' id='policyType' size='30' maxlength='40'  <%=disabled %>  value='<%= policy %>' onblur="policyLkup(this,document.forms[0].policyTypeCode,'Y')"/>
				<input type='hidden' name='policyTypeCode' id='policyTypeCode' value='<%=policy_code%>'>
				<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?' <%=disabled %> onClick="policyLkup(document.forms[0].policyType,document.forms[0].policyTypeCode)" tabindex='2'>
				<img src='../../eCommon/images/mandatory.gif'>
			</td>   
		</tr>

		<tr>
			<td width='20%' nowrap class='label' ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
			<td width='25%' nowrap class='fields' >
				<input type='text' name='drugDesc' id='drugDesc' size='30' maxlength='40' value='<%= drugDesc %>' onblur="drugLkup(this,document.forms[0].drugCode,'Y')"/>
				<input type='hidden' name='drugCode' id='drugCode' value='<%=drugCode%>'>
				<input type='button' class='button' name="drug_btn" id="drug_btn" value='?' onClick="drugLkup(document.forms[0].drugDesc,document.forms[0].drugCode)" tabindex='2'>
			</td>   
		</tr>			
		<tr>
			<td  class="columnheader" colspan=2>&nbsp;</td>
		</tr>			
	</table>
	<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name="facility_id" id="facility_id"  value="<%=p_facility_id %>">
	<input type='hidden' name="facility" id="facility"  value="<%=p_facility_id %>">
	<input type='hidden' name="strloggeduser" id="strloggeduser"  value="<%=strloggeduser %>">
	<input type='hidden' name="strclientip" id="strclientip"  value="<%=strclientip %>">
</form>
<%
} catch(Exception e) {
	System.err.println("Exception in BLInsuranceApprDrugsAddModify.jsp ->"+e.toString());
}
finally
{
	if(pstmt!=null) pstmt.close();
	if(rst!=null)rst.close();						
	ConnectionManager.returnConnection(con, request);	
}
%>
</body>

</html>

