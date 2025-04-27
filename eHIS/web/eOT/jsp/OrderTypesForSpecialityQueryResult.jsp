<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eOT/js/OrderTypesForSpeciality.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<%	try{

    String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
    String speciality_code =request.getParameter("speciality_code")==null?"":request.getParameter( "speciality_code" );
	String order_type_code = request.getParameter("order_type_code")==null?"":request.getParameter( "order_type_code" );
	String order_type_desc = request.getParameter("order_type_desc")==null?"":request.getParameter( "order_type_desc" );
	String sql="";
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=1;
	
	if ( !(speciality_code == null || speciality_code.equals("")) )
		{
			sql+= "and  A.speciality_code = '"+speciality_code+"' ";
			//andCheck = 1;
			cnt++;
		}


	if ( !(order_type_code == null || order_type_code.equals("")) )
		{
		if(cnt>0)
			sql+= "and  upper(A.order_type_code) like upper('"+order_type_code+"%')";
			//andCheck = 1;
			else{
				sql=sql+" and upper(A.order_type_code) like upper('"+order_type_code+"%')";
				cnt=1;

		}
	} 
	 	
	if ( !(order_type_desc == null || order_type_desc.equals("")) )
		{
			if(cnt>0)
			sql+= "and  upper(C.short_desc) like upper('%"+order_type_desc+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" and upper(C.short_desc) like upper('%"+order_type_desc+"%')";
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
	int start = 0 ;
	int end = 0 ;
	int i=1;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

Connection 	conn = ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
ResultSet rs=null;
ResultSet rset=null;
int maxRecord = 0;
try{

String strsql="SELECT A.SPECIALITY_CODE, B.SHORT_DESC, A.ORDER_TYPE_CODE, C.SHORT_DESC FROM OT_SPECIALITY_ORDER_TYPES A, AM_SPECIALITY B, OR_ORDER_TYPE_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.ORDER_TYPE_CODE=C.ORDER_TYPE_CODE " +sql;


String strsql1="SELECT A.SPECIALITY_CODE, B.SHORT_DESC, A.ORDER_TYPE_CODE, C.SHORT_DESC FROM OT_SPECIALITY_ORDER_TYPES A, AM_SPECIALITY B, OR_ORDER_TYPE_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND A.SPECIALITY_CODE=B.SPECIALITY_CODE AND A.ORDER_TYPE_CODE=C.ORDER_TYPE_CODE " +sql;
   stmt = conn.prepareStatement(strsql);
   rs = stmt.executeQuery();
   int total=0;
		while(rs.next())
	{
		total++;

	}

	 maxRecord=total;
	 System.err.println(" Total rec in Max rec : "+maxRecord);
		if(maxRecord == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		
		
		stmt1=conn.prepareStatement(strsql1);
	System.err.println("SQL for order type for splty : "+strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		
	}

%>
<form name='QueryResult' id='QueryResult'>
<table align='right'>
<tr>
<td>
<%
	int a=14;
	int temp=(a+start);
if ( !(start <= 1) )
	out.println("<A HREF='../jsp/OrderTypesForSpecialityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( temp > maxRecord ) )
	out.println("<A HREF='../jsp/OrderTypesForSpecialityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
<br><br>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3 >

<th class="columnheadercenter" nowrap > <!-- changed by yadav -->
	<fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/>
</th>
<!-- <td class="columnHeader">
	<fmt:message key="Common.SpecialtyDescription.label" bundle="${common_labels}"/>
</td> -->
<th class="columnheadercenter" nowrap > <!-- changed by yadav -->
	<fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" nowrap > <!-- changed by yadav -->
	<fmt:message key="ePH.OrderTypeDescription.label" bundle="${ph_labels}"/>
	
</th>


<%
 	if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;

	}
/*if ( !(start <= 1) )
	out.println("<A HREF='../jsp/OrderTypesForSpecialityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( temp > maxRecord ) )
	out.println("<A HREF='../jsp/OrderTypesForSpecialityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

*/
	String classValue = "" ;
	
while ( rset.next() && i<=end )
{
        if ( i % 2 == 0 )
			classValue = "gridData" ; // changed by yadav
		else
			classValue = "gridData" ; // changed by yadav


	out.println("<tr><td class='" + classValue + "'>");

	 speciality_code = rset.getString(1);
	 order_type_code = rset.getString(3);
	 order_type_desc = rset.getString(4);

	out.println(speciality_code+"</td><td class='gridData'>"); // changed by yadav
	out.println(order_type_code+"</td><td class='" + classValue + "'>");
	out.println(order_type_desc);

	
	i++;

}


		
%>

</td></tr>
</table>
<br><center>
<%
	if(stmt!=null)
			stmt.close();
		if(stmt1!=null)
			stmt1.close();
		if(rset!=null)
			rset.close();
		if(rs!=null)
			rs.close();
		ConnectionManager.returnConnection(conn,request);

		}
catch(Exception e)
{
	e.printStackTrace();
		
}
%>
</center>

<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

