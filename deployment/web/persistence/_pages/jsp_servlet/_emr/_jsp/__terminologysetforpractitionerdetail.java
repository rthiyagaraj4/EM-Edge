package jsp_servlet._emr._jsp;

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

public final class __terminologysetforpractitionerdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TerminologySetForPractitionerDetail.jsp", 1722864632075L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../js/TerminologySetForPractitioner.js\"></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<body  OnMouseDown=\"CodeArrest();\" onKeyDown=\'lockKey()\' onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =")\' class=\'CONTENT\' >\n\t\t\t\t<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eMR/jsp/TerminologySetForPractitionerDetail.jsp\' method=\'post\' >\n\n\t\t\t\t<table  width=90%\' border=0 align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<!--<td align=\'right\' class=\'NONURGENT\'>-->\n\t\t\t\t\t<input type=hidden name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\t\n\t\t\t\t\t<input type=hidden name=\'pract_type\' id=\'pract_type\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n\t\t\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t\t\t\t<input type=hidden name=\'pract_desc_text\' id=\'pract_desc_text\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t\t\t<input type=hidden name=\'search_criteria\' id=\'search_criteria\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\t\n\t\t\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'allValues\' id=\'allValues\' value=\'\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'selctAllCHk\' id=\'selctAllCHk\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t\t\t\t<table align=\'right\'>\n\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<br>\n\t\t\t\t\t<br>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\n\t\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'60%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t<td width=\'20%\' class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t<td width=\'20%\' class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" <br><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" value=\"\" onClick=\'selectAll(this,";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =")\'></td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'><input type=\'checkbox\' name=\'dftselect";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'dftselect";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'      onclick=\'SelectDefaultChk(this, ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =")\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="><input type=\'hidden\' name=\'dftremoveCode";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'dftremoveCode";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' value=\"N\"><input type=\'hidden\' name=\'dftpractTypeCode";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'dftpractTypeCode";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'></td>\n\n\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" name=\'chk";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'  value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' onClick=\'unSelectAll(this, ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =")\'><input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'removeCode";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' value=\"\"><input type=\'hidden\' name=\'practCode";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'practCode";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"> </td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));parent.frames[1].location.href=\'../../eCommon/html/blank.html\';</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\n\t\t</table>\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n</html>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet TerminologyForPractitioner= null;synchronized(session){
                TerminologyForPractitioner=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologyForPractitioner",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologyForPractitioner==null){
                    TerminologyForPractitioner=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologyForPractitioner",TerminologyForPractitioner,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.RecordSet TerminologyForPractitioner1= null;synchronized(session){
                TerminologyForPractitioner1=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologyForPractitioner1",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologyForPractitioner1==null){
                    TerminologyForPractitioner1=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologyForPractitioner1",TerminologyForPractitioner1,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.RecordSet TerminologyForPractitioner2= null;synchronized(session){
                TerminologyForPractitioner2=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologyForPractitioner2",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologyForPractitioner2==null){
                    TerminologyForPractitioner2=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologyForPractitioner2",TerminologyForPractitioner2,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String req_start   =   "";
	String req_end     =   "";
	String checkedOnes         =   "";
	String checkedOnes1         =   "";
	String dftremoveCode="";
	String dflt_term_set_yn1="";
	String dflt_term_set_yn="";
	String dftchkAttribute="";
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
	String pract_desc_text = request.getParameter("pract_desc_text") ;
	String search_criteria = request.getParameter("search_criteria") ;
	String removeCode = "";
	String disable_yn="";
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if (from == null){ 
		start = 0 ; 
		TerminologyForPractitioner1.clearAll();
		TerminologyForPractitioner2.clearAll();
	}   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
	req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus="";
	//Statement stmt3 = null;
	PreparedStatement stmt3=null;
	//Statement stmt4 = null;
	PreparedStatement stmt4=null;
	ResultSet rstlRs3 = null;
	ResultSet rstlRs4 = null;
	
	String selctAllCHk=checkForNull(request.getParameter("selctAllCHk"));
	String _chkAll="";
	if(selctAllCHk.equals("Y"))
	_chkAll="checked";
	else
		_chkAll="";

	effStatus=request.getParameter("effStatus");
	if(effStatus == null)
		effStatus="";
	
	Statement stmt=null;
	ResultSet rs=null ;

	Connection con = null;
	try
	{
			
		con = ConnectionManager.getConnection(request);
	
		String term_set_id=request.getParameter("term_set_id");
		String pract_type=request.getParameter("pract_type")==null?"":request.getParameter("pract_type");
		String flagSelect = request.getParameter("fromSearch");

		if(flagSelect !=null)
       	{
      		TerminologyForPractitioner.clearAll();
      		TerminologyForPractitioner1.clearAll();
      		TerminologyForPractitioner2.clearAll();
       		String sqlinsVals= "select practitioner_id ,DFLT_TERM_SET_YN from mr_term_set_for_pract where term_set_id=? and practitioner_id in(select practitioner_id from am_practitioner where pract_type=nvl(?,pract_type))"; 
			//stmt3=con.createStatement();
			stmt3 = con.prepareStatement(sqlinsVals);
			stmt3.setString(1,term_set_id);
			stmt3.setString(2,pract_type);
			rstlRs3 = stmt3.executeQuery();
			if(rstlRs3 !=null)
			{
				while(rstlRs3.next())
				{
					TerminologyForPractitioner.putObject(rstlRs3.getString(1));
					dflt_term_set_yn1=rstlRs3.getString(2);
					if(dflt_term_set_yn1.equals("Y")){
					TerminologyForPractitioner1.putObject(rstlRs3.getString(1));
					}
				 }
			}
		}





    String sqlinsVals1="select practitioner_id from mr_term_set_for_pract where DFLT_TERM_SET_YN='Y' and term_set_id !=?";
	//out.println("sqlinsVals1:"+sqlinsVals1);
    //stmt4=con.createStatement();
	stmt4 = con.prepareStatement(sqlinsVals1);
	stmt4.setString(1,term_set_id);
	rstlRs4 = stmt4.executeQuery();
    if(rstlRs4 !=null){
				while(rstlRs4.next()){
					TerminologyForPractitioner2.putObject(rstlRs4.getString("practitioner_id"));
					
				 }
			}
	        
	   
		


		
		if(from != null && to != null)
        {
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
			{
				if(request.getParameter("chk"+(i)) != null)
				{
					checkedOnes = request.getParameter("chk"+(i));
					if(!(TerminologyForPractitioner.containsObject(checkedOnes)))
						TerminologyForPractitioner.putObject(checkedOnes);
					j++;
				}

				removeCode = checkForNull(request.getParameter("removeCode"+(i)));
				if(removeCode.equals("Y"))
				{
					String practCode = request.getParameter("practCode"+(i));
					if((TerminologyForPractitioner.containsObject(practCode)))
					{
						int removeCodeIndex = TerminologyForPractitioner.indexOfObject(practCode);
							TerminologyForPractitioner.removeObject(removeCodeIndex);
					}
				}
			


if(request.getParameter("dftselect"+(i)) != null){
				checkedOnes1 = request.getParameter("dftselect"+(i));
				//out.println("checkedOnes1="+checkedOnes1);
				if(!(TerminologyForPractitioner1.containsObject("dftselect"+i))){
					TerminologyForPractitioner1.putObject(checkedOnes1);
				}
			}
			dftremoveCode = checkForNull(request.getParameter("dftremoveCode"+(i)));
			if(dftremoveCode.equals("Y")){
				String dftpractTypeCode = request.getParameter("dftpractTypeCode"+(i));
				if((TerminologyForPractitioner1.containsObject(dftpractTypeCode))){
					int dftremoveCodeIndex = TerminologyForPractitioner1.indexOfObject(dftpractTypeCode);
					TerminologyForPractitioner1.removeObject(dftremoveCodeIndex);
				}
			}
			




			}
			out.println("<input type=hidden name='pages' id='pages' value='multiple'>"); 
			out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
		}
		i = 1 ;
     	String classValue="";
		String chkAttribute="";
				
		StringBuffer sql = new StringBuffer();
		


		sql.append("select '"+term_set_id+"', practitioner_id, practitioner_name, 'I' db_action ,'N' DFLT_TERM_SET_YN from am_practitioner where practitioner_id not in(select practitioner_id from mr_term_set_for_pract where term_set_id = '"+term_set_id+"') and eff_status = 'E' and pract_type = nvl('"+pract_type+"',pract_type) ");

		if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
		sql.append(" and Upper(practitioner_name) LIKE Upper('"+pract_desc_text+"%')");
		else if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
			sql.append(" and Upper(practitioner_name) LIKE Upper('%"+pract_desc_text+"%')");
		else if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
			sql.append(" and Upper(practitioner_name) LIKE Upper('%"+pract_desc_text+"')");

		sql.append(" union all select '"+term_set_id+"', a.practitioner_id practitioner_id, b.practitioner_name practitioner_name, 'U' db_action,a.DFLT_TERM_SET_YN from mr_term_set_for_pract a, am_practitioner b where term_set_id='"+term_set_id+"' and b.pract_type = nvl('"+pract_type+"',b.pract_type) and b.practitioner_id = a.practitioner_id ");

		if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
			sql.append(" and Upper(b.practitioner_name) LIKE Upper('"+pract_desc_text+"%')");
		else if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
			sql.append(" and Upper(b.practitioner_name) LIKE Upper('%"+pract_desc_text+"%')");
		else if(pract_desc_text!=null && !pract_desc_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
			sql.append(" and Upper(b.practitioner_name) LIKE Upper('%"+pract_desc_text+"')");

		sql.append(" order by 3");


		

		//String   sql  ="select '"+term_set_id+"', practitioner_id, practitioner_name, 'I' db_action from am_practitioner where practitioner_id not in(select practitioner_id from mr_term_set_for_pract where term_set_id = '"+term_set_id+"') and eff_status = 'E' and pract_type = nvl('"+pract_type+"',pract_type) union all select '"+term_set_id+"', a.practitioner_id practitioner_id, b.practitioner_name practitioner_name, 'U' db_action from mr_term_set_for_pract a, am_practitioner b where term_set_id='"+term_set_id+"' and b.pract_type = nvl('"+pract_type+"',b.pract_type) and b.practitioner_id = a.practitioner_id order by 3";
							
				
		try
		{
			//stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			

			stmt=con.createStatement();
			rs=stmt.executeQuery(sql.toString());
			
		}
		catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}

		
		if (start != 0)
		{
			for(int j=1; j<=start; i++,j++)
			{
				rs.next() ;
			}
		}

		while( i<=end  && rs.next() )
		{

			if(maxRecord == 0)
			{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(end));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(end));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pract_desc_text));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(_chkAll));
            _bw.write(_wl_block20Bytes, _wl_block20);

				
				if ( !(start <= 1)) 
				{
					out.println("<td align ='right' id='prev' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");

            _bw.write(_wl_block21Bytes, _wl_block21);

				}
				//if ( !((start+12) >= maxRecord ))
				//{
					out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(_chkAll));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block27Bytes, _wl_block27);
	
			}
			
		
				/*if (start != 0)
				{
					for(int j=1; j<=start; i++,j++)
					{
						rs.next() ;
					}
				}*/
			
				//while(rs.next() && i<=end)
				//{ 
					String practitioner_id=rs.getString("practitioner_id");
					String practitioner_name=rs.getString("practitioner_name");
					dflt_term_set_yn=rs.getString("DFLT_TERM_SET_YN");
					//out.println("dflt_term_set_yn="+dflt_term_set_yn);
					if(TerminologyForPractitioner.containsObject(practitioner_id)) 
						chkAttribute = "CHECKED";
					else
						chkAttribute="";
					int recordIndex = TerminologyForPractitioner.indexOfObject(practitioner_id);
					if(recordIndex!=-1)
					if(chkAttribute.equals("CHECKED"))   
						TerminologyForPractitioner.removeObject(recordIndex);



    if(TerminologyForPractitioner1.containsObject(practitioner_id)){  
			dftchkAttribute = "CHECKED";
		}
		else
			dftchkAttribute="";
		
	int dftrecordIndex = TerminologyForPractitioner1.indexOfObject("dftselect"+i);
		if(dftrecordIndex!=-1)
			if(dftchkAttribute.equals("CHECKED"))
			TerminologyForPractitioner1.removeObject(dftrecordIndex);

	
	
				
					disable_yn="";
		if(TerminologyForPractitioner2.containsObject(practitioner_id))
		{
	
				disable_yn = "disabled";
	
		}		
		else
			{
			disable_yn="";
			}
					
					
					
					if( i%2 == 0)
						classValue="QRYEVEN";
					else
						classValue="QRYODD";

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dftchkAttribute));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disable_yn ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block52Bytes, _wl_block52);

						i++;
						maxRecord++;
				
		}
			

				if ( maxRecord < 12 || (!rs.next()) )
				{
					
            _bw.write(_wl_block53Bytes, _wl_block53);
 
				}
				else
				{
            _bw.write(_wl_block54Bytes, _wl_block54);

				}

				if(maxRecord == 0)
				{
					
            _bw.write(_wl_block55Bytes, _wl_block55);

				}			
		}
		catch(Exception e)
		{
			//out.print(e);
			e.printStackTrace();
		}
		finally
		{
			if(rs != null){ rs.close(); }
			if(rstlRs3 != null){ rstlRs3.close(); }
			if(stmt != null){ stmt.close(); }
			if(stmt3 != null){ stmt3.close(); }
				    
			ConnectionManager.returnConnection(con,request);
			session.setAttribute("TerminologyForPractitioner", TerminologyForPractitioner);
			session.setAttribute("TerminologyForPractitioner1", TerminologyForPractitioner1);
		}

            _bw.write(_wl_block56Bytes, _wl_block56);

	

            _bw.write(_wl_block57Bytes, _wl_block57);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.DefaultTermSet.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
}
