<!DOCTYPE html>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

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
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordIntraAnesthesia.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
<script language='javascript'>
var rows = new Array();
var rowLength=0;
var line_no=0;
var personnel_rows = new Array();
var personnel_len=0;

</script>
<script language='javascript'>

function createXMLForPersonnelDetails(){
  var rows=parent.Intra_anesthesia_objectcollect_frame.personnel_rows;
  var table_name="AT_PERSONNEL";
  var len = rows.length;
  var xmlString ="";
  for(i=0;i<len;i++){
	 if(rows[i]!=null &&  rows[i].db_mode!='L'){
		xmlString+="<PERSONNEL_DTL"+i+" ";
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
</form>
</body>
</html>

