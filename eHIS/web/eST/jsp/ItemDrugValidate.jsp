<%@page import="java.util.*, eST.Common.*, eST.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	String locale			= (String)session.getAttribute("LOCALE");

	
	String bean_id					= request.getParameter("bean_id");
	String bean_name				= request.getParameter("bean_name");
	String validate					= request.getParameter("validate");
	String message					= "";
	String flag						= "";
	boolean	result					= false;
	String total					= "";
	String p_ret_value				= "";
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	ItemBean bean = (ItemBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	String item_code = (String) hash.get("item_code");
	bean.setItemCode( item_code );
		try {
			if (validate.equals("CHECK_DRUG")) 
			{
				try {
				HashMap addResult = new HashMap();
				addResult = bean.getValidDrug(hash);
				p_ret_value = (String)addResult.get("p_ret_value");
				if(!p_ret_value.equals("1"))
					{
					result	=	false;
					flag	=	"INVALID_DRUG_CODE";
					message	=	"Done";
				}
				}
				catch(Exception e)
				{e.printStackTrace();
				}
			}else if (validate.equals("ORDER_CATALOG")){
				try {
					//HashMap addResult = new HashMap();
					//addResult = bean.getOrderCount(item_code);
					String ord_cat_count = bean.getOrderCount(item_code);
					if(ord_cat_count.equals("0"))
						out.println("f_query_add_mod.document.formItemHeader.mode.value=1;");	
					else
						out.println("f_query_add_mod.document.formItemHeader.mode.value=2;");
					result = true;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else{
				try{
 						String sql = bean.getStRepositoryValue("SQL_SM_MODULES_FACILITY_COUNT_VALID");
						ArrayList sqlParam = new ArrayList (2);
						sqlParam.add(bean.getLoginFacilityId());
						sqlParam.add("PH");
						HashMap hmValues = bean.fetchRecord(sql,sqlParam);
						if(hmValues==null) return;
						total =bean.checkForNull((String)hmValues.get("TOTAL"),"");
					} catch( Exception e) {	
					e.printStackTrace();
					}
					boolean drugCanBeEnabled	=	false;
					if(total.equals("1")) {
						HashMap addResult = new HashMap();
						addResult = bean.DrugCheck(hash);
						p_ret_value = (String)addResult.get("p_ret_value");
						out.println("document.formItemHeader.drug_item_indicator.value= '"+p_ret_value+"';");
						if(p_ret_value.equals("S"))
						{
							out.println("document.formItemHeader.drug_desc.value= '"+bean.checkForNull((String) addResult.get("p_drug_desc"),"")+"';");
						out.println("document.formItemHeader.drug_code.value= '"+bean.checkForNull((String) addResult.get("p_drug_code"),"")+"';");
							out.println("document.formItemHeader.drug_desc.disabled='true';");
							out.println("document.formItemHeader.drug_search.disabled='true';");
							out.println("document.formItemHeader.drug_item_yn.checked='true';");
							out.println("document.formItemHeader.drug_item_yn.disabled='true';");
							out.println("document.formItemHeader.spare_part_id.disabled='false';");
										}
						else if(p_ret_value.equals("D"))
						{
							drugCanBeEnabled	=	true;
						}

						else if(p_ret_value.equals("A"))
						{
							out.println("ConfirmBox();");
						}
						else{
						}						
						result	=	true;
						message	=	"Done";
				out.println("document.formItemHeader.drug_code_can_be_enabled.value='"+drugCanBeEnabled+"';");
						return;
					} 
					else
					{	
						drugCanBeEnabled	=	false;
	out.println("document.formItemHeader.drug_code_can_be_enabled.value='"+drugCanBeEnabled+"';");
						return;
					}
			}
			}
			catch ( Exception e1) {
				result	=	false;
				flag	=	"INVALID_ITEM_CODE";
				message	=	e1.getMessage();
				out.println("document.formItemHeader.item_search.disabled='false';");
				out.println("document.formItemHeader.reset();");
				out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML='&nbsp';");
			}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%><%
putObjectInBean(bean_id,bean,request);
%>
