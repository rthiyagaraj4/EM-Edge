<!DOCTYPE html>
<%--
	FileName	: ComplaintqueryCriteria.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>	


<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</html></head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = (Connection) session.getValue( "connection" );



ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforAdmission.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));// label
firstItem.add("complaint_code"); //name of field
firstItem.add("8");	// SIZE
firstItem.add("8");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforAdmission.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	// label
secondItem.add("complaint_desc"); //name of field
secondItem.add("53");	// SIZE
secondItem.add("60");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("List");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
thirdItem.add("nature");   //name of field
thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("4");	//LENGTH


finAr.add(thirdItem); //add to ArrayList obj finAr

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforAdmission.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforAdmission.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
//orderByCols[2] = "Gender";

orderByColVals[0] = "complaint_code";
orderByColVals[1] = "complaint_desc";
//orderByColVals[2] = "gender";



strbuff = qrypg.getQueryPage(con,finAr,"Find complaint","../../eAM/jsp/ComplaintqueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
thirdItem.clear();
finAr.clear();
//Added for check style for COMMON-ICN-0056
} catch (Exception e) 
{
//out.println("Exception :"+e);
e.printStackTrace();
}
finally{
	if(con != null)  ConnectionManager.returnConnection(con,request);
}

%>

