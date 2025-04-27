package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifynursunitroom extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AddModifyNursUnitRoom.jsp", 1718263004982L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eIP/js/NursUnitRoom.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\nvar xxx;\nvar sleBox;\n\n</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"DC_UNITS_NOT_LINKED\",\"IP\"));\n\t\t\t\tdocument.location.href=\'../../eCommon/html/blank.html\'\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  class=\'CONTENT\' >\n\t\t<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eIP/jsp/AddModifyNursUnitRoom.jsp\' method=\'post\'>\n\n\t\t<table  width=\"90%\" border=0 align=\'center\'>\n\t\t<tr>\n\t\t<input type= hidden name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n\t\t<input type= hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t<input type= hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t<input type= hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t<input type= hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' >\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t\t<input type=hidden name=\'maxRecord\' id=\'maxRecord\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\t\t\n\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\t\n\t\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'></td> \n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\n\t\t</tr>\t\t\n\t\t</table>\n\t\t<br>\n\t\t<br>\n\t\t</tr>\n\t</table>\n\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t\t<th width=\'35%\' align=left>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t\t\t<th width=\'25%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </th> \n\t\t\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  </th>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<tr>\n\t\t\t<td width=\'1%\' class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\n\t\t<!--||||||||  CODED BY SRIDHAR ON 25 FEB 2004  |||||||||-->\n\t\t<!-- ||||||||||||||| LEVEL OF CARE INDICATOR  ||||||||||||||||-->\n\t\t<!-- The Select Option values are populated from Nursing Unit.\n\t\tIf value of [Level Of Care] Select option in Nursing Unit is null then all Default values will be populated from [am_level_of_care] table.\n\t\tIf there exists a value in [Level of care] wrt Nursing Unit code then only that Level of care value is populated as option value -->\n\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' width=\'15%\'>\n\t\t\t\t\t<select name=\"level";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"level";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onchange=\'ValueSelect(chk";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =",\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\");\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>&nbsp;------ ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="------&nbsp;   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<td align=\'left\' class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t<input type=\"hidden\" name=\"level";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" ></td> \n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t</select>\n\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t<input type=\'checkbox\' ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" name=\'chk";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'  value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' onclick=\'checkdis(this);SelectValue(this,\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\");RemSelectAll(this, ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =");\' >\n\t\t\t\t<input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'removeCode";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' value=\"\">\n\t\t\t\t<input type=\'hidden\' name=\'rm_num";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'rm_num";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'no_of_beds";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'no_of_beds";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' value= \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t\t\t\t<input type=\"hidden\" name=\"Update_yn\" id=\"Update_yn\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" ></td> \n\t\t\t\t<input type=\"hidden\" name=\"search_by\" id=\"search_by\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" ></td> \n\t\t\t\t<input type=\"hidden\" name=\"search_txt\" id=\"search_txt\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" ></td> \n\t\t   </td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t<script>\n\t\t\t\tif(document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t<script>\n\t\t\t\tif(document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'norecords\' id=\'norecords\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' >\t\n\t</form>\n  </body>\n</html>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.RecordSet accessRightRecSet= null;synchronized(session){
                accessRightRecSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightRecSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightRecSet==null){
                    accessRightRecSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightRecSet",accessRightRecSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.RecordSet accessRightRec= null;synchronized(session){
                accessRightRec=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightRec",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightRec==null){
                    accessRightRec=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightRec",accessRightRec,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.RecordSet accessRight= null;synchronized(session){
                accessRight=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRight",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRight==null){
                    accessRight=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRight",accessRight,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

/* ADDED by SRIDHAR on 23 FEB 2004 FOR LEVEL OF CARE INDIACTOR & CHECK BOX */
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String nursing_unit = (request.getParameter("nursing_unit_code") == null) ? "" : request.getParameter("nursing_unit_code");
	String search_by	= checkForNull(request.getParameter("search_by"));
	String search_txt	= checkForNull(request.getParameter("search_txt"));
String req_start	="", req_end	="";
	String checkedOnes  ="";
	String SelectedOnes  ="";
		String removeCode = "";

	String SelectedOnes2 = "";
	
	String from			= request.getParameter("from") ;
	String to			= request.getParameter("to") ;
	String LOC			= "";
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int count = 0;
	if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 14 ; }   else {  end = Integer.parseInt( to ) ; }
	req_start =   (request.getParameter("start")==null)   ?  "0" :   request.getParameter("start");
	req_end   =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus	="";
	Statement stmt3		= null;
	ResultSet rstlRs3	= null;
	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null ;
	ResultSet rset	= null;
	Statement Levelstmt = null;
	ResultSet LevelRset = null;
	PreparedStatement pstmt = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String Update_yn	="";
		String data		="";		
		String code		="";		
		String sel		="";		
		String facility_id		=(String)session.getValue("facility_id");
		String nursing_unit_code= request.getParameter("nursing_unit_code");
		String flagSelect		= request.getParameter("fromSelect");
		Hashtable htRecord		= null ;
		int cnt=0;
		String classValue	="";
		String chkAttribute	="";
		String eff_status	="";
		StringBuffer patient_class = new StringBuffer();
		patient_class.append(" select  appl_patient_class from IP_NURSING_UNIT  where FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE='"+nursing_unit_code+"' and eff_status='E' ");
		String appl_patient_class="";
		stmt=con.createStatement();
		rs = stmt.executeQuery(patient_class.toString());

		if(rs !=null)
		{
			while(rs.next())
			{
				appl_patient_class=rs.getString("appl_patient_class");
			}
		if(rs != null)			rs.close(); 
		if(stmt != null)		stmt.close(); 
		}
		if(appl_patient_class.equals("DC"))
		{
			StringBuffer check_Dc = new StringBuffer();
			check_Dc.append(" select  count(*) cnt from IP_DC_UNIT_FOR_NURS_UNIT where FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE='"+nursing_unit_code+"'");
			
			stmt=con.createStatement();
			rs = stmt.executeQuery(check_Dc.toString());
			if(rs !=null)
			{
				while(rs.next())
				{
					cnt=rs.getInt("cnt");
				}
			}
			if(rs != null)			rs.close();
			if(stmt != null)		stmt.close();
		}


		if(!appl_patient_class.equals("DC"))
			cnt=1;


		if(cnt > 0)
		{

			if(appl_patient_class.equals("DC"))
			{
				StringBuffer practid_sql = new StringBuffer();
				practid_sql.append("select practitioner_id from op_pract_for_Clinic where clinic_code in (select clinic_code from ip_dc_unit_for_nurs_unit where FACILITY_ID = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"') and FACILITY_ID = '"+facility_id+"' and resource_class = 'R'");
				stmt = con.createStatement();
				rs	 = stmt.executeQuery(practid_sql.toString());

				if(rs !=null)
				{
					while(rs.next())
					{
					}
				}
				if(rs != null)			rs.close(); 
				if(stmt != null)		stmt.close();
			}

			if(flagSelect !=null)
			{
				accessRightRecSet.clearAll();
				accessRightRec.clearAll();
				accessRight.clearAll();
				htRecord = new Hashtable();
				StringBuffer sqlinsVals = new StringBuffer();
				if(appl_patient_class.equals("DC"))
				{
					sqlinsVals.append(" select ROOM_NO,Level_of_care_code,NO_OF_BEDS from IP_NURSING_UNIT_ROOM  where FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE='"+nursing_unit_code+"' and eff_status='E' ");
				}
				else
				{
					sqlinsVals.append(" select ROOM_NO,Level_of_care_code,NO_OF_BEDS from IP_NURSING_UNIT_ROOM  where FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE='"+nursing_unit_code+"' and eff_status='E' ");
				}
				stmt3=con.createStatement();
				rstlRs3 = stmt3.executeQuery(sqlinsVals.toString());

				if(rstlRs3 !=null)
				{
					while(rstlRs3.next())
					{
							accessRightRecSet.putObject(rstlRs3.getString(1));
							accessRightRec.putObject(rstlRs3.getString(2));
							accessRight.putObject(rstlRs3.getString(3));

					 }
					
				}
	       	}
			if(rstlRs3 != null)		rstlRs3.close(); 
			if(stmt3 != null)		stmt3.close();


        
// ADDED by SRIDHAR on 23 FEB 2004 
			if(from != null && to != null)
			{
				 int j=0;
				 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
				 {
					 if(request.getParameter("chk"+(i)) != null)
					 {
						 checkedOnes = request.getParameter("chk"+(i));
						 SelectedOnes = request.getParameter("level"+(i));
						 SelectedOnes2 = request.getParameter("no_of_beds"+(i));

						 if(!(accessRightRecSet.containsObject(checkedOnes)))
						 {
							accessRightRecSet.putObject(checkedOnes);
							accessRightRec.putObject(SelectedOnes);
							accessRight.putObject(SelectedOnes2);

						 }
						 j++;
					 }
					 removeCode = checkForNull(request.getParameter("removeCode"+(i)));
					if(removeCode.equals("Y"))
						{ 
							if(request.getParameter("rm_num"+(i)) != null)
							 {
								String rm_num = request.getParameter("rm_num"+(i));
								if(accessRightRecSet.containsObject(rm_num))
								{
									int removeCodeIndex = accessRightRecSet.indexOfObject(rm_num);
									accessRightRecSet.removeObject(removeCodeIndex);
									accessRightRec.removeObject(removeCodeIndex);
									accessRight.removeObject(removeCodeIndex);
								}
							}
							
						}
						
					}
				 
				 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
				 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
			 }


			i = 1 ;
			
     		StringBuffer sql = new StringBuffer();

			if(appl_patient_class.equals("DC"))
			{
				sql.append("select distinct a.practitioner_id room_num, b.short_desc,decode(level_of_care_code, '',(select level_of_care_code from ip_nursing_unit_room where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"' and room_no = a.practitioner_id),(select nvl(level_of_care_code,'') from ip_nursing_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"')) Level_of_care_code,B.eff_status,( select count(*) from ip_nursing_unit_bed where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"' and room_no = a.practitioner_id) no_of_beds   from op_pract_for_Clinic a,am_facility_room b where clinic_code in (select clinic_code from ip_dc_unit_for_nurs_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"') and a.resource_class = 'R' and a.practitioner_id  = b.room_num and a.eff_status = 'E' and a.facility_id = '"+facility_id+"' and b.operating_facility_id = '"+facility_id+"' ");
		
				if(search_by.equals("ID"))
					sql.append(" and upper(room_num) like upper('"+search_txt+"%') ");
				else if(search_by.equals("DESC"))
					sql.append("  and upper(short_desc) like upper('"+search_txt+"%') ");

			}
			else
			{
				sql.append(" Select room_num, short_desc , B.eff_status, 'Y', nvl(no_of_beds,0) no_of_beds,B.Level_of_care_code ");
				sql.append(" from am_facility_room A,");
				sql.append(" IP_NURSING_UNIT_ROOM B ");
				sql.append(" WHERE B.FACILITY_ID='"+facility_id+"' ");
				sql.append(" AND B.NURSING_UNIT_CODE='"+nursing_unit_code+"' ");
				sql.append(" AND B.FACILITY_ID=A.OPERATING_FACILITY_ID ");
				sql.append(" AND B.ROOM_NO = A.ROOM_NUM and A.eff_status='E'  ");
			
				if(search_by.equals("ID"))
					sql.append(" and upper(room_num) like upper('"+search_txt+"%') ");
				else if(search_by.equals("DESC"))
					sql.append("  and upper(short_desc) like upper('"+search_txt+"%') ");

				sql.append(" union ");

				sql.append(" Select room_num, short_desc , 'D', 'N',0 ,Level_of_care_code" );
				sql.append(" from am_facility_room ");
				sql.append(" where operating_facility_id='"+facility_id+"' ");
				sql.append(" and eff_status='E' ");
				sql.append(" and resident_stay_yn='Y' ");
				sql.append(" and room_type in (Select locn_type from am_care_locn_type where care_locn_type_ind in ('R')) ");
				sql.append(" and nursing_unit_code is null ");
				sql.append(" and room_num not  in (Select room_no from ip_nursing_unit_room ");
				sql.append(" where facility_id='"+facility_id+"')  ");
		
				if(search_by.equals("ID"))
					sql.append(" and upper(room_num) like upper('"+search_txt+"%') ");
				else if(search_by.equals("DESC"))
					sql.append("  and upper(short_desc) like upper('"+search_txt+"%') ");
			}

			sql.append(" order by room_num ");
			try
			{
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs=stmt.executeQuery(sql.toString());

				rs.last();
				maxRecord = rs.getRow();
				rs.beforeFirst();
			}catch(Exception e)
			{
				//out.println(e);
				e.printStackTrace();
			}
		
			if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				return;
			}
			if (start != 0)
				{
				   for(int j=1; j<=start; i++,j++)
					{
						rs.next() ;
					}
				}

			//out.println("<script>alert(\""+sql.toString()+"\");</script>");
			pstmt=con.prepareStatement("select LEVEL_OF_CARE_CODE,LEVEL_OF_CARE_DESC from ip_nursing_unit_vw where FACILITY_ID = ? and nursing_unit_code = ? ");	
			
		}
		else
		{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
			String no_of_beds	="";
			while(i<=end && rs.next())
			{
				
				if(count == 0)
				{
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(start));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block18Bytes, _wl_block18);

	
		if ( !(start <= 1)) 
			{ 
				out.println("<td id='prev'><a href='javascript:submitPrevNext("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
				
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
			//if ( !((start+14) >= maxRecord ))
			//{
				out.println("<td id='next' style='visibility:hidden'><a href='javascript:submitPrevNext("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
				
            _bw.write(_wl_block20Bytes, _wl_block20);

			//}
		
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
	 
		
				}

/*		if (start != 0)
		{
		   for(int j=1; j<=start; i++,j++)
		   {
				rs.next();
		   }
		}
*/
	/*pstmt=con.prepareStatement("select LEVEL_OF_CARE_CODE,LEVEL_OF_CARE_DESC from ip_nursing_unit_vw where FACILITY_ID = ? and nursing_unit_code = ? ");

		while(rs.next())
		{ */
			String room_num = "",short_desc = "";
			room_num		=  rs.getString("room_num");
			short_desc		=  rs.getString("short_desc");
			no_of_beds		= rs.getString("no_of_beds");
			eff_status		= rs.getString("eff_status");

			LOC = rs.getString("LEVEL_OF_CARE_CODE");
			if(LOC == null) LOC="";
			

			// ADDED by SRIDHAR on 23 FEB 2004 
			if(accessRightRecSet.containsObject(room_num))  {
					chkAttribute = "CHECKED";
				
			}
				
			else
			{
				if(eff_status.equals("E"))
				{
					chkAttribute = "CHECKED";
					
				}
				else
				{
					chkAttribute = "";
					
				}
				
			}
			
			if( i%2 == 0)  
				classValue="QRYEVEN";
			else
				classValue="QRYODD";
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);

	
	//moved this query out of while loop....
	//pstmt=con.prepareStatement("select LEVEL_OF_CARE_CODE,LEVEL_OF_CARE_DESC from ip_nursing_unit_vw where FACILITY_ID = ? and nursing_unit_code = ? ");

	pstmt.setString(1,facility_id);
	pstmt.setString(2,nursing_unit);
	LevelRset=pstmt.executeQuery();
	Levelstmt=con.createStatement();

	if(LevelRset!=null)
	{
		while(LevelRset.next())
		{
			data=LevelRset.getString("LEVEL_OF_CARE_DESC");
			code=LevelRset.getString("LEVEL_OF_CARE_CODE");

			if(code == null)
			{
				Update_yn = "Y";
				//Levelstmt=con.createStatement();
				//moved outside looop...
				LevelRset=Levelstmt.executeQuery("select LEVEL_OF_CARE_CODE,LEVEL_OF_CARE_DESC from am_level_of_care where EFF_STATUS = 'E' order by LEVEL_OF_CARE_DESC");
				if(LevelRset!=null)
				{
					
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
 if(LOC.equals(""))
					{	
						chkAttribute = ""; 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(LOC));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

					}
					while(LevelRset.next())
					{
						data=LevelRset.getString("LEVEL_OF_CARE_DESC");
						code=LevelRset.getString("LEVEL_OF_CARE_CODE");
						if(LOC.equals(code))
							sel = "selected";
						else
							sel="";
						out.println("<option value='"+code+"'"+sel+">"+data+"</option>");
					}
				}	
			}
			else 
			{
				Update_yn ="N";
				if(LOC.equals(code))
					sel = "selected";
				else
					sel="";
				
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(data));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(code));
            _bw.write(_wl_block42Bytes, _wl_block42);

			}
		}
	}

		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(no_of_beds));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(Update_yn));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(search_txt));
            _bw.write(_wl_block60Bytes, _wl_block60);


		i++;
		count++;
	} 

	if(count<14 || (!rs.next()))
		{
            _bw.write(_wl_block61Bytes, _wl_block61);

		}
		else
		{
            _bw.write(_wl_block62Bytes, _wl_block62);

		}

	if(count == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		return;
	}
		// end of while		
		if(stmt != null)		stmt.close(); 
		if(stmt3 != null)		stmt3.close(); 
		if(rstlRs3 != null)		rstlRs3.close(); 
		if(pstmt != null)		pstmt.close(); 
		if(rset != null)		rset.close(); 
		if(Levelstmt != null)	Levelstmt.close(); 
		if(LevelRset != null)	LevelRset.close(); 

	}catch(Exception e){
		//out.print(e);
		e.printStackTrace();
		}
	finally
	  {
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("AXSRightRecSet", accessRightRecSet);
		session.setAttribute("AXSRightRec", accessRightRec);
		session.setAttribute("AXSRight", accessRight);
	  }
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RoomCubicleDescription.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.levelofcare.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
}
