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
import eCA.*;
import eOR.Common.*;
import eOR.*;
import java.util.*;
import eCA.CAOpenChartServlet;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recentpatlistdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecentPatListDetails.jsp", 1737541180400L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n   ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n   <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n    <script language=\'javascript\' src=\'../../eCA/js/RecentPatListDetails.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/CACommon.js\'></script> <!-- 37866 -->\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n    <head>\n    </head>\n    <body onscroll=\'moveFrame()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<style>\n.gridDataSelectNew\n{\n\tbackground-color: #CDE5FF;\n\tfont-family: Verdana;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tvertical-align:middle;\t\n} \n</style>\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\nfunction patClick_(id){\n\tfor(var i=0;i<patIdArr.length;i++){\n\t\tif(i==id){\n\t\t\tdocument.getElementById(\'rta\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtb\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtc\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtd\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rte\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtf\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtg\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rth\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rti\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtj\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtk\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtl\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtm\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtn\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rto\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtct\'+i).className=\'gridDataSelectNew\'; //37866\n\t\t}else{\n\t\t\tdocument.getElementById(\'rta\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtb\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtc\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtd\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rte\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtf\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtg\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rth\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rti\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtj\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtk\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtl\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtm\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtn\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rto\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtct\'+i).className=\'gridData\';\t\t//37866\n\t\t}\n\t}\n}\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'PatCriteriaFrm\' id=\'PatCriteriaFrm\' action=\'OpenChartWrapper.jsp\' method = \'post\' target=\'messageFrame\'>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<table class=\'grid\' id=\'PatCriteriaTbl\' width=\'100%\' >\n\t<tr>\n\t\t<th class=\'columnHeadercenter\' width=\'3%\'>&nbsp;</th>\t\t\n\t\t<th class=\'columnHeadercenter\' width=\'3%\'>&nbsp;</th>\t\t\n\t\t<th class=\'columnHeadercenter\' nowrap  >\n\t\t\t<a  id=\'a001\' name=\'a001\' style=\'color:white\' href=\"javascript:callForOrderBy(\'AAT\');\" onclick=\'changeColor(this);\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\' nowrap>\n\t\t\t<a id=\'a01\'  name=\'a01\' style=\'color:white\'    href=\"javascript:callForOrderBy(\'PC\');\" onclick=\'changeColor(this);\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a1\' name=\'a1\' style=\'color:white\'  href=\"javascript:callForOrderBy(\'LOC\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'   nowrap>\n\t\t\t<a id=\'a2\' name=\'a2\'  style=\'color:white\'   href=\"javascript:callForOrderBy(\'PN\');\" onclick=\'changeColor(this);\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n\t\t</th>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\n\t\t<th class=\'columnHeadercenter\'   nowrap>\n\t\t\t<a id=\'a12\' name=\'a12\'  style=\'color:white\'   >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\n\t\t</th>\t\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a3\' name=\'a3\' style=\'color:white\'     href=\"javascript:callForOrderBy(\'DOB\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a4\' name=\'a4\' style=\'color:white\'     href=\"javascript:callForOrderBy(\'AGE\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a5\' name=\'a5\' style=\'color:white\'    href=\"javascript:callForOrderBy(\'SEX\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a6\' name=\'a6\'  style=\'color:white\'   href=\"javascript:callForOrderBy(\'PID\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a72\' name=\'a72\'  style=\'color:white\'   href=\"javascript:callForOrderBy(\'VT\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a>\n\t\t</th>\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a7\' name=\'a7\'  style=\'color:white\'   href=\"javascript:callForOrderBy(\'VD\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a71\'  name=\'a71\' style=\'color:white\'   href=\"javascript:callForOrderBy(\'DD\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a8\' name=\'a8\'  style=\'color:white\'   href=\"javascript:callForOrderBy(\'RN\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a9\' name=\'a9\'  style=\'color:white\'   href=\"javascript:callForOrderBy(\'BN\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a10\' name=\'a10\' style=\'color:white\' href=\"javascript:callForOrderBy(\'AP\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a11\' name=\'a11\' style=\'color:white\'   href=\"javascript:callForOrderBy(\'MS\');\" onclick=\'changeColor(this);\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a>\n\t\t</th>\n\t</tr>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"  name=\"restPatientYN";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'><!--32902  -->\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n        </table>\n                \n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"insert_op\" id=\"insert_op\" value=\"N\">\n        <input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"\">\n\t\t<input type=\"hidden\" name=\"reln_req_yn\" id=\"reln_req_yn\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type=\"hidden\" name=\"fromNewFunction\" id=\"fromNewFunction\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'><!--32902  -->\t\t\n        </form>\n\t\t<div id=\'motherLink\'  name=\'motherLink\' style=\'position:absolute; visibility:visible ;overflow:auto\'></div>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'!=\'\')\n\t\t\t{\n\t\t\t\tdocument.body.scrollLeft=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\';\n\t\t\t}\n\t\t\tif(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'!=\'\')\n\t\t\t{\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'==\'1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\").style.color=\'pink\';\n\t\t\t\t}\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'==\'2\')\n\t\t\t\t\tdocument.getElementById(\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\").style.color=\'yellow\';\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n    </body>\n</html>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );
	
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
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
18/04/2012		IN030318		Ramesh G		This age of the newborn is displayed in the newborn list in location list as well as in the patient banner in patient?s chart.	
24/04/2012		IN032435,IN032437		Ramesh G		The age of new born is displayed as Null.
09/08/2012		IN029180		Chowminya G		 The system is not running by sequence number of newborn.		
01/03/2013		IN037816		Chowminya G		 Recently Assessed Patient List Displaying Outpatient Visit Type For An Inpatient
06/03/2014		ICN060314		Ramesh G		 Error  Unclosed connection detected.
13/03/2014		IN044157		Chowminya		 [AAKH CRF 0010.1]Five level Triage system AE requirement 	
15/04/2023		37866			Ramesh G		 MMS-DM-CRF-0226	
6/11/2023     32902             Krishna Pranay    	     7/11/2023      Ramesh G      MMS-DM-CRF-0210	

---------------------------------------------------------------------------------------------------------------

*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);


	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection con =null;
PreparedStatement pstmt = null;
PreparedStatement mo_install_yn_stmt = null;
ResultSet mo_install_yn_rs = null;
String speciality="";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
con = ConnectionManager.getConnection(request);
String mo_install_yn = "";
String qry_mo_install_yn = "select install_yn from sm_module where module_id='MO'";
mo_install_yn_stmt = con.prepareStatement(qry_mo_install_yn);
mo_install_yn_rs = mo_install_yn_stmt.executeQuery();
if(mo_install_yn_rs.next())
	mo_install_yn = (mo_install_yn_rs.getString("install_yn")==null?"":mo_install_yn_rs.getString("install_yn"));

boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION"); //37866

//32902 start
String ca_bean_id 						= "@CACommonGetPatientDtlBean";
String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
CACommonGetPatientDtlBean bean1					= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
 int accessRightsViewPatient=0;
 //32902 end

HttpSession thisSession = request.getSession(false);
String facility_id  =  (String) thisSession.getValue("facility_id") ;
String userId=(String) session.getValue("login_user");
String apgar_score = "";
String clinicianId=(String) session.getValue("ca_practitioner_id");
accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
StringBuffer QueryString=new StringBuffer();
String relnreqyn = request.getParameter("reln_req_yn")==null?"Y":request.getParameter("reln_req_yn");
//values comming when we try to sort
String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
//to give scrolling effect which clicked on title for sorting
String leftScrolling= request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");
String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
String fromNewFunction= request.getParameter("fromNewFunction")==null?"N":request.getParameter("fromNewFunction");
String sex_desc = "";
String DateofBirth = "";
String dateofbirth1 = "";
String restPatientYN="";//32902
//ends here

/*
	modified by Deepa on 2/4/2010 at 6:43 PM for IN018725/IN000135

	changed the visit_status to include 09
*/
//[IN030318] QueryString.append("SELECT a.patient_id, CASE WHEN B.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE ,b.encounter_id episode_id ,b.OP_EPISODE_VISIT_NUM visit_id ,am_get_desc.am_patient_class (b.patient_class, ?, '2') episode_type_desc , am_get_desc.am_service(b.SERVICE_CODE,?,'2') SPECIALITY, DECODE (b.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, b.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, b.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, b.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, b.assign_care_locn_code,?,'1'), null ) locn_name, REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','') patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob,  get_age(c.date_of_birth,nvl(c.DECEASED_DATE,sysdate)) age , sex, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date, TO_CHAR (b.discharge_date_time,  'dd/mm/yyyy hh24:mi' ) discharge_date_time, NVL (b.ASSIGN_room_num, '' ) room_num, NVL (b.ASSIGN_bed_num, '' ) bed_num,  NVL (am_get_desc.am_practitioner (b.ATTEND_PRACTITIONER_ID, ?, '2'), '') phy_prov_name, ca_get_patient_curr_status (a.facility_id, a.patient_id, a.encounter_id, b.patient_class, ?,c.deceased_yn ) status, TO_CHAR (a.access_date_time, 'dd/mm/yyyy hh24:mi') access_date_time1, B.patient_class,  b.visit_adm_date_time visit_adm_date1, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy hh24:mi') cls_cons_date, b.priority_zone,OP_GET_DESC.OP_VISIT_TYPE(?,B.VISIT_ADM_TYPE,?,1) visit_type  FROM ca_pat_recent_access_list a, pr_encounter b, mp_patient c , ca_encntr_param D WHERE   a.facility_id =?  and a.appl_user_id = ? and  d.MODULE_ID='CA' AND c.patient_id=a.patient_id  and b.facility_id (+)=a.facility_id  and b.encounter_id(+)=a.encounter_id  AND c.SUSPEND_YN  != 'Y' AND (       (    b.patient_class IN ('IP', 'DC') AND SYSDATE - D.days_backward_visits <= nvl(B.discharge_date_time,sysdate)           and b.adt_status between '01' and '08'  )   OR (    b.patient_class IN  ('OP', 'EM') AND SYSDATE - D.days_backward_visits <=  B.visit_adm_date_time             and B.visit_status in ('01','02','03','04','05','06','07','09')      )   OR b.patient_class  is null     ) ");

// [IN032435] QueryString.append("SELECT a.patient_id, CASE WHEN B.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE ,b.encounter_id episode_id ,b.OP_EPISODE_VISIT_NUM visit_id ,am_get_desc.am_patient_class (b.patient_class, ?, '2') episode_type_desc , am_get_desc.am_service(b.SERVICE_CODE,?,'2') SPECIALITY, DECODE (b.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, b.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, b.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, b.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, b.assign_care_locn_code,?,'1'), null ) locn_name, REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','') patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob, MP_GET_AGE_YMDH(c.date_of_birth,c.DECEASED_DATE) age , sex, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date, TO_CHAR (b.discharge_date_time,  'dd/mm/yyyy hh24:mi' ) discharge_date_time, NVL (b.ASSIGN_room_num, '' ) room_num, NVL (b.ASSIGN_bed_num, '' ) bed_num,  NVL (am_get_desc.am_practitioner (b.ATTEND_PRACTITIONER_ID, ?, '2'), '') phy_prov_name, ca_get_patient_curr_status (a.facility_id, a.patient_id, a.encounter_id, b.patient_class, ?,c.deceased_yn ) status, TO_CHAR (a.access_date_time, 'dd/mm/yyyy hh24:mi') access_date_time1, B.patient_class,  b.visit_adm_date_time visit_adm_date1, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy hh24:mi') cls_cons_date, b.priority_zone,OP_GET_DESC.OP_VISIT_TYPE(?,B.VISIT_ADM_TYPE,?,1) visit_type  FROM ca_pat_recent_access_list a, pr_encounter b, mp_patient c , ca_encntr_param D WHERE   a.facility_id =?  and a.appl_user_id = ? and  d.MODULE_ID='CA' AND c.patient_id=a.patient_id  and b.facility_id (+)=a.facility_id  and b.encounter_id(+)=a.encounter_id  AND c.SUSPEND_YN  != 'Y' AND (       (    b.patient_class IN ('IP', 'DC') AND SYSDATE - D.days_backward_visits <= nvl(B.discharge_date_time,sysdate)           and b.adt_status between '01' and '08'  )   OR (    b.patient_class IN  ('OP', 'EM') AND SYSDATE - D.days_backward_visits <=  B.visit_adm_date_time             and B.visit_status in ('01','02','03','04','05','06','07','09')      )   OR b.patient_class  is null     ) ");

// [IN032437] QueryString.append("SELECT a.patient_id, CASE WHEN B.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE ,b.encounter_id episode_id ,b.OP_EPISODE_VISIT_NUM visit_id ,am_get_desc.am_patient_class (b.patient_class, ?, '2') episode_type_desc , am_get_desc.am_service(b.SERVICE_CODE,?,'2') SPECIALITY, DECODE (b.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, b.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, b.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, b.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, b.assign_care_locn_code,?,'1'), null ) locn_name, REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','') patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob, nvl(MP_GET_AGE_YMDH(c.date_of_birth,c.DECEASED_DATE),get_age(c.date_of_birth,nvl(c.DECEASED_DATE,sysdate))) age , sex, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date, TO_CHAR (b.discharge_date_time,  'dd/mm/yyyy hh24:mi' ) discharge_date_time, NVL (b.ASSIGN_room_num, '' ) room_num, NVL (b.ASSIGN_bed_num, '' ) bed_num,  NVL (am_get_desc.am_practitioner (b.ATTEND_PRACTITIONER_ID, ?, '2'), '') phy_prov_name, ca_get_patient_curr_status (a.facility_id, a.patient_id, a.encounter_id, b.patient_class, ?,c.deceased_yn ) status, TO_CHAR (a.access_date_time, 'dd/mm/yyyy hh24:mi') access_date_time1, B.patient_class,  b.visit_adm_date_time visit_adm_date1, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy hh24:mi') cls_cons_date, b.priority_zone,OP_GET_DESC.OP_VISIT_TYPE(?,B.VISIT_ADM_TYPE,?,1) visit_type  FROM ca_pat_recent_access_list a, pr_encounter b, mp_patient c , ca_encntr_param D WHERE   a.facility_id =?  and a.appl_user_id = ? and  d.MODULE_ID='CA' AND c.patient_id=a.patient_id  and b.facility_id (+)=a.facility_id  and b.encounter_id(+)=a.encounter_id  AND c.SUSPEND_YN  != 'Y' AND (       (    b.patient_class IN ('IP', 'DC') AND SYSDATE - D.days_backward_visits <= nvl(B.discharge_date_time,sysdate)           and b.adt_status between '01' and '08'  )   OR (    b.patient_class IN  ('OP', 'EM') AND SYSDATE - D.days_backward_visits <=  B.visit_adm_date_time             and B.visit_status in ('01','02','03','04','05','06','07','09')      )   OR b.patient_class  is null     ) ");
//QueryString.append("SELECT a.patient_id, CASE WHEN B.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE ,b.encounter_id episode_id ,b.OP_EPISODE_VISIT_NUM visit_id ,am_get_desc.am_patient_class (b.patient_class, ?, '2') episode_type_desc , am_get_desc.am_service(b.SERVICE_CODE,?,'2') SPECIALITY, DECODE (b.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, b.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, b.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, b.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, b.assign_care_locn_code,?,'1'), null ) locn_name, REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','') patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date, TO_CHAR (b.discharge_date_time,  'dd/mm/yyyy hh24:mi' ) discharge_date_time, NVL (b.ASSIGN_room_num, '' ) room_num, NVL (b.ASSIGN_bed_num, '' ) bed_num,  NVL (am_get_desc.am_practitioner (b.ATTEND_PRACTITIONER_ID, ?, '2'), '') phy_prov_name, ca_get_patient_curr_status (a.facility_id, a.patient_id, a.encounter_id, b.patient_class, ?,c.deceased_yn ) status, TO_CHAR (a.access_date_time, 'dd/mm/yyyy hh24:mi') access_date_time1, B.patient_class,  b.visit_adm_date_time visit_adm_date1, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy hh24:mi') cls_cons_date, b.priority_zone,OP_GET_DESC.OP_VISIT_TYPE(?,B.VISIT_ADM_TYPE,?,1) visit_type  FROM ca_pat_recent_access_list a, pr_encounter b, mp_patient c , ca_encntr_param D WHERE   a.facility_id =?  and a.appl_user_id = ? and  d.MODULE_ID='CA' AND c.patient_id=a.patient_id  and b.facility_id (+)=a.facility_id  and b.encounter_id(+)=a.encounter_id  AND c.SUSPEND_YN  != 'Y' AND (       (    b.patient_class IN ('IP', 'DC') AND SYSDATE - D.days_backward_visits <= nvl(B.discharge_date_time,sysdate)           and b.adt_status between '01' and '08'  )   OR (    b.patient_class IN  ('OP', 'EM') AND SYSDATE - D.days_backward_visits <=  B.visit_adm_date_time             and B.visit_status in ('01','02','03','04','05','06','07','09')      )   OR b.patient_class  is null     ) ");//IN037816 Commetted
//QueryString.append("SELECT a.patient_id, CASE WHEN B.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE ,b.encounter_id episode_id ,b.OP_EPISODE_VISIT_NUM visit_id ,am_get_desc.am_patient_class (b.patient_class, ?, '2') episode_type_desc , am_get_desc.am_service(b.SERVICE_CODE,?,'2') SPECIALITY, DECODE (b.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, b.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, b.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, b.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, b.assign_care_locn_code,?,'1'), null ) locn_name, REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','') patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date, TO_CHAR (b.discharge_date_time,  'dd/mm/yyyy hh24:mi' ) discharge_date_time, decode(b.ASSIGN_room_num,'*ALL','',NVL (b.ASSIGN_room_num, '') ) room_num, NVL (b.ASSIGN_bed_num, '' ) bed_num,  NVL (am_get_desc.am_practitioner (b.ATTEND_PRACTITIONER_ID, ?, '2'), '') phy_prov_name, ca_get_patient_curr_status (a.facility_id, a.patient_id, a.encounter_id, b.patient_class, ?,c.deceased_yn ) status, TO_CHAR (a.access_date_time, 'dd/mm/yyyy hh24:mi') access_date_time1, B.patient_class,  b.visit_adm_date_time visit_adm_date1, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy hh24:mi') cls_cons_date, b.priority_zone,OP_GET_DESC.OP_VISIT_TYPE(?,decode( b.patient_class, 'OP',b.visit_adm_type,''),?,1) visit_type  FROM ca_pat_recent_access_list a, pr_encounter b, mp_patient c , ca_encntr_param D WHERE   a.facility_id =?  and a.appl_user_id = ? and  d.MODULE_ID='CA' AND c.patient_id=a.patient_id  and b.facility_id (+)=a.facility_id  and b.encounter_id(+)=a.encounter_id  AND c.SUSPEND_YN  != 'Y' AND (       (    b.patient_class IN ('IP', 'DC') AND SYSDATE - D.days_backward_visits <= nvl(B.discharge_date_time,sysdate)           and b.adt_status between '01' and '08'  )   OR (    b.patient_class IN  ('OP', 'EM') AND SYSDATE - D.days_backward_visits <=  B.visit_adm_date_time             and B.visit_status in ('01','02','03','04','05','06','07','09')      )   OR b.patient_class  is null     ) ");//IN037816//Added decode to assign_room_num
//QueryString.append("SELECT a.patient_id, CASE WHEN B.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE ,b.encounter_id episode_id ,b.OP_EPISODE_VISIT_NUM visit_id ,am_get_desc.am_patient_class (b.patient_class, ?, '2') episode_type_desc , am_get_desc.am_service(b.SERVICE_CODE,?,'2') SPECIALITY, DECODE (b.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, b.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, b.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, b.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, b.assign_care_locn_code,?,'1'), null ) locn_name, REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','') patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date, TO_CHAR (b.discharge_date_time,  'dd/mm/yyyy hh24:mi' ) discharge_date_time, decode(b.ASSIGN_room_num,'*ALL','',NVL (b.ASSIGN_room_num, '') ) room_num, NVL (b.ASSIGN_bed_num, '' ) bed_num,  NVL (am_get_desc.am_practitioner (b.ATTEND_PRACTITIONER_ID, ?, '2'), '') phy_prov_name, ca_get_patient_curr_status (a.facility_id, a.patient_id, a.encounter_id, b.patient_class, ?,c.deceased_yn ) status, TO_CHAR (a.access_date_time, 'dd/mm/yyyy hh24:mi') access_date_time1, B.patient_class,  b.visit_adm_date_time visit_adm_date1, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy hh24:mi') cls_cons_date, b.priority_zone,OP_GET_DESC.OP_VISIT_TYPE(?,decode( b.patient_class, 'OP',b.visit_adm_type,''),?,1) visit_type,ca_ae_get_priority_zone_color(b.priority_zone,'en') ae_zone_color,b.ATTEND_PRACTITIONER_ID, oa_appt_virtual_status(b.facility_id,b.patient_id,b.encounter_id,b.patient_class) virtualApptYN FROM ca_pat_recent_access_list a, pr_encounter b, mp_patient c , ca_encntr_param D WHERE   a.facility_id =?  and a.appl_user_id = ? and  d.MODULE_ID='CA' AND c.patient_id=a.patient_id  and b.facility_id (+)=a.facility_id  and b.encounter_id(+)=a.encounter_id  AND c.SUSPEND_YN  != 'Y' AND (       (    b.patient_class IN ('IP', 'DC') AND SYSDATE - D.days_backward_visits <= nvl(B.discharge_date_time,sysdate)           and b.adt_status between '01' and '08'  )   OR (    b.patient_class IN  ('OP', 'EM') AND SYSDATE - D.days_backward_visits <=  B.visit_adm_date_time             and B.visit_status in ('01','02','03','04','05','06','07','09')      )   OR b.patient_class  is null     ) ");//IN044157//32902
QueryString.append("SELECT a.patient_id, CASE WHEN B.PATIENT_CLASS IN ('IP','DC') THEN 'I' ELSE 'O' END EPISODE_TYPE ,b.encounter_id episode_id ,b.OP_EPISODE_VISIT_NUM visit_id ,am_get_desc.am_patient_class (b.patient_class, ?, '2') episode_type_desc , am_get_desc.am_service(b.SERVICE_CODE,?,'2') SPECIALITY, DECODE (b.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, b.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, b.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, b.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, b.assign_care_locn_code,?,'1'), null ) locn_name, REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','') patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob, CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex, TO_CHAR (b.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date, TO_CHAR (b.discharge_date_time,  'dd/mm/yyyy hh24:mi' ) discharge_date_time, decode(b.ASSIGN_room_num,'*ALL','',NVL (b.ASSIGN_room_num, '') ) room_num, NVL (b.ASSIGN_bed_num, '' ) bed_num,  NVL (am_get_desc.am_practitioner (b.ATTEND_PRACTITIONER_ID, ?, '2'), '') phy_prov_name, ca_get_patient_curr_status (a.facility_id, a.patient_id, a.encounter_id, b.patient_class, ?,c.deceased_yn ) status, TO_CHAR (a.access_date_time, 'dd/mm/yyyy hh24:mi') access_date_time1, B.patient_class,  b.visit_adm_date_time visit_adm_date1, TO_CHAR (b.discharge_date_time, 'dd/mm/yyyy hh24:mi') cls_cons_date, b.priority_zone,OP_GET_DESC.OP_VISIT_TYPE(?,decode( b.patient_class, 'OP',b.visit_adm_type,''),?,1) visit_type,ca_ae_get_priority_zone_color(b.priority_zone,'en') ae_zone_color,b.ATTEND_PRACTITIONER_ID, oa_appt_virtual_status(b.facility_id,b.patient_id,b.encounter_id,b.patient_class) virtualApptYN,c.restrict_reinstate_yn FROM ca_pat_recent_access_list a, pr_encounter b, mp_patient c , ca_encntr_param D WHERE   a.facility_id =?  and a.appl_user_id = ? and  d.MODULE_ID='CA' AND c.patient_id=a.patient_id  and b.facility_id (+)=a.facility_id AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,a.patient_id,a.facility_id ) and b.encounter_id(+)=a.encounter_id  AND c.SUSPEND_YN  != 'Y' AND (       (    b.patient_class IN ('IP', 'DC') AND SYSDATE - D.days_backward_visits <= nvl(B.discharge_date_time,sysdate)           and b.adt_status between '01' and '08'  )   OR (    b.patient_class IN  ('OP', 'EM') AND SYSDATE - D.days_backward_visits <=  B.visit_adm_date_time             and B.visit_status in ('01','02','03','04','05','06','07','09')      )   OR b.patient_class  is null     ) ");//32902

	
String desc="";
if(reOrder.equals("2"))
	desc=" desc";
if(orderBy.equals("PC"))
	QueryString.append(" Order By episode_type_desc"+desc);
else if(orderBy.equals("LOC"))
	QueryString.append(" Order By locn_name"+desc);
else if(orderBy.equals("PN"))
	QueryString.append(" Order By patient_name"+desc);
else if(orderBy.equals("DOB"))
	QueryString.append(" Order By date_of_birth"+desc);
else if(orderBy.equals("AGE"))
{
	if(reOrder.equals("1"))
	{
		QueryString.append(" Order By date_of_birth desc");


	}
	else
		QueryString.append(" Order By date_of_birth");
}
else if(orderBy.equals("SEX"))
	QueryString.append(" Order By sex"+desc);
else if(orderBy.equals("PID"))
	QueryString.append("Order By patient_id"+desc);
else if(orderBy.equals("VD"))
	QueryString.append(" Order By visit_adm_date1"+desc);
else if(orderBy.equals("VT"))
	QueryString.append(" Order By visit_type"+desc);
else if(orderBy.equals("RN"))
	QueryString.append(" Order By room_num"+desc);
else if(orderBy.equals("BN"))
	QueryString.append(" Order By bed_num"+desc);
else if(orderBy.equals("AP"))
	QueryString.append(" Order By phy_prov_name"+desc);
else if(orderBy.equals("AAT"))
	QueryString.append(" Order By access_date_time"+desc);
else if(orderBy.equals("MS"))
	QueryString.append(" Order By speciality"+desc);
else if(orderBy.equals("DD"))
{
	QueryString.append(" Order By b.discharge_date_time"+desc);
}
else
	QueryString.append( " Order By access_date_time desc");


            _bw.write(_wl_block9Bytes, _wl_block9);

//IN044157 - Start
	String AEZone5 = "N";
	PreparedStatement stmtAE = con.prepareStatement("Select FIVE_LEVEL_TRIAGE_APPL_YN from AE_PARAM where OPERATING_FACILITY_ID=?");
	ResultSet rsAE = null;
	stmtAE.setString(1,facility_id);
	rsAE = stmtAE.executeQuery();
	while(rsAE.next()){
		AEZone5 = rsAE.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
	}
	if(stmtAE!=null)stmtAE.close();
	if(rsAE!=null)rsAE.close();
//IN044157 - End
pstmt = con.prepareStatement(QueryString.toString());
pstmt.setString(1,locale);
pstmt.setString(2,locale);
pstmt.setString(3,locale);
pstmt.setString(4,locale);
pstmt.setString(5,locale);
pstmt.setString(6,locale);
pstmt.setString(7,locale);
pstmt.setString(8,locale);
pstmt.setString(9,clinicianId);
pstmt.setString(10,facility_id);
pstmt.setString(11,locale);
pstmt.setString(12,facility_id);
pstmt.setString(13,userId);
pstmt.setString(14,clinicianId);
/*pstmt.setString(10,clinicianId);
pstmt.setString(11,locale);
pstmt.setString(12,userId);
pstmt.setString(13,facility_id); */



ResultSet rsPatList = null;
PreparedStatement stmtMotherLink =null;
ResultSet rsMotherLink = null;

String sqlMotherLink = "select    a.patient_id pat_id , replace(replace(decode(?,'en',B.PATIENT_NAME,nvl(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)),'''',''),'''','') short_name , to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth  , to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH  , a.WEIGHT  , a.WEIGHT_UNIT  , a.LENGTH||' cms'  LENGTH_OF_BABY  , a.CIRCUMFERENCE||' cms'  CIRCUMFERENCE_OF_HEAD  , a.APGAR_SCORE  , b.sex  from  mp_birth_register a  ,mp_patient b  where  b.patient_id=a.patient_id  ";
try
{
	int k=0;
	int i=0;
	String rowclass = "";
	rsPatList = pstmt.executeQuery(); 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AccessedAt.label","ca_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);

		//37866 Start.
		if(isVirtualConsSiteSpec){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ConsultationType.label","ca_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
		//37866 End.
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitAdmDate.label","common_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.VisitAdmEndDate.label","ca_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MedicalService.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
	while(rsPatList.next()) 
	{
		if (k % 2 == 0 )
			rowclass = "gridData";
		else
			rowclass = "gridData";
		// color coding
		String status = rsPatList.getString("status");
		String emergencyYn = "";
		String deceasedYn = "";
		int noofchildren = 0;
		String relationYn = "";
		String className = rowclass;
		String className1 = rowclass;
		String text = "&nbsp;&nbsp;&nbsp;";
		String disp_cls_cons_date ="&nbsp;";
		String tempDischargeDate = "";
		String emg_zome_color = ""; //IN044157
		//sex_desc = rsPatList.getString("sex_desc");
		sex_desc = rsPatList.getString("sex");
		if(sex_desc.equals("MALE"))
			{
				sex_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			}
		else if(sex_desc.equals("FEMALE"))
			{
			sex_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			}
		else if(sex_desc.equals("UNKNOWN"))
			{
			sex_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}

		StringTokenizer st = new StringTokenizer(status,"|");
		
		while (st.hasMoreTokens())
		{
			emergencyYn = st.nextToken();
			deceasedYn = st.nextToken();
			String n = st.nextToken();
			if(!(n == null || n.equals("")))
				noofchildren = Integer.parseInt(n);
			relationYn = st.nextToken();
		}

		tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");
		
					
		String decesedColor="";
		if(deceasedYn.equals("D"))
		{
			rowclass = "DECEASED1";
			decesedColor="";
			className="CADECEASED";
		}else if(deceasedYn.equals("S")){
			rowclass = "GRAY";
			decesedColor="yellow";
		}else{
			decesedColor="";
		}
		
		if (!deceasedYn.equals("D"))
		{	
			if(!tempDischargeDate.equals("")) className = "DISCHARGED";
            else if((noofchildren > 0)) className = "NEWBORN";
		}
		emergencyYn=rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
		//IN044157 - Start
		if(AEZone5.equals("Y")){
		if(!emergencyYn.equals(""))
			className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");			
		}else{
		if(emergencyYn.equals("R")) 
			className1 = "RED";
		if(emergencyYn.equals("Y")) 
			className1 = "YELLOW";
		if(emergencyYn.equals("G")) 
			className1 = "GREEN";}
		//IN044157 - End
		if(relnreqyn.equals("Y"))
		{
			if(relationYn.equals("N")) 	
				text = "<font size=2><b>*</b></font>";
		}


	// color coding ends
	disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
	if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
		disp_cls_cons_date="&nbsp;";

	if(!disp_cls_cons_date.equals("&nbsp;"))
		disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);


	StringBuffer layer = new StringBuffer();
	layer.append("");
	if(rsPatList.getString("episode_type").equals("I"))
	{
		if(noofchildren > 0)
		{
			//String sqlMotherLink_query1 = sqlMotherLink + " and a.mother_patient_id=? and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by TIME_OF_BIRTH ";
			String sqlMotherLink_query1 = sqlMotherLink + " and a.mother_patient_id=? and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by pat_id asc "; //Modified --[IN029180]
			stmtMotherLink = con.prepareStatement(sqlMotherLink_query1);
			stmtMotherLink.setString(1,locale);
			stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
			stmtMotherLink.setString(3,facility_id);
			stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));

			rsMotherLink = stmtMotherLink.executeQuery();
			while(rsMotherLink.next())
			{
				if(locale.equals("en"))
	                 {
		                dateofbirth1=rsMotherLink.getString("date_of_birth");
	                 }
	                else
	                {
		               dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
	                }
				apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
				layer.append("<tr><td class=gridData nowrap>"+rsMotherLink.getString("pat_id")+"</td>"+
					"<td class=gridData>"+rsMotherLink.getString("short_name")+"</td>"+
					"<td class=gridData>"+rsMotherLink.getString("sex")+"</td>"+
					"<td class=gridData>"+dateofbirth1+"</td>"+
					"<td class=gridData>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</td>"+
					"<td class=gridData>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</td>"+
					"<td class=gridData>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</td>"+
					"<td class=gridData>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</td>"+
					"<td class=gridData>"+apgar_score+"</td></tr>");
			}

			if(rsMotherLink != null) rsMotherLink.close();
			if(stmtMotherLink != null ) stmtMotherLink.close();
			
		}
	}
	if(locale.equals("en"))
	{
		DateofBirth=rsPatList.getString("DOB");
	}
	else
	{
		DateofBirth=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale);
	}

	speciality=rsPatList.getString("SPECIALITY"); //commented shaiju
	
	 restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
	if(speciality == null) 
		speciality="&nbsp;";
	out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
		//IN044157 - Start Modified
		out.println("<tr>");
		if(!emergencyYn.equals(""))
			out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt; width='3%'>&nbsp;&nbsp;&nbsp;</td>");
		else
			out.println("<td class="+className1+" width='3%'>&nbsp;&nbsp;&nbsp;</td>");
		//IN044157 - End Modified	
		out.println("<td  onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='3%' class='"+className+"'><b>"+text+"</td><td id='rta"+i+"' class='gridData' nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("access_date_time1"),"DMYHM","en",locale)+"</td><td id='rtb"+i+"' class='gridData' nowrap>"+(rsPatList.getString("episode_type_desc")==null?"&nbsp;":rsPatList.getString("episode_type_desc"))+"</td><td id='rtc"+i+"' class='gridData' nowrap>"+(rsPatList.getString("LOCN_NAME")==null?"&nbsp;":rsPatList.getString("LOCN_NAME"))+"</td><td  onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" id='rtd"+i+"' class='gridData' nowrap><a class='gridLink' href=\"javascript:patClick('"+i+"');patClick_('"+i+"');\" name='patName'><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></td>");
		//37866 Start.
		if(isVirtualConsSiteSpec && ("OP".equals(rsPatList.getString("patient_class"))) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
			out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
		}else if(isVirtualConsSiteSpec){
			out.println("<td id='rtct"+i+"' class='gridData' nowrap>&nbsp;</td>");	
		}
		//37866 End.
		out.println("<td id='rte"+i+"' class='gridData' nowrap>"+DateofBirth+"</td><td id='rtf"+i+"' class='gridData' nowrap>"+rsPatList.getString("AGE")+"</td><td id='rtg"+i+"' class='gridData' nowrap>"+sex_desc+"</td><td id='rth"+i+"' class='gridData' nowrap>"+rsPatList.getString("PATIENT_ID")+"</td><td id='rti"+i+"' class='gridData' nowrap>"+(rsPatList.getString("visit_type")==null?"":rsPatList.getString("visit_type"))+"</td><td id='rtj"+i+"'class='gridData' nowrap>"+(rsPatList.getString("VISIT_ADM_DATE")==null?"&nbsp;":com.ehis.util.DateUtils.convertDate(rsPatList.getString("VISIT_ADM_DATE"),"DMYHM","en",locale))+"</td>"+
		"<td id='rtk"+i+"' class='gridData' nowrap>"+disp_cls_cons_date+"</td>"+
		"<td id='rtl"+i+"' class='gridData' nowrap>"+(rsPatList.getString("ROOM_NUM")==null?"&nbsp;":rsPatList.getString("ROOM_NUM"))+"</td><td id='rtm"+i+"' class='gridData' nowrap>"+(rsPatList.getString("BED_NUM")==null?"&nbsp;":rsPatList.getString("BED_NUM"))+"</td><td id='rtn"+i+"' class='gridData' nowrap>"+(rsPatList.getString("PHY_PROV_NAME")==null?"&nbsp;":rsPatList.getString("PHY_PROV_NAME"))+"</td><td id='rto"+i+"' class='gridData' nowrap>"+speciality+"</td></tr>");
		out.println("<script language='javascript'>");
		out.println("patIdArr["+i+"]='"+rsPatList.getString("patient_id")+"';");
		out.println("episodeIdArr["+i+"]='"+(rsPatList.getString("EPISODE_ID")==null?"":rsPatList.getString("EPISODE_ID"))+"';");
		out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
		out.println("</script>");
		out.println("<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>");
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block32Bytes, _wl_block32);
 
		i++;
		k++;
	}
}
catch(Exception e)
{
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally 
{
	if(pstmt!=null) pstmt.close();
	if(rsPatList!=null) rsPatList.close();
	if(mo_install_yn_stmt!=null) mo_install_yn_stmt.close();
	if(mo_install_yn_rs!=null) mo_install_yn_rs.close();
	//if(con!=null)ConnectionManager.returnConnection(con,request);  //Commented for ICN060314 
	if(con!=null)con.close();										//Add for ICN060314
}
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(relnreqyn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromNewFunction));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block37Bytes, _wl_block37);
if(!anchorID.equals("")){
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
