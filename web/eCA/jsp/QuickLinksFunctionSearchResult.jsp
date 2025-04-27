<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
20/01/2017		IN061898	Raja S			23/01/2017		Ramesh G			ML-MMOH-CRF-0550
15/03/2017		IN051294	Krishna Gowtham J									MO-CRF-20087
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
15/09/2020		IN074045	Ramesh Goli		15/09/2020		Ramesh G			CA-PMG2020-TECH-CRF-0001/06	
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*,java.net.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />



<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown='lockKey()'>
<form name='gen_srch_result' id='gen_srch_result'>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String code="";
	String desc="";
%>
<script>
	function closew(position)
	 {
		
		var Dcode=eval('document.forms[0].desc'+position).value;
		while(Dcode.indexOf("+")!=-1)
		{
			Dcode=Dcode.replace('+'," ");
		}
		window.parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = Dcode ;
		window.parent.parent.document.getElementById('dialog_tag').close() ;

	 }
</script>

<%
	Connection conn=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	int i=1;

try
{
	conn = ConnectionManager.getConnection(request);

	String from				= request.getParameter( "from" ) ;
	String to				= request.getParameter( "to" ) ;
	String searchcriteria	= request.getParameter("search_criteria") == null ? "" : request.getParameter("search_criteria");
	String searchby			= request.getParameter("search_by") == null ? "" : request.getParameter("search_by"); 
	String module_id		= request.getParameter("module_id") == null ? "" : request.getParameter("module_id"); 
	String searchtext		= request.getParameter("search_text") == null ? "" : request.getParameter("search_text");
	String ql_type		= request.getParameter("ql_type") == null ? "" : request.getParameter("ql_type");
	String scode			= searchtext.toUpperCase();
	StringBuffer sql		= new StringBuffer();	

	if(ql_type.equals("AM")){
		sql.append("select ADPT_FUNCTION_REF code, ADPT_FUNCTION_NAME description from SM_QUICK_LINK_ADPT_MNU where SOURCE_FUNCTION_YN='Y' AND ");
		
		if(searchby.equals("D"))
		{
			sql.append(" upper(ADPT_FUNCTION_NAME) like ");
			}
			else
			{
					sql.append("upper(ADPT_FUNCTION_REF) like ");
					searchtext = scode;
			}

			if(searchcriteria.equals("S"))
			{
					searchtext=searchtext+"%";
					sql.append("upper(?)");
			}
			else if(searchcriteria.equals("E"))
			{
				searchtext="%"+searchtext;
				sql.append("upper(?)");
			}
			else if(searchcriteria.equals("C"))
			{
				searchtext="%"+searchtext+"%";
				sql.append("upper(?)");
			}

			if (searchby.equals("C"))
				sql.append(" order by ADPT_FUNCTION_REF") ;
			else{
			sql.append(" order by ADPT_FUNCTION_NAME") ;			
			}
			
		//sql.append(" order by ADPT_FUNCTION_NAME") ;
	}
	else{
	sql.append("select OPTION_ID , SYS_OPTION_DESC from SM_QUICK_LINK_OPTION where SM_MODULE_ID = ? and ");
	
	if(ql_type.equals("QF"))
		//sql.append(" OPTION_ID='FLOW_SHEET' and ");
		//sql.append(" OPTION_ID in('FLOW_SHEET','CLINICAL_NOTES','DISCHARGE_SUMMARY','REFERRAL_LETTER','MEDICAL_CERTFICATE','PREVIOUS_NOTES','BY_LOCATION' ) and "); Commented for IN061898
		//sql.append(" OPTION_ID in('FLOW_SHEET','CLINICAL_NOTES','DISCHARGE_SUMMARY','REFERRAL_LETTER','MEDICAL_CERTFICATE','PREVIOUS_NOTES','BY_LOCATION','CA_TASK_LIST' ) and "); //Added tasklist for IN061898
		//IN051294 Start
		//sql.append(" OPTION_ID in('FLOW_SHEET','CLINICAL_NOTES','DISCHARGE_SUMMARY','REFERRAL_LETTER','MEDICAL_CERTFICATE','PREVIOUS_NOTES','BY_LOCATION','CA_TASK_LIST','PHYSICIAN_NOTES' ) and ");
		sql.append(" OPTION_ID in('FLOW_SHEET','CLINICAL_NOTES','DISCHARGE_SUMMARY','REFERRAL_LETTER','MEDICAL_CERTFICATE','PREVIOUS_NOTES','BY_LOCATION','CA_TASK_LIST','PHYSICIAN_NOTES','FLOW_SHEET_NEW' ) and ");//IN069654
		//IN051294 Ends
	if(ql_type.equals("AF"))		
		sql.append(" OPTION_ID !='PREVIOUS_NOTES' and ");

	if(searchby.equals("D"))
	{
		sql.append(" upper(SYS_OPTION_DESC) like ");
	}
	else
	{
		sql.append(" upper(OPTION_ID) like ");
		searchtext = scode;
	}

	if(searchcriteria.equals("S"))
	{
		searchtext=searchtext+"%";
		sql.append("upper(?)");
	}
	else if(searchcriteria.equals("E"))
	{
		searchtext="%"+searchtext;
		sql.append("upper(?)");
	}
	else if(searchcriteria.equals("C"))
	{
		searchtext="%"+searchtext+"%";
		sql.append("upper(?)");
	}

	if (searchby.equals("C"))
		sql.append(" order by OPTION_ID") ;
	else
		sql.append(" order by SYS_OPTION_DESC") ;
	}
	

	int start = 0 ;
	int end = 0 ;
	int k = 0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
	
	try
	{
		
		stmt = conn.prepareStatement(sql.toString());
		if(ql_type.equals("AM")){
		stmt.setString(1,searchtext);
		}
		else{
		stmt.setString(1,module_id);
		stmt.setString(2,searchtext);
		}
		
		rs1=stmt.executeQuery();
		while(rs1.next())
		{
			k++;

		}		

		if(k == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.location.href='../../eCommon/html/blank.html'</script>");
		// IN074045 Start.
		//rs = stmt.executeQuery(sql.toString());	
		if (stmt != null) stmt.close();
		if (rs1 != null) rs1.close();
		
		stmt = conn.prepareStatement(sql.toString());		
		if(ql_type.equals("AM")){
			stmt.setString(1,searchtext);
		}
		else{
			stmt.setString(1,module_id);
			stmt.setString(2,searchtext);
		}
		rs = stmt.executeQuery();	
		// IN074045  End.
%>

<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A  class='gridLink' HREF='../../eCA/jsp/QuickLinksFunctionSearchResult.jsp?from="+(start-14)+"&to="+(end-14)+"&search_text="+URLEncoder.encode(searchtext)+"&module_id="+module_id+"&search_criteria="+searchcriteria+"&ql_type="+ql_type+"&search_by="+searchby+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > k ) )
	out.println("<A class='gridLink'  HREF='../../eCA/jsp/QuickLinksFunctionSearchResult.jsp?from="+(start+14)+"&to="+(end+14)+"&search_text="+URLEncoder.encode(searchtext)+"&module_id="+module_id+"&search_criteria="+searchcriteria+"&ql_type="+ql_type+"&search_by="+searchby+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<BR><BR>
</P>

	<table  width="100%" class='grid' id='tb1'>
	
	<th width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th width='80%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>

	<%
if(rs != null)
{
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rs.next() ;

	while(rs.next() && i<=end)
	{
%>
<%
	//String rowclass = "" ;
	String rowclass = "gridData" ;
	String me="";
		/*if ( i % 2 == 0 )
			rowclass = "QRYEVEN" ;
		else
			rowclass = "QRYODD" ;*/
	   code=rs.getString(1);
	   desc=rs.getString(2);
	    out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");
		
		me=desc+"::"+code;
%>
	<input type='hidden' name="desc<%=i%>" id="desc<%=i%>" value="<%=me%>">
<%
		out.println("<a class='gridLink' href=\"javascript:closew('"+i+"')\">");
		out.println(code+"</a></td><td  class='"+rowclass+"'>");
		out.println( desc+"</td></tr>" );
		
		i++;	  
	 }
  } 
}catch(Exception e) { 
//	out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
	finally
	{
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
	}
%>
</table>
<input type='hidden' name='searchtext' id='searchtext' value="<%=searchtext%>" > 
</form>
</BODY>
</html>
<%
}catch(Exception e) {
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
	finally
	{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}	

%>

