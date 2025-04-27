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

public final class __packingvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/PackingValidate.jsp", 1732510730631L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            java.util.ArrayList alPackingDiscrepancyList= null;synchronized(session){
                alPackingDiscrepancyList=(java.util.ArrayList)pageContext.getAttribute("alPackingDiscrepancyList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alPackingDiscrepancyList==null){
                    alPackingDiscrepancyList=new java.util.ArrayList();
                    pageContext.setAttribute("alPackingDiscrepancyList",alPackingDiscrepancyList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            java.util.ArrayList alPackingList= null;synchronized(session){
                alPackingList=(java.util.ArrayList)pageContext.getAttribute("alPackingList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alPackingList==null){
                    alPackingList=new java.util.ArrayList();
                    pageContext.setAttribute("alPackingList",alPackingList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);


		PackingDiscrepancyListBean bean = (PackingDiscrepancyListBean)getBeanObject( "packingDiscrepancyListBean", "eSS.PackingDiscrepancyListBean", request ) ;  
	PackingListBean packingListBean	=	(PackingListBean)getBeanObject( "packingListBean", "eSS.PackingListBean" ,request ) ;

	PackingBean packingBean	=	(PackingBean)getBeanObject( "packingBean", "eSS.PackingBean" ,request ) ;
	
	Hashtable htXMLData				=	(Hashtable) XMLobj.parseXMLString(request);
	htXMLData						=	(Hashtable) htXMLData.get ("SEARCH");

	String validate					=	request.getParameter("validate");

	String group_code				=	request.getParameter("group_code");
	String tray_no					=	request.getParameter("tray_no");
	String item_code				=	request.getParameter("item_code");
	String item_desc				=	request.getParameter("item_desc");
	String write_off_reason_code	=	request.getParameter("write_off_reason_code");
	String write_off_reason_desc	=	request.getParameter("write_off_reason_desc");
	String discrepancy_qty			=	request.getParameter("discrepancy_qty"); 

	String remarks					=	request.getParameter("remarks"); ;
	String index					=	request.getParameter("index");


	String pack_item_code			=	request.getParameter("pack_item_code");
	String pack_item_desc			=	request.getParameter("pack_item_desc");
	String pack_item_qty			=	request.getParameter("pack_item_qty");

	String packing_date				=	request.getParameter("packing_date");
	String hold_reason				=	request.getParameter("hold_reason");
	String hold_yn					=	request.getParameter("hold_yn");
	String message					=	"";
	String flag						=	"";
	boolean	result					=	false;
	

	try{
		if (validate.equals("ADD_TO_DISCREPANCY_LIST")){
			HashMap hmListItems	=	new HashMap();

			double dPackingCost	= bean.getItemUnitCost(item_code);

			if (dPackingCost<0){
				throw new Exception("NOT_A_CSSD_ITEM");
			}
			if (remarks.length()>200){
				throw new Exception("REMARKS_EXCEEDS_LIMIT");
			}
			if(index.equals("-1")){
			if(item_code.equals(bean.getItem_code()))
			{
					
				throw new Exception("RECORD_ALREADY_EXISTS");

			}
			}
			if (!packingListBean.isValidDiscrepancyQty(group_code, tray_no, item_code, "N", discrepancy_qty )){
				throw new Exception("INVALID_DISCREPANCY_QTY_MSG");
			}

			
		

			if(alPackingDiscrepancyList.size()>0){
				int des_qty=0;
				for(int i=0;i<alPackingDiscrepancyList.size();i++){
						
				if(((String)(((HashMap)alPackingDiscrepancyList.get(i)).get("group_code"))).equals(group_code) && 
					((String)(((HashMap)alPackingDiscrepancyList.get(i)).get("tray_no"))).equals(tray_no)   &&  
					((String)(((HashMap)alPackingDiscrepancyList.get(i)).get("item_code"))).equals(item_code)){	
						des_qty=Integer.parseInt(discrepancy_qty)+des_qty+Integer.parseInt((String)(((HashMap)alPackingDiscrepancyList.get(i)).get("discrepancy_qty")));

					}
			    }

				if (!packingListBean.isValidDiscrepancyQty(group_code, tray_no, item_code, "N", ""+des_qty )){
					throw new Exception("INVALID_DISCREPANCY_QTY_MSG");
				}
			}

			if(bean.isItemAndDiscrepancyInArrayList(alPackingDiscrepancyList,item_code,write_off_reason_code,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			hmListItems.put("group_code",			group_code				);
			hmListItems.put("tray_no",				tray_no					);
			hmListItems.put("item_code",			item_code				);
			hmListItems.put("item_desc",			item_desc				);
			hmListItems.put("write_off_reason_code",write_off_reason_code	);
			hmListItems.put("write_off_reason_desc",write_off_reason_desc	);
			hmListItems.put("discrepancy_qty",		discrepancy_qty			);
			hmListItems.put("discrepancy_cost",		""+(Long.parseLong(discrepancy_qty)*dPackingCost)		);
			hmListItems.put("remarks",				remarks					);

			if(index.equals("-1")){
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				hmListItems.put("markedAsDelete",		"N"						);
				alPackingDiscrepancyList.add(hmListItems);
			}
			else{
				hmListItems.put("mode",((HashMap)alPackingDiscrepancyList.get(Integer.parseInt(index))).get("mode"));
				hmListItems.put("markedAsDelete",((HashMap)alPackingDiscrepancyList.get(Integer.parseInt(index))).get("markedAsDelete"));
				alPackingDiscrepancyList.set(Integer.parseInt(index),hmListItems);
			}
			result	=	true;
			message	=	"Done";
		}
		else if (validate.equals("PRESERVE_DISCREPANCY")){
			for(int i=0;i<alPackingDiscrepancyList.size();i++){
				String stMarkedForDeletion=(String)htXMLData.get("checkbox"+i);
				if(stMarkedForDeletion==null) continue;
				HashMap hmListItems	=	(HashMap) alPackingDiscrepancyList.get(i);
				hmListItems.put("markedAsDelete",stMarkedForDeletion);
			}
			result	=	true;
			message	=	"DonePRESERVE_DISCREPANCY";
		}
		else if (validate.equals("ADD_TO_LIST")){
			HashMap hmListItems	=	(HashMap)alPackingList.get(Integer.parseInt(index));
			double dPackingCost=0;
			
			if(!pack_item_code.equals("")   ){
				dPackingCost	= bean.getItemUnitCost(pack_item_code);	
				if (dPackingCost<0){
					throw new Exception("NOT_A_CSSD_ITEM");
				}
			}
			
				hmListItems.put("PACK_ITEM_CODE",		bean.checkForNull(pack_item_code ,"" ));
				hmListItems.put("PACK_ITEM_DESC",		bean.checkForNull(pack_item_desc,""));
				hmListItems.put("PACK_ITEM_QTY",		bean.checkForNull(pack_item_qty,""));
				if(!pack_item_code.equals("")  )
			
				hmListItems.put("PACK_COST",		"100");
				hmListItems.put("remarks",				remarks					);
				hmListItems.put("hold_reason",			hold_reason				);
				hmListItems.put("hold_yn",				hold_yn.equals("true")?"Y":"N");
				hmListItems.put("packing_date",			packing_date);
				alPackingList.set(Integer.parseInt(index),hmListItems);
				
				
				result	=	true;
				
				message	=	"Done";
		}
		
			else if (validate.equals("doc_date")) {
				int isValidDocDate = -1;
				String doc_date = (String) htXMLData.get("packing_date");
				if (doc_date.trim().equals("")) {
					out.println("errorDisplay();"); // To be replaced with proper message
					return;
				}
				
				isValidDocDate = bean.isValidDocDate(doc_date);

				if (isValidDocDate > 0) {
					if (isValidDocDate== 1) {

						throw new Exception("DOC_DT_NOT_LT_PROC_MTH");
					}
					else if (isValidDocDate== 2) {

						throw new Exception("DOC_DT_NOT_GR_SYSDATE");
					}
					out.println("requestDocDateFocus("+isValidDocDate+");");

				} 
				else {
					result = true;

				}

						
             }

			  else if (validate.equals("printOnlineDoc")){
			try{
				String pdocno=packingBean.getPrintDocNo();
				System.out.println("pdocno"+pdocno);
				//packingBean.doOnlineReportPrinting(pdocno,pdocno);
				packingBean.doOnlineReportPrinting(pdocno,pdocno,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
		
			}catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
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
	
putObjectInBean("packingDiscrepancyListBean",bean,request);
putObjectInBean("packingListBean",packingListBean,request);
putObjectInBean("packingBean",packingBean,request);

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
