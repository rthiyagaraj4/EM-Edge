<!DOCTYPE html>
<html>
<head>
<title>Policy Definition</title>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<% request.setCharacterEncoding("UTF-8");%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>




<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script>
<Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<Script src='../../eBL/js/PolicyDefinition.js' language='JavaScript'></Script>
<script language='javascript'>
function focusObject() {
	document.forms[0].elements[0].focus();
}
function addOrderByCol() {
	var i = 0;
	var from = document.getElementById('orderbycols');
	if (from.options.length > 0) {
		var to = document.getElementById('orderbycolumns');
		var element = document.createElement('OPTION');
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[i])
			from.options[i].selected = true;
		i++;
	}
}
function removeOrderByCol() {
	var j = 0;
	var from = document.getElementById('orderbycolumns');
	if (from.options.length > 0) {
		var to = document.getElementById('orderbycols');
		var element = document.createElement('OPTION');
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[j])
			from.options[j].selected = true;
		j++;
	}
}
function SelectAll() {
	var i = 0;
	document.getElementById("orderbycolumns").selectedIndex = 0;
	while (i < document.getElementById("orderbycolumns").length) {
		document.getElementById("orderbycolumns").options[i].selected = true;
		i++;
	}
}
function execQuery() {
	if (document.getElementById("orderbycolumns").options.length > 0) {
		SelectAll();
		document.query_form.submit();
	} else {
		alert(getMessage('ORDERBY_NOT_BLANK', 'Common'))
	}
}

function clearPolicyFields(obj){
	obj.value = '';
}

async function billGrpLkup(billGrp_desc,billGrp_id,empty_chk)
{		
//	alert("billGrpLkup");
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

	var sql1="SELECT BLNG_GRP_ID code, SHORT_DESC description FROM BL_BLNG_GRP_LANG_VW WHERE  LANGUAGE_ID = '"+locale+"' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 1 ";
	
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

		var sql1="SELECT BLNG_GRP_ID code, SHORT_DESC description FROM BL_BLNG_GRP_LANG_VW WHERE  LANGUAGE_ID = '"+locale+"' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 1 ";
		
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
		argArray[7] = DESC_CODE;	
		
		retArray = await CommonLookup( title, argArray );
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
	}

	async function payerlkup(payer_desc,payer_code,empty_chk)
	{	
		if(empty_chk=='Y' && payer_desc.value=='')
		{
			return false;
		}
		
		var target			= document.forms[0].payer;	
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight	= "10" ;
		var dialogWidth	= "40" ;
		var features	= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc	= "";
		var title	= encodeURIComponent(getLabel("Common.Payer.label","common"));
		var locale  = document.forms[0].locale.value;
		var cust_group_code=document.forms[0].payerGrpCode.value;
		
		//var sql1="select  cust_code  code,SHORT_NAME description from ar_customer_lang_vw where language_id = '"+locale+"'   and cust_group_code = '"+cust_group_code+"' and upper(cust_code) like upper(?) and upper(long_name) like upper(?) order by 1";  //commented V190603-Dhananjay/MMS-DM-CRF-130/70600 /Start

		var sql1="select code, description from ( select  cust_code  code,SHORT_NAME description from ar_customer_lang_vw where language_id = '"+locale+"'   and cust_group_code = '"+cust_group_code+"' union select '**' code  ,'All' description  from dual  WHERE '**' != nvl( '" + cust_group_code + "', '**')) where  upper(code) like upper(?) and upper(description) like upper(?)  order by decode(description,'All','A')"; //Added V190603-Dhananjay/MMS-DM-CRF-130/70600
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
        var ret1=unescape(retArray);
			var arr=ret1.split(",");
					if(arr[1]==undefined) 
					{
						arr[0]="";	
						arr[1]="";	
					}			
		
		if(retArray != null && retArray !="")
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
	}

	async function policyLkup(policy_desc,policy_code,empty_chk)
	{		
		if(empty_chk=='Y' && policy_desc.value=='')
		{
			return false;
		}
		var locale  = document.forms[0].locale.value;			
		var facility_id  = document.forms[0].facility_id.value;			
		var target		= document.forms[0].policyType;		
		var retVal		=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features	= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("eBL.POLICY.label","BL");
		
		var cust_group_code= document.forms[0].payerGrpCode.value;
		var cust_code= document.forms[0].payerCode.value;	

		//Commented for  V190603-Dhananjay/MMS-DM-CRF-130/70600
		/*var sql1=" select a.policy_type_code code,a.short_desc description from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id='"+locale+"' "+
		" AND b.cust_group_code =  '"+cust_group_code+"'  AND (b.cust_code = '"+cust_code+"' OR b.cust_code = '**') "+
		" AND a.policy_type_code = b.policy_type_code "+
		" AND a.operating_facility_id = '"+facility_id+"'  AND UPPER (a.language_id) = UPPER ('"+locale+"') "+
		" AND upper(a.policy_type_code) like upper(?) and upper(short_desc) like upper(?) order by 1 ";*/
			
		//Added V190603-Dhananjay/MMS-DM-CRF-130/70600 /Start
		var sql1 = " select code ,description from ( select  a.policy_type_code code,a.short_desc description from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id='"+locale+"' "+            
		" AND b.cust_group_code =  '"+cust_group_code+"' AND (b.cust_code = '"+cust_code+"' OR nvl( '" + cust_code + "', '**') = '**') "+
		" AND a.policy_type_code = b.policy_type_code "+
		" AND a.operating_facility_id = '"+facility_id+"'  AND UPPER (a.language_id) = UPPER ('"+locale+"') union  select '**' code , 'All' description from dual     WHERE '****' != nvl( '" + cust_group_code + "', '****') )"+
		" where  upper(code) like upper(?) and upper(description) like upper(?)  order by decode(description,'All','A')";
		//Added V190603-Dhananjay/MMS-DM-CRF-130/70600 /End
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
		var ret1=unescape(retArray);
				var arr=ret1.split(",");
						if(arr[1]==undefined) 
						{
							arr[0]="";	
							arr[1]="";	
						}				

		if(retArray != null && retArray !="")
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
	}
	
	


</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad='focusObject()'>
<form name='query_form' id='query_form' method='post' action='../../eBL/jsp/BLInsuranceBlngLinkQueryResult.jsp' onsubmit='SelectAll()'><Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<table width='100%' align='center' cellspacing='0' cellpadding='0'>
	<tr>
		<th align='left' width='20%'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
		<tr>
			<td width='60%'>
			<p title='Query Criteria'>
			<table width='100%'>
				<tr>
			 	<td width='20%' class="label" ><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/></td>
				<td width="25%" class="fields" >
					<INPUT TYPE="TEXT"  name="billingGrp" id="billingGrp" SIZE="30"  MAXLENGTH='40'	 VALUE='' onBlur="billGrpLkup(this,document.forms[0].billingGrpCode,'Y')">
					<input type= 'hidden' name="billingGrpCode" id="billingGrpCode"  value=''>
					<input type='button' class='button' name="billingGrpBut" id="billingGrpBut" value='?' onClick="billGrpLkup(document.forms[0].billingGrp,document.forms[0].billingGrpCode)" tabindex='' >	
								 
			   </td>	
			   <td width='20%' nowrap class='label' ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
				<td width='25%' nowrap class='fields' >
					<input type='text' name='payerGroup' id='payerGroup' size='30' maxlength='40'  value='' onblur="payerGrpLkup(this,document.forms[0].payerGrpCode,'Y')"/>
					<input type='hidden' name='payerGrpCode' id='payerGrpCode' value=''>
					<input type='button' class='button' name="payerGroupBtn" id="payerGroupBtn" value='?' onClick="payerGrpLkup(document.forms[0].payerGroup,document.forms[0].payerGrpCode)" tabindex='2'>
					
				</td> 		
			 </tr>
				<tr>
					<td  width="20%" class="label" ><fmt:message key="Common.Payer.label"  bundle="${common_labels}"/></td>	
				<td  width="25%" class="fields" >
					<INPUT TYPE="TEXT"  name="payer" id="payer" SIZE="30"  MAXLENGTH='40'	 VALUE='' onBlur="payerlkup(this,document.forms[0].payerCode,'Y')"/>
					<input type= 'hidden' name="payerCode" id="payerCode"  value=''>
					<input type='button' class='button' name="payerBtn" id="payerBtn" value='?' onClick="payerlkup(document.forms[0].payer,document.forms[0].payerCode)" tabindex='2' >	
							 
				</td>
				
				<td width='20%' nowrap class='label' ><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
				<td width='25%' nowrap class='fields' >
					<input type='text' name='policyType' id='policyType' size='30' maxlength='40'  value='' onblur="policyLkup(this,document.forms[0].policyTypeCode,'Y')"/>
					<input type='hidden' name='policyTypeCode' id='policyTypeCode' value=''>
					<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?'onClick="policyLkup(document.forms[0].policyType,document.forms[0].policyTypeCode)" tabindex='2'>
					
				</td>   
				</tr>
				<tr>
					
			
				</tr>
			</table>
			</td>
		</tr>
</table>
</p>
<table width='100%' align='center'>
	<th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/>
	</td>
	<tr>
		<td width='60%'>
		<p title='Sort Order'>
		<table width='100%'>
			<td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			<td>&nbsp;</td>
			<td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
			<tr>
				<td width='45%' align='center'><select name='orderbycols' id='orderbycols'
					size='5'>					
<%-- 					<option value='hdr.BILL_GRP'><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/></option> --%>
<%-- 					<option value='hdr.CUST_CODE'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></option> --%>
<%-- 					<option value='hdr.POLICY'><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></option>		 --%>
					<option value='hdr.BLNG_GRP_ID'><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/></option>
					<option value='hdr.CUST_CODE'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></option>
					<option value='hdr.POLICY_TYPE_CODE'><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></option>					
				</select></td>
				<td align='center' width='3%'><input type='button' name='add' id='add'
					class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button' value='<----'
					onclick='removeOrderByCol()'></img></td>
				<td width='45%' align='center'><select name='orderbycolumns' id='orderbycolumns'
					size='5' multiple='true'>
<%-- 					<option value='hdr.CUST_GROUP_CODE'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></option> --%>
					<option value='hdr.CUST_GROUP_CODE'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></option>
				</select></td>
			</tr>
		</table>
		</p>
		</td>
	</tr>
</table>
<br>
<table border='0' width='100%' align='center'>
	<tr>
		<td width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button'
			onclick='execQuery()'></td>
	</tr>
</table>
<script>var exe=getLabel('Common.Execute.label','common'); document.forms[0].ExecuteQuery.value=exe;</script>
<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
</form>
</body>
</html>

