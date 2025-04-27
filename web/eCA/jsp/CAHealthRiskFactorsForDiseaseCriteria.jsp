<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager,eCA.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/HealthRiskFactorsForDisease.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;

try{
	HealthRiskFactorsBean beanObj = new HealthRiskFactorsBean();
	String locale=(String)session.getAttribute("LOCALE"); 
	System.out.println(" LOCALE " + locale );
	con  =  ConnectionManager.getConnection(request);
	String comboString = beanObj.getDiagnosisSetValues(locale, con);
	System.out.println(" comboString " + comboString );
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	firstItem.add("List");           //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisSet.label","mr_labels"));     // label
	firstItem.add("term_set_id");   //name of field
	firstItem.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---," + comboString); // SIZE
	firstItem.add("10"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");          //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiagnosisCode.label","common_labels"));    // label
	secondItem.add("term_set_code");  //name of field
	secondItem.add("30");  
	secondItem.add("30");  
	finAr.add(secondItem);    //add to ArrayList obj finAr

/*	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels"));  // label
	thirdItem.add("risk_grp_type");//name
	thirdItem.add( "'',------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------------,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Individual.label","common_labels")+",G,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Group.label","common_labels")+"");
	finAr.add(thirdItem); //add to ArrayList obj finAr 
	*/
	String[] orderByCols = new String[2];
	String[] orderByColVals = new String[2];
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisSet.label","mr_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiagnosisCode.label","common_labels");
		
		orderByColVals[0] = "GD.TERM_SET_ID";
		orderByColVals[1] = "GD.TERM_SET_CODE"; 
	
	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.riskfactor.label","ca_labels"),"../../eCA/jsp/CAHealthRiskFactorsForDiseaseQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ,orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	//thirdItem.clear();
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

