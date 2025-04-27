<!DOCTYPE html>
<%@ page import ="java.sql.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML>
<head>
 <%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/messages.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <%
 Connection conn  =  ConnectionManager.getConnection(request);
 try
{
	String facilityId=(String)session.getValue("facility_id");
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String amb_vehicle_type  = request.getParameter("amb_vehicle_type");
    String amb_veh_id = request.getParameter("amb_veh_id");
    String amb_veh_desc = request.getParameter("amb_veh_desc");
    String amb_veh_regnno = request.getParameter("amb_veh_regnno");
	
	if(amb_veh_desc == null)
	{
		amb_veh_desc = "";
	}
	else
	{
		amb_veh_desc = amb_veh_desc.toUpperCase();
	}
	
	if(amb_veh_regnno == null)
	{
		amb_veh_regnno = "";
	}
	else
	{
		amb_veh_regnno = amb_veh_regnno.toUpperCase();
	}
    
	
    String eff_status= request.getParameter("eff_status");

	int count = 0;

	if ( (whereClause == null || whereClause.equals("")) ){
		if ( !(amb_vehicle_type == null || amb_vehicle_type.equals("")) ){
			sql.append(" and upper(AMB_VEHICLE_TYPE ) like upper('"+amb_vehicle_type +"%')");			
        }
	
		if ( !(amb_veh_id == null || amb_veh_id.equals("")) ){ 
			sql.append(" and upper(AMB_VEHICLE_ID ) like upper('"+amb_veh_id +"%')");			
		}
		
    	if ( !(amb_veh_desc == null || amb_veh_desc.equals("")) ){			
			sql.append(" and upper(AMB_VEHICLE_NAME) like '"+amb_veh_desc+"%'");			
        }

		if ( !(amb_veh_regnno == null || amb_veh_regnno.equals("")) ){			
			sql.append(" and upper(AMB_REGN_NO) like '"+amb_veh_regnno+"%'");		
        }
  
		if(!(eff_status == null || eff_status.equals(""))){
			 if(eff_status.equals("E")){			
				   sql.append(" and eff_status='E'");			
			 }
			 if(eff_status.equals("D")){          
				   sql.append(" and eff_status='D'");					   
			 }
		}   
  
    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append(" order by ");
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql.append(ord[i]);
        else
            sql.append(ord[i]+",");
        }
    }

    } //end of where clause IF
    else
	{
		 sql.append(whereClause);
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



PreparedStatement stmt1=null;
PreparedStatement stmt=null;
int maxRecord = 0;
ResultSet rset = null;
ResultSet rs = null;


String strsql="select count(*) as total from AE_AMB_VEHICLE where FACILITY_ID='"+facilityId+"' "+sql.toString();

String strsql1="select AMB_VEHICLE_TYPE,AMB_VEHICLE_ID,AMB_VEHICLE_NAME,AMB_REGN_NO,EFF_STATUS from  AE_AMB_VEHICLE where FACILITY_ID='"+facilityId+"' "+sql.toString();

stmt = conn.prepareStatement(strsql);
rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");


if(maxRecord == 0)
{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); parent.f_query_add_mod.location.href ='../../eAE/jsp/AMBVechileQueryCriteria.jsp'</script>");
}


%>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eAE/jsp/AMBVehicleQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eAE/jsp/AMBVehicleQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th width='15%'><fmt:message key="eAE.AmbulanceType.label" bundle="${ae_labels}"/></th>
<th width='15%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
<th width='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th width='25%'><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></th>
<th width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>


<%
//rset.beforeFirst();

stmt1=conn.prepareStatement(strsql1);
rset = stmt1.executeQuery();


if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
 while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
            classValue = "QRYODD" ;

	out.println("<tr><td align=='left' class='" + classValue + "'>");

		String amb_vehicle_type1	=(rset.getString("AMB_VEHICLE_TYPE")==null)?"":rset.getString("AMB_VEHICLE_TYPE");
		String amb_veh_id1	 =(rset.getString("AMB_VEHICLE_ID")==null)?"":rset.getString("AMB_VEHICLE_ID");
		String amb_veh_desc1	 =(rset.getString("AMB_VEHICLE_NAME")==null)?"":rset.getString("AMB_VEHICLE_NAME");		
		String amb_veh_regnno1		=(rset.getString("AMB_REGN_NO")==null)?"":rset.getString("AMB_REGN_NO");
		String effective_status1		=(rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");
		String amb_vehicle_type_desc="";
		if(amb_vehicle_type1.equals("A"))
			amb_vehicle_type_desc="Air Ambulance";
		else if(amb_vehicle_type1.equals("M"))
			amb_vehicle_type_desc="Marine Ambulance";
		else if(amb_vehicle_type1.equals("R"))
			amb_vehicle_type_desc="Road Ambulance";

		out.println(amb_vehicle_type_desc);
		out.println("</td><td class='" + classValue + "'>");
	out.println("<a href='../../eAE/jsp/AMBVehicleAddModify.jsp?mode=update&amb_veh_id="+ URLEncoder.encode(amb_veh_id1)+"' target='f_query_add_mod' >");
    out.println(amb_veh_id1 + "</a></td><td class='" + classValue + "'>");

    out.println(amb_veh_desc1);
	out.println("</td><td class='" + classValue + "'>");
	out.println(amb_veh_regnno1);
    out.println("</td><td class='" + classValue + "' align='center'>");
	
	  if ( effective_status1.equalsIgnoreCase("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
out.println("</td>");
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%

if(rs!=null) rs.close();
if(stmt!=null) stmt.close();

if(rset!=null) rset.close();
if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
		System.out.println("@@ Exception in AMBTypeCodeQueryResult.jsp="+e.toString());
e.printStackTrace();
}
finally
{
	if (conn != null) 
	ConnectionManager.returnConnection(conn,request);
}	

%>

</center>
</BODY>
</HTML>

