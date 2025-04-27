<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<!-- <%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %> -->
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

 <Script Language="JavaScript" src="../../eCommon/js/common.js"></script> 
<script language='javascript' src='../js/AdverseReaction.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String whereClause		= request.getParameter("whereclause");
	StringBuffer sql		= new StringBuffer();
	String from				= request.getParameter( "from" ) ;
	String to				= request.getParameter( "to" ) ;
	String reaction_code	= request.getParameter("REACTION_CODE");
	String reac_desc		= request.getParameter("a.long_desc");
	String allergen_code	= request.getParameter("b.allergen_code");
	String allergen_desc	= request.getParameter("c.short_desc");
	String adv_event_desc1	= request.getParameter("ADV_EVENT_TYPE_IND_DESC");
	String adv_event_type_code	= request.getParameter("ADV_EVENT_TYPE_CODE");
	 
	String new_code			= "";
	String classValue		= "";


	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql	= new StringBuffer();
		int andCheck = 0;

		if ( !(reaction_code == null || reaction_code.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append(" upper(REACTION_CODE)  like  upper('"+reaction_code+"%') ");
			}
			else
			{
				sql = new StringBuffer();
				sql.append(" and upper(REACTION_CODE)  like  upper('"+reaction_code+"%') ");
				andCheck = 1;
			}
		}

		if ( !(reac_desc == null || reac_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append( " and ");
				sql.append(" upper(am_get_desc.am_reaction(b.reaction_code,'"+locale+"',1))  like  upper('"+reac_desc+"%') ");
			}
			else
			{
				sql = new StringBuffer();
				sql.append(" and upper(am_get_desc.am_reaction(b.reaction_code,'"+locale+"',1))  like  upper('"+reac_desc+"%') ");
				andCheck = 1;
			}
		}

		if ( !(allergen_code == null || allergen_code.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append( " and ");
				sql.append(" upper(a.ALLERGEN_CODE)  like  upper('"+allergen_code+"%') ");
			}
			else
			{
				sql = new StringBuffer();
				sql.append(" and upper(a.ALLERGEN_CODE)  like  upper('"+allergen_code+"%') ");
				andCheck = 1;
			}
		}

		if ( !(allergen_desc == null || allergen_desc.equals("")) )
		{
			if(adv_event_type_code.equals("DA"))
			{
				if ( andCheck == 1 )
				{	
					sql.append( " and ");
					sql.append(" upper(c.generic_name)  like  upper('"+allergen_desc+"%') ");
				}
				else
				{
					sql = new StringBuffer();
					sql.append(" and upper(c.generic_name)  like  upper('"+allergen_desc+"%') ");
					andCheck = 1;
				}
			}else
			{
				if ( andCheck == 1 )
				{	
					sql.append( " and ");
					sql.append(" upper(c.short_desc)  like  upper('"+allergen_desc+"%') ");
				}
				else
				{
					sql = new StringBuffer();
					sql.append(" and upper(c.short_desc)  like  upper('"+allergen_desc+"%') ");
					andCheck = 1;
				}
			}
		}	
			
		if ( !(adv_event_desc1 == null || adv_event_desc1.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append( " and ");
				sql.append(" upper(d.ADV_EVENT_TYPE_IND)  like  upper('"+adv_event_desc1+"%') ");
			}
			else
			{
				sql = new StringBuffer();
				sql.append(" and upper(d.ADV_EVENT_TYPE_IND)  like  upper('"+adv_event_desc1+"%') ");
				andCheck = 1;
			}
		}	


		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");

			for ( int i=0;i < ord.length;i++ )
			{
				if ( i == ord.length - 1 )
					sql.append(ord[i]);
				else
					sql.append(ord[i]+",");
			}
		}
	} //end of where clause IF
	else 
	{
		sql			= new StringBuffer();
		sql.append(whereClause);
	}

		int start	= 0 ;
		int end		= 0 ;
		int i		= 1;

		if ( from == null )
			start	= 1 ;
		else
			start	= Integer.parseInt( from ) ;

		if ( to == null )
			end		= 10 ;
		else
			end		= Integer.parseInt( to ) ;

		Connection conn		= null;
		Statement stmt		= null;
		ResultSet rs		= null;
		int maxRecord		= 0;
	try
	{
		conn				= ConnectionManager.getConnection(request);
		String strsql2		= "";

	
		 //strsql2="select * from (SELECT a.ADV_REAC_CODE REACTION_CODE, b.long_desc long_desc, b.short_desc, a.eff_status, a.adv_event_type_ind,a.ALLERGEN_CODE allergen_code, c.long_desc causitive_desc,d.ADV_EVENT_TYPE_IND_DESC ADV_EVENT_TYPE_IND_DESC  FROM  mr_adv_rea_cause_agent A, AM_reaction b, MR_ALLERGEN c, MR_ADV_EVENT_TYPE_IND d WHERE a.ADV_REAC_CODE=b.REACTION_CODE AND b.ADVERSE_REACTION_YN='Y' AND A.ALLERGEN_CODE = c.ALLERGEN_CODE and a.ADV_EVENT_TYPE_IND = d.ADV_EVENT_TYPE_IND UNION SELECT a.ADV_REAC_CODE REACTION_CODE, b.long_desc long_desc, b.short_desc, a.eff_status, a.adv_event_type_ind,a.ALLERGEN_CODE allergen_code, c.GENERIC_NAME causitive_desc,d.ADV_EVENT_TYPE_IND_DESC ADV_EVENT_TYPE_IND_DESC FROM  mr_adv_rea_cause_agent A, AM_reaction b, PH_GENERIC_NAME c,MR_ADV_EVENT_TYPE_IND d WHERE a.ADV_REAC_CODE=b.REACTION_CODE AND b.ADVERSE_REACTION_YN='Y' AND A.ALLERGEN_CODE = c.GENERIC_ID and a.ADV_EVENT_TYPE_IND = d.ADV_EVENT_TYPE_IND ) WHERE  eff_status='E' "+sql.toString();
		 /*Friday, February 11, 2011,SRR20056-SCF-6860 [IN:026456]*/
		if(adv_event_type_code.equals("DA"))
		{
			strsql2="SELECT a.ADV_REAC_CODE REACTION_CODE, am_get_desc.am_reaction(b.reaction_code,'"+locale+"',1) long_desc, am_get_desc.am_reaction(b.reaction_code,'"+locale+"',2)short_desc, a.eff_status, a.adv_event_type_ind,a.ALLERGEN_CODE allergen_code, c.GENERIC_NAME causitive_desc,mr_get_desc.MR_ADV_EVENT_TYPE_ind(d.ADV_EVENT_TYPE_IND,'"+locale+"',1) ADV_EVENT_TYPE_IND_DESC FROM  mr_adv_rea_cause_agent A, AM_reaction b, PH_GENERIC_NAME_lang_vw c,MR_ADV_EVENT_TYPE_IND d WHERE a.ADV_REAC_CODE=b.REACTION_CODE AND b.ADVERSE_REACTION_YN='Y' AND A.ALLERGEN_CODE = c.GENERIC_ID and a.ADV_EVENT_TYPE_IND = d.ADV_EVENT_TYPE_IND and  a.eff_status='E' and a.ADV_REAC_CODE like ('%%') AND c.language_id = '"+locale+"' "+sql.toString();	
		}else
		{
			strsql2="SELECT a.ADV_REAC_CODE REACTION_CODE, am_get_desc.am_reaction(b.reaction_code,'"+locale+"',1) long_desc, am_get_desc.am_reaction(b.reaction_code,'"+locale+"',2)short_desc, a.eff_status, a.adv_event_type_ind,a.ALLERGEN_CODE allergen_code, c.short_desc causitive_desc,mr_get_desc.MR_ADV_EVENT_TYPE_ind(d.ADV_EVENT_TYPE_IND,'"+locale+"',1) ADV_EVENT_TYPE_IND_DESC  FROM  mr_adv_rea_cause_agent A, AM_reaction b, MR_ALLERGEN_LANG_VW c, MR_ADV_EVENT_TYPE_IND d WHERE a.ADV_REAC_CODE=b.REACTION_CODE AND b.ADVERSE_REACTION_YN='Y' AND A.ALLERGEN_CODE = c.ALLERGEN_CODE and a.ADV_EVENT_TYPE_IND = d.ADV_EVENT_TYPE_IND and  a.eff_status='E' and a.ADV_REAC_CODE like ('%%') AND c.language_id = '"+locale+"' "+sql.toString();
		}
		 
		/*Friday, February 11, 2011,commented for SRR20056-SCF-6860 [IN:026456]*/
		//stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(strsql2);
		
		/*Friday, February 11, 2011,commented for SRR20056-SCF-6860 [IN:026456]*/
		/*rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		*/

		if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
			  rs.next() ;

			  }
		while ( rs.next() && i<=end )
		{
			if(maxRecord == 0){
		%>
		<P>
		<table align='right'>
		<tr>
		<td>
		<%
		if ( !(start <= 1) )
		{
			out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/AdverseReactionQueryResult.jsp?from="+(start-10)+"&to="+(end-10)+"&whereclause="+URLEncoder.encode(sql.toString())+"&ADV_EVENT_TYPE_CODE="+adv_event_type_code+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		}
		//if ( !( (start+10) > maxRecord ) )
		//{
			out.println("<td align ='right' id='next' ><A HREF='../../eMR/jsp/AdverseReactionQueryResult.jsp?from="+(start+10)+"&to="+(end+10)+"&whereclause="+URLEncoder.encode(sql.toString())+"&ADV_EVENT_TYPE_CODE="+adv_event_type_code+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		//}
			%>
		</tr>
		</td>
		</table>
		<br><br>
		</P>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<% //if(maxRecord > 0){ %>
		<th><fmt:message key="eMR.AdverseReaction Code.label" bundle="${mr_labels}"/></th>
		<th><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></th>
		<th><fmt:message key="eMR.AllergenCode.label" bundle="${mr_labels}"/></th>
		<th><fmt:message key="eMR.Allergendesc.label" bundle="${mr_labels}"/></th>
		<th><fmt:message key="eMR.AdverseEventTypeIndicator.label" bundle="${mr_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>


		<%}
			/*if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
			  rs.next() ;

			  }*/

			//while ( rs.next() && i<=end )
			//{
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				
				new_code = rs.getString("REACTION_CODE");

				out.println ( "<tr><td class='"+classValue+"'>");
				%><%=new_code%></td><%
				out.println("<td  class='"+classValue+"'>");
				out.println( rs.getString("long_desc") );
				out.println("</td><td  class='"+classValue+"'>");

				out.println( rs.getString("ALLERGEN_CODE") );
				out.println("</td><td  class='"+classValue+"'>");

				out.println( rs.getString("causitive_desc") );
				out.println("</td><td  class='"+classValue+"'>");

				out.println( rs.getString("ADV_EVENT_TYPE_IND_DESC") );
				out.println("</td><td  class='"+classValue+"' align=center>");

				//if ( rs.getString("eff_status").equals("E") )
				String eff_status		=(rs.getString("eff_status")==null)?"D":rs.getString("eff_status");
				if ( eff_status.equals("E") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

				i++;
				maxRecord ++;

			}//endwhile	
		
			
										
				if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
				boolean flag = false;
				if ( maxRecord < 10 || (!rs.next()) )
				{
					%>
					<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='hidden';
					</script>
					<% flag = true;
				}
				else
				{%>
					<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<%
				}	
					%>

		</td></tr>
		</table>
		<br>
		</BODY>
		</HTML>
			<%
	}catch(Exception e){
			out.println("Exception "+e.toString());
			e.printStackTrace();
	}
	finally{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			ConnectionManager.returnConnection(conn,request);
		}
	
	%>
	<%!	
		private String checkForNull(String inputString)
		{
			return (inputString==null)	? "" : inputString;
		}

		private String checkForNull(String inputString, String defaultValue)
		{
			return (inputString==null)	? defaultValue : inputString;
		}
	%>

