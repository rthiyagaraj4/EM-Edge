<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
	<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String)session.getAttribute("facility_id");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String privilegeCode = "";
    
	System.out.println("Inside query result>>>>");

	String rightsType =request.getParameter("rightsType")==null?"":request.getParameter( "rightsType" ).trim().toUpperCase();
	String rightsCode =request.getParameter("rightsCode")==null?"":request.getParameter( "rightsCode" ).trim().toUpperCase();
	
	String functionId =request.getParameter("function_type")==null?"":request.getParameter( "function_type" ).trim().toUpperCase();
	
		if(rightsType.equals("S")){
			rightsType="";
		}
	
	System.out.println("rightsType/rightsCode/functionId>>>>"+rightsType+"/"+rightsCode+"/"+functionId);
	
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;        

        if ( !(rightsType == null || rightsType.equals("")) ){
				sql=sql+" and upper(hdr.USER_TYPE) like '"+rightsType+"'";
				cnt=1;
        }        
        if ( !(rightsCode == null || rightsCode.equals("")) ){
				sql=sql+" and upper(hdr.USER_CODE) like '"+rightsCode+"'";
				cnt=2;
        }
        if ( !(functionId == null || functionId.equals("")) ){
			sql=sql+" and upper(hdr.FUNCTION_ID) like '"+functionId+"'";
			cnt=3;
         }
	 

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
    	System.out.println("Inside orderby if cond");
        sql=sql+" order by ";
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql=sql+ord[i];
        else
            sql=sql+ord[i]+",";
        }
        System.out.println("sql>>>>"+sql);
    }

    } //end of where clause IF
    else{
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

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;

	try{
		
		
		String strsql= "SELECT count(*) as total FROM bl_user_privileges hdr where trunc(sysdate) between hdr.eff_from_date and nvl(hdr.eff_to_date,sysdate) and hdr.operating_facility_id = '"+facility_id+"' "+sql ;
		String strsql1="";
		
		strsql1 = 	"SELECT USER_TYPE,USER_CODE,(select func.FUNCTION_DESC func_desc  from BL_FUNCTIONS func where func.FUNCTION_ID = hdr.FUNCTION_ID) func_desc,  "+
						" hdr.FUNCTION_ID,to_char(hdr.EFF_FROM_DATE,'dd/mm/yyyy') EFF_FROM_DATE,to_char(hdr.EFF_TO_DATE,'dd/mm/yyyy') EFF_TO_DATE,hdr.PRVLEGE_VAL_YN,privlege_code  FROM BL_USER_PRIVILEGES hdr where trunc(sysdate) between hdr.eff_from_date and nvl(hdr.eff_to_date,sysdate) and hdr.operating_facility_id = '"+facility_id+"'  "+sql ;
		
		System.out.println("sql->"+sql);
		System.out.println("strsql1->"+strsql1);
		stmt = conn.prepareStatement(strsql);
		System.out.println("prepareStatement->1");
		rs = stmt.executeQuery();
		System.out.println("executeQuery->1");

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			System.out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		System.out.println("prepareStatement->");
		rset = stmt1.executeQuery();
		System.out.println("executeQuery->");
		
	}catch(Exception e){
		System.out.println("exception occurred "+e);
		e.printStackTrace();
	}
%>
<form name='QueryResult' id='QueryResult'>

<P>
<table align='right'>
<tr>
<td>
<!-- Modified by rajesh V - Include Called From -->
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eBL/jsp/BLFunctionPrivilegeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eBL/jsp/BLFunctionPrivilegeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eDSN.resources.Labels" var="dl_labels"/>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>

<td class="columnheadercenter" nowrap> 
	User Type
</td>
<td class="columnheadercenter" nowrap> 
	User Code
</td>
<td class="columnheadercenter" nowrap> 
	Function Id
</td>
<td class="columnheadercenter" nowrap> 
	Privilege Code
</td>

<%
	int mOrder = 0;
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
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");    
   
   String functionDesc="";
   String effFrmDate="";
   String effToDate="";
   String privYN="";
   
    
    rightsType=rset.getString("USER_TYPE"); 
    rightsCode=rset.getString("USER_CODE");   
    
    functionId=rset.getString("FUNCTION_ID"); 
    functionDesc=rset.getString("func_desc"); 
    effFrmDate=rset.getString("EFF_FROM_DATE"); 
    effToDate=rset.getString("EFF_TO_DATE");
    privYN=rset.getString("PRVLEGE_VAL_YN");
    privilegeCode = rset.getString("privlege_code");
    effFrmDate=(effFrmDate==null)?"":effFrmDate;
    effToDate=(effToDate==null)?"":effToDate;
    
    System.out.println("userType/userCode/functionId/functionDesc/effFrmDate/effToDate/privYN "+rightsType+"/"+rightsCode+"/"+functionId+"/"+functionDesc+"/"+effFrmDate+"/"+effToDate+"/"+privYN);
	String mode="modify";
    
	out.println("<a href='../../eBL/jsp/BFunctionPrivilegeAddMod.jsp?mode=modify&rightsType="+rightsType+"&rightsCode="+rightsCode+"&functionId="+functionId+"&functionDesc="+functionDesc+"&effFrmDate="+effFrmDate+"&effToDate="+effToDate+"&privYN="+privYN+"' target='BLUserRightsMainFrame' >");
	
    out.println(rightsType+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+rightsCode+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+functionId+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+privilegeCode+"</td>");
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%
if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
ConnectionManager.returnConnection(conn,request);
}
catch(Exception e)
{
	e.printStackTrace();
	out.println("here "+e);
}
%>

</center>
</form>
</BODY>
</HTML>

