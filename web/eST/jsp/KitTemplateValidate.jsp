<%@page  import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	KitTemplateBean bean = (KitTemplateBean)getBeanObject( "kitTemplateBean","eST.KitTemplateBean", request ) ;  
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
	String uom_code					=	request.getParameter("uom_code");
	String seq_no					=	request.getParameter("seq_no");
	String eff_status				=	request.getParameter("eff_status");
	String db_action				=	request.getParameter("db_action")==null?"I":request.getParameter("db_action");
	String usage_type				=	request.getParameter("usage_type")==null?"":request.getParameter("usage_type"); //27/07/12
	
	try {
		if (validate.equals("ADD_TO_LIST")) {
			try{
				hashmapDtl.put("item_code",		item_code );
				hashmapDtl.put("item_desc",		item_desc );
				hashmapDtl.put("qty",			qty		  );
				hashmapDtl.put("uom_code",		uom_code  );
				hashmapDtl.put("seq_no",		seq_no	  );
				hashmapDtl.put("eff_status",	eff_status);
				hashmapDtl.put("db_action",     db_action );
				hashmapDtl.put("usage_type",     usage_type ); //27/07/12
				

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
			//code added for Issue UOM Details...
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

			
			//code ended...
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
putObjectInBean("kitTemplateBean",bean,request);
%>
