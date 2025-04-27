<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.ConnectionManager,java.net.URLEncoder"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />


<%
/*String res_town_prompt=request.getParameter("res_town_prompt");
String res_area_prompt=request.getParameter("res_area_prompt");
String region_prompt=request.getParameter("region_prompt");
String postal_code_prompt=request.getParameter("postal_code_prompt");*/

String search_text=request.getParameter("search_text");
String searchcriteria=request.getParameter("search_criteria");
String search_by=request.getParameter("search_by");

if(search_text==null)
search_text="";

//search_text = java.net.URLDecoder.decode(search_text,"UTF-8");

int index= search_text.indexOf("'");
if(index != -1)
{
search_text = search_text.replace("'","''");
}


String fieldname=request.getParameter("fieldname");

String a_area_code="";
String a_area_desc="";
String a_postal_code="";
String a_postal_desc="";
String a_region_code="";
String a_region_desc="";
String a_town_code="";
String a_town_desc="";
String res_area_appl_yn ="";
String res_town_appl_yn ="";
String region_appl_yn ="";
String postal_code_appl_yn ="";
String res_area_prompt ="";
String res_town_prompt ="";
String postal_code_prompt ="";
String region_prompt ="";
String a_country_code="";
String a_country_desc="";
if(fieldname==null)
fieldname="";

%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<Script language='javascript' src='../../eMP/js/AddressLookup.js'></Script>
	</head>
	<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause	= "";
	whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter("from");
	String to			= request.getParameter("to");

	StringBuffer sbQuery = new StringBuffer();

	//if((whereClause == null || whereClause.equals(""))) {		

		if(search_by.equals("T") && !search_text.equals(""))
		{
			 if(fieldname.equals("town_code"))
			 {
				if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
			 }
			 else
			 {
				 if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(d.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(d.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(d.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}

			}
		}
		else if(search_by.equals("P") && !search_text.equals(""))
		{
			if(fieldname.equals("town_code")) {
			if(searchcriteria.equals("S"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(d.short_desc) like '");
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
			else if(searchcriteria.equals("E"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(d.short_desc) like '%");
			sbQuery.append(search_text);
			sbQuery.append("'");
				
			}
			else if(searchcriteria.equals("C"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(d.short_desc) like '%");
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
		 }
		 else
			{
				 if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.short_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.short_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.short_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}

			}
		}
		else if(search_by.equals("A") && !search_text.equals(""))
		{
			if(fieldname.equals("town_code") || fieldname.equals("postal_code")) 
			{
				if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(c.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(c.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(c.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
		   }
		   else if(fieldname.equals("area_code"))
           {
			   if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}

		   }
		}
		else if(search_by.equals("R") && !search_text.equals(""))
		{
			if(fieldname.equals("town_code") || fieldname.equals("postal_code")) 
			{
				if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(b.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(b.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(b.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
		   }
		   else if(fieldname.equals("area_code"))
           {
			   String sql_temp="and Upper(( CASE WHEN a.region_code IS not null THEN (SELECT long_desc FROM mp_region_lang_vw WHERE region_code = a.region_code AND language_id = a.language_id AND EFF_STATUS='E' ) END)) like '";
			   if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(sql_temp);
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(sql_temp +"%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(sql_temp+"%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}

		   }
		   else  if(fieldname.equals("region_code"))
			{
				if(searchcriteria.equals("S"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
				else if(searchcriteria.equals("E"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("'");
					
				}
				else if(searchcriteria.equals("C"))
				{
				search_text = search_text.toUpperCase();
				sbQuery.append(" and upper(a.long_desc) like '%");
				sbQuery.append(search_text);
				sbQuery.append("%'");
				}
		   }
		}
		else if(search_by.equals("C") && !search_text.equals(""))
		{	
		String sql_temp1="and Upper(( CASE WHEN a.country_code IS not null THEN (SELECT long_name FROM mp_country_lang_vw WHERE country_code = a.country_code AND language_id = a.language_id AND EFF_STATUS='E' ) END)) like '";
			if(searchcriteria.equals("S"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(sql_temp1);
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
			else if(searchcriteria.equals("E"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(sql_temp1);
			sbQuery.append("%");
			sbQuery.append(search_text);
			sbQuery.append("'");
				
			}
			else if(searchcriteria.equals("C"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(sql_temp1);
			sbQuery.append("%");
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
			
		}
		else if(search_by.equals("D") && !search_text.equals(""))
		{
			if(searchcriteria.equals("S"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(long_desc) like '");
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
			else if(searchcriteria.equals("E"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(long_desc) like '%");
			sbQuery.append(search_text);
			sbQuery.append("'");
				
			}
			else if(searchcriteria.equals("C"))
			{
			search_text = search_text.toUpperCase();
			sbQuery.append(" and upper(long_desc) like '%");
			sbQuery.append(search_text);
			sbQuery.append("%'");
			}
			
		}


		if(search_by.equals("P"))
		{
			sbQuery.append(" order by postal_desc");
		}
		else if(search_by.equals("D") || search_by.equals("R")) 
		{
			sbQuery.append(" order by region_desc");
		}
		else if(search_by.equals("A")) {
			sbQuery.append(" order by area_desc");
		}
		else if(search_by.equals("T")) {
			sbQuery.append(" order by town_desc");
		}
		else if(search_by.equals("C"))
		{
			//sbQuery.append(" order by region_code");
			sbQuery.append(" order by country_desc");
		}
/*	} 
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
	}
*/

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

	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	PreparedStatement stmt			= null;
	ResultSet rset				= null;

	String sql="SELECT initcap(res_area_prompt) res_area_prompt,initcap(res_town_prompt) res_town_prompt, postal_code_prompt, initcap(region_prompt) region_prompt,res_area_appl_yn,res_town_appl_yn,region_appl_yn,postal_code_appl_yn from sm_site_param_LANG_VW where language_id='"+locale+"'";
	
	try{
		conn = ConnectionManager.getConnection(request);
	//	pstmt = conn.prepareStatement("SELECT a.region_code region_code , mp_get_desc.MP_REGION(a.region_code,'"+locale+"',1) region_desc , b.res_area_code area_code ,  mp_get_desc.MP_RES_AREA( b.res_area_code,'"+locale+"',1) area_desc , c.res_town_code town_code , mp_get_desc.MP_RES_TOWN( c.res_town_code,'"+locale+"',1) town_desc , d.postal_code postal_code , mp_get_desc.MP_POSTAL_CODE( d.postal_code,'"+locale+"',2) postal_desc  FROM mp_region a , mp_res_area b , mp_res_town c , mp_postal_code d  WHERE a.region_code = b.region_code (+)  AND b.res_area_code = c.res_area_code(+)  AND c.res_town_code = d.res_town_code(+) "+sbQuery.toString());


	stmt = conn.prepareStatement(sql.toString());
			rset = stmt.executeQuery();
			if(rset.next())
			{
				//out.println("res_area_prompt:"+rset.getString("res_area_prompt"));
				res_area_prompt=rset.getString("res_area_prompt");
				res_town_prompt=rset.getString("res_town_prompt");
				postal_code_prompt=rset.getString("postal_code_prompt");
				region_prompt=rset.getString("region_prompt");
				res_area_appl_yn=rset.getString("res_area_appl_yn");
				region_appl_yn=rset.getString("region_appl_yn");
				postal_code_appl_yn=rset.getString("postal_code_appl_yn");
				res_town_appl_yn=rset.getString("res_town_appl_yn");
			}
			if(res_area_appl_yn==null)
			res_area_appl_yn="N";

			if(region_appl_yn==null)
			region_appl_yn="N";

			if(postal_code_appl_yn==null)
			postal_code_appl_yn="N";

			if(res_town_appl_yn==null)
			res_town_appl_yn="N";

			if(res_area_prompt==null)
			res_area_prompt="";

			if(res_town_prompt==null)
			res_town_prompt="";

			if(postal_code_prompt==null)
			postal_code_prompt="";

			if(region_prompt==null)
			region_prompt="";

		//pstmt = conn.prepareStatement("SELECT a.region_code region_code , a.long_desc region_desc , b.res_area_code area_code, b.long_desc area_desc , c.res_town_code town_code, c.long_desc town_desc , d.postal_code postal_code, d.short_desc postal_desc FROM mp_region_lang_vw a , mp_res_area_lang_vw b , mp_res_town_lang_vw c , mp_postal_code_lang_vw d WHERE a.region_code = b.region_code (+) and a.language_id = b.language_id (+) AND b.res_area_code = c.res_area_code(+) and b.language_id = c.language_id (+) AND c.res_town_code = d.res_town_code(+) and c.language_id = d.language_id (+) and a.language_id = '"+locale+"'"+sbQuery.toString());
		if(fieldname.equals("postal_code"))
		{
			pstmt = conn.prepareStatement("select a.postal_code postal_code, a.short_desc postal_desc, d.res_town_code town_code, d.long_desc town_desc, d.res_area_code area_code, c.long_desc area_desc, c.region_code region_code, b.long_desc region_desc from mp_postal_code_lang_vw a, (select region_code, long_desc from mp_region_lang_vw where language_id = '"+localeName+"' and EFF_STATUS='E') b, (select res_area_code, long_desc, region_code from mp_res_area_lang_vw where language_id = '"+localeName+"'  and EFF_STATUS='E') c, (select res_town_code, long_desc, res_area_code from mp_res_town_lang_vw where language_id = '"+localeName+"'  and EFF_STATUS='E') d where a.res_town_code = d.res_town_code(+) and d.res_area_code = c.res_area_code(+) and c.region_code = b.region_code(+) and a.language_id(+) = '"+localeName+"'  and a.EFF_STATUS='E' "+sbQuery.toString());
		}
		else if(fieldname.equals("region_code")) 
		{
			//pstmt = conn.prepareStatement("Select region_code,long_Desc region_desc from Mp_region_lang_vw where language_id='"+locale+"' and eff_status='E' "+sbQuery.toString());
			pstmt = conn.prepareStatement("SELECT   a.region_code, a.long_desc region_desc,a.country_code country_code,      (CASE WHEN a.country_code IS NOT NULL THEN (SELECT long_name  FROM mp_country_lang_vw WHERE country_code = a.country_code  AND language_id = a.language_id    AND eff_status = 'E')  END) country_desc  FROM mp_region_lang_vw a  WHERE a.language_id = 'en' AND a.eff_status = 'E' "+sbQuery.toString());
		}
		else if(fieldname.equals("area_code")) {
			pstmt = conn.prepareStatement("SELECT a.res_area_code area_code, a.long_desc area_desc, a.region_code region_code, (case when a.region_code is not null then (select long_desc from mp_region_lang_vw where region_code = a.region_code and language_id = a.language_id and EFF_STATUS='E') end) region_desc FROM mp_res_area_lang_vw a WHERE 	a.language_id = '"+localeName+"'  and a.EFF_STATUS='E' "+sbQuery.toString());
		}
		else if(fieldname.equals("town_code")) {
			pstmt = conn.prepareStatement("select a.res_town_code town_code, a.long_desc town_desc, a.res_area_code area_code, c.long_desc area_desc, c.region_code region_code, b.long_desc region_desc, d.postal_code postal_code, d.short_desc postal_desc from mp_res_town_lang_vw a, (select region_code, long_desc from mp_region_lang_vw where language_id = '"+localeName+"'  and EFF_STATUS='E') b, (select res_area_code, long_desc, region_code from mp_res_area_lang_vw where language_id = '"+localeName+"'  and EFF_STATUS='E') c, (select postal_code, short_desc, res_town_code from mp_postal_code_lang_vw where language_id = '"+localeName+"'  and EFF_STATUS='E') d where a.res_area_code = c.res_area_code(+) and b.region_code(+) = c.region_code and a.res_town_code = d.res_town_code(+) and a.language_id = '"+localeName+"'  and a.EFF_STATUS='E' "+sbQuery.toString());
		}

		
		rs = pstmt.executeQuery();
%>


<%
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		String classValue = "" ;
//		String code="";
		int cnt=0;
		while (i<=end && rs.next()){

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			if(fieldname.equals("postal_code") || fieldname.equals("town_code"))
			{
				a_town_code = rs.getString("town_code");
				a_town_desc = rs.getString("town_desc");
				a_area_code = rs.getString("area_code");
				a_area_desc =  rs.getString("area_desc");
				a_region_code = rs.getString("region_code");
				a_region_desc = rs.getString("region_desc");
				a_postal_code = rs.getString("postal_code");
				a_postal_desc = rs.getString("postal_desc");
			}
			else if(fieldname.equals("region_code")) 
			{
				a_region_code = rs.getString("region_code");
				a_region_desc = rs.getString("region_desc");
				a_country_code = rs.getString("country_code");
				a_country_desc = rs.getString("country_desc");
			}
			else if(fieldname.equals("area_code")) {
				a_area_code = rs.getString("area_code");
				a_area_desc =  rs.getString("area_desc");
				a_region_code = rs.getString("region_code");
				a_region_desc = rs.getString("region_desc");
			}
					
			
			if(a_town_code == null)
				a_town_code="";
			if(a_town_desc == null)
				a_town_desc="";
			if(a_area_code == null)
				a_area_code="";
			if(a_area_desc == null)
				a_area_desc="";
			if(a_region_code == null)
				a_region_code="";
			if(a_region_desc == null)
				a_region_desc="";
			if(a_postal_code == null)
				a_postal_code="";
			if(a_postal_desc == null)
				a_postal_desc="";
			if(a_country_code == null)
				a_country_code="";
			if(a_country_desc == null)
				a_country_desc="";	

			if(cnt==0)
			{%>	
				<P>
				<table align='right'>
				<tr>

				<%
						if ( !(start <= 1) )
							out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/AddressLookupResult.jsp?from="+(start-14)+"&to="+(end-14)+"&search_text="+java.net.URLEncoder.encode(search_text,"UTF-8")+"&search_criteria="+searchcriteria+"&search_by="+search_by+"&fieldname="+fieldname+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
				%>
						<td align ='right' id='next' style='visibility:hidden'>
				<%
					//	if ( !( (start+14) > maxRecord ) )
							out.println("<A HREF='../../eMP/jsp/AddressLookupResult.jsp?from="+(start+14)+"&to="+(end+14)+"&search_text="+java.net.URLEncoder.encode(search_text,"UTF-8")+"&search_criteria="+searchcriteria+"&search_by="+search_by+"&fieldname="+fieldname+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				%>
				</td>
				</tr>
				</table>
					<BR><BR>
				</P>
				<%if(fieldname.equals("town_code")) {%>
				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				
				<th><%=res_town_prompt%></th>
				<%if(res_area_appl_yn.equals("Y")){%>
					<th><%=res_area_prompt%></th>
				<%}
				if(region_appl_yn.equals("Y")){ %>
				<th><%=region_prompt%></th>
				<%}
				if(postal_code_appl_yn.equals("Y")){ %>
					<th><%=postal_code_prompt%></th>
	
			<% }
				}

				if(fieldname.equals("area_code")) {%>
				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			
				<th><%=res_area_prompt%></th>
				<% if(region_appl_yn.equals("Y")){ %>
				<th><%=region_prompt%></th>
			<% }
				}

				if(fieldname.equals("region_code")) {%>
				<table border="1" width="100%" cellspacing='0' cellpadding='0'>

				<th><%=region_prompt%></th>
				<th><fmt:message key="Common.country.label" bundle="${common_labels}"/></th>
			<% 
				}

				if(fieldname.equals("postal_code")) {%>
				<table border="1" width="100%" cellspacing='0' cellpadding='0'>

				<th><%=postal_code_prompt%></th>
				<%if(res_town_appl_yn.equals("Y")){%>
				<th><%=res_town_prompt%></th>
				<%}	if(res_area_appl_yn.equals("Y")){%>
				<th><%=res_area_prompt%></th>
				<%}
				if(region_appl_yn.equals("Y")){ %>
				<th><%=region_prompt%></th>
	
			<% }
				}
			}
			
			if(fieldname.equals("town_code")) {
				out.println("<tr>");

				out.println("<td class='" + classValue + "'><a href='#' onclick='ReturnValues(\""+i+"\")'>");
					
				if(a_town_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_town_desc );
				}
				out.println("</a><input type = 'hidden' name = 'code"+i+"' id = 'code"+i+"' value = \""+a_town_code+"\"><input type = 'hidden' name = 'desc"+i+"' id = 'desc"+i+"'  value = \""+a_town_desc+"\"></td>");

				if(res_area_appl_yn.equals("Y")){
				
				out.println("<td class='" + classValue + "'>");				
				if(a_area_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_area_desc );
				}
				out.println("</td>");
				}
				if(region_appl_yn.equals("Y")){

				out.println("<td class='" + classValue + "'>");
				if(a_region_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_region_desc );
				}				
				out.println("</td>");
				}
				
				if(postal_code_appl_yn.equals("Y")){
				out.println("<td class='" + classValue + "'>");
				if(a_postal_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_postal_desc );
				}
				}
			}
			else if(fieldname.equals("area_code")) {
				out.println("<tr>");

				out.println("<td class='" + classValue + "'><a href='#' onclick='ReturnValues(\""+i+"\")'>");	
				
				if(a_area_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_area_desc );
				}
				out.println("</a><input type = 'hidden' name = 'code"+i+"' id = 'code"+i+"' value = \""+a_area_code+"\"><input type = 'hidden' name = 'desc"+i+"' id = 'desc"+i+"' value = \""+a_area_desc+"\"></td>");

				if(region_appl_yn.equals("Y")){

				out.println("<td class='" + classValue + "'>");
				if(a_region_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_region_desc );
				}
				out.println("</td>");
				}

			}
			else if(fieldname.equals("region_code")) {
				out.println("<tr>");
				//out.println("<td class='" + classValue + "'>");
				//Added for incident[57733]
				out.println("<td class='" + classValue + "'><a href='#' onclick='ReturnValues(\""+i+"\")'>");
				if(a_region_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_region_desc );
				}
				//Added for incident[57733]
				//out.println("</td><td class='" + classValue + "'><a href='#' onclick='ReturnValues(\""+i+"\")'>");	
				
				out.println("</td><td class='" + classValue + "'>");
				
				if(a_country_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_country_desc );
				}
				out.println("</a><input type = 'hidden' name = 'code"+i+"' id = 'code"+i+"' value = \""+a_region_code+"\"><input type = 'hidden' name = 'desc"+i+"' id = 'desc"+i+"' value = \""+a_region_desc+"\"></td>");
				
			}
			else if(fieldname.equals("postal_code")) {
				out.println("<tr>");

				out.println("<td class='" + classValue + "'><a href='#' onclick='ReturnValues(\""+i+"\")'>");
				
				if(a_postal_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_postal_desc );
				}
				out.println("</a><input type = 'hidden' name = 'code"+i+"' id = 'code"+i+"' value = \""+a_postal_code+"\"><input type = 'hidden' name = 'desc"+i+"'  id= 'desc"+i+"' value = \""+a_postal_desc+"\"></td>");

				if(res_town_appl_yn.equals("Y")){
				out.println("<td class='" + classValue + "'>");
				if(a_town_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_town_desc );
				}
				out.println("</td>");
				}
				if(res_area_appl_yn.equals("Y")){
				
				out.println("<td class='" + classValue + "'>");
				if(a_area_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_area_desc );
				}
				out.println("</td>");
				}
				if(region_appl_yn.equals("Y")){
			
				out.println("<td class='" + classValue + "'>");
				if(a_region_desc.equals("")){
					out.println( "&nbsp;" );
				}else{
					out.println( a_region_desc );
				}
				
				}
				
			}
			i++;
			cnt++;
		} 
		
		if (cnt==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%}
		
		%>
		<script>
		<%if(fieldname.equals("postal_code") && cnt==1 && start==1)
		{%>

			ReturnValues('1');
		<%}
		else if(fieldname.equals("region_code") && cnt==1 && start==1) 
		{%>
			ReturnValues('1');
		<%}
		else if(fieldname.equals("area_code") && cnt==1 && start==1) {%>
			ReturnValues('1');
		<%}
		else if(fieldname.equals("town_code") && cnt==1 && start==1) {%>
			ReturnValues('1');
		<%}
		%>
</script>
</td></tr>
</table>
<br><center>
<%
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		sbQuery.setLength(0);
	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
	}finally{
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}


%>

</center>
</body>
</html>
</BODY>
</HTML>

