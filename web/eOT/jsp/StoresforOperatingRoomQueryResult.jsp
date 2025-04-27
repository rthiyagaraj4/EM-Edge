<!DOCTYPE html>
 <%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eOT/js/StoresforOperatingRoom.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%	try{
    String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
    String operating_room_code =request.getParameter("operating_room_code")==null?"":request.getParameter("operating_room_code" );
	String facility_name = request.getParameter("facility_name")==null?"":request.getParameter("facility_name");
	String store_desc = request.getParameter("store_desc")==null?"":request.getParameter("store_desc");
	String type_desc = request.getParameter("type_desc")==null?"":request.getParameter("type_desc");
	String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
	String sql="";
    //String speciality_desc="";
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=1;
	
	if ( !(operating_room_code == null || operating_room_code.equals("")) )
		{
			sql+= "AND  D.OPER_ROOM_CODE = '"+operating_room_code+"' ";
			//andCheck = 1;
			cnt++;
		}
	if ( !(facility_name == null || facility_name.equals("")) )
		{
		if(cnt>0)
			sql+= "AND  upper(D.STORE_FACILITY_ID) like upper('"+facility_name+"%')";
			//andCheck = 1;
			else{
				sql=sql+" AND upper(D.STORE_FACILITY_ID) like upper('"+facility_name+"%')";
				cnt=1;

		}
	} 
	 	
	if ( !(store_desc == null || store_desc.equals("")) )
		{
			if(cnt>0)
			sql+= "AND  upper(D.STORE_CODE) like upper('%"+store_desc+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" AND upper(D.STORE_CODE) like upper('%"+store_desc+"%')";
				cnt=1;
			}
		}
    if ( !(type_desc == null || type_desc.equals("")) )
		{
			if(cnt>0)
			sql+= "AND  upper(D.STORE_TYPE) like upper('%"+type_desc+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" AND upper(D.STORE_TYPE) like upper('%"+type_desc+"%')";
				cnt=1;
			}
		}
     if ( !(default_yn == null || default_yn.equals("")) )
		{
			if(cnt>0)
			sql+= "AND  upper(D.DEFAULT_YN) like upper('%"+default_yn+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" AND upper(D.DEFAULT_YN) like upper('%"+default_yn+"%')";
				cnt=1;
			}
		}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ )
		 	{
			 	if ( i == ord.length - 1 )
				sql=sql+ord[i];
				else
				sql=sql+ord[i]+",";
			}
		}
	}//end of where clause IF

 else
    {
	sql = whereClause;
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

Connection 	conn = ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
ResultSet rs=null;
ResultSet rset=null;
int maxRecord = 0;
try{


//String strsql="SELECT D.OPER_ROOM_CODE,C.FACILITY_NAME,B.SHORT_DESC,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID ='"+locale+"' AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE  " +sql;
String strsql="SELECT E.SHORT_DESC,C.FACILITY_NAME,B.SHORT_DESC,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D,OT_OPER_ROOM_LANG E WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID  = E.LANGUAGE_ID AND B.LANGUAGE_ID ='"+locale+"' AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE AND D.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND D.OPER_ROOM_CODE = E.OPER_ROOM_CODE  " +sql;


//String strsql1="SELECT D.OPER_ROOM_CODE,C.FACILITY_NAME,B.SHORT_DESC,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID ='"+locale+"' AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE " +sql;
String strsql1="SELECT E.SHORT_DESC,C.FACILITY_NAME,B.SHORT_DESC,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D,OT_OPER_ROOM_LANG_VW E WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID  = E.LANGUAGE_ID AND B.LANGUAGE_ID ='"+locale+"' AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE AND D.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND D.OPER_ROOM_CODE = E.OPER_ROOM_CODE " +sql;
   stmt = conn.prepareStatement(strsql);
   rs = stmt.executeQuery();
   int total=0;
		while(rs.next())
	{
		total++;

	}
	 maxRecord=total;
		if(maxRecord == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err MessageOrderTypesForSpecialityQueryResult ::" +e);
	}

%>
<form name="QueryResult" id="QueryResult">

<P>
<form name="QueryResult" id="QueryResult">
<table cellspacing=0 cellpadding=3  align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/StoresforOperatingRoomQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/StoresforOperatingRoomQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="0" width="100%" cellspacing='0' cellpadding=3 align='center' >

<tr>
<th class="columnheadercenter" nowrap>
	<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
</th>

<th class="columnheadercenter" nowrap >
	Facility Name
</th>
<th class="columnheadercenter" nowrap> 
	<fmt:message key="Common.Store.label" bundle="${common_labels}"/>
	
</th>
<th class="columnheadercenter" nowrap> 
	<fmt:message key="Common.type.label" bundle="${common_labels}"/>
	
</th>
<th class="columnheadercenter" nowrap > 
	Default Store
</th>


<%
 	if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;

	}
	String classValue = "" ;
	
while ( rset.next() && i<=end )
{
        if ( i % 2 == 0 )
			classValue = "gridData" ; // changed by yadav
		else
			classValue = "gridData" ; // changed by yadav
		

	out.println("<tr><td class='" + classValue + "' style='border: 1px solid black;'>");

	 operating_room_code = rset.getString(1);
	 facility_name = rset.getString(2);
	 store_desc = rset.getString(3);
	 type_desc = rset.getString(4);
	 default_yn = rset.getString(5);

	out.println(operating_room_code+"</td><td class='gridData' style='border: 1px solid black;'>"); 
	out.println(facility_name+"</td><td class='" + classValue + "' style='border: 1px solid black;'>");
	out.println(store_desc+"</td><td class='" + classValue + "' style='border: 1px solid black;'>");
	out.println(type_desc+"</td><td class='" + classValue + "' style='border: 1px solid black;'>");
	//out.println(default_yn);

    if ( default_yn.equals("Y") || default_yn.equals("null"))
	    out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else 
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
   	out.println("</td>");

	
	i++;

}


		
%>

</tr>
</table>
<br><center>
<%
	if(stmt!=null)
			stmt.close();
		if(stmt1!=null)
			stmt1.close();
		if(rset!=null)
			rset.close();
		if(rs!=null)
			rs.close();
		ConnectionManager.returnConnection(conn,request);

		}
catch(Exception e)
{
	e.printStackTrace();
	//System.err.println("Err Message from StoresForOperatingRoomQueryResult.jsp ::" +e);
}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

