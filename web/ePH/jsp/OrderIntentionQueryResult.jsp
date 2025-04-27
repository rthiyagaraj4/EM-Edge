<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<!-- OrderIntentionQueryResult.jsp -->


<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
	<head>
	<title></title>
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
		var code = obj.cells[0].innerText;

		document.location.href="OrderIntentionAddModify.jsp?mode=2&code="+code+"&function_id="+parent.function_id;
	}
	</script>
	<!-- <body OnMouseDown="CodeArrest()"; > -->
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" > 
 <%

    String indicator						=	 request.getParameter("indicator").trim();
    String order_intention_id				=	 request.getParameter("order_intention_id").trim();
    String order_intention_short_desc       =	 request.getParameter("order_intention_short_desc").trim();
    String order_intention_long_desc		=	 request.getParameter("order_intention_long_desc").trim();
    String eff_status						=	 request.getParameter("eff_status").trim();

	
	if(indicator == null)					{indicator = "";}
	if(order_intention_id == null)
	{order_intention_id = "";}
	else{order_intention_id = order_intention_id.toUpperCase();}

	if(order_intention_short_desc == null){order_intention_short_desc = "";}
	if(order_intention_long_desc == null){order_intention_long_desc = "";}
	if(eff_status==null || eff_status.equals("B")) eff_status="";

	boolean searched						=	request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue						=	"";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_ORDER_INTENTION_SELECT"));

	//Function Parameters
	HashMap funcMap = new HashMap();
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "intention_code" );
	displayFields.add( "problem_ind" );	
	displayFields.add( "short_desc" );	
	displayFields.add( "long_desc" );
	displayFields.add( "eff_status" );	
	

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( indicator + "%");
	chkFields.add( order_intention_id + "%");
	chkFields.add(order_intention_long_desc + "%");
	chkFields.add(order_intention_short_desc + "%" ); 
	chkFields.add( eff_status + "%");
	chkFields.add(locale);
	

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" border=0 align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="ePH.ProblemInd.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="Common.ShortDesc.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.LongDesc.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		%>
			<tr onClick="Modify(this);" >
		<%
		String link_columns = "1", disp ="";
		records=(ArrayList) result.get( recCount );

		for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK'><%=(String)records.get(colCount)%> </font></td>
			<%}else{
			
			if((colCount==1)){
						%>
					<td class="<%=classvalue%>" onclick="disableClick(event);">
					<%
//					out.println("align=\"center\">");											
//					out.println("IBA");
					out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH."+(String)records.get( colCount)+".label","ph_labels"));

					out.println("</td>"); 
					
					}

				else if((colCount == 2) || (colCount == 3)) {  
					%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);"><%
					out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
				%></td>
				<%
				}else{
					disp = (String)records.get(colCount);
					%>
					<td class="<%=classvalue%>"><%
					if(disp.equals("E")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(disp.equals("D")){%><img src="../../eCommon/images/disabled.gif"></img> <%}%></td>
					
					<%
				}
			}
		}
		%>
		</tr>
		<%}%>
		</table>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"OrderIntentionQueryResult.jsp", searched));
	}
	catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
	}	
	%>
	</body>
	</html>

