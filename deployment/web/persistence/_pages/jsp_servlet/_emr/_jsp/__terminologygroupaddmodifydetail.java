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
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __terminologygroupaddmodifydetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TerminologyGroupAddModifyDetail.jsp", 1722864609968L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/TerminologyGroup.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\twindow.onload=function(){\n\t\t\tif(document.getElementById(\"term_associated\")!=null)\t\t\t\n\t\t\t\tfxheaderInit(\'term_associated\',210);\n\t\t\telse\n\t\t\t\tdocument.getElementById(\"term_associated_div\").style.display=\'none\';\n\t\t};\n\t</script>\n\n</head>\n<body   onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<form name=\'term_code_associated\' id=\'term_code_associated\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eMR.TerminologyGroupServlet\'>\n\t<!--Maheshwaran K has added div and width added in <td> for PMG2014-MOD-CRF-0004(ENM-139) as on 29/1/2015-->\n\t\t<div  id=\"term_associated_div\" style=\"position:relative;width:100%;height:300px;overflow:auto;vertical-align:top;\"> \n\t\t<table style=\'border-spacing:0px ;border-collapse: collapse;\' width=\"100%\"  id=\'term_associated\'>\n\t\t<tr align=\'left\'>\n\t\t\t<td width=\'20%\' border=\"0\" class=\"COLUMNHEADER\" style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<br>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td width=\'20%\' border=\"0\" class=\"COLUMNHEADER\" style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td width=\'35%\' class=\"COLUMNHEADER\" style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td width=\'15%\' class=\"COLUMNHEADER\" style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\' style=\"background-color: black; color: white;\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t</tr>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<tr style=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'term_set_tr";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t\n\t\t\t<td  id=\'Level";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\n\t\t\t<td   id=\'term_code";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\'term_set";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\n\t\t\t<td   id=\'term_code_desc";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\'term_code_desc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\n\t\t\t<td   id=\'term_sn";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<input type=\"text\" size=\'3\' maxLength=\'3\' name=\"term_sn";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"term_sn";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onkeypress=\"return allowPositiveNumber()\" onBlur=\"CheckPositiveNumber(this)\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"> </img>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</td>\n\n\n\t\t\t<td   align=\'center\' class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"><input type=\"checkbox\" name=\"term_chk";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"term_chk";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" value=\"Y\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="></td>\n\t\t</tr>\n\t\t\t<input type=\"hidden\" name=\"term_code";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"term_code";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t<input type=\"hidden\" name=\"code_level";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"code_level";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\t\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\t\n\t\t<input type=\"hidden\" name=\"fun\" id=\"fun\" value=\"modify\">\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<input type=\"hidden\" name=\"fun\" id=\"fun\" value=\"insert\">\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n</tr>\n</table>\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"\">\n\t<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" name=\"service_code\" id=\"service_code\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"term_set_id\" id=\"term_set_id\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"term_group_id\" id=\"term_group_id\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"temp_term_code\" id=\"temp_term_code\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"term_code_associated\" id=\"term_code_associated\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" name=\"DB_term_code_associated\" id=\"DB_term_code_associated\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\" name=\"db_tot\" id=\"db_tot\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" name=\"indextype_yn\" id=\"indextype_yn\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\'hidden\' name=\'count1\' id=\'count1\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t<input type=\'hidden\' name=\'returnVal1\' id=\'returnVal1\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n</form>\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
//	String DB_term_code_associated_str = request.getParameter("Db_term_code")==null?"":request.getParameter("Db_term_code");
	String DB_Term_code_Exisits = request.getParameter("Db_term_code")==null? "N" :"Y";
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		
	String mode = request.getParameter("mode");
//	String function_id = request.getParameter("function_id");
	String service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");

	String term_set = request.getParameter("term_set")==null?"":request.getParameter("term_set");
	//String term_code_associated_str = request.getParameter("term_code_associated")==null?"":request.getParameter("term_code_associated");

	
	String level1 = request.getParameter("level")==null?"0":request.getParameter("level") ;

	String term_group_id=request.getParameter("term_group_id");
	String term_set_id=request.getParameter("term_set_id");
	String status_yn=request.getParameter("eff_status")==null?"":request.getParameter("eff_status");
	String indextype_yn=request.getParameter("indextype_yn")==null?"":request.getParameter("indextype_yn");
	StringBuffer DB_term_code_associated = new StringBuffer();
	StringBuffer term_code_associated = new StringBuffer();
	StringBuffer term_code_associated1 = new StringBuffer();
	StringBuffer DB_term_code_associated1 = new StringBuffer();
	String classvalue="", checked = "";
	int db_count=0;
	String returnVal  =request.getParameter("returnVal")==null?"":request.getParameter("returnVal") ;
	String tag = "",tag1="";
	String checkbox="";
	StringBuffer temp_db_chk = new StringBuffer("");
	StringBuffer temp_term_code = new StringBuffer("");
	StringBuffer sr_nos= new StringBuffer("");
	StringBuffer sr_nos1= new StringBuffer("");
	String temp_no="";
	int cnt=0;
	if(status_yn.equals("D"))
		checkbox="disabled";
	else
		checkbox="enabled";

	boolean mode_flag=false;

		Connection con = null;
		PreparedStatement pstmt_code = null;
		ResultSet rs_code = null;
		PreparedStatement pstmt_code1 = null;
		ResultSet rs_code1 = null;
		String temp="";
		String code_level_desc="";
		String returnVal1="";
	mode_flag = false;
	StringBuffer term_code_buf= new StringBuffer();
	con = ConnectionManager.getConnection(request);
	StringTokenizer stoken2=new StringTokenizer(returnVal,"$");
	if(stoken2.hasMoreTokens()){
	returnVal1= stoken2.nextToken();
	term_group_id= stoken2.nextToken();
	term_set_id= stoken2.nextToken();	
	}
	StringBuffer returnVa2= new StringBuffer();
	returnVa2.append(returnVal1);
	if(!returnVal1.equals(""))
		{		
			StringTokenizer stoken1=new StringTokenizer(returnVal1,"~");
			int j=1;
			cnt=stoken1.countTokens();
			while(stoken1.hasMoreTokens())
				{
				if(j!=cnt)
				term_code_buf.append("'"+stoken1.nextToken()+"',");
				else
				term_code_buf.append("'"+stoken1.nextToken()+"'");
				j++;
				}
			try
			{
			StringBuffer s1=new StringBuffer();
			s1.append(" select b.TERM_CODE,b.short_desc term_code_desc,b.code_level code_level,DECODE (b.code_level,'1', level_1_desc,'2', level_2_desc, ");
            s1.append(" '3', level_3_desc,'4', level_4_desc,'5', level_5_desc,'6', level_6_desc,'7', level_7_desc,'8', level_8_desc,'9', level_9_desc,'10', level_10_desc ) code_level_desc " );
			s1.append(" FROM  mr_term_set a, mr_term_code b where  b.TERM_CODE in ("+term_code_buf.toString()+") AND a.term_set_id = b.term_set_id and b.term_set_id='"+term_set_id+"' ");
			pstmt_code1 = con.prepareStatement(s1.toString());
			rs_code1=pstmt_code1.executeQuery();
			while(rs_code1.next())
				{
			    level1=rs_code1.getString("code_level");
				code_level_desc=checkForNull(rs_code1.getString("code_level_desc"));
				if(code_level_desc.equals(""))
					code_level_desc = "||";
				temp = rs_code1.getString("term_code")+"~"+level1+"~"+code_level_desc+"~"+rs_code1.getString("term_code_desc")+"`";
				temp_db_chk.append(rs_code1.getString("term_code")+"~");
				sr_nos1.append("~");
				if(term_code_associated.indexOf(temp) == -1)
				{
//				DB_term_code_associated1 += temp ;
				DB_term_code_associated1.append(temp);
				db_count++;
				}
			mode_flag =true;
		}
	//	 if (DB_Term_code_Exisits == "N")
		//{
//			term_code_associated = DB_term_code_associated + term_code_associated;
			term_code_associated1.append(DB_term_code_associated1);
	//	}
		}
		catch(Exception e)
			{
			System.err.println("Exception e**********"+ e );
			}
		 if ( rs_code1 !=null ) rs_code1.close();
	  if ( pstmt_code1 !=null ) pstmt_code1.close();
			}
	if(mode.equals("2"))
	{
		tag = "<B>";tag1="</B>";
		String sql_code = "select a.TERM_CODE term_code, c.SHORT_DESC term_code_desc, c.CODE_LEVEL code_level, Decode(c.CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC, '3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC , '6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,  '9',LEVEL_9_DESC ,'10',LEVEL_10_DESC ) code_level_desc, ORDER_SRL_NO order_no from MR_TERM_GROUP_DTL a, mr_term_set b,mr_term_code c where   a.term_set_id = b.term_set_id and b.term_set_id = c.term_set_id and a.term_code  = c.term_code and a.term_group_id like upper(?) and a.TERM_SET_ID like upper(?)";
		
	
		
		pstmt_code = con.prepareStatement(sql_code);
		pstmt_code.setString(1,term_group_id);
		pstmt_code.setString(2,term_set_id);
		rs_code=pstmt_code.executeQuery();
		
//		String DB_term_code_associated="";

		/*String temp="";
		String code_level_desc="";
		mode_flag = false;*/
		while(rs_code.next())
		{
		    level1=rs_code.getString("code_level");
			code_level_desc=checkForNull(rs_code.getString("code_level_desc"));
			if(code_level_desc.equals(""))
				code_level_desc = "||";
			temp = rs_code.getString("term_code")+"~"+level1+"~"+code_level_desc+"~"+rs_code.getString("term_code_desc")+"`";
			temp_db_chk.append(rs_code.getString("term_code")+"~");
//			sr_nos+=rs_code.getString("order_no")+"~";
			sr_nos.append(rs_code.getString("order_no")+"~");

			if(term_code_associated.indexOf(temp) == -1)
			{
//				DB_term_code_associated += temp ;
				DB_term_code_associated.append(temp);
				db_count++;
			}
			mode_flag =true;
		}

	
	  if ( rs_code !=null ) rs_code.close();
	  if ( pstmt_code !=null ) pstmt_code.close();
	  if(returnVal.equals(""))
		{
//			term_code_associated = DB_term_code_associated + term_code_associated;
			term_code_associated.append(DB_term_code_associated);
		}
		else
			{
			term_code_associated=DB_term_code_associated;
			}
		}
	sr_nos.append(sr_nos1);
	term_code_associated.append(term_code_associated1);
	StringTokenizer stoken=new StringTokenizer(term_code_associated.toString(),"`");
	cnt=stoken.countTokens();
	  try{
		if (con != null) ConnectionManager.returnConnection(con,request);
	  }
	  catch(Exception e)
	  {
		out.println("Exception "+e.toString());
	  }

	if(mode_flag && mode.equals("2"))
	{
			session.putValue("db_count",String.valueOf(db_count));
			session.putValue("sr_nos",sr_nos.toString());
	}
	else if(!mode.equals("2"))
	{
		session.putValue("db_count",String.valueOf(0));
					session.putValue("sr_nos","");
	}

	if(!mode_flag)
			db_count=Integer.parseInt((String)session.getValue("db_count"));

	if(sr_nos==null || (sr_nos.toString()).equals(""))
	{
		String s_tmp = (String)session.getValue("sr_nos")==null?"":(String)session.getValue("sr_nos");
		sr_nos.append(s_tmp);
	}
	

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

	
	if(cnt>0)
	{
		String display="display:none";String term_assc_temp="";
		String term_code="",level="",term_code_desc="",level_code_desc="";
		int tmp_level=0;
		//int i=0;
		/*while(rs_code.next())
			{
			term_code=rs_code.getString("term_code");
			term_code_desc=checkForNull(rs_code.getString("term_code_desc"));
			level_code_desc=checkForNull(rs_code.getString("code_level_desc"));
			//code_level_desc=checkForNull(rs_code.getString("code_level"));*/
		StringTokenizer token_no=null;
		if(sr_nos!=null || !(sr_nos.toString()).equals(""))
			token_no= new StringTokenizer(sr_nos.toString(),"~");
		
		for(int i=0;i<cnt;i++)
		{
			display ="";
			if(stoken.hasMoreTokens())
			{
				term_assc_temp=stoken.nextToken();
				
				
				StringTokenizer token= new StringTokenizer(term_assc_temp,"~");
				term_code=token.nextToken();
				if(token.hasMoreTokens())
				{
					level=token.nextToken();
					if(level.equals("||"))
						level="";
				}

				if(token.hasMoreTokens())
				{
					level_code_desc=token.nextToken();
					if(level_code_desc.equals("||"))
						level_code_desc="";
				}

				if(token.hasMoreTokens())
					term_code_desc=token.nextToken();
//				temp_term_code +=term_code+"~";
				temp_term_code.append(term_code+"~");
				
				if(!level.equals("") && tmp_level < Integer.parseInt(level))
					tmp_level = Integer.parseInt(level);

				
			}

			if(token_no!=null && !(sr_nos.toString()).equals("") && token_no.hasMoreTokens())
				temp_no=token_no.nextToken();
			else
			{
				temp_no="";
			}

			if(i<db_count)
			{
				//tag = "<B>";tag1="</B>";
				tag = "";tag1="";
				checked="checked";
			}
			else
			{
				tag = "";tag1="";
				checked="checked";
			}
			
			if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(display));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(level_code_desc));
            out.print( String.valueOf(tag1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(term_code));
            out.print( String.valueOf(tag1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(term_code_desc));
            out.print( String.valueOf(tag1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(tag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(checkbox));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(temp_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(i==0)
				{
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(checkbox));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(level));
            _bw.write(_wl_block43Bytes, _wl_block43);

	}
}
 if ( rs_code !=null ) rs_code.close();
	  if ( pstmt_code !=null ) pstmt_code.close();
		//if(mode.equals("2") || db_count!=0)
		if(mode.equals("2"))
		{
            _bw.write(_wl_block44Bytes, _wl_block44);

		}
		else
		{
            _bw.write(_wl_block45Bytes, _wl_block45);
		}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(term_group_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(temp_term_code.toString()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(term_code_associated.toString()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(DB_term_code_associated.toString()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(db_count));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(indextype_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf((cnt-1)));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(returnVal1));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TerminologyCodeAssociated.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCodeDescription.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SerialNo.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
