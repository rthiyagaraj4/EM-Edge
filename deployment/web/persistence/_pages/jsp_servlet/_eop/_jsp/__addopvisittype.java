package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eAE.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addopvisittype extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/addOPVisitType.jsp", 1715246574830L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\t\t\t\t\n\t<!-- Overview: This program called for two operations.One is Insert Mode\n\t     and  other is Modify mode.These mode values are stored one variable\n\t\t -- fnvalue.Take one boolean variable newvisittype,If fnvalue is Insert\n\t\t then boolean variable is true otherwise false.Based on Operation the\n\t\t corresponding details are passed to VisitTypeServlet -->\t\n\t\t\n\t\t\n<html>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n      \t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eOP/js/Visittype.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/Colourpalette.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n </head>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n     <body OnMouseDown=\'CodeArrest()\' onload=\'FocusFirstElement();\' onKeyDown = \'lockKey();\' >\n      \t<form name=\'visittype_form\' id=\'visittype_form\' action=\'../../servlet/eOP.VisitTypeServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<div id=\'colorpicker201\' class=\'colorpicker201\' style=\"LEFT: 670px; DISPLAY: block; TOP: 330px;\"></div>\n      \t<BR><BR><BR><BR><BR>\n\t\t\t<div align=\'left\' >\n\t\t\t <input type=\'hidden\' name=\'install\' id=\'install\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n      \t<table width=\'60%\' border=0 align=\'center\'>\n      \t<tr><td  valign=\'center\' width=\'60%\'>\n      \t<center>\n      \t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' >\n      \t\t<tr>\n      \t\t    <td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n      \t\t    <td width=\'60%\' class=\'fields\' colspan=\'2\'><input type=\'text\' name=\'visit_type_code\' id=\'visit_type_code\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" size=\'2\' maxlength=\'2\' onKeyPress=\"return CheckForSpecChars(event)\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n      \t\t    <img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n      \t\t</tr>\n\n     \t\t<tr>\n      \t\t    <td  width=\'30%\' class=label>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n      \t\t    <td width=\'70%\'  class=\'fields\' colspan=\'2\'><input type=\'text\' name=\'long_desc\' id=\'long_desc\' size=\'32\' onBlur = \'makeValidString(this)\' maxlength=\'30\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n      \t\t    <img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n      \t\t</tr>\n\n     \t\t<tr>\n      \t\t    <td  width=\'30%\' class=label>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t    <td width=\'70%\'  class=\'fields\' colspan=\'2\'>\n\t\t    <input type=\'text\' name=\'short_desc\' id=\'short_desc\' size=\'20\'  onBlur = \'makeValidString(this)\' maxlength=\'15\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >\n\t\t    <img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n      \t\t</tr>\n\n     \t\t<tr>\n      \t\t\t<td width=\'30%\' class=\'label\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n      \t\t\t<td width=\'70%\' class=\'fields\' colspan=\'2\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t   \t\t<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t   \t\t</td>\n   \t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\'30%\' class=\'label\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t<td width=\'10%\' class=\'fields\'><input type=\'text\' name=\'max_appt_duration\' id=\'max_appt_duration\' size=\'4\' maxlength=\'4\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" onKeyPress=\'return allowValidNumber(this,event,4,0)\' ></td>\n\t\t\t<td width=\'60%\' class=\'querydata\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td width=\'30%\' class=\'label\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t<td width=\'10%\' class=\'fields\'>\n\t\t\t<input type=\'text\' name=\'max_appt_slots\' id=\'max_appt_slots\' onKeyPress=\'return allowValidNumber(this,event,3,0)\' size=\'3\' maxlength=\'3\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" ></td>\n\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t</tr>\n     \t\t<tr>\n      \t\t\t<td width=\'30%\' class=\'label\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t</td>\n   \t\t</tr>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<tr>\n      \t\t     <td width=\'30%\' class=\'label\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n      \t\t     <td width=\'70%\' colspan=\'2\'  class=\'fields\'>\n      \t\t     <input type=\'checkbox\' name=\'rd_appl_yn\' id=\'rd_appl_yn\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" onClick=\"assignValue()\"></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<tr>\n      \t\t     <td width=\'30%\' class=\'label\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n      \t\t     <td width=\'70%\' colspan=\'2\'  class=\'fields\'> \n      \t\t     <input type=\'checkbox\' name=\'eff_status\' id=\'eff_status\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="  onClick=\"change()\"></td></tr> <!--  added by mujafar for KDAH-CRF-0526 -->\n\t\t\t\t \n\t\t\t\t \t ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<tr>\n      \t\t\t<td width=\'30%\' class=\'label\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n      \t\t\t<td width=\'70%\' class=\'fields\' colspan=\'2\'>\n             &nbsp;<input type=\"text\" size=\"12\" name=\"colour_code_disply\"  id=\"colour_code_disply\" style=\"background-color:";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" readonly ><input type=\"button\" value=\'?\' onclick=\"showColorGrid2(\'colour_code_id\',\'colour_code_disply\');\">&nbsp;<input type=\"hidden\" name=\"colour_code_id\" id=\"colour_code_id\"value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\t</td>\n   \t\t</tr>\n   \t\t\n   \t\t\n   \t\t<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U2) on 18-04-2023 Started -->\n   \t\t\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t<tr>\n      \t\t     <td width=\'30%\' class=\'label\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n      \t\t     <td width=\'70%\' colspan=\'2\'  class=\'fields\'> \n      \t\t     <input type=\'checkbox\' name=\'virtual_consultation\' id=\'virtual_consultation\' id=\'virtual_consultation\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="  onClick=\"changeVCvalue()\"></td>\n      \t\t     </tr>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<input type=\'hidden\' name=\'virtual_consultation\' id=\'virtual_consultation\' id=\'virtual_consultation\' value=\"D\">\t\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U2) on 18-04-2023 End -->\n   \t\t\n   \t\t\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n      \t</table>\n      \t</td>\n      \t</table>\n      \t</div>\n    ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n      \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n      \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\n      ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\n      \t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n      \t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n     ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n   \n\t\t\t <input type=\'hidden\' name=\'hiddenscriteria\' id=\'hiddenscriteria\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\n      \t</form>\n      \t</body>\n<script>\n\t\tif(document.forms[0].function_name.value==\"modify\")\n\t\t\t\tselectOrderableCriteria();\n</script>\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


   String facilityid = (String) session.getValue( "facility_id" ) ;	
   String visit_type_code=""; // Used to Store Visit Type Code
   String longdesc="";
   String shortdesc="";
   String visit_type_ind="";	// Used to Store visit type indicator value
   String max_appt_duration=""; // Used to store maximum appointment duration for patient - not to                                  exceed 1440 minutes
   String max_appt_slots="";  // Used to store maximum appointment slots
  
   String vtype="";
   String vtype1="";
   String effstatus=""; // Used to Store Effective Status either 'E' or 'D'
   
   String checkBoxAttribute_VC=""; //added by Himanshu Saxena for ML-MMOH-CRF-1930(U2)
   String effstatus_VC="D"; //added by Himanshu Saxena for ML-MMOH-CRF-1930(U2)
		   
   String codeTextAttribute=""; // used for visit type code
   String otherTextAttribute=""; // Used for  effective status whether it is (enabled/disabled)  
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   String rd_appl_yn="";
 
   String radApplYnChk = "";
   String radApplYnDis = "";
   String ris_oa_integrate = "N";
   String disCheckBoxAttribute=""; // added by mujafar for KDAH-CRF-0526
  
   //String sel="";
  
  String color_indicator=""; // color indicator used to store visit type colour code value. BRU-HIMS-CRF-177
  
   Connection conn =null;
   String service_criteria="";
   StringBuffer service_criteria_sel=new StringBuffer();

  try
  {
	conn=ConnectionManager.getConnection(request);
	Boolean isAERegisterTypeAutoUpdateAppl =	CommonBean.isSiteSpecific(conn, "AE", "AE_REG_TYPE_AUTO_UPDATE"); // added by mujafar for KDAH-CRF-0526
	Boolean isVIRTUAL_CONSULTATION  = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","VIRTUAL_CONSULTATION");//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 17-04-2023 -->

	Statement st=null;
	ResultSet rset=null;
	st=conn.createStatement();
	String sql3="";
	String installed_yn="N";
  	sql3="select install_yn, (select 'Y' from sm_function_control where functionality_id = 'RD_OA_INTEGRATE') ris_oa_integrate from sm_module where module_id='OR'";
	
	rset=st.executeQuery(sql3);
	if(rset != null && rset.next())
	  {
	   installed_yn=rset.getString(1);
	   ris_oa_integrate=rset.getString("ris_oa_integrate")==null?"N":rset.getString("ris_oa_integrate"); //Added this line for incident [36918]
	  }
	if(rset != null) rset.close();
	
	boolean newVisitType=false; // Used whether the visit type is create mode or modify mode
                                
/* if visit type is create mode 
    then set the variable newvisittype is true and continue the process. 
	otherwise take the data from the database based on visit type code
	and set the newvisittype is false
*/


            _bw.write(_wl_block2Bytes, _wl_block2);


	visit_type_code=request.getParameter("visit_type_code");
	               
	if(visit_type_code==null){
		visit_type_code="";
		longdesc="";
		shortdesc="";

		
	
		if(isAERegisterTypeAutoUpdateAppl) // added by mujafar for KDAH-CRF-0526
		{
			visit_type_ind="<select name='visit_type_ind' id='visit_type_ind' onChange='populateCriteria(this,this.form)'><option value=''>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;</option><option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels")+"&nbsp;<option value='L'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels")+"&nbsp;<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+"&nbsp;<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+"&nbsp;<option value='W'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels")+"&nbsp;<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels")+"&nbsp;<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels")+"&nbsp;</select>";

		}

		else
		{

		visit_type_ind="<select name='visit_type_ind' id='visit_type_ind' onChange='populateCriteria(this,this.form)'><option value=''>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;</option><option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels")+"&nbsp;<option value='L'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels")+"&nbsp;<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+"&nbsp;<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+"&nbsp;<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels")+"&nbsp;<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels")+"&nbsp;</select>";
		}
		max_appt_duration="";
		max_appt_slots="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED"; //Used for checkbox is checked or not
		newVisitType=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'"; //whatever case you enter either                                                        Lower OR Upper it will convert Uppercase 
		/* Resource Scheduling */

		if(!installed_yn.equals("Y"))
		{
			service_criteria_sel.append("<select name='scriteria' id='scriteria'><option value=''>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;</option> </select>");
		}
		else
		{
			service_criteria_sel.append( "<select name='scriteria' id='scriteria'><option value=' '>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;</option> </select>&nbsp;<img id='criteriaImg' align='center' src='../../eCommon/images/mandatory.gif'>");
		}
		
		/* Resource Scheduling */

	}else
		{
    	 
		try{
		
        /* The sql query is used to retrieve the values from
		the table op_visit_type based on the visittype code and facility_id 
		for modifying the data
		*/
                
        
		String sql = "select visit_type_code,long_desc,short_desc,visit_type_ind,eff_status,virtual_consultation,max_appt_duration,max_appt_slots,ORDER_CATALOG_CRITERIA,rd_appl_yn,color_indicator from op_visit_type where visit_type_code='"+visit_type_code+"' and facility_id ='"+facilityid+"'";
	    	
		rset = st.executeQuery(sql);
		rset.next();
		 
		visit_type_code=rset.getString("visit_type_code");
		longdesc=rset.getString("long_desc");
		shortdesc=rset.getString("short_desc");
		vtype =rset.getString("visit_type_ind");
		max_appt_duration = rset.getString("max_appt_duration");
		max_appt_slots= rset.getString("max_appt_slots");
		if(max_appt_duration == null) max_appt_duration = "";
		if(max_appt_slots== null) max_appt_slots = "";
		effstatus=rset.getString("eff_status");
		if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			checkBoxAttribute="";
		}else{
       		otherTextAttribute="";
			checkBoxAttribute="CHECKED";
		}
		
		//added by Himanshu Saxena for ML-MMOH-CRF-1930(U2) Started //
		effstatus_VC=rset.getString("virtual_consultation");
		if(effstatus_VC.equals("D")){
			checkBoxAttribute_VC="";
		}else{
			checkBoxAttribute_VC="CHECKED";
		}//added by Himanshu Saxena for ML-MMOH-CRF-1930(U2) Started //
		

		if(isAERegisterTypeAutoUpdateAppl) // added by mujafar for KDAH-CRF-0526
			{
				int loc_cnt = eAE.AECommonBean.getEffectiveStatus(conn,visit_type_code,facilityid);	
			

				if(loc_cnt>0 && effstatus.equals("E"))
				{disCheckBoxAttribute="disabled";
					checkBoxAttribute="CHECKED";}
			}


		
        service_criteria = (rset.getString("ORDER_CATALOG_CRITERIA")== null)?"":rset.getString("ORDER_CATALOG_CRITERIA");
        rd_appl_yn = (rset.getString("rd_appl_yn")== null)?"N":rset.getString("rd_appl_yn");
		
		color_indicator=rset.getString("color_indicator")==null?"":rset.getString("color_indicator"); //Added  [Bru-HIMS-CRF-177]
		
		if(rd_appl_yn.equals("Y")){
			radApplYnChk = "checked";
			radApplYnDis = "disabled";
		}else{
			radApplYnChk = "";
			radApplYnDis = "";
		}

        String service_criteria_value =""; 	
		
		if(service_criteria!=null) {
			
			if(service_criteria.equals("R"))
				service_criteria_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.required.label","common_labels");
			else if(service_criteria.equals("N"))
				service_criteria_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notrequired.label","common_labels");
			else if(service_criteria.equals(""))				service_criteria_value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		}
		
		if(effstatus.equals("E"))
			{
					if(!installed_yn.equals("Y"))
				 {
						service_criteria_sel.append( "<input type='text' name='scriteriaDisplay' id='scriteriaDisplay' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels")+"' size='15' maxlength='15' readonly> <input type=hidden name='scriteria' id='scriteria' value=''>");
				 }
				else
				 {
				service_criteria_sel.append("<select name='scriteria' id='scriteria'><option value=' ' >&nbsp;--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------&nbsp;</option><option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.required.label","common_labels")+"</option><option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notrequired.label","common_labels")+" </option></select>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>");	
				 }
			}
			else
			{
				service_criteria_sel.append("<input type='text' name='scriteriaDisplay' id='scriteriaDisplay' value='"+service_criteria_value+"' size='15' maxlength='15' readonly> <input type=hidden name='scriteria' id='scriteria' value='"+service_criteria+"'>");

				if(installed_yn.equals("Y"))
				{
					service_criteria_sel.append("&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>");
				}
			}
	
		if (vtype.equals("F")) {
			
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else if(vtype.equals("L")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else if(vtype.equals("R")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else if(vtype.equals("E")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}


	


	else if(vtype.equals("W") && isAERegisterTypeAutoUpdateAppl) { // added by mujafar for KDAH-CRF-0526
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}





		else if(vtype.equals("S")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
		visit_type_ind= "<input type='text' name='visit_type_ind' id='visit_type_ind' value='"+vtype1+"' size='20' maxlength='20' readonly>";
	      }

     }catch(Exception e){
		e.printStackTrace();
		 }
     finally 
		{        
		     try{
				if (rset!= null) rset.close();
	           	if (st != null) st.close();
			 }catch(Exception e){}
		}
		codeTextAttribute="READONLY";
		newVisitType=false;
		eventFunctionForCase="";
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
/*Below Div Added for this CRF [Bru-HIMS-CRF-177]*/	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(installed_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(codeTextAttribute));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eventFunctionForCase));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(longdesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(max_appt_duration));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(max_appt_slots));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(otherTextAttribute));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
out.println(service_criteria_sel.toString().trim());
            _bw.write(_wl_block28Bytes, _wl_block28);
if(ris_oa_integrate.equals("Y")){
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rd_appl_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(radApplYnChk));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(radApplYnDis));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disCheckBoxAttribute));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block35Bytes, _wl_block35);
/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(color_indicator));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(color_indicator));
            _bw.write(_wl_block40Bytes, _wl_block40);
if(isVIRTUAL_CONSULTATION){ 
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(effstatus_VC));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(checkBoxAttribute_VC));
            _bw.write(_wl_block44Bytes, _wl_block44);

}else
{
	
            _bw.write(_wl_block45Bytes, _wl_block45);

}

            _bw.write(_wl_block46Bytes, _wl_block46);
//End [Bru-HIMS-CRF-177]
            _bw.write(_wl_block47Bytes, _wl_block47);
  if(newVisitType){
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(service_criteria));
            _bw.write(_wl_block51Bytes, _wl_block51);

  }catch(Exception e) {e.printStackTrace();}
finally{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.INDICATOR.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.MaxApptDuration.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MIN.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.MaxApptSlots.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.OrderableCriteria.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ApplicableToRadiology.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Color.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.INDICATOR.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.virtualConsultation.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }
}
