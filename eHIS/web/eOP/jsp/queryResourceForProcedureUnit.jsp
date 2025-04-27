<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<%
request.setCharacterEncoding("UTF-8");

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey();' >");

    String whereClause = request.getParameter("whereclause");
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql = new StringBuffer();
    String facilityid=(String)session.getValue("facility_id");
	String function = request.getParameter("function");
	String clinictype="";


    if ( (whereClause == null || whereClause.equals("")) )
    {
	String unittype=request.getParameter("unit_type");
	
	String resourceclass=request.getParameter("resource_class");
	String resourceunit=request.getParameter("resource_unit");
	String resourceunitdesc=request.getParameter("resource_unit_desc");
	String resource_code=request.getParameter("resource_code");
	String resource_desc=request.getParameter("resource_desc");

    

	String enabled = request.getParameter("eff_status");
    

    if ( !(facilityid == null || facilityid.equals("")) )
    {
		sql.append( " where facility_id like '"+facilityid+"%'");
    }

   
	if ( !(unittype == null || unittype.equals("")) )
	{
		
		if(unittype.equals("C"))
		{
			sql.append( " and care_locn_type_ind ='C'" );
		}
		else if(unittype.equals("E"))
		{
			sql.append(" and care_locn_type_ind ='E'" );
		}
		else if(unittype.equals("Y"))
		{
			sql.append( " and care_locn_type_ind ='D'" );
		}		
	}    


    if ( !(resourceclass == null || resourceclass.equals("")) )
	{
		 if( resourceclass.equals("P") )
         {
			sql.append(" and resource_class='P'" );
		 }
		 else  if( resourceclass.equals("R") )
         {
			 sql.append(" and resource_class='R'");
		 }
		 else  if( resourceclass.equals("E") )
         {
			sql.append(" and resource_class='E'" );
		 }
		 else  if( resourceclass.equals("O") )
         {
			sql.append(" and resource_class='O'" );
		 }
		
	}
	if ( !(resourceunit == null || resourceunit.equals("")) )
    {
		
		sql.append(" and upper(clinic_code) like upper('"+resourceunit+"%')" );
    }

	if ( !(resourceunitdesc == null || resourceunitdesc.equals("")) )
    {
		
		sql.append( " and upper(clinic_name) like upper('"+resourceunitdesc+"%')" );
    }
    if ( !(resource_code == null || resource_code.equals("")) )
    {
		
		 sql.append( " and upper(practitioner_id) like upper('"+resource_code+"%')");
    }
	if ( !(resource_desc == null || resource_desc.equals("")) )
    {
		
		sql.append(" and upper(practitioner_short_name) like upper('"+resource_desc+"%')");
    }

	 if ( !(enabled == null || enabled.equals("")) )
    {
         if( enabled.equals("E") )
         {

           sql.append( " and eff_status='E'" );

         }
         if ( enabled.equals("D") )
         {

           sql.append(" and eff_status='D'");

         }
	}

	String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append( " order by " );
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql.append(ord[i] );
        else
            sql.append(ord[i]).append(",");
        }
    }
    } //end of where clause IF
    else
            sql.append(whereClause);

	String endOfRes = "1";

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

Connection conn  =  null;
//int maxRecord = 0;
PreparedStatement pstmt = null;
ResultSet rset;

try{
conn  =  ConnectionManager.getConnection(request);

/*String strsql="select count(*) as total from op_pract_for_clinic_vw "+sql.toString();

pstmt=conn.prepareStatement(strsql);
ResultSet rs = pstmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");
if(maxRecord == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

if(pstmt != null) pstmt.close();
if(rs != null) rs.close();*/


String strsql1="select care_locn_type_ind,resource_class,decode(resource_class,'P','Practitioner','R','Room','E','Equipment','O','Other') resource_desc,clinic_code,clinic_name short_desc,practitioner_id,practitioner_short_name short_name,eff_status,decode(care_locn_type_ind,'C','Clinic','E','Exam/Procedure Unit','D','Daycare Unit') care_locn_desc,clinic_type FROM  op_pract_for_clinic_vw"+sql.toString();

pstmt=conn.prepareStatement(strsql1);
rset = pstmt.executeQuery();

 if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
		rset.next() ;

while( i<=end && rset.next() )
{
	if( cnt == 0 )
	{
%>

<P>
<form name='query_resource' id='query_resource'>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOP/jsp/queryResourceForProcedureUnit.jsp?function="+function+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( endOfRes.equals("1") )
    out.println("<A id='nextval' HREF='../../eOP/jsp/queryResourceForProcedureUnit.jsp?function="+function+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
    %>
</td>
</tr>
</table><br><br>
</P>
 
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader' ><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.ResourceCode.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%

}
    String classValue = "" ;
	
    if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
            classValue = "QRYODD" ;

    out.println("<tr><td align=='left' class='" + classValue + "'>");

    String type = rset.getString(1);
	String resclass=rset.getString(2);
	String resclassdesc =(rset.getString(3) == null)?"":rset.getString(3);
	String unit=rset.getString(4);
	String pid=rset.getString(6);
	clinictype=rset.getString(10);
	
    
	out.println("<a href='../../eOP/jsp/InsertPClinic.jsp?call_func="+function+"&care_locn_type="+type+"&unit_type="+clinictype+"&resource_unit="+unit+"&res_class="+resclass+"&practitioner_id="+pid+"' >");
	out.println(unit+"</a></td><td class='" + classValue + "'>");
    out.println(rset.getString(9)+"</td><td class='" + classValue + "'>");   
	out.println("<a href='../../eOP/jsp/InsertPClinic.jsp?call_func="+function+"&care_locn_type="+type+"&unit_type="+clinictype+"&resource_unit="+unit+"&res_class="+resclass+"&practitioner_id="+pid+"'>" );	
	out.println(rset.getString(5)+"</a></td><td class='" + classValue + "'>");
	 
    out.println(resclassdesc+"</td><td class='" + classValue + "'>");
	out.println(rset.getString(6)+"</td><td class='" + classValue + "'>");
	out.println(rset.getString(7) );
	out.println("</td><td class='" + classValue + "' align='center'>");
	if ( rset.getString("eff_status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

	out.println("</td>");
	
    i++;
	cnt++;
} 

if( cnt == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

if( !rset.next() && cnt!=0 )
{
%>
<script>
	document.getElementById("nextval").innerHTML = " ";
</script>
<%
}
	if(pstmt != null) pstmt.close();
	//if(rs!=null)rs.close();
	if(rset != null) rset.close();

	}catch(Exception e) {
		e.printStackTrace();
		}
	finally
		{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);  
		}
	//Added by Raj when dealing with unclosed connections, statements and resultsets on 10/17/2003

	%>

	</td></tr>
	</table>
	</center>

	<br><center>


	</center>
	</form>
	</BODY>
	</HTML>

