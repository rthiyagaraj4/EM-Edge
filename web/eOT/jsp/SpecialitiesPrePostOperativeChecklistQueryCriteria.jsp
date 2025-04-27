<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet, java.util.ArrayList,webbeans.eCommon.ConnectionManager" %>

<% ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String ca_module_yn=request.getParameter("ca_module_yn");

String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String speciality =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
String diag_code_scheme =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ProcedureCodingScheme.Label","ot_labels");//added by rajesh
String user_defined =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UserDefined.label","common_labels");//added by rajesh
String cpt4 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CPT4.label","common_labels");//added by rajesh
String icd9_cm =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ICD9CM.label","common_labels");//added by rajesh
String icd10_pcs =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.icd10pcs.label","common_labels");//added by rajesh

String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
//String orderType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels")	;
String anaesthesiaReviewRequired =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AnaesthesiaReviewRequired.Label","ot_labels");
String swabandInstrumentCount =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SwabandInstrumentCount.Label","ot_labels");
String medicalServiceGroup =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.MedicalServiceGroup.label","ip_labels");
String specialitys =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.Specialitys.label","fm_labels");
String specialityCode =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialtyCode.label","common_labels");
//String chartID =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChartID.label","common_labels");
String role =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels");
String preOperativeCheckList =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreOperativeCheckList.Label","ot_labels");
String postOperativeCheckList =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PostOperativeCheckList.Label","ot_labels");
String chart =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels");
String yes =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
String all =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");


StringBuffer strbuff;
ArrayList firstItem = new ArrayList();
ArrayList secondItem = new ArrayList();
ArrayList thirdItem = new ArrayList();
ArrayList fourthItem = new ArrayList();
ArrayList fifthItem = new ArrayList();
ArrayList sixthItem = new ArrayList();
ArrayList seventhItem = new ArrayList();
ArrayList eightItem = new ArrayList();
ArrayList ninethtItem = new ArrayList();
ArrayList tenthItem = new ArrayList();
ArrayList finAr = new ArrayList();
Connection con=null ;
try {

	con  =  ConnectionManager.getConnection(request);
	firstItem.add("List");           //Type of item
	firstItem.add(speciality);     // label
	firstItem.add("speciality_code");   //name of field
	//firstItem.add("SELECT SPECIALITY_CODE,LONG_DESC  FROM AM_SPECIALITY WHERE EFF_STATUS = 'E'ORDER BY 1"); // SIZE
	firstItem.add("SELECT A.SPECIALITY_CODE,B.LONG_DESC  FROM OT_SPECIALITIES A,AM_SPECIALITY B WHERE EFF_STATUS = 'E' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ORDER BY 2"); // SIZE
	finAr.add(firstItem);//add to ArrayList obj finAr

	//Added by Rajesh

	tenthItem.add("List");   //Type of item
	tenthItem.add(diag_code_scheme);  // label
	tenthItem.add("diag_code_scheme");//name
	String g = "";
	//Modified by rajesh for changing the diagnosis code scheme to MR_TERM_SET
	tenthItem.add("SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and term_set_id in('ICD10PCS','ICD9CMP','CPT4','OTH')");//static values that need to be displayed as
	//tenthItem.add("1,"+user_defined+",2,"+icd10_pcs+",3,"+cpt4+",4,"+icd9_cm);//static values that need to be displayed as
	finAr.add(tenthItem);


	if (ca_module_yn.equals("Y")) {
		
		secondItem.add("List");          //Type of item
		secondItem.add(chart);    // label
		secondItem.add("chart_id");  //name of field
		//secondItem.add("SELECT CHART_ID,SHORT_DESC  FROM CA_CHART WHERE EFF_STATUS = 'E'ORDER BY 1");  
		secondItem.add("SELECT DISTINCT A.DISCR_MSR_ID,B.SHORT_DESC  FROM OT_SPECIALITIES A,CA_CHART B WHERE EFF_STATUS = 'E' AND A.DISCR_MSR_ID = B.CHART_ID ORDER BY 1");  
		finAr.add(secondItem);    //add to ArrayList obj finAr
	}
	
	thirdItem.add("List");          //Type of item
	thirdItem.add(swabandInstrumentCount);    // label
	thirdItem.add("swab_instr_tmpl_id");  //name of field
	thirdItem.add("SELECT TEMPLATE_ID,DESCRIPTION  FROM OT_SWAB_INSTR_TMPL_HDR WHERE NVL(STATUS,'E') = 'E'ORDER BY 1");   // SIZE

	finAr.add(thirdItem);    //add to ArrayList obj finAr

	
	fourthItem.add("List");          //Type of item
	fourthItem.add(medicalServiceGroup);    // label
	fourthItem.add("med_ser_grp_code");  //name of field
	fourthItem.add("select MED_SER_GRP_CODE, LONG_DESC, SHORT_DESC from IP_MEDICAL_SERVICE_GRP_LANG_VW where language_id ='"+locale+"' and NVL(EFF_STATUS,'E')='E' ORDER BY 1");   // SIZE

	finAr.add(fourthItem);    //add to ArrayList obj finAr

	
	fifthItem.add("List");   //Type of item
	fifthItem.add(anaesthesiaReviewRequired);  // label
	fifthItem.add("anaesthesia_reqd_yn");//name
	//fifthItem.add("all,All,Y,Yes,N,No");//static values that need to be displayed as 
	fifthItem.add("all,"+all+",Y,"+yes+",N,"+no);//static values that need to be displayed as 

	finAr.add(fifthItem);

	
	sixthItem.add("List");   //Type of item
	sixthItem.add(nature);  // label
	sixthItem.add("status");//name
	//sixthItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as
	sixthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);//static values that need to be displayed as
	finAr.add(sixthItem);

	
	seventhItem.add("List");   //Type of item
	seventhItem.add(preOperativeCheckList);  // label
	seventhItem.add("pre_op_checklist");//name
	seventhItem.add("SELECT CHECKLIST_CODE,DESCRIPTION FROM OT_CHECKLIST_HDR WHERE NVL(STATUS,'E') = 'E'ORDER BY 1");//static values that need to be displayed as 
	finAr.add(seventhItem);

	
	eightItem.add("List");   //Type of item
	eightItem.add(postOperativeCheckList);  // label
	eightItem.add("post_op_checklist");//name
	eightItem.add("SELECT CHECKLIST_CODE,DESCRIPTION FROM OT_CHECKLIST_HDR WHERE NVL(STATUS,'E') = 'E'ORDER BY 1");//static values that need to be displayed as 
	finAr.add(eightItem);

	
	ninethtItem.add("List");   //Type of item
	ninethtItem.add(role);  // label
	ninethtItem.add("role");//name
	ninethtItem.add("SELECT ROLE_ID,ROLE_DESC FROM OT_ROLES WHERE NVL(STATUS,'E') = 'E'ORDER BY 1");//static values that need to be displayed as 
	finAr.add(ninethtItem);


	String[] orderByCols=null;
	String[] orderByColVals=null;
	if(ca_module_yn.equals("Y")){
		orderByCols = new String[3];
		orderByColVals = new String[3];

		orderByCols[0] = specialityCode;
		orderByCols[1] = chart;
		orderByCols[2] = "Swab & Instrument Template ID";
	   

		orderByColVals[0] = "speciality_code";
		orderByColVals[1] = "chart_id";
		orderByColVals[2] = "swab_instr_tmpl_id";
	}else{
		orderByCols = new String[2];
		orderByColVals = new String[2];

		orderByCols[0] = specialityCode;
		orderByCols[1] = "Swab & Instrument Template ID";
	   

		orderByColVals[0] = "speciality_code";
		orderByColVals[1] = "swab_instr_tmpl_id";
	}


	strbuff = qrypg.getQueryPage( con,finAr,specialitys,"../../eOT/jsp/SpecialitiesPrePostOperativeChecklistQueryResult.jsp?ca_module_yn="+ca_module_yn,sortorder,queryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
	out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		seventhItem.clear();
		eightItem.clear();
		ninethtItem.clear();
		tenthItem.clear();
		finAr.clear();
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

