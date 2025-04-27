<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*, eCommon.Common.*,java.util.*,java.sql.*,webbeans.eCommon.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String	bean_id			=	"SlidingScaleTmpl" ;
	String	bean_name		=	"ePH.SlidingScaleTmplBean";
	SlidingScaleTmplBean bean = (SlidingScaleTmplBean)getBeanObject(bean_id,bean_name,request );  
	bean.setLanguageId(locale);
	String validate		=	request.getParameter("validate");
	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	String index			=	request.getParameter("index");;
	boolean	result			=	false;
	
	HashMap hashmapDtl          =   new HashMap();
	String from_uom				=	request.getParameter("from_uom");
	String to_uom				=	(request.getParameter("to_uom")==null || request.getParameter("to_uom").equalsIgnoreCase("Null"))?"0":request.getParameter("to_uom");
	String admin_units			=	request.getParameter("admin_units");
	String informPractitioner	=	request.getParameter("informPractitioner")==null?"N":request.getParameter("informPractitioner");
	String remarks				=	request.getParameter("remarks");
    String eff_status			=	request.getParameter("eff_status");
    
	String db_action			=	request.getParameter("db_action")==null?"I":request.getParameter("db_action");
    
	try {
		if (validate.equals("ADD_TO_LIST")) {//for adding to bean object the range details values
			try{
				String rangeUOM_desc		=	request.getParameter("rangeUOM_desc")==null?"":request.getParameter("rangeUOM_desc");
				String adminUnitUOM_desc		=	request.getParameter("adminUnitUOM_desc")==null?"":request.getParameter("adminUnitUOM_desc");
                bean.setRangeUOM_desc(rangeUOM_desc);
                bean.setAdminUnitUOM_desc(adminUnitUOM_desc);
				hashmapDtl.put("from_uom", from_uom);
				hashmapDtl.put("to_uom",to_uom );
				hashmapDtl.put("admin_units",admin_units);
				if(((String)informPractitioner).equals("Y"))
					informPractitioner="Y";
				else
					informPractitioner="N";
				hashmapDtl.put("informPractitioner",informPractitioner);
				hashmapDtl.put("remarks",remarks);
                hashmapDtl.put("eff_status",eff_status);
              
                String[]  key		=new String[]{"from_uom","to_uom"};
				String[] value		=new String[]{from_uom,to_uom};
				if(bean.isDuplicateAdminValueInArrayList(bean.getDtlRecords(),"admin_units",admin_units,Integer.parseInt(index))){
						//result	=	false;
						//message	=	"RANGE_DETAILS_RECORD_ALREADY_EXISTS";
						throw new Exception("ADMIN_UNIT_ALREADY_EXISTS");	//For duplicate Entry.
					}
				if(bean.isDuplicateInArrayList(bean.getDtlRecords(),key,value,Integer.parseInt(index))){
						//result	=	false;
						//message	=	"RANGE_DETAILS_RECORD_ALREADY_EXISTS";
						throw new Exception("RANGE_DETAILS_RECORD_ALREADY_EXISTS");	//For duplicate Entry.
				}if((bean.getDtlRecords()).size() >0 ){ //For checking previous to value
			         if(bean.isFromrangeGraterThenToRane(bean.getDtlRecords(),key[1],value[0],Integer.parseInt(index))){
				        throw new Exception("FROM_RANGE_GRT_PREV_TO_RANGE");	//For checking previous to value
				     }
				 }if(Integer.parseInt(index) !=-1 && to_uom.equals("0") && Integer.parseInt(index)<bean.getDtlRecords().size()-1){
						throw new Exception("PH_DUP_RANGE_DETAILS_SEQ_NO");
				 }
				 if(bean.isDuplicateSequence(bean.getDtlRecords(),key,value,Integer.parseInt(index))){
						//result	=	false;
						throw new Exception("PH_DUP_RANGE_DETAILS_SEQ_NO"); //For overlaping of ranges.
						//message	=	"PH_DUP_RANGE_DETAILS_SEQ_NO";
					}
					if((bean.getDtlRecords()).size() >0 ){ //For new Insertion
			         if(bean.isFreezedTransaction(bean.getDtlRecords(),key[1],Integer.parseInt(index))){
				        throw new Exception("TO_RANG_NO_NEW_REC_ALLOWED");	//For freeze transaction.
				     }
					}
					if((bean.getDtlRecords().size() >1) && !admin_units.equals("0")){ //For restricting Insertion of admin Unit  for assending or decending
						String possibleOutCome=bean.possibleOutComeForAdminValueInArrayList(bean.getDtlRecords(),"admin_units",
							admin_units,Integer.parseInt(index));
			        if(possibleOutCome.equalsIgnoreCase("AscendingOrderEcception")){
						 throw    new Exception("INVALID_ASC_ADMIN_UNIT");//
					 }else if (possibleOutCome.equalsIgnoreCase("DecendingOrderEcception")) {
						  throw   new Exception("INVALID_DESC_ADMIN_UNIT");//
	                 }
					}

				bean.updateDtlRecord(Integer.parseInt(index),hashmapDtl);

			}catch(Exception exception){

				 if (exception.getMessage().equals("RANGE_DETAILS_RECORD_ALREADY_EXISTS")) {
				throw exception;
				}else if (exception.getMessage().equals("ADMIN_UNIT_ALREADY_EXISTS")) {
				throw exception;
				}else if (exception.getMessage().equals("PH_DUP_RANGE_DETAILS_SEQ_NO")) {
				throw exception;
				}else if (exception.getMessage().equals("TO_RANG_NO_NEW_REC_ALLOWED")) {
				throw  exception;
				}else if (exception.getMessage().equals("FROM_RANGE_GRT_PREV_TO_RANGE")){
					  //For from should grater then previous to
				  throw  exception;
				}else if (exception.getMessage().equals("INVALID_ASC_ADMIN_UNIT")){
					  //DecendingOrderEcception
				  throw exception;
				}else if (exception.getMessage().equals("INVALID_DESC_ADMIN_UNIT")){
					  //AssendingOrderEcception
				  throw exception;
				}
			}
			result			=	true;
		}else if(validate.equals("UPDATE_STATUS")){//for Updating check box status in bean class 
			try{
			HashMap record			    =	    null;
			ArrayList alDtlRecords		=		new ArrayList();
	         alDtlRecords				=		bean.getDtlRecords();
			 record =	(HashMap)alDtlRecords.get(Integer.parseInt(index));
			 hashmapDtl.put("from_uom", record.get("from_uom"));
			 hashmapDtl.put("to_uom",record.get("to_uom") );
			 hashmapDtl.put("admin_units",record.get("admin_units"));
			 hashmapDtl.put("informPractitioner",record.get("informPractitioner") );
			 hashmapDtl.put("remarks",record.get("remarks"));
             hashmapDtl.put("eff_status",eff_status);
			 bean.updateDtlRecord(Integer.parseInt(index),hashmapDtl);
			 
          }catch(Exception exception){
			  throw exception;
		  }
		  result			=	true;
		} 
	}catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
	}finally{
		//for assign back the final result to js
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
