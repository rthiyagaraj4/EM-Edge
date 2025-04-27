<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String amb_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AmbulanceType.label","ae_labels");
String id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
String des=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String reg_no=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.registrationno.label","common_labels");
Connection con=null ;

try
	{

		con  =  ConnectionManager.getConnection(request);


		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();
		firstItem.add("List");           //Type of item
		firstItem.add(amb_type);     // label
		firstItem.add("amb_vehicle_type");   //name of field
		firstItem.add("'',ALL,A,Air Ambulance,M,Marine Ambulance,R,Road Ambulance"); // SIZE
		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");          //Type of item
		secondItem.add(id);    // label
		secondItem.add("amb_veh_id");  //name of field
		secondItem.add("10");   // SIZE
		secondItem.add("10");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");          //Type of item
		thirdItem.add(des);    // label
		thirdItem.add("amb_veh_desc");  //name of field
		thirdItem.add("30");   // SIZE
		thirdItem.add("30");   //LENGTH
		finAr.add(thirdItem);    //add to ArrayList obj finAr
		
		ArrayList forthItem = new ArrayList();

		forthItem.add("Text");          //Type of item
		forthItem.add(reg_no);    // label
		forthItem.add("amb_veh_regnno");  //name of field
		forthItem.add("20");   // SIZE
		forthItem.add("20");   //LENGTH
		finAr.add(forthItem);    //add to ArrayList obj finAr
		
		ArrayList fifthItem = new ArrayList();

		fifthItem.add("List");   //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		fifthItem.add("eff_status");//name
		fifthItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
		finAr.add(fifthItem); //add to ArrayList obj finAr


			String[] orderByCols = null;
			String[] orderByColVals = null;


			orderByCols = new String[4];
			orderByColVals = new String[4];


			orderByCols[0] = amb_type;
			orderByCols[1] = id;
			orderByCols[2] = des;
			orderByCols[3] = reg_no;
	

			orderByColVals[0] = "amb_vehicle_type";
			orderByColVals[1] = "AMB_VEHICLE_ID";
			orderByColVals[2] = "AMB_VEHICLE_NAME";
			orderByColVals[3] = "AMB_REGN_NO";

			strbuff = qrypg.getQueryPage(con,finAr,"NoteGroup","../../eAE/jsp/AMBVehicleQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order By",orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
			finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		forthItem.clear();
		fifthItem.clear();
	
} 

catch (Exception e) 
{
	//out.println("Exception@1: "+e.toString());
	e.printStackTrace();
}

finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<SCRIPT LANGUAGE="JavaScript">
//parent.commontoolbarFrame.document.getElementById("apply").disabled = true;
</SCRIPT>

