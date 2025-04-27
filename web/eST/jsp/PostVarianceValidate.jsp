<%@page import="java.util.*, eST.Common.*,eST.*,java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			
	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	PostVarianceBean bean = (PostVarianceBean) getBeanObject( bean_id, bean_name, request ) ;
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
			String doc_type_code = (String) hash.get("doc_type_code");
			if (doc_type_code.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			if (!bean.isDocNoAutoGenYN(doc_type_code)) {
				out.println("enableDocNo();");
			}
			else {
				out.println("disableDocNo();");
			}
		}
		break;
	case 4: // This case will be executed on focus lost of Doc Date
		{
			int isValidDocDate = -1;
			String doc_date = (String) hash.get("doc_date");
			if(!locale.equals("en"))
			{
				//doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
				doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");//Added by Sakti against SKR-SCF-0929 - Inc#47445 to convert thai to english. because every validation is happening in english only. so we need to pass date after converting from thai to english.
			
			}
			if (doc_date.trim().equals("")) {
				out.println("errorDisplay();"); // To be replaced with proper message
				return;
			}
			isValidDocDate = bean.isValidDocDate(doc_date);
			String errorCode = null;
			if (isValidDocDate > 0) {
				if (isValidDocDate== 1) {
					errorCode = "ST_DOC_DT_NOT_LT_PROC_MTH";
				}
				else if (isValidDocDate== 2) {
					errorCode = "ST_DOC_DT_NOT_GR_SYSDATE";
				}
				String moduleid = "ST" ;
				out.println("requestDocDateFocus("+isValidDocDate+");");
				//out.println("assignResult(false,getMessage(\""+errorCode+"\"), \"0\")");
				out.println("assignResult(false,getMessage(\""+errorCode+"\", \"" + moduleid + "\"), \"0\")"); //Added by Sakti against SKR-SCF-0929 - Inc#47445. module ID passed
			} 
			else {
				out.println("assignResult(true,\"\", \"0\");");
				return;
			}
		}
		break;
	default :
		//To be replaced with proper message
		out.println("alert(\'Invalid Function\');");
		return;
	}


%>
<%
putObjectInBean(bean_id,bean,request);
%>
