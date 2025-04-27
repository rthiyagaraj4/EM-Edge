<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	StringBuffer strbuff;
	StringBuffer module_buff = new StringBuffer();

	module_buff.append("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels"));



try {
	 String module_query="select MODULE_ID,MODULE_NAME   from SM_module where MODULE_GROUP_ID='SS' order by 2";
	 
		con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(module_query.toString());
		rset = pstmt.executeQuery();
		while(rset!=null && rset.next()){
			module_buff.append(","+rset.getString(1)+","+rset.getString(2));
		}

		if(rset!=null)
		rset.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();

		ArrayList finAr = new ArrayList();

		
		ArrayList firstItem = new ArrayList();
		firstItem.add("List");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","ca_labels"));	  // label
		firstItem.add("module_id");	//name of field
		firstItem.add(module_buff.toString());
				
		finAr.add(firstItem);//add to ArrayList obj finAr


		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");  		 //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityEvent.label","ca_labels"));	  // label
		secondItem.add("event_id");	//name of field
		secondItem.add("6");	// SIZE
		secondItem.add("6");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

		ArrayList thirdItem=new ArrayList();

		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EventDescription.label","common_labels"));	  // label
		thirdItem.add("event_desc");	//name of field
		thirdItem.add("30");	// SIZE
		thirdItem.add("30");	//LENGTH

		finAr.add(thirdItem);//add to ArrayList obj finAr

		ArrayList fourthItem=new ArrayList();

		fourthItem.add("Text");  		 //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.outcome.label","common_labels"));	  // label
		fourthItem.add("outcome_code");	//name of field
		fourthItem.add("6");	// SIZE
		fourthItem.add("6");	//LENGTH

		finAr.add(fourthItem);//add to ArrayList obj finAr

		ArrayList fifthItem=new ArrayList();

		fifthItem.add("Text");  		 //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.outcome.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
		fifthItem.add("outcome_desc");	//name of field
		fifthItem.add("30");	// SIZE
		fifthItem.add("30");	//LENGTH

		finAr.add(fifthItem);//add to ArrayList obj finAr

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EventDescription.label","ca_labels");
		orderByCols[1] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.outcome.label","common_labels");
		

		orderByColVals[0] = "SPLTY_EVENT_DESC";
		orderByColVals[1] = "OUTCOME_DESC";
	

		strbuff = qrypg.getQueryPage(con,finAr,"Find Event Outcomes","../jsp/SpltyEventOutcomeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());

		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();

		} 
		catch (Exception e) 
			{
				//out.println("Exception @ try"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();//COMMON-ICN-0181
			}
		finally
			{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
		%>

