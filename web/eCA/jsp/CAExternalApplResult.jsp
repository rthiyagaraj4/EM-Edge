<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*,java.net.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML><head><!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>	 -->
<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- <added by Archana  @08-12-2008> -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src="../../eCommon/js/common.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head><BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%

Connection conn  =  ConnectionManager.getConnection(request);
try
{
PreparedStatement stmt = null;
ResultSet rset = null;
String ext_id="";
String ext_name="";
String base_url="";
String eff_status="";
int i=0;
String classValue="";


String strsql1="select EXT_IMAGE_APPL_ID,EXT_IMAGE_APPL_NAME,BASE_URL,EFF_STATUS from CA_EXT_IMAGE_APPL ";
stmt = conn.prepareStatement(strsql1);
rset = stmt.executeQuery();

%>
<br><br><br><br><br><br>
<table border="1" width="85%" class='grid' align='center'>
<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ExternalID.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ExternalName.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.BaseURL.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

<% while ( rset.next()  )
{
   /* if ( i % 2 == 0 )
              classValue = "QRYEVEN" ;
        else
            classValue = "QRYODD" ;
	*/
    classValue = "gridData";

    out.println("<tr><td class='" + classValue + "'>");

    ext_id = rset.getString(1);
    ext_name=rset.getString(2);
    base_url= rset.getString(3);
    
	if(base_url==null)
	{base_url="&nbsp;";}
    eff_status= rset.getString(4);

	out.println("<a class='gridLink' href='../../eCA/jsp/CAExternalApplModify.jsp?appl_id="+ ext_id + "' target='CAEx_Query' >");
     out.println(ext_id+"</a></td><td class='" + classValue + "'>");
    out.println( ext_name );
    out.println("</td><td class='" + classValue + "'>");

    out.println(base_url );
    out.println("</td><td class='" + classValue + "'>");
  
  	if (eff_status.equals("E"))
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td></tr>");
	
	i++;
	
} %>
</td></tr>
</table>

<%
if(rset!=null)	rset.close();
if(stmt!=null)	stmt.close();
}
catch(Exception e)
{
	//out.println("Exception in CAExternalApplResult.jsp " + e.toString());//COMMON-ICN-0181
       e.printStackTrace();//COMMON-ICN-0181
}
finally
{
ConnectionManager.returnConnection(conn,request);
}		

%>
</BODY>
</HTML>

