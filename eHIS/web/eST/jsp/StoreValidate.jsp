<%@page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,javax.servlet.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

	String locale			= (String)session.getAttribute("LOCALE");

		
	StoreBean bean = (StoreBean)getBeanObject( "StoreBean", "eST.StoreBean" , request) ;  
	bean.setLanguageId(locale);
	String store_code	=	request.getParameter("store_code");
	String validate			=	request.getParameter("validate");

	String message			=	"";
	String flag				=	"INVALID_VALIDATE_FLAG";
	String facility_id=(String)session.getValue("facility_id");
	boolean	result			=	false;
	String department="";
//	String store_desc="";
	String external_yn="";
//	String count="";
//	String stock_item_yn="N";

	try{
		 if (validate.equals("STORE_CODE"))
			{
				flag="";

				try{

					ArrayList alParameters	=	new ArrayList();
					alParameters.add(facility_id);
					alParameters.add(locale);
					alParameters.add(store_code);
					alParameters.add(store_code);

					//HashMap hmRecord =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_STORE_CODE_VALIDATE"),alParameters);
					HashMap hmRecord =	bean.fetchRecord("SELECT store_code, st.short_desc, external_yn, (CASE WHEN st.store_group_code IS NOT NULL THEN (SELECT short_desc FROM mm_store_group_lang_vw WHERE st.store_group_code = store_group_code AND language_id = ST.LANGUAGE_ID) END ) group_desc FROM mm_store_lang_vw st  WHERE facility_id LIKE (?) AND st.language_id = ? AND UPPER (store_code) LIKE UPPER (?) AND st.eff_status = 'E' AND store_code NOT IN (SELECT store_code FROM st_store WHERE UPPER (store_code) LIKE UPPER (?))",alParameters);

				//	store_desc=(String)hmRecord.get("SHORT_DESC" )	;
					external_yn=(String)hmRecord.get("EXTERNAL_YN" )	;

					result=true;

					if(result)
					{
						ArrayList alParameter	=	new ArrayList(2);
						alParameter.add(facility_id);
						alParameter.add(store_code);
                    	HashMap hmRecord1 = new HashMap();

                        if(external_yn.equals("N")){
							hmRecord1 =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_STORE_DEPT"),alParameter);
							department=bean.checkForNull((String)hmRecord1.get("DEPARTMENT"))	;
						}
						//String strGroupDesc = bean.checkForNull((String)hmRecord.get("GROUP_DESC"));
						out.println("setStoreDetail(\""+store_code+"\",\""+department+"\",\""+bean.checkForNull((String)hmRecord.get("SHORT_DESC"))+"\",\""+hmRecord.get("EXTERNAL_YN")+"\",\""+bean.checkForNull((String)hmRecord.get("GROUP_DESC"))+"\");");
					}  
				}
				catch(Exception exception){ 
				flag			=	"STORE_ALRDY_EXISTS";
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
