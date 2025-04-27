 <%@page import="java.util.*, ePH.Common.*, ePH.*,eST.*,java.text.DecimalFormat " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	try {
		String identity		  = request.getParameter( "identity" );
		Hashtable hash		  = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash				  = (Hashtable)hash.get( "SEARCH" ) ;
		if(identity.equals("InsertMode")){
			String select_option	= (String) hash.get("select_option");
			String bean_id		  = hash.get( "bean_id" ).toString() ;
			String bean_name	  = hash.get( "bean_name" ).toString() ;
			HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);
			//bean.clear();//Commented for RUT-CRF-0061 [IN:45785]
			List<String> form_code_List = Arrays.asList(hash.get("selected_Array").toString()); 
			List<String> unchecked_formcode_List = Arrays.asList("");
			bean.setSelectedOption(select_option);
			bean.setFormCodeList(form_code_List,unchecked_formcode_List); 
			HashMap result=bean.insert();
			String message=result.get("message").toString();
			out.println("'"+message+"'");
			putObjectInBean(bean_id,bean,request);
		}
		else if(identity.equals("ModifyMode")){
			String select_option	= (String) hash.get("select_option");
			String bean_id		  = hash.get( "bean_id" ).toString() ;
			String bean_name	  = hash.get( "bean_name" ).toString() ;
			HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);
			bean.clear();//Commented for RUT-CRF-0061 [IN:45785]
			List<String> form_code_List = Arrays.asList(hash.get("selected_Array").toString()); 
			List<String> unchecked_formcode_List = Arrays.asList(hash.get("uncheck_data").toString());
			bean.setSelectedOption(select_option);
			bean.setFormCodeList(form_code_List,unchecked_formcode_List); // Commented for RUT-SCF-0358[IN:46704]
			bean.setUncheckedData(unchecked_formcode_List,form_code_List);// Commented for RUT-SCF-0358[IN:46704]
			ArrayList unchechdata=bean.getUncheckedData();
			HashMap result=bean.modify();
			String message=result.get("message").toString();
			out.println("'"+message+"'");
			putObjectInBean(bean_id,bean,request);
		}
		else if(identity.equals("Store_select")){//Added for RUT-CRF-0061 [IN:45785] - Start
			String bean_id		  = hash.get( "bean_id" ).toString() ;
			String bean_name	  = hash.get( "bean_name" ).toString() ;
			HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);
			List<String> check_associate_data=new ArrayList();
			List<String> uncheck_associate_data =new ArrayList();
			List<String> form_code_List = Arrays.asList(hash.get("selected_Array").toString());
			List<String> unchecked_formcode_List = Arrays.asList(hash.get("uncheck_data").toString());
			
			if(!hash.get("check_associate_data").toString().equals(""))
				check_associate_data = Arrays.asList(hash.get("check_associate_data").toString());
			
			if(!hash.get("uncheck_associate_data").toString().equals(""))
				uncheck_associate_data = Arrays.asList(hash.get("uncheck_associate_data").toString());
			
			bean.setFormCodeList(form_code_List,unchecked_formcode_List);
			bean.setUncheckedData(unchecked_formcode_List,form_code_List);
			bean.setFormAssociatedRecords(check_associate_data,uncheck_associate_data);
			putObjectInBean(bean_id,bean,request);
		}
		else if(identity.equals("Store_associate")){
			String bean_id		  = hash.get( "bean_id" ).toString() ;
			String bean_name	  = hash.get( "bean_name" ).toString() ;
			HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);
			List<String> form_code_List = Arrays.asList(hash.get("selected_Array").toString()); 
			List<String> unchecked_formcode_List = Arrays.asList(hash.get("uncheck_data").toString());
			bean.setFormCodeList(form_code_List,unchecked_formcode_List);
			bean.setUncheckedData(unchecked_formcode_List,form_code_List);
			putObjectInBean(bean_id,bean,request);
		}//Added for RUT-CRF-0061 [IN:45785] - End
		else if(identity.equals("Onchange_tab")){// Added for RUT-SCF-0358[IN:46704]
			String bean_id		  = hash.get( "bean_id" ).toString() ;
			String bean_name	  = hash.get( "bean_name" ).toString() ;
			HomeMednSheetBean bean = (HomeMednSheetBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.setLanguageId(locale);
			bean.setFormAssociatedRecords(new ArrayList(),new ArrayList());
			putObjectInBean(bean_id,bean,request);
		}
	}//Modified for RUT-SCF-0358[IN46714] - End
	catch(Exception e) {
		e.printStackTrace();
	}
%>
