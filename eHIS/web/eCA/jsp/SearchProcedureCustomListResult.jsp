<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../js/rowcolor.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function closew(Diagcode)
  {
	window.parent.parent.returnValue=Diagcode;
	window.parent.parent.close();
  }
</script>

</head>

<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
 Connection conn=null;
 PreparedStatement stmt=null;
 ResultSet rset=null;
 String diagcode=request.getParameter("p_diag_code");
 String diagdesc=request.getParameter("p_diag_scheme_desc");
 String Diag_Code=request.getParameter("Diag_code");
 //String Diag_Desc=request.getParameter("Diag_desc");
 String Diag_code="";
 String Diag_desc="";
 String cause_indicator=request.getParameter("cause_indicator");
if(cause_indicator==null)
	cause_indicator="";
 String from = request.getParameter( "from" ) ;
 String to = request.getParameter( "to" ) ;


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
 try
 {
	 conn = ConnectionManager.getConnection(request);
	 
	String sql1 = "select count(*) from mr_diag_group_dtl_vw where diag_group_code=? AND NVL(CAUSE_INDICATOR, '|') =NVL(?, NVL(CAUSE_INDICATOR,'|')) ";
	
	StringBuffer sql=new StringBuffer();
	sql.append("select diag_code || nvl2(cause_indicator,'/' || cause_indicator,null) diag_code , diag_desc from mr_diag_group_dtl_vw  where diag_group_code=? AND NVL(CAUSE_INDICATOR, '|') =NVL(?, NVL(CAUSE_INDICATOR,'|')) ");
   
	if(diagcode.equals("2"))
		sql.append(" AND RECORD_TYPE='O' ");
 
 	sql.append("order by diag_code");
	stmt=conn.prepareStatement(sql1);
	stmt.setString(1,Diag_Code);
	stmt.setString(2,cause_indicator);
	rset=stmt.executeQuery();
	rset.next();
	int maxRecord = rset.getInt(1);

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
 
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
 //if(rset!=null) rset=null;
	stmt=conn.prepareStatement(sql.toString());
	stmt.setString(1,Diag_Code);
	stmt.setString(2,cause_indicator);	
	rset=stmt.executeQuery();
%>
<P>
<table align='center' cellpadding='3' width='100%'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eCA/jsp/SearchProcedureCustomListResult.jsp?from="+(start-14)+"&to="+(end-14)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&Diag_code="+Diag_Code+"&cause_indicator="+cause_indicator+"' text-decoration='none'>Prev</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eCA/jsp/SearchProcedureCustomListResult.jsp?from="+(start+14)+"&to="+(end+14)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&Diag_code="+Diag_Code+"&cause_indicator=	"+cause_indicator+"'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table width='100%' border='1' cellspacing='0' cellpadding='3' id='tb1'>
<td class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String rowclass="";

	while (rset.next()&& i<=end )
	{
		if (i%2==0)
			 rowclass="QRYEVEN";
		else
			 rowclass="QRYODD";

		Diag_code=rset.getString("diag_code");
		Diag_desc=rset.getString("diag_desc");
		out.println("<tr style='background-color:;' ><td  class='"+rowclass+"'>");
		  out.println("<a   href=javascript:closew('"+Diag_code+"')>");
		  out.println(Diag_code+"</a></td><td  class='"+rowclass+"'>");
		  out.println(Diag_desc+"</td></tr>");
		i++;
	}
 
	if (rset!=null) rset.close();
	if (stmt!=null) stmt.close();
   }//try
catch  (Exception e)
{
  //out.println("Exception="+e.toString()); //COMMON-ICN-0181
  e.printStackTrace();//COMMON-ICN-0181
} 
finally
{
	if(conn!=null)ConnectionManager.returnConnection(conn,request);
 }
 %>

</table>
</body>
</html>

