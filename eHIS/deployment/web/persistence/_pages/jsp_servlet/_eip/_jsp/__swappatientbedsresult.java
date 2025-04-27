package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __swappatientbedsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/SwapPatientBedsResult.jsp", 1709117937245L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eip/jsp/ForSplChars.jsp", 1709116911640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\t<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eIP/js/SwapPatientBeds.js\' language=\'javascript\'></script>\n\t\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t</head>\n\t\t\t<body onLoad=\'validateCheck()\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t\t\t<form name=\'iplookupqueryresult\' id=\'iplookupqueryresult\' method=\"post\" action=\"../../eIP/jsp/SwapPatientBedsResult.jsp\"  target=\'messageFrame\'>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<input type=hidden name=\'pages\' id=\'pages\' value=\'multiple\'>\n\t\t\t\t\t<input type=hidden name=\'totChecked\' id=\'totChecked\' value=\'\"+j+\"\'>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<table  align=\'right\' id =\'maxrec\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<input type=hidden name=from value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=to value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t<td align=\'right\' id=\'prev\' style=\'visibility:visible\'><a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =",";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></td>\n\t\t\t\t\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<td align=\'right\' id=\'next\' style=\'visibility:hidden\'><a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></td>\n\t\t\t\t\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<br><BR>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'1\' cellpadding=0 cellspacing=0>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"columnheadercenter\" nowrap>&nbsp;</td>\n\t\t\t\t\t<td class=\"columnheadercenter\" nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t<td class=\"columnheadercenter\" nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;</td>\n\t\t\t\t\t<td class=\"columnheadercenter\" nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t<td \n\t\t\t\t\t\t\t\t\tclass=\'CAGROUPHEADING\' colspan=\'11\' align=\'left\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t</td></tr><tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" nowrap> <a href=\"javascript:closeWin(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'N\')\">+</a></td>\n\t\t\t\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' align=\'center\'>\n\t\t\t\t\t\t\t<input type=\'checkbox\' name=\"Check";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"Check";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"  value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onClick=\"checkNoSelect(this,";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =")\"></td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' nowrap>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\t\t\t\t\n\t\t\t\t\t\t\t<td ><input type=\'hidden\'  value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' name=\'allow_bed_swap_yn";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t\t\t\tdocument.getElementById(\"maxrec\").style.visibility=\'hidden\';\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\t\n\t\t\t\t</table>\n\t\t\t\t<input type=\'hidden\' name=\'whereclause\' id=\'whereclause\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'e1\' id=\'e1\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'e2\' id=\'e2\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'maxRecord\' id=\'maxRecord\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n\t\t\t\t</form>\n\t\t\t\t</body>\n\t\t\n\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.frames[3].location.href= \'../../eIP/jsp/SwapPatientBedButtons.jsp?";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n</html>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
 
public String singleToDoubleQuotes(String strDB)
{
	/*
	String strModified="";
	try
	{
		if((strDB != null) ||(strDB !=""))
		{
			StringBuffer stringbuffer = new StringBuffer(strDB);
			int i = 0;
			for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
			{
				i = strDB.indexOf('\'', i);
				stringbuffer.insert(i + j, "'");
				i++;
			}
			strModified=stringbuffer.toString();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}

	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultValue)
	{
		return (inputString==null)	?	defaultValue :	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet swapPatientBedResultBean= null;synchronized(session){
                swapPatientBedResultBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("swapPatientBedResultBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(swapPatientBedResultBean==null){
                    swapPatientBedResultBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("swapPatientBedResultBean",swapPatientBedResultBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

Connection con = null;
try	
{
	con				= ConnectionManager.getConnection(request);	
	Statement stmt	= null;
	ResultSet rs	= null;
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		try
		{
			request.setCharacterEncoding("UTF-8");
			String locale					= (String)session.getAttribute("LOCALE");
			StringBuffer where_criteria		= new StringBuffer();
			StringBuffer sql				= new StringBuffer();
			String encounter_id				= "";
			String class_val				= "QRYEVENSMALL";
			String whereClause				= request.getParameter("whereclause");
			String from						= request.getParameter( "from" ) ;
			String to						= request.getParameter( "to" ) ;
			String checkedOnes				= "";			
			String facility_id				= checkForNull((String)session.getValue("facility_id"));
			String p_practitioner_id		= checkForNull(request.getParameter("practitioner_id"));
			String nursing_unit_code		= checkForNull(request.getParameter("nursing_unit"));
			String speciality_code			= checkForNull(request.getParameter("Splcode"));
			String practitioner_id			= checkForNull(request.getParameter("practid"));
			String from_date				= checkForNull(request.getParameter("from_date"));
			if(!(from_date.equals("") || from_date == null))
					from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 

			String to_date					= checkForNull(request.getParameter("to_date"));
			if(!(to_date.equals("") || to_date == null))
						to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 

			String e1						= checkForNull(request.getParameter("e1"));
			String e2						= checkForNull(request.getParameter("e2"));
			String patient_name				= "";
			String bed_no					= "";
			String room_no					= "";
			String bed_class				= "";
			String specialty_short_desc		= "";
			String practitioner_name		= "";
			String prev_val					= "";
			String Sex						= "";
			String admission_date_time		= "";
			String allow_bed_swap_yn		= "";
			String patient_id				= "";
			//Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] Start
			Boolean isNewBornChngsAppl		= eCommon.Common.CommonBean.isSiteSpecific(con,"IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");
			String trans_yn_unfnzed_newborn	= "N";
			//Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] End


			int start	= 0;
			int end		= 0;
			int i		= 1;
			int maxRecord=0;
			if ( from == null )
				start = 1 ;		
			else
				start = Integer.parseInt( from ) ;
			if ( to == null )
				end = 12 ;
			else
				end = Integer.parseInt( to ) ;
			/*Added by Thamizh selvi on 29th May 2018 - checkbox check/uncheck value not retained while traversing through next/prev link*/
			if(from != null && to != null)
				maxRecord = Integer.parseInt(to);
			/*End*/
			String req_start       = checkForNull(request.getParameter("start"),"0");
			String req_end         = checkForNull(request.getParameter("end"),"0");
			if(whereClause==null)
			{
				where_criteria.append(" where a.facility_id='"+facility_id+"' ");
				if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
					where_criteria.append( " and a.nursing_unit_code='"+nursing_unit_code+"' ");
				
				if(speciality_code!=null && !speciality_code.equals(""))
					where_criteria.append(" and a.specialty_code='"+speciality_code+"' ");
				
				if(practitioner_id!=null && !practitioner_id.equals(""))
					where_criteria.append( " and a.attend_practitioner_id='"+practitioner_id+"' ");
				if(from_date!=null && !from_date.equals(""))
					where_criteria.append(" and trunc(a.admission_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
				
				if(to_date!=null && !to_date.equals(""))
					where_criteria.append(" and trunc(a.admission_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
				if( p_practitioner_id!=null && !p_practitioner_id.equals(""))
				{
						where_criteria.append(" and (a.ATTEND_PRACTITIONER_ID ='"+ p_practitioner_id +"'  ");
						where_criteria.append(" or a.encounter_id in ");
						where_criteria.append("(select encounter_id  ");
						where_criteria.append("  from pr_encounter_pract ");
						where_criteria.append(" where operating_facility_Id= '"+ facility_id +"'  ");
						where_criteria.append(" and practitioner_id= '"+ p_practitioner_id +"' )) ");
				}
			}
			else
			{
				where_criteria.append( whereClause );
			}
			/*Wednesday, June 02, 2010 , commented for PE*/
			/*			
			sql.append(" select  count(*) from IP_OPEN_ENCOUNTER a, MP_PATIENT B  "+where_criteria.toString() );	
			sql.append(" and a.patient_id=b.patient_id and a.room_num is not null and a.bed_num is not null  ");
			sql.append(" and oth_adt_status is null and ip_leave_status is null ");
			sql.append(" and tfr_req_status is null ");

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql.toString());

			rs.next();
			maxRecord = rs.getInt(1);
			*/
			
            _bw.write(_wl_block8Bytes, _wl_block8);

			if (whereClause==null)
				swapPatientBedResultBean.clearAll();
			if(from != null && to != null)
			{
				int j=0;
				for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
				{
					if(request.getParameter("Check"+(i-1)) != null)
					{
						checkedOnes = request.getParameter("Check"+(i-1));						
						if(!(swapPatientBedResultBean.containsObject(checkedOnes)))
							swapPatientBedResultBean.putObject(checkedOnes);
						j++;
					}
					else
					{
					}
				}
				
            _bw.write(_wl_block9Bytes, _wl_block9);
      
			}
			i = 1 ;

			//Added by Devang on 28/09/2002
			
			
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" select to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,");
			sql.append("b.sex gender ,  AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+locale+"','2') specialty_short_desc,"); 
			sql.append("a.nursing_unit_code nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PRACTITIONER_ID,'"+locale+"','1') "); 
			sql.append(" practitioner_short_name,a.encounter_id encounter_id, a.patient_id patient_id, ");
			sql.append(" decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, ");
			sql.append("IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc,a.ATTEND_PRACTITIONER_ID ");
			sql.append(" practitioner_id,(CASE WHEN A.BED_CLASS_CODE IS NOT NULL THEN( SELECT ALLOW_BED_SWAP_YN FROM IP_BED_CLASS WHERE BED_CLASS_CODE = A.BED_CLASS_CODE )END )  allow_bed_swap_yn,a.room_num room_no,a.bed_num bed_no,(select TRANS_YN_UNFNZED_NEWBORN from ip_param where facility_id='"+facility_id+"') TRANS_YN_UNFNZED_NEWBORN  from IP_OPEN_ENCOUNTER a, MP_PATIENT B  "+where_criteria.toString()+"  ");
			sql.append(" and a.patient_id=b.patient_id and a.room_num is not null and a.bed_num is not null ");
			sql.append(" and a.tfr_req_status is null ");
			sql.append(" and a.oth_adt_status is null and a.ip_leave_status is null ");

			sql.append(" order by bed_class_short_desc, admission_date_time, encounter_id");

			stmt	= con.createStatement();
			rs		= stmt. executeQuery(sql.toString());

			int recSelect = 0;
			int flag=0;
			if(rs !=null)
			{
				if ( start != 1 )
				{
					for( int j=1; j<start; i++,j++ )
					{
						rs.next() ;
					}
					recSelect +=start;
					--recSelect;
				}
				while ( rs.next() && i<=end ) 
				{
			/*if (( !(start <= 1)) || ( !((start+12) > maxRecord )) )
			{*/
					if(flag==0)
					{
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);

							if ( !(start <= 1)) 
							{
								
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start-12)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end-12)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

							}
							//if ( !((start+12) > maxRecord ))
							//{
								
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((start+12)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end+12)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

							//}
							
            _bw.write(_wl_block21Bytes, _wl_block21);

			//}
			
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

					}
					
						room_no					= checkForNull(rs.getString("room_no"));
						bed_no					= checkForNull(rs.getString("bed_no"));
						admission_date_time		= checkForNull(rs.getString("admission_date_time"),"&nbsp;");
						admission_date_time		= DateUtils.convertDate(admission_date_time,"DMYHM","en",locale);
						specialty_short_desc	= checkForNull(rs.getString("specialty_short_desc"),"&nbsp;");
						encounter_id			= checkForNull(rs.getString("encounter_id"));
						Sex						= checkForNull(rs.getString("gender"));
						patient_id				= checkForNull(rs.getString("patient_id"));
						patient_name			= checkForNull(rs.getString("patient_name"),"&nbsp;");
						bed_class				= checkForNull(rs.getString("BED_CLASS_SHORT_DESC"));
						practitioner_id			= checkForNull(rs.getString("practitioner_id"));
						practitioner_name		= checkForNull(rs.getString("practitioner_short_name"));
						allow_bed_swap_yn		= checkForNull(rs.getString("allow_bed_swap_yn"));
						/*Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
						trans_yn_unfnzed_newborn		= checkForNull(rs.getString("TRANS_YN_UNFNZED_NEWBORN"),"N");
						int unFinalizedNewBornCnt	= 0;
						if("F".equals(Sex) && isNewBornChngsAppl && "Y".equals(trans_yn_unfnzed_newborn)){
							unFinalizedNewBornCnt		= eIP.IPCommonBean.getUnfinalizedNewBornCount(con,patient_id);	
						}
						/*Added by Dharma on 28th May 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/
					

						try
						{
							if(swapPatientBedResultBean.containsObject(encounter_id))  allow_bed_swap_yn = "Y";
							else if(!allow_bed_swap_yn.equals("Y"))  allow_bed_swap_yn = "N";
							int recordIndex = swapPatientBedResultBean.indexOfObject(encounter_id);
							if(recordIndex!=-1)
							if(allow_bed_swap_yn.equals("Y"))    swapPatientBedResultBean.removeObject(recordIndex);
						}
						catch(Exception e)
						{
							//out.println("Exception@containsObject : "+e);
							e.printStackTrace();
						}
						if(class_val.equals("QRYEVENSMALL"))
								class_val = "QRYODDSMALL";
						else
								class_val = "QRYEVENSMALL";
						
            _bw.write(_wl_block26Bytes, _wl_block26);
		
							if(!prev_val.equals(bed_class))
							{ 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bed_class));
            _bw.write(_wl_block28Bytes, _wl_block28);
	
							}
							
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recSelect));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recSelect));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(recSelect));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(unFinalizedNewBornCnt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(admission_date_time));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(class_val));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(allow_bed_swap_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(recSelect));
            _bw.write(_wl_block44Bytes, _wl_block44);
	
						prev_val=bed_class;
						recSelect++;				
						i++;
						maxRecord++;
						flag++;
				}
					if ( maxRecord < 12 || (!rs.next()) )
					{
						
            _bw.write(_wl_block45Bytes, _wl_block45);
 
					}
					else
					{
						
            _bw.write(_wl_block46Bytes, _wl_block46);

					}
					
			}
				
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(where_criteria.toString()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((recSelect-1)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(e1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(e2));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block54Bytes, _wl_block54);
	
			if(maxRecord == 0)
			{
            _bw.write(_wl_block55Bytes, _wl_block55);

				return;
			}
			else
			{
				
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block57Bytes, _wl_block57);

			}
					
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
				
		}catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}

	}catch(Exception e)
	{
		//out.println("Exception:"+e.getMessage());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
		out.print("<script>if(parent.frames[1].document.forms[0] != null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
	}	

            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
}
