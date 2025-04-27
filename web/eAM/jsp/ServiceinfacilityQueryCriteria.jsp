<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;

try 
{
	con = (Connection) session.getValue( "connection" );




ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 		//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	  		// label
firstItem.add("operating_facility_id");	//name of field
firstItem.add("2");					// SIZE
firstItem.add("2");					//LENGTH

finAr.add(firstItem);					//add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();

secondItem.add("Text");  			//Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));  	// label
secondItem.add("facility_name");   	//name of field
secondItem.add("70");				// SIZE
secondItem.add("35");				//LENGTH

finAr.add(secondItem); 				//add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   				//Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));  		// label
thirdItem.add("service_code");		//name
thirdItem.add("4");					// SIZE
thirdItem.add("4");					//LENGTH

finAr.add(thirdItem); 				//add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   				//Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels"));  	// label
fourthItem.add("service_short_desc");	//name
fourthItem.add("15");				// SIZE
fourthItem.add("15");				//LENGTH

finAr.add(fourthItem); 				//add to ArrayList obj finAr


ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");  	 			//Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  	// label
fifthItem.add("dept_code");			//name
fifthItem.add("10");					// SIZE
fifthItem.add("10");					//LENGTH

finAr.add(fifthItem); 				//add to ArrayList obj finAr


ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");   				//Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  	// label
sixthItem.add("dept_short_desc");		//name
sixthItem.add("15");				// SIZE
sixthItem.add("15");				//LENGTH

finAr.add(sixthItem); 				//add to ArrayList obj finAr


ArrayList seventhItem = new ArrayList();

seventhItem.add("List");  			//Type of item
seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  			// label
seventhItem.add("eff_status");   		//name of field
seventhItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
seventhItem.add("1");				//LENGTH

finAr.add(seventhItem); 				//add to ArrayList obj finAr


String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "operating_facility_id";
orderByColVals[1] = "facility_name";
orderByColVals[2] = "service_code";
orderByColVals[3] = "service_short_desc";
orderByColVals[4] = "dept_code";
orderByColVals[5] = "dept_short_desc";


strbuff = qrypg.getQueryPage(con,finAr,"Find Speciality For Practitioner","../../eAM/jsp/ServiceinfacilityQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels"));

out.println(strbuff.toString());
    firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	//forthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	finAr.clear();
	fourthItem.clear();
//Added for check style for COMMON-ICN-0056
	} catch (Exception e) 
{
out.println("Exception :"+e);
}
finally{
	if(con != null)  ConnectionManager.returnConnection(con,request);
}
%>
