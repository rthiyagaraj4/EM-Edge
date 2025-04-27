<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.net.*,java.text.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eCA/js/ConstructCAMenu_temp.js'></script>


 <HTML><head>	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'  class='CONTENT' >
<%
  
request.setCharacterEncoding("UTF-8");	
    String whereClause = request.getParameter("whereclause");
    StringBuffer sql=new StringBuffer("") ;
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	String mname = "";
	String fname = " ";
	String sql2 = "";


    if ((whereClause == null || whereClause.equals(""))){
	sql.setLength(0);
	sql.append("");
	String dcode = request.getParameter("desktop_code")==null ? "" : request.getParameter("desktop_code");
	String dname = request.getParameter("desktop_name")==null ? "" : request.getParameter("desktop_name");
	String dmodule_id = request.getParameter("module_id")==null ? "" : request.getParameter("module_id");
	String dfun_id = request.getParameter("function_id")==null ? "" : request.getParameter("function_id");
	String estatus = request.getParameter("eff_status");

	int andCheck = 0;

	dcode=dcode.toUpperCase();
	if ( !(dcode == null || dcode.equals("")) )
	{
		sql.setLength(0);
		sql.append("where upper(DESKTOP_SUMMARY_ID) like upper('"+dcode+"%')");
		andCheck = 1;
	}

	if ( !(dname == null || dname.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			
			sql.append(" and upper(DESKTOP_SUMMARY_NAME) like  upper('"+dname+"%')" );
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(DESKTOP_SUMMARY_NAME) like upper('"+dname+"%')" );
			andCheck = 1;
		}
	}

	dmodule_id=dmodule_id.toUpperCase();
	if ( !(dmodule_id == null || dmodule_id.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(DFLT_MODULE_ID) like  upper('"+dmodule_id+"%')" );
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(DFLT_MODULE_ID) like upper('"+dmodule_id+"%')" );
			andCheck = 1;
		}

	}

	if ( !(dfun_id == null || dfun_id.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(DFLT_FUNCTION_ID)  like  upper('"+dfun_id+"%')") ;
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(DFLT_FUNCTION_ID)  like upper('"+dfun_id+"%')" );
			andCheck = 1;
		}
	}

	if ( !(estatus == null || estatus.equals("")) )
	{
	     
	   if ( estatus.equals("E") )
	   {
		if ( andCheck == 0 )
		   {
			sql.setLength(0);
			sql.append("where eff_status='E'");
		   }
		else
		   
			sql.append(" and eff_status='E'");
		   
	   }
	   if ( estatus.equals("D") )
	   {
		if ( andCheck == 0 )
		   {
			sql.setLength(0);
			sql.append(" where  eff_status='D'");
		   }
		else
			sql.append(" and eff_status='D'");
	   }
	   if ( estatus.equals("B") )
	   {
	    }
		if ( andCheck == 0 )
		   {
			sql.setLength(0);
			sql.append(" where  DESKTOP_SUMMARY_ID!='DFLT_CADT'");
		   }
		else
			sql.append(" and DESKTOP_SUMMARY_ID!='DFLT_CADT'");

	}
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	if (!(ord == null || ord .equals(""))){
		sql.append(" order by ");
		for ( int i=0;i < ord.length;i++ ){
	 	    if ( i == ord.length - 1 )
			sql.append(ord[i]);
		    else
			sql.append(ord[i]+",");
		}
	}
    } //end of where clause IF
    else
    {
		sql.setLength(0);
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
		
	Connection conn = null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet rset=null;
	int maxRecord = 0;
    try
    {
    	conn = ConnectionManager.getConnection(request);

	  stmt = conn.createStatement();

			
	
	//String strsql2="select  desktop_code, desktop_name,desktop_layout_type,content_type,module_id,function_id,eff_status from sm_desktop_setup "+sql.toString();
	
	String strsql2="select s.DESKTOP_SUMMARY_ID desktop_code,s.DESKTOP_SUMMARY_NAME desktop_name ,s.DESKTOP_LAYOUT_TYPE desktop_layout_type,s.DFLT_CONTENT_TYPE content_type ,s.DFLT_MODULE_ID module_id,s.DFLT_FUNCTION_ID function_id ,s.EFF_STATUS eff_status from SM_DESKTOP_SUM_HDR s "+sql.toString();

	
	
	if(rs!=null)rs.close();

	rs = stmt.executeQuery(strsql2);

			

	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	{
		rs.next() ;
	}

	
	
	while ( i<=end && rs.next() )
	{
		if(maxRecord==0)
		{
%>

<p>
<table align='right'>
<tr>

<%
if ( !(start <= 1) )
	    out.println("<td align ='right' id='prev'><A HREF='../../eCA/jsp/CreateDesktopQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
		
		<%

	    out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eCA/jsp/CreateDesktopQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>

</tr>
</table>
</p>
<br>
<br>


	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<td class='columnheader'><fmt:message key="eSM.Desktop.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/> </td>
	<td class='columnheader'><fmt:message key="eSM.Desktop.label" bundle="${sm_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/> </td>
	<td class='columnheader'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
	<td class='columnheader'> <fmt:message key="eSM.ContentType.label" bundle="${sm_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

<% }

	String classValue = "" ;
	

	
	        if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			

		

		out.println("<tr><td class='" + classValue + "'>");
		String code = rs.getString("desktop_code");
		String sbcode= rs.getString("module_id");
		String sf_id= rs.getString("function_id")==null?"":rs.getString("function_id");
		String content= rs.getString("content_type");
		String eff_status= rs.getString("eff_status");
		if(content.equals("F"))
		{
       content="Function";
		} else
		{
		}

	
try{						
                    
					  sql2="Select  module_id,module_name from sm_module   where module_id='"+sbcode+"' ";
						pstmt=conn.prepareStatement(sql2);
						rset=pstmt.executeQuery();
						if(rset!=null){
							while(rset.next()){
								mname=rset.getString(2);
									}
								   }
						
					
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();	

						
				}catch(Exception e) { 
					//out.println("desktopcode"+e);//COMMON-ICN-0181
                                          e.printStackTrace();//COMMON-ICN-0181
					}


try{						
                      fname="";
					  sql2="select function_id, function_name from Sm_Function where function_id='"+sf_id+"' ";
						pstmt=conn.prepareStatement(sql2);
						rset=pstmt.executeQuery();
						
						if(rset!=null){
							while(rset.next()){
								fname=rset.getString(2)==null?"":rset.getString(2);
									}
								   }
						
					
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();	

						
				}catch(Exception e) { 
					//out.println("desktopcode"+e);//COMMON-ICN-0181
                                          e.printStackTrace();//COMMON-ICN-0181
					}

					
		out.println("<a href='../../eCA/jsp/ConstructCAMenuMain_temp.jsp?Desktop_code="+ code +"&module_id="+sbcode+"&operation=modify&eff_status="+eff_status+"' target='f_query_add_mod' >");
				


		out.println(code+"</a></td><td class='" + classValue + "'>");
	
		out.println( rs.getString("desktop_name") );

		out.println("</td><td class='" + classValue + "'>");

		out.println (mname);
		
		out.println("</td><td class='" + classValue + "'>");

		out.println( fname);


		out.println("</td><td class='" + classValue + "'>");

		out.println(content);
		
		out.println("</td><td align='center' class='" + classValue + "'>");
		if ( rs.getString("eff_status").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		
		i++;
		maxRecord++;

  	}//end of while
if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
	} // end of try
    catch(Exception e)
    {
	//out.println("in result page :" +e);//COMMON-ICN-0181
          e.printStackTrace();//COMMON-ICN-0181
	}

	finally   
	{
	    if(stmt!=null) 		stmt.close();
	    if(rs!=null)	 		rs.close();
	    ConnectionManager.returnConnection(conn,request);
	}
%>

	</td></tr>
	</table>
	<br>
</BODY>
</HTML>

