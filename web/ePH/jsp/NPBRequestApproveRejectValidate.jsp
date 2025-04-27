 <%@page import="java.util.*,java.io.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
		
	String func_mode		= request.getParameter("func_mode");
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash		= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	String facility_id   = (String)session.getValue( "facility_id" );
	String login_user	= (String)session.getValue("login_user");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	try{
		NPBRequestApproveRejectBean bean = (NPBRequestApproveRejectBean)getBeanObject(bean_id,bean_name ,request) ;
		bean.setLanguageId(locale);
		if(func_mode.equals("storeChangedValues")){
			HashMap NPBRequestDtlList = bean.getNPBRequestDtlList();
			HashMap NPBRequestDtl = null;
			String req_no, validityDate, reqAction, NPBRemarks, selectedYN, reqStatus, appr_drug_code, request_drug_name;
			for(int i=0; i<NPBRequestDtlList.size(); i++){
				selectedYN			= (String) hash.get("selectedYN_"+i);
				if(selectedYN.equals("Y")){
					req_no			= (String) hash.get("request_no_"+i);
					NPBRequestDtl = (HashMap)NPBRequestDtlList.get(req_no);
					if(NPBRequestDtl!=null){
						validityDate			= (String) hash.get("validityDate_"+i);
						reqAction			= (String) hash.get("reqAction_"+i);
						NPBRemarks			= (String) hash.get("NPBRemarks_"+i);
						appr_drug_code			= (String) hash.get("approved_drug_code_"+i);
						request_drug_name			= (String) hash.get("request_drug_name_"+i);
						NPBRequestDtl.put("DRUG_VALIDITY_DATE",validityDate);
						NPBRequestDtl.put("REQUEST_STATUS",reqAction);
						NPBRequestDtl.put("NPBREMARKS",java.net.URLDecoder.decode(NPBRemarks,"UTF-8"));
						NPBRequestDtl.put("APPROVED_DRUG_CODE",appr_drug_code);
						NPBRequestDtl.put("REQUEST_DRUG_CODE",appr_drug_code);
						NPBRequestDtl.put("REQUEST_DRUG_NAME",java.net.URLDecoder.decode(request_drug_name,"UTF-8"));
						NPBRequestDtl.put("SELECTEDYN",selectedYN);
						NPBRequestDtlList.put(req_no,NPBRequestDtl );
					}
				}
			}
			bean.setNPBRequestDtlList(NPBRequestDtlList);
		}
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}

%>											
