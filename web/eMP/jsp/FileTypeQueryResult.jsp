<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script Language='JavaScript' src='../../eCommon/js/common.js'></script></head><BODY  OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'  class='CONTENT' >");

    StringBuffer sql =new StringBuffer();
    String from = request.getParameter( "from" ) ;

    String to = request.getParameter( "to" ) ;
	
	
	//sql="";

	String scode = request.getParameter("facility_id")==null ? "" : request.getParameter("facility_id");
	String sdesc = request.getParameter("facility_name")==null ? "" : request.getParameter("facility_name");
	String sscode = request.getParameter("file_type_code")==null ? "" : request.getParameter("file_type_code");
	String ssdesc = request.getParameter("long_desc")==null ? "" : request.getParameter("long_desc");
	String sssdesc = request.getParameter("short_desc")==null ? "" : request.getParameter("short_desc");

	String appl_to_op = request.getParameter("appl_to_op")==null ? "" : request.getParameter("appl_to_op");
	String appl_to_ip = request.getParameter("appl_to_ip")==null ? "" : request.getParameter("appl_to_ip");
	String appl_to_em = request.getParameter("appl_to_em")==null ? "" : request.getParameter("appl_to_em");
	String appl_to_dc = request.getParameter("appl_to_dc")==null ? "" : request.getParameter("appl_to_dc");

	String estatus = request.getParameter("eff_status")==null ? "" : request.getParameter("eff_status");
	/*Added by lakshmanan for security issue ID 174183097 on 21-08-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174183097 on 21-08-2023 end */
	int andCheck = 0;

	scode=scode.toUpperCase();
		if ( !(scode == null || scode.equals("")) )
			{
				sql.append(" and upper(isc.facility_id) like upper(?)");
				//sql.append(scode);
				//sql.append("%')");
				psthashmap.put(++psthmcount,scode+"%");
				andCheck = 1;
			}

		if ( !(sdesc == null || sdesc.equals("")) )
			{
				if ( andCheck == 1 )
					{	
						sql.append(" and upper(facility_name) like  upper(?)");
						//sql.append(sdesc);
						//sql.append("%')");
						psthashmap.put(++psthmcount,sdesc+"%");
					}
				else
					{
						sql.append(" and upper(facility_name) like upper(?)");
						//sql.append(sdesc);
						//sql.append("%')");
						psthashmap.put(++psthmcount,sdesc+"%");
						andCheck = 1;
					}
			}

	sscode=sscode.toUpperCase();
		if ( !(sscode == null || sscode.equals("")) )
			{
				if ( andCheck == 1 )
					{	
						sql.append(" and upper(file_type_code) like  upper(?)");
						psthashmap.put(++psthmcount,sscode+"%");
						//sql.append(sscode);
						//sql.append("%')");
					}
				else
					{
						sql.append("and upper(file_type_code) like upper(?)");
						psthashmap.put(++psthmcount,sscode+"%");
						//sql.append(sscode);
						//sql.append("%')");
						andCheck = 1;
					}

			}
	ssdesc=ssdesc.toUpperCase();
		if ( !(ssdesc == null || ssdesc.equals("")) )
			{
				if ( andCheck == 1 )
					{	
						sql.append(" and upper(long_desc)  like  upper(?)");
						psthashmap.put(++psthmcount,ssdesc+"%");
						//sql.append(ssdesc);
						//sql.append("%')");
					}
				else
					{
						sql.append(" and upper(long_desc)  like upper(?)");
						psthashmap.put(++psthmcount,ssdesc+"%");
						//sql.append(ssdesc);
						//sql.append("%')");
						andCheck = 1;
					}
			}
	sssdesc=sssdesc.toUpperCase();
		if ( !(sssdesc == null || sssdesc.equals("")) )
			{

				if ( andCheck == 1 )
					{	
						sql.append( " and upper(short_desc)  like  upper(?)");
						psthashmap.put(++psthmcount,sssdesc+"%");
						//sql.append(sssdesc);
						//sql.append("%')");
					}
				else
					{
						sql.append(" and upper(short_desc)  like upper(?)");
						psthashmap.put(++psthmcount,sssdesc+"%");
						//sql.append(sssdesc);
						//sql.append("%')");
						andCheck = 1;
					}
			}
			if(!(appl_to_op == null || appl_to_op.equals("")))
			{
				if(appl_to_op.equals("Y"))
				{
					if(andCheck == 1)
					{	
						sql.append(" and isc.appl_to_op = 'Y' ");
					}
					else
					{
						sql.append(" and isc.appl_to_op = 'Y' ");
						andCheck = 1;
					}
				}
				if(appl_to_op.equals("N"))
				{
					if(andCheck == 1)
					{	
						sql.append(" and isc.appl_to_op = 'N' ") ;
					}
					else
					{
						sql.append(" and isc.appl_to_op = 'N' ");
						andCheck = 1;
					}
				}
			}
			if(!(appl_to_ip == null || appl_to_ip.equals("")))
			{
				if(appl_to_ip.equals("Y"))
				{
					if(andCheck == 1)
					{	
						sql.append( " and isc.appl_to_ip = 'Y' ");
					}
					else
					{
						sql .append( " and isc.appl_to_ip = 'Y' ");
						andCheck = 1;
					}
				}
				if(appl_to_ip.equals("N"))
				{
					if(andCheck == 1)
					{	
						sql.append(" and isc.appl_to_ip = 'N' ");
					}
					else
					{
						sql.append(" and isc.appl_to_ip = 'N' " );
						andCheck = 1;
					}
				}
			}
			if(!(appl_to_em == null || appl_to_em.equals("")))
			{
				if(appl_to_em.equals("Y"))
				{
					if(andCheck == 1)
					{	
						sql.append( " and isc.appl_to_em = 'Y' ");  
					}
					else
					{
						sql.append( " and isc.appl_to_em = 'Y' ");
						andCheck = 1;
					}
				}
				if(appl_to_em.equals("N"))
				{
					if(andCheck == 1)
					{	
						sql.append( " and isc.appl_to_em = 'N' ");  
					}
					else
					{
						sql.append(" and isc.appl_to_em = 'N' ");
						andCheck = 1;
					}
				}
			}
			if(!(appl_to_dc == null || appl_to_dc.equals("")))
			{
				if(appl_to_dc.equals("Y"))
				{
					if(andCheck == 1)
					{	
						sql.append(" and isc.appl_to_dc = 'Y' ");
					}
					else
					{
						sql.append(" and isc.appl_to_dc = 'Y' ");
						andCheck = 1;
					}
				}
				if(appl_to_dc.equals("N"))
				{
					if(andCheck == 1)
					{	
						sql.append(" and isc.appl_to_dc = 'N' ");
					}
					else
					{
						sql.append(" and isc.appl_to_dc = 'N' ");
						andCheck = 1;
					}
				}
			}
	estatus=estatus.toUpperCase();
//		if ( !(estatus == null || estatus.equals("")) )
			{
     
			   if ( estatus.equals("E") )
					{

						if ( andCheck == 0 )
							sql.append(" and ISC.EFF_STATUS='E'");
						else
							sql.append(" and  ISC.EFF_STATUS='E'");  
					}
			   if ( estatus.equals("D") )
					{
					//out.println(sql);
						if ( andCheck == 0 )
							sql.append( " and  ISC.EFF_STATUS='D'");
						else
							sql.append(" and	ISC.EFF_STATUS='D'");
					}
			   if ( estatus.equals("B") )
					{
					//out.println(sql);
					   	// sql = sql; nothing is added to get both E and D
					}
				}

		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
			{
				sql.append( " order by ");

				for ( int i=0;i < ord.length;i++ )
	 				{
				 	    if ( i == ord.length - 1 )
						{
							if(ord[i].equals("facility_name"))
							{
							sql.append( "IC.");
							sql.append(ord[i]);
							}
							else
							{
							sql.append( "ISC.");
							sql.append(ord[i]);
							}
						}
					    else
						{	if(ord[i].equals("facility_name"))
							{
							sql.append( "IC.");
							sql.append(ord[i]);
							sql.append(",");

							}
							else
							{
							sql.append( "ISC.");
							sql.append(ord[i]);
							sql.append(",");
							}
						}
					}
			}
		 //end of where clause IF


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
		Statement stmt=null;
		PreparedStatement pstmt = null;
		//ResultSet rset=null;
		ResultSet rs=null;
		ResultSet rs1 = null;

	//	int maxRecord = 0;
	

    try
    {
		
   	conn = ConnectionManager.getConnection(request);

	stmt = conn.createStatement();
		/*String strsql1="select count(*) as total from (SELECT IC.FACILITY_ID, IC.FACILITY_NAME 	FACILITY_NAME, ISC.FILE_TYPE_CODE, ISC.LONG_DESC FILE_TYPE_LONG_DESC, ISC.SHORT_DESC	FILE_TYPE_SHORT_DESC, ISC.EFF_STATUS EFF_STATUS FROM  SM_FACILITY_PARAM IC,MR_FILE_TYPE ISC WHERE  ISC.FACILITY_ID = IC.FACILITY_ID " + sql.toString() + " )";

		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			*/
		String strsql2="SELECT ic.facility_id,ic.facility_name facility_name,isc.file_type_code, isc.long_desc file_type_long_desc,isc.short_desc file_type_short_desc,isc.eff_status eff_status,isc.appl_to_op,isc.appl_to_ip,isc.appl_to_em,isc.appl_to_dc FROM  sm_facility_param ic, mr_file_type isc WHERE  isc.facility_id = ic.facility_id " + sql.toString();
		pstmt = conn.prepareStatement(strsql2);
		int pstcount=1;
		while ( pstcount<=psthashmap.size()) {
		pstmt.setString(pstcount,(String) psthashmap.get(pstcount));
		pstcount++;
		}
		psthashmap.clear();
	//rs1 = stmt.executeQuery(strsql2);
		rs1 = pstmt.executeQuery();
	
%>



<%
 	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	{
		rs1.next() ;
	}
	String classValue = "" ;
	
	int cnt=0;
	while ( i<=end && rs1.next())
	{
		if(cnt==0)
		{%>
			<p>
			<table align='right'>
			<tr>

			<%
				if ( !(start <= 1) )
					out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/FileTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			%>
			<td align ='right' id='next' style='visibility:hidden'>
			<%
				//if ( !( (start+14) > maxRecord ) )
					out.println("<A HREF='../../eMP/jsp/FileTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
			</tr>
			</table>
			</p>
			<br>
			<br>
				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<td class='columnheader'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.filetype.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>	
				<td class='columnheader'><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.OP.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.IP.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.DC.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMP.EM.label" bundle="${mp_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<%}
	        if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			

		out.println("<tr><td class='" + classValue + "'>");
		String code = rs1.getString("facility_id");
		String sbcode= rs1.getString("file_type_code");
		String shortdesc=rs1.getString("facility_name");		
		
		out.println(code+"</a></td><td class='" + classValue + "'>");
		out.println( rs1.getString("facility_name") );
		out.println("</td><td class='" + classValue + "'>");
		out.println("<a href='../../eMP/jsp/addModifyFileType.jsp?facility_id="+code+"&facility_name="+shortdesc+"&file_type_code="+sbcode+"&source=Modify"+"'target='f_query_add_mod'>");
		out.println(sbcode+"</a></td><td class='" + classValue + "'>");				
		out.println(rs1.getString("file_type_long_desc") );
		out.println("</td><td class='" + classValue + "'>");
		out.println(rs1.getString("file_type_short_desc") );

		out.println("</td><td align='center' class='" + classValue + "'>");
		if (rs1.getString("appl_to_op").equals("Y") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

		out.println("</td><td align='center' class='" + classValue + "'>");
		if (rs1.getString("appl_to_ip").equals("Y") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");		
		
		out.println("</td><td align='center' class='" + classValue + "'>");
		if (rs1.getString("appl_to_dc").equals("Y") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

		out.println("</td><td align='center' class='" + classValue + "'>");
		if (rs1.getString("appl_to_em").equals("Y") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

		out.println("</td><td align='center' class='" + classValue + "'>");
		if ( rs1.getString("EFF_STATUS").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		
		i++;
		cnt++;
  	}//end of while

	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs1.next()) ) {
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
    }// end oftry 

    catch(Exception e)
    {
		//e.toString();
		//out.println("Error:"+e.toString());
		e.printStackTrace();
    }


	finally   
	{
	    if(stmt!=null) 			stmt.close();
	    if(pstmt!=null) 		pstmt.close();
	    if(rs!=null)	 		rs.close();
		if(rs1!=null)	 		rs1.close();
	    if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}

	%>
	</td></tr>
	</table>
	<br><center>
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

