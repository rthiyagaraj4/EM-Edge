<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.ArrayList, eMM.StoreBean, eMM.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 
<%
		request.setCharacterEncoding("UTF-8");
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff = new StringBuffer();
String bean_id				=	"storeBean" ;
String bean_name			=	"eMM.StoreBean";
StoreBean bean = (StoreBean)getBeanObject( bean_id, bean_name, request );
bean.setLanguageId(locale);
//ArrayList	arrDept			=	null;

String function_id = request.getParameter( "function_id" );

//	arrDept		=	bean.getDepartment();
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	
	String Store_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreCode.label","common_labels");

	firstItem.add("Text");  		    //Type of item
	firstItem.add(Store_Code);	   // label
	firstItem.add("store_code");	  //name of field
	firstItem.add("6");				 // SIZE
	firstItem.add("6");				//LENGTH

	finAr.add(firstItem);			//add to ArrayList obj finAr
	
	ArrayList secondItem=new ArrayList();

	String Store_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreDescription.label","common_labels");

	secondItem.add("Text");			    //Type of item
	secondItem.add(Store_Desc);      // label
	secondItem.add("short_desc");     //name of field
	secondItem.add("15");			 // SIZE
	secondItem.add("15");			//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem=new ArrayList();

	String department = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
	thirdItem.add("List");		 //Type of item
	thirdItem.add(department);	// label
	thirdItem.add("dept_code");   //name of field
	thirdItem.add(eMM.Common.MmRepository.getMmKeyValue("SQL_MM_STORE_DEPT"));
//	thirdItem.add("SELECT empno,ename from emp where 'C1'=?");
	ArrayList alParameter	=	new ArrayList(1);
	alParameter.add((String)session.getAttribute("facility_id"));
	thirdItem .add(alParameter);
	finAr.add(thirdItem); //add to ArrayList obj finAr


	ArrayList itemStoreGroup=new ArrayList();

	String storeGroup = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.StoreGroup.label","mm_labels");
	itemStoreGroup.add("List");		 //Type of item
	itemStoreGroup.add(storeGroup);	// label
	itemStoreGroup.add("store_group");   //name of field
	itemStoreGroup.add("SELECT STORE_GROUP_CODE,SHORT_DESC FROM MM_STORE_GROUP_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? ORDER BY SHORT_DESC");
	alParameter	=	new ArrayList();
	alParameter.add(locale);
	itemStoreGroup .add(alParameter);
	finAr.add(itemStoreGroup); //add to ArrayList obj finAr
	
		
	
	

	ArrayList fourthItem=new ArrayList();
	
	String Store_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Store.label","common_labels");
	String All_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
	String External_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
	String Internal_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Internal.label","common_labels");
	String Store_List="%,"+All_legend+",Y,"+External_legend+",N,"+Internal_legend;

	fourthItem.add("List");		 //Type of item
	fourthItem.add(Store_legend);	// label
	fourthItem.add("external_yn");   //name of field
	fourthItem.add(Store_List);//
	fourthItem.add("4");
	

	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem=new ArrayList();
	
	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	fifthItem.add("List");		 //Type of item
	fifthItem.add(Nature);	// label
	fifthItem.add("nature");   //name of field
	fifthItem.add(Nature_List);//static values that need to be displayed as option.Send it along with the value that is inserted.
	fifthItem.add("4");		//LENGTH

	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem=new ArrayList();

	sixthItem.add("Hidden");	// label
	sixthItem.add("function_id");   //name of field
	sixthItem.add(function_id);//static values that need to be displayed as option.Send it along with the value that is inserted.

	finAr.add(sixthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];


	orderByCols[0] = Store_Code;
	orderByCols[1] = Store_Desc;

	orderByColVals[0] = "store_code";
	orderByColVals[1] = "short_desc";

	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");


	strbuff = qrypg.getQueryPage((java.util.Properties)session.getAttribute("jdbc"),finAr,Store_Code,"StoreQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery,true);

	out.println(strbuff.toString());

%>
<%
putObjectInBean(bean_id,bean,request);
%>
