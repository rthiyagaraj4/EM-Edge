<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	</head>
  
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;

try 
{
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	
	firstItem.add("List");           // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels"));			 // label	
	firstItem.add("ext_image_appl_id");		 // name of field
	firstItem.add("select EXT_IMAGE_APPL_ID,EXT_IMAGE_APPL_NAME from CA_EXT_IMAGE_APPL where EFF_STATUS='E' order by EXT_IMAGE_APPL_NAME");			
	finAr.add(firstItem);            // add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("List");           // Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));			  // label
	secondItem.add("order_category");	  // name of field
	secondItem.add("select ORDER_CATEGORY,SHORT_DESC from OR_ORDER_CATEGORY order by  SHORT_DESC ");			  
	finAr.add(secondItem);            // add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");           // Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels"));			  // label
	thirdItem.add("order_type_code");	  // name of field
	thirdItem.add("20");			  // SIZE
	thirdItem.add("20");             // LENGTH
	finAr.add(thirdItem);			//	add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");           // Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ordercatalog.label","common_labels"));			  // label
	fourthItem.add("order_catalog_code");	  // name of field
	fourthItem.add("20");			  // SIZE
	fourthItem.add("20");             // LENGTH
	finAr.add(fourthItem);			//	add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");           // Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));			  // label
	fifthItem.add("facility_id");	  // name of field
	fifthItem.add("select facility_id ,facility_name from sm_facility_param where  status='E'");			  
	finAr.add(fifthItem);            // add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");           // Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));			  // label
	sixthItem.add("eff_status");	  // name of field
	sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");		//static values that need to be 
	//displayed as option.Send it along with the value that is inserted.

	

	finAr.add(sixthItem);	


	String[] orderByCols = null;
	String[] orderByColVals = null;
	orderByCols = new String[4];
	orderByColVals = new String[4];
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Application.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ordercatalog.label","common_labels");

	orderByColVals[0] = "ext_image_appl_id";
	orderByColVals[1] = "order_category";
	orderByColVals[2] = "order_type_code";
	orderByColVals[3] = "order_catalog_code";

	strbuff = qrypg.getQueryPage(con,finAr,"External Application Detail","../../eCA/jsp/CAExternalApplDtlResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());

	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();


}//end of try
catch (Exception e) 
{
	//out.println("Exception in CAExternalApplDtlCriteria.jsp:"+e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
finally	
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

<html>	

