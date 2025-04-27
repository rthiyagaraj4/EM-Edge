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
   <!--  <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
   <%
   request.setCharacterEncoding("UTF-8");
 //Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
   request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
   response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
   response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
   //ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

    <script language="JavaScript" src="../js/ReissueMed.js"></script>
	 <script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	 <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- <body topmargin=0 leftmargin=0 bottommargin=0 > -->
<body topmargin=0 leftmargin=0 bottommargin=0 onMouseDown="" onKeyDown="lockKey()">
<%
		String patient_class	= request.getParameter("patient_class");
		String code = "";
		String desc = "";
	    HashMap sqlMap = new HashMap();
		boolean searched            = request.getParameter( "searched" ) == null ? false : true  ;
    //Function Parameters
    HashMap funcMap = new HashMap();
    //The fields are going to be display
    ArrayList displayFields = new ArrayList();
  
    if(patient_class.equals("IP")){
			code = "Nursing Unit Code";
			desc = "Nursing Unit Description";
		    sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_ORDER_ROUTING_SELECT2"));
			  displayFields.add( "NURSING_UNIT_CODE" );
			  displayFields.add( "SHORT_DESC" );
	 }else{
 			code = "Clinic Code";
			desc = "Clinic Description";
		    sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_ORDER_ROUTING_SELECT3"));
			displayFields.add( "CLINIC_CODE" );
			displayFields.add( "SHORT_DESC" );
	 }
    //The fields are going to be in where condition * should match with the query
    ArrayList chkFields = new ArrayList();
	chkFields.add("C1");

    // Adding function related array list into the HashMap
    funcMap.put( "displayFields", displayFields );
    funcMap.put( "chkFields", chkFields );

    //Calling the Result from Common Adaptor as a arraylist.
   ArrayList DispDetails=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

%>

<form name="FormReissueMedOrdLookupResult" id="FormReissueMedOrdLookupResult" >
<% if( !( ((String) DispDetails.get(0)).equals("0")) ){
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

 <table cellpadding=0 cellspacing=0 width="50%"  align="center" border='1'>
<tr>
<th width="30%"><%=code%></th>
<th width="70%"><%=desc%></th>
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
            for(int colCount=0; colCount<records.size(); colCount+=2){
    %>
            <td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK' onclick="CloseOrdResult('<%=(String)records.get( colCount )%>','<%=(String)records.get( colCount+1 )%>')"><%=(String)records.get( colCount )%></font></td>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><%=(String)records.get( colCount+1 )%></td>

<%
		}%>
</tr>
<%		}
%>
</table>
<%
	 }
 %>
</form>
<%
out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ReissueMedOrdIDLookup.jsp", searched) );
%>
</body>
</html>
	

