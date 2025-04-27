<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String reportId="BLRAPPPD";
		String locale = (String)session.getAttribute("LOCALE");
		String facilityId = (String)session.getAttribute("facility_id");
		if (facilityId==null) facilityId = "";
		String	strLoggedUser	=  (String) session.getValue("login_user");	
		if (strLoggedUser==null) strLoggedUser = "";
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal=Calendar.getInstance();
		String todaysDate=dateFormat.format(cal.getTime());
		cal.add(Calendar.DATE, -31);
		String backDate=dateFormat.format(cal.getTime());
		System.out.println("facilityId:"+facilityId+" strLoggedUser:"+strLoggedUser+" todaysDate:"+todaysDate+" backDate:"+backDate);
%>
<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eBL/js/BLPatientPayerSummayDetail.js'></script>
		<script type="text/javascript">
		 $(document).ready(function(){
			 
			 	$('#custGrpCode').focus();
			
			 	if($('#Bill_Duration_From').val()==''){
					$('#Bill_Duration_From').val($('#backDate').val());
				}
				if($('#Bill_Duration_To').val()==''){
					$('#Bill_Duration_To').val($('#todaysDate').val());
				} 
				
			$('#selectall').change(function () {
				if($(this).prop('checked')){
					$('[id^=Episodetype_]').prop('checked', true);
					$('[id^=Episodetype_]').val('Y');		
				}else{
					$('[id^=Episodetype_]').prop('checked', false);
					$('[id^=Episodetype_]').val('N');			
				}
			});
			$('#Episodetype_OP').change(function(){
				$('#selectall').prop('checked', false);
			    if($(this).prop('checked')){
			        $(this).val('Y');   
			    }else{
			        $(this).val('N');	
			    }
			});
			$('#Episodetype_IP').change(function(){
				$('#selectall').prop('checked', false);
			    if($(this).prop('checked')){
			        $(this).val('Y');
			    }else{
			        $(this).val('N');
			    }
			});
			$('#Episodetype_EM').change(function(){
				$('#selectall').prop('checked', false);
			    if($(this).prop('checked')){
			        $(this).val('Y');
			    }else{
			        $(this).val('N');
			    }
			});
			$('#Episodetype_DC').change(function(){
				$('#selectall').prop('checked', false);
			    if($(this).prop('checked')){
			        $(this).val('Y');
			    }else{
			        $(this).val('N');
			    }
			});
			
		    $('#detail').change(function(){	 
		    	if(this.checked){
		    		$('#rb').val('D');
		    	} 
			});
		    $('#summary').change(function(){
		        if(this.checked){
		    		$('#rb').val('S');
		    	} 
		    });
		    
		    $('#patientwisebut').change(function(){
					$('#ppwb').val('P');
		    	 	$('#report_id').val('BLRAPPPD');
		    	 	$('#detail').attr('disabled',false);
		    	 	$('#summary').attr('disabled',false); 
		    	if($('#detail').is(':checked')){
		    		$('#rb').val('D');
		    	} 
		    });   
 			$('#payerwisebut').change(function(){
		    	 	$('#report_id').val('BLRAPPCD');
		    	 	$('#detail').attr('disabled',true);
		    		$('#summary').attr('disabled',false); 
		    	 	$('#summary').attr('checked','checked');
		    	 	$('#rb').val('S');
		    	 	$('#ppwb').val('C'); 
		    });	     	  	     
		});
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body>
<form name="check id=" id="check id="check">
<table width="90%" align="center" cellpadding=6 cellspacing=0 >
	<tr style="padding-bottom: 10px;">
		<td width="10%" nowrap class='label'  style="text-align: left;" > 
		   <fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/>
		</td>
		<td width="20%" nowrap class='fields' style="text-align: left;">
			<input type="text" name='custGrpCode' id='custGrpCode' id='custGrpCode' size="10" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,1,1); } else{ fnClearCode(custGrpDesc);  }">&nbsp;
			<input type="text" name='custGrpDesc' id='custGrpDesc' id='custGrpDesc' size="30" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,1,2); } else{ fnClearCode(custGrpCode);  }">&nbsp;
			<input type="button" class="button" value='?' name="custGrpBtn" id="custGrpBtn" id="custGrpBtn" onClick="callCommonLookupCode(custGrpDesc,custGrpCode,1,2);" ><img src='../../eCommon/images/mandatory.gif'></td>
		</td>
		<td style="padding-top: 10px;" width="10%" nowrap></td>
		<td width="10%" nowrap class='label'  style="text-align: left;">
			<fmt:message key="eBL.BILL_DATE.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<fmt:message key="eBL.From.label" bundle="${bl_labels}"/>&nbsp;&nbsp;
			<input type="text" name="Bill_Duration_From" id="Bill_Duration_From" id="Bill_Duration_From" size="10" maxlength='10' value='' onBlur='return checkDateBL(document.forms[0].Bill_Duration_From)' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Bill_Duration_From');"><img src='../../eCommon/images/mandatory.gif'>
		</td>
		<td width="20%" nowrap class='label' style="text-align: left;">
			<fmt:message key="eBL.To.label" bundle="${bl_labels}"/>&nbsp;&nbsp;
			<input type="text"  name="Bill_Duration_To" id="Bill_Duration_To"  id="Bill_Duration_To"   size="10" maxlength='10' value='' onBlur='return toFromDateChk(document.forms[0].Bill_Duration_To)' ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Bill_Duration_To');"><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr>
		<td width="10%" nowrap class='label' style="text-align: left;">
			<fmt:message key="eBL.CustomerCode.label" bundle="${bl_labels}"/>
		</td>
		<td width="20%" nowrap class='fields' style="text-align: left;">
			<input type="text" name='custCode' id='custCode' id='custCode' size="10" onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,2,1); } else{ fnClearCode(custDesc);}" value="**">&nbsp;
			<input type="text" name='custDesc' id='custDesc' id='custDesc' size="30" onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,2,2); } else{ fnClearCode(custCode);}" value="All Payer">&nbsp;
			<input type="button" class="button" name="custBtn" id="custBtn" id='custBtn' value='?' onClick="callCommonLookupCode(custDesc,custCode,2,2)"><img src='../../eCommon/images/mandatory.gif'>
		</td>
		<td style="padding-top: 10px;" width="10%" nowrap></td>
		<td width="10%" nowrap class='label' style="text-align: left;">
			<fmt:message key="eBL.ApprovalStatus.label" bundle="${bl_labels}"/>
		</td>
		<td width="20%" nowrap class='fields' style="text-align: left;">
			<select id="App_status" name="App_status" id="App_status"  style="width: 120px;">					
					<option value="A">Approved</option>
					<option value="U">UnApproved</option>
					<option value="B">All</option>
			</select>	
		</td>
	</tr>
	<tr>
		<td width="10%" nowrap class='label' style="text-align: left;">
			<fmt:message key="eBL.EpisodeType.label" bundle="${bl_labels}"/>
		</td>
		<td width="20%" nowrap class='label' style="text-align: left;">
			OP<input  style="margin-right:15px" class="checkbox" type="checkbox" id='Episodetype_OP' value='Y' checked>
			IP<input  style="margin-right:15px" class="checkbox" type="checkbox" id="Episodetype_IP" value='N'>
			EM<input  style="margin-right:15px" class="checkbox" type="checkbox" id="Episodetype_EM" value='N'>
			DC<input  style="margin-right:15px" class="checkbox" type="checkbox" id="Episodetype_DC" value='N'>
   			ALL<input style="margin-right:15px" class="checkbox" type="checkbox" id="selectall" >
		</td>
		<td style="padding-top: 10px;" width="10%" nowrap></td>
		<td width="10%" nowrap class='label' style="text-align: left;">
			<input type="radio" name="patientpayerwisebut" id="patientpayerwisebut" id="patientwisebut" checked><fmt:message key="eBL.PatientWise.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="patientpayerwisebut" id="patientpayerwisebut" id="payerwisebut" ><fmt:message key="eBL.PayerWise.label" bundle="${bl_labels}"/>   	
		</td>
		<td width="20%" nowrap class='label' style="text-align: left;">
			<input type="radio" name="reportbut" id="reportbut"  id="summary" checked><fmt:message key="Common.Summary.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="reportbut" id="reportbut"  id="detail"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/>
		</td>
	</tr>
			<input type="hidden" name="locale" id="locale" 		id="locale" 	 value="<%=locale %>">
			<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facilityId %>">
			<input type="hidden" name="report_id" id="report_id" 	id="report_id" 	 value="<%=reportId %>">
			<input type="hidden" name="ppwb" id="ppwb" 		id="ppwb" 		 value="P">
			<input type="hidden" name="rb" id="rb" 			id="rb" 		 value="S">
			<input type="hidden" name="todaysDate" id="todaysDate"	id="todaysDate"  value="<%=todaysDate %>">
			<input type="hidden" name="backDate" id="backDate" 	id="backDate" 	 value="<%=backDate %>">
			<input type="hidden" name="userid" id="userid" 	    id="userid" 	 value="<%=strLoggedUser %>">
</table>
</form>
</body>	
</HTML>

