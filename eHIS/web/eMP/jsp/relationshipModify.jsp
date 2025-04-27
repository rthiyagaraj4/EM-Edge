<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>
<% 

String relationship_code = request.getParameter("relationship_code");
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
String eff_date_from="",eff_date_to="";

try{
conn = ConnectionManager.getConnection(request);

String status = "" ;

StringBuffer sql = new StringBuffer("select relationship_code,long_desc,short_desc,sex_ind,relationship_level,eff_date_from,eff_date_to,eff_status from mp_relationship where relationship_code='");
sql.append(relationship_code);
sql.append("'");
pstmt = conn.prepareStatement(sql.toString());
rset = pstmt.executeQuery();

if ( rset != null ) {
	rset.next();
	status = rset.getString( "eff_status" ) ;
}
%>
<form name='relationship_form' id='relationship_form' action='../../servlet/eMP.RelationshipServlet' method='post' target='messageFrame'> <BR><BR><BR><BR><BR><BR><BR><BR><BR>
<div align='left'>
<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
	<tr>
		<td width='40%'>&nbsp;</td>
		<td width='60%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
		<td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td width='60%' class='fields' colspan='2'><input type='text'size='4' maxlength='4' name='relationship_code' id='relationship_code' readonly value='<%= rset.getString("relationship_code")%>'><img src='../images/mandatory.gif'></img>
		</td>
	</tr>
	<tr>
			<td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='60%' class='fields' colspan='2'>
<%if ( status.equals( "E" ) )
	out.println( "<input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value=\"" + rset.getString( "long_desc" ) + "\">" );
else
	out.println( "<input type='text' name='long_desc' id='long_desc' size='30' readonly value=\"" + rset.getString( "long_desc" ) + "\">" );
%>
	<img src='../images/mandatory.gif'></img>
	</td>
	</tr>

<tr>
	<td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td width='60%' class='fields' colspan='2'> 
<%
if ( status.equals( "E" ) )
	out.println( "<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value=\"" + rset.getString( "short_desc" ) + "\">" );
else
	out.println( "<input type='text' name='short_desc' id='short_desc' size='15' readonly value=\""  + rset.getString( "short_desc" ) + "\">" );
%>
	<img src='../images/mandatory.gif'></img>
	</td>
</tr>
<!--modified on 30/01/2008 Gender Modification-->
	<tr>
		<td width='40%' class='label'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td width='60%' class='fields' colspan='2'><select name='sex_ind' id='sex_ind' disabled>
<%    
if(rset.getString("sex_ind")== null)
{
	out.println("<option value="+"''"+">"+"---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---"+"</option>");
	out.println( "<OPTION VALUE="+"M"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
	out.println( "<OPTION VALUE="+"F"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
	out.println( "<OPTION VALUE="+"U"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</Option>");
	
}	
else
	if (rset.getString("sex_ind").equals("M"))
    {
       out.println( "<OPTION VALUE="+"M"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
       out.println( "<OPTION VALUE="+"F"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
       out.println( "<OPTION VALUE="+"U"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</Option>");
	   
	}
	else if (rset.getString("sex_ind").equals("F"))
    {
      out.println( "<OPTION VALUE="+"F"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
      out.println( "<OPTION VALUE="+"M"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
      out.println( "<OPTION VALUE="+"U"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</Option>");
	 
	}
	else if (rset.getString("sex_ind").equals("U"))
    {
      out.println( "<OPTION VALUE="+"U"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+"</Option>");
      out.println( "<OPTION VALUE="+"M"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
      out.println( "<OPTION VALUE="+"F"+">" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
	 
	}	
	
%>
		</select>
		</td>
	</tr>
<!--relationship modification-->	
	<tr>
		<td width='40%' class='label'><fmt:message key="eMP.RelationshipLevel.label" bundle="${mp_labels}"/></td>
		<td width='60%' class='fields' colspan='2'><select name='relationship_level' id='relationship_level' disabled>
<%    
	if(rset.getString("relationship_level")== null)
	{
		/*out.println("<option value="+"''"+">"+"---&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"&nbsp;---"+"</option>");*/
		out.println( "<OPTION VALUE="+"0"+">"+0+"</Option>");
        out.println( "<OPTION VALUE="+"1"+">"+1+"</Option>");
        out.println( "<OPTION VALUE="+"2"+">"+2+"</Option>");
	}
	else
	if (rset.getString("relationship_level").equals("0"))
    {
        out.println( "<OPTION VALUE="+"0"+">"+0+"</Option>");
        out.println( "<OPTION VALUE="+"1"+">"+1+"</Option>");
        out.println( "<OPTION VALUE="+"2"+">"+2+"</Option>");
	}
    else if (rset.getString("relationship_level").equals("1"))
    {
        out.println( "<OPTION VALUE="+"1"+">"+1+"</Option>");
        out.println( "<OPTION VALUE="+"0"+">"+2+"</Option>");
        out.println( "<OPTION VALUE="+"2"+">"+0+"</Option>");
	}
    else if (rset.getString("relationship_level").equals("2"))
    {
       out.println( "<OPTION VALUE="+"2"+">"+2+"</Option>");
       out.println( "<OPTION VALUE="+"0"+">"+0+"</Option>");
       out.println( "<OPTION VALUE="+"1"+">"+1+"</Option>");
	}
%>
			</select>
		<img src='../images/mandatory.gif'></img></td>
	</tr>
<!--modified on 30/01/2008 -->
<%
if ( rset.getDate("eff_date_from") != null )
{
 java.util.Date date = rset.getDate("eff_date_from");
 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
 eff_date_from= formatter.format(date);
 date = null;
 formatter = null;
 }
 

if ( rset.getDate("eff_date_to") != null)
{
 java.util.Date date1 = rset.getDate("eff_date_to");
 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
 eff_date_to = formatter.format(date1);
 date1 = null;
 formatter = null;
}


if ( status.equals( "E" ) )
	out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' value='"+eff_date_from+"'>");
else
	out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' readonly value='"+eff_date_to+"'>");


/*out.println("' onblur='checkdate(this)'></td><td width='47%' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp;" ) ;*/

if ( status.equals( "E" ) )
	out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"'>");
else
	out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  readonly value='"+eff_date_to+"'>");


/*out.println("' onblur='checkdate(this)'></td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/
%>
<tr>
	<td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
<%
String eff_status = rset.getString("eff_status");

if  ( eff_status.equals("E") )
	out.println("checked >");
else
	out.println(">");
%>
	</td>
</tr>
<tr>
	<td width='40%'>&nbsp;</td>
	<td width='60%' colspan='2'>&nbsp;</td>
</tr>
</table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>
<%
	} catch ( Exception e ){
 out.println(e.toString());
 e.printStackTrace();
}

finally{
  	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
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

