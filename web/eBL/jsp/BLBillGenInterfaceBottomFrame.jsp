<!DOCTYPE html>
<%@ page  import="eBL.*,eBL.Common.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" 			contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<html>
<head>



<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>



<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language='javascript' src='../js/json2.js'></script>
		<script language="javascript" src="../../eBL/js/BLBillGenInterfaceJs.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		

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
		
	
SPAN.LABEL
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

SPAN.LABEL1
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  /*TEXT-ALIGN: LEFT;*/
  TEXT-ALIGN: RIGHT;
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}

SPAN.SpanYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
		
		
		.ordered{
		width: 12.5px;
		height: 03px;
		background: #5A0000;
	}
	.registered{
		width: 12.5px;
		height: 03px;	
		background: #000080;
	}
	.completed{
		width: 12.5px;
		height: 03px;
		background: #FFFF00;
	}
	.resulted{
		width: 12.5px;
		height: 03px;
		background: #00FF00;
	}
		
		
		
		
	</style>

<script>

$(document).ready(function(){
	
	$('#charging_state').attr('disabled','disabled');
	$('#btmframecontainer').hide();

	
}); 

</script>

</head>
<body>
<Form name='btm_frame' id='btm_frame' id='btm_frame'>
<div id='btmframecontainer'>
<fieldset>

<table border='' cellpadding='3' cellspacing='0'  id='tbl_bottom_frame' width='100%' >
<thead>
<tr>
<td width='5%' class='COLUMNHEADER'><fmt:message key="eBL.patientno.label" bundle="${bl_labels}"/></td>
<td width='5%' class='COLUMNHEADER'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
<td width='5%' class='COLUMNHEADER'><fmt:message key="Common.episodeid.label" bundle="${bl_labels}"/></td>
<td width='5%' class='COLUMNHEADER'><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></td>
<td width='5%' class='COLUMNHEADER'><fmt:message key="eBL.ChargingState.label" bundle="${bl_labels}"/></td>


</tr>
</thead>
<tbody>
<tr>
<td width='5%' align='center'><span class="LABEL" name='patient_no' id='patient_no'   value=''</span></td>
<td width='5%' align='center'><span class="LABEL" name='patient_name' id='patient_name'  value=''</span></td>
<td width='5%' align='center'><span class="LABEL" name='episode_id' id='episode_id'   value=''</span></td>
<td width='5%' align='center'><span class="LABEL" name='visit_id' id='visit_id'  value=''</span></td>
<td width='5%' align='center'><span><select name='charging_state' id='charging_state' id='charging_state' >
<option value='ORD'> On Order</option>
<option value='REG'> On Registration</option>
<option value='RST'> On Result</option>
<option value='CMP'>On Completion </option>


</select>
</span>
</td>
</tr>

</tbody>

</table>
</fieldset>
</div>
<table style="width: 90%;" align="center">
		<tr>
	
		
		
			<td style="width: 1%;">
				<span class='Ordered'></span>
				<td style="width: 5%;" class='LABEL'>
			Ordered
			</td>
			<td style="width: 1%;">
				<span class='Registered'></span>
				<td style="width: 5%;" class='LABEL'>
			Registered
			</td>
			<td style="width: 1%;">
				<span class='Completed'></span>
			<td style="width: 5%;" class='LABEL'>
			Completed
			</td>
				
			
	
			<td style="width: 1%;">
				<span class='Resulted'></span>
				<td style="width: 5%;" class='LABEL'>
			Resulted
		
				
			</td>
		</tr>


</Form> 



</body>
</html>

