 <%@page  import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%
	StoreBean bean = (StoreBean)getBeanObject( "StoreBean","eST.StoreBean",request ) ;  
	String store_code	=	request.getParameter("store_code");
	String validate			=	request.getParameter("validate");

	String message			=	"";
	String flag				=	"INVALID_VALIDATE_FLAG";
	String facility_id=(String)session.getValue("facility_id");
	boolean	result			=	false;
	//String department="";
	//String store_desc="";
	//String external_yn="";
	//String count="";
//	String stock_item_yn="N";

	try{
		 if (validate.equals("STORE_CODE"))
			{
				flag="";
				
				try{
					ArrayList alParameters	=	new ArrayList(2);
					alParameters.add(facility_id);
					alParameters.add(store_code);
					alParameters.add(store_code);
					HashMap hmRecord =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_STORE_CODE_VALIDATE"),alParameters);
					result=true;
					if(result)
					{
						ArrayList alParameter	=	new ArrayList(2);
						alParameter.add(facility_id);
						alParameter.add(store_code);
						HashMap hmRecord1 =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_STORE_DEPT"),alParameter);
					//	store_desc=(String)hmRecord.get("SHORT_DESC" )	;
					//	external_yn=(String)hmRecord.get("EXTERNAL_YN" )	;
					//	department=(String)hmRecord1.get("DEPARTMENT" )	;
						out.println("setStoreDetail(\""+store_code+"\",\""+hmRecord1.get("DEPARTMENT")+"\",\""+hmRecord.get("SHORT_DESC")+"\",\""+hmRecord.get("EXTERNAL_YN")+"\");");

					}
				}
				catch(Exception exception){
				flag			=	"INVALID_STORE_CODE";
				result			=	false;
				}
		}
		//Added by Martin
		else if (validate.equals("PARENT_STORE")) {
			result=true;
			flag = "";
			out.println("clearListItems('formStore.parent_store_code'); ");
			ArrayList parentStores = bean.getParentStores(store_code);
			for(int i=0; i< parentStores.size(); i++) {
				String[] record = (String[])parentStores.get(i);
				out.println("addListItem(\"formStore.parent_store_code\", \"" + record[0] + "\",\"" + record[1] + "\");");
			}
		}
/*		else if(validate.equals("STORE_TYPE"))
		{
			try{
			ArrayList alParameter	=	new ArrayList(2);
			alParameter.add(store_code);
			HashMap hmRecord1 =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_STORE_TYPE_VALIDATE"),alParameter);
			stock_item_yn=(String)hmRecord1.get("STOCK_ITEM_YN" )	;
				out.println("setStoreType(\""+stock_item_yn+"\");");
			//out.println("stock_item_yn"+stock_item_yn);
				flag			=	"";
				result			=	true;
			}catch(Exception e)
			{
				flag			=	"INVALID_STORE_TYPE";
				result			=	false;
			}
		}*/
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("StoreBean",bean,request);
%>
