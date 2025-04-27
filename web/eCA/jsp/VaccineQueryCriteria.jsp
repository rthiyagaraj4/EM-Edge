<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
	<%  request.setCharacterEncoding("UTF-8");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
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

		firstItem.add("Text"); 
        firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));     // label
        firstItem.add("vaccine_id");   //name of field
        firstItem.add("10"); // SIZE
        firstItem.add("10"); //LENGTH
        finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels"));    // label
		secondItem.add("vaccine_long_desc");  //name of field
		secondItem.add("60");   // SIZE
		secondItem.add("60");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");          //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")); 
		// label
		thirdItem.add("vaccine_short_desc");  //name of field
		thirdItem.add("40");   // SIZE
		thirdItem.add("40");   //LENGTH
		finAr.add(thirdItem);    //add to ArrayList obj finAr


		/*ArrayList fourthItem = new ArrayList();

        fourthItem.add("List");   //Type of item
        fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CanBeUsedAsAdhoc.label","ca_labels"));  // label
        fourthItem.add("adhoc_yn");//name
        fourthItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");   
        finAr.add(fourthItem); //add to ArrayList obj finAr

		ArrayList fifthItem = new ArrayList();

        fifthItem.add("List");   //Type of item
        fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DuplicateCheckRecquired.label","ca_labels"));  // label
        fifthItem.add("check_dup_yn");//name
        fifthItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");   
        finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList sixthIem = new ArrayList();

		sixthItem.add("Text");          //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DuplicateCheckDays.label","ca_labels")); 
		// label
		sixthItem.add("dup_chk_days");  //name of field
		sixthItem.add("40");   // SIZE
		sixthItem.add("40");   //LENGTH
		finAr.add(sixthItem);    //add to ArrayList obj finAr

		

		ArrayList senventhItem = new ArrayList();

        senventhItem.add("List");   //Type of item
        senventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DuplicateCheckAction.label","ca_labels"));  // label
        senventhItem.add("dup_chk_action");//name
        senventhItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",WARN,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Warn.label","ca_labels")+",ERROR,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Error.label","ca_labels")+"");
        finAr.add(senventhItem); //add to ArrayList obj finAr */

		ArrayList fourthItem = new ArrayList();

        fourthItem.add("List");   //Type of item
        fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
        fourthItem.add("eff_status");//name
        fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
        finAr.add(fourthItem); //add to ArrayList obj finAr

		String[] orderByCols = null;
        String[] orderByColVals = null;

		orderByCols = new String[3];
	    orderByColVals = new String[3];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels") ;
	    orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
	    orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
		//orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DuplicateCheckDays.label","ca_labels");
		//orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DuplicateCheckAction.label","ca_labels");
		

	    orderByColVals[0] = "VACCINE_ID";
	    orderByColVals[1] = "LONG_DESC";
	    orderByColVals[2] = "SHORT_DESC";
		//orderByColVals[3] = "dup_chk_days";
		//orderByColVals[4] = "dup_chk_action";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Clinic","../../eCA/jsp/VaccineQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");


		out.println(strbuff.toString());
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		//fifthItem.clear();
		//sixthItem.clear();
		//senventhItem.clear();
		//eigthItem.clear();
}
 catch (Exception e) {
	//out.println("Exception "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>


