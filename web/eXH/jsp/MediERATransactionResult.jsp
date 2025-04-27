<!DOCTYPE html>
<HTML>
<%@ page import= "java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.Connection,java.util.HashMap,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHQueryRender,eXH.XHDBAdapter,eXH.EClaimsERATransaction" %>

<%@ page import="eXH.XHUtil"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<HEAD>
																									  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	   
<style>
.left_child{	
	overflow-y:auto;
 }

 #header-fixed {
    position: fixed;
    top: 0px; display:none;
    background-color:white;
}
</style>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>

<script language="javascript">

function funSubmit()
{
	parent.resultFrame.PAYER_CHECK_QUERY_FORM.action = '../../eXH/jsp/MediERATransactionResult.jsp';
	parent.resultFrame.PAYER_CHECK_QUERY_FORM.target="resultFrame";
	parent.resultFrame.PAYER_CHECK_QUERY_FORM.submit();
}

function funAction(typ)
{  
	parent.resultFrame.PAYER_CHECK_QUERY_FORM.action_type.value = typ;
	funSubmit();
}

//function callForOrderBy
function callForOrderBy(obj,order)
{	
	if(order == 'A') obj = obj + ' asc';
	if(order == 'D') obj = obj + ' desc';
	var url = '&orderBy=' + obj + '&order=' + order;

	this.document.forms[0].action_type.value = "";
	this.document.forms[0].action = "../../eXH/jsp/MediERATransactionResult.jsp?"+url;
	this.document.forms[0].target = "f_query_add_mod";
	this.document.forms[0].submit();
}

async function checkEligibility(obj)
{	
	var checkType = "";
	
	var checkTypeButtons = document.getElementsByName('CheckType');


	//var request_status = obj.getAttribute('request_status');
    var trans_num = obj.getAttribute('trans_num');
	//var event_type = document.forms[0].event_type.value;
	//var check_type = obj.getAttribute('check_type');
	//var eligibility_status_type = obj.getAttribute('request_status');
    
	var dialogHeight = "30vh";    // have to remove 
	var dialogWidth  = "60vw";
	var dialogTop    = "130";
	var title="Patient Eligibility Check ";
	title=encodeURIComponent(title);
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	var params= "trans_num="+trans_num;
	var arguments = new Array();
	var url = "../../eXH/jsp/MediQueryResponsePopUp.jsp?" +params;
	
	var retVal =await window.showModalDialog(url,arguments,features);
      
}
function Process(){
  var checkType = "";
	var patientData="";
	var checkedValue = null; 
	var checkBoxes = document.getElementsByName('checkbox');
	var selectedIndex = 0;
	var count = 0;
	var trans_Id = "";
	var responseMessage = "";
	var authnum = "";
	var destcode = "";

	var responseMessage = "", validate = "";
    
	for(var i = 0; i < checkBoxes.length; i++){
		if(checkBoxes[i].checked){
			checkedValue = checkBoxes[i].value;
			selectedIndex = i;
			count++;
		
		}
	}
	if(count == 0 || checkedValue == null)
	{
         alert("APP-XH0070 Please select at least one File.");
		 return;
	}
    for(var i = 0; i < checkBoxes.length; i++){
		if(checkBoxes[i].checked){
			checkedValue = checkBoxes[i].value;
			    responseMessage = ERATransaction(checkedValue);
		}
	}

	var responseData = "";
	responseData = responseMessage.split("$!^");

	if (responseData.length > 0)
	{
		if (responseData[0] == "E")
		{
			alert(responseData[3]);
			return;
		}
	}
	alert("APP-XH0070 Selected ERA Files has been processed. Please check the status.");

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

function includeBoxChecked() {

	if (document.forms[0].includeMastercheckbox.checked == true) {
		if (document.forms[0].includeCheckbox.length != undefined) {
			for ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {
				document.forms[0].includeCheckbox[a].checked = true;
			}
		} else if (document.forms[0].gatewayservers.length == undefined) {
			document.forms[0].includeCheckbox.checked = true;
		}
	}
	else {
		if (document.forms[0].includeCheckbox.length != undefined) {
			for ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {
				document.forms[0].includeCheckbox[a].checked = false;
			}
		} else if (document.forms[0].includeCheckbox.length == undefined) {
			document.forms[0].includeCheckbox.checked = false;
		}
	}
	return true;
}
function CheckAll()
{
	var checkBoxes = document.getElementsByName('checkbox');
	if(document.getElementById("allCheck").checked==true)
	{
		for(var i = 0; i < checkBoxes.length; i++)
		{
			checkBoxes[i].checked=true;
	    } 
	}
	else
	{
		for(var i = 0; i < checkBoxes.length; i++)
		{
			checkBoxes[i].checked=false;
	    } 
	}
	

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >
	<form name="PAYER_CHECK_QUERY_FORM" id="PAYER_CHECK_QUERY_FORM" method="POST" action=''  >
	<%
		String order = "";
		String orderBy = "";
		String action_type=null;
		Connection conn = null;
		Statement stmt=null;
		ResultSet rset=null ;
		String event_type = "";
		String dest_code = "";
        String checkboxvalue = "";
		String Checkboxname = "";

		String rs_filename="", rs_size = "";
        String rs_date = "",rs_path = "";
         
		HttpSession httpSession = request.getSession(false);
		String loginfacility = (String) session.getValue("facility_id");
		String user_id	= (String)session.getValue("login_user") ;
		Properties p=( java.util.Properties ) session.getValue( "jdbc" ) ;
		String AddedAtWsNo     =  p.getProperty("client_ip_address");

		String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

		/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

		boolean  boolToggle = true;
		String strTDClass = "";
		String whereClause = "";
		int totalRecords=0;


		try
		{ 
            EClaimsERATransaction ecliams = new EClaimsERATransaction();
			ArrayList arrRow =(ArrayList)ecliams.FetchFiles("ECLAIMPROF1","ECLAIMS"); 

			ArrayList arrCol = null;
			//if(isDebugYN)System.out.println("boolPrevious...."+boolPrevious);
			//if(isDebugYN)System.out.println("boolNext...."+boolNext);

			if(arrRow.size()==0)
			{
				%>	
				<script>
				alert('APP-002415 Query caused no records to be retrieved');
				history.go(-1);
				parent.resultFrame.location.href='../../eCommon/html/blank.html';
				</script>
				<%
			}
			else
			{
				%> 
				<table cellspacing=0 cellpadding=3 width='100%' align=center border=1 >

					<tr>
						<td colspan="27" class="COLUMNHEADER" align='center'>List of ERA Files</td>
					</tr>
					<tr>
						
		               <td align="right" class="CAGROUP" > 
		                   <input class='BUTTON' type="button"  ID="search" name=search value='Process Files' onClick="Process()">
						</td>
						   <td align="right" class="CAGROUP"></td>
					</tr>
				</table>

				<div id="left_child" class="left_child">
					<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%' border=1 align=center>	
						<tr style="position:fixed;">
					        <td class='COLUMNHEADER' width='6%'>
								<font color=white><fmt:message key="Common.selectall.label" bundle="${common_labels}"/></font><input type='checkbox' id='allCheck' name='allCheck' id='allCheck' value='allCheck' onClick='CheckAll()'>
							</td>
							<td class='COLUMNHEADER' width='40%'>
								<font color=white><fmt:message key="Common.FileName.label" bundle="${common_labels}"/></font>
							</td>
							<td class='COLUMNHEADER' width='40%'>
								<font color=white><fmt:message key="Common.modifieddatetime.label" bundle="${common_labels}"/></font>
							</td>
					       
						</tr>
					 
						<%
						System.out.println("Before getting details....."+arrRow.size());
						Map cmp = new HashMap();

						totalRecords=0;

						//billDetailsRowCount = arrRow.size();
						int j = 0;

						for (j=0; j<arrRow.size();j++)
						{
							arrCol = (ArrayList)arrRow.get(j);
							rs_filename = arrCol.get(0).equals("null")?"":(String)arrCol.get(0);
							rs_date = arrCol.get(1).equals("null")?"":(String)arrCol.get(1);
							rs_size = arrCol.get(2).equals("null")?"":(String)arrCol.get(2)+" Bytes";
							rs_path = arrCol.get(3).equals("null")?"":(String)arrCol.get(3);

							checkboxvalue = "<REQUEST>ERA$!^<REQUEST_TYPE>ERARES$!^<USER>"+user_id+"$!^<WS_NO>"+AddedAtWsNo+"$!^<FACILITY_ID>"+loginfacility+"$!^<FILE_DIR>"+rs_path+"$!^<FILE_NAME>"+rs_filename+"$!^<TRANS_ID>XXX$!^";

				            Checkboxname = "Check-"+j;
							out.println("<tr width='100%' id = 'trGrpHeader"+j+"' >");	
							out.println("<td class='gridData' align='center'><input type='checkbox'  name='secChk"+j+"' id='secChk"+j+"' value='"+checkboxvalue+"' > </td>");	
							out.println("<td width='300' style='display:block' class='gridData' ><img src='../../eXH/images/file.png' style='width:20px; height: 20px;' alt='File' align='left'/>"+rs_filename+"</td>");
							out.println("<td width='300' style='display:block' class='gridData'>"+rs_date+"</td>");
							
							out.println("</tr>");
								
						

							//checkboxvalue =rs_patient_id+"$!^"+rs_sex+"$!^"+rs_family_name+"$!^"+rs_episode_id+"$!^"+rs_encounter_id+"$!^"+rs_patient_class+"$!^"+rs_visit_adm_date_time+"$!^"+rs_visit_adm_type+"$!^"+rs_service_code+"$!^"+rs_discharge_date_time+"$!^"+rs_operating_facility_id+"$!^"+rs_doc_type_code+"$!^"+rs_doc_num+"$!^"+rs_doc_date+"$!^"+rs_bill_from_date+"$!^"+rs_bill_to_date+"$!^"+rs_visit_id+"$!^"+rs_cust_code+"$!^"+rs_blng_grp_id+"$!^";

						}
							   
						
						%>	
						</table>
						</div>
		
			<%
				}
				if(arrRow!=null) arrRow.clear();
				if(arrCol!=null) arrCol.clear();
				

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
	</table>
	</form>
</body>
</html>

