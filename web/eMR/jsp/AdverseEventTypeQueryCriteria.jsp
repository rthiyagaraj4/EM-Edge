<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<script src='../../eCommon/js/common.js' language='javascript'></script>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con=ConnectionManager.getConnection(request);


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseEventTypeCode.label","mr_labels"));	  // label
//firstItem.add("Adverse Event Type Code");	  // label
firstItem.add("ADV_EVENT_TYPE_CODE");	//name of field
firstItem.add("2");	// SIZE
firstItem.add("2");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
//secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseEventType.label","mr_labels"));	  // label
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseEventTypeDesc.label","mr_labels"));	  // label
//secondItem.add("Adverse Event Type Desc");  // label
secondItem.add("long_desc");   //name of field
secondItem.add("30");	//SIZE
secondItem.add("30");	//LENGTH


finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("List");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseEventTypeIndicator.label","mr_labels"));	  // label
//fourthItem.add("Adverse Type Indicator");  // label
fourthItem.add("ADV_EVENT_TYPE_IND");   //name of field
fourthItem.add("Select ADV_EVENT_TYPE_IND,ADV_EVENT_TYPE_IND_DESC from MR_ADV_EVENT_TYPE_IND order by ADV_EVENT_TYPE_IND_DESC");//static values that need to be displayed as option.Send it along with the value that is inserted.
/*fourthItem.add("null,-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----,7,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Allergy.label","mr_labels")+",8,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Hypersensitivity.label","mr_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypeII.label","mr_labels")+",9,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Hypersensitivity.label","mr_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypeIII.label","mr_labels")+",10,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Hypersensitivity.label","mr_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TypeIV.label","mr_labels"));*/
finAr.add(fourthItem); //add to ArrayList obj finAr


ArrayList eigthItem=new ArrayList();

eigthItem.add("List");  //Type of item
eigthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels"));	  // label
//eigthItem.add("User Defined");  // label
eigthItem.add("user_define");   //name of field
eigthItem.add("X,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
//eigthItem.add("X,Select,U,Yes,S,No");//static values that need to be displayed as option.Send it along with the value that is inserted.
eigthItem.add("4");	//LENGTH
finAr.add(eigthItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("List");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
//thirdItem.add("Nature");  // label
thirdItem.add("nature");   //name of field
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
//thirdItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("4");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr



String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseEventTypeCode.label","mr_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseEventTypeDesc.label","mr_labels");


orderByCols[0] = "Adverse Event Type Code";
orderByCols[1] = "Adverse Event Type Desc";


orderByColVals[0] = "a.ADV_EVENT_TYPE_CODE";
orderByColVals[1] = "a.long_desc";


strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AdverseEventType.label","mr_labels"),"../jsp/AdverseEventTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
out.println(strbuff.toString());
finAr.clear();
firstItem.clear();
thirdItem.clear();
eigthItem.clear();
fourthItem.clear();
secondItem.clear();
} catch (Exception e) {
		out.println("Exception "+e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

%>

