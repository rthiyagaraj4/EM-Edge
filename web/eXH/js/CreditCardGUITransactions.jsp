<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>
 
<title>Credit Card Interface</title>

<script type="text/javascript">
function processResponse()
{
	var requestType = '${param.requestType}';
	alert('${param.intExtAppID}');
	var settleBillResponse = "";
	if(requestType == '') {
		var responseMessage = '${param.responseMessage}'.split('$|#');
		if(confirm(responseMessage[2])) {
			var dataElements = "interfaceRequestType=SETTLE_BILL&" + $('#creditCardGUI').serialize();
			alert(dataElements);
			
			this.location.href = "../../servlet/eXH.InvokeExternalApplication?" + dataElements;
			
		/*	$.ajax({
				  type: 'POST',
				  url: '../../servlet/eXH.InvokeExternalApplication',
				  data: dataElements,
				  success: function(settleBillResponseServer) {
					  settleBillResponse = settleBillResponseServer;
					},
				  dataType: 'text',
				  async:false
				});
			var response = settleBillResponse.split("$|#")[2];
			alert(response);
			return settleBillResponse;
			*/
		}
	}
} 
</script>
</head>
<body onLoad="processResponse()">
<FORM ID="creditCardGUI" name="creditCardGUI" id="creditCardGUI" METHOD="post" action="../../servlet/eXH.InvokeExternalApplication">
<%@ include file="../../eXH/jsp/IncludeRequestParams.jsp" %>
<input type='hidden' id='requestType' name='requestType' id='requestType'>
</FORM>
</body>
</html>

