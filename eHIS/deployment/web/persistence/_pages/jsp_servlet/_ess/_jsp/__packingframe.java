package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eSS.*;
import eSS.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __packingframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/PackingFrame.jsp", 1709117482399L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t\t<title> </title>\n\t\t<meta name=\"Generator\" content=\"EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.\">\n\t\t<meta name=\"Author\" content=\"Manish Anand\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t<script language=\"javascript\" src=\"../../eSS/js/SsCommon.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<frameset rows=\'100,*\'>\n\t\t<frame name=\'framePackingHeader\'\t\t\t\tsrc=\"../../eSS/jsp/PackingHeader.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" frameborder=0 scrolling=\'no\'   noresize>\n\t\t<frameset cols=\"40%,*\" >\n\t\t\t<frame name=\'framePackingDetail\'\t\t\tsrc=\"../../eSS/jsp/PackingDetail.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\t\t\t\t\tframeborder=0 scrolling=\'no\'   noresize>\n\t\t\t\t<frame name=\'framePackingList\'\t\t\tsrc=\"../../eSS/jsp/PackingList.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"\t\t\t\t\tframeborder=0 scrolling=\'auto\' noresize>\n\t\t</frameset>\n\n\t</frameset>\n\n</html>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            java.util.ArrayList alPackingList= null;synchronized(session){
                alPackingList=(java.util.ArrayList)pageContext.getAttribute("alPackingList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alPackingList==null){
                    alPackingList=new java.util.ArrayList();
                    pageContext.setAttribute("alPackingList",alPackingList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            java.util.ArrayList alPackingDiscrepancyList= null;synchronized(session){
                alPackingDiscrepancyList=(java.util.ArrayList)pageContext.getAttribute("alPackingDiscrepancyList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alPackingDiscrepancyList==null){
                    alPackingDiscrepancyList=new java.util.ArrayList();
                    pageContext.setAttribute("alPackingDiscrepancyList",alPackingDiscrepancyList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	alPackingList.clear();
	alPackingDiscrepancyList.clear();
	String doc_type_code		=	request.getParameter("doc_type_code");
	String doc_no				=	request.getParameter("doc_no");
	
	PackingListBean bean		=	(PackingListBean)getBeanObject( "packingListBean", "eSS.PackingListBean",request );  
	bean.clear();

	ArrayList alPackingRecords	=	null;
	if( (doc_no!=null) && (doc_type_code!=null) )
	{
		try{
			ArrayList alParameters = new ArrayList();
			alParameters.add(session.getAttribute("facility_id"));
			alParameters.add(doc_type_code);
			alParameters.add(new Long(doc_no));
			
			alPackingRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_ROF_DTL_SELECT_MULTIPLE"),alParameters);

			for (int i=0;i<alPackingRecords.size();i++){
				HashMap hmPackingRecord=(HashMap)alPackingRecords.get(i);
				hmPackingRecord.put("tray_no",			(String)hmPackingRecord.get("TRAY_NO") );
				hmPackingRecord.put("group_code",		(String)hmPackingRecord.get("GROUP_CODE") );
				hmPackingRecord.put("group_desc",		(String)hmPackingRecord.get("GROUP_DESC") );
				hmPackingRecord.put("pack_item_code",	bean.checkForNull((String)hmPackingRecord.get("pack_item_code"),"") );
				hmPackingRecord.put("pack_item_qty",	bean.checkForNull((String)hmPackingRecord.get("pack_item_qty"),""));
				hmPackingRecord.put("pack_cost",		bean.checkForNull((String)hmPackingRecord.get("PACK_COST"),""));
				hmPackingRecord.put("packing_date",		bean.checkForNull((String)hmPackingRecord.get("PACKING_DATE"),""));
				hmPackingRecord.put("pack_item_desc",	bean.checkForNull((String)hmPackingRecord.get("pack_item_desc"),""));
				hmPackingRecord.put("store_code",		bean.checkForNull((String)hmPackingRecord.get("store_code"),""));
				hmPackingRecord.put("hold_yn",			(String)hmPackingRecord.get("HOLD_YN"	));
				hmPackingRecord.put("hold_reason",		bean.checkForNull((String)hmPackingRecord.get("HOLD_REASON"),""));
				hmPackingRecord.put("mode",				eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				
				hmPackingRecord.remove("TRAY_NO");    
				hmPackingRecord.remove("GROUP_CODE");   
				hmPackingRecord.remove("GROUP_DESC");   
				hmPackingRecord.remove("pack_item_code");
				hmPackingRecord.remove("pack_item_qty");      
				if((String) hmPackingRecord.get("pack_item_qty")==null)
				{
					hmPackingRecord.put("pack_item_qty","");
				}
				if((String) hmPackingRecord.get("store_code")==null)
				{
					hmPackingRecord.put("store_code","");
				}
				if((String) hmPackingRecord.get("pack_item_code")==null)
				{
					hmPackingRecord.put("pack_item_code","");
				}
				if((String) hmPackingRecord.get("pack_item_desc")==null)
				{
					hmPackingRecord.put("pack_item_desc","");
				}
				hmPackingRecord.remove("pack_cost"); 
				hmPackingRecord.remove("PACKING_DATE"); 
				hmPackingRecord.remove("pack_item_desc"); 
				hmPackingRecord.remove("HOLD_YN"); 
				hmPackingRecord.remove("HOLD_REASON"); 
				alPackingList.add(hmPackingRecord);				
				
				
			}
			
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}

putObjectInBean("packingListBean",bean,request);


            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
