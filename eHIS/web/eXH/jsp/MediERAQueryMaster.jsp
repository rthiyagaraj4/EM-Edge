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

<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../OP/js/messages.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/ViewEvents.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>


<script language="javascript">

function Query()
{    	
	var era_from_dt =  document.getElementById("era_from_dt").value;
	var era_to_dt =  document.getElementById("era_to_dt").value;
	var from_era_id =  document.getElementById("from_era_id").value;
	var to_era_id =  document.getElementById("to_era_id").value;
	var to_claim_id =  document.getElementById("to_claim_id").value;
	var from_claim_id =  document.getElementById("from_claim_id").value;
	var claim_status_type =  document.getElementById("claim_status_type").value;

	var params ="era_from_dt="+era_from_dt+"&era_to_dt="+era_to_dt+"&from_era_id="+from_era_id+"&to_era_id="+to_era_id+"&to_claim_id="+to_claim_id+"&from_claim_id="+from_claim_id+"&claim_status_type="+claim_status_type;
	parent.resultFrame.document.location.href="../../eXH/jsp/MediERAQueryResult.jsp?"+params;
	//var response=EClaimsTransaction(params);
	
}

function Report()
{
	var event = "";
	document.getElementById("p_report_id").value ="XFERACLM"; 
	var checkBoxes = document.getElementsByName('checkbox');

	for(var i = 0; i < checkBoxes.length; i++)
	{
		if(checkBoxes[i].checked)
		{
			document.getElementById("p_line_level_reqd_yn").value = "Y";
		}
		else
		{
			document.getElementById("p_line_level_reqd_yn").value = "N";
		}
	}

		 //"XFERACLM";
        /*if(!(event !=null && event != "" && event != " " && report_id !=null && report_id != "" && report_id != " " )){
            alert("APP-XH0068 Please Select the Transaction Type and Event.");
			return;
		}*/
		parent.resultFrame.location.href='../../eCommon/html/blank.html';
		parent.f_query_add_mod.ERA_QUERY_FORM.action = '../../eCommon/jsp/report_options.jsp';
	    parent.f_query_add_mod.ERA_QUERY_FORM.target="messageFrame";
	    parent.f_query_add_mod.ERA_QUERY_FORM.submit();
		//document.PAYER_CHECK_QUERY_FORM.submit();
   /* parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.action = '../../eXH/jsp/PatientMembershipReports.jsp';
	parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target="f_query_add_mod";

	//parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target="f_query_add_mod";
	parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.submit();*/
}
function EClaimsTransaction(dataElements)
{
    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeExternalApplication',
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



function clearSearch()
{
   parent.resultFrame.location.href='../../eCommon/html/blank.html';
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >

<%

String era_from_dt = "";
String era_to_dt = "";
String status_code = "",status_desc = "";
String str = "";
String p_module_id      = "XF" ;
String p_facility_id    = (String) session.getValue( "facility_id" ) ;
String p_user_name      = (String) session.getValue( "login_user" ) ;
SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
era_to_dt = dateFormat.format(new java.util.Date()) ;



java.util.Date da = new java.util.Date();
Calendar cal = Calendar.getInstance();
cal.setTime(da);
cal.add(Calendar.MONTH, -1);
da = cal.getTime();
era_from_dt =dateFormat.format(da) ;


String pid_length="10";
Connection conn = null;
String qry="";
ResultSet rs=null;
PreparedStatement pstmt = null;
String l_type_code = "",l_type_desc = "";
	try
	{ 
		pid_length = (XHUtil.singleParamExeQry("SELECT PATIENT_ID_LENGTH FROM MP_PARAM"));	
		
		conn = ConnectionManager.getConnection(request);
		    qry= "Select STATUS_CODE,STATUS_DESC from XH_TRANS_STATUS where APPLICATION_ID = 'ECLAIMS' and TRANS_EVENT =? and TRANS_TYPE =? and  ACTIVE_FLAG='Y'";
			System.out.println("Query..."+qry);
			pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, "ERA");
			pstmt.setString(2, "CLA");

			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				l_type_code=rs.getString("STATUS_CODE");
				l_type_desc=rs.getString("STATUS_DESC");


				
					System.out.println("MediERAQueryMaster.java:::getStatus...l_type_code...."+l_type_code+"...l_type_desc..."+l_type_desc);
				
				str+="<option value = '"+l_type_code+"'>"+l_type_desc+"</option>";
			}
		
		
			System.out.println("MediERAQueryMaster.java:::getStatus...str..."+str);
		
		
	%>


<form name="ERA_QUERY_FORM" id="ERA_QUERY_FORM" method="get" action="">
<fieldset style=" border-color:grey;" >
<table height='50%' cellspacing=0 cellpadding=3 width='100%' align=center>
	
	

	<td class=label width="10%" ><fmt:message key="eXH.ERANumber.label" bundle="${xh_labels}"/></td>
		<td class='fields'> <fmt:message key="Common.from.label" bundle="${common_labels}"/>  &nbsp;&nbsp;
		<INPUT TYPE="text" id="from_era_id" name="p_fr_era_no" id="p_fr_era_no" align="left" size='20'  value="" style="width: 100px" >
		<!--<input type="button" value="?" class="button" name='from_bill_search' id='from_bill_search' onClick="getFromBillID()">-->
		<fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;
        <INPUT TYPE="text" id="to_era_id" name="p_to_era_no" id="p_to_era_no" align="left" size='20'  value=""  style="width: 110px" >
		<!--<input type="button" value="?" class="button" name='to_bill_search' id='to_bill_search' onClick="getToBillID()">-->
	</td>
	<td class=label width="15%"><fmt:message key="eXH.ERADate.label" bundle="${xh_labels}"/></td>
	
		<td class='fields'> <font class=label>&nbsp;&nbsp;</font>
			<input type=text name=p_fr_era_date  id="era_from_dt" value="<%=era_from_dt%>" size=11  > <input type='image' id="era_from_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('era_from_dt','dd/mm/y');"  >
			<input type=text name=p_to_era_date  id="era_to_dt" value="<%=era_to_dt%>" size=11> <input type='image' id="era_to_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('era_to_dt','dd/mm/y');">
		</td>			
	
</tr>
<tr>
	
		<td class=label width="10%"><fmt:message key="eXH.ClaimNumber.label" bundle="${xh_labels}"/></td>
		<td class='fields'> <fmt:message key="Common.from.label" bundle="${common_labels}"/> &nbsp;&nbsp;</font>
		<INPUT TYPE="text" id="from_claim_id" name="p_fr_era_claim_id" id="p_fr_era_claim_id" align="left" size='20'  value="" style="width: 100px">
		<!--<input type="button" value="?" class="button" name='from_bill_search' id='from_bill_search' onClick="getFromBillID()">-->
		<fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;&nbsp;
        <INPUT TYPE="text" id="to_claim_id" name="p_to_era_claim_id" id="p_to_era_claim_id" align="left" size='20'  value=""  style="width: 110px">
		<!--<input type="button" value="?" class="button" name='to_bill_search' id='to_bill_search' onClick="getToBillID()">-->
	</td>			
	<td class=label width="10%"><fmt:message key="eXH.claimstatus.label" bundle="${xh_labels}"/></td>
	  <td class='fields'>
	    <select name="p_era_claim_status" id="p_era_claim_status" id="claim_status_type" style="width:250px">
		   <option value = ''><fmt:message key="Common.defaultSelect.label" bundle ="${common_labels}"/></option>
		    <%=str%>
	    </select>
	</td>
</tr>
<tr><td class=label width="10%" ><fmt:message key="eXH.shwClaimDtl.label" bundle="${xh_labels}"/></td>
<td><input type='checkbox' id='checkbox' value = 'Y'> </td>
</td><td>&nbsp;</td><td>&nbsp;</td></tr>
</table>
<table width='100%' cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr align="right">
		<td colspan=4 class='BUTTON'>
		<input class='BUTTON' type="button"  ID="query" name="query" id="query" value='Search' onClick="Query()">
		<input class='BUTTON' type="button"  ID="report" name="report" id="report" value='Report' onClick="Report()">
		<input class='BUTTON' type="button"  ID="clear" name=clear value='Clear' onClick="clearSearch()">
		</td>
	</tr>
</table>
<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"   value="">
<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id"   value="<%=p_module_id%>"> 
<input type="hidden" name="p_language_id" id="p_language_id" id="p_language_id"   value="en"> 
<input type="hidden" name="p_line_level_reqd_yn" id="p_line_level_reqd_yn" id="p_line_level_reqd_yn"   value="">
<input type="hidden" name="p_era_process_status" id="p_era_process_status" id="p_era_process_status"   value=""> 

</fieldset>
<%
}catch(Exception e1)
			{
			 out.println("(MediERAQueryMaster.jsp:Exception) "+e1);
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

