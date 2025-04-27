<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
try {
	con = ConnectionManager.getConnection(request);

boolean isFPPPractApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","FULL_PAYING_PATIENT_PRACT");//Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184


ArrayList finAr = new ArrayList();


ArrayList firstItem1 = new ArrayList();

firstItem1.add("Text");  		 //Type of item
firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	  // label
firstItem1.add("facility_id");	//name of field
firstItem1.add("2");	// SIZE
firstItem1.add("2");	//LENGTH

finAr.add(firstItem1);//add to ArrayList obj finAr

ArrayList firstItem2 = new ArrayList();

firstItem2.add("Text");  		 //Type of item
firstItem2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));	  // label
firstItem2.add("facility_name");	//name of field
firstItem2.add("70");	// SIZE
firstItem2.add("35");	//LENGTH

finAr.add(firstItem2);//add to ArrayList obj finAr



ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));	  // label
firstItem.add("pract_id");	//name of field
firstItem.add("15");	// SIZE
firstItem.add("15");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"));  // label
secondItem.add("pract_name");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("Text");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  // label
thirdItem.add("splty_code");   //name of field
thirdItem.add("4");	// SIZE
thirdItem.add("4");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList forthItem=new ArrayList();

forthItem.add("Text");  //Type of item
forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
forthItem.add("splty_name");   //name of field
forthItem.add("15");	// SIZE
forthItem.add("15");	//LENGTH
finAr.add(forthItem); //add to ArrayList obj finAr

/*Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184 Start*/
ArrayList fifthItem = new ArrayList();
if(isFPPPractApplicable){
	fifthItem.add("List");
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FPP.label","common_labels"));
	fifthItem.add("FPP_Pract");
	fifthItem.add("'',--" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,Y," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
	finAr.add(fifthItem);
}
/*End*/

String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "sm_facility_param.facility_id";
orderByColVals[1] = "sm_facility_param.facility_name";

orderByColVals[2] = "Am_Pract_Specialities.practitioner_id";
orderByColVals[3] = "am_practitioner.practitioner_name";
orderByColVals[4] = "Am_Pract_Specialities.speciality_code";
orderByColVals[5] = "am_speciality.short_desc";



strbuff = qrypg.getQueryPage(con,finAr,"Find Speciality For Practitioner","../../eAM/jsp/queryOPSPractitioner.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
thirdItem.clear();
forthItem.clear();
fifthItem.clear();//Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184
finAr.clear();
firstItem1.clear();
firstItem2.clear();
} catch (Exception e) {}

finally{
	ConnectionManager.returnConnection(con,request);
}
%>
