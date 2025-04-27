<!DOCTYPE html>
 <%--
    Created: S V Narayana
	Created on 	: 14-04-2009
  --%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
	<%
			ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
			StringBuffer strbuff;
			Connection con=null ;

try {
			request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);

			ArrayList finAr = new ArrayList();

			ArrayList firstItem = new ArrayList();

			firstItem.add("Text");  		 //Type of item
			firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.FacilityCategoryCode.label","sm_labels"));	  // label
			firstItem.add("facility_level_code");	//name of field
			firstItem.add("2");	// SIZE
			firstItem.add("2");	//LENGTH

			finAr.add(firstItem);//add to ArrayList obj finAr

			ArrayList secondItem=new ArrayList();

			secondItem.add("Text");  //Type of item
			secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.FacilityCategoryDesc.label","sm_labels"));  // label
			secondItem.add("long_desc");   //name of field
			secondItem.add("30");	// SIZE
			secondItem.add("30");	//LENGTH

			finAr.add(secondItem); //add to ArrayList obj finAr

			ArrayList thirdItem=new ArrayList();

			thirdItem.add("List");  //Type of item
			thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
			thirdItem.add("nature");   //name of field
			thirdItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static 
			thirdItem.add("4");	//LENGTH

			finAr.add(thirdItem); //add to ArrayList obj finAr

			String orderByCols[] = new String[2];
			String orderByColVals[] = new String[2];


			orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.FacilityCategoryCode.label","sm_labels");
			orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.FacilityCategoryDesc.label","sm_labels");

			orderByColVals[0] = "facility_level_code";
			orderByColVals[1] = "long_desc";



			strbuff = qrypg.getQueryPage(con,finAr,"Find Facility Category Code ","../../eSM/jsp/FacilityCategoryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

			out.println(strbuff.toString());
			firstItem.clear();
			secondItem.clear();
			thirdItem.clear();
			finAr.clear();

}
catch (Exception e) 
{
	out.println(e.toString());
}
finally
	{
		ConnectionManager.returnConnection(con,request);
	}


%>
