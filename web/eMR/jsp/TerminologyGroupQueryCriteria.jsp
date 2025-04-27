<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.*,eMR.*,eCommon.Common.*,com.ehis.eslp.* " %>
<%
	String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%

	try
	{
		request.setCharacterEncoding("UTF-8");
		Connection conn=null ;
		conn = ConnectionManager.getConnection(request);

		ArrayList Terminologyvalues = new ArrayList();
	    ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	
		StringBuffer strbuff;
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologyGroup.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	  // label
		firstItem.add("TerminologyGroup_ID");	//name of field
		firstItem.add("10"); //size
		firstItem.add("10"); //maxlength
		Terminologyvalues.add(firstItem); //add to ArrayList obj finAr
	
		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");   //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologyGroup.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")); //label
		secondItem.add("TerminologyGroup_desc");//name
		secondItem.add("30"); //size
		secondItem.add("60");  //maxlength
		Terminologyvalues.add(secondItem); //add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();
		thirdItem.add("List");   //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSet.label","common_labels")); //label
		thirdItem.add("term_set_id");//name


		String term_set ="select TERM_SET_ID,TERM_SET_DESC from mr_term_set where eff_Status = 'E' order by 2";

		PreparedStatement stmt =conn.prepareStatement(term_set);
		ResultSet rset = stmt.executeQuery();
		
		StringBuffer  a = new StringBuffer("E,------- Select -------,");
		while(rset!=null  && rset.next())
		{
			a.append(rset.getString(1)+","+rset.getString(2)+",");	//static values that need to be displayed as option.
		}
		thirdItem.add(a.toString());
		if ( rset != null) rset.close();
		if ( stmt != null) stmt.close();

//		thirdItem.add("%,Both,C,Certain,U,Uncertain");//static values that need to be displayed as option.

		Terminologyvalues.add(thirdItem); //add to ArrayList obj finAr

		ArrayList fourthItem = new ArrayList();
		fourthItem.add("Text");   //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels")); //label
		fourthItem.add("TerminologySet_desc");//name
		fourthItem.add("30"); //size
		fourthItem.add("30");  //maxlength
		Terminologyvalues.add(fourthItem); //add to ArrayList obj finAr

		ArrayList fifthItem = new ArrayList();
		fifthItem.add("List");   //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); //label
		fifthItem.add("eff_status_yn"); //name
		fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.
		Terminologyvalues.add(fifthItem); //add to ArrayList obj finAr
	
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologyGroup.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologyGroup.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSetID.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSetDescription.label","common_labels");

		orderByColVals[0] = "TERM_GROUP_ID";
		orderByColVals[1] = "TERM_GROUP_DESC";
		orderByColVals[2] = "TERM_SET_ID";
		orderByColVals[3] = "TERM_SET_DESC";

	//session.putValue("orderByColVals",orderByColVals);

		strbuff = qrypg.getQueryPage(conn,Terminologyvalues,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologyGroup.label","mr_labels"),"../jsp/TerminologyGroupQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	
		out.println(strbuff.toString());

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	Terminologyvalues.clear();
	if ( conn != null ) ConnectionManager.returnConnection(conn,request);
	}
	catch (Exception e) 
	{
		//out.println(e.toString());
		e.printStackTrace();
	}

	finally
	{
	}
%>
