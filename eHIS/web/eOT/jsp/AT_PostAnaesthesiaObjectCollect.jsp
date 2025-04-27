<!DOCTYPE html>

<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>

<html>
<head>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript'>
var compl_rows = new Array();
var personnel_rows = new Array();
var personnel_len=0;

</script>
<script language='javascript'>
 
function createXMLForHdr(){
  var formObjHdr = parent.AnaesthesiaHdrFrame.RecordAnesthesiaHdrForm;
  var PostStatusformObj = window.parent.parent.frames[7].document.forms[0];
  var formObjDtl = parent.AnaesthesiaDetailsFrame.AnaesthesiaParticularsForm;
  var locale=formObjDtl.locale.value;
  var table_name="AT_ANAESTHESIA_RECORD_HDR";
  var db_mode="U";
  var finish_time = formObjDtl.finish_date.value+" "+formObjDtl.finish_time.value;
  var finish_date=formObjDtl.finish_date.value;
  var rec_start_date=formObjDtl.rec_start_date.value;
  var rec_finish_date=formObjDtl.rec_finish_date.value;
  if(finish_date!="")
  finish_date=convertDate(finish_date,"DMY",locale,"en");
  if(rec_start_date!="")
  rec_start_date=convertDate(rec_start_date,"DMY",locale,"en");
  if(rec_finish_date!="")
  rec_finish_date=convertDate(rec_finish_date,"DMY",locale,"en");
  var height = formObjHdr.height.value;
  var weight = formObjHdr.weight.value;
  var BMI = formObjHdr.bmi.value;
  //var BSA = formObjHdr.bsa.value;
  var BSA = formObjHdr.bsaDisp.value;
  var doc_comp = "";
  var status="";
   if(PostStatusformObj.checkAnaes.checked==true){
			doc_comp="Y";
			status="FN"
	}else{
			doc_comp="N";
			status="PO"
	}
	var xmlString ="";
	xmlString+="<HDR_DTL"+" ";
	xmlString+="finish_time=\""+finish_date+" "+formObjDtl.finish_time.value+"\""+" ";
	xmlString+="anesthesia_srl_no=\""+document.forms[0].anaesthesia_srl_no.value+"\""+" ";
	xmlString+="rec_start_date_time=\""+rec_start_date+" "+formObjDtl.rec_start_time.value+"\""+" ";
	xmlString+="rec_finish_date_time=\""+rec_finish_date+" "+formObjDtl.rec_finish_time.value+"\""+" ";
	xmlString+="height=\""+formObjHdr.height.value+"\""+" ";
	xmlString+="weight=\""+formObjHdr.weight.value+"\""+" ";
	xmlString+="BMI=\""+formObjHdr.bmi.value+"\""+" ";
	//xmlString+="BSA=\""+formObjHdr.bsa.value+"\""+" ";
	xmlString+="BSA=\""+formObjHdr.bsaDisp.value+"\""+" ";
	xmlString+="doc_comp=\""+doc_comp+"\""+" ";
	xmlString+="status=\""+status+"\""+" ";
	xmlString+="db_mode=\""+db_mode+"\""+" ";
	xmlString+="table_name=\""+table_name+"\""+" />";
    return xmlString;
}

function createXMLForPersonnelDetails(){
  var rows=parent.ObjectCollect.personnel_rows;
  var table_name="AT_PERSONNEL";
  var len = rows.length;
  var xmlString ="";
  for(i=0;i<len;i++){
	 if(rows[i]!=null &&  rows[i].db_mode!='L'){
		xmlString+="<PERSONNEL_DTL"+i+" ";
		xmlString+="anesthesia_srl_no=\""+document.forms[0].anaesthesia_srl_no.value+"\""+" ";
		xmlString+="pract_type=\""+rows[i].pract_type+"\""+" ";
		xmlString+="practitioner_id=\""+rows[i].practitioner_id+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";

	 }
  }
  return xmlString;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="PAObjectCollectForm" id="PAObjectCollectForm">
<input type = "hidden" name="anaesthesia_srl_no" id="anaesthesia_srl_no" value='<%=request.getParameter("anesthesia_srl_no")%>'>
<input type = "hidden" name="params" id="params" value='<%=request.getQueryString()%>' >
</form>
</body>
</html>

