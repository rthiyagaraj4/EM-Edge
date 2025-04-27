
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facilityid=(String)session.getValue("facility_id");  
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script language='javascript' src="../../eST/js/StCommon.js"></script>
<script language='javascript' src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String index=request.getParameter("index")==null?"-1":request.getParameter("index");
String mode=request.getParameter("mode")==null?"1":request.getParameter("mode");
String bean_id = "ManufacturingReceiptsBean";
	String bean_name = "eST.ManufacturingReceiptsBean";
//	String disable ="";
	ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean) getBeanObject(bean_id, bean_name, request);
	bean.setLanguageId(locale);
	bean.initialize();
	//bean.setReFamily(request, response);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String doc_type_code	=	request.getParameter("doc_type_code");
	String doc_no			=	request.getParameter("doc_no");
	//String mode				=	request.getParameter("mode");
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
	 String dflt_mfg_mode = request.getParameter("dflt_mfg_mode")==null?"":request.getParameter("dflt_mfg_mode");
	 String mfg_req_yn	= bean.checkForNull(request.getParameter( "mfg_req_yn" ), "N");//Added by suresh.r on 11-12-2014 against BRU-HIMS-CRF-080

if ((mode == null) || (mode.equals(""))) 
		return;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode);

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.setDoc_type_code(doc_type_code);
		bean.setDoc_no(doc_no);
	//	bean.loadData();
		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("doc_type_code",bean.getDoc_type_code());
		hmParameter.put("doc_no",bean.getDoc_no());
		hmParameter.put("trn_type","MFG");

		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
			out.println("<script>alert(getMessage('PHY_INV_PROCESS_INITIATED','ST'));history.go(-1);</script>");
		}	
	}
putObjectInBean(bean_id,bean,request);
//Added on 6/21/2005
	//String bean_id = "ManufacturingReceiptsBean" ;
	//String bean_name = "eST.ManufacturingReceiptsBean";
	String sql_id = "SQL_ST_MAN_REQ_STORE_SELECT";
	String trn_type = "MFG";
	StHeaderBean stBean = (StHeaderBean)getBeanObject( bean_id, bean_name,request);
	stBean.setLanguageId(locale);
	doc_type_code=bean.getDoc_type_code() ;
	doc_no=bean.getDoc_no() ;
	String doc_date=bean.getDoc_date();
	String doc_ref=bean.getDoc_ref();
	String store_code=bean.getStore_code() ;
	//Added by suresh.r on 11-12-2014 against BRU-HIMS-CRF-080 beg
	String item_code="";
	if(mfg_req_yn.equals("Y")){
		store_code	=	request.getParameter("store_code");
		item_code	=	request.getParameter("item_code");
		out.println("<script>parent.commontoolbarFrame.CommonToolbar_form.reset.disabled=true;</script>");
	}//Added by suresh.r on 11-12-2014 against BRU-HIMS-CRF-080 end
	String storeSQLID=sql_id;
	//String item_class_code=bean.getItem_class_code();
	//String docNoDisabled=	"";
	
	mode		= request.getParameter( "mode" ) ;
	
	if (bean_id.equals("stHeaderBean")) {
		stBean.clear() ;
	}

	stBean.setTrn_type(trn_type);
	stBean.setDefault_doc(stBean.checkForNull(request.getParameter("default_doc"),trn_type));
	stBean.initDoc_type_code_List();
	
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		stBean.setLocalEJB(false);
	stBean.setMode(mode);
	stBean.initStore_code_List(storeSQLID);
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ))
		stBean.initialize(trn_type);
	else
		stBean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code);

	putObjectInBean(bean_id,stBean,request);
	
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
	if(dflt_mfg_mode.equals("")){
	 dflt_mfg_mode = bean.checkForNull(((String)bean.fetchRecord("SELECT DFLT_MFG_MODE FROM	st_facility_param WHERE facility_id=?",facilityid).get("DFLT_MFG_MODE")),"R");
	 }
	//ends

%>
<!-- Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts -->
     <%if(dflt_mfg_mode.equals("R")){%>
	 <iframe name='selectcriteriaframe' id='selectcriteriaframe'	src="../../eST/jsp/ManufacturingReceiptsSearchCriteria.jsp?mode=<%=mode%>&index=<%=index%>&dflt_mfg_mode=<%=dflt_mfg_mode%>"  frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
	<iframe name='detailframe' id='detailframe' src='../../eCommon/html/blank.html'  frameborder=0 style='height:75vh;width:100vw'></iframe>
	 <%}else{%>
	  <frameset>
	  <%if(mfg_req_yn.equals("Y")){//Added by suresh.r on 11-12-2014 against BRU-HIMS-CRF-080 %>
	   <frame name='selectcriteriaframe' id='selectcriteriaframe'	src="../../eST/jsp/ManufacturingReceiptsSecondFrame.jsp?mode=<%=mode%>&index=<%=index%>&dflt_mfg_mode=<%=dflt_mfg_mode%>&store_code=<%=store_code%>&mfg_req_yn=<%=mfg_req_yn%>&item_code=<%=item_code%>"  scrolling='no' frameborder=0 noresize>
	  <%}else{ %>
      <frame name='selectcriteriaframe' id='selectcriteriaframe'	src="../../eST/jsp/ManufacturingReceiptsSecondFrame.jsp?mode=<%=mode%>&index=<%=index%>&dflt_mfg_mode=<%=dflt_mfg_mode%>"  scrolling='no' frameborder=0 noresize>
      <%} %>
      <frame name='detailframe' id='detailframe' src='../../eCommon/html/blank.html'  frameborder=0>
     </frameset>
     <%}%>

</html>

