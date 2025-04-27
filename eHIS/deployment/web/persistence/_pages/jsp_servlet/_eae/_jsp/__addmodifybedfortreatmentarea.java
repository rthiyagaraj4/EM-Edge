package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifybedfortreatmentarea extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/addModifyBedforTreatmentArea.jsp", 1709113824007L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n <!--  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n  <script language=\'javascript\' src=\'../../eAE/js/BedforTreatmentArea.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n  <script>\n      function setFocus()\n\t  {\n\t\t  if(document.forms[0].clinic_code.disabled==false)\n\t\t\t  document.forms[0].clinic_code.focus();\n\t\t \n\t  }\n\t\t\n\n  </script>\n</head>\n  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t <body OnMouseDown=\'CodeArrest()\' onLoad=\'setFocus();\' onKeyDown = \'lockKey()\'>\n\t <form name=\"bed_treatment_area_form\" id=\"bed_treatment_area_form\" action=\"../../servlet/eAE.BedforTreatmentAreaServlet\" method=\"post\" target=\"messageFrame\">\n\n\t <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'90%\'>\n\t\t <br><br><br><br><br><br><br><br><br>\n\t    <tr>\n\t\t   <td colspan=\'4\'>&nbsp;</td>\n\t\t</tr>\n\t    <tr>\n\t\t      <td align=\'left\' width=\'12%\'>&nbsp;</td> \t\n\t\t      <td class=\'label\' align=\'right\' width=\'25%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t      <td class=\'label\' align=\'left\' width=\'40%\'>&nbsp;<select name=\'clinic_code\' id=\'clinic_code\'  onChange=\'popTreatmentCode(this);\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">\n\t\t      <option value=\'\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t      ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t      </select>\n   \t\t      <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t  </td> \t\n\t\t      <td align=\'left\' width=\'13%\'>&nbsp;</td>\n\t    </tr>\t\n\t\t<tr>\n\t\t   <td colspan=\'4\'>&nbsp;</td>\n\t\t</tr>\n\n\t\t\t\t\n<tr> \n\t\t      <td align=\'left\' width=\'12%\'>&nbsp;</td> \t\n\t\t      <td class=\'label\' align=\'right\' width=\'25%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t      <td class=\'label\' align=\'left\' width=\'40%\'>&nbsp;\n\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t   <input type=\'text\' name=\'treatment_area_code1\' id=\'treatment_area_code1\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' maxLength=\'15\' size=\'15\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">  \n\t\t\t\t   <input type=\'hidden\' name=\'treatment_area_code\' id=\'treatment_area_code\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' >   \n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<select name=\'treatment_area_code\' id=\'treatment_area_code\'  value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n<!-- \n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' selected > ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</option>  -->\n\t\t      </select>\n \t\t      \n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\n\t\t\t  <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n              </td>\n\t          <td align=\'left\' width=\'13%\'>&nbsp;</td> \n        </tr>\n\n\t\t<tr>\n\t\t   <td colspan=\'4\'>&nbsp;</td>\n\t\t</tr>\n\t\t\n<tr>\n\n\t<td align=\'left\' width=\'10%\'>&nbsp;</td> \t\n\t<td class=\'label\' align=\'right\' width=\'30%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t<td class=\'label\' align=\'left\' width=\'45%\'>&nbsp;<input type=\'text\' name=\'bed_no\' id=\'bed_no\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" maxLength=\'8\' size=\'8\' \n\tonKeyPress=\"return CheckForSpecChars(event);\" >\n\t  <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t</td>\n\t<td align=\'left\' width=\'15%\'>&nbsp;</td> \n\n</tr>\n\t<tr>\n\t\t   <td colspan=\'4\'>&nbsp;</td>\n\t\t</tr>\n\t\n<tr>\n\n<td colspan=\'1\'>&nbsp;</td>\n<td class=\'label\' align=\'right\' width=\'\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n<td align=left class=LABEL width=\'\' >\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t<input type=\'text\' name=\'bay_type_desc\' id=\'bay_type_desc\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' maxLength=\'15\' size=\'15\' readonly>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img> \n\t<input type=\'hidden\' name=\'bay_type\' id=\'bay_type\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' > \n\t\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t&nbsp;<select name=\'bay_type\' id=\'bay_type\'  >\n<option value=\'\'>------";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="------</option>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\n<option value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</option>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\n\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n</td>\n<td colspan=\'1\'>&nbsp;</td>\t\n\n</tr>\n\t\t<tr>\n\t\t   <td colspan=\'4\'>&nbsp;</td>\n\t\t</tr>\n\t\t <tr>\n\t\t      <td align=\'left\' width=\'12%\'>&nbsp;</td> \t\n\t\t      <td class=\'label\' align=\'right\' width=\'25%\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t      <td class=\'label\' align=\'left\' width=\'40%\'><input type=\'checkbox\' name=\'pseudo_bed\' id=\'pseudo_bed\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" onClick=\'chkValuePseudoBed(this);\'>\n              </td>\n\t          <td align=\'left\' width=\'13%\'>&nbsp;</td> \n\t\t </tr><tr>\n\t\t   <td colspan=\'4\'>&nbsp;</td></tr><tr>\n\t\t      <td align=\'left\' width=\'12%\'>&nbsp;</td> \t\n\t\t      <td class=\'label\' align=\'right\' width=\'25%\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t      <td class=\'label\' align=\'left\' width=\'40%\'><input type=\'checkbox\' name=\'eff_status\' id=\'eff_status\'value=\"E\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="  onClick=\'chkValue(this);\'>\n              </td>\n\t          <td align=\'left\' width=\'13%\'>&nbsp;</td> \n        </tr>\n\t\t\n\t\t<tr>\n\t\t   <td colspan=\'4\'>&nbsp;</td>\n\t\t</tr>\n\t\t\n\t\t\n\t    \n\t </table> \n\t\t     <input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' >\t\n\t\t\t <input type=\'hidden\' name=\'clinic_code_val\' id=\'clinic_code_val\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\t \t\n\t\t\t <input type=\'hidden\' name=\'treatment_area_code_val\' id=\'treatment_area_code_val\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' >\t \t\n\t\t\t <input type=\'hidden\' name=\'bed_no_val\' id=\'bed_no_val\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' >\t \t\n\t\t\t <input type=\'hidden\' name=\'eff_status_val\' id=\'eff_status_val\' value=\'Y\' >\t\n        \t\n\n\t\t\t <input type=\'hidden\' name=\'pseudo_bed_val\' id=\'pseudo_bed_val\' value=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" >\t\t \n\t\t\t <input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t\t \n\t\t\t \n\n\n\n\t </form>\n\t\t  \n    </body>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n</html>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
     request.setCharacterEncoding("UTF-8");
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 String	facilityId 					= (String) session.getValue( "facility_id" ) ;
	 String mode						= "";
	////////////////////
	ArrayList Arr_Of_HashMap=new ArrayList();
	HashMap general_HashMap=new HashMap();

///////////////////
	 

	 String clinic						= " select  distinct clinic_code, clinic_desc from ae_tmt_area_for_clinic_vw where eff_status = 'E' and facility_id=? order by 2 ";


 	  String clinic_code_result			= request.getParameter("clinic_code");
		 clinic_code_result 			= (clinic_code_result == null)?"":clinic_code_result;
	
	 String treatment_area_code_result	= request.getParameter("treatment_area_code");
		 treatment_area_code_result		= (treatment_area_code_result == null)?"":treatment_area_code_result;
	
	 String bed_no_result		= request.getParameter("bed_no");
	 	 bed_no_result			= (bed_no_result == null)?"":bed_no_result;
	
  try
  {
     con								= ConnectionManager.getConnection(request);
     String clinic_code					= "";
	 String treatment_area_code			= "";
	 String treatment_area_code_desc    = "";
 	 String bed_no						= "";            
	 String eff_status					= "";	
	 String pseudo_bed					= "";
	 String checkBoxAttribute			= "";
	 String checkBoxAttribute1			= "";
 	 //String disabledField				= "";
	 //String disabledfields				= "";
	 String bay_type_code="";
	 String bay_type_desc="";
	 String readonly  ="";
	 String modifymode="";

	// String modify						= "";
	// String readOnlyAttribute			= "";
	 //String readOnlyAttribute1			= "";
	
	mode							= "INSERT";
   
    String sql = "SELECT A.CLINIC_CODE, A.TREATMENT_AREA_CODE, B.SHORT_DESC trtmt_code_desc, A.BED_NO, A.PSEUDO_BED_YN, A.EFF_STATUS, A.BAY_TYPE_CODE,c.short_desc FROM AE_BED_FOR_TRMT_AREA A, AE_TMT_AREA_FOR_CLINIC B,ae_bay_type c WHERE A.TREATMENT_AREA_CODE = B.TREATMENT_AREA_CODE AND a.bay_type_code = c.bay_type_code and A.CLINIC_CODE=? AND A.TREATMENT_AREA_CODE=? AND A.BED_NO=? AND A.FACILITY_ID=? ";

//	AND B.OPEN_TO_ALL_PRAC_FOR_CLINIC_YN='N' AND B.EFF_STATUS='E'

//	"select clinic_code,treatment_area_code,bed_no,pseudo_bed_yn, eff_status,bay_type_code from AE_BED_FOR_TRMT_AREA where clinic_code=? and treatment_area_code=? and bed_no=? and facility_id=? ";

	
 if(!(clinic_code_result.equals("") && treatment_area_code_result.equals("") && bed_no_result.equals("")))
  {
	  
	pstmt   = con.prepareStatement(sql);
	pstmt.setString(1,clinic_code_result);
	pstmt.setString(2,treatment_area_code_result);
	pstmt.setString(3,bed_no_result);
	pstmt.setString(4,facilityId);

	rset = pstmt.executeQuery();
	
	 while(rset!=null && rset.next())
	  {
			clinic_code					= rset.getString(1);    
			clinic_code 				= (clinic_code == null)?"":clinic_code;

			treatment_area_code			= rset.getString(2);
			treatment_area_code 		= (treatment_area_code == null)?"":treatment_area_code;

			treatment_area_code_desc	= rset.getString(3);
			treatment_area_code_desc 	= (treatment_area_code_desc == null)?"":treatment_area_code_desc;

			bed_no				        = rset.getString(4);
			bed_no 			            = (bed_no == null)?"":bed_no;

			pseudo_bed					= rset.getString(5)==null?"N":rset.getString(5);

			eff_status					= rset.getString(6);

			bay_type_code				= rset.getString(7);
			bay_type_code 			    = (bay_type_code == null)?"":bay_type_code;

			bay_type_desc=(rset.getString(8) == null)?"":rset.getString(8);
			
			
			
			
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute   = "CHECKED";
			}
			else
		    {
				   readonly="disabled";
            }


			if(pseudo_bed!=null && pseudo_bed.equalsIgnoreCase("Y"))
			{
					checkBoxAttribute1   = "CHECKED";
					//disabledfields		 = "disabled";//naveen
			}

			if(pseudo_bed!=null && pseudo_bed.equalsIgnoreCase("N"))
			{
					checkBoxAttribute1   = "";
					//disabledfields		 = "disabled";//naveen
			}

			mode						= "MODIFY";
			//modify						= "READONLY";	
			//disabledField				= "DISABLED";
			
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if clinic_code	  
	  if(mode.equalsIgnoreCase("INSERT"))
		{
		  checkBoxAttribute = "CHECKED";
		  checkBoxAttribute1 = "CHECKED";
		}else if(mode.equalsIgnoreCase("MODIFY")) modifymode="disabled";

   
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(modifymode));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

				 pstmt   = con.prepareStatement(clinic);
				 pstmt.setString(1,facilityId) ;
				 rset   = pstmt.executeQuery();
				 
				 while(rset!=null && rset.next())
				 {
					if(clinic_code.equals(rset.getString(1)))
						
	                    out.println("<option value='"+rset.getString(1)+"' selected>");	                
					else
                        out.println("<option value='"+rset.getString(1)+"'>");	     
					out.println(rset.getString(2));
					out.println("</option>"); 
				 }

				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
              
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
  if(mode.equalsIgnoreCase("MODIFY")) {
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(treatment_area_code_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modifymode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
} else {
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(modifymode));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(treatment_area_code_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(modifymode));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
  if(eff_status.equals("D")) {
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bay_type_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bay_type_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
else
	  {
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

	String sel="";
	
	String sqlBayType="select bay_type_code,short_desc from ae_bay_type where eff_status=? ORDER BY 2";

	String[] params={"E"};
	eAE.AEUtils oputils = new  eAE.AEUtils();
	
	Arr_Of_HashMap=oputils.getData(sqlBayType,params,request);
	general_HashMap.clear();

	for(int i=0; i<Arr_Of_HashMap.size();i++)
	{

	 sel="";
	 general_HashMap=(HashMap)Arr_Of_HashMap.get(i);
	 if(general_HashMap.get("BAY_TYPE_CODE").equals(bay_type_code)) sel="selected";
	

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(general_HashMap.get("BAY_TYPE_CODE")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(general_HashMap.get("SHORT_DESC")));
            _bw.write(_wl_block36Bytes, _wl_block36);
						

}

            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(pseudo_bed));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(checkBoxAttribute1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(pseudo_bed));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block48Bytes, _wl_block48);
 
	Arr_Of_HashMap.clear();
} catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
	    ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayNo.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayType.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.PseudoBedBay.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
}
