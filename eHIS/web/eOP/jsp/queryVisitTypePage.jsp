<!DOCTYPE html>

 
	<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;

	Connection con=null ;

try {

	con  =  ConnectionManager.getConnection(request);
	Boolean isAERegisterTypeAutoUpdateAppl =	CommonBean.isSiteSpecific(con, "AE", "AE_REG_TYPE_AUTO_UPDATE"); // added by mujafar for KDAH-CRF-0526
	ArrayList finAr = new ArrayList();
	
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");           //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeCode.label","common_labels"));     // label
	firstItem.add("visit_type_code");   //name of field
	firstItem.add("2"); // SIZE
	firstItem.add("2"); //LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");          //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeDescription.label","common_labels"));    // label
	secondItem.add("long_desc");    //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");           //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VisitTypeIndicator.label","op_labels"));    // label
	thirdItem.add("visit_type_ind");    //name of field
	if(isAERegisterTypeAutoUpdateAppl) //Added by mujafar for KDAH-CRF-0526
	{
	thirdItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+",W,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels"));
	}
	else{
	thirdItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels"));
	}
	finAr.add(thirdItem);//add to ArrayList obj finAr


	ArrayList fourthItem = new ArrayList();

	fourthItem.add("List");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	fourthItem.add("eff_status");//name
	fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitTypeDescription.label","common_labels");

	orderByColVals[0] = "visit_type_code";
	orderByColVals[1] = "long_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find VisitType","../../eOP/jsp/queryVisittype.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	finAr.clear();
	orderByCols = null;
	orderByColVals=null;

	} catch (Exception e) {}
	finally
	{
    if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

