<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*" %>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;

	try
	{
		con = ConnectionManager.getConnection(request);
	
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 // Type of item
	firstItem.add("Facility ID");	 // label
	firstItem.add("operating_facility_id");	//name of field
	firstItem.add("2");	// SIZE
	firstItem.add("2");	// LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add("Facility Name");	  // label
	secondItem.add("facility_name");	//name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr
	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  		 //Type of item
	thirdItem.add("Indicator ID");	  // label
	thirdItem.add("qind_clind_id");	//name of field
	thirdItem.add("4");	// SIZE
	thirdItem.add("4");	// LENGTH

	finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList forthItem = new ArrayList();

	forthItem.add("Text");  		 //Type of item
	forthItem.add("Indicator Description");	  // label
	forthItem.add("qind_clind_desc");	//name of field
	forthItem.add("40");	// SIZE
	forthItem.add("60");	// LENGTH

	finAr.add(forthItem);//add to ArrayList obj finAr


	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");  		 //Type of item
	fifthItem.add("Periodicity");	  // label
	fifthItem.add("dflt_rep_periodicity");	//name of field
	fifthItem.add("S,All,Q,Quarterly,M,Monthly,B,Bi-Annually,A,Annually");
	// LENGTH

	finAr.add(fifthItem);//add to ArrayList obj finAr

	String orderByCols[] = new String[5];
	String orderByColVals[] = new String[5];

	orderByCols[0] = "Facility ID";
	orderByCols[1] = "Facility name";
	orderByCols[2] = "Indicator ID";
	orderByCols[3] = "Indicator Description";
	orderByCols[4] = "Periodicity";

	orderByColVals[0] = "operating_facility_id";
	orderByColVals[1] = "facility_name";
	orderByColVals[2] = "to_number(qind_clind_id)";
	orderByColVals[3] = "qind_clind_desc";
	orderByColVals[4] = "dflt_rep_periodicity";
	
	strbuff = qrypg.getQueryPage(con,finAr,"Find Indicator For Facility ","../../eQA/jsp/QAIndicatorsForFacilityQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	forthItem.clear();
	fifthItem.clear();
	} 
		catch (Exception e) {}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
%>
