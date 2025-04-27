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
try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
	
    String blngGroup = request.getParameter("billingGrpCode")==null?"":request.getParameter( "billingGrpCode" ).trim().toUpperCase();
    String payerGroup =request.getParameter("payerGrpCode")==null?"":request.getParameter( "payerGrpCode" ).trim().toUpperCase();
    String payer =request.getParameter("payerCode")==null?"":request.getParameter( "payerCode" ).trim().toUpperCase();
	String policyType =request.getParameter("policyTypeCode")==null?"":request.getParameter( "policyTypeCode" ).trim().toUpperCase();

	String validFrom =request.getParameter("validFrom")==null?"":request.getParameter( "validFrom" ).trim().toUpperCase();
	String oprFacId =request.getParameter("facility")==null?"":request.getParameter( "facility" ).trim().toUpperCase();
	String validTo =request.getParameter("validTo")==null?"":request.getParameter( "validTo" ).trim().toUpperCase();
	String applInd =request.getParameter("applInd")==null?"":request.getParameter( "applInd" ).trim().toUpperCase();
	String alwMultiPkgYN =request.getParameter("alwMultiPkgYN")==null?"":request.getParameter( "alwMultiPkgYN" ).trim().toUpperCase();
	String alwPkgCustYN =request.getParameter("alwPkgCustYN")==null?"":request.getParameter( "alwPkgCustYN" ).trim().toUpperCase();
	String alwAdhocPkgYN =request.getParameter("alwAdhocPkgYN")==null?"":request.getParameter( "alwAdhocPkgYN" ).trim().toUpperCase();
	String discPerc =request.getParameter("discPerc")==null?"":request.getParameter( "discPerc" ).trim().toUpperCase();	
	
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
    } //end of where clause IF
    else{
            sql = whereClause;
    }

    int start = 0;
    int end = 0;
    int i=1;

    if ( from == null )
        start = 1;
    else
        start = Integer.parseInt( from );

    if ( to == null )
        end = 14;
    else
        end = Integer.parseInt( to );

	Connection conn  =  ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;

	try{		
		String strsql= "SELECT count(*) as total FROM BL_MULTI_PKG_DISCOUNT hdr where hdr.operating_facility_id = '"+facility_id+"' "+sql ;

		String strsql1="SELECT OPERATING_FACILITY_ID,BLNG_GRP_ID,CUST_GROUP_CODE,CUST_CODE,POLICY_TYPE_CODE, TO_CHAR(VALID_FROM_DATE,'dd/mm/yyyy') VALID_FROM_DATE,TO_CHAR(VALID_TO_DATE,'dd/mm/yyyy') VALID_TO_DATE,APPLICABILITY_IND,ALW_MULTI_PKG_DISC,ALW_CUST_PKG_DISC,ALW_ADHOC_PKG_DISC,DISC_PERC FROM "+
				" BL_MULTI_PKG_DISCOUNT hdr where hdr.operating_facility_id = '"+facility_id+"'  "+sql;
		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			System.out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();		
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
<%
	if ( !(start <= 1) )
		out.println("<A HREF='../../eBL/jsp/MultiPkgDiscQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF='../../eBL/jsp/MultiPkgDiscQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eDSN.resources.Labels" var="dl_labels"/>
	<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
		<td class="columnheadercenter" > 
			Billing Group Code
		</td>
		<td class="columnheadercenter" > 
			Customer Group Code
		</td>
		<td class="columnheadercenter" > 
			Customer Code
		</td>
		<td class="columnheadercenter" > 
			Policy Type Code
		</td>
		<td class="columnheadercenter" > 
			Facility Id
		</td>
		<td class="columnheadercenter" nowrap> 
			Valid From
		</td>
		<td class="columnheadercenter" nowrap> 
			Valid To
		</td>
		<td class="columnheadercenter" > 
			Applicable For
		</td>
		<td class="columnheadercenter" > 
			Multi Package Discount
		</td>
		<td class="columnheadercenter" > 
			Multi Package Discount YN
		</td>
		<td class="columnheadercenter" > 
			Package/Customer Discount YN
		</td>
		<td class="columnheadercenter" > 
			Adhoc Discount YN
		</td>
<%
	int mOrder = 0;
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rset.next();
	String classValue= " ";
    while ( rset.next() && i<=end  )
	{
		if ( i % 2 == 0 )
           classValue = "gridData";  
          else
            classValue = "gridData";  
		out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");    
   
		blngGroup=rset.getString("BLNG_GRP_ID");
		payerGroup=rset.getString("CUST_GROUP_CODE");
		payer=checkForNull(rset.getString("CUST_CODE"));
		validFrom=rset.getString("VALID_FROM_DATE");
		policyType=checkForNull(rset.getString("POLICY_TYPE_CODE"));   
		oprFacId=rset.getString("OPERATING_FACILITY_ID");   
		validTo=checkForNull(rset.getString("VALID_TO_DATE"));   
		applInd=checkForNull(rset.getString("APPLICABILITY_IND"));   
		alwMultiPkgYN=checkForNull(rset.getString("ALW_MULTI_PKG_DISC"));   
		alwPkgCustYN=checkForNull(rset.getString("ALW_CUST_PKG_DISC"));   
		alwAdhocPkgYN=checkForNull(rset.getString("ALW_ADHOC_PKG_DISC"));   
		discPerc=checkForNull(rset.getString("DISC_PERC"));    
		
		String mode="modify";
		
		out.println("<a href='../../eBL/jsp/MultiPkgDiscCreate.jsp?mode=modify&blngGroup="+ blngGroup+"&payerGroup="+payerGroup+"&payer="+payer+"&validFrom="+validFrom+"&policyType="+policyType+"&oprFacId="+oprFacId+"&validTo="+validTo+"&applInd="+applInd+"&alwMultiPkgYN="+alwMultiPkgYN+"&alwPkgCustYN="+alwPkgCustYN+"&alwAdhocPkgYN="+alwAdhocPkgYN+"&discPerc="+discPerc+" ' target='MultiPkgDiscCreate' >");	
		
		if("E".equals(applInd)){		
			applInd="All Packages Except High Cost ";		
		}
		
		else if("H".equals(applInd)){		
			applInd="Only High Cost Packages";		
		}
		
		else if("L".equals(applInd)){		
			applInd="Only Low Cost Packages";		
		}
		
		out.println(blngGroup+"</a></td>");
		out.println("<td class='" + classValue+"' nowrap>"+payerGroup+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+payer+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+policyType+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+oprFacId+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+validFrom+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+validTo+"</td>");
		out.println("<td class='" + classValue+"' nowrap >"+applInd+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+discPerc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+alwMultiPkgYN+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+alwPkgCustYN+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+alwAdhocPkgYN+"</td>");    
		i++;
	} 
%>

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
		//out.println("here "+e);
		e.printStackTrace();
	}
%>
</center>
</form>
</BODY>
</HTML>

