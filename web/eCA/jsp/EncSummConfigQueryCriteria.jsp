<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
26/09/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	Connection con=null ;
	
	try
	{
		    con  =  ConnectionManager.getConnection(request);
			ArrayList finAr = new ArrayList();
			ArrayList firstItem = new ArrayList();

			firstItem.add("Text");           //Type of item
			firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SummaryCode.label","ca_labels"));     // label
			firstItem.add("es_summ_code");   //name of field
			firstItem.add("8"); // SIZE
			firstItem.add("8"); //LENGTH
			finAr.add(firstItem);//add to ArrayList obj finAr

			ArrayList secondItem = new ArrayList();

			secondItem.add("Text");           //Type of item
			secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SummaryDescription.label","ca_labels"));     // label
			secondItem.add("es_summ_desc");   //name of field
			secondItem.add("64"); // SIZE
			secondItem.add("64"); //LENGTH
			finAr.add(secondItem);//add to ArrayList obj finAr

			ArrayList thirdItem = new ArrayList();

			thirdItem.add("Text");           //Type of item
			thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GroupCode.label","common_labels"));     // label
			thirdItem.add("es_group_code");   //name of field
			thirdItem.add("16"); // SIZE
			thirdItem.add("16"); //LENGTH
			finAr.add(thirdItem);//add to ArrayList obj finAr

			ArrayList fourthItem = new ArrayList();

			fourthItem.add("Text");           //Type of item
			fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.groupdesc.label","ca_labels"));     // label
			fourthItem.add("es_group_desc");   //name of field
			fourthItem.add("64"); // SIZE
			fourthItem.add("64"); //LENGTH
			finAr.add(fourthItem);//add to ArrayList obj finAr			

			String orderByCols[] = new String[4];
			String orderByColVals[] = new String[4];

			orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SummaryCode.label","ca_labels");
			orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SummaryDescription.label","ca_labels");
			orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GroupCode.label","common_labels");
			orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.groupdesc.label","ca_labels");

			orderByColVals[0] = "es_summ_code";
			orderByColVals[1] = "es_summ_desc";
			orderByColVals[2] = "es_group_code";
			orderByColVals[3] = "es_group_desc";
			
			StringBuffer strbuff=new StringBuffer();
			strbuff.append(qrypg.getQueryPage(con,finAr,"Find Summary","../../eCA/jsp/EncSummConfigQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query"));
			out.println(strbuff.toString());

			finAr.clear();
			firstItem.clear();
			secondItem.clear();
			thirdItem.clear();
			fourthItem.clear();

	}
	catch(Exception e)
	{
		//out.println("Exception in Main Block :"+e.toString());//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}
%>

