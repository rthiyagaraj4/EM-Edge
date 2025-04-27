package jsp_servlet._eip._jsp;

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

public final class __addmodifynursunitspeciality extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AddModifyNursUnitSpeciality.jsp", 1709117699098L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../js/NursUnitSpeciality.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\n/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\nFunction Name :\tRemSelectAll()\nPurpose : To Uncheck the Select All CheckBox when atleast one of the CheckBox is Un Checked..\n\t\t  and also to assign value Y/N based on check option...\nremoveCode - used to remove the record from the recordSet bean..when chk box is unchecked..\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/\nfunction RemSelectAll(obj, i)\n{\n\t\n\tdocument.forms[0].chkAll.checked = false;\n\n\tif(obj.checked == false)\n\t\teval(\"document.forms[0].removeCode\"+i).value = \"Y\";\n\n\telse\n\t\teval(\"document.forms[0].removeCode\"+i).value = \"N\";\n\n}\n\n\n</script>\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =");chekSelectAll()\' class=\'CONTENT\' >\n<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eIP/jsp/AddModifyNursUnitSpeciality.jsp\' method=\'post\' >\n<table  width=\'90%\' border=0 align=\'center\'>\n\t<tr>\n\t\t<td align=\'right\' class=\'NONURGENT\'>\n\t\t\t<input type=hidden name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t<input type=hidden name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' >\n\t\t\t<input type=hidden name=\'maxRecord\' id=\'maxRecord\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\n\t\t\t<input type=hidden name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t\t\t<input type=hidden name=\'allValues\' id=\'allValues\' value=\'\'>\n\t\t\t<input type=\"hidden\" name=\"search_by\" id=\"search_by\" value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\t\t\t<input type=\"hidden\" name=\"search_txt\" id=\"search_txt\" value=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n\t\t\t<input type=\'hidden\' name=\'selectChk\' id=\'selectChk\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t<input type=\'hidden\' name=\'recordCount\' id=\'recordCount\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t<input type=\'hidden\' name=\'chkcount1\' id=\'chkcount1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'selctAllCHk\' id=\'selctAllCHk\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\n\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\t</td>\n\t</tr>\n</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t<th width=\'60%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</th>\n\t\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" <br><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" onClick=\'selectAll(this,";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =");\'><input type=\'hidden\' name=\'removeCodei\' id=\'removeCodei\' value=\"\"><input type=\'hidden\' name=\'spclCode1i\' id=\'spclCode1i\' value=\"\"></th>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" name=\'chk";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onclick=\"RemSelectAll(this, ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =");\" value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'><input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'removeCode";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' value=\"\"><input type=\'hidden\' name=\'spclCode";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'spclCode";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"></td>\n\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\"nextval\").innerHTML = \" \";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

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
            webbeans.eCommon.RecordSet NursUnitSpeciality= null;synchronized(session){
                NursUnitSpeciality=(webbeans.eCommon.RecordSet)pageContext.getAttribute("NursUnitSpeciality",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(NursUnitSpeciality==null){
                    NursUnitSpeciality=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("NursUnitSpeciality",NursUnitSpeciality,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
String selctAllCHk=checkForNull(request.getParameter("selctAllCHk"));
	String _chkAll="";
	if(selctAllCHk.equals("Y"))
	_chkAll="checked";
	else
		_chkAll="";

String selectChkecked="";
		String selectChk=checkForNull(request.getParameter("selectChk"));
			if(selectChk.equals("Y"))
				selectChkecked="checked";
				else
				selectChkecked="";

				
	request.setCharacterEncoding("UTF-8");
	String req_start	="", req_end	="";
	String checkedOnes  ="";
	//String checkedOnes1  ="";
	String from	= request.getParameter("from") ;
	String to	= request.getParameter("to") ;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
	
	

	String removeCode = "";
	//String removeCode1 = "";

	req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
	String effStatus		="";
	Connection con			= null;
	PreparedStatement pstmt	= null;
	Statement stmt3		= null;
	ResultSet rstlRs3	= null;
	Statement stmt		= null;
	ResultSet rs		= null;

	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";

	if(from != null && to != null)
	{
		int j=0;
		for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		{
			if(request.getParameter("chk"+(i)) != null)
			{
				checkedOnes = request.getParameter("chk"+(i));
				//out.println("checkedOnes==="+checkedOnes);
				if(!(NursUnitSpeciality.containsObject(checkedOnes)))
					NursUnitSpeciality.putObject(checkedOnes);
				j++;
			}

			removeCode = checkForNull(request.getParameter("removeCode"+(i)));
			if(removeCode.equals("Y"))
			{
				String spclCode = request.getParameter("spclCode"+(i));
				if((NursUnitSpeciality.containsObject(spclCode)))
				{
					int removeCodeIndex = NursUnitSpeciality.indexOfObject(spclCode);
						NursUnitSpeciality.removeObject(removeCodeIndex);
				}
			}

		}
		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
	i = 1 ;

	try{
			
	con = ConnectionManager.getConnection(request);

	String facility_id			= (String)session.getValue("facility_id");
	String nursing_unit_code	= request.getParameter("nursing_unit_code");
	String flagSelect			= request.getParameter("fromSelect");

	String search_by		= checkForNull(request.getParameter("search_by"));
	String search_txt		= checkForNull(request.getParameter("search_txt"));
	String search_criteria	=  "";
	String search_criteria2	=  "";

	if(search_by.equals("ID")) search_by = "01";
	if(search_by.equals("DESC")) search_by = "02";
	if(search_by.equals("")||(search_by == null)) search_by = "00";

	if(search_by != null && !search_by.equals("00"))
	{
		if(search_txt != null && !search_txt.equals(""))
		{
			if(search_by.equals("01"))
			{
				search_criteria  = " and upper(speciality_code) like UPPER('"+search_txt+"%') ";
				search_criteria2 = " and upper(specialty_code) like UPPER('"+search_txt+"%') ";
			}
			else if(search_by.equals("02"))
			{	
				search_criteria  = " and upper(short_desc) like UPPER('"+search_txt+"%')  ";
				search_criteria2 = " and upper(specialty_short_desc) like UPPER('"+search_txt+"%') ";
			}
		}
	}

	if(flagSelect !=null)
	{
		NursUnitSpeciality.clearAll();
		StringBuffer sqlinsVals = new StringBuffer();
		sqlinsVals.append(" select SPECIALTY_CODE from IP_NURS_UNIT_FOR_SPECIALTY_VW   where NURSING_UNIT_CODE='"+nursing_unit_code+"' and FACILITY_ID='"+facility_id+"'   ");
		sqlinsVals.append(search_criteria2);

		stmt3=con.createStatement();
		rstlRs3 = stmt3.executeQuery(sqlinsVals.toString());
		if(rstlRs3 !=null)
		{
			 while(rstlRs3.next())
			 {
				NursUnitSpeciality.putObject(rstlRs3.getString(1));
			 }
		}
		if(rstlRs3 != null) rstlRs3.close();
		if(stmt3 != null) stmt3.close();
	}
	int recordCount			=	0;
    recordCount =NursUnitSpeciality.getSize();
	//out.println("recordCount=="+recordCount);

	int cnt = 0;
	int nextOfRes = 1;
	//static int ch;

	String classValue="";
	String chkAttribute="";
	StringBuffer sql = new StringBuffer();
	
	sql.append(" SELECT A.specialty_code, B.short_desc short_desc, 'Y' ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SPECIALTY A, AM_SPECIALITY B ");
	sql.append(" WHERE A.facility_id='"+facility_id+"' ");
	sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
	sql.append(" AND A.specialty_code=b.speciality_code AND B.eff_status='E' ");
	sql.append(search_criteria);
	sql.append(" UNION ");
	sql.append("SELECT speciality_code, short_desc short_desc, 'N' ");
	sql.append(" FROM AM_SPECIALITY ");
	sql.append(" WHERE speciality_code NOT IN ( SELECT specialty_code ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SPECIALTY ");
	sql.append(" WHERE facility_id='"+facility_id+"' ");
	sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ) ");
	sql.append(" AND eff_status='E' ");
	sql.append(search_criteria);
	sql.append("  ORDER BY 2 ");

	try
	{
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=stmt.executeQuery(sql.toString());
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();
		//out.println("maxRecord=="+maxRecord);
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			return;
		}
	}catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}

	
	//if(rs != null)		rs.close();
	//if(stmt != null)	stmt.close(); 

	
	//out.println(sql.toString());
	//stmt=con.createStatement();
	//rs=stmt.executeQuery(sql.toString());

	if(start != 0)
	{
		for(int j=1; j<=start; i++,j++)
		{
			rs.next() ;
		}
	}
	while( i<=end && rs.next() )
	{ 
		if( cnt == 0 )
		{



            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(start));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(search_txt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(selectChk));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(recordCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(_chkAll));
            _bw.write(_wl_block23Bytes, _wl_block23);
	if(!(start <= 1)) 
			{	
				out.println("<a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
				
            _bw.write(_wl_block24Bytes, _wl_block24);
	}
			
			if( nextOfRes == 1 )
			{	
				out.println("<a id='nextval' href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
				
            _bw.write(_wl_block25Bytes, _wl_block25);
	}	
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(_chkAll));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block30Bytes, _wl_block30);
	 
		}
			/*if(start != 0)
			{
				for(int j=1; j<=start; i++,j++)
				{
					rs.next() ;
				}
			}
			while(rs.next() && i<=end)
			{ */
				String speciality_code=rs.getString(1);
				
				String short_desc=rs.getString("short_desc");
				//recordCount =NursUnitSpeciality.getSize();
				//out.println("recordCount=="+recordCount);

				if(NursUnitSpeciality.containsObject(speciality_code))  
					chkAttribute = "CHECKED";
				else
					chkAttribute="";

				int recordIndex = NursUnitSpeciality.indexOfObject(speciality_code);
				if(recordIndex!=-1)
				if(chkAttribute.equals("CHECKED"))    									    	NursUnitSpeciality.removeObject(recordIndex);


			
			
					if( i%2 == 0)  
						classValue="QRYEVEN";
					else
						classValue="QRYODD";
					
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
		i++;
				cnt++;
			}
			
			if( cnt == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				return;
			}	

			if( !rs.next() && cnt!=0 )
			{
				nextOfRes=0;
			
            _bw.write(_wl_block44Bytes, _wl_block44);

			}

			if(rs != null)		rs.close();
			if(stmt != null)	stmt.close(); 
			if(pstmt !=null)	pstmt = null; 
		}catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
			session.setAttribute("NursUnitSpeciality", NursUnitSpeciality);
		}	

            _bw.write(_wl_block45Bytes, _wl_block45);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
