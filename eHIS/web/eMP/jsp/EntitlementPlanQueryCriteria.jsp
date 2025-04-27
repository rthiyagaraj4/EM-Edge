<!DOCTYPE html>
<!-- 
	Query Criteria for Entitlement Plan
	Created		: 2/10/2006 11:08 AM
	Modified		: 2/10/2006 11:08 AM
	Created By	: Vinod Babu MV
-->	
<%@ page import="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con=null ;
%>

<%
try
{
	    
	con = ConnectionManager.getConnection(request);
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	String ip_install_yn = "N";
	String op_install_yn = "N";
	String module_id = "";
	Statement stmt = null;
	ResultSet rs  = null;
	stmt = con.createStatement();
	rs = stmt.executeQuery("SELECT module_id, install_yn FROM sm_module WHERE module_id = 'IP' or module_id = 'OP'");
	if (rs != null)
	while(rs.next())
	{
		module_id = rs.getString("module_id");
		if (module_id.equals("IP"))
			ip_install_yn = rs.getString("install_yn");
		else
		if (module_id.equals("OP"))
			op_install_yn = rs.getString("install_yn");
	}
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%

ecis.utils.CommonQueryPage  qryPage = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels"));	// label
firstItem.add("PAT_CAT_CODE");	//name of field
firstItem.add("15");			// SIZE
firstItem.add("15");			//LENGTH
finAr.add(firstItem);			//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("List");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EntitlementBy.label","mp_labels"));	 // label
secondItem.add("ENTITLEMENT_CRITERIA");	 //name of field
secondItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,3,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+",2,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+",1,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+",");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));        // label
thirdItem.add("ENTITLEMENT_FACILITY_ID");   	 	 //name
thirdItem.add("48");			 // SIZE
thirdItem.add("35");			 //LENGTH
finAr.add(thirdItem); 			 //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");  		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));  	 //label
fourthItem.add("ENTITLEMENT_CARE_LOCN_IND");  	 //name

if ( (ip_install_yn.equals("Y")) && (op_install_yn.equals("Y")) )
	fourthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
else
if ( (ip_install_yn.equals("Y")) && (op_install_yn.equals("N")) )
	fourthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"));
else
if ( (ip_install_yn.equals("N")) && (op_install_yn.equals("Y")) )
	fourthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"));
else
if ( (ip_install_yn.equals("N")) && (op_install_yn.equals("N")) )
	fourthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--");

finAr.add(fourthItem);			 //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");   		 //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));        // label
fifthItem.add("ENTITLEMENT_CRITERIA_CODE");   	 	 //name
fifthItem.add("30");			 // SIZE
fifthItem.add("30");			 //LENGTH
finAr.add(fifthItem); 			 //add to ArrayList obj finAr

String orderByCols[] 	= new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EntitlementBy.label","mp_labels");

orderByColVals[0] = "pat_cat_code";
orderByColVals[1] = "entitlement_criteria";


strbuff = qryPage.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EntitlementPlan.label","mp_labels"),"../jsp/EntitlementPlanQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
out.println(strbuff.toString());

if ( firstItem != null ) firstItem.clear(); 
if ( secondItem != null ) secondItem.clear(); 
if ( thirdItem != null ) thirdItem.clear(); 
if ( fourthItem != null ) fourthItem.clear(); 
if ( fifthItem != null ) fifthItem.clear(); 
if ( finAr != null ) finAr.clear(); 

}catch(Exception e)
{
	e.printStackTrace();
}
finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>
<%!
	public static String checkForNull(String inputStr,String defaultVal)
	{
		 return ( ((inputStr==null) || (inputStr=="null") || (inputStr=="") ) ?  defaultVal : inputStr );
	}
%>
