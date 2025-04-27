
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"  import=" eSS.*,eSS.Common.*,java.util.*"%>  
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
	request.setCharacterEncoding("UTF-8");
	eSS.SsItemBean bean = (eSS.SsItemBean)getBeanObject( "SSitemBean", "eSS.SsItemBean",request ) ;  
	String validate			=	request.getParameter("validate");

	String item_code		=	request.getParameter("item_code");

	String message			=	"";
	String flag				=	"";
	boolean	result			=	true;

	try{
		if (validate.equals("ITEM_DESC")){
			try{
				out.println("setItemDetails(\""+item_code.toUpperCase()+"\",\""+bean.getItemDescription(item_code.toUpperCase())+"\");");
			}
			catch(Exception exception){
				flag			=	"INVALID_SS_ITEM_CODE";
				result			=	false;
			}
		}
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
