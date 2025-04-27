package jsp_servlet._eca._jsp;

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
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;

public final class __generalpractitionersearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/GeneralPractitionerSearchResult.jsp", 1742180266852L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n\t\n<style>\n\t.inner_table_site { \n\t\twidth:1100px;  \n\t\theight:325px;\n\t\toverflow-y: auto;\t\n\t} \t\n</style>\n\t\n</head>\n<script>\nfunction callonload(){\n\tif(parent.frames[0].document.getElementById(\'Search\'))\n\t\tparent.frames[0].document.getElementById(\'Search\').disabled=false;\n\tif(parent.frames[0].document.getElementById(\'clear\'))\n\t\tparent.frames[0].document.getElementById(\'clear\').disabled=false;\n\tif(parent.frames[0].document.getElementById(\"resultPageLoaded\"))\n\t\tparent.frames[0].document.getElementById(\"resultPageLoaded\").value=\"Y\";\n}\n</script>\n<body onload=\'callonload();\' onKeyDown = \'lockKey()\'>\n<form name=\'pract_form\' id=\'pract_form\'>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\nfunction closew(Dcode,position,tel,mobile,pager,job_title,pract_type,pract_type_desc,count,Name)\n{\nif(count!=1)\n\n\t\t  {var Name= eval(\'document.forms[0].desc\'+position).value;\n\t\t  while(Name.indexOf(\"+\")!=-1)\n\t\t  {\n\t\t\tName=Name.replace(\'+\',\" \");\n\t \t  }\n\t\t  while(pract_type_desc.indexOf(\"+\")!=-1)\n\t\t  {\n\t\t\tpract_type_desc=pract_type_desc.replace(\'+\',\" \");\n\t \t  }\n\t\t  }\n\t\twindow.parent.parent.returnValue=Dcode+\"~\"+Name+\"~\"+tel+\"~\"+mobile+\"~\"+pager+\"~\"+job_title+\"~\"+pract_type+\"~\"+pract_type_desc;\n\t\twindow.parent.parent.close();\n\t  }\n/******function to show practitioner details*********************/\nfunction showPractWindow(practID)\n\t{\n\t    var url     =\"../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id=\"+practID+\"&fcall=call\";\n\t    var dialogHeight    = \"30\" ;\n\t    var dialogWidth = \"40\" ;\n\t\t\n\t\t//Added for this CRF ML-MMOH-CRF-0862\n\t\tif(document.forms[0].isCernerpractitioner && document.forms[0].isCernerpractitioner.value==\"true\"){\n\t\t\t// dialogHeight    = \"30\" ;\n\t         dialogWidth = \"60\" ;\t\t\t\n\t\t}\t\t\n\t\t//End this CRF ML-MMOH-CRF-0862\n\t\t\n\t    var dialogLeft=\"\";\n\t    var arguments   = \"\" ;\n\t    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; status=no;dialogLeft:\"+dialogLeft+\";\";\n\t    var reportURL   = window.showModalDialog( url, arguments, features ) ;\n\t}\n\n </script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n<table align=\'right\' border=\'0\' >\n<tr>\n<td>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</td>\n</tr>\n</table>\n<BR><BR>\n</P>\n   ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="    \n\t <table class=\"head\" width=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t <table border=\"1\" width=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" cellspacing=\'0\' cellpadding=\'0\' id=\'tb1\'>\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<th width=\'60%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t<th width=\'40%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<th width=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' style=\'visibility:hidden\' >+</th>\n\t\t\t<th width=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\t\t\t\n\t\t\t<th width=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \n\t\t\t<th width=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t<th width=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</table>\n\t\t  <div class=\"inner_table_site\">\n\t\t  <table class=\"head\" width=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"  border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\t\t  \n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<input type=\'hidden\' name=\"desc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<a href=javascript:closew(\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\")>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<td class=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" width=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' style=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'  >\t\t  \n\t\t<a  href=\'javascript:closew(\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\",\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\")\'> ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</a></td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t <a href=\'javascript:closew(\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\")\'>\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t<a href=\'javascript:closew(\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<td class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' width=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' style=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td></tr>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script >\nif (document.getElementById(\'nextval\'))\ndocument.getElementById(\'nextval\').style.visibility=\'hidden\';\nif(";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="==1 && ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="==1 && \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"==\"N\")\n{\t\nclosew(\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\")\n}\n</script>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t<script >\n\t\n\tif (document.getElementById(\'nextval\'))\n\t\tdocument.getElementById(\'nextval\').style.visibility=\'visible\';\n\t</script>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n<script>\n\nif(parent.frames[0].document.getElementById(\'pract_id\'))\nparent.frames[0].document.getElementById(\'pract_id\').readOnly=false;                     \n\nif(parent.frames[0].document.getElementById(\'pract_name\'))\nparent.frames[0].document.getElementById(\'pract_name\').readOnly=false;               \n\n\nif(parent.frames[0].document.getElementById(\'Search\'))\nparent.frames[0].document.getElementById(\'Search\').disabled=false;\n\nif(parent.frames[0].document.getElementById(\'clear\'))\nparent.frames[0].document.getElementById(\'clear\').disabled=false;\n\n</script>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</table>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n</div>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n<input type=\'hidden\' name=\'searchtext\' id=\'searchtext\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" > \n<input type=\'hidden\' name=\'resultPageLoaded\' id=\'resultPageLoaded\' value=\"Y\" > \n<!--Below line added for this CRF ML-MMOH-CRF-0862--> \n<input type=\'hidden\' name=\'isCernerpractitioner\' id=\'isCernerpractitioner\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >  \n</form>\n\n</BODY>\n</html>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

    String user_sql="";
	request.setCharacterEncoding("UTF-8");	
    String tel_no="";
	String mobile_no="";
	String pager_no="";
	String endOfRes = "1" ;
	String job_title_practDetails="";
	String pract_type_dtls="";
	String pract_type_desc="";
	String pract_name_temp="";
	
	boolean isCernerpractitioner=false;
	String pract_word_wrap="";
	String pract_long_namewidth="";
	String other_desc_width="";	
	String pract_word_wrap_postion="";	
	String other_fields_width="";
    String plusSymbol_width="";	
	String pract_id_width="";
	String pract_full_namewidth="";
	String pract_full_word_wrap="";
	String tab_width="100%";
	String plussymbol_word_wrap="";	
	
	String srch_click			=request.getParameter("srch_click")==null?"N":request.getParameter("srch_click"); 
	String locale				=((String)session.getAttribute("LOCALE"));
	String facility_id			=(String)session.getAttribute("facility_id");
    String pract_type			=request.getParameter("pract_type")==null?"":request.getParameter("pract_type"); 
	String primary_specialty	=request.getParameter("primary_specialty")==null?"":request.getParameter("primary_specialty");
	String pract_id				=request.getParameter("pract_id")==null?"":request.getParameter("pract_id");              	
	String pract_name			=request.getParameter("pract_name")==null?"":request.getParameter("pract_name");         	
	String start_ends_contains	=request.getParameter("start_ends_contains")==null?"S":request.getParameter("start_ends_contains");  
	String job_title			=request.getParameter("job_title")==null?"":request.getParameter("job_title");
	String gender				=request.getParameter("gender")==null?"":request.getParameter("gender");         
	String bool_user_sql		=request.getParameter("bool_user_sql")==null?"":request.getParameter("bool_user_sql"); 
	String toggle_sql2			=request.getParameter("toggle_sql2")==null?"":request.getParameter("toggle_sql2"); 
	String radiovalue			=request.getParameter("radiovalue")==null?"":request.getParameter("radiovalue");
	String from					=request.getParameter( "from" ) ;
	String to					=request.getParameter( "to" ) ;
	pract_id=pract_id.trim();
	pract_name=pract_name.trim();
	int start = 0 ;
	int end = 0 ;
	//int k=0;
	if ( from == null ){
		start = 1 ;
	}else{
		start = Integer.parseInt( from ) ;
		/*if(!pract_name.equals("")){
			pract_name = URLDecoder.decode(pract_name,"UTF-8");
		}*/
	}
	if ( to == null ){
		end = 14 ;
	}else{
		end = Integer.parseInt( to ) ;
		/*if(!pract_name.equals("")){
			pract_name = URLDecoder.decode(pract_name,"UTF-8");
		}*/
	}
	if(toggle_sql2.equals("")){
		user_sql    = (String) session.getValue("sql")==null?"":(String) session.getValue("sql");
     		
	}
	if(toggle_sql2.equals("Yes")){
		user_sql       = (String) session.getValue("sqlSec")==null?"":(String) session.getValue("sqlSec");
	}
	if(bool_user_sql.equals("")){
		if(user_sql.equals("") ){
			bool_user_sql="0";
		}else{
			bool_user_sql="1";
		}
	}
	if(!pract_id.equals("") &&  bool_user_sql.equals("0") ){
		if(start_ends_contains.equals("S")){
			pract_id=pract_id+"%";
		}else if(start_ends_contains.equals("E")){
			pract_id="%"+pract_id;
		}else if(start_ends_contains.equals("C")){
			pract_id="%"+pract_id+"%";
		}
	}
	String code="";
	String desc="";

            _bw.write(_wl_block6Bytes, _wl_block6);

Connection conn=null;
PreparedStatement stmt=null;
ResultSet rs=null;
ResultSet rs1=null;

ResultSet rs_practDetail=null;
PreparedStatement pstmt_practDetail=null;

String searchtext="";
int i=1;
String dispDescFirst =request.getParameter("dispDescFirst");
if(dispDescFirst == null) dispDescFirst="";

try{
	conn=ConnectionManager.getConnection(request);

  isCernerpractitioner=CommonBean.isSiteSpecific(conn, "AM","CERNER_PRACTITIONER_ID");
  if(isCernerpractitioner){
     pract_word_wrap="word-wrap: break-word;width:248px";	
     pract_long_namewidth="248px";  
	 other_fields_width="130px";
	 pract_id_width="130px";
     plusSymbol_width="20px";	
	 plussymbol_word_wrap="word-wrap: break-word;width:20px";
     pract_word_wrap_postion="word-wrap: break-word;width:130px";	
     //pract_full_namewidth="167.5px";	 
	 //pract_full_word_wrap="word-wrap: break-word;width:167.5px";	
	 pract_full_namewidth="168px";
	 pract_full_word_wrap="word-wrap: break-word;width:168px";
	 //tab_width="1100px";
	 tab_width="1110px";
	 if(dispDescFirst.equals("dispDescFirst"))  tab_width="100%";
  }
  //End this CRF ML-MMOH-CRF-0862

String sql="";

//String searchcriteria=request.getParameter("search_criteria");
searchtext = request.getParameter("searchtext");
if(searchtext == null) searchtext="";

if(bool_user_sql.equals("0")){
	//out.println("<script>alert(\"inside default:-----"+bool_user_sql+"\")</script>");
	sql = "SELECT a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name,b.desc_sysdef practitioner_type ,c.short_desc  primary_specialty,d.POSITION_CODE job_title,am_get_desc.AM_POSITION(d.POSITION_CODE, '"+locale+"','1') job_title_desc ,a.gender FROM am_practitioner_lang_vw a, am_pract_type_lang_vw b,am_speciality_lang_vw c,am_position_lang_vw d, am_pract_for_facility e WHERE a.pract_type=NVL('"+pract_type+"',a.pract_type) And A.PRACTITIONER_ID=E.PRACTITIONER_ID AND E.FACILITY_ID='"+facility_id+"' AND a.primary_speciality_code=NVL('"+primary_specialty+"',a.primary_speciality_code) AND a.EFF_STATUS='E' AND A.EFF_STATUS=E.EFF_STATUS AND a.practitioner_id like upper(NVL('"+pract_id+"',a.practitioner_id)) AND  a.gender=NVL('"+gender+"',a.gender) AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL('"+job_title+"',NVL(a.position_code,'123'))) AND a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND  a.position_code=d.position_code(+) and a.language_id='"+locale+"' and b.language_id='"+locale+"' and c.language_id='"+locale+"' and d.language_id(+)='"+locale+"' and  upper(a.practitioner_name) LIKE ";
	if(start_ends_contains.equals("S")){
		pract_name_temp=pract_name+"%";
		sql=sql+"upper(?)";
	}else if(start_ends_contains.equals("E")){
		pract_name_temp="%"+pract_name;
		sql=sql+"upper(?)";
	}else if(start_ends_contains.equals("C")){
		pract_name_temp="%"+pract_name+"%";
		sql=sql+"upper(?)";
	}
}else{
	sql=user_sql;
	// break the incoming sql... if the position_code is fetched, include th get desc also for teh position code.
	int job_title_ind=sql.toUpperCase().indexOf("POSITION_CODE");
	int from_ind=sql.toUpperCase().indexOf("FROM");
	StringBuffer strbff=new StringBuffer();
	if(job_title_ind>0 && (job_title_ind<from_ind)){
		strbff.append(sql.substring(0,job_title_ind-2));
		if((sql.substring(job_title_ind-1,job_title_ind)).equals(".")){
			strbff.append("am_get_desc.AM_POSITION("+sql.substring(job_title_ind-2,job_title_ind)+"POSITION_CODE, '"+locale+"','1') job_title_desc,");
		}else{
			strbff.append(",am_get_desc.AM_POSITION(POSITION_CODE, '"+locale+"','1') job_title_desc");
		}
		strbff.append(sql.substring(job_title_ind-2,sql.length()));
		sql= strbff.toString();
	}else{
		strbff.append(sql.substring(0,from_ind));
		strbff.append(",am_get_desc.AM_POSITION(b.POSITION_CODE, '"+locale+"','1') job_title_desc ");
		strbff.append(sql.substring(from_ind,sql.length()));
		sql= strbff.toString();
	}
	strbff=null;
}

	
//sql=sql.toUpperCase();
int sqlind=sql.indexOf("order by");
if(sqlind == -1)
{
	sqlind=sql.indexOf("ORDER BY");
}

if(sqlind != -1)
{
	sql = sql.substring(0,sqlind-1);
}

try{

if(radiovalue.equals("C")){
sql=sql+" order by practitioner_id";
}
else{
sql=sql+" order by practitioner_name";
}
stmt = conn.prepareStatement(sql);




if(bool_user_sql.equals("0")){
	stmt.setString(1,pract_name_temp);

}else{



if(toggle_sql2.equals("")){
	
	if(start_ends_contains.equals("S"))
	{
		pract_name_temp=pract_name+"%";
		pract_id=pract_name+"%";
	}
	else if(start_ends_contains.equals("E"))
	{
			pract_name_temp="%"+pract_name;
			pract_id="%"+pract_name;
	}
	else if(start_ends_contains.equals("C"))
	{
			pract_name_temp="%"+pract_name+"%";
			pract_id="%"+pract_name+"%";
	}
}else{
	if(start_ends_contains.equals("S"))
	{
		pract_name_temp=pract_name+"%";
		pract_id=pract_id+"%";
	}
	else if(start_ends_contains.equals("E"))
	{
			pract_name_temp="%"+pract_name;
			pract_id="%"+pract_id;
	}
	else if(start_ends_contains.equals("C"))
	{
			pract_name_temp="%"+pract_name+"%";
			pract_id="%"+pract_id+"%";
	}
}
	if(pract_type.equals("")){
		stmt.setString(1,"%");
	}else{
		stmt.setString(1,pract_type);
	}

	if(!primary_specialty.equals("")){
	stmt.setString(2,primary_specialty);
	}

	if(pract_id.equals("")){
		stmt.setString(3,"%");
	}else{
		stmt.setString(3,pract_id);
	}
	if(pract_name.equals("")){
		stmt.setString(4,"%");
	}else{
		stmt.setString(4,pract_name_temp);
	}

	if(gender.equals("")){
		stmt.setString(5,"%");
	}else{
		stmt.setString(5,gender);
	}

	if(job_title.equals("")){
		stmt.setString(6,"%");
	}else{
		stmt.setString(6,job_title);
	}
	
	if(gender.equals("")){
		stmt.setString(5,"%");
	}else{
		stmt.setString(5,gender);
	}
    stmt.setString(7,facility_id); 
    stmt.setString(8,facility_id);  

    }

rs = stmt.executeQuery();
String gender1="";
String pract_id1="";
String pract_name1="";
String gender2	="";
if ( start != 1 )
for( int j=1; j<start; i++,j++ )
rs.next() ;
int count=0;
while(i<=end && rs.next()){
  
if(count==0)
{
            _bw.write(_wl_block7Bytes, _wl_block7);


if ( !(start <= 1) )
	out.println("<A HREF='../../eCA/jsp/GeneralPractitionerSearchResult.jsp?dispDescFirst="+dispDescFirst+"&bool_user_sql="+URLEncoder.encode(bool_user_sql)+"&from="+(start-14)+"&to="+(end-14)+"&fromLink="+URLEncoder.encode("Yes")+"&pract_type="+URLEncoder.encode(pract_type)+"&primary_specialty="+URLEncoder.encode(primary_specialty)+"&pract_id="+URLEncoder.encode(pract_id,"UTF-8")+"&gender="+URLEncoder.encode(gender)+"&job_title="+URLEncoder.encode(job_title)+"&toggle_sql2="+URLEncoder.encode(toggle_sql2)+"&start_ends_contains="+URLEncoder.encode(start_ends_contains)+"&pract_name="+URLEncoder.encode(pract_name,"UTF-8")+"&radiovalue="+radiovalue+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if (endOfRes.equals("1") ) 
	out.println("<A id='nextval' HREF='../../eCA/jsp/GeneralPractitionerSearchResult.jsp?dispDescFirst="+dispDescFirst+"&bool_user_sql="+URLEncoder.encode(bool_user_sql)+"&from="+(start+14)+"&to="+(end+14)+"&fromLink="+URLEncoder.encode("Yes")+"&pract_id="+URLEncoder.encode(pract_id,"UTF-8")+"&pract_type="+URLEncoder.encode(pract_type)+"&primary_specialty="+URLEncoder.encode(primary_specialty)+"&gender="+URLEncoder.encode(gender)+"&job_title="+URLEncoder.encode(job_title)+"&toggle_sql2="+URLEncoder.encode(toggle_sql2)+"&start_ends_contains="+URLEncoder.encode(start_ends_contains)+"&pract_name="+URLEncoder.encode(pract_name,"UTF-8")+"&radiovalue="+radiovalue+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block8Bytes, _wl_block8);
if(isCernerpractitioner){
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(tab_width));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else {
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tab_width));
            _bw.write(_wl_block12Bytes, _wl_block12);
	}
	
			if(dispDescFirst.equals("dispDescFirst")) {
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
} else {
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(plusSymbol_width));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pract_id_width));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pract_full_namewidth));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(isCernerpractitioner){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pract_long_namewidth));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(other_fields_width));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(other_fields_width));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(other_fields_width));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(other_fields_width));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
  
		} 
		//Added for this CRF ML-MMOH-CRF-0862
		if(isCernerpractitioner){
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tab_width));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
		//End this CRF ML-MMOH-CRF-0862
	
	}
count++;

            _bw.write(_wl_block0Bytes, _wl_block0);

	String rowclass = "" ;
	String me="";
		if ( i % 2 == 0 )
			rowclass = "QRYEVEN" ;
		else
			rowclass = "QRYODD" ;

	 pract_name1	=	rs.getString("practitioner_name");

	 gender2		=	rs.getString("gender");
if(gender2.equals("M") || gender2.equalsIgnoreCase("MALE"))
{
	gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
}else if(gender2.equals("F")|| gender2.equalsIgnoreCase("FEMALE"))
{
	gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
}else if(gender2.equals("U")|| gender2.equalsIgnoreCase("UNKNOWN"))
{
	gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
}
   pract_id1	        	=	rs.getString("practitioner_id");
	code							=	rs.getString("practitioner_type");
	desc							=	rs.getString("primary_specialty");
	try{
		job_title_practDetails			=rs.getString("job_title_desc");
	}catch(Exception nocolumn){
		
		nocolumn.printStackTrace();
	}
	
	
// block commented  to reduce un neseccary query for tel/pager/mobile/position. 
// handled internally in  RegPatReferral1.js
//Below line commented for this CRF ML-MMOH-CRF-0862
//out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");	
	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pract_name1));
            _bw.write(_wl_block28Bytes, _wl_block28);

		if(dispDescFirst.equals("dispDescFirst")) {
		me=desc+"::"+code;
		//Below line added for this CRF ML-MMOH-CRF-0862
		out.println("<tr style='background-color:;'><td width='60%' class='"+rowclass+"'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(me)));
            _bw.write(_wl_block30Bytes, _wl_block30);
	out.println(desc+"</a></td><td width='40%' class='"+rowclass+"'>");
		out.println( code+"</td></tr>" );
		}
		//used as of now...
		else
		{
		me=code;		
		//Below line added for this CRF ML-MMOH-CRF-0862
		out.println("<tr style='background-color:;'><td class='"+rowclass+"' width ='"+plusSymbol_width+"' style='"+plussymbol_word_wrap+"' >");
		
		//out.println("<a href=\"javascript:showPractWindow('"+pract_id1+"')\">+</a></td>");
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(pract_id_width));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract_word_wrap_postion));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(pract_id1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tel_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mobile_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pager_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(job_title_practDetails));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_dtls));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(pract_id1));
            _bw.write(_wl_block37Bytes, _wl_block37);

		//Added for this CRF ML-MMOH-CRF-0862
		if(isCernerpractitioner){
		out.println("<td class='"+rowclass+"' width ='"+pract_full_namewidth+"' style='"+pract_full_word_wrap+"' >");
		if(!locale.equals("en")) {
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(pract_id1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tel_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mobile_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pager_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(job_title_practDetails));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_dtls));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
}else
		{ 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(pract_id1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tel_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mobile_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pager_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(job_title_practDetails));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_dtls));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
}
		
		out.println( pract_name1	+"</a></td>" );
		}
		//End this CRF ML-MMOH-CRF-0862
		
		out.println( "<td class='"+rowclass+"' width ='"+pract_long_namewidth+"' style='"+pract_word_wrap+"' >");
				
		if(!locale.equals("en")) {
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(pract_id1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tel_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mobile_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pager_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(job_title_practDetails));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_dtls));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
}else
		{ 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(pract_id1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tel_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mobile_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pager_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(job_title_practDetails));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_dtls));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
}
		//Added for this CRF ML-MMOH-CRF-0862
		if(isCernerpractitioner){
		  //Below line added for this CRF ML-MMOH-CRF-0862	    
		  String long_name=CommonBean.getPractitionerLongName(conn, pract_id1, locale);		
           if(long_name.equals("")) long_name="&nbsp;";
           out.println(long_name +"</a></td>" );		
		}else{	
		   out.println( pract_name1	+"</a></td>" );
		}
		//End this CRF ML-MMOH-CRF-0862		
				
		out.println("<td class='"+rowclass+"' width ='"+other_fields_width+"' style='"+pract_word_wrap_postion+"' >");
		out.println(code+"</td><td  class='"+rowclass+"' width ='"+other_fields_width+"' style='"+pract_word_wrap_postion+"' >");
		out.println( desc+"</td>" );
		out.println( "<td class='"+rowclass+"' width ='"+other_fields_width+"' style='"+pract_word_wrap_postion+"' >"+gender1+"</td>" );
		

		//job_title1=job_title_practDetails;
				

		if(job_title_practDetails==null || job_title_practDetails.equals("null"))
			{
			job_title_practDetails="&nbsp;";
			}
			if(job_title_practDetails!=null && job_title_practDetails.equals("")){
				job_title_practDetails="&nbsp;";
			}
		
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(rowclass));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(other_fields_width));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pract_word_wrap_postion));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(job_title_practDetails));
            _bw.write(_wl_block45Bytes, _wl_block45);

		}
		i++;	  
	 }
	 
	 if(count==0)
	{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));if(parent.frames[0].document.getElementById('radiovalue').value == 'D'){                     if(parent.frames[0].document.getElementById('pract_name'))                   parent.frames[0].document.getElementById('pract_name').readOnly=false; }else if (parent.frames[0].document.getElementById('radiovalue').value == 'C'){if(parent.frames[0].document.getElementById('pract_id'))                   parent.frames[0].document.getElementById('pract_id').readOnly=false; }else {if(parent.frames[0].document.getElementById('pract_name'))                   parent.frames[0].document.getElementById('pract_name').readOnly=false;}                         if(parent.frames[0].document.getElementById('Search'))                                       parent.frames[0].document.getElementById('Search').disabled=false;                                         if(parent.frames[0].document.getElementById('clear'))                                                 parent.frames[0].document.getElementById('clear').disabled=false;	document.location.href='../../eCommon/html/blank.html'</script>");
	
	}
	 if ( count < 14 || (!rs.next()) ) {

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(start));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(srch_click));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(pract_id1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tel_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mobile_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pager_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(job_title_practDetails));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_dtls));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(count));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pract_name1));
            _bw.write(_wl_block50Bytes, _wl_block50);
 
		} else {
            _bw.write(_wl_block51Bytes, _wl_block51);
}
	 
  
            _bw.write(_wl_block52Bytes, _wl_block52);
 
   if (rs != null) rs.close();if (stmt != null) stmt.close();
}catch(Exception e) { 
	e.printStackTrace();
}
finally
{
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
		if (pstmt_practDetail != null) pstmt_practDetail.close();
		if (rs_practDetail != null) rs_practDetail.close();
		if (stmt != null) stmt.close();
} 


            _bw.write(_wl_block53Bytes, _wl_block53);
if(isCernerpractitioner){
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(searchtext));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(isCernerpractitioner));
            _bw.write(_wl_block57Bytes, _wl_block57);

}catch(Exception e) { 
	
e.printStackTrace();
}
	finally
	{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}	

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionerid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionername.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longname.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionertype.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primaryspeciality.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
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
}
