<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%><%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>


<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script></head><BODY  OnMouseDown='CodeArrest()' onLoad='ClearMsg()' onKeyDown = 'lockKey()' class='CONTENT'>");


	String whereClause = request.getParameter("whereclause");
	if(whereClause==null)
		whereClause="";
	String sql=" " ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	String locale = (String)session.getAttribute("LOCALE");

	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql = " ";
	String cd = request.getParameter("stn_id");
	String stnname = request.getParameter("stn_desc");
	String userid= request.getParameter("user_id");
	String username=request.getParameter("user_name");
	String facility_id = request.getParameter("facility_id");
	String facility_name = request.getParameter("facility_name");

	int andCheck = 0;

	if ( !(cd == null || cd.equals("")) )
	{
		sql = "where upper(oper_stn_id) like upper('"+cd+"%')";
		andCheck = 1;
	}

	if ( !(facility_id== null || facility_id.equals("")) )
	{
		if ( andCheck == 1 )
		{	sql = sql + " and ";
			sql = sql + " upper(facility_id)  like  upper('"+facility_id+"%') " ;
		}
		else
		{
			sql = " where upper(facility_id)   like upper('"+facility_id+"%') " ;
			andCheck = 1;
		}

	}

	if ( !(facility_name== null || facility_name.equals("")) )
	{
		if ( andCheck == 1 )
		{	sql = sql + " and ";
			sql = sql + " upper(facility_name)  like  upper('"+facility_name+"%') " ;
		}
		else
		{
			sql = " where upper(facility_name)   like upper('"+facility_name+"%') " ;
			andCheck = 1;
		}

	}



	if ( !(stnname == null || stnname.equals("")) )
	{
		if ( andCheck == 1 )
		{	sql = sql + " and ";
			sql = sql + "  upper(short_desc)  like upper('"+stnname+"%') " ;
		}
		else
		{
			sql = " where upper(short_desc)   like upper('"+stnname+"%') " ;
			andCheck = 1;
		}
	}
	if ( !(userid== null || userid.equals("")) )
	{
		if ( andCheck == 1 )
		{	sql = sql + " and ";
			sql = sql + " appl_user_id like  upper('"+userid+"%')" ;
		}
		else
		{
			sql = " where appl_user_id  like upper('"+userid+"%') " ;
			andCheck = 1;
		}

	}

	if ( !(username== null || username.equals("")) )
	{
		if ( andCheck == 1 )
		{	sql = sql + " and ";
			sql = sql + " upper(appl_user_name)  like  upper('"+username+"%') " ;
		}
		else
		{
			sql = " where upper(appl_user_name)   like upper('"+username+"%') " ;
			andCheck = 1;
		}

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
	 //end of where clause IF
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

Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try
{
	conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();



rs = stmt.executeQuery("select * from am_user_for_oper_stn_vw  "+sql);

if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

while ( i<=end && rs.next() )
  {
	if(maxRecord==0)
	  {

%>

<p>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryUserForOperatorStation.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryUserForOperatorStation.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>

</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader' ><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="eAM.OperatorStationID.label" bundle="${am_labels}"/></th>
<th class='columnheader'><fmt:message key="eAM.OperatorStationDescription.label" bundle="${am_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.EffectiveDate.label" bundle="${common_labels}"/> <fmt:message key="Common.from.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.EffectiveDate.label" bundle="${common_labels}"/> <fmt:message key="Common.to.label" bundle="${common_labels}"/></th>

<% }

  String classValue = "" ;

        if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
	        classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("OPER_STN_id");
	String spcode=rs.getString("appl_user_id");
	String dateString="";
	String dateString_disp="";

	if ( rs.getDate("eff_date_from") != null )
	{
	 java.sql.Date date = rs.getDate("eff_date_from");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	 dateString = formatter.format(date);
	 dateString_disp=DateUtils.convertDate(dateString,"DMY","en",locale);
	 formatter = null;
	}
	else
	{
		dateString="&nbsp";
	}


	out.println("<a href='../../eAM/jsp/UserForOperatorStation_Form.jsp?stn_id="+ code + "&uid="+spcode+"&date="+dateString+"&value=modify' target='f_query_add_mod' >");
	out.println(rs.getString("facility_id")+"</a> </td><td  class='" + classValue + "'>");
	out.println(rs.getString("facility_name")+" </td><td  class='" + classValue + "'>");
	out.println("<a href='../../eAM/jsp/UserForOperatorStation_Form.jsp?stn_id="+ code + "&uid="+spcode+"&date="+dateString+"&value=modify' target='f_query_add_mod' >");
	out.println(code+"</a></td><td  class='" + classValue + "'>");
	//out.println("<a href='../../eAM/jsp/UserForOperatorStation_Form.jsp?stn_id="+ code + "&uid="+spcode+"&date="+dateString+"&value=modify' target='f_query_add_mod' >");
	out.println( rs.getString("short_desc") );
	out.println("</td><td  class='" + classValue + "'>");
	//out.println("<a href='../../eAM/jsp/UserForOperatorStation_Form.jsp?stn_id="+ code + "&uid="+spcode+"&date="+dateString+"&value=modify' target='f_query_add_mod' >");
	out.println(spcode );
	out.println("</td> <td  class='" + classValue + "'>");
	//out.println("<a href='../../eAM/jsp/UserForOperatorStation_Form.jsp?stn_id="+ code + "&uid="+spcode+"&date="+dateString+"&value=modify' target='f_query_add_mod' >");
	out.println( rs.getString("appl_user_name") );
	out.println("</td><td  class='" + classValue + "'>");
	out.println(dateString_disp);
	out.println("</td><td class='" + classValue + "'>");

	if ( rs.getDate("eff_date_to") != null )
	{
	 java.util.Date date1 = rs.getDate("eff_date_to");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	 dateString = formatter.format(date1);
	 dateString_disp=DateUtils.convertDate(dateString,"DMY","en",locale);
	 out.println(dateString_disp);
	}
	else
	{
	 out.println("&nbsp;");
	}

	out.println("</td><td class='" + classValue + "'>");
	i++;
	maxRecord++;

  }//end of while

  if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}

}//end of try
	catch(Exception e){
		//out.print(e);
		e.printStackTrace();
	}
	finally
	{
		if(stmt!=null)	stmt.close();
		if(rs!=null) 	rs.close();
			ConnectionManager.returnConnection(conn,request);

	}
%>

</td></tr>
</table>
<br><center>
<!--%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/queryUserForOperatorStation.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/queryUserForOperatorStation.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/next.gif' alt='Next' border='0'></A>");
	rs.close();
%-->

</center>
</BODY>
</HTML>

