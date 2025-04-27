package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __newproceduretabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcedureTabs.jsp", 1709119750000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head><title>New Procedure Tabs</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\n\t<script>\n\t\t\n\t\t\n\t\tfunction change_common_tab(obj)\n\t\t{  \n\t\t\t\n\t\t\t\n\t\t\tvar qry_str= document.proceduretab_form.qry_str.value;\n\t\t\t\n\t\t\t//if(patient_id !=\"\"){\n\t\t\t\tdocument.getElementById(\"tab\").style.visibility=\"visible\";\n\t\t\tif((obj==\"View\") )\n\t\t\t{\t\n\t\t\t\tcolorChange(obj);\n\t\t\t\t\n \t\t\t\t/*parent.refusal_main_label.location.href = \"../../eOR/jsp/RefusalOrderResultLabel.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&patient_id=\"+patient_id;\n \t\t\t\t\n \t\t\t\t*/\n\t\t\t\tparent.document.getElementById(\"procDetailFrame\").rows=\"17.5%,79%,3.5%,0%,0%,0%\";\n\t\t\t\tparent.document.getElementById(\"procTermFrame\").cols=\"100%,0%\";\n\t\t\t\tparent.document.getElementById(\"procPractFrame\").cols=\"100%,0%\";\n\n\t\t\t\tparent.proc_main_search.location.href =\"../../eOR/jsp/NewProcedureSearch.jsp?\"+qry_str;\n\t\t\t\tparent.proc_main_result.location.href =\"../../eOR/jsp/NewProcedureQueryResult.jsp?\"+qry_str; \t\t\t\t\n\t\t\t\tparent.proc_main_label.location.href = \"../../eOR/jsp/NewProcedureLegend.jsp\";\n   \t\t  \t\tparent.proc_main_desc.location.href = \"../../eCommon/html/blank.html\";\n   \t\t  \t\tparent.proc_main_butn.location.href = \"../../eCommon/html/blank.html\";\n   \t\t  \t\t\n\t\t\t}\n\t\t\telse if( obj==\"New\" )\n\t\t\t{\n\t\t\t\tcolorChange(obj);\n\t\t\t\t\n\t\t\t\t//parent.document.getElementById(\"procDetailFrame\").rows=\"30%,15%,30%,5%,0%\";\n\t\t\t\tparent.document.getElementById(\"procDetailFrame\").rows=\"15%,40%,40%,5%,0%\";\n\t\t\t\tparent.document.getElementById(\"procTermFrame\").cols=\"50%,50%\";\n\t\t\t\tparent.document.getElementById(\"procPractFrame\").cols=\"50%,50%\";\n   \t\t  \t\t\n\t\t\t\tparent.proc_main_search.location.href = \"../../eOR/jsp/NewProcedureAddModify.jsp?\"+qry_str;\n   \t\t  \t\tparent.proc_main_result.location.href = \"../../eCommon/html/blank.html\";\n   \t\t  \t\tparent.proc_term_info.location.href = \"../../eCommon/html/blank.html\";\n   \t\t  \t\t\n   \t\t  \t\t\n   \t\t  \t\t//parent.document.getElementById(\"proc_main_label\").scrolling = \"auto\";\n   \t\t  \t\t\n   \t\t  \t\tparent.proc_main_label.location.href = \"../../eOR/jsp/NewProcedureAddModifyPractMulti.jsp?\"+qry_str;\n   \t\t  \t\tparent.proc_main_butn.location.href = \"../../eOR/jsp/NewProcedureBtn.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n   \t\t  \t\tparent.proc_main_desc.location.href = \"../../eOR/jsp/NewProcedureDesc.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n   \t\t  \t\tparent.proc_temp_frame.location.href = \"../../eCommon/html/blank.html\";\n\t\t  \t}\n\t\t\t/*}else{\n\t\t\t\tdocument.getElementById(\"tab\").style.visibility=\"hidden\";\n\t\t\t\t//alert(getOrMessage(\'SHD_NOT_BE_BLANK\'));\n\t\t\t\tdocument.proceduretab_form.patientId.focus();\n\t\t\t\tparent.refusal_main_search.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\tparent.refusal_main_label.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\tparent.refusal_main_result.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\t\n\t\t\t}*/\n\t\t\tif(top.content)\n\t\t\t\ttop.content.messageFrame.location.href = \"../../eCA/jsp/error1.jsp\";\n\t\t}\n\n\t\tfunction colorChange(obj) {\n\t\t\t/*if(document.proceduretab_form.all.viewRefusal){\n\t\t\t\tdocument.proceduretab_form.all.viewRefusal.className  = \"CAFIRSTSELECTHORZ\";\n\t\t\t\talert(\'here\');\n\t\t\t}if(document.proceduretab_form.all.refusalType){\n\t\t\t\tdocument.proceduretab_form.all.refusalType.className\t\t= \"CASECONDSELECTHORZ\";\n\t\t\t\talert(\'hereeeeeeeeeeeeeee\');\n\t\t\t}*/\n\t\t\tif(obj==\'View\'){\n\t\t\t\tdocument.proceduretab_form.all.viewRefusal.className\t= \"CASECONDSELECTHORZ\";\n\t\t\t\tdocument.proceduretab_form.all.refusalType.className\t= \"CAFIRSTSELECTHORZ\";\n\t\t\t\t//alert(\'here\');\n\t\t\t}else if(obj==\'New\'){\n\t\t\t\tdocument.proceduretab_form.all.viewRefusal.className\t= \"CAFIRSTSELECTHORZ\";\n\t\t\t\tdocument.proceduretab_form.all.refusalType.className\t= \"CASECONDSELECTHORZ\";\n\t\t\t\t//alert(\'hereeeeeeeeeeeeeee\');\n\t\t\t}\n\t\t}\n\t\tfunction changeColor(obj,from_name)\n\t\t{\n\t\t\tif(from_name==\"COMMON\")\n\t\t\t\tcellref = document.getElementById(\"tab\").rows(0).cells\n\t\t\tfor(i=0; i<cellref.length; i++)\n\t\t\t{\n\t\t\t\tif(i!=2 && i!=3)\n\t\t\t\t cellref[i].className = \'CAFIRSTSELECTHORZ\'\n\t\t\t}\n\t\t\tobj.className = \"CASECONDSELECTHORZ\"\n\t\t\tcurrClass =\"CASECONDSELECTHORZ\";\n\t\t}\n\t\tfunction callOnMouseOver(obj){\n\t\tcurrClass = obj.className ;\n\t\t obj.className = \'CASECONDSELECTHORZ\';\n\t\t \n\t\t}\n\nfunction callOnMouseOut(obj){\n\tobj.className = currClass;\n}\n\t</script>\n\t<STYLE TYPE=\"text/css\"></STYLE>\n </head>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body onLoad=\"change_common_tab(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"proceduretab_form\" id=\"proceduretab_form\">\n<table id=\"\" cellspacing=0 cellpadding=\"3\" border=\"0\" width=\'100%\'>\n<tr>\n\t<td class=\"label\" width=\'30%\'>\n\t\t<table id=\"tab\" cellspacing=0 cellpadding=\"1\" border=\"0\" width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<td id=\"viewRefusal\" width=\'50%\' class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"changeColor(this,\'COMMON\')\" nowrap><a  style=\'color:white;cursor:pointer\' href=\"javascript:change_common_tab(\'View\')\">Existing Procedure</a></td>\n\t\t\t\t<td id=\"refusalType\" width=\'50%\' class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"changeColor(this,\'COMMON\')\" nowrap><a style=\'color:white;cursor:pointer\' href=\"javascript:change_common_tab(\'New\')\">New Procedure</a></td>\n\t\t\t</tr>\n\t\t</table>\n\t</td>\n\t<td class=\"label\" width=\'35%\'></td>\n\t<td class=\"label\" width=\'35%\'></td>\n</tr>\n</table>\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\"hidden\" name=\"qry_str\" id=\"qry_str\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"\">\n</form>\n</body>\n</html> \n \n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);

	
	String encounter_id			= request.getParameter("episode_id");
	String class_name_first		= "";
	String patient_id = (request.getParameter("patient_id")==null) ? "":request.getParameter("patient_id");
	//out.println("<script>alert('patient_id="+patient_id+"');</script>");
	String tab_name = (request.getParameter("tab_name")==null) ? "View":request.getParameter("tab_name");	
		

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(tab_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(class_name_first));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(class_name_first));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
