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

public final class __groupvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/GroupValidate.jsp", 1731914437896L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            java.util.ArrayList alGroupList= null;synchronized(session){
                alGroupList=(java.util.ArrayList)pageContext.getAttribute("alGroupList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alGroupList==null){
                    alGroupList=new java.util.ArrayList();
                    pageContext.setAttribute("alGroupList",alGroupList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            java.util.ArrayList alCheckList= null;synchronized(session){
                alCheckList=(java.util.ArrayList)pageContext.getAttribute("alCheckList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alCheckList==null){
                    alCheckList=new java.util.ArrayList();
                    pageContext.setAttribute("alCheckList",alCheckList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	GroupItemBean bean = (GroupItemBean)getBeanObject( "groupItemBean", "eSS.GroupItemBean",request ) ;  
	String item_code		=	request.getParameter("item_code");
	String item_qty			=	request.getParameter("item_qty");
	String validate			=	request.getParameter("validate");
	String description		=	"";
	String index			=	request.getParameter("index");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	true;

	try{
		if (validate.equals("ITEM_DESC")){
			try{
				out.println("setItemDetails(\""+item_code.toUpperCase()+"\",\""+bean.getItemDescription(item_code.toUpperCase())+"\");");
			}
			catch(Exception exception){
				flag			=	"INVALID_SS_ITEM_CODE";
				result			=	false;
			}
		}
		else if (validate.equals("PACK_ITEM_DESC")){
			try{
				out.println("setPackItemDetails(\""+item_code.toUpperCase()+"\",\""+bean.getItemDescription(item_code.toUpperCase())+"\");");
			}
			catch(Exception exception){
				flag			=	"INVALID_SS_ITEM_CODE";
				result			=	false;
			}
		}
		else if (validate.equals("ADD_TO_LIST")){
			if(bean.isValidItemCode(item_code)){
				description		=	bean.getItemDescription(item_code);	
				if(bean.isItemInArrayList(alGroupList,item_code,Integer.parseInt(index)))
					throw new Exception("RECORD_ALREADY_EXISTS");
				HashMap hmListItems=new HashMap();
				hmListItems.put("ITEM_CODE",item_code);
				hmListItems.put("ITEM_QTY",item_qty);
				hmListItems.put("CONSUMABLE_YN",bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_ITEM_SELECT_SINGLE"),item_code).get("CONSUMABLE_YN").toString());
				hmListItems.put("CHARGEABLE_YN",bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_ITEM_SELECT_SINGLE"),item_code).get("CHARGEABLE_YN").toString());

				hmListItems.put("DESCRIPTION",description);
				hmListItems.put("MADATORY_ITEM_YN","");
				if (index.equals("-1")){
					hmListItems.put("MODE",bean.getCommonRepositoryValue("MODE_INSERT"));
					alGroupList.add(hmListItems);
				}
				else{
					hmListItems.put("MODE",((HashMap)alGroupList.get(Integer.parseInt(index))).get("MODE"));
					alGroupList.set(Integer.parseInt(index),hmListItems);
				}
				result	=	true;
				message	=	"Done";
			}
			else{
				result	=	false;
				message	=	"INVALID_SS_ITEM_CODE";
			}
		}else if(validate.equals("CHECKLIST"))
		{
		String checklist_code = request.getParameter("checklist_code");
		try{
			
	    	ArrayList alParameters = new ArrayList(1);
			alParameters.add(checklist_code);
			ArrayList alResult = new ArrayList();
			alGroupList=bean.fetchRecords("SELECT dtl.item_code, mm.short_desc description, ss.consumable_yn,       ss.item_image_file_name, ss.chargeable_yn, dtl.madatory_item_yn, dtl.quantity item_qty  FROM SS_CHECKLIST_DTL dtl, SS_ITEM ss, mm_item mm, SS_CHECKLIST hdr WHERE dtl.item_code = ss.item_code   AND ss.item_code = mm.item_code   AND dtl.checklist_code = hdr.checklist_code   AND hdr.checklist_code = ? and dtl.EFF_STATUS='E' order by dtl.SEQ_NO",alParameters);
            
	    for	(int i	=0;	i<alGroupList.size();i++){
	    HashMap hmListItems			=	new HashMap();
		hmListItems	=(HashMap)	alGroupList.get(i);
			hmListItems.put("MODE",bean.getCommonRepositoryValue("MODE_INSERT"));
			alResult.add(hmListItems);
			}
			session.setAttribute("alCheckList",alResult);
		System.out.println("Validate alGroupList"+alResult);    
		}
			catch(Exception exception){
				flag			=	"Exception Occured";
				result			=	false;
			}
				
		        result	=	true;
				message	=	"Done";
		}else if(validate.equals("MODIFY_QTY")){
	        String item_qty_temp = request.getParameter("item_qty");
	        String index_temp = request.getParameter("index");
		try {
	    
	    HashMap hmListItems			=	new HashMap();
		hmListItems	=(HashMap)	alGroupList.get(Integer.parseInt(index_temp));
		alGroupList.remove(Integer.parseInt(index_temp));
		hmListItems.put("ITEM_QTY",item_qty_temp);
	    alGroupList.add(Integer.parseInt(index_temp),hmListItems);
		session.setAttribute("alGroupList",alGroupList);
				}
			catch(Exception exception){
				flag			=	"Exception Occured";
				result			=	false;
			}
				
		        result	=	true;
				message	=	"Done";
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
	putObjectInBean( "groupItemBean", bean,request);


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
