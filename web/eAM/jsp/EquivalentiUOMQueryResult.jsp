<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");%>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<BODY  class='CONTENT' onKeyDown = 'lockKey()' onLoad='ClearMsg()'; OnMouseDown='CodeArrest()'>
<%

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection conn = null;
conn = ConnectionManager.getConnection(request);
Statement stmt = null;
ResultSet rs = null;

try{
	


	String whereClause = request.getParameter("whereclause");

//	String sql ;
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	//String sql_bl="";
	//String facilityid=(String)session.getValue("facility_id");
	
	stmt = conn.createStatement();
	String code = request.getParameter("uom");		
	String shortdesc=request.getParameter("uomdesc");
	String equom = request.getParameter("Equom");
	String shortequdesc=request.getParameter("Equomdesc");
		
	if ( (whereClause == null || whereClause.equals("")) )
	{
		//sql="";
		//int andCheck = 0;

		if ( !(code == null || code.equals("")) )
		{
			code= code.toUpperCase();
			sbQuery.append(" and upper(A.UOM_CODE) like upper('"+code+"%')");
			//sql = " and upper(A.UOM_CODE) like upper('"+code+"%')";
		}

		if ( !(shortdesc == null || shortdesc.equals("")) )
	    {
			sbQuery.append(" and ");
			//sql = sql + " and ";
			sbQuery.append(	"upper(B.short_desc) like  upper('"+shortdesc+"%')");
			//sql = sql + "upper(B.short_desc) like  upper('"+shortdesc+"%')" ;
		}

		if ( !(equom == null || equom.equals("")) )
		{
			equom= equom.toUpperCase();
			sbQuery.setLength(0);
			sbQuery.append(	" and upper(A.EQVL_UOM_CODE) like upper('"+equom+"%')");
			//sql = " and upper(A.EQVL_UOM_CODE) like upper('"+equom+"%')";
		}
		if ( !(shortequdesc == null || shortequdesc.equals("")) )
		{
				sbQuery.append(" and ");
			//	sql = sql + " and ";
				sbQuery.append("upper(C.short_desc) like  upper('"+shortequdesc+"%')");
				//sql = sql + "upper(C.short_desc) like  upper('"+shortequdesc+"%')" ;
		}



		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sbQuery.append(" order by ");
		//	sql=sql+" order by ";

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sbQuery.append(ord[i]);
				//sql=sql+ord[i];
			else
					sbQuery.append(ord[i]+",");
				//sql=sql+ord[i]+",";
			}
		}
	} //end of where clause IF
	else
	{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
		//sql = whereClause;
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



int maxRecord = 0;


String strsql2="select A.UOM_CODE, A.EQVL_UOM_CODE, B.SHORT_DESC UOM_DESC, C.SHORT_DESC EQVL_UOM_DESC, EQVL_VALUE from AM_UOM_EQVL A, AM_UOM B, AM_UOM C where A.UOM_CODE = B.UOM_CODE AND A.EQVL_UOM_CODE = C.UOM_CODE "+sbQuery.toString();
rs = stmt.executeQuery(strsql2);

if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	while ( i<=end && rs.next() )
	{
		if(maxRecord==0)
		{
%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A id='prev' HREF='../jsp/EquivalentiUOMQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<A id='next' HREF='../jsp/EquivalentiUOMQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
</p>
<br>
<br>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EquivalentUOM.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EquivalentUOM.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.ConversionFactor.label" bundle="${common_labels}"/></th>


<% }

 
	  String classValue = "" ;

        if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
	else
		  classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	String uom = rs.getString("UOM_CODE");
	out.println("<a href='../jsp/addModifyEquivalentUOM.jsp?EqCode="+ rs.getString("EQVL_UOM_CODE")+"&Code="+ uom + "' target='f_query_add_mod' >");


	out.println(uom+"</a></td><td class='" + classValue + "'>");
	out.println(rs.getString("UOM_DESC") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("EQVL_UOM_CODE") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("EQVL_UOM_DESC") );
	out.println("</td><td align='right' class='" + classValue + "'>");
	out.println(rs.getString("EQVL_VALUE") );
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
%>

</td></tr>
</table>
<%
	
	if(rs != null) rs.close();   
	if(stmt != null) stmt.close();
	rs.close();

}//end of try
catch(Exception e) {
	//out.println("main try"+e);
	e.printStackTrace();
}
finally
{
	 
	ConnectionManager.returnConnection(conn,request);
}
%>
</BODY>
</HTML>

