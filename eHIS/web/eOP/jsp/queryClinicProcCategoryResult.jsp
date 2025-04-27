<!DOCTYPE html>
<!--
     Program to query the VisitType for Patients 
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<HTML><head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  OnMouseDown='CodeArrest();' class='CONTENT'  onKeyDown = 'lockKey();'>

<%
    String whereClause = request.getParameter("whereclause");
   	StringBuffer sql =new StringBuffer();
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    Connection conn = null ;
	ResultSet rs = null;
	Statement stmt =null;
 
 try{
	 conn  =  ConnectionManager.getConnection(request);
	 
	 
    if ( (whereClause == null || whereClause.equals("")) )
    {
   
    String facilityid=(String)session.getValue("facility_id");
    String cd = request.getParameter("CLINIC_PROC_CATG_CODE");
    String longdesc = request.getParameter("long_desc");
    String enabled = request.getParameter("eff_status");

    int andCheck = 0;
    cd=cd.toUpperCase();
	    

    if ( !(cd == null || cd.equals("")) )
        {
        sql.append(" where upper(CLINIC_PROC_CATG_CODE) like upper('"+cd+"%')");
        andCheck = 1;
        }

    if ( !(longdesc == null || longdesc.equals("")) )
    {
        if ( andCheck == 1 )
        {   sql.append(" and ");
            sql.append("upper(long_desc) like  upper('"+longdesc+"%')");
        }
        else
        {
            sql.append("where upper(long_desc) like upper('"+longdesc+"%')" );
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
	
    } 
	else{
        sql.append(whereClause);
	}
    int start = 0 ;
    int end = 0 ;
    int i=1;
	int cnt=0;
	String endOfRes="1";

if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;



System.err.println(sql.toString());
stmt = conn.createStatement();
	
rs = stmt.executeQuery("select * from OP_CLINIC_PROC_CATEGORY "+sql.toString()); 


if ( start != 1 )
    for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	}

while(i<=end && rs.next()) 
{
	if(cnt==0)
	{
%>

<P>
<table align='right'>
<tr>
<td>
<%

 /* The Following block displays  14 records per page. we see the records
    bidirectionally by using Next and Previous hiperLinks */

if ( !(start <= 1) )
     
     out.println("<A HREF='../../eOP/jsp/queryClinicProcCategoryResult.jsp.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
 
if ( endOfRes.equals("1") )
    
     out.println("<A id='nextval' HREF='../../eOP/jsp/queryClinicProcCategoryResult.jsp.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
  
  %>
</td>
</tr>
</table>
<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<!--Display the records -->

<%
}    
    String classValue = "" ;
     
    if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
            classValue = "QRYODD" ;
      
    out.println("<tr><td align='left' class='" + classValue + "'>");
  	String facilityid=(String)session.getValue("facility_id");
    String code = rs.getString("CLINIC_PROC_CATG_CODE");
    String func="modify";
    out.println("<a href='../../eOP/jsp/addClinicProcCategory.jsp?facility_id="+facilityid+" &CLINIC_PROC_CATG_CODE="+ code + "&mode="+func+"' target='f_query_add_mod' >");
   
	out.println(code+"</a></td><td class='" + classValue + "' >");
  	out.println( rs.getString("long_desc") );
    out.println("</td><td class='" + classValue + "'>");
    out.println(rs.getString("short_desc") );
    	
    out.println("</td><td align='center' class='" + classValue + "'>");

    if ( rs.getString("eff_status").equals("E") )
      out.println("<img src='../../eCommon/images/enabled.gif'></img>");
   
	else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
    
	i++;
	cnt++;
	
} 

if(cnt==0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

if (!rs.next() && cnt!=0 )
    {
    endOfRes = "0";	
	
%>
<script>
	document.getElementById("nextval").innerHTML=" ";
	//document.getElementById("nextval").style.visibility='hidden';
</script>

<% } %>

</td></tr>
</table>
</center>
<br><center>

<%

sql.setLength(0);
}
catch(Exception e ){}
finally
{
	// Added by Raj when dealing with unclosed connections and resultsets 
	try{
	if (rs!=null) rs.close();
	if(stmt!=null)stmt.close();	
	}catch(Exception e){}
    if(conn!=null) ConnectionManager.returnConnection(conn,request); 
}
%>

</center>
</BODY>
</HTML>

