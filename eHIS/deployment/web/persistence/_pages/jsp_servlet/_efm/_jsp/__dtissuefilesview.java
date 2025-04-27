package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __dtissuefilesview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTIssueFilesView.jsp", 1741319161734L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMIssueFiles.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/checkSystemDate.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMIssueFilesDoc.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<script>\n\tfunction GetRemarks(recnum) {\t\n\t\tvar dialogHeight\t= \"12\" ;\n\t\tvar dialogWidth\t\t= \"20\" ;\n\t\tvar dialogTop\t\t= \"185\" ;\n\t\tvar dialogLeft\t\t= \"250\" ;\n\t\tvar center\t\t\t= \"0\" ;\n\t\tvar status\t\t\t= \"no\";\n\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop + \";dialogLeft:\" + dialogLeft;\n\t\tvar arguments\t\t= \"\" ;\n\t\t\n\t\tvar transmode1 = \"document.forms[0].file_transport_mode\"+recnum;\n\t\tvar obj1 = eval(transmode1);\n\t\t\n\t\tvar carriedbyname1 = \"document.forms[0].carried_by_name\"+recnum;\n\t\tvar obj2 = eval(carriedbyname1);\n\t\t\n\n\t\tretVal\t\t\t\t= window.showModalDialog( \"../../eFM/jsp/FMIssueFileModelWindow.jsp?from=detail&file_transport_mode=\"+obj1.value+\"&carried_by_name=\"+obj2.value, arguments, features );\n\t\tvar arr=new Array();\n\n\tif (!(retVal == null)) {\n\t\tvar retVal=unescape(retVal);\n\t\tarr=retVal.split(\"::\");\n\n\t\tvar transmode = \"document.forms[0].file_transport_mode\"+recnum;\n\t\tvar obj1 = eval(transmode);\n\t\tobj1.value = arr[0];\n\t\tvar carriedbyname = \"document.forms[0].carried_by_name\"+recnum;\n\t\tvar obj2 = eval(carriedbyname);\n\t\tobj2.value = arr[1];\n\t\t\n\t\t}\n}\t\n\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n<form name=\'IssueFileView_form\' id=\'IssueFileView_form\'>\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n \t<th width=\'14%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th> \t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\t\n\t<th width=\"5%\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\t\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="?</th>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n        <tr>\n            <td  width=\"90%\" height=\"20\" colspan=8  class=\'CAGROUPHEADING\' ><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></td>\n        </tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n        <tr>\n            <td  width=\"90%\" height=\"20\" colspan=8 class=\'CAGROUPHEADING\' ><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<td class=\'\"+classValue+\"\'>\n\t\t<input type=\'text\' name=\'retdate";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'retdate";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'datetd";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' size=\'16\' maxlength=\'16\' tabIndex=\'3\' value=\'\' onBlur=\'ValidateDateTime(this,sys_date);\'><img name=\'im";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'retdate";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\', null, \'hh:mm\');\" onMouseover=\"changeCursor(this)\"></img>\n\t\t</td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\n\t\t\t<SCRIPT>\n\t\t\t\tdocument.forms[0].retdate";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =".value    = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"; \n\t\t\t\tdocument.forms[0].retdate";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =".disabled = true; \n\t\t\t\tdocument.forms[0].im";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =".disabled      = true; \n\t\t\t</SCRIPT> \n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\t\n\t\t\t<SCRIPT>\n\t\t\t\tif(document.forms[0].retdate";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =".disabled  == true)\n\t\t\t\t\tdocument.forms[0].retdate";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =".disabled = false;\n\t\t\t\tif(document.forms[0].im";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =".disabled  == true)\n\t\t\t\t\tdocument.forms[0].im";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =".disabled = false;\n\t\t\t</SCRIPT> \n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t <a href=\'javascript:GetRemarks(";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =")\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</a></font></td>\n\t<input type=\"hidden\" name=\"rem_recnum_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"rem_recnum_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" value=\"\">\n\t\n\t<input type=\"hidden\" name=\"file_transport_mode";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"file_transport_mode";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" value=\"\">\n\t<input type=\"hidden\" name=\"carried_by_name";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"carried_by_name";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" value=\"\">\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t<input type=\"hidden\" name=\"comm_file_transport_mode\" id=\"comm_file_transport_mode\" value=\"\">\n\t<input type=\"hidden\" name=\"comm_carried_by_name\" id=\"comm_carried_by_name\" value=\"\">\n\t<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

	public boolean sortFMFilesIssueCart(webbeans.eFM.FMFilesIssueCart FMIssueFilesCart) throws Exception
	{
		String	Rec_Locn_Code	=	"",		next_Rec_Locn_Code		=	"";
		boolean	isSorted		=	true;
		ArrayList ArrFileCart	=	(ArrayList) FMIssueFilesCart.getPresCart();
		webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
		webbeans.eFM.FMFilesIssueDetail fissuebean2 = new 	
		webbeans.eFM.FMFilesIssueDetail();		
		
		try
		{
			for( int i=0; i<ArrFileCart.size(); i++ )
			{
				for(int j=0; j<ArrFileCart.size()-1-i;j++)
				{
					fissuebean	=	FMIssueFilesCart.getIssuesfromCart(j);
					Rec_Locn_Code	=	(String)			
					fissuebean.getRec_Locn_Code();
					fissuebean2	=	FMIssueFilesCart.getIssuesfromCart(j+1);
					next_Rec_Locn_Code	=	(String)				fissuebean2.getRec_Locn_Code();
					if(Rec_Locn_Code.compareToIgnoreCase(next_Rec_Locn_Code)<0)
					{
						FMIssueFilesCart.updIssuestoCart(fissuebean2.cloneFMFilesIssueDetail(), j);
						FMIssueFilesCart.updIssuestoCart(fissuebean.cloneFMFilesIssueDetail(), j+1);
					}
				}
			}
		}
		catch(Exception e)
		{
			isSorted = false;
		}
		return isSorted;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eFM.FMFilesIssueCart FMIssueFilesCart= null;synchronized(session){
                FMIssueFilesCart=(webbeans.eFM.FMFilesIssueCart)pageContext.getAttribute("FMIssueFilesCart",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FMIssueFilesCart==null){
                    FMIssueFilesCart=new webbeans.eFM.FMFilesIssueCart();
                    pageContext.setAttribute("FMIssueFilesCart",FMIssueFilesCart,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection conn = null;
	String curr_facility_id = (String) session.getValue("facility_id");
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	ResultSet rset3 = null;
	Statement stmt          = null;
	ResultSet rs            = null;

	String classValue = "";
	String otherValue = "";
	String sql = "";
	String sql1 = "";
	String sql3 = "";
	String daystoreturn = "";
	String reqlocndesc = "";
	int Other_rec_count = 0;
	String p_locncode = "";
	String file_type_appl_yn = "N";
	String DOC_TYPE_CODE = "";
	String DOC_TYPE_NAME = "";
	String DOC_FOLDER_ID = "";
	String DOC_FOLDER_NAME = "";
	String DOC_TYPE = "";
	String return_criteria	 = "";
	String returndays	 = "";

	String sys_date_query    = "";
	String sys_date          = "";

	try
	{
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement("SELECT file_type_appl_yn FROM mp_param ");
		rset = pstmt.executeQuery();
		if ((rset!=null) && (rset.next()))
		{
			file_type_appl_yn = rset.getString("file_type_appl_yn");
		}
		if(rset!=null)	rset.close();
		if ((file_type_appl_yn==null) || (file_type_appl_yn.equals("null")))
			file_type_appl_yn = "N";
		sys_date_query="select to_char(sysdate,'dd/mm/yyyy hh24:mi')from dual";
		stmt = conn.createStatement();
		rs   = stmt.executeQuery(sys_date_query);
		if(rs !=null && rs.next())
		{
			sys_date = rs.getString(1);
		}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

		if (file_type_appl_yn.equals("N"))
		{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
		else if (file_type_appl_yn.equals("Y"))
		{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		}
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	
	sortFMFilesIssueCart(FMIssueFilesCart);
	ArrayList ArrFileCart =(ArrayList) FMIssueFilesCart.getPresCart();
	int countRec = ArrFileCart.size();
	if (countRec >0)
	{
		out.println("<script>parent.parent.frames[2].document.getElementById('tab1').style.visibility='visible';parent.parent.frames[2].document.getElementById('tab1').style.display='inline';</script>");
	}	
	String locn_identity = "";
	String number = "";
	String duration_type = "";
	int ind = 0;
	for(ind=0;ind < ArrFileCart.size();ind++)
	{
		if ( ind % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
		fissuebean = FMIssueFilesCart.getIssuesfromCart(ind);		
		
	//	String indval = fissuebean.getIndex_Value();
		String fileno = fissuebean.getFile_No();
		String reqno = fissuebean.getReq_No();
		String file_type = fissuebean.getFile_Type();
		if ((file_type == null) || (file_type.equals("")))  file_type = "";
		String volume_no = fissuebean.getVolume_No();
		if (volume_no == null)  volume_no = "&nbsp;";
		String reqby = fissuebean.getRec_Name_Desc();
		String locncode = fissuebean.getRec_Locn_Code();
		String fac_id = fissuebean.getReq_Facility_Id();
	//	String from	= fissuebean.getRequest_From();	
		String reqfrom = fissuebean.getRequest_From();
		String reqdatetime = fissuebean.getRequest_Date_Time();	
		
		int hrs = 0;
		sql = "select locn_identity from fm_storage_locn where FACILITY_ID = ? and FS_LOCN_CODE = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,fac_id);
		pstmt.setString(2,locncode);
		rset = pstmt.executeQuery();

		while(rset.next())
		{
			locn_identity = rset.getString(1);
		}
		if(rset!=null)	rset.close();
		if(pstmt!=null)	pstmt.close();
		
		if(locn_identity.equals("C") || locn_identity.equals("N"))
		{
			sql = "SELECT (CASE WHEN  LOCN_IDENTITY in('C','E') THEN NO_OF_DH_TO_RETURN_OP ELSE (CASE WHEN LOCN_IDENTITY = 'N' THEN NO_OF_DH_TO_RETURN_IP ELSE (CASE WHEN LOCN_IDENTITY = 'Y' THEN NO_OF_DH_TO_RETURN_DC END) END) END),duration_type FROM fm_storage_locn WHERE FS_LOCN_CODE = ? AND FACILITY_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,locncode);
		pstmt.setString(2,fac_id);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				number = rset.getString(1);
				duration_type = rset.getString(2);
			}			
			if(rset!=null)	rset.close();
			if(pstmt!=null)	pstmt.close();

			if(number==null || number.equals(""))
				number = "0";
			if(duration_type == null || duration_type.equals("null"))	  duration_type = "";

			if(duration_type.equals("D"))
				hrs = Integer.parseInt(number)*24;
			else if(duration_type.equals("H"))
				hrs = Integer.parseInt(number);
		}
////
sql3 = "select a.DOC_TYPE_CODE, a.DOC_TYPE_NAME, a.DOC_FOLDER_ID, a.DOC_FOLDER_NAME, (CASE WHEN f.PATIENT_PERIOD_SPECIFIC='D' THEN ' ,' || TO_CHAR(f.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(f.to_period,'dd/mm/rrrr ')  ELSE ' ' || get_patient_line(f.patient_id,'"+localeName+"') END)doc_type from fm_curr_locn_vw a, fm_doc_folder f  Where a.DOC_FOLDER_ID=f.doc_folder_id and a.FACILITY_ID = ? and a.FILE_NO = ? ";

		pstmt = conn.prepareStatement(sql3);
		pstmt.setString(1,curr_facility_id);
		pstmt.setString(2,fileno);
		rset3 = pstmt.executeQuery();

		if(rset3.next())
		{
			DOC_TYPE_CODE = rset3.getString(1);
			DOC_TYPE_NAME = rset3.getString(2);
			DOC_FOLDER_ID = rset3.getString(3);
			DOC_FOLDER_NAME = rset3.getString(4);
			DOC_TYPE = rset3.getString(5);
		}
		if(pstmt!=null)	pstmt.close();

		if ((DOC_TYPE_CODE==null) || (DOC_TYPE_CODE.equals(""))) DOC_TYPE_CODE = "&nbsp;";
		if ((DOC_TYPE_NAME==null) || (DOC_TYPE_NAME.equals(""))) DOC_TYPE_NAME = "&nbsp;";
		if ((DOC_FOLDER_ID==null) || (DOC_FOLDER_ID.equals(""))) DOC_FOLDER_ID = "&nbsp;";
		if ((DOC_FOLDER_NAME==null) || (DOC_FOLDER_NAME.equals(""))) DOC_FOLDER_NAME = "&nbsp;";
		if ((DOC_TYPE==null) || (DOC_TYPE.equals(""))) DOC_TYPE = "&nbsp;";

////

		sql = "Select to_char(SYSDATE+"+(hrs)+"/24,'DD/MM/YYYY HH24:MI') RET, SHORT_DESC,RETURN_CRITERIA from FM_STORAGE_LOCN Where FACILITY_ID = ? and FS_LOCN_CODE = ? ";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,fac_id);
		pstmt.setString(2,locncode);
		rset = pstmt.executeQuery();

		if(rset.next())
		{
			returndays = rset.getString(1);
			reqlocndesc = rset.getString(2);
			return_criteria = rset.getString(3);
		}
		if(pstmt!=null)	pstmt.close();
		if(rset!=null)	rset.close();
		
		if(returndays == null || returndays.equals("null"))	  returndays = "&nbsp;";
		if(return_criteria == null || return_criteria.equals("null"))	  return_criteria = "";
		if (return_criteria.equals("I"))
		{
			daystoreturn = returndays;
		}else
		{
			daystoreturn = "";
		}
		if(reqno.equals(""))	  reqno = "&nbsp;";

		if(reqfrom.equals("S") || reqfrom.equals("MS"))
			otherValue = "lightgreen";  //"CCEEDD";
		else if(reqfrom.equals("D") || reqfrom.equals("MD"))
			otherValue = "lightpink";	//"FFEECC";

		sql1 = "select count(*) from fm_encounter_VOLUME_LINK a,pr_encounter b where a.facility_id = ? and a.file_no = ? and b.facility_id=a.facility_id and  b.encounter_id=a.encounter_id and volume_no= ? and closed_date is null and b.mlc_yn='Y'";
						
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1,curr_facility_id);
					pstmt.setString(2,fileno);
					pstmt.setString(3,volume_no);
					rset  = pstmt.executeQuery();
		if ((rset != null) && (rset.next()))
			{					
					Other_rec_count = rset.getInt(1);					
			}
			if(rset!=null)	rset.close();
			if(pstmt!=null)	pstmt.close();

      if (ind==0)
           {
                p_locncode = locncode;

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(reqlocndesc));
            _bw.write(_wl_block16Bytes, _wl_block16);

            }
        else if (!p_locncode.equals(locncode))
            {
                p_locncode = locncode;

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(reqlocndesc));
            _bw.write(_wl_block16Bytes, _wl_block16);

            }
 
		out.println("<tr><td class='"+classValue+"' nowrap><font size='1'>");
		out.println(reqdatetime);		
		out.println("</font></td><td class='"+classValue+"'><font size='1'><b>");			out.println(DOC_FOLDER_ID+"</b><br>&nbsp;"+DOC_FOLDER_NAME+"&nbsp;"+DOC_TYPE);
		out.println("</font></td><td class='"+classValue+"' align='CENTER'><font size='1'>");
		out.println(DOC_TYPE_NAME);			
		out.println("</font></td><td class='"+classValue+"'><font size='1'>");
		out.println(reqno);
		out.println("</font></td><td class='"+classValue+"'><font size='1'>");
		out.println(reqby);
		out.println("</font></td>");

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block23Bytes, _wl_block23);
		
		if(locn_identity.equals("C") || locn_identity.equals("N"))
		{

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(daystoreturn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		else if(locn_identity.equals("T") || locn_identity.equals("D"))
		{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block33Bytes, _wl_block33);

		}		
		out.println("<td class='"+classValue+"'><font size='1'>");

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ind ));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( ind ));
            _bw.write(_wl_block42Bytes, _wl_block42);

		out.println("</font></td><td style='background-color:"+otherValue+";' align='CENTER'>");
		if (Other_rec_count > 0)
		{
		if(reqfrom.equals("MS") || reqfrom.equals("MD"))
			out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'><img src='../../eFM/images/stop.gif' align='center'></img>#");
		else
			out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;<img src='../../eFM/images/stop.gif' align='center'></img>");
		}else
		{
			if(reqfrom.equals("MS") || reqfrom.equals("MD"))
			out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;#");
		else
			out.println("<font size='1'>&nbsp;<input type='checkbox' name='issue"+ind+"' id='issue"+ind+"' checked onClick='RemoveIssueFileView("+ind+");'>&nbsp;");
		};
		out.println("</font></td></tr>");

	}

	out.println("<input type='hidden' name='fileCount' id='fileCount' value=\""+ind+"\">");

	if(rset!=null)	rset.close();
	if(pstmt!=null)	pstmt.close();
	if(rset3!=null)	rset3.close();
	if(stmt  !=null) stmt.close();
	if(rs    !=null) rs.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(sys_date));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.requesteddate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentdetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentdetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestNo.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestedBy.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReturnDate.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransportMode.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Issue.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModeOfTransport.label", java.lang.String .class,"key"));
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
}
