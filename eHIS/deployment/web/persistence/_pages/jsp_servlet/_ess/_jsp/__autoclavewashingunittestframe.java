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

public final class __autoclavewashingunittestframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/AutoclaveWashingUnitTestFrame.jsp", 1709117467306L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History     Name        \tRev.Date\t\tRev.Name\t\tDescription\n--------------------------------------------------------------------------------------------------------------------\n25/11/2014\tIN052312\t\tKarthi L\t\t\t\t\t\tRamesh\t\t\tAutoclaving Unit Test Entry\n--------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n\t<head>\n\t\t<title> </title>\n\t\t<meta name=\"Generator\" content=\"EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.\">\n\t\t<meta name=\"Author\" content=\"Geetha CR\">\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t</head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<frameset rows=\'100,*\'  name=\'fsAutoclaveWashingUnitTest\'>\n\t\t<frame name=\'frameAutoclaveWashingUnitTestHeader\' src=\"../../eSS/jsp/AutoclaveWashingUnitTestHeader.jsp?";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" frameborder=0 scrolling=\'no\'   noresize>\n\t\t<!--  <frameset cols=\"40%,*\" >AAKH-CRF-0057 - IN052312 -->\n\t\t  <frameset cols=\"27%,*\" name=\'fsAutoclaveWashingUnitTestDtl\'> <!-- AAKH-CRF-0057 - IN052312 -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<frame name=\'frameAutoclaveWashingUnitTestDetail\' src=\"../../eSS/jsp/AutoclaveWashingUnitTestDetail.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" frameborder=0 scrolling=\'no\'   noresize>\n\t\t\t\t<!-- <frameset rows=\"17,*\">  AAKH-CRF-0057 - IN052312-->\n\t\t\t\t<!-- <frame name=\'frameAutoclaveWashingUnitTestListHeader\' src=\'../../eSS/html/AutoclaveWashingUnitTestListHeader.html\' nowrap frameborder=0 scrolling=\'no\'  noresize> -->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<frame name=\'frameAutoclaveWashingUnitTestDetail\' src=\"../../eCommon/html/blank.html\" frameborder=0 scrolling=\'no\'   noresize>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<frame name=\'frameAutoclaveWashingUnitTestList\'\tsrc=\"../../eSS/jsp/AutoclaveWashingUnitTestList.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" frameborder=0 scrolling=\'auto\' noresize>\n\t\t</frameset>\n\n\t</frameset>\n\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            java.util.ArrayList alAutoclaveWashingUnitTestList= null;synchronized(session){
                alAutoclaveWashingUnitTestList=(java.util.ArrayList)pageContext.getAttribute("alAutoclaveWashingUnitTestList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alAutoclaveWashingUnitTestList==null){
                    alAutoclaveWashingUnitTestList=new java.util.ArrayList();
                    pageContext.setAttribute("alAutoclaveWashingUnitTestList",alAutoclaveWashingUnitTestList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);


	request.setCharacterEncoding("UTF-8");
	String sStyle			 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	alAutoclaveWashingUnitTestList.clear();
	String autoclave_wash_unit_code	=	request.getParameter("autoclave_wash_unit_code");
	String test_date				=	request.getParameter("test_date");
	String unit_type				=	request.getParameter("unit_type");
	String mode				=	request.getParameter("mode");
	String bean_id					=	 "autoclaveWashingUnitTestListBean";
	String bean_name				=	"eSS.AutoclaveWashingUnitTestListBean";

	AutoclaveWashingUnitTestListBean bean = (AutoclaveWashingUnitTestListBean) getBeanObject( bean_id,  bean_name, request );  
	bean.clear();
	ArrayList alAutoclaveWashingUnitTestRecords	=	null;
	if(autoclave_wash_unit_code!=null){
		try{
			ArrayList alParameters = new ArrayList(3);
			alParameters.add(autoclave_wash_unit_code.trim());
			alParameters.add(test_date.trim());
			alParameters.add(unit_type.trim().substring(0,1));
			alAutoclaveWashingUnitTestRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_DTL_SELECT_MULTIPLE"),alParameters);

			for (int i=0;i<alAutoclaveWashingUnitTestRecords.size();i++){
				HashMap hmAutoclaveWashingUnitTestRecord=(HashMap)alAutoclaveWashingUnitTestRecords.get(i);
				hmAutoclaveWashingUnitTestRecord.put("test_code",		(String)hmAutoclaveWashingUnitTestRecord.get("TEST_CODE") );
				hmAutoclaveWashingUnitTestRecord.put("batch_id",	(String)hmAutoclaveWashingUnitTestRecord.get("BATCH_ID") );
				hmAutoclaveWashingUnitTestRecord.put("test_result",		(String)hmAutoclaveWashingUnitTestRecord.get("TEST_RESULT")  );
				hmAutoclaveWashingUnitTestRecord.put("test_date",		(String)hmAutoclaveWashingUnitTestRecord.get("TEST_DATE")  );
				hmAutoclaveWashingUnitTestRecord.put("result_date",		(String)hmAutoclaveWashingUnitTestRecord.get("RESULT_DATE")  );
				hmAutoclaveWashingUnitTestRecord.put("result_remarks",		(String)hmAutoclaveWashingUnitTestRecord.get("RESULT_REMARKS"));
				hmAutoclaveWashingUnitTestRecord.put("unit_type",		unit_type);
				//added for AAKH-CRF-0057 - IN052312 - Start	
				hmAutoclaveWashingUnitTestRecord.put("room_temp",		(String)hmAutoclaveWashingUnitTestRecord.get("ROOM_TEMP"));
				hmAutoclaveWashingUnitTestRecord.put("relative_humidity",		(String)hmAutoclaveWashingUnitTestRecord.get("RELATIVE_HUMIDITY"));
				hmAutoclaveWashingUnitTestRecord.put("biologic_indicator",		(String)hmAutoclaveWashingUnitTestRecord.get("BIOLOGICAL_IND_TEST_DONE"));
				hmAutoclaveWashingUnitTestRecord.put("bms_pass_fail",		(String)hmAutoclaveWashingUnitTestRecord.get("BMS_PASS_FAIL"));
				//added for AAKH-CRF-0057 - IN052312 - End
				hmAutoclaveWashingUnitTestRecord.put("mode",			eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				hmAutoclaveWashingUnitTestRecord.remove("TEST_CODE") ;
				hmAutoclaveWashingUnitTestRecord.remove("BATCH_ID")  ;
				hmAutoclaveWashingUnitTestRecord.remove("TEST_RESULT");
				hmAutoclaveWashingUnitTestRecord.remove("TEST_DATE");
				//added for AAKH-CRF-0057 - IN052312 - Start	
				hmAutoclaveWashingUnitTestRecord.remove("ROOM_TEMP") ;
				hmAutoclaveWashingUnitTestRecord.remove("RELATIVE_HUMIDITY")  ;
				hmAutoclaveWashingUnitTestRecord.remove("BIOLOGICAL_IND_TEST_DONE");
				hmAutoclaveWashingUnitTestRecord.remove("BMS_PASS_FAIL");
				//added for AAKH-CRF-0057 - IN052312 - End	
				alAutoclaveWashingUnitTestList.add(hmAutoclaveWashingUnitTestRecord);
			}
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}
	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block6Bytes, _wl_block6);

			if(mode.equals("1")){

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
			else{

            _bw.write(_wl_block9Bytes, _wl_block9);

			}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
