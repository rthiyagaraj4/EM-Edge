package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __quicklinksforrespcustomizedtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/QuickLinksForRespCustomizeDtl.jsp", 1733739404592L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n    \n</head>\n<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" style=\'background-color:#E2E3F0;\'>\n<form name=\'QuickLinksForRespCustomizeDtl\' id=\'QuickLinksForRespCustomizeDtl\' action=\"QuickLinksForRespCustomizeDtl.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"  method=\'post\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\n\t <table border=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<td width=\'65%\'></td> \n\t\t\t<td align=\'right\' width=\'35%\'>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\n\t\t<a  class=\'gridLink\' href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\n\t\t<a class=\'gridLink\' href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")\' text-decoration=\'none\'>&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</td>\n\t\t</tr>\n\t </table>\n\t  <table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=tableId>\n\t\t<td class=\'columnHeadercenter\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=\'columnHeadercenter\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\n\t\t<td class=\'columnHeadercenter\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<tr>\n\t\t\t\t<td class=\'CAGROUP\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<td class=\'CAGROUP\' align=\'center\'><input type=\'checkbox\' name=\"chk";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"chk";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" onclick=\"enableDefault(this,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<td class=\'CAGROUP\' align=\'center\'><input type=\'checkbox\' name=\"default_chk";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"default_chk";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" onclick=\'defaultSelect(this);\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n\t\t<input type=hidden name=from value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t<input type=hidden name=to value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t<input type=hidden name=\'link_type\' id=\'link_type\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t<input type=hidden name=\'default_yn\' id=\'default_yn\' value=\'\'>\n\t\t<input type=hidden name=\'initial_count\' id=\'initial_count\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t </table>\n\t \t \n\t <table border=\'0\' width=\'100%\'>\n\t <tr><td align=\'right\'><input type=\'button\' class=\'white\' value=\'Update\' width=\'25%\' onclick=\'updateResp()\'></td></tr></table>\n\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</form>\n</body>\n<script>\n\tfunction submitPrevNext(from, to)\n\t{\n\t\t\n\t\tdocument.QuickLinksForRespCustomizeDtl.from.value = from;\n        document.QuickLinksForRespCustomizeDtl.to.value = to; \n        document.QuickLinksForRespCustomizeDtl.target = \"detailFrame\"\n        document.QuickLinksForRespCustomizeDtl.submit();\n\t}\n\t\n\tfunction updateResp()\n\t{\t\t\t\n\t\tdocument.QuickLinksForRespCustomizeDtl.action = \"../../servlet/eCA.QuickLinksRespUpdateServlet?function_id=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\n\t\tdocument.QuickLinksForRespCustomizeDtl.target = \"messageFrame\"\n        document.QuickLinksForRespCustomizeDtl.submit();\n\t}\n\tvar pre_default=\'\';\n\tfunction chkdefault(count,obj)\n\t{\n\t\tdocument.forms[0].default_yn.value=obj;\n\t\t\n\t\tif(pre_default!=\'\')\n\t\t{\n\t\t\teval(\"document.forms[0].chkdefault\"+pre_default).checked = false;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvar initial_count = document.forms[0].initial_count.value;\n\t\t\t\n\t\t\t\tif(initial_count!= -1)\n\t\t\t\t{\n\t\t\t\t\teval(\"document.forms[0].chkdefault\"+initial_count).checked = false;\n\t\t\t\t}\n\t\t}\n\t\tpre_default = count;\n\t}\n\nfunction defaultSelect(object)\n{\n\tvar start = eval(document.forms[0].from.value)-1;\n\tvar end = eval(document.forms[0].end.value)-1;\n\tfor(i=start;i<=end;i++)\n\t{\n\t\tif(object.checked == true)\n\t\t{\n\t\t\tif(eval(\"document.forms[0].default_chk\"+i)!=null)\n\t\t\t{\n\t\t\t\tvar obj = eval(\"document.forms[0].default_chk\"+i);\n\t\t\t\t\n\t\t\t\tif(object == obj)\n\t\t\t\t{\n\t\t\t\t\tif(eval(\"document.forms[0].chk\"+i).checked == true)\n\t\t\t\t\t\tobj.checked = true;\n\t\t\t\t\telse\n\t\t\t\t\t\tobject.checked = false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tobj.checked = false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n}\n\n\n\n\n\tfunction enableDefault(obj,count)\n\t{\n\t\tif(eval(\"document.forms[0].default_chk\"+count)!=null)\n\t\t{\n\t\t\tif(obj.checked==true)\n\t\t\t{\n\t\t\t\t\n\t\t\t\teval(\"document.forms[0].default_chk\"+count).disabled = false;\t\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t\n\t\t\t\teval(\"document.forms[0].default_chk\"+count).checked = false;\n\t\t\t\teval(\"document.forms[0].default_chk\"+count).disabled = true;\n\t\t\t}\n\t\t}\n\n\t}\n\n\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String episode_id = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
	String encounterId = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	webbeans.eCommon.RecordSet CustomizeResp = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeResp"+patient_id+encounterId,"webbeans.eCommon.RecordSet",session);
	webbeans.eCommon.RecordSet CustomizeRespDef = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeRespDef"+patient_id+encounterId,"webbeans.eCommon.RecordSet",session);
	//out.println("CustomizeResp "+CustomizeResp.getRecordSetHandle());

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");
	String userId=((String) session.getValue("login_user")).trim();
	String resp_id				= (String)session.getValue("responsibility_id");
	//String reln_id				= (String)session.getValue("relationship_id");
	String reln_id				= request.getParameter("relationship_id");
	String facilityId			= (String)session.getValue("facility_id");
	if(resp_id == null) resp_id = "";
	if(reln_id == null) reln_id = "";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String from			= request.getParameter("from") ;
	String to			= request.getParameter("to") ;
	String checkedOnes	= "";
	String req_start   =   "", req_end     =   "";
	//String function_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
	String link_type = "";
	String checkdef_dis = "";
	String df_checkStatus = "";

	String speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	link_type = request.getParameter("link_type")==null?"":request.getParameter("link_type");
	String patientclass = request.getParameter("patientclass") == null ? "" : request.getParameter("patientclass");

	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	
	String prev_notes_called_from = request.getParameter("prev_notes_called_from") == null ? "" : request.getParameter("prev_notes_called_from");

	if(!prev_notes_called_from.equals("") && prev_notes_called_from.equals("PREVIOUS_NOTES"))
		function_id = prev_notes_called_from;

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;
		
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 13 ; }   else {  end = Integer.parseInt( to ) ; }


	req_start       =   (request.getParameter("start")==null)   ?   "0" : request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" : request.getParameter("end");

	if(from != null && to != null) {
		int j=0;
		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		{
			if(request.getParameter("chk"+(i-1)) != null)
			{
				checkedOnes = request.getParameter("chk"+(i-1));
				if(!(CustomizeResp.containsObject(checkedOnes)))
				{
					CustomizeResp.putObject(checkedOnes);
				}
				j++;
			}
		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
		
		if(link_type.equals("F"))
		{
			for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
			{
				if(request.getParameter("default_chk"+(i-1)) != null)
				{
					checkedOnes = request.getParameter("default_chk"+(i-1));
					if(CustomizeRespDef.getSize() > 0)
					{
						CustomizeRespDef.removeObject(0);
						CustomizeRespDef.putObject(checkedOnes);
					}
					else
						CustomizeRespDef.putObject(checkedOnes);
				}
			}
		}



	}
	putObjectInBean("CustomizeResp"+patient_id+encounterId, CustomizeResp,session);
	putObjectInBean("CustomizeRespDef"+patient_id+encounterId, CustomizeRespDef,session);
	i = 1;
	try
	{
		con = ConnectionManager.getConnection(request);
		String ql_ref	= "";
		String description	= "";
		int ilCkeckedYN = 0;
		int initial_count = -1;
		int recordCount = 0;
		String checkStatus  = "";	
		String checkProp = "";
		StringBuffer sql = new StringBuffer();

		String checked_yn="";
		String default_yn="";
		String allow_yn="";
		String checkdef="";
		String pat_appl_yn = "";
		String hist_or_record = "";
		String option_id = "";
		String mode = request.getParameter("mode")==null?"V":request.getParameter("mode");
		String desktop_yn = "";
		
		/*sql.append("select QUICK_LINK_REF, QUICK_LINK_DESCRIPTION from SM_QUICK_LINK_LIST a where a.EFF_STATUS = 'E' ");
		if(!function_id.equals(""))
			sql.append(" and a.OPTION_ID = ? ");
		else
			sql.append(" and a.GLOBAL_YN = 'Y' "); */

		sql.append("SELECT DISTINCT A.QUICK_LINK_REF , A.QUICK_LINK_DESCRIPTION , nvl2(c.QUICK_LINK_REF,'Y','N') checked_yn,NVL(C.DEFAULT_YN,'N') DEFAULT_YN "); 
		if(!patient_id.equals(""))
		{
			if(patientclass.equals(""))
				patientclass = "XT";

			sql.append(", APPL_"+patientclass+"_YN Pat_APPL_YN , D.DESKTOP_YN, HIST_OR_RECORD HIST_OR_RECORD");
		}
		else
		{
			sql.append(", 'N' Pat_APPL_YN , D.DESKTOP_YN, '' HIST_OR_RECORD ");
		}
		sql.append(" , NVL((SELECT 'Y' FROM CA_APPL_TASK ia WHERE ia.option_id = a.option_id and 'A' = Get_Task_Applicability(APPL_TASK_ID,DFLT_PRIVILEGE_STATUS,?,?,?,?,?) and  (ia.BASE_MODULE_ID = 'CA' or  exists( select 1 from sm_module where install_yn = 'Y' and MODULE_ID = ia.BASE_MODULE_ID ");

		if(!patient_id.equals(""))
		{
			sql.append(" and ( MODULE_GROUP_ID! = 'SS' OR EXISTS (SELECT 1 FROM AM_SPLTY_FOR_SPLTY_MODULES WHERE MODULE_ID = ia.BASE_MODULE_ID AND  SPECIALITY_CODE = ? )) ");
		}
		sql.append(" )) and rownum=1),'N') Allow_yn, a.option_id, a.QUICK_LINK_TYPE FROM SM_QUICK_LINK_LIST_LANG_VW A,SM_QUICK_LINK_RESP B,SM_QUICK_LINK_FOR_USER c, CA_OPTION D WHERE  A.eff_STATUS='E' and a.LANGUAGE_ID = '"+locale+"' and B.RESP_ID=? AND A.QUICK_LINK_REF = B.QUICK_LINK_REF and c.APPL_USER_ID(+)=? AND c.LINK_TYPE(+) =?  AND c.QUICK_LINK_REF(+) = A.QUICK_LINK_REF AND D.OPTION_ID(+) = A.OPTION_ID "); // AND c.QUICK_LINK_REF(+) =A.QUICK_LINK_REF
		
		if(patient_id.equals(""))
		{
			sql.append(" and D.DESKTOP_YN = 'Y' ");
		}
		else
		{
			 sql.append(" and D.DESKTOP_YN = 'N' ");
		}

		if(link_type.equals("Q"))
			sql.append(" AND A.GLOBAL_YN='Y' and b.LINK_TYPE = 'Q'");
		else if(link_type.equals("F"))
			sql.append(" AND A.FUNCTION_SPEC_YN ='Y' AND A.OPTION_ID = ? and b.LINK_TYPE = 'F'");	
		
		if(!link_type.equals("F"))
		{		
			sql.append("UNION ALL SELECT DISTINCT a.quick_link_ref ,(SELECT quick_link_description FROM sm_quick_link_list_lang_vw WHERE LANGUAGE_ID = ? AND QUICK_LINK_REF = a.quick_link_ref) quick_link_description,nvl2(d.QUICK_LINK_REF,'Y','N') checked_yn,NVL(d.DEFAULT_YN,'N') DEFAULT_YN,");
			
			if(patient_id.equals(""))
			{
				sql.append(" 'N' Pat_APPL_YN ,'Y' DESKTOP_YN ");
			}
			else
			{
				 sql.append(" 'Y' Pat_APPL_YN ,'N' DESKTOP_YN ");
			}
			sql.append(",'' HIST_OR_RECORD,'Y' Allow_yn,'' OPTION_ID, a.QUICK_LINK_TYPE FROM sm_quick_link_list_lang_vw A, SM_QUICK_LINK_RESP C,SM_QUICK_LINK_FOR_USER d WHERE A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND C.RESP_ID =? AND A.QUICK_LINK_REF = C.QUICK_LINK_REF  AND  d.quick_link_ref(+) = c.quick_link_ref AND A.EXTERNAL_URL_APPL  IS NOT NULL AND QUICK_LINK_TYPE = 'EX'");
		}
 		sql.append("  order by 2");
		
		
		pstmt = con.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		
		int indval =1;

		pstmt.setString(indval++,resp_id);
		pstmt.setString(indval++,reln_id);
		pstmt.setString(indval++,facilityId);
		pstmt.setString(indval++,episode_id);
		pstmt.setString(indval++,patient_id);
		if(!patient_id.equals(""))
			pstmt.setString(indval++,speciality_code);
		
		pstmt.setString(indval++,resp_id);
		pstmt.setString(indval++,userId);
		pstmt.setString(indval++,link_type);
		if(link_type.equals("F"))
		{
			pstmt.setString(indval++,function_id);
		}
		if(!link_type.equals("F"))
		{
			pstmt.setString(indval++,locale);
			pstmt.setString(indval++,resp_id);
		}	
		
		rs = pstmt.executeQuery();
		rs.last();
		maxRecord = rs.getRow();
		if(maxRecord == 0)
		{
			/* out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);window.close();</script>"); */
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();</script>");
		}
		else
		{
			rs.beforeFirst();

            _bw.write(_wl_block9Bytes, _wl_block9);

		if ( !(start <= 1)) {
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-13)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-13)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		}	
	
		if ( !((start+13) > maxRecord )){		
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start+13)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+13)));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

			if(link_type.equals("F")){
		 
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
 }
		
            _bw.write(_wl_block22Bytes, _wl_block22);

			if (start != 0){
            for(int j=1; j<start; i++,j++){
                rs.next() ;
             }
			 ilCkeckedYN+=start;
             --ilCkeckedYN ;
			}
			recordCount			=	CustomizeResp.getSize();

			while(rs.next()&& i<=end)
			{
				
				ql_ref = rs.getString("QUICK_LINK_REF")==null?"":rs.getString("QUICK_LINK_REF");
				description = rs.getString("QUICK_LINK_DESCRIPTION")==null?"":rs.getString("QUICK_LINK_DESCRIPTION");
				checked_yn = rs.getString("checked_yn")==null?"":rs.getString("checked_yn");
				default_yn = rs.getString("DEFAULT_YN")==null?"":rs.getString("DEFAULT_YN");
				allow_yn = rs.getString("Allow_yn")==null?"":rs.getString("Allow_yn");
				pat_appl_yn = rs.getString("Pat_APPL_YN")==null?"":rs.getString("Pat_APPL_YN");
				hist_or_record = rs.getString("HIST_OR_RECORD")==null?"":rs.getString("HIST_OR_RECORD");
				option_id = rs.getString("option_id")==null?"":rs.getString("option_id");
				desktop_yn = rs.getString("DESKTOP_YN")==null?"":rs.getString("DESKTOP_YN");
			
				try
				{
					if(CustomizeResp.containsObject(ql_ref))
						checkStatus = "Y";
					else
						checkStatus = "N";


					int recordIndex = CustomizeResp.indexOfObject(ql_ref);
					if(recordIndex!=-1)
					{
						if(checkStatus.equals("Y"))
						{
							CustomizeResp.removeObject(recordIndex);
						}
					}
										
					if(CustomizeRespDef.containsObject(ql_ref))
						df_checkStatus = "Y";
					else
						df_checkStatus = "N";
					
					int recordIndex1 = CustomizeRespDef.indexOfObject(ql_ref);
					if(recordIndex1 != -1)
					{
						if(df_checkStatus.equals("Y"))
						{
							CustomizeRespDef.removeObject(recordIndex1);
						}
					}


				}
				catch(Exception e)
				{
					//out.println("Exception in QuickLinksForRespCustomizeDtl.jsp: "+e.toString());//COMMON-ICN-0181
                                          e.printStackTrace();//COMMON-ICN-0181
				}
								
				//if(checkStatus.trim().equals("Y")||checked_yn.equals("Y"))
				if(checkStatus.trim().equals("Y"))
				{
					checkProp = " CHECKED ";
					checkdef_dis="";
				}
				else
				{
					checkProp = "";
					checkdef_dis ="disabled";
				}

				//if(df_checkStatus.equals("Y")||default_yn.equals("Y"))
				if(df_checkStatus.equals("Y"))
				{
					checkdef ="CHECKED";
					initial_count = ilCkeckedYN;
					
				}
				else
				{
					checkdef ="";
					
				}
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(description));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
				if(!function_id.equals("PREVIOUS_NOTES"))
				{
					
					if(!patient_id.equals(""))
					{
						if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
						{
							if(!option_id.equals("CLINICAL_NOTES") && !option_id.equals("CLINICAL_NOTES_NEW") && !option_id.equals("PATCHIEFCOMPLAINT") && !option_id.equals("REL_PAT_TREAT_PAT") && !option_id.equals("CA_TASK_LIST") && !option_id.equals("CA_TASK_LIST_DT"))
							{
								if(mode.equals("V"))
								{
									if( pat_appl_yn.equals("Y") && !hist_or_record.equals("R") && allow_yn.equals("Y"))
										out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
									else
										out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
								}
								else
								{
									if(pat_appl_yn.equals("Y") && allow_yn.equals("Y"))
										out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
									else
										out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
								}
							}
							else
								out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
						}
						else
						{
							if(mode.equals("V"))
							{
								if( pat_appl_yn.equals("Y") && !hist_or_record.equals("R") && allow_yn.equals("Y"))
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
								else
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
							}
							else
							{
								if(pat_appl_yn.equals("Y") && allow_yn.equals("Y"))
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
								else
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
							}
						}
					}
					else
					{
						if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
						{
							if(!option_id.equals("CA_TASK_LIST") && !option_id.equals("REL_PAT_TREAT") && !option_id.equals("CA_TASK_LIST_DT"))
							{
								if(desktop_yn.equals("Y") && allow_yn.equals("Y"))
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
								else
									out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
							}
							else
								out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
						}
						else
						{
							if(desktop_yn.equals("Y") && allow_yn.equals("Y"))
								out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
							else
								out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
						}
					} 
				}else{
					
					out.println("<td class='CAGROUP' align='center'><img src='../../eCommon/images/enabled.gif'></img></td>");
				}
		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ql_ref));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checkProp));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block29Bytes, _wl_block29);

				if(link_type.equals("F")){
				
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ilCkeckedYN));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ql_ref));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checkdef));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(checkdef_dis));
            _bw.write(_wl_block33Bytes, _wl_block33);
 } 
            _bw.write(_wl_block34Bytes, _wl_block34);

				ilCkeckedYN = ilCkeckedYN + 1;		
				i=i+1;
			}
			out.println("<input type=hidden name='count' id='count' value="+(ilCkeckedYN-1)+">");
 			out.println("<input type='hidden' name='recordCount' id='recordCount' value='"+ recordCount +"'>");
			out.println("<input type=hidden name=occurance value='next'>");
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(start));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(end));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(start));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(end));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(link_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(initial_count));
            _bw.write(_wl_block41Bytes, _wl_block41);

		}	
	
	 }
		catch(Exception e)
		{
			out.println("Exception in CAMainCustomizeToolbarDtl.jsp"+e.toString());
		}
		finally
		{
		    if(con != null)ConnectionManager.returnConnection(con,request);
		}
	 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block44Bytes, _wl_block44);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CurrentPrivilege.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
