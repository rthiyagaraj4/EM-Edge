<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%! String ocpncode;String longdesc;String shortdesc;String effdatefrom;String effdateto;String effstatus;String ocpnclasscode;String ocpn_class_desc;%>
<% ocpncode = request.getParameter("occupation_code");
//Connection conn = (Connection) session.getValue( "connection" );
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
ResultSet rs=null;
try{ 
	conn = ConnectionManager.getConnection(request);
	StringBuffer sbQuery = new StringBuffer();
//	String sql ;									// will be deleted once code walkthrough is done
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>");
	sbQuery.append("select ocpn_code,a.ocpn_class_code ocpn_class_code,a.long_desc long_desc,a.short_desc occupation_desc,a.eff_date_from,a.eff_date_to,a.eff_status eff_status, b.long_desc ocpn_class_desc from mp_occupation a, mp_occupation_class b where a.ocpn_class_code = b.ocpn_class_code and a.ocpn_code='");
	sbQuery.append(ocpncode);
	sbQuery.append("'");
//String sql = "select ocpn_code,a.ocpn_class_code ocpn_class_code,a.long_desc long_desc,a.short_desc occupation_desc,a.eff_date_from,a.eff_date_to,a.eff_status eff_status, b.short_desc ocpn_class_desc from mp_occupation a, mp_occupation_class b where a.ocpn_class_code = b.ocpn_class_code and a.ocpn_code='"+ocpncode+"'"; 
pstmt = conn.prepareStatement(sbQuery.toString());
rset = pstmt.executeQuery();
if (rset.next())
{
	ocpncode = rset.getString("ocpn_code");
	longdesc = rset.getString("long_desc");
	shortdesc = rset.getString("occupation_desc");
	ocpn_class_desc = rset.getString("ocpn_class_desc");
	ocpnclasscode = rset.getString("ocpn_class_code");
	effstatus = rset.getString("eff_status");
}
	out.println("<form name='occupation_form' id='occupation_form' action='../../servlet/eMP.OccupationServlet' method='post' target='messageFrame'><div align='left'><BR><BR><BR><BR><BR><BR><BR><BR><table border='0' cellpadding='3' cellspacing='0' width='75%'align='center'><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'>" ); out.println( "<input type='text' name='occupation_code' id='occupation_code' value='" + ocpncode + "' size='6' readonly ><img src='../images/mandatory.gif'></img>" ) ; 

	if ( effstatus.equals("E") )
	{
		out.println("</td></tr><!--tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr--><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value=\"" +longdesc+ "\">");
		out.println("<img src='../images/mandatory.gif'></img></td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value=\"" + shortdesc +"\">");
		out.println("<img src='../images/mandatory.gif'></img></td></tr>");
		try
		{
			sbQuery.setLength(0);
			sbQuery.append("Select ocpn_class_code,long_desc short_desc  from mp_occupation_class where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_desc ");

//			sql="Select ocpn_class_code,short_Desc  from mp_occupation_class where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_desc ";

			pstmt = conn.prepareStatement(sbQuery.toString());
			rs = pstmt.executeQuery();
			out.println("<tr><td width='40%'  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OccupationClass.label","mp_labels")+"</td><td width='60%' class='fields' colspan='2'><select name='occupation_class' id='occupation_class'><option value=''>-------------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------</option>");
			if( rs != null )
			{
				while(rs.next()) 
				{
					String classcode = rs.getString( "ocpn_class_code" ) ;
					String classname = rs.getString( "short_desc" ) ;
					
					if(ocpnclasscode.equals(classcode))
					{
						out.println("<option value=\"" + classcode + "\" selected>" + classname );
					}
					else out.println("<option value=\"" + classcode + "\">" + classname );
				}
			}		
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();			
		}
		catch(Exception e) { 
			// out.println(e.toString());
			e.printStackTrace();
		}
		out.println("</select><img src='../images/mandatory.gif'></img></td></tr>");
		
	//	out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");
		
		
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='" + effdatefrom +"' >");
		
		
		out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='" + effdateto + "'>");
		
		
		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'");
		if  ( effstatus.equals("E") )
			out.println("checked >&nbsp;");
		else
			out.println(">&nbsp;");
		out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>");
	}
	if ( effstatus.equals("D") )
	{
		out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value=\"" + longdesc + "\" readonly>");
		out.println("<img src='../images/mandatory.gif'></img></td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15'  maxlength='15' value=\"" + shortdesc +"\" readonly >");
		out.println("<img src='../images/mandatory.gif'></img></td></tr>");
		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OccupationClass.label","mp_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='hidden' name='occupation_class' id='occupation_class' value=\""+ocpnclasscode+"\"><input type='text' size='30' name='occupation_class_desc' id='occupation_class_desc' value=\"" + ocpn_class_desc + "\"");
		out.println(" readonly>&nbsp;<img src='../images/mandatory.gif'></img></td></tr>");
		//out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");
		
		
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='" + effdatefrom + "' readonly>");

			
		out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='" + effdateto + "' readonly>");
		
		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'");
		if  ( effstatus.equals("E") )
			out.println("checked >&nbsp;");
		else
			out.println(">&nbsp;");
		out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>");
	}
 	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
}catch ( Exception e ){ 
	// out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174210364 on 12-09-2023
	}
finally{
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

