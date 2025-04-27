  <%@page import="java.util.*,ePO.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id				=	request.getParameter("bean_id");
	String bean_name			=	request.getParameter("bean_name");
	int functionType			=	Integer.parseInt(request.getParameter("function_type"));
	boolean result			=		false;
	String message			=		"";
	String flag				=		"";

	request.setCharacterEncoding("UTF-8");
	String locale				=	(String)session.getAttribute("LOCALE");
	
	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	DeliveryOrderCancelBean bean		=	(DeliveryOrderCancelBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Hashtable hash				=	(Hashtable) XMLobj.parseXMLString(request);
    hash						=	(Hashtable) hash.get ("SEARCH");	
	
	switch (functionType) {
	case 1:
		{
		   System.out.println("hash=====>" +hash);
			bean.updateRemarks(hash);
		}
		break;
	case 2:
		{
			System.out.println("hash===in do validate updateSelectedValues==>" +hash);
			bean.updateSelectedValues(hash);
			
		} 
		break;
	case 3:
		{
		try{	
			String do_no	=	request.getParameter("do_no");
			String do_srl_no	=	request.getParameter("do_srl_no");
			String item_code	=	request.getParameter("item_code");
			String rem_value	=	request.getParameter("rem_value");
								
			bean.setTFRExpRecords(do_no+"-"+do_srl_no+"-"+item_code,rem_value);
			System.out.println("bean.getTFRExpRecords = "+bean.getTFRExpRecords());
			
			result = true;
			flag="";
		}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		}
		break;
	case 4:
		{
		try{	
			
			HashMap hmTemp	=	new HashMap();
			ArrayList alExpRecords = new ArrayList();
		
			hmTemp = bean.getTFRExpRecords();
			System.out.println("hmTemp = "+hmTemp);
			
			if(hmTemp.size() > 0){
				result = true;
				flag="";
			}	
		}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
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
