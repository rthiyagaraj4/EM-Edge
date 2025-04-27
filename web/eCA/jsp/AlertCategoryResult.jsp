<!DOCTYPE html>
<%--Author  Arvind Singh Pal Created on 4/9/2009 --%>

<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name ='AlertCategoryResultForm'>

<%
	Connection con			=	null ;
	String whereClause		=	"";
	String alert_categ_code ="";
	String alert_categ_desc ="";
	String mode ="";	
	StringBuffer sql = new  StringBuffer();
	PreparedStatement pstmt=null,pstmt1=null;
	int maxRecord =	 0;
	ResultSet rset=null;
	ResultSet rs = null;

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
	

	try	{
			mode="modify";
			whereClause= request.getParameter("whereclause");
			if(whereClause==null) whereClause="";

			String from = request.getParameter( "from" ) ;
		    String to = request.getParameter( "to" ) ;

			alert_categ_code=request.getParameter("alert_categ_code");
			if( alert_categ_code == null)
				alert_categ_code = "";
			
			alert_categ_desc=request.getParameter("alert_categ_desc");
			if( alert_categ_desc == null)
				alert_categ_desc = "";		



if ( (whereClause == null || whereClause.equals("null") || whereClause.equals("") ) )
{
		int cnt=0;
		if( !(alert_categ_code == null || alert_categ_code.equals("null") || alert_categ_code.equals("") ) )
		{
		    sql.append(" where upper(alert_categ_code) like upper('"+alert_categ_code+"%') ");
			cnt++;
		}

		if( !(alert_categ_desc == null  || alert_categ_desc.equals("null") || alert_categ_desc.equals("")) )
		{
			if(cnt>0)
			{
				sql.append( "and upper(alert_categ_desc) like upper('"+alert_categ_desc+"%')");
			}
			else
			{ sql=new StringBuffer();
				sql.append(" where upper(alert_categ_desc) like  upper('"+alert_categ_desc+"%')");
				cnt = 1;
			}
		}
	

		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null  || ord .equals("null") || ord .equals("")) )
		{
				sql.append(" order by ");
				for ( int i=0;i < ord.length;i++ )
				{
					if ( i == ord.length - 1 )
					{
						sql.append(ord[i]);
					}
					else
					{
						sql.append(ord[i]+",");
					}
				}			
		}//if ord

}// if of where clause

else
		{	
			sql=new StringBuffer();
			sql.append(whereClause);
		}

int start = 0 ;
    int end = 0 ;
    int i=1;

		if ( from == null)
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

	    if ( to == null)
		    end = pageCnt ;
		else
			end = Integer.parseInt( to ) ;	

	con  = ConnectionManager.getConnection(request);
	
	try
	{	// stmt = con.createStatement();	

	   
		String strsql= "select count(*) as total from CA_ALERT_CATEG"+sql.toString();
		pstmt=con.prepareStatement(strsql);
		
		String strsqll="select a.alert_categ_code,a.alert_categ_desc  from CA_ALERT_CATEG a ";
		//out.println("sql "+strsqll+sql);		
	
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		
		
		if(maxRecord == 0)
		{
			//out.println("<script>alert('NO RECORD FOUND FOR CRITERIA');history.go(-2);</script>");

			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		pstmt1=con.prepareStatement(strsqll+sql.toString());
		rset =pstmt1.executeQuery();
    }
	

	catch (Exception e)
	{
		//out.println("Exception :"+e.getMessage());//common-icn-181
		e.printStackTrace();//COMMON-ICN-0181
	}

%>

<!-- <modified by Arvind  90 to 100 @10-12-08> -->
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>

<tr>
<td class='white' width='65%' ></td> 
<td  align='right' width='15%' nowrap>

<%
if ( !(start <= 1) )
    out.println("<A class='gridLink' HREF='../../eCA/jsp/AlertCategoryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/AlertCategoryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
%>
</td></tr>
</table>

<table class='grid' border='1' width='100%' cellpadding='3' cellspacing='0' align='center' >
	
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.AlertCategoryCode.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.AlertCategoryDescription.label" bundle="${ca_labels}"/></td>
	

	<%
	if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
      {
          if ( i % 2 == 0 )
            classValue = "gridData" ;
            else
            classValue = "gridData" ;
		
	alert_categ_code	=(rset.getString(1)==null)?"":rset.getString(1);
	alert_categ_desc=(rset.getString(2)==null)?"":rset.getString(2); 
  
	//out.println("eff_status...."+eff_status);

	out.println("<tr><td class='" + classValue + "'>");
	out.println("<a class='gridLink' href='../../eCA/jsp/AlertCategAddModify.jsp?mode="+mode+"&alert_categ_code="+alert_categ_code+"' target='f_query_add_mod'>");    
    out.println(alert_categ_code+"</a></td>");

	out.println("<td class='" + classValue + "'>"+alert_categ_desc+"</td>");

	out.println("</tr>");

	i++;
	  }
%>


</table>

<%

	if( rs!=null) rs.close();
	if( rset!=null) rset.close();
	if (pstmt!=null)pstmt.close();
	if (pstmt1!=null) pstmt1.close();
}//end of 1st try block

	catch (Exception e)
	{
		//out.println("Exception :"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{	
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

</form>
</body>
</html>

