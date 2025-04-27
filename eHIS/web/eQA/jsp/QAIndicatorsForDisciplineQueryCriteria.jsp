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
	firstItem.add("Discipline Code");	 // label
	firstItem.add("qind_discipline_id");	//name of field
	firstItem.add("4");	// SIZE
	firstItem.add("4");	// LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add("Discipline Description");	  // label
	secondItem.add("qind_discipline_desc");	//name of field
	secondItem.add("40");	// SIZE
	secondItem.add("40");	// LENGTH

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


//add to ArrayList obj finAr


	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

    orderByCols[0]    = "Discipline Code";
	orderByCols[1]	  = "Discipline Description";
	orderByCols[2]    = "Indicator ID";
	orderByCols[3]    = "Indicator Description";
	orderByColVals[0] = "qind_discipline_id";
	orderByColVals[1] = "qind_discipline_desc";
	orderByColVals[2] = "to_number(qind_clind_id)";
	orderByColVals[3] = "qind_clind_desc";
	
	strbuff = qrypg.getQueryPage(con,finAr,"Find Indicator For Facility ","../../eQA/jsp/QAIndicatorsForDisciplineQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());
	finAr.clear();
    firstItem.clear();
    secondItem.clear();
    thirdItem.clear();
    forthItem.clear();
	
	} 
		catch (Exception e) {out.println("Exception in QAIndicatorsForDisciplineQueryCriteria"+e.toString());}
		finally{
			ConnectionManager.returnConnection(con,request);
		
		}

%>
