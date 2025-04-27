<!DOCTYPE html>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import=" eST.Common.StDuoHeaderBean,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale				=		(String)session.getAttribute("LOCALE");
	
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link><!--  -->
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/Issue.js'></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		 <script>
			function_id					=		"<%= request.getParameter( "function_id" ) %>"
			menu_id						=		"<%= request.getParameter( "menu_id" ) %>"
			module_id					=		"<%= request.getParameter( "module_id" ) %>"
		 </script>
</head>
<%
			eST.IssueBean bean			=		(eST.IssueBean) getBeanObject( "issueBean",  "eST.IssueBean",request );
			bean.setLanguageId(locale);
			bean.initialize();
			String doc_type_code		=		request.getParameter("doc_type_code");
			String doc_no				=		request.getParameter("doc_no");
			String seq_no				=		request.getParameter("seq_no");
			String mode					=		request.getParameter("mode");
			String req_facility_id		=		request.getParameter("req_facility_id");

			//added for barcode
			String param = request.getQueryString();


			if ((mode == null) || (mode.equals(""))) {
				return;
			}
			if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT")))) {
				return;
			}
			ServletContext context		=		getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))){ 
				bean.setLocalEJB(false);
			}
			bean.setMode(mode);
			bean.setReq_Facility_id(req_facility_id);

			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			bean.setDoc_type_code(doc_type_code);
			bean.setDoc_no(doc_no);
			bean.setSeq_no(seq_no);
			try{
				bean.loadData();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			java.util.HashMap hmParameter	=		new java.util.HashMap();

			hmParameter.put("facility_id",bean.getLoginFacilityId());
			hmParameter.put("doc_type_code",doc_type_code.trim());
			hmParameter.put("doc_no",doc_no.trim());
			hmParameter.put("seq_no",seq_no.trim());
			hmParameter.put("trn_type","ISS");
			String phy_inv_id = "";
			if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
				//out.println("<script>alert(getMessage('PHY_INV_PROCESS_INITIATED','ST'));history.go(-1);</script>");
					phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_SELECT"),new String[]{bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),seq_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),seq_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),seq_no.trim()}).get("PHY_INV_ID");
					out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
					//out.println("<script>alert(getMessage('PHY_INV_PROCESS_INITIATED','ST')+ getLabel('eST.PhyInventoryID.label','ST')+':');history.go(-1);</script>");
									// alert(getMessage(message,"ST")+"\n"+getLabel("eST.PhyInventoryID.label","ST")+":"+formObj.phy_inv_id.value)
				//out.println("<script>alert(getMessage('PHY_INV_PROCESS_INITIATED','ST')"+'\n'+"getLabel('eST.PhyInventoryID.label','ST')+':'"+phy_inv_id+");history.go(-1);</script>");
			}

			hmParameter.clear();
			hmParameter.put("facility_id",req_facility_id);
			hmParameter.put("doc_type_code",doc_type_code.trim());
			hmParameter.put("doc_no",doc_no.trim());
			hmParameter.put("seq_no",seq_no.trim());
			hmParameter.put("trn_type","ISS");

			if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
					phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_SELECT"),new String[]{req_facility_id,doc_type_code.trim(),doc_no.trim(),seq_no.trim(),req_facility_id,doc_type_code.trim(),doc_no.trim(),seq_no.trim(),req_facility_id,doc_type_code.trim(),doc_no.trim(),seq_no.trim()}).get("PHY_INV_ID");
					out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
			//out.println("<script>alert(getMessage('PHY_INV_PROCESS_INITIATED','ST')+'\n'+getLabel('eST.PhyInventoryID.label','ST')+':'"+phy_inv_id+");history.go(-1);</script>");
			}	

			bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	}				   
%>
<%putObjectInBean("issueBean",bean,request);
//Added on 6/21/2005
		String bean_id						=		 "stDuoHeaderBean" ;
		String bean_name					=		 "eST.Common.StDuoHeaderBean";
	//	String sql_id						=		 "SQL_ST_GRN_STORE_SELECT";
		String trn_type						=		 "URG";
		//String sql_from_store				=		"SQL_ST_ISSUE_REQ_URG_FROM_STORE";
		//String sql_to_store				=		"SQL_ST_ISSUE_REQ_URG_TO_STORE";
		//String Modal_Window_Open			=		"Yes";

		StDuoHeaderBean stDuoBean			=		(StDuoHeaderBean)getBeanObject( bean_id, bean_name,request);
		doc_type_code						=		bean.getDoc_type_code() ;
		doc_no								=		bean.getDoc_no() ;
		String doc_date						=		bean.getDoc_date();
		String doc_ref						=		bean.getDoc_ref();
		String from_store_code				=		bean.getFrom_store_code();
		String to_store_code				=		bean.getTo_store_code() ;
		//String storeSQLID					=		sql_id;
		String item_class_code				=		bean.getItem_class_code();
		//String docNoDisabled				=		"";
		mode								=		request.getParameter( "mode" ) ;
		
		if (bean_id.equals("stDuoHeaderBean")) {
			stDuoBean.clear() ;
		}
		stDuoBean.setLanguageId(locale);
		stDuoBean.setTrn_type(trn_type);
		//stDuoBean.setTrn_type(trn_type);
	//	stDuoBean.setDefault_doc(stDuoBean.checkForNull(request.getParameter("default_doc"),trn_type));
		stDuoBean.initDoc_type_code_List();
		
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))){ 
			stDuoBean.setLocalEJB(false);
		}
		stDuoBean.setMode(mode);
	//	stDuoBean.initStore_code_List(storeSQLID);
		
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )){
		stDuoBean.initialize(trn_type);
	}else{
		stDuoBean.initialize(trn_type, doc_type_code, doc_no, doc_date,  doc_ref,from_store_code,to_store_code,item_class_code);
	}
	
	putObjectInBean(bean_id,stDuoBean,request);

%>

	<iframe name='frameIssueHeader'		id='frameIssueHeader'		src="../../eST/jsp/IssueHeader.jsp?<%=param%>" frameborder=0 scrolling='no'   noresize style='height:13vh;width:100vw'></iframe>
	<iframe name='frameIssueDetail' id='frameIssueDetail' src="../../eCommon/html/blank.html" frameborder=0 scrolling="auto"   noresize style='height:74vh;width:24vw'></iframe>
	<iframe name='frameIssueList' id='frameIssueList' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' noresize style='height:74vh;width:74vw'></iframe>
<script>
	clearMessageFrame();
</script>

</html>
