package jsp_servlet._eop._jsp;

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
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.RecordSet;

public final class __practfornursunitresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/PractForNursUnitResult.jsp", 1742445567003L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<!--\n\tDeveloped by \t:\tPrakash.S\n\tCreated on \t\t:\t20/08/2002\n\tModule\t\t\t:\tIP\n-->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eOP/js/NursUnitPract.js\'></script>\n<script>\n\nfunction assignVal(obj, i)\n{\n\tif(obj.checked)\n\t\teval(\"document.forms[0].removeCode\"+i).value = \"N\";\n\telse\n\t\teval(\"document.forms[0].removeCode\"+i).value = \"Y\";\n}\n\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body  onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' class=\'CONTENT\' >\n<form name=\'FMAssnStrLocnMainResultForm\' id=\'FMAssnStrLocnMainResultForm\' action=\'../../eIP/jsp/PractForNursUnitResult.jsp\' method=\'post\' >\n\n<input type=hidden name=\'function_code\' id=\'function_code\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=hidden name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=hidden name=\'operation\' id=\'operation\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=hidden name=\'Function\' id=\'Function\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\n<input type=hidden name=\'function_name\' id=\'function_name\' value=\'insert\'>\n<input type=hidden name=\'isOnApply\' id=\'isOnApply\' value=\'N\'>\n<input type=\"hidden\" name=\"search_by\" id=\"search_by\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=\"hidden\" name=\"search_txt\" id=\"search_txt\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\"hidden\" name=\"isSimplifyPractNursUnit\" id=\"isSimplifyPractNursUnit\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name=\"is_origin\" id=\"is_origin\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\n<P>\n<table width=\'90%\' align=\'center\'>\n<tr>\n<!--<td class = \'white\' width = \'95%\'></td>\n<td align = \'right\' nowrap>-->\n<table align=\'right\'>\n<tr>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n    <input type=\"hidden\" name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n</td>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n    <input type=\"hidden\" name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\n</td>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</tr>\n\t</table>\n\t<br>\n\t<br>\n\t</tr>\n\t</table>\n\n    <table cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'90%\' align=\'center\' >\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<th>&nbsp;</th>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<th width=\'\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\n\t<th width=\'\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" <br><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\"selectAll(this,";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =",";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =");\"></th>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' align=\'center\' width=\'1%\'>\n\t\t\t\t\n\t\t\t<a href=\'javascript:showPractWindow(\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\");\'>+</a></td>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' align=\'left\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' align=\'center\'>\n\t\t\t<input type=\'checkbox\' ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="  name=\'select_yn";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' onclick=\"assignVal(this, ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =");\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"><input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"><input type=\'hidden\' name=\'Code";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"></td>\n\t\t</tr>\n\n\t\t<input type=\"hidden\" name=pract_id id=pract_id value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t<input type=\"hidden\" name=\"hddselect\" id=\"hddselect\" value=\"Tru\">\n\t\t\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t<script>document.getElementById(\"chkAll\").checked=true;</script>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<script>document.getElementById(\"chkAll\").checked=false;</script>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t<script>\n\t\t\t\tif(document.getElementById(\'next\'))\n\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<script>\n\t\t\t\tif(document.getElementById(\'next\'))\n\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\n\t</body>\n</html>\n\t\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

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
 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet PractNursRecordSet= null;synchronized(session){
                PractNursRecordSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("PractNursRecordSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(PractNursRecordSet==null){
                    PractNursRecordSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("PractNursRecordSet",PractNursRecordSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            webbeans.eCommon.RecordSet SimplifyPractNurs= null;synchronized(session){
                SimplifyPractNurs=(webbeans.eCommon.RecordSet)pageContext.getAttribute("SimplifyPractNurs",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(SimplifyPractNurs==null){
                    SimplifyPractNurs=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("SimplifyPractNurs",SimplifyPractNurs,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet NextPrevPractNurs= null;synchronized(session){
                NextPrevPractNurs=(webbeans.eCommon.RecordSet)pageContext.getAttribute("NextPrevPractNurs",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(NextPrevPractNurs==null){
                    NextPrevPractNurs=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("NextPrevPractNurs",NextPrevPractNurs,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
 	Statement stmt3		= null;
 	ResultSet rstlRs3	= null;
	PreparedStatement pstmt=null;
	con = 	ConnectionManager.getConnection(request);
	
	try
	{
		
		stmt	=	con.createStatement();
		String facility_id  =	(String)session.getAttribute("facility_id");
		//String req_start    =   "", req_end     =   "";
		//String checkedOnes  =   "";
		String practype     = "";
		boolean is_all_selected = true;
		boolean isSimplifyPractNursUnit = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","SIMPLIFY_PRACT_FOR_NURS_RES"); //Added by Ajay Hatwate for ML-MMOH-CRF-2121		
		int existingCount = 0;
		
		String search_by    = request.getParameter("search_by") ;
		if(search_by == null || search_by.equals("null")) search_by="";

			
	
		String search_txt   = request.getParameter("search_txt") ;
		if(search_txt == null || search_txt.equals("null")) search_txt="";

		

		String from			= request.getParameter("from") ;
		String to			= request.getParameter("to") ;

		int maxRecord = 0;
		int start     = 0;
		int end       = 0;
		int i         = 1;

		if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
		if (to == null){ end = 14 ; }   else {  end = Integer.parseInt( to ) ; }

		



		//req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
		//req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
		
		String mode			=	request.getParameter("mode") ;
		if(mode == null || mode.equals("null")) mode="";

		String function_code=request.getParameter("function_code");
		if(function_code==null)function_code="";

		String operation = request.getParameter("operation");
			if(operation==null)operation="";

		String Function = request.getParameter("Function");
			if(Function==null)Function="";

		//for first time if session exists then removing attribute for capturing current results.
		String is_origin = request.getParameter("is_origin");
		if(is_origin==null)is_origin="true";
		Boolean fromSession = false;
		
		if(is_origin.equals("true") && session.getAttribute("PractForNurseUnit") != null){
			session.removeAttribute("PractForNurseUnit");
		}else{
			int page1 = end/14;
			HashMap<String, String> map = (HashMap<String, String>)(session.getAttribute("PractForNurseUnit")) ;
			if(map != null){
				String c_code = map.get("c_clinic_id"+page1);
				if(c_code != null){
					NextPrevPractNurs.clearAll();
					String[] NextPrevCodes = c_code.split(",");
						
					for(String npCode : NextPrevCodes){
						NextPrevPractNurs.putObject(npCode);	
					}
					fromSession = true;
				}
			}
		}
		String function_desc="";

		if(Function.equals("pract"))
			function_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		else if(Function.equals("nurs"))
			function_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");

		StringBuffer result_query = new StringBuffer();
		//String flagSelect = request.getParameter("fromSelect");
		String search_criteria	= "";
		String search_criteria2 = "";
		String search_criteria3 = "";
		//String removeCode		= "";

		if(search_by != null && !search_by.equals(""))
		{
		  if(search_txt != null && !search_txt.equals(""))
		  {
			if(Function.equals("pract"))
			{
				if(search_by.equals("01"))
				{
				  search_criteria = " and NURSING_UNIT_CODE like upper('"+search_txt+"%') ";
				  search_criteria2 = " and NURSING_UNIT_CODE like upper('"+search_txt+"%') ";
				  search_criteria3 = " and b.NURSING_UNIT_CODE like upper('"+search_txt+"%') ";
				}
				else if(search_by.equals("02"))
				{
				  search_criteria = " and UPPER(NURSING_UNIT_SHORT_DESC) like UPPER('"+search_txt+"%') ";
				  search_criteria2 = " and UPPER(SHORT_DESC) like UPPER('"+search_txt+"%') ";
				  search_criteria3 = " and UPPER(b.SHORT_DESC) like UPPER('"+search_txt+"%') ";
				}
			}
			else if(Function.equals("nurs"))
			{
				if(search_by.equals("01"))
				  search_criteria = " and UPPER(PRACTITIONER_ID) like UPPER('"+search_txt+"%') ";
				else if(search_by.equals("02"))
				  search_criteria = " and UPPER(PRACTITIONER_NAME) like UPPER('"+search_txt+"%') ";
			}
		  }
		}

		//if(flagSelect !=null)
		//{
			PractNursRecordSet.clearAll();

			if(Function.equals("nurs"))
			{
				result_query.append(" select practitioner_id from IP_NURSING_UNIT_FOR_PRACT_VW where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"'"); 
				result_query.append(search_criteria); 

			}
			else if(Function.equals("pract"))
			{
				result_query.append(" select nursing_unit_code from IP_NURSING_UNIT_FOR_PRACT_VW where practitioner_id='"+function_code+"' and facility_id='"+facility_id+"' ");
				result_query.append(search_criteria); 
			}	
			stmt3=con.createStatement();
			rstlRs3 = stmt3.executeQuery(result_query.toString());

			if(rstlRs3 !=null)
			{
				 while(rstlRs3.next())
				 {
					PractNursRecordSet.putObject(rstlRs3.getString(1));
				 }
			}	
			if(rstlRs3!=null)rstlRs3.close();
			if(stmt3!=null)stmt3.close();
			
			//Added by Ajay Hatwate for ML-MMOH-CRF-2121	
			SimplifyPractNurs.clearAll();
			if(isSimplifyPractNursUnit && Function.equals("pract")){
				result_query.setLength(0);
				
				result_query.append("select count(*) from IP_NURSING_UNIT_FOR_PRACT where practitioner_id = ? and facility_id = ?");
				pstmt = con.prepareStatement(result_query.toString());
				pstmt.setString(1, function_code);
				pstmt.setString(2, facility_id);
				rstlRs3 = pstmt.executeQuery();
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						 existingCount = rstlRs3.getInt(1);
					 }
				}	
				
				
				if(existingCount == 0){
				result_query.setLength(0);
				
				result_query.append("SELECT locn_code FROM am_locn_for_oper_stn WHERE oper_stn_id = (SELECT oper_stn_id	FROM am_user_for_oper_stn WHERE appl_user_id = (SELECT appl_user_id FROM sm_appl_user WHERE func_role_id = '"+function_code+"') AND (TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (eff_date_from, 'DD/MM/YYYY') AND (eff_date_to IS NULL OR TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (eff_date_to, 'DD/MM/YYYY'))))");	
				stmt3 = con.createStatement();
				rstlRs3 = stmt3.executeQuery(result_query.toString());
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						SimplifyPractNurs.putObject(rstlRs3.getString(1));
					 }
				}	
			}
			}//End of ML-MMOH-CRF-2121
	

		/*if(from != null && to != null)
		{
			 int j=0;
			 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
			 {
				 if(request.getParameter("select_yn"+(i)) != null)
				 {
					 checkedOnes = request.getParameter("select_yn"+(i));
					 if(!(PractNursRecordSet.containsObject(checkedOnes)))
						 PractNursRecordSet.putObject(checkedOnes);
						 j++;
				 }
				
				removeCode = checkForNull(request.getParameter("removeCode"+(i)));
				if(removeCode.equals("Y"))
				{
					String Code = request.getParameter("Code"+(i));
					if((PractNursRecordSet.containsObject(Code)))
					{
						int removeCodeIndex = PractNursRecordSet.indexOfObject(Code);
							PractNursRecordSet.removeObject(removeCodeIndex);
					}
				}
			 }

			 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
			 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
		 }*/

	        i = 1 ;
			String classValue="";
			String chkAttribute="";
			StringBuffer sql = new StringBuffer();

			if(Function.equals("nurs"))
			{

				sql.append("select a.practitioner_id \"code\", a.practitioner_name \"desc\",a.pract_type practype, 'Y',b.Desc_Userdef from am_pract_for_facility_vw a, am_pract_type b where operating_facility_id='"+facility_id+"' and practitioner_id in (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"' )and a.pract_type = b.pract_type "+search_criteria+" UNION select practitioner_id \"code\", practitioner_name \"desc\",a.pract_type,'N',b.Desc_Userdef from am_pract_for_facility_vw a, am_pract_type b where operating_facility_id='"+facility_id+"' and 	a.eff_status='E' and practitioner_id NOT IN (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"') and a.pract_type = b.pract_type "+search_criteria+" order by 2"); 
			}
			else if(Function.equals("pract"))
			{
				sql.append("select nursing_unit_code \"code\", short_desc \"desc\", 'N' from ip_nursing_unit where facility_id='"+facility_id+"' AND eff_status='E' and locn_type = 'N' and nursing_unit_code not in (select nursing_unit_code from ip_nursing_unit_for_pract where practitioner_id='"+function_code+"' and facility_id='"+facility_id+"') "+search_criteria2+" union select a.nursing_unit_code, short_desc,'Y' from ip_nursing_unit_for_pract a, ip_nursing_unit b where a.facility_id='"+facility_id+"' AND a.practitioner_id='"+function_code+"' AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.nursing_unit_code "+search_criteria3+" order by 2");
			}
  try{
        //stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql.toString());

		
		/*rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			return;
		}*/

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

	while(i<=end && rs.next())
	{
	  if(maxRecord==0)
		{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Function));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(end));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(end));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(search_txt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(isSimplifyPractNursUnit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(is_origin));
            _bw.write(_wl_block22Bytes, _wl_block22);

    if ( !(start <= 1)) {

    out.println("<td id='prev'><a href='javascript:submitPrevNext("+(start-14)+","+(end-14)+", "+start+", "+end+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
	
            _bw.write(_wl_block23Bytes, _wl_block23);

    }
    out.println("<td id='next' style='visibility:hidden'><a href='javascript:submitPrevNext("+(start+14)+","+(end+14)+", "+start+", "+end+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
	
            _bw.write(_wl_block24Bytes, _wl_block24);

    //}

            _bw.write(_wl_block25Bytes, _wl_block25);
if(Function.equals("nurs")){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
	if(Function.equals("nurs"))
	{

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

	}

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(start));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(end));
            _bw.write(_wl_block32Bytes, _wl_block32);
	 
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
		String id=  rs.getString(1);
		String desc = rs.getString(2);
		String removeCode_YN = "";
		if(Function.equals("nurs"))
		{
			practype = rs.getString("desc_userdef");
		}	
		if(PractNursRecordSet.containsObject(id)) 
		{
			chkAttribute = "CHECKED";
			removeCode_YN = "N";
		}
		else
		{
			chkAttribute="";
			removeCode_YN = "Y";
			is_all_selected = false;
		}
		
		//Added by Ajay Hatwate for ML-MMOH-CRF-2121
				// if(Function.equals("pract") && isSimplifyPractNursUnit && SimplifyPractNurs.containsObject(id) && existingCount == 0){		
				if(isSimplifyPractNursUnit && SimplifyPractNurs.containsObject(id) && existingCount == 0){		// modified for ML-MMOH-SCF-3045
					chkAttribute = "CHECKED";
					removeCode_YN = "N";
				}
		if(fromSession){
//			if(Function.equals("pract") && isSimplifyPractNursUnit){
			if(isSimplifyPractNursUnit){ // modified for ML-MMOH-SCF-3045
				if(NextPrevPractNurs.containsObject(id)){
					chkAttribute = "CHECKED";
					removeCode_YN = "N";
				}else{	
					chkAttribute = "";
					removeCode_YN = "Y";
					is_all_selected = false;
				}
			}
		}
		

		if( i%2 == 0)  
			classValue="QRYEVEN";
		else
			classValue="QRYODD";
		
            _bw.write(_wl_block33Bytes, _wl_block33);
if(Function.equals("nurs")){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(id));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
	if(Function.equals("nurs"))
			{	
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(practype));
            _bw.write(_wl_block39Bytes, _wl_block39);
	}	
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(removeCode_YN));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(function_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
		i++;
		maxRecord++;
	}

		if(is_all_selected)
		{
			
            _bw.write(_wl_block50Bytes, _wl_block50);

		}
		else
		{
            _bw.write(_wl_block51Bytes, _wl_block51);

		}

		if(maxRecord<14 || (!rs.next()))
		{
            _bw.write(_wl_block52Bytes, _wl_block52);

		}
		else
		{
            _bw.write(_wl_block53Bytes, _wl_block53);

		}

		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			
		}
		if(stmt != null)	stmt.close();
		if(stmt3 != null)	stmt3.close();
		if(pstmt != null)	pstmt.close();
		if(rstlRs3 != null) rstlRs3.close();

	}catch(Exception e)
	{
		//out.println("Exception in fetching connection"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("PractNursRecordSet", PractNursRecordSet);
	}
	
            _bw.write(_wl_block54Bytes, _wl_block54);
            _bw.write(_wl_block55Bytes, _wl_block55);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
}
