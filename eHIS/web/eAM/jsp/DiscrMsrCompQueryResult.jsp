<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<HTML>
	<head>
		
		<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" class='CONTENT'>
<%
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");

	StringBuffer sql=new StringBuffer() ;
	String resulttypecode[] = {"","C","D","E","N","P","A","I","L","F","H","T","R","X","S","G","V","Z"};
    String resulttypedesc[]={"&nbsp;------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -------&nbsp;","Check Box",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DecimalNumeric.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmbeddedComponent.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Formula.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IntegerNumeric.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.List.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LongText.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ShortText.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GridComponent.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MatrixComponent.label","common_labels"),(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Summary.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Component.label","common_labels")),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ChartSection.label","am_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VitalSignsBattery.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.PatientCarePanel.label","am_labels")};

	String from = request.getParameter( "from" );
	String to = request.getParameter( "to" ) ;
	String comp_id ="";
	String short_desc ="";
	String comp_type="";
	String enabled ="";

	if ( (whereClause == null || whereClause.equals("")) )
	{
	 sql.append(" ");
	 comp_id    = request.getParameter("comp_id")==null ?"":request.getParameter("comp_id");
	 short_desc = request.getParameter("short_desc")==null ?"":request.getParameter("short_desc");
	 comp_type  = request.getParameter("comp_type")==null ?"":request.getParameter("comp_type");
	 enabled    = request.getParameter("nature")==null ?"":request.getParameter("nature");

	short_desc = short_desc.toUpperCase();
	int andCheck = 0;

	if ( !(comp_id == null || comp_id.equals("")) )
			{
				comp_id=comp_id.trim().toUpperCase();
				sql.append("where upper(discr_msr_id) like upper('"+comp_id+"%')");
				andCheck = 1;
			}
	
		if ( !(short_desc == null || short_desc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append(" and ");
					sql.append("upper(short_desc) like upper('"+short_desc+"%')" );
				}
				else
				{
					sql.append("where upper(short_desc) like upper('"+short_desc+"%')" );
					andCheck = 1;
				}
			}

		if ( !(comp_type == null || comp_type.equals("Q")) )
			{
				if ( andCheck == 1 )
				{	sql.append(" and ");
					sql.append("result_type =  '"+comp_type+"'" );
				}
				else
				{
					sql.append("where result_type = '"+comp_type+"'");
					andCheck = 1;
				}
			}
		else
		{
			if ( andCheck == 1 )
				{	sql.append(" and ");
					sql.append("result_type not in('Z','V','G')");
				}
				else
				{
					sql.append("where result_type not in('Z','V','G')");
					andCheck = 1;
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
	}

	sql.append(" and modifiable_yn ='Y' ");
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
	else {
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
Connection conn = ConnectionManager.getConnection(request);
PreparedStatement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try{

StringBuffer strsql1 = new StringBuffer();
strsql1.append("select count(*) as total from AM_DISCR_MSR");
strsql1.append(sql.toString());
stmt = conn.prepareStatement(strsql1.toString());
rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");
if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}

if(rs!=null) rs.close();
if(stmt!=null) stmt.close();
StringBuffer strsql2=new StringBuffer();
strsql2.append("SELECT DISCR_MSR_ID,SHORT_DESC,LONG_DESC,RESULT_TYPE,EFF_STATUS FROM AM_DISCR_MSR");
strsql2.append(sql.toString());
stmt = conn.prepareStatement(strsql2.toString());
rs = stmt.executeQuery();
%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/DiscrMsrCompQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/DiscrMsrCompQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
	<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th width="10%"><fmt:message key="eAM.DiscreteID.label" bundle="${am_labels}"/></th>
<!-- <th width="15%">Prompt</th> -->
<th width="22%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th width="37%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th width="10%"><fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/></th>
<th width="5%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
String classValue = "" ;
while ( rs.next() && i<=end )
{
       comp_id = rs.getString("DISCR_MSR_ID");

	   if ( i % 2 == 0 )
       		classValue = "QRYEVEN" ;
       	else
		classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	out.println("<a href='../../eAM/jsp/DiscrMsrCompAddModify.jsp?mode=update&comp_id="+ comp_id + "' target='f_query_add_mod' >");
	out.println(comp_id+"</a></td>");//<td class='" + classValue + "'>");
	//out.println(rs.getString("COMP_PROMPT"));
	out.println("<td class='" + classValue + "'>");
	out.println(rs.getString("SHORT_DESC"));
	out.println("</td><td class='" + classValue + "'>");
	out.println( rs.getString("LONG_DESC") );
	out.println("</td><td align='left' class='" + classValue + "'>");
	for(int k=0;k<resulttypecode.length;k++)
		if(resulttypecode[k].trim().equalsIgnoreCase(rs.getString("RESULT_TYPE")))
			out.println(resulttypedesc[k]);
	out.println("</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("eff_status").equals("E") )
		out.print("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;

  }//endwhile
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
}catch(Exception e){
		e.toString();
}
finally 
{
	if(conn!=null)ConnectionManager.returnConnection(conn,request);
}
%>

</td></tr>
</table>
</BODY>
</HTML>

