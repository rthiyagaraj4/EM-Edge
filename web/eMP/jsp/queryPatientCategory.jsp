<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' > 
<%
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String type_desc = "";
	String temp = "";
	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd = request.getParameter("pat_cat_code");
	cd = cd.toUpperCase();
	String longdesc = request.getParameter("long_desc");
	longdesc = longdesc.toUpperCase();
	String enabled = request.getParameter("nature");
	String pat_cat_type = request.getParameter("govt_or_pvt_ind")==null?"A":request.getParameter("govt_or_pvt_ind");
	int andCheck = 0;
	if ( !(cd == null || cd.equals("")) )
	{
		sql.append("where pat_cat_code like '");
		sql.append(cd);
		sql.append("%'");
		andCheck = 1;
		
	}
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	sql.append(" and ");
			sql.append("upper(long_desc) like  '");
			sql.append(longdesc);
			sql.append("%'") ;
		}
		else
		{
			sql.append("where upper(long_desc) like '");
			sql.append(longdesc);
			sql.append("%'") ;
			andCheck = 1;
		}
	}
	if(!pat_cat_type.equals("A"))
		{
			if ( andCheck == 0 )
			{
			sql.append(" where govt_or_pvt_ind='");
			sql.append(pat_cat_type);
			sql.append("' ");
			andCheck = 1;
			}
			else
			{
			sql.append(" and govt_or_pvt_ind='");
			sql.append(pat_cat_type);
			sql.append("' ");			
			}

		}



	if ( !(enabled == null || enabled.equals("")) )
	{
	    if ( enabled.equals("E") )
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
	    if ( enabled.equals("B") )
	    {
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
			{
			sql.append(ord[i]);
			sql.append(",");
			}
		}
	}

	} //end of where clause IF
	else
	{
		sql.setLength(0);
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

Connection conn = null;
Statement stmt=null;
ResultSet rs=null;
//int maxRecord = 0;
try
{
	conn = ConnectionManager.getConnection(request);
try
{
stmt = conn.createStatement();
String query="select ENTITLEMENT_BY_PAT_CAT_YN from mp_param";
 rs = stmt.executeQuery(query);
 String eligibility="";
 while(rs.next())
 {
    eligibility=rs.getString("ENTITLEMENT_BY_PAT_CAT_YN");
 }
 if(rs!=null) rs.close();
/* rs = stmt.executeQuery("select count(*) as total from mp_pat_category "+sql.toString());

rs.next();

maxRecord = rs.getInt("total");

if(rs!=null) rs.close();
if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/
rs = stmt.executeQuery("select * from mp_pat_category "+sql.toString()); 
%>




<%
	
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

	  	  String classValue = "" ;
		  int cnt=0;
while ( i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryPatientCategory.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryPatientCategory.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</P>

		<center>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
			<%if(eligibility.equals("Y")){%>
			<th><fmt:message key="eMP.ExpiryApplicable.label" bundle="${mp_labels}"/> </th>
			<th><fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/></th>
			
			<%}%>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%	}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;

	out.println("<tr><td align='left' class='" + classValue + "'>");
	String code = rs.getString("pat_cat_code");

	out.println("<a href='../../eMP/jsp/patientcategoryModify.jsp?patient_cat_code="+ code + "' target='f_query_add_mod'>"+code+"</a></td>");

        out.println("<td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	out.println("</td><td class='" + classValue + "'>");

	temp = rs.getString("govt_or_pvt_ind");
	if(temp.equals("G"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Government.label","common_labels");

	if(temp.equals("S"))   type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Semigovernment.label","mp_labels");
	if(temp.equals("R"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Pensioner.label","mp_labels");

	if(temp.equals("P"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Private.label","common_labels");

	if(temp.equals("T"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Student.label","mp_labels");
	if(temp.equals("B"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RegisteredDisabled.label","mp_labels");
	if(temp.equals("C"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PersonUnderPoliceCustody.label","mp_labels");

	if(temp.equals("I"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Prisoners.label","mp_labels");
	if(temp.equals("W"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EstateWorkers.label","mp_labels");
	if(temp.equals("U"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Unemployed.label","mp_labels");
	if(temp.equals("F"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Foreigner.label","mp_labels");
	if(temp.equals("D"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DesignatedRoyalties.label","mp_labels");
	if(temp.equals("E"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SelfEmployed.label","mp_labels");
	if(temp.equals("V"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VIP.label","common_labels");
	if(temp.equals("K"))  type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");

	out.println(type_desc);
    if(eligibility.equals("Y")){
	
	out.println("</td><td class='" + classValue + 
		"'  align='center'>");
    if(rs.getString("EXP_VAL_APPL_YN").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td><td class='" + classValue + "'  align='center'>");
    out.println(checkForNull(rs.getString("EXP_PERIOD_IN_DAYS"),"&nbsp;") );
	}
	out.println("</td><td class='" + classValue + 
		"'  align='center'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td></tr>");
	
	i++;
	cnt++;
} 
	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}%>

</td></tr>
</table>
</center>

<br><center>
<%

if ( rs != null ) rs.close() ;
if ( stmt != null ) stmt.close() ;
}catch(Exception e) { out.println(e.toString());}
}catch(Exception e) { out.println(e.toString());}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
</center>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

