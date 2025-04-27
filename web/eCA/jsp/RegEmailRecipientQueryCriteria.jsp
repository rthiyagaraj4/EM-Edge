<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../js/RegEmailRecipient.js'></script>

</head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;


Connection con=null ;

try
	{
		con  =  ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");           //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisteredRecipientID.label","ca_labels"));     // label
		firstItem.add("mailer_id");   //name of field
		firstItem.add("4"); // SIZE
		firstItem.add("4"); //LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisteredRecipientName.label","ca_labels"));    // label
		secondItem.add("mailer_name");  //name of field
		secondItem.add("30");   // SIZE
		secondItem.add("30");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr


		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");          //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EmailId.label","ca_labels"));    // label
		thirdItem.add("email_id");  //name of field
		thirdItem.add("34.5");   // SIZE
		thirdItem.add("50");   //LENGTH
		finAr.add(thirdItem);    //add to ArrayList obj finAr
		
		ArrayList fifthItem = new ArrayList();

		fifthItem.add("List");   //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		fifthItem.add("eff_status");//name
		fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
		
		finAr.add(fifthItem); //add to ArrayList obj finAr

		String[] orderByCols = null;
		String[] orderByColVals = null;
		orderByCols = new String[3];
		orderByColVals = new String[3];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisteredRecipientName.label","ca_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RegisteredRecipientName.label","ca_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EmailId.label","ca_labels");
		orderByColVals[0] = "mailer_id";
		orderByColVals[1] = "mailer_name";
		orderByColVals[2] = "email_id";
			
		strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteGroup.label","ca_labels"),"../../eCA/jsp/RegEmailRecipientQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ,orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fifthItem.clear();
} 

catch (Exception e) 
{
	e.printStackTrace() ;
}

finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

