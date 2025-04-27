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
import eCA.CAOpenChartServlet;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __openchartwrapperintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/OpenChartWrapperIntermediate.jsp", 1743149964938L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script> var  firstwindow = top.window ;</script>\n<BODY OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\nif(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' == \'Switch\') showPats();\n\nelse if(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' == \'unLoad\' || \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' == \'Close\')\n{\n\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' == \"Y\")\n\t\t{\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t\t\t\n\t\t\ttop.window.close();\n\t\t}\n\t\telse if(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' == \"N\")\n\t\t{\n\t\t\tif(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' > 0)\n\t\t\t{\n\t\t\t\talert(getMessage(\"CLOSE_ALL_CHARTS\",\"CA\"));\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n//\t\t\t\ttop.content.location.href = \'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t/* for PMG20089-CRF-0120 by Deepa on 3/11/2009 at 4:12 PM*/\n\n\t\t\t\tif (\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' == \"N\")\n\t\t\t\t{\n\t\t\t\ttop.content.location.href = \'../../eCommon/jsp/dmenu.jsp?desktopFlag=Y\';\n\n\t\t\t\tif(top.headerFrameset != null)\n\t\t\t\t{\n\t\t\t\t\tif(top.headerFrameset.rows == \'8.5%,*\')\n\t\t\t\t\t\ttop.headerFrameset.rows = \'11.3%,*\';\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.parent.content.location.href=\'../../eCommon/jsp/logoff.jsp\';\n\t\t\t\t}\n\t\t\t\t/*ends here*/\n\t\t\t}\n\n\t\t}\n\t\t\n}\n\nasync function showPats(FromPatChart)\n{\n\tif(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' != \'FromPatChart\' )\n\t{\n\t\t/*for (var nCtr =0; nCtr < 701; nCtr++)\n\t\t{}*/\n\t\tvar ref = firstwindow.top.content.CommonToolbar;\n\t\tvar pat_info_temp = new Array();\n\t\tvar pat_info_backup = new Array();\n\t\tpat_info_backup = ref.pat_info;\n\t\tif(ref.pat_info.length == 0 && \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' != \"N\")\n\t\t{\t\t\n\t\t\tpat_info_backup = top.opener.top.content.CommonToolbar.pat_info;\n\t\t\n\t\t}\n\t\t\n\t\tvar j=0 ;\n\t\tvar pat_info_len;\n\t\tif( pat_info_backup != null)\n\t\t\tpat_info_len = pat_info_backup.length;\n\n\t\tif(pat_info_backup != null)\n\t\t{\n\t\t  for(var i=0;i<pat_info_len;i++)\n\t\t  {\n\t\t\t if(!pat_info_backup[i].window_obj.closed  )\n\t\t\t\t{\n\t\t\t\t  pat_info_temp[j] = pat_info_backup[i]\n\t\t\t\t  j++\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tref.pat_info = pat_info_temp;\n\t\tpat_info_backup = pat_info_temp;\n\t\t\n\t\tif(pat_info_backup != null)\n\t\t{\n\t\t\tpat_info_len = pat_info_backup.length;\n\n\t\t\tif(pat_info_len > 1)\n\t\t\t{\n\t\t\t\tvar j=0\n\t\t\t\tpat_info_temp = new Array()\n\t\t\t\t\n\t\t\t\tfor(var i=0;i<pat_info_len;i++)\n\t\t\t\t{\n\t\t\t\t\tif(pat_info_backup[i].winname!=null && pat_info_backup[i].winname !=top.name )\n\t\t\t\t\t{\n\t\t\t\t\t\tpat_info_temp[j] = pat_info_backup[i]\n\t\t\t\t\t\tj++\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t   }\t\n\t  \n\n\t\tif(pat_info_backup != null)\n\t\t{\t\t\t\t\n\t\t\tpat_info_len = pat_info_backup.length;\n\t\t\tif(pat_info_len > 1)\n\t\t\t{\t\n\t\t\t\tvar dialogHeight= 1 ;\n\t\t\t\tif(ref.pat_info.length > 4)\n\t\t\t\t\tdialogHeight = ref.pat_info.length *2;\n\t\t\t\tvar dialogWidth = \"45\" ;\n\t\t\t\tvar dialogTop = \"117\" ;\n\t\t\t\tvar dialogLeft = \"50\" ;\n\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";dialogTop:\"+dialogTop+\";dialogLeft:\"+dialogLeft+\";status=no;scroll=no;\"\n\t\t\t\tvar arguments   = \"\" ;\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'==\"Y\")\n\t\t\t\t\tpat_info_temp[pat_info_temp.length] =\"CY\"\n\t\t\t\tretVal =await  window.showModalDialog(\"ShowPatients.jsp?child_window=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&patientID=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&episodeID=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&visitID=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",pat_info_temp,features);\n\t\t\t\tif(retVal != \"CD\" )\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\tif(retVal != null )\n\t\t\t\t\t{\n\t\t\t\t\t\tfor(var i=0;i<pat_info_temp.length;i++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//alert(pat_info_temp[i].winname);\n\t\t\t\t\t\t\tif(pat_info_temp[i].winname == retVal)\n\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tpat_info_temp[i] .window_obj.focus();\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\ttop.opener.document.focus() ;\n\t\t\t\t\t//alert(top.opener.name);\n\t\t\t\t//\twindow.top.opener.focus();\n\t\t\t\t\t//eHISMain1\n\t\t\t\t\t\n\t\t\t\t\t//top.opener.focus() ;\n\t\t\t\t\t//top.opener.close() ;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(pat_info_len == 1)\n\t\t\t\t{\n\t\t\t\t\t if(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'==\"Y\"){\n\t\t\t\t\t\t   //top.opener.top.focus();\n\t\t\t\t\t\t  top.opener.document.focus();\n\t\t\t\t\t\t   }\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tpat_info_temp[0].window_obj.focus();}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\talert(getMessage(\"NO_PATIENT_SELECTED\",\"CA\"))\n\t\t\t}\t\n\t\t} // not patinfo null\n\t}\n\t/*else if(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' == \"FromPatChart\")\n\t{\n\t\tif(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'==\"Y\")\n\t\t{\n\t\t\ttop.opener.focus();\n\t\t\ttop.opener.top.content.CommonToolbar.document.getElementById(\"searchPatHome\").click();\n\t\t}\n\t}*/\n}\n</script>\n<script>\n\ttop.content.messageFrame.location.href = \"../../eCommon/jsp/error.jsp\";\n</script>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patientId = request.getParameter("patientID") == null ? "" : request.getParameter("patientID");
	String episodeId = request.getParameter("episodeID") == null ? "" : request.getParameter("episodeID");
	String visitId = request.getParameter("visitID") == null ? "" : request.getParameter("visitID");
	String fromPatChart = request.getParameter("FromPatChart") == null ? "" : request.getParameter("FromPatChart"); 
	String fromCloseOrSwitch = request.getParameter("FromCloseOrSwitch") == null ? "" : request.getParameter("FromCloseOrSwitch");
	if(fromCloseOrSwitch.equals("unLoad")) fromCloseOrSwitch = "Close";

    String child_window = request.getParameter("child_window") == null ? "" : request.getParameter("child_window");
    String windName = request.getParameter("windName") == null ? "" : request.getParameter("windName");
    String currentWindowName = request.getParameter("currentWindowName") == null ? "" : request.getParameter("currentWindowName");
//	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
//	String queryStringForChart = request.getParameter("queryStringForChart")==null?"":request.getParameter("queryStringForChart");
	String ca_user_desktop_yn=(String)session.getValue("ca_user_desktop_yn");
						if (ca_user_desktop_yn==null) ca_user_desktop_yn="N";
	//String windowName = patientId+episodeId+visitId;

	int mapSize = 0;

	HashMap sessionPatMap = null;
	ArrayList sessionIDList = null;
	Set sessSet = null;
	Iterator sessIter = null;

	HashMap patTempMap = null;

	try
	{
		sessionPatMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId()) == null ? new HashMap() : (HashMap) session.getAttribute("sessionMainMap"+session.getId());

		sessionIDList = (ArrayList) session.getAttribute("sessionList"+session.getId()) == null ? new ArrayList() : (ArrayList) session.getAttribute("sessionList"+session.getId());

		//out.println("<script>alert('sessionIDList "+sessionIDList+"')</script>");

		if(sessionPatMap != null && sessionPatMap != new HashMap())
			mapSize = sessionPatMap.size();
		else
			mapSize = 0;

		sessSet = (Set) sessionPatMap.keySet();
		sessIter = sessSet.iterator();	

	}
	catch(Exception e)
	{
		
		out.println("Exception 1 in OpenChartWrapperIntermediate.jsp --"+e.toString()+"--");
		e.printStackTrace();
	}




            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(fromCloseOrSwitch));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(fromCloseOrSwitch));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(fromCloseOrSwitch));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block10Bytes, _wl_block10);

			if(currentWindowName.equals(""))
			{
		
				patTempMap = (HashMap) sessionPatMap.get(windName) == null ? new HashMap() : (HashMap) sessionPatMap.get(windName);
				patTempMap.remove(windName);
				sessionPatMap.remove(windName);
				sessionIDList.remove(windName);
				session.setAttribute("sessionMainMap"+session.getId(),sessionPatMap);
				session.setAttribute("sessionList"+session.getId(),sessionIDList);
			}
			else
			{
				patTempMap = (HashMap) sessionPatMap.get(currentWindowName) == null ? new HashMap() : (HashMap) sessionPatMap.get(currentWindowName);
				patTempMap.remove(currentWindowName);
				sessionPatMap.remove(currentWindowName);
				sessionIDList.remove(currentWindowName);
				session.setAttribute("sessionMainMap"+session.getId(),sessionPatMap);
				session.setAttribute("sessionList"+session.getId(),sessionIDList);
			}
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mapSize));
            _bw.write(_wl_block13Bytes, _wl_block13);

						sessionPatMap = new HashMap();
						sessionIDList = new ArrayList();					

				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ca_user_desktop_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fromPatChart));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(visitId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(fromPatChart));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block25Bytes, _wl_block25);

	//if(sessionPatMap != null) sessionPatMap.clear();
	//if(sessionIDList != null) sessionIDList.clear();
	//if(patTempMap != null) patTempMap.clear();

            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
