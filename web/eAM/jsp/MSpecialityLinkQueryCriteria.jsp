<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eAM/js/MSpecialityLink.js'></script>
	<%@ page import ="java.util.ArrayList,webbeans.eCommon.ConnectionManager,java.sql.Connection"%>
<%
	String sortorder =
	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")  ;
	String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")  ;
	String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
	String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels")	;
	String speciality_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialityCode.label","common_labels")	;
	String speciality_module = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.SpecialityModule.Label","am_labels")	;
	String short_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")	;
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	try {
			con  =  ConnectionManager.getConnection(request);
			ArrayList finAr = new ArrayList();
			ArrayList firstItem = new ArrayList();
			firstItem.add("List");//Type of item
			firstItem.add(speciality_module);// label
			firstItem.add("speciality_module");//name of field
			firstItem.add("SELECT MODULE_ID, MODULE_NAME FROM SM_MODULE WHERE MODULE_GROUP_ID = 'SS' ORDER BY 2");// SIZE
			finAr.add(firstItem);//add to ArrayList obj finAr


			ArrayList secondItem = new ArrayList();
			secondItem.add("Text");          //Type of item
			secondItem.add(speciality_code);    // label
			secondItem.add("speciality_code");  //name of field
			secondItem.add("20"); // SIZE
			secondItem.add("20"); //LENGTH
			finAr.add(secondItem);    //add to ArrayList obj finAr

			ArrayList thirdItem = new ArrayList();
			thirdItem.add("Text");          //Type of item
			thirdItem.add(short_desc);    // label
			thirdItem.add("short_desc");  //name of field
			thirdItem.add("40");   // SIZE
			thirdItem.add("40");   //LENGTH
			finAr.add(thirdItem);    //add to ArrayList obj finAr

			String[] orderByCols=null;
			String[] orderByColVals=null;
			orderByCols = new String[2];
			orderByColVals = new String[3];
			orderByCols[0] = speciality_code;
			orderByCols[1] = short_desc;

			orderByColVals[0] = "A.speciality_code";
			orderByColVals[1] = "B.short_desc";
				

			strbuff = qrypg.getQueryPage( con,finAr,"Speciality Link","../../eAM/jsp/MSpecialityLinkQueryResult.jsp",sortorder,QueryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
			out.println(strbuff.toString());
	} catch (Exception e) {}
	finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

