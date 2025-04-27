<%@page contentType="text/html;charset=UTF-8" import=" ePO.*,ePO.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale							=		(String)session.getAttribute("LOCALE");
	String bean_id							=		request.getParameter("bean_id");
	String bean_name						=		request.getParameter("bean_name");	
	String functionType						=		request.getParameter("function_type");
	int index								=		Integer.parseInt(request.getParameter("index"));

	System.out.println("index = " + index);

	if (("multipleInsertMasterTypeBean" == null) || ("multipleInsertMasterTypeBean".equals("")))
		return;

  
	MultipleInsertMasterTypeBean bean		=		(MultipleInsertMasterTypeBean) getBeanObject(bean_id, bean_name, request  );
	bean.setLanguageId(locale);

	Hashtable hash			=		(Hashtable) XMLobj.parseXMLString(request);
    hash					=		(Hashtable) hash.get ("SEARCH");

	
	boolean result			=		false;
	String message			=		"";
	String flag				=		"";
		
	System.out.println("functionType"+functionType);
	System.out.println("hash"+hash);

	if(functionType.equals("SETVALUES")){

			try{
			  bean.updateAllRecords(index, hash);

				result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}


%>
<%
putObjectInBean(bean_id,bean,request);
%>
