<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

    <script  src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>

<% 
	request.setCharacterEncoding("UTF-8");

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	

    String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' onKeyDown = 'lockKey();' >");
    Connection conn  = null;
    String whereClause = request.getParameter("whereclause");
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql = new StringBuffer();
	String facilityid=(String)session.getValue("facility_id");
    String function = request.getParameter("function");
	 String function_id = request.getParameter("function_id");
    
	try
	{
	conn  =  ConnectionManager.getConnection(request);

	if ( (whereClause == null || whereClause.equals("")) )
    {
    sql.append(" where b.speciality_code = a.speciality_code and a.service_code = c.service_code ");
    String cd = request.getParameter("clinic_code");
    String longdesc = request.getParameter("long_desc");
    String speciality = request.getParameter("speciality_code");
    String proc_type = request.getParameter("proc_type");
    String age_group_code = request.getParameter("age_group_code");
    String ccd = request.getParameter("short_desc");
    String level_of_care_ind = request.getParameter("level_of_care_ind");
    String dept_code = request.getParameter("dept_code");
    String service_code = request.getParameter("service_code");
	String service_short_desc = request.getParameter("service_short_desc");
    String fs_locn_code = request.getParameter("fs_locn_code");
    String res_class = request.getParameter("res_class");	
    String ident_at_checkin = request.getParameter("ident_at_checkin");
    String enabled = request.getParameter("eff_status");
    String online_mr_notfn_yn = request.getParameter("online_mr_notfn_yn");
	if (online_mr_notfn_yn==null) online_mr_notfn_yn="";

    cd=cd.toUpperCase();
    speciality=speciality.toUpperCase();

    if ( !(facilityid == null || facilityid.equals("")) )
            {
            sql.append(" and a.facility_id like '"+facilityid+"%'");

        }
    if ( !(cd == null || cd.equals("")) )
        {
        sql.append(" and upper(a.clinic_code) like upper('"+cd+"%')");

        }

    if ( !(ccd == null || ccd.equals("")) )
    {
		
		sql.append(" and upper(b.short_desc) like  upper('"+ccd+"%')" );
    }

    if ( !(longdesc == null || longdesc.equals("")) )
    {

            sql.append(" and upper(a.long_desc) like  upper('"+longdesc+"%')" );
    }

    if ( !(speciality == null || speciality.equals("")) )
        {

            sql.append(" and upper(a.speciality_code) like  upper('"+speciality+"%')") ;

        }

    
	 if ( !(service_short_desc == null || service_short_desc.equals("")) )
        {
          
           sql.append(" and upper(c.short_desc) like  upper('"+service_short_desc+"%')" );

        }

    if ( !(proc_type == null || proc_type.equals("")) )
        {

            sql.append( " and upper(a.clinic_type) like  upper('"+proc_type+"%')" );

        }


    if ( !(age_group_code == null || age_group_code.equals("")) )
        {

             sql.append(" and upper(a.age_group_code) like  upper('"+age_group_code+"%')" );

        }

    if ( !(level_of_care_ind == null || level_of_care_ind.equals("")) )
        if( level_of_care_ind.equals("A") )
         {

         sql.append(" and a.level_of_care_ind='A'" );

         }
         if ( level_of_care_ind.equals("E") )
         {

          sql.append( " and a.level_of_care_ind='E'" );

         }

    if ( !(dept_code == null || dept_code.equals("")) )
        {
           sql.append(" and upper(a.dept_code) like  upper('"+dept_code+"%')" );

        }
    if ( !(service_code == null || service_code.equals("")) )
        {

           sql.append(" and upper(a.service_code) like  upper('"+service_code+"%')" );

        }
    if ( !(fs_locn_code == null || fs_locn_code.equals("")) )
        {

                sql.append(" and upper(a.fs_locn_code) like  upper('"+fs_locn_code+"%')" );

        }
    if ( !(res_class == null || res_class.equals("")) )
        {

         if( res_class.equals("P") )
         {

          sql.append(" and a.primary_resource_class='P'" );

         }
         if ( res_class.equals("R") )
         {

           sql.append(" and a.primary_resource_class='R'");

         }
		 if ( res_class.equals("E") )
         {

          sql.append(" and a.primary_resource_class='E'" );

         }
		 if ( res_class.equals("O") )
         {

          sql.append(" and a.primary_resource_class='O'" );

         }
      }

    if ( !(ident_at_checkin == null || ident_at_checkin.equals("")) )
        {

         if( ident_at_checkin.equals("P") )
         {

           sql.append(" and a.ident_at_checkin='P'" );

         }
         if ( ident_at_checkin.equals("X") )
         {

         sql.append(" and a.ident_at_checkin='X'" );

         }

        }

    if ( !(enabled == null || enabled.equals("")) )
    {
         if( enabled.equals("E") )
         {

           sql.append(" and a.eff_status='E'" );

         }
         if ( enabled.equals("D") )
         {

          sql.append(" and a.eff_status='D'" );

         }

	}

    if ( !(online_mr_notfn_yn == null || online_mr_notfn_yn.equals("")) )
    {
         if( online_mr_notfn_yn.equals("Y") )
         {

           sql.append(" and a.online_mr_notfn_yn='Y'" );

         }
         if ( online_mr_notfn_yn.equals("N") )
         {

          sql.append(" and a.online_mr_notfn_yn='N'" );

         }

	}

	if(function.equals("DaycareUnit"))
       sql.append(" and care_locn_type_ind = 'D'" );
	else
		sql.append(" and care_locn_type_ind = 'E'");

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append(" order by " );
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql.append(ord[i]);
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
	int cnt=0;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;



/*int maxRecord = 0;
Statement stmt;
stmt = conn.createStatement();
StringBuffer strsql = new StringBuffer();
strsql.append("select count(*) as total from op_clinic a, am_speciality b,am_service c ").append(sql);

ResultSet rs = stmt.executeQuery(strsql.toString());
rs.next();
maxRecord = rs.getInt("total");
if(maxRecord == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

Statement stmt1;
ResultSet rset;
stmt1=conn.createStatement();

StringBuffer strsql1= new StringBuffer();

 strsql1.append("select b.short_desc,a.clinic_code,a.long_desc,a.short_desc,a.eff_status,b.speciality_code  from op_clinic a, am_speciality b ,am_service c" ).append(sql);

//out.println(strsql1.toString());
 rset = stmt1.executeQuery(strsql1.toString()); 

 if( start != 1 )
	 for(int j=1;j<start;i++,j++)
		rset.next();
 
while ( i<=end && rset.next() ) 
{ 
	if (cnt == 0)
	{
 %>
<form name='query_proc' id='query_proc'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOP/jsp/queryProcUnit.jsp?function="+function+"&function_id="+function_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( endOfRes.equals("1") )
    out.println("<A id='nextval' HREF='../../eOP/jsp/queryProcUnit.jsp?function="+function+"&function_id="+function_id+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
    %>
</td>
</tr>
</table><br><br>
</P>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.SpecialtyDescription.label" bundle="${common_labels}"/></th>
<th class='columnheader' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
}
    
    String classValue = "" ;
 
    if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
            classValue = "QRYODD" ;

    out.println("<tr><td align=='left' class='" + classValue + "'>");

    String code = rset.getString(2);
	
    out.println("<a href='../../eOP/jsp/AddClinicResource.jsp?call_func="+function+"&function_id="+function_id+"&clinic_code="+ code + "' target='f_query_add_mod' >");
    out.println(code+"</a></td><td class='" + classValue + "'>");
    out.println( rset.getString(3) );
    out.println("</td><td class='" + classValue + "'>");
    out.println(rset.getString(4) );
    out.println("</td><td class='" + classValue + "'>");
    out.println(rset.getString("speciality_code"));
    out.println("</td><td class='" + classValue + "'>");
    out.println(rset.getString(1));
    out.println("</td><td align='center' class='" + classValue + "'>");

    if ( rset.getString("eff_status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
    i++;
	cnt++;
} 

if (cnt == 0)  
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

if(!rset.next() && cnt!=0)
{
	endOfRes = "0";
%>

<script>
	document.getElementById("nextval").innerHTML=" ";
</script>

<% }

//Added by Raj when dealing with unclosed connections, statements and resultsets on 10/17/2003
//if(stmt!=null)stmt.close();
if(stmt1!=null)stmt1.close();
//if(rs!=null)rs.close();
if(rset != null) rset.close();

sql.setLength(0);
//strsql.setLength(0);
strsql1.setLength(0);


}catch(Exception e)
	{
		e.printStackTrace();
	}
 finally
 {
	 if(conn!=null) ConnectionManager.returnConnection(conn,request);
 }

%>

</td></tr>
</table>
</form>
</BODY>
</HTML>

