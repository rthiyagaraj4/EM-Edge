package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eST.Common.*;
import eST.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __manufacturingreceiptsvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/est/jsp/ManufacturingReceiptsValidate.jsp", 1720701031674L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

	String bean_id = "ManufacturingReceiptsBean";
	String bean_name = "eST.ManufacturingReceiptsBean";
	String message ="";
	String labeltype ="";
	String flag =""; 
	String function_type = request.getParameter("function_type") ;
	String req_no="";
	String message1="";
	boolean result = true ; 
	int functionType = Integer.parseInt(function_type.trim());
	ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean)getBeanObject(bean_id, bean_name, request);
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
	hash = (Hashtable) hash.get ("SEARCH");
	//System.out.println("hash===>" +hash);
	
	switch (functionType) {
		case 4:
		{	
			 
			bean.setComposition_for_qty(bean.checkForNull(request.getParameter("composition_for_qty")));
			bean.setReq_qty(bean.checkForNull(request.getParameter("req_qty")));//Added by Rabbani #Inc no:37445(RUT-CRF-0097) on 08-MAY-2013
			bean.getAssemblyTempDtlData();	
		}
		break;
		case 5:
		{
			flag	=	"";
			message	=	"";
			result=true;
			try{
				bean.setValues(hash);
					
							}
			catch (Exception exception) {
				message	=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;	
		case 6:
		{	
			try
			{
				labeltype = request.getParameter("labeltype");
				bean.setLabel_Type(labeltype);
				 //Added by Rabbani #Inc no : 38900 on 23-Mar-2013 
				bean.setNo_of_labels(bean.checkForNull(request.getParameter("no_of_labels")));
				bean.setItem_code(bean.checkForNull(request.getParameter("item_code")));
				String pdocno=bean.getPrintDocNo();
				//bean.doOnlineReportPrinting(pdocno);	
				bean.doOnlineReportPrinting(pdocno,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
				result =  true ;
			    message = request.getParameter("msg");
				//System.out.println("message val===>"+message);
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}		}
		
		break;
				case 7: 
			{
// modified on Tuesday, November 18, 2003 by manish
				String dt_frm=(String)hash.get("dt_frm");
				String dt_to =(String)hash.get("dt_to");
				//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013  
				String dflt_mfg_mode = bean.checkForNull((String)hash.get("dflt_mfg_mode"),"R");
				if(!locale.equals("en")){
					dt_frm = DateUtils.convertDate(dt_frm,"DMY",locale,"en");
					dt_to  = DateUtils.convertDate(dt_to,"DMY",locale,"en");
				}
				bean.setReq_store(bean.checkForNull((String) hash.get("store_code"),"%"));
				bean.setPrep_mode(((String) hash.get("prep_mode")).equals("A")?"%":((String) hash.get("prep_mode")));
				bean.setPrep_loc(bean.checkForNull((String) hash.get("prep_loc"),"%"));
				bean.setReq_type(((String) hash.get("req_type")).equals("A")?"%":((String) hash.get("req_type")));
                if(dflt_mfg_mode.equals("R"))
				bean.getAssemblyDtlData(((String)hash.get("req_status")).equals("A")?"%":"E" ,  dt_frm ,  dt_to , ((String)hash.get("req_no_frm")) , ((String)hash.get("req_no_to")) , ((String)hash.get("store_code")) );
				//else // Commented by Rabbani #INC NO: 38402 on 06-MAR-2013 
				// bean.loadHdrData(hash);
				//bean.loadHdrData(hash,stock_uom,patient_name);
				 
				out.println(bean.getDataRecordList());	
			}
		break;
		case 8: 
			{
					HashMap hm =bean.getBaseProcessCost();
					out.println("document.forms[0].baseqty.value=\""+hm.get("BASE_QTY")+"\"");
					out.println("document.forms[0].labeltype.value=\""+hm.get("LABEL_TYPE")+"\"");
					if(hm.get("BASE_QTY").equals("")){
						out.println("document.forms[0].baseqty.value=\""+bean.getReq_qty()+"\"");
					}
					//Added by Rabbani #Inc no:37445(RUT-CRF-0097) on 08-MAY-2013
					out.println("document.forms[0].process_loss.value=\""+hm.get("PROCESS_LOSS_PERCENT")+"\"");
			       out.println("if(document.forms[0].mfg_process_loss_na.value == 'true'){");
			       out.println("document.forms[0].process_loss.value = 0");
			       out.println("}");
			}
		break;
		case 9:
			{
				message="";
				flag="";
				result=true;
				ArrayList alBatchRecords=new ArrayList();
				StUtilities bean1 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
				String total_checkboxes=(String)hash.get("total_checkboxes");
				StringBuffer sb = new StringBuffer();
				StringBuffer sb1 = new StringBuffer();
				
				HashMap hmParameters	=	new HashMap();
				HashMap hmReturn		= null;
				for (int i=0;i<(Integer.parseInt(total_checkboxes));i++){
					if(((String)hash.get("checkbox"+i)).equals("N")){
			
						try { 
								hmParameters.put("ITEM_CODE",hash.get("child_item_code_"+i));
								hmParameters.put("STORE_CODE",bean.getStore_code());
									int count = bean.LinkChk((String)hash.get("child_item_code_"+i),(String)bean.getStore_code());
								if(count==0){
									sb.append(hash.get("child_item_desc_"+i));
									sb.append("!");
	 							    result=false;
									flag ="";
									message1 = sb.toString();
									message1 = message1.substring(0,message1.length()-1);
							   continue;
							//	out.println(" assignResult(" + result + ",\"" + message1 + "\", \"" + flag + "\" ) ; ") ;	       
							}
                       
								int int1 = (int)Float.parseFloat((String)hash.get("qty_"+i));
								hmParameters.put("TRN_QTY",""+int1);
								
								hmReturn	=	(HashMap)bean1.getBatches(hmParameters);
								alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA");
								bean.setRemarks(((String)hash.get("remarks"))==null?"":(String)hash.get("remarks")); 
								bean.setPackedBy((String)hash.get("packed_by"));
								bean.setCounterChk((String)hash.get("counter"));
								bean.setAutoGenBatch_yn((String)hash.get("auto_gen_batch_yn"));
	            
									
									
						 
						/*	  if(message1.length()>0)				
							out.println(" assignResult(" + result + ",\"" + message1 + "\", \"" + flag + "\" ) ; ") ;	 
							  else
                              out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;	 */
							

						}catch (eST.Common.InsufficientBatchException insufficientBatchException) {					
							result=false;
                           flag="";
						  sb1.append(hash.get("child_item_desc_"+i));
							sb1.append("!");
							 message = sb1.toString();
								  message = message.substring(0,message.length()-1);
				  //          out.println(" assignResult(" + result + ", \"" +  insufficientBatchException.getMessage()+" for Item : "+message+flag+ "\") ; ") ;						
							insufficientBatchException.printStackTrace();
							//return;
						}
						catch (Exception exception) {
						out.println(exception.getMessage());
						
						exception.printStackTrace();
						}

					}
         		
			      
					
			
			}
											
			
		if((message1.length()==0)&&(message.length()>0)){
			//eST.Common.InsufficientBatchException insufficientBatchException=new eST.Common.InsufficientBatchException();
				  out.println(" assignResult(" + result + ", \"" +  ""+message+flag+ "\") ; ") ;	
		  }
		   if((message.length()==0)&&(message1.length()>0))
         out.println(" assignResult(" + result + ",\"" +" "+ message1 + "\", \"" + flag + "\" ) ; ") ;
              if((message1.length()>0)&&(message.length()>0))
				{
				 
				    out.println(" assignResult(" + result + ",\"" + message1 + "\", \"" + flag + "\" ) ; ") ;
				// eST.Common.InsufficientBatchException insufficientBatchException=new eST.Common.InsufficientBatchException();
				  out.println(" assignResult(" + result + ", \"" +  " "+message+flag+ "\") ; ") ;	
				}
				if((message1.length()==0)&&(message.length()==0)){
				  
				  out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				
				}
			putObjectInBean("stUtilities",bean1,request);
          
			}
			

			break;
			
		case 10:
		{	
			try
			{
			req_no = request.getParameter("req_no");
				//bean.doOnlineReportPrinting(req_no);
				bean.doOnlineReportPrinting(req_no,request,response);
				result =  true ;
			    message = request.getParameter("msg");

			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}		
		break;
		case 11: 
			{
// modified on Tuesday, November 18, 2003 by manish
				String store_code=bean.checkForNull(request.getParameter("store_code"));
				String doc_type_code =bean.checkForNull(request.getParameter("doc_type_code"));
				String doc_no=bean.checkForNull(request.getParameter("doc_no"));
				bean.loadData(store_code,doc_type_code,doc_no);
			}
		break;
		case 12: 
			{
                 //System.out.println("setbarcode:=modify===>"+request.getParameter("barcode_id_set"));
				//String barcode_id=bean.checkForNull(request.getParameter("barcode_id"));
				 bean.setBarcode_id(bean.checkForNull(request.getParameter("barcode_id_set")));
			}
		break;
		case 13: 
			{
              // System.out.println("no_of_labels:====>"+request.getParameter("no_of_labels"));
			  // System.out.println("test:====>"+bean.checkForNull(request.getParameter("barcode_id")));
				boolean check = true;
			String barcode_yn =  bean.checkForNull(request.getParameter("barcode_yn"));
			String barcode_id =  bean.checkForNull(request.getParameter("barcode_id"));
			//System.out.println("barcode_yn==val==>" +barcode_yn);
			//System.out.println("barcode_id==val==>" +barcode_id);
			if((barcode_id.trim()).equals("")){
			check = false;
			}
			//System.out.println("check==val==>" +check);
			if(barcode_yn.equals("true")){
			//if(!(barcode_id.equals(""))){
			//if(!((String)(bean.checkForNull(request.getParameter("barcode_id")))).equals("")){
			if(check){
			//System.out.println("barcode_id==vaiiiif==>" +barcode_id);
			bean.setBarcode_id(bean.checkForNull(request.getParameter("barcode_id")));
			}
			bean.setNo_of_labels(bean.checkForNull(request.getParameter("no_of_labels")));
			}
			}
		break;
		
		case 14:   //Added by Rabbani #Inc no:33352 on 18/06/12 
			{
			    String remarks_code = bean.checkForNull(request.getParameter("remarks_code"));
				String remarks_desc = bean.checkForNull(request.getParameter("remarks_desc"));
                 bean.setRemarks_code((String)remarks_code); 
				 bean.setRemarks_desc((String)remarks_desc);
			}
		break;
		
		case 15: //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		  {
           String  store_code	=	request.getParameter("store_code");
           String  item_code	=	request.getParameter("item_code");
		   bean.setReq_store(store_code); 
		   bean.setStore_code(store_code);
		   bean.setItem_code(item_code); 
			ArrayList BinLocationList = bean.getSTITBin_location_code_ArrayList(store_code,item_code,locale);
			//System.out.println("BinLocationList==manu=>" +BinLocationList);
			out.println("clearListItems('Header.bin_location'); ");
			HashMap record = new HashMap();
			for(int i=0; i< BinLocationList.size(); i++) {
      		   record = (HashMap)BinLocationList.get(i);
 			   out.println("addListItem(\"Header.bin_location\", \"" + record.get("BIN_LOCATION_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
			result=true;
		 }
		break;
		case 16: //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
			{
				String patient_id =  (String) hash.get("patient_id");
				//System.out.println("patient_id==manu=>" +patient_id);
				bean.setPatient_id(patient_id);
				out.println("document.getElementById('pn').innerText=\""+bean.checkForNull(bean.getPatientName())+"\"");
				patient_id = null;
			}
		break;
		
		case 17: //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		{
			String patient_id = (String) hash.get("patient_id");
				if (patient_id.trim().equals("")) {
					return;
				}
			bean.setPatient_id(patient_id);out.println("2");
			out.println("clearListItems('Header.encounter_id'); ");
			String encounterId = "";
			ArrayList encounter_id = bean.getEncounterData();
			HashMap record=null;
			for(int i=0; i< encounter_id.size(); i++) {
				record =(HashMap)encounter_id.get(i);
				String listRecord =(String)record.get("ENCOUNTER_ID");
				out.println("addListItem(\"Header.encounter_id\", \"" +listRecord+ "\",\"" +listRecord+ "\",\""+encounterId+"\"); ");
			}
			encounterId = null;
		}
		break;
		
		case 18: //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
			{		
				String seq_no=bean.checkForNull(request.getParameter("seq_no"),"");
				String forInserting=bean.checkForNull(request.getParameter("forInserting"),"");
				String ItemCode=bean.checkForNull(request.getParameter("ItemCode"),"");
				bean.setCheckBox(ItemCode,seq_no,forInserting);
			}
		break;
		
		case 19: //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 
			{
				String mfg_uom=	request.getParameter("mfg_uom");
				bean.setMfg_uom(mfg_uom);
				out.println("document.forms[0].mfg_uom.value=\""+mfg_uom+"\"");
			}
		break;
		case 20: //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		{
			try{
//					String index =bean.checkForNull(request.getParameter("index"),"-1");
					//String [] key={"MFG_REQUEST_NO","CHILD_ITEM_CODE"};
					//String [] value={(String)hash.get("extemp_item_seq"),(String)hash.get("child_item_code")};
					
					//Added by Rabbani #Inc no:38809(CRF-ST- Bru-HIMS-CRF-084/09) on 20-MAR-2013
					 String [] key={"CHILD_ITEM_CODE"}; 
					 String [] value={(String)hash.get("child_item_code")};
		
					if(bean.isDuplicateInArrayList(bean.getDataList(),key,value,Integer.parseInt("-1"))){
						result	=	false;
						message	=	"ITEM_CODE_ALREADY_EXIST";
					}
					else{
						result	=	true;
						message	=	"done";
					}
					if  (result){
					String item_unit_cost= bean.checkForNull(bean.getUnitCost((String)hash.get("child_item_code"),(String)hash.get("store_code")));
					double tmp_conv = bean.getConvFactTemp((String)hash.get("child_item_code"),(String)hash.get("store_code"));
					    hash.put("tmp_conv", ""+tmp_conv);
					    hash.put("unit_cost" ,item_unit_cost);
						String stock_uom=bean.checkForNull(request.getParameter("stock_uom"),"");
						String mfg_desc=bean.checkForNull(request.getParameter("mfg_desc"),"");
                       //String seq_no=bean.checkForNull(request.getParameter("seq_no"),"");
					  // String patient_name=bean.checkForNull(request.getParameter("patient_name"),"");
						bean.setValForArrayList(hash,stock_uom,mfg_desc);
					   //bean.loadHdrData(hash,stock_uom,patient_name);
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
		
		case 21: //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		{
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
		
		case 22:
		{               //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
			try{	
					//String key[]={"ITEM_CODE","MFG_REQUEST_NO"};
					//String value[]={(String)hash.get("item_code"),(String)hash.get("extemp_item_seq") };
					//Added by Rabbani #Inc no:38809(CRF-ST- Bru-HIMS-CRF-084/09) on 20-MAR-2013
					  String [] key={"CHILD_ITEM_CODE"};
					  String [] value={(String)hash.get("child_item_code")};
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
		
		case 23:  //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 
			{
			 
            boolean	result1				=	false;
			String item_code	=	request.getParameter("item_code");
			String store_code	=	request.getParameter("store_code");
			bean.setStore_code(store_code);
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
					out.println("document.forms[0].prep_type.value=\""+bean.checkForNull((String)hashAsmbDtl.get("PREPARATION_TYPE"),"")+"\"");
					out.println("document.forms[0].prep_mode.value=\""+bean.checkForNull((String)hashAsmbDtl.get("PREPARATION_MODE"),"")+"\"");
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
		
		case 24:  //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		{	
		   String stock_uom =bean.checkForNull(request.getParameter("stock_uom"),"");
		   String patient_name = bean.checkForNull(request.getParameter("patient_name"),"");
		   String req_type = bean.checkForNull(request.getParameter("req_type"),"");
		   
			bean.setComposition_for_qty(bean.checkForNull(request.getParameter("composition_for_qty")));
			bean.setReq_qty(bean.checkForNull(request.getParameter("req_qty"))); 
			//System.out.println("hash==function 24==>" +hash);
			hash.put("req_type",req_type);
			if(req_type.equals("E")){
			bean.loadHdrData(hash,stock_uom,patient_name);
			}else{
			bean.getAssemblyTempDtlData();   //for hdr data
			bean.loadHdrData(hash); //Added by Rabbani #Inc no:38402(Bru-HIMS-CRF-084) on 06-MAR-2013
			}
		}
		break;
		case 25:  //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		{
		String req_type = bean.checkForNull(request.getParameter("req_type"),"");
		bean.setReq_type(req_type);
		//System.out.println("######function 25##" +bean.getReq_type());
		}
		break;
		
		case 26:  //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		{
		try{  
		result = false;
		String prep_loc = bean.checkForNull(request.getParameter("prep_loc"),"");
		bean.setPrep_loc(prep_loc);
		//System.out.println("######function 25##" +bean.getPrep_loc());
		HashMap auto_gen_batch_id	=	 bean.getBatchGenDetails();
		//System.out.println("auto_gen_batch_id==validate 180====>" +auto_gen_batch_id);
		String auto_gen_batch_yn			 =	(String)auto_gen_batch_id.get("AUTO_GEN_BATCH_YN");
		//System.out.println("auto_gen_batch_yn==validate 180====>" +auto_gen_batch_yn);
		String next_batch_id                 =    bean.checkForNull((String)auto_gen_batch_id.get("NEXT_BATCH_ID"));  
	   String batch_id_series                      =    bean.checkForNull((String)auto_gen_batch_id.get("BATCH_ID_SERIES")); 
	    if(auto_gen_batch_yn.equals("N") ){
		result = true;
		}
		out.println("document.forms[0].next_batch_id.value=\""+next_batch_id+"\"");
		out.println("document.forms[0].batch_id_series.value=\""+batch_id_series+"\"");
		out.println("document.forms[0].auto_gen_batch_yn.value=\""+auto_gen_batch_yn+"\"");
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
		case 27:
		{				 
			String store_code = request.getParameter("store_code");
			String stFinalize_allowed	=	bean.getFinalize_allowed_yn(store_code);
			if(stFinalize_allowed.equals("Y"))				
				result=true;
			else
				result=false;
			
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		break;
		//Added by suresh.r on 02-03-2015 against BRU-HIMS-CRF-080 beg
		case 28:
		{				 
			String item_code = request.getParameter("item_code");
			int	count=Integer.parseInt((String)	bean.fetchRecord("SELECT COUNT(1) CNT FROM ST_ASSEMBLY_HDR WHERE ITEM_CODE=?",item_code).get("CNT"));
			String mfg_allowed_yn=(String)	bean.fetchRecord("SELECT MFG_ALLOWED_YN FROM st_user_access_for_store WHERE user_id	= ?	 AND store_code = ?",new String[]{bean.getLoginById(),bean.getStore_code()}).get("MFG_ALLOWED_YN");
			if(mfg_allowed_yn.equals("N")){		
				result=false;
			}else{
				result=true;
				if(count==0){
					flag="N";
				}else{
					flag="Y";
					String	def_item_sec=(String)bean.fetchRecord("SELECT DFLT_ITEM_SEARCH FROM ST_FACILITY_PARAM WHERE FACILITY_ID=?",bean.getLoginFacilityId()).get("DFLT_ITEM_SEARCH");
					HashMap hmReturn=bean.fetchRecord("SELECT SHORT_DESC ITEM_DESC,ALPHA_CODE FROM MM_ITEM_LANG_VW WHERE ITEM_CODE=? AND LANGUAGE_ID=?",new String[]{item_code,bean.getLanguageId()});
							
					if(def_item_sec.equals("IN")){
						message=(String)hmReturn.get("ITEM_DESC");
					}else if(def_item_sec.equals("AC")){
						message=(String)hmReturn.get("ALPHA_CODE");
					}
				}
			}
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		break;
		//Added by suresh.r on 02-03-2015 against BRU-HIMS-CRF-080 end
		case 29: //Added for ML-MMOH CRF-1909 US3 start
		  {
			System.out.println("Inside case 29");  
         	String  item_code	=	request.getParameter("item_code");
		    bean.setItem_code(item_code); 
			HashMap hmshelfTemp = (HashMap) bean.getShelfLifeTime(item_code);
  			String shelf_life_value = bean.checkForNull((String) hmshelfTemp.get("SHELF_LIFE_VALUE"));
  			String shelf_life_flag = bean.checkForNull((String) hmshelfTemp.get("SHELF_LIFE_FLAG"));
  			if (shelf_life_value != null && shelf_life_value != "" && shelf_life_flag != null && shelf_life_flag != "") {
  				System.out.println("before");
  				String newDate = bean.setExpiryDate(shelf_life_flag, shelf_life_value);
  				//bean.setExpiry_date(newDate);
  				System.out.println("after"+newDate);
  				out.println("document.forms[0].expiry.value=\""+bean.checkForNull(newDate,"")+"\"");
  				}
			result=true;
		 }
		break;
		//Added for ML-MMOH CRF-1909 US3 end
		default :
		{
			System.out.println("Inside Invalid Function"+function_type+"end of Invalid Function");
			out.println("alert(\'Invalid Function\');");
			System.out.println("After ok "+request.toString()+" end");
			return;
		}
	}

            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
