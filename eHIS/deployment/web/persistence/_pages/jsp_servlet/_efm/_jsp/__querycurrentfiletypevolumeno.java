package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import java.util.StringTokenizer;
import java.util.*;
import com.ehis.util.*;

public final class __querycurrentfiletypevolumeno extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryCurrentFileTypeVolumeNo.jsp", 1724410484027L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\" ></script>\n<script src=\'../../eFM/js/QueryFMCurrentFileStatus.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<body onMouseDown = \"CodeArrest();\" onKeyDown = \'lockKey();\'> \n\t\t<form name=\'QueryFileTypeVolume\' id=\'QueryFileTypeVolume\' action=\'\' method=\'POST\'>\n\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table width=\"50%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" align=\"CENTER\" id=\'tb1\'>\n\t\t\t\t<tr>\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<th width=\"30%\" class=\'columnheader\' style=\"background:#224771\" id=\"th2\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </th>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<th width=\"10%\" class=\'columnheader\' style=\"background:#224771\" id=\"th2\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<th width=\"10%\" class=\'columnheader\' style=\"background:#224771\" id=\"th1\" nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t<th width=\"10%\" class=\'columnheader\' style=\"background:#224771\" id=\"th3\" nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<tr>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\t\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n           <!--Below line modified for this CRF HSA-CRF-0306-->\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" align=\"CENTER\" style=\"cursor:pointer;color:blue\" onClick=\"if(document.getElementById(\'inactive_vols";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\').options[0]!=null){document.forms[0].inactive_vols";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =".options[0].selected=true}; javascript:searchResult(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\', \'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');changeRowColor(this,2); changeBackgroundFM();\" name=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" align=\'center\' width=\'7%\'><select name=\'inactive_vols";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'inactive_vols";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onchange=\"javascript:searchResult(this.value, \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\');changeRowColor1(2); changeBackgroundFM();\"><option value=\'\'>------- ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" -------</option>\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</select>\n\t\t\t</td> \n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\t\tparent.volumeFrame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.searchResultFrame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<input type=\"Hidden\" name=\"file_no\" id=\"file_no\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t<input type=\"Hidden\" name=\"file_type\" id=\"file_type\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t<input type=\"Hidden\" name=\"volume_no\" id=\"volume_no\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<input type=\"Hidden\" name=\"countt\" id=\"countt\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t</table>\t\t\n\t\t</form>\n\t\t<script>parent.searchResultFrame.location.href=\'../../eCommon/html/blank.html\';</script>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n</html>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );


public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("")) ) ? defaultValue : inputString);
}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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

request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String facility_id				= (String) session.getValue("facility_id");
	
	Connection connection			=	null;
	PreparedStatement preStatement	=	null;
	PreparedStatement pstmt	=	null;
	PreparedStatement pstmt1	=	null;
	ResultSet	resultSet			=	null;
	ResultSet	rset			=	null;
   ResultSet	rset1			=	null;
	String patient_id				=	"";
	String file_type_appl_yn		=	"N";
	StringBuffer sqlString				=	new StringBuffer();
     String file_no					=	"";
	String file_type				=	"";
	String volume_no				=	"";
	String dflt_incomplete_fs_locn_code		=	"";
	String class_value				=	"QRYEVEN";
	String file_type_desc="";
	String fileno="";
	String volumeno="";
	String flag="false";
	String volume_status="";
	String faci_id="";
	int countt=0;
	//String volume_status="";
	int count						=	1;
	int cnt							=	0;
	Hashtable		htRecord	=	null;
	try
	{
		 htRecord			=	new Hashtable();
		patient_id			=	checkForNull(request.getParameter("patient_id"));
		file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"), "N");
		file_no				=	checkForNull(request.getParameter("file_no"));

		file_type			=	checkForNull(request.getParameter("file_type"));
		volume_no			=	checkForNull(request.getParameter("volume_no"));
		dflt_incomplete_fs_locn_code =	checkForNull(request.getParameter("dflt_incomplete_fs_locn_code"));

		String incomp_chk = checkForNull(request.getParameter("incomp_chk"));
		String lost_chk = checkForNull(request.getParameter("lost_chk"));
		String inact_chk = checkForNull(request.getParameter("inact_chk"));
		connection			=	ConnectionManager.getConnection(request);
		String dflt_valnot = "";


		if(! dflt_incomplete_fs_locn_code.equals(""))
		{
		dflt_valnot = "and curr_fs_locn_code != '"+dflt_incomplete_fs_locn_code+"'";
		}
		//sqlString.append(" SELECT distinct a.file_no, a.file_type_code, b.short_desc file_type_desc, a.volume_no, a.volume_status FROM FM_CURR_LOCN a, mr_file_type b WHERE a.patient_id = ? and a.facility_id = b.facility_id(+) and a.file_type_code = b.file_type_code(+)  and volume_status='A'  ");
		
		//sqlString.append(" SELECT  a.file_no  , a.file_type_code  , MR_GET_DESC.MR_FILE_TYPE(a.facility_id, a.file_type_code, '"+localeName+"', 2) file_type_desc  , a.volume_no  , a.volume_status  FROM  FM_CURR_LOCN a WHERE a.patient_id = ?   AND volume_status='A'  ");

		sqlString.append(" SELECT  a.file_no  , a.file_type_code  , MR_GET_DESC.MR_FILE_TYPE(a.facility_id, a.file_type_code, '"+localeName+"', 2) file_type_desc  ,MAX(a.volume_no) volume_no, a.volume_status,facility_id  FROM  FM_CURR_LOCN a WHERE a.patient_id = ?  AND volume_status NOT IN('I') ");

		if(lost_chk.equals("N"))
		{
			sqlString.append(" AND volume_status='A' ");
		}

		if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString.append(dflt_valnot +" and curr_file_status not in ('A','L')  ");
		else if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString.append(dflt_valnot +" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString.append(dflt_valnot +" and curr_file_status not in ('A')");
		else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("Y"))
			sqlString.append(dflt_valnot);
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString.append(" and curr_file_status not in ('A','L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString.append(" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString.append(" and curr_file_status not in ('A') ");


sqlString.append("  GROUP BY a.facility_id,a.file_no,a.file_type_code,a.volume_status order by volume_no desc ");




		
		preStatement	=	connection.prepareStatement(sqlString.toString());

		preStatement.setString(1, patient_id);
		resultSet		=	preStatement.executeQuery();

	//	sqlString1.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = ? and volume_status IN('I','L') and file_no=?");
		
		/*if(file_type_appl_yn.equals("Y")) {
			sqlString1.append("and file_type_code = ? ");
		}commented by sathish for IN018405 on Friday, January 22, 2010*/ 
/*
		if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('A','L') ");
		else if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('A')");
			else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("Y"))
			sqlString1.append(dflt_valnot);
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString1.append(" and curr_file_status not in ('A','L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString1.append(" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString1.append(" and curr_file_status not in ('A') ");

			pstmt	=	connection.prepareStatement(sqlString1.toString()); */

		String file_typecode	= "";
		String code				= "";		
		
            _bw.write(_wl_block8Bytes, _wl_block8);
 if(resultSet != null) 
		{
			
            _bw.write(_wl_block9Bytes, _wl_block9);
 if(file_type_appl_yn.equals("N")) { 
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 } else if(file_type_appl_yn.equals("Y")) { 
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
 } 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			while(resultSet.next())
			{
			
				
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
			
			
			      file_type_desc=  checkForNull(resultSet.getString("file_type_desc"), "&nbsp;");
			      fileno         =checkForNull(resultSet.getString("file_no"), "&nbsp;");
			      volumeno  = checkForNull(resultSet.getString("volume_no"));
			      file_typecode = checkForNull(resultSet.getString("file_type_code")); 	
			      faci_id     = checkForNull(resultSet.getString("facility_id")); //Added by S.Sathish for IN021074 on Friday, April 30, 2010
				  
				if(file_typecode==null) file_typecode="";
				if (file_type_appl_yn.equals("Y"))
				{
				  String file_typecodecomp	=	(String)	htRecord.get(file_typecode);				  

				 if(file_typecodecomp==null || file_typecodecomp.equals("null") ) 
					{
					file_typecodecomp="";
						}
								
				file_typecode=faci_id+"/"+file_typecode;  //Added by S.Sathish for IN021074 on Friday, April 30, 2010
				
				 if(!file_typecodecomp.equals("") && file_typecodecomp.equals(file_typecode) )
					{
                  					
					file_type_desc="&nbsp";
                   volumeno="&nbsp";
					fileno="";
					flag="true";
						}				 
				 
				 htRecord.put(file_typecode	,file_typecode);
					
				}
			  
			 if(file_type_appl_yn.equals("N"))
				{
				String filenocomp	=	(String)	htRecord.get(fileno);
				 if(filenocomp==null || filenocomp.equals("null"))  filenocomp="";
				  
				  if(!filenocomp.equals("") && filenocomp.equals(fileno))
					{
				   volumeno="&nbsp";
					fileno="&nbsp";
					 flag="true";
						}
			 htRecord.put(fileno,fileno); 
				}							
				
				if(flag.equals("false"))
				{			 
           	 
			  countt++;
			 
            _bw.write(_wl_block17Bytes, _wl_block17);
 if (file_type_appl_yn.equals("N")) { 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block20Bytes, _wl_block20);
 } else if (file_type_appl_yn.equals("Y")) { 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(file_type_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
 } 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(volumeno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(volumeno));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

				  
			pstmt1	=	connection.prepareStatement("select volume_status  from fm_curr_locn where patient_id=? and file_no=? and facility_id=? and volume_no=(select max(volume_no) from fm_curr_locn where patient_id=? and file_no=? and facility_id=? )");
           pstmt1.setString(1, patient_id);
           pstmt1.setString(2, fileno);
		    pstmt1.setString(3, facility_id);	
		    pstmt1.setString(4, patient_id);	
		   pstmt1.setString(5, fileno);	
		   pstmt1.setString(6,facility_id);
			rset1		=	pstmt1.executeQuery();
              
				
				while(rset1.next())
                {
				volume_status    = rset1.getString("volume_status");                     
                
				  } 
            		StringBuffer sqlString1			=	new StringBuffer();		
			sqlString1.append("SELECT distinct volume_no FROM fm_curr_locn WHERE patient_id = ? and volume_status IN('I','L') and file_no=?");
		
		if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('A','L') ");
		else if(incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString1.append(dflt_valnot +" and curr_file_status not in ('A')");
			else if(incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("Y"))
			sqlString1.append(dflt_valnot);
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("N"))
			sqlString1.append(" and curr_file_status not in ('A','L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("N") && inact_chk.equals("Y"))
			sqlString1.append(" and curr_file_status not in ('L') ");
		else if(incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("N"))
			sqlString1.append(" and curr_file_status not in ('A') ");
		
		
				
		if((incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("N")) || (incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("Y")) || (incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("N")) || (incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("N")) || (incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("Y")) )
		{
          
			if(volume_status.equals("L"))
			{
			
			
			sqlString1.append("  AND volume_no <> (SELECT  nvl(max(volume_no),0)    FROM fm_curr_locn   WHERE patient_id = ?  AND volume_status IN('L')   AND file_no =?  AND curr_file_status NOT IN('A'))");
			}else{
	     sqlString1.append("  AND volume_status NOT IN('A')" );
		}
		}
			sqlString1.append(" order by volume_no ");
			pstmt	=	connection.prepareStatement(sqlString1.toString());			
			
			
			pstmt.setString(1, patient_id);
				/*if (file_type_appl_yn.equals("Y") && !file_typecode.equals("")) {
					pstmt.setString(3, file_typecode);
				} commented by sathish for IN018405 on Friday, January 22, 2010*/

					pstmt.setString(2,fileno );

	if(volume_status.equals("L"))
					{
		if((incomp_chk.equals("N") && lost_chk.equals("N") && inact_chk.equals("N")) || (incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("Y")) || (incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("N")) || (incomp_chk.equals("Y") && lost_chk.equals("Y") && inact_chk.equals("N")) || (incomp_chk.equals("N") && lost_chk.equals("Y") && inact_chk.equals("Y")) )
		{
          pstmt.setString(3, patient_id);
          pstmt.setString(4,fileno);
		  }
					}	
						rset		=	pstmt.executeQuery();
            			
				while(rset.next())
                {
					code    = rset.getString("volume_no");                     
                    out.println("<option value='"+code+"'>"+code);
                } if(rset != null) rset.close();
               				
                
            _bw.write(_wl_block37Bytes, _wl_block37);
				
				}
			if(flag.equals("false"))
				{
			count++;
				}
			flag="false";
			cnt++;
			}
		}
		
		
		if(cnt == 0)
		{
			
            _bw.write(_wl_block38Bytes, _wl_block38);

		}
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(file_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(countt));
            _bw.write(_wl_block43Bytes, _wl_block43);

	//}

	if(rset!=null)	rset.close();
	if(rset1!=null)	rset1.close();
	if(resultSet!=null)	resultSet.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();
	if(preStatement!=null) preStatement.close();

}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fileno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.filetype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ActiveVolumeNo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.InactiveVolumeNo.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
