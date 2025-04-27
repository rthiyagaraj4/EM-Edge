<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
 <script>
	function Modify(obj)
	{	
		var doctype=obj.innerText;

		//parent.document.getElementById("mainFrame").rows="8%,*%,50%,10%";

		parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.document.getElementById("f_query_add_mod").style.height="32vh";
		parent.document.getElementById("f_query_add_modcr").style.height="50vh";
		parent.document.getElementById("messageFrame").style.height="10vh";
		parent.f_query_add_mod.location.href = "../../eSM/jsp/addModifyDocumentType.jsp?operation=modify&DOC_TYPE_CODE="+doctype;
		parent.f_query_add_modcr.location.href = "../../eSM/jsp/addModifyDocTypeModule.jsp?DOC_TYPE_CODE="+doctype;
	}
	</script> 



<HTML><head>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
</head><BODY class='CONTENT'  onKeyDown = 'lockKey()'; OnMouseDown='CodeArrest()'>
<%
	
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql =new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
    String cd="";
	String ccd="";
	String longd="";
	String shortd="";
	String entity="";
	String startdocnum="";
	String nextdoctype="";
	String auto="";
	int cnt = 0;
		
		
		Connection conn=null;
		
		
		
		
		try
		{
			conn = ConnectionManager.getConnection(request);
		Statement stmt =conn.createStatement();
		ResultSet rs = null;

		if ( (whereClause == null || whereClause.equals("")) )
	{
		cd = request.getParameter("basedon");
	    ccd = request.getParameter("doctype");
		longd = request.getParameter("longdescription");
		 shortd = request.getParameter("shortdescription");
		 entity = request.getParameter("entitymode");
		 startdocnum = request.getParameter("startdocnum")==null?"":request.getParameter("startdocnum");
		 nextdoctype = request.getParameter("nextdoctype")==null?"":request.getParameter("nextdoctype");
		 auto = request.getParameter("auto");
	
            

			
			//String endOfRes="1";
 
			if ( !(cd == null || cd.equals("")) )
			{
				if( cd.equals("E") )
				{
	   				sql.append(" and A.ENTITY_OR_FACILITY_BASED='E'");
				}
				else if ( cd.equals("F") )
				{
	     	         sql.append(" and A.ENTITY_OR_FACILITY_BASED='F'");
				}
			}

				if ( !((ccd == null) || ccd.equals("")) )
				{
					sql.append(" and upper(A.DOC_TYPE_CODE) like upper('"+ccd+"%')");
				}

				if ( !(longd == null || longd.equals("")) )
				{
					sql.append(" and upper(LONG_DESC)  like  upper('"+longd+"%') " );
				}
	
				if ( !(shortd == null || shortd.equals("")) )
				{
					sql.append(" and upper(SHORT_DESC) like  upper('"+shortd+"%')");
				}
				 if ( !(startdocnum == null || startdocnum.equals("")) )
				{
					sql.append(" and upper(startdocnum) like  upper('"+startdocnum+"%')");
				} 
				if ( !(nextdoctype == null || nextdoctype.equals("")) )
				{
					sql.append(" and upper(nextdoctype) like  upper('"+nextdoctype+"%')");
				} 
				if ( !(auto == null || auto.equals("")) )
				{
					sql.append(" and upper(autoprint) like  upper('"+auto +"%')");
				} 
				if ( !(entity == null || entity.equals("")) )
			{
				if( entity.equals("B") )
				{
	   				sql.append(" and  DOC_ENTRY_MODE='B'");
				}
				if ( entity.equals("O") )
				{
	     	         sql.append(" and  DOC_ENTRY_MODE='O'");
				}

	

				
			}

	
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
			}
			else
			{	
				if(sql.length() > 0) sql.delete(0,sql.length());
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
			
		 

try
			{

String exesql = ("SELECT a.ENTITY_OR_FACILITY_BASED, a.DOC_TYPE_CODE, a.LONG_DESC, a.SHORT_DESC, B.DOC_NUM_GEN_FLAG, B.START_DOC_NO,B.NEXT_DOC_NO, B.DOC_PRINT_FLAG, B.DOC_ENTRY_MODE FROM SY_DOC_TYPE_MASTER A,SY_ACC_ENTITY_DOC_TYPE B WHERE A.DOC_TYPE_CODE=B.DOC_TYPE_CODE "+sql.toString());

rs = stmt.executeQuery(exesql); 
	 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  String classValue = "" ;

	  
while ( i<=end && rs.next()){
	if(cnt==0){

%>
<p>
<table align='right'>



<tr>
							<%
								if ( !(start <= 1) )
									out.println("<td align ='right' id='prev'><A HREF='../../eSM/jsp/DocumentTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
							
									out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eSM/jsp/DocumentTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
							%>
						</tr>
</table>
<br><br>

<center>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
 <th><fmt:message key="Common.Basedon.label" bundle="${common_labels}"/></th> 
<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
 

<%}

	if ( i % 2 == 0 )
	  	classValue = "QRYEVEN" ;
	  else
	  	classValue = "QRYODD" ;
%>

	<tr><td class='<%=classValue%>'>
	<%
	String efb = rs.getString("ENTITY_OR_FACILITY_BASED");
	String doc = rs.getString("DOC_TYPE_CODE");
	if(efb.equals("E"))
	{%>
		<fmt:message key="eSM.AcctEntity.label" bundle="${common_labels}"/>
	<%}
	else if(efb.equals("F"))   
	{%>
		<fmt:message key="Common.facility.label" bundle="${common_labels}"/>	
	<%
		}	
	%> 	
	</td>
	<td class="<%=classValue%>" onClick="Modify(this);" onmouseover="changeCursor(this);"><font class='HYPERLINK'><%=doc%></font></td>
	
	<td class='<%=classValue%>'>
	<%=rs.getString("LONG_DESC")%>
	</td><td class='<%=classValue%>'>
	<%=rs.getString("SHORT_DESC")%>
	</td>
	
 
	<%

	i++;
	cnt++;
}


if( cnt == 0 )
	{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	}



		boolean flag = false;
		if ( cnt < 14 || (!rs.next()) )
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<%
			}
					if(stmt!=null) 	stmt.close();
			        if(rs!=null) 		rs.close();
						%>
		</table>
		</center>
		<%
					}
			catch(Exception e)
			{
				out.println(e.toString());
			}
						if(rs!=null) 	rs.close();
						if(stmt!=null) 	stmt.close();
		}catch(Exception e)
		{
			out.println(e.toString());
		}
		finally   
		{
			
			ConnectionManager.returnConnection(conn,request);
		}
%>			
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>
	</BODY>
</HTML>

