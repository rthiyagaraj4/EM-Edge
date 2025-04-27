<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->

<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eOT/js/PreOpIndicator.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	try
	{
   	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String DISCR_MSR_ID = request.getParameter("DISCR_MSR_ID")==null?"":request.getParameter( "DISCR_MSR_ID" );
	String SHORT_DESC =request.getParameter("SHORT_DESC")==null?"":request.getParameter( "SHORT_DESC" );
	
   if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(DISCR_MSR_ID == null || DISCR_MSR_ID.equals("")) ){
	        sql = sql + " and upper(A.DISCR_MSR_ID ) like upper('"+DISCR_MSR_ID +"%')";
			cnt++;
        }

        if ( !(SHORT_DESC == null || SHORT_DESC.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(B.SHORT_DESC) like upper('"+SHORT_DESC+"%')";
			else{
				sql=sql+" and upper(B.SHORT_DESC) like upper('"+SHORT_DESC+"%')";
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

    } //end of where clause IF
    else
            sql = whereClause;



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

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
int total=0;
ResultSet rset=null;
ResultSet rs = null;
try{
		
		String strsql="SELECT  A.DISCR_MSR_ID,  B.SHORT_DESC FROM  OT_DISCR_MSR  A,  AM_DISCR_MSR  B WHERE  A.DISCR_MSR_ID =  B.DISCR_MSR_ID"+sql;
		String strsql1="SELECT  A.DISCR_MSR_ID,  B.SHORT_DESC FROM  OT_DISCR_MSR  A,  AM_DISCR_MSR  B WHERE  A.DISCR_MSR_ID =  B.DISCR_MSR_ID"+sql;
		//out.println("sql1  :"+strsql);
		//out.println("<br>sql2  :"+strsql1);
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
       
		while(rs.next())
		total++;
		maxRecord=total;
		if(maxRecord == 0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		/*if(maxRecord==0) 
		{
			out.println("<script>alert('no records found');history.back();</script>");
			return;
		}
*/
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err PreOpIndicatorQueryResult" +e);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/PreOpIndicatorQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/PreOpIndicatorQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>Next</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class="columnHeaderCenter" nowrap> <!-- changed by yadav -->
<fmt:message key="Common.DiscreteMeasureCode.label" bundle="${common_labels}"/>
</th><!--20%-->
<th class="columnheadercenter" nowrap> <!-- changed by yadav -->
<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th><!--30%-->
<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ; // changed by yadav
                else
              classValue = "gridData" ; // changed by yadav
    out.println("<tr><td align=='left' class='"+classValue+"'>");
    DISCR_MSR_ID = rset.getString(1);
    SHORT_DESC=rset.getString(2);
	
	
	String preMorbidCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")  ;
	
	//String mode="delete";
	
	//out.println("<a href='../../eOT/jsp/PreOpIndicatorAddModify.jsp?mode="+mode+"&DISCR_MSR_ID="+ DISCR_MSR_ID+"' target='f_query_add_mod' >");
    out.println(DISCR_MSR_ID+"</td>");
  
   out.println("<td class='" + classValue+"'>"+SHORT_DESC+"</td>");
   	
	i++;
} %>

</td>
</tr>
</table>
</center>

<br><center>
<%
if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
ConnectionManager.returnConnection(conn,request);
}
catch(Exception e)
{
	e.printStackTrace();
	//System.err.println("ErrPreOpIndicatorQueryResult" +e);
}
%>
</center>
</form>
</BODY>
</HTML>

