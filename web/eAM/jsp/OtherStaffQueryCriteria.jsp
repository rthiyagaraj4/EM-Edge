<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<% String sStyle =
checkForNull((String)session.getAttribute("PREFERRED_STYLE"),
"IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css'
href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;
String nat_id_prompt="";//Added for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020
try {
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);	

	//Added for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020
	boolean isPractOtherStaff = isPractOtherStaff = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","PRACT_OTHER_STAFF");
	nat_id_prompt=eAM.AMCommonBean.getNationalIDPrompt(con); 
	if(nat_id_prompt.equals("")) nat_id_prompt=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OtherStaffID.label","am_labels"));	  // label
firstItem.add("other_staff_id");	//name of field
firstItem.add("15");	// SIZE
firstItem.add("15");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaffName.label","common_labels"));	  // label
secondItem.add("other_staff_name");	//name of field
secondItem.add("28");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("List");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaffType.label","common_labels"));	  // label
thirdItem.add("other_staff_type");	//name of field
thirdItem.add("select 'All' other_staff_type,'All' short_desc from dual union select other_staff_type,short_desc from am_other_staff_type where eff_status='E'  order by short_desc");
finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem1 = new ArrayList();
fourthItem1.add("List");   //Type of item
fourthItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Position.label","common_labels"));  // label
fourthItem1.add("Position");//name
fourthItem1.add("SELECT position_code, position_desc FROM am_position WHERE eff_status='E' ORDER BY position_desc");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem1); //add to ArrayList obj finAr

ArrayList fourthItem2 = new ArrayList();
fourthItem2.add("List");   //Type of item
fourthItem2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmplStatus.label","common_labels"));  // label
fourthItem2.add("empl_status");//name
fourthItem2.add("'',,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Associate.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FullTime.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartTime.label","common_labels")+",V,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visitor.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem2); //add to ArrayList obj finAr

ArrayList fourthItem3 = new ArrayList();
fourthItem3.add("List");   //Type of item
fourthItem3.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));  // label
fourthItem3.add("all_facilities_yn");//name
fourthItem3.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem3); //add to ArrayList obj finAr

ArrayList fourthItem4 = new ArrayList();
fourthItem4.add("List");   //Type of item
fourthItem4.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.RepFacility.label","am_labels"));  // label
fourthItem4.add("reporting_facility_id");//name
fourthItem4.add("select facility_id,facility_name from sm_facility_param where facility_type='F' and STATUS ='E' order by facility_name");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem4); //add to ArrayList obj finAr



ArrayList fourthItem = new ArrayList();
//ArrayList valItem=new ArrayList();
fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fourthItem.add("eff_status");//name
fourthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr


/*Added for MOHE-CRF-0019 by Kamatchi S 12-JUN-2020*/
ArrayList fifthItem= new ArrayList();
ArrayList fifthItem1= new ArrayList();
if(isPractOtherStaff)
	{


fifthItem.add("Text");  		 //Type of item
fifthItem.add(nat_id_prompt);	  // label
fifthItem.add("National_ID");	//name of field
fifthItem.add("15");	// SIZE
fifthItem.add("20");	// LENGTH
finAr.add(fifthItem);



fifthItem1.add("Text");  		 //Type of item
fifthItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","common_labels"));	  // label
fifthItem1.add("OTHER_ALT_NO");	//name of field
fifthItem1.add("15");	// SIZE
fifthItem1.add("20");   // LENGTH
finAr.add(fifthItem1);
	}
/*End of MOHE-CRF-0019*/


String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OtherStaffID.label","am_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaffName.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaffType.label","common_labels");



orderByColVals[0] = "a.other_staff_id";
orderByColVals[1] = "a.other_staff_name";
orderByColVals[2] = "a.other_staff_type";




strbuff = qrypg.getMultiColumnQueryPage(con,finAr," OtherStaff ","../../eAM/jsp/OtherStaffQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString().replace("nowrap",""));
} catch (Exception e) {
	
	out.println(e);

}
finally{
ConnectionManager.returnConnection(con,request);
}

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
