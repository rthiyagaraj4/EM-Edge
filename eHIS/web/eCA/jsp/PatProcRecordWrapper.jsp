<!DOCTYPE html>
<%@page import="java.sql.*, java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//String practitioner_type=(String)session.getValue("practitioner_type")==null?"":(String)session.getValue("practitioner_type");
String practitioner_type = request.getParameter("practitioner_type")==null?"":request.getParameter("practitioner_type");

session.putValue("practitioner_type",practitioner_type);

%>
<script>

const showPatProcRecord = async function() {
    var dialogHeight = "650px;";
    var dialogWidth = "1250px;";
    var dialogTop = "72";
    var center = "1";
    var status = "no";
    var features = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center:" + center + "; status:" + status + "; dialogTop:" + dialogTop;
    var args = "";
    var retVal = await window.showModalDialog("../../eCA/jsp/PatProcRecord.jsp?<%=request.getQueryString()%>", args, features);
};
showPatProcRecord() ;
</script>
