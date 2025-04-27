<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;
try
{
	con				= ConnectionManager.getConnection(request);
String immobilizationCode    = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.ImmobilizationCode.label","ae_labels");
String immobilizationDes    = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.ImmobilizationDesc.label","ae_labels");
ArrayList finAr 	= new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		//Type of item
firstItem.add(immobilizationCode);		//label
firstItem.add("immobilization_code");		//name of field
firstItem.add("6");				// SIZE
firstItem.add("6");			    //LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem	= new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels"));  // label
secondItem.add("long_desc");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList fourthItem	= new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));  // label
fourthItem.add("short_desc");   //name of field
fourthItem.add("15");	// SIZE
fourthItem.add("15");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList thirdItem	 = new ArrayList();

thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
thirdItem.add("eff_status");//name
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(thirdItem); //add to ArrayList obj finAr

String orderByCols[] 	= new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] 		 = immobilizationCode;
orderByCols[1]		 = immobilizationDes;

orderByColVals[0] 	 = "immobilization_code";
orderByColVals[1] 	 = "long_desc";

strbuff 		= qrypg.getQueryPage(con,finAr,"Find Site" ,"../jsp/ImmobilizationQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(thirdItem!=null)thirdItem.clear();
	if(fourthItem!=null)fourthItem.clear();
}catch (Exception e)  {e.printStackTrace();}
finally
	{
		 ConnectionManager.returnConnection(con,request);
	}
%>
