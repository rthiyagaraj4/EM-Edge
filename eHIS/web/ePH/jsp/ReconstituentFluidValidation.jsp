
 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String item_code	=	(String) hash.get("item_code");
	String base_uom		=	(String) hash.get("base_uom");
	String bean_id		=	(String) hash.get("bean_id");
	String bean_name	=	(String) hash.get("bean_name");
	String fluid	=	(String) hash.get("fluid");
    int flid_res=0;
   	ReconstituentFluidBean bean = (ReconstituentFluidBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	String vldstr=(String) bean.validate(bean.getSaleUOM(item_code),base_uom);
    flid_res = bean.getFluidId(fluid); 
	
  if(flid_res>0)
  {
	  out.println("fluidCheck(\""+fluid+"\")");
  } 
	if(vldstr=="Error"){
			out.println("alert(getMessage('PH_CONV_FACTOR_NOT_DEF','PH'))");
			out.println("ResetToDefaultValues()");
			out.println("obj.focus()");
	}else{
		out.println("assignBaseUnit(\""+vldstr+"\")");
	}
	
putObjectInBean(bean_id,bean,request);
%> 
