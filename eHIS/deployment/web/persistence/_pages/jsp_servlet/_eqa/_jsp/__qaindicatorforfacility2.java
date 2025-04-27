package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __qaindicatorforfacility2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndicatorForFacility2.jsp", 1742817544122L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n    <script src=\'../../eQA/js/QAIndicatorsForFacility.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  \n<script>\n//moved to JS\n\n</script>\n<body onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >\n<form name=\'result_form\' id=\'result_form\' action=\"QAIndicatorForFacility2.jsp\" method=\"post\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\'));\n\t\t</script>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<P>\n<table  width=\'90%\' align=\'center\' >\t\n<tr >\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n        \n\t   <td class=\'white\' width=\'95%\'>&nbsp;</td>\n    \t<td  align=\'right\' nowrap>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t    \n\t\t<td class=\'white\'>\n\t   ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<a HREF=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =", ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =");\' text-decoration=\'none\'>Previous</a>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =");\'  text-decoration=\'none\'>Next</a>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n</td>\n</tr>\n</table>\n\n\t<table cellpadding=0 cellspacing=0 border=1 width=\'90%\' align=\'center\'>\n\t\t<th nowrap>Indicator ID</th>\n\t\t<th nowrap>Periodicity</th>\n\t<th nowrap>Age</th>\t\n\t<th nowrap>Gender</th>\n\t\t\n\t   <th nowrap>Select</th>\n\t\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" nowrap align=center  width=25%>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<input type=hidden name=qd";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"  width=15% nowrap >&nbsp;&nbsp;\n\t\t\t\t<select name=period";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t\t\t\t<option value=\'X\'>-----------------Select--------------------&nbsp;&nbsp;&nbsp;\n\t\t\t    ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<option value=\'M\'  selected>Monthly&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t    <option value=\'M\' >Monthly&nbsp;\n\t\t\t   ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t     ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<option value=\'Q\'  selected>Quarterly&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t    <option value=\'Q\' >Quarterly&nbsp;\n\t\t\t   ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<option value=\'B\'  selected>Bi-Annually&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t    <option value=\'B\' >Bi-Annually&nbsp;\n\t\t\t   ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<option value=\'A\'  selected>Annually &nbsp;\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t    <option value=\'A\' >Annually &nbsp;\n\t\t\t   ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t</select></td>\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t   <td class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" width=10% nowrap align=center>&nbsp;<input type=\'text\'  onKeyPress=\'return(ChkNumberInput(this,event,0))\' OnBlur=\'CheckPositiveNumberLocal(this);onBlur=CheckNum(this)\'\t name=age";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="  size=4 maxlength=3 value=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">&nbsp;</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"width=10% nowrap align=center>\n\t\t\t  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t   \n\t\t\t   <input type=\'checkbox\'  name=gender";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" value=\'Y\' checked  onclick=\"genYN(this)\">\n\t\t\t   ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t   <input type=\'checkbox\'  name=gender";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="   value=\'N\'  onclick=\"genYN(this)\">\n\t\t\t   ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t   \n\t\t\t   </td>\n\t\t\t   <td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" nowrap align=center>\n\t\t\t\t<input type=checkbox  onclick=\"chkValue(this,";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =")\"  name=\'strKey";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' \tvalue =\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'></td>\n                 <input type=hidden name=h";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =">\n\t\t\t\t<input type=hidden name=\'strValue";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t\t<input type=hidden name=\'removedValue";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t\t \n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n</table>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</div>\n<input type=hidden name=\'count\' id=\'count\' value=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =">\n<input type=\'hidden\' name=fac_id id=fac_id value=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">\n<input type=\'hidden\' name=indi id=indi value=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =">\n<input type=\'hidden\' name=\'n\' id=\'n\' value=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =">\n<input type=\'hidden\' name=\'fnname\' id=\'fnname\' value=\"Insert\">\n<input type=\'hidden\' name=\'insert_table\' id=\'insert_table\' value=\'Y\'>\n<input type=\'hidden\' name=\'flagYN\' id=\'flagYN\' value=\'Y\'>\n\n<input type=\"Hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<input type=\"Hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<input type=\"Hidden\" name=\"counter\" id=\"counter\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

	public static String checkForNull(String inputString)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString );
	}


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


Connection con					=	null;
HashMap hashIndicator = null;
PreparedStatement pstmt			=	null;
ResultSet rset					=	null ;
//String	facilityId 					= (String) session.getValue( "facility_id" ) ;

int  count = request.getParameter("n")==null ? 0 : Integer.parseInt(request.getParameter("n"));
String flagYN = request.getParameter("flagYN")==null ? "N" : request.getParameter("flagYN");
//String valid_values="";
String checkedValues = "";
String checkedKey="";
String strKey="";
String strValue="";
int n=0;
int counter = request.getParameter("counter")==null ? 0 : Integer.parseInt(request.getParameter("counter"));
String from = request.getParameter( "from" ) ;
//valid_values		=	request.getParameter("valid_values")==null?"":request.getParameter("valid_values");

String to = request.getParameter( "to" ) ;
ArrayList keys = (ArrayList)session.getValue("arrayKeys");

if(keys == null)
{
	keys = new ArrayList();
}

StringTokenizer strToken1		= null;

boolean boolFlag = false;
String class_value				= "QRYEVEN";
String clindid					= "";
String fac_id                   = "";
String checked_yn				= "";
String dflt_rep_periodicity     = "";
String dflt_bd_by_gender_yn     = "";
String dflt_bd_age_range_id     = "";

int maxRecord=0;

StringBuffer sql   = new StringBuffer();
String indi="";
int start = 0 ;
int end = 0 ;
int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt(from) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;

            _bw.write(_wl_block4Bytes, _wl_block4);
try
{
	
	
	con						=	ConnectionManager.getConnection(request);
	fac_id				    =	checkForNull(request.getParameter("fac_id"));
	indi				    =	checkForNull(request.getParameter("indi"));
	String removeValue = "";
	StringBuffer countsql		= new StringBuffer();
	countsql.append("select  count(*)  FROM QA_QIND_CLIND  A,QA_QIND_FACILITY_CLIND B ");	countsql.append("WHERE B.OPERATING_FACILITY_ID(+) ='"+fac_id+"' and A.QIND_CLIND_ID=B.QIND_CLIND_ID(+) and A.QIND_CLIND_ID like '"+indi+"%'");
	 
	hashIndicator = (HashMap)session.getValue("hashIndicator");
	if(hashIndicator == null)
	{
		hashIndicator = new HashMap();
	}
	int count_value=0;
	int index=0;
	if(hashIndicator != null)
	{

		for(index=0 ;index < count;index++)
		{
				checkedKey = request.getParameter("strKey"+index) == null ? "" : request.getParameter("strKey"+index);
				
				if(!checkedKey.equals(""))
				{
					checkedValues = request.getParameter("strValue"+index) == null ? "" : request.getParameter("strValue"+index);
					hashIndicator.put (checkedKey,checkedValues);
				}
				else
				{
					removeValue = request.getParameter("removedValue"+index) == null ? "" : request.getParameter("removedValue"+index);
					if(!removeValue.equals(""))
					{
						hashIndicator.remove (removeValue);
						counter++;
					}
				}
			}
		}
	pstmt	=	con.prepareStatement(countsql.toString());
	rset = pstmt.executeQuery();
  	if ((rset != null) && (rset.next()))
	{
		count_value= rset.getInt(1);
		maxRecord=count_value;
	} if(rset!=null) rset.close();
	  if(pstmt!=null) pstmt.close();
	if (count_value==0)
	{
	
            _bw.write(_wl_block5Bytes, _wl_block5);

		return;
	}
	else
	{
		if (sql.length() > 0) sql.delete(0,sql.length());
		
sql.append("select to_number(QIND_CLIND_ID) CLINDID,'Y' CHECKED_YN, DFLT_REP_PERIODICITY  DFLT_REP_PERIODICITY,DFLT_BD_BY_GENDER_YN DFLT_BD_BY_GENDER_YN,DFLT_BD_AGE_RANGE_ID DFLT_BD_AGE_RANGE_ID  FROM QA_QIND_FACILITY_CLIND WHERE OPERATING_FACILITY_ID ='"+fac_id+"' and QIND_CLIND_ID like '"+indi+"%'UNION select to_number(QIND_CLIND_ID) CLINDID,'N' CHECKED_YN, DFLT_REP_PERIODICITY  DFLT_REP_PERIODICITY,DFLT_BD_BY_GENDER_YN DFLT_BD_BY_GENDER_YN,DFLT_BD_AGE_RANGE_ID DFLT_BD_AGE_RANGE_ID  FROM QA_QIND_CLIND  WHERE QIND_CLIND_ID like '"+indi+"%'AND QIND_CLIND_ID NOT IN (SELECT QIND_CLIND_ID FROM QA_QIND_FACILITY_CLIND WHERE OPERATING_FACILITY_ID ='"+fac_id+"') order by 1");

		//sql.append("select  A.QIND_CLIND_ID CLINDID,DECODE(B.OPERATING_FACILITY_ID,'");
		//sql.append(fac_id+"','Y','N') DB_YN,DECODE(B.OPERATING_FACILITY_ID,'");
		//sql.append(fac_id+"','CHECKED','UNCHECKED')  CHECKED_YN,B.DFLT_REP_PERIODICITY  DFLT_REP_PERIODICITY,B.DFLT_BD_BY_GENDER_YN DFLT_BD_BY_GENDER_YN,B.DFLT_BD_AGE_RANGE_ID DFLT_BD_AGE_RANGE_ID  FROM QA_QIND_CLIND  A,QA_QIND_FACILITY_CLIND B ");		
		//sql.append("WHERE B.OPERATING_FACILITY_ID(+) ='"+fac_id+"' and A.QIND_CLIND_ID=B.QIND_CLIND_ID(+) and A.QIND_CLIND_ID like '"+indi+"%' ORDER BY TO_NUMBER(A.QIND_CLIND_ID)");
	}
	pstmt = con.prepareStatement(sql.toString());
	rset = pstmt.executeQuery();
	
            _bw.write(_wl_block6Bytes, _wl_block6);
if (!(start <= 1) || !( (start+10) > maxRecord ))
		{
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);

if ( !(start <= 1) )
		{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start-10));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end-10));
            _bw.write(_wl_block12Bytes, _wl_block12);

		}

	if ( !( (start+10) > maxRecord ) )
	{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start+10));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end+10));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}

            _bw.write(_wl_block14Bytes, _wl_block14);


	  String tempString = "";
		if(hashIndicator != null)
		{
			if(flagYN.equals("N"))
				hashIndicator.clear();
		if(hashIndicator.size() == 0)
		{
			while(rset.next())
			{
				checked_yn= checkForNull(rset.getString("CHECKED_YN"));
				dflt_rep_periodicity=checkForNull(rset.getString("DFLT_REP_PERIODICITY"));
				dflt_bd_by_gender_yn= checkForNull(rset.getString("DFLT_BD_BY_GENDER_YN"));
				dflt_bd_age_range_id= checkForNull(rset.getString("DFLT_BD_AGE_RANGE_ID"));
				clindid= checkForNull(rset.getString("CLINDID"));
				strKey = fac_id + "~" + clindid;
				if(checked_yn.equals("Y"))
				{
				 if(dflt_bd_by_gender_yn.equals(""))
				   dflt_bd_by_gender_yn="X";
				 if(dflt_bd_age_range_id.equals(""))
				   dflt_bd_age_range_id="X";
				 if(dflt_rep_periodicity.equals(""))
				   dflt_rep_periodicity="X";
					
					strValue = dflt_rep_periodicity+"||"+ dflt_bd_age_range_id+"||"+dflt_bd_by_gender_yn ;
					hashIndicator.put(strKey,strValue);
				}
				if(!keys.contains(strKey))
				{
					keys.add(strKey);
				}
			}if(rset!=null) rset.close();
		}
	}
	
	rset = pstmt.executeQuery();
	if (rset != null)
	{
		if( start != 1 )
	   for( int j=1; j<start; i++,j++ ){
	  rset.next() ;
	  }
		while(rset.next() && i<=end)
		{
			clindid= checkForNull(rset.getString("CLINDID"));
			dflt_rep_periodicity=checkForNull(rset.getString("DFLT_REP_PERIODICITY"));
			dflt_bd_by_gender_yn= checkForNull(rset.getString("DFLT_BD_BY_GENDER_YN"));
			dflt_bd_age_range_id= checkForNull(rset.getString("DFLT_BD_AGE_RANGE_ID"));
			
			checked_yn= checkForNull(rset.getString("CHECKED_YN"));
			
			

             if(dflt_bd_by_gender_yn.equals(""))
               dflt_bd_by_gender_yn="X";
			 if(dflt_bd_age_range_id.equals(""))
               dflt_bd_age_range_id="X";
			 if(dflt_rep_periodicity.equals(""))
               dflt_rep_periodicity="X";
		    strKey = fac_id + "~" + clindid;
			strValue = dflt_rep_periodicity+"||"+ dflt_bd_age_range_id+"||"+dflt_bd_by_gender_yn ;
			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
			
				if(hashIndicator != null)
				{
					tempString = hashIndicator.get(strKey) == null ? "" : (String) hashIndicator.get(strKey) ;
					if(!tempString.equals(""))
					{
						 strToken1= new StringTokenizer(tempString,"||");
						  dflt_rep_periodicity=strToken1.nextToken();
						  dflt_bd_age_range_id= strToken1.nextToken();
						  dflt_bd_by_gender_yn=strToken1.nextToken();
						 boolFlag=true;
					}
					else
					{
						boolFlag=false;
					}
				}
			
				if(boolFlag==true)
				{
					checked_yn = "CHECKED";
				}
				else
				{
					checked_yn = "";
				}	
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clindid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(n% id=qd<%=n));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(clindid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(n% id=period<%=n));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(dflt_rep_periodicity.equals("M"))
			{
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
if(dflt_rep_periodicity.equals("Q"))
			{
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
if(dflt_rep_periodicity.equals("B"))
			{
            _bw.write(_wl_block28Bytes, _wl_block28);
}else{
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
if(dflt_rep_periodicity.equals("A"))
			{
            _bw.write(_wl_block30Bytes, _wl_block30);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
if(dflt_bd_age_range_id.equals("X"))dflt_bd_age_range_id="";
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(n% id=age<%=n));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dflt_bd_age_range_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block37Bytes, _wl_block37);
 if(dflt_bd_by_gender_yn.equals("Y")){
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(n% id=gender<%=n));
            _bw.write(_wl_block39Bytes, _wl_block39);
}else{
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(n% id=gender<%=n));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(n));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(n));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strKey));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(checked_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strKey));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(n% id=h<%=n));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(n));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(n));
            _bw.write(_wl_block50Bytes, _wl_block50);

			i++;
			n++;
		}
            _bw.write(_wl_block51Bytes, _wl_block51);
}if(pstmt!=null) pstmt.close();
	       if(rset!=null) rset.close();

            _bw.write(_wl_block52Bytes, _wl_block52);

	session.putValue("hashIndicator",hashIndicator);
	session.putValue("arrayKeys",keys);
	

	}
	catch (Exception e){
	out.println("Exception in query="+e);
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(indi));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(n));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(to));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
