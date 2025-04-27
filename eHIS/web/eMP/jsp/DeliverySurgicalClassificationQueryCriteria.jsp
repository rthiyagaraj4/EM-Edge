<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
Boolean isModifyLongShortDescAppl = false;

try {
	con = ConnectionManager.getConnection(request);

	isModifyLongShortDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MODIFY_LONG_SHORT_DESC");//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	if(isModifyLongShortDescAppl)
	{
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgClass.label","mp_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
	}else
	{
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgicalClassificationCode.label","mp_labels"));	  // label
	}
	firstItem.add("Dely_Surg_Class_Code");	//name of field
	firstItem.add("10");	// SIZE
	firstItem.add("10");	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();

	secondItem.add("Text");  //Type of item
	//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	if(isModifyLongShortDescAppl)
	{
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgClass.label","mp_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	}else
	{
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgicalClassificationDesc.label","mp_labels"));  // label
	}
	secondItem.add("short_desc");   //name of field
	//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	if(isModifyLongShortDescAppl)
	{
		secondItem.add("75");	// SIZE
		secondItem.add("75");	//LENGTH
	}else
	{
		secondItem.add("30");	// SIZE
		secondItem.add("30");	//LENGTH
	}

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

	//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	if(isModifyLongShortDescAppl)
	{
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgClass.label","mp_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgClass.label","mp_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	}else
	{
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgicalClassificationCode.label","mp_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgicalClassificationDesc.label","mp_labels");
	}

	orderByColVals[0] = "Dely_Surg_Class_Code";
	orderByColVals[1] = "long_desc";
	
	//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	if(isModifyLongShortDescAppl)
	{
	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgClass.label","mp_labels"),"../jsp/DeliverySurgicalClassificationQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	}else
	{
	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.DeliverySurgicalClassification.label","mp_labels"),"../jsp/DeliverySurgicalClassificationQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	}

	out.println(strbuff.toString());
} catch (Exception e) {out.println(e.toString());}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>

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
