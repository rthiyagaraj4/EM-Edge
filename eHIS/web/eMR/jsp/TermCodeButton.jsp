<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
<% request.setCharacterEncoding("UTF-8"); %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eMR/js/NoteTerminologyCode.js"></script>
<script language ='javascript' src='../../eCommon/js/common.js'></script>	
<script language="javascript">

function ok() {
	var frmObj = parent.lookup_detail.document.all;
	var chkValues = frmObj.chkValues1.value;
	
	
	if(parent.lookup_detail.document)
	{
		if(frmObj.term_code_associated != null)
		{
			retVal ="";
			retVal = frmObj.temp_term_code.value;
			
			
			var ret_term_code ="";
			ret_term_code = frmObj.term_code_associated.value;
			
			var cnt = "";
			
			if ( parent.lookup_detail.document.all.cnt != null)
					cnt = parent.lookup_detail.document.all.cnt.value;
			else
				cnt = 0;
			var test_code2="";
			if ( cnt != 0 )    /* If no records are selected or found, nothing should be returned from window.*/
			{
			  for(var i=2;i<cnt;i++)
			  { 
				if(eval("frmObj.term_chk"+i).checked){
					var code1=frmObj.result_tbl.rows[i-1].cells[0].innerText;
					var test_code1 = code1+"~";
					if(eval("frmObj.term_chk"+i).disabled==true)
					{}
					else
						{test_code2 += code1+"~"; }
				}
				}
			}

			var returnVal2=frmObj.returnVal2.value;
			test_code2=returnVal2+""+chkValues;	
			if(test_code2=='')
				{
				test_code2=' ';
				}	
			var term_group_id=frmObj.term_group_id1.value;
			if(term_group_id=='')
				{
				term_group_id=' ';
				}
			var term_set_id=frmObj.term_set_id1.value;
			parent.window.returnValue = test_code2+"$"+term_group_id+"$"+term_set_id;
		}
	    //parent.window.close();
		const dialogTag = top.dialogArray[top.dialogArray.length - 1];
	    dialogTag.close(); 
	}
}

function closew() {
   // parent.window.close ;
	const dialogTag = top.dialogArray[top.dialogArray.length - 1];
    dialogTag.close(); 
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% String mulitple_yn = request.getParameter("mulitple_yn")==null?"":request.getParameter("mulitple_yn");
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='0' cellspacing='0' >
	<tr>
	<td class='button'>
	<%if(mulitple_yn.equals("Y")){%>
		<input type='button' name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='ok()'  class='button'>
	<%}%>
		<input type='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closew()' class='button'>
		</td>
	</tr>
</table>
</div>
</body>
</html>

