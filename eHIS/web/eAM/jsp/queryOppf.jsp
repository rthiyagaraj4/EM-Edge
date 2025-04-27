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

boolean isFPPPractApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","FULL_PAYING_PATIENT_PRACT");//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	  // label
firstItem.add("facility_id");	//name of field
firstItem.add("2");	// SIZE
firstItem.add("2");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));  // label
secondItem.add("facility_name");   //name of field
secondItem.add("70");	// SIZE
secondItem.add("35");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("Text");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));  // label
thirdItem.add("pract_id");   //name of field
thirdItem.add("15");	// SIZE
thirdItem.add("15");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();
fifthItem.add("Text");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"));  // label
fifthItem.add("pract_name");//name
fifthItem.add("30");
fifthItem.add("30");
finAr.add(fifthItem); //add to ArrayList obj finAr



ArrayList sixItem = new ArrayList();

sixItem.add("Text");  		 //Type of item
sixItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primaryspeciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
sixItem.add("speciality_code");	//name of field
sixItem.add("4");	// SIZE
sixItem.add("4");	//LENGTH
finAr.add(sixItem);

ArrayList sevenItem = new ArrayList();

sevenItem.add("Text");  		 //Type of item
sevenItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primaryspeciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
sevenItem.add("speciality_desc");	//name of field
sevenItem.add("15");	// SIZE
sevenItem.add("15");	//LENGTH
finAr.add(sevenItem);

ArrayList fItem1 = new ArrayList();
fItem1.add("List");   //Type of item
fItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AssignUnassignedPatient.label","am_labels"));  // label
fItem1.add("allow_unassign_in_practq_yn");//name
fItem1.add("'',--" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,Y," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fItem1); //add to ArrayList obj finAr

/*Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start*/
ArrayList ninthItem = new ArrayList();
if(isFPPPractApplicable){
	ninthItem.add("List");
	ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FPP.label","common_labels"));
	ninthItem.add("FPP_Pract");
	ninthItem.add("'',--" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,Y," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
	finAr.add(ninthItem);
}
/*End*/

ArrayList fItem = new ArrayList();
fItem.add("List");   //Type of item
fItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fItem.add("nature");//name
fItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fItem); //add to ArrayList obj finAr

String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primaryspeciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primaryspeciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "am_pract_for_facility_vw.OPERATING_FACILITY_ID";
orderByColVals[1] = "sm_facility_param.facility_name";
orderByColVals[2] = "am_pract_for_facility_vw.practitioner_id";
//orderByColVals[3] = "am_practitioner.short_name";
orderByColVals[3] = "short_name";
orderByColVals[4] = "am_pract_for_facility_vw.PRIMARY_SPECIALITY_CODE";
orderByColVals[5] = "am_pract_for_facility_vw.PRIMARY_SPECIALITY_DESC";

strbuff = qrypg.getQueryPage(con,finAr,"Find Practitoner For Facility","../../eAM/jsp/queryOppfPage.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fifthItem.clear();
sixItem.clear();
sevenItem.clear();
fItem.clear();
finAr.clear();fItem1.clear();
ninthItem.clear();//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184

} catch (Exception e) {}

finally{
	ConnectionManager.returnConnection(con,request);
}
%>
