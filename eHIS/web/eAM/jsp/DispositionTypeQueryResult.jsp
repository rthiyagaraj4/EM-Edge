<!DOCTYPE html>
<%
/*
*
*	Application		:	eAM
*   File Name       :	DispositionTypeQueryResult.jsp
*	
*
*	Created On		:	19-02-2005
*/
%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,eCommon.Common.*" 
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<%
	out.println("<HTML><head>	<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >");
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();	
	//String sql ;
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;
	//sql="";

	if ( (whereClause == null || whereClause.equals("")) )
	{
		//sql="";

		String disp_type    = request.getParameter("disp_type")==null ?"":request.getParameter("disp_type");
		String short_desc    = request.getParameter("short_desc")==null ?"":request.getParameter("short_desc");
		String deceased_yn    = request.getParameter("deceased_yn")==null ?"":request.getParameter("deceased_yn");
		String absconded_yn    = request.getParameter("absconded_indicator")==null ?"":request.getParameter("absconded_indicator");  //Added by Sangeetha for ML-MMOH-CRF-0630
		String callnotaround_yn    = request.getParameter("callnotaround_yn")==null ?"":request.getParameter("callnotaround_yn"); //Added by Mano aganist ML-MMOH-CRF-0783
		String useconclatyn    = request.getParameter("use_at_concl_yn")==null ?"":request.getParameter("use_at_concl_yn");
		String usedischatyn    = request.getParameter("use_at_disch_yn")==null ?"":request.getParameter("use_at_disch_yn");
		String enabled    = request.getParameter("eff_status")==null ?"":request.getParameter("eff_status");
		//String facilityid=(String)session.getValue("facility_id");


	int andCheck 		= 0;
	if(disp_type!= null)
		disp_type		=disp_type.toUpperCase();


	if ( !(disp_type == null || disp_type.equals("")) )
	{
		sbQuery.append("where upper(disp_type) like upper('"+disp_type+"%')");
		//sql = "where upper(disp_type) like upper('"+disp_type+"%')";
		andCheck = 1;
	}

	if ( !(short_desc == null || short_desc.equals("")) )
		{
			if ( andCheck == 1 )

			{	
				sbQuery.append(" and ");
				//sql = sql + " and ";
				sbQuery.append(" upper(long_desc)  like  upper('"+short_desc+"%') ");
				//sql = sql + " upper(long_desc)  like  upper('"+short_desc+"%') " ;
			}
			else
			{
				sbQuery.setLength(0);
				sbQuery.append("where upper(long_desc)  like upper('"+short_desc+"%') ");
			//	sql = "where upper(long_desc)  like upper('"+short_desc+"%') " ;
				andCheck = 1;
			}
	}

	if ( !(deceased_yn == null || deceased_yn.equals("")) )
	{
	   if ( deceased_yn.equals("Y") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append("where deceased_yn='Y'");
		//	sql = "where deceased_yn='Y'";
			andCheck = 1;
		}
		else
			sbQuery.append( " and deceased_yn='Y'");
		//	sql = sql + " and deceased_yn='Y'";
	   }
	   if ( deceased_yn.equals("N") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append( " where  deceased_yn='N'");
			//sql = " where  deceased_yn='N'";
			andCheck = 1;
		}
		else
			sbQuery.append(	" and deceased_yn='N'");
			//sql = sql + " and deceased_yn='N'";
	   }
	}

	//Added by Sangeetha for ML-MMOH-CRF-0630
	if ( !(absconded_yn == null || absconded_yn.equals("")) )
	{
	   if ( absconded_yn.equals("Y") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append("where absconded_yn='Y'");
			andCheck = 1;
		}
		else
			sbQuery.append( " and absconded_yn='Y'");
	   }
	   if ( absconded_yn.equals("N") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append( " where  absconded_yn='N'");
			andCheck = 1;
		}
		else
			sbQuery.append(	" and absconded_yn='N'");
	   }
	}
	
	//Added by Mano for ML-MMOH-CRF-0783
	if ( !(callnotaround_yn == null || callnotaround_yn.equals("")) )
	{
	   if ( callnotaround_yn.equals("Y") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append("where callnotaround_yn='Y'");
			andCheck = 1;
		}
		else
			sbQuery.append( " and callnotaround_yn='Y'");
	   }
	   if ( callnotaround_yn.equals("N") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append( " where  callnotaround_yn='N'");
			andCheck = 1;
		}
		else
			sbQuery.append(	" and callnotaround_yn='N'");
	   }
	}

	if ( !(useconclatyn == null || useconclatyn.equals("")) )
	{
	   if ( useconclatyn.equals("Y") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append("where use_at_concl_yn='Y'");
			//sql = "where use_at_concl_yn='Y'";
			andCheck = 1;
		}
		else
			sbQuery.append(" and use_at_concl_yn='Y'");
			//sql = sql + " and use_at_concl_yn='Y'";
	   }
	   if ( useconclatyn.equals("N") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append(" where  use_at_concl_yn='N'");
			//sql = " where  use_at_concl_yn='N'";
			andCheck = 1;
		}
		else
			sbQuery.append("and use_at_concl_yn='N'");
			//sql = sql + " and use_at_concl_yn='N'";
	   }
	}

	if ( !(usedischatyn == null || usedischatyn.equals("")) )
	{
	   if ( usedischatyn.equals("Y") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append("where use_at_disch_yn='Y'");
			//sql = "where use_at_disch_yn='Y'";
			andCheck = 1;
		}
		else
			sbQuery.append( " and use_at_disch_yn='Y'");
			//sql = sql + " and use_at_disch_yn='Y'";
	   }
	   if ( usedischatyn.equals("N") )
	   {
		if ( andCheck == 0 )
		{
			sbQuery.setLength(0);
			sbQuery.append(" where  use_at_disch_yn='N'");
			//sql = " where  use_at_disch_yn='N'";
			andCheck = 1;
		}
		else
			sbQuery.append(" and use_at_disch_yn='N'");
			//sql = sql + " and use_at_disch_yn='N'";
	   }
	}
	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	   {
		if ( andCheck == 0 )
		   {sbQuery.setLength(0);
			sbQuery.append("where eff_status='E'");}
			//sql = "where eff_status='E'";
		else
		   {sbQuery.append("and eff_status='E'");}
			//sql = sql + " and eff_status='E'";
	   }
	   if ( enabled.equals("D") )
	   {
		if ( andCheck == 0 )
		   {sbQuery.setLength(0);
			sbQuery.append("where  eff_status='D'");}
			//sql = " where  eff_status='D'";
		else
		   {sbQuery.append("and eff_status='D'");}
			//sql = sql + " and eff_status='D'";
	   }
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord.equals("")) )
	{
		sbQuery.append(" order by ");
		//sql=sql+" order by ";

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
			//sql=sql+ord[i];
		else
			sbQuery.append(ord[i]+",");
			//sql=sql+ord[i]+",";
		}
	}
	} //end of where clause IF

	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
		//sql = whereClause;

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
Connection conn = null;
conn = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
Boolean isDidCallNotAroundDgnNotAppl;

try{

isDidCallNotAroundDgnNotAppl = CommonBean.isSiteSpecific(conn, "AE", "DID_CALLNOTAROUND_NOT_REQ_DGN");

String strsql2="select * from am_disposition_type "+sbQuery.toString();
stmt = conn.createStatement();
if(rs!=null)rs.close();
rs = stmt.executeQuery(strsql2);

	 if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	  while ( i<=end && rs.next() )
	{
		  if(maxRecord==0)
		{

%>

<P>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/DispositionTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/DispositionTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
</P>
<br><br>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>

<th><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eAM.DeceasedIndicator.label" bundle="${am_labels}"/></th>
<th><fmt:message key="eAM.AbscondedIndicator.label" bundle="${am_labels}"/></th>   <!-- Added by Sangeetha for ML-MMOH-CRF-0630-->
<%if(isDidCallNotAroundDgnNotAppl){%>
<th><fmt:message key="eAM.CallNotAroundIndicator.label" bundle="${am_labels}"/></th> <!--Added by Mano aganist ML-MMOH-CRF-0783-->
<%}%>
<th><fmt:message key="eAM.UseatVisitConclusion.label" bundle="${am_labels}"/></th>
<th><fmt:message key="eAM.UseforMaternalDeath.label" bundle="${am_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
 
	  String classValue = "" ;
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
		  


	out.println("<tr><td class='" + classValue + "'>");
	String disp_type = rs.getString("disp_type");
	String long_desc = rs.getString("long_desc");
	String short_desc = rs.getString("short_desc");

	out.println("<a href='../../eAM/jsp/AddModifyDispositionType.jsp?disp_type="+disp_type+"' target='f_query_add_mod' >");
	out.println(disp_type+"</a></td><td class='" + classValue + "'>");
	//out.println("<a href='../../eAM/jsp/AddModifyDispositionType.jsp?disp_type="+disp_type+"' target='f_query_add_mod' >");
	out.println(long_desc+"</td><td class='" + classValue + "'>");
	//out.println("<a href='../../eAM/jsp/AddModifyDispositionType.jsp?disp_type="+disp_type+"' target='f_query_add_mod' >");
	out.println(short_desc+"</td class='" + classValue + "'>");

	out.println("<td align='center' class='" + classValue + "'>");

	if ( rs.getString("deceased_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

	out.println("<td align='center' class='" + classValue + "'>");

	//Added by Sangeetha for ML-MMOH-CRF-0630
	if ( rs.getString("absconded_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>"); 

	
	out.println("<td align='center' class='" + classValue + "'>");
	
	//Added by Mano aganist ML-MMOH-CRF-0783
	if(isDidCallNotAroundDgnNotAppl)
	{
	if ( rs.getString("callnotaround_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>"); 

	
	out.println("<td align='center' class='" + classValue + "'>");
	}
	if ( rs.getString("use_at_concl_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

	out.println("<td align='center' class='" + classValue + "'>");


	if ( rs.getString("use_at_disch_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

	out.println("<td align='center' class='" + classValue + "'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
  }//endwhile

  if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}


  if(rs!=null) rs.close();
  if (stmt != null) stmt.close();
}catch(Exception e){
		e.toString();out.println(e);
}
	finally   {
		
		ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>

<!--%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/DispositionTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/DispositionTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/next.gif' alt='Next' border='0'></A>");
rs.close();
%-->

</center>
</BODY>
</HTML>

