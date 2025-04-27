package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import javax.servlet.jsp.JspWriter;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __arriveddepartedresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ArrivedDepartedResult.jsp", 1723108990602L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tSmita Unnikrishnan\n\tCreated on \t:\t12/05/2004\n\tModule\t\t:\tOut Patient Management\n\tFunction\t:\tThis file is used for displaying results for the criteria search for Patient movement records.\n-->\n\t ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t \n<html>\n\t<head>\n\t\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eOP/js/ArrivedDeparted.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body OnMouseDown=\"CodeArrest()\" onLoad=\"FocusFirstElement();\" onKeyDown = \'lockKey();\'>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<form name=\"ArrivedDepartedResult_form\" id=\"ArrivedDepartedResult_form\" >\n\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t <table cellpadding=0 cellspacing=0 border=0 width=\'100%\' align=\'center\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 width=\'100%\' border=\'1\' align=\'center\'>\n\t\t\t\t\t\t<th class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t\t<th class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\t\n\t\t\t\t\t\t<th class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' width=\'15%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' width=\'10%\' onMouseOver=\'style.cursor=\"hand\";\' onClick=\"ShowModal(\'A\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\" ><a><FONT SIZE=\"2\" COLOR=\"BLUE\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</FONT><!-- Wednesday, March 24, 2010  20215 venkat S --></a></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');\" ><FONT SIZE=\"2\" COLOR=\"BLUE\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</FONT></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' width=\'15%\'>&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t<!--Below line was added by venkatesh.s on 16-Nov-2012 against SS-CRF-010 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="/";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t  \t\t\t\t   ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' nowrap>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\t\n\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\'100%\' align=\'center\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 width=\'100%\' border=\'1\' align=\'center\'>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' width=\'25%\' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' width=\'17%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' width=\'13%\'  onMouseOver=\'style.cursor=\"pointer\";\' onClick=\"ShowModal(\'D\',\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\"><a><FONT SIZE=\"2\" COLOR=\"BLUE\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</FONT><!-- Wednesday, March 24, 2010  20215 venkat S --></a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\');\"><FONT SIZE=\"2\" COLOR=\"BLUE\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</FONT></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t<td width=\'20%\' class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t\t\t\t<td width=\'25%\' class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t</form>\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

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
	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Connection con=null;	
	
            _bw.write(_wl_block9Bytes, _wl_block9);


try {
	String facilityid=(String)session.getValue("facility_id");
	String locale=(String)session.getAttribute("LOCALE"); 
	String Pageval=request.getParameter("Pageval");
	if(Pageval == null) Pageval="A";
	String objname=request.getParameter("callfrom");
	if(objname == null) objname="";
	String patientid=request.getParameter("patientid");
	if(patientid==null) patientid="";
	String encounterid=request.getParameter("encounterid");
	if(encounterid == null) encounterid="";
	String patientclass=request.getParameter("patientclass");
	if(patientclass==null) patientclass="";
		
	String locntype=request.getParameter("locntype");
	if(locntype == null) locntype="";
	String locntypedesc=request.getParameter("");
	if(locntypedesc == null) locntypedesc="";
	
	String locncode =request.getParameter("locncode");
	if(locncode==null) locncode="";
	String locndesc=request.getParameter("");
	if(locndesc==null) locndesc="";
	
	String encounterdatetime=request.getParameter("encounterdate");
	if(encounterdatetime==null) encounterdatetime="";
	
	String allencounters=request.getParameter("allencounters");
	if(allencounters==null) allencounters="";
	
	String orderby=request.getParameter("orderby");
	if(orderby == null) orderby="";
	
	StringBuffer sql1=new StringBuffer();
	String locn_type="";
	String locn_type_desc="";
	String locn="";
	String locn_desc="";
	String pat_id="";
	String pat_name="";
	String enc_id="";
	String enc_dt_time="";
	String enc_dt_time_display="";
	String pat_trn_time="";
	String enc_type="";
	String enc_type_desc="";

	String enc_locn_type="";
	String enc_locn_code="";
	String reason_desc="";
    String classValue=""; 
	String current_locn_type="";
	String current_locn="";
	
	int i=0;
	int cnt=0;
 
    con=ConnectionManager.getConnection(request);
	
            _bw.write(_wl_block10Bytes, _wl_block10);
 

	sql1.append("SELECT a.patient_id patient_id , decode('"+locale+"', 'en', c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name)) patient_name ,a.encounter_id encounter_id , a.patient_class encounter_type , TO_CHAR(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') encounter_date_time  , TO_CHAR(a.pat_trn_time,'dd/mm/yyyy hh24:mi') pat_trn_time , a.pat_curr_locn_type pat_curr_locn_type,  b.to_locn_type  pat_curr_locn_type_desc ,b.to_locn_type current_locn_type,b.to_locn_code current_locn,a.pat_curr_locn_code , DECODE(b.to_locn_type,'W', get_desc ('"+locale+"', 'rd_clinic_lang_vw', 'SHORT_DESC', 'CLINIC_CODE', b.to_locn_code),'O', get_desc ('"+locale+"', 'ot_oper_room_lang_vw', 'SHORT_DESC', 'OPER_ROOM_CODE', b.to_locn_code),'N',IP_GET_DESC.IP_NURSING_UNIT(b.facility_id,b.to_locn_code,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(b.facility_id,b.to_locn_code,'"+locale+"','2'), OP_GET_DESC.OP_CLINIC(b.facility_id,b.to_locn_code,'"+locale+"','1')) pat_curr_locn_desc  ,DECODE(a.movement_reason_code,NULL,'',AM_GET_DESC.am_contact_reason(a.movement_reason_code,'"+locale+"','1')) reason_desc  ,a.ASSIGN_CARE_LOCN_TYPE ASSIGN_CARE_LOCN_TYPE ,a.ASSIGN_CARE_LOCN_CODE ASSIGN_CARE_LOCN_CODE FROM  pr_encounter a , pr_patient_movement b , mp_patient c WHERE a.facility_id='"+facilityid+"' AND a.facility_id = b.facility_id AND a.encounter_id=b.encounter_id ");

	//sql1.append("FROM  pr_encounter a , pr_patient_movement b , mp_patient c  ");	
	
	//sql1.append(" WHERE a.facility_id='"+facilityid+"' AND a.facility_id = b.facility_id AND a.encounter_id=b.encounter_id ");	 
	
	if(Pageval.equals("A")) {
		sql1.append(" and (b.movement_type='D') ");
	} else if(Pageval.equals("D")) {
		sql1.append(" and b.movement_type='A' ");
	}

	if((allencounters.equals("N") && Pageval.equals("A")) || Pageval.equals("D")) {
		sql1.append("and b.to_locn_code='"+locncode+"' and b.to_locn_type='"+locntype+"'");
	}

	if(!patientid.equals("")) {
		sql1.append(" and a.patient_id='"+patientid+"'");
	}

	if(!encounterid.equals("")) {
		sql1.append(" and a.encounter_id='"+encounterid+"'");
	}

	if(!encounterdatetime.equals("")) {
		sql1.append(" and trunc(a.visit_adm_date_time)=nvl(to_date('"+encounterdatetime+"','dd/mm/yyyy'),trunc(sysdate))");
	}
 	if(!patientclass.equals("")) {
		sql1.append(" and a.patient_class='"+patientclass+"'");
	   if(patientclass.equals("OP")) {
         sql1.append("and (a.visit_status >'01' and a.visit_status < '07')");
       } else if(patientclass.equals("EM")) {
	        sql1.append("and a.visit_status < '07' ");
       } else if(patientclass.equals("IP") || patientclass.equals("DC")) {
	        sql1.append("and a.adt_status < '08' ");
	   }
	} else {
		 sql1.append(" and (( a.patient_class = 'OP' and a.visit_status in ('02','03','04','05','06')) Or ( a.patient_class = 'EM' and a.visit_status < '07') OR (( a.patient_class in ('IP','DC') and a.ADT_STATUS  < '08')))");
	}
	
	sql1.append(" and  a.patient_id=c.patient_id and b.srl_no =(SELECT MAX(to_number(SRL_NO)) FROM PR_PATIENT_MOVEMENT d WHERE A.PATIENT_ID = d.PATIENT_ID AND  a.encounter_id=d.encounter_id and  "); 
	sql1.append(" d.FACILITY_ID ='"+facilityid+"') ");

	if(!orderby.equals(""))	{
		if(orderby.equals("T"))	{
			sql1.append(" order by a.patient_class");
		}
		else if(orderby.equals("D")) {
			sql1.append(" order by a.visit_adm_date_time");
		}
	}
		
		
		if(Pageval.equals("A"))
			{
			 
			pstmt=con.prepareStatement(sql1.toString());			
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				if( cnt==0 )
				{
				
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

					}
					
						if ( i % 2 == 0 )
					        classValue = "QRYEVEN" ;
					    else
				            classValue = "QRYODD" ;

						locn_type=rs.getString("pat_curr_locn_type");
						if(locn_type == null) locn_type="";
						
						locn_type_desc=rs.getString("pat_curr_locn_type_desc");

						if(locn_type_desc.equals("N")) {						
							locn_type_desc=
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
						}else if(locn_type_desc.equals("C")){					
							locn_type_desc=
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
						}else if(locn_type_desc.equals("E")) {
							locn_type_desc=
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
						}else if(locn_type_desc.equals("Y")){			
							locn_type_desc=
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
						}else if(locn_type_desc.equals("R")){			
							locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						}else if(locn_type_desc.equals("W")){			
							locn_type_desc=
								com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels");
						}else if(locn_type_desc.equals("O")){					
							locn_type_desc=
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.OTSpecific.label","op_labels");
						}

						if(locn_type_desc == null)
							locn_type_desc="";

						pat_id=rs.getString("patient_id");
							if(pat_id == null) pat_id = "";
						pat_name=rs.getString("patient_name");
						if(pat_name == null) pat_name="";
						
						enc_id=rs.getString("encounter_id");
						if(enc_id == null) enc_id="";
						enc_type=rs.getString("encounter_type");
						if(enc_type== null) enc_type="";
						current_locn_type = rs.getString("current_locn_type")==null?"":rs.getString("current_locn_type");
						current_locn = rs.getString("current_locn")==null?"":rs.getString("current_locn");

						if(enc_type.equals("IP"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
						else if(enc_type.equals("OP"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
						else if(enc_type.equals("EM"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
						else if(enc_type.equals("DC"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

						enc_dt_time=rs.getString("encounter_date_time");
							if(enc_dt_time == null) enc_dt_time = "";

						enc_dt_time_display=DateUtils.convertDate(enc_dt_time,"DMYHM","en",locale);

						locn=rs.getString("pat_curr_locn_code");
						if(locn == null) locn="";

						locn_desc=rs.getString("pat_curr_locn_desc");						
						if(locn_desc == null) 
							locn_desc="";
						pat_trn_time=rs.getString("pat_trn_time");
						if(pat_trn_time == null) pat_trn_time="";

						enc_locn_type=rs.getString("ASSIGN_CARE_LOCN_TYPE");
						if(enc_locn_type == null) enc_locn_type="";
						enc_locn_code=rs.getString("ASSIGN_CARE_LOCN_CODE");
						if(enc_locn_code == null) enc_locn_code="";

						reason_desc=rs.getString("reason_desc");
						if(reason_desc == null) reason_desc="&nbsp;";
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(enc_dt_time_display));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(enc_type_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

						if(!sStyle.equals("IeStyle.css"))
						{
						
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Pageval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(locn_desc)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(current_locn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locndesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(current_locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locntypedesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_dt_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_trn_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_locn_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Pageval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(current_locn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locndesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(current_locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locntypedesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_dt_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_trn_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_locn_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_name));
            _bw.write(_wl_block29Bytes, _wl_block29);

					if(locn_type.equals(""))
						{
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);

						}
						else
						{
            _bw.write(_wl_block31Bytes, _wl_block31);
if(locn_type_desc.equals("Room")){
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(current_locn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locn_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(locn_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(reason_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);

					i++;
					cnt++;
				}
				if( cnt == 0) {																					        out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
				}

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			
            _bw.write(_wl_block41Bytes, _wl_block41);
	
	}
	else if(Pageval.equals("D"))
	{		
		 
		pstmt=con.prepareStatement(sql1.toString());
		rs=pstmt.executeQuery();

		while(rs.next())
		{
			if( cnt==0 )
			{
			
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

			}

						if ( i % 2 == 0 )
					        classValue = "QRYEVEN" ;
					    else
				            classValue = "QRYODD" ;
						
						pat_id=rs.getString("patient_id");
						if(pat_id == null) pat_id = "";
						pat_name=rs.getString("patient_name");
						if(pat_name == null) pat_name="";
						
						enc_id=rs.getString("encounter_id");
						if(enc_id == null) enc_id="";
						enc_type=rs.getString("encounter_type");
						if(enc_type== null) enc_type="";
						
						if(enc_type.equals("IP"))
							enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
						else if(enc_type.equals("OP"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
						else if(enc_type.equals("EM"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
						else if(enc_type.equals("DC"))
							 enc_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");							 
						enc_dt_time=rs.getString("encounter_date_time");
							if(enc_dt_time == null) enc_dt_time = "";
						enc_dt_time_display=DateUtils.convertDate(enc_dt_time,"DMYHM","en",locale);				
							pat_trn_time=rs.getString("pat_trn_time");
						if(pat_trn_time == null) pat_trn_time="";
						enc_locn_type=rs.getString("ASSIGN_CARE_LOCN_TYPE");
						if(enc_locn_type == null) enc_locn_type="";
						enc_locn_code=rs.getString("ASSIGN_CARE_LOCN_CODE");
						if(enc_locn_code == null) enc_locn_code="";
					
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(enc_dt_time_display));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(enc_type_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);

						if(!sStyle.equals("IeStyle.css"))
						{
						
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Pageval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(locn_desc)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locndesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locntype));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locntypedesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_dt_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_trn_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_locn_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Pageval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(locn_desc)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locndesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locntype));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locntypedesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_dt_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_trn_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_locn_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enc_locn_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(pat_name));
            _bw.write(_wl_block57Bytes, _wl_block57);

						i++;
						cnt++;
				}
				if( cnt == 0 )
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");			
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			
            _bw.write(_wl_block58Bytes, _wl_block58);

		}
            _bw.write(_wl_block59Bytes, _wl_block59);

   sql1.setLength(0);

 }catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{
		if(con != null )
			 ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block60Bytes, _wl_block60);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdatetime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.currentlocation.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.ReasonForMovement.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdatetime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }
}
