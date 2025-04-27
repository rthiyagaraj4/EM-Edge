<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<HTML>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%	
	
	String locale = (String)session.getAttribute("LOCALE");
	//setting the character encoding before retreiving any request
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String whereClause = request.getParameter("whereclause");
	String from = checkForNull(request.getParameter( "from" ) ) ;
    String to =   checkForNull(request.getParameter( "to" ) ) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
	int end =  ( to.equals("") )?14:Integer.parseInt(to);
    String status_code =checkForNull(request.getParameter( "status_code" ));
	String function_id = checkForNull(request.getParameter( "function_id" ));
	String function_desc_user = checkForNull(request.getParameter( "function_desc_user" ));
	String sql="";
    String status_desc="";
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=1;
	
	if ( !(status_code == null || status_code.equals("")) )
		{
			sql+= "and  A.status_code = '"+status_code+"' ";
			//andCheck = 1;
			cnt++;
		}


	if ( !(function_id == null || function_id.equals("")) )
		{
		if(cnt>0)
			sql+= "and  A.function_id = '"+function_id+"' ";
			//andCheck = 1;
			else{
				sql=sql+" and A.function_id = '"+function_id+"'";
				cnt=1;

		}
	} 
	 
	
	if ( !(function_desc_user == null || function_desc_user.equals("")) )
		{
			if(cnt>0)
			sql+= "and  upper(C.function_desc_user) like upper('%"+function_desc_user+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" and upper(C.function_desc_user) like upper('%"+function_desc_user+"%')";
				cnt=1;
			}
		}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ )
		 	{
			 	if ( i == ord.length - 1 )
				sql=sql+ord[i];
				else
				sql=sql+ord[i]+",";
			}
		}
	}//end of where clause IF

 else
    {
	sql = whereClause;
    }
	
Connection 	conn = ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
ResultSet rst=null;
int maxRecord = 0;
String strsql="SELECT A.STATUS_CODE , B.STATUS_DESC , A.FUNCTION_ID , C.FUNCTION_DESC_USER  FROM OT_FUNCT_APPL_FOR_STATUS A, OT_FUNCTIONS_LANG_VW C, OT_STATUS_LANG_VW B WHERE C.LANGUAGE_ID ='"+locale+"'  AND B.LANGUAGE_ID ='"+locale+"'  AND A.FUNCTION_ID	= C.FUNCTION_ID AND A.STATUS_CODE = B.STATUS_CODE " +sql;

StringBuffer sbr = new StringBuffer();

try{
    stmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  rst = stmt.executeQuery();
  //getting maximum record
  rst.last();	maxRecord = rst.getRow();
  //out.println(maxRecord);
  if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			
  }
  //again move the resultset pointer to initial position
  rst.beforeFirst();
%>
<form name='QueryResult' id='QueryResult'>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../jsp/FunctionsForStatusQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../jsp/FunctionsForStatusQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3 >
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.StatusCode.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.StatusDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.FunctionID.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.FunctionDescription.Label" bundle="${ot_labels}"/>
</th>

<%
	String classValue = "" ;
 	if ( start!= 1 ) rst.absolute(start-1);
	int i=start;
	while ( rst.next() && i<=end ){
        classValue = ( i % 2 == 0 )?"gridData":"gridData"; // changed by yadav
		sbr.append("<tr>");
		sbr.append("<td class='gridData'>"+rst.getString(1)+"</td>"); // changed by yadav
		sbr.append("<td class='"+classValue+"'>"+rst.getString(2)+"</td>");
		sbr.append("<td class='gridData'>"+rst.getString(3)+"</td>"); // changed by yadav
		sbr.append("<td class='"+classValue+"'>"+rst.getString(4)+"</td>");
		sbr.append("</tr>");
		i++;
}
out.println(sbr.toString());
}catch(Exception e){
	e.printStackTrace();
	//System.err.println("Err Msg From FunctionForStatusQueryResult-->"+e);
}finally{
		try{
			if(stmt!=null)	stmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(conn,request);
			sbr.setLength(0);
		}catch(Exception e){e.printStackTrace();}
}
%>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

