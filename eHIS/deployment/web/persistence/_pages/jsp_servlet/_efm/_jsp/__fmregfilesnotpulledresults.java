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
import webbeans.st.RecordSetBean;
import java.util.*;
import com.ehis.util.*;

public final class __fmregfilesnotpulledresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMRegFilesNotPulledResults.jsp", 1709116867875L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tPrakash.S\n\tCreated on \t\t:\t10/06/2002\n\tModule\t\t\t:\tFM - Register File Not Pulled\n\tFunction\t\t:\tThis function is used for Search Result.\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMRegFilesNotPulled.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<SCRIPT>\n\tfunction loadCurrPage()\n\t{\n\t\t/*\t\t\n\t\tvar CBValStr\t\t=\tparent.frames[0].document.forms[0].CBValStr.value;\n\t\tvar fm_disp\t=\tdocument.forms[0].fm_disp.value;\n\t\tvar to_disp\t=\tdocument.forms[0].to_disp.value;\n\t\tif(CBValStr != \"\")\n\t\t{\n\t\t\tfor(i=fm_disp; i<=to_disp; i++)\n\t\t\t{\n\t\t\t\tif(eval(\'document.forms[0].pull_yn\'+i+\'.disabled=false;\'))\n\t\t\t\t{\n\t\t\t\t\teval(\'document.forms[0].pull_yn\'+i+\'.checked=true;\');\n\t\t\t\t}\n\t\t\t}\n\t\t}\t\t\n\t\t//else if((chk_val==\"\"))\n\t\t//{\n\t\t\t//parent.frames[1].document.forms[0].CBValStr.value\t=\tCBValStr;\n\t\t\t//parent.frames[1].document.forms[0].LocnValStr.value\t=\tLocnValStr;\n\n\t\t/*for(i=fm_disp; i<=to_disp; i++)\n\t\t\t{\n\t\t\t\teval(\'document.forms[0].fs_locn_code\'+i+\'.disabled=false;\');\n\t\t\t\teval(\'document.forms[0].associate_yn\'+i+\'.disabled=false;\');\n\t\t\t\teval(\'document.forms[0].fs_locn_code\'+i+\'.value=\"\";\');\n\t\t\t\teval(\'document.forms[0].associate_yn\'+i+\'.checked=false;\');\n\t\t\t}\n\t\t\tif(CBValStr != \"\") parent.frames[1].document.forms[0].CBValStr.value=\"\";\n\t\t\tif(LocnValStr != \"\") parent.frames[1].document.forms[0].LocnValStr.value=\"\";\n\t\t*/\n\t\t//}\n\t\t\n\t}\n\t</SCRIPT>\n</head>\n<body  onLoad=\'dispRecord(); loadCurrPage();\' onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n<form name=\'FMRegFilesNotPulledForm\' id=\'FMRegFilesNotPulledForm\' action=\'\' method=\'\'>\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<A HREF=\'../jsp/FMRegFilesNotPulledResults.jsp?from=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&to=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&mode=Previous\' onClick=\'checkVal();\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</A>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&mode=next\' onClick=\'checkVal();\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</td>\n</tr>\n</table> \n<br><br>\n</P>\n\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'100%\'  >\n<th width=\'40%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n<th width=\'15%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n<th width=\'10%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n<th width=\'5%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="?</th>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<tr id=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' ><font size=\'1\'><b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</b></font><br>&nbsp;&nbsp;&nbsp;<font size=\'1\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font></td>\t\t\t\n\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' ><font size=\'1\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font></td>\n\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' align=\'center\'><input type=\'checkbox\' name=\'pull_yn";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'pull_yn";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  value=\'Y\'  onClick=\'CBValue(this,\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\");\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</table>\n<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n</form>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );
int row_count=0;

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
            webbeans.st.RecordSetBean recordSet= null;synchronized(session){
                recordSet=(webbeans.st.RecordSetBean)pageContext.getAttribute("recordSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(recordSet==null){
                    recordSet=new webbeans.st.RecordSetBean();
                    pageContext.setAttribute("recordSet",recordSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	request.setCharacterEncoding("UTF-8");
	Connection con	=	null;
	Statement stmt	=	null;		 
	ResultSet rs	=	null;	
	
	Hashtable		htRecord	=	null;
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();		
		
		int start = 0 ;
		int end = 0 ;
		int fm_disp=0, to_disp=0;
		
		String file_no="", patient_id="", tblrow_id="",classValue="";
		String pat_details="",appt_date="",	clinic_desc="", clinic_code="",fs_locn_code="",curr_file_status="",pull_yn_prop="";
		String fs_locn_desc="",practitioner_name="",practitioner_id="",result_query="",file_pull_yn="N";
		String curr_fs_locn_code="", curr_facility_id="",curr_file_status1="";

		String facility_id=(String)session.getValue("facility_id");
		String from			=	request.getParameter( "from" ) ;
		String to			=	request.getParameter( "to" ) ;
		String mode			=	request.getParameter("mode") ;

		if(mode == null || mode.equals("null")) mode="";

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
	  		end = 9 ;
		else
			end = Integer.parseInt( to ) ;

		if(mode.equals(""))
		{
			appt_date=request.getParameter("appt_date");
			if(appt_date==null)appt_date="";
			if(!(appt_date.equals(""))) recordSet.clearAll();

			//result_query="select a.file_no, a.patient_id, a.clinic_desc, a.clinic_code, a.src_fs_locn_code, a.DEST_FS_LOCN_DESC src_fs_locn_desc, a.practitioner_name, a.practitioner_id, get_patient_line(a.patient_id) pat_details , decode(b.curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived', 'O', 'Outside' ) curr_file_status,curr_file_status curr_file_status1,b.curr_fs_locn_code,b.curr_facility_id from fm_pulling_list_vw a,fm_curr_locn_vw b where a.facility_id='"+facility_id+"' and a.appt_date = to_date('"+appt_date+"','dd/mm/yyyy') and a.file_pulled_yn='N' and a.facility_id=b.facility_id and a.file_no=b.file_no ";
			result_query = "SELECT"
						  +"  a.File_No"
						  +"  , a.Patient_Id"
						  +"  , op_Get_desc.OP_CLINIC('"+facility_id+"',a.Clinic_Code,'"+localeName+"',1)"
						  +"  , a.Clinic_Code"
						  +"  , a.src_fs_Locn_Code"
						  +"  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',a.src_fs_Locn_Code,'"+localeName+"',2) src_fs_Locn_desc"
						  +"  , am_Get_desc.AM_PRACTITIONER(a.Practitioner_Id,'"+localeName+"',1)"
						  +"  , a.Practitioner_Id"
						  +"  , Get_patient_line(a.Patient_Id,'"+localeName+"') Pat_Details"
						  +"  , b.Curr_File_Status Curr_File_Status"
						  +"  , Curr_File_Status Curr_File_Status1"
						  +"  , b.Curr_fs_Locn_Code"
						  +"  , b.Curr_Facility_Id "
						  +"FROM"
						  +"  fm_PullIng_List a"
						  +"  , fm_Curr_Locn b "
						  +"WHERE a.Facility_Id = '"+facility_id+"' "
						  +"  AND a.appt_Date = TO_DATE('"+appt_date+"','dd/mm/yyyy') "
						  +"  AND a.CONFIRM_YN = 'N' "
						  +"  AND a.Facility_Id = b.Facility_Id "
						  +"  AND a.File_No = b.File_No";


			rs=stmt.executeQuery(result_query);

			if(rs != null)
			{
				while(rs.next())
				{
					file_no				=	rs.getString("file_no");
					patient_id			=	rs.getString("patient_id");
					clinic_desc			=	rs.getString("clinic_desc");
					clinic_code			=	rs.getString("clinic_code");
					fs_locn_code		=	rs.getString("src_fs_locn_code");
					fs_locn_desc		=	rs.getString("src_fs_locn_desc");
					practitioner_name	=	rs.getString("practitioner_name");
					practitioner_id		=	rs.getString("practitioner_id");
					curr_file_status	=	rs.getString("curr_file_status");
					curr_file_status1	=	rs.getString("curr_file_status1");
					pat_details			=	rs.getString("pat_details").substring(0,rs.getString("pat_details").length()-6);
					curr_fs_locn_code	=	rs.getString("curr_fs_locn_code");
					curr_facility_id	=	rs.getString("curr_facility_id");


					if(file_no == null || file_no.equals("null"))file_no="";
					if(patient_id == null || patient_id.equals("null"))patient_id="";
					if(clinic_desc == null || clinic_desc.equals("null"))clinic_desc="";				if(clinic_code == null || clinic_code.equals("null"))clinic_code="";
					if(fs_locn_code == null || fs_locn_code.equals("null"))fs_locn_code="";
					if(fs_locn_desc == null || fs_locn_desc.equals("null"))fs_locn_desc="";
					if(practitioner_name == null || practitioner_name.equals("null"))practitioner_name="";
					if(practitioner_id == null || practitioner_id.equals("null"))practitioner_id="";
					if(pat_details == null || pat_details.equals("null"))pat_details="";
					if(curr_file_status == null || curr_file_status.equals("null"))curr_file_status="";
					if(curr_file_status1 == null || curr_file_status1.equals("null"))curr_file_status1="";
					if(curr_fs_locn_code == null || curr_fs_locn_code.equals("null"))curr_fs_locn_code="";
					if(curr_facility_id == null || curr_facility_id.equals("null"))curr_facility_id="";

			if(!curr_file_status.equals(""))
			{
				switch(curr_file_status.charAt(0))
				{
					case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;
			
				}
			}


					htRecord			=	new Hashtable();

					htRecord.put("file_no"			,	file_no);
					htRecord.put("patient_id"		,	patient_id);
					htRecord.put("clinic_desc"		,	clinic_desc);
					htRecord.put("clinic_code"		,	clinic_code);
					htRecord.put("fs_locn_code"		,	fs_locn_code);
					htRecord.put("fs_locn_desc"		,	fs_locn_desc);
					htRecord.put("practitioner_name",	practitioner_name);
					htRecord.put("practitioner_id"	,	practitioner_id);
					htRecord.put("pat_details"		,	pat_details);
					htRecord.put("pat_details"		,	pat_details);
					htRecord.put("file_pull_yn"		,	file_pull_yn);
					htRecord.put("curr_file_status" ,	curr_file_status);
					htRecord.put("curr_file_status1" ,	curr_file_status1);
					htRecord.put("curr_fs_locn_code",	curr_fs_locn_code);	
					htRecord.put("curr_facility_id" ,	curr_facility_id);
					
					recordSet.putObject(htRecord);
				}
			}

			row_count				=	recordSet.getSize();

			
			fm_disp	=	0;
			to_disp	=	9;
			if(to_disp > (row_count-1))
					to_disp=(row_count-1);
		}

			fm_disp =	start-1;
			to_disp	=	end-1;
				if(to_disp > (row_count-1))
					to_disp=(row_count-1);
		

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	if ( !(start <= 1) )
	{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start-9));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end-9));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
	
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	if ( !( (start+9) > row_count ) )
	{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((start+9)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((end+9)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	}

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

try
{
	for(int i=fm_disp; i<=to_disp; i++)
	{
		classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		htRecord			=	(java.util.Hashtable)	recordSet.getObject(i);

		file_no				=	(String)	htRecord.get("file_no");
		patient_id			=	(String)	htRecord.get("patient_id");
		clinic_desc			=	(String)	htRecord.get("clinic_desc");
		clinic_code			=	(String)	htRecord.get("clinic_code");
		fs_locn_code		=	(String)	htRecord.get("fs_locn_code");
		fs_locn_desc		=	(String)	htRecord.get("fs_locn_desc");
		practitioner_name	=	(String)	htRecord.get("practitioner_name");
		practitioner_id		=	(String)	htRecord.get("practitioner_id");
		curr_file_status	=	(String)	htRecord.get("curr_file_status");
		curr_file_status1	=	(String)	htRecord.get("curr_file_status1");
		pat_details			=	(String)	htRecord.get("pat_details");
		curr_fs_locn_code	=	(String)	htRecord.get("curr_fs_locn_code");
		curr_facility_id	=	(String)	htRecord.get("curr_facility_id");
				
		if((fs_locn_code.equals(curr_fs_locn_code)) && (facility_id.equals(curr_facility_id)) && (curr_file_status1.equals("I"))) 
			pull_yn_prop="checked";
		else
			pull_yn_prop="disabled";

		tblrow_id	=	"tblrow_id"+i;

		
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(((file_no.equals(""))?"&nbsp;":file_no)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(((pat_details.equals(""))?"&nbsp;":pat_details)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(((clinic_desc.equals(""))?"&nbsp;":clinic_desc)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(((practitioner_name.equals(""))?"&nbsp;":practitioner_name)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(((fs_locn_desc.equals(""))?"&nbsp;":fs_locn_desc)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(((curr_file_status.equals(""))?"&nbsp;":curr_file_status)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pull_yn_prop));
            _bw.write(_wl_block29Bytes, _wl_block29);

		}
	}
	catch(Exception e)
	{
		out.println("Exception@2: "+e);
	}	

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block33Bytes, _wl_block33);

if(rs != null) rs.close();
if(stmt != null) stmt.close();	
}
catch(Exception e)
{
	out.println("Exception in etching connection"+e.toString());
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileNoPatientDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReceivingFSLocation.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileStatus.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.Pull.label", java.lang.String .class,"key"));
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
}
