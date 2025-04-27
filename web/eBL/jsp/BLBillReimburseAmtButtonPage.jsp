<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* , java.io.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eBL/js/BLBillReimburseAmtDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <script>
	function cancel()
	{
		//parent.window.returnValue = "N";
		//parent.window.close();
		let dialogBody = parent.parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = "N"; 
		const dialogTag = parent.parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close(); 
		
	}
	function funSubmit()
	{
		//alert("1");
		var toc_rec = parent.frames[2].document.forms[0].total_records.value;

		for(var i=0;i<toc_rec;i++)
		{
			var stup_reimb_YN = eval("parent.frames[1].document.forms[0].stup_reimb_YN_"+i);
			var stup_reimb_type = eval("parent.frames[1].document.forms[0].stup_reimb_type_hid_"+i);
			var stup_reimb_amt = eval("parent.frames[1].document.getElementById('stup_reimb_amt_')"+i);

			var rtn_stup_reimb_YN = eval("parent.frames[1].document.forms[0].rtn_stup_reimb_YN_"+i);
			var rtn_stup_reimb_type = eval("parent.frames[1].document.forms[0].rtn_stup_reimb_type_"+i);
			var rtn_stup_reimb_amt = eval("parent.frames[1].document.forms[0].rtn_stup_reimb_amt_"+i);

			var curr_reimb_YN = eval("parent.frames[1].document.forms[0].curr_reimb_YN_"+i);
			var curr_reimb_type = eval("parent.frames[1].document.forms[0].curr_reimb_type_"+i);
			var curr_rev_amt = eval("parent.frames[1].document.forms[0].curr_rev_amt_"+i);

			var rtn_curr_reimb_YN = eval("parent.frames[1].document.forms[0].rtn_curr_reimb_YN_"+i);
			var rtn_curr_reimb_type = eval("parent.frames[1].document.forms[0].rtn_curr_reimb_type_"+i);
			var rtn_curr_rev_amt = eval("parent.frames[1].document.forms[0].rtn_curr_rev_amt_"+i);

			if(stup_reimb_YN.checked)
				rtn_stup_reimb_YN.value = "Y";
			else
				rtn_stup_reimb_YN.value = "N";

			rtn_stup_reimb_type.value = stup_reimb_type.value;
			rtn_stup_reimb_amt.value = stup_reimb_amt.innerText;

			if(curr_reimb_YN.checked)
				rtn_curr_reimb_YN.value = "Y";
			else
				rtn_curr_reimb_YN.value = "N";

			rtn_curr_reimb_type.value = curr_reimb_type.value;
			rtn_curr_rev_amt.value = curr_rev_amt.value;
		}

		parent.frames[1].document.forms[0].target='submit_frame';
		parent.frames[1].document.forms[0].action="../../servlet/eBL.BLBillReimburseAmtServlet";
		parent.frames[1].document.forms[0].submit();
	}

 </script>
</head>

	<body onLoad='' onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();">
	<form name='CusrDet' id='CusrDet' method='post' action=''>		
	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
		<tr>
			<td width="100%" class='button' colspan='2'  align='right'>
<!--				<input type='button' name='apply_button' id='apply_button' onClick='funSubmit();' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels")%>" align='right'>-->
				<input type='button' name='close_button' id='close_button' onClick='cancel();' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>">
			</td>	
		</tr>
	</table>
	</form>
	</body>

</html>



