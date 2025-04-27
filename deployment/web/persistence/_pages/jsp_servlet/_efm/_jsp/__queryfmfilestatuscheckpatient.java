package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __queryfmfilestatuscheckpatient extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryFMFileStatusCheckPatient.jsp", 1709116886093L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form name=\"checkvals\" id=\"checkvals\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n//alert(\'APP-MP0012 Invalid Patient ID\');\n\t\t\tvar msg = getMessage(\'INVALID_VALUE\',\'Common\'); \n\t\t\tmsg = msg.replace(\'#\',getLabel(\'Common.patientId.label\',\'Common\'));\n\t\t\talert(msg);\n\t\t\tparent.frames[1].document.forms[0].patient_id.select();\n\t\t\tparent.volumeFrame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t<script>\n\t\t\t\tvar errors = getMessage(\'PATIENT_FILE_NOT_EXIST\',\'FM\');\t\n\t\t\t\tparent.frames[1].document.forms[0].patient_id.focus();\n\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'false\';\n\t\t\t\tparent.volumeFrame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t   \t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t<script>\n\n\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'true\';\n\t\t\t\tparent.frames[1].document.forms[0].currStatDesc.value =\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\tparent.frames[1].document.forms[0].currIdDesc.value = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t\tparent.frames[1].document.forms[0].Curr_locn_desc.value = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\n\t\t\t\tparent.frames[1].document.forms[0].Req_on.value = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\tparent.frames[1].document.forms[0].Curr_locn_code.value = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\t\tparent.frames[1].document.forms[0].Curr_locn_iden.value = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\t\tparent.frames[1].document.forms[0].Curr_locn_mr_locn.value = \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\t\t\t\t\t\t\t\t\n\t\t\t\tparent.frames[1].showPatientLine();\t\t\n\t\t\t\tvar patient_id\t\t\t= parent.frames[1].document.forms[0].patient_id.value;\n\t\t\t\tvar file_type_appl_yn\t= parent.frames[1].document.forms[0].file_type_appl_yn.value;\n\n\t\t\t/*\tvar incomp_chk\t= \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\t\tvar lost_chk\t= \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\t\tvar inact_chk\t= \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\';\n\t\t\t\tvar dflt_incomplete_fs_locn_code\t= \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\';  */\n\n\t\t\t\tvar incomp_chk\t= parent.frames[1].document.forms[0].incomp_chk.value;\n\t\t\t\tvar lost_chk\t= parent.frames[1].document.forms[0].lost_chk.value;\n\t\t\t\tvar inact_chk\t= parent.frames[1].document.forms[0].inact_chk.value;\n\t\t\t\tvar dflt_incomplete_fs_locn_code\t= parent.frames[1].document.forms[0].dflt_incomplete_fs_locn_code.value;\n\n\t\t\t/*\talert(\"incomp_chk :\"+incomp_chk);\n\t\t\t\talert(\"lost_chk :\"+lost_chk);\n\t\t\t\talert(\"inact_chk :\"+inact_chk);\n\t\t\t\talert(\"dflt_incomplete_fs_locn_code :\"+dflt_incomplete_fs_locn_code); */\n\n\n\t\t\t\t\n\t\t\t\tparent.volumeFrame.location.href=\"../../eFM/jsp/QueryCurrentFileTypeVolumeNo.jsp?patient_id=\"+patient_id+\"&file_type_appl_yn=\"+file_type_appl_yn+\"&incomp_chk=\"+incomp_chk+\"&lost_chk=\"+lost_chk+\"&inact_chk=\"+inact_chk+\"&dflt_incomplete_fs_locn_code=\"+dflt_incomplete_fs_locn_code;\n\n\t\t</script>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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

	Connection con = ConnectionManager.getConnection(request);
	Statement stmt = null;
	ResultSet rs   = null;

try
{
	StringBuffer sql		= new StringBuffer();
	String found	= "N";
	String pat_id = "";
	String file_no = "";
	String fs_locn = "";
	String currLocn = "";
	String currDesc = "";
	String currStat = "";
	String currStatDesc = "";
	String currIden = "";
	String currIdDesc = "";
	String currMrLocn = "";
	String sysdate	= "";
	String otherFiles = "N";
	String FirstcurrDesc = "";
	String FirstcurrIdDesc = "";
	String FirstcurrStatDesc = "";
	String facility_id = (String) session.getValue("facility_id");
	String Facility = request.getParameter("Facility");
	String Patient = request.getParameter("Patient");

	String incomp_chk = request.getParameter("incomp_chk");
	String lost_chk = request.getParameter("lost_chk");
	String inact_chk = request.getParameter("inact_chk");
	String dflt_incomplete_fs_locn_code = request.getParameter("dflt_incomplete_fs_locn_code");
	String moreCriteria = "";
	int temp = 1;
	
	if (!Patient.equals(""))
	{
		webbeans.op.PatientData patdata = new webbeans.op.PatientData();
		patdata.setFacility_id(facility_id);
		String patient_status = patdata.CheckStatus(con,Patient);
		if (patient_status.equals("INVALID_PATIENT"))
		{
	
            _bw.write(_wl_block8Bytes, _wl_block8);
		
		}
	}
	
	if(Facility.equals(facility_id))
		moreCriteria = " ISS_YN = 'Y' ";
	else
		moreCriteria = " ISS_ACROSS_FACILITIES_YN = 'Y' ";

		stmt = con.createStatement();
		sql.append("Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, get_patient_line(PATIENT_ID,'"+localeName+"') PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN, DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External', 'E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,CURR_FACILITY_ID  from FM_CURR_LOCN_VW A where  PATIENT_ID='"+Patient+"' ");
		if(facility_id.equals("HS"))
	   {
		sql.append("and  CURR_FS_LOCN_CODE is not null order by FILE_NO");
		}else{
		
		// sql.append("and exists (select 1 from fm_curr_locn where patient_id = a.patient_id and (facility_id ='"+facility_id+"' or curr_facility_id ='"+facility_id+"'))");
		sql.append("and exists (select 1 from fm_curr_locn where patient_id = a.patient_id )");
		
		}
		//sql = "Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, get_patient_line(PATIENT_ID,'"+localeName+"') PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN, DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External', 'E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,CURR_FACILITY_ID  from FM_CURR_LOCN_VW A where  PATIENT_ID='"+Patient+"' and A.FACILITY_ID='"+facility_id+"' AND CURR_FS_LOCN_CODE is not null order by FILE_NO";
	
	
		rs = stmt.executeQuery(sql.toString());

		String str = "";
		if(rs != null)
		{
			while (rs.next())
			{
				found = "Y";
				String file_status =(rs.getString("CURR_FILE_STATUS")==null)?"":rs.getString("CURR_FILE_STATUS");

				if(file_status.equals("I") || file_status.equals("O") ||file_status.equals("L") || file_status.equals("A")||file_status.equals("T")||file_status.equals("E"))
				{
					pat_id = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
					file_no =(rs.getString("FILE_NO")==null)?"":rs.getString("FILE_NO");
					str = str + "<option value='"+file_no+"'>"+file_no+"</option>";
					fs_locn =(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");				
					currMrLocn =(rs.getString("CURR_MR_LOCN_YN")==null)?"":rs.getString("CURR_MR_LOCN_YN");
					currLocn =(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");
					currDesc =(rs.getString("CURR_FS_LOCN_DESC")==null)?"":rs.getString("CURR_FS_LOCN_DESC") ;
					currStat =(rs.getString("CURR_FILE_STATUS")==null)?"":rs.getString("CURR_FILE_STATUS");
					currStatDesc
					=(rs.getString("FILE_STATUS_DESC")==null)?"":rs.getString("FILE_STATUS_DESC"); 
				currIden =(rs.getString("CURR_FS_LOCN_IDENTITY")==null)?"":rs.getString("CURR_FS_LOCN_IDENTITY");
				currIdDesc =(rs.getString("LOCN_IDENTITY_DESC")==null)?"":rs.getString("LOCN_IDENTITY_DESC");
					sysdate  =(rs.getString("SYDATE")==null)?"":rs.getString("SYDATE");

					if(temp == 1)
					{
					FirstcurrDesc =(rs.getString("CURR_FS_LOCN_DESC")==null)?"":rs.getString("CURR_FS_LOCN_DESC") ;
					FirstcurrIdDesc =(rs.getString("LOCN_IDENTITY_DESC")==null)?"":rs.getString("LOCN_IDENTITY_DESC");
					FirstcurrStatDesc =(rs.getString("FILE_STATUS_DESC")==null)?"":rs.getString("FILE_STATUS_DESC"); 
					temp++;
					}
				}
				else
					otherFiles = "Y";
			}
		}

		if(found.equals("N"))
		{

            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		else
		{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(java.net.URLEncoder.encode(currStatDesc)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(currIdDesc)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(currDesc)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(currLocn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(currIden));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(currMrLocn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(incomp_chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(lost_chk));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(inact_chk));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dflt_incomplete_fs_locn_code));
            _bw.write(_wl_block21Bytes, _wl_block21);

		}
if (rs!=null) rs.close();
if (stmt!=null) stmt.close();
}
catch(Exception e)
{ out.println("In Exception :"+e.toString()); }
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
