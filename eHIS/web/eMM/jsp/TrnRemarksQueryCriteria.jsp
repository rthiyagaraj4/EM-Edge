<!DOCTYPE html>
<%@page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
//		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<% ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
String function_id = request.getParameter( "function_id" );
ArrayList finAr = new ArrayList();
 
/* For Enhancement  after 10/27/2004

ArrayList firstItem11 = new ArrayList();
firstItem11.add("Text");  		 //Type of item
firstItem11.add("Module ID");	  // label
firstItem11.add("module_id");	//name of field
firstItem11.add("5");	// SIZE
firstItem11.add("2");	//LENGTH
finAr.add(firstItem11);//add to ArrayList obj finAr

ArrayList firstItem12 = new ArrayList();
firstItem12.add("Text");  		 //Type of item
firstItem12.add("TRN Type");	  // label
firstItem12.add("trn_type");	//name of field
firstItem12.add("5");	// SIZE
firstItem12.add("3");	//LENGTH

finAr.add(firstItem12);//add to ArrayList obj finAr */

ArrayList firstItem = new ArrayList();
String Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
firstItem.add("Text");  		 //Type of item
firstItem.add(Code);	  // label
firstItem.add("trn_remarks_code");	//name of field
firstItem.add("10");	// SIZE
firstItem.add("10");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
String Remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
secondItem.add("Text");  //Type of item
secondItem.add(Remarks);  // label
secondItem.add("remarks_desc");   //name of field
secondItem.add("20");	// SIZE
secondItem.add("200");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();
String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
thirdItem.add("List");  //Type of item
thirdItem.add(Nature);  // label
thirdItem.add("nature");   //name of field
thirdItem.add(Nature_List);//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("4");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();
//Type of item
fourthItem.add("Hidden");  // label
fourthItem.add("function_id");   //name of field
fourthItem.add(function_id);//static values that need to be displayed as option.Send it along with the value that is inserted.
	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr

/*

	For Enhancement ie to include Module ID and TRN Type please uncomment all the comments labeled by For Enhancement after 10/27/2004
	and increase the array length to 4.. see the next statement. for array size..

*/

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];
String TransactionRemarksCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.TransactionRemarksCode.label","mm_labels");
String TransactionRemarksDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.TRNRemarksDescription.label","mm_labels");
orderByCols[0] = TransactionRemarksCode;
orderByCols[1] = TransactionRemarksDesc;

/* For Enhancement after 10/27/2004
orderByCols[2] = "Module ID";
orderByCols[3] = "TRN Type"; */

orderByColVals[0] = "trn_remarks_code";
orderByColVals[1] = "remarks_desc";

String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
/*For Enhancement after 10/27/2004
orderByColVals[2] = "module_id";
orderByColVals[3] = "trn_type";*/

strbuff = qrypg.getQueryPage(null,finAr,TransactionRemarksCode,"TrnRemarksQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy,orderByCols, orderByColVals,ExecuteQuery);
out.println(strbuff.toString());
%>
