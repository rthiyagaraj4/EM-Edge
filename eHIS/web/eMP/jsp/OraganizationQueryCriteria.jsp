<!DOCTYPE html>
<!--
	Developed By       :	Shyam Prasad.P
	Created on   	   :	09/02/2006
	Function		   :	Oraganization
-->
<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<script src='../../eMP/js/Organization.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function calldis()
{
	parent.frames[0].document.getElementById('apply').disabled= true;
}
</script> 
</head>

<body onload="calldis();FocusFirstElement();" onKeyDown='lockKey()'>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
try{
	con = ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OrganizationID.label","mp_labels"));	// label
	firstItem.add("org_id");			//name of field
	firstItem.add("20");			// SIZE
	firstItem.add("10");			//LENGTH
	finAr.add(firstItem);			//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orgName.label","common_labels"));	 // label
	secondItem.add("org_name");		 //name of field
	secondItem.add("20");			 // SIZE
	secondItem.add("20");			 //LENGTH
	finAr.add(secondItem);			 //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");   		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));     // label
	thirdItem.add("eff_status");   	 //name
	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));	 //static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(thirdItem); 			 //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OrganizationID.label","mp_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orgName.label","common_labels");

	orderByColVals[0] = "FAMILY_ORG_ID";
	orderByColVals[1] = "FAMILY_ORG_NAME";

	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Organization.label","common_labels"),"../jsp/OraganizationQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

}catch(Exception e)  { 
	out.println(e.toString());
	e.printStackTrace();
}finally { 
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

