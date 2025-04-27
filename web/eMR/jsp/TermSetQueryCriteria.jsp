<!DOCTYPE html>
<!--Created by P.Anuradha on Jan-06-2005-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.* " %>
  <%String sStyle	=
  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
try{
	request.setCharacterEncoding("UTF-8");
	Connection conn=null ;
	conn = (Connection) session.getValue( "connection" );
    //HttpSession sess = request.getSession(false);
	ArrayList TermSetValues = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;

	//String function_id = request.getParameter("function_id");

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetId.label","mr_labels"));	  // label
	firstItem.add("TermSet_ID");	//name of field
	firstItem.add("20"); //size
	firstItem.add("20"); //maxlength
	TermSetValues.add(firstItem); //add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels")); //label
	secondItem.add("TermSet_Desc");//name
	secondItem.add("60"); //size
	secondItem.add("60");  //maxlength
	TermSetValues.add(secondItem); //add to ArrayList obj finAr

    ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
    thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); //label
	thirdItem.add("eff_status_yn");//name
	thirdItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.
	TermSetValues.add(thirdItem); //add to ArrayList obj finAr
	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetId.label","mr_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologySetDescription.label","mr_labels");
	orderByColVals[0] = "term_set_id";
	orderByColVals[1] = "term_set_desc";

	strbuff = qrypg.getQueryPage(conn,TermSetValues,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSet.label","labelmon_labels"),"../jsp/TermSetQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
	out.println(strbuff.toString());

	if ( firstItem != null )  firstItem.clear();
	if ( secondItem != null )  secondItem.clear();
	if ( thirdItem != null )  thirdItem.clear();
	if ( TermSetValues != null )  TermSetValues.clear();

	} catch (Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
	}	
	finally	{}
%>

