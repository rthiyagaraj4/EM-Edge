<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
	<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage() ;

	StringBuffer strbuff ;

	Connection con = null ;

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  				//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.levelofcare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	//label
	firstItem.add("level_of_care_code");	//name of field
	firstItem.add("10");						//SIZE
	firstItem.add("10");						//LENGTH
	finAr.add(firstItem);					//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  				//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.levelofcare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	// label
	secondItem.add("level_of_care_desc");	//name of field
	secondItem.add("30");					// SIZE
	secondItem.add("30");					//LENGTH
	finAr.add(secondItem);					//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");   		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.INDICATOR.label","common_labels"));		 //label
	thirdItem.add("level_of_care_indicator");   //name

	thirdItem.add("All,------ " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------,A, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ambulatory.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Isolation.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.IntensiveCare.label","am_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CriticalCare.label","am_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgery.label","common_labels")+"");	
 //static values that need to be displayed asamtion.Send it along with the value that is inserted.

	finAr.add(thirdItem); 			 //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   		 //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));		 //label
	fourthItem.add("eff_status");    //name
	fourthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");	 //static values that need to be displayed asamtion.Send it along with the value that is inserted.
	finAr.add(fourthItem); 			 //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.levelofcare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.levelofcare.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

	orderByColVals[0] = "level_of_care_code";
	orderByColVals[1] = "level_of_care_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Level of Care","../jsp/LevelofCareQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());


	        firstItem.clear();
			secondItem.clear();
			thirdItem.clear();
			fourthItem.clear();
			finAr.clear();
%>
