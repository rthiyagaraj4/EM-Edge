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
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __icdfordiaggroupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ICDForDiagGroupResult.jsp", 1709118937032L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 =" \n<html>\n    <head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t<!-- <script language=\'javascript\' src=\'../js/ICDCodeForTabList.js\'></script> -->\n\t<script language=\'javascript\' src=\'../js/ICDForDiagGroup.js\'></script>\n\n\t</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<body  OnMouseDown=\"CodeArrest()\" onLoad=\"FocusFirstElement();\" onKeyDown=\'lockKey()\'>\n\t<form name=\'tablistQueryResult\' id=\'tablistQueryResult\' method=\"post\" action=\"../../eMR/jsp/ICDForDiagGroupResult.jsp\" action=\'messageFrame\' >\t\n\t\n\t<table width=\'100%\' border=0 cellspacing=0>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<tr>\n\t\t<td colspan=\'6\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:callMember1(\'A\')\">A</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'B\')\">B</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'C\')\">C</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'D\')\">D</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'E\')\">E</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'F\')\">F</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'G\')\">G</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'H\')\">H</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'I\')\">I</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'J\')\">J</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'K\')\">K</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'L\')\">L</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'M\')\">M</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'N\')\">N</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'O\')\">O</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'P\')\">P</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'Q\')\">Q</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'R\')\">R</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'S\')\">S</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'T\')\">T</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'U\')\">U</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'V\')\">V</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'W\')\">W</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'X\')\">X</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'Y\')\">Y</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'Z\')\">Z</a>&nbsp;&nbsp;<a href=\"javascript:callMember1(\'Others\')\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a>&nbsp;&nbsp;</td>\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</table>\n\t<table border=\'0\' align=\'right\'>\n\t<tr>\n\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\n\t</tr>\n\t</table>\n\t<br>\n\t<br>\n\t<table  align=\'center\' cellpadding=0 cellspacing=0 border=1 width=\'100%\'>\n\t<tr id=\'header\'>\n\t\t<th nowrap> ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<th> ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t</tr>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<input type=\'hidden\' name=\'group_type\' id=\'group_type\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\n\t<input type=\'hidden\' name=\'diag_group_code\' id=\'diag_group_code\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' >\n\t<input type=\'hidden\' name=\'selectedAlpha\' id=\'selectedAlpha\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' >\n\t<input type=\'hidden\' name=\'diag_code_scheme\' id=\'diag_code_scheme\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n\t<input type=hidden name=from value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t<input type=hidden name=to value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\t\n\t<input type=hidden name=\'continue_yn\' id=\'continue_yn\' value=\'Y\'>\n\n\t  <input type=hidden name=\'alphadescription\' id=\'alphadescription\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t  <input type=hidden name=\'searchby\' id=\'searchby\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t  <input type=hidden name=\'searchcrt\' id=\'searchcrt\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t</form>\n\t</body>\n\n\n</html>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    public static String checkForNullnb(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
	}
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet icdforDiagGroup= null;synchronized(session){
                icdforDiagGroup=(webbeans.eCommon.RecordSet)pageContext.getAttribute("icdforDiagGroup",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(icdforDiagGroup==null){
                    icdforDiagGroup=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("icdforDiagGroup",icdforDiagGroup,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
        Connection conlConn = null;
        int initCount = 1;
        
        Statement stmt1 = null;
        ResultSet rstlRs1 = null;
        //Statement stmt2 = null;
        //ResultSet rstlRs2 = null;
        
        PreparedStatement stmt3 = null;
        ResultSet rstlRs3 = null;
		String alphadescription="";
		String searchby="";
		String searchcrt="";

 try
 {
	 conlConn = ConnectionManager.getConnection(request);
	 String group_type = request.getParameter("group_type");
	 if(group_type == null) group_type="";
     searchby					= checkForNull(request.getParameter("searchby"));
	 searchcrt					= checkForNull(request.getParameter("searchcrt"));
	 alphadescription				= checkForNull(request.getParameter("alphadescription"));
	 String diag_group_code = request.getParameter("diag_group_code");
		if(diag_group_code == null) diag_group_code="";
	 String selectedAlpha = request.getParameter("selectedAlpha");
		if(selectedAlpha == null) selectedAlpha="";
	String diag_code_scheme = request.getParameter("diag_code_scheme");
		if(diag_code_scheme == null) diag_code_scheme="";
//     String continue_yn = request.getParameter("continue_yn")==null?"":request.getParameter("continue_yn");   
	 
    String flagSelect = request.getParameter("fromSelect");
      	
			if(flagSelect !=null)
        	{
        		icdforDiagGroup.clearAll();
				String sqlinsVals="";
				if (group_type.equals("P")&&diag_code_scheme.equals("3"))
				sqlinsVals= " select cpt_code from mr_proc_group_dtl  where group_type = ? and diag_group_code= ? ";				 
				else
				sqlinsVals= " select diag_srl_no from mr_diag_group_dtl  where group_type = ? and diag_group_code= ? ";

				stmt3=conlConn.prepareStatement(sqlinsVals);
				stmt3.setString(1,group_type);
				stmt3.setString(2,diag_group_code);
				rstlRs3 = stmt3.executeQuery();

			if(rstlRs3 !=null)
			{
				 while(rstlRs3.next())
				 {
					icdforDiagGroup.putObject(rstlRs3.getString(1));
				 }
			}
			
        	}
			//        int recordCount			=	0;
			String  req_start   =   "", req_end     =   "";

			String  checkedOnes         =   "";
			String from = request.getParameter("from") ;
			String to = request.getParameter("to") ;
			int maxRecord = 0;
			int start = 0 ;
			int end = 0 ;
			int i=1;
		
		if (from == null || from.equals("0") ){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }

        req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
        req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

        if(from != null && to != null)
        {
                int j=0;
                for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                {
                    if(request.getParameter("icdCodeNum"+(i)) != null)
                    { 
                        checkedOnes = request.getParameter("icdCodeNum"+(i));
                        if(!(icdforDiagGroup.containsObject(checkedOnes)))
                            icdforDiagGroup.putObject(checkedOnes);

                        j++;
                    }
                    else
                    {
                    
                    }
                }

       
            out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
            out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
        }
        i = 1 ;

 

 /*String sqlCount="";
 if (group_type.equals("P")&&diag_code_scheme.equals("3"))
	 {
	  if(!alphadescription.equals(""))
	   {
		  sqlCount="select count(1)  from mr_cpt_code where ";
		  if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
				sqlCount=sqlCount+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sqlCount=sqlCount+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sqlCount=sqlCount+ "UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
				sqlCount=sqlCount+ "UPPER (CPT_CODE) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sqlCount=sqlCount+ "UPPER (CPT_CODE) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sqlCount=sqlCount+ "UPPER (CPT_CODE) LIKE  upper( '"+alphadescription+"%')";
			}
	   }
	   else{
		if(selectedAlpha.equals("Others"))
			sqlCount="select count(1) from mr_cpt_code where upper(substr(short_desc,1,1)) not between 'A' and 'Z'  order by  short_desc";
		else
			sqlCount="select count(1)  from mr_cpt_code where UPPER (short_desc) like '"+selectedAlpha+"%' order by  short_desc ";
	   }
	 }
else
	 {
		if(!alphadescription.equals(""))
	   {
		  sqlCount="select count(1)  from mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"' and ";
		  if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
				sqlCount=sqlCount+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sqlCount=sqlCount+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sqlCount=sqlCount+ "UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
				sqlCount=sqlCount+ "UPPER (diag_code) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sqlCount=sqlCount+ "UPPER (diag_code) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sqlCount=sqlCount+ "UPPER (diag_code) LIKE  upper( '"+alphadescription+"%')";
			}
	   }
	   else{
		if(!selectedAlpha.equals("Others"))
			 sqlCount= " select count(1) from  mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"' and short_desc like '"+selectedAlpha+"%' ";
		else
			 sqlCount= " select count(1) from  mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"' and upper(substr(short_desc,1,1)) not between 'A' and 'Z' ";
	   }
	 }

 stmt2= conlConn.createStatement();
 
 rstlRs2 = stmt2.executeQuery(sqlCount);
 rstlRs2.next();
  maxRecord = rstlRs2.getInt(1);
  if(maxRecord==0)
			{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}*/
	String sql="";
 if (group_type.equals("P")&&diag_code_scheme.equals("3"))
	 {
		if(!alphadescription.equals(""))
	   {
		   sql="select cpt_code diag_code ,short_desc,cpt_code from mr_cpt_code where";
		   if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
				sql=sql+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sql=sql+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sql=sql+ "UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
				sql=sql+ "UPPER (CPT_CODE) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sql=sql+ "UPPER (CPT_CODE) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sql=sql+ "UPPER (CPT_CODE) LIKE  upper( '"+alphadescription+"%')";
			}
			if(searchby.equals("D"))
				sql=sql+" order by 2";
			else if(searchby.equals("C"))
				sql=sql+" order by 1";
	   }
	   else{
		if(selectedAlpha.equals("Others"))
			sql="select cpt_code diag_code ,short_desc,cpt_code from mr_cpt_code where upper(substr(short_desc,1,1)) not between 'A' and 'Z'  order by  short_desc";
		else
		  sql="select cpt_code diag_code ,short_desc,cpt_code from mr_cpt_code where UPPER (short_desc) like '"+selectedAlpha+"%' order by  short_desc ";
	   }
	 }
else
	 {
		
	   if(!alphadescription.equals(""))
	   {
		   sql="select diag_code ,short_desc,diag_srl_no from mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"'   and ";
		   if(searchby.equals("D"))
			{
				if(searchcrt.equals("C"))
				sql=sql+" UPPER (short_desc) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sql=sql+ "UPPER (short_desc) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sql=sql+ "UPPER (short_desc) LIKE  upper( '"+alphadescription+"%')";
			}
			else if(searchby.equals("C"))
			{
				if(searchcrt.equals("C"))
				sql=sql+ "UPPER (diag_code) LIKE  upper( '%"+alphadescription+"%')";
				else if(searchcrt.equals("E"))
				sql=sql+ "UPPER (diag_code) LIKE  upper( '%"+alphadescription+"')";
				else if(searchcrt.equals("S"))
				sql=sql+ "UPPER (diag_code) LIKE  upper( '"+alphadescription+"%')";
			}
			if(searchby.equals("D"))
				sql=sql+" order by 2";
			else if(searchby.equals("C"))
				sql=sql+" order by 1";
	   }
	   else{
		if(selectedAlpha.equals("Others"))
			sql="select diag_code ,short_desc,diag_srl_no from mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"' and upper(substr(short_desc,1,1)) not between 'A' and 'Z'  order by  short_desc";
		else
		  sql="select diag_code ,short_desc,diag_srl_no from mr_icd_code where diag_code_scheme ='"+diag_code_scheme+"'   and UPPER (short_desc) like '"+selectedAlpha+"%' order by  short_desc ";
	   }
	 }

//out.println("sql is:"+sql);
 //stmt1 = conlConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
 stmt1 = conlConn.createStatement();
 rstlRs1 = stmt1.executeQuery(sql);

if ( start != 0 )
	{
	 for( int j=1; j<start; i++,j++ ){
	  rstlRs1.next() ;
	  }
	  initCount+=start;
	  --initCount;
	}

 if (maxRecord==0)
			{

            _bw.write(_wl_block8Bytes, _wl_block8);
if(alphadescription.equals(""))
	   {
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

	    if ( !(start <= 1)) {
	
	    out.println("<td align ='right' id='prev'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
	
	
	    }
	   // if ( !((start+12) > maxRecord )){
	
		out.println("<td align ='right' id='next' style='visibility:hidden'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
	
	    //}
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
 
			}
	 String classValue = "" ;String diag_srl_no="";
//	recordCount			=	icdforDiagGroup.getSize();

	String chkAttribute="";
	
	/*if ( start != 0 )
	{
	 for( int j=1; j<start; i++,j++ ){
	  rstlRs1.next() ;
	  }
	  initCount+=start;
	  --initCount;
	}*/
	//while(rstlRs1.next() && i<=end ) {

		
		while( i<=end && rstlRs1.next() ) {
	diag_srl_no = rstlRs1.getString(3);
//    out.println(diag_srl_no);
	
	if(icdforDiagGroup.containsObject(diag_srl_no))  
		chkAttribute = "CHECKED";
	else
		chkAttribute="";	
	
	int recordIndex = icdforDiagGroup.indexOfObject(diag_srl_no);
	
	if(recordIndex!=-1)
		if(chkAttribute.equals("CHECKED"))    icdforDiagGroup.removeObject(recordIndex);		
	
	if ( i % 2 == 0 )
	classValue = "QRYEVEN" ;
	else
	classValue = "QRYODD" ;
	
	out.println("<tr>");
		out.println("<td class='"+classValue+"' width='5%'>"+checkForNullnb(rstlRs1.getString(1))+"</td>");
		out.println("<td  class='"+classValue+"' width='90%' >"+checkForNullnb(rstlRs1.getString(2))+"</td>");
		out.println("<td align='center' width='5%' class='"+classValue+"' ><input type='checkbox'  "+chkAttribute +" name='icdCodeNum"+initCount+"' id='icdCodeNum"+initCount+"'  value='"+diag_srl_no+"'></td>");
		out.println("</tr>");
	  i++;
	  initCount++;
	  maxRecord++;
	  } 
	  
	  if ( maxRecord < 12 || (!rstlRs1.next()) )
			{
				
            _bw.write(_wl_block15Bytes, _wl_block15);
 
			}
			else
			{
            _bw.write(_wl_block16Bytes, _wl_block16);

			}

		if(maxRecord==0)
			{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
  
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(group_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(diag_group_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(selectedAlpha));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(start));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(end));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(start));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(end));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alphadescription));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(searchby));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(searchcrt));
            _bw.write(_wl_block28Bytes, _wl_block28);
    }
catch(Exception e){
       
    }
finally{
           
		try
		{
				if(stmt1 != null){ stmt1.close(); }
				if(rstlRs1 != null){ rstlRs1.close(); }
				//if(stmt2 != null){ stmt2.close(); }
				//if(rstlRs2 != null){ rstlRs2.close(); }
				if(stmt3 != null){ stmt3.close(); }
				if(rstlRs3 != null){ rstlRs3.close(); }
		}
		catch(Exception e){
			//out.println("Exception @ finally "+e.toString());
			e.printStackTrace();
		}
	  session.setAttribute("icdforDiagGroup", icdforDiagGroup);
	  ConnectionManager.returnConnection(conlConn,request);
  }

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICDCode.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TITLE.label", java.lang.String .class,"key"));
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
}
