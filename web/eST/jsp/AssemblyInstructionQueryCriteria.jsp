<!DOCTYPE html>
 <%@page import="java.util.*, eST.*, eST.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
		request.setCharacterEncoding("UTF-8");
		
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
	ArrayList finAr		= new ArrayList();
	ArrayList firstItem = new ArrayList(); 
	ArrayList secondItem=new ArrayList();
	ArrayList thirdItem	=new ArrayList();
	ArrayList fourthItem=new ArrayList();
try{
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	String function_id = request.getParameter( "function_id" );
	String Assembly_instruct_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	firstItem.add("Text");  		 //Type of item
	firstItem.add(Assembly_instruct_Code);	  // label
	firstItem.add("assm_instrn_code");	//name of field
	firstItem.add("4");	// SIZE
	firstItem.add("4");	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	String Assembly_instruct_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

	secondItem.add("Text");  //Type of item
	secondItem.add(Assembly_instruct_Desc);  // label
	secondItem.add("description");   //name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","mm_labels");
	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	thirdItem.add("List");  //Type of item
	thirdItem.add(Nature);  // label
	thirdItem.add("eff_status");   //name of field
	thirdItem.add(Nature_List);//static values that need to be displayed as option.Send it along with the value that is inserted.
	thirdItem.add("4");	//LENGTH

	finAr.add(thirdItem); //add to ArrayList obj finAr


	//Type of item
	fourthItem.add("Hidden");  // label
	fourthItem.add("function_id");   //name of field
	fourthItem.add(function_id);//static values that need to be displayed as option.Send it along with the value that is inserted.

		//LENGTH

	finAr.add(fourthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];


	orderByCols[0] = Assembly_instruct_Code;
	orderByCols[1] = Assembly_instruct_Desc;

	orderByColVals[0] = "assm_instrn_code";
	orderByColVals[1] = "description";

	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	strbuff = qrypg.getQueryPage(null,finAr,Assembly_instruct_Code,"AssemblyInstructionQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
}catch(Exception e){
	e.printStackTrace();
}finally{
	finAr.clear();		
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();	
	fourthItem.clear();
}
%>
