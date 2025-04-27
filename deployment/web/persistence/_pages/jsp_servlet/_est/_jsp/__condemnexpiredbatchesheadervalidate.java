package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.CondemnExpiredBatchesHeaderBean;
import java.util.ArrayList;
import java.util.HashMap;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __condemnexpiredbatchesheadervalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/CondemnExpiredBatchesHeaderValidate.jsp", 1732511597784L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );
	
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

/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
06/02/2017		IN0063027			Badmavathi B							GHL-CRF-0413.7 - US009 - Barcode search
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block3Bytes, _wl_block3);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
	String bean_id = CommonBean.checkForNull(request.getParameter( "bean_id" ),"condemnExpiredBatchesHeaderBean") ;
	String bean_name = CommonBean.checkForNull(request.getParameter( "bean_name" ),"eST.CondemnExpiredBatchesHeaderBean") ;
	CondemnExpiredBatchesHeaderBean bean = (CondemnExpiredBatchesHeaderBean) getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");
	
	String doc_type_code	=	request.getParameter("doc_type_code");
	String validate		=	request.getParameter("validate");
	String doc_no		=	request.getParameter("doc_no");
	String doc_ref		=	request.getParameter("doc_ref");
	String doc_date		=	request.getParameter("doc_date");
	String adj_remarks	=	request.getParameter("adj_remarks");
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
	String adj_remarks_desc	=	CommonBean.checkForNull(request.getParameter("adj_remarks_desc"));
	String message		=	"";
	String flag		=	"";
	boolean	result		=	false;
	// doc_date = com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
	 
	try {
		if(validate.equals("UPDATE_VALUES")) {
		     String remarks = bean.checkForNull(bean.getAdj_remarks());
			 remarks = java.net.URLEncoder.encode(remarks,"UTF-8");
			//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990) beg
			 if(!locale.equals("en"))
				{
				doc_date=	com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale);	
				}else
				{
				doc_date=bean.getDoc_date();
				}
			//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990) end
			/*out.println("setDocumentDetails(\""+bean.getDoc_type_desc(bean.getDoc_type_code())+"\", \""+bean.getDoc_no()+"\", \""+bean.getDoc_date()+"\", \""+bean.getDoc_ref()+"\", \""+bean.getDoc_type_code()+"\" );");*/			
            //Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 	
			//out.println("setDocumentDetails(\""+bean.getDoc_type_desc(bean.getDoc_type_code())+"\", \""+bean.getDoc_no()+"\", \""+bean.getDoc_date()+"\", \""+bean.getDoc_ref()+"\", \""+bean.getDoc_type_code()+"\" , \""+remarks+"\");");	
			//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990)
			out.println("setDocumentDetails(\""+bean.getDoc_type_desc(bean.getDoc_type_code())+"\", \""+bean.getDoc_no()+"\", \""+doc_date+"\", \""+bean.getDoc_ref()+"\", \""+bean.getDoc_type_code()+"\" , \""+remarks+"\");");
			/* removed for not displaying remarks..
			out.println("setDocumentDetails(\""+bean.getDoc_type_desc()+"\", \""+bean.getDoc_no()+"\", \""+bean.getDoc_date()+"\", \""+bean.getDoc_ref()+"\", \""+bean.getDoc_type_code()+"\", \""+bean.getAdj_remarks()+"\");");			
			*/
			result	=	true;
			message	=	validate;			
		}
		else if(validate.equals("SET_DETAILS")) {
 
			bean.setDoc_type_code (doc_type_code);
			//bean.setDoc_date (doc_date); Commented by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990)
			bean.setDoc_ref (doc_ref);
			//bean.setDoc_no (doc_no);
			bean.setAdj_remarks (adj_remarks);
			bean.setAdj_remarks_Desc(adj_remarks);
			 
			//added by Rabbani on 06-MAR-2013 against inc no:29954
			//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990) beg
           //doc_date = com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
           if(!locale.equals("en"))
			{
        	   doc_date=	com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
			}
				else
			{
					doc_date=doc_date;
			}
			bean.setDoc_date (doc_date);
			//Added by suresh.r on 14-04-2014 against #048587(SKR-SCF-0990) end
			int iValidDocDate = bean.isValidDocDate(doc_date);
			if (iValidDocDate > 0) {
				if (iValidDocDate== 1) 
					throw new Exception( "ST_DOC_DT_NOT_LT_PROC_MTH");
				else if (iValidDocDate== 2) 
					throw new Exception( "ST_DOC_DT_NOT_GR_SYSDATE");
			}
			
			

			result	= true;
			message	= validate + doc_type_code + doc_date + doc_ref + doc_no;	
		}
		else if(validate.equals("LOAD_DATA")) {
			
			String from_date =  (String)request.getParameter("from_date");
			String to_date =  (String)request.getParameter("to_date");
			String from_item =  (String)request.getParameter("from_item");
			String to_item =  (String)request.getParameter("to_item");
			String from_store =  (String)request.getParameter("from_store");
			String to_store =  (String)request.getParameter("to_store");
			String batch_id =  (String)request.getParameter("batch_id");
			String exp_yn =  (String)request.getParameter("exp_yn");// Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
			
			
			HashMap hmParam = new HashMap();
			
			hmParam.put("from_date",from_date);
			hmParam.put("to_date",to_date);
			hmParam.put("from_item",from_item);
			hmParam.put("to_item",to_item);
			hmParam.put("from_store",from_store);
			hmParam.put("to_store",to_store);
			hmParam.put("batch_id",batch_id);
			hmParam.put("exp_yn",exp_yn); // Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
			
			
			bean.loadExpired_batches(hmParam);
		
			result	= true;			
			
		}
		else if(validate.equals("VALIDATE")) {

			 result = bean.validateCheckedCount(htFormValues);
		}
//  Added for online printing on 10/1/2004

		else if (validate.equals("printOnlineDoc")){
		   ArrayList alData     =  bean.getPrintDocNo();
			try{
			// Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
			//for(int i=0;i<alData.size();i++){
				 String pdoc_no = (String)alData.get(1);
				 String pdoc_type_code = (String)alData.get(0);
				 bean.doOnlineReportPrinting(pdoc_no,pdoc_type_code,request,response);
			  //}
			//bean.CalldoOnlineReportPrinting();	
			}catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");

		}else if(validate.equals("CHECKEDCOMMITED")){
			try
			{
				 result = false;
				String checkedValues = (String) htFormValues.get("checkedValues");

			 java.util.StringTokenizer st	=		new java.util.StringTokenizer(checkedValues,"~");
				 ArrayList arr					=		new ArrayList();
				 while( st.hasMoreElements())
				 {
					 arr.add(st.nextElement() );
			 	 }

				String count="0";
				String item_code="";
				String store_code="";
				String batch_id="";
				String bin_location_code="";
				String expiry_date_or_receipt_date="";
				String trade_id="";
				String qty_on_hand="";
				String replace_on_expiry_yn="";
				String item_desc = "";
				 
				for(int i=0;i<arr.size();i++){
				String stBatch = (String)arr.get(i);
				StringTokenizer st1 = new StringTokenizer (stBatch,"||");
				 while( st1.hasMoreElements())
				 {
				 item_code=(String)st1.nextElement();
				 store_code=(String)st1.nextElement();
				 batch_id=(String)st1.nextElement();
				 bin_location_code=(String)st1.nextElement();
				 expiry_date_or_receipt_date=(String)st1.nextElement();
				 trade_id=(String)st1.nextElement();
				 qty_on_hand=(String)st1.nextElement();
				 replace_on_expiry_yn=(String)st1.nextElement();
				 
				   
				 }
				 
				
				 
					
					count=(String)bean.fetchRecord("SELECT COUNT (*) count  FROM st_item_batch WHERE item_code = ? AND store_code = ? AND  batch_id = ?  AND bin_location_code = ? AND  expiry_date_or_receipt_date = TO_DATE (?, 'dd/mm/yyyy') and committed_qty >0 ",new String[]{item_code,store_code,batch_id,bin_location_code,expiry_date_or_receipt_date}).get("COUNT");
					if(Integer.parseInt(count) >0){
					result=true;
					
					message=(String)bean.fetchRecord("select short_desc from mm_store_lang_vw where store_code = ? and language_id = ?",new String[]{store_code,locale}).get("SHORT_DESC");
					item_desc =(String)bean.fetchRecord("select short_desc from mm_item_lang_vw where item_code=? and language_id=?",new String[]{item_code,locale}).get("SHORT_DESC");
					item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
					 if(!locale.equals("en"))
				{
                 expiry_date_or_receipt_date=com.ehis.util.DateUtils.convertDate(expiry_date_or_receipt_date, "DMY" , "en",locale);
				}
					flag=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.item.label","common_labels")+": "+item_desc+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BatchID.label","common_labels")+": "+batch_id+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.expiryDate.label","common_labels")+": "+expiry_date_or_receipt_date;
					break;
					}

					}

				}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
	
			}
// End of Online printing on 10/1/2004
		//Added for GHL-CRF-0413.7 starts
		else if(validate.equals("VALID_BARCODE")){
			String barcode = request.getParameter("barcode");
			String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Adding start for MMS-DM-CRF-0174.6
			String item_code ="";
			String batch_id  ="";
			String list_item_code ="";
			String list_batch_id ="";
			ArrayList barcodeBatches =bean.get2DBarcodeBacthes("",barcode);//Adding end for MMS-DM-CRF-0174.6
			result = false;
			try{
				int barcodeExists = 0;
				ArrayList alExpiredBatches = bean.getExpired_batches();	
				 HashMap hmBatch = new HashMap();
				 String list_barcode = "";
				int selectedBatch=0;
				for(int i=0;i<alExpiredBatches.size();i++){
					 hmBatch = (HashMap)alExpiredBatches.get(i);
					 list_item_code =(String) hmBatch.get("item_code");//Adding start for MMS-DM-CRF-0174.6
					 list_batch_id =(String) hmBatch.get("batch_id");
					 if(barcode_2d_applicable_yn.equals("Y")){
						 if(barcodeBatches.size()>0){
						      HashMap batch =(HashMap)barcodeBatches.get(0);
                               item_code = (String)batch.get("ITEM_CODE");
							   batch_id  = (String)batch.get("BATCH_ID");
							   System.err.println("item_code==="+item_code+"list_item_code=="+list_item_code+"batch_id=="+batch_id+"list_batch_id=="+list_batch_id);
							   if(item_code.equals(list_item_code)&& batch_id.equals(list_batch_id)){
                                   selectedBatch = i;
						           barcodeExists++;
							   }
						 }
					 }else{//Addign end for MMS-DM-CRF-0174.6
					 list_barcode = (String) hmBatch.get("barcode_id");
					     if(barcode.equals(list_barcode)){
						       selectedBatch = i;
						       barcodeExists++;
					      }
					 }
				}
				if( barcodeExists != 0){
				   	  result = true;
				   	  message = ""+selectedBatch;
				}
				else{
				   	  result = false;
				}
			}
			catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
				flag = "";
			}
		}
		//Added for GHL-CRF-0413.7 ends
	}
	catch (Exception exception) {	
		result	=	false;
		message	=	exception.getMessage();
	}
	finally {
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

            _bw.write(_wl_block3Bytes, _wl_block3);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
