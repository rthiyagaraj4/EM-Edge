<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" 
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><BODY  OnMouseDown='CodeArrest();'   onKeyDown = 'lockKey()' class='CONTENT'   >

<%
	
    String whereClause = request.getParameter("whereclause");
   	if(whereClause == null) whereClause="";

	StringBuffer sql =new StringBuffer();
    
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	Connection conn = null ;
	ResultSet rs = null;
	Statement stmt =null;
 
 try{
	
	if ((whereClause == null || whereClause.equals("")) )
    {
		String Qid = request.getParameter("queue_id");
		if(Qid == null) Qid="";
		
		String Qdesc = request.getParameter("queue_desc");
		if(Qdesc == null) Qdesc="";
		String enabled = request.getParameter("enable_yn");
		if(enabled == null) enabled="";

		String queue_pr=request.getParameter("queue_prefix");
		if(queue_pr == null) queue_pr="";

	    int andCheck = 0;
		Qid=Qid.toUpperCase();
		
		if ( !(Qid == null || Qid.equals("")) )
        {
        sql.append(" where upper(QUEUE_ID) like upper('"+Qid+"%')");
        andCheck = 1;
        }
		if ( !(Qdesc == null || Qdesc.equals("")) )
		{
        if ( andCheck == 1 )
        {   sql.append(" and ");
            sql.append("upper(QUEUE_DESCRIPTION) like  upper('"+Qdesc+"%')");
        }
        else
        {
            sql.append("where upper(QUEUE_DESCRIPTION) like upper('"+Qdesc+"%')" );
            andCheck = 1;
        }
		}
		if ( !(queue_pr == null || queue_pr.equals("")) )
		{
        if ( andCheck == 1 )
        {   sql.append(" and ");
            sql.append("upper(QUEUE_PREFIX) like  upper('"+queue_pr+"%')");
        }
        else
        {
            sql.append("where upper(QUEUE_PREFIX) like upper('"+queue_pr+"%')" );
            andCheck = 1;
        }
		}
		if ( !(enabled == null || enabled.equals("")) )
		{
			 if( enabled.equals("E") )
			 {
				if ( andCheck == 0 )
			   sql.append("where eff_status='E'");
			else
			   sql.append(" and eff_status='E'");
			 }
			 if ( enabled.equals("D") )
			 {
						if ( andCheck == 0 )
						   sql.append(" where  eff_status='D'");
						else
						   sql.append(" and eff_status='D'");
			 }    
		}
		 String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql.append(ord[i]);
			else
				sql.append(ord[i]).append(",");
			}
		}

	}else
        sql.append(whereClause);

	int start = 0 ;
    int end = 0 ;
    int i=1;
	int cnt = 0;


	if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

	conn  =  ConnectionManager.getConnection(request);
	stmt = conn.createStatement();

	//int maxRecord = 0;
	/*rs = stmt.executeQuery("select count(*) as total from op_queue_series "+sql.toString());
	rs.next();
	maxRecord = rs.getInt("total");
	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

	if(rs != null) rs.close();*/
	
	rs = stmt.executeQuery("select * from op_queue_series "+sql.toString()); 

	if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
	      rs.next() ;

	while( i<=end && rs.next() )	
	{
		if( cnt == 0 )
		{	

	%>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
     
     out.println("<A HREF='../../eOP/jsp/queryOPQSeriesResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
    
     out.println("<A id='nextval'  HREF='../../eOP/jsp/queryOPQSeriesResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
  
  %>
</td>
</tr>
</table>
<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader' style="background-color: color: white;" ><fmt:message key="eOP.QueueID.label" bundle="${op_labels}"/></th>
<th class='columnheader' style="background-color: color: white;" ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheader' style="background-color: color: white;" ><fmt:message key="eMP.prefix.label" bundle="${mp_labels}"/></th>
<th class='columnheader' style="background-color: color: white;" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%
    
}
    String classValue = "" ;
	
    if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
		        classValue = "QRYODD" ;
	out.println("<tr><td align='left' class='" + classValue + "'>");
    String queue_id = rs.getString("QUEUE_ID");
	String queue_desc=rs.getString("QUEUE_DESCRIPTION");
	int qpref=rs.getInt("QUEUE_PREFIX");
	String enable_yn=rs.getString("EFF_STATUS");
	String func="modify";	
	
	out.println("<a href='../../eOP/jsp/addModifyOPQSeries.jsp?queue_id="+queue_id+"&fun_value="+func+"' target='f_query_add_mod' >");
   
	out.println(queue_id+"</a></td><td class='" + classValue + "' >");
  	out.println(queue_desc);
    out.println("</td><td class='" + classValue + "'>");
    out.println(qpref);
    out.println("</td><td align=center class='" + classValue + "'>");
    if(enable_yn.equals("E"))
      out.println("<img src='../../eCommon/images/enabled.gif'></img>");
   	else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
    
	i++;
	cnt++;

}

if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

if( !rs.next() && cnt!=0 )
{
%>
<script>
	document.getElementById("nextval").innerHTML = " ";
</script>
<%}%>

</td></tr>
</table>
</center>

<br><center>
<%
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if (rs!=null) rs.close();
	if(stmt!=null)stmt.close();	
    if(conn!=null) ConnectionManager.returnConnection(conn,request); 
}
%>
</center>
</BODY>
</HTML>

