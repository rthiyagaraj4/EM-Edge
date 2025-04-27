<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Progress Status</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String reqId = request.getParameter("reqId");
	String closeDisabled = request.getParameter("closeDisable");
	if(closeDisabled == null)	closeDisabled="";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(){
		var reqId = $('#reqId').val();
		var patData = loadPatientDetails(reqId);
		var patDataArr = patData.split('::');
		
		$('#trRow1').css('visibility','visible');
		$('#trRow2').css('visibility','visible');
		$('#trRow3').css('visibility','visible');
		
		$('#patIdLabel').text('Patient Id');
		$('#patId').text(patDataArr[0]);
		$('#epiTypeLabel').text('Episode Type');
		$('#epiType').text(patDataArr[1]);
		
		$('#patNameLabel').text('Patient Name');
		$('#patName').text(patDataArr[4]);
		$('#epiLabel').text('Episode Id');
		$('#episode').text(patDataArr[2]);
		$('#visitLabel').text('Visit Id');
		$('#visitId').text(patDataArr[3]);
		
		var progress = checkProgress(reqId);
		var progArr = progress.split('::');
		if(progArr[0] == 'C'){
			window.returnValue = 'Y';
			window.close();
		}
		else if(progArr[0] == 'F'){
			window.returnValue = 'F';
			window.close();
		}
		else{
			$('#message').css('visibility','visible');
			$('#processed').text(progArr[1]);
			$('#total').text(progArr[2]);
			var cnt = 1;
			var intr = setInterval(function chkProg(){
				cnt++;
				var status = checkProgress(reqId);
				var statusArr = status.split('::');
				if(statusArr[0] == 'C'){
					clearInterval(intr);
					window.returnValue = 'Y';
					window.close();
				}
				else if(statusArr[0] == 'F'){
					clearInterval(intr);
					window.returnValue = 'F';
					window.close();
				}
				else{
					$('#processed').text(statusArr[1]);
					$('#total').text(statusArr[2]);
				}
			}, 5000);
		}
		
		$('#refersh').click(function(){
			var status = checkProgress(reqId);
			var statusArr = status.split('::');
			if(statusArr[0] == 'C'){
				$('#processed').text(statusArr[1]);
				$('#total').text(statusArr[2]);
				window.returnValue = 'Y';
				window.close();
				
			}
			else if(statusArr[0] == 'F'){
				window.returnValue = 'F';
				window.close();
			}
			else{
				$('#processed').text(statusArr[1]);
				$('#total').text(statusArr[2]);
			}
		});
		
		$('#close').click(function(){
			window.returnValue = 'Y';
			window.close();
		});
	});
	
	function checkProgress(reqId){
		var progress = 'I';
		$.ajax({
			type:"GET",
			url:"../jsp/PkgSubscriptionValidation.jsp?reqId="+reqId,
			data:"func_mode=getProgressCount",
			dataType:"text",
			async:false,
			success: function(data){
				progress = $.trim(data);
				
			},
			 error: function(data){
				 progress = 'I';
		      }
		});
		return progress;
	}
	
	function loadPatientDetails(reqId){
		var patData = '';
		$.ajax({
			type:"GET",
			url:"../jsp/PkgSubscriptionValidation.jsp?reqId="+reqId,
			data:"func_mode=getPatData",
			dataType:"text",
			async:false,
			success: function(data){
				patData = $.trim(data);
				
			},
			 error: function(data){
				 patData = '';
		      }
		});
		return patData;
	}
</script>
</head>
<body>
	<table width="90%" align="center">
		<tr id='trRow1' style="visibility: hidden;">
			<td id='patIdLabel'  style="width: 25%; font-size: 11px;"></td>
			<td id='patId' style="width: 25%; font-size: 11px;"></td>
			<td id='epiTypeLabel' style="width: 25%; font-size: 11px;" ></td>
			<td id='epiType' class='label' style="width: 25%"></td>
		</tr>
		<tr id='trRow2' style="visibility: hidden;">
			<td id='epiLabel' style="width: 25%; font-size: 11px;" ></td>
			<td id='episode' style="width: 25%; font-size: 11px;" ></td>
			<td id='visitLabel' style="width: 25%; font-size: 11px;" ></td>
			<td id='visitId' style="width: 25%; font-size: 11px;" ></td>
			
		</tr>
		<tr  id='trRow3' style="visibility: hidden;">
			<td id='patNameLabel' style="width: 25%; font-size: 11px;" ></td>
			<td id='patName' style="width: 25%; font-size: 11px;" ></td>
		</tr>
	</table>
	<div align="center">
		<br/>
		<%if("Y".equals(closeDisabled)){ %>
			<h6 >Financial Calculation in Progress for the previous job request...</h6>
			<h6 >Current job request cannot be processed until the previous request has been completed...</h6>
		<%}
		else{ %>
			<h6 >Financial Calculation in Progress...</h6>
		<%} %>
		<br/>
		<h6  id='message' style="visibility: hidden;"><span id='processed' style="padding-right: 5px;padding-left: 5px;"></span>of<span id='total' style="padding-left: 5px;padding-right: 5px;"></span> Records Processed</h6>
		<br/>
		<input class='button' type='button' id='refersh' name='refresh' id='refresh' value='Refresh'> &nbsp;
		<%if("Y".equals(closeDisabled)){ %>
		<input class='button' type='button' id='close' name='close' id='close' value='Close' disabled>
		<%}
		else{ %>
			<input class='button' type='button' id='close' name='close' id='close' value='Close' >
		<%} %>
	</div>
	<input type='hidden' name='reqId' id='reqId' id='reqId' value='<%=reqId %>'>
</body>
</html>

