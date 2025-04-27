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
import eCommon.XSSRequestWrapper;

public final class __icdcodefordaggerqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ICDCodeForDaggerQueryResult.jsp", 1709118932517L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n     <head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t<script language=\'javascript\' src=\'../js/ICDCodeForTabList.js\'></script>\n\t<script src=\'../../eMR/js/ICDCodeForDagger.js\' language=\'javascript\'></script>\n    <script language=javascript>\n\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n\t<body  OnMouseDown=\"CodeArrest()\" onLoad=\"FocusFirstElement();\" onKeyDown=\'lockKey()\'>\n\t<form name=\'tablistQueryResult\' id=\'tablistQueryResult\' method=\"post\" action=\"../../eMR/jsp/ICDCodeForDaggerQueryResult.jsp\"   >\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t<th width=\'100%\'>&nbsp;</th>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:callMember(\'A\')\">A</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'B\')\">B</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'C\')\">C</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'D\')\">D</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'E\')\">E</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'F\')\">F</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'G\')\">G</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'H\')\">H</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'I\')\">I</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'J\')\">J</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'K\')\">K</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'L\')\">L</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'M\')\">M</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'N\')\">N</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'O\')\">O</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'P\')\">P</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Q\')\">Q</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'R\')\">R</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'S\')\">S</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'T\')\">T</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'U\')\">U</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'V\')\">V</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'W\')\">W</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'X\')\">X</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Y\')\">Y</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Z\')\">Z</a>&nbsp;&nbsp;<a href=\"javascript:callMember(\'Others\')\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</a>&nbsp;&nbsp;</td>\n\t</tr>\n\t</table>\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'80%\' align=\'center\'>\n\t<tr>\n\t\t<td class=\"white\">\n\t\t<table border=\'0\' align=\'right\'>\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<td align =\'right\' id=\'prev\'>\n\t\t\t\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' text-decoration=\'none\'>Previous</a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n\t\t\t\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")\' text-decoration=\'none\'>Next</a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\n\t\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\t\n\t<tr>\n\t<td>\n\t<table  align=\'center\' cellpadding=0 cellspacing=0 border=1 width=\'100%\'>\n\t\t<tr id=\'header\'>\n\t\t\t<th nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t<th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<input type=\'hidden\' name=\'dagger_code\' id=\'dagger_code\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n\t\t\t<input type=\'hidden\' name=\'selectedAlpha\' id=\'selectedAlpha\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >\n\t\t\t<input type=hidden name=from value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<input type=hidden name=to value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t<input type=hidden name=\'scheme\' id=\'scheme\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t</table>\n\t\t</td>\n\t</tr>\n\t</table>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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

/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Asterisk Codes for Dagger Codes 
/// Developer		:	SRIDHAR R
/// Created On		:	1 DEC 2004
/// Function 		:   Used to associate Asterisk Codes for a selected Dagger Code...
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet accessRightRecSet= null;synchronized(session){
                accessRightRecSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightRecSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightRecSet==null){
                    accessRightRecSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightRecSet",accessRightRecSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet accessLeftRecSet= null;synchronized(session){
                accessLeftRecSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessLeftRecSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessLeftRecSet==null){
                    accessLeftRecSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessLeftRecSet",accessLeftRecSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection Con = null;
	int initCount = 1;
	Statement stmt1		= null;
	ResultSet rstlRs1	= null;
	//Statement stmt2		= null;
	//ResultSet rstlRs2	= null;
	Statement stmt3		= null;
	ResultSet rstlRs3	= null;
	try
	{
		Con = ConnectionManager.getConnection(request);
		String dagger_code = request.getParameter("dagger_code");
		if(dagger_code == null) dagger_code="";
	
		String selectedAlpha = request.getParameter("selectedAlpha");
		if(selectedAlpha == null) selectedAlpha="";

		String scheme = request.getParameter("scheme");
		if(scheme == null) scheme="";

		String flagSelect = request.getParameter("fromSelect");
		if(flagSelect !=null)
		{
			accessRightRecSet.clearAll();
			accessLeftRecSet.clearAll();
		
			String sqlinsVals= " SELECT astk_diag_srl_no diag_srl_no, astk_diag_code diag_code, astk_short_desc short_desc FROM mr_icd_code_dtl_vw WHERE dag_diag_code = '"+dagger_code+"' ";
			stmt3=Con.createStatement();
			rstlRs3 = stmt3.executeQuery(sqlinsVals);
			if(rstlRs3 !=null)
			{
				while(rstlRs3.next())
				{
					accessRightRecSet.putObject(rstlRs3.getString(1));
					accessLeftRecSet.putObject(rstlRs3.getString(2));
				}
			}
		}
//		int recordCount			=	0;
		String  req_start   =   "", req_end     =   "";
		String  checkedOnes         =   "";
		String  checkedOnesCode         =   "";
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;

		if(from == null)
			start = 1 ;  
		else 
			start = Integer.parseInt(from); 

		if(to == null)
			end = 12 ; 
		else 
			end = Integer.parseInt(to); 
		
		req_start = request.getParameter("start");
			if(req_start== null) req_start = "0";

		req_end =   request.getParameter("end");
			if(req_end== null) req_end = "0";

		if(from != null && to != null)
		{
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
			{
				if(request.getParameter("astk_diag_srl_no"+(i)) != null)
				{
					checkedOnes = request.getParameter("astk_diag_srl_no"+(i));
					checkedOnesCode = request.getParameter("astk_diag_code"+(i));
					if(!(accessRightRecSet.containsObject(checkedOnes)))
					{
						accessRightRecSet.putObject(checkedOnes);
						accessLeftRecSet.putObject(checkedOnesCode);

					}
					j++;
				}
			}
			out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
			out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
		}

		i = 1 ;
		//String sqlCount="";

		/*if(selectedAlpha.equals("Others"))
		{
			sqlCount=" select count(*) from MR_ICD_CODE where eff_status = 'E' and DIAG_CODE_SCHEME = '"+scheme+"' and code_indicator = 'A' and upper(substr(short_desc,1,1)) not between 'A' and 'Z' ";
		}
		else
		{
			sqlCount=" SELECT count(*) from MR_ICD_CODE where eff_status = 'E' and DIAG_CODE_SCHEME = '"+scheme+"' and code_indicator = 'A' and UPPER (short_desc) like '"+selectedAlpha+"%' ";
		}


		stmt2	= Con.createStatement();
		rstlRs2 = stmt2.executeQuery(sqlCount);
		rstlRs2.next();
		maxRecord = rstlRs2.getInt(1);*/
		String sql="";

		if(selectedAlpha.equals("Others"))
		{
			sql=" select diag_code ,short_desc, diag_srl_no from mr_icd_code where eff_status = 'E' and DIAG_CODE_SCHEME = '"+scheme+"' and code_indicator = 'A' and upper(substr(short_desc,1,1)) not between 'A' and 'Z' ";
		}
		else
		{
			sql=" SELECT diag_code ,short_desc,diag_srl_no from mr_icd_code where eff_status = 'E' and DIAG_CODE_SCHEME = '"+scheme+"' and code_indicator = 'A' and UPPER (short_desc) like '"+selectedAlpha+"%' ";
		}

		//stmt1 = Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt1 = Con.createStatement();
		rstlRs1 = stmt1.executeQuery(sql);

//out.println("Final SQL : "+sql);

		if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rstlRs1.next() ;
			}
			initCount+=start;
			--initCount;
		}

	//while(i<=end && rstlRs1.next()) 
		//{

	if (maxRecord==0)
			{
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
	
					if(!(start <= 1)) 
					{	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-12)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-12)));
            _bw.write(_wl_block12Bytes, _wl_block12);
	}
					//if(!((start+12) > maxRecord ))
						
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((start+12)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+12)));
            _bw.write(_wl_block14Bytes, _wl_block14);
		
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
 
	}
		String classValue = "" ;
		String diag_srl_no="";
//		recordCount =	accessRightRecSet.getSize();
		String chkAttribute="";

		/*if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rstlRs1.next() ;
			}
			initCount+=start;
			--initCount;
		}*/

		//while(rstlRs1.next() && i<=end ) 
		//{
		while(i<=end && rstlRs1.next()) 
		{

			diag_srl_no = rstlRs1.getString(3);
			
			if(accessRightRecSet.containsObject(diag_srl_no))  
				chkAttribute = "CHECKED";
			else
				chkAttribute="";
			
			int recordIndex = accessRightRecSet.indexOfObject(diag_srl_no);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    
			{
				accessRightRecSet.removeObject(recordIndex);
				accessLeftRecSet.removeObject(recordIndex);
			}
			
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			out.println("<tr>");
			out.println("<td class='"+classValue+"' width='5%' >"+rstlRs1.getString(1)+"</td>");
			out.println("<td class='"+classValue+"' width='90%'>"+rstlRs1.getString(2)+"</td>");
			out.println("<td align='center' width='5%' class='"+classValue+"'><input type='checkbox'  "+chkAttribute+" name='astk_diag_srl_no"+initCount+"' id='astk_diag_srl_no"+initCount+"' value='"+diag_srl_no+"'     </td>");
			out.println("</tr>");
			out.println("<input type='hidden'  "+chkAttribute+" name='astk_diag_code"+initCount+"' id='astk_diag_code"+initCount+"'  value='"+rstlRs1.getString(1)+"'>");
			out.println("</tr>");
			i++;
			initCount++;
			maxRecord++;
		} 

			
			if ( maxRecord < 12 || (!rstlRs1.next()) )
			{
				
            _bw.write(_wl_block18Bytes, _wl_block18);
 
			}
			else
			{
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dagger_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(selectedAlpha));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(start));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(end));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(scheme));
            _bw.write(_wl_block27Bytes, _wl_block27);
  }catch(Exception e)
	{
        //out.println("Error in displaying the records "+e);
		e.printStackTrace();
    }finally
	{
		try
		{
		if(rstlRs1 != null) rstlRs1.close(); 
		if(stmt1 != null)	stmt1.close(); 
		//if(rstlRs2 != null) rstlRs2.close(); 
		//if(stmt2 != null)	stmt2.close(); 
		if(rstlRs3 != null)	rstlRs3.close();
		if(stmt3 != null)	stmt3.close(); 
		}
		catch(Exception e)
	{
			//out.println("Exception @ try "+e.toString());
			e.printStackTrace();
    }
		session.setAttribute("AXSRightRecSet", accessRightRecSet);
		session.setAttribute("AXSLeftRecSet", accessLeftRecSet);
		ConnectionManager.returnConnection(Con,request);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AsteriskCode.label", java.lang.String .class,"key"));
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
