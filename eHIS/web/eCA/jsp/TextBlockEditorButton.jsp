<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
---------------------------------------------------------------------------------------------------------------
-->

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<script>
function storeEditorValue(){
var outData=parent.textBlockEditor.RTEditor0.contentDocument.body.innerHTML;
//var outData=parent.textBlockEditor.RTEditor0.document.body.innerHTML;
outData = outData.replace("<ADDRESS>","");
outData = outData.replace("</ADDRESS>","");
//outData = outData.replace( /\"/g, "'" );  //[IN033786]
outData = outData.replace( /<P\s*[^>]*>\s*&nbsp;\s*<\/P>/gi, "" ) ;
if(outData!=""){
	//document.parentWindow.returnValue = "<ADDRESS>"+outData+"</ADDRESS>";
	//window.parent.returnValue = "<ADDRESS>"+outData+"</ADDRESS>";
	parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = "<ADDRESS>"+outData+"</ADDRESS>";
}else{
	//window.parent.returnValue = "";
	parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = "";
	//document.parentWindow.returnValue = "";
}
//window.parent.close();
parent.parent.document.getElementById('dialog_tag').close();
//document.parentWindow.close();

}
</script>
<table border="0" cellpadding="0" cellspacing="0" width="100%" id='test'>
<tr>
	<td class="LABEL" align="right" >
		<font size='1'>	
			<input type="button" value="OK" onclick="javascript:storeEditorValue();"/>&nbsp;&nbsp;<input type="button" value="Cancel" onclick="parent.parent.document.getElementById('dialog_tag').close();"/>					 
		</font>
	</td>
</tr>
</table>

