<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
try {
	con = ConnectionManager.getConnection(request);
	//Added by Sangeetha for ML-MMOH-CRF-0732 
	Boolean increase_leng_pat_series	= CommonBean.isSiteSpecific(con, "MP","INCREASE_LENGTH_PAT_SERIES");


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeriesCode.label","mp_labels"));	  // label
firstItem.add("pat_ser_grp_code");	//name of field
firstItem.add("2");	// SIZE
if(increase_leng_pat_series)
{
	firstItem.add("3");	//LENGTH
}else{
	firstItem.add("2");	//LENGTH
}

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSerieDesc.label","mp_labels"));	  // label
secondItem.add("pat_ser_grp_desc");	//name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SiteFacilityID.label","mp_labels"));	  // label
thirdItem.add("site_or_facility_id");	//name of field
thirdItem.add("2");	// SIZE
thirdItem.add("2");	//LENGTH

finAr.add(thirdItem);//add to ArrayList obj finAr

String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeriesCode.label","mp_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSerieDesc.label","mp_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SiteFacilityID.label","mp_labels");

orderByColVals[0] = "pat_ser_grp_code";
orderByColVals[1] = "pat_ser_grp_desc";
orderByColVals[2] = "site_or_facility_id";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientNumbering.label","mp_labels"),"../../eMP/jsp/queryPatientNumberDetail.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
} catch (Exception e) { 
	// out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174216963 on 22-08-2023 
	}
finally { 
	if(con!=null) ConnectionManager.returnConnection(con,request);
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
