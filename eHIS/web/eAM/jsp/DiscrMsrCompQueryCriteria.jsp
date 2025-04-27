<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff =new StringBuffer() ;

Connection con=null ;

try {
	con = (Connection) session.getValue( "connection" );


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
firstItem.add("Text");  //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	// label
firstItem.add("comp_id"); //name of field
firstItem.add("15");	// SIZE
firstItem.add("15");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	// label
secondItem.add("short_desc"); //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH
finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("List");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ComponentType.label","common_labels"));	// label
thirdItem.add("comp_type"); //name of field
//thirdItem.add("Q,-----Select-----,C,Check Box,D,Date,Z,Date/Time,I,Integer Numeric ,L,List,N,Decimal Numeric,H,Time,T,Long Text,S,Short Text,F,Formula,P,Embedded Component");//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("Q,-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----,C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckBox.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DecimalNumeric.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmbeddedComponent.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Formula.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GridComponent.label","common_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IntegerNumeric.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.List.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LongText.label","common_labels")+",X,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MatrixComponent.label","common_labels")+",H,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ShortText.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Summary.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.

thirdItem.add("1");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();
fourthItem.add("List");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fourthItem.add("nature");   //name of field
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
fourthItem.add("4");	//LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ComponentType.label","common_labels");
//orderByCols[3] = "Effective Status";

orderByColVals[0] = "discr_msr_id";
orderByColVals[1] = "short_desc";
orderByColVals[2] = "result_type";
//orderByColVals[3] = "eff_status";

strbuff= qrypg.getQueryPage(con,finAr,"Template Component  ","../../eAM/jsp/DiscrMsrCompQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels"));
out.println(strbuff.toString());


    finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
//Added for check style for COMMON-ICN-0056
} catch (Exception e) 
{
//out.println("Exception :"+e);
e.printStackTrace();
}
finally{
	if(con != null)  ConnectionManager.returnConnection(con,request);
}

%>
