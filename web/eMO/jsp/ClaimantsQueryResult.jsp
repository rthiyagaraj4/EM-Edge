<!DOCTYPE html>
 <%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>


<HTML><head>
<%
	request.setCharacterEncoding("UTF-8"); 
	//String locale = ((String)session.getAttribute("LOCALE"));
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<BODY  class='CONTENT' onLoad='ClearMsg()'; OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

    try{
	request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
    String whereClause = request.getParameter("whereclause");
	StringBuffer  sql=new StringBuffer() ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	//String facilityid=(String)session.getValue("facility_id");
	stmt = conn.createStatement();
	if ( (whereClause == null || whereClause.equals("")) )
	{
	String claimant_type_code=request.getParameter("claimant_type_code");
	String long_desc = request.getParameter("long_desc");
	String Claimant_type = request.getParameter("Claimant_type");
	String enabled = request.getParameter("eff_status");

	int andCheck = 0;
	if ( !(claimant_type_code == null || claimant_type_code.equals("")) )
		{
		sql.setLength(0);
		sql.append("where  upper(claimant_type_code) like upper('"+claimant_type_code+"%')");
		andCheck = 1;
		}

	if ( !(long_desc == null || long_desc.equals("")) )
	   {
		if ( andCheck == 1 )
		{	sql.append(" and upper(long_desc) like  upper('"+long_desc+"%')");
		}
		else
		{  sql.setLength(0);
			sql.append("where upper(long_desc) like upper('"+long_desc+"%')");
			andCheck = 1;
		}
	 }

	 /*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	 if ( !(Claimant_type == null || Claimant_type.equals("")) )
	   {
		if ( andCheck == 1 )
		{	sql.append(" and upper(Claimant_type) =  upper('"+Claimant_type+"')");
		}
		else
		{  sql.setLength(0);
			sql.append("where upper(Claimant_type) = upper('"+Claimant_type+"')");
			andCheck = 1;
		}
	   }

/*
if ( !(Claimant_type == null || Claimant_type.equals("")) )
	{
	   if ( Claimant_type.equals("K") )
	        {
		       if ( andCheck == 0 )
			    {sql.setLength(0);
			     sql.append("where Claimant_type='K'");
			     andCheck = 1;
			    }
		       else
			      sql.append(" and Claimant_type='K'");
		    }
			 if ( Claimant_type.equals("E") )
	        {
		       if ( andCheck == 0 )
			    {sql.setLength(0);
			     sql.append("where Claimant_type='E'");
			     andCheck = 1;
			    }
		       else
			      sql.append(" and Claimant_type='E'");
		    }
			if ( Claimant_type.equals("M") )
	        {
		       if ( andCheck == 0 )
			    {sql.setLength(0);
			     sql.append( "where Claimant_type='M'");
			     andCheck = 1;
			    }
		       else
			      sql.append(" and Claimant_type='M'");
		    }
			if ( Claimant_type.equals("W") )
	        {
		       if ( andCheck == 0 )
			    {sql.setLength(0);
			     sql.append("where Claimant_type='W'");
			     andCheck = 1;
			    }
		       else
			      sql.append(" and Claimant_type='W'");
		    }

			if ( Claimant_type.equals("U") )
	        {
		       if ( andCheck == 0 )
			    {sql.setLength(0);
			     sql.append("where Claimant_type='U'");
			     andCheck = 1;
			    }
		       else
			      sql.append(" and Claimant_type='W'");
		    }
			if ( Claimant_type.equals("R") )
	        {
		       if ( andCheck == 0 )
			    {
			     sql.append("where Claimant_type='R'");
			     andCheck = 1;
			    }
		       else
			      sql.append(" and Claimant_type='R'");
		    }
			if ( Claimant_type.equals("O") )
	        {
		       if ( andCheck == 0 )
			    {
			     sql.append("where Claimant_type='O'");
			     andCheck = 1;
			    }
		       else
			      sql.append(" and Claimant_type='O'");
		    }

	}
*/
/*End ML-MMOH-CRF-1095*/

if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
				sql.append("where EFF_STATUS='E'");
			else
				sql.append(" and EFF_STATUS='E'");
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
				sql.append(" where  EFF_STATUS='D'");
			else
				sql.append(" and EFF_STATUS='D'");
		}
	}
	
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql=sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql.append(ord[i]);
		else
			sql.append(ord[i]+",");
		}
	}
	}else
	{
	sql.append(whereClause);
	}  //end of where clause IF
	

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



/*int maxRecord = 0;


String strsql1=" select count(*) as total from MO_CLAIMANT_TYPE_lang_vw "+sql;

rs = stmt.executeQuery(strsql1);
rs.next();
maxRecord = rs.getInt("total");
if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");*/
StringBuffer strsql2=new StringBuffer();

/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
strsql2.append("SELECT claimant_type_code, long_desc, short_desc, (SELECT short_desc FROM mo_claimant_type_mstr WHERE claimant_type_mstr_code = mo_claimant_type.claimant_type) claimant_type, eff_status FROM mo_claimant_type "+sql.toString());

/*strsql2.append("select * from MO_CLAIMANT_TYPE "+sql.toString());*/
/*End ML-MMOH-CRF-1095*/

rs = stmt.executeQuery(strsql2.toString());
;
%>


<%
if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue = "" ;
		  int cnt=0;
while (i<=end  && rs.next() )
{
	if(cnt==0)
	{%>
		<p>
		<table align='right'>
		<tr>
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A  HREF='../jsp/ClaimantsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if (!(start+14))
			out.println("<td align ='right' id='next' style='visibility:hidden'><A  HREF='../jsp/ClaimantsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		%>

		</tr>
		</table>
		</p>
		<br>
		<br>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th  class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>

		<th  class='columnheader'><fmt:message key="eMO.ClaimantTypeRelat.label" bundle="${mo_labels}"/></th>

		<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%	}
        if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
	else
		  classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	String claimant_type_code = rs.getString("claimant_type_code");
	String claimant_desc="";
	out.println("<a href='../jsp/addModifyClaimants.jsp?operation=modify&claimant_type_code="+claimant_type_code+ "' target='f_query_add_mod' >");
	out.println(claimant_type_code+"</a></td><td class='" + classValue + "'>");
	out.println(rs.getString("Long_Desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("Short_desc") );
	out.println("</td><td align='left' class='" + classValue + "'>");
	String claimant_type = rs.getString("Claimant_type");
	
	/*Commented by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	/*if(	claimant_type.equals("M"))
		claimant_desc = "Embassy of a Country";
	if(	claimant_type.equals("O"))
		claimant_desc = "Others";
	if(	claimant_type.equals("R"))
		claimant_desc = "Religious Organizations";
	if(	claimant_type.equals("W"))
		claimant_desc = "Welfare Associations";
	if(	claimant_type.equals("U"))
		claimant_desc = "Under Taker";*/

	out.println(claimant_type); /*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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



	<%}
%>
</td></tr>
</table>
<br><center>

<%
rs.close();

}catch(Exception e) {
	out.println("main try"+e);
	e.printStackTrace();}
finally
{
	if (rs != null)   rs.close();
	if (stmt != null)   stmt.close();
	ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</BODY>
</HTML>

