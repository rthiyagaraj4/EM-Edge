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
import java.util.*;
import eCA.CAOpenChartServlet;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __personalisepatlistdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PersonalisePatListDetails.jsp", 1738757939840L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n<html>\n   ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n   <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n    <script language=\'javascript\' src=\'../../eCA/js/PersonalisePatListDetails.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script>\n\n\t//function ShowPats(pat_name,pat_id,age,gender,queryStringForChart,prac_id) //32902\n\tasync function ShowPats(pat_name,pat_id,age,gender,queryStringForChart,prac_id,ind)  //32902\n\t\t{\t\n\t\t\t//Start.32902\n\t\t\tvar restPatientYN=document.getElementById(\"restPatientYN\"+ind).value; \n\t\t\tvar accessRightsViewPatient=document.getElementById(\"accessRightsViewPatient\").value; \n\t\t\tif(pat_id !==\"\" && restPatientYN ==\"Y\" && accessRightsViewPatient==0)\n\t\t\t{\n\t\t\t  \trestrictOpenVIPPat(pat_id,restPatientYN,accessRightsViewPatient);\n\t\t\t  \treturn;\n\t\t\t}\n\t\t\t//end. 32902\n\t\t\t\tvar dialogHeight= \"200px\" ;\n\t\t\t\tvar dialogWidth = \"700px\" ;\n\t\t\t\tvar dialogTop = \"117\" ;\n\t\t\t\tvar dialogLeft = \"50\" ;\n\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";dialogTop:\"+dialogTop+\";dialogLeft:\"+dialogLeft+\";status=no;scroll=yes;\";\n\t\t\t\tretVal = await window.showModalDialog(\"ShowPersonalisePatients.jsp?queryStringForChart=\"+queryStringForChart+\"&patientName=\"+pat_name+\"&patientID=\"+pat_id+\"&Age=\"+age+\"&Gender=\"+gender+\"&pracID=\"+prac_id,\"\",features);\n\t\t}\n\t</script>\n    <head>\n    </head>\n    <body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<style>\n.gridDataSelectNew\n{\n\tbackground-color: #CDE5FF;\n\tfont-family: Verdana;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:center;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tvertical-align:middle;\t\n} \n.gridData\n{\n\tbackground-color: #FFFFFF;\n\theight:18px;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:center;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tvertical-align:middle;\n\tborder-bottom:1px;\n\tborder-top:0px;\n\tborder-left:0px;\n\tborder-right:0px;\n\tborder-style:solid;\n\tborder-color:#EEEEEE;\n}\n</style>\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\nfunction patClick_(id){\n\tfor(var i=0;i<patIdArr.length;i++){\n\t\tif(i==id){\n\t\t\tdocument.getElementById(\'rtz\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rty\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rta\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtb\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtc\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtd\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rte\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtf\'+i).className=\'gridDataSelectNew\';\n\t\t\tdocument.getElementById(\'rtg\'+i).className=\'gridDataSelectNew\';\n\t\t\t\n\t\t}else{\n\t\t\tdocument.getElementById(\'rtz\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rty\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rta\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtb\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtc\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtd\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rte\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtf\'+i).className=\'gridData\';\n\t\t\tdocument.getElementById(\'rtg\'+i).className=\'gridData\';\n\t\t}\n\t}\n}\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'PatCriteriaFrm\' id=\'PatCriteriaFrm\' action=\'OpenChartWrapper.jsp\' method = \'post\' target=\'messageFrame\'>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<table class=\'grid\' id=\'PatCriteriaTbl\' width=\'100%\' >\n\t<tr>\n\t\t<th class=\'columnHeadercenter\' width=\'3%\'>&nbsp;</th>\t\t\n\t\t<th class=\'columnHeadercenter\' width=\'3%\'><input type=\"checkbox\" id=\'a001\'  name=\'select_all\' id=\'select_all\' onclick=\'selectallpat();\'></th>\t\t\n\t\t<th class=\'columnHeadercenter\' nowrap  >\n\t\t\t<a  id=\'a1\' style=\'color:white\' href=\"javascript:callForOrderBy(\'AAT\');\" onclick=\'changeColor(this);\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'   nowrap>\n\t\t\t<a id=\'a2\'  style=\'color:white\'   href=\"javascript:callForOrderBy(\'PN\');\" onclick=\'changeColor(this);\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a3\' style=\'color:white\'     href=\"javascript:callForOrderBy(\'DOB\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a4\' style=\'color:white\'     href=\"javascript:callForOrderBy(\'AGE\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a5\' style=\'color:white\'    href=\"javascript:callForOrderBy(\'SEX\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n\t\t</th>\t\t\n\t\t<th class=\'columnHeadercenter\'  nowrap  >\n\t\t\t<a id=\'a6\'  style=\'color:white\'   href=\"javascript:callForOrderBy(\'PID\');\" onclick=\'changeColor(this);\'  >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a>\n\t\t</th>\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<script language=\'javascript\' src=\'../../eCA/js/CACommon.js\'></script> <!-- 32902 -->\n<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  name=\"restPatientYN";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'><!-- 32902  --> \n<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'><!-- 32902  --> \n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n        </table>\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"insert_op\" id=\"insert_op\" value=\"N\">\n        <input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\'hidden\' name=\'rec_count\' id=\'rec_count\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'\'>\n\t    <input type=\'hidden\' name=\'delPatList\' id=\'delPatList\' value=\"\">\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\'hidden\' name=\'login_id\' id=\'login_id\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=\'hidden\' name=\'system_id\' id=\'system_id\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\n\t\t\n        </form>\n\t\t<form name=\'PatSearchFrm\' id=\'PatSearchFrm\' action=\'OpenChartWrapper.jsp\' method = \'post\' target=messageFrame>\n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'>\n\t\t<input type=\'hidden\' name=\'episode_visit_id\' id=\'episode_visit_id\'>\n\t\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\'>\n\t    <input type=\'hidden\' name=\'from_function\' id=\'from_function\' value=\'M\'>\n\t\t<input type=\'hidden\' name=\'from_date_time\' id=\'from_date_time\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t    <input type=\'hidden\' name=\'to_date_time\' id=\'to_date_time\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type=\'hidden\' name=\'active_flg\' id=\'active_flg\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\n\t\n\t\n</form>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'!=\'\')\n\t\t\t{\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'==\'1\')\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"PatCriteriaTbl\").all.";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =".style.color=\'pink\';\n\t\t\t\t}\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'==\'2\')\n\t\t\t\t\tdocument.getElementById(\"PatCriteriaTbl\").all.";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =".style.color=\'yellow\';\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n    </body>\n</html>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );
	
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
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
27/07/2017		IN061891	Raja S		27/07/2017		Ramesh G		ML-MMOH-CRF-0543 
11/24/2023   32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);


	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String queryStringForChart		=	request.getQueryString() == null ? "" : request.getQueryString();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con =null;
PreparedStatement pstmt = null;
int recCount = 0;

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String client_ip_address = p.getProperty("client_ip_address");
con = ConnectionManager.getConnection(request);

HttpSession thisSession = request.getSession(false);
String facility_id  =  (String) thisSession.getValue("facility_id") ;
String userId=(String) session.getValue("login_user");
String clinicianId=(String) session.getValue("ca_practitioner_id");
StringBuffer QueryString=new StringBuffer();

String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
String sex_desc = "";
String DateofBirth = "";
String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
String from_date_time1 = request.getParameter("from_date_time")==null?"":request.getParameter("from_date_time");
String to_date_time1 = request.getParameter("to_date_time")==null?"":request.getParameter("to_date_time");
String active_flg = request.getParameter("active_flg")==null?"":request.getParameter("active_flg");
//32902 start
String restPatientYN	=	"";
String ca_bean_id 						= "@CACommonGetPatientDtlBean";
String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
CACommonGetPatientDtlBean bean1			= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
int accessRightsViewPatient=0;
accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
//32902 end

from_date_time1		= com.ehis.util.DateUtils.convertDate(from_date_time1,"DMYHM",locale,"en");
to_date_time1		= com.ehis.util.DateUtils.convertDate(to_date_time1,"DMYHM",locale,"en");

if("A".equals(active_flg))
//QueryString.append("select  distinct a.patient_id,REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','')      patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob,c.date_of_birth,CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex,  TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE from ca_pat_personalise_list a, pr_encounter b, mp_patient c WHERE   a.facility_id =? and a.PRACTITIONER_ID = ? AND c.patient_id=a.patient_id and b.patient_id(+)=a.patient_id and b.facility_id (+)=a.facility_id AND c.SUSPEND_YN  != 'Y' AND b.ATTEND_PRACTITIONER_ID =? AND ( (b.patient_class IN ('IP', 'DC') and b.adt_status between '01'and '07') OR ( b.patient_class IN  ('OP', 'EM') and B.visit_status in ('01','02','03','04','05','06','09'))) AND C.DECEASED_YN!='Y' "); //IN064743 //32902
QueryString.append("select  distinct a.patient_id,REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','')      patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob,c.date_of_birth,CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex,  TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE,c.restrict_reinstate_yn from ca_pat_personalise_list a, pr_encounter b, mp_patient c WHERE   a.facility_id =? and a.PRACTITIONER_ID = ? AND c.patient_id=a.patient_id and b.patient_id(+)=a.patient_id and b.facility_id (+)=a.facility_id AND c.SUSPEND_YN  != 'Y' AND b.ATTEND_PRACTITIONER_ID =? AND ( (b.patient_class IN ('IP', 'DC') and b.adt_status between '01'and '07') OR ( b.patient_class IN  ('OP', 'EM') and B.visit_status in ('01','02','03','04','05','06','09'))) AND C.DECEASED_YN!='Y' "); //32902
else
//QueryString.append("select distinct  a.patient_id,REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','')      patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob,c.date_of_birth,CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex,  TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE from ca_pat_personalise_list a, pr_encounter b, mp_patient c WHERE   a.facility_id =? and a.PRACTITIONER_ID = ? AND c.patient_id=a.patient_id and b.patient_id(+)=a.patient_id and b.facility_id (+)=a.facility_id AND c.SUSPEND_YN  != 'Y' AND b.ATTEND_PRACTITIONER_ID =? AND  ( (b.patient_class IN ('IP', 'DC') and b.adt_status not between '01'and '07') OR ( b.patient_class IN  ('OP', 'EM') and B.visit_status not in ('01','02','03','04','05','06','09')))  AND C.DECEASED_YN!='Y' AND NOT EXISTS ( select pr.patient_id from ca_pat_personalise_list cp, pr_encounter pr WHERE   pr.facility_id =a.facility_id and pr.patient_id=a.patient_id AND pr.patient_id(+)=cp.patient_id and pr.facility_id (+)=cp.facility_id and pr.ATTEND_PRACTITIONER_ID = a.practitioner_id AND ((pr.patient_class IN ('IP', 'DC') and pr.adt_status between '01'and '07') OR (pr.patient_class IN ('OP','EM') and pr.visit_status  in ('01','02','03','04','05','06','09')))) "); //IN064743 //32902
QueryString.append("select distinct  a.patient_id,REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','')      patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob,c.date_of_birth,CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex,  TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE,c.restrict_reinstate_yn from ca_pat_personalise_list a, pr_encounter b, mp_patient c WHERE   a.facility_id =? and a.PRACTITIONER_ID = ? AND c.patient_id=a.patient_id and b.patient_id(+)=a.patient_id and b.facility_id (+)=a.facility_id AND c.SUSPEND_YN  != 'Y' AND b.ATTEND_PRACTITIONER_ID =? AND  ( (b.patient_class IN ('IP', 'DC') and b.adt_status not between '01'and '07') OR ( b.patient_class IN  ('OP', 'EM') and B.visit_status not in ('01','02','03','04','05','06','09')))  AND C.DECEASED_YN!='Y' AND NOT EXISTS ( select pr.patient_id from ca_pat_personalise_list cp, pr_encounter pr WHERE   pr.facility_id =a.facility_id and pr.patient_id=a.patient_id AND pr.patient_id(+)=cp.patient_id and pr.facility_id (+)=cp.facility_id and pr.ATTEND_PRACTITIONER_ID = a.practitioner_id AND ((pr.patient_class IN ('IP', 'DC') and pr.adt_status between '01'and '07') OR (pr.patient_class IN ('OP','EM') and pr.visit_status  in ('01','02','03','04','05','06','09')))) "); //32902

		if(!(from_date_time1.equals("")))
			QueryString.append(" 	and a.ADDED_DATE >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");
		if(!(to_date_time1.equals("")))
			QueryString.append(" 	and a.ADDED_DATE <= to_date( ?,'dd/mm/yyyy hh24:mi' )+0.00068287 ");
		QueryString.append("AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,a.patient_id,a.facility_id)");  //32902
String desc="";
if(reOrder.equals("2"))
	desc=" desc";
if(orderBy.equals("PN"))
	QueryString.append(" Order By patient_name"+desc);
else if(orderBy.equals("DOB"))
	QueryString.append(" Order By date_of_birth"+desc); //IN064743
else if(orderBy.equals("AGE"))
{
	if(reOrder.equals("1"))
	{
		QueryString.append(" Order By date_of_birth desc"); //IN064743


	}
	else
		QueryString.append(" Order By date_of_birth"); //IN064743
}
else if(orderBy.equals("SEX"))
	QueryString.append(" Order By sex"+desc);
else if(orderBy.equals("PID"))
	QueryString.append("Order By patient_id"+desc);
else if(orderBy.equals("AAT"))
	QueryString.append(" Order By ADDED_DATE"+desc);
else
	QueryString.append( " Order By ADDED_DATE desc");


            _bw.write(_wl_block8Bytes, _wl_block8);

pstmt = con.prepareStatement(QueryString.toString());
int colIndex=1;
pstmt.setString(colIndex++,locale);

pstmt.setString(colIndex++,facility_id);
pstmt.setString(colIndex++,clinicianId);
pstmt.setString(colIndex++,clinicianId);
if(!(from_date_time1.equals("")))
	pstmt.setString	(colIndex++,	from_date_time1	);
			
if(!(to_date_time1.equals("")))
	pstmt.setString	(colIndex++,	to_date_time1	);

pstmt.setString	(colIndex++,clinicianId);  //32902

ResultSet rsPatList = null;

try
{
	int k=0;
	int i=0;

	rsPatList = pstmt.executeQuery(); 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddedAt.label","ca_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
	while(rsPatList.next()) 
	{
		recCount++;
		sex_desc = rsPatList.getString("sex");
		restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
		if(sex_desc.equals("M"))
			{
				sex_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			}
		else if(sex_desc.equals("F"))
			{
			sex_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			}
		else if(sex_desc.equals("U"))
			{
			sex_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}

		if(locale.equals("en"))
		{
			DateofBirth=rsPatList.getString("DOB");
		}
		else
		{
			DateofBirth=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale);
		}

		out.println("<tr>");
		out.println("<td class='gridData' width='3%' id='rtz"+i+"' style='text-align: center'>&nbsp;</td>");
		out.println("<td class='gridData' width='3%' id='rty"+i+"' style='text-align: center'><input type='checkbox' name='rta"+i+"' id='rta"+i+"' id='rta"+i+"'></td><td id='rtb"+i+"' class='gridData' nowrap style='text-align: center'>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADDED_DATE"),"DMYHM","en",locale)+"</td><td  id='rtc"+i+"' class='gridData' nowrap style='text-align: center'>");
		if("A".equals(active_flg))
		//out.println("<a class='gridLink' href=\"javascript:ShowPats('"+rsPatList.getString("PATIENT_NAME")+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("AGE")+"','"+sex_desc+"','"+queryStringForChart+"','"+clinicianId+"');patClick_('"+i+"');\" name='patName'>"+rsPatList.getString("PATIENT_NAME")+"</a>");  //32902
		out.println("<a class='gridLink' href=\"javascript:ShowPats('"+rsPatList.getString("PATIENT_NAME")+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("AGE")+"','"+sex_desc+"','"+queryStringForChart+"','"+clinicianId+"','"+i+"');patClick_('"+i+"');\" name='patName'>"+rsPatList.getString("PATIENT_NAME")+"</a>"); //32902
		else
		out.println(rsPatList.getString("PATIENT_NAME"));
		out.println("</td><td id='rtd"+i+"' class='gridData' nowrap style='text-align: center'>"+DateofBirth+"</td><td id='rte"+i+"' class='gridData' nowrap style='text-align: center'>"+rsPatList.getString("AGE")+"</td><td id='rtf"+i+"' class='gridData' nowrap style='text-align: center'>"+sex_desc+"</td><td id='rtg"+i+"' class='gridData' nowrap style='text-align: center'>"+rsPatList.getString("PATIENT_ID")+"</td></tr>");
		out.println("<input type='hidden' name='rtp"+i+"' id='rtp"+i+"' id='rtp"+i+"' value='"+rsPatList.getString("PATIENT_ID")+"'> ");
		out.println("<script language='javascript'>");
		out.println("patIdArr["+i+"]='"+rsPatList.getString("patient_id")+"';");
		out.println("</script>");
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block20Bytes, _wl_block20);

		i++;
		k++;
	}
	if(recCount==0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");



}
catch(Exception e)
{
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally 
{
	if(pstmt!=null) pstmt.close();
	if(rsPatList!=null) rsPatList.close();
	if(con!=null)con.close();										
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(userId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(clinicianId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(client_ip_address));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(from_date_time1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(to_date_time1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(active_flg));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(!anchorID.equals("")){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
