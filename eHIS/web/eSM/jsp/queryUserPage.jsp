<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2 
boolean isSSOIntegrationAppl = false;

try {
//	con = (Connection) session.getValue( "connection" );
con = ConnectionManager.getConnection(request);

//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
isSSOIntegrationAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "SM", "SSO_INTEGRATION");


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
String user_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
firstItem.add("Text");  		 //Type of item
firstItem.add(user_id);	  // label
firstItem.add("appl_user_id");	//name of field
firstItem.add("30");	// SIZE
firstItem.add("30");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
String user_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
secondItem.add("Text");  		 //Type of item
secondItem.add(user_name);	  // label
secondItem.add("appl_user_name");	//name of field
secondItem.add("30");	// SIZE
secondItem.add("60");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.FunctionalRoleType.label","sm_labels"));	  // label
thirdItem.add("func_role_type");	//name of field
thirdItem.add("z,----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----,P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaff.label","common_labels"));
thirdItem.add("1");

finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");  		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));	  // label
fourthItem.add("pract_type");	//name of field
fourthItem.add("select PRACT_TYPE, DESC_SYSDEF from am_pract_type");

finAr.add(fourthItem);//add to ArrayList obj finAr

ArrayList fifthItem12 = new ArrayList();

fifthItem12.add("List");  		 //Type of item
fifthItem12.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaffType.label","common_labels"));	  // label
fifthItem12.add("other_staff_type");	//name of field
fifthItem12.add("select OTHER_STAFF_TYPE PRACT_TYPE, SHORT_DESC DESC_SYSDEF from am_other_staff_type");

finAr.add(fifthItem12);//add to ArrayList obj finAr

ArrayList fifthItem1 = new ArrayList();
String pract_oth_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+" /"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaff.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
fifthItem1.add("Text");  		 //Type of item
fifthItem1.add(pract_oth_id);	  // label
fifthItem1.add("pract_id");	//name of field
fifthItem1.add("15 ");
fifthItem1.add("15 ");
finAr.add(fifthItem1);//add to ArrayList obj finAr



ArrayList fifthItem = new ArrayList();
String pract_oth_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+" /"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaff.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
fifthItem.add("Text");  		 //Type of item
fifthItem.add(pract_oth_name);	  // label
fifthItem.add("pract_name");	//name of field
fifthItem.add("30");
fifthItem.add("30");
finAr.add(fifthItem);//add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();
String emp_no=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EmployeeNo.label","common_labels");
sixthItem.add("Text");  		 //Type of item
sixthItem.add(emp_no);	  // label
sixthItem.add("emp_no");	//name of field
sixthItem.add("10");	// SIZE
sixthItem.add("10");	//LENGTH

finAr.add(sixthItem);

//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
ArrayList eigthItem = new ArrayList();

if(isSSOIntegrationAppl){

	String active_dir_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ActiveDirectoryID.label","sm_labels");
	eigthItem.add("Text");  		 //Type of item
	eigthItem.add(active_dir_id);	  // label
	eigthItem.add("active_dir_id");	//name of field
	eigthItem.add("91");	// SIZE
	eigthItem.add("80");	//LENGTH

	finAr.add(eigthItem);
}

ArrayList seventhItem = new ArrayList();

seventhItem.add("List");  		 //Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));	  // label
seventhItem.add("eff_status");	//name of field
seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));

finAr.add(seventhItem);//add to ArrayList obj finAr

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = user_id;
orderByCols[1] = user_name;

orderByColVals[0] = "appl_user_id"; 
orderByColVals[1] = "appl_user_name";


strbuff = qrypg.getQueryPage(con,finAr,"Find User ","../../eSM/jsp/queryUser.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());

      strbuff.setLength(0);
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem12.clear();
		fifthItem1.clear();
		fifthItem.clear();
		sixthItem.clear();
		seventhItem.clear();
		eigthItem.clear();

} catch (Exception e) {}
finally { 
	ConnectionManager.returnConnection(con,request);
}
%>
