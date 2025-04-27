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

public final class __terminologysetforpractitionertypedetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TerminologySetForPractitionerTypeDetail.jsp", 1722864645025L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../js/TerminologySetForPractitionerType.js\"></script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<body  OnMouseDown=\"CodeArrest();\" onKeyDown=\'lockKey()\' onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =")\' class=\'CONTENT\' >\n\t\t<form name=\'formPractitionerResult\' id=\'formPractitionerResult\' action=\'../../eMR/jsp/TerminologySetForPractitionerTypeDetail.jsp\' method=\'post\' >\n\n\t\t<table  width=\'90%\' border=\'0\' align=\'center\'>\n\t\t<tr>\n\t\t<!--<td align=\'right\' class=\'NONURGENT\'>-->\n\t\t<input type=hidden name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t<input type=hidden name=\'pract_type_text\' id=\'pract_type_text\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<input type=hidden name=\'search_criteria\' id=\'search_criteria\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\t<input type=\'hidden\' name=\'allValues\' id=\'allValues\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'selectCHk\' id=\'selectCHk\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\n\t\t<table  align=\'right\'>\n\t\t<tr>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t</tr>\n\t\t</table>\n\t\t<br>\n\t\t<br>\n\t\t</tr>\n\t\t</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t<tr><td width=\'60%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<td width=\'20%\' class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" <br><input type=\'checkbox\' name=\'selectall\' id=\'selectall\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" onClick=\'selectAll(this,";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =")\'></td></tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<tr>\n\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'><input type=\'checkbox\' name=\'dftselect";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'dftselect";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'      onclick=\'SelectDefaultChk(this, ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =")\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" ><input type=\'hidden\' name=\'dftremoveCode";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'dftremoveCode";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' value=\"N\"><input type=\'hidden\' name=\'dftpractTypeCode";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'dftpractTypeCode";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"></td>\n\n\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" name=\'select";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'  value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'  onclick=\"RemSelectAll(this, ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =");\"><input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'removeCode";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' value=\"\"><input type=\'hidden\' name=\'practTypeCode";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'practTypeCode";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t<script >\n\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<script >\n\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</table>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet TerminologySetForPractitionerType= null;synchronized(session){
                TerminologySetForPractitionerType=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologySetForPractitionerType",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologySetForPractitionerType==null){
                    TerminologySetForPractitionerType=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologySetForPractitionerType",TerminologySetForPractitionerType,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet TerminologySetForPractitionerType1= null;synchronized(session){
                TerminologySetForPractitionerType1=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologySetForPractitionerType1",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologySetForPractitionerType1==null){
                    TerminologySetForPractitionerType1=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologySetForPractitionerType1",TerminologySetForPractitionerType1,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet TerminologySetForPractitionerType2= null;synchronized(session){
                TerminologySetForPractitionerType2=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologySetForPractitionerType2",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologySetForPractitionerType2==null){
                    TerminologySetForPractitionerType2=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologySetForPractitionerType2",TerminologySetForPractitionerType2,javax.servlet.jsp.PageContext.SESSION_SCOPE);

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
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
String pract_type_text = request.getParameter("pract_type_text") ;
String search_criteria = request.getParameter("search_criteria") ;
String removeCode	= "";
String dftremoveCode="";
String dflt_term_set_yn="";
String dflt_term_set_yn1="";
String disable_yn="";
int maxRecord = 0;
int start = 0 ;
int end = 0 ;
int i=1;
if (from == null){
	start = 0 ;
	TerminologySetForPractitionerType1.clearAll();
	TerminologySetForPractitionerType2.clearAll();
}
else
	start = Integer.parseInt(from);
if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
req_start=(request.getParameter("start")==null)?"0":request.getParameter("start");
req_end=(request.getParameter("end")==null)?"0":request.getParameter("end");
//String totAssignreasign="",
String effStatus="";
//Statement stmt3 = null;
PreparedStatement stmt3=null;	
//Statement stmt4=null;
PreparedStatement stmt4=null;	

ResultSet rstlRs3 = null;
effStatus=request.getParameter("effStatus");
if(effStatus == null) 
	effStatus="";
Statement stmt=null;
ResultSet rs=null ;
Connection con = null;
String selectCHkChecked="";
String selectCHk=checkForNull(request.getParameter("selectCHk"));
if(selectCHk.equals("Y"))
selectCHkChecked="checked";
else
selectCHkChecked=" ";


try
{
	con = ConnectionManager.getConnection(request);			
	String term_set_id=request.getParameter("term_set_id");
	String flagSelect = request.getParameter("fromSearch");
	if(flagSelect !=null){
		TerminologySetForPractitionerType.clearAll();
		TerminologySetForPractitionerType1.clearAll();
		TerminologySetForPractitionerType2.clearAll();
		String sqlinsVals="select pract_type,DFLT_TERM_SET_YN from mr_term_set_for_pract_type where term_set_id=?";
		//stmt3=con.createStatement();
		stmt3 = con.prepareStatement(sqlinsVals);
		stmt3.setString(1,term_set_id);
			 rstlRs3 = stmt3.executeQuery();
			if(rstlRs3 !=null){
				while(rstlRs3.next()){
					TerminologySetForPractitionerType.putObject(rstlRs3.getString(1));
					dflt_term_set_yn1=rstlRs3.getString(2);
					if(dflt_term_set_yn1.equals("Y")){
					TerminologySetForPractitionerType1.putObject(rstlRs3.getString(1));
					}
				 }
			}	
		}
		String sqlinsVals1="select pract_type from mr_term_set_for_pract_type where DFLT_TERM_SET_YN='Y' and term_set_id !=?";
	
		//stmt4=con.createStatement();
		stmt4 = con.prepareStatement(sqlinsVals1);
		stmt4.setString(1,term_set_id);
		rstlRs3 = stmt4.executeQuery();
		//out.println("sql 2"+sqlinsVals1.toString());
	
		if(rstlRs3 !=null){
				while(rstlRs3.next()){
					TerminologySetForPractitionerType2.putObject(rstlRs3.getString("pract_type"));		
				 }
			}	

	if(from != null && to != null){
		int j=0;
		for( i=(Integer.parseInt(req_start))+1; i<=(Integer.parseInt(req_end)); i++){
			 if(request.getParameter("select"+(i)) != null){
				 checkedOnes = request.getParameter("select"+(i));
				 if(!(TerminologySetForPractitionerType.containsObject(checkedOnes)))
					 TerminologySetForPractitionerType.putObject(checkedOnes);
				 j++;
				 }

			removeCode = checkForNull(request.getParameter("removeCode"+(i)));
			if(removeCode.equals("Y")){
				String practTypeCode = request.getParameter("practTypeCode"+(i));
				if((TerminologySetForPractitionerType.containsObject(practTypeCode))){
					int removeCodeIndex = TerminologySetForPractitionerType.indexOfObject(practTypeCode);
						TerminologySetForPractitionerType.removeObject(removeCodeIndex);
				}
			}
			if(request.getParameter("dftselect"+(i)) != null){
				checkedOnes1 = request.getParameter("dftselect"+(i));
				
				if(!(TerminologySetForPractitionerType1.containsObject("dftselect"+i))){
					TerminologySetForPractitionerType1.putObject(checkedOnes1);
				}
			}
			dftremoveCode = checkForNull(request.getParameter("dftremoveCode"+(i)));
			if(dftremoveCode.equals("Y")){
				String dftpractTypeCode = request.getParameter("dftpractTypeCode"+(i));
				if((TerminologySetForPractitionerType1.containsObject(dftpractTypeCode))){
					int dftremoveCodeIndex = TerminologySetForPractitionerType1.indexOfObject(dftpractTypeCode);
					TerminologySetForPractitionerType1.removeObject(dftremoveCodeIndex);
				}
			}
			

	}

		 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	 }
	i = 1 ;

	String classValue="";
	String chkAttribute="";
	String dftchkAttribute="";
	
	//String eff_status="",
	

	StringBuffer sql = new StringBuffer();
	sql.append("select pract_type, desc_userdef pract_type_desc, 'I' db_action,'N' DFLT_TERM_SET_YN from am_pract_type where pract_type not in (select pract_type from mr_term_set_for_pract_type where term_set_id ='"+term_set_id+"') and eff_status='E' ");
	if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
		sql.append(" and Upper(desc_userdef) LIKE Upper('"+pract_type_text+"%')");
	else if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
		sql.append(" and Upper(desc_userdef) LIKE Upper('%"+pract_type_text+"%')");
	else if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
		sql.append(" and Upper(desc_userdef) LIKE Upper('%"+pract_type_text+"')");
	
	sql.append(" union all select  a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action,a.DFLT_TERM_SET_YN from mr_term_set_for_pract_type a, am_pract_type b where a. term_set_id = '"+term_set_id+"' and b. pract_type = a.pract_type ");
	if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
		sql.append(" and Upper(b.desc_userdef) LIKE Upper('"+pract_type_text+"%')");
	else if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
		sql.append(" and Upper(b.desc_userdef) LIKE Upper('%"+pract_type_text+"%')");
	else if(pract_type_text!=null && !pract_type_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
		sql.append(" and Upper(b.desc_userdef) LIKE Upper('%"+pract_type_text+"')");

	sql.append(" order by 2");
//out.println("sql2 "+sql.toString());
	
	try{
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql.toString());

	}catch(Exception e){/* out.println(e); */e.printStackTrace();}

	if (start != 0){
		for(int j=1; j<=start; i++,j++){
			rs.next() ;
		}
	}

while(i<=end && rs.next() ){ 

	if(maxRecord == 0)
			{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(start));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pract_type_text));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(selectCHk));
            _bw.write(_wl_block19Bytes, _wl_block19);

		if ( !(start <= 1)) {

		out.println("<td align ='right' id='prev' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
		
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
		//if ( !((start+12) >= maxRecord )){

		out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
		
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(selectCHkChecked));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block25Bytes, _wl_block25);
	 
			}
//recordCount =TerminologySetForPractitionerType.getSize();
/*if (start != 0){
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
}*/
	//while(rs.next() && i<=end){ 
		String pract_type=rs.getString("pract_type");
		String pract_type_desc=rs.getString("pract_type_desc");
		dflt_term_set_yn=rs.getString("DFLT_TERM_SET_YN");
		//out.println("<script>alert('"+TerminologySetForPractitionerType1.getObject(i)+"')</script>");
		
		if(TerminologySetForPractitionerType.containsObject(pract_type))  
			chkAttribute = "CHECKED";
		else
			chkAttribute="";
		
		int recordIndex = TerminologySetForPractitionerType.indexOfObject(pract_type);
		if(recordIndex!=-1)
		if(chkAttribute.equals("CHECKED"))    TerminologySetForPractitionerType.removeObject(recordIndex);
	
		if(TerminologySetForPractitionerType1.containsObject(pract_type)){  
			dftchkAttribute = "CHECKED";
		}
		else
			dftchkAttribute="";
		
	
		int dftrecordIndex = TerminologySetForPractitionerType1.indexOfObject("dftselect"+i);
		if(dftrecordIndex!=-1)
			if(dftchkAttribute.equals("CHECKED"))
			TerminologySetForPractitionerType1.removeObject(dftrecordIndex);

		disable_yn="";
		if(TerminologySetForPractitionerType2.containsObject(pract_type))
		{
	
				disable_yn = "disabled";
	
		}		
		else
			{
			disable_yn="";
			}

			if( i%2 == 0)  classValue="QRYEVEN";
			else
			classValue="QRYODD";
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dftchkAttribute));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disable_yn ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block49Bytes, _wl_block49);

		i++;
		maxRecord++;
	}		

		if ( maxRecord < 12 || (!rs.next()) )
		{
			
            _bw.write(_wl_block50Bytes, _wl_block50);
 
		}
		else
		{
            _bw.write(_wl_block51Bytes, _wl_block51);

		}

		if(maxRecord == 0)
		{
			
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			
            _bw.write(_wl_block52Bytes, _wl_block52);

		}
 }
 catch(Exception e){/* out.print(e); */e.printStackTrace();}
finally
{
// Added on 25/07/2003 for closing ResultSet & Statements which are not closed Properly.
	if(rs != null){ rs.close(); }
	if(rstlRs3 != null){ rstlRs3.close(); }
	if(stmt != null){ stmt.close(); }
	if(stmt3 != null){ stmt3.close(); }
	if(stmt4 != null){ stmt4.close(); }
	
// End of Addition on 25/07/2003 for closing ResultSet & Statements which are not closed properly.
	ConnectionManager.returnConnection(con,request);
	session.setAttribute("TerminologySetForPractitionerType", TerminologySetForPractitionerType);
	session.setAttribute("TerminologySetForPractitionerType1", TerminologySetForPractitionerType1);
	
}

            _bw.write(_wl_block53Bytes, _wl_block53);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionertype.label", java.lang.String .class,"key"));
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
