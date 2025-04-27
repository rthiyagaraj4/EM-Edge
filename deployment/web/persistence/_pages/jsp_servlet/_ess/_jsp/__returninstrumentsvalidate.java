package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eSS.*;
import eSS.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __returninstrumentsvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/ReturnInstrumentsValidate.jsp", 1732510826822L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            java.util.ArrayList alReturnInstrumentsList= null;synchronized(session){
                alReturnInstrumentsList=(java.util.ArrayList)pageContext.getAttribute("alReturnInstrumentsList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alReturnInstrumentsList==null){
                    alReturnInstrumentsList=new java.util.ArrayList();
                    pageContext.setAttribute("alReturnInstrumentsList",alReturnInstrumentsList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	ReturnInstrumentsListBean bean		=	(ReturnInstrumentsListBean)getBeanObject( "returnInstrumentsListBean", "eSS.ReturnInstrumentsListBean", request ) ;

	String doc_type_code				=	request.getParameter("doc_type_code");
	String validate						=	request.getParameter("validate");

	String item_code					=	request.getParameter("item_code");
	String item_desc					=	request.getParameter("item_desc");
	String ret_item_qty					=	request.getParameter("ret_item_qty");
	String damaged_yn					=	request.getParameter("damaged_yn");
	String contaminated_yn				=	request.getParameter("contaminated_yn");
	String remarks						=	request.getParameter("remarks");
	String ret_store_code				=	request.getParameter("ret_store_code");
	String rec_store_code				=	request.getParameter("rec_store_code");
	String mode							=	request.getParameter("mode");
	
	String patient_id					=	request.getParameter("patient_id");
	String index						=	request.getParameter("index");
	String expiry_date                  =   request.getParameter("expiry_date");//Added for TH-KW-CRF-0030

	String message						=	"";
	String flag							=	"";
	boolean	result						=	true;

	try{
		if (validate.equals("DOC_TYPE_CODE")){
			out.println("enableDocNo("+!bean.isDocNoAutoGenYN(doc_type_code)+");");
		}
		else if (validate.equals("PATIENT_NAME")){
			try{
				out.println("setPatientName(\""+bean.getPatientName(patient_id)+"\");");
				out.println("populateItem();");
			}
			catch(Exception exception){
				flag			=	"INVALID_PATIENT";
				result			=	false;
			}
		}
		else if (validate.equals("POPULATE_ITEM_CODE")){
			ArrayList alRecords	=	null;
			ArrayList alParameters	=	new ArrayList(4);
			alParameters.add(bean.getLoginFacilityId());
			alParameters.add(ret_store_code);
			alParameters.add(rec_store_code);
			alParameters.add(bean.checkForNull(patient_id,""));
			alRecords = bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_RETURN_DISCREPANCY_DTL_SELECT_LIST"),alParameters);
				
			out.println(  "clearListItems(\"parent.frameReturnInstrumentsDetail.document.formReturnInstrumentsDetail.item_code\");"  );
			if(alRecords==null) return;
			for (int i=0;i<alRecords.size();i++){
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				out.println(  "addListItem(\"parent.frameReturnInstrumentsDetail.document.formReturnInstrumentsDetail.item_code\",\""+hmRecord.get("CODE")+"\",\""+hmRecord.get("DESCRIPTION")+"\");"  );
			}
		}

		else if (validate.equals("ADD_TO_LIST")){
			HashMap hmListItems	=	new HashMap();

			if(bean.isItemInArrayList(alReturnInstrumentsList,item_code,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			if(remarks.length()>200){
				throw new Exception("REMARKS_EXCEEDS_MAX_LIMIT");
			}
			
			StringTokenizer stItem_code	=	new StringTokenizer(item_code,"|");//21052
			String strGroup_code	=	stItem_code.nextToken();
			String strTray_no		=	stItem_code.nextToken();
			String strItem_code		=	stItem_code.nextToken();
			String streExpiry_Date	=	stItem_code.nextToken();//Added for TH-KW-CRF-0030
		
			HashMap hmRecord	=	null;
			ArrayList alParameters	=	new ArrayList(7);
			alParameters.add(bean.getLoginFacilityId());
			alParameters.add(ret_store_code);
			alParameters.add(rec_store_code);
			alParameters.add(bean.checkForNull(patient_id,""));
			alParameters.add(strItem_code);
			alParameters.add(strTray_no);
			alParameters.add(strGroup_code);
			
			hmRecord = bean.fetchRecord("SELECT dtl.discrepancy_qty-dtl.returned_qty pending_qty,dtl.discrepancy_qty DISCREPANCY_QTY FROM ss_return_hdr hdr, ss_return_discrepancy_dtl dtl, ss_group ss, mm_item mm WHERE ss.group_code=dtl.group_code AND mm.item_code=dtl.item_code AND hdr.doc_type_code = dtl.doc_type_code AND hdr.FACILITY_ID=dtl.FACILITY_ID AND hdr.doc_no=dtl.doc_no  AND (dtl.discrepancy_qty - dtl.returned_qty) >= 0  AND item_returnable_yn='Y' AND hdr.facility_id=? AND hdr.fr_store_code=? AND hdr.to_store_code=? AND NVL(dtl.patient_id,'~')=nvl(?,nvl(dtl.patient_id,'~')) AND dtl.item_code=? AND dtl.tray_no=? AND dtl.group_code=?",alParameters);
		
			
			if(mode.equals(bean.getCommonRepositoryValue("MODE_INSERT"))){
			if(Long.parseLong(ret_item_qty)>Long.parseLong(hmRecord.get("PENDING_QTY").toString()) ){
				
				throw new Exception("RETURN_EXCEEDS_PENDING");
			}
			}
			else
			{
			if(Long.parseLong(ret_item_qty)>Long.parseLong(hmRecord.get("DISCREPANCY_QTY").toString()) ){
				
				throw new Exception("RETURN_EXCEEDS_PENDING");
			}
			}
			System.err.println("Returned Qty"+ret_item_qty);
			hmListItems.put("item_code",		item_code		);
			hmListItems.put("item_desc",		item_desc		);
			hmListItems.put("ret_item_qty",		ret_item_qty	);
			hmListItems.put("ret_item_cost",	""+(bean.getItemUnitCost(strItem_code)*Double.parseDouble(ret_item_qty)));
			hmListItems.put("damaged_yn",		damaged_yn.equals("true")?"Y":"N"		);
			hmListItems.put("contaminated_yn",	contaminated_yn.equals("true")?"Y":"N"	);
			hmListItems.put("remarks",			remarks			);
			hmListItems.put("expiry_date",			streExpiry_Date			);//Added for TH-KW-CRF-0030
			System.err.println(item_code+item_desc+ret_item_qty+(bean.getItemUnitCost(strItem_code)*Double.parseDouble(ret_item_qty))+damaged_yn+contaminated_yn+remarks);
			if(index.equals("-1")){
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alReturnInstrumentsList.add(hmListItems);
			}
			else{
				hmListItems.put("mode",((HashMap)alReturnInstrumentsList.get(Integer.parseInt(index))).get("mode"));
				System.err.println("hmListItems "+hmListItems);
				alReturnInstrumentsList.set(Integer.parseInt(index),hmListItems);
			}
			System.err.println("hmListItems "+hmListItems);
			out.println("disableStorePatient();");
			result	=	true;
			message	=	"Done";
		}

	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
		System.err.println("message "+message);
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
putObjectInBean("returnInstrumentsListBean",bean,request);

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
