<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<head>
	<%  request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
		con =ConnectionManager.getConnection(request); 
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("List");           //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));     // label
		firstItem.add("patientClass");   //name of field
			firstItem.add("Select '*A' PATIENT_CLASS,'ALL' SHORT_DESC from dual union all select  PATIENT_CLASS,SHORT_DESC from AM_PATIENT_CLASS order by SHORT_DESC");
		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");          //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityDesc.label","ca_labels"));    // label
		secondItem.add("speciality");  //name of field
		secondItem.add("20");   // SIZE
		secondItem.add("20");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");          //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels"));    // label
		thirdItem.add("practType");  //name of field
		thirdItem.add("20");   // SIZE
		thirdItem.add("20");   //LENGTH
		finAr.add(thirdItem);    //add to ArrayList obj finAr	
		
		ArrayList fourthItem = new ArrayList();
		fourthItem.add("List");          //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));    // label
		fourthItem.add("locationType");  //name of field
		fourthItem.add("'',------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------------,*,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"");   // SIZE
		finAr.add(fourthItem);    //add to ArrayList obj finAr	

		ArrayList fifthItem = new ArrayList();
		fifthItem.add("Text");          //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));    // label
		fifthItem.add("location");  //name of field
		fifthItem.add("20");   // SIZE
		fifthItem.add("20");   //LENGTH
		finAr.add(fifthItem);    //add to ArrayList obj finAr	
									
		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Text");          //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroup.label","common_labels"));    // label
		sixthItem.add("ageGrp");  //name of field
		sixthItem.add("20");   // SIZE
		sixthItem.add("20");   //LENGTH
		finAr.add(sixthItem);    //add to ArrayList obj finAr	
		
		ArrayList seventhItem = new ArrayList();
		seventhItem.add("Text");          //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels"));    // label
		seventhItem.add("chart");  //name of field
		seventhItem.add("20");   // SIZE
		seventhItem.add("20");   //LENGTH
		finAr.add(seventhItem);    //add to ArrayList obj finAr	

		String[] orderByCols =  new String[7];
		String[] orderByColVals =  new String[7];
		orderByCols[0]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"); 
		orderByCols[1]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityDesc.label","ca_labels");  
		orderByCols[2]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");
		orderByCols[3]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
		orderByCols[4]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels");
		orderByCols[5]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.agegroup.label","common_labels");
		orderByCols[6]  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels");

		orderByColVals[0] = "PATIENT_CLASS_SHORT_DESC";
		orderByColVals[1] = "SPECIALITY_SHORT_DESC";
		orderByColVals[2] = "PRACT_TYPE_DESC";
		orderByColVals[3] = "LOCN_TYPE_IND_DESC";
		orderByColVals[4] = "LOCN_SHORT_DESC";
		orderByColVals[5] = "AGE_GROUP_SHORT_DESC";
		orderByColVals[6] = "CHART_SHORT_DESC";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Chart","../../eCA/jsp/ChartApplicabilityQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
		
		out.println(strbuff.toString());	

		finAr.clear();
       firstItem.clear();
       secondItem.clear();
       thirdItem.clear();
       fourthItem.clear(); 
       fifthItem.clear();
       sixthItem.clear();
       seventhItem.clear();


	}
	catch(Exception ee)
	{
		//out.println("Exception in ChartApplicabilityQueryCriteria Block of Chart Applicability : "+ee.toString());//common-icn-0181
                ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
       

		if(con != null)ConnectionManager.returnConnection(con); 
	}
%>

