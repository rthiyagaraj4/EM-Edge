<!DOCTYPE html>
<%--
	FileName	: CircumstanceofInjuryQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>


<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></html></head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

try {
	con = (Connection) session.getValue( "connection" );
	



ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CircumstanceofInjuryCode.label","common_labels"));			// label
firstItem.add("circumstance_of_injury_code");	//name of field
firstItem.add("4");			// SIZE
firstItem.add("4");			//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		//Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CircumstanceofInjury.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  	// label
secondItem.add("long_desc");		//name of field
secondItem.add("30");			// SIZE
secondItem.add("30");			//LENGTH
finAr.add(secondItem);			//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   		    //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReimbursementType.label","am_labels"));		    // label
thirdItem.add("injury_reimbursement_type");	    //name
thirdItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",GE,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.GovernmentEmployees.label","am_labels")+",MV,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.MotorVehicleAccidentFund.label","am_labels")+",NA,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels")+",OT,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+",WC,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.WorkmenCompensationFund.label","am_labels"));
//thirdItem.add("A,All,MV,Motor Vehicle Accident Fund,WC,Workmen's Compensation Fund,NA,Not Applicable,OT,Others,GE,Government Employees");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(thirdItem); 			    //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   		      //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  		      // label
fourthItem.add("eff_status");		      //name
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fourthItem); 			      //add to ArrayList obj finAr


String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CircumstanceofInjuryCode.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CircumstanceofInjury.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReimbursementType.label","am_labels");



orderByColVals[0] = "circumstance_of_injury_code";
orderByColVals[1] = "long_desc";
orderByColVals[2] = "injury_reimbursement_type";




strbuff = qrypg.getQueryPage(con,finAr,"Find Service","../../eAM/jsp/CircumstanceofInjuryQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
finAr.clear();
//Added for check style for COMMON-ICN-0056
} catch (Exception e)  {
//out.println("Exception :"+e);
e.printStackTrace();
}
finally{
	if(con != null)  ConnectionManager.returnConnection(con,request);
	
}

%>

