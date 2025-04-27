<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

 <%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*,eCommon.XSSRequestWrapper" %>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
 <%!
	 ArrayList finAr;
	ArrayList firstItem1;
	ArrayList firstItem2;
	ArrayList firstItem;
	ArrayList secondItem;
	ArrayList thirdItem;
	ArrayList fourthItem;
	ArrayList thirdItemaddl;
	ArrayList fourthItemaddl;
	ArrayList fifthItem;
%>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
StringBuffer strbuff;
Connection con=null ;
try
{
	finAr = new ArrayList();

	firstItem1 = new ArrayList();
		firstItem1.add("Text");  	 	//Type of item
		firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	 	// label
		firstItem1.add("facility_id");	 	//name of field
		firstItem1.add("2");		 	// SIZE
		firstItem1.add("2");		 	//LENGTH

		finAr.add(firstItem1);//add to ArrayList obj finAr

	firstItem2 = new ArrayList();
		firstItem2.add("Text");  	 	//Type of item
		firstItem2.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));	 	// label
		firstItem2.add("facility_name");	 	//name of field
		firstItem2.add("70");		 	// SIZE
		firstItem2.add("35");		 	//LENGTH

		finAr.add(firstItem2);//add to ArrayList obj finAr

	 firstItem = new ArrayList();
		firstItem.add("Text");  	 	//Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TeamID.label","common_labels"));	 	// label
		firstItem.add("team_id");	 	//name of field
		firstItem.add("6");		 	// SIZE
		firstItem.add("6");		 	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr

 secondItem=new ArrayList();
	secondItem.add("Text");  		//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Team.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")); 	// label
	secondItem.add("team_short_desc");   	//name of field
	secondItem.add("15");			// SIZE
	secondItem.add("15");			//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

 thirdItemaddl=new ArrayList();
	thirdItemaddl.add("Text");  	 	//Type of item
	thirdItemaddl.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	 	// label
	thirdItemaddl.add("speciality_code");	 	//name of field
	thirdItemaddl.add("4");		 	// SIZE
	thirdItemaddl.add("4");		 	//LENGTH

	finAr.add(thirdItemaddl); //add to ArrayList obj finAr

 fourthItemaddl=new ArrayList();
	fourthItemaddl.add("Text");  	 	//Type of item
	fourthItemaddl.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	 	// label
	fourthItemaddl.add("speciality_desc");	 	//name of field
	fourthItemaddl.add("15");		 	// SIZE
	fourthItemaddl.add("15");		 	//LENGTH

	finAr.add(fourthItemaddl); //add to ArrayList obj finAr


 thirdItem=new ArrayList();
	thirdItem.add("Text");  		//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels")); 	// label
	thirdItem.add("practitioner_id");   	//name of field
	thirdItem.add("15");			// SIZE
	thirdItem.add("15");			//LENGTH
	finAr.add(thirdItem); //add to ArrayList obj finAr

fourthItem=new ArrayList();
	fourthItem.add("Text");  		//Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"));  	// label
	fourthItem.add("practitioner_short_name");   	//name of field
	fourthItem.add("30");			// SIZE
	fourthItem.add("30");			//LENGTH
	finAr.add(fourthItem); //add to ArrayList obj finAr

fifthItem=new ArrayList();
	fifthItem.add("List");  		//Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels"));  	// label
	fifthItem.add("practitioner_role");   	//name of field
	fifthItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ,CHIEF,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chief.label","common_labels")+",MEMBER,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Member.label","common_labels")+"");			// SIZE

	finAr.add(fifthItem); //add to ArrayList obj finAr


String orderByCols[] = new String[9];
String orderByColVals[] = new String[9];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TeamID.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Team.label","am_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
orderByCols[7] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");
orderByCols[8] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels");

orderByColVals[0] = "facility_id";
orderByColVals[1] = "facility_name";

orderByColVals[2] = "team_id";
orderByColVals[3] = "team_short_desc";

orderByColVals[4] = "speciality_code";
orderByColVals[5] = "SHORT_DESC";

orderByColVals[6] = "practitioner_id";
orderByColVals[7] = "practitioner_short_name";
orderByColVals[8] = "practitioner_role";


strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Practitioners For Team","../jsp/PractForTeamQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString().replace("nowrap",""));
}
catch(Exception e)
{

}
finally
{
	finAr.clear();
	firstItem1.clear();
	firstItem2.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItemaddl.clear();
	fourthItemaddl.clear();
	fifthItem.clear();

ConnectionManager.returnConnection(con,request);
}


%>
