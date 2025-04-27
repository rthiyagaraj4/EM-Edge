<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page import ="eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>	
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
		<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
		<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eXH/js/json2.js'></script>
		<script type="text/javascript">
			$(document).ready(function() {
			 
				var responseMsg="";
				var data1=true;

				var l_request_id = document.forms[0].requestId.value;
				var l_hashData = document.forms[0].hashData.value;
				var l_uuid = document.forms[0].uuid.value;
				var l_status = document.forms[0].status.value;
				var l_transaction_id = document.forms[0].transactionId.value;

				/*
				var authenticationCode = document.forms[0].authenticationCode.value;
				var errorCode = document.forms[0].errorCode.value;
				var errorMessage = document.forms[0].errorMessage.value;
				*/

				var dataElements = "<REQUESTID>"+l_request_id+"$!^<UUID>"+l_uuid+"$!^<HASHDATA>"+l_hashData+"$!^<STATUS>"+l_status+"$!^<TRANSACTION_ID>"+l_transaction_id+"$!^";

				$.ajax({
					url: '../../servlet/eXH.AadhaarResponse',
					type: 'POST',
					cache: false,
					data: {
							callType:	'KYC',
							request_id:	l_request_id,
							uuid:	l_uuid,
							hash_data:	l_hashData,
							status:		l_status,
							transaction_id:	l_transaction_id,
							paramString: dataElements
					}, 
					success: function (data1) {
						responseMsg = data1;
					},
					dataType: 'text',
					async: false
				});  
				window.open('', '_self', ''); window.close();
			});
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%
		//http://localhost:8899/eHIS/eXH/jsp/EMKYCDetails.jsp?requestId=731418475004&uuid=3722398c-72fb-4bf1-a662-8611a1cb21b1&hash=f063f1205ec53b6f376f93057f5bd27011332db55385de5b05aefda1e3ccd430&status=success

			String hashData = "";
			String uuid = "";
			String requestId = "";
			String status = "";
			String transactionId = "",l_return_str="",l_param_string="",responseMsg="";
			
			request.setCharacterEncoding("UTF-8");
			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			hashData = XHDBAdapter.checkNull(request.getParameter("hash"));
			uuid = XHDBAdapter.checkNull(request.getParameter("uuid"));
			requestId = XHDBAdapter.checkNull(request.getParameter("requestId"));
			status = XHDBAdapter.checkNull(request.getParameter("status"));
			transactionId = XHDBAdapter.checkNull(request.getParameter("transactionId"));

			boolean isDebugYN = false; 
			String l_app_msg = "";
			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			//responseMsg= XHDBAdapter.checkNull(request.getParameter("responseMsg"));

			l_app_msg = " ::: HASHDATA ::: "+hashData+" ::: UUID  ::: "+uuid+" ::: REQUEST ID  ::: "+requestId+" ::: STATUS  ::: "+status+" ::: TRANSACTIONID  ::: "+transactionId;
			if (isDebugYN) System.out.println(l_app_msg);
			    
		%>
	</head>
	<body>	
		<form name="ekycform" id="ekycform">
			<p>
					Request Details : Hash <%=hashData %>
			</p>
			<p>
					Request Details : UUID <%=uuid %> 
			</p>
			<p>
					Request Details : Status <%=status %>
			</p>
			<p>
					Request Details : requestId <%=requestId %>
			</p>
			<p>
					Request Details : transactionId <%=transactionId %>
			</p>
			<input type='hidden' name='hashData' id='hashData' value="<%=hashData%>">
			<input type='hidden' name='uuid' id='uuid' value="<%=uuid%>" >
			<input type='hidden' name='status' id='status' value="<%=status%>" >
			<input type='hidden' name='requestId' id='requestId' value="<%=requestId%>" >
			<input type='hidden' name='transactionId' id='transactionId' value="<%=transactionId%>" >		
		</form>
	</body>
</html>

