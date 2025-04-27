<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;
Boolean isCnrmReqPatOutChngAppl = false;//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617
try
{
	con	= ConnectionManager.getConnection(request);

	isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");//Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
	firstItem.add("transfer_type_code");	//name of field
	firstItem.add("2");	// SIZE
	firstItem.add("2");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
	secondItem.add("transfer_type_desc");   //name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList third_item=new ArrayList();
	third_item.add("Text");  //Type of item
	third_item.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockingType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
	third_item.add("BLOKCING_TYPE_SHORT_DESC");   //name of field
	third_item.add("30");	// SIZE
	third_item.add("30");	//LENGTH
finAr.add(third_item); //add to ArrayList obj finAr

/*Added by Thamizh selvi on 5th May 2017 for ML-MMOH-CRF-0617 Start*/
ArrayList fourth_item=new ArrayList();
if(isCnrmReqPatOutChngAppl){
	fourth_item.add("List");  //Type of item
	fourth_item.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.InformedDtlsMand.label","ip_labels"));  // label
	fourth_item.add("informed_dtls_mand_yn");   //name of field
	fourth_item.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(fourth_item); //add to ArrayList obj finAr
}/*End*/

ArrayList fifth_item=new ArrayList();
	fifth_item.add("List");  //Type of item
	fifth_item.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	fifth_item.add("eff_status");   //name of field
	fifth_item.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
finAr.add(fifth_item); //add to ArrayList obj finAr


String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];
//<fmt:message key="eIP.TransferType.label" bundle="${ip_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>
orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockingType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "transfer_type_code";
orderByColVals[1] = "long_desc";
orderByColVals[2] = "BLOKCING_TYPE_SHORT_DESC";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferType.label","ip_labels"),"../jsp/TransferTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
third_item.clear();
if(isCnrmReqPatOutChngAppl)
	fourth_item.clear();
fifth_item.clear();
finAr.clear();

}catch(Exception e) 
{ 
	out.println(e.toString());
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

