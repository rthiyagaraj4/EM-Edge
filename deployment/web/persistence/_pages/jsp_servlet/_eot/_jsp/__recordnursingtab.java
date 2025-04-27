package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import eOT.Common.*;
import eCommon.Common.CommonBean;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __recordnursingtab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/RecordNursingTab.jsp", 1743149396779L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/Tabs.css\"></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n</head>\n<script language=\"javascript\">\nasync function callOperativeNotes(){\n\tvar formObj =  parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n\tvar formObjDtl = document.RecordNursingTabForm;\n\tvar slate_user_id = formObjDtl.slate_user_id.value;\n\tvar title=getLabel(\"eOT.NursingNotes.Label\",\"OT\");\n\tvar facility_id = formObj.facility_id.value;//1\n\tvar patient_id = formObj.patient_id.value;//2\n\tvar episode_id = formObj.episode_id.value;//3\n\tvar patient_class = formObj.patient_class.value;//4\n\tvar encounter_id = formObj.encounter_id.value;//5\n\tvar called_from = \"OPERATIVE_NOTES\";//6\n\tvar accession_num=formObj.oper_num.value;//7\n\tvar speciality_code=formObj.oper_speciality_code.value;//8\n\t//if(speciality_code==\"*ALL\") speciality_code=\"ALL\";\n\tvar locn_type = \"\";//from OPERATIVE_NOTES Locn type=NULL;\n\tvar url = \"../../eOT/jsp/SelectNoteTypeFrames.jsp?\"+ \"facility_id=\"+facility_id+\"&patient_id=\"+patient_id+\"&episode_id=\"+episode_id+\"&patient_class=\"+patient_class+\"&encounter_id=\"+encounter_id+\"&called_from=\"+called_from+\"&accession_num=\"+accession_num+\"&speciality_code=\"+speciality_code+\"&locn_type=\"+locn_type+\"&slate_user_id=\"+slate_user_id;\n\tvar retVal;\n\tvar dialogHeight = \"5\";\n    var dialogWidth  = \"20\";\n    var dialogTop    = \"200\";\n    var dialogLeft   = \"200\";\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" + dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no\" ;\n\tvar arguments    = \"\" ;\n\tretVal \t   = await window.showModalDialog(url, arguments, features);\n}\n\nfunction changeTab(objStr){\n\tselectTab(objStr);\n\tvar frmObj=document.forms[0];\n\tvar param=frmObj.param.value;\n\tif(objStr==\'OperationDetails\' && parent.RecordFrame!=null ){\n\t\tparent.RecordFrame.location.href=\'../../eOT/jsp/ProcedureFrames.jsp?\'+param;\n\t\t//parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t}else if(objStr==\'PersonnelDetails\' && parent.RecordFrame!=null ){\n\t\t//parent.RecordFrame.location.href=\'../../eOT/jsp/PersonnelFrames.jsp?\'+param;\n\t\tparent.RecordFrame.location.href=\'../../eOT/jsp/PersonnelCommonFrames.jsp?\'+param;\n\t\t//parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t}else if(objStr==\'TimeAndDetails\' && parent.RecordFrame!=null ){\n\t\tparent.RecordFrame.location.href=\'../../eOT/jsp/TimeDtlsFrames.jsp?\'+param+\"&tab_id=TimeAndDetailsTab\";\n\t\t//parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t}/*else if(objStr==\'Operative Records\'){\n\t   alert(\"U N D E R C O N S T R U C T I O N\");\n\t}*/else if(objStr==\'SpecimenDetails\' && parent.RecordFrame!=null){\n\t  parent.RecordFrame.location.href=\'../../eOT/jsp/SpecimenFrames.jsp?\'+param;\n\t  //parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t}else if(objStr==\'DisposalDetails\' && parent.RecordFrame!=null){\n\t   parent.RecordFrame.location.href=\'../../eOT/jsp/NursingDisposalFrames.jsp?\'+param;\n\t   //parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t}\n\tif(parent.parent.messageFrame!=null)\n\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n}\n\nfunction Class_personnelrow()\n{\n\t this.speciality_code=\"\";\n\t this.speciality_desc=\"\";\n\t this.role_id =\"\";\n\t this.role_desc =\"\";\n\t this.role_type=\"\";\n\t this.practitioner_id=\"\";\n\t this.practitioner_name=\"\";\n\t this.position_desc=\"\";\n\t this.db_mode=\"\";\n\t this.recId =\"\";\n}\nfunction loadRoleDBRows(speciality_code,speciality_desc,role_id,role_desc,practitioner_id,practitioner_desc,recId,role_type,position_desc,mode){ \n\t  var objrow = newRow();\n\t  var rows=parent.parent.parent.ObjectCollect.personnelrows;\n\t  var rowLength=parent.parent.parent.ObjectCollect.personnelrowLength;\n\t   if(rowLength==0){\n\t\t  objrow.speciality_code = speciality_code;\n\t\t  objrow.speciality_desc= speciality_desc;\n\t\t  objrow.role_id= role_id;\n\t\t  role_desc = role_desc; //Added Against SKR-SCF-1584\n\t\t  objrow.role_desc= unescape(role_desc);\n\t\t  objrow.practitioner_id= practitioner_id;\n\t\t  objrow.practitioner_name=unescape(practitioner_desc);\n\t\t  objrow.role_type=role_type;\n\t\t  objrow.position_desc=unescape(position_desc);\n\t\t  objrow.db_mode=mode;\n\t\t  objrow.recId=recId;\n\t\t  rows.push(objrow);\n\t\t}\n}\nfunction newRow()\n{\n\tvar objrow = new Class_personnelrow();\n\t//\tif(typeof(parent.parent.parent.ObjectCollect) != \"undefined\" || parent.parent.parent.ObjectCollect != \'\' || parent.parent.parent.ObjectCollect != null)\n\tif(typeof(parent.parent.parent.ObjectCollect) != \"undefined\" && parent.parent.parent.ObjectCollect != \'\' && parent.parent.parent.ObjectCollect != null) //Modified Against SKR-SCF-1584\n\t{\n\t\tif(typeof(parent.parent.parent.ObjectCollect.personnelrows) != \"undefined\" && parent.parent.parent.ObjectCollect.personnelrows != \'\' && parent.parent.parent.ObjectCollect.personnelrows != null)\n\t\t\tobjrow.recId = parent.parent.parent.ObjectCollect.personnelrows.length+1;\n\t\telse\n\t\t\tsetTimeout(\'newRow()\',500);\n\t}\n\telse\n\t{\n\t\tsetTimeout(\'newRow()\',500);\n\t}\n\treturn(objrow);\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onload=\'loadOthrFrames();\'> <!-- Onload Function Added Against SKR-SCF-1584-->\n<form name=\"RecordNursingTabForm\" id=\"RecordNursingTabForm\">\n\t<table id=\"tab\" cellspacing=0 cellpadding=3 border=\"0\" width=\'100%\' align=\'center\'>\n\t<tr>\n\t\t<td width=\"100%\" class=\"white\">\n\t\t\t<ul id=\'tablist\' class=\'tablist\'>\n\t\t\t\t<li class=\'tablistitem\' title=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t\t\t<a onclick=\"changeTab(\'OperationDetails\')\" class=\"tabclicked\" id=\"OperationDetails\">\n\t\t\t\t\t\t<span class=\"tabSpanclicked\" id=\"OperationDetailsspan\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span></a>\n\t\t\t\t</li>\n\t\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t<a onclick=\"changeTab(\'PersonnelDetails\')\" class=\"tabA\" id=\"PersonnelDetails\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"PersonnelDetailsspan\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t\t<a onclick=\"changeTab(\'TimeAndDetails\')\" class=\"tabA\" id=\"TimeAndDetails\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"TimeAndDetailsspan\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t\t\t<a onclick=\"changeTab(\'SpecimenDetails\')\" class=\"tabA\" id=\"SpecimenDetails\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"SpecimenDetailsspan\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t\t<a onclick=\"changeTab(\'DisposalDetails\')\" class=\"tabA\" id=\"DisposalDetails\">\n\t\t\t\t\t\t<span class=\"tabAspan\" id=\"DisposalDetailsspan\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span></a>\n\t\t\t\t</li>\n\t\t\t</ul>\n\t\t</td>\n\t\t<!--<td align=\"right\" cellspacing=\"0\" cellpadding=3=\"0\">\n\t\t\t<input type=\"button\" class=\"button\" value=\"Nursing Notes\" name=\"nursing_notes\" id=\"nursing_notes\" onclick=\"callOperativeNotes();\">\n\t\t</td>-->\n\t\t<!-- <td class=\"fields\" cellspacing=\"0\" cellpadding=3>\n\t\t\t<input type=\"button\" class=\"button\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' name=\"operative_records\" onclick=\"callOperativeNotes();\">\n\t\t</td> Commented by Sathish.K on 13-03-2009 for Amazonchanges this button is transferred to CommonOperDtlsHdr.jsp as a hyperlink showing  there-->\n\t</tr>\n</table>\n<input type=\'hidden\' name=\'param\' id=\'param\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' name=\'doc_oper_line_sent\' id=\'doc_oper_line_sent\' value=\'\'>\n<input type=\'hidden\' name=\'Speciality_code_val\' id=\'Speciality_code_val\' value=\'\'>\n<!-- Added for CHL-CRF-0020.1 [IN:043132] -->\n<input type=\'hidden\' name=\'disp_hosp\' id=\'disp_hosp\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<!-- The below line is required to change the select state of Initial tab selected -->\n<script>prevTabObj=\'OperationDetails\'</script>\n<script>\nfunction loadOthrFrames()//Added Against SKR-SCF-1584\n{\n\tvar params = document.forms[0].param.value;\n\tparent.RecordFrame.location.href=\"../../eOT/jsp/ProcedureFrames.jsp?\"+params;\n\tparent.doc_status_frame.location.href=\"../../eOT/jsp/SurgeonDocStatus.jsp?\"+params;\n}\n</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}

 
	String encode(String data){	  
	byte byteData[] = data.getBytes();
	String outDat = "";
	for (int i=0; i<byteData.length; i++)
	{
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	}
		return(outDat);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String facility_id = checkForNull(request.getParameter("facility_id"));
		String oper_num = checkForNull(request.getParameter("oper_num"));
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		//Added for CHL-CRF-0020.1 [IN:043132]
		PreparedStatement pstmt_hosp = null;
		ResultSet rst_hosp = null;
		String disp_hosp ="";
		//Added for CHL-CRF-0020.1 [IN:043132]
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection();
			//Added for CHL-CRF-0020.1 [IN:043132]
			String disp_hosp_sql = "select DISPLAY_HOSPITAL_YN from OT_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID =?";
				pstmt_hosp = con.prepareStatement(disp_hosp_sql);
				pstmt_hosp.setString(1, facility_id);
				rst_hosp = pstmt_hosp.executeQuery();
				while(rst_hosp.next()){
					disp_hosp=rst_hosp.getString(1);
				}
				if(rst_hosp!=null)rst_hosp.close();
				if(pstmt_hosp!=null)pstmt_hosp.close();
				//Added for CHL-CRF-0020.1 [IN:043132]
				pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2"));
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,oper_num);
				rst = pstmt.executeQuery();
				int index = 0;
				while(rst.next())
				{
					index++;
					Thread.sleep(1000);	 //Added against SKR-SCF-1596
					out.println("<script>loadRoleDBRows('"+rst.getString("SPECIALITY_CODE")+"','"+rst.getString("SPECIALITY_DESC")+"','"+rst.getString("ROLE_ID") +"','"+(rst.getString("ROLE_DESC"))+"','"+rst.getString("PRACTITIONER_ID")+"','"+rst.getString("PRACTITIONER_NAME")+"','"+index+"','"+rst.getString("ROLE_TYPE")+"','"+encode(CommonBean.checkForNull(rst.getString("POS_DESC")))+"','L'); </script>");
				}
				if(rst!=null)
					rst.close();
				if(pstmt!=null)
					pstmt.close();
				if(index == 0 && disp_hosp.equals("Y"))
				{
					String SQL2 = "SELECT SURGEON_CODE, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',SURGEON_CODE) " +  
						"PRACTITIONER_NAME, ANESTHETIST_CODE, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ANESTHETIST_CODE) " + 
						"ANAESTHETIST_NAME, SPECIALITY_CODE, GET_DESC(?,'AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',SPECIALITY_CODE) SPECIALITY_DESC, " + 
						"ASST_SURGEON_CODE,  GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE) " + 
						" ASST_SURGEON_NAME, ASST_SURGEON_CODE_2, GET_DESC(?,'AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE_2) " + 
						"ASST_SURGEON_NAME_2  FROM OT_POST_OPER_HDR HDR WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM =  ?";

					String ROLE_SQL = "SELECT ROLE_DESC, ROLE_ID, ROLE_TYPE FROM OT_ROLES_LANG_VW WHERE LANGUAGE_ID= ? AND ROLE_TYPE IN ('OS', 'MA', 'AS')"
							+ "AND NVL(APPL_TO_OT_SLATE,'N') = 'N' AND NVL(STATUS,'E') = 'E'";
					pstmt1 = con.prepareStatement(ROLE_SQL);
					pstmt1.setString(1, locale);
					rst1 = pstmt1.executeQuery();
					if(pstmt!=null)
						pstmt.close();
					pstmt = con.prepareStatement(SQL2);
					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,locale);
					pstmt.setString(6,facility_id);
					pstmt.setString(7,oper_num);
					rst = pstmt.executeQuery();
					index = 0;
					//count of 
					int surgCount = 0;
					int anasCount = 0;
					int assSurgCount = 0;
					if(rst.next())
					{
						while(rst1.next() )
						{
							String roleId = rst1.getString("ROLE_TYPE");
							String specCode = rst.getString("SPECIALITY_CODE");
							String specDesc = rst.getString("SPECIALITY_DESC");
							String surgCode = rst.getString("SURGEON_CODE");
							//if( disp_hosp.equals("Y")){//Added for CHL-CRF-0020.1 [IN:043132]
							if("OS".equals(roleId) && surgCode != null && (surgCount == 0))
							{
								index++;
								surgCount++;
								Thread.sleep(1000);	 //Added against SKR-SCF-1744
								out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
										+"','"+rst1.getString("ROLE_DESC")+"','" + surgCode +"','" 
										+rst.getString("PRACTITIONER_NAME")+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"', '', 'I'"
										+ "); </script>");
							}
							//}//Added for CHL-CRF-0020.1 [IN:043132]
							String asstSurgCode = rst.getString("ASST_SURGEON_CODE"); 
							if("AS".equals(roleId) && asstSurgCode != null && assSurgCount <= 1)
							{
								index++;
								assSurgCount++;
								Thread.sleep(1000);	 //Added against SKR-SCF-1744
								out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
								+"','"+(rst1.getString("ROLE_DESC"))+"','"+ asstSurgCode +"','" 
								+encode(rst.getString("ASST_SURGEON_NAME"))+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"', '', 'I'"
								+ "); </script>");
							}
							asstSurgCode = rst.getString("ASST_SURGEON_CODE_2"); 
							if("AS".equals(roleId) && asstSurgCode != null && assSurgCount <= 1)
							{
								index++;
								assSurgCount++;
								Thread.sleep(1000);	 //Added against SKR-SCF-1744
								out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
								+"','"+(rst1.getString("ROLE_DESC"))+"','"+ asstSurgCode +"','" 
								+ encode(rst.getString("ASST_SURGEON_NAME_2"))+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"', '', 'I'"
								+ "); </script>");
							}
							String anansCode = rst.getString("ANESTHETIST_CODE");
							if("MA".equals(roleId) && anansCode != null && anasCount == 0)
							{
								index++;
								anasCount++;
								Thread.sleep(1000);	 //Added against SKR-SCF-1744
								out.println("<script>loadRoleDBRows('"+ specCode +"','"+ specDesc +"','"+rst1.getString("ROLE_ID") 
								+"','"+(rst1.getString("ROLE_DESC"))+"','"+ anansCode +"','" 
								+ encode(rst.getString("ANAESTHETIST_NAME"))+"','"+index+"','"+rst1.getString("ROLE_TYPE")+"','', 'I'"
								+ "); </script>");
							}
						//	}//Added for CHL-CRF-0020.1 [IN:043132]
						}
					}
			}			
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from RecordSurgeonTab.jsp "+e);
		}finally{
			if(rst!=null)rst.close();
			if(rst1!=null)rst1.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(request.getParameter("slate_user_id")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disp_hosp));
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationDetails.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationDetails.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PersonnelDetails.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PersonnelDetails.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TimeandDetails.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TimeandDetails.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecimenDetails.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecimenDetails.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DisposalDetails.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DisposalDetails.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperativeRecords.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
