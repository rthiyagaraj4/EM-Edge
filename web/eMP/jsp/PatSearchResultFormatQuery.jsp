<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<HTML>
<head>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	
	if(whereClause == null) whereClause="";

	String sql=" " ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	
	String name_prefix="";
	String first_name="";
	String second_name="";
	String third_name="";
	String family_name="";
	String name_suffix="";
	String link="Y";
	String accept_national_id_no_yn="";
	String alt_id1_type="";
	String addl_field1_prompt=""; 
	String addl_field2_prompt="";
	String addl_field3_prompt="";
	String addl_field4_prompt=""; 
	String addl_field5_prompt="";	
	String maintain_doc_or_file ="";	
	String entitlement_by_pat_cat_yn ="";	
   
    if(!(whereClause == null || whereClause.equals("")))
    {
		sql = whereClause;
    }

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if(from == null) start = 1 ;
	else start = Integer.parseInt( from ) ;

	if(to == null) end = 14 ;
	else end = Integer.parseInt( to ) ;

	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pcondstmt=null;
	ResultSet rs=null;
	ResultSet condres=null;
	
//	int maxRecord = 0;
	
	try
	{
		conn = ConnectionManager.getConnection(request);
		pcondstmt=conn.prepareStatement("SELECT first_name_accept_yn, second_name_accept_yn, third_name_accept_yn, family_name_accept_yn, name_suffix_accept_yn, name_prefix_accept_yn, accept_national_id_no_yn, alt_id1_type, addl_field1_prompt, addl_field2_prompt, addl_field3_prompt, addl_field4_prompt, addl_field5_prompt, maintain_doc_or_file,entitlement_by_pat_cat_yn FROM mp_param");
	
		condres = pcondstmt.executeQuery();
		if(condres != null)
		{
			if(condres.next())
			{
				name_prefix					= condres.getString("name_prefix_accept_yn");
				first_name					= condres.getString("first_name_accept_yn");
				second_name					= condres.getString("second_name_accept_yn");
				third_name					= condres.getString("third_name_accept_yn");
				family_name					= condres.getString("family_name_accept_yn");
				name_suffix					= condres.getString("name_suffix_accept_yn");
		 		accept_national_id_no_yn	= condres.getString("accept_national_id_no_yn");
				alt_id1_type				= condres.getString("alt_id1_type");                 addl_field1_prompt			= condres.getString("addl_field1_prompt");         
				addl_field2_prompt			= condres.getString("addl_field2_prompt");         
				addl_field3_prompt			= condres.getString("addl_field3_prompt");         
				addl_field4_prompt			= condres.getString("addl_field4_prompt");         
				addl_field5_prompt			= condres.getString("addl_field5_prompt");	        
				maintain_doc_or_file		= condres.getString("maintain_doc_or_file");	        
				entitlement_by_pat_cat_yn		= condres.getString("entitlement_by_pat_cat_yn");	        
				
				if(name_prefix	==null) name_prefix = "N";
				if(first_name	==null) first_name = "N";
				if(second_name	==null) second_name = "N";
				if(third_name	==null) third_name = "N";
				if(family_name	==null) family_name = "N";
				if(name_suffix	==null) name_suffix = "N";
				if(accept_national_id_no_yn == null) accept_national_id_no_yn = "N";
				if(maintain_doc_or_file == null) maintain_doc_or_file = "F";
				if(entitlement_by_pat_cat_yn == null) entitlement_by_pat_cat_yn = "F";
								
				if(addl_field1_prompt	==null) addl_field1_prompt="";
				if(addl_field2_prompt	==null) addl_field2_prompt="";
				if(addl_field3_prompt	==null) addl_field3_prompt="";
				if(addl_field4_prompt	==null) addl_field4_prompt="";
				if(addl_field5_prompt	==null) addl_field5_prompt="";
			}
			else
			{
				out.println("<script>alert(parent.parent.frames[0].getMessage('MP_PARAM_NOT_FOUND','MP'));");
				out.println("parent.window.location.href ='../../eCommon/html/blank.html'</script>") ;	
			}
		}
		else out.print("No records");

	/*	try
		{
			pstmt = conn.prepareStatement("SELECT count(*) as total FROM mp_pat_search_result "+sql);
			rs = pstmt.executeQuery();
			rs.next();
			maxRecord = rs.getInt("total");
		}
		catch(Exception e) 
		{ 
			out.println(e.toString());
		}
		finally
		{
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
	}*/
	
	try
	{
		pstmt = conn.prepareStatement("SELECT * FROM mp_pat_search_result ORDER BY field_order"+sql);
		rs = pstmt.executeQuery();
		%>
		
			<%
		 	if(start != 1)
				for( int j=1; j<start; i++,j++ )
			 		rs.next();
	 		String classValue="";
			int cnt=0;
		    while(i<=end && rs.next())
			{
				if(cnt==0)
				{%>
				<P>
				<table align='right'>
					<tr>
						
						<%
						if(!(start <= 1))
							out.println("<td align ='right' id='prev'><A HREF='../jsp/PatSearchResultFormatQuery.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
%>
						<td align ='right' id='next' style='visibility:hidden'>
<%
						//if(!((start+14) > maxRecord))
							out.println("<A HREF='../jsp/PatSearchResultFormatQuery.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						%>
						</td>
					</tr>
				</table>
				<BR><BR>
				</P>
				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
					<th><fmt:message key="eMP.FieldName.label" bundle="${mp_labels}"/></th>
					<th><fmt:message key="eMP.FieldTitle.label" bundle="${mp_labels}"/></th>
					<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Order.label" bundle="${common_labels}"/></th>
				<%}
				if(i%2==0) classValue="QRYEVEN";
				else classValue="QRYODD";
				out.println("<tr><td class='" + classValue + "'>");
				String code = rs.getString("field_name");
				if(code.equalsIgnoreCase("Patient_Id"))
				{
					//nolink=true;
					link="N";
				}
				/*If Entitlement is unchecked the links of FAMILY_ORG_ID,FAMILY_ORG_SUB_ID, PAT_CAT_CODE,RELATIONSHIP_TO_HEAD should be disabled - Vinod 4/5/2006
				*/
				if (!entitlement_by_pat_cat_yn.equals("Y"))
				{
					if(code.equalsIgnoreCase("FAMILY_ORG_ID"))
					{
						//nolink=true;
						link="N";
					}
					if(code.equalsIgnoreCase("FAMILY_ORG_SUB_ID"))
					{
						//nolink=true;
						link="N";
					}
					if(code.equalsIgnoreCase("PAT_CAT_CODE"))
					{
						//nolink=true;
						link="N";
					}
					if(code.equalsIgnoreCase("RELATIONSHIP_TO_HEAD"))
					{
						//nolink=true;
						link="N";
					}
				}
				if(code.equalsIgnoreCase("Patient_Id"))
				{
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("Name_Prefix") && name_prefix.equals("N"))
				{
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("first_name") && first_name.equals("N"))
				{
					//nolink=true;
					link="N";
				}	
				if(code.equalsIgnoreCase("second_name") && second_name.equals("N"))
				{
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("third_name") && third_name.equals("N"))
				{
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("family_name") && family_name.equals("N"))
				{
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("name_suffix") && name_suffix.equals("N"))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("National_ID_No") && accept_national_id_no_yn.equals("N"))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("Alt_ID1_No") && alt_id1_type.equals("N"))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("ADDL_FIELD1") && addl_field1_prompt.equals(""))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("ADDL_FIELD2") && addl_field2_prompt.equals(""))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("ADDL_FIELD3") && addl_field3_prompt.equals(""))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("ADDL_FIELD4") && addl_field4_prompt.equals(""))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("ADDL_FIELD5") && addl_field5_prompt.equals(""))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("File_No") && maintain_doc_or_file.equals("D"))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("Facility_Id") && maintain_doc_or_file.equals("D"))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("Old_File_No") && maintain_doc_or_file.equals("D"))
				{	
					//nolink=true;
					link="N";
				}
				
				//if(!nolink)
				if(link.equals("N"))
				{
					out.println(code+"</td>");
				}
				else
				{
					out.println("<a href='../../eMP/jsp/modifyPatSearchForResults.jsp?field_name="+ code + "' target='f_query_add_mod' >"+code+"</a></td>");
				}

				out.println("<td class='" + classValue + "'>");
				out.println( rs.getString("field_desc") );
				out.println("</td><td class='" + classValue + "'><CENTER>");
				//out.println(rs.getString("field_select") );
				if(rs.getString("field_select").equals("Y"))
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				out.println("</CENTER></td> <td class='" + classValue + "'>");

				if(rs.getString("field_order")==null)
					out.println("&nbsp");
				else
					out.println(rs.getString("field_order"));
				i++;
				link="Y";
				cnt++;
			}
			if (cnt==0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			boolean flag = false;
			if ( cnt < 14 || (!rs.next()) ) { 
			%>
				<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='hidden';
				</script>
			<% flag = true;
					} else {%>
				<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='visible';
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%}
			out.println("</td>");
			//nolink=false;
		}
		catch(Exception e) 
		{ 
			//out.println(e.toString());
			e.printStackTrace(); // Added by lakshmanan for security issue ID 174219100 on 28-08-2023
		}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		}
	}
	catch(Exception e)
	{ 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174219101 on 28-08-2023
	}
	finally
	{
		if(pcondstmt!=null)	pcondstmt.close();
		if(condres!=null) 	condres.close();
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>
</td></tr>
</table>
<br><center>
<%
%>
</center>
</BODY>
</HTML>
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

