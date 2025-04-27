<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="eBL.billreceipt.model.BillReceiptExistOrderExclusion"%>
<%@ 
page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.* " contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%! private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
}
%>

<head>
<meta HTTP-EQUIV="content-type" CONTENT="text/html; charset=UTF-8">
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>

<%
String facilityId =  (String) session.getValue( "facility_id" ) ;
String locale = (String)session.getAttribute("LOCALE");
String docType = checkForNull(request.getParameter("docType"));
String docNumber = checkForNull(request.getParameter("docNumber")); 
String episodeId = checkForNull(request.getParameter("episodeId"));
String episodeType = checkForNull(request.getParameter("episodeType"));   
String err_value=request.getParameter( "err_value" );
String message = request.getParameter( "message" );
%>

<script language="JavaScript">
$(document).ready(function(){
	var frm = document.forms[0];
	var err = frm.err_value.value;
	var message = frm.message.value;
	if(err == '1'){
		generateDischClear();
	}else if(err == '0'){
		alert(message);
		return false;
	}
});

function generateDischClear()
{
	
	var frm = document.forms[0];
	var docType = frm.docType.value;
	var docNumber = frm.docNumber.value;
	var p_facility_id = frm.facility_id.value;
	var locale = frm.locale.value;
	var login_user = '';
	var episodeId = frm.episodeId.value;
	var episodeType = frm.episodeType.value;
	var detailed_yn = "Y";
	var reportId = "BLRDISCL";
	var module_id = "BL";
	var session_id = '';
	var pgm_date = '';	
	var app_server_ip =''; 
	var copies = '';
	var rep_server_key = '';
	var url = "" ;
	var reportserver = '';
	var userid = '';
	var report_option = "P";
	var message = "";
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ReprintReport&p_report_id="+reportId+"&param1="+docType+"&param2="+docNumber+
				"&param3="+docNumber+"&param4="+docNumber+"&param5="+"&param6="+detailed_yn+"&param7="+"R"+"&param8="+locale+
				"&param9="+
				"&param10="+				
				"&param11="+
				"&param12="+
				"&param13="+episodeId+
				"&param14="+episodeType;
		
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);
	
	var arr=new Array();
	arr = retVal.split(":::");
	session_id = trimString(arr[0]);
	pgm_date = trimString(arr[1]);
	
	var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=ReprintReportValue&p_report_id="+reportId+"&reportOption="+report_option+"&module_id="+module_id;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	var retVal = trimString(xmlHttp.responseText);		
	var arr=new Array();
	arr = retVal.split(":::");
	report = trimString(arr[0]);
	server = trimString(arr[1]);
	copies = trimString(arr[2]);
	app_server_ip = trimString(arr[3]);
    rep_server_key = trimString(arr[4]);
    reportserver = trimString(arr[5]);
    login_user = trimString(arr[6]);
    message = trimString(arr[7]);
   
    if(message != ""){
    	alert(message);
    	return false;
    }
    userid = "userid"+"="+login_user;
    login_user = encodeURIComponent(userid); 
	
	var params		= "&P_PGM_ID="+reportId+"&P_PGM_DATE="+pgm_date+"&P_OPERATING_FACILITY_ID="+p_facility_id+"&P_SESSION_ID="+session_id+"&P_DOC_TYPE_CODE="+docType+"&P_DOC_NUM="+docNumber;
	var regExp = /&/g ;
	params = params.replace( regExp, "+" ) ; 
			
	var myRegExp = /\\/g ;
	var desformat = "PDF";
	var destype	= "CACHE";
	
	params=params.toUpperCase();
	var report = reportId;
	url = reportserver+"?server="+server+"+report="+reportId+"+"+ login_user+"+p_language_id="+locale+"+DESTYPE="+destype+"+PARAMFORM=NO"+"+P_FACILITY_ID="+p_facility_id+"+DESFORMAT="+desformat+"+RECURSIVE_LOAD=NO"+"+MAXIMIZE=YES"	;
	url=url+params;	
	var myBars 		= 'directories=no,location=no,menubar=no' ;
	var myOptions 	= 'width=1500px !important, height=750px !important, resizable=yes' ; 
	var myFeatures 	= myBars + ', ' + myOptions ;
	var reportWindow 	= open( url, '_blank', myFeatures ) ;
	
	alert("Discharge Clearance Document Number is "+docType+"/"+docNumber+"\nAPP-SM0070 Operation Completed Successfully ....");
	parent.frames[0].location.reload();
	parent.frames[1].location.reload();

}	

</script>
<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>
<form id='messageFrm'>
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">	
	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
	<input type='hidden' name='err_value' id='err_value' id='err_value' value='<%=err_value %>'>
	<input type='hidden' name='message' id='message' id='message' value='<%=message %>'>
	<input type='hidden' name='docType' id='docType' id='docType' value='<%=docType %>'>
	<input type='hidden' name='docNumber' id='docNumber' id='docNumber' value='<%=docNumber %>'>
	<input type='hidden' name='episodeId' id='episodeId' id='episodeId' value='<%=episodeId %>'>
	<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value='<%=episodeType %>'>
</form>
</BODY>

