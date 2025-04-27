<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Sanjay Patil
*	Created On		:	19 jan 2005

--%>


<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.*, eMR.*,eCommon.Common.*,com.ehis.eslp.* " %>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<%
try{
	request.setCharacterEncoding("UTF-8");
	Connection con=null ;
	con = (Connection) session.getValue( "connection" );
    ArrayList finAr = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add("Episode of Care Code");	  // label
	firstItem.add("eoc_code");	//name of field
	firstItem.add("10"); //size
	firstItem.add("20"); //maxlength
	finAr.add(firstItem); //add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add("Episode of Care Description"); //label
	secondItem.add("short_desc");//name
	secondItem.add("50"); //size
	secondItem.add("100");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr
	
	

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add("Nature");// label
	thirdItem.add("eff_status");//name
	thirdItem.add("%,Both,E,Enabled,D,Disabled");//static values that need to be displayed as option.
	finAr.add(thirdItem); //add to ArrayList obj finAr
	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];
	orderByCols[0] = "Episode of Care Code";
	orderByCols[1] = "Episode of Care Description";
	orderByColVals[0] = "eoc_code";
	orderByColVals[1] = "short_desc";
		
	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EpisodeOfCare.label","mr_labels"),"../jsp/EpisodeOfCareQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( finAr != null )  finAr.clear();


	} catch (Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
	}	finally{
		
		
	}
%>


