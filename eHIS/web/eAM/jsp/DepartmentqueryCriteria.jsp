<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%! 
	ArrayList finAr;
	ArrayList firstItem ;
	ArrayList secondItem;
	ArrayList fourthItem ;%>
<%
	request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	String dept_code_length="";
	//int code_len=0;
	Connection con=null ;
	ResultSet rset=null;
	Statement stmt=null;
	
	try 
	{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		
		rset=stmt.executeQuery("Select  dept_code_length from SM_ACC_ENTITY_PARAM order by 1");
		if(rset !=null && rset.next())
		{
		dept_code_length	=	rset.getString("dept_code_length");
		}
		
		if (rset != null) rset.close();
		if(stmt != null) stmt.close();

			finAr = new ArrayList();

			firstItem = new ArrayList();
			firstItem.add("Text");  		 //Type of item
			firstItem.add( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
			firstItem.add("dept_code");	//name of field
			firstItem.add(dept_code_length);	// SIZE
			firstItem.add(dept_code_length);	//LENGTH
			finAr.add(firstItem);//add to ArrayList obj finAr

			secondItem=new ArrayList();
			secondItem.add("Text");  //Type of item
			secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
			secondItem.add("long_desc");   //name of field
			secondItem.add("30");	// SIZE
			secondItem.add("30");	//LENGTH
			finAr.add(secondItem); //add to ArrayList obj finAr

			fourthItem = new ArrayList();
			fourthItem.add("List");  //Type of item
			fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
			fourthItem.add("nature");   //name of field
			fourthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
			finAr.add(fourthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		orderByColVals[0] = "dept_code";
		orderByColVals[1] = "long_desc";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Department","../../eAM/jsp/DepartmentqueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels"));

		out.println(strbuff.toString());
	} 
	catch (Exception e) 
		{}
	finally
	{
		//resetting the arraylist
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		fourthItem.clear();

		ConnectionManager.returnConnection(con,request);
	}
%>
