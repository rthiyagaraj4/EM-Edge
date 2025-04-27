<!DOCTYPE html>
<html>
<head>
<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<%
		String params = request.getQueryString() ;
%>
	<script>
	function fun()
	{
		var retVal = 	new String();
		var dialogHeight= "100" ;//26
		var dialogWidth	= "100" ;//42
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var jsp_name = "BLLogoutCashCounterMain.jsp?<%=params %>";
		window.showModalDialog(jsp_name,arguments,features);
			}
	</script>

	<body onLoad='fun()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	</body>

