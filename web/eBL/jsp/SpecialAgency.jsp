<!DOCTYPE html>
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
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
			
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
			 			
	 
</script>

</head>
<body>

<form name='SplAgency' id='SplAgency' method='post' action=''  scrolling=no >
<div>
	<table  border='1' cellpadding='3' cellspacing='0' align='center' width='100%'>	
	<tr><td class='columnHeader' colspan='16'><fmt:message key="eBL.Depositdetails.label" bundle="${bl_labels}"/></td></tr>
	</table></div>
	<br/><br/>
	<div overflow:scroll>  
	<!-- id="tblcontainer" STYLE="overflow: auto; width: 1020px; height: 195px;   padding:3px; margin: 0px">-->
	
	<table id='spldeposit' border='1' cellpadding='3' cellspacing='0' align = 'center'  width='100%'>	
	
		<tr>	
	 	<td class='COLUMNHEADER' width='2.5%'><fmt:message key="eBL.DEPOSIT_TYPE.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="eBL.Depositamount.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="eBL.Utilizedamount.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="Common.Balance.label" 	bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='1.5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='3.5%'><fmt:message key="eBL.RefundAmount.label" bundle="${common_labels}"/></td>				
		</tr>
 </table>
 
 	
  	<table id='spldep' border='1' cellpadding='3' cellspacing='0' align = 'center' id='' width='100%'>	
	
	
	<tr data-id='1' id='tr_1'> 
 	<td  width='2.5%' class='fields'><select name='dep_type' id='dep_type' id='dep_type'  onChange=" "> </td> 
 	<td  width='3.5%' class='fields'><input type='text' id='dep_amt' name='dep_amt' id='dep_amt' size='10' maxlength='30' value='' > </td> 
 	 <td  width='3.5%' class='fields'><input type='text' id='utilizedamt' name='utilizedamt' id='utilizedamt' size='10' maxlength='30' value='' > </td> 
 	<td  width='3.5%' class='fields'><input type='text' id='balance' name='balance' id='balance' size='10' maxlength='30' value='' > </td> 
 	<td  width='3.5%' class='fields'><input type='text' id='effectivefrom' name='effectivefrom' id='effectivefrom' size='10' maxlength='30' value='' > </td> 
 	 <td  width='3.5%' class='fields'><input type='text' id='effectiveto' name='effectiveto' id='effectiveto' size='10' maxlength='30' value='' > </td>  
 	<td  width='1.5%'  class='fields'><input type="checkbox" name='selected_row' id='selected_row' id='selected_row' value='' onClick=""></td>	  
	<td  width='3.5%' class='fields'><input type='text' id='refundamt' name='refundamt' id='refundamt' size='10' maxlength='30' value='' > </td>
	
	</tr> 
	</table>	
	 </div> 
	
<%
String locale	= (String)session.getAttribute("LOCALE");	
if(locale==null || locale.equals("")) locale="en";	

String facilityid = (String) session.getValue("facility_id");
if (facilityid==null) facilityid = "";


%>
<div>
<table>
<tr>
<td width='25%'>
</td>
<td width='25%'>
</td>
<td width='25%'>
</td>
</tr>
<tr>	<td width='25%'>
		<INPUT TYPE='button' name='add_button' id='add_button' id='add_button' class="BUTTON" VALUE="Add Row" size='5' onClick='addrow();'>
		<INPUT TYPE='button' name='del_button' id='del_button' id='del_button' class="BUTTON" VALUE="Delete Row" size='5' onClick='delrow();'></td>
		<td>
		<td width='25%'></td>
		<td width='25%'></td>
</tr>
</table>
</div>

<input type= 'hidden' name="locale" id="locale"  value="<%=locale%>">
	<input type= 'hidden' name="facility_id" id="facility_id"  value="<%=facilityid %>">	
	 
</body>
</html>

