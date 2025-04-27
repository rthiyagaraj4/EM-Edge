package jsp_servlet._eqa._jsp;

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

public final class __qaparameterform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAParameterForm.jsp", 1742817545745L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n               Developed By :-  Rajesh Kanna.S\n\t\t\t                        1/2/2005 \n\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n  <script src=\'../../eCommon/js/MstCodeCommon.js\' language=\'javascript\'></script>\n  <script language=\'javascript\' src=\'../../eQA/js/QAParameter.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/messages.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eQA/js/QAMessages.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n <body OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n <form name=\"qaparameter_form\" id=\"qaparameter_form\" action=\"../../servlet/eQA.QAParameterServlet\" method=\"post\" target=\"messageFrame\">\n <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'90%\'>\n <br><br>\n <tr><th align=left colspan=3> Direct Recording: Encounter Selection Defaults </th></tr> \n <tr><td align=left colspan=3> &nbsp;</td></tr>       \n <tr><td class=label>&nbsp;</td> <td class=label  >Period To &nbsp; </td><td class=label  align=left>Period  From&nbsp;</td></tr>\n <tr><td class=label align=right width=40%><B>Days to backdate</B> For IP &nbsp; </td ><td width=15%><input type=\'text\' name=\'encounteripTo\' id=\'encounteripTo\'  value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' maxLength=\'4\' size=\'4\'  onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'>  </td> <td><input type=\'text\' name=\'encounteripFrom\' id=\'encounteripFrom\'  value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' maxLength=\'4\' size=\'4\'   onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'></td></tr>\n <tr><td class=label align=right>&nbsp;For DC   &nbsp; </td> <td><input type=\'text\' name=\'encounterdcTo\' id=\'encounterdcTo\'  value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'maxLength=\'4\' size=\'4\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'>  </td> <td><input type=\'text\' name=\'encounterdcFrom\' id=\'encounterdcFrom\'   value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'maxLength=\'4\' size=\'4\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'></td></tr>\n <tr><td class=label align=right>&nbsp;For OP  &nbsp; </td> <td><input type=\'text\' name=\'encounteropTo\' id=\'encounteropTo\'   value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'maxLength=\'4\' size=\'4\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'>  </td> <td><input type=\'text\' name=\'encounteropFrom\' id=\'encounteropFrom\'  value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' maxLength=\'4\' size=\'4\'  onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'></td></tr>\n <tr><td class=label align=right>&nbsp; For EM  &nbsp; </td> <td><input type=\'text\' name=\'encounteremTo\' id=\'encounteremTo\'   value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'maxLength=\'4\' size=\'4\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'>  </td> <td><input type=\'text\' name=\'encounteremFrom\' id=\'encounteremFrom\'   value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'maxLength=\'4\' size=\'4\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'></td></tr>\n <tr><td class=label align=right>&nbsp;For XT   &nbsp; </td> <td><input type=\'text\' name=\'encounterxtTo\' id=\'encounterxtTo\'  value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'maxLength=\'4\' size=\'4\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'>  </td> <td><input type=\'text\' name=\'encounterxtFrom\' id=\'encounterxtFrom\'  value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' maxLength=\'4\' size=\'4\'  onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'></td></tr>\n <tr><td align=left colspan=3> &nbsp;</td></tr> \n <tr><td class=label align=right>Encounter Status &nbsp; </td> <td>\n <SELECT name=\"encounterstatus\" id=\"encounterstatus\">\n ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t <option value=\'A\'>All</option>\n\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<option value=\'A\'>All</option>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t <option value=\'O\' selected>Open</option>\n\t\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t  <option value=\'O\' >Open</option>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t <option  value=\'C\' selected>Closed</option>\n\t\t ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t  <option value=\'C\'>Closed</option>\n\t\t ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t  </SELECT></td><td>&nbsp;</td></tr>\n<tr><td class=label align=right>Include Analyzed Encounters  &nbsp; </td> <td>\n<INPUT TYPE=\"checkbox\" name=\"analyzeenc\" id=\"analyzeenc\"  value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'\t onclick=\'chkValue(this);\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="></td><td>&nbsp;</td></tr>\n<tr><td align=left colspan=3> &nbsp;</td></tr>\n<tr><th align=left colspan=3> Automated Data Collection: Encounter Selection Controls </th></tr> \n<tr><td align=left colspan=3> &nbsp;</td></tr>       \n<tr><td class=label align=right><B>Min Days After Discharge/Check-out</B> For IP &nbsp; </td> <td><input type=\'text\' name=\'encollecipTo\' id=\'encollecipTo\'  value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'maxLength=\'4\' size=\'4\'  onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'>  </td> <td>&nbsp;</td></tr>\n<tr><td class=label align=right>&nbsp;For DC   &nbsp; </td> <td><input type=\'text\' name=\'encollecdcTo\' id=\'encollecdcTo\'   value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'maxLength=\'4\' size=\'4\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'>  </td> <td>&nbsp;</td></tr>\n<tr><td class=label align=right>&nbsp;For OP  &nbsp; </td> <td><input type=\'text\' name=\'encollecopTo\' id=\'encollecopTo\'   value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'maxLength=\'4\' size=\'4\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'> </td><td> &nbsp;</td></tr>\n<tr><td class=label align=right>&nbsp; For EM  &nbsp; </td> <td><input type=\'text\' name=\'encollecemTo\' id=\'encollecemTo\'   value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'maxLength=\'4\' size=\'4\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'>  </td> <td>&nbsp;</td></tr>\n<tr><td class=label align=right>&nbsp;For XT   &nbsp; </td> <td><input type=\'text\' name=\'encollecxtTo\' id=\'encollecxtTo\'  value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'maxLength=\'4\' size=\'4\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'checkSequence(this)\'>  </td> <td>&nbsp;</td></tr>\n<tr><td align=left colspan=3> &nbsp;</td></tr>\n<input type=\"hidden\"  name=mode id=mode  value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n</table>\n</form>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
	
	Connection con 					= null;
	ResultSet rset					= null;
	PreparedStatement pstmt			= null;
	String mode						= "";
	//String	facilityId 				= (String) session.getValue( "facility_id" ) ;
	String	analyzeenc				= "";	
	String	encounterstatus			= "";	
	String  encounteripTo			= "";
	String  encounteripFrom			= "";
	String  encounteropTo			= "";
	String  encounteropFrom			= "";
	String  encounterdcTo			= "";
	String  encounterdcFrom			= "";
	String  encounteremTo			= "";
	String  encounteremFrom			= "";
	String  encounterxtTo			= "";
	String  encounterxtFrom			= "";
	String  encollecipTo			= "";
	String  encollecipFrom			= "";
	String  encollecopTo			= "";
	String  encollecopFrom			= "";
	String  encollecdcTo			= "";
	String  encollecdcFrom			= "";
	String  encollecemTo			= "";
	String  encollecemFrom			= "";
	String  encollecxtTo			= "";
	String  encollecxtFrom			= "";
	String  checkBoxAttribute		= "";
	mode="INSERT";
	try
    {
     con	 = ConnectionManager.getConnection(request);
	 pstmt	 = con.prepareStatement("Select * from  qa_qind_param");
	 rset	 = pstmt.executeQuery();
	 if(rset!=null && rset.next())
	  {    
		analyzeenc		= rset.getString("DIR_REC_INCL_ANALYZED_YN");
		if(analyzeenc!=null &&analyzeenc.equalsIgnoreCase("Y"))
			checkBoxAttribute = "checked";
        encounterstatus		= rset.getString("DIR_REC_ENC_STATUS");    
		encounterstatus		= (encounterstatus == null)?"A":encounterstatus.trim();	 
		encounteripTo		= rset.getString("DIR_REC_PRD_TO_DAYS_BACK_IP");    
		encounteripTo		= (encounteripTo == null)?"7":encounteripTo;	 
		encounteripFrom		= rset.getString("DIR_REC_PRD_FR_DAYS_BACK_IP");    
		encounteripFrom		= (encounteripFrom == null)?"14":encounteripFrom;	 
       	encounteropTo		= rset.getString("DIR_REC_PRD_TO_DAYS_BACK_OP");    
		encounteropTo		= (encounteropTo == null)?"7":encounteropTo;	 
      	encounteropFrom		= rset.getString("DIR_REC_PRD_FR_DAYS_BACK_OP");    
		encounteropFrom		= (encounteropFrom == null)?"14":encounteropFrom;	 
       	encounterdcTo		= rset.getString("DIR_REC_PRD_TO_DAYS_BACK_DC");    
		encounterdcTo		= (encounterdcTo == null)?"7":encounterdcTo;	 
 	    encounterdcFrom		= rset.getString("DIR_REC_PRD_FR_DAYS_BACK_DC");    
		encounterdcFrom		= (encounterdcFrom == null)?"14":encounterdcFrom;	 
		encounteremTo		= rset.getString("DIR_REC_PRD_TO_DAYS_BACK_EM");    
		encounteremTo		= (encounteremTo == null)?"7":encounteremTo;	 
      	encounteremFrom		= rset.getString("DIR_REC_PRD_FR_DAYS_BACK_EM");    
		encounteremFrom		= (encounteremFrom == null)?"14":encounteremFrom;	 
      	encounterxtTo		= rset.getString("DIR_REC_PRD_TO_DAYS_BACK_XT");    
		encounterxtTo		= (encounterxtTo == null)?"7":encounterxtTo;	 
       	encounterxtFrom		= rset.getString("DIR_REC_PRD_FR_DAYS_BACK_XT");    
		encounterxtFrom		= (encounterxtFrom == null)?"14":encounterxtFrom;	 
        encollecipTo		= rset.getString("SYS_REC_PROC_UPTO_DATE_IP");    
 	    encollecipTo		= (encollecipTo == null)?"7":encollecipTo;	 
		encollecipFrom		= rset.getString("SYS_REC_DAYS_AFT_CLOSE_IP");    
		encollecipFrom		= (encollecipFrom == null)?"7":encollecipFrom;	 
       	encollecopTo		= rset.getString("SYS_REC_PROC_UPTO_DATE_OP");    
		encollecopTo		= (encollecopTo == null)?"7":encollecopTo;	 
      	encollecopFrom		= rset.getString("SYS_REC_DAYS_AFT_CLOSE_OP");    
		encollecopFrom		= (encollecopFrom == null)?"7":encollecopFrom;	 
		encollecdcTo		= rset.getString("SYS_REC_PROC_UPTO_DATE_DC");    
		encollecdcTo		= (encollecdcTo == null)?"7":encollecdcTo;	 
		encollecdcFrom		= rset.getString("SYS_REC_DAYS_AFT_CLOSE_DC");    
		encollecdcFrom		= (encollecdcFrom == null)?"7":encollecdcFrom;	 
		encollecemTo		= rset.getString("SYS_REC_PROC_UPTO_DATE_EM");    
		encollecemTo		= (encollecemTo == null)?"7":encollecemTo;	 
		encollecemFrom		= rset.getString("SYS_REC_DAYS_AFT_CLOSE_EM");    
		encollecemFrom		= (encollecemFrom == null)?"7":encollecemFrom;	 
		encollecxtTo		= rset.getString("SYS_REC_PROC_UPTO_DATE_XT");    
		encollecxtTo		= (encollecxtTo == null)?"7":encollecxtTo;	 
		encollecxtFrom		= rset.getString("SYS_REC_DAYS_AFT_CLOSE_XT");    
		encollecxtFrom		= (encollecxtFrom == null)?"7":encollecxtFrom;	 
	    mode				= "MODIFY";
    }
    else
    {
		encounteripTo		="7";
		encounteripFrom		="14";
		encounteropTo		="7";
		encounteropFrom		="14";
		encounterdcTo		="7";
		encounterdcFrom		="14";
		encounteremTo		="7";
		encounteremFrom		="14";
		encounterxtTo		="7";
		encounterxtFrom		="14";
		encollecipFrom		="7";
		encollecopFrom		="7";
		encollecdcFrom		="7";
		encollecemFrom		="7";
		encollecxtFrom		="7";
	}
 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(encounteripTo));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(encounteripFrom));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(encounterdcTo));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(encounterdcFrom));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounteropTo));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounteropFrom));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounteremTo));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounteremFrom));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounterxtTo));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounterxtFrom));
            _bw.write(_wl_block14Bytes, _wl_block14);
 if(encounterstatus.equals("A")){	
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(encounterstatus.equals("O")){	
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(encounterstatus.equals("C"))	
            _bw.write(_wl_block21Bytes, _wl_block21);
else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(analyzeenc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encollecipFrom));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(encollecdcFrom));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encollecopFrom));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encollecemFrom));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(encollecxtFrom));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block31Bytes, _wl_block31);

	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
  }
  catch(Exception e)
  {
  out.println("Main "+e);
  }
finally
{
   ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block32Bytes, _wl_block32);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
