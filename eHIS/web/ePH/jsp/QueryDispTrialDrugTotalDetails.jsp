<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
      request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
    String locale			= (String)session.getAttribute("LOCALE");
  
    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../js/QueryDispDrug.js"></script> 
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin='0'>
<%
	
	String  drug_code	=	request.getParameter("drug_code");
	String  uom			=	request.getParameter("uom");
	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
	try{
		drug_code	 = CommonBean.checkForNull( drug_code );
		uom	 = CommonBean.checkForNull( uom );
	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	ArrayList chkFields = new ArrayList();
	chkFields.add( drug_code.trim() );
	//include all the common parameters.
	String sql=PhRepository.getPhKeyValue("SQL_QUERY_DISP_TRIAL_DRUG_SELECT3");
	
	if ( (!(drug_code.equals("")))&&(drug_code!=null))
	{
			sql=sql+" AND A.DISP_DRUG_CODE=?";
			chkFields.add( drug_code.trim() );
	}  

	sqlMap.put( "sqlData",  sql);
		
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add("TOTALPATIENTS");
	displayFields.add("TOTALORDERS");
	displayFields.add("ORDEREDQTY");
	displayFields.add("RETURNEDQTY");
	displayFields.add("DISPENSEDQTY");
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){

	%>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) 
			{

			records=(ArrayList) result.get( recCount );
		
		%>

				<table border="0" cellpadding="0" cellspacing="0" width="100%" align="LEFT" topmargin='0'>

	<%
				
							
out.println("<TR><tD ><B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalNoofPatients.label","ph_labels")+"</B></TD><td >"+(String)records.get( 0 )+"</td>");
				out.println("<tD ><B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalOrders.label","ph_labels")+"</B></tD><td >"+(String)records.get( 1 )+"</td><td><B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalOrderedQuantity.label","ph_labels")+"</B></td><td>"+(String)records.get( 2 )+" "+uom+"</td>");
				out.println("<TR><td><B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalDispensedQuantity.label","ph_labels")+"</B></td><td >"+(String)records.get( 4 )+" "+uom+"</td>");
				out.println("<tD ><B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalReturnedQuantity.label","ph_labels")+"</B></tD><td colspan=3>"+(String)records.get( 3 )+" "+uom+"</td></tr>");
							
					}			//end of record count
			}
			else{
			%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"))</script>
			<%
			}
			%>
	
		</tr>
	<%
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryPresVsDispOrder.jsp", searched) );
		}//end of try
	
	catch (Exception e)
	{
		out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
		</table>

</body>
</html>

