package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eMR.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import webbeans.eCommon.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.eslp.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __agegroupfortermcodedetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AgeGroupForTermCodeDetail.jsp", 1722863419695L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!-- AgeGroupForTermCodeDetail.jsp -->\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n\t\t\t\n\t\n\t<script language=\"JavaScript\" src=\"../js/AgeGroupForTermCode.js\"></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t</head>\n\t\t<body  onKeyDown = \'lockKey()\';  OnMouseDown=\"CodeArrest()\">\n\t\t<form name=\'form_AgeGrupdetail\' id=\'form_AgeGrupdetail\' action=\"../../servlet/eMR.AgeGroupForTermCodeServlet\" target=\"messageFrame\" method=\'post\' >\n\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<br><br>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t<!--<td align=\'right\'  id=\'prevNext\'  class=\'BODYCOLORFILLED\'>-->\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</tr>\n\t\t</table><br><br>\n\t\t\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'  width=\'80%\' >\n\t\t\t<tr>\n\t\t\t<td width=\'100%\' colspan=\'2\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\t\t\t\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' align=\"left\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'><input type=\'checkbox\' name=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="chk";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'  value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" onclick=\"updateValue(this);setchkAll(this);\"></td>\n\t\t\t</tr>\n\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<script >\n\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n\t<input type=hidden name=from value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t<input type=hidden name=to value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t<input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'maxRecords\' id=\'maxRecords\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t<input type=\'hidden\' name=\"age_group_code\" id=\"age_group_code\" value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t<input type=\'hidden\' name=\"term_set_id\" id=\"term_set_id\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t<input type=\'hidden\' name=\"type\" id=\"type\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t<input type=\'hidden\' name=\"alphalink\" id=\"alphalink\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t<input type=\'hidden\' name=\"flag\" id=\"flag\" value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\n\t</table>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\n\t</form>\n\t</body>\n </html>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

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
            webbeans.eCommon.RecordSet AgeGroupForTermCode= null;synchronized(session){
                AgeGroupForTermCode=(webbeans.eCommon.RecordSet)pageContext.getAttribute("AgeGroupForTermCode",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(AgeGroupForTermCode==null){
                    AgeGroupForTermCode=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("AgeGroupForTermCode",AgeGroupForTermCode,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;String classValue="";
	String term_set_id="";
	//String checked="";
	String type="";
	String term_code_desc="";
	String age_group_code="";
	String sql_associated="";
	String term_code="" , short_desc="";
	String search_criteria="" , search_text="" ;
	Statement stmt_Associated=null;
	
	ResultSet rset_Associated=null ;
	/*
		This logic for the defaulted the values which is already select in deffirent age group of same termset
	*/

	List listTermCode=(ArrayList)session.getAttribute("compareTermCode");

	Set set = new HashSet();
	List newListTermCode = new ArrayList();
	 for (Iterator iter = listTermCode.iterator();    iter.hasNext(); ) {
	 Object element = iter.next();
	   if (set.add(element))
		  newListTermCode.add(element);
			}

	/*
		End here 
	*/


	try{
	con = ConnectionManager.getConnection(request);

term_set_id=request.getParameter("term_set_id")== null?"":request.getParameter("term_set_id");
age_group_code=request.getParameter("age_group_code")==null ? "":request.getParameter("age_group_code");
type=request.getParameter("type")== null?"":request.getParameter("type");
term_code_desc=request.getParameter("term_code_desc")== null ? "":request.getParameter("term_code_desc");
search_criteria=request.getParameter("search_criteria") == null ? "": request.getParameter("search_criteria");
if(search_criteria.equals("S"))
				 search_text = term_code_desc +"%";
     else if(search_criteria.equals("E"))
             	 search_text ="%"+term_code_desc;
   	 else if(search_criteria.equals("C"))
   		   		 search_text = "%"+term_code_desc+"%";
   	 else
                 search_text = "%";
	String from = request.getParameter("from");
	String to = request.getParameter("to") ;
	int flag=0;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
        
        String chkAttribute="" ,disabled="";
        String dbaction="";
        String  req_start   =   "", req_end     =   "";
		/* Removed for Check Style correction 
		String db_action="";
		*/
       boolean isRecordFound = false;

        req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
        req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
		String alphalink = request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
		if(alphalink.equals("*"))
				{
					alphalink="_";
				}

            _bw.write(_wl_block8Bytes, _wl_block8);
	
		ArrayList TabList		= null;

		ArrayList sessionList			=  (ArrayList)AgeGroupForTermCode.getRecordSetHandle();
		if(sessionList.size()>0)
		{
			TabList=(ArrayList)AgeGroupForTermCode.getObject(0);
		}
		if(alphalink.equals("Associated"))
		{
						
			 sql_associated="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,'U' db_action FROM mr_age_grp_for_term_code a, mr_term_code b WHERE a.age_group_code = '"+age_group_code+"' and  b.term_set_id = '"+term_set_id+"' and  b.term_set_id = a.term_set_id AND b.term_code = a.term_code and (( '"+type+"' = 'PR' and b.procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and b.diagnosis_yn = 'Y' )) and upper(short_desc) like upper('"+search_text+"') ORDER BY 3";
		}
		else
		{
			 sql_associated="select term_set_id, term_code, short_desc, 'I' db_action from mr_term_code where term_set_id = '"+term_set_id+"' and (( '"+type+"' = 'PR' and procedure_yn = 'Y' ) or ( '"+type+"' = 'DX' and diagnosis_yn = 'Y')) and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(short_desc,1,1)) = upper('"+alphalink+"') and upper(short_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and substr(short_desc,1,1) not between 'A' and 'Z' and upper(short_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(short_desc) like upper('"+alphalink+"' || '"+search_text+"'))) and (term_set_id, term_code) not in (select term_set_id,term_code from mr_age_grp_for_term_code where age_group_code = '"+age_group_code+"') union all select a.term_set_id, a.term_code, b.short_desc ,'U' db_action from mr_age_grp_for_term_code a, mr_term_code b where a.age_group_code = '"+age_group_code+"' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( '"+type+"' = 'PR' and b.procedure_yn = 'Y' )or ( '"+type+"' = 'DX' and b.diagnosis_yn = 'Y' )) and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(short_desc,1,1)) = upper('"+alphalink+"') and upper(short_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and substr(short_desc,1,1) not between 'A' and 'Z' and upper(short_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(short_desc) like upper('"+alphalink+"' || '"+search_text+"'))) order by 3 ";  
	
		}
		
		stmt_Associated=con.createStatement();
		rset_Associated=stmt_Associated.executeQuery(sql_associated);
		if (start != 0){
		for(int j=1; j<=start; i++,j++){
			rset_Associated.next() ;
		}
	}

	
	
		while(i< end && rset_Associated.next() ){
            isRecordFound=true;
			term_code = rset_Associated.getString("term_code");
			short_desc=rset_Associated.getString("short_desc");
			dbaction=rset_Associated.getString("db_action");

if (maxRecord==0)
		{
		
            _bw.write(_wl_block9Bytes, _wl_block9);

	    if ( !(start <= 1)) {	
		out.println("<td align ='right' id='prev' ><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
	    }
	    //if ( !((start+12) >= maxRecord )){
	    out.println("<td align ='right' id='next' style='visibility:hidden'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
	
	   //}
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		}		
			if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
							
			if(dbaction.equals("U")){
				if(alphalink.equals("Associated"))
						disabled="";
				else
					disabled="Disabled";
			}
			
			if(TabList.contains(term_code))
			{
				chkAttribute="checked";
			}
			else
				chkAttribute="";

			/*
			Disableing field which is alredy defaulted
			*/
				String legDisabled="";
			if(newListTermCode.contains(term_code))
				legDisabled="Disabled";
			else
				legDisabled="";
				/*
				End here 
				*/
			

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(alphalink));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(alphalink));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(legDisabled));
            _bw.write(_wl_block21Bytes, _wl_block21);

			i++;
			chkAttribute="";
			disabled="";
			if(TabList.size()>0)
				flag=1;
	
			maxRecord++;
		}

		if(isRecordFound==false)
		{
		     out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			 out.println("<script>parent.frames[2].location.href='../../eCommon/html/blank.html'</script>");
		}

		if ( maxRecord < 12 || (!rset_Associated.next()) )
			{
				
            _bw.write(_wl_block22Bytes, _wl_block22);
 
			}
			else
			{
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
			
	

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(start));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(end));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alphalink));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block35Bytes, _wl_block35);

	}catch(Exception e){
		e.printStackTrace();}
				finally { 
	if(rset_Associated!=null) rset_Associated.close();
	if(stmt_Associated!=null) stmt_Associated.close();

		ConnectionManager.returnConnection(con,request);
		session.setAttribute("AgeGroupForTermCode", AgeGroupForTermCode);
	}	
	
            _bw.write(_wl_block36Bytes, _wl_block36);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
}
