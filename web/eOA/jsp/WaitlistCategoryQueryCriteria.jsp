<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;

try 
{

	con = (Connection) session.getValue( "connection" );
} 
catch (Exception e) {}


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 		//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.WaitlistCategoryCode.label","oa_labels"));	// label
firstItem.add("waitlist_code");	//name of field
firstItem.add("4");					// SIZE
firstItem.add("4");					//LENGTH

finAr.add(firstItem);					//add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();

secondItem.add("Text");  			//Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.WaitlistCategoryDescription.label","oa_labels"));  	// label
secondItem.add("long_desc");   	//name of field
secondItem.add("30");				// SIZE
secondItem.add("30");				//LENGTH

finAr.add(secondItem); 				//add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   				//Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  		// label
thirdItem.add("eff_status");		//name
//thirdItem.add("B,Both,E,Enabled,D,Disabled");					// SIZE
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
//LENGTH

finAr.add(thirdItem); 				//add to ArrayList obj finAr

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.WaitlistCategoryCode.label","oa_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.WaitlistCategoryDescription.label","oa_labels");

orderByColVals[0] = "WAITLIST_CATEGORY_CODE";
orderByColVals[1] = "long_desc";

strbuff = qrypg.getQueryPage(con,finAr,"Waitlist Category","../../eOA/jsp/WaitlistCategoryQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");


finAr.clear();
thirdItem.clear();
secondItem.clear();
firstItem.clear();
out.println(strbuff.toString());
%>
