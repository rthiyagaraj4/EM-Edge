<%@ page import ="eST.SalesReturnBatchSearchBean,eST.SalesReturnBean,java.util.Hashtable" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<jsp:useBean id="XMLobj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj511"   scope="page"  class="eST.SalesReturnBatchSearchBean"/>

<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

	int functionType = Integer.parseInt(request.getParameter("function_type"));

	String bean_id = "SalesReturnBatchSearchBean";
	String bean_name = "eST.SalesReturnBatchSearchBean";
	SalesReturnBatchSearchBean bean = (SalesReturnBatchSearchBean)getBeanObject( bean_id, bean_name,request );

	java.util.Properties prop			=		(java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no				=		prop.getProperty( "client_ip_address" );
	String bean_id1						=		"salesReturnBean"+login_at_ws_no;
	String bean_name1					=		"eST.SalesReturnBean";


	SalesReturnBean bean1 = (SalesReturnBean)getBeanObject( bean_id1, bean_name1 , request) ;  

	bean.setLanguageId(locale);
	bean.clear();

	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");

	switch (functionType) {

	case 1:
		{
				
				String item_code_from	=   CommonBean.checkForNull(request.getParameter("item_code_from"),"");
				String store_code		=	CommonBean.checkForNull(request.getParameter("store_code"),"");
                String sal_trn_type		=	CommonBean.checkForNull(request.getParameter("sal_trn_type"),"");
				String patient_id		=	CommonBean.checkForNull(request.getParameter("patient_id"),"");
				String encounter_id		=	CommonBean.checkForNull(request.getParameter("encounter_id"),"");

				//String from			= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
				//String to			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;

				bean.setItem_code_from(item_code_from) ;
				bean.setStore_code(store_code) ;
				//added by Pankaj on 12/07/2004 
                bean.setSal_trn_type(sal_trn_type) ;
				bean.setPatient_id(patient_id) ;
				bean.setEncounter_id(encounter_id) ;
				String doc_type_code	=	CommonBean.checkForNull(request.getParameter("doc_type_code"),"");
				String doc_no			=	CommonBean.checkForNull(request.getParameter("doc_no"),"");
				String trn_type			=	CommonBean.checkForNull(request.getParameter("trn_type"),"");
				bean.loadResultPage(doc_type_code,doc_no,trn_type,CommonBean.checkForNull((String)bean1.getSalesDocTypeCode()),CommonBean.checkForNull((String)bean1.getSalesDocNo()));
		}
		break;
		case 2:
		{
			//String start		= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
			//String end			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
			//String stColumnName	= request.getParameter( "ordercolmns" )==null?"":request.getParameter( "ordercolmns" ) ;
		}
		break;
		case 3:
		{
			//String start		= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
			//String end			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
			//String stColumnName	= request.getParameter( "ordercolmns" )==null?"":request.getParameter( "ordercolmns" ) ;
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
