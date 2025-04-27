package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCA.PatTaskListRepository;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __pattasklistresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatTaskListResult.jsp", 1736916113463L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../html/CAPatTaskList.css\">  -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCA/js/PatTaskList.js\"></script>\n\t<style>\n\t\tTD.PLANSUBHEAD\n\t\t{\n\t\t\tFONT-SIZE: 9pt;\n\t\t\tBORDER-LEFT-COLOR: white;\n\t\t\tBORDER-BOTTOM-COLOR: white;\n\t\t\tBORDER-TOP-STYLE: solid;\n\t\t\tBORDER-TOP-COLOR: white;\n\t\t\tBORDER-RIGHT-STYLE: solid;\n\t\t\tBORDER-LEFT-STYLE: solid;\n\t\t\tHEIGHT: 18px;\t\t\t\n\t\t\tBORDER-RIGHT-COLOR: white;\n\t\t\tBORDER-BOTTOM-STYLE: solid\n\t\t}\n\t\t A:link\n\t\t{\n\t\t\tCOLOR: yellow\n\t\t}\n\t\tA:visited\n\t\t{\n\t\t\tCOLOR: yellow\n\t\t} \n\t</style>\n\t<script>\n\tvar child = null;\n\tfunction loadpage()\n\t{\n\t\tif (child != null)\n\t\t{\n\t\t\tif(child.closed == false)\n\t\t\t{\n\t\t\t\tchild.focus();\n\t\t\t\twindow.onblur = loadpage;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tSearchTaskCriteria1(\'flagString\');\n\t\t\t}\n\t\t}\n\t}\n\tfunction newWindow(action_url,arguments,features)\n\t{\n\t\tchild =\twindow.open(action_url,arguments,features);\n\t\tchild.onblur = loadpage;\n\t}\n</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" OnScroll=\"scrollTitle()\" onfocus=\"loadpage()\">\n\n<script language=\'javascript\'>\n\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<form name=\'patTaskListResultForm\' id=\'patTaskListResultForm\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<table border=\"1\" cellpadding=\'3\' cellspacing=\'0\'   id=\'tableId\' width=\"100%\" align=\'center\'>\n\t\t\t\t\t<tr id=\'divTitleTable\' border=\'0\'>\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' border=\'0\'></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' border=\'0\' width=\'2%\'></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' border=\'0\' width=\'2%\'></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' border=\'0\' width=\'2%\'></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' nowrap id=\'thDateId\' border=\'0\'>\n\t\t\t\t\t\t\t<a href=\'javascript:\' OnClick=\'sortRecord(\"Date\",this)\' id=\'anchorDateId\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' id=\'thTaskType\' width=\'15%\' border=\'0\'>\n\t\t\t\t\t\t\t<a href=\'javascript:\' OnClick=\'sortRecord(\"TaskType\",this)\' id=\'anchorTaskType\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' border=\'0\' id=\'thTask\' width=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t\t\t<a href=\'javascript:\' OnClick=\'sortRecord(\"Task\",this)\' id=\'anchorTask\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' id=\'thPriority\' border=\'0\'>\n\t\t\t\t\t\t\t<a href=\'javascript:\' OnClick=\'sortRecord(\"Priority\",this)\' id=\'anchorPriority\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' id=\'thPriority\' border=\'0\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' id=\'thPriority\' border=\'0\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' id=\'thPatDetails\' style=\'display\' border=\'0\' width=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t\t\t\t\t\t<a href=\'javascript:\' OnClick=\'sortRecord(\"PatientDetails\",this)\'  id=\'anchorPatDetails\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\'  id=\'thStatus\' border=\'0\'>\n\t\t\t\t\t\t\t<a href=\'javascript:\' OnClick=\'sortRecord(\"Status\",this)\' id=\'anchorStatus\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a>\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<script>\t\t\n\t\t\t\t\t\t\tvar patientId =\"\"; \n\t\t\t\t\t\t\tif (parent.patTaskListCriteriaFrame)\n\t\t\t\t{ patientId=parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientFlag;\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\t\t\tif ( (\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'==\'9\')||(patientId.value !=\'\')){//||(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'==\'Y\') (patientId.value !=\'\')|| )\n\t\t\t\t\t\t\t\tdocument.getElementById(\"thPatDetails\").style.display=\'none\';}\n\t\t\t\t\t\t\t\telse{ \n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\"thPatDetails\").style.display=\'inline\';}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t<script>\t\t\n\t\t\t\t\t\t\t\tvar ThpatientId =document.getElementById(\"tdPatientId\"+";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =");\n\t\t\t\t\t\t\t\tif(patientId.value !=\'\')\n\t\t\t\t\t\t\t\t\tThpatientId.style.display=\'none\';\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</table>\n<input type=\'hidden\' name=\'qs\' id=\'qs\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<script>\nif(\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" == \'\')\n{\n\tif(\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" != \'\')\n\t{\n\t\tvar PatientId =\'\';\n\n\t\tif(parent.patTaskListCriteriaFrame)\n\t\t\tPatientId=parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientFlag.value\n\t\t\n\t\tif(PatientId == \'\')\n\t\t{\n\t\t\tif(parent.document.getElementById(\"patTaskListFrameSet\").rows==\'21%,0%,0%,*,0%,5%\' ){\n\t\t\t\tparent.document.getElementById(\"patTaskListFrameSet\").rows = \'21%,0%,*,0%,0%,5%\'\n\t\t\t\t}\n\t\t\telse\n\t\t\t{parent.document.getElementById(\"patTaskListFrameSet\").rows = \'21%,0%,0%,*,0%,5%\' \n\t\t\t\t}\n\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(parent.document.getElementById(\"patTaskListFrameSet\").rows==\'17%,0%,0%,*,0%,5%\' )\n\t\t\t{\n\t\t\t\t\n\t\t\t\tparent.document.getElementById(\"patTaskListFrameSet\").rows = \'17%,0%,*,0%,0%,5%\'\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t\n\t\t\t\tparent.document.getElementById(\"patTaskListFrameSet\").rows = \'17%,0%,0%,*,0%,5%\' \n\t\t\t}\n\t\t}\n\t}\n\telse\n\t{\n\t\tvar PatientId =\'\';\n\n\t\tif (\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' !=\'Y\')\n\t\t{\n\t\t\tif(parent.patTaskListCriteriaFrame)\n\t\t\t\tPatientId=  parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientFlag.value;\n\n\t\t\tif(PatientId==\'\')\n\t\t\t{\n\t\t\t\t\n\t\t\t\tparent.document.getElementById(\"patTaskListFrameSet\").rows=\'36%,0%,0%,*,0%,5%\' \n\t\t\t}\n\t\t\telse\n\t\t\t{\t\n\t\t\t\tparent.document.getElementById(\"patTaskListFrameSet\").rows=\'36%,0%,0%,*,0%,5%\' \n\t\t\t}\n\t\t}\n\t}\n}\nelse\n{\n\tvar PatientId = \'\';\n\n\tPatientId=parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientFlag.value\n\t\t\n\tif(PatientId == \'\')\n\t{\n\t\tif(parent.document.getElementById(\"patTaskListFrameSet\").rows==\'21%,0%,0%,*,0%,5%\' )\n\t\t{\t\n\t\t\tparent.document.getElementById(\"patTaskListFrameSet\").rows = \'21%,0%,*,0%,0%,5%\'\n\t\t\t}\n\t\telse\n\t\t{\n\t\tparent.document.getElementById(\"patTaskListFrameSet\").rows = \'36%,0%,0%,*,0%,5%\' //21\n\t\t}\n\t}\n\telse\n\t{\n\t\tif(parent.document.getElementById(\"patTaskListFrameSet\").rows==\'17%,0%,0%,*,0%,5%\' )\n\t\t{\n\t\t\tparent.document.getElementById(\"patTaskListFrameSet\").rows = \'36%,0%,*,0%,0%,5%\'\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\tparent.document.getElementById(\"patTaskListFrameSet\").rows = \'36%,0%,0%,*,0%,5%\' \n\t\t}\n\t}\n\n\tif(parent.patTaskListCriteriaFrame)\n\t\tparent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.flagString1.value=\'\'\n}\n\nif(parent.patTaskListCriteriaFrame)\n\tparent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.search.disabled=false\n</script>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</body>\n</html> \n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
            eCA.PatTaskListRepository patTask= null;{
                patTask=(eCA.PatTaskListRepository)pageContext.getAttribute("patTask");
                if(patTask==null){
                    patTask=new eCA.PatTaskListRepository();
                    pageContext.setAttribute("patTask",patTask);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	//out.println("<script>alert('1');</script>");
	//Properties property = null;
	ArrayList arrayDateTime = null;
	String sortOrder = patTask.checkForNull(request.getParameter("sortOrder"));
	String sortSelection = patTask.checkForNull(request.getParameter("sortSelection"));
	String color="";
	String thId = "";
	ArrayList arrayTaskType= null;
	ArrayList arrayTask= null;
	ArrayList arrayPriority= null;	
	ArrayList arrayPatDetail= null;
	ArrayList arrayStatus= null;
	String resultType ="";
	String resultId ="";
	//boolean Flag = false;
	ArrayList retArray = null;
	ArrayList arrayTaskSrlNo = null;	
	ArrayList arrayRemarks=null;
	ArrayList arrayPerformedId=null;
	ArrayList arrayResultType=null;
	ArrayList arrayResultId=null;
	ArrayList arrayEncounterId= null;
	ArrayList arrayPatientClass= null;
	ArrayList arrayFacilityId= null;
	ArrayList arrayTaskCategory = null;
	ArrayList arrayScheduleDateTime= null;
	ArrayList arrayOrderId= null;
	ArrayList arrayOrderNum = null;
	ArrayList arrayPatientId = null;
	ArrayList arrayStatusDesc = null;
	ArrayList arrayOrderStatusCode = null;
	ArrayList arrayStageDesc = null;

	ArrayList arrayApplicableYN = new ArrayList();
	ArrayList arrayGuildeLinelength = new ArrayList();
	ArrayList arrayPositionDesc = new ArrayList();

	String encounterId ="";
	String patientClass ="";
	String adminStatus="";
	String facilityId ="";
	String flagString = request.getParameter("flagString")==null ? "" : request.getParameter("flagString");
	String flagString1 = request.getParameter("flagString1")==null ? "" : request.getParameter("flagString1");
	String dateTime =  request.getParameter("dateTime")==null ? "" :request.getParameter("dateTime");
	String patientDetail =  request.getParameter("patientDetail")==null ? "" :  request.getParameter("patientDetail");
	String taskSelect =  request.getParameter("taskSelect")==null ? "" : request.getParameter("taskSelect");
	String CP =request.getParameter("CP")==null ? "Y" : request.getParameter("CP");
	
	String tdColor="";
		
	try
	{
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		retArray = patTask.getTaskListQuery(request,locale);

		if(retArray != null)
		{
			arrayDateTime = (ArrayList)retArray.get(0);
			arrayTaskType	 = (ArrayList)retArray.get(1);
			arrayTask	 = (ArrayList)retArray.get(2);
			arrayPriority	 = (ArrayList)retArray.get(3);
			arrayPatDetail	 = (ArrayList)retArray.get(4);
			arrayStatus	 = (ArrayList)retArray.get(5);
			arrayTaskSrlNo= (ArrayList)retArray.get(6);
			arrayRemarks= (ArrayList)retArray.get(7);
			arrayPerformedId= (ArrayList)retArray.get(8);
			arrayResultType= (ArrayList)retArray.get(9);
			arrayResultId= (ArrayList)retArray.get(10);
			arrayEncounterId= (ArrayList)retArray.get(11);
			arrayPatientClass= (ArrayList)retArray.get(24);
			
			arrayFacilityId= (ArrayList)retArray.get(12);
			arrayTaskCategory = (ArrayList)retArray.get(13);
			arrayScheduleDateTime= (ArrayList)retArray.get(14);
			arrayOrderId= (ArrayList)retArray.get(15);
			arrayOrderNum = (ArrayList)retArray.get(16);
			arrayPatientId= (ArrayList)retArray.get(17);
			arrayStatusDesc= (ArrayList)retArray.get(18);
			arrayOrderStatusCode= (ArrayList)retArray.get(19);
			arrayStageDesc= (ArrayList)retArray.get(20);
			arrayApplicableYN = (ArrayList)retArray.get(21);
			arrayGuildeLinelength = (ArrayList)retArray.get(22);
			arrayPositionDesc = (ArrayList)retArray.get(23);

			if(arrayDateTime.size() ==0 && arrayTaskType.size()==0 && arrayTask.size()==0 && arrayPriority.size()==0 &&  arrayPatDetail.size()==0 && arrayStatus.size()==0 && arrayTaskSrlNo.size()==0)
			{
				out.println("<script>if(parent.patTaskListCriteriaFrame) parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.search.disabled=false</script>");		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'))</script>");
			out.println("<script>parent.patTaskListResultFrame.location.href='../../eCommon/html/blank.html'</script>");

			}
			else
			{
            _bw.write(_wl_block8Bytes, _wl_block8);
if(!dateTime.equals("")){
            _bw.write(_wl_block9Bytes, _wl_block9);
if(!patientDetail.equals("")){
            _bw.write(_wl_block10Bytes, _wl_block10);
if(!taskSelect.equals("")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
							}
						}
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(((dateTime.equals(""))?"45%":((!dateTime.equals("") && patientDetail.equals(""))?"46%":((!dateTime.equals("") && !patientDetail.equals("") && taskSelect.equals(""))?"47%":		((!taskSelect.equals(""))?"48%":""))))));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(((dateTime.equals(""))?"45%":((!dateTime.equals("") && patientDetail.equals(""))?"46%":((!dateTime.equals("") && !patientDetail.equals("") && taskSelect.equals(""))?"47%":		((!taskSelect.equals(""))?"48%":""))))));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateTime));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(CP));
            _bw.write(_wl_block24Bytes, _wl_block24);
		
		if(!sortOrder.equals(""))
	{
		if(sortOrder.equals("asc"))
		{
			color="#FFA6A6"	;
		}	
		else
		{
			color="#FFFF00"	;
		}
		if(!sortSelection.equals(""))
		{
			if(sortSelection.equals("6"))
				thId = "anchorDateId";
			else if(sortSelection.equals("3"))
				thId = "anchorTaskType";
			else if (sortSelection.equals("5"))
			thId = "anchorTask";
			else if (sortSelection.equals("11"))
			thId = "anchorPriority";
			else if (sortSelection.equals("9"))
				thId = "anchorPatDetails";
			else if(sortSelection.equals("12"))
				thId = "anchorStatus";
	
		}
		if(!thId.equals(""))
			out.println("<script>document.all."+thId+".style.color='"+color+"'</script>");
	}

						String classValue="";						
						String taskCode ="";
						String taskTypeCode="";
						String taskDesc="";	
						String taskTypeDesc = "";
						StringTokenizer tokenColon = null;
						String remarks="";
						String performedId = "";
                       
						if(dateTime.equals(""))
						{
							for(int index=0;index < arrayDateTime.size() ;index++)	
							{
								tokenColon = new StringTokenizer((String)arrayTaskType.get(index),":");
								taskTypeDesc = tokenColon.nextToken();
								taskTypeCode = tokenColon.nextToken();
								tokenColon = new StringTokenizer((String)arrayTask.get(index),":");
								taskDesc = tokenColon.nextToken();
								taskCode = tokenColon.nextToken();
								resultType=(String)arrayResultType.get(index) == null ? "" : (String)arrayResultType.get(index);
								adminStatus = arrayOrderStatusCode.get(index).toString()==null ? "" :arrayOrderStatusCode.get(index).toString();
								resultId=(String)arrayResultId.get(index) == null ? "" : (String)arrayResultId.get(index);
								encounterId = (String)arrayEncounterId.get(index) == null ? "" : (String)arrayEncounterId.get(index);
								patientClass = (String)arrayPatientClass.get(index) == null ? "" : (String)arrayPatientClass.get(index);

								facilityId = (String)arrayFacilityId.get(index) == null ? "" : (String)arrayFacilityId.get(index);

                               
								if(index % 2 ==0) 
									classValue="QRYEVEN" ;
								else
								classValue="QRYODD";

								out.println("<tr id='rowId"+index+"'>");
								if(adminStatus.equals("D"))
								{
									tdColor = "#CCFFCC";	
								}
								else if(adminStatus.equals("O"))
								{
									tdColor = "#FFFFCC";
								}
								else if(adminStatus.equals("E"))
								{
									tdColor = "#D5006A";
								}
								else if(adminStatus.equals("C"))
								{
									tdColor = "#0099FF";

								}
								else if(adminStatus.equals("F"))
								{
									tdColor = "#FFCCCC";
								}
								out.println("<td nowrap  style='background:"+tdColor+"' class='label' align='center'><B>"+(arrayTaskCategory.get(index).toString())+"</B></td>");
								/*out.println("<td nowrap class='"+classValue+"'>&nbsp;</td>");
								out.println("<td  nowrap class='"+classValue+"'>&nbsp;</td>");
								out.println("<td  nowrap class='"+classValue+"'>&nbsp;</td>");*/
								out.println("<td  nowrap class='"+classValue+"'>"+(String)arrayScheduleDateTime.get(index)+"</td>");
								out.println("<td   class='"+classValue+"' id='tdTaskType"+index+"'>"+taskTypeDesc+"</td>");


								String anchor_guideLine = "";
								if (Integer.parseInt((String)arrayGuildeLinelength.get(index)) > 0)
								{
									anchor_guideLine = "&nbsp;&nbsp;<a href='javascript:' onclick='showGuideLine(\"" + taskCode + "\")'><font color='BLUE'>(G)</font></a>";
								}
								else
									anchor_guideLine = "&nbsp;";

								if(adminStatus.equals("D") || adminStatus.equals("O"))
								{
								if(arrayTaskCategory.get(index).toString().equals("I"))
								{	out.println("resultType  "+resultType);
									if(((String)arrayStatus.get(index)).equals("Pending") && ((String)arrayApplicableYN.get(index)).equals("Y") ) 
									{
										
										if(resultType.equals(""))
										{
											out.println("<td class='"+classValue+"'><a href='javascript:' OnClick='displayToolTip(event,"+index+")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='visibility:hidden'><table id='tooltiptable"+index+"' cellpadding=3 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
										}
										else
										{
											out.println("<td class='"+classValue+"'><a href='javascript:' OnClick='displayToolTipForEvents(event,"+index+",\""+resultType+"\",\""+resultId+"\")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='25%' style='visibility:hidden'><table id='tooltiptable"+index+"' cellpadding=3 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
										}
									}else
									{
										out.println("<td class='"+classValue+"'>" + taskDesc + anchor_guideLine + "</td>");
									}
								}
								else
								{
										out.println("<td class='"+classValue+"'><a href='javascript:' OnClick='displayToolTipForEvents(event,"+index+",\""+resultType+"\",\""+resultId+"\")'><font color='BLUE'>"+taskDesc+"</font></a>" + anchor_guideLine + "<div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='visibility:hidden'><table id='tooltiptable"+index+"' cellpadding=3 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
								}
								}
								else
								{
									out.println("<td class='"+classValue+"'>"+taskDesc + anchor_guideLine + "</td>");
								}
								out.println("<td  class='"+classValue+"'>"+(String)arrayPriority.get(index)+"</td>");

								out.println("<td  class='"+classValue+"'>" + (String)arrayStageDesc.get(index) + "</td>");
								out.println("<td  class='"+classValue+"'>" + (String)arrayPositionDesc.get(index) + "</td>");

								out.println("<td class='" + classValue + "' id='tdPatientId" + index+"'>" + (String)arrayPatDetail.get(index) + "</td>");
								if((((String)arrayStatusDesc.get(index)).equals("Performed") || ((String)arrayStatusDesc.get(index)).equals("Not Performed"))) 
								{
									out.println("<td  class='"+classValue+"' ><a href='javascript:' OnClick='displayToolTip1(event,"+index+",\"Details\")'><font color='BLUE'>"+(String)arrayStatus.get(index)+"</font></a><div name='tooltiplayer' id='tooltiplayer"+index+"'  width='20%' style='visibility:hidden'><table id='tooltiptable"+index+"' cellpadding=3 cellspacing=0 border='0' width='auto' height='100%' align='center' ><tr><td width='100%' id='t"+index+"'></td></tr></table></div></td>");
								}
								else
								{
									out.println("<td class='"+classValue+"'>"+(String)arrayStatusDesc.get(index)+"</td>");
								}
								out.println("<input type='hidden' name='patientClass"+index+"' id='patientClass"+index+"' value='"+patientClass+"'>");
								out.println("<input type='hidden' name='taskType"+index+"' id='taskType"+index+"' value='"+taskTypeCode+"'>");
								out.println("<input type='hidden' name='taskCode"+index+"' id='taskCode"+index+"' value='"+taskCode+"'>");
								out.println("<input type='hidden' name='taskSrlNo"+index+"' id='taskSrlNo"+index+"' value='"+(String)arrayTaskSrlNo.get(index)+"'>");
								remarks = (String)arrayRemarks.get(index) == null ? "" : (String)arrayRemarks.get(index);
								performedId=(String)arrayPerformedId.get(index) == null ? "" : (String)arrayPerformedId.get(index);	
								out.println("<input type='hidden' name='remarks"+index+"' id='remarks"+index+"' value='"+remarks+"'>");
								out.println("<input type='hidden' name='performedId"+index+"' id='performedId"+index+"' value='"+performedId+"'>");	
								out.println("<input type='hidden' name='resultType"+index+"' id='resultType"+index+"' value='"+resultType+"'>");
								out.println("<input type='hidden' name='resultId"+index+"' id='resultId"+index+"' value='"+resultId+"'>");
								out.println("<input type='hidden' name='facilityId"+index+"' id='facilityId"+index+"' value='"+facilityId+"'>");
								out.println("<input type='hidden' name='encounterId"+index+"' id='encounterId"+index+"' value='"+encounterId+"'>");
								out.println("<input type='hidden' name='taskCategory"+index+"' id='taskCategory"+index+"' value='"+patTask.checkForNull(arrayTaskCategory.get(index).toString())+"'>");
								out.println("<input type='hidden' name='scheduleDate"+index+"' id='scheduleDate"+index+"' value='"+patTask.checkForNull(arrayScheduleDateTime.get(index).toString())+"'>");
								out.println("<input type='hidden' name='orderId"+index+"' id='orderId"+index+"' value='"+patTask.checkForNull(arrayOrderId.get(index).toString())+"'>");
								out.println("<input type='hidden' name='orderNum"+index+"' id='orderNum"+index+"' value='"+patTask.checkForNull(arrayOrderNum.get(index).toString())+"'>");
								out.println("<input type='hidden' name='patientId"+index+"' id='patientId"+index+"' value='"+patTask.checkForNull(arrayPatientId.get(index).toString())+"'>");
								out.println("<input type='hidden' name='status"+index+"' id='status"+index+"' value='"+patTask.checkForNull(arrayStatus.get(index).toString())+"'>");
								out.println("<input type='hidden' name='adminStatus"+index+"' id='adminStatus"+index+"' value='"+adminStatus+"'>");
								out.println("<input type='hidden' name='priority"+index+"' id='priority"+index+"' value='"+patTask.checkForNull(arrayPriority.get(index).toString())+"'>");
								out.println("</tr>");
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(index));
            _bw.write(_wl_block26Bytes, _wl_block26);
			
							}
							out.println("<input type='hidden' name='count' id='count' value='"+arrayStatus.size()+"'>");
						}
						else			
				{
							
							request.setAttribute("retArray",retArray);

							
            _bw.write(_wl_block27Bytes, _wl_block27);
            {java.lang.String __page ="PatTaskListPopulation.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block1Bytes, _wl_block1);
				}
			}
		}
	}
	catch(Exception ee)
	{
		//out.println("Exception from Patient Task List Result Page :"+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();
	}
	finally 
	{
		if(arrayDateTime!=null)			arrayDateTime.clear();
		if(arrayTaskType!=null)			arrayTaskType.clear();
		if(arrayTask!=null)				arrayTask.clear();
		if(arrayPriority!=null)			arrayPriority.clear();
		if(arrayPatDetail!=null)		arrayPatDetail.clear();
		if(arrayStatus!=null)			arrayStatus.clear();
		if(arrayTaskSrlNo!=null)		arrayTaskSrlNo.clear();
		if(arrayRemarks!=null)			arrayRemarks.clear();
		if(arrayPerformedId!=null)		arrayPerformedId.clear();
		if(arrayResultType!=null)		arrayResultType.clear();
		if(arrayResultId!=null)			arrayResultId.clear();
		if(arrayEncounterId!=null)		arrayEncounterId.clear();
		if(arrayPatientClass!=null)		arrayPatientClass.clear();
		if(arrayFacilityId!=null)		arrayFacilityId.clear();
		if(arrayTaskCategory!=null)		arrayTaskCategory.clear();
		if(arrayScheduleDateTime!=null)	arrayScheduleDateTime.clear();
		if(arrayOrderId!=null)			arrayOrderId.clear();
		if(arrayOrderNum!=null)			arrayOrderNum.clear();
		if(arrayPatientId!=null)		arrayPatientId.clear();
		if(arrayStatusDesc!=null)		arrayStatusDesc.clear();
		if(arrayOrderStatusCode!=null)	arrayOrderStatusCode.clear();
		if(arrayStageDesc!=null)		arrayStageDesc.clear();
		if(arrayApplicableYN!=null)		arrayApplicableYN.clear();
		if(arrayGuildeLinelength!=null)	arrayGuildeLinelength.clear();
		if(arrayPositionDesc!=null)		arrayPositionDesc.clear();
		
	
		if (retArray!=null) retArray.clear();
	}

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(request.getParameter("qs")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(flagString1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(flagString));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(CP));
            _bw.write(_wl_block33Bytes, _wl_block33);



            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TaskType.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Task.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stage.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
