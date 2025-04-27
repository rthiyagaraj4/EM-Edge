package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __revisecareplanviewdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/ReviseCarePlanViewDetail.jsp", 1740026320571L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------\nDate       Edit History      Name        \tDescription\n-----------------------------------------------------------------------\n?             100            ?           \tcreated\n1/06/2012    IN032685\t\t Menaka V\t\tManage Care plan>When we Uncheck Active or Pending status we get script error during revise plan.\n-----------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\' ></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\' ></SCRIPT>\n\t\t<SCRIPT language=\"javascript\" src=\"../js/ReviseCarePlan.js\"></SCRIPT>\n</HEAD>\n\n<BODY onKeyDown = \'lockKey()\'  OnMouseDown=\"CodeArrest()\">\n<!-- style=\"overflow-y:scroll;overflow-x:hidden\" -->\n<FORM name=\"formReviseCareplanDetail\" id=\"formReviseCareplanDetail\" >\n<SCRIPT language=\'javascript\'>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<TABLE border=\'0\' cellpadding=0 cellspacing=\'0\' align=\'center\'  width=\'100%\'> \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<TR>\n\t\t<TD class=\"ATCTABLE\" align=\"left\" width=\"15%\"><B><font size=\"1\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font></B></TD>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<!-- IN032685 -->\n\t\t<TD class=\"ATCTABLE\" align=\"center\" width=\"3%\"><INPUT TYPE=\"checkbox\" checked ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" NAME=\"update_diag\" onclick=\"updateDiagnosis(this,\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\"></TD><!-- IN032685 -->\n\t\t<TD class=\"ATCTABLE\" align=\"left\" width=\"48%\" ><B><font size=\"1\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font></B></TD>\n\t\t<TD class=\"ATCTABLE\" align=\"left\" width=\"18%\"><B><font size=\"1\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></B></TD>\n\t\t<TD class=\"ATCTABLE\" align=\"left\"><B><font size=\"1\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></B></TD>\n\t</TR>\n\t<TR>\n\t\t<TD class=\"ATCTABLE\" colspan=\"2\">&nbsp;</TD>\n\t\t<TD class=\"ATCTABLE\" colspan=\"3\">&nbsp;</TD>\n\t</TR>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<TR>\n\t\t<TD class=\"ATCTABLE\" align=\"left\"><B><font size=\"1\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<!-- IN032685-->\n\t\t<TD class=\"ATCTABLE\" align=\"center\"><INPUT TYPE=\"checkbox\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="  NAME=\"diag_code_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onclick=\"updateGoal(this,\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\"></TD><!-- IN032685-->\n\t\t<TD class=\"ATCTABLE\" colspan=\"3\" align=\"left\"><B><font size=\"1\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font></B></TD>\n\t</TR>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<TR>\n\t\t<TD class=\"ATCTABLE\" colspan=\"5\">&nbsp;</TD>\n\t</TR>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t<TR>\n\t\t<TD class=\"ATCTABLE\" colspan=\"2\">&nbsp;</TD>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<!--IN032685 -->\n\t\t<TD class=\"ATCTABLE\" colspan=\"3\" id=\"lbl_goal_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label   style=\"cursor:pointer;color:blue \" onclick=\"ShowAddIntvn(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\"><b>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</b></label></TD><!--IN032685 -->\n\t</TR>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="<!-- IN032685 -->\n\t\t<TD class=\"ATCTABLE\" colspan=\"3\" id=\"lbl_goal_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label    style=\"cursor:default;color:black \"></label></TD><!-- IN032685 -->\n\t</TR>\t\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t<TR>\n\t\t<TD class=\"ATCTABLE\" align=\"left\"><font size=\"1\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</font></TD>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<!-- IN032685 -->\n\t\t<TD class=\"ATCTABLE\" align=\"center\"><INPUT TYPE=\"checkbox\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" NAME=\"intv_code_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" onclick=\"updateIntvn(this,\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\"></TD><!-- IN032685 -->\n\t\t<TD class=\"ATCTABLE\" colspan=\"3\" align=\"left\"><font size=\"1\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<B>I</B>]&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</font></TD>\n\t</TR>\n\t\t\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" NAME=\"out_code_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" onclick=\"updateOutcome(this,\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\')\"></TD><!-- IN032685 -->\n\t\t <TD class=\"ATCTABLE\" colspan=\"3\" align=\"left\"><font size=\"1\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<B>O</B>]&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<TR>\n\t\t<TD class=\"ATCTABLE\" colspan=\"2\">&nbsp;</TD>\n\t\t<TD class=\"ATCTABLE\" colspan=\"3\">&nbsp;</TD>\n\t</TR>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t</TABLE>\n\t\t<INPUT TYPE=\"hidden\" name=\"care_plan_id\" id=\"care_plan_id\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"md_care_plan_id\" id=\"md_care_plan_id\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<INPUT TYPE=\"hidden\" name=\"care_mgr_id\" id=\"care_mgr_id\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t</FORM>\n\t</BODY>\n\t</HTML>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

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
            webbeans.eCommon.RecordSet ReviseCarePlan= null;synchronized(session){
                ReviseCarePlan=(webbeans.eCommon.RecordSet)pageContext.getAttribute("ReviseCarePlan",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(ReviseCarePlan==null){
                    ReviseCarePlan=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("ReviseCarePlan",ReviseCarePlan,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String care_plan_id=request.getParameter("care_plan_id");
	int careplanid=Integer.parseInt(care_plan_id);
	String md_care_plan_id=request.getParameter("md_care_plan_id");
	int mdcareplanid=Integer.parseInt(md_care_plan_id);

	String patient_id=request.getParameter("patient_id");
	String encounter_id=request.getParameter("encounter_id");
	String care_mgr_id=request.getParameter("care_mgr_id");
	//out.println("care_plan_id "+care_plan_id);
	//out.println("md_care_plan_id "+md_care_plan_id);
	
	//1865-c
	//528-m
	Connection connection		=		null;
    PreparedStatement pstmt		=		null;
	ResultSet rs				=		null;

	String diagnosisSql			=		"SELECT 	A.TERM_SET_ID,A.TERM_CODE, A.TERM_SET_ID || ' - ' || B.SHORT_DESC DIAG_DESC,TO_CHAR(A.START_DATE,'dd/mm/yyyy hh24:mi') START_DATE, TO_CHAR(A.TARGET_DATE,'dd/mm/yyyy hh24:mi') TARGET_DATE,	A.STATUS, A.APPL_YN,A.LIBRARY_ID,A.VERSION_NO FROM  CP_PAT_CARE_PLAN_TERM_CODE A, MR_TERM_CODE B WHERE  A.MD_CARE_PLAN_ID = ? AND	A.CARE_PLAN_ID = ? AND A.APPL_YN = 'Y' AND B.TERM_SET_ID = A.TERM_SET_ID AND  B.TERM_CODE = A.TERM_CODE ORDER  BY A.TERM_SET_ID,A.TERM_CODE";
//	String goalSql				=		"SELECT	A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE, B.SHORT_DESC GOAL_DESC,TO_CHAR(A.GOAL_TARGET_DATE,'dd/mm/yyyy hh24:mi') GOAL_TARGET_DATE,A.APPL_YN,A.STATUS FROM	CP_PAT_CARE_PLAN_GOAL A, CP_OUTCOME B WHERE  A.MD_CARE_PLAN_ID = ? AND	A.CARE_PLAN_ID = ? AND B.OUTCOME_CODE = A.GOAL_CODE  ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE";
	String goalSql				=		"SELECT	A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE, B.SHORT_DESC GOAL_DESC,TO_CHAR(A.GOAL_TARGET_DATE,'dd/mm/yyyy hh24:mi') GOAL_TARGET_DATE,A.APPL_YN,A.STATUS FROM	CP_PAT_CARE_PLAN_GOAL A, CP_OUTCOME_lang_vw B WHERE  A.MD_CARE_PLAN_ID = ? AND	A.CARE_PLAN_ID = ? AND B.OUTCOME_CODE = A.GOAL_CODE  AND b.language_id = ? ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE";
//	String interventionSql		=		"SELECT A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.INTERVENTION_CODE,B.SHORT_DESC INTVN_DESC,B.Intervention_type,A.STATUS, A.APPL_YN FROM CP_PAT_CARE_PLAN_INTVN A, CA_INTERVENTION B WHERE  A.MD_CARE_PLAN_ID =? AND	A.CARE_PLAN_ID = ? AND  B.INTERVENTION_CODE = A.INTERVENTION_CODE ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.INTERVENTION_CODE";
	String interventionSql		=		"SELECT A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.INTERVENTION_CODE,B.SHORT_DESC INTVN_DESC,B.Intervention_type,A.STATUS, A.APPL_YN FROM CP_PAT_CARE_PLAN_INTVN A, CA_INTERVENTION_lang_vw B WHERE  A.MD_CARE_PLAN_ID =? AND	A.CARE_PLAN_ID = ? AND  B.INTERVENTION_CODE = A.INTERVENTION_CODE AND b.language_id = ? ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.INTERVENTION_CODE";
//	String outcomeSql			=		"SELECT	A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC,TO_CHAR(A.OUTCOME_TARGET_DATE,'dd/mm/yyyy hh24:mi') TARGET_DATE,A.STATUS, A.APPL_YN FROM	CP_PAT_CARE_PLAN_OUTCOME A, CP_OUTCOME B WHERE  A.MD_CARE_PLAN_ID = ? AND	A.CARE_PLAN_ID = ? AND	B.OUTCOME_CODE = A.OUTCOME_CODE ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.OUTCOME_CODE";
	String outcomeSql			=		"SELECT	A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.OUTCOME_CODE,B.SHORT_DESC OUTCOME_DESC,TO_CHAR(A.OUTCOME_TARGET_DATE,'dd/mm/yyyy hh24:mi') TARGET_DATE,A.STATUS, A.APPL_YN FROM	CP_PAT_CARE_PLAN_OUTCOME A, CP_OUTCOME_lang_vw B WHERE  A.MD_CARE_PLAN_ID = ? AND	A.CARE_PLAN_ID = ? AND	B.OUTCOME_CODE = A.OUTCOME_CODE AND language_id = ? ORDER  BY A.TERM_SET_ID,A.TERM_CODE,A.GOAL_CODE,A.GROUP_ID,A.OUTCOME_CODE";

	ArrayList Diagnosis			=		new ArrayList();
	ArrayList Goal				=		null;
	HashMap InterventionOutcome	=		null;
	HashMap IOGroup				=		null;
	ArrayList Intervention		=		null;
	ArrayList Outcome			=		null;

	String termSet="";
	String termCode="";
	String diagDesc="";
	String startdate="";
	String enddate="";
	String temptermSet="";
	String temptermCode="";
	String diagStatus="";
	String diagStatuslegend="";
	String diagappln_yn="";
	String diagenabled="";

	String goalCode="";
	String goalDesc="";
	String goalStatus="";
	String goalStatuslegend="";
	String goalappln_yn="";
	String goalchecked="";
	String goalenabled="";
	String goalenabled1="";

	String grpid1="";
	
	String IntvnCode="";
	String IntvnDesc="";
	String IntvnStatus="";
	String IntvnStatuslegend="";
	String Intvnchecked="";
	String Intvnenabled="";
	String Intvnappln_yn="";

	String outcomeCode="";
	String outcomeDesc="";
	String outcomeStatus="";
	String outcomeStatuslegend="";
	String outcomechecked="";
	String outcomeenabled="";
	String outcomeappln_yn="";
	int index=0;

	try{
		connection	=	ConnectionManager.getConnection(request);
		//stmt		=	connection.createStatement();
		//rs			=	stmt.executeQuery(diagnosisSql);
		pstmt = connection.prepareStatement( diagnosisSql);
		pstmt.setInt(1,mdcareplanid);
		pstmt.setInt(2,careplanid);
		rs=pstmt.executeQuery();
		while(rs.next()){
			Diagnosis.add(rs.getString("TERM_SET_ID"));
			Diagnosis.add(rs.getString("TERM_CODE"));
			Diagnosis.add(rs.getString("DIAG_DESC"));
			Diagnosis.add(com.ehis.util.DateUtils.convertDate(rs.getString("START_DATE"),"DMYHM","en",locale));
			Diagnosis.add(com.ehis.util.DateUtils.convertDate(rs.getString("TARGET_DATE"),"DMYHM","en",locale));
			Goal=new ArrayList();
			Diagnosis.add(Goal);
			Diagnosis.add(rs.getString("STATUS"));
			Diagnosis.add(rs.getString("APPL_YN"));
			Diagnosis.add(rs.getString("APPL_YN"));
			Diagnosis.add(rs.getString("LIBRARY_ID"));
			Diagnosis.add(rs.getString("VERSION_NO"));
		}
		rs.close();
		pstmt.close();

		//rs=stmt.executeQuery(goalSql);
		pstmt = connection.prepareStatement( goalSql);
		pstmt.setInt(1,mdcareplanid);
		pstmt.setInt(2,careplanid);
		pstmt.setString(3,locale);
		rs=pstmt.executeQuery();
		while(rs.next()){
			termSet=rs.getString("TERM_SET_ID");
			termCode=rs.getString("TERM_CODE");
			for(int i=0;i<Diagnosis.size();i=i+11){
				temptermSet=(String)Diagnosis.get(i);
				temptermCode=(String)Diagnosis.get(i+1);
				if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
					Goal=(ArrayList)Diagnosis.get(i+5);
					Goal.add(rs.getString("GOAL_CODE"));
					Goal.add(rs.getString("GOAL_DESC"));
				//Goal.add(rs.getString("GOAL_TARGET_DATE"));
					InterventionOutcome	=	new HashMap();
					Goal.add(InterventionOutcome);
					Goal.add(rs.getString("STATUS"));
					Goal.add(rs.getString("APPL_YN"));
					Goal.add(rs.getString("APPL_YN"));
				}
			}
		}
		pstmt.close();
		rs.close();
		//rs=stmt.executeQuery(interventionSql);
		pstmt = connection.prepareStatement( interventionSql);
		pstmt.setInt(1,mdcareplanid);
		pstmt.setInt(2,careplanid);
		pstmt.setString(3,locale);
		rs=pstmt.executeQuery();
		while(rs.next()){
			termSet=rs.getString("TERM_SET_ID");
			termCode=rs.getString("TERM_CODE");
			goalCode=rs.getString("GOAL_CODE");
			grpid1=rs.getString("GROUP_ID");
			for(int i=0;i<Diagnosis.size();i=i+11){
				temptermSet=(String)Diagnosis.get(i);
				temptermCode=(String)Diagnosis.get(i+1);
				if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
					Goal=(ArrayList)Diagnosis.get(i+5);
						if(Goal.contains(goalCode)){
							index=Goal.indexOf(goalCode);
							InterventionOutcome=(HashMap)Goal.get(index+2);
							if(InterventionOutcome.containsKey(grpid1)){
								IOGroup=(HashMap)InterventionOutcome.get(grpid1);
								Intervention=(ArrayList)IOGroup.get("I");
								Intervention.add(rs.getString("INTERVENTION_CODE"));
								Intervention.add(rs.getString("INTVN_DESC"));
								Intervention.add(rs.getString("STATUS"));
								Intervention.add(rs.getString("APPL_YN"));
								Intervention.add(rs.getString("APPL_YN"));
								Intervention.add(rs.getString("Intervention_type"));
							}else{
								IOGroup=new HashMap();
								Intervention=new ArrayList();
								Intervention.add(rs.getString("INTERVENTION_CODE"));
								Intervention.add(rs.getString("INTVN_DESC"));
								Intervention.add(rs.getString("STATUS"));
								Intervention.add(rs.getString("APPL_YN"));
								Intervention.add(rs.getString("APPL_YN"));
								Intervention.add(rs.getString("Intervention_type"));
								IOGroup.put("I",Intervention);
								InterventionOutcome.put(grpid1,IOGroup);
							}
						}
					}
				}
			}
			rs.close();
			pstmt.close();
		//rs=stmt.executeQuery(outcomeSql);
		pstmt = connection.prepareStatement( outcomeSql);
		pstmt.setInt(1,mdcareplanid);
		pstmt.setInt(2,careplanid);
		pstmt.setString(3,locale);
		rs=pstmt.executeQuery();
		while(rs.next()){
			termSet=rs.getString("TERM_SET_ID");
			termCode=rs.getString("TERM_CODE");
			goalCode=rs.getString("GOAL_CODE");
			grpid1=rs.getString("GROUP_ID");
			for(int i=0;i<Diagnosis.size();i=i+11){
				temptermSet=(String)Diagnosis.get(i);
				temptermCode=(String)Diagnosis.get(i+1);
				if(termSet.equals(temptermSet) && termCode.equals(temptermCode)){
					Goal=(ArrayList)Diagnosis.get(i+5);
					if(Goal.contains(goalCode)){
						index=Goal.indexOf(goalCode);
						InterventionOutcome=(HashMap)Goal.get(index+2);
						if(InterventionOutcome.containsKey(grpid1)){
							IOGroup=(HashMap)InterventionOutcome.get(grpid1);
							if(IOGroup.containsKey("O")){
								Outcome=(ArrayList)IOGroup.get("O");
								Outcome.add(rs.getString("OUTCOME_CODE"));
								Outcome.add(rs.getString("OUTCOME_DESC"));			
								Outcome.add(rs.getString("STATUS"));
								Outcome.add(rs.getString("APPL_YN"));	
								Outcome.add(rs.getString("APPL_YN"));	

							}else{
								Outcome=new ArrayList();
								Outcome.add(rs.getString("OUTCOME_CODE"));
								Outcome.add(rs.getString("OUTCOME_DESC"));			
								Outcome.add(rs.getString("STATUS"));
								Outcome.add(rs.getString("APPL_YN"));	
								Outcome.add(rs.getString("APPL_YN"));
								IOGroup.put("O",Outcome);
							}
						}
					}
				}
			}
		}
		rs.close();
		pstmt.close();
	

            _bw.write(_wl_block9Bytes, _wl_block9);

	for(int i=0;i<Diagnosis.size();i=i+11){
		termSet=(String)Diagnosis.get(i);
		termCode=(String)Diagnosis.get(i+1);
		diagDesc=(String)Diagnosis.get(i+2);	
		startdate=(String)Diagnosis.get(i+3);
		if(startdate==null || startdate.equals(""))
			startdate="";
		if(enddate==null || enddate.equals(""))
			enddate="";		
		enddate=(String)Diagnosis.get(i+4);
		Goal=(ArrayList)Diagnosis.get(i+5);
		diagStatus=(String)Diagnosis.get(i+6);
		diagappln_yn=(String)Diagnosis.get(i+8);

		if(diagStatus.equals("O") && diagappln_yn.equals("Y"))
			diagStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
		else if(diagStatus.equals("O") && diagappln_yn.equals("N"))
			diagStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		else if(diagStatus.equals("R"))
			diagStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
		else if(diagStatus.equals("D"))
			diagStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
		else if(diagStatus.equals("9"))
			diagStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

		if(!diagStatus.equals("O")){
			diagenabled="Disabled";	
		}
		

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(diagStatuslegend));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(diagenabled));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(diagDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(startdate));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(enddate));
            _bw.write(_wl_block18Bytes, _wl_block18);

		for(int j=0;j<Goal.size();j=j+6){
			goalCode=(String)Goal.get(j);
			goalDesc=(String)Goal.get(j+1);
			InterventionOutcome=(HashMap)Goal.get(j+2);
			goalStatus=(String)Goal.get(j+3);
			goalappln_yn=(String)Goal.get(j+4);

			if(goalStatus.equals("O") && goalappln_yn.equals("Y"))
				goalStatuslegend="Pending";
			else if (goalStatus.equals("O") && goalappln_yn.equals("N"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
			else if(goalStatus.equals("P"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.PartiallyAchieved.label","cp_labels");
			else if(goalStatus.equals("A"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Achieved.label","cp_labels");
			else if(goalStatus.equals("N"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.NotAchieved.label","cp_labels");
			else if(goalStatus.equals("D"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
			else if(goalStatus.equals("9"))
				goalStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

			if(diagStatus.equals("O") && diagappln_yn.equals("Y")){
				if(!(goalStatus.equals("O") || goalStatus.equals("P"))){
					goalenabled="Disabled";
					goalenabled1="Disabled";
					if(goalappln_yn.equals("Y"))
						goalchecked="checked";
					else
						goalchecked="";

				}else{
					goalenabled="";
					if(goalappln_yn.equals("Y"))
						goalchecked="checked";
					else{
						goalchecked="";
						goalenabled="";
						goalenabled1="Disabled";
					}

				}

			}

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(goalStatuslegend));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(diagenabled));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(goalenabled));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(goalchecked));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(goalDesc));
            _bw.write(_wl_block26Bytes, _wl_block26);

			Set itr_set			=	InterventionOutcome.keySet();
			Iterator recordItr		=	itr_set.iterator();
			while(recordItr.hasNext()){
				grpid1="";
				grpid1=(String)recordItr.next();
				IOGroup=(HashMap)InterventionOutcome.get(grpid1);
				Intervention=(ArrayList)IOGroup.get("I");
				if(IOGroup.containsKey("O"))
					Outcome=(ArrayList)IOGroup.get("O");


            _bw.write(_wl_block27Bytes, _wl_block27);


				if(goalchecked.equals("checked") && goalenabled.equals("")){
					

            _bw.write(_wl_block28Bytes, _wl_block28);
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(goalCode));
            out.print( String.valueOf(grpid1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(grpid1));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

				}else if(goalenabled.equals("")){

            _bw.write(_wl_block28Bytes, _wl_block28);
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(goalCode));
            out.print( String.valueOf(grpid1));
            _bw.write(_wl_block34Bytes, _wl_block34);


				}
				for(int k=0;k<Intervention.size();k=k+6){
					IntvnCode=(String)Intervention.get(k);
					IntvnDesc=(String)Intervention.get(k+1);
					IntvnStatus=(String)Intervention.get(k+2);
					Intvnappln_yn=(String)Intervention.get(k+3);

					if(IntvnStatus.equals("O") && Intvnappln_yn.equals("Y"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
					else if (IntvnStatus.equals("O") && Intvnappln_yn.equals("N"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
					else if(IntvnStatus.equals("P"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartiallyCompleted.label","common_labels");
					else if(IntvnStatus.equals("C"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
					else if(IntvnStatus.equals("D"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
					else if(IntvnStatus.equals("9"))
						IntvnStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

					if(diagStatus.equals("O") &&(goalStatus.equals("O")||goalStatus.equals("P"))){
						if(!(IntvnStatus.equals("O") || IntvnStatus.equals("P"))){
							Intvnenabled="Disabled";
							if(Intvnappln_yn.equals("Y"))
								Intvnchecked="Checked";
							else
								Intvnchecked="";
						}else{
							Intvnenabled="";
							if(Intvnappln_yn.equals("Y"))
								Intvnchecked="Checked";
							else
								Intvnchecked="";


						}
					}
					

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(IntvnStatuslegend));
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(diagenabled));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(goalenabled1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Intvnenabled));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Intvnchecked));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(goalCode));
            out.print( String.valueOf(IntvnCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(grpid1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(IntvnCode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(IntvnDesc));
            _bw.write(_wl_block41Bytes, _wl_block41);

					IntvnDesc="";
					IntvnStatus="";
					IntvnStatuslegend="";
					Intvnchecked="";
					Intvnenabled="";
					Intvnappln_yn="";
				}
				if(Outcome!=null){
					for(int k=0;k<Outcome.size();k=k+5){
						outcomeCode=(String)Outcome.get(k);
						outcomeDesc=(String)Outcome.get(k+1);
						
						outcomeStatus=(String)Outcome.get(k+2);
						outcomeappln_yn=(String)Outcome.get(k+3);

						if(outcomeStatus.equals("O") && outcomeappln_yn.equals("Y"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
						else if(outcomeStatus.equals("O") && outcomeappln_yn.equals("N"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						else if(outcomeStatus.equals("P"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.PartiallyAchieved.label","cp_labels");
						else if(outcomeStatus.equals("A"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Achieved.label","cp_labels");
						else if(outcomeStatus.equals("N"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.NotAchieved.label","cp_labels");
						else if(outcomeStatus.equals("D"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
						else if(outcomeStatus.equals("9"))
							outcomeStatuslegend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
			
						if(diagStatus.equals("O") &&(goalStatus.equals("O")||goalStatus.equals("P"))){
							if(!(outcomeStatus.equals("O") || outcomeStatus.equals("P"))){
								outcomeenabled="Disabled";
								if(outcomeappln_yn.equals("Y"))
									outcomechecked="Checked";
								else
									outcomechecked="";
							}else{
								outcomeenabled="";
								if(outcomeappln_yn.equals("Y"))
									outcomechecked="Checked";
								else
									outcomechecked="";
							}	
						}

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(outcomeStatuslegend));
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(diagenabled));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(goalenabled1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(outcomechecked));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(outcomeenabled));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(goalCode));
            out.print( String.valueOf(outcomeCode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(grpid1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(outcomeCode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(outcomeDesc));
            _bw.write(_wl_block41Bytes, _wl_block41);

						outcomeDesc="";
						outcomeStatus="";
						outcomeStatuslegend="";
						outcomechecked="";
						outcomeenabled="";
						outcomeappln_yn="";
					}

				}
				IOGroup=null;
				Intervention=null;
				Outcome=null;
			}

            _bw.write(_wl_block45Bytes, _wl_block45);

			goalDesc="";
			goalStatus="";
			goalappln_yn="";
			goalenabled="";
			goalenabled1="";
			goalchecked="";
			goalStatuslegend="";
			InterventionOutcome=null;
						
		}
		diagDesc="";
		startdate="";
		enddate="";
		diagStatus="";
		diagStatuslegend="";
		diagenabled="";
	}

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(care_plan_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(md_care_plan_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(care_mgr_id));
            _bw.write(_wl_block51Bytes, _wl_block51);

	
	ReviseCarePlan.putObject(Diagnosis);
	//out.println("Diagnosis"+Diagnosis);

	}catch(Exception e){
		System.err.println(e.toString());
		e.printStackTrace();
	}finally{
	  if (rs != null)   rs.close();
	  if (pstmt != null) pstmt.close();
	  ConnectionManager.returnConnection(connection,request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
}
