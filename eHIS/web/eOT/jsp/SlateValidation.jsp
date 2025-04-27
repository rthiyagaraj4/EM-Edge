<%//@page  import="java.sql.*, java.util.*, java.io.*, eOT.Common.*, eOT.*" contentType="text/html;charset=" %>
<%@page  import ="eOT.*, eOT.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper,java.util.ArrayList,java.util.Hashtable"  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	try {
		
		String func_mode	= request.getParameter("func_mode");
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id		= "@SlateBean";
		String bean_name	= "eOT.SlateBean";
		SlateBean bean= (SlateBean)mh.getBeanObject( bean_id, request, bean_name );

		if(func_mode!= null && func_mode.equals("getMenuList")){
			try{
				String oper_status	= (String) hash.get("oper_status");
				String role_id		= (String) hash.get("user_role");
				String tab_name		= (String) hash.get("tab_name");
				String sch_type		= request.getParameter("sch_type");//newly added for removing function id 17 in unsch cases.,
				ArrayList menu_list_arr = (ArrayList)bean.getMenuList(oper_status,role_id,tab_name,sch_type);
				StringBuffer function_id_list	= new StringBuffer();
				StringBuffer function_name_list = new StringBuffer();
				StringBuffer url_desc_list		= new StringBuffer();
				for(int i=0;i<menu_list_arr.size();i+=3){
					function_id_list.append((String)menu_list_arr.get(i));
					function_id_list.append("##");

					function_name_list.append((String)menu_list_arr.get(i+1));
					function_name_list.append("##");

					url_desc_list.append((String)menu_list_arr.get(i+2));
					url_desc_list.append("##");
				}
				out.println("assignFunctionIDList(\"" + function_id_list + "\");") ;
				out.println("assignFunctionNameList(\"" + function_name_list + "\");") ;
				out.println("assignFunctionURLList(\"" + url_desc_list + "\");") ;
				function_id_list.setLength(0);
				function_name_list.setLength(0);
				url_desc_list.setLength(0);
			}catch(Exception e1){
				System.err.println("Execpetion in SlateValidation.jsp: line 43: "+e1);
			}
		}else if(func_mode!= null && func_mode.equals("clearBean")){
			bean.clear();
		}else if(func_mode!= null && func_mode.equals("validateUserPwd")){
			String user_id	= (String) hash.get("user_id");
			String password	= (String) hash.get("password");
			String function_id	= (String) hash.get("function_id");
			ArrayList valid_user_arr = bean.validateUserPwd(user_id,password,function_id);
			String valid_user_flag = (String)valid_user_arr.get(0)+"##"+(String)valid_user_arr.get(1);
			out.println(valid_user_flag);
		}else if(func_mode!= null && func_mode.equals("updateStatusAndCommit")){
			String function_id		= (String) hash.get("function_id");
			String oper_num			= (String) hash.get("oper_num");
			String booking_num		= (String) hash.get("booking_num");
			String order_id			= (String) hash.get("order_id");
			String slate_user_id	= (String) hash.get("slate_user_id");
			String tab_name			= (String) hash.get("tab_name");
			String waitlist_num		= (String) hash.get("waitlist_num");
			String theatre			= (String) hash.get("theatre");
			String waitlist_flag	= "";
			if(tab_name.equals("WAITLIST"))
				waitlist_flag = "Y";

			String error_text = bean.updateStatusAndCommit(function_id,booking_num,oper_num,slate_user_id,waitlist_flag,order_id,waitlist_num,theatre);
			if(error_text==null) error_text="";
			if(error_text!=null && error_text.equals("null")) error_text="";
			if(error_text!=null && error_text.equals("")) error_text="";
			if(!error_text.equals("") && !error_text.equals("RECORD_INSERTED"))
				out.println(error_text);
			else
				out.println("NO_ERROR_FOUND");
		}else if(func_mode!= null && func_mode.equals("getBarcodeMenuList")){
			ArrayList menu_list_arr = (ArrayList)bean.getBarcodeMenuList();
			StringBuffer function_id_list = new StringBuffer();
			StringBuffer function_name_list = new StringBuffer();
			StringBuffer url_desc_list		= new StringBuffer();
			for(int i=0;i<menu_list_arr.size();i+=3){
				function_id_list.append((String)menu_list_arr.get(i));
				function_id_list.append("##");

				function_name_list.append((String)menu_list_arr.get(i+1));
				function_name_list.append("##");

				url_desc_list.append((String)menu_list_arr.get(i+2));
				url_desc_list.append("##");
			}
			out.println("assignBarcodeFunctionIDList(\"" + function_id_list + "\");") ;
			out.println("assignBarcodeFunctionNameList(\"" + function_name_list + "\");") ;
			out.println("assignBarcodeFunctionURLList(\"" + url_desc_list + "\");") ;
			function_id_list.setLength(0);
			function_name_list.setLength(0);
			url_desc_list.setLength(0);
		}
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
%>
