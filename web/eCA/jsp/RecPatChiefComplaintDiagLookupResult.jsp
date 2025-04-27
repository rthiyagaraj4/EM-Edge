<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
1?             100            		?					?				?				created
22/08/2020	IN073645			Ramesh Goli				22/08/2020		Ramesh G		CA-PMG2020-TECH-CRF-0001/02-Lookup issues
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 

<html>
<head>
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
	td,th,tr
	{border-bottom: 1px solid #d5e2e5;
	}
	.grid
	{
		border-bottom: 1px solid black;
	}
	</style>
<script>
function closewindow(rowNum)
{
	var val = eval("document.forms[0].descVal"+rowNum).value;
	/*Added by Archana on 3/10/2010 at 3:07 PM for IN019870 start*/
	while(val.indexOf("CHIEFDOUBLEQUOTE")!= -1)
	{
	  val = val.replace("CHIEFDOUBLEQUOTE","\"");
	}
	//end
	//alert("val"+val);
	//window.returnValue = val;
	//window.close();
	parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = val;
	parent.parent.document.getElementById('dialog_tag').close();
}
</script>

</head>
<form>
<body onKeyDown='lockKey()'>
<%
    java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	Connection conn = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	
	String searchtext="";
	String code="";
	String desc="";
	String details="";
	String splty_desc="";
	String facility_id="";
	String encounter_id="";
	StringBuffer sql = new StringBuffer();

	String filter_by = request.getParameter("filter_by");
	String filter_desc =  (request.getParameter("filter_desc")==null?"":request.getParameter("filter_desc"));
	String speciality_code =  (request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"));

	boolean filterDesc = true;
		
	int i = 0;

	try
	{
		conn=ConnectionManager.getConnection(request);
		//String querystring=request.getQueryString();		
		facility_id=(String) session.getValue("facility_id");
		encounter_id = (request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"));
		String complaint = (request.getParameter("complaint")==null?"":request.getParameter("complaint"));

		String whereClause = (request.getParameter("whereclause")==null?"":request.getParameter("whereclause"));

		String from = (request.getParameter("from")==null?"":request.getParameter("from"));
		String to = (request.getParameter("to")==null?"":request.getParameter("to"));
		String searchcriteria=(request.getParameter("search_criteria")==null?"":request.getParameter("search_criteria"));
		searchtext =(request.getParameter("searchtext")==null?"":request.getParameter("searchtext"));

		
		if(searchtext == null) searchtext="";




		if ( (whereClause == null || whereClause.equals("")|| whereClause.equals("null")) )
		{

		/*
		sql.append("select COMPLAINT_ID,COMPLAINT_DESC,COMPLAINT_TEXT from CA_CHIEF_COMPLAINT_lang_vw where (SPECIALITY_CODE is null  or SPECIALITY_CODE=(select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?)) and eff_status='E' and language_id = ? ");

		
			sql.append(" and");
			StringBuffer l_where_clause = new StringBuffer();

	//		String searchby=request.getParameter("search_by"); 
			String searchby=(request.getParameter("search_by")==null?"":request.getParameter("search_by")); 
			searchtext=request.getParameter("search_text");			
			String scode = searchtext.toUpperCase();			

			if(searchby.equals("D"))
				l_where_clause.append(" upper(COMPLAINT_DESC) like ");
			else
			{
				l_where_clause.append(" COMPLAINT_ID like ");
				searchtext = scode;
			}

			if(searchcriteria.equals("S"))
			{
				searchtext=searchtext+"%";
				l_where_clause.append("upper(?)");
			}
			else if(searchcriteria.equals("E"))
			{
				searchtext="%"+searchtext;
				l_where_clause.append("upper(?)");
			}
			else if(searchcriteria.equals("C"))
			{
				searchtext="%"+searchtext+"%";
				l_where_clause.append("upper(?)");
			}
			if (searchby.equals("C"))
			{
				sql.append(l_where_clause.toString());
				sql.append(" order by complaint_id ");
			}
			else
			{
				sql.append(l_where_clause.toString());
				sql.append(" order by complaint_desc ");
			}	
			
			

			
		} 
		else
		{
			sql.append(whereClause.toString());
			searchtext =searchtext;
		}

		

		try{
		

		stmt = conn.prepareStatement(sql.toString());
		stmt.setString(1,facility_id);
		stmt.setString(2,encounter_id);
		stmt.setString(3,locale);
		stmt.setString(4,searchtext);*/

		if(filter_by.equals("S") && !filter_desc.equals("") && speciality_code.equals(""))
		{
		    filterDesc = false;
            out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		else if(filter_by.equals("S") && !speciality_code.equals(""))
		{
			sql.append("select COMPLAINT_ID,COMPLAINT_DESC,COMPLAINT_TEXT, am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,?,2) SPLTY_DESC from CA_CHIEF_COMPLAINT_lang_vw where  language_id = ? and eff_status = 'E' and SPECIALITY_CODE = ? ");
		}
		else if(filter_by.equals("S") && speciality_code.equals(""))
		{
			sql.append("select 	COMPLAINT_ID,COMPLAINT_DESC,COMPLAINT_TEXT, am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,?,2) SPLTY_DESC from CA_CHIEF_COMPLAINT_lang_vw where SPECIALITY_CODE is NOT NULL and eff_status = 'E' and language_id = ? ");
		}
		else if(filter_by.equals("N"))
		{
			sql.append("select 	COMPLAINT_ID,COMPLAINT_DESC,COMPLAINT_TEXT, am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,?,2) SPLTY_DESC from CA_CHIEF_COMPLAINT_lang_vw where SPECIALITY_CODE is NULL and eff_status = 'E' and language_id = ? ");
		}
		else
		{
			sql.append("select 	COMPLAINT_ID,COMPLAINT_DESC,COMPLAINT_TEXT, am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,?,2) SPLTY_DESC from CA_CHIEF_COMPLAINT_lang_vw where eff_status = 'E' and language_id = ? ");
		}
		sql.append(" and");
		StringBuffer l_where_clause = new StringBuffer();

//		String searchby=request.getParameter("search_by"); 
		String searchby=(request.getParameter("search_by")==null?"":request.getParameter("search_by")); 
		searchtext=request.getParameter("search_text");			
		String scode = searchtext.toUpperCase();			

		if(searchby.equals("D"))
			l_where_clause.append(" upper(COMPLAINT_DESC) like ");
		else
		{
			l_where_clause.append(" COMPLAINT_ID like ");
			searchtext = scode;
		}

		if(searchcriteria.equals("S"))
		{
			searchtext=searchtext+"%";
			l_where_clause.append("upper(?)");
		}
		else if(searchcriteria.equals("E"))
		{
			searchtext="%"+searchtext;
			l_where_clause.append("upper(?)");
		}
		else if(searchcriteria.equals("C"))
		{
			searchtext="%"+searchtext+"%";
			l_where_clause.append("upper(?)");
		}
		if (searchby.equals("C"))
		{
			sql.append(l_where_clause.toString());
			sql.append(" order by complaint_id ");
		}
		else
		{
			sql.append(l_where_clause.toString());
			sql.append(" order by complaint_desc ");
		}	
}else{
	sql.append(whereClause.toString());
	searchtext =searchtext;
}
int start = 0 ;
int end = 0 ;
int k=0;

if ( from == null || from.equals(""))
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to == null || to.equals(""))
	end = 14 ;
else
	end = Integer.parseInt( to ) ;

if(filterDesc)
{
try
{
stmt = conn.prepareStatement(sql.toString());
stmt.setString(1,locale);
stmt.setString(2,locale);
if(filter_by.equals("S") && !speciality_code.equals(""))
{
  stmt.setString(3,speciality_code);
  stmt.setString(4,searchtext);
}else{
stmt.setString(3,searchtext);
}

rs1=stmt.executeQuery();

while(rs1.next())
{
	k++;

}

if(k == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
//IN073645 Start.
//rs = stmt.executeQuery(sql.toString());
rs = stmt.executeQuery();
//IN073645 End.
%>
<DIV STYLE="overflow: auto; width: 100%; height: 100%;              
            padding:0px; margin: 0px">

<table  width="100%" cellspacing='0' cellpadding='3' align='center' width="100%" >
<tr>
<td colspan=4 bgcolor='#FFFFFF' align='right'>
<%	
if ( !(start <= 1) )
	out.println("<A HREF='../../eCA/jsp/RecPatChiefComplaintDiagLookupResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"&searchtext="+URLEncoder.encode(searchtext)+"&filter_by="+filter_by+"&filter_desc="+filter_desc+"&speciality_code="+speciality_code+"' text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > k ) )
	out.println("<A HREF='../../eCA/jsp/RecPatChiefComplaintDiagLookupResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"&searchtext="+URLEncoder.encode(searchtext)+"&filter_by="+filter_by+"&filter_desc="+filter_desc+"&speciality_code="+speciality_code+"' text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>

</td>
</tr>
</table> 
 <table  class='grid' id='tb1' align='center' width='100%'>
  <tr>
	<th class='columnheadercenter' width='20%' align='left'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th class='columnheadercenter' width='30%' align='left'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th class='columnheadercenter' width='30%' align='left'><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
		
<%
if(filter_desc.equals("") && filter_by.equals("S") || filter_by.equals("A"))
{%>
	<th class='columnheadercenter' width='30%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
	</tr>
<%} 
  else
      {%>
</tr>
<%}
if(rs != null)
{
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rs.next() ;

	while(rs.next() && i<=end)
	{

	String rowclass = "" ;
	String retValue="";
	String desc1 ="";
	//String details1 ="";
	//String d="/";
		if ( i % 2 == 0 )
			rowclass = "gridData" ;
		else
			rowclass = "gridData" ;
	   code		=  rs.getString(1);
	   desc		=  rs.getString(2);
	   details	=  rs.getString(3);
	   splty_desc	=  rs.getString(4);
       /*Added by Archana on 3/10/2010 at 3:07 PM for IN019870  start*/
	      desc1 = desc.replaceAll("\"", "CHIEFDOUBLEQUOTE");
	   /*end*/
	   if (splty_desc == null)
		{
		   splty_desc = "&nbsp;";
		}
		
	   //retValue = code + "`" + desc + "`" +details; //Commented 
	   /*Modified by Archana on 3/10/2010 at 3:07 PM for IN019870*/
	   retValue = code + "`" + desc1 + "`" +details;  //+"#"+splty_desc;
	   
	   out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");
	   out.println("<a    href=\"javascript:closewindow('"+i+"')\" class='gridLink'>");
	   out.println(code+"</a></td><td  class='"+rowclass+"'>");
	   out.println(desc+"</td><td  class='"+rowclass+"'>");
	   out.println(details+"</td>");
	   if(filter_desc.equals("") && filter_by.equals("S") || filter_by.equals("A"))
	   {
           out.println("<td  class='"+rowclass+"'>"+splty_desc+"</td></tr>" );         
	   }
	   else
	   {
          out.println("</tr>" );
	   }%>
	  <input type='hidden' name='descVal<%=i%>' id='descVal<%=i%>' value="<%=retValue%>">
	<%i++;
	}
}

}
catch(Exception e) 
{
	e.printStackTrace();
	//out.println(e.toString());//COMMON-ICN-0181
}
finally
{
	if (stmt != null) stmt.close();
	if (rs != null) rs.close();
	if (rs1 != null) rs1.close();
}
}
%>
</table>
<input type='hidden' name='searchtext' id='searchtext' value="<%=searchtext%>" > 
<input type='hidden' name='complaint' id='complaint' value="<%=(complaint==null)?"":complaint%>" > 

</BODY>
</form>
</html>
<%
}
catch(Exception e) 
{
		e.printStackTrace();
		//out.println(e.toString());//COMMON-ICN-0181
}
	finally
	{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}	

%>

