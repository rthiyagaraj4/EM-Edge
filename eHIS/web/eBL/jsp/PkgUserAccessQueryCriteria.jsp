<!DOCTYPE html>
<%@ page import ="java.util.*, java.sql.*,webbeans.eCommon.*,eOR.Common.* "  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;

	try {
	con = ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");   //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels"));  // label
	firstItem.add("user_id");//name
	firstItem.add("10");
	firstItem.add("30");
	finAr.add(firstItem); //add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");   //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels"));  // label
	secondItem.add("user_name");//name
	secondItem.add("40");
	secondItem.add("60");
	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");   //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.userGroupId.label","bl_labels")); // label
	thirdItem.add("user_grp_id");//name
	thirdItem.add("10");
	thirdItem.add("10");
	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.userGroupName.label","bl_labels")); // label
	fourthItem.add("user_grp_name");//name
	fourthItem.add("40");
	fourthItem.add("100");
	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageCreation.label","bl_labels"));  // label
	fifthItem.add("package_creation");//name
	fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.packageApproval.label","bl_labels"));  // label
	sixthItem.add("package_approval");//name
	sixthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(sixthItem); //add to ArrayList obj finAr

	ArrayList seventhItem = new ArrayList();

	seventhItem.add("List");   //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageTransfer.label","bl_labels"));  // label
	seventhItem.add("package_transfer");//name
	seventhItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(seventhItem); //add to ArrayList obj finAr

	ArrayList eighthItem = new ArrayList();

	eighthItem.add("List");   //Type of item
	eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageDiscount.label","bl_labels"));  // label
	eighthItem.add("package_discount");//name
	eighthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(eighthItem); //add to ArrayList obj finAr

	ArrayList ninth = new ArrayList();
	ninth.add("List");   //Type of item
	ninth.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageRefund.label","bl_labels"));  // label
	ninth.add("package_refund");//name
	ninth.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(ninth); //add to ArrayList obj finAr

	ArrayList tenth = new ArrayList();
	tenth.add("List");   //Type of item
	tenth.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageCancel.label","bl_labels"));  // label
	tenth.add("package_cancel");//name
	tenth.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(tenth); //add to ArrayList obj finAr

	ArrayList eleventh = new ArrayList();
	eleventh.add("List");   //Type of item
	eleventh.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageAdhocRefund.label","bl_labels"));  // label
	eleventh.add("package_adhoc_refund");//name
	eleventh.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(eleventh); //add to ArrayList obj finAr

	String orderByCols[] = new String[11];
	String orderByColVals[] = new String[11];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.userGroupId.label","bl_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.userGroupName.label","bl_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageCreation.label","bl_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.packageApproval.label","bl_labels");
	orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageTransfer.label","bl_labels");	
	orderByCols[7] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageDiscount.label","bl_labels");
	orderByCols[8] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageRefund.label","bl_labels");
	orderByCols[9] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageCancel.label","bl_labels");
	orderByCols[10] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PackageAdhocRefund.label","bl_labels");

	orderByColVals[0] = "user_id";
	orderByColVals[1] = "user_name";
	orderByColVals[2] = "user_grp_id";
	orderByColVals[3] = "user_grp_name";
	orderByColVals[4] = "package_creation";
	orderByColVals[5] = "package_approval";
	orderByColVals[6] = "package_transfer";
	orderByColVals[7] = "package_discount";
	orderByColVals[8] = "package_refund";
	orderByColVals[9] = "package_cancel";
	orderByColVals[9] = "package_adhoc_refund";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/PkgUserAccessQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	strbuff.setLength(0);
	} catch (Exception e) {
			//out.println(e.toString());
			e.printStackTrace();
	}
	finally{
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		 }catch(Exception e){
			System.out.println("exception"+e);
			e.printStackTrace();		 
		 }
	}
%>

