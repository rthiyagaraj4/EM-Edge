<%@page import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>  

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

%>

<%
	boolean	result					=		false;
	String message					=		"";
	String flag						=		"";
	String bean_id					=		request.getParameter( "bean_id" ) ;
	String bean_name				=		request.getParameter( "bean_name" ) ;
	String validate					=		request.getParameter( "validate" ) ;
	String store_code				=		request.getParameter( "store_code" ) ;
	String store_desc				=		request.getParameter( "store_desc" ) ;
	String parent_store_code		=		request.getParameter( "parent_store_code" ) ;
	//String parent_store_desc		=		request.getParameter( "parent_store_desc" ) ;
	Hashtable hash					=		( Hashtable )XMLobj.parseXMLString( request ) ;
	hash							=		( Hashtable )hash.get( "SEARCH" ) ;
	String result1					=		"Y";
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( validate == null || validate.equals( "" ) )
		return ;	

	ParentStoreForStoreBean beanObj = ( ParentStoreForStoreBean )getBeanObject(bean_id,bean_name,request) ;
	beanObj.setLanguageId(locale);

try
{
		if(validate.equals("STORE_DESC")) 
		{
	
			String  result_bean							=		 beanObj.checkStoreDesc(store_code,store_desc);
			//String  result_bean1						=		 beanObj.checkStoreDesc(parent_store_code,parent_store_desc);

			if((result_bean.equals("1"))) {//&&(result_bean1.equals("1"))){
				result			=	true;
				message			=	"done";
				 result1		=	"Y";
				out.println("setResult();");
				   
				 }

			else{
				 result1		=	"N";
				 result			=	false;
				 out.println("setResultNo();");
			}
					
		}else if(validate.equals("REFRESHDETAIL")){
			int count = Integer.parseInt((String)request.getParameter("tot_item_class"));
			ArrayList alRecords = new ArrayList();
//alRecords.add((String)hash.get("store_code"));
//alRecords.add((String)hash.get("parent_store_code"));
			for(int i=0;i<count;i++){
				if(((String)hash.get("eff_status_"+i)).equals("Y"))
					alRecords.add((String)hash.get("item_class_code_"+i));
			}
			beanObj.alhmData.put((String)hash.get("parent_store_code"),alRecords);
			result = true;
		}else if(validate.equals("DELETERECORD")){
			if(beanObj.alhmData.containsKey(parent_store_code))
			beanObj.alhmData.remove(parent_store_code);
			result = true;
		}
		
	}
	catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		
		exception.printStackTrace();

		flag=validate;
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
