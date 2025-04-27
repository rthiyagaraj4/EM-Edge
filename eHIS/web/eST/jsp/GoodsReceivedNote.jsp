
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page  import="java.lang.*" contentType="text/html;charset=UTF-8"%>  
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language='javascript' src='../../eST/js/GoodsReceivedNote.js'></script>
	<script language='javascript' src='../../eST/js/StTransaction.js'></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityid=(String)session.getValue("facility_id");

	eST.GoodsReceivedNoteBean bean = (eST.GoodsReceivedNoteBean) getBeanObject( "goodsReceivedNoteBean", "eST.GoodsReceivedNoteBean",request );
	//Adding start for PMG2017-SS-CRF-0002
	HashMap	mm_parameter=(HashMap)bean.fetchRecord("SELECT COUNT(*) TOTAL FROM MM_PARAMETER");
	  if (mm_parameter.get("TOTAL").toString().equals("0")) {
	       out.println("<script>alert(getMessage('PARAMETER_SETUP','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	   }
	   //Adding end for PMG2017-SS-CRF-0002
	bean.setLanguageId(locale);
	session.setAttribute("ACC_ENTITY_ID","ZZ");
	bean.setEntity_param((String) session.getAttribute("ACC_ENTITY_ID"));

	// Passing login_facility_id, material_group_code as arguments
	if(!(bean.recordExists(facilityid, "ALL"))) {
		out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	}
	 
	 boolean flag_grn = bean.isCreateGRNApplicable(facilityid,"GRN");
	

	String ACC_ENTITY_ID = "ZZ";
	
	boolean po_appl_yn = ((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),ACC_ENTITY_ID).get("PO_INTERFACE_YN")).equals("Y");
	
	boolean grn_appl_yn = ((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),ACC_ENTITY_ID).get("INTERFACE_TO_EXTERNAL_PO_YN")).equals("Y");

	String GRN_Label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.GoodsReceivedNote.label","ST_labels");
	url = "../../eCommon/jsp/commonToolbar.jsp?" ;


	//Added for 29970	Bru-HIMS-CRF-095
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String count		= request.getParameter("count") == null?"0":request.getParameter("count");
	String store_code	= request.getParameter("store_code") == null?"":request.getParameter("store_code");
	String home_required_yn = "Y";
	if(homepage.equals("Y"))
		home_required_yn = request.getParameter("home_required_yn") == null?"N":request.getParameter("home_required_yn");
	
	System.out.println(" Inside GoodsReceivedNote JSP 70 po_appl_yn : "+po_appl_yn+" grn_appl_yn : "+grn_appl_yn+" flag_grn : "+flag_grn);
	
	if(!po_appl_yn){
		
			if(grn_appl_yn){%>
				<script>external_po_yn='Y'</script>	
				<%if(flag_grn){
				params = "menu_id=MM_MENU&module_id=MM&function_id=MM_GRN&function_name="+GRN_Label+"&function_type=F&access=YYYYN&home_required_yn="+home_required_yn;
				}else{
				params = "menu_id=MM_MENU&module_id=MM&function_id=MM_GRN&function_name="+GRN_Label+"&function_type=F&access=NYYYY&home_required_yn="+home_required_yn;
				}
				session.putValue( "queryString",params );
				source = url + params ;
			}	

	}else{%>
		<script>external_po_yn='N'</script>	
	  <%
		params = "menu_id=MM_MENU&module_id=MM&function_id=MM_GRN&function_name="+GRN_Label+"&function_type=F&access=YYYYN&home_required_yn="+home_required_yn;
		session.putValue( "queryString",params );
		source = url + params ;
	}
%>
<%
putObjectInBean("goodsReceivedNoteBean",bean,request);
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style='height:82vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
<%
if(homepage.equals("Y") && !count.equals("0")){
%>
		<script>
			parent.workAreaFrame.f_query_add_mod.document.location.href = "../../eST/jsp/GoodsReceivedNoteQueryFrame.jsp?mode=2&<%=params%>";
		</script>
<%
}
%>
</html>

