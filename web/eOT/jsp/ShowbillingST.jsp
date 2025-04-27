<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOR.OrderEntryBillingQueryBean,eST.OTTransactionBean,eST.*,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");




 String Appr_reqd=CommonBean.checkForNull(request.getParameter("Appr_reqd"));
String include_exclude=CommonBean.checkForNull(request.getParameter("include_exclude"));
String total_amt=CommonBean.checkForNull(request.getParameter("total_amt"));
String pat_pay=CommonBean.checkForNull(request.getParameter("pat_pay"));
String pat_paid=CommonBean.checkForNull(request.getParameter("pat_paid"));
String reason_code=CommonBean.checkForNull(request.getParameter("reason_code"));
String patient_class=CommonBean.checkForNull(request.getParameter("patient_class"));
String facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
if(reason_code.equals("null")) reason_code="";



	String patient_id = request.getParameter("patient_id")== null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")== null?"":request.getParameter("encounter_id");
	//String mm_item_code = request.getParameter("mm_item_code")== null?"":request.getParameter("mm_item_code");
	String req_store_code = request.getParameter("req_store_code")== null?"":request.getParameter("req_store_code");
	String quantity = request.getParameter("quantity")== null?"":request.getParameter("quantity");
	String item_code = request.getParameter("item_code")== null?"":request.getParameter("item_code");
	String sale_doc_no = request.getParameter("sale_doc_no")== null?"":request.getParameter("sale_doc_no");
	String sale_doc_type = request.getParameter("sale_doc_type")== null?"":request.getParameter("sale_doc_type");
	String override_value = request.getParameter("override_value")== null?"":request.getParameter("override_value");


  try {
String disabled="";
String checked="";
String mm_item_code="";
PreparedStatement pstmt = null;
PreparedStatement pstmt_st = null;
String action_reason_desc= "";
ResultSet rst = null;
ResultSet rst_st = null;
	Connection con = null;

	con = ConnectionManager.getConnection(request);


			String sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_code+"'";
			
					pstmt_st=con.prepareStatement(sql_mm_code);
					rst_st=pstmt_st.executeQuery();
				if(rst_st !=null && rst_st.next())
				{
					mm_item_code=rst_st.getString(1);
				}

if (((override_value.equals("Y") || override_value =="Y") && (Appr_reqd.equals("N")) ) )
{ 
	disabled="";

}else
 {
	 disabled="disabled";
}

 %>


<html>
<title><fmt:message key="eOT.IncludeExcludecharges.Label" bundle="${ot_labels}"/></title>

	<head>
				<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
				<script language="JavaScript" src="../../eCommon/js/common.js"></script>
				<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
				<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
				<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
				<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <script>

function clearreason()
	  {
	

document.forms[0].reason_desc.value="";
document.forms[0].reason_code.value="";

	  }
function closewindow()
 {
	window.returnValue="CANCEL";
parent.window.close();
}

function passvalues()
{
	var flag=true;
	var patient_id=document.forms[0].patient_id.value;
	var encounter_id=document.forms[0].encounter_id.value;
	var patient_id=document.forms[0].patient_id.value;
	var mm_item_code=document.forms[0].mm_item_code.value;
	var req_store_code=document.forms[0].req_store_code.value;
	var quantity=document.forms[0].quantity.value;
	var reason_code=document.forms[0].reason_code.value;
	var patient_class=document.forms[0].patient_class.value;
	var facility_id=document.forms[0].facility_id.value;
		if(document.forms[0].include_exclude.disabled==false)
		{
		
var include_exclude_old="<%=include_exclude%>";
			if(document.forms[0].include_exclude.value != include_exclude_old)
			{
			if(document.forms[0].reason_code.value == "")
			{
				var err=getMessage("CANNOT_BE_BLANK","OT");
var reason_val=getLabel("Common.reason.label","Common");
err=err.replace("&",reason_val)
				alert(err);
				flag=false;
			}
			}
		}

		if(flag==true)
	{
			var flag_val=document.forms[0].include_exclude.value;

		//window.returnValue=document.forms[0].reason_code.value+"*"+flag_val;

var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","STBillingValidation.jsp?reason_code="+document.forms[0].reason_code.value+"&include_exclude_val="+flag_val+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&mm_item_code="+mm_item_code+"&req_store_code="+req_store_code+"&quantity="+quantity+"&reason_code="+reason_code+"&patient_class="+patient_class+"&facility_id="+facility_id,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
     window.returnValue=retVal;
       
		window.close();
	}
}
function show_inc_exc()
  {
var include_exclude =document.forms[0].include_exclude_val.value;
if(include_exclude =="I")
{
	document.forms[0].include_exclude.value="I";
}else
{
	document.forms[0].include_exclude.value="E";
}
}
function searchReason(obj)
 {
	var locale=document.forms[0].locale.value;
	var reason_code=document.forms[0].reason_code.value;
	var tit="";
	var sql="select  a.action_reason_code code,a.action_reason_desc description from bl_action_reason_lang_vw a where nvl(status,'!') != 'S' and upper(language_id) = upper('"+locale+"') and exists (select b.action_type from bl_action_type b, bl_action_reason_by_type c  where b.action_type = c.action_type and b.action_type = 'OV' and nvl(a.action_reason_code,'*')=nvl('"+reason_code+"',nvl(a.action_reason_code,'*')) and c.action_reason_code = a.action_reason_code and c.active_yn = 'Y') and UPPER(a.action_reason_desc) LIKE UPPER(?) AND UPPER(a.action_reason_code) LIKE UPPER(?) ORDER BY 1";

	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	returnedValues = CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value=returnedValues[1];
		document.forms[0].reason_code.value=returnedValues[0];
		}else{
		document.forms[0].reason_code.value="";
		obj.value="";
		}
}
		</script>
	<body onload='show_inc_exc();'>

 	<form name='st_billing_window' id='st_billing_window'>
 
 <table  cellpadding='3' cellspacing='0' width='100%' align='center'>
						<tr>
						<td  nowrap class='gridData'>
						 <fmt:message key="eOT.IncludeExclude.Label" bundle="${ot_labels}"/>
						</td>
						<td  nowrap class='gridData'>
						<fmt:message key="Common.reason.label" bundle="${common_labels}"/>
						</td>
						<td  nowrap class='gridData'>
						<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>
						</td>
					  <tr>


					<tr>
						
						<td  nowrap class='gridData'>
						  
				   <select name="include_exclude" id="include_exclude"   <%=disabled%> onchange="clearreason();">
				     <option value='I'  >
					<fmt:message key="Common.Include.label" bundle="${common_labels}"/>
					</option>
				<option value='E' >
				<fmt:message key="eOT.Exclude.Label" bundle="${ot_labels}"/>
				</option>
			</select>
			</td>

						
						</td>

						<%
						if(!reason_code.equals(""))
	  {
						String sql_reason="select ACTION_REASON_DESC from bl_action_reason_lang_vw where nvl(ACTION_REASON_CODE,' ')=nvl('"+reason_code+"',nvl(ACTION_REASON_CODE,' ') )";
						pstmt=con.prepareStatement(sql_reason);
						rst = pstmt.executeQuery();
						if(rst !=null && rst.next())
						{
							action_reason_desc=rst.getString("ACTION_REASON_DESC");
							if(action_reason_desc==null) action_reason_desc="";
						}
	  }
						%>
						<td  nowrap class='gridData'>
						<input type='text' name='reason_desc' id='reason_desc' size='80'  <%=disabled%> class='fields' width="25%" value="<%=action_reason_desc%>" >
						<input type='HIDDEN' name='reason_code' id='reason_code' value="<%=reason_code%>">
						<input type='button' class='button' name='quest1' id='quest1' <%=disabled%> value='?'  onClick="searchReason(reason_desc);">
						<img id='reason_gif' style='visibility:hidden' src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td  nowrap class='gridData'>
						<%if(Appr_reqd.equals("Y")) {%>
						<B><font color='crimson' ><img width=15px src='../../eCommon/images/enabled.gif'></img></font></B>
						<%}else {%>
						<B><font color='crimson' ><img width=15px src='../../eCommon/images/disabled.gif'></img></font></B>
						<%}%>
						</td>
						</td>
					  <tr>



					  <tr>
						<td  nowrap class='gridData'>
						<fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;<%=total_amt%></td>
						
						<td  nowrap class='gridData'>
						<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;<%=pat_pay%></td>
						
						<td  nowrap class='gridData'>
						<fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;<%=pat_paid%></td>
					  </tr>

					  
					   
					  <tr>
					  <td  align='right' width="25%" colspan='8' nowrap>
					  	<input type='button' name='close' id='close' class='button' value="<fmt:message key='Common.ok.label' bundle='${common_labels}'/>" onClick='passvalues();' >

						<input type='button' name='close' id='close' class='button' value="<fmt:message key='Common.cancel.label' bundle='${common_labels}'/>" onClick='closewindow();' >
							</td>
							</tr>
					  </table>
					  <input type='hidden' name='locale' id='locale' value='<%=locale%>'>
					  <input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
					  <input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
					  <input type='hidden' name='mm_item_code' id='mm_item_code' value='<%=mm_item_code%>'>
					  <input type='hidden' name='req_store_code' id='req_store_code' value='<%=req_store_code%>'>
					  <input type='hidden' name='quantity' id='quantity' value='<%=quantity%>'>
					  <input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
					  <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
					  <input type='hidden' name='sale_doc_no' id='sale_doc_no' value='<%=sale_doc_no%>'>
					  <input type='hidden' name='sale_doc_type' id='sale_doc_type' value='<%=sale_doc_type%>'>
					  <input type='hidden' name='include_exclude_val' id='include_exclude_val' value='<%=include_exclude%>'>
					  <input type='hidden' name='override_value' id='override_value' value='<%=override_value%>'>
	</form>
	</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace();
	//System.err.println("cmg 5" +e);
}finally {

}
%>

