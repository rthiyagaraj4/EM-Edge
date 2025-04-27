<!DOCTYPE html>
<%--
	FileName	: AnaesthesiaQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>

<%@ page import="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.* "  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><Script Language="JavaScript" src="../../eCommon/js/common.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</html></head>
<%
	request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con = null;

try
{

	con = ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");   //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AnaesthesiaCode.label","common_labels"));   // label
	firstItem.add("anaesthesia_code");   //name of field
	firstItem.add("4");  // SIZE
	firstItem.add("4");  // LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthesia.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));   // label
	secondItem.add("LONG_DESC");  //name of field
	secondItem.add("40");  // SIZE
	secondItem.add("40");  // LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

    ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	thirdItem.add("eff_status");  //name of field
	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));

	finAr.add(thirdItem);//add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AnaesthesiaCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthesia.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

	orderByColVals[0] = "anaesthesia_code";
	orderByColVals[1] = "LONG_DESC";

	strbuff = qrypg.getQueryPage(con,finAr,"Find ANAESTHESIA", "../../eAM/jsp/AnaesthesiaQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		finAr.clear();
		


	}catch(Exception e){}
	 finally
	 {
		ConnectionManager.returnConnection(con,request);
	 }

%>

