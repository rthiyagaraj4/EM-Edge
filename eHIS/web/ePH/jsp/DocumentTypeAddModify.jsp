<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
  <%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
	
    <script language="JavaScript" src="../js/DocumentType.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
     /* Mandatory checks start */
    String mode			= request.getParameter("mode");
    String bean_id		= "DocumentTypeBean" ;
    String bean_name	= "ePH.DocumentTypeBean";

	if ( mode == null || mode.equals("") )
        return ;
    if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
        return ;
    /* Mandatory checks end */

    /* Initialize Function specific start */
    DocumentTypeBean bean = (DocumentTypeBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
    bean.clear() ;
    bean.setMode( mode ) ;
	HashMap intialValues = new HashMap();
	ArrayList PH_TRN_TYPE		= new ArrayList();
	ArrayList SHORT_DESC		= new ArrayList();

	if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
		intialValues = (HashMap) bean.loadIntialValues();
	}
/*	else{
		intialValues = (HashMap) bean.loadIntialValues();
	}
*/
	if(intialValues != null && intialValues.size()>0){
		PH_TRN_TYPE		= (ArrayList) intialValues.get("PH_TRN_TYPE");
		SHORT_DESC		= (ArrayList) intialValues.get("SHORT_DESC");
	}
	%>

			<form name="document_type" id="document_type" >

				   <%
					   if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){

						   String ph_trn_type		=	request.getParameter("ph_trn_type");
						   String ph_trn_typeval	=	request.getParameter("ph_trn_typeval");
						   String st_document_type	=	request.getParameter("st_document_type");
						   String stock_type		=	"";

						  ArrayList values			=	 bean.loadDocumentType(ph_trn_typeval,st_document_type);

							ph_trn_type				=	(String)values.get(0);
							ph_trn_typeval			=	(String)values.get(1);
							String st_doc_type		=	(String)values.get(2);
							String st_doc_type_val	=	(String)values.get(3);

							if(ph_trn_typeval.startsWith("Disp"))
								stock_type			=	"SAL";
							else if(ph_trn_typeval.startsWith("Prepare"))
								stock_type			=	"MFG";
							else
								stock_type			=	"RET";
							 

						%>

						<br><br><br><br><br><br><br>
						<table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" id="patient_table">
						<tr><td class="label" colspan="2">&nbsp;</td></tr>
						<tr>
						   <td class="label" width="35%" ><fmt:message key="ePH.PharmacyTransactionType.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;&nbsp;<input type="text" value="<%=ph_trn_typeval%>" name="PH_TRN_TYPE" disabled size="30">
						<input type="hidden" value="<%=ph_trn_type%>" name="PH_TRN_TYPE_CODE" disabled size="30">
						</td>
        			 	</tr>

        			 	<tr>
						 <td  class="label" width="35%" ><fmt:message key="ePH.StockTransactionType.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;&nbsp;<input type="text" value="<%=stock_type%>" name="st_document_type" disabled size="30">
						</td>
						</tr>
						<tr>
						<td class="label" width="35%" ><fmt:message key="ePH.STDocumentType.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;&nbsp;<input type=text name="st_doc_type_val" id="st_doc_type_val" value="<%=st_doc_type_val%>" disabled>
						<input type="hidden" name="st_doc_type" id="st_doc_type" value="<%=st_doc_type%>">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
						<input type="hidden" value="<%=st_doc_type%>" name="ST_TRN_TYPE_CODE" disabled size="30">
						</td>
					</tr>
					<tr><td class="label" colspan="2">&nbsp;</td></tr>
					<%
					   }
					if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
					   %>
					   <br><br><br><br><br><br><br><br><br><br>
					   <table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" id="patient_table">
					   <tr><td class="label" colspan="2">&nbsp;</td></tr>
					   <tr><td class="label" width="35%" ><fmt:message key="ePH.PharmacyTransactionType.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;&nbsp;<select name="PH_TRN_TYPE" id="PH_TRN_TYPE" onChange="searchBasedOnCriteria(this)" >
		                <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
						<%
						for(int i=0;PH_TRN_TYPE.size()>i;i++){
						%>
						<option value="<%=PH_TRN_TYPE.get(i)%>"><%=SHORT_DESC.get(i)%></option>
						  <%
						  }
						  %>
		                </select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
						</td>
         </tr>
          <tr>
		 	<td  class="label" ><fmt:message key="ePH.StockTransactionType.label" bundle="${ph_labels}"/></td>
		 	<td >&nbsp;&nbsp;<input type="text" name="StockTransactionType" id="StockTransactionType" value="" readonly></td>
         </tr>
		   <td class="label" width="35%" ><fmt:message key="ePH.STDocumentType.label" bundle="${ph_labels}"/></td>
		   <td>&nbsp;&nbsp;<select name="TRN_TYPE_CODE" id="TRN_TYPE_CODE"  >
		   <option value="Select">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" name="IMG"></img>
			</td>
         </tr>
		<tr><td class="label" colspan="2">&nbsp;</td></tr>
   </table>
<%
					     }
						%>



   <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">

 </form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

