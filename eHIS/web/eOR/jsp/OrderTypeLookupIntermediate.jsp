<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import="eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/LocationForPractitioner.js"></script>
		<script language="JavaScript" src ="../../eOR/js/OrderEntrySearch.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
			
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%
	String facility_id = (String)session.getValue("facility_id");
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String speciality = "";
	String orderTypevalue = "";
	String sql = "";
	String selFunVal = "";
	String localeName1 = "";
	String order_category = "";
	int count =0;
	try
	{
		
			con = ConnectionManager.getConnection(request);
			
		    speciality = request.getParameter("speciality")==null ? "" : request.getParameter("speciality");
			orderTypevalue = request.getParameter("orderTypevalue")==null ? "" : request.getParameter("orderTypevalue");
			order_category = request.getParameter("order_category")==null ? "" : request.getParameter("order_category");
			localeName1 = request.getParameter("localeName")==null ? "" : request.getParameter("localeName");
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");

		   if (selFunVal.equals("OrderType"))
			{
			  
					if(!orderTypevalue.equals(""))
					{
                        sql="SELECT order_type_code code,  short_desc description FROM or_order_type_lang_vw WHERE language_id=? and eff_status='E' AND order_category like ?  and upper(short_desc) like upper(?)";
						orderTypevalue = orderTypevalue + "%";
					}
			
			}
			ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			if (selFunVal.equals("OrderType"))
			{
                 
					if(!orderTypevalue.equals(""))
					{	
						ps.setString(1,localeName1);
						ps.setString(2,order_category);
						ps.setString(3,orderTypevalue);		
					}
			
			}
		    rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			
			if(count == 1)
		 {		 
				rs.beforeFirst() ;				
				out.println("<script>");
             
            
			if(!orderTypevalue.equals(""))
		   {				
				 while(rs.next())
				{
                  
			        out.println("parent.criteriaMainFrame.document.addlSearchCriteriaForm.order_type_desc.value='"+rs.getString(2)+"'");
					out.println(" parent.criteriaMainFrame.document.addlSearchCriteriaForm.order_type.value='"+rs.getString(1)+"' ");
				}
			}

			out.println("</script>");
		   }
		  
		    if(ps != null) ps.close();
		    if(rs != null) rs.close();

			if(count == 0 || count > 1)
			{	
				if(!orderTypevalue.equals(""))
			{
				sql ="SELECT order_type_code code,  short_desc description FROM or_order_type_lang_vw WHERE language_id='"+localeName1+"' and eff_status='E' AND order_category like '"+order_category+"' and upper(order_type_code) like upper(?) and upper(short_desc) like upper(?)";
			}
%>
	<script>

		var chkVal = "<%=selFunVal%>";
          if (chkVal == "OrderType")
		        {	
				retVal = callFunction3("<%=sql%>","Order Type",parent.criteriaMainFrame.document.addlSearchCriteriaForm.order_type_desc)  
				if(retVal != null && retVal !="")	
				{
					    parent.criteriaMainFrame.document.addlSearchCriteriaForm.order_type_desc.value=retVal[1];
					    parent.criteriaMainFrame.document.addlSearchCriteriaForm.order_type.value=retVal[0];			
				}
				else
				{
					parent.criteriaMainFrame.document.addlSearchCriteriaForm.order_type_desc.value='';
					parent.criteriaMainFrame.document.addlSearchCriteriaForm.order_type.value='';	
				}
			  }
	</script>
<%	
	}
	
}
	catch(Exception ee)
	{
		ee.printStackTrace();
		//out.println("Exception in Location For Order type Intermediate Module "+ee.toString());//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}
%>
 </body>
</html>

