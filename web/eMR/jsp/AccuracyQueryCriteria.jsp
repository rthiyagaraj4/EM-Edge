<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*, eMR.*,eCommon.Common.*,com.ehis.eslp.* " %><!--oracle.jdbc.driver.*,-->
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
try{
	request.setCharacterEncoding("UTF-8");
	Connection conn=null ;
	conn = (Connection) session.getValue( "connection" );
//    HttpSession sess = request.getSession(false);
	ArrayList Accuracyvalues = new ArrayList();
	      ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AccuracyCode.label","mr_labels"));	  // label
	firstItem.add("Accuracy_code");	//name of field
	firstItem.add("10"); //size
	firstItem.add("10"); //maxlength
	Accuracyvalues.add(firstItem); //add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AccuracyDescription.label","mr_labels")); //label
	secondItem.add("Accuracy_Longdesc");//name
	secondItem.add("30"); //size
	secondItem.add("30");  //maxlength
	Accuracyvalues.add(secondItem); //add to ArrayList obj finAr


	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accuracy.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.INDICATOR.label","common_labels")); //label
	thirdItem.add("Indicator");//name
	thirdItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Certain.label","common_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Uncertain.label","common_labels"));//static values that need to be displayed as option.
	Accuracyvalues.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); //label
	fourthItem.add("eff_status_yn");//name
	fourthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.
	Accuracyvalues.add(fourthItem); //add to ArrayList obj finAr
	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AccuracyCode.label","mr_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AccuracyDescription.label","mr_labels");
	orderByColVals[0] = "accuracy_code";
	orderByColVals[1] = "long_desc";

	strbuff = qrypg.getQueryPage(conn,Accuracyvalues,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accuracy.label","common_labels"),"../jsp/AccuracyQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	out.println(strbuff.toString());

	if ( firstItem != null ) firstItem.clear(); 
	if ( secondItem != null ) secondItem.clear(); 
	if ( thirdItem != null ) thirdItem.clear(); 
	if ( fourthItem != null ) fourthItem.clear(); 
	if ( Accuracyvalues != null ) Accuracyvalues.clear(); 


	} catch (Exception e) 
	{
		//out.println(e.toString());
		e.printStackTrace();
	}	finally{
	}
%>


