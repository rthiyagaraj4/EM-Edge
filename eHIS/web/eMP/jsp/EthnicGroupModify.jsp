<!DOCTYPE html>

<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% String RACE_CODE = request.getParameter("RACE_CODE");
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
String eff_date_from="",eff_date_to="";

try{

out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></script></head><body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>");

//conn = (Connection) session.getValue( "connection" );
conn = ConnectionManager.getConnection(request);



String status = "" ;

String sql = "select RACE_CODE,LONG_DESC,SHORT_DESC,eff_date_from,eff_date_to,EFF_STATUS from MP_RACE where RACE_CODE=? ";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, RACE_CODE); // Added by lakshmanan for security issue ID 174167469 on 05-09-2023
rset = pstmt.executeQuery();

if ( rset != null ) {
    rset.next();
    status = rset.getString( "EFF_STATUS" ) ;
}

out.println(" <form name='ETHNIC_GROUP_FORM' id='ETHNIC_GROUP_FORM' action='../../servlet/eMP.EthnicGroupServlet' method='post' target='messageFrame'> <div align='left'><BR><BR><BR><BR><BR><BR><BR><BR><BR><table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'>" );
out.println( "<input type='text' size='10' maxlength='10' name='ETHNIC_GROUP_CODE' id='ETHNIC_GROUP_CODE' readonly value=" + rset.getString("RACE_CODE") + ">" ) ;
out.println("<img src='../images/mandatory.gif'></img>");

out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'>" ) ;

if ( status.equals( "E" ) )
	out.println( "<input type='text' name='LONG_DESC' id='LONG_DESC' size='30' maxlength='30' onBlur='makeValidString(this)' value=\"" + rset.getString( "LONG_DESC" ) + "\">" );
else
	out.println( "<input type='text' name='LONG_DESC' id='LONG_DESC' size='30' readonly value=\"" + rset.getString( "LONG_DESC" ) + "\">" );
out.println("<img src='../images/mandatory.gif'></img></td></tr>" ) ;

out.println( "<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'>" ) ;

if ( status.equals( "E" ) )
	out.println( "<input type='text' name='SHORT_DESC' id='SHORT_DESC' size='15' maxlength='15' onBlur='makeValidString(this)' value=\"" + rset.getString( "SHORT_DESC" ) + "\">" );
else
	out.println( "<input type='text' name='SHORT_DESC' id='SHORT_DESC' size='15' readonly value=\""  + rset.getString( "SHORT_DESC" ) + "\">" );
out.println("<img src='../images/mandatory.gif'></img></td></tr>" ) ;

/*out.println( "<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");

out.println("<tr><td align='right' width='40%' class='label'>Effective From</td><td width='13%' align='left'>&nbsp;&nbsp;" ) ;*/

if ( status.equals( "E" ) )
	out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' value='"+eff_date_from+"'>");
else
	out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' readonly value='"+eff_date_from+"'>");

if ( rset.getDate("eff_date_from") != null )
{
 java.util.Date date = rset.getDate("eff_date_from");
 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
 eff_date_from = formatter.format(date);
 date = null;
 formatter = null;
 }

/*out.println("' onblur='checkdate(this)'></td><td width='47%' align='left' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp; " ) ;*/

if ( status.equals( "E" ) )
	out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"'>");
else
	out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  readonly value='"+eff_date_to+"'>");

if ( rset.getDate("eff_date_to") != null)
{
 java.util.Date date1 = rset.getDate("eff_date_to");
 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
 eff_date_to = formatter.format(date1);
 date1 = null;
 formatter = null;
}


/*out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/

out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='checkbox' name='EFF_STATUS' id='EFF_STATUS' value='E'");

String eff_status = rset.getString("EFF_STATUS");

if  ( eff_status.equals("E") )
	out.println("checked >");
else
	out.println(">");

out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr></table></div><input type='hidden' name='mode' id='mode' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>");

}catch ( Exception e ){ 
	// out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174112769 on 05-09-2023
	}
finally{
  	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
	ConnectionManager.returnConnection(conn,request);
}

%>
</body>
</html>
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

