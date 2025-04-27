<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eST.*,eSS.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	CheckListBean bean = (CheckListBean)getBeanObject( "checkListBean","eSS.CheckListBean", request ) ;  
	bean.setLanguageId(locale);
	String validate		=	request.getParameter("validate");
	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	String index			=	request.getParameter("index");;
	boolean	result			=	false;
	//String facility_id=(String)session.getValue("facility_id");
	HashMap hashmapDtl=new HashMap();
	String item_code				=	request.getParameter("item_code");
	String item_desc				=	request.getParameter("item_desc");
	String qty						=	request.getParameter("qty");
	String mandatory_status					=	request.getParameter("mandatory_status");
	String seq_no					=	request.getParameter("seq_no");
	String eff_status				=	request.getParameter("eff_status");
	String db_action				=	request.getParameter("db_action")==null?"I":request.getParameter("db_action");
	try {
		if (validate.equals("ADD_TO_LIST")) {
			try{
				hashmapDtl.put("item_code",		item_code );
				hashmapDtl.put("item_desc",		item_desc );
				hashmapDtl.put("qty",			qty		  );
				//hashmapDtl.put("uom_code",		uom_code  );
                hashmapDtl.put("mandatory_status",	mandatory_status);
				hashmapDtl.put("seq_no",		seq_no	  );
				hashmapDtl.put("eff_status",	eff_status);
				hashmapDtl.put("db_action",     db_action );

				String[]  key1		=	{"seq_no"};
				String[] value1		=	{seq_no};
				String[] stNames	=	{"item_code"};
				String[] stValues	=	{item_code};
				if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index))) { 
					throw new Exception("RECORD_ALREADY_EXISTS");
				}
				else if(bean.isDuplicateInArrayList(bean.getDtlRecords(),key1,value1,Integer.parseInt(index))){
						//result	=	false;
						throw new Exception("SEQ_NO_ALREADY_EXIST");
						//message	=	"SEQ_NO_ALREADY_EXIST";
					}
				bean.updateDtlRecord(Integer.parseInt(index),hashmapDtl);
			}catch(Exception exception){
				if (exception.getMessage().equals("RECORD_ALREADY_EXISTS")) {
				throw exception;
				}
				else if (exception.getMessage().equals("SEQ_NO_ALREADY_EXIST")) {
				throw exception;
				}
			}
			result			=	true;
		}else if(validate.equals("GET_STATUS")) {
			try { 
			result		=	true;
			
			/*//code added for Issue UOM Details...
				String gen_uom_code			=	bean.getGenItemUOM(item_code);
				out.println("clearListItems('document.KitTemplateAddModifyform.uom_code'); ");
			 		ArrayList iss_results	= bean.getUom_code_List(item_code);
					HashMap record			=	null;
					for(int i=0; i< iss_results.size(); i++) 
					{
					record			=	(HashMap)iss_results.get(i);
					String listRecord1		=	(String)record.get("EQVL_UOM_CODE");
					String listRecord2		=	(String)record.get("SHORT_DESC");
					if(gen_uom_code !=null || gen_uom_code ==""){
						out.println("addListItem(\"document.KitTemplateAddModifyform.uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +gen_uom_code+"\") ; ");
					}else{
						out.println("addListItem(\"document.KitTemplateAddModifyform.uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\" ,\"" +gen_uom_code+"\") ; ");
					}
					}

			
			//code ended...*/
			}
			catch (Exception exception) {
				message = exception.getMessage();
			}
		}

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
putObjectInBean("checkListBean",bean,request);
%>
