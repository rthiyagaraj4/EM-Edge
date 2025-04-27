<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
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
			firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MainSectionCode.label","ca_labels"));     // label
			firstItem.add("mainSectionCode");   //name of field
			firstItem.add("6"); // SIZE
			firstItem.add("6"); //LENGTH
			finAr.add(firstItem);//add to ArrayList obj finAr

			ArrayList secondItem = new ArrayList();

			secondItem.add("Text");           //Type of item
			secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MainSectionDesc.label","ca_labels"));     // label
			secondItem.add("mainSectionDesc");   //name of field
			secondItem.add("30"); // SIZE
			secondItem.add("30"); //LENGTH
			finAr.add(secondItem);//add to ArrayList obj finAr

			ArrayList thirdItem = new ArrayList();

			thirdItem.add("Text");           //Type of item
			thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SubSectionCode.label","ca_labels"));     // label
			thirdItem.add("subSectionCode");   //name of field
			thirdItem.add("6"); // SIZE
			thirdItem.add("6"); //LENGTH
			finAr.add(thirdItem);//add to ArrayList obj finAr

			ArrayList fourthItem = new ArrayList();

			fourthItem.add("Text");           //Type of item
			fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SubSectionDescription.label","ca_labels"));     // label
			fourthItem.add("subSectionDesc");   //name of field
			fourthItem.add("30"); // SIZE
			fourthItem.add("30"); //LENGTH
			finAr.add(fourthItem);//add to ArrayList obj finAr

			/*ArrayList fifthItem = new ArrayList();

			fifthItem.add("Text");           //Type of item
			fifthItem.add("Sequence Number");     // label
			fifthItem.add("seq_num");   //name of field
			fifthItem.add("6"); // SIZE
			fifthItem.add("6"); //LENGTH
			finAr.add(fifthItem);//add to ArrayList obj finAr*/

			String orderByCols[] = new String[4];
			String orderByColVals[] = new String[4];

			orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MainSectionCode.label","ca_labels");
			orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MainSectionDesc.label","ca_labels");
			orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SubSectionCode.label","ca_labels");
			orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SubSectionDescription.label","ca_labels");

			orderByColVals[0] = "HEADER_SEC_HDG_CODE";
			orderByColVals[1] = "HEADER_SEC_HDG_DESC";
			orderByColVals[2] = "CHILD_SEC_HDG_CODE";
			orderByColVals[3] = "CHILD_SEC_HDG_DESC";
			
			StringBuffer strbuff=new StringBuffer();
			strbuff.append(qrypg.getQueryPage(con,finAr,"Find Section","../../eCA/jsp/QuerySubSection.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query"));
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

