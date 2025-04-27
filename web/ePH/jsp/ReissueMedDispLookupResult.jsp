<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
    <!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="JavaScript" src="../js/ReissueMed.js"></script>
	<script language="Javascript" src="../../eCommon/js/messages.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>

<!-- <body topmargin=0 leftmargin=0 bottommargin=0 > -->
<body topmargin=0 leftmargin=0 bottommargin=0 onMouseDown="" onKeyDown="lockKey()">
<%
		String DispCode=request.getParameter("DispCode");
		String DispDate=request.getParameter("DispDate");
		String DrugCode=request.getParameter("DrugCode");
		String OrderId=request.getParameter("OrderId");
		String OrderDate=request.getParameter("OrderDate");
		String PatientClass=request.getParameter("PatientClass");
		String PatientId=request.getParameter("PatientId");
		String OrderLocation=request.getParameter("OrderLocation");
		
	
		HashMap sqlMap = new HashMap();
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_REISSUE_MEDICATION_SELECT2"));
		boolean searched            = request.getParameter( "searched" ) == null ? false : true  ;
    //Function Parameters
		HashMap funcMap = new HashMap();
		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add( "DISP_NO" );
		displayFields.add( "DISP_DATE_TIME" );
		displayFields.add( "ADDED_BY_ID" );
		displayFields.add( "DRUG_DESC" );
		displayFields.add( "DISP_QTY" );
		displayFields.add( "PATIENT_ID" );
		displayFields.add( "LOCN_CODE");

    
    //The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();

		chkFields.add("C1");
		chkFields.add(DispCode);
		chkFields.add(DispCode);
		chkFields.add(DispDate);
		chkFields.add(DispDate);
		chkFields.add(DrugCode);
		chkFields.add(DrugCode);
		chkFields.add(OrderId);
		chkFields.add(OrderId);
		chkFields.add(OrderDate);
		chkFields.add(OrderDate);
		chkFields.add(PatientClass);
		chkFields.add(PatientClass);
		chkFields.add(OrderLocation);
		chkFields.add(OrderLocation);
		chkFields.add(PatientId);
		chkFields.add(PatientId);
    // Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

    //Calling the Result from Common Adaptor as a arraylist.
	    ArrayList DispDetails=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

%>


<form name="FormReissueMedDispLookupResult" id="FormReissueMedDispLookupResult" >
<% if( !( ((String) DispDetails.get(0)).equals("0"))){
    %>
        <table cellpadding=0 cellspacing=0 width="100%" align="center">
        <tr>
        <td width="80%" class="white">&nbsp;</td>
        <td width="20%" class="white">&nbsp;
    <%
        // For display the previous/next link
         out.println(DispDetails.get(1));
    %>
        </td></tr>
        </table>

 <table cellpadding=0 cellspacing=0 width="100%"  align="center" border='1'>
<tr>
<th width="15%"><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></th>
<th width="20%">Date Time</th>
<th width="20%"><fmt:message key="ePH.DispensedBy.label" bundle="${ph_labels}"/></th>
<th width="20%">Drug Name</th>
<th width="15%">Disp Qty</th>
</tr>
<%
		ArrayList records=new ArrayList();
		String classvalue="";
        for(int recCount=2; recCount<DispDetails.size(); recCount++) {
            if ( recCount % 2 == 0 )
                classvalue = "QRYODD" ;
            else
                classvalue = "QRYEVEN" ;
    %>
            <tr >
    <%

            records=(ArrayList) DispDetails.get( recCount );
            for(int colCount=0; colCount<records.size(); colCount+=7){
    %>
            <td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK' onclick="CloseResult('<%=(String)records.get( colCount )%>','<%=(String)records.get( colCount+5 )%>','<%=(String)records.get( colCount+6 )%>')"><%=(String)records.get( colCount )%></font></td>
		<td class="<%=classvalue%>"  ><%=(String)records.get( colCount+1 )%></td>
		<td class="<%=classvalue%>" ><%=(String)records.get( colCount+2 )%></td>
		<td class="<%=classvalue%>" ><%=(String)records.get( colCount+3 )%></td>
		<td class="<%=classvalue%>"  ><%=(String)records.get( colCount+4 )%></td>
		<input type=hidden name='Patient_id' id='Patient_id'<%=recCount%> value='<%=(String)records.get( colCount+5 )%>'>
<%
		}
		}
%>
</table>
<%
	 }
else{
%>
<script>
	alert(getMessage("NO_RECORD_FOUND"));
</script>
<%
}
 %>
</form>
<%
out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ReissueMedDispLookupResult.jsp", searched) );
%>
</body>
</html>
	

