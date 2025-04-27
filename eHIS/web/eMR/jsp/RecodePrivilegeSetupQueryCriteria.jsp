<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
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
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));	  // label
firstItem.add("stage_no");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
secondItem.add("stage_desc");   //name of field
secondItem.add("40");	// SIZE
secondItem.add("40");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

	thirdItem.add("Text");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SpecificIndicator.Label","ot_labels"));  // label
thirdItem.add("spec_ind");   //name of field
thirdItem.add("4");	// SIZE
thirdItem.add("4");//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr

String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SpecificIndicator.Label","ot_labels");


orderByColVals[0] = "stage_no";
orderByColVals[1] = "stage_desc";
orderByColVals[2] = "specific_ind";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stage.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"),"../../eMR/jsp/RecodePrivilegeSetupqueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( finAr != null )  finAr.clear();

} catch (Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
