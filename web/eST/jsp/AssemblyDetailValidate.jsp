<%@page import="java.util.*, eST.Common.*, eST.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>



<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="AssemblyDtlList" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
	String bean_id = "AssemblyDetailBean";
	String bean_name = "eST.AssemblyDetailBean";
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	

	AssemblyDetailBean bean = (AssemblyDetailBean) getBeanObject(bean_id,bean_name,request);
			bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");

	
	String instruction=	bean.checkForNull(request.getParameter("instruction"));

	switch (functionType) {
	case 1:
		{

			boolean	result				=	true;
			String message="";
			String flag					=	"";
			try{
					String  key="CHILD_ITEM_CODE";
					String  key1="SEQ_NO";

					String value=(String)hash.get("child_item_code");
					String value1=(String)hash.get("Seqence_No");
					
					if(bean.isDuplicateInArrayList(AssemblyDtlList,key,value,Integer.parseInt("-1"))){
						result	=	false;
						message	=	"ITEM_CODE_ALREADY_EXIST";
					}
					else if(bean.isDuplicateInArrayList(AssemblyDtlList,key1,value1,Integer.parseInt("-1"))){
						result	=	false;
						message	=	"SEQ_NO_ALREADY_EXIST";
					}
				 	else{
						result	=	true;
						message	=	"done";
					}

					if  (result){
						String stock_uom=CommonBean.checkForNull(request.getParameter("stock_uom"),"");
						String Conv_factor=CommonBean.checkForNull(request.getParameter("Conv_factor"),"");
						String allow_deci_yn = CommonBean.checkForNull(request.getParameter("allow_deci_yn"),"N");
					    String no_deci = CommonBean.checkForNull(request.getParameter("no_deci"),"0");



						String mfg_desc=CommonBean.checkForNull(request.getParameter("mfg_desc"),"");
						
					HashMap hmAssemblyDetailRecord=new HashMap();
					hmAssemblyDetailRecord.put("CHILD_ITEM_CODE",(String)hash.get("child_item_code") );
					hmAssemblyDetailRecord.put("COMPONENT_QTY",(String)hash.get("component_qty") );
					hmAssemblyDetailRecord.put("SHORT_DESC",(String)hash.get("child_item_code_desc") );
					hmAssemblyDetailRecord.put("COMPONENT",(String)hash.get("component") );
					hmAssemblyDetailRecord.put("MANDATORY",(String)hash.get("mandatory") );
					hmAssemblyDetailRecord.put("MFG_UOM_CODE",(String)hash.get("mfg_uom") );

					hmAssemblyDetailRecord.put("PRINTONLABEL",(String)hash.get("PrintOnlabel") );
		            hmAssemblyDetailRecord.put("Manufactur",(String)hash.get("Manufactur") );
					hmAssemblyDetailRecord.put("SEQ_NO",(String)hash.get("Seqence_No") );

    				hmAssemblyDetailRecord.put("STOCK_UOM", stock_uom);
					hmAssemblyDetailRecord.put("CONV_FACTOR",Conv_factor);
					hmAssemblyDetailRecord.put("MFG_DESC",mfg_desc);
					hmAssemblyDetailRecord.put("UOM_CODE",(String)hash.get("uom_code") );
					hmAssemblyDetailRecord.put("ALLOW_DECI_YN",allow_deci_yn);
					hmAssemblyDetailRecord.put("NO_DECI",no_deci);
					hmAssemblyDetailRecord.put("TD_SALE_STK_UOM_CONV_RULE",request.getParameter("td_sale_stk_uom_conv_rule"));

						AssemblyDtlList.add(hmAssemblyDetailRecord);

						
					}
			}
			catch (Exception exception){
				result	=	false;
				message	=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ", \"" +message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
		case 2:
		{
			String message			=	"";
			String flag				=	"";
			boolean	result			=	false;
			try	{
						String sale_uom =(String)hash.get("mfg_uom");
						String uom_code =request.getParameter("uom_code");
						String item_code =request.getParameter("item_code");
						//ML-MMOH-SCF-0382 starts
						HashMap uom_desc = bean.fetchRecord("SELECT SHORT_DESC   FROM AM_UOM WHERE UOM_CODE= ?",new String[]{uom_code});
						HashMap sale_desc = bean.fetchRecord("SELECT SHORT_DESC   FROM AM_UOM WHERE UOM_CODE= ?",new String[]{sale_uom});
						System.out.print("uom_desc=======110"+(String)uom_desc.get("SHORT_DESC"));
						//ML-MMOH-SCF-0382 ends
						if(sale_uom!=null && sale_uom!="")
							{
						int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, sale_uom}).get("COUNT"));
						int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code, sale_uom,item_code}).get("COUNT"));
						if(item_uom_count >0){
						HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, sale_uom,item_code});
						//String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_code+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+sale_uom;	ML-MMOH-SCF-0382 
						String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+(String)uom_desc.get("SHORT_DESC")+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+(String)sale_desc.get("SHORT_DESC");
						String stEqvl_value=(String)stEqvl_value1.get("CONV_FACTOR");
						out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML=' <b>"+stEqvl_value+"</b>';");
						//out.println("document.all.	td_sale_stk_uom_conv_rule.innerHTML=' <b>"+conver+"</b>';");
						out.println("document.getElementById('td_sale_stk_uom_conv_rule').innerHTML=' <b>"+conver+"</b>';");
						result=true;
						}else if(am_count >0){

						String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, sale_uom}).get("EQVL_VALUE");
						//String conver=stEqvl_value+" "+sale_uom+" = 1 "+uom_code;ML-MMOH-SCF-0382 
						String conver=stEqvl_value+" "+(String)sale_desc.get("SHORT_DESC")+" = 1 "+(String)uom_desc.get("SHORT_DESC");
						out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML=' <b>"+stEqvl_value+"</b>';");
						//out.println("document.all.	td_sale_stk_uom_conv_rule.innerHTML=' <b>"+conver+"</b>';");
                        out.println("document.getElementById('td_sale_stk_uom_conv_rule').innerHTML=' <b>"+conver+"</b>';");
						
						result=true;
					
						}else{
						String stEqvl_value="1";
						out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML=' <b>"+stEqvl_value+"</b>';");
						//String conver="1 "+sale_uom+" = 1 "+uom_code;ML-MMOH-SCF-0382 
						String conver="1 "+(String)sale_desc.get("SHORT_DESC")+" = 1 "+(String)uom_desc.get("SHORT_DESC");
						//out.println("document.all.	td_sale_stk_uom_conv_rule.innerHTML=' <b>"+conver+"</b>';");
						out.println("document.getElementById('td_sale_stk_uom_conv_rule').innerHTML=' <b>"+conver+"</b>';");
						result=true;
						}




						//	String [] uom={uom_code,sale_uom,uom_code,sale_uom,item_code,uom_code,sale_uom};
						//	String sql = bean.getStRepositoryValue("SQL_ST_AM_UOM_EQL_CONVERSION_SELECT1");
						
						//	HashMap hmDefaultValues = bean.fetchRecord(sql,uom);
							
							
						//	if(((String)hmDefaultValues.get("EQVL_VALUE")).equals("")  ) {
						//	result	=	false;
						//	message	=	"Done";
						//	flag="NO_CONV_FACTOR_FOR_UOM_CODE";
						//	return;
						//	}
						//else{
						//	out.println("document.getElementById("td_sale_stk_uom_conv").innerHTML=' <b>"+bean.checkForNull((String)hmDefaultValues.get("EQVL_VALUE"),"")+"</b>';");
						//	result	=	true;
						//	message	=	"Done";
					//		return;
					//	}
						}
			}
			catch (Exception exception){
				result	=	false;
				flag	=	"NO_CONV_FACTOR_FOR_UOM_CODE";
				out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML='&nbsp';");
			}
			finally{
				out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
		case 3:
		{
			String message				=	"";
			String flag					=	"";
			boolean	result				=	false;
			String  key1="SEQ_NO";
			String value1=(String)hash.get("Seqence_No");


			try{
					String stock_uom=CommonBean.checkForNull(request.getParameter("stock_uom"),"");
					String Conv_factor=CommonBean.checkForNull(request.getParameter("Conv_factor"),"");
					String mfg_desc=CommonBean.checkForNull(request.getParameter("mfg_desc"),"");
					String allow_deci_yn = CommonBean.checkForNull(request.getParameter("allow_deci_yn"),"N");
					String no_deci = CommonBean.checkForNull(request.getParameter("no_deci"),"0");
					String index				=	request.getParameter("index");
					HashMap hmAssemblyDetailRecord	=	(HashMap)AssemblyDtlList.get(Integer.parseInt(index));
					if(bean.isDuplicateInArrayList(AssemblyDtlList,key1,value1,Integer.parseInt(index))){

									result	=	false;
									message	=	"SEQ_NO_ALREADY_EXIST";
					}else{
						result	=	true;
						message	=	"done";
					}
					if(result){
						hmAssemblyDetailRecord.put("CHILD_ITEM_CODE",(String)hash.get("child_item_code") );
						hmAssemblyDetailRecord.put("COMPONENT_QTY",(String)hash.get("component_qty") );
						hmAssemblyDetailRecord.put("SHORT_DESC",(String)hash.get("child_item_code_desc") );
						hmAssemblyDetailRecord.put("COMPONENT",(String)hash.get("component") );
						hmAssemblyDetailRecord.put("MANDATORY",(String)hash.get("mandatory") );
						hmAssemblyDetailRecord.put("MFG_UOM_CODE",(String)hash.get("mfg_uom") );
						hmAssemblyDetailRecord.put("PRINTONLABEL",(String)hash.get("PrintOnlabel") );
						hmAssemblyDetailRecord.put("Manufactur",(String)hash.get("Manufactur") );
						hmAssemblyDetailRecord.put("SEQ_NO",(String)hash.get("Seqence_No") );
						hmAssemblyDetailRecord.put("MFG_DESC",mfg_desc);
						hmAssemblyDetailRecord.put("STOCK_UOM", stock_uom);
						hmAssemblyDetailRecord.put("CONV_FACTOR",Conv_factor);
						hmAssemblyDetailRecord.put("ALLOW_DECI_YN",allow_deci_yn);
						hmAssemblyDetailRecord.put("NO_DECI",no_deci);
						hmAssemblyDetailRecord.put("TD_SALE_STK_UOM_CONV_RULE",request.getParameter("td_sale_stk_uom_conv_rule"));

						AssemblyDtlList.set(Integer.parseInt(index),hmAssemblyDetailRecord);
					}
			}
			catch (Exception exception){
				result	=	false;
				message	=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
		case 4:
		{
			String index				=	CommonBean.checkForNull(request.getParameter("index"),"-1");
			ArrayList  dataList=new ArrayList();
			dataList=bean.getDataModifyList();
           
		   	boolean	result				=	true;


			
			

			String message				=	"";
			String flag					=	"";
		
			try{	
					String  key1="SEQ_NO";
					String value1=(String)hash.get("Seqence_No");
                    String key="CHILD_ITEM_CODE";
					String value=(String)hash.get("child_item_code");

					String mfg_desc=CommonBean.checkForNull(request.getParameter("mfg_desc"),"");
					String stock_uom=CommonBean.checkForNull(request.getParameter("stock_uom"),"");
						String Conv_factor=CommonBean.checkForNull(request.getParameter("Conv_factor"),"");
						String uom_code_1=CommonBean.checkForNull(request.getParameter("uom_code"),"");
						HashMap hmAssemblyDetailRecord	=new HashMap();
						if(!index.equals("-1")){
							hmAssemblyDetailRecord	=	(HashMap)dataList.get(Integer.parseInt(index));
							if(bean.isDuplicateInArrayList(dataList,key1,value1,Integer.parseInt(index))){
							result	=	false;
							message	=	"SEQ_NO_ALREADY_EXIST";
						}
						}
						else{
					    if(bean.isDuplicateInArrayList(dataList,key,value,Integer.parseInt("-1"))){

									result	=	false;
									message	=	"ITEM_CODE_ALREADY_EXIST";
						}
						else if(bean.isDuplicateInArrayList(dataList,key1,value1,Integer.parseInt("-1"))){
							result	=	false;
							message	=	"SEQ_NO_ALREADY_EXIST";
						}
	 					else{
									result	=	true;
									message	=	"done";
							}
							
						}
						
				
						if(result){
								hmAssemblyDetailRecord.put("COMPONENT_QTY",(String)hash.get("component_qty") );
								hmAssemblyDetailRecord.put("SHORT_DESC",(String)hash.get("child_item_code_desc") );
								hmAssemblyDetailRecord.put("COMPONENT",(String)hash.get("component") );
								hmAssemblyDetailRecord.put("MANDATORY",(String)hash.get("mandatory") );
								hmAssemblyDetailRecord.put("MFG_UOM_CODE",(String)hash.get("mfg_uom") );
								
								hmAssemblyDetailRecord.put("PRINTONLABEL",(String)hash.get("PrintOnlabel") );
								hmAssemblyDetailRecord.put("Manufactur",(String)hash.get("Manufactur") );
								hmAssemblyDetailRecord.put("SEQ_NO",(String)hash.get("Seqence_No") );

								hmAssemblyDetailRecord.put("MFG_DESC",mfg_desc);
								hmAssemblyDetailRecord.put("STOCK_UOM", stock_uom);
								hmAssemblyDetailRecord.put("CONV_FACTOR",Conv_factor);
								hmAssemblyDetailRecord.put("UOM_CODE",uom_code_1);
								hmAssemblyDetailRecord.put("TD_SALE_STK_UOM_CONV_RULE",request.getParameter("td_sale_stk_uom_conv_rule"));


								if(!index.equals("-1")){
									dataList.set(Integer.parseInt(index),hmAssemblyDetailRecord);
									bean.setDataModifyList(dataList);
								}
								else{
									hmAssemblyDetailRecord.put("CHILD_ITEM_CODE",(String)hash.get("child_item_code") );
									hmAssemblyDetailRecord.put("FUNC_MODE","insert");
									
									dataList.add(hmAssemblyDetailRecord);
								}
								bean.setDataModifyList(dataList);
							}
						}
			catch (Exception exception){
				result	=	false;
				message	=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
		case 5:
		{
			String uom_code =request.getParameter("uom_code");
			String item_code =request.getParameter("item_code");
			String mfg_uom=	request.getParameter("mfg_uom");
			HashMap uom_desc = bean.fetchRecord("SELECT SHORT_DESC   FROM AM_UOM WHERE UOM_CODE= ?",new String[]{uom_code}); //ML-MMOH-SCF-0382
			HashMap sale_desc = bean.fetchRecord("SELECT SHORT_DESC   FROM AM_UOM WHERE UOM_CODE= ?",new String[]{mfg_uom});//ML-MMOH-SCF-0382
			
			String stock_uom=	request.getParameter("stock_uom");
			
			bean.setStock_uom(stock_uom);
			bean.setMfg_uom(mfg_uom);
			bean.setItem_code(item_code);
			//String conver="1"+" "+mfg_uom+" = 1 "+uom_code;
			String conver="1 "+(String)sale_desc.get("SHORT_DESC")+" = 1 "+(String)uom_desc.get("SHORT_DESC");//ML-MMOH-SCF-0382
			out.println("document.getElementById('td_sale_stk_uom_conv_rule').innerHTML=' <b>"+ conver +"</b>';");	

			out.println("document.forms[0].mfg_uom.value=\""+mfg_uom+"\"");
		}
		break;
		case 6:
		{
			bean.setInstruction(instruction);
		}
		break;
		case 7:
		{
			java.util.HashMap record = new java.util.HashMap();
		
			out.println("clearListItems('document.forms[0].mfg_uom'); ");
					ArrayList mfg_uoms = bean.getMfgUom(bean.getMfg_uom());
					for(int i=0; i< mfg_uoms.size(); i++) {
						record = (java.util.HashMap)mfg_uoms.get(i);
						out.println("addListItem(\"document.forms[0].mfg_uom\", \"" + record.get("EQVL_UOM_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					
							if(record.get("EQVL_UOM_CODE").equals(bean.getMfg_uom())){
							
									out.println("document.forms[0].mfg_uom.value=\""+bean.getMfg_uom()+"\"");
							}
					}
		}
		break;
		default :
			out.println("alert(\'Invalid Function\');");
			return;
		}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
