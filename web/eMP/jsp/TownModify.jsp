<!DOCTYPE html>
<%--
/**
  *
  * @filename TownModify.jsp
  * @version 3.0 updated on 2/19/2005
  */
--%>

<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.sql.Statement,java.sql.PreparedStatement, java.sql.ResultSet,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String restowncode="";
	String longdesc="";
	String shortdesc="";
	String effdatefrom="";
	String effdateto="";
	String effstatus="";
	String resareacodecompare=""; 
   String postal_code_link_yn="";
%>
<%		
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>
<% 
restowncode = request.getParameter("res_town_code");
Connection conn = null;
Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;
//String effdatefrom="",effdateto="";

/*Below Line Added for this CRF [Bru-HIMS-CRF-256]*/
	PreparedStatement prestmt=null;
	int count_lang=0;
	String shortmaxlength="15";
	String longmaxlength="30";
	String shortsize="20";
	String longsize="35";
/*Above Line Added for this CRF [Bru-HIMS-CRF-256]*/

try{

//Connection conn = (Connection) session.getValue( "connection" );
//conn = ConnectionManager.getConnection(request);
/*Below Line Added for this CRF [Bru-HIMS-CRF-256]*/
         conn = ConnectionManager.getConnection(request);
		 prestmt = conn.prepareStatement("SELECT COUNT (*) dflt_lang_appl_cnt FROM sm_site_param a, sm_function_control b WHERE a.customer_id = b.site_id AND module_id = 'MP' AND functionality_id = 'MP_TOWN_MAST'");
	     rs = prestmt.executeQuery();
         if( rs.next() )
	      {
		  count_lang=rs.getInt("dflt_lang_appl_cnt");		  
		  }	
		if ( rs != null ) rs.close() ;
		if ( prestmt != null ) prestmt.close() ;		
	if(count_lang>0){
	shortmaxlength="30";
	longmaxlength="60";
	shortsize="35";
    longsize="70";
	}	
/*Above Line Added for this CRF [Bru-HIMS-CRF-256]*/

stmt = conn.createStatement();
StringBuffer sql = new StringBuffer("select res_town_code,res_area_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from mp_res_town where res_town_code='");
StringBuffer sql1 = new StringBuffer("SELECT POSTAL_CODE_LINK_YN from  SM_SITE_PARAM");
sql.append(restowncode);
sql.append("'");
rset = stmt.executeQuery(sql.toString());
	if(rset != null) {
		rset.next();
		restowncode = rset.getString("res_town_code");
		longdesc = rset.getString("long_desc");
		shortdesc = rset.getString("short_desc");
		
		if(rset.getString("eff_date_from")==null) {
			effdatefrom = "" ;
		}
		else {
			String temp = rset.getString("eff_date_from");
			effdatefrom = temp.substring(8,10)+ "/" + temp.substring(5,7) + "/" + temp.substring(0,4);
		}
		if(rset.getString("eff_date_to")==null) {
			effdateto = "";
		}
		else {
			String temp1 = rset.getString("eff_date_to");
			effdateto = temp1.substring(8,10)+ "/" + temp1.substring(5,7) + "/" + temp1.substring(0,4);
		}
		effstatus = rset.getString("eff_status");
		resareacodecompare = rset.getString("res_area_code")==null?"":rset.getString("res_area_code");
	}
  if ( rset != null ) rset.close() ;
		if ( stmt != null ) stmt.close() ;
	stmt = conn.createStatement();
	rset= stmt.executeQuery(sql1.toString());
      if( rset != null )
	      {
	          while( rset.next() )
	          {
			postal_code_link_yn =rset.getString( "POSTAL_CODE_LINK_YN" ) ;
		        }
	      }
  // 	if ( rset != null ) rset.close() ;
	//if ( stmt != null ) stmt.close() ;


	
	

%>
<form name='res_town_form' id='res_town_form' action='../../servlet/eMP.ResidenceTownServlet' method='post' target='messageFrame'> 
	<BR><BR><BR><BR><BR><BR><BR><BR>
	<div align='left'>
	<table  cellpadding='3' cellspacing='0' width='75%'align='center'>
	<tr><td width='40%'></td><td width='60%' colspan='2'>&nbsp;</td></tr>
	<td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td><td width='60%' class='fields' colspan='2'><input type='text' name='res_town_code' id='res_town_code' value="<%=restowncode%>" size='6' readonly ><img src='../images/mandatory.gif'></img>
<%

if ( effstatus.equals("E") )
{%>   <!-- long and short description changed the maxlength for this [Bru-HIMS-CRF-256]-->
	</td></tr><tr><td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td><td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='<%=longsize%>' maxlength='<%=longmaxlength%>' onBlur='makeValidString(this)' value="<%=longdesc%>">
	<img src='../images/mandatory.gif'></img>

	</td></tr><tr><td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td><td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='<%=shortsize%>' maxlength='<%=shortmaxlength%>' onBlur='makeValidString(this)' value="<%=shortdesc%>"><img src='../images/mandatory.gif'></img></td></tr>
<%
	//sql="Select Res_Area_Code,Short_Desc from Mp_Res_Area where eff_status='E' and ( (eff_date_from <= sysdate and eff_date_to >= sysdate ) or (eff_date_from <= sysdate and eff_date_to is null ) or (eff_date_to >= sysdate and eff_date_from is null) or (eff_date_from is null and eff_date_to is null ) ) order by Short_Desc";
	sql.setLength(0);
	sql.append(	"Select Res_Area_Code,long_desc Short_Desc from Mp_Res_Area  where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_desc ");

	
	rs = stmt.executeQuery(sql.toString());
	
//	out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.area.label","common_labels")+"</td><td width='60%'class='fields' colspan='2'><select name='res_area_code' id='res_area_code'><option value=''>--------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option>");
  %>
	 <td width="40%" class="label"><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
					<td width="60%" colspan="2" class='fields'><select name="res_area_code" id="res_area_code">
					<option value='' >-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option> 
<%	  
	  if( rs != null )
      {
		 
		  String classcode = "";
		  String classname = "";
		while(rs.next()) {
			
			classcode = rs.getString( "res_area_code" ) ;
			classname = rs.getString( "short_desc" ) ;
			
			
			if(resareacodecompare.equals(classcode))
			{
			  
			
		 	%>	<OPTION VALUE='<%=classcode%>' selected> <%=classname%> 
				<%	}
				else
			{
					
			%>
				<OPTION VALUE='<%=classcode%>'><%=classname%>
				<%
					 
				
			  
			}
		}
	}
%>
	</select><%if(postal_code_link_yn.equals("Y")) {%> <img src='../images/mandatory.gif'></img><%}%> </td></tr>
	
<%/*out.println("<tr><td width='40%' class='label'>Effective From</td><td width='13%' >&nbsp;&nbsp;&nbsp;*/%>
	
    <input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value="<%=effdatefrom%>" >
	<input type='hidden' name='postal_code_link_yn' id='postal_code_link_yn'  value="<%=postal_code_link_yn%>" >

<%/*out.println("</td><td width='47%' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp;&nbsp;*/ %>
	
	<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'   value="<%=effdateto%>">
<%	/*out.println("</td></tr><tr><td width='40%'></td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/%>

<tr><td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><td class='fields' width='60%' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
<%
	if  ( effstatus.equals("E") )
		out.println("checked >");
	else
		out.println(">");
%>	
	</td></tr><tr><td width='40%'></td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>
<%
}
if ( effstatus.equals("D") )
{
	sql.setLength(0);
	sql.append("Select res_area_code,long_desc Short_Desc from Mp_Res_Area where Res_Area_Code ='");
	sql.append(resareacodecompare);
	sql.append("' and eff_status='E' and ( (eff_date_from <= sysdate and eff_date_to >= sysdate ) or (eff_date_from <= sysdate and eff_date_to is null ) or (eff_date_to >= sysdate and eff_date_from is null) or (eff_date_from is null and eff_date_to is null ) ) order by Short_Desc");
	if(rset!=null) rset.close();
	rset = stmt.executeQuery(sql.toString());
	String rgncode="";
	if (rset != null) {
		if(rset.next())
		{
		rgncode=rset.getString("res_area_code");
		resareacodecompare = rset.getString("Short_Desc");
		}
		else
			resareacodecompare = "";
	}
%>
	</td></tr><tr><td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td><td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" readonly><img src='../images/mandatory.gif'></img>
	</td></tr><tr><td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td><td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%= shortdesc%>" readonly ><img src='../images/mandatory.gif'></img></td></tr>
	<tr><td width='40%' class='label'><fmt:message key="Common.area.label" bundle="${common_labels}"/></td><td width='60%' class='fields' colspan='2'><input type='text' size='15' name='res_area_desc' id='res_area_desc' value="<%=resareacodecompare%>" readonly><img src='../images/mandatory.gif'></img></td></tr>
	
<%	/*out.println("<tr><td  width='40%' class='label'>Effective From</td><td width='13%' >&nbsp;&nbsp;&nbsp;*/ %>
	
	<input type='hidden'  name='res_area_code' id='res_area_code' value="<%=rgncode%>" readonly><input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value="<%=effdatefrom%>" readonly>
	
<%	/*out.println("</td><td width='47%' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp;&nbsp;*/%>
	
	<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'   value="<%= effdateto%>" readonly>
<%	/*out.println("</td></tr><tr><td width='40%'></td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/%>

	<tr><td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
<%	
	if  ( effstatus.equals("E") )
		out.println("checked >");
	else
		out.println(">");
%>
	</td></tr><tr><td width='40%'></td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>
<%}
	if ( rset != null ) rset.close() ;
  	if ( rs != null ) rs.close() ;
	if ( stmt != null ) stmt.close() ;
}catch ( Exception e ){ 
	// out.println(e.toString());
	e.printStackTrace();
}finally{ 
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

