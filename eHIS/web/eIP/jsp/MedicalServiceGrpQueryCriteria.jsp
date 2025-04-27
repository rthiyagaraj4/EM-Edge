<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page   contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MedicalServiceGroup.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
	firstItem.add("med_ser_grp_code");	//name of field
	firstItem.add("2");	// SIZE
	firstItem.add("2");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MedicalServiceGroup.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
	secondItem.add("long_desc");   //name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

//Added BY SRIDHAR on 10 MAY 2004
//Nursing Unit Applicable To either INPATIENT or DAY CARE 
/*ArrayList ApplToDescItem=new ArrayList();
	ApplToDescItem.add("List");			
	ApplToDescItem.add("Applicable To");
	ApplToDescItem.add("applicable_to");  
	ApplToDescItem.add("'',-- Select --,DC,Day Care,IP,Inpatient");
finAr.add(ApplToDescItem); */

ArrayList thirdItem=new ArrayList();
	thirdItem.add("List");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	thirdItem.add("eff_status");   //name of field
	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
finAr.add(thirdItem); //add to ArrayList obj finAr

String orderByCols[] = new String[2];
orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MedicalServiceGroup.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MedicalServiceGroup.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

String orderByColVals[] = new String[2];
orderByColVals[0] = "med_ser_grp_code";
orderByColVals[1] = "long_desc";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MedicalServiceGroup.label","ip_labels"),"../jsp/MedicalServiceGrpQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
%>

<%!
	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
