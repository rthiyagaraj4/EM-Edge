<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.lang.*,java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.Common.*,eST.*, eCommon.Common.* "%>

<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String facility_id  =  (String) session.getValue( "facility_id" ) ;
String user_name  =  (String) session.getValue( "login_user" ) ;

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<!--	<script language='javascript' src='../../eST/js/StMessages.js'></script>  -->
		<script language="javascript" src="../../eST/js/SRRCertificateForReimbursement.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body>
	<form name="SRRCertiforReimbursementQueryResultForm" id="SRRCertiforReimbursementQueryResultForm">
	<%

		int count = 0;
		int k = 0;

	    String bean_id1 = "RePrintDocReportBean";
		String bean_name1 = "eST.RePrintDocReportBean";

		RePrintDocReportBean bean1 = (RePrintDocReportBean) getBeanObject( bean_id1, bean_name1, request);   
		bean1.setLanguageId(locale);
      
		String bean_id				= "SRRCertificateForReimbursementBean" ;
		String bean_name			= "eST.SRRCertificateForReimbursementBean";
		SRRCertificateForReimbursementBean bean		= (SRRCertificateForReimbursementBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
        String doc_type_code="";
		String store_code				=		bean.checkForNull(request.getParameter("store_code"),"%");
		String patient_id				=		bean.checkForNull(request.getParameter("patient_id"),"%");
		String adr_reported_date_from		=		bean.checkForNull(request.getParameter("adr_reported_date_from"));
		String adr_reported_date_to			=		bean.checkForNull(request.getParameter("adr_reported_date_to"));
		String sale_doc_no_from			=		bean.checkForNull(request.getParameter("sale_doc_no_from"));
		String sale_doc_no_to			=		bean.checkForNull(request.getParameter("sale_doc_no_to"));
		String from = CommonBean.checkForNull(request.getParameter("from"));
	    String to = CommonBean.checkForNull(request.getParameter("to"));
	 
	    int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		int i = 0;

         if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt(from) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt(to) ;
			int maxRecord	= 0;


		try{

			ArrayList alParam = new ArrayList();
			alParam.add(facility_id);
			doc_type_code = (String)((HashMap)bean1.fetchRecord("SELECT a.doc_type_code FROM st_trn_doc_type a  WHERE a.facility_id=?  AND a.trn_type ='SAL' ",alParam)).get("DOC_TYPE_CODE");
			doc_type_code	=		bean1.checkForNull(doc_type_code,"%");	
		  
			ArrayList result =null;
		result=bean.getCertiforReimbursementList(patient_id,adr_reported_date_from,adr_reported_date_to,sale_doc_no_from,sale_doc_no_to,store_code,doc_type_code,facility_id,user_name,locale);
			maxRecord = result.size();	
//out.println("maxRecord-----> " +maxRecord);
		
		if( (result != null && result.size()>0)){ %>
		<table width='100%'>
		<tr>
		<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    if ( !(start <= 1)) {
	%>
			 <a href='javascript:SubmitLink("<%=(start-query_result_size)%>","<%=(end-query_result_size)%>","<%=(patient_id)%>","<%=(adr_reported_date_from)%>","<%=(adr_reported_date_to)%>","<%=(sale_doc_no_from)%>","<%=sale_doc_no_to%>","<%=(store_code)%>",
			 "<%=doc_type_code%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>	
	<%
	    }
	    if ( !((start+14) > result.size() )){
	%>
	    <a href='javascript:SubmitLink("<%=(start+query_result_size)%>","<%=(end+query_result_size)%>","<%=(patient_id)%>","<%=(adr_reported_date_from)%>","<%=(adr_reported_date_to)%>","<%=(sale_doc_no_from)%>","<%=sale_doc_no_to%>","<%=(store_code)%>",
			 "<%=doc_type_code%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
	<%
	    }
	%>
	</td>
	</tr>
	<table>

	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
	<tr>
	<th> <fmt:message key="Common.date.label" bundle="${common_labels}"/> </th>
	<th> <fmt:message key="Common.Store.label" bundle="${common_labels}"/>  </th>
	<th> <fmt:message key="Common.Sale.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>  </th>
	<th> <fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </th>
	<th> <fmt:message key="Common.PatientName.label"   bundle="${common_labels}"/> </th>
	<th> <fmt:message key="Common.encounterid.label" bundle="${mm_labels}"/> </th>
	<th  ><fmt:message key="Common.Select.label" bundle="${common_labels}"/><input type="checkbox" name="selectall_yn" id="selectall_yn" value="N" onClick="return chkall(SRRCertiforReimbursementQueryResultForm);" ></th>
	</tr>

 <%

		String []record=new String[9];
		if ( start != 1)
		for( int j=1; j<start; i++,j++ ) {   }

		while(i<end && i<result.size())	{
		record= (String[])result.get(i);

		String classvalue="";
		if ( i % 2 == 0 )
		classvalue = "QRYEVEN" ;
		else
		classvalue = "QRYODD" ;

		//record[0]=com.ehis.util.DateUtils.convertDate(record[0],"DMY","en",locale);
		String doc_date=com.ehis.util.DateUtils.convertDate(record[0],"DMY",locale,"en");//Added By Sakti Sankar against inc#38120
		if( (record[5] == null)  || (record[5].equals("")))  record[5] ="&nbsp";

	%>
		<tr>
			<td class="<%=classvalue%>" style="font-size=9" nowrap><font class="hyperlink" style="cursor:pointer" onClick="show_Print_for_certi('<%=doc_date%>','<%=record[2]%>','<%=i%>')"><%=record[0]%></font></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap><font class="hyperlink" style="cursor:pointer" onClick="show_Print_for_certi('<%=doc_date%>','<%=record[2]%>','<%=i%>')"><%=record[1]%></font></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><font class="hyperlink" style="cursor:pointer" onClick="show_Print_for_certi('<%=doc_date%>','<%=record[2]%>','<%=i%>')"><%=record[2]%></font></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[3]%></td>
			<td class="<%=classvalue%>" style="font-size=9"        ><%=record[4]%></td>
			<td class="<%=classvalue%>" style="font-size=9" nowrap ><%=record[5]%></td>			
			<td  class="<%=classvalue%>"nowrap>  <input type="checkbox" name="p_print_yn<%=i%>" id="p_print_yn<%=i%>" value="<%=record[6]%>" onClick="assignValue(this);calvalidation(this,'<%=i%>','<%=record[2]%>');" <%if(record[6].equals("Y")){count++;%>checked<%}%> ></td>
				<input type="hidden" name="doc_no_<%=i%>" id="doc_no_<%=i%>" value="<%=record[2]%>">

		</tr>
	<%
				  i++;
		k++;
		}
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
		        parent.f_query_add_mod.document.forms[0].print.disabled =true;
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
         %>
	 </table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%=maxRecord%>">
	<input type="hidden" name="from" id="from" value="">
	<input type="hidden" name="to" id="to" value="">
	<input type="hidden" name="patient_id" id="patient_id" value="">
	<input type="hidden" name="adr_reported_date_from" id="adr_reported_date_from" value="">
	<input type="hidden" name="adr_reported_date_to" id="adr_reported_date_to" value="">
	<input type="hidden" name="sale_doc_no_from" id="sale_doc_no_from" value="">
	<input type="hidden" name="sale_doc_no_to" id="sale_doc_no_to" value="">
	<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	<input type="hidden" name="doc_type_code" id="doc_type_code" value="">
    </table> 

			 <%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id1,bean1,request);

		if(count == k)
			out.println("<script>document.getElementById("selectall_yn").checked=true;</script>");

	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
	}
%>
</form>
</body>

</html>

