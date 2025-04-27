package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __spltyhomepagecontrol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SpltyHomePageControl.jsp", 1736157593229L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<head> \n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link> \n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/SpltyHomePage.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdtArr[";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="] = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>dtArr[";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";</script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'controlsForm\' id=\'controlsForm\' >\n<input type = hidden  name = idx_value\t\tvalue = ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" - 1>\n<input type = hidden  name = cur_idx_value\tvalue = \"0\">\n<input type = hidden  name = queryString\tvalue = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<input type = hidden  name = called_from\tvalue =";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" >\n<input type = hidden  name = strFromDate\tvalue =";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >\n<input type = hidden  name = strToDate\t\tvalue =";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n<input type = hidden  name = strPatientId\tvalue =";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" >\n<input type = hidden  name = strHistRecType value =";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >\n<input type = hidden  name = strEventClass\tvalue =";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" >\n<input type = hidden  name = strEventGroup\tvalue =";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >\n<input type = hidden  name = strEventCode\tvalue =";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >\n<input type = hidden  name = strFacilityId\tvalue =";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >\n<input type = hidden  name = strEncounterId value =";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n<input type = hidden  name = strEpisodeType\tvalue =";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >\n<input type = hidden  name = strNormalcyInd\tvalue =";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n<input type = hidden  name = strAbnormal\tvalue =";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n<input type = hidden  name = strFlowSheetId value =";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" >\n<input type = hidden  name = strViewConfRes\tvalue =";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" >\n<input type = hidden  name = strGraphOrder\tvalue =";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" >\n<input type = hidden  name = strErrorEvent\tvalue =";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" >\n<TABLE width=\'100%\'>\n<TR> \n\t\t<td width=\"73%\" align=\'left\' class=\'oalabel\'><font CLASS=\'HIGH\' size=\'1\' >&nbsp;&nbsp;</font><B><font color=\'BLACK\' size=\'1\'>&nbsp;[";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="]</font><font size=\'1\'>-";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font>&nbsp;<font CLASS=\'LOW\' size=\'1\' >&nbsp;&nbsp;</font>&nbsp;<font color=\'BLACK\' size=\'1\'>[";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font>&nbsp;&nbsp;&nbsp;<font CLASS=\'CRITICALLOW\' size=\'1\' >&nbsp;&nbsp;</font>&nbsp;<font color=\'BLACK\' size=\'1\'>[";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</font>&nbsp;<font CLASS=\'CRITICALHIGH\' size=\'1\' >&nbsp;&nbsp;</font>\n\t\t<font color=\'BLACK\' size=\'1\'>[";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</font>&nbsp;&nbsp;&nbsp;\n\t\t<font CLASS=\'ABNORMAL\' size=\'1\' >&nbsp;&nbsp;</font>&nbsp;<font color=\'BLACK\' size=\'1\'>[";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</font>&nbsp;<font CLASS=\'CRITICAL\' size=\'1\' >&nbsp;&nbsp;</font>&nbsp;<font color=\'BLACK\' size=\'1\'>[";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</font>&nbsp;<!-- ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;&nbsp;<font color=\'red\' size=\'1\'> [";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="]</font><font size=\'1\'>-Delta Check</font>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" --></B></td>\t\n\t\n</TR>\n</TABLE>\n<table border=0 cellpadding=0 cellspacing=0 width=\"100%\" align=\'right\' id=\'tablePrevNext\' style=\'display\'>\n\t<tr>\n\t\t<td  width=\'85%\'>&nbsp;</td>\n\t\t<td align=\'left\' width=\'5%\'><input type=\'button\' id=\'prev\' name=\'prev\' id=\'prev\' value=\'<\' ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" class=\'button\' onclick=\'loadPrevNext(this)\' align=\'right\'></td>\n\t\t<td  align =\'center\' class = \'QRYEVEN\'>\n\t\t\t\t<input type =\'label\' class=\"LABEL\" name = \'label_cap\'> \n\t\t</td>\n\t\t<td align=\'left\' width=\'5%\'><input type=\'button\' id=\'next\' name=\'next\' id=\'next\' value=\'>\' ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" class=\'button\' onclick=\'loadPrevNext(this)\' ></td>\n\t</tr>\n</table>\n<script>\nfunction defaultPage()\n{\n\tvar idx_value\t= document.forms[0].idx_value.value;\n\tvar cur_idx_value = document.forms[0].cur_idx_value.value;\n\n\tvar fromDateTime =\"\";\n\tvar toDateTime =\"\";\n\tvar displend = \"\";\n\tvar displstart = 1;\n\n\tif(idx_value > 0)\n\t{\n\t\tfromDateTime\t= dtArr[0];\n\t\ttoDateTime\t\t= dtArr[1];\n\t\tdisplend = eval(idx_value) ;\n\t\tparent.controlsFrame.document.forms[0].cur_idx_value.value = 0;\n\t\tparent.controlsFrame.document.forms[0].label_cap.value = displstart + \" of \" + displend;\n\n\t\tif(idx_value == 1)\n\t\t{\n\t\t\tparent.controlsFrame.document.forms[0].next.disabled = true;\n\t\t\tparent.controlsFrame.document.forms[0].prev.disabled = true;\n\n\t\t}\n\t\tpopulateControl();\n\t\t\n\t}\n}\ndefaultPage();\n</script>\n</form>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	Connection con = null;
	PreparedStatement pstmtDt = null;
	ResultSet rsDt = null;

	String high_str = "",low_str="",abn_str="",crit_str="",crit_high_str="",crit_low_str="",delta_fail_str="";
	
//	String disabled ="";
	String disablePrev = " disabled ";
	String disableNext = "";
	String birth="";
	String called_from ="";
	String strFromDate  = "";
	String strToDate = "";
	String strPatientId = "";
	String strHistRecType = "";
	String strEventClass ="";
	String strEventGroup = "";
	String strEventCode  = "";
	String strFacilityId ="";
	String strEncounterId ="";
	String strEpisodeType ="";
	String strNormalcyInd ="";
	String strAbnormal ="";
	String strFlowSheetId ="";
	String strViewConfRes ="";
	String strGraphOrder ="";
	String strErrorEvent ="";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String cycle_no = request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");

	strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");

  if(strGraphOrder.equals("D"))
		strGraphOrder = "desc";
  else if(strGraphOrder.equals("A"))
		strGraphOrder = "asc";

  strViewConfRes	= request.getParameter("viewConfRes")==null?"":request.getParameter("viewConfRes");
  strFromDate		= request.getParameter("c_from_date")==null?"":request.getParameter("c_from_date");
  strToDate			= request.getParameter("c_to_date")==null?"":request.getParameter("c_to_date");
  strFlowSheetId	= request.getParameter("cboFlowSheetComp")==null?"":request.getParameter("cboFlowSheetComp");
  strEventCode		= request.getParameter("eventitem")==null?"":request.getParameter("eventitem");
  strErrorEvent		= request.getParameter("errorEvent")==null?"":request.getParameter("errorEvent");
  strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
  strPatientId		= request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
  strEventGroup		= request.getParameter("p_event_group")==null?"":request.getParameter("p_event_group");
  strEventClass		= request.getParameter("p_event_class")==null?"":request.getParameter("p_event_class");
  strHistRecType	= request.getParameter("p_hist_rec_type")==null?"":request.getParameter("p_hist_rec_type");
  called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
  strFacilityId		= request.getParameter("c_facility_id")==null?"":request.getParameter("c_facility_id");
  strEpisodeType	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
  strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

 // strFromDate		= com.ehis.util.DateUtils.convertDate(strFromDate,"DMYHM",locale,"en");
  //strToDate			= com.ehis.util.DateUtils.convertDate(strToDate,"DMYHM",locale,"en");

	int nKey = 0;
	try
	{
		con = ConnectionManager.getConnection(request);
	//	pstmtDt = con.prepareStatement("SELECT DISTINCT TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi') trans_date 	FROM CA_SPLTY_DISCR_MSR WHERE patient_id=? AND module_id=? AND cycle_no=? ORDER BY TO_DATE(trans_date,'dd/mm/yyyy hh24:mi') desc");
		
		pstmtDt = con.prepareStatement("Select distinct KEY_REF	From CA_PAT_SPLTY_HIST_REF a WHERE a.PATIENT_ID =? AND a.MODULE_ID  =? AND a.CYLE_NO   =? ORDER BY KEY_REF");
		int nCtr = 0;
		try
		{
			pstmtDt.setString(1,patient_id);
			pstmtDt.setString(2,module_id);
			pstmtDt.setString(3,cycle_no);
			rsDt = pstmtDt.executeQuery();
	
			String strDateRecd = "";
			
			while (rsDt.next())
			{
				strDateRecd = rsDt.getString(1);

				if (nCtr%10 == 0)
				{
					
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strDateRecd));
            _bw.write(_wl_block10Bytes, _wl_block10);


						nKey++;
				}
				nCtr++;
			}

			if(nCtr%10!=0)
			{
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strDateRecd));
            _bw.write(_wl_block12Bytes, _wl_block12);
}
			if(nKey == 0)
			{ 
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
		}
		catch (Exception ee1)
		{
			//out.println(ee1);//common-icn-0181
		   	ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rsDt != null) rsDt.close();
			if(pstmtDt != null) pstmtDt.close();
		}

		pstmtDt = con.prepareStatement("SELECT HIGH_STR,LOW_STR, ABN_STR,CRIT_STR, CRIT_HIGH_STR, CRIT_LOW_STR, DELTA_FAIL_STR, nvl((select 'Y' from mp_birth_register where patient_id=?),'N') birth FROM CR_CLIN_EVENT_PARAM");

		pstmtDt.setString(1,strPatientId);

		rsDt = pstmtDt.executeQuery();
		
		while(rsDt.next())
		{
			high_str		= rsDt.getString("HIGH_STR");
			low_str			= rsDt.getString("LOW_STR");
			abn_str			= rsDt.getString("ABN_STR");
			crit_str		= rsDt.getString("CRIT_STR");
			crit_high_str	= rsDt.getString("CRIT_HIGH_STR");
			crit_low_str	= rsDt.getString("CRIT_LOW_STR");
			delta_fail_str	= rsDt.getString("DELTA_FAIL_STR");
			birth			= rsDt.getString("birth");
		}
		
		if(delta_fail_str == null) delta_fail_str="";
	
		if(rsDt != null) rsDt.close();
		if(pstmtDt != null) pstmtDt.close();

	}
	catch(Exception e)
	{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strFromDate));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strToDate));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strHistRecType));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strEventClass));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strEventGroup));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strEventCode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strAbnormal));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strFlowSheetId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strViewConfRes));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strGraphOrder));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strErrorEvent));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(high_str));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(low_str));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(crit_low_str));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(crit_high_str));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(abn_str));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(crit_str));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
//if(!delta_fail_str.equals("")){
            _bw.write(_wl_block40Bytes, _wl_block40);
//=delta_fail_str
            _bw.write(_wl_block41Bytes, _wl_block41);
//}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disablePrev));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(disableNext));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ViewSpecialtyEventHistory.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.High.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Low.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CriticalLowValue.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CriticalHighValue.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Abnormal.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Critical.label", java.lang.String .class,"key"));
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
}
