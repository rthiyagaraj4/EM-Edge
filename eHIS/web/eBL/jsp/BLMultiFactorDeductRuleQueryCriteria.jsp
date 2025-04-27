<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230210								MMS-DM-CRF-0209.5			Namrata Charate
*/ %>
<html>
<head>
<title>Policy Definition</title>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@page import="webbeans.eCommon.ConnectionManager"%>
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
<Script src='../../eBL/js/BLMultiFactorDeductRule.js' language='JavaScript'></Script>
<script language="JavaScript">
function focusObject() {
	document.forms[0].elements[0].focus();
}

//V221113
async function callCommonValidation(sqlSelect, obj, code) {
	//alert("12");
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    switch (sqlSelect) {
        case 1:
            {
                var payer_group_code = document.forms[0].payerCode2.value;
				
				sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
                "Where Cust_Code In ( SELECT cust_code " +
                "FROM bl_cust_by_cust_group " +
                "WHERE cust_group_code = " +
                "DECODE ('" +
                payer_group_code +
                "', " +
                "'**', cust_group_code, '" +
                payer_group_code +
                "')) " +
                "and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' " +
                "and nvl(pat_com_flag,'N')='N' " +
                "And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
                "and upper(language_id) = upper('" +
                locale +
                "') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

				
                title = 'Payer';
                break;
            }
        case 2:
            {
                sql = "select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and " +
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

                title = 'Payer Group';
                break;
            }
        case 3:
			{
				var cust_group_code= document.forms[0].payerCode2.value;
				var cust_code= document.forms[0].payerCode.value;
	
                sql = "Select description,code from ( select a.long_desc description, a.policy_type_code code from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b"+
				" where  language_id='"+locale+"' AND (b.cust_group_code =  '"+cust_group_code+"' OR b.cust_group_code = '**')" +
				" AND (b.cust_code = '"+cust_code+"' OR b.cust_code = '**') "+
				" AND a.policy_type_code = b.policy_type_code "+
				" AND a.operating_facility_id = '"+facility_id+"'  AND UPPER (a.language_id) = UPPER ('"+locale+"') "+
				" union  Select 'All Policy','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) order by 1 ";
						
				title = 'Policy';
                break;
            }
    }
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = await CommonLookup(title, argumentArray);
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = arr[1];
        code.value = arr[0];
    } else {
        obj.value = arr[1];
        code.value = arr[0];
    }
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

function fnEnableDisableMFDR(obj, cat_lbl, drugCat_lbl, diagCat_lbl, clinicCat_lbl) {
	
	var destBox1 = document.getElementById(cat_lbl);
    var destBox2 = document.getElementById(drugCat_lbl);
    var destBox3 = document.getElementById(diagCat_lbl);
	var destBox4 = document.getElementById(clinicCat_lbl);  //V230210
	if (obj.value == 'DrugCat') {
		
    	destBox1.style.display = "block";
        destBox2.style.display = "block";
        destBox3.style.display = "none";
		destBox4.style.display = "none";  //V230210
		destBox2.value = "";
    	destBox3.value = "";
        destBox4.value = "";   //V230210
		
    } else if(obj.value == 'DiagCat'){
    	
    	destBox1.style.display = "block";
		destBox2.style.display = "none";
		destBox3.style.display = "block";
		destBox4.style.display = "none"; //V230210
		destBox2.value = "";
    	destBox3.value = "";
        destBox4.value = "";  //V230210
    } /* V230210 starts */
    else if(obj.value == 'ServicesandItemCat'){
    	
    	destBox1.style.display = "block";
    	destBox2.style.display = "none";
    	destBox3.style.display = "none";
		destBox4.style.display = "block";
		destBox2.value = "";
    	destBox3.value = "";
        destBox4.value = "";
    }  /* V230210 ends */ 
    else{
		destBox2.value = "";
    	destBox3.value = "";
        destBox4.value = "";		
    	destBox1.style.display = "none";
        destBox2.style.display = "none";
        destBox3.style.display = "none";
		destBox4.style.display = "none"; //V230210
		
    }
	
	
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<style>
.criteria{
position:fixed;
}
</style>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad='focusObject();fnEnableDisableMFDR(document.forms[0].category,"cat","drug_category","diag_category","clinic_category");'>
<%
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
String drugCatTab_YN = "N";
String diagCatTab_YN = "N";
String servicesAndItemsCatTab_YN = "N";  //V230210
String show_drug_cat = "";
String show_diag_cat = "";
String show_servicesAndItems_cat = "";

try{
	con = ConnectionManager.getConnection(request);
	
	String qry_MFDRMandYN = "select NVL(MFDR_DRUG_CAT_APPL_YN,'N') MFDR_DRUG_CAT_APPL_YN, NVL(MFDR_DIAG_CAT_APPL_YN,'N') MFDR_DIAG_CAT_APPL_YN ,NVL(MFDR_SERV_ITEM_CAT_APPL_YN,'N') MFDR_SERV_ITEM_CAT_APPL_YN from bl_parameters where OPERATING_FACILITY_ID = '"+facility_id+"'";
	
		pstmt = con.prepareStatement(qry_MFDRMandYN);
		rst = pstmt.executeQuery();
					
		if(rst != null){
			while(rst.next()) {
				drugCatTab_YN = rst.getString("MFDR_DRUG_CAT_APPL_YN");
				diagCatTab_YN = rst.getString("MFDR_DIAG_CAT_APPL_YN");
				servicesAndItemsCatTab_YN = rst.getString("MFDR_SERV_ITEM_CAT_APPL_YN"); //V230210
				}
			}
			
			if(drugCatTab_YN.equals("N"))
				show_drug_cat = "display:none;";
			else
				show_drug_cat="display:block";
			
			if(diagCatTab_YN.equals("N"))
				show_diag_cat = "display:none;";
			else
				show_diag_cat="display:block";
			
			if(servicesAndItemsCatTab_YN.equals("N"))
				show_servicesAndItems_cat = "display:none;";
			else
				show_servicesAndItems_cat="display:block";
%>
<form name='query_form' id='query_form' method='post' action='../../eBL/jsp/BLMultiFactorDeductRuleQueryResult.jsp' onsubmit='SelectAll()' >

<table width='100%' align='center' cellspacing='0' cellpadding='0'>
	<tr>
		<th align='left' width='20%'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
	<tr>
	<!-- <td width='60%'> -->
	<p title='Query Criteria'>
	<table width='100%' colspan='3'>
		<tr>
			<td width='40%' nowrap class='label' colspan='1'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
				<td class='fields' nowrap width='60%' colspan='2'>
					<input type='text' name='payerGroup2' id='payerGroup2' size='40' maxlength='40' value='' onblur='if(this.value!=""){ callCommonValidation(2,payerGroup2,payerCode2); } else{clearPolicyFields(payerCode2);}'/>
					<input type='hidden' name='payerCode2' id='payerCode2' value=''>
					<input type='button' class='button' name="payerGroup2_btn" id="payerGroup2_btn" value='?'  onClick="callCommonValidation(2,payerGroup2,payerCode2);" tabindex='2'>
				</td>
		</tr>
		<tr>
			<td width='40%' class='label'><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></td>
				<td class='fields' nowrap width='60%' colspan='2'>
					<input type='text' name='payerGroup1' id='payerGroup1' size='40' maxlength='40'  value='' onblur='if(this.value!=""){ callCommonValidation(1,payerGroup1,payerCode);} else{clearPolicyFields(payerCode);}'/>
					<input type='hidden' name='payerCode' id='payerCode' value=''>
					<input type='button' class='button' name="payerGroup1_btn" id="payerGroup1_btn" value='?'  onClick="callCommonValidation(1,payerGroup1,payerCode);" tabindex='2'>
			</td>
		</tr>
		<tr>
			<td width='40%' class='label'><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></td>
				<td class='fields' nowrap width='60%' colspan='2'>
					<input type='text' name='policyType' id='policyType' size='40' maxlength='40' value='' onblur='if(this.value!=""){ callCommonValidation(3,policyType,policyTypeCode);} else{clearPolicyFields(policyTypeCode);}'/>
					<input type='hidden' name='policyTypeCode' id='policyTypeCode' value=''>
					<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?'  onClick="callCommonValidation(3,policyType,policyTypeCode);" tabindex='2'>
				</td>
		</tr>
		
		<tr>
			<td width='40%' class='label'><fmt:message key="eBL.DeductibleCategory.label" bundle="${bl_labels}"/></td>
				<td class='fields' nowrap width='60%' size='40' maxlength='40' colspan='2' >
					<select id='category' name='category'  onchange="fnEnableDisableMFDR(this,'cat','drug_category','diag_category','clinic_category');" >
					<%if(diagCatTab_YN.equals("Y") && drugCatTab_YN.equals("Y") && servicesAndItemsCatTab_YN.equals("Y")){%>
						<option value='All' selected> <fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
						<option value='DrugCat'> <fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></option>
						<option value='DiagCat'> <fmt:message key="eBL.DiagnosisCategory.label" bundle="${bl_labels}"/> </option>
						<!-- V230210 -->
						<option value='ServicesandItemCat'> <fmt:message key="eBL.ServicesandItemsClinicCategory.label" bundle="${bl_labels}"/> </option>
					<%}if(drugCatTab_YN.equals("Y") && diagCatTab_YN.equals("N") && servicesAndItemsCatTab_YN.equals("N")){%>
						<option value='DrugCat' selected> <fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></option>
					<%}if(diagCatTab_YN.equals("Y") && drugCatTab_YN.equals("N") && servicesAndItemsCatTab_YN.equals("N")){%>
						<option value='DiagCat' selected > <fmt:message key="eBL.DiagnosisCategory.label" bundle="${bl_labels}"/> </option>
					<!-- V230210 starts -->
					<%}if(servicesAndItemsCatTab_YN.equals("Y") && drugCatTab_YN.equals("N") && diagCatTab_YN.equals("N")){%>
						<option value='ServicesandItemCat' selected> <fmt:message key="eBL.ServicesandItemsClinicCategory.label" bundle="${bl_labels}"/> </option>
					<%}if(drugCatTab_YN.equals("Y") && diagCatTab_YN.equals("Y") && servicesAndItemsCatTab_YN.equals("N")){%>
						<option value='DrugCat' > <fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></option>
						<option value='DiagCat' > <fmt:message key="eBL.DiagnosisCategory.label" bundle="${bl_labels}"/> </option>
					<%}if(drugCatTab_YN.equals("Y") && servicesAndItemsCatTab_YN.equals("Y") && diagCatTab_YN.equals("N")){%>
						<option value='DrugCat'> <fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></option>
						<option value='ServicesandItemCat'> <fmt:message key="eBL.ServicesandItemsClinicCategory.label" bundle="${bl_labels}"/> </option>
					<%}if(servicesAndItemsCatTab_YN.equals("Y") && diagCatTab_YN.equals("Y") && drugCatTab_YN.equals("N")){%>
						<option value='DiagCat' > <fmt:message key="eBL.DiagnosisCategory.label" bundle="${bl_labels}"/> </option>
						<option value='ServicesandItemCat'> <fmt:message key="eBL.ServicesandItemsClinicCategory.label" bundle="${bl_labels}"/> </option>
					<%}%>
					<!-- V230210 ends-->
					</select>
				</td>
		</tr>
		
		<tr>
			<td width='40%' nowrap class='label' id="cat" name="cat" colspan='1'>
			<fmt:message key="Common.category1.label" bundle="${ph_labels}"/></td>
				<td class='fields' nowrap width='60%' size='40' maxlength='40' colspan='2' >
				<select id='drug_category' name='drug_category'  colspan='2' style = "<%=show_drug_cat%>">
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>		
					<option value='AG'> <fmt:message key="eBL.Agreement.label" bundle="${bl_labels}"/> </option>
					<option value='GN'> <fmt:message key="eBL.Generic.label" bundle="${bl_labels}"/> </option>
					<option value='BA'> <fmt:message key="eBL.BrandWithAlternate.label" bundle="${bl_labels}"/> </option> 
					<option value='BN'> <fmt:message key="eBL.BrandWithoutAlternate.label" bundle="${bl_labels}"/> </option>
				</select>
				<select id='diag_category' name='diag_category'   colspan='2' style = "<%=show_diag_cat%>">
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>		
<%
			
			pstmt = con.prepareStatement( "select DIAG_CATG_CODE, LONG_DESC from MR_DIAG_CATEGORY where EFF_STATUS = 'E'" ) ;
			rst = pstmt.executeQuery() ;
			
			if( rst != null ) 
			{
				while( rst.next() ) 
				{
					String diag_cat_code = rst.getString( "DIAG_CATG_CODE" ) ;
					String long_desc = rst.getString( "LONG_DESC" ) ;
					out.println("<option value=\""+diag_cat_code+"\">"+long_desc+"</option>");	
				}
			}
			if(rst !=null) rst.close();
			pstmt.close();	
			
%>  						
				</select>
				<!-- V230210  starts-->
				<select id='clinic_category' name='clinic_category'  colspan='2' style = "<%=show_servicesAndItems_cat%>"> 
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>	
<%
			
			pstmt = con.prepareStatement("select CLINIC_PROC_CATG_CODE, LONG_DESC from op_clinic_proc_category where eff_status='E' order by srl_no" ) ;
			rst = pstmt.executeQuery() ;
			
			if( rst != null ) 
			{
				while( rst.next() ) 
				{
					String clininc_cat_code = rst.getString( "CLINIC_PROC_CATG_CODE" ) ;
					String long_desc = rst.getString( "LONG_DESC" ) ;
					out.println("<option value=\""+clininc_cat_code+"\">"+long_desc+"</option>");
				}	
			}  
			if(rst !=null) rst.close();
			pstmt.close() ;	
			
%>   	
				</select>
				<!-- V230210 ends --> 
			</td>	
		</tr>
	</table>
	</p>
<!-- </td> -->	
	
</table>
<table width='100%' align='center'>
	<th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/>
	</th>
	<tr>
		<td width='60%'>
		<p title='Sort Order'>
		<table width='100%'>
			<td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			<td>&nbsp;</td>
			<td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
			<tr>
				<td width='45%' align='center'>
					<select name='orderbycols' id='orderbycols' size='5'>
						<option value='hdr.CUST_CODE'><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></option>
						<option value='hdr.POLICY_TYPE_CODE'><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></option>
					</select>
				</td>
				<td align='center' width='3%'>
					<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
					<input type='button' name='add' id='add' class='button' value='<----' onclick='removeOrderByCol()'>
				</td>
				<td width='45%' align='center'>
					<select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true'>
						<option value='hdr.CUST_GROUP_CODE'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></option>
					</select>
				</td>
			</tr>
		</table>
		</p>
		</td>
	</tr>
</table>
<br>

<table border='0' width='100%' align='center'>
	<tr>
		<td width='100%' align='center' class='white'>
			<input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick='execQuery()'>
		</td>
	</tr>
</table>
<script>var exe=getLabel('Common.Execute.label','common'); document.forms[0].ExecuteQuery.value=exe;</script>
<%
			}catch(Exception e){
			System.err.println("Exception "+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			if(pstmt !=null) pstmt = null;
			if(rst !=null) rst = null;
		}
%>
<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
</form>
</body>
</html>

