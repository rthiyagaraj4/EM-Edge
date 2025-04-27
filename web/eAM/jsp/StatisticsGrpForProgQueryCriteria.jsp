<!DOCTYPE html>
<%--
	FileName	:StatisticsGrpForProgQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 23-2-2005 , 10-3-2008
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.util.ArrayList" contentType="text/html;charset=UTF-8" %>
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
		con = ConnectionManager.getConnection(request);//(Connection) session.getValue( "connection" );
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		//firstItem("Module ID");        //label
		firstItem.add ( com.ehis.util.BundleMessage.getBundleMessage ( pageContext , "Common.Module.label" , "common_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	  // label
        firstItem.add("module_id");	//name of field
		firstItem.add("2");	// SIZE
		firstItem.add("2");	//LENGTH

		finAr.add(firstItem);//add to ArrayList obj finAr
		ArrayList fifthItem = new ArrayList();

		fifthItem.add("Text");  		 //Type of item
		//fifthItem.add("Module Name");	  // label
		fifthItem.add ( com.ehis.util.BundleMessage.getBundleMessage ( pageContext , "Common.Module.label" , "common_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels"));				 //label
		fifthItem.add("module_name");	//name of field
		fifthItem.add("30");	// SIZE
		fifthItem.add("30");	//LENGTH

		finAr.add(fifthItem);//add to ArrayList obj finAr
		ArrayList sixthItem = new ArrayList();

		sixthItem.add("Text");  		 //Type of item
		//sixthItem.add("Program ID");	  // label
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ProgramID.label","am_labels"));
		// labels
		sixthItem.add("program_id");	//name of field
		sixthItem.add("30");	// SIZE
		sixthItem.add("30");	//LENGTH

		finAr.add(sixthItem);//add to ArrayList obj finAr
		ArrayList secondItem=new ArrayList();

		secondItem.add("Text");  //Type of item
		//secondItem.add("Program Name");  // label
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ProgramName.label","am_labels"));
		//labels
		secondItem.add("program_name");   //name of field
		secondItem.add("20");	// SIZE
		secondItem.add("20");	//LENGTH

		finAr.add(secondItem); //add to ArrayList obj finAr
		ArrayList thirdItem=new ArrayList();

		thirdItem.add("List");   //Type of item
		//thirdItem.add("Program Type");  // label
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ProgramType.label","am_labels"));			//label
		thirdItem.add("program_type");//name
		//thirdItem.add("B,Both,R,Report,F,Function");//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.report.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels")+"");
		finAr.add(thirdItem); //add to ArrayList obj finAr
		ArrayList seventhItem = new ArrayList();

		seventhItem.add("Text");  		 //Type of item
		//seventhItem.add("Statistics Group ID");	  // label
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.StatisticsGroupID.label","am_labels"));		//label
		seventhItem.add("stat_grp_id");	//name of field
		seventhItem.add("10");	// SIZE
		seventhItem.add("10");	//LENGTH

		finAr.add(seventhItem);//add to ArrayList obj finAr
		ArrayList fourthItem=new ArrayList();

		fourthItem.add("Text");   //Type of item
		//fourthItem.add("Statistics Group Desc");  // label
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StatisticsGroup.label","common_labels") + " "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));
		//labels
		fourthItem.add("stat_grp_desc");//name
		fourthItem.add("20");	// SIZE
		fourthItem.add("20");	//LENGTH

		finAr.add(fourthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		//orderByCols[0] = "Module ID";
		//orderByCols[0] = "Module Name";
		//orderByCols[2] = "Program ID";
		//orderByCols[1] = "Program Name";
		//orderByCols[2] = "Program Type";
		//orderByCols[5] = "Statistics Group ID";
		//orderByCols[3] = "Statistics Group Desc";

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
		orderByCols[1]   = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ProgramName.label","am_labels");
		orderByCols[2]	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ProgramType.label","am_labels");
		orderByCols[3]	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StatisticsGroup.label","common_labels") + " "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

		//orderByColVals[0] = "module_id";
		orderByColVals[0] = "module_name";
		//orderByColVals[2] = "program_id";
		orderByColVals[1] = "program_name";
		orderByColVals[2] = "program_type";
		//orderByColVals[5] = "stat_grp_id";
		orderByColVals[3] = "stat_grp_desc";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Building Code","../../eAM/jsp/StatisticsGrpForProgQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
		out.println(strbuff.toString());


		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		seventhItem.clear();
		finAr.clear();
	} catch (Exception e) {}
	finally
	{
	
	ConnectionManager.returnConnection(con,request);
	}
%>
