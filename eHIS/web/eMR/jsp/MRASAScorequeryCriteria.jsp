<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*	" %>
  <%String sStyle	=
  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;

try {

con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ASAScorecode.label","mr_labels"));	  // label
firstItem.add("asa_score_code");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("5");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PhysicalStatus.label","common_labels"));  // label
secondItem.add("patient_physical_status");   //name of field
secondItem.add("40");	// SIZE
secondItem.add("40");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("List");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
thirdItem.add("nature");   //name of field
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("4");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ASAScorecode.label","mr_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PhysicalStatus.label","common_labels");

orderByColVals[0] = "asa_score_code";
orderByColVals[1] = "patient_physical_status";

strbuff = qrypg.getQueryPage(con,finAr, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PhysicalStatus.label","common_labels"),"../../eMR/jsp/MRASAScoreQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));


out.println(strbuff.toString());

if ( firstItem != null )  firstItem.clear();
if ( secondItem != null )  secondItem.clear();
if ( thirdItem != null )  thirdItem.clear();
if ( finAr != null )  finAr.clear();


} catch (Exception e) {
	//out.println("Exception @ try"+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
