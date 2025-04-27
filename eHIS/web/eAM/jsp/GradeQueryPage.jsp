<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	    <script src="../js/common.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
</html></head>
<%!	
	StringBuffer strbuff;
	ArrayList finAr;
	ArrayList firstItem;
	ArrayList secondItem;
	ArrayList thirdItem;
	
%>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	Connection con=null ;
		
	try 
	{	
		con=   ConnectionManager.getConnection(request);
					String function_id = request.getParameter("function_id");

	
		finAr = new ArrayList();

		firstItem = new ArrayList();
		firstItem.add("Text");  					
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GradeCode.label","common_labels"));		firstItem.add("grade_code");				
		firstItem.add("2");							
		firstItem.add("2");							
		finAr.add(firstItem);						
		secondItem = new ArrayList();
		secondItem.add("Text");  					
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GradeDescription.label","common_labels"));	secondItem.add("long_desc");				
		secondItem.add("30");						
		secondItem.add("30");						
		finAr.add(secondItem);								
							

		thirdItem = new ArrayList();
		thirdItem.add("List");						
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));			thirdItem.add("eff_status");				
		thirdItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
		finAr.add(thirdItem);						 


		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GradeCode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GradeDescription.label","common_labels");

		orderByColVals[0] = "grade_code";
		orderByColVals[1] = "long_desc";

		strbuff = qrypg.getQueryPage(con,finAr,"Find grade","../../eAM/jsp/GradeQuery.jsp?function_id="+function_id,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels"));

		out.println(strbuff.toString());
	
	} 
	catch (Exception e)
	{
		e.printStackTrace();
	}

	finally
	{
		//returning the connection 
		ConnectionManager.returnConnection(con,request);

		//Clearing the String Buffer.
		
		strbuff.setLength(0);	

		//Clearing the ArrayList
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		
	}
%>

