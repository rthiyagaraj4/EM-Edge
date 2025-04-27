
 <%@page  import=" eMM.ItemUOMDefinition,java.util.HashMap"
contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String flag = "";
	String message = "";
	Boolean result = false;
	ItemUOMDefinition bean = (ItemUOMDefinition)getBeanObject( "ItemUOMDefinition","eMM.ItemUOMDefinition", request) ;  
	bean.setLanguageId(locale);
	//String validate		=	request.getParameter("validate");
	try {
		String item_code = request.getParameter("item_code");
		HashMap hmResult = (HashMap)bean.getGenItemUOM(item_code);
		out.println("document.ItemUOM_form.uom_code.value='"+(String)hmResult.get("GEN_UOM_CODE")+"';");
		out.println("document.ItemUOM_form.uom_desc.value='"+(String)hmResult.get("SHORT_DESC")+"';");
		result = true;
	}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
	}
	finally{
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("ItemUOMDefinition",bean,request);
%>
