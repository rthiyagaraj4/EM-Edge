<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*" %><!--, oracle.jdbc.driver.*-->
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
	request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;

	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminologySet.label","common_labels"));	// label
	firstItem.add("term_set_id");	//name of field
	firstItem.add("20");			// SIZE
	firstItem.add("20");			//LENGTH
	finAr.add(firstItem);			//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminologySet.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	 // label
	secondItem.add("term_code");	 //name of field
	secondItem.add("60");			 // SIZE
	secondItem.add("60");			 //LENGTH
	finAr.add(secondItem);			 //add to ArrayList obj finAr



	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels"));	 // label
	thirdItem.add("short_desc");	 //name of field
	thirdItem.add("60");			 // SIZE
	thirdItem.add("60");			 //LENGTH
	finAr.add(thirdItem);





	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");   		 //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSet.label","mr_labels"));        // label
	fourthItem.add("equivalent_term_set_id");   	 	 //name  
	fourthItem.add("20");			 // SIZE
	fourthItem.add("20");			 //LENGTH
	finAr.add(fourthItem); 			 //add to ArrayList obj finAr




	ArrayList fifthItem = new ArrayList();

	fifthItem.add("Text");  		 //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetCode.label","mr_labels"));  	 //label
	fifthItem.add("equivalent_term_code");  	 //name
	fifthItem.add("60");		         //SIZE 
	fifthItem.add("60");  			 //LENGTH
	finAr.add(fifthItem);





	ArrayList sixthItem = new ArrayList();

	sixthItem.add("Text");  		 //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetDesc.label","mr_labels"));  	 //label
	sixthItem.add("short_desc1");  	 //name
	sixthItem.add("60");		         //SIZE 
	sixthItem.add("60");  			 //LENGTH
	finAr.add(sixthItem);			 //add to ArrayList obj finAr


	String orderByCols[] 	= new String[6];
	String orderByColVals[] = new String[6];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminologySet.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminologySet.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSet.label","mr_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetCode.label","mr_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetDesc.label","mr_labels");

	orderByColVals[0] = "term_set_id";
	orderByColVals[1] = "term_code";
	orderByColVals[2] = "short_desc";
	orderByColVals[3] = "equivalent_term_set_id";
	orderByColVals[4] = "equivalent_term_code";
	orderByColVals[5] = "short_desc1";



	strbuff = qrypg.getQueryPage(con,finAr,"FindTerminologySetForFacility","../jsp/EquivalentTermCodeSetQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( fourthItem != null )  fourthItem.clear();
	if ( fifthItem != null )  fifthItem.clear();
	if ( sixthItem != null )  sixthItem.clear();
	if ( finAr != null )  finAr.clear();
%>
