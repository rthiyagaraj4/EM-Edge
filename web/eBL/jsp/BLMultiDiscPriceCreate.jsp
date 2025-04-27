<!DOCTYPE html>
<!-- Page Added by Nandhini for Price Discount Create Record -->    
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210217            14525 	       	MMS-QH-CRF-0128.2		       Nandhini M 
--> 

<%@page import="eBL.BlServiceDiscPriceBean"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
    private String checkForNull(String inputString)
	{	
		if(inputString == null || "null".equals(inputString) || " ".equals(inputString)){
			//inputString=="";
			//System.err.println("28===>");
			return "";
		}
		else{
			///System.err.println("27===>");
			return inputString;
		}
		
	}
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			int tableIndex = 1; // added against 128.2

	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	System.err.println(mode);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eBL/js/BLServiceDiscountPrice.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function discFieldValidation() {
	var locale = document.forms[0].locale.value;
	//alert("inside discFieldValidation");
	var totalRecords = document.forms[0].lastRowIndex.value;
	//alert("totalRecords:"+totalRecords);
	var pat_cat_code = document.forms[0].pat_cat_code.value;
	var effFromDate = document.getElementById('BCEffFromDate');
	var effToDate = document.getElementById("BCEffToDate");
	var effFromDuplicateCount = 0;
	var effToDuplicateCount = 0;
	
	for(var i=1;i<=totalRecords;i++){
		var disc_Ind = document.getElementById("disc_Ind"+i).value;
		if(disc_Ind == "") disc_Ind = "";
		
		var isDiscInsMod = document.getElementById("isDiscInsMod_"+i).value;;
		
		if(disc_Ind == ""){
			alert("Discount Indicator cannot be Blank");
			disc_Ind= document.getElementById("discInd"+i).value = "";
			disc_Ind= document.getElementById("discInd"+i).focus();
			return false;
		}
		
		var discUptoHrs = document.getElementById("discUptoHrs"+i).value;
		var i_discUptoHrs = 0;
		if(discUptoHrs != "") i_discUptoHrs = parseInt(discUptoHrs);
		var discUptoPercAmt = document.getElementById("discUptoPercAmt"+i).value;
		var i_discUptoPercAmt = 0;
		if(discUptoPercAmt != "") i_discUptoPercAmt = parseInt(discUptoPercAmt);

		if(i_discUptoHrs > 0){
			if(discUptoPercAmt == ""){
				alert(getMessage("BL8589","BL"));
				document.getElementById("discUptoPercAmt"+i).value = "";
				document.getElementById("discUptoPercAmt"+i).focus();
				return false;
			}
			
			if(discUptoPercAmt == 0){
				alert("Discount value cannot be zero")
				document.getElementById("discUptoPercAmt"+i).value = "";
				document.getElementById("discUptoPercAmt"+i).focus();
				return false;
			}			
		}
		
		var discPer_ip = document.getElementById("discPer_ip"+i);
		var discPer_op = document.getElementById("discPer_op"+i);
		var discPer_em = document.getElementById("discPer_em"+i);
		var discPer_ex = document.getElementById("discPer_ex"+i);
		var discPer_dc = document.getElementById("discPer_dc"+i);			
		
		if(disc_Ind == 'P'){			
			if(discPer_ip.value > 100){
				alert('Percentage cannot be greater than 100');
				discPer_ip.select();
				return false;
			}
			if(discPer_op.value > 100){
				alert('Percentage cannot be greater than 100');
				discPer_op.select();
				return false;
			}
			if(discPer_em.value > 100){
				alert('Percentage cannot be greater than 100');
				discPer_em.select();
				return false;
			}
			if(discPer_ex.value > 100){
				alert('Percentage cannot be greater than 100');
				discPer_ex.select();
				return false;
			}
			if(discPer_dc.value > 100){
				alert('Percentage cannot be greater than 100');
				discPer_dc.select();
				return false;
			}
		}
		
		if(pat_cat_code == "I" && discPer_ip.value == ""){
			alert("IP Discount value cannot be Blank");
			setTimeout(function () {
				discPer_ip.focus();
			}, 10);
			//discPer_ip.value = "";
			//discPer_ip.focus();
			return false;			
		}
		
		if(pat_cat_code == "O" && discPer_op.value == ""){
			alert("OP Discount value cannot be Blank");
			setTimeout(function () {
				discPer_op.focus();
			}, 10);
			//discPer_op.value = "";
			//discPer_op.focus();
			return false;			
		}
			
		if(pat_cat_code == "D" && discPer_dc.value == ""){
			alert("DC Discount value cannot be Blank");
			setTimeout(function () {
				discPer_dc.focus();
			}, 10);
			//discPer_dc.focus();
			return false;			
		}
		
		if(pat_cat_code == "X" && discPer_ex.value == ""){
			alert("EX Discount value cannot be Blank");
			setTimeout(function () {
				discPer_ex.focus();
			}, 10);
			//discPer_ex.value = "";
			//discPer_ex.focus();
			return false;			
		}
		
		if(pat_cat_code == "E" && discPer_em.value == ""){
			alert("EM Discount value cannot be Blank");
			setTimeout(function () {
				discPer_ex.focus();
			}, 10);
			//discPer_em.value = "";
			//discPer_em.focus();
			return false;
		}
		
		var discApplicability = document.getElementById("discAppl"+i);
		if(discApplicability.value == ""){
			alert("Discount Applicability cannot be Blank");
			setTimeout(function () {
				discApplicability.focus();
			}, 10);
			//discApplicability.value = "";
			//discApplicability.focus();
			return false;
		}	

		var discFromDate = document.getElementById("discFromDate"+i);
		var disToDate = document.getElementById("disToDate"+i);
		
		if(discFromDate.value == ""){
			alert("Effective From Date cannot be Blank");
			setTimeout(function () {
				discFromDate.focus();
			}, 10);
			//discFromDate.value = "";
			//discFromDate.focus();
			return false;
		}

		if(discFromDate.value != '' && isDiscInsMod != "M"){	
			if(!isAfterNow(discFromDate.value,'DMY',locale))
			{
				alert("Effective From Date Should be Greater than System Date");
				setTimeout(function () {
				discFromDate.focus();
			}, 10);
				//discFromDate.value="";
				//discFromDate.focus();
				return false;
			} 
		}
		if(discFromDate.value!='' && disToDate.value!=''){	
			if(!isBefore(discFromDate.value,disToDate.value,'DMY',locale))
			{
				alert("Effective To Date should be greater than Effective From Date");
				setTimeout(function () {
				disToDate.focus();
			}, 10);
				//disToDate.value="";
				//disToDate.focus();
				return false;
			} 
		}
		
		for(var j=1;j<=totalRecords;j++){
			if(i != j){
				var lclDiscFromDate = document.getElementById("discFromDate"+j);
				var lclDiscToDate = document.getElementById("disToDate"+j);
				
				if(lclDiscFromDate.value != '' && discFromDate.value != ''){
					if(lclDiscFromDate.value == discFromDate.value) {
						effFromDuplicateCount = 1;
					}
				}
				
				if(lclDiscToDate.value != '' && disToDate.value != ''){
					if(lclDiscToDate.value == disToDate.value) {
						effToDuplicateCount = 1;
					}
				}
				
				if(lclDiscFromDate.value != '' && lclDiscToDate.value != '' && discFromDate.value != ''){
					if(isBetween(lclDiscFromDate.value,lclDiscToDate.value,discFromDate.value,'DMY',locale)){
						alert("Effective dates are overlapping between records, please rectify and continue");
						alert(getMessage("BL8108", "BL"));
						return false;
					}						
				}
			}			
		}
		
		if(effFromDuplicateCount > 0) {
			alert("More than one record has same effective from date, please rectify and continue");
			return false;
		}

		if(effToDuplicateCount > 0) {
			alert("More than one record has same effective to date, please rectify and continue");
			return false;
		}		
	}	

	return true;
}

function fieldValidation(obj,index,class_type) {
	var disc_Ind = document.getElementById("disc_Ind"+index).value;
	var pat_cat_code = document.forms[0].pat_cat_code.value;
	
	if(disc_Ind == ""){
		alert("Discount Indicator cannot be blank");
		obj.value = '';
		disc_Ind= document.getElementById("discInd"+index).focus();
		return false;
	}
	
	if( (pat_cat_code == "I" && class_type == "IP" && obj.value == "") || (pat_cat_code == "O" && class_type == "OP" && obj.value == "") || (pat_cat_code == "D" && class_type == "DC" && obj.value == "") || (pat_cat_code == "X" && class_type == "EX" && obj.value == "") || (pat_cat_code == "E" && class_type == "EM" && obj.value == "")) {
		alert("Discount value cannot be blank");
		obj.value = '';
		obj.focus();
		return false;
	}
	
	if( (pat_cat_code == "I" && class_type == "IP" && obj.value == "0") || (pat_cat_code == "O" && class_type == "OP" && obj.value == "0") || (pat_cat_code == "D" && class_type == "DC" && obj.value == "0") || (pat_cat_code == "X" && class_type == "EX" && obj.value == "0") || (pat_cat_code == "E" && class_type == "EM" && obj.value == "0")) {
		alert("Discount value cannot be zero");
		obj.value = "";
		obj.focus();
		return false;
	}	
	
	if(disc_Ind == 'P' && obj.value > 100){
		alert('Percentage cannot be greater than 100');
		obj.value = '';
		obj.focus();
		return false;
	}
	return true;
}

function validateDiscDate(index){
	
	var locale = document.forms[0].locale.value;
	var effFromDate = document.getElementById('BCEffFromDate');
	var effToDate = document.getElementById("BCEffToDate");
	var discFromDate = document.getElementById('discFromDate'+index);
	var disToDate = document.getElementById('disToDate'+index);
	
	if(discFromDate.value !='' && disToDate.value != ''){	
		if(!isBefore(discFromDate.value,disToDate.value,'DMY',locale))
		{
			alert("Discount Effective From Date cannot be after Discount Effective To Date");
			discFromDate.value="";
			discFromDate.focus();
			return false;
		} 	
	}
	
	if(discFromDate.value !='' && disToDate.value != ''){	
		if(!isAfter(disToDate.value,discFromDate.value,'DMY',locale))
		{
			alert("Discount Effective To Date cannot be before Effective From Date");
			disToDate.value="";
			disToDate.focus();
			return false;
		} 	
	}

	if(effFromDate.value !='' && discFromDate.value != ''){	
		if(!isBefore(effFromDate.value,discFromDate.value,'DMY',locale))
		{
			alert("Discount Effective From Date cannot be before Price Effective From Date");
			discFromDate.value="";
			discFromDate.focus();
			return false;
		} 
	}
	//alert("effToDate.value:"+effToDate.value);
	//alert("disToDate.value:"+disToDate.value);
	if(effToDate.value != '' && disToDate.value != ''){
		if(!isAfter(effToDate.value,disToDate.value,'DMY',locale))
		{
			alert("Discount Effective To Date should be within Price Effective To Date");
			disToDate.value="";
			disToDate.focus();
			return false;
		} 
	}
	
	return true;
}

function valDiscUptoPercAmt(obj, discInd){
	var discValue = parseInt(obj.value);
	if(discInd.value == ""){
		alert("Discount Indicator cannot be Blank");
		obj.value = "";
		discInd.focus();
		return false;
	} else {
		if(discInd.value == "P"){
			if(discValue > 100){
				alert("Percentage cannot be greater than 100");
				obj.value = "";
				return false;
			} else if(discValue == 0){
				alert("Discount value cannot be zero");
				obj.value = "";
				return false;
			}
		}
	}
}

function valDiscUptoHrs(obj){
	if(obj.value != "" && obj.value == "0") {
		alert("Range should be within 1 to 999");
		obj.value = "";
		return false;
	}
}

</script>
</head>
<%
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String isServiceDiscountEnabledYN = "N";
			int servDiscFnCntCheck = 0;
			try
			{
				
				String selBlngClass = request.getParameter("selBlngClass");
				if(selBlngClass == null || "null".equals(selBlngClass)) selBlngClass = "";
				
				String effFromDate = request.getParameter("effFromDate");
				if(effFromDate == null || "null".equals(effFromDate)) effFromDate = "";

				String effToDate = request.getParameter("effToDate");
				if(effToDate == null || "null".equals(effToDate)) effToDate = "";
				
				String pat_cat_code = "";
			
				String locale = (String)session.getAttribute("LOCALE");
				int noofdecimal = Integer.parseInt(request.getParameter("noofdecimal")!=null ? request.getParameter("noofdecimal") : "2");
				con = ConnectionManager.getConnection(request);
				
				try 
				{ 
					String sql = "select NVL(PATIENT_CATEGORY_CODE,'') from bl_blng_class where BLNG_CLASS_CODE = '" + selBlngClass + "'";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						pat_cat_code = rs.getString(1);			
					}
				} catch (Exception e) {
					System.err.println(e);
				} finally {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();	
				}
				
				try
				{
					String sql = "SELECT COUNT (*) FROM sm_function_control a, sm_site_param b  WHERE a.site_id = b.customer_id AND module_id = 'BL'  AND functionality_id = 'ENABLE_SERVICE_PERIOD_DISC'";
					System.out.println("sql for Package Group Function Control:"+sql);
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();	
					if(rs.next())
					{
						servDiscFnCntCheck=rs.getInt(1);
						System.err.println("count for ENABLE_SERVICE_PERIOD_DISC Function Control:"+servDiscFnCntCheck);
					}		
					
					if(servDiscFnCntCheck > 0)
						isServiceDiscountEnabledYN = "Y";
					else
						isServiceDiscountEnabledYN = "N";
				}catch(Exception e){
					System.out.println("Exception in Package Group Function Control Query :"+e);
					e.printStackTrace();
				}finally{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();	
				}				
%>				
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();">
	<form name = 'discbulkupd' id='discbulkupd' >	
      	<table name='Multidiscbulkupd' id='Multidiscbulkupd'  width='100%' cellpadding='3'  cellspacing='0' align="center" >
			<div id="tableContainer">			
			<tr>
			<td align="left" nowrap><fmt:message key="eBL.DiscountDetails.label" bundle="${bl_labels}"></fmt:message> </td>
		</tr>
		<tr>
			<td class='COLUMNHEADER'	width='4%'	align="left">
				<fmt:message key="eBL.DiscountIndicator.label" bundle="${bl_labels }"></fmt:message>
			</td>
<%
			if("Y".equals(isServiceDiscountEnabledYN)){
%>			
			<td class='COLUMNHEADER'	width='4%'	align="left">
				Discount <BR>Upto (Hours)
			</td>
			<td class='COLUMNHEADER'	width='4%'	align="left">
				%/Amount
			</td>
<%
			}
%>			
			
			<td class='COLUMNHEADER'	width='4%'	align="left">
				<fmt:message key="eBL.IP_amt.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td class='COLUMNHEADER'	width='4%'	align="left">
				<fmt:message key="eBL.OP_amt.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td class='COLUMNHEADER'	width='4%'	align="left">
				<fmt:message key="eBL.EM_amt.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td class='COLUMNHEADER'	width='4%'	align="left">
				<fmt:message key="eBL.EX_amt.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td class='COLUMNHEADER'	width='4%'	align="left">
				<fmt:message key="eBL.DC_amt.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td class='COLUMNHEADER'	width='4%'	align="left">
				<fmt:message key="eBL.DiscApplicability.label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td class='COLUMNHEADER'	width='4%'	align="left">
				<fmt:message key="eBL.EffectiveFrom.Label" bundle="${bl_labels }"></fmt:message>
			</td>
			<td class='COLUMNHEADER'	width='4%'	align="left">
				<fmt:message key="eBL.EffectiveTo.Label" bundle="${bl_labels }"></fmt:message>
			</td>
<%
				if(mode.equals("loaddisc")){
					String discstr=request.getParameter("discstr")==null?"":request.getParameter("discstr");
					System.err.println("84====>"+discstr);
					String[] val = discstr.split(",");
					System.err.println("86====>"+val.length);
					//System.err.println("87====>"+val[0]);
					String discInd =  "";
					String ipper	 =""; 
					String opper	 =""; 
					String DCper	 =""; 
					String EMper   =  "";
					String EXper   =  "";
					String discappl=  "";
					String frmDate =  "";
					String toDate =   "";
					//String dseffecTO = request.getParameter("dseffecTO");
					//System.err.println("400,dseffecTO===>"+dseffecTO);
					String isDiscInsMod = "I";
					String discUptoHrs = "";
					String discUptoPercAmt = "";
					for(int i=0;i<val.length;i++){
						tableIndex = i+1;
						System.err.println("i====>"+i);
						String rowdata=val[i];
						System.err.println("86====>"+rowdata);
						String[] rowval=rowdata.split("::");
						System.err.println("rowval:"+rowval);
						
						discInd = checkForNull(rowval[0]);
						if(" ".equals(discInd)) discInd = "";
						
						ipper	 = checkForNull(rowval[1]);
						if(" ".equals(ipper)) ipper = "";
						
						opper	 = checkForNull(rowval[2]);
						if(" ".equals(opper)) opper = "";
						
						EMper   = checkForNull(rowval[3]);
						if(" ".equals(EMper))  EMper = "";
						
						EXper   = checkForNull(rowval[4]);
						if(" ".equals(EXper))  EXper = "";
						
						DCper	 = checkForNull(rowval[5]);
						if(" ".equals(DCper)) DCper = "";					
						
						discappl= checkForNull(rowval[6]);
						if(" ".equals(discappl))  discappl = "";
						
						frmDate = checkForNull(rowval[7]);
						if(" ".equals(frmDate)) frmDate = "";
						
						toDate =  checkForNull(rowval[8]);
						if(" ".equals(toDate)) toDate = "";
						
						isDiscInsMod =  checkForNull(rowval[9]);
						if(" ".equals(isDiscInsMod)) isDiscInsMod = "I";
						
						discUptoHrs =  checkForNull(rowval[10]);
						if(" ".equals(discUptoHrs)) discUptoHrs = "";

						discUptoPercAmt =  checkForNull(rowval[11]);
						if(" ".equals(discUptoPercAmt)) discUptoPercAmt = "";
					
%>
			<tr>
			<%
			if("I".equals(isDiscInsMod)){
%>
			<td  nowrap class='fields'>
      			<Select name='discInd<%= tableIndex%>'  id='discInd<%= tableIndex%>' onchange="addData(this,<%= tableIndex%>,'discInd')" >
      					<option value='' <%=discInd.equals("")?"selected":""%>><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
	      					<option value="A" <%=discInd.equals("A")?"selected":""%>><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"></fmt:message> </option>
	      				
	      					<option value="P" <%=discInd.equals("P")?"selected":""%>><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"></fmt:message></option>
	      			</Select>
	      			<img src='../../eCommon/images/mandatory.gif'>
      		</td>
			<%
			} else{
			%>
				<td  nowrap class='fields'>
      			<Select name='discInd<%= tableIndex%>'  id='discInd<%= tableIndex%>' onchange="addData(this,<%= tableIndex%>,'discInd')" disabled>
      					<option value='' <%=discInd.equals("")?"selected":""%>><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
	      					<option value="A" <%=discInd.equals("A")?"selected":""%>><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"></fmt:message> </option>
	      				
	      					<option value="P" <%=discInd.equals("P")?"selected":""%>><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"></fmt:message></option>
	      			</Select>
	      			<img src='../../eCommon/images/mandatory.gif'>
      		</td>
<%
			}
%>
<%
			if("Y".equals(isServiceDiscountEnabledYN)){
%>		
		
			<td  nowrap class='fields'>
      				<input type="text" name='discUptoHrs<%= tableIndex%>'  id='discUptoHrs<%= tableIndex%>' readonly onkeypress='return ChkNumberInput(this,event,"0");' onblur="valDiscUptoHrs(this);" size='15' maxlength="3" value='<%=discUptoHrs%>' />
      		</td>
			<td  nowrap class='fields'>
      				<input type="text" name='discUptoPercAmt<%= tableIndex%>'  id='discUptoPercAmt<%= tableIndex%>' readonly onblur="valDiscUptoPercAmt(this,document.forms[0].discInd<%= tableIndex%>)" size='15' maxlength="15" value='<%=discUptoPercAmt%>' onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")'/>
      		</td>			
<%
			}
%>			
	<%
			if("I".equals(isDiscInsMod)){
%>
			<td  nowrap class='fields'>
      				<input type="text" name='discPer_ip<%= tableIndex%>'  id='discPer_ip<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'IP')) addData(this,<%= tableIndex%>,'IP')}" size='15' maxlength="15" value='<%=ipper%>' <%= ("I".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
      			</td>
			<%
			} else{
			%>
			<td  nowrap class='fields'>
      				<input type="text" name='discPer_ip<%= tableIndex%>'  id='discPer_ip<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'IP')) addData(this,<%= tableIndex%>,'IP')}" size='15' maxlength="15" value='<%=ipper%>' <%= ("I".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
      			</td>
			
			<%
			}
%>
<%
			if("I".equals(isDiscInsMod)){
%>
				<td  nowrap class='fields'>
				<input type="text" name='discPer_op<%= tableIndex%>'  id='discPer_op<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'OP')) addData(this,<%= tableIndex%>,'OP')}" size='15' maxlength="15" value='<%=opper%>' <%= ("O".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
				</td>
				<%
			} else{
			%>
			<td  nowrap class='fields'>
				<input type="text" name='discPer_op<%= tableIndex%>'  id='discPer_op<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'OP')) addData(this,<%= tableIndex%>,'OP')}" size='15' maxlength="15" value='<%=opper%>' <%= ("O".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
				</td>
			<%
			}
%>
				<%
			if("I".equals(isDiscInsMod)){
%>
				<td  nowrap class='fields'>
				<input type="text" name='discPer_em<%= tableIndex%>'  id='discPer_em<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'EM')) addData(this,<%= tableIndex%>,'EM')}" size='15' maxlength="15" value='<%=EMper%>' <%= ("E".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
				</td>
				<%
			} else{
			%>
			<td  nowrap class='fields'>
				<input type="text" name='discPer_em<%= tableIndex%>'  id='discPer_em<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'EM')) addData(this,<%= tableIndex%>,'EM')}" size='15' maxlength="15" value='<%=EMper%>' <%= ("E".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
				</td>
				<%
			}
%>
<%
			if("I".equals(isDiscInsMod)){%>
			
				<td  nowrap class='fields'>
				<input type="text" name='discPer_ex<%= tableIndex%>'  id='discPer_ex<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'EX')) addData(this,<%= tableIndex%>,'EX')}" size='15' maxlength="15" value='<%=EXper%>' <%= ("X".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
				</td>
				<%
			} else{
				%>
				<td  nowrap class='fields'>
				<input type="text" name='discPer_ex<%= tableIndex%>'  id='discPer_ex<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'EX')) addData(this,<%= tableIndex%>,'EX')}" size='15' maxlength="15" value='<%=EXper%>' <%= ("X".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
				</td>
			
			<%
			}
%>
<%
			if("I".equals(isDiscInsMod)){
				%>
				<td  nowrap class='fields'>
				<input type="text" name='discPer_dc<%= tableIndex%>'  id='discPer_dc<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'DC')) addData(this,<%= tableIndex%>,'DC')}" size='15' maxlength="15" value='<%=DCper%>' <%= ("D".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
				</td>
				<%
			} else{
				%>
				<td  nowrap class='fields'>
				<input type="text" name='discPer_dc<%= tableIndex%>'  id='discPer_dc<%= tableIndex%>' readonly onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'DC')) addData(this,<%= tableIndex%>,'DC')}" size='15' maxlength="15" value='<%=DCper%>' <%= ("D".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
				</td>
				<%
			}
%>
		<%
			if("I".equals(isDiscInsMod)){
				%>		
				<td  nowrap class='fields'>
				<select name='discAppl<%= tableIndex%>'  id='discAppl<%= tableIndex%>' onchange="addData(this,<%= tableIndex%>,'discAppl')" >
      					<option value='' <%=discappl.equals("")?"selected":""%>><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
	      					<option value="T" <%=discappl.equals("T")?"selected":""%>>Total Amount </option>
	      					<option value="P"  <%=discappl.equals("P")?"selected":""%>><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"></fmt:message></option>
	      					<option value="X"  <%=discappl.equals("X")?"selected":""%>><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"></fmt:message></option>
	      					<option value="C"  <%=discappl.equals("C")?"selected":""%>><fmt:message key="Common.patient.label" bundle="${common_labels}"></fmt:message></option>
      				</select>
      				<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<%
			} else{
				%>
				<td  nowrap class='fields'>
				<select name='discAppl<%= tableIndex%>'  id='discAppl<%= tableIndex%>' onchange="addData(this,<%= tableIndex%>,'discAppl')" disabled >
      					<option value='' <%=discappl.equals("")?"selected":""%>><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
	      					<option value="T" <%=discappl.equals("T")?"selected":""%>>Total Amount </option>
	      					<option value="P"  <%=discappl.equals("P")?"selected":""%>><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"></fmt:message></option>
	      					<option value="X"  <%=discappl.equals("X")?"selected":""%>><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"></fmt:message></option>
	      					<option value="C"  <%=discappl.equals("C")?"selected":""%>><fmt:message key="Common.patient.label" bundle="${common_labels}"></fmt:message></option>
      				</select>
      				<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<%
			}
%>
				<%
			if("I".equals(isDiscInsMod)){
				%>
				<td  nowrap class='fields'>
				<input type='text' name='discFromDate<%= tableIndex%>'  id='discFromDate<%= tableIndex%>' size='15' maxlength='15' 
				onBlur="if(isValidDate(this)) { if(validateDiscDate(<%= tableIndex%>)) addData(this,<%= tableIndex%>,'discfromdate')}" value='<%=frmDate%>'  />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='discFromDate_ctrl' onClick="return showCalendar('discFromDate<%= tableIndex%>');"   />
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>&nbsp;
					</td>
					<%
			} else{
				%>
				<td  nowrap class='fields'>
				<input type='text' name='discFromDate<%= tableIndex%>'  id='discFromDate<%= tableIndex%>' size='15' maxlength='15' readonly 
				onBlur="if(isValidDate(this)) { if(validateDiscDate(<%= tableIndex%>)) addData(this,<%= tableIndex%>,'discfromdate')}" value='<%=frmDate%>' disabled />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='discFromDate_ctrl' readonly onClick="return showCalendar('discFromDate<%= tableIndex%>');"  disabled />
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>&nbsp;
					</td>
					<%
			}
%>
					<td  nowrap class='fields'>
					<input type='text' name='disToDate<%= tableIndex%>'  id='disToDate<%= tableIndex%>'  size='15' maxlength='15' onBlur="if(isValidDate(this)){if(validateDiscDate(<%= tableIndex%>)) addData(this,<%= tableIndex%>,'discToDate')}" value='<%=toDate%>' />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='disToDate_ctrl' onClick="return showCalendar('disToDate<%= tableIndex%>');" />
					
				<input type='hidden' name='discDtls<%=tableIndex%>'  id='discDtls<%=tableIndex%>' value=''>
				<input type='hidden' name='ip_per<%=tableIndex%>'  id='ip_per<%=tableIndex%>' value='<%=ipper%>'>
				<input type='hidden' name='op_per<%=tableIndex%>'  id='op_per<%=tableIndex%>' value='<%=opper%>'>
				<input type='hidden' name='DC_per<%=tableIndex%>'  id='DC_per<%=tableIndex%>' value='<%=DCper%>'>
				<input type='hidden' name='EM_per<%=tableIndex%>'  id='EM_per<%=tableIndex%>' value='<%=EMper%>'>
				<input type='hidden' name='EX_per<%=tableIndex%>'  id='EX_per<%=tableIndex%>' value='<%=EXper%>'>
				<input type='hidden' name='disc_appl<%=tableIndex%>'  id='disc_appl<%=tableIndex%>' value='<%=discappl%>'>
				<input type='hidden' name='disc_Ind<%=tableIndex%>'  id='disc_Ind<%=tableIndex%>' value='<%=discInd%>'>
				<input type='hidden' name='discFrmDate<%=tableIndex%>'  id='discFrmDate<%=tableIndex%>' value='<%=frmDate%>'>
				<input type='hidden' name='discToDate<%=tableIndex%>'  id='discToDate<%=tableIndex%>' value='<%=toDate%>'>
				<input type='hidden' name='isDiscInsMod_<%=tableIndex%>'  id='isDiscInsMod_<%=tableIndex%>' value='<%=isDiscInsMod%>'>
				
<%
			if("N".equals(isServiceDiscountEnabledYN)){
%>					
				<input type="hidden" name='discUptoHrs<%= tableIndex%>'  id='discUptoHrs<%= tableIndex%>'value='<%=discUptoHrs%>' />
				<input type="hidden" name='discUptoPercAmt<%= tableIndex%>'  id='discUptoPercAmt<%= tableIndex%>' value='<%=discUptoPercAmt%>' />
<%
			}
%>				
			</td>
      		</tr>
<%  
						//tableIndex+=1;
					}
				}
				else
				{
%>
	<tr>
			<td  nowrap class='fields'>
      			<Select name='discInd<%= tableIndex%>'  id='discInd<%= tableIndex%>' onchange="addData(this,<%= tableIndex%>,'discInd')">
      					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
	      					<option value="A" ><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"></fmt:message> </option>
	      				
	      					<option value="P"><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"></fmt:message></option>
	      			</Select>
	      			<img src='../../eCommon/images/mandatory.gif'>
      		</td>					
<%
			if("Y".equals(isServiceDiscountEnabledYN)){
%>			
			<td  nowrap class='fields'>
      				<input type="text" name='discUptoHrs<%= tableIndex%>'  id='discUptoHrs<%= tableIndex%>' onkeypress='return ChkNumberInput(this,event,"0");' onblur="valDiscUptoHrs(this);" size='15' maxlength="3" value='' />
      		</td>
			<td  nowrap class='fields'>
      				<input type="text" name='discUptoPercAmt<%= tableIndex%>'  id='discUptoPercAmt<%= tableIndex%>'  onkeypress="return checkForSpecChars(event)" onblur="valDiscUptoPercAmt(this,document.forms[0].discInd<%= tableIndex%>)" size='15' maxlength="15" value='' onkeypress='return allowValidNumber(this,event,10,"<%=noofdecimal%>")'/>
      		</td>	
<%
			}				
%>			
			<td  nowrap class='fields'>
      				<input type="text" name='discPer_ip<%= tableIndex%>'  id='discPer_ip<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'IP')) addData(this,<%= tableIndex%>,'IP')}" size='15' maxlength="15" value='' <%=("I".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
      		</td>
			<td  nowrap class='fields'>
				<input type="text" name='discPer_op<%= tableIndex%>'  id='discPer_op<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'OP')) addData(this,<%= tableIndex%>,'OP')}" size='15' maxlength="15" value='' <%=("O".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
			</td>
			<td  nowrap class='fields'>
				<input type="text" name='discPer_em<%= tableIndex%>'  id='discPer_em<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'EM')) addData(this,<%= tableIndex%>,'EM')}" size='15' maxlength="15" value='' <%=("E".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
			</td>
			<td  nowrap class='fields'>
				<input type="text" name='discPer_ex<%= tableIndex%>'  id='discPer_ex<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'EX')) addData(this,<%= tableIndex%>,'EX')}" size='15' maxlength="15" value='' <%=("X".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
			</td>
			<td  nowrap class='fields'>
				<input type="text" name='discPer_dc<%= tableIndex%>'  id='discPer_dc<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,<%= tableIndex%>,'DC')) addData(this,<%= tableIndex%>,'DC')}" size='15' maxlength="15" value='' <%=("D".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"%>/>
			</td>
			<td  nowrap class='fields'>
				<select name='discAppl<%= tableIndex%>'  id='discAppl<%= tableIndex%>' onchange="addData(this,<%= tableIndex%>,'discAppl')">
      					<option value='' ><fmt:message key="Common.Select.label" bundle="${common_labels }"></fmt:message></option>
	      					<option value="T">Total Amount </option>
	      					<option value="P" ><fmt:message key="eBL.PAYABLE_AMT.label" bundle="${bl_labels}"></fmt:message></option>
	      					<option value="X" ><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"></fmt:message></option>
	      					<option value="C" ><fmt:message key="Common.patient.label" bundle="${common_labels}"></fmt:message></option>
      				</select>
      				<img src='../../eCommon/images/mandatory.gif'>
			</td>
			<td  nowrap class='fields'>
				<input type='text' name='discFromDate<%= tableIndex%>'  id='discFromDate<%= tableIndex%>' size='15' maxlength='15' 
				onBlur="if(isValidDate(this)){if(validateDiscDate(<%= tableIndex%>)) addData(this,<%= tableIndex%>,'discfromdate')}" value='' />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='discFromDate_ctrl' onClick="return showCalendar('discFromDate<%= tableIndex%>');"  />
					&nbsp;<img src='../../eCommon/images/mandatory.gif'>&nbsp;
			</td>
					
			<td  nowrap class='fields'>
					<input type='text' name='disToDate<%= tableIndex%>'  id='disToDate<%= tableIndex%>'  size='15' maxlength='15' onBlur="if(isValidDate(this)){if(validateDiscDate(<%= tableIndex%>)) addData(this,<%= tableIndex%>,'discToDate')}" value='' />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='disToDate_ctrl' onClick="return showCalendar('disToDate<%= tableIndex%>');" />
					
				<input type='hidden' name='discDtls<%=tableIndex%>'  id='discDtls<%=tableIndex%>' value=''>
				<input type='hidden' name='ip_per<%=tableIndex%>'  id='ip_per<%=tableIndex%>' value=''>
				<input type='hidden' name='op_per<%=tableIndex%>'  id='op_per<%=tableIndex%>' value=''>
				<input type='hidden' name='DC_per<%=tableIndex%>'  id='DC_per<%=tableIndex%>' value=''>
				<input type='hidden' name='EM_per<%=tableIndex%>'  id='EM_per<%=tableIndex%>' value=''>
				<input type='hidden' name='EX_per<%=tableIndex%>'  id='EX_per<%=tableIndex%>' value=''>
				<input type='hidden' name='disc_appl<%=tableIndex%>'  id='disc_appl<%=tableIndex%>' value=''>
				<input type='hidden' name='disc_Ind<%=tableIndex%>'  id='disc_Ind<%=tableIndex%>' value=''>
				<input type='hidden' name='discFrmDate<%=tableIndex%>'  id='discFrmDate<%=tableIndex%>' value=''>
				<input type='hidden' name='discToDate<%=tableIndex%>'  id='discToDate<%=tableIndex%>' value=''>
				<input type='hidden' name='isDiscInsMod_<%=tableIndex%>'  id='isDiscInsMod_<%=tableIndex%>' value='I'>
				
<%
			if("N".equals(isServiceDiscountEnabledYN)){
%>
				<input type="hidden" name='discUptoHrs<%= tableIndex%>'  id='discUptoHrs<%= tableIndex%>' value='' />
				<input type="hidden" name='discUptoPercAmt<%= tableIndex%>'  id='discUptoPercAmt<%= tableIndex%>' value='' />	
<%
			}
%>				
			</td>
      		</tr>
<%
		 		} 
%>
	</table>
	<table width='100%'>
		<tr>
			<td width='70%'>
			</td>
			<td width='10%'>
				<input type='button' name='discBulkAdd'  id='discBulkAdd' value='Add' onclick='if(addModify()) addRowDisc("discBulkAdd")'>
				<input type='button' name='discBulkSave'  id='discBulkSave' value='Save' onclick='if(discFieldValidation()) saveDiscDtls()'>
			</td>
		</tr>
		
	</table>
      			<input type='hidden' name='pageId' id='pageId'  value='Bulk'>
				<input type='hidden' name='locale' id='locale'  value='<%=locale%>'>
				<input type='hidden' name='lastRowIndex' id='lastRowIndex'  value='<%=tableIndex%>'>
				<input type='hidden' name='inclRowCount' id='inclRowCount' value='<%=tableIndex -1 %>'>
				<input type='hidden' name='pat_cat_code' id='pat_cat_code'  value='<%=pat_cat_code%>'>
				<input type='hidden' name='selBlngClass' id='selBlngClass'  value='<%=selBlngClass%>'>				
				<input type='hidden' name='BCEffFromDate' id='BCEffFromDate'  value='<%=effFromDate%>'>				
				<input type='hidden' name='BCEffToDate' id='BCEffToDate'  value='<%=effToDate%>'>
				<input type='hidden' name='noofdecimal' id='noofdecimal'  value='<%=noofdecimal%>'>
				<input type='hidden' name='mode' id='mode'  value='<%=mode%>'>
				<input type='hidden' name='isServiceDiscountEnabledYN'  id='isServiceDiscountEnabledYN' value = '<%=isServiceDiscountEnabledYN%>'>
	</form>
	</body>
<% 			}catch(Exception e){
				System.err.println("Exception in BLMultiDiscPriceCreate.jsp:"+e);
				e.printStackTrace();
			}finally {
				ConnectionManager.returnConnection(con, request);
			}
%>			
	</html>

