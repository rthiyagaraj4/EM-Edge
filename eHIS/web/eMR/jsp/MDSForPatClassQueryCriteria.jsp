<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.*, java.util.ArrayList" contentType="text/html;charset=UTF-8" %>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<%
		try
		{
			request.setCharacterEncoding("UTF-8");
			Connection conn	= null;
			Statement stmt	= null;
			conn = ConnectionManager.getConnection(request);	
			stmt = conn.createStatement();
			
			ArrayList MDSforpat = new ArrayList();
   	        ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
			StringBuffer strbuff;

			ArrayList firstItem = new ArrayList();
			firstItem.add("List");//type of item 
			firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MDS.label","mr_labels")); //label
			firstItem.add("mds_code");//fields
			firstItem.add("select mds_code,short_desc from mr_mds where eff_status = 'E' order by short_desc");
			MDSforpat.add(firstItem);
			//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			//Start
			ArrayList ThirdItem = new ArrayList();
			ThirdItem.add("Text");  		 //Type of item
			ThirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
			ThirdItem.add("mds_sub_code");	//name of field
			ThirdItem.add("10");	// SIZE
			ThirdItem.add("10");	//LENGTH
			MDSforpat.add(ThirdItem);//add to ArrayList obj finAr
			
			ArrayList FifthItem = new ArrayList();
			FifthItem.add("Text");  		 //Type of item
			FifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
			FifthItem.add("mds_sub_desc");	//name of field
			FifthItem.add("20");	// SIZE
			FifthItem.add("20");	//LENGTH
			MDSforpat.add(FifthItem);//add to ArrayList obj finAr
			//End

		/*	ArrayList fourthItem = new ArrayList();
			fourthItem.add("List");//type of item 
			fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminologySet.label","common_labels"));
			fourthItem.add("term_set_id");//fields
			fourthItem.add("select term_set_id,term_set_desc from mr_term_set where eff_status = 'E' and diag_spec_yn='Y'  order by term_set_id");
			MDSforpat.add(fourthItem);*/

			ArrayList secondItem = new ArrayList();
			secondItem.add("List");
			secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));
			secondItem.add("patient_class");
			secondItem.add("ALL,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",IP,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels")+",OP,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels")+",EM,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+",DC,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels")+"");
			MDSforpat.add(secondItem);

			String orderByCols[] = new String[2];
			String orderByColVals[] = new String[2];
			orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");//+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");

			orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
			//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			orderByColVals[0] = "mds_sub_code";
			orderByColVals[1] = "mds_sub_desc";
			
			
			strbuff = qrypg.getQueryPage(conn,MDSforpat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MDSforPatClass.label","mr_labels"),"../jsp/MDSForPatClassQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

			out.println(strbuff.toString());

			if ( firstItem != null ) firstItem.clear(); 
			//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			//Start
			if ( ThirdItem != null ) ThirdItem.clear(); 
			if ( FifthItem != null ) FifthItem.clear(); 
			//End
			if ( secondItem != null ) secondItem.clear(); 
			//if ( fourthItem != null ) fourthItem.clear();
			if ( MDSforpat != null ) MDSforpat.clear(); 
			if(stmt != null) stmt.close();
			if(conn!=null) ConnectionManager.returnConnection(conn,request);

		}catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();

		}
		finally
		{
			
		}
	%>
	<!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
	<script>
	document.forms[0].mds_code.remove(0);
  	</script>
