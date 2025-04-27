<!DOCTYPE html>
<%@ 
page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
//String facilityId		= (String) session.getValue( "facility_id" ) ;
%>
<HTML>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eMP/js/PatCatOrgMbsp.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
 
</script>
</head>
<BODY  class='CONTENT' onLoad='' onMouseDown='CodeArrest()' onKeyDown='lockKey()' >
<%
String param		= request.getParameter("param");

if(param.equals("CREATE"))
{
	String category		= request.getParameter("category");
	Connection con = null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;
	try
	{
		con =ConnectionManager.getConnection(request);
		StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from MP_PAT_CATEGORY_DERIV_RULE where PAT_CAT_CODE='"+category+"'");
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
		stmt.close();
		rs.close();
		//out.println("<script>alert('here 222----"+maxRecord+"');</script>");

	if(maxRecord == 0)
		{
		//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA')+'"+maxRecord+"');history.go(-1);</script>");
		}
		else
		{
		StringBuffer strsql2 = new StringBuffer();
		//strsql2.append("SELECT a.MEMBERSHIP_TYPE, a.FAMILY_ORG_ID, a.FAMILY_ORG_SUB_ID,a.RELATIONSHIP_CODE ,DECODE (a.membership_type,'1', 'Organization Member','2', 'Related Member - Family', '3', 'Related Member - Non-Family','4', 'Non-Organization Member') membership,a.name_prefix, b.family_org_sub_name,c.short_desc relation_desc,d.FAMILY_ORG_NAME  FROM mp_pat_category_deriv_rule a, mp_family_org_sub b, mp_relationship c,MP_FAMILY_ORG d WHERE a.family_org_sub_id = b.family_org_sub_id   AND c.relationship_code = a.relationship_code  and d.FAMILY_ORG_ID=a.FAMILY_ORG_ID and  a.PAT_CAT_CODE='"+category+"'");

		strsql2.append("SELECT a.MEMBERSHIP_TYPE Membership_code, membership_type,a.name_prefix,a.relationship_code,( case when a.relationship_code != '*ALL' and a.relationship_code != '*NA' then (select short_desc from mp_relationship where relationship_code = a.relationship_code) when a.relationship_code = '*ALL' then 'ALL' when a.relationship_code = '*NA' then 'NA' end ) relation_desc, a.pat_cat_code, (select short_desc from mp_pat_category where pat_cat_code = a.pat_cat_code) pat_cat_desc, a.family_org_id, ( case when a.family_org_id != '*ALL' and a.family_org_id != '*NA' then (select family_org_name from mp_family_org where family_org_id = a.family_org_id) when a.family_org_id = '*ALL' then 'ALL' when a.family_org_id = '*NA' then 'NA' end ) family_org_desc, a.family_org_sub_id, ( case when a.family_org_sub_id = '*ALL'  then 'ALL' when a.family_org_sub_id = '*NA' then 'NA' when a.family_org_id != '*ALL' and a.family_org_sub_id != '*ALL' and a.family_org_id != '*NA' and a.family_org_sub_id != '*NA' then (select family_org_sub_name from mp_family_org_sub where family_org_id = a.family_org_id and family_org_sub_id = a.family_org_sub_id) end ) family_org_sub_desc FROM  mp_pat_category_deriv_rule a where a.PAT_CAT_CODE='"+category+"' order by membership_code");
		//strsql2.append(category);
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2.toString());

%>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th><fmt:message key="eMP.membership.label" bundle="${mp_labels}"/></th>
				<th><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="eMP.SubUnit.label" bundle="${mp_labels}"/></th>
				<th nowrap><fmt:message key="Common.NamePrefix.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></th>
			</tr>

<%
				String classValue = "" ;
				int i=1;
				String membership_type = "" ;
				String family_org_id = "" ;
				String family_org_sub_id = "" ;
				String name_prefix = "" ;
				String relationship_code = "" ;
				String membership_type_code = "" ;
				String family_org_id_code = "" ;
				String family_org_sub_id_code = "" ;
				String relationship_code1 = "" ;
				String mode = "update" ;

				while ( rs.next())
				{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
				//DECODE (membership_type, '1', 'Organization Member','2', 'Related Member - Family','3', 'Related Member - Non-Family','4', 'Non-Organization Member' )

						membership_type	  =rs.getString("MEMBERSHIP_TYPE");

						if(membership_type.equals("1"))
							membership_type="Organization Member";
						if(membership_type.equals("2"))
							membership_type="Related Member - Family";
						if(membership_type.equals("3"))
							membership_type="Related Member - Non-Family";
						if(membership_type.equals("4")) 
							membership_type="Non-Organization Member";

						family_org_id	  =rs.getString("FAMILY_ORG_DESC");
						family_org_sub_id =rs.getString("FAMILY_ORG_SUB_DESC");
						name_prefix		  =rs.getString("NAME_PREFIX");
						relationship_code =rs.getString("RELATION_DESC");

						membership_type_code	  =rs.getString("Membership_code");
						family_org_id_code	  =rs.getString("FAMILY_ORG_ID");
						family_org_sub_id_code =rs.getString("FAMILY_ORG_SUB_ID");
						relationship_code1 =rs.getString("RELATIONSHIP_CODE");

						out.println("<tr>");
						//out.println("<td class='" + classValue + "'><a  href=\"../jsp/AddModifyNursUnitPhysLocn.jsp?nursing_unit_code="+URLEncoder.encode(nursing_unit_code)+"&nursing_unit_desc="+URLEncoder.encode(nursing_unit_desc)+"&building_desc="+URLEncoder.encode(building_desc)+"&floor_desc="+URLEncoder.encode(floor_desc)+"&bldng_code="+URLEncoder.encode(building_code)+"&floor_code="+URLEncoder.encode(floor_code)+"\" target='f_query_add_mod' >");  
						//out.println(nursing_unit_code+"</a></td>");

						out.println("<td nowrap class='" + classValue + "'><a  href=\"../jsp/PatCatOrgMbspSub.jsp?membership_type_code="+URLEncoder.encode(membership_type_code)+"&family_org_id_code="+URLEncoder.encode(family_org_id_code)+"&family_org_sub_id_code="+URLEncoder.encode(family_org_sub_id_code)+"&relationship_code1="+URLEncoder.encode(relationship_code1)+"&name_prefix="+URLEncoder.encode(name_prefix)+"&mode="+URLEncoder.encode(mode)+"\" target='sub_frame' >");  
						
					out.println(membership_type+"</a></td>");

						

						out.print("<td class='" + classValue + "'>"+family_org_id+"</td>");

						out.print("<td class='" + classValue + "'>"+family_org_sub_id+"</td>");
						out.print("<td class='" + classValue + "'>"+name_prefix+"</td>");
						out.print("<td class='" + classValue + "'>"+relationship_code+"</td>");
						
						out.print("</tr>");
					i++;
				}
%>
<%
		}
}
catch(Exception e)
{
	out.print(e.toString());
}
finally   
{
	try{

		if(stmt!=null) 	stmt.close();
		if(rs!=null) 		rs.close();
	}
	catch(Exception e)
	{out.println("Exception in tryCatch : "+ e.toString());}
		ConnectionManager.returnConnection(con,request); ;
}
}
else
if(param.equals("QUERY"))
{

	StringBuffer sql	= new StringBuffer();

	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	String whereClause		= request.getParameter("whereclause");
	String category			= "";
	String membership		= "";
	String organization		= "";
	String sub_org			= "";
	String prefix			= "";
	String relationship		= "";

	if ( (whereClause == null || whereClause.equals("")) )
	{
		 membership			= request.getParameter("membership");
		 category			= request.getParameter("category");
		 organization		= request.getParameter("organization");
		 sub_org			= request.getParameter("sub_org");
		 prefix				= request.getParameter("prefix");
		 relationship		= request.getParameter("relationship");

		int andCheck		= 0;

		if(category!=null && !category.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(PAT_CAT_CODE) like upper('"+category+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(PAT_CAT_CODE) like upper('"+category+"%')");
				andCheck = 1;
			}				
		}

		if(membership!=null && !membership.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(membership_type) like upper('"+membership+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(membership_type) like upper('"+membership+"%')");
				andCheck = 1;
			}				
		}

		if(organization!=null && !organization.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(family_org_id) like upper('"+organization+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(family_org_id) like upper('"+organization+"%')");
				andCheck = 1;
			}
		}

		if(sub_org!=null && !sub_org.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(family_org_sub_id) like upper('"+sub_org+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(family_org_sub_id) like upper('"+sub_org+"%')");
				andCheck = 1;
			}				
		}

		if(prefix!=null && !prefix.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(name_prefix)= upper(?)");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(name_prefix) = upper(?)");
				andCheck = 1;
			}				
		}

		if(relationship!=null && !relationship.equals(""))
		{	
			if ( andCheck == 1 )
			{
				sql.append("and upper(relationship_code) like upper('"+relationship+"%')");
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(relationship_code) like upper('"+relationship+"%')");
				andCheck = 1;
			}				
		}
	}
	else
	{
		sql.append(whereClause);
	}

	int start = 0 ;			
	int end = 0 ;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;


	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{
		con =ConnectionManager.getConnection(request);
		StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from MP_PAT_CATEGORY_DERIV_RULE ");
		strsql1.append(sql.toString());
		pstmt=con.prepareStatement(strsql1.toString());
        if(prefix!=null && !prefix.equals(""))
		{	
		  pstmt.setString(1,prefix);	
        }
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		pstmt.close();
		rs.close();

	if(maxRecord == 0)
		{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
		%>
			<script>
			parent.frames[1].location.href ="../../eMP/jsp/PatCatOrgMbspQueryCriteria.jsp?param=query";
			</script>
		<%
		}
		else
		{
		//out.println("<script>alert('inside else...');</script>");
		StringBuffer strsql2 = new StringBuffer();
		//strsql2.append("select DECODE (MEMBERSHIP_TYPE,'1', 'Organization Member','2', 'Related Member - Family','3', 'Related Member - Non-Family','4','Non-Organization Member') MEMBERSHIP_TYPE, FAMILY_ORG_ID, FAMILY_ORG_SUB_ID, NAME_PREFIX, RELATIONSHIP_CODE,PAT_CAT_CODE from MP_PAT_CATEGORY_DERIV_RULE ");
		//strsql2.append("select DECODE (MEMBERSHIP_TYPE,'1', 'Organization Member','2', 'Related Member - Family','3', 'Related Member - Non-Family','4','Non-Organization Member') MEMBERSHIP_TYPE,a.family_org_id,b.FAMILY_ORG_NAME, a.family_org_sub_id,c.FAMILY_ORG_SUB_NAME, name_prefix, d.relationship_code, d.SHORT_DESC relationship_desc, a.pat_cat_code,e.SHORT_DESC category_desc  FROM mp_pat_category_deriv_rule a,MP_FAMILY_ORG b,MP_FAMILY_ORG_SUB c,mp_relationship d,mp_pat_category e  where  a.family_org_id =  b.family_org_id and  a.family_org_sub_id = c.family_org_sub_id and  a.RELATIONSHIP_CODE=d.RELATIONSHIP_CODE and a.pat_cat_code = e.pat_cat_code ");

		//strsql2.append("SELECT DECODE (membership_type, '1', 'Organization Member','2', 'Related Member - Family','3', 'Related Member - Non-Family','4', 'Non-Organization Member' ) membership_type,a.name_prefix,a.relationship_code,( case when a.relationship_code != '*ALL' and a.relationship_code != '*NA' then (select short_desc from mp_relationship where relationship_code = a.relationship_code) when a.relationship_code = '*ALL' then 'ALL' when a.relationship_code = '*NA' then 'NA' end ) relation_desc, a.pat_cat_code, (select short_desc from mp_pat_category where pat_cat_code = a.pat_cat_code) pat_cat_desc, a.family_org_id, ( case when a.family_org_id != '*ALL' and a.family_org_id != '*NA' then (select family_org_name from mp_family_org where family_org_id = a.family_org_id) when a.family_org_id = '*ALL' then 'ALL' when a.family_org_id = '*NA' then 'NA' end ) family_org_desc, a.family_org_sub_id, ( case when a.family_org_sub_id = '*ALL'  then 'ALL' when a.family_org_sub_id = '*NA' then 'NA' when a.family_org_id != '*ALL' and a.family_org_sub_id != '*ALL' and a.family_org_id != '*NA' and a.family_org_sub_id != '*NA' then (select family_org_sub_name from mp_family_org_sub where family_org_id = a.family_org_id and family_org_sub_id = a.family_org_sub_id) end ) family_org_sub_desc FROM  mp_pat_category_deriv_rule a ");
		strsql2.append("SELECT membership_type,a.name_prefix,a.relationship_code,( case when a.relationship_code != '*ALL' and a.relationship_code != '*NA' then (select short_desc from mp_relationship where relationship_code = a.relationship_code) when a.relationship_code = '*ALL' then 'ALL' when a.relationship_code = '*NA' then 'NA' end ) relation_desc, a.pat_cat_code, (select short_desc from mp_pat_category where pat_cat_code = a.pat_cat_code) pat_cat_desc, a.family_org_id, ( case when a.family_org_id != '*ALL' and a.family_org_id != '*NA' then (select family_org_name from mp_family_org where family_org_id = a.family_org_id) when a.family_org_id = '*ALL' then 'ALL' when a.family_org_id = '*NA' then 'NA' end ) family_org_desc, a.family_org_sub_id, ( case when a.family_org_sub_id = '*ALL'  then 'ALL' when a.family_org_sub_id = '*NA' then 'NA' when a.family_org_id != '*ALL' and a.family_org_sub_id != '*ALL' and a.family_org_id != '*NA' and a.family_org_sub_id != '*NA' then (select family_org_sub_name from mp_family_org_sub where family_org_id = a.family_org_id and family_org_sub_id = a.family_org_sub_id) end ) family_org_sub_desc FROM  mp_pat_category_deriv_rule a ");

		strsql2.append(sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2.toString());
%>
		<P>
		<table align='right'>
			<tr>
				<td>
					<%
					if ( !(start <= 1) )
						out.println("<A HREF='../jsp/PatCatOrgMbspDtls.jsp?from="+(start-14)+"&to="+(end-14)+"&category="+URLEncoder.encode(category)+"&membership="+URLEncoder.encode(membership)+"&organization="+URLEncoder.encode(organization)+"&param="+URLEncoder.encode("QUERY")+"&sub_org="+URLEncoder.encode(sub_org)+"&prefix="+URLEncoder.encode(prefix)+"&relationship="+URLEncoder.encode(relationship)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					if ( !( (start+14) > maxRecord ) )
						out.println("<A HREF='../jsp/PatCatOrgMbspDtls.jsp?from="+(start+14)+"&to="+(end+14)+"&category="+URLEncoder.encode(category)+"&membership="+URLEncoder.encode(membership)+"&organization="+URLEncoder.encode(organization)+"&param="+URLEncoder.encode("QUERY")+"&sub_org="+URLEncoder.encode(sub_org)+"&prefix="+URLEncoder.encode(prefix)+"&relationship="+URLEncoder.encode(relationship)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
					%>
				</td>
			</tr>
		</table>
		</P>
		<br>
		<br>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th><fmt:message key="Common.category1.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eMP.membership.label" bundle="${mp_labels}"/></th>
				<th><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="eMP.suborgn.label" bundle="${mp_labels}"/></th>
				<th nowrap><fmt:message key="eMP.prefix.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></th>
			</tr>

<%
				String classValue = "" ;
				int i=1;
				String category_desc = "" ;
				String membership_type = "" ;
				String family_org_id = "" ;
				String family_org_sub_id = "" ;
				String name_prefix = "" ;
				String relationship_code = "" ;

				while ( rs.next())
				{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						membership_type	  = rs.getString("MEMBERSHIP_TYPE");

						
						if(membership_type.equals("1"))
							membership_type="Organization Member";
						if(membership_type.equals("2"))
							membership_type="Related Member - Family";
						if(membership_type.equals("3"))
							membership_type="Related Member - Non-Family";
						if(membership_type.equals("4")) 
							membership_type="Non-Organization Member";

						category_desc	  = rs.getString("PAT_CAT_DESC");

						family_org_id	  = rs.getString("FAMILY_ORG_DESC");
						if(family_org_id.equals("*ALL")) family_org_id = "ALL";
						if(family_org_id.equals("*NA"))  family_org_id = "NA";

						family_org_sub_id = rs.getString("FAMILY_ORG_SUB_DESC");
						if(family_org_sub_id.equals("*ALL")) family_org_sub_id = "ALL";
						if(family_org_sub_id.equals("*NA")) family_org_sub_id = "NA";

						name_prefix		  = rs.getString("NAME_PREFIX");
						if(name_prefix.equals("*ALL")) name_prefix = "ALL";

						relationship_code = rs.getString("RELATION_DESC");

						out.println("<tr>");
						out.print("<td class='" + classValue + "'>"+category_desc+"</td>");
						out.print("<td class='"+classValue+ "'>"+membership_type+"</td>");
						out.print("<td class='" + classValue + "'>"+family_org_id+"</td>");
					out.print("<td class='"+classValue+"'>"+family_org_sub_id+"</td>");
						out.print("<td class='" + classValue + "'>"+name_prefix+"</td>");
					out.print("<td class='"+classValue+ "'>"+relationship_code+"</td>");
						out.print("</tr>");
					i++;				}
		}
}
catch(Exception e)
{
	out.print(e.toString());
}
finally   
{
	try{

		if(stmt!=null) 	stmt.close();
		if(rs!=null) 		rs.close();
	}
	catch(Exception e)
	{out.println("Exception in tryCatch : "+ e.toString());}
		ConnectionManager.returnConnection(con,request); ;
}
}
%>
</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

