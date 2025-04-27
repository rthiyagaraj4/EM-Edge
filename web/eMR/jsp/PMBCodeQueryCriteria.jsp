<!DOCTYPE html>
<!--Created by Thamizh selvi on 04/10/2016 for GDOH-CRF-0082-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*,org.json.simple.parser.JSONParser,org.json.simple.* " %>
  <%String sStyle	=
  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
try{
	request.setCharacterEncoding("UTF-8");
	Connection conn=null ;
	conn = (Connection) session.getValue( "connection" );
	ArrayList PMBCodeValues = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PMBCode.label","mr_labels"));	  
	firstItem.add("PMBCode");	
	firstItem.add("20"); 
	firstItem.add("20"); 
	PMBCodeValues.add(firstItem); 
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text"); 
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PMBCodeDescription.label","mr_labels")); 
	secondItem.add("PMBCode_Desc");
	secondItem.add("60"); 
	secondItem.add("60");  
	PMBCodeValues.add(secondItem); 

    ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");   
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCode.label","common_labels")); 
	thirdItem.add("TermCode");
	thirdItem.add("20"); 
	thirdItem.add("20");  
	PMBCodeValues.add(thirdItem); 

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");   
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCodeDescription.label","common_labels")); 
	fourthItem.add("TermCode_Desc");
	fourthItem.add("60");
	fourthItem.add("60");  
	PMBCodeValues.add(fourthItem);
	
	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PMBCode.label","mr_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PMBCodeDescription.label","mr_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCode.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCodeDescription.label","common_labels");
	orderByColVals[0] = "pmb_code";
	orderByColVals[1] = "pmb_desc";
	orderByColVals[2] = "term_code";
	orderByColVals[3] = "term_desc";

	strbuff = qrypg.getQueryPage(conn,PMBCodeValues,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSet.label","labelmon_labels"),"../jsp/PMBCodeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( fourthItem != null )  fourthItem.clear();
	if ( PMBCodeValues != null )  PMBCodeValues.clear();

	} catch (Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
	}	
	finally	{}
%>

