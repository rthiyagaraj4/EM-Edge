<!DOCTYPE html>
<!--
     Program to query the VisitType for Patients 
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
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
    String facilityid=(String)session.getValue("facility_id");
    String whereClause = request.getParameter("whereclause");
   	StringBuffer sql =new StringBuffer();
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    Connection conn = null ;
	ResultSet rs = null;
	Statement stmt =null;
   
	String vcode=null;
	String rclass=null;
	String rtype=null;
	
	String vdesc=null;
	String rdesc=null;
	 
/* The SQL query is used to retrieve the results based on the facilityID,visittypeCode,
 visittype_ind ,LongDesc and Effective Status.*/
 

  
 try{
    if ( (whereClause == null || whereClause.equals("")) )
    {
   
     vcode = request.getParameter("visit_type_code");
     rclass = request.getParameter("resource_class");
     rtype = request.getParameter("resource_type");
	 vdesc=request.getParameter("short_desc");
	 rdesc=request.getParameter("resource_short_desc");
     int andCheck = 0;
     vcode=vcode.toUpperCase();
    
 
    if ( !(facilityid == null || facilityid.equals("")) )
            {
            sql.append("where upper(facility_id) = upper('"+facilityid+"')");
            
			andCheck = 1;
        }
    if ( !(vcode == null || vcode.equals("")) )
        {
        sql.append(" and upper(visit_type_code) like upper('"+vcode+"%')");
        andCheck = 1;
        }
     if ( !(rclass == null || rclass.equals("")) &&!(rclass.equals("A")) )
    {
        if ( andCheck == 1 )
        {  

			 
			sql.append(" and ");
            sql.append("upper(resource_class) like  upper('"+rclass+"%')");
		}
        else
        {
            sql.append("where upper(resource_class) like upper('"+rclass+"%')" );
            andCheck = 1;
        }
    }
    if ( !(rtype == null || rtype.equals("")) )
    {
        if ( andCheck == 1 )
        {   sql.append(" and ");
            sql.append("upper(resource_type) like  upper('"+rtype+"%')");
        }
        else
        {
            sql.append("where upper(resource_type) like upper('"+rtype+"%')" );
            andCheck = 1;
        }
        
    }

	 if ( !(vdesc == null || vdesc.equals("")) )
    {
        if ( andCheck == 1 )
        {   sql.append(" and ");
            sql.append("upper(visit_type_desc) like  upper('"+vdesc+"%')");
        }
        else
        {
            sql.append("where upper(visit_type_desc) like upper('"+vdesc+"%')" );
            andCheck = 1;
        }
    }

 if ( !(rdesc == null || rdesc.equals("")) )
    {
        if ( andCheck == 1 )
        {   sql.append(" and ");
            sql.append("upper(resource_type_desc) like  upper('"+rdesc+"%')");
        }
        else
        {
            sql.append("where upper(resource_type_desc) like upper('"+rdesc+"%')" );
            andCheck = 1;
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
    else
        sql.append(whereClause);

    int start = 0 ;
    int end = 0 ;
    int i=1;
	int endOfRes = 1;
	int cnt =0;

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
/*int maxRecord = 0;
rs = stmt.executeQuery("select count(*) as total from op_resource_type_for_appt_vw "+sql.toString());
if(rs.next())
   maxRecord = rs.getInt("total");

if(rs != null) rs.close();

if(maxRecord == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

rs = stmt.executeQuery("select * from op_resource_type_for_appt_vw "+sql.toString()); 

if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
		rs.next() ;

while( i<=end && rs.next() )
{
	if (cnt == 0)
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
     
     out.println("<A HREF='../../eOP/jsp/QueryResourceTypeResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
 
if ( endOfRes == 1 )
    
     out.println("<A id='nextval' HREF='../../eOP/jsp/QueryResourceTypeResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
  
  %>
</td>
</tr>
</table>
<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.VisitTypeDescription.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="eOP.ResourceTypeDescription.label" bundle="${op_labels}"/></th>
<th class='columnheader' ><fmt:message key="eOP.ResourceCriteria.label" bundle="${op_labels}"/></th>


<!--Display the records -->

<%
}
    String classValue = "" ;	  
      
	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
    else
		classValue = "QRYODD" ;
      
    out.println("<tr><td align='left' class='" + classValue + "'>");
  	vcode = rs.getString("visit_type_code");
	String vtdesc=rs.getString("visit_type_desc");
    String  slno=rs.getString("resource_srl_no");
	String rcl=rs.getString("resource_class");
	if(rcl==null)rcl="&nbsp";
    
   String rt=rs.getString("resource_type");
   if(rt==null) rt="";
   String rtdesc=rs.getString("resource_type_desc");
   if(rtdesc==null)rtdesc="&nbsp";
   String rcriteria=rs.getString("resource_criteria");
   if(rcriteria==null)rcriteria="&nbsp";

	%>
	  <a href="../../eOP/jsp/resourceTypeVisitType.jsp?facility_id=<%=facilityid%>&visit_type_code=<%=vcode%>&resourceclass=<%=rcl%>&rsource_type=<%=rt%>&rsource_srl=<%=slno%>" target='f_query_add_mod' >
	<%

	//out.println("<a href='../../eOP/jsp/resourceTypeVisitType.jsp?facility_id="+facilityid+" &visit_type_code="+vcode+"&visitdesc="+vtdesc+"&resourceclass="+rcl+"&resource_desc="+rtdesc+"&rsource_type="+rt+"&rsource_srl="+slno+"' target='f_query_add_mod' >");
   	
	out.println(vcode+"</a></td><td class='" + classValue + "' >");
	out.println(vtdesc);
	out.println("</td><td class='"+classValue+"'>");
	out.println(slno);
	out.println("</td><td class='"+classValue+"'>");
  	out.println( rcl );
    out.println("</td><td class='" + classValue + "'>");
	if(rt.equals(""))
		rt = "&nbsp";
    out.println( rt );
    out.println("</td><td class='" + classValue + "'>");
	out.println(rtdesc);
	out.println("</td><td class='" + classValue + "'>");
	out.println(rcriteria);
	out.println("</td><td class='" + classValue + "'>");
   	
	i++;
	cnt++;
    
} 

if(cnt == 0)
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
catch(Exception e ){}
finally
{
   try{
	if(stmt!=null)stmt.close();
	if (rs!=null) rs.close();
   }catch(Exception e){}
    if(conn!=null) ConnectionManager.returnConnection(conn,request); 
}
%>

</center>
</BODY>
</HTML>

