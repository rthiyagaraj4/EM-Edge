<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<script>
	  function funApply()
		{		
			var total_records=parent.frames[0].document.forms[0].total_records.value;
			if(total_records!=0)
			{
				var checked_row=parent.frames[1].document.forms[0].checked_row.value;		
				var total_records=parent.frames[1].document.forms[0].total_records.value;
		
			if(checked_row=="")
			{		
			alert(getMessage("ATLEAST_ONE_SELECTED","common"));
			return false;
		}
		else{			
			for(var i=0;i<total_records;i++)
			{
				var selected_row=eval("parent.frames[1].document.forms[0].selected_row"+i);
				if(selected_row.checked)
				{
					selected_row.value="1";	
					
				
				}
				else
				{
					selected_row.value="0";	
				}
			
			
			var adjust_dep =eval("parent.frames[1].document.forms[0].adjust_dep"+i);
			var prepay_adj_yn =eval("parent.frames[1].document.forms[0].prepay_adj_yn"+i);
			
			
			if(adjust_dep.checked)
				{
					adjust_dep.value="Y";	
					
				
				}
				else
				{
					
					adjust_dep.value="N";
					
					
				}

				if(prepay_adj_yn.checked)
				{
					prepay_adj_yn.value="Y";	
					
				
				}
				else
				{
					
					prepay_adj_yn.value="N";	
					
				}


			
			}		
			}
	parent.frames[1].document.forms[0].action="../../servlet/eBL.BLInterimBillServlet" 
	parent.frames[1].document.forms[0].submit();
		}
	
	}
</script>

	
<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
	<FORM name='' id='' action="" method='post'>
	  <TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
	    <TR>

		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>
		<input type='button' class='button' onclick='funApply()' name="apply_button" id="apply_button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels")%>" >
		<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel()'></td>
		
</TR>
</TABLE>
</BODY>
</FORM>
</HTML>

