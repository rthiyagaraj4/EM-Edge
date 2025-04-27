<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>


<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql= new StringBuffer();
		String med_board_code = request.getParameter("MEDICAL_BOARD_CODE");
		String med_board_type = request.getParameter("MED_BOARD_TYPE_CODE");
		String longdesc = request.getParameter("long_desc");
		String enabled = request.getParameter("nature");
		int andCheck = 0;

		med_board_code=med_board_code.toUpperCase();

		sql.append(" where a.MED_BOARD_TYPE_CODE=b.MED_BOARD_TYPE_CODE ");
		andCheck = 1;
		

		if ( !(med_board_code == null || med_board_code.equals("")) )
				{
				sql.append(" and upper(MEDICAL_BOARD_CODE)  like  upper('"+med_board_code+"%') ");
				andCheck = 1;
				}

			if ( !(longdesc == null || longdesc.equals("")) )
				{
					if ( andCheck == 1 )
					{	sql.append( " and ");
						sql.append(" upper(a.long_desc)  like  upper('"+longdesc+"%') ");
					}
					else
					{
						sql = new StringBuffer();
						sql.append(" where upper(a.long_desc)  like  upper('"+longdesc+"%') ");
						andCheck = 1;
					}
				}

			if ( !(med_board_type == null || med_board_type.equals("")) )
			{
					if ( andCheck == 1 )
					{	sql.append(" and ");
						sql.append(" upper(a.MED_BOARD_TYPE_CODE)  like  upper('"+med_board_type+"%') ");
					}
					else
					{
						sql.append(" where upper(a.MED_BOARD_TYPE_CODE)  like  upper('"+med_board_type+"%') ");
						andCheck = 1;
					}
			}
			

			if ( !(enabled == null || enabled.equals("")) )
			{
			   if ( enabled.equals("E") )
					{
				if ( andCheck == 0 )
				{
					sql = new StringBuffer();
					sql.append(" where a.eff_status='E' ");
				}
				else
					sql.append(" and a.eff_status='E' ");

				}
			   if ( enabled.equals("D") )
				{
				   
				if ( andCheck == 0 ){
					sql = new StringBuffer();
					sql.append("  where  a.eff_status='D' ");
					
					
				}
				else{
					
					sql.append(" and a.eff_status='D' ");
					
				}
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
		sql = new StringBuffer();
		sql.append(whereClause);
	}

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
	Connection conn =null;
	Statement stmt=null;
	//ResultSet rset=null;
	ResultSet rs=null;
	int maxRecord = 0;
//out.println("query------"+sql);
	try{
			conn=ConnectionManager.getConnection(request);
/*stmt = conn.createStatement();
String strsql1="select count(*) as total from MR_MEDICAL_BOARD a, MR_MEDICAL_BOARD_TYPE b  "+sql.toString();

rs = stmt.executeQuery(strsql1);
rs.next();
maxRecord = rs.getInt("total");

if(rs!=null)
	rs.close();
if(stmt!=null)
	stmt.close();

	if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
*/
			String strsql2="select a.MEDICAL_BOARD_CODE, a.long_desc,a.short_desc,a.eff_status, a.MED_BOARD_TYPE_CODE from MR_MEDICAL_BOARD a, MR_MEDICAL_BOARD_TYPE b "+sql.toString();

			stmt = conn.createStatement();
			rs = stmt.executeQuery(strsql2);

			if ( start != 1 )
				for( int j=1; j<start; i++,j++ ){
					 rs.next() ;
					  }
			while ( i<=end && rs.next())
			{
				if (maxRecord==0)
				{

%>
			<P>
			<table align='right'>
			<tr>

			<%
			if ( !(start <= 1) )
				out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/MedicalBoardQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

			//if ( !( (start+14) > maxRecord ) )
				out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/MedicalBoardQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
			%>
			</tr>
			
			</table>
			<br><br>
			</P>

			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<th><fmt:message key="eMR.MedBoardCode.label" bundle="${mr_labels}"/></th>
			<th><fmt:message key="eMR.MedicalBoardType.label" bundle="${mr_labels}"/></th>
			<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
				}
 	/*if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }*/
			String classValue="";
//while ( rs.next() && i<=end )
	//{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			out.println("<tr><td  class='" + classValue + "'>");
			String code = rs.getString("MEDICAL_BOARD_CODE");

			out.println("<a href='../../eMR/jsp/addModifyMedicalBoard.jsp?MED_BOARD_CODE="+ code+"&mode=modify'>");
			out.println(code+"</a></td><td  class='" + classValue + "'>");
			out.println( rs.getString("MED_BOARD_TYPE_CODE") );
			out.println("</td><td  class='" + classValue + "'>");
			out.println( rs.getString("long_desc") );
			out.println("</td><td  class='" + classValue + "'>");
			out.println(rs.getString("short_desc") );
			out.println("</td><td align='center'  class='" + classValue + "'>");

			if ( rs.getString("eff_status").equals("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			i++;
			maxRecord++;
			}//endwhile
%>

</td></tr>
</table>
<br><center>
<%

			if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			if ( maxRecord < 14 || (!rs.next()) )
			{
			%>
				<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='hidden';
				</script>
			<% 
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
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();

%>

</center>
</BODY>
</HTML>
<%
}catch(Exception e){
		out.println("Exception "+e.toString());
}
finally{
		
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

