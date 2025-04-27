<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onLoad="FocusFirstElement();" onKeyDown='lockKey()'>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientCategoryCode.label","mp_labels"));	  // label
	firstItem.add("pat_cat_code");	//name of field
	firstItem.add("4");	// SIZE
	firstItem.add("4");	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();

	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientCategoryDesc.label","mp_labels"));  // label
	secondItem.add("long_desc");   //name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr


	ArrayList thirdItem=new ArrayList();

	thirdItem.add("List");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	thirdItem.add("nature");   //name of field
	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
	thirdItem.add("4");	//LENGTH

	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem=new ArrayList();

	fourthItem.add("List");  //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientCategoryType.label","mp_labels"));  // label
	fourthItem.add("govt_or_pvt_ind");   //name of field 
	fourthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DesignatedRoyalties.label","mp_labels")+",W,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EstateWorkers.label","mp_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Foreigner.label","mp_labels")+",G,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Government.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Pensioner.label","mp_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PersonUnderPoliceCustody.label","mp_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Private.label","common_labels")+",I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Prisoners.label","mp_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RegisteredDisabled.label","mp_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SelfEmployed.label","mp_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Semigovernment.label","mp_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Student.label","mp_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Unemployed.label","mp_labels")+",V,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VIP.label","common_labels")+",K,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
	fourthItem.add("30");	//LENGTH

	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientCategoryCode.label","mp_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientCategoryDesc.label","mp_labels");

	orderByColVals[0] = "pat_cat_code";
	orderByColVals[1] = "long_desc";

	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels"),"../../eMP/jsp/queryPatientCategory.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	out.println(strbuff.toString());
}catch (Exception e) {
	//out.println(e.toString());
	e.printStackTrace();
}finally { 
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

