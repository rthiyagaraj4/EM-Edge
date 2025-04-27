<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<%!
	String resareacode;String longdesc;String shortdesc;String effdatefrom;String effdateto;String effstatus;String regioncodecompare; %>
 
<% resareacode = request.getParameter("res_area_code");

Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
ResultSet rs=null;
StringBuffer sbQuery = new StringBuffer();
	String postal_code_link_yn="";
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>");
try{
	conn = ConnectionManager.getConnection(request);
	sbQuery.append("select res_area_code,region_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from mp_res_area where res_area_code='");
	sbQuery.append(resareacode);
	sbQuery.append("'");
//	pstmt = conn.prepareStatement("select res_area_code,region_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from mp_res_area where res_area_code='"+resareacode+"'");
	pstmt = conn.prepareStatement(sbQuery.toString());
	rset = pstmt.executeQuery();
	if(rset != null) {
		rset.next();
		resareacode = rset.getString("res_area_code");
		longdesc = rset.getString("long_desc");
		shortdesc = rset.getString("short_desc");
		if(rset.getString("eff_date_from")==null) {
			effdatefrom = "" ;
		}else {
			String temp = rset.getString("eff_date_from");
			effdatefrom = temp.substring(8,10)+ "/" + temp.substring(5,7) + "/" + temp.substring(0,4);
		}
		if(rset.getString("eff_date_to")==null) {
			effdateto = "";
		}else {
			String temp1 = rset.getString("eff_date_to");
			effdateto = temp1.substring(8,10)+ "/" + temp1.substring(5,7) + "/" + temp1.substring(0,4);
		}
		effstatus = rset.getString("eff_status");
		regioncodecompare = rset.getString("region_code")==null?"":rset.getString("region_code");
	}

	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close(); 

	pstmt = conn.prepareStatement("SELECT POSTAL_CODE_LINK_YN from  SM_SITE_PARAM"); 
	rset = pstmt.executeQuery();

	if( rset!= null ) {
        while( rset.next() ) {
			postal_code_link_yn =rset.getString( "POSTAL_CODE_LINK_YN" ) ;
        }
    }

	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close(); 

	out.println("<form name='res_area_form' id='res_area_form' action='../../servlet/eMP.ResidenceAreaServlet' method='post' target='messageFrame'><BR><BR><BR><BR><BR><BR><BR><BR><div align='left'><table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'><tr><td width='40%' >&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'>" );
	out.println( "<input type='text' name='res_area_code' id='res_area_code' value='" + resareacode + "' size='6' readonly ><img src='../images/mandatory.gif'></img>");
	if ( effstatus.equals("E") )
	{
		out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value=\"" +longdesc+ "\"><img src='../images/mandatory.gif'></img>");
		out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value=\"" + shortdesc +"\"><img src='../images/mandatory.gif'></img></td></tr>");

		try{

			//out.println("");
			pstmt=conn.prepareStatement("Select Region_Code,Short_Desc from Mp_Region where eff_status='E' and ( (eff_date_from <= sysdate and eff_date_to >= sysdate ) or (eff_date_from <= sysdate and eff_date_to is null ) or (eff_date_to >= sysdate and eff_date_from is null) or (eff_date_from is null and eff_date_to is null ) ) order by Short_Desc");

			rs = pstmt.executeQuery();
		
		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.region.label","mp_labels")+"</td><td width='60%'class='fields' colspan='2'><select name='region_code' id='region_code'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------</option>");
		
		//	out.println("<tr><td width='40%'class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.region.label","mp_labels")+"</td><td width='60%' class='fields' colspan='2'><select name='region_code' id='region_code'><option>--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------</option>");
			if( rs != null )
			{
				String classcode="";
				String classname ="";
				while(rs.next()) 
				{
					classcode = rs.getString( "region_code" ) ;
					classname = rs.getString( "short_desc" ) ;
					if(regioncodecompare.equals(classcode)) 
						out.println("<option value=\"" + classcode + "\" selected>" + classname );
					else 
						out.println("<option value=\"" + classcode + "\">" + classname);
				}
			}
		
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close(); 
			
		} catch(Exception e) { 
			out.println(e.toString());
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close(); 			
		}
	
		if(postal_code_link_yn.equals("Y")) {
			out.println("</select>  <img src='../images/mandatory.gif'></img></td></tr>");
		} else {
			out.println("</select>  </td></tr>");
		}
		/*out.println("<tr><td  width='40%' class='label'>Effective From</td><td width='13%' >&nbsp;&nbsp;&nbsp;*/
	
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' value='" + effdatefrom +"' >");

		out.println("<input type='hidden' name='postal_code_link_yn' id='postal_code_link_yn'   value='"+postal_code_link_yn+"' >");
		
		
		/*out.println("</td><td width='47%' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp;&nbsp;*/
	
		out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='" + effdateto + "'>");
		/*out.println("</td></tr><tr><td width='40%' >&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/

		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'");
		if  ( effstatus.equals("E") )
			out.println("checked >");
		else
			out.println(">");
			out.println("</td></tr> <tr><td width='40%' >&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr></table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>");
	}
	if ( effstatus.equals("D") )
	{
			String rgncode="";
		try{
			pstmt = conn.prepareStatement("Select REGION_CODE,Short_Desc from Mp_Region where Region_Code ='"+ regioncodecompare +"' and eff_status='E' and ( (eff_date_from <= sysdate and eff_date_to >= sysdate ) or (eff_date_from <= sysdate and eff_date_to is null ) or (eff_date_to >= sysdate and eff_date_from is null) or (eff_date_from is null and eff_date_to is null ) ) order by 1");
			rset = pstmt.executeQuery();
			if (rset != null) {
				if(rset.next())
				{
					rgncode=rset.getString("region_code");
					regioncodecompare = rset.getString("Short_Desc");
				}
			else
				regioncodecompare = "";
			}
		}catch(Exception e) { 
			out.println("then here"+e.toString());
			e.printStackTrace();
		}finally{
			if (rset != null) rset.close();
			if (pstmt != null) pstmt.close();			
		}

		out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value=\"" + longdesc + "\" readonly><img src='../images/mandatory.gif'></img>");
		out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15'  maxlength='15' value=\"" + shortdesc +"\" readonly ><img src='../images/mandatory.gif'></img></td></tr>");
		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.region.label","mp_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='text' size='15' name='region_code1' id='region_code1' value=\"" + regioncodecompare + "\" readonly>");
		
		if(postal_code_link_yn.equals("Y")) {
			out.println("<img src='../images/mandatory.gif'></img></td></tr>");
		} else {
			out.println("</td></tr>");
		}
		
		out.println("<input type='hidden' name='postal_code_link_yn' id='postal_code_link_yn'   value='"+postal_code_link_yn+"' >");

		out.println("<input type='hidden' name='region_code' id='region_code' value='"+rgncode+"'>"); 		
	
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' value='" + effdatefrom + "' readonly>");	
		
		out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='" + effdateto + "' readonly>"); 	

		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'");
		if (effstatus.equals("E") )
			out.println("checked >");
		else
			out.println(">");
		out.println("</td></tr><tr><td width='40%' >&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>");

	}

}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();
}
finally{
	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close();
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

