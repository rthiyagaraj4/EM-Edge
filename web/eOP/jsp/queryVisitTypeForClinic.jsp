<!DOCTYPE html>

<!-- Program for to fetch the visitType details for a particular clinic -->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  OnMouseDown='CodeArrest();' class='CONTENT' onKeyDown = 'lockKey();'>
<%
  /* The SQL query is used to retrieve the results based on the facilityID,visittypeCode,
 visittype_ind ,LongDesc and Effective Status.*/
   
		
	String whereClause = request.getParameter("whereclause");
    if(whereClause==null)
         whereClause="";
    StringBuffer sql=new StringBuffer();
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String fid=(String)session.getValue("facility_id");
    String cd="";
	String clinicdesc="";
	String proc_type="";

	String pfunctionID=request.getParameter("pid");
	if(pfunctionID==null)pfunctionID="";
 
   if ( (whereClause == null || whereClause.equals("")) )
   {
	 
    if(pfunctionID.equals("visit_type_for_proc_unit"))
	   {
          cd = request.getParameter("proc_code");
	
		  clinicdesc=request.getParameter("proc_name");
		  proc_type=request.getParameter("proc_type");
		  if(proc_type.equals("Y")) 
			  proc_type="D";
		  else
			  proc_type=proc_type;
	   }
	   else{
     cd = request.getParameter("clinic_code");
    clinicdesc=request.getParameter("clinic_name");
	   }
	

	String visittypecode = request.getParameter("visit_type_code");
    String visittypedesc = request.getParameter("visit_type_desc");
   
    String enabled1 = request.getParameter("nature");

    if ( !(cd == null || cd.equals("")) )
        {
        sql.append(" and upper(clinic_code) like upper('"+cd+"%' )");
       
        }

    if ( !(clinicdesc == null || clinicdesc.equals("")) )
        {
            sql.append(" and ");
            sql.append("upper(clinic_short_desc) like  upper('"+clinicdesc+"%')" );
        }

    if(!(proc_type==null || proc_type.equals("")|| proc_type.equals("A")))
	   {
		  sql.append(" and  care_locn_type_ind='"+proc_type+"' ");
		  
	   }

        if ( !(visittypecode == null || visittypecode.equals("")) )
        {
            sql.append(" and ");
            sql.append("upper(visit_type_code) like  upper('"+visittypecode+"%')" );
        }

    if ( !(visittypedesc == null || visittypedesc.equals("")) )
    {
        sql.append(" and ");
        sql.append("upper(visit_type_short_desc) like  upper('"+visittypedesc+"%')" );
    }

    if ( !(enabled1 == null || enabled1.equals("")) )
    {
       if ( enabled1.equals("E") )
            {
            sql.append(" and eff_status='E'");
        }
       if ( enabled1.equals("D") )
        {
            sql.append(" and eff_status='D'");
        }
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
     //end of where clause IF
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

Connection conn=null;
Statement stmt=null;
//ResultSet rs=null;
ResultSet rset=null;
//int maxRecord = 0;
StringBuffer sqlmain=new StringBuffer();

try
{
conn  =  ConnectionManager.getConnection(request);
Boolean isAERegisterTypeAutoUpdateAppl =	CommonBean.isSiteSpecific(conn, "AE", "AE_REG_TYPE_AUTO_UPDATE"); // added by mujafar for KDAH-CRF-0526
stmt = conn.createStatement();

/*if(pfunctionID.equals("visit_type_for_proc_unit"))
	{
	sqlmain.append("select count(*) as total from op_visit_type_for_clinic_vw  where facility_id='"+fid+"' and care_locn_type_ind in ('C','E','D')").append(sql);

	}
	else
	{
	sqlmain.append("select count(*) as total from op_visit_type_for_clinic_vw  where facility_id='"+fid+"' and care_locn_type_ind='C' ").append(sql);
	}
 
 rs=stmt.executeQuery(sqlmain.toString());
 rs.next();
 maxRecord = rs.getInt("total");

 if(rs != null) rs.close();

 sqlmain.setLength(0);

if(maxRecord == 0)
	{
  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	}
else
	{*/

	if(pfunctionID.equals("visit_type_for_proc_unit"))
	{
    
	if(isAERegisterTypeAutoUpdateAppl) // Added by mujafar for KDAH-CRF-0526
	 sqlmain.append("select * from op_visit_type_for_clinic_vw  where care_locn_type_ind in ('C','E','D','W') and facility_id='"+fid+"' ").append(sql);
	else
	 sqlmain.append("select * from op_visit_type_for_clinic_vw  where care_locn_type_ind in ('C','E','D') and facility_id='"+fid+"' ").append(sql);
	
	}else
	{
	 
	 sqlmain.append("select * from op_visit_type_for_clinic_vw  where care_locn_type_ind='C' and facility_id='"+fid+"' ").append(sql);
	}
	//out.println(sqlmain.toString());
	rset=stmt.executeQuery(sqlmain.toString());

	if(start != 1)
		for(int j=1;j<start;i++,j++)
			rset.next();

	while( i<=end && rset.next() )
	{
		if( cnt == 0 )
		{
%>

<P>
<table align='right'>
<tr>
<td>
<%

if(pfunctionID.equals("visit_type_for_proc_unit"))
	{
if ( !(start <= 1) )
   out.println("<A HREF='../../eOP/jsp/queryVisitTypeForClinic.jsp?from="+(start-14)+"&to="+(end-14)+"&pid="+pfunctionID+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	}
	else
	{
		if ( !(start <= 1) )
   out.println("<A HREF='../../eOP/jsp/queryVisitTypeForClinic.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	}
if(pfunctionID.equals("visit_type_for_proc_unit"))
	{
if ( endOfRes.equals("1") )
    out.println("<A id='nextval' HREF='../../eOP/jsp/queryVisitTypeForClinic.jsp?from="+(start+14)+"&to="+(end+14)+"&pid="+pfunctionID+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
    }
else
	{
	if ( endOfRes.equals("1") )
    out.println("<A id='nextval' HREF='../../eOP/jsp/queryVisitTypeForClinic.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='nones'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
    }
%>
</td>
</tr>
</table>
<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<%
if(pfunctionID.equals("visit_type_for_proc_unit"))
	{
%>
<th class='columnheader'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></th>
<%}else {%>
<th class='columnheader'><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.ClinicDescription.label" bundle="${common_labels}"/></th>
<%}%>
<th class='columnheader'><fmt:message key="Common.VisitTypeCode.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.VisitTypeDescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
}
	
        String classValue="";
		
	    if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;
        else
            classValue = "QRYODD";

		out.println("<tr><td class='" + classValue + "'>");
		String code = rset.getString("clinic_code");
		String fac = rset.getString("facility_id");
		String visit=rset.getString("visit_type_code");
		String careind=rset.getString("care_locn_type_ind");
		if(careind.equals("C"))
			careind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		else if(careind.equals("E"))
			careind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
		else if(careind.equals("D"))
			careind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");

		if(pfunctionID.equals("visit_type_for_proc_unit"))
		{
		   out.println(careind);
		   out.println("</td><td class='" + classValue + "'>");
		}

		if(pfunctionID.equals("visit_type_for_proc_unit"))
		{	
		out.println("<a href='../../eOP/jsp/addModifyVTForClinic.jsp?clinic="+code+" &visit="+visit+"&facility="+fac+"&procID="+pfunctionID+"'target='f_query_add_mod' >");
		}
		else{
			out.println("<a href='../../eOP/jsp/addModifyVTForClinic.jsp?clinic="+code+" &visit="+visit+"&facility="+fac+" 'target='f_query_add_mod' >");
			}
		out.println(code+"</a></td><td  class='" + classValue + "'>");
		out.println( rset.getString("clinic_short_desc") );
		out.println("</td><td class='" + classValue + "'>");
		out.println(visit );
		out.println("</td><td class='" + classValue + "'>");
		out.println(rset.getString("visit_type_short_desc") );
		out.println("</td><td align='center' class='" + classValue + "'>");

		if ( rset.getString("eff_status").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		i++;
		cnt++;
}

if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

if( !rset.next() && cnt!=0 )
{
%>
<script>
	document.getElementById("nextval").innerHTML = " ";
</script>
<%
}
	if(rset != null) rset.close();
	if(stmt != null) stmt.close();
	sql.setLength(0);
	sqlmain.setLength(0); 
}
catch(Exception e){
	e.printStackTrace();
	}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);

}%>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

