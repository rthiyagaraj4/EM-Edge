<!DOCTYPE html>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,oracle.jdbc.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Special Agency Deposit</title>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

	String facilityId = request.getParameter("facilityId");
	String patientId = request.getParameter("patientId");
	String episodeType = request.getParameter("episodeType");
	String systemDate="";
	String effFromDt="";
	String effToDt="";
	
	if(request.getParameter("effFromDt")==null || ("undefined").equals(request.getParameter("effFromDt"))){
		effFromDt = "";
		}else{
			effFromDt = request.getParameter("effFromDt");
		}
	
	
	if(request.getParameter("effToDt")==null || ("undefined").equals(request.getParameter("effToDt"))){
		effToDt = "";
		}else{
			effToDt = request.getParameter("effToDt");
		}
	
	

	System.out.println("facilityId / patientId / episodeType /effFromDt / effToDt:::"
			+ facilityId + "/" + patientId + "/" + episodeType +"/" +effFromDt +"/"+ effToDt);
	
	

	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/messages.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>			
		<script language='javascript' ></script>		
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language="javascript" src="../../eBL/js/BLDepositReceipt.js"></script>
		<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		
			
			<script>
			
			  
	 function addrow(index)
	 {
		// alert('reached addrow');
		//var index = $('#estimatedeposit tr:last').attr('estimatedeposit'); 
			var index = $('#spldep tr:last').attr('data-id');
			index= parseInt(index)+parseInt(1) ;
			alert(index);
			
			var tableRow = "<tr id='tr_"+index+"' data-id='"+index+"' indexval='"+index+"'> "+									
	 		"<td  width='2.5%' class='fields'>"+
			"<select name='dep_type' id='dep_type' id='dep_type"+index+"'></td>"+
	 		"<td  width='3.5%' class='fields'>"+
			"<input type='text' id='dep_amt"+index+"' name='dep_amt"+index+"' id='dep_amt"+index+"' size='10' maxlength='30' value='' readonly></td>"+
			"<td width='3.5%' class='fields'>"+
			"<input type='text' id='utilizedamt"+index+"' name='utilizedamt"+index+"' id='utilizedamt"+index+"' size='10' maxlength='30' value='' readonly>" +"</td>"+
			"<td width='3.5%' class='fields'>"+
			"<input type='text' id='balance"+index+"' name='balance"+index+"' id='balance"+index+"' size='10' maxlength='30' value='' readonly>"+"</td>"+
			"<td width='3.5%' class='fields'>"+
			"<input type='text' id='effectivefrom"+index+"' name='effectivefrom"+index+"' id='effectivefrom"+index+"' size='10' maxlength='30' value='' readonly>"+"</td>"+
			"<td width='3.5%' class='fields'>"+
			"<input type='text' id='effectiveto"+index+"' name='effectiveto"+index+"' id='effectiveto"+index+"' size='10' maxlength='30' value='' readonly>"+"</td>"+
			"<td width='1.5%' class='fields'> "+
			"<input type='checkbox' name='selected_row"+index+"' id='selected_row"+index+"'  id='selected_row"+index+"' value='' onClick=''>"+"</td>"+
			"</tr>";
		// $('#estimatedeposit tr:last').after(tableRow);
	 	//alert(<tr>);
		 
		 $('#spldep').append(tableRow);
	 }

	//					 $("#selected_row").closest("#tr").remove();	
		//	    	  }	
			
			//	});
	 
			
				 function delrow()
	 {
		alert('reached delete row');
		var index = $('#spldep tr:last').attr('data-id');
		alert(index);
		for(i=0;i<=index;i++)
			 {
			 			if ($('#selected_row'+i).prop("checked"))
			 			{ 
			 					
			 				$('#tr_'+i).remove();
			 				}
			 			
			 }
	 }			
			 			
				 function selSplAgnDep(index){
					 alert("selSplAgnDep"+index);
					 alert("depositTyp :: "+document.getElementById("depositTyp"+index).value);
					 if(document.getElementById("depositTyp"+index).value == document.forms[0].episodeType.value){
					 document.getElementById("depositTyp").value=document.getElementById("depositTyp"+index).value;
					 }else{
						 document.getElementById("depositTyp").value=document.forms[0].episodeType.value;
					 }
					 document.getElementById("effFrom").value=document.getElementById("effFrom"+index).value;
					 document.getElementById("effTo").value=document.getElementById("effTo"+index).value;
				 }
				 
				 function depType(index){
					 alert("depType"+index);
					 var rowId= index-1;
					 var depTyp=document.getElementById("depositTyp").value;
				     alert("depTyp"+depTyp);
					 var selDepTyp=document.forms[0].episodeType.value;
					 alert("selDepTyp"+selDepTyp);
				     
				     if(depTyp!=selDepTyp){
				    	 alert("Invalid episode type");
				    	 document.forms[0].depositTyp.value=document.forms[0].episodeType.value;
				     }
				 }
				 
				 function setDepositType(){
					 document.forms[0].depositTyp.value=document.forms[0].episodeType.value;
				 }
				 
				 function splAgnDepSubmit(index){
					 alert("splAgnDepSubmit");
					 var rowId= index-1;
					 var effFromSel=document.getElementById("effFrom"+rowId).value;
					 var effToSel=document.getElementById("effTo"+rowId).value;
					 
					 var depositTyp=document.forms[0].depositTyp.value;	
					 var effFrom=document.forms[0].effFrom.value;	
					 var effTo=document.forms[0].effTo.value;	
					 alert("effFromSel/effFrom"+effFromSel+"/"+effFrom);
					 
					 if(effFromSel==''||effToSel==''){
						 if(effFrom=='' && effTo==''){
							 alert("Please enter Effective From & Effective To Dates");
							 return;
						 }
						 if(effFrom==''){
							 alert("Please enter Effective From Date");
							 return;
						 }
						 if(effTo==''){
							 alert("Please enter Effective To Date");
							 return;
						 }
					 }
					 
						var retVal=depositTyp+"::"+effFrom+"::"+effTo;    
						alert("retVal :" +retVal);
						parent.window.returnValue = retVal;
						parent.window.close();
// 						top.returnValue = retVal;
// 						top.close();

				 }
				 
				 function cancel()
				 {
				 	parent.window.close();
				 }
</script>

</head>

<%
	Connection con = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;
	Statement stmt = null;

	SpecialAgencyDepositBean splAgnDepBn = null;
	List<SpecialAgencyDepositBean> splAgenDepList = new ArrayList<SpecialAgencyDepositBean>();

	String beanId = "SpecialAgencyDepositBean";
	String beanName = "eBL.SpecialAgencyDepositBean";
	SpecialAgencyDepositBean specialAgencyDepositBean = (SpecialAgencyDepositBean) getBeanObject(
			beanId, beanName, request);

	try {
		con = ConnectionManager.getConnection();

		try
		{
			
			String query_date="select sysdate from dual";
			stmt = con.createStatement();
			rst = stmt.executeQuery(query_date) ;
			if( rst != null ) 
			{
				while( rst.next() )
				{  
					systemDate = formatDate(rst.getString(1));
					System.out.println("systemDate :::: " + systemDate);
				}
			}
			stmt.close();
			rst.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in Sys Date :"+e);
		}
		
		
		
		String sql = "{ call  IBAEHIS.bl_proc_receipt_refund_main.get_spl_age_dep_dtls(?,?,?,?) }";
		cstmt = con.prepareCall(sql);
		cstmt.setString(1, facilityId);
		cstmt.setString(2, patientId);
		cstmt.setString(3, episodeType);
		cstmt.registerOutParameter(4, OracleTypes.CURSOR);
		cstmt.execute();
		rst = (ResultSet) cstmt.getObject(4);

		System.out.println("rst :::" + rst);

		if (rst != null) {
			//System.out.println("rst.next() :::" + rst.next());
			while (rst.next()) {
				System.out.println("inside iterator");
				splAgnDepBn = new SpecialAgencyDepositBean();
				splAgnDepBn.setDepositType(rst.getString("deposit_type"));
				splAgnDepBn.setDepositAmt(rst.getString("deposit_amount"));
				splAgnDepBn.setUtilizedAmt(rst.getString("utilized"));
				splAgnDepBn.setBalance(rst.getString("balance"));
				splAgnDepBn.setEffFrom(rst.getString("effective_from_date"));
				splAgnDepBn.setEffTo(rst.getString("effective_to_date"));

				System.out.println("splAgnDepBn VALUES" + rst.getString("deposit_type")
						+ "/" + rst.getString("deposit_amount") + "/"
						+ rst.getString("effective_from_date") + "/"
						+ rst.getString("effective_to_date"));
				splAgenDepList.add(splAgnDepBn);
			}
		}
	} catch (Exception e) {
		System.err.println("Exception in SpecialAgencyDeposit -> " + e);
		e.printStackTrace();
	} finally {
		cstmt = null;
		rst = null;
		ConnectionManager.returnConnection(con);
	}
%>
<body onLoad="setDepositType();">

<form name='SplAgency' id='SplAgency' method='post' action=''  scrolling=no >
<div>
	<table  border='1' cellpadding='3' cellspacing='0' align='center' width='100%'>	
	<tr><td class='columnHeader' colspan='16'><fmt:message key="eBL.DepositDetails.label" bundle="${bl_labels}"/></td></tr>
	</table></div>
	<br/><br/>
	<div overflow:scroll>  
	<!-- id="tblcontainer" STYLE="overflow: auto; width: 1020px; height: 195px;   padding:3px; margin: 0px">-->
	
	<table id='spldeposit' border='1' cellpadding='3' cellspacing='0' align = 'center'  width='100%'>	
	
		<tr>	
	 	<td class='COLUMNHEADER' width='2.5%'><fmt:message key="eBL.DEPOSIT_TYPE.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="eBL.DepositAmount.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="eBL.UtilizedAmount.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="Common.Balance.label" 	bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='1.5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<%-- 		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="eBL.RefundAmount.label" bundle="${common_labels}"/></td>				 --%>
		</tr>
 </table>
 
 	
  	<table id='spldep' border='1' cellpadding='3' cellspacing='0' align = 'center' id='' width='100%'>	
	
	<%
				int tableIndex = 1;
	
				if (splAgenDepList == null || splAgenDepList.isEmpty()) {
					SpecialAgencyDepositBean splAgDpBean = new SpecialAgencyDepositBean();
					splAgenDepList = new ArrayList<SpecialAgencyDepositBean>();
					splAgenDepList.add(splAgDpBean);
				}
				
				for (SpecialAgencyDepositBean splAgenDepBean : splAgenDepList) {	
					
					 String eff_from_date=formatDate(splAgenDepBean.getEffFrom());
					 String eff_to_date=formatDate(splAgenDepBean.getEffTo());

			%>
			
	<tr data-id='1' id='tr_1'> 
 	<td  width='2.5%' class='fields'>
 	<select name='depositTyp<%=tableIndex%>' id='depositTyp<%=tableIndex%>' id='depositTyp<%=tableIndex%>' onChange=" ">
 	<%
 		if ("O".equals(splAgenDepBean.getDepositType())) {
 	%>
 	<option value='O' selected><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
 	<%
 		} else {
 	%>
	<option value='O'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
	<%
		}
			if ("R".equals(splAgenDepBean.getDepositType())) {
	%>
 	<option value='R' selected><fmt:message key="Common.external.label" bundle="${bl_labels}"/></option>
 	<%
 		} else {
 	%>
	<option value='R'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
	<%
		}
			if ("E".equals(splAgenDepBean.getDepositType())) {
	%>
 	<option value='E' selected><fmt:message key="Common.emergency.label" bundle="${bl_labels}"/></option>
 	<%
 		} else {
 	%>
	<option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
	<%
		}
			if ("I".equals(splAgenDepBean.getDepositType())) {
	%>
 	<option value='I' selected><fmt:message key="Common.inpatient.label" bundle="${bl_labels}"/></option>
 	<%
 		} else {
 	%>
	<option value='I'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
	<%
		}
			if ("D".equals(splAgenDepBean.getDepositType())) {
	%>
 	<option value='D' selected><fmt:message key="Common.daycare.label" bundle="${bl_labels}"/></option>
 	<%
 		} else {
 	%>
	<option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
	<%
		}
	%>
 	</select> 
 	</td> 
 	<td  width='3.5%' class='fields'><input type='text' id='depositAmt<%=tableIndex%>' name='depositAmt<%=tableIndex%>' size='10' maxlength='30' value='<%=checkForNull(splAgenDepBean.getDepositAmt())%>' readonly> </td> 
 	 <td  width='3.5%' class='fields'><input type='text' id='utilizedAmt<%=tableIndex%>' name='utilizedAmt<%=tableIndex%>' size='10' maxlength='30' value='<%=checkForNull(splAgenDepBean.getUtilizedAmt())%>' readonly> </td> 
 	<td  width='3.5%' class='fields'><input type='text' id='balance<%=tableIndex%>' name='balance<%=tableIndex%>' size='10' maxlength='30' value='<%=checkForNull(splAgenDepBean.getBalance())%>' readonly> </td> 
 	<td  width='3.5%' class='fields'><input type='text' id='effFrom<%=tableIndex%>' name='effFrom<%=tableIndex%>' size='10' maxlength='30' value='<%=eff_from_date%>' readonly> </td> 
 	 <td  width='3.5%' class='fields'><input type='text' id='effTo<%=tableIndex%>' name='effTo<%=tableIndex%>' size='10' maxlength='30' value='<%=eff_to_date%>' readonly> </td>  
 	<td  width='1.5%'  class='fields'><input type="checkbox" name='selected_row' id='selected_row' id='selected_row' value='' onClick="selSplAgnDep(<%=tableIndex%>);"></td>	  
<!-- 	<td  width='3.5%' class='fields'><input type='text' id='refundamtname='refundAmt' size='10' maxlength='30' value='' > </td> -->
	
	</tr> 
	<%
 		tableIndex++;
 		}
 	%>
	</table>	
	<table border='0' cellpadding='0' cellspacing='0'  align = 'center' id='tbl' width='30%'>	
	<tr>
	<td class="label" width="2%"><fmt:message key="eBL.DEPOSIT_TYPE.label"	bundle="${bl_labels}"/>
	</td>
	 	<td  width='2.5%' class='fields'>
 	<select name='depositTyp' id='depositTyp' id='depositTyp' onChange="depType(<%=tableIndex%>,depositTyp);" >
 		<option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
		<option value='O'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
		<option value='I'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
		<option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
		<option value='R'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
  	</select> 
 	</td> 
	</tr>
	<tr>
	<td class="label" width="2%"><fmt:message key="Common.EffectiveFrom.label"	bundle="${common_labels}"/>
	</td>
	<td class='fields' nowrap>
					<input type='text' id='effFrom' name='effFrom' id='effFrom' size='10'  value='<%=effFromDt%>' onblur='chkDtGreaterThanSysDate(effFrom,systemDate);' >
					<img src='../../eCommon/images/CommonCalendar.gif'  id='effFrom_ctrl'  onClick="return showCalendar('effFrom');" />
	</td>
	</tr>
	<tr>
	<td class="label" width="2%"><fmt:message key="Common.EffectiveTo.label"	bundle="${common_labels}"/>
	</td>
	<td class='fields' nowrap>
					<input type='text' id='effTo' name='effTo' id='effTo' size='10'  value='<%=effToDt%>' onblur='validDateChk(this);compareDates(effFrom,effTo);' >
					<img src='../../eCommon/images/CommonCalendar.gif'  id='effFrom_ctrl'  onClick="return showCalendar('effTo');" />
	</td>
	</tr>
	<tr>	<td>
		<INPUT TYPE='button' name='ok_button' name='ok_button' id='ok_button' class="BUTTON"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,
					"Common.ok.label", "common_labels")%>"     size='5' onClick='splAgnDepSubmit(<%=tableIndex%>);'>
		</td>
		<td>
		<INPUT TYPE='button' name='cancel_button' id='cancel_button' id='cancel_button' class="BUTTON" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,
					"Common.cancel.label", "common_labels")%>" size='5' onClick='cancel()'>
		</td>
</tr>
	</table>
	 </div> 
	
<%
 		String locale = (String) session.getAttribute("LOCALE");
 		if (locale == null || locale.equals(""))
 			locale = "en";

 		String facilityid = (String) session.getValue("facility_id");
 		if (facilityid == null)
 			facilityid = "";
 	%>


<input type= 'hidden' name="locale" id="locale"  value="<%=locale%>">
<input type= 'hidden' name="facility_id" id="facility_id"  value="<%=facilityid%>">	
<input type= 'hidden' name="episodeType" id="episodeType"  value="<%=episodeType%>">	
<input type= 'hidden' name="systemDate" id="systemDate"  value="<%=systemDate%>">	


	  <%!private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	  }
		
	  private String formatDate(String inputDate){
			System.out.println("formatDate "+inputDate);
			if(inputDate==null || inputDate.equals("")){
				return "";
			}
			else
			{
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    Timestamp inputTimeStamp = null;
		    String outputDate=inputDate;
		    long longTimeStamp = 0;
		    inputTimeStamp = Timestamp.valueOf(inputDate);
		    longTimeStamp = inputTimeStamp.getTime();
		    outputDate=sdf.format(longTimeStamp);
		    return outputDate;	
			}
		}
	%>
</body>
</html>

