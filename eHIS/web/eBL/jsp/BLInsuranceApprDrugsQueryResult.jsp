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
	<%!
     private String checkForNull(String inputString) {
 		if(inputString == null || "null".equals(inputString)){
 			inputString = "";
 		}
 		return inputString;
 	}
	%>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String)session.getAttribute("facility_id");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
Connection conn = null;
PreparedStatement stmt = null;
ResultSet rs = null;
try
{
	conn  =  ConnectionManager.getConnection(request);
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    
    
    String blngGroup = request.getParameter("billingGrpCode")==null?"":request.getParameter( "billingGrpCode" ).trim().toUpperCase();
    String payerGroup =request.getParameter("payerGrpCode")==null?"":request.getParameter( "payerGrpCode" ).trim().toUpperCase();
    String payer =request.getParameter("payerCode")==null?"":request.getParameter( "payerCode" ).trim().toUpperCase();
	String policyType =request.getParameter("policyTypeCode")==null?"":request.getParameter( "policyTypeCode" ).trim().toUpperCase();

	String oprFacId =request.getParameter("facility_id")==null?"":request.getParameter( "facility_id" ).trim().toUpperCase();
	
	if ( (whereClause == null || whereClause.equals("")) )
    {
		int cnt=0;        

        if ( !(blngGroup == null || blngGroup.equals("")) ){
	        sql = sql + " and upper(hdr.BLNG_GRP_ID) like upper('"+blngGroup +"%')";
			cnt++;
        }
        if ( !(payerGroup == null || payerGroup.equals("")) ){
				sql=sql+" and upper(hdr.CUST_GROUP_CODE) like '"+payerGroup+"%'";
				cnt=1;
        }        
        if ( !(payer == null || payer.equals("")) ){
				sql=sql+" and upper(hdr.CUST_CODE) like '"+payer+"%'";
				cnt=2;
        }
        if ( !(policyType == null || policyType.equals("")) ){
			sql=sql+" and upper(hdr.POLICY_TYPE_CODE) like '"+policyType+"%'";
			cnt=2;
         }
	 
		sql = sql+ "GROUP BY OPERATING_FACILITY_ID,BLNG_GRP_ID,CUST_GROUP_CODE,CUST_CODE,POLICY_TYPE_CODE " ;
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
		}
    } //end of where clause IF
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
        end = 9 ;
    else
        end = Integer.parseInt( to ) ;
    int maxRecord = 0;
	try{
		
		String strsql= "SELECT COUNT(*) total FROM (SELECT count(*) as total FROM BL_PH_DRUG_AGREEMENT hdr where hdr.operating_facility_id = ? "+sql + ")" ;
		
		String strsql1="SELECT OPERATING_FACILITY_ID,BLNG_GRP_ID,CUST_GROUP_CODE,CUST_CODE,POLICY_TYPE_CODE " +
					   "FROM BL_PH_DRUG_AGREEMENT hdr where hdr.operating_facility_id = ? " + sql ;
		/* Fixed SQL Injection for Common-ICN-0222 */
		System.err.println("sql-> "+sql);
		System.err.println("strsql-> "+strsql);
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1, facility_id);
		System.err.println("prepareStatement->1");
		rs = stmt.executeQuery();
		System.err.println("executeQuery->1");
		if(rs.next())
			maxRecord = rs.getInt("total");
		else
			maxRecord = 0;
		System.err.println("maxRecord:"+maxRecord);
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		if(stmt!=null)	stmt.close();
		if(rs!=null)	rs.close();

		System.err.println("strsql1-> "+strsql1);
		stmt = conn.prepareStatement(strsql1);
		stmt.setString(1, facility_id);
		System.err.println("prepareStatement->");
		rs = stmt.executeQuery();
		System.err.println("executeQuery->");
		
	}catch(Exception e){
		//System.err.println("exception occurred "+e);
		e.printStackTrace();
	}
%>
<form name='QueryResult' id='QueryResult'>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eBL/jsp/BLInsuranceApprDrugsQueryResult.jsp?from="+(start-9)+"&to="+(end-9)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+9) > maxRecord ) )
    out.println("<A HREF='../../eBL/jsp/BLInsuranceApprDrugsQueryResult.jsp?from="+(start+9)+"&to="+(end+9)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
	<fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/>
</td>
<td class="columnheadercenter" nowrap> 
	<fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/>
</td>
<td class="columnheadercenter" nowrap> 
	<fmt:message key="Common.Payer.label"  bundle="${common_labels}"/>
</td>
<td class="columnheadercenter" nowrap> 
	<fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>
</td>
<%
	int mOrder = 0;
	if ( start != 1 )
    for( int j=1; j<start; i++,j++ )
		rs.next() ;
	String classValue= " ";
    while ( rs.next() && i<=end  )
	{
		if ( i % 2 == 0 )
			classValue = "gridData" ;  
        else
            classValue = "gridData" ;  
		out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

		blngGroup = rs.getString("BLNG_GRP_ID");
		payerGroup = rs.getString("CUST_GROUP_CODE");
		payer = checkForNull(rs.getString("CUST_CODE"));
		policyType = checkForNull(rs.getString("POLICY_TYPE_CODE")); 
    	
		String mode="modify";
    
		out.println("<a href='../../eBL/jsp/BLInsuranceApprDrugsAddModify.jsp?mode=modify&calledFrm=Q&blngGroup="+ blngGroup+"&payerGroup="+payerGroup+"&payer="+payer+"&policyType="+policyType+"&oprFacId="+oprFacId+"' target='ApprovedDrugsCriteriaFrame' >");
		out.println(blngGroup+"</a></td>");
		out.println("<td class='" + classValue+"' nowrap>"+payerGroup+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+payer+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+policyType+"</td>");	
		i++;
	} 

%>

</td></tr>
</table>
</center>

<br><center>
<%
}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("here "+e);
}
finally{
	if(stmt!=null)	stmt.close();
	if(rs!=null)	rs.close();
	ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</form>
</BODY>
</HTML>

