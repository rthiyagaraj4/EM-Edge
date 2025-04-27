<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.lang.*,java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.Common.*,eST.*, eCommon.Common.* "%>

<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		
		<%
		request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String facility_id  =  (String) session.getValue( "facility_id" ) ;
//String user_name  =  (String) session.getValue( "login_user" ) ;

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>

		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>

		<script language="javascript" src="../../eST/js/SRRSalesReturnVoucherReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>


<body>
	<form name="QueryForm" id="QueryForm">
	<%
      
		

       	ArrayList chkFields		=		new ArrayList();
		ArrayList displayFields =		new ArrayList();
		HashMap sqlMap			=		new HashMap();
		HashMap funcMap			=		new HashMap();
        String sql="";
       
	


		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String login_user	= (String)session.getValue("login_user");

 
    String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
    String fr_rtndate = CommonBean.checkForNull(request.getParameter("fr_rtndate"));
    String to_rtndate = CommonBean.checkForNull(request.getParameter("to_rtndate"));
    String p_encounter = CommonBean.checkForNull(request.getParameter("p_encounter"));
    String p_rtnstore = CommonBean.checkForNull(request.getParameter("p_rtnstore"));
    String p_sal_trn_type = CommonBean.checkForNull(request.getParameter("p_sal_trn_type"));
    String p_document = CommonBean.checkForNull(request.getParameter("p_document"));
	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
   
	try{

		chkFields		=		new ArrayList();

		
			 sql = "SELECT hdr.doc_type_code doc_type_code, hdr.doc_no doc_no, TO_CHAR (hdr.doc_date, 'dd/mm/yyyy') doc_date, hdr.store_code store_code, fms.short_desc to_store_desc, hdr.patient_id patient_id,mpp.patient_name patient_name,NVL (hdr.encounter_id, '') encounter_id   FROM ST_SAL_RET_HDR hdr, mm_store_lang_vw fms, ST_USER_ACCESS_FOR_STORE uaca,mp_patient mpp WHERE hdr.store_code = fms.store_code  AND uaca.store_code = hdr.store_code  AND hdr.finalized_yn = 'Y' AND hdr.module_id = 'ST' AND uaca.srt_allowed_yn = 'Y' AND hdr.trn_type LIKE 'SRT' AND hdr.patient_id = NVL (?, hdr.patient_id) AND hdr.patient_id = mpp.patient_id AND TO_CHAR (hdr.doc_no)= NVL (?, hdr.doc_no) AND hdr.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'dd/mm/yyyy') AND TO_DATE (NVL (?, TO_CHAR (SYSDATE, 'DD/MM/YYYY')),'dd/mm/yyyy') AND hdr.store_code LIKE ? AND uaca.user_id = ? AND hdr.facility_id =? AND NVL (hdr.encounter_id, 1) = NVL (?, NVL (hdr.encounter_id, 1)) AND hdr.sal_trn_type = NVL (?, hdr.sal_trn_type) AND fms.language_id = ? order by doc_date desc,doc_no desc";

			  sqlMap.put("sqlData",sql);

		chkFields.add(patient_id);
		chkFields.add(p_document);
		chkFields.add(fr_rtndate);
		chkFields.add(to_rtndate);
		chkFields.add(p_rtnstore);
		chkFields.add(login_user);
		chkFields.add(p_facility_id);
		chkFields.add(p_encounter);
		chkFields.add(p_sal_trn_type);
		
		chkFields.add(locale);


		displayFields.add("doc_no");
		displayFields.add("doc_date");
		displayFields.add("to_store_desc");
		displayFields.add("patient_id");
		displayFields.add("patient_name");
		displayFields.add("encounter_id");

		// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result =(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
String classvalue	=	"";
					int recCount=0,i = 0;

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
%>
	<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;</td>
				<%
					out.println(result.get(1));
				%>
			</tr>
			</table>

<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">


<tr>
			<th  nowrap><fmt:message key="eST.ReturnDate.label" bundle="${st_labels}"/></th>
			<th  nowrap><fmt:message key="eST.ReturnStore.label" bundle="${st_labels}"/></th>
			<th  nowrap><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th  nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>

				</tr>
<%
			ArrayList records=null;
			for(recCount=2,i=0; recCount<result.size(); recCount++,i++){
				if (recCount % 2 == 0)
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
		%>
				<tr>
		<%
				records=(ArrayList) result.get(recCount);

				String encounter_id	= (String)records.get(5);
				if(encounter_id== null) encounter_id="&nbsp";


      %>

	 <td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=records.get(1)%>','<%=records.get(0)%>')"><%=com.ehis.util.DateUtils.convertDate((String)records.get(1),"DMY","en",locale)%></font></td>
	 <td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=records.get(1)%>','<%=records.get(0)%>')"><%=records.get(2)%></font></td>
	 <td class="<%=classvalue%>" style="font-size=9"><font class="hyperlink" style="cursor:pointer" onClick="showPrintReport('<%=records.get(1)%>','<%=records.get(0)%>')"><%=records.get(0)%></font></td>



		 
		
		<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
		<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
		<td class="<%=classvalue%>" onclick="disableClick(event);"><%=encounter_id%></td>
		
			 <%
					 }
		%>

</table>
	<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
				out.println(CommonBean.setForm (request ,"../../eST/jsp/SRRSalesReturnVoucherReportQueryCriteriaResult.jsp", searched));
			

		

	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</form>
</body>

</html>




</form>
</body>
</html>



