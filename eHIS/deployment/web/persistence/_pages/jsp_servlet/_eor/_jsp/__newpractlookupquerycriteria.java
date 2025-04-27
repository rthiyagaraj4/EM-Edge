package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.servlet.http.*;
import eCommon.XSSRequestWrapper;

public final class __newpractlookupquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewPractLookupQueryCriteria.jsp", 1709119744000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n\t\t<script>\n\n\t\t\tvar radioval=\"D\";\n\t\t\n/******************************************************/\t\t\t\nfunction closew()\n{\n\tparent.window.close();\n}\n\n/******************************************************/\nfunction storeVal(currad)\n{\nradioval=currad.value\n\tparent.frames[0].document.getElementById(\"radiovalue\").value=radioval;\n }\n/**********************************************/\nfunction toggle(){\n\t\nif(radioval == \'C\')\n{\n//alert(document.forms[0].pract_id.disabled);\ndocument.forms[0].pract_id.disabled = false;\n//alert(document.getElementById(\"pract_id\").readonly);\nparent.frames[0].document.getElementById(\"pract_id\").readOnly=false;\ndocument.forms[0].pract_id.value = document.forms[0].pract_name.value;\ndocument.forms[0].pract_name.disabled=true;\ndocument.forms[0].pract_name.value = \'\';\n}\nelse if(radioval == \'D\')\n{\ndocument.forms[0].pract_name.disabled=false;\nparent.frames[0].document.getElementById(\"pract_name\").readOnly=false;\ndocument.forms[0].pract_name.value = document.forms[0].pract_id.value;\ndocument.forms[0].pract_id.disabled=true;\ndocument.forms[0].pract_id.value = \'\';\n}\n\n}\n/***************************************************/\n function valtext(boolSql2)\n {\n\n//alert(\"in valtext:-\"+boolSql2);\n\nvar pract_type\t\t\t\t= document.getElementById(\"pract_type\").value;\nvar primary_specialty\t\t= document.getElementById(\"primary_specialty\").value;\nvar pract_id\t\t\t\t= document.getElementById(\"pract_id\").value;\nvar pract_name\t\t\t\t= document.getElementById(\"pract_name\").value;\nvar start_ends_contains\t\t= document.getElementById(\"start_ends_contains\").value;\nvar job_title\t\t\t\t= document.getElementById(\"job_title\").value;\nvar gender\t\t\t\t\t= document.getElementById(\"gender\").value;\nvar temp_practID\t\t\t= document.getElementById(\"temp_practID\").value;\nvar pract_retval\t\t\t= document.getElementById(\"pract_retval\").value;\n\n\n//alert(\"in valtext prim spec:-\"+document.getElementById(\"primary_specialty\").value);\nif(boolSql2){\ndocument.getElementById(\"user_sql1\").value=document.getElementById(\"user_sql2\").value\ndocument.getElementById(\"toggle_sql2\").value=\"Yes\";\n//alert(\"in valtext sql1:-\"+document.getElementById(\"user_sql1\").value)\n}\n//alert(\"in result call\"+sql);\ndocument.forms[0].action = \'../../eOR/jsp/NewPractLookupQueryResult.jsp?&pract_type=\'+pract_type+\'&primary_specialty=\'+primary_specialty+\'&pract_id=\'+escape(pract_id)+\'&pract_name=\'+escape(pract_name)+\'&start_ends_contains=\'+start_ends_contains+\'&job_title=\'+job_title+\'&gender=\'+gender+\"&temp_practID=\"+temp_practID+\"&pract_retval=\"+pract_retval;\n//parent.frames[1].location.href=\'../../eAM/jsp/GeneralPractitionerSearchResult.jsp?&pract_type=\'+pract_type+\'&primary_specialty=\'+primary_specialty+\'&pract_id=\'+escape(pract_id)+\'&pract_name=\'+escape(pract_name)+\'&start_ends_contains=\'+start_ends_contains+\'&job_title=\'+job_title+\'&gender=\'+gender;\ndocument.forms[0].method=\"post\";\ndocument.forms[0].target=\"result_frame\";\ndocument.forms[0].submit();\n\t\n//if(parent.frames[0].document.getElementById(\"pract_type\"))\n//parent.frames[0].document.getElementById(\"pract_type\").disabled=true;                 \n\n//if(parent.frames[0].document.getElementById(\"primary_specialty\"))\n//parent.frames[0].document.getElementById(\"primary_specialty\").disabled=true;     \n\nif(parent.frames[0].document.getElementById(\"pract_id\"))\nparent.frames[0].document.getElementById(\"pract_id\").readOnly=true;                     \n\nif(parent.frames[0].document.getElementById(\"pract_name\"))\nparent.frames[0].document.getElementById(\"pract_name\").readOnly=true;               \n\n//if(parent.frames[0].document.getElementById(\"job_title\"))\n//parent.frames[0].document.getElementById(\"job_title\").disabled=true;                     \n\n//if(parent.frames[0].document.getElementById(\"gender\"))\n//parent.frames[0].document.getElementById(\"gender\").disabled=true;\n\nif(parent.frames[0].document.getElementById(\"Search\"))\nparent.frames[0].document.getElementById(\"Search\").disabled=true;\n\t\nif(parent.frames[0].document.getElementById(\"clear\"))\nparent.frames[0].document.getElementById(\"clear\").disabled=true;\t\n\t}\n\n/*******************************************************************/\nfunction on_Clear(){\n\n\nif(\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"==\"\")\ndocument.getElementById(\"pract_type\").options(0).selected=true;\n\nif(\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"==\"\")\ndocument.getElementById(\"primary_specialty\").options(0).selected=true;\n\n\ndocument.getElementById(\"pract_id\").value=\"\";\ndocument.getElementById(\"pract_name\").value=\"\";\ndocument.getElementById(\"start_ends_contains\").options(0).selected=true;\ndocument.getElementById(\"start_ends_contains\").disabled=true;\n\nif(\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"==\"\")\ndocument.getElementById(\"job_title\").options(0).selected=true;\n\nif(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"==\"\")\ndocument.getElementById(\"gender\").options(0).selected=true;\n\n// clearing the result page\nparent.frames[1].location.href =\'../../eCommon/html/blank.html\';\n}\n/*********************************************/\nfunction enableSEC()\n{\n\ndocument.getElementById(\"start_ends_contains\").disabled=false;\n\n}\nfunction callOnLoad()\n{\n\tvar arraySql=parent.window.dialogArguments;\n\t\n//\tdocument.forms[0].user_sql1.value=arraySql[0];\n//\tdocument.forms[0].user_sql2.value=arraySql[1];\n\t\n\tdocument.forms[0].user_sql1.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tdocument.forms[0].user_sql2.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\n\tvar i=0;\t\n\tfor(i=0; i<document.getElementById(\"job_title\").options.length;i++)\n\t{\n\t\t\tif(document.getElementById(\"job_title\").options[i].value==\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\")\n\t\t\tdocument.getElementById(\"job_title\").options[i].selected=true;\n\t}\n\t\n\tfor(i=0; i<document.getElementById(\"gender\").options.length;i++)\n\t{\n\t\t\tif(document.getElementById(\"gender\").options[i].value==\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\")\n\t\t\tdocument.getElementById(\"gender\").options[i].selected=true;\n\t}\n\tvaltext(false);\n}\n</script>\n\n</head>\n<body onload=\"callOnLoad()\">\n<form name=\'general_search_criteria\' id=\'general_search_criteria\' >\n<table align=\'right\'  border=\"0\" width=\'100% \'cellspacing=\'0\' cellpadding=\'0\'>\n <tr width=\"100\">\n        <td align=\'right\' class=\'label\'>Search By</td>\n        <td colspan=2  class=\"label\">\n        <input type=\"radio\" name=\"search_by\" id=\"search_by\" class=\"label\" value=\"D\"  checked  onclick=\"storeVal(this);toggle();\">Description\n        <input type=\"radio\" name=\"search_by\" id=\"search_by\" class=\"label\" value=\"C\" onclick=\"storeVal(this);toggle();\">Code\n        </td>\n        <td>&nbsp<select name=\"start_ends_contains\" id=\"start_ends_contains\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t\t\t\t\t<option value=\"S\">Starts With</option>\n\t\t\t\t\t<option value=\"E\">Ends With</option>\n\t\t\t\t\t<option value=\"C\">Contains</option>\n\t\t\t\t</select></td>\n </tr>\n<tr width=\'100\'>\n\t\t<td colspan=1  class=\"label\" nowrap align=\'right\'>Practitioner ID</td>\n\t\t<td align=\'left\'>&nbsp;<input type=\'text\'  name=\'pract_id\' id=\'pract_id\'maxlength=\'15\' onkeypress=\'enableSEC();\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="></td>\n\t\t<td colspan=1  class=\"label\" nowrap align=\'right\'>Practitioner type</td>\n\t\t<td align=\'left\'>&nbsp;<select name=\"pract_type\" id=\"pract_type\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="><option value=\"\">---------- Select ----------</option>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<option value= \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' selected> ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' > ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\t\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</select>\n\t\t</td>\n\t\t\n\t\t<!-- <td colspan=1  class=\"label\" nowrap align=\'right\'>Practitioner Name</td>\n\t\t<td align=\'left\'>&nbsp;<input type=\'text\' maxlength=\'30\' size=\'30\'name=\'pract_name\' onkeypress=\'enableSEC();\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t</td> -->\n\t</tr>\n\t\t<tr width=\'100\'>\n\t\t\n\t\t<td colspan=1  class=\"label\" nowrap align=\'right\'>Practitioner Name</td>\n\t\t<td align=\'left\'>&nbsp;<input type=\'text\' maxlength=\'30\' size=\'30\'name=\'pract_name\' onkeypress=\'enableSEC();\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t</td>\n\t\t<td colspan=1  class=\"label\" nowrap align=\'right\'>Specialty</td>\n\t\t<td align=\'left\'>&nbsp;<select name=\"primary_specialty\" id=\"primary_specialty\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">\n\t\t\t\t<option value=\"\">------------ Select -----------</option>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t\t\t\t\n\t\t\t\t</select>\n\t\t</td>\n\t</tr>\n\t<tr width=\'100\'>\n\t\t<td colspan=1  class=\"label\" nowrap align=\'right\'>Gender</td>\n\t\t<td align=\'left\'>&nbsp;<select name=\'gender\' id=\'gender\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">\n\t\t\t\t<option value=\"\">------- Select ------</option>\n\t\t\t\t<option value=\"M\">Male</option>\n\t\t\t\t<option value=\"F\">Female</option>\n\t\t\t\t<option value=\"U\">Unknown</option>\n\t\t\t\t</select>\n\t\t</td>\n\t\t<td colspan=1  class=\"label\" nowrap align=\'right\'>Position</td>\n\t\t<td align=\'left\'>&nbsp;<select name=\'job_title\' id=\'job_title\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n\t\t<option value=\"\">------- Select ------</option>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<option value= \'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t</select>\n\t\t</td>\n\t\t\n\t</tr>\n\t<tr>\n\t\t<td colspan=3>&nbsp;</td>\n\t\t<td align=\'right\'><input type=\"button\" align=\"left\" name=\"Search\" id=\"Search\" value=\"Search\" onClick=\"valtext(true); \" class=\'button\' >&nbsp;&nbsp;\n\t\t<input type=\"button\"  align=\"left\" name=\"clear\" id=\"clear\" value=\"Clear\" class=\'button\'  onClick=\"on_Clear(); \">\n\t\t</td>\n\t</tr>\n</table>\n<BR>\n<BR>\n\t<input type=\"hidden\"  name=user_sql1 value=\"\" >\n\t<input type=\"hidden\"  name=user_sql2 value=\"\" >\n<input type=\"hidden\"  name=toggle_sql2 value=\"\" >\n\t<input type=\"hidden\" name=radiovalue value=\"\">\t\n\t<input type=\"hidden\" name=temp_practID value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\t\n\t<input type=\"hidden\" name=pract_retval value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\t\n\t\t</form>\n\t\n</body>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<script>\n\t\t\n\n\t\t//document.general_search_criteria.Search.click()\n\t\n\n\t\t</script>\n\t\t</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

/*********************getdata() generalized function to fetch values from Database*******************/

public ArrayList getData(String sql,String[] whereClause,JspWriter out,Connection con) throws Exception
{

   ArrayList arrL_of_HashMap   		= new ArrayList() ;
//   Connection con				= null ;
   PreparedStatement pstmt         		= null ;
   ResultSet resultSet             			= null ;
   ResultSetMetaData resultSetMetaData 	= null;
   //ArrayList deBug   			= new ArrayList() ;

 try {

  // con 	= ConnectionManager.getConnection(request);
   pstmt 	= con.prepareStatement(sql) ;
		 
	if (whereClause!=null)
		for (int index=0; index<whereClause.length ;index++ )
			pstmt.setString( index+1, whereClause[index]);

    resultSet = pstmt.executeQuery() ;
	if ( resultSet != null )
	 {
		resultSetMetaData   =   resultSet.getMetaData();
		while ( resultSet.next() )
		{
	    HashMap hmRecord  =  new HashMap();
		    for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
		    {
		        String column_Val=resultSet.getString(resultSetMetaData.getColumnName(i));


		        if(column_Val==null) column_Val="";	
		        hmRecord.put(resultSetMetaData.getColumnName(i),column_Val);
	   }	

		  arrL_of_HashMap.add(hmRecord) ;

		 
					
 		}
}

       }catch ( Exception e )
        {
            	System.err.println( "Error loading values from database" ) ;
            	e.printStackTrace() ;
				//out.println(e.toString());//COMMON-ICN-0181     
        }
        finally
        {
            try {
               		if(pstmt!=null)	pstmt.close();
		if(resultSet!=null)	resultSet.close();
	//ConnectionManager.returnConnection(con,request);
              	}
                catch(Exception es) { }
        }
	return arrL_of_HashMap;

}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	///////////
	/////////////
	//String queryString=request.getQueryString();
	Connection con = ConnectionManager.getConnection(request);
	ArrayList  Arr_Of_HashMap=new ArrayList();
	HashMap  general_HashMap=new HashMap();
	String specialty_disabled="";
	String pract_type_disabled="";
	String job_title_disabled="";
	String gender_disabled="";
	String start_end_cont_disabled="";
	 
String pract_id_disabled="disabled";

String practname=request.getParameter("practname");
String temp_practID	= request.getParameter( "temp_practID" )==null?"":request.getParameter( "temp_practID" ) ;
String pract_retval	= request.getParameter( "pract_retval" )==null?"":request.getParameter( "pract_retval" ) ;

if(practname==null) practname="";

if(!practname.equals("")){
	start_end_cont_disabled="";
	}

//String sql	=request.getParameter("sql");         
//if(sql==null) sql="";

String sql       = (String) session.getValue("sql")==null?"":(String) session.getValue("sql");

String sqlSec       = (String) session.getValue("sqlSec");

//String sqlSec	=request.getParameter("sqlSec");         
//if(sqlSec==null) sqlSec="";

//out.println("<script> alert(\" in criteria sql:---"+sql+"\"); </script>");
//out.println("<script> alert(\" in criteria sqlSec:---"+sqlSec+"\"); </script>");
//out.println("<script> alert(\" in criteria practname:---"+practname+"\"); </script>");
/*
*these 4 variables are passed in the query string ..they are specially included in the where criteria of the    *user passed sql
*/
String user_specialty_code="";
String user_pract_type="";
String user_job_title= "";
String user_gender="";
user_pract_type=request.getParameter("practitioner_type");  
// ********this block will get the values only if the user sql is passed
if(!sql.equals(""))
{
	user_specialty_code=request.getParameter("specialty_code");         
	if(user_specialty_code==null) user_specialty_code="";
	specialty_disabled=user_specialty_code.equals("")?"":"disabled";

	user_pract_type=request.getParameter("practitioner_type");         
	if(user_pract_type==null) user_pract_type="";
	pract_type_disabled=user_pract_type.equals("")?"":"disabled";

//out.println("<script> alert(\" in criteria user_pract_type:---"+user_pract_type+"\"); </script>");

	user_gender=request.getParameter("gender");         
	if(user_gender==null) user_gender="";
	gender_disabled=user_gender.equals("")?"":"disabled";

	//out.println("<script>alert(\"user_gender:-----"+gender_disabled+"\")</script>");

	user_job_title=request.getParameter("job_title");         
	if(user_job_title==null) user_job_title="";
	job_title_disabled=user_job_title.equals("")?"":"disabled";

}
// ********block ends

//out.println("<script>alert(\"specialty_code:-----"+specialty_code+"\")</script>");

try
{

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(user_pract_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(user_specialty_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(user_job_title));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(user_gender));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sqlSec));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(user_job_title));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(user_gender));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start_end_cont_disabled));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pract_id_disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pract_type_disabled));
            _bw.write(_wl_block16Bytes, _wl_block16);

String Sql="SELECT pract_type,desc_sysdef FROM am_pract_type WHERE eff_status='E' ORDER BY 2";
Arr_Of_HashMap= getData( Sql, null, out,con);


for(int i=0; i<Arr_Of_HashMap.size();i++)
	{
	 general_HashMap=(HashMap)Arr_Of_HashMap.get(i);
if(general_HashMap.get("PRACT_TYPE").equals(user_pract_type)) {

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(general_HashMap.get("PRACT_TYPE")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(general_HashMap.get("DESC_SYSDEF")));
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(general_HashMap.get("PRACT_TYPE")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(general_HashMap.get("DESC_SYSDEF")));
            _bw.write(_wl_block21Bytes, _wl_block21);

}
	}

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(specialty_disabled));
            _bw.write(_wl_block25Bytes, _wl_block25);

String Sql1="select speciality_code,short_desc from am_speciality WHERE eff_status='E'  order by 2";
	Arr_Of_HashMap= getData( Sql1, null,out,con);
	
	general_HashMap.clear();
	
	for(int i=0; i<Arr_Of_HashMap.size();i++)
	{
	 general_HashMap=(HashMap)Arr_Of_HashMap.get(i);
if(general_HashMap.get("SPECIALITY_CODE").equals(user_specialty_code)) {

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(general_HashMap.get("SPECIALITY_CODE")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(general_HashMap.get("SHORT_DESC")));
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(general_HashMap.get("SPECIALITY_CODE")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(general_HashMap.get("SHORT_DESC")));
            _bw.write(_wl_block26Bytes, _wl_block26);

		}
	}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(gender_disabled));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(job_title_disabled));
            _bw.write(_wl_block29Bytes, _wl_block29);

		String	Sql2="select position_code,position_desc from am_position where role_type='P' and eff_status='E'  order by 2";


			Arr_Of_HashMap= getData( Sql2, null,out,con);
			general_HashMap.clear();
	
			for(int i=0; i<Arr_Of_HashMap.size();i++){
				general_HashMap=(HashMap)Arr_Of_HashMap.get(i);
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(general_HashMap.get("POSITION_CODE")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(general_HashMap.get("POSITION_DESC")));
            _bw.write(_wl_block31Bytes, _wl_block31);
				
			}
		
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(temp_practID));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pract_retval));
            _bw.write(_wl_block34Bytes, _wl_block34);

}catch(Exception e)
{
		
	//	out.println(e.toString);

}
	finally
	{
		if (con != null) 
			ConnectionManager.returnConnection(con,request);
	}		
		
            _bw.write(_wl_block35Bytes, _wl_block35);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
