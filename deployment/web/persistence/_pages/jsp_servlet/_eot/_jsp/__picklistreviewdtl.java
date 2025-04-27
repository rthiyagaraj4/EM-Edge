package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.CommonBean;

public final class __picklistreviewdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PickListReviewDtl.jsp", 1723530948000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="                              \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>                \n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../../eOT/js/OTCommon.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n<script language=\'javascript\'>\n//Added by MuthuN against CRF-268 Starts Here \n\nfunction hideToolTip(){\n  document.getElementById(\"tooltiplayer1\").style.visibility = \'hidden\';\n}\n\nfunction localTrimString(sInString) {\n\t  return sInString.replace(/[\\[\\]\']+/g,\"\");\n}\n\nfunction  reasonToolTip_pick(rownum,booking_num,oper_code){\n\tvar formObj = document.forms[0];\n    var formObj1= parent.parent.frames[1].frames[2].document.forms[0]\n\tvar facilityid=formObj.facilityid.value;\n\tvar surgeryDate = formObj.surgeryDate.value;\n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\txmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=pick_list_complete_status&facilityid=\"+facilityid+\"&surgeryDate=\"+surgeryDate+\"&booking_num=\"+booking_num+\"&oper_code=\"+oper_code,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText);\n\tvar arrMsg=retVal;\n\tvar arr=new Array();\n\tarr=arrMsg.split(\",\");\n\tvar cou=0;\n\tvar oper_proc_label=getLabel(\"eOT.PickListStatus.Label\",\"ot_labels\");\n\tvar tab_dat  = \"<table id =\'tooltiptable1\' cellpadding=\'3\' cellspacing=0 border=\'0\' class=\'BOX\' width=\'50%\' height=\'50%\' align=\'center\'>\";\n\tvar id_name_colval  =\'\';\n\tif(arr[0]==\"\" || arr[0]==null){\n\tid_name_colval  =oper_proc_label;\n\t}else{\n\tid_name_colval  = arr[0];\n\t}\n\ttab_dat     += \"<tr>\"\n\t//tab_dat     += \"<th   nowrap > <B>\"+id_name_colval + \" </B> </a> </th>\" //for testing\n\ttab_dat     += \"</tr> \";\n\n\tfor( cou=0;cou<arr.length;cou++){\n\t\tmsg=arr[cou];//- commented by MuthuN for testing\n\t\tvar msg1 = localTrimString(msg);//Added By MuthuN against CRF-268\n\t\ttab_dat     += \"<tr>\"\n\t\ttab_dat     += \"<td class=\'label\' > <B>\"+msg1+ \" </B> </a> </td>\"\n\t\ttab_dat     += \"</tr> \";\n\t}\n\ttab_dat     += \"</table> \";\n\tdocument.getElementById(\"tooltiplayer1\").innerHTML = tab_dat;\n\tresizeWindow1();\n}\n\nfunction resizeWindow1(){\n\tbodwidth = parent.frames[1].document.body.offsetWidth\n\tbodheight = parent.frames[1].document.body.offsetHeight\n\n\tvar x =event.x\n\tvar y =  event.y;\n\n\tx = x + (document.getElementById(\"tooltiplayer1\").offsetWidth)\n\ty = y + (document.getElementById(\"tooltiplayer1\").offsetHeight)\n\n\tif(x<bodwidth)\n\t\tx =event.x\n\telse\n\t\tx = x - (document.getElementById(\"tooltiplayer1\").offsetWidth*1)\n\n\tif(y<bodheight){\n\t\t y =event.y\n\t}else{\n\t\ty = y - (document.getElementById(\"tooltiplayer1\").offsetHeight*1)\n\t}\n\n\ty+=document.body.scrollTop\n\tx+=document.body.scrollLeft\n\n\tdocument.getElementById(\"tooltiplayer1\").style.posLeft= x\n\tdocument.getElementById(\"tooltiplayer1\").style.posTop = y\n\tdocument.getElementById(\"tooltiplayer1\").style.visibility=\'visible\'\n}\n//Added by MuthuN against CRF-268 Ends Here\n\nfunction callNoRecord()\n{\n\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n}\n\nfunction addNewItem(coun,highlightcnt)\n{\nvar frmObj=parent.parent.frames[1].frames[0];\nif(frmObj.isModify()==false)\n\t{\nvar obj=document.forms[0];\nvar patient_id=eval(\"obj.patient_id\"+coun+\".value\");\nvar locale=obj.locale.value;\nvar surgery_date=dateUtils(eval(\"obj.surgery_date\"+coun+\".value\"),locale);\nvar surgeoncode=eval(\"obj.surgeoncode\"+coun+\".value\");\nvar booking_no=eval(\"obj.booking_no\"+coun+\".value\");\nvar oper_code=eval(\"obj.oper_code\"+coun+\".value\");\nvar oper_room_code=eval(\"obj.oper_room_code\"+coun+\".value\");\nvar end=obj.endcnt.value;\n//Add by MuthuN against CRF -268\nvar cssd_doc_type = obj.cssd_doc_type.value;\nvar cssd_store_req = obj.cssd_store_req.value;\nvar cssd_store_ret = obj.cssd_store_ret.value;\n\tvar oddeven=\"\";\n\tfor(i=0;i<=end;i++)\n\t{\n\tif(i%2==0)\n\t{\n\t\toddeven=\'gridData\';\n\t}else{\n\t\toddeven=\'gridData\';\n\t}\n\n\t\t\n\t \tif((\"operdesc\"+i)==highlightcnt)\n\t\t{\n\t\t  eval(document.getElementById(\"date\"+i)).style.backgroundColor=\'#FF99FF\';\n\t\t  eval(document.getElementById(\"patname\"+i)).style.backgroundColor=\'#FF99FF\';\n\t\t  eval(document.getElementById(\"surgname\"+i)).style.backgroundColor=\'#FF99FF\';\n\t\t  eval(document.getElementById(\"booknum\"+i)).style.backgroundColor=\'#FF99FF\';\n\t\t  eval(document.getElementById(\"operdesc\"+i)).style.backgroundColor=\'#FF99FF\';\n\t\t  eval(document.getElementById(\"operroomdesc\"+i)).style.backgroundColor=\'#FF99FF\';\n\t\t}else\n\t\t{\n\t\t\tif(eval(document.getElementById(\"date\"+i)))\n\t\t\t{\n\t\t  eval(document.getElementById(\"date\"+i)).style.backgroundColor=\'\';\n\t\t  eval(document.getElementById(\"date\"+i)).className=oddeven\n\t\t\t}\nif(eval(document.getElementById(\"date\"+i)))\n\t\t\t{\n\t\t  eval(document.getElementById(\"patname\"+i)).style.backgroundColor=\'\';\n\t\t  eval(document.getElementById(\"patname\"+i)).className=oddeven\n    \t  eval(document.getElementById(\"surgname\"+i)).style.backgroundColor=\'\';\n\t\t  eval(document.getElementById(\"surgname\"+i)).className=oddeven\n\t\t  eval(document.getElementById(\"booknum\"+i)).style.backgroundColor=\'\';\n\t\t  eval(document.getElementById(\"booknum\"+i)).className=oddeven\n\t\t  eval(document.getElementById(\"operdesc\"+i)).style.backgroundColor=\'\';\n\t\t  eval(document.getElementById(\"operdesc\"+i)).className=oddeven\n\t\t  eval(document.getElementById(\"operroomdesc\"+i)).style.backgroundColor=\'\';\n\t\t  eval(document.getElementById(\"operroomdesc\"+i)).className=oddeven\n\t\t\t}\n\n\t\t}\n\t}\n//var param=\"patient_id=\"+patient_id+\"&surgery_date=\"+surgery_date+\"&surgeoncode=\"+surgeoncode+\"&booking_no=\"+booking_no+\"&oper_code=\"+oper_code+\"&oper_room_code=\"+oper_room_code;\n\nvar param=\"patient_id=\"+patient_id+\"&surgery_date=\"+surgery_date+\"&surgeoncode=\"+surgeoncode+\"&booking_no=\"+booking_no+\"&oper_code=\"+oper_code+\"&oper_room_code=\"+oper_room_code+\"&cssd_doc_type=\"+cssd_doc_type+\"&cssd_store_req=\"+cssd_store_req+\"&cssd_store_ret=\"+cssd_store_ret;\n\nvar from_val=parent.parent.frames[1].frames[1].document.forms[0].from_val.value;\nparent.parent.frames[1].location.href=\"../../eOT/jsp/PickListReviewItemFrame.jsp?\"+param+\"&from_val=\"+from_val;\n\t}\n\telse\n\t{\n\t\talert(\"Finalize already selected data\");\n\t}\n}\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<form name=\'picklistReviewDtl\' id=\'picklistReviewDtl\' action=\'\' method = \'post\'>\n<table  border=\'1\' width=\'100%\' cellpadding=3  cellspacing=0>\n<tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<!-- Added By MuthuN against CRF - 268 Starts -->\n\t<td class=\'columnHeader\'></td>\n<!-- Added By MuthuN against CRF - 268 Ends -->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<input type=\'hidden\' name=\'booking_num";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'booking_num";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n </table>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<!-- Added By MuthuN against CRF - 268 Starts -->\n\n<input type=\'hidden\' name=\'booking_num\' id=\'booking_num\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\'hidden\' name=\'patient_id_pick\' id=\'patient_id_pick\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\'hidden\' name=\'surgeryDate\' id=\'surgeryDate\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\'hidden\' name=\'cssd_doc_type\' id=\'cssd_doc_type\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\'hidden\' name=\'cssd_store_req\' id=\'cssd_store_req\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\'hidden\' name=\'cssd_store_ret\' id=\'cssd_store_ret\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<!-- Added newly by MuthuN against CRF-268 Ends -->\n </form>\n <!-- Added By MuthuN against CRF - 268 Starts -->\n\t\t<div name=\'tooltiplayer1\' id=\'tooltiplayer1\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\' ></div>\n\t \t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t</div>\n<!-- Added By MuthuN against CRF - 268 Ends -->\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
 
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String facilityid=(String)session.getValue("facility_id");
	Connection conn=null;
	PreparedStatement pstmt=null;	
	ResultSet rs=null;
	ResultSet rs2=null;//Added By MuthuN CRF-268
	Statement stmt2=null;//Added By MuthuN CRF-268
	PreparedStatement pstmt1=null;	
	ResultSet rs1=null;
	String ot_Param="";
	//Added By MuthuN CRF-268
	String sql_pick_param ="";
	String cssd_doc_type ="";
	String cssd_store_req ="";
	String cssd_store_ret ="";

	//Added newly by MuthuN against CRF-268 Starts
 sql_pick_param ="select CSSD_DOC_TYPE_REQ, CSSD_STORE_REQ, CSSD_STORE_RET from OT_PARAM_FOR_FACILITY where operating_facility_id ='"+facilityid+"'";
	try{
			conn=ConnectionManager.getConnection(request);
			stmt2 = conn.createStatement();
			rs2 = stmt2.executeQuery(sql_pick_param);
			if (rs2!= null && rs2.next())
			{
				cssd_doc_type=checkForNull(rs2.getString(1));
				cssd_store_req=checkForNull(rs2.getString(2));
				cssd_store_ret=checkForNull(rs2.getString(3));
			}
		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();
		}finally{
			try{
			if(rs2!=null)       rs2.close();
			if(stmt2!=null)       stmt2.close();
			if(conn!=null)  ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}


	String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";
	try{
			conn=ConnectionManager.getConnection(request);
			pstmt = conn.prepareStatement(sqlOtParam);
		pstmt.setString(1,facilityid);
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
		{
			ot_Param=rs.getString("facility");
		}		
		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();
		}finally{
			try{
			if(rs!=null)       rs.close();
			if(pstmt!=null)       pstmt.close();
			if(conn!=null)  ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}	
//Added newly by MuthuN against CRF-268 Ends


            _bw.write(_wl_block9Bytes, _wl_block9);

if("Y".equalsIgnoreCase(ot_Param)){

            _bw.write(_wl_block10Bytes, _wl_block10);
}
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
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	/*String facilityid=(String)session.getValue("facility_id");
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;*/		
	Statement stmt=null;
	ResultSet rs_oper_room=null;
	String sql="";
	String strQuery="";
	String strPatientId="";
	String strSurgeryDate="";
	String strPatientName="";
	String strSurgeonCode="";
	String strSurgeonName="";
	String strBookingNum="";
	String strOperCode="";
	String strOperDesc="";
	String sql_oper_room="";
	String oper_room_code="";
	String oper_room_desc="";

//Added by lakshmi for CRF-0146
String strPatientIdFltr=checkForNull(request.getParameter("patient_id"));
String strFacilityId=checkForNull(request.getParameter("facility_id"));
String strSourceType=checkForNull(request.getParameter("source_type"));
String strSourceCode=checkForNull(request.getParameter("source_code"));

int fetchCount=0;

try{
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();

//Modified by lakshmi against CRF-0146 starts here
if((strPatientIdFltr.length()==0)&&(strSourceCode.length()==0)){
	sql = "SELECT PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = OT_PICK_LIST_VW.patient_id )  PATIENT_NAME1,to_char( SURGERY_DATE,'dd/mm/yyyy') SURGERY_DATE1,  nvl(SURGEON_CODE,'*ALL') SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1, BOOKING_NUM BOOKING_NUM1,OPER_CODE OPER_CODE1, OPER_DESC OPER_DESC1 FROM OT_PICK_LIST_VW WHERE OPERATING_FACILITY_ID = ? and trunc(SURGERY_DATE) >= trunc(sysdate) and language_id='"+locale+"' ORDER BY  SURGERY_DATE1,BOOKING_NUM1";
}
else if((strPatientIdFltr.length()!=0)&&(strSourceCode.length()==0)){
	sql = "SELECT PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = OT_PICK_LIST_VW.patient_id )  PATIENT_NAME1,to_char( SURGERY_DATE,'dd/mm/yyyy') SURGERY_DATE1,  nvl(SURGEON_CODE,'*ALL') SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1, BOOKING_NUM BOOKING_NUM1,OPER_CODE OPER_CODE1, OPER_DESC OPER_DESC1 FROM OT_PICK_LIST_VW WHERE OPERATING_FACILITY_ID = ? and PATIENT_ID='"+strPatientIdFltr+"'and trunc(SURGERY_DATE) >= trunc(sysdate) and language_id='"+locale+"' ORDER BY  SURGERY_DATE1,BOOKING_NUM1";
}
/*else if((strPatientIdFltr.length()!=0)&&(strSourceCode.length()!=0)){
	sql = "SELECT PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = OT_PICK_LIST_VW.patient_id )  PATIENT_NAME1,to_char( SURGERY_DATE,'dd/mm/yyyy') SURGERY_DATE1,  nvl(SURGEON_CODE,'*ALL') SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1, BOOKING_NUM BOOKING_NUM1,OPER_CODE OPER_CODE1, OPER_DESC OPER_DESC1 FROM OT_PICK_LIST_VW WHERE OPERATING_FACILITY_ID = ? and PATIENT_ID='"+strPatientIdFltr+"' and SOURCE_TYPE='"+strSourceType+"' and SOURCE_CODE='"+strSourceCode+"'and trunc(SURGERY_DATE) >= trunc(sysdate) and language_id='"+locale+"' ORDER BY  SURGERY_DATE1,BOOKING_NUM1";
}*/
else if((strPatientIdFltr.length()==0)&&(strSourceCode.length()!=0)){
	if (strSourceType.equals("W")== true || strSourceType.equals("N")== true) 
	{
	sql = "SELECT PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = OT_PICK_LIST_VW.patient_id )  PATIENT_NAME1,to_char( SURGERY_DATE,'dd/mm/yyyy') SURGERY_DATE1,  nvl(SURGEON_CODE,'*ALL') SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1, BOOKING_NUM BOOKING_NUM1,OPER_CODE OPER_CODE1, OPER_DESC OPER_DESC1 FROM OT_PICK_LIST_VW WHERE OPERATING_FACILITY_ID = ? and SOURCE_TYPE IN ('W','N')  and SOURCE_CODE='"+strSourceCode+"'and trunc(SURGERY_DATE) >= trunc(sysdate) and language_id='"+locale+"' ORDER BY  SURGERY_DATE1,BOOKING_NUM1";
	}
	else
	{
	sql = "SELECT PATIENT_ID PATIENT_ID1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = OT_PICK_LIST_VW.patient_id )  PATIENT_NAME1,to_char( SURGERY_DATE,'dd/mm/yyyy') SURGERY_DATE1,  nvl(SURGEON_CODE,'*ALL') SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1, BOOKING_NUM BOOKING_NUM1,OPER_CODE OPER_CODE1, OPER_DESC OPER_DESC1 FROM OT_PICK_LIST_VW WHERE OPERATING_FACILITY_ID = ? and SOURCE_TYPE ='"+strSourceType+"' and SOURCE_CODE='"+strSourceCode+"'and trunc(SURGERY_DATE) >= trunc(sysdate) and language_id='"+locale+"' ORDER BY  SURGERY_DATE1,BOOKING_NUM1";
	}

}
//Modified by lakshmi against CRF-0146 ends here

     pstmt=conn.prepareCall(sql);
	 pstmt.setString(1,facilityid);
	 rs=pstmt.executeQuery();
while(rs.next())
{
	fetchCount++;
strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
strPatientName=CommonBean.checkForNull(rs.getString("PATIENT_NAME1"));
//strSurgeryDate=CommonBean.checkForNull(rs.getString("SURGERY_DATE1"));
strSurgeryDate=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("SURGERY_DATE1"),"DMY","en",locale));
strSurgeonCode=CommonBean.checkForNull(rs.getString("SURGEON_CODE1"));
strSurgeonName=CommonBean.checkForNull(rs.getString("SURGEON_NAME1"));	strBookingNum=CommonBean.checkForNull(rs.getString("BOOKING_NUM1"));
strOperDesc=CommonBean.checkForNull(rs.getString("OPER_DESC1"));
strOperCode=CommonBean.checkForNull(rs.getString("OPER_CODE1"));

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strBookingNum));
            _bw.write(_wl_block17Bytes, _wl_block17);

	//Added Newly for Icon Disable on 12/28/2012
	int count_val=0;
	String sqlPickList_Status = "SELECT count(*) FROM ot_pick_lists WHERE booking_num = '"+strBookingNum+"' AND OPER_CODE = '"+strOperCode+"' AND operating_facility_id = '"+facilityid+"' AND surgery_date = TO_DATE (?, 'dd/mm/yyyy') and (item_type='I' or item_type='P') and (nvl(cssd_status,'X') <>'F')";
	try{
//			conn=ConnectionManager.getConnection(request); //Perf issue 05Dec
			pstmt1 = conn.prepareStatement(sqlPickList_Status);
			pstmt1.setString(1, strSurgeryDate);
			rs1=pstmt1.executeQuery();
		if(rs1 !=null && rs1.next())
		{
			count_val=rs1.getInt(1);
		}	
		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(rs1!=null) rs1.close();	
			if(pstmt1 != null) pstmt1.close();
// 			if(conn!=null)  ConnectionManager.returnConnection(conn,request); Perf issue 05Dec
			//ConnectionManager.returnConnection(conn,request);
			}
//Added Newly for Icon Disable on 12/28/2012

	sql_oper_room="SELECT a.OPER_ROOM_CODE, b.SHORT_DESC FROM OT_booking_hdr a, OT_OPER_ROOM_LANG_VW b WHERE a.OPER_ROOM_CODE=b.OPER_ROOM_CODE  and  a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID AND b.OPERATING_FACILITY_ID = '"+facilityid+"'  AND a.BOOKING_NUM='"+strBookingNum+"' and b.LANGUAGE_ID='"+locale+"'";
		rs_oper_room=stmt.executeQuery(sql_oper_room);

		if(rs_oper_room !=null && rs_oper_room.next())
		{
			oper_room_code=rs_oper_room.getString("OPER_ROOM_CODE");
			if(oper_room_code ==null) oper_room_code="";
			oper_room_desc=rs_oper_room.getString("SHORT_DESC");
			if(oper_room_desc ==null) oper_room_desc="";
		}

// Modified by DhanasekarV on 1/8/2011
		if(rs_oper_room!=null)rs_oper_room.close();		
if(fetchCount%2==0)	
	strQuery="class='gridData'";
else
	strQuery="class='gridData'";


out.println("<tr>");
//Added By MuthuN against CRF-268 
if("Y".equalsIgnoreCase(ot_Param)){
	if(count_val > 0){
	out.println("<td><img src='../../eOT/images/picklist.png' class='img' name='img1' OnMouseOver=\"reasonToolTip_pick('"+fetchCount+"','"+strBookingNum+"','"+strOperCode+"')\" onmouseout=\"hideToolTip()\"></td>");
	}else{
		out.println("<td></td>");
	}
}
//Added By MuthuN against CRF - 268
out.println("<td "+strQuery+"  id='date"+fetchCount+"'  class='"+strQuery+"'  align='left'>"+strSurgeryDate+"</td>");
out.println("<td "+strQuery+"  id='patname"+fetchCount+"'  class='"+strQuery+"'  align='left'>"+strPatientName+"</td>");

out.println("<td "+strQuery+"  id='surgname"+fetchCount+"'  class='"+strQuery+"'  align='left'>"+strSurgeonName+"</td>");

out.println("<td "+strQuery+"  id='booknum"+fetchCount+"'  class='"+strQuery+"'  align='left'>"+strBookingNum+"</td>");

out.println("<td  "+strQuery+"  id='operdesc"+fetchCount+"'  class='"+strQuery+"'   onClick=\"addNewItem('"+fetchCount+"','operdesc"+fetchCount+"')\"  nowrap><font class='HYPERLINK' style='font-size:7pt;color:blue;cursor:pointer;font-weight:normal'> "+strOperDesc+"</font></td>");

out.println("<td "+strQuery+"  id='operroomdesc"+fetchCount+"'   class='"+strQuery+"'  align='left'>"+oper_room_desc+"</td>");

out.println("<input type='hidden' name='patient_id"+fetchCount+"' id='patient_id"+fetchCount+"' value='"+strPatientId+"'>");
out.println("<input type='hidden' name='surgery_date"+fetchCount+"' id='surgery_date"+fetchCount+"'  value='"+strSurgeryDate+"'>");
out.println("<input type='hidden' name='surgeoncode"+fetchCount+"' id='surgeoncode"+fetchCount+"'  value='"+strSurgeonCode+"'>");
out.println("<input type='hidden' name='booking_no"+fetchCount+"' id='booking_no"+fetchCount+"' value='"+strBookingNum+"'>");
out.println("<input type='hidden' name='oper_code"+fetchCount+"' id='oper_code"+fetchCount+"'  value='"+strOperCode+"'>");
out.println("<input type='hidden' name='oper_room_code"+fetchCount+"' id='oper_room_code"+fetchCount+"'  value='"+oper_room_code+"'>");
out.println("</tr>");
	}
out.println("<input type='hidden' name='endcnt' id='endcnt'  value='"+fetchCount+"'>");
if(fetchCount==0)
	out.println("<script>callNoRecord();</script>");
if(stmt !=null) stmt.close();
if(rs_oper_room !=null) rs_oper_room.close();
}catch(Exception ee)
{

}
finally
{
	if(rs!=null) rs.close();	
	pstmt.close();
	if(conn!=null)  ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strBookingNum));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strPatientIdFltr));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strSurgeryDate));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(cssd_doc_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cssd_store_req));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(cssd_store_ret));
            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SurgeryDate.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.BookingNumber.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OperatingRoom.label", java.lang.String .class,"key"));
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
}
