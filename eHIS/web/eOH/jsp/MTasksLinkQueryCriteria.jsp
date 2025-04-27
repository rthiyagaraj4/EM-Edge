<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String locale = (String)session.getAttribute("LOCALE");

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eOH/js/MSpecialityLink.js'></script>
	<%@ page import ="java.util.ArrayList,webbeans.eCommon.ConnectionManager,java.sql.Connection"%>
<%
	String sortorder =
	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")  ;
	String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")  ;
	String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.DefaultSelect.Label","oh_labels");
	String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
	String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels")	;
	String task_code_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TaskCode.Label","oh_labels")	;
	String task_desc_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TaskDescription.Label","oh_labels")	;
	String treatment_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treatment.label","common_labels")	;
	//String short_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")	;
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	try {
			con  =  ConnectionManager.getConnection(request);
			ArrayList finAr = new ArrayList();
			ArrayList firstItem = new ArrayList();
			firstItem.add("List");//Type of item
			firstItem.add(treatment_title);// label
			firstItem.add("trmt_code");//name of field
			firstItem.add("SELECT TRMT_CODE, TRMT_DESC FROM OH_TREATMENT_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND EFF_STATUS = 'E' ORDER BY TRMT_DESC");// SIZE
			finAr.add(firstItem);//add to ArrayList obj finAr


			ArrayList secondItem = new ArrayList();
			secondItem.add("Text");          //Type of item
			secondItem.add(task_code_title);    // label
			secondItem.add("task_code");  //name of field
			secondItem.add("20"); // SIZE
			secondItem.add("20"); //LENGTH
			finAr.add(secondItem);    //add to ArrayList obj finAr

			ArrayList thirdItem = new ArrayList();
			thirdItem.add("Text");          //Type of item
			thirdItem.add(task_desc_title);    // label
			thirdItem.add("task_desc");  //name of field
			thirdItem.add("60");   // SIZE
			thirdItem.add("60");   //LENGTH
			finAr.add(thirdItem);    //add to ArrayList obj finAr

			String[] orderByCols=null;
			String[] orderByColVals=null;
			orderByCols = new String[3];
			orderByColVals = new String[3];
			orderByCols[0] = treatment_title;
			orderByCols[1] = task_code_title;
			orderByCols[2] = task_desc_title;

			orderByColVals[0] = "trmt_code,seq_no";
			orderByColVals[1] = "task_code";
			orderByColVals[2] = "task_desc";
				

			strbuff = qrypg.getQueryPage( con,finAr,"Tasks Link","../../eOH/jsp/MTasksLinkQueryResult.jsp",sortorder,QueryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
			out.println(strbuff.toString());

			finAr.clear();
			firstItem.clear();
			secondItem.clear();
			thirdItem.clear();
			
	} catch (Exception e) {}
	finally{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

