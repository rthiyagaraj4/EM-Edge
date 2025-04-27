 <%@page import="java.util.*, eST.Common.*, eST.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String bean_id = "ManufacturingRequestBean";
String bean_name = "eST.ManufacturingRequestBean";
int functionType = Integer.parseInt(request.getParameter("function_type"));
	
	ManufacturingRequestBean bean = (ManufacturingRequestBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	
	//out.println(hash);
	switch (functionType) {
	case 1:
		{
			boolean	result				=	true;
			String message="";
			String flag					=	"";
			try{
//pmd 29/01/05
//					String index =bean.checkForNull(request.getParameter("index"),"-1");
					String [] key={"MFG_REQUEST_NO","CHILD_ITEM_CODE"};
					String [] value={(String)hash.get("extemp_item_seq"),(String)hash.get("child_item_code")};
		
					if(bean.isDuplicateInArrayList(bean.getDataList(),key,value,Integer.parseInt("-1"))){
						result	=	false;
						message	=	"ITEM_CODE_ALREADY_EXIST";
					}
					else{
						result	=	true;
						message	=	"done";
					}

					if  (result){
						String stock_uom=bean.checkForNull(request.getParameter("stock_uom"),"");
						String mfg_desc=bean.checkForNull(request.getParameter("mfg_desc"),"");
//						String seq_no=bean.checkForNull(request.getParameter("seq_no"),"");
						bean.setValForArrayList(hash,stock_uom,mfg_desc);
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
			String patient_id = (String) hash.get("patient_id");
				if (patient_id.trim().equals("")) {
					//out.println("errorDisplay();");
					return;
				}
			bean.setPatient_id(patient_id);out.println("2");
			out.println("clearListItems('manufacturing_form.encounter_id'); ");
			String encounterId = "";
			ArrayList encounter_id = bean.getEncounterData();
			HashMap record=null;
			for(int i=0; i< encounter_id.size(); i++) {
				record =(HashMap)encounter_id.get(i);
				String listRecord =(String)record.get("ENCOUNTER_ID");
				out.println("addListItem(\"manufacturing_form.encounter_id\", \"" +listRecord+ "\",\"" +listRecord+ "\",\""+encounterId+"\"); ");
				
			}
			encounterId = null;
		}
		break;
		case 3:
		{
			String message				=	"";
			String flag					=	"";
			boolean	result				=	false;

			try{
					String stock_uom=bean.checkForNull(request.getParameter("stock_uom"),"");
					
					String mfg_desc=bean.checkForNull(request.getParameter("mfg_desc"),"");
					String index				=	request.getParameter("index");
					bean.setValForArrayListModify(hash,stock_uom,mfg_desc,Integer.parseInt(index));

					result	=	true;
					message	=	"Done";
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
//			String index				=	bean.checkForNull(request.getParameter("index"),"-1");
			String message				=	"";
			String flag					=	"";
			boolean	result				=	true;
//			out.println(bean.seq_no);
			try{	
					String key[]={"ITEM_CODE","MFG_REQUEST_NO"};
					String value[]={(String)hash.get("item_code"),(String)hash.get("extemp_item_seq") };
					String stock_uom=bean.checkForNull(request.getParameter("stock_uom"),"");
					String patient_name=bean.checkForNull(request.getParameter("patient_name"),"");
				    out.println("patient_name"+patient_name);
					if(bean.isDuplicateInArrayList(bean.getDataRecordList(),key,value,Integer.parseInt("-1"))){
						result	=	false;
						message	=	"ITEM_CODE_ALREADY_EXIST";
					}
					else{
						result	=	true;
						message	=	"done";
					}
					if(result)
						bean.loadHdrData(hash,stock_uom,patient_name);
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
				String mfg_uom=	request.getParameter("mfg_uom");
				bean.setMfg_uom(mfg_uom);
				out.println("document.forms[0].mfg_uom.value=\""+mfg_uom+"\"");
			}
		break;
		case 6: 
			{
				String patient_id =  (String) hash.get("patient_id");
				bean.setPatient_id(patient_id);
				out.println("document.getElementById('pn').innerText=\""+bean.checkForNull(bean.getPatientName())+"\"");
				patient_id = null;
			}
		break;
		case 7: 
			{
			boolean	result				=	true;
            boolean	result1				=	false;
			String message="";
			String flag					=	"";

			String item_code		=	request.getParameter("item_code");
			String store_code	=	request.getParameter("store_code");
			result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");

				if(result1)
				{	
					String	phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.forms[0].phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
				
				message="PHY_INV_PROCESS_INITIATED";
			    result	=	false;
					//throw new Exception("PHY_INV_PROCESS_INITIATED");
				}

			String objName	=	request.getParameter("objName");
			
			String [] params={item_code,store_code,"0","N","","N",""};
			HashMap hashStock=new HashMap();
			try{
			hashStock=bean.getStockAvailabilityStatus(params);
			//System.err.println("@@hashStock-->"+hashStock);//store_item_unit_cost
			out.println("document.forms[0].stock_item_yn.value=\""+hashStock.get("stock_item_yn")+"\"");
			
			if(objName.equals("item_code_desc")){
			HashMap hashAsmbDtl=bean.checkAssemblydtl(item_code);
				if(hashAsmbDtl!=null){
					out.println("document.forms[0].preptype.value=\""+bean.checkForNull((String)hashAsmbDtl.get("PREPARATION_TYPE"),"")+"\"");
					out.println("document.forms[0].prepmode.value=\""+bean.checkForNull((String)hashAsmbDtl.get("PREPARATION_MODE"),"")+"\"");
				}
			}
			}catch(Exception exception) {
				result = false;
				exception.printStackTrace();
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					message ="PHY_INV_PROCESS_INITIATED";
					throw exception;
				}
				else
				{
					//message="ITEM_STORE_NOT_FOUND";
					//throw new Exception("ITEM_STORE_NOT_FOUND");
					
				}
			//exception.printStackTrace();
		//	throw new Exception("ITEM_STORE_NOT_FOUND");//exception;
		}
		finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
			}
		break;
		case 8: 
			{		
				String seq_no=bean.checkForNull(request.getParameter("seq_no"),"");
				String forInserting=bean.checkForNull(request.getParameter("forInserting"),"");
				String ItemCode=bean.checkForNull(request.getParameter("ItemCode"),"");
/*				out.println("forInserting"+forInserting);
				out.println("ItemCode"+ItemCode);
				out.println("seq_no"+seq_no);*/
				bean.setCheckBox(ItemCode,seq_no,forInserting);
			}
		break;
		case 9: 
			{
				bean.setReq_store(bean.checkForNull((String) hash.get("req_store"),"%"));
				bean.setPrep_mode(((String) hash.get("prep_mode")).equals("A")?"%":((String) hash.get("prep_mode")));
				bean.setPrep_loc(bean.checkForNull((String) hash.get("prep_loc"),"%"));
				bean.setReq_type(((String) hash.get("req_type")).equals("A")?"%":((String) hash.get("req_type")));
				bean.getAssemblyDtlData();
				//out.println(bean.getDataRecordList());
				bean.getDtlData();
			}
		break;
		case 10: 
			{
				String patient_name=bean.checkForNull(request.getParameter("patient_name"),"");
				String stock_uom=bean.checkForNull(request.getParameter("stock_uom"),"");
				String index				=	request.getParameter("index");
				bean.setLoadHdrData(hash,stock_uom,Integer.parseInt(index),patient_name);
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
