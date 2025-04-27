<!DOCTYPE html>
<%
/*
Sr No            Version            Incident             SCF/CRF           Developer Name
1 		V220909		    33891	  TH-KW-CRF-0093         Mohanapriya K
*/
%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.RecordApprovalPatientDataBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String calledForm=request.getParameter("calledForm");
	System.err.println("calledForm "+calledForm);
	String enableMCNNumber=request.getParameter("enableMCNNumber");
	System.err.println("enableMCNNumber BillingRecordApprovalPatientDataBtn.jsp ::"+enableMCNNumber);
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/BillingRecordApprovalScript.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

var ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL	=	"<%=BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")%>";
var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL	=	"<%=BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")%>";	
var PAYER_LOOKUP_RECORD_PREAPPROVAL			=	"<%=BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")%>";	
var POLICY_LOOKUP_RECORD_PREAPPROVAL		=	"<%=BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")%>";	
var headTop = -1;
var FloatHead1;
function processScroll()
	{
		if (headTop < 0)
		{
			saveHeadPos();
			
		}
		if (headTop>0)
		{
			if (document.documentElement && document.documentElement.scrollTop)
				theTop = document.documentElement.scrollTop;
			else if (document.body)
				theTop = document.body.scrollTop;

			if (theTop>headTop)
				FloatHead1.style.top = (theTop-headTop) + 'px';
			else
				FloatHead1.style.top = '0px';
		}
	}

	function saveHeadPos()
	{
		parTable = document.getElementById("divHeadSep");
		if (parTable != null)
		{
			headTop = parTable.offsetTop + 3;
			FloatHead1 = document.getElementById("heading");
			FloatHead1.style.position = "relative";
		}
	}
	
	function lockKey()
	  {
		 	 
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }

	  function lockbackSpace()
	  {
		// alert(document.order_type_form.mode.value);
		   var mode = document.mode.value;
      // alert(window.event.keyCode);
		 if(mode=='modify' && window.event.keyCode==8)
		  {
           //return false;
		  }
	  }
	 
	
	
</script>
</head>

<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"    ; onSelect="codeArrestThruSelect();">

<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>
				<tr>
					<td class='fields' width="32%"></td>
					<% if(enableMCNNumber.equals("Y")){%>
						<td class='fields' width="20%"></td>
						<td width='10%' nowrap class='label' align='left'><fmt:message key="eBL.AutoFillMCNno.label" bundle="${bl_labels}"/></td>
						<td class='fields' width="8%" align='right'><!--Added V220905 -->
							<input type='checkbox' name="auto_fill" id="auto_fill" id='auto_fill' value='N' disabled onClick="loadMCNnumber(this)"/>
						</td>
					<%
					}else{%>
						<td class='fields' width="55%"></td>
					<%}%>
					
					<td class='fields' width="10%"><input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"   value="Patient Demographic" onclick="callDemographic()"	/></td>
					<td class='fields' width="15%" ><input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"   value="Print UCAF" onclick="printUCAF()"		/></td>
					<! -- Modified by Rajesh V -->
					<td class='fields' width="15%"><input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"   value="Policy Details" onclick="fnPolicyDetails();"    /></td>
					<! -- Modified by Rajesh V -->
					
				</tr>
			</TABLE>	
	
</body>

</html>

