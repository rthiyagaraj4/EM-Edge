 
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/02/2014				42063			        Suresh R           27/02/2014        Suresh R     AMS-CRF-0054(Added Item Based IssueReturn)

--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@page import=" eST.*,eST.Common.* , eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>  

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj39"   scope="page"  class="eST.BatchSearchIssueReturnBean"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	int functionType = Integer.parseInt(request.getParameter("function_type"));

	String bean_id = "BatchSearchIssueReturnBean";
	String bean_name = "eST.BatchSearchIssueReturnBean";
	BatchSearchIssueReturnBean bean = (BatchSearchIssueReturnBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	IssueReturnBean bean1 = (IssueReturnBean)getBeanObject("issueReturnBean","eST.IssueReturnBean", request ) ;   
	bean1.setLanguageId(locale);
	bean.clear();

	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
				String item_code_from	=   CommonBean.checkForNull(request.getParameter("item_code_from"),"");
				String store_code_from	=	CommonBean.checkForNull(request.getParameter("store_code_from"),"");
				String store_code_to	=	CommonBean.checkForNull(request.getParameter("store_code_to"),"");
				String issue_doc_no		=	CommonBean.checkForNull(request.getParameter("issue_doc_no"),"");
				String doc_type_code	=	CommonBean.checkForNull(request.getParameter("doc_type_code"),"");
				String doc_no			=	CommonBean.checkForNull(request.getParameter("doc_no"),"");
				String trn_type			=	CommonBean.checkForNull(request.getParameter("trn_type"),"");
				String seq_no			=	CommonBean.checkForNull(request.getParameter("seq_no"));
				bean.setItem_code_from(item_code_from) ;
				bean.setStore_code_from(store_code_from) ;
				bean.setStore_code_to(store_code_to) ;
			
				if(!issue_doc_no.equals("")){//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
				bean.setIssueDocNo(issue_doc_no) ;}
				bean.loadResultPage(doc_type_code,doc_no,trn_type,bean1.getIssueDocTypeCode(),seq_no);
		}
		break;
		case 2:
		{
		}
		break;
		case 3:
		{
			out.println("document.forms[0].count.value=1;");
		}
		break;
		case 4:
		{
			String index= request.getParameter( "index" )==null?"":request.getParameter( "index" ) ;
			String noOfCheckedRecords= request.getParameter( "noOfCheckedRecords" )==null?"":request.getParameter( "noOfCheckedRecords" ) ;
			bean.selectedBatches(index,noOfCheckedRecords);
		}
		break;
		default :
		out.println("alert(\'Invalid Function\');");
		return;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
