<!DOCTYPE html>
<HTML>
<%@ page contentType="text/html;" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eXH.XHUtil" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<HEAD>
																									  
																									  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	    

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../OP/js/messages.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/ViewEvents.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>


<script language="javascript">

function Search()
{    	
	parent.resultFrame.document.location.href="../../eXH/jsp/MediERATransactionResult.jsp";	
}
function ERATransaction(dataElements)
{
    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeMedikreditApplication',
		type: 'POST',
		cache: false,
		
		data: {
				callType: 'ECLAIMSERA',
				paramString: dataElements
		},
		success: function (data1) {
			responseMsg = data1;
		},		
		dataType: 'text',
		async: false
	});
	
	return responseMsg;

} 



function clearSearchResult()
{
   parent.resultFrame.location.href='../../eCommon/html/blank.html';
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >

<%

String trans_from_dt = "";
String trans_to_dt = "";
String status_code = "",status_desc = "";
String str = "";
String p_module_id      = "XF" ;
String p_facility_id    = (String) session.getValue( "facility_id" ) ;
String p_user_name      = (String) session.getValue( "login_user" ) ;
SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
trans_from_dt = trans_to_dt = dateFormat.format(new java.util.Date()) ;

String pid_length="10";
Connection conn = null;
	try
	{ 
		pid_length = (XHUtil.singleParamExeQry("SELECT PATIENT_ID_LENGTH FROM MP_PARAM"));		
	%>


<form name="PAYER_CHECK_QUERY_FORM" id="PAYER_CHECK_QUERY_FORM" method="get" action="">
<fieldset style=" border-color:grey;" width="100%">
<table width='100%' cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr><td>&nbsp;</td></tr>
	<tr align="right">

		<td colspan=4 class='BUTTON'>
		<input style="position: absolute; left: 20px;" class='BUTTON' type="button"  ID="query" name="query" id="query" value='Fetch ERA Files' onClick="Search()">
		<!--<input class='BUTTON' type="button"  ID="report" name="report" id="report" value='Report' onClick="Report()">-->
		</td>
	</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
</table>

</fieldset>
<%
}catch(Exception e1)
			{
			 out.println("(MediERATransactionResult.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}
%>

</form>
</body>
</html>

