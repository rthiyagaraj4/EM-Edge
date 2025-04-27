package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class __addmodifydeathregisterbuttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AddModifyDeathRegisterButtons.jsp", 1743143156416L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script> \n\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\"../../eMR/js/DeathRegister.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t<script>\n\t\tasync function callAuditTrail(){\n\t\t\tvar dialogHeight= \"1000px\";\n\t\t\tvar dialogWidth = \"1000px\";\n\t\t\tvar dialogTop\t= \"100\";\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\t\t\t\n\t\t\tvar patient = parent.frames[1].document.forms[0].patient_id.value;\n\t\t\tvar encounter_id = parent.frames[1].document.forms[0].encounter_id.value;\n\t\t\tvar facilityId = parent.frames[1].document.forms[0].facilityId.value;\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogTop:\" + dialogTop + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\tvar jsp_name;\n\t\t\tjsp_name = \"../../eMR/jsp/ViewDeathRegisterAuditTrial.jsp?patient_id=\" + patient+\"&encounter_id=\"+encounter_id+\"&facilityId=\"+facilityId;\t\t\t\n\t\t\tretVal = await window.showModalDialog(jsp_name,arguments,features);\n\n\t\t}\n\n\t\t</script>\n\t</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<body>\n\t\t\t\t<form name=\"DR_Buttons_Form\" id=\"DR_Buttons_Form\">\n\t\t\t\t\t<table width=\'100%\' cellpadding=\'1\' cellspacing=\'0\' border=\'0\' >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\'10%\' class=\'fields\' align=\'right\'><input type=\"button\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' onclick=\"callAuditTrail();\" style=\"display:";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/></td>\n\t\t\t\t\t\t\t\t<td  width=\'90%\' colspan=\"3\" class=\'fields\'></td>\n\t\t\t\t\t\t\t\t<td  class=\'fields\' style=\"visibility:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";display:";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"><input type=\"button\"  name=\"save_btn\" id=\"save_btn\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onclick=\"Save(\'N\')\" /></td>\n\t\t\t\t\t\t\t\t<td  class=\'fields\' style=\"display:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"><input type=\"button\" name=\"finalize_btn\" id=\"finalize_btn\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onclick=\"Save(\'Y\')\" / ></td>\n\t\t\t\t\t\t\t\t<td  class=\'fields\' style=\"display:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"><input type=\"button\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onclick=\"printMDRCertificate1()\"/></td>\n\t\t\t\t\t\t\t\t<td  class=\'fields\' style=\"display:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"><input type=\"button\" name=\"clear_btn\" id=\"clear_btn\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onclick=\"resetValues();\"/></td>\n\t\t\t\t\t\t\t\t<td  class=\'fields\'><input type=\"button\" name=\"close_btn\" id=\"close_btn\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onclick=\"closeWindow();\"/></td>\n\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t <input type=\'hidden\' id=\'deathCerApplYn\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'></input><!--Added by Rameswar  Against  HSA-SCF-0143.1 [IN:055069]-->\n\t\t\t\t</form>\n\t\t\t</body>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</html>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	request.setCharacterEncoding("UTF-8"); 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String single_stage_death_reg_appl_yn="";// Getting from MR_Parameter Table.
	String visble_save_btn="";// To make visible or Hide of Save button,Based upon the value of  SINGLE_STAGE_DEATH_REG_APPL_YN.


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		try{
			String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"),"N");
			String call_from					=	checkForNull(request.getParameter("call_from"));
			String disable_btns="";
			String display_audit_btn="";
			String display_print_btn="";
			String mrdthcercount	= "";
			String MR_PARAM_SQL="SELECT SINGLE_STAGE_DEATH_REG_APPL_YN,(SELECT 1 FROM sm_report  WHERE report_id = 'MRDTHCER' and Module_id = 'MR') mrdthcercount FROM MR_PARAMETER";
			conn = ConnectionManager.getConnection(request);
			pstmt=conn.prepareStatement(MR_PARAM_SQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				single_stage_death_reg_appl_yn=checkForNull(rs.getString("SINGLE_STAGE_DEATH_REG_APPL_YN"));
				mrdthcercount=checkForNull(rs.getString("mrdthcercount"));
			}

			if(mrdthcercount.equals("")){
				display_print_btn	= "none;";
			}

			/*FYI:
			1.Based upon the parameter set up value wheather the MDR is to perfom single stage or multiple stage
			the below logic is used.
			2. if the parameter set to  'Y 'only finalize button will visible. if 'N' Both save and finalize buttons are visible.
			*/
			if(single_stage_death_reg_appl_yn.equals("Y")){
				visble_save_btn="hidden";
			}else{
				visble_save_btn="visible";
			}
			/*
				FYI:Once the MDR is finalized all the buttons are not visible.like wise the below logic works.	
			*/
			if(finalize_yn.equals("Y")){
				disable_btns="none";
			}else{
				disable_btns="";
			}
			/*
			FYI:If MDR is calling from IP Discharge Advice the audit trail button wouldnt visible.
			*/
			if(call_from.equals("IP_Discharge_Advice")){
				display_audit_btn="none";
			}else{
				display_audit_btn="";
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AuditTrail.label","common_labels")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(display_audit_btn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(visble_save_btn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disable_btns));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_btns));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalize.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(display_print_btn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_btns));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(mrdthcercount));
            _bw.write(_wl_block21Bytes, _wl_block21);
}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(conn,request);
	}
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
