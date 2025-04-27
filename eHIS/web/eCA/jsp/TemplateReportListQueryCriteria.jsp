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

</head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;


Connection con=null;

try
	{

		con  =  ConnectionManager.getConnection(request);


		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");           //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reportname.label","common_labels"));     // label
		firstItem.add("report_name");   //name of field
		firstItem.add("10"); // SIZE
		firstItem.add("10"); //LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("List");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reporttype.label","common_labels"));  // label
		secondItem.add("report_type");//name
		secondItem.add("s1,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","ca_labels")+",SC,Simple Count,LC,List Choice Count"+"");
		
		finAr.add(secondItem); //add to ArrayList obj finAr


/*
		ArrayList thirdItem= new ArrayList();

		thirdItem.add("List");   //Type of item
		thirdItem.add("Role Based Access");  // label
		thirdItem.add("role_base");//name
		thirdItem.add("B,Both,Y,Yes,N,No");
		//fifthItem.add("Y","checked");//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(thirdItem); //add to ArrayList obj finAr

*/
		
		//Modified by Dinesh
		/*ArrayList fourthItem  = new ArrayList();

		fourthItem.add("List");   //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PreconditionforRecording.label","ca_labels"));  // label
		fourthItem.add("precondition_recording");//name
		fourthItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DischargeAdvice.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.deceased.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(fourthItem); //add to ArrayList obj finAr*/

		ArrayList fifthItem = new ArrayList();

		fifthItem.add("List");   //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		fifthItem.add("eff_status");//name
		fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
		
		finAr.add(fifthItem); //add to ArrayList obj finAr

		String[] orderByCols = null;
		String[] orderByColVals = null;


			orderByCols = new String[2];
			orderByColVals = new String[2];

			orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reportname.label","common_labels");
			orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reporttype.label","common_labels");
			//Modified by dinesh
			/*orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PreconditionforRecording.label","ca_labels");*/
		
		/*	orderByCols[0] = "ID";
			orderByCols[1] = "Description";
			orderByCols[2] = "Precondition for Recording";
		*/
			

			orderByColVals[0] = "report_name";
			orderByColVals[1] = "report_type";
			//orderByColVals[2] = "PRE_COND_FOR_REC";
			
		strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reportname.label","common_labels"),"../../eCA/jsp/TemplateReportListQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ,orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		//thirdItem.clear();
		//fourthItem.clear();
		fifthItem.clear();
} 

catch (Exception e) 
{
	//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
       e.printStackTrace();//COMMON-ICN-0181
}

finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

