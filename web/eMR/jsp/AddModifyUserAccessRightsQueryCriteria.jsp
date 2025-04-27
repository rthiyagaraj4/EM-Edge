<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.* "%>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
	request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;

	Connection con=null ;

//	String opfacilityid=(String) session.getValue("facility_id");

	try {
	con = ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  	//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	// label
	firstItem.add("facility_id");	//name of field
	firstItem.add("2");		// SIZE
	firstItem.add("2");		//LENGTH
	finAr.add(firstItem);		//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  	 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels")); // label
	secondItem.add("facility_name");//name of field
	secondItem.add("50");		// SIZE
	secondItem.add("35");		//LENGTH
	finAr.add(secondItem);		//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  	//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels"));	// label
	thirdItem.add("appl_user_id");	//name
	thirdItem.add("15");		// SIZE
	thirdItem.add("15");		//LENGTH
	//thirdItem.add("Select appl_user_id,appl_user_name from SM_FACILITY_FOR_USER_VW where facility_id ='"+opfacilityid+"' order by 2");
	//thirdItem.add("B,Both,Y,Yes,N,No");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(thirdItem); 		//add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text"); 	//Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels"));   	// label
	fourthItem.add("appl_user_name");//name
	fourthItem.add("30");		 // SIZE
	fourthItem.add("30");		 //LENGTH
	finAr.add(fourthItem); 		//add to ArrayList obj finAr


	String orderByCols[] 	= new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");

	orderByColVals[0] = "facility_id";
	orderByColVals[1] = "facility_name";
	orderByColVals[2] = "appl_user_id";
	orderByColVals[3] = "appl_user_name";


	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserAccessRights.label","common_labels"),"../../eMR/jsp/AddModifyUserAccessRightsQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( fourthItem != null )  fourthItem.clear();
	if ( finAr != null )  finAr.clear();

		} catch (Exception e) {}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
%>
