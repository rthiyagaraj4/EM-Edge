package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnoteslinkmultihistintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkMultiHistIntermediate.jsp", 1709115233603L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");


	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

	ArrayList list = manageEmailBean.returnSortList();

	Connection con = null;
/*	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql	 = "";
	StringBuffer displaydata = new StringBuffer();
	StringBuffer section_content = null ;
	String		 hist_data_type="";
	String		 strKey			=	"";
	String		 contentXML = "";*/
	String		 secKey = "";
	String		 hashKey = "";
	


	
	String sec_hdg_code = request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
//	String child_sec_hdg_code = request.getParameter("child_sec_hdg_code")==null?"":request.getParameter("child_sec_hdg_code");
	String Histrectype = request.getParameter("Histrectype")==null?"":request.getParameter("Histrectype");
	String Contrsysid = request.getParameter("Contrsysid")==null?"":request.getParameter("Contrsysid");
	String Accessionnum = request.getParameter("Accessionnum")==null?"":request.getParameter("Accessionnum");
	String Contrsyseventcode = request.getParameter("Contrsyseventcode")==null?"":request.getParameter("Contrsyseventcode");
	String result_disp = request.getParameter("result_disp")==null?"&nbsp;":request.getParameter("result_disp");
	result_disp=result_disp.trim();
	if(result_disp.equals("")||result_disp.equals("SPACE")||result_disp==null||result_disp.equals("null")||result_disp.equals("&nbsp;")||result_disp.equals("&amp;nbsp;"))
	{
		result_disp ="&amp;nbsp;";
	
	}
	String hist_rec_type_desc = request.getParameter("hist_rec_type_desc")==null?"&nbsp;":request.getParameter("hist_rec_type_desc");
	if(hist_rec_type_desc.equals("")||hist_rec_type_desc==null||hist_rec_type_desc.equals("null"))
		hist_rec_type_desc ="&nbsp;";
	String sort_by = request.getParameter("sort_by")==null?"C":request.getParameter("sort_by");
	String event_date_time = request.getParameter("event_date_time")==null?"":request.getParameter("event_date_time");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");

	
	try
	{
			hashKey = Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode+"~"+sec_hdg_code;
			
			if(sort_by.equals("D"))
				{
					secKey = sort_by+"~"+event_date_time+"~"+Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode+"~"+result_disp+"~"+hist_rec_type_desc+"~"+sec_hdg_code;
					//secKeyVal=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode
				}
				else if(sort_by.equals("C"))
				{
					secKey=sort_by+"~"+Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode+"~"+result_disp+"~"+hist_rec_type_desc+"~"+event_date_time+"~"+sec_hdg_code;
					//secKeyVal=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode
				}

				//secKey=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode;
				
				//secKey = secKey.trim();
				//PatResHash.put(secKey,section_content.toString());


				//sectionBean.setPatSecDetails(PatResHash,patient_id);

				//sectionBean.setSectionContent(sec_hdg_code,child_sec_hdg_code,section_content.toString());
				
				if(mode.equals("add"))
				{
					if(!list.contains(secKey)) 
						manageEmailBean.addRecordsToSortList(hashKey);
						manageEmailBean.addToHashMap(hashKey,secKey);
						manageEmailBean.addRecordstoLine2(hashKey);
						manageEmailBean.remRecordsFromLine1(hashKey);
						//manageEmailBean.addRecordstoLine1(secKeyVal);
				}
				if(mode.equals("remove"))
				{

					manageEmailBean.remRecordsFromSortList(hashKey);
					manageEmailBean.removeFromHashMap(hashKey);
					if(!manageEmailBean.returnList1().contains(hashKey))
						{
							manageEmailBean.addRecordstoLine1(hashKey);
							//manageEmailBean.addToHashMap(hashKey,secKey);
						}
					
					//if((list.contains(secKey)))
					//manageEmailBean.addRecordstoLine2(secKey);
					
				}
				
				if(mode.equals("removeAll"))
				{
					manageEmailBean.clearBean();
												
				}
			
				putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session);

				//putObjectInBean("sectionBean",sectionBean,session);


		/*if(rs !=null) rs.close();
		if(stmt != null ) stmt.close(); */

	}catch(Exception e)
	{		
		
		e.printStackTrace();
	
	}

	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}


	
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
