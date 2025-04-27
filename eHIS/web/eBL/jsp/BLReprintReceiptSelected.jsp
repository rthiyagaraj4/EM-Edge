<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../js/BLReprintReportReceipt.js'></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
<script language='javascript' src='../../eBL/js/BLReprintReportReceipt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	var selectedReceipt = '';
	$(document).ready(function(event){
		$("input[type='text']").keydown(function(e){
			if (e.which === 8 && !$(e.target).is("input[type='text']:not([readonly])")) {
				e.preventDefault();
		    }
		});
	})
</script>
<style>
	div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 160px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}
	table {
		width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
		border: none;
		background-color: #f7f7f7;
		}
	table>tbody	{  /* child selector syntax which IE6 and older do not support*/
		overflow: auto; 
		height: 120x;
		overflow-x: hidden;
		}		
	thead tr	{
		position:relative; 
		top: expression(offsetParent.scrollTop); /*IE5+ only*/
		}			
			div.tableContainer {
			width: 100%;		/* table width will be 99% of this*/
			height: 140px; 	/* must be greater than tbody*/
			overflow: scroll;
			margin: 0 auto;
		}	
	TD.YELLOW 
		{			
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
.QRYEVEN
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT;
  /*TEXT-ALIGN: RIGHT;*/
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}

</style>
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<form name='selectedReceiptForm' id='selectedReceiptForm' target='messageFrame'>
		<div id="tableContainer">
			<table border='' id='tblSelectedReport' style="display: none;" cellpadding='3' cellspacing='0'  id='tbl' width='100%' >	
			<thead style="position: sticky;z-index: 1;top: 0;">
			<tr>						
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' id='removeAll' width='12%' style='cursor:pointer' onclick="RemoveAllTooltip(this);" onmouseover="hideToolTip();"><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/>		
				<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow'> 
				</td>					
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}"/></td>								
				<td class='COLUMNHEADER' width='11%'><fmt:message key="eBL.ReceiptNatureCode.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.ReceiptTypeCode.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='12%'><fmt:message key="eBL.DocAmt.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>	
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.episodeId.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='7%'><fmt:message key="eBL.voidNumber.label" bundle="${bl_labels}"/></td>
			</tr>
			</thead>
			<tbody id='selectedReportBody'>
		
			</tbody>
			</table>		
			<input type ='hidden' name='indexTrack' id='indexTrack'  value='0'>
			<input type = 'hidden' name ='mode' id ='mode' value =''>
			<input type = 'hidden' name ='action1' id ='action1'  value =''>
			<input type = 'hidden' name ='lastindx' id ='lastindx'  value =''>
			<input type = 'hidden' name ='facilityId' id ='facilityId' value=''>
			<input type = 'hidden' name ='login_user' id ='login_user' value=''>
			<input type = 'hidden' name ='cancel_reasoncode' id ='cancel_reasoncode' value=''>	
			<input type = 'hidden' name ='cancel_reason' id ='cancel_reason' value=''>	
			<input type = 'hidden' name ='void_number' id ='void_number' value=''>		
			<input type = 'hidden' name ='print_option' id ='print_option' value=''>
			<input type = 'hidden' name ='p_alert_flag' id ='p_alert_flag' value=''>
			<input type = 'hidden' name ='receiptCount' id = 'receiptCount' value='0'>
			
		</div>
	</form>				
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
	<div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:12%; visibility:hidden;' bgcolor='blue'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
	<tr>
	<td width='100%' id='t'></td>
	</tr>
	</table>
    </div>		
	</body>					
</html>

