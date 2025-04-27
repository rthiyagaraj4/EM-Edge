package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aemanagepatgiwaitlistresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEManagePatGIWaitListResult.jsp", 1737911822303L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n<html>\n<meta http-equiv=\"REFRESH\" content=\"600\">\n\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEUtilities.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEManagePatientGI.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t<script>\n\t\t\tvar tab= parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.tabIndicator.value;\n\t\t\tif(tab==\'others_tab\')\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<body  onMouseDown=\"CodeArrest()\" class=\'CONTENT\' onKeyDown = \"lockKey()\"onScroll = \'scrollTitle()\' >\n<center>\n\t\t\n<form name=\'AEMPSearchResultForm\' id=\'AEMPSearchResultForm\' onLoad=\'callShowQueryResult();\'>\n\t\t\n<div  id=\'msg\' style=\"position:absolute;width: 0; height: 0; left: 201; top: 62\">\n</div>\n\n<div  id=\'divTitleTable\' width=\'100%\' >\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' id=\'TitleTab\'>\n<tr >\n<td class=\'LABEL\' align=\'left\' nowrap >&nbsp;</td>\n<td class=\'QueryData\' align=\'left\' nowrap >&nbsp;</td>\n</tr>\n</table>\n<table  id=\'th_table\'  cellpadding=\'0\' cellspacing=\'0\' border=1  width=\'100%\'>\n\n<tr>\n<th width=\"5%\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'selectGif\' style=\'visibility:hidden\'></th>\n<th  width=\"10%\">&nbsp;&nbsp;&nbsp;</th> \n<th width=\"15%\" onclick =\"sort(\'queueDate\');\"  style=\'cursor:pointer\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'dateGif\' style=\'visibility:hidden\'></th> \n<th width=\"20%\" onclick =\"sort(\'patientName\');\"  style=\'cursor:pointer\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'patNameGif\' style=\'visibility:hidden\'></th> \n<th width=\"20%\" onclick =\"sort(\'patientId\');\" style=\'cursor:pointer\'  nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'patIdGif\' style=\'visibility:hidden\'></th> \n<th width=\"10%\" onclick =\"sort(\'waitingTime\');\" style=\'cursor:pointer\'   nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'waitTimeGif\' style=\'visibility:hidden\'></th> \n<th width=\"20%\" onclick =\"sort(\'locType\');\"  style=\'cursor:pointer\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<img src=\'../../eAE/images/Ascending.gif\'  border=none  align=right name=\'locTypeGif\' style=\'visibility:hidden\'></th>\n\t</tr>\n</table>\n</div>\n<table border=\'1\'  style=\'border-bottom:#ffffff\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' id=\'tb1\'>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<tr>\n\t\t\t<th colspan=10 align=\'left\'  nowrap><font size=1>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t </tr> \n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\n\t\t\t<tr id=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\t\n\t\t\n\t\t <td width=\"5%\" class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' align=middle><font size=1>\n   ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n    <input type=\"checkbox\" name=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="*";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onclick=\"check_checked(this,\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\')\" disabled>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n<input type=\"checkbox\" name=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\" checked >\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\" >\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \n</td>\n\n\t\t\t<td width=\"10%\" class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" style=\"background-color:";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">&nbsp;</td>\n\t\t\t\n\t\t\t<td width=\"15%\" ondblclick =\"sort(\'queueDate\');\" nowrap class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'><font size=1>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<td width=\"20%\" ondblclick =\"sort(\'patientName\');\" class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' nowrap>\n\t\t\t\t\n\t\t\t\t<a name=\"desc";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" onMouseover=\"onMMove(msg,event,\'Brought Dead Patient\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');\" onMouseout=\"onMOut(msg,\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');\" href=\"javascript:DummyRef()\"\n\t\t\tonClick=\"showAllowedOperationsGraphic(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\', \'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' , \'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\" >\n\t\t\t\t\n\t\t\t<font size=1>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</font></a></td>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t<td width=\"20%\" ondblclick =\"sort(\'patientName\');\"  nowrap class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'><a name=\'desc";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'onMouseover=\"onMMove(msg,event,\'Brought Dead Patient\',\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\');\"   href=\'javascript:DummyRef()\' \n\t\t\tonClick=\" CallViewPatDetails1(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\" ><font size=1>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a></td>\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n\t\t\t\t<td  width=\"20%\" ondblclick =\"sort(\'patientName\');\" nowrap class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\');\"\n\t\t\t\n\t\t\tonMouseout=\"onMOut(msg,\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');\" href=\'javascript:LoadChkOut( \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\",\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\",\"\",\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\")\' > <font size=1>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</a></td>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t<td  width=\"20%\" ondblclick =\"sort(\'patientName\');\" nowrap class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\');\" href=\'javascript:DummyRef()\' \n\t\t\t\t\tonClick=\" CallViewPatDetails1(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\');\"> <font size=1>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\n\t\t\t<td width=\"20%\" ondblclick =\"sort(\'patientId\');\" class=\'AEDECEASED\'><font size=1>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\n\t\t\t<td  width=\"20%\" ondblclick =\"sort(\'patientId\');\" class=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\n\t\t\t\t<td width=\"10%\" ondblclick =\"sort(\'waitingTime\');\"  nowrap class=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'  align=\'center\' ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="><font size=1>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\n\t\t\t\t<td width=\"10%\" ondblclick =\"sort(\'waitingTime\');\" nowrap class=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' align=\'center\' ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\n\t\t\t<td width=\"20%\" nowrap class=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\t\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n<tr style=\'visibility:hidden\'>\n<th onclick =\"sort(\'blank\');\" nowrap>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</th>\n<th onclick =\"sort();\" nowrap>&nbsp;&nbsp;&nbsp;</th>\n<th onclick =\"sort(\'queueDate\');\" nowrap>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</th>\n<th onclick =\"sort(\'patientName\');\" nowrap>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</th>\n<th onclick =\"sort(\'patientId\');\" nowrap>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</th>\n<th onclick =\"sort(\'waitingTime\');\" nowrap>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</th>\n<th onclick =\"sort(\'locType\');\" nowrap>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</th>\n</tr>\n</table>\n<input type=\'hidden\' name=\'CAInstalled\' id=\'CAInstalled\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\n<!--Added for MMS-QH-CRF-0126.2 by Dharma Start-->\n<input type=\'hidden\' name=\'action_on_pending_bill\' id=\'action_on_pending_bill\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<!--Added for MMS-QH-CRF-0126.2 by Dharma End-->\n\n<input type=\'hidden\' name=\'queue_date\' id=\'queue_date\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n<input type=\"hidden\" name=\"chk_Select\" id=\"chk_Select\" value=\"\">\n<script>\n\t\nhideAllGifs(\'pseudo\');\ntoggleGifs(\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\');\n</script>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\n\n</form>\n</center>\n</body>\n\n<script>\n//alignHeading1();\n</script>\n\n</html>\n\n\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

/*public String getStatistics(PageContext pageContext,Connection con,String facility_id,String clinic_type,String clinic_code,String treatment_area_code, String include_checkedout) throws java.sql.SQLException  Tuesday, June 01, 2010 PE_EXE Venkat S
	{ 
		String query_statistics	=	" select tot_assigned, tot_under_tmt, tot_consulted, tot_await_tmt, tot_checked_out from ae_tmt_area_summ where facility_id = ? and trunc(queue_date) = trunc(sysdate) and locn_type = ? and locn_code = ? and treatment_area_code = ?"; 
		int tot_assigned	=	0; 
		int tot_under_tmt	=	0;  
		int tot_consulted	=	0;	
		int tot_await_tmt	=	0;
		int tot_checked_out	=	0;

		PreparedStatement pstmt	=	con.prepareStatement(query_statistics);

		pstmt.setString	(	1,	facility_id	);
		pstmt.setString	(	2,	clinic_type	);
		pstmt.setString	(	3,	clinic_code	);
		pstmt.setString	(	4,	treatment_area_code);

		ResultSet rs =	pstmt.executeQuery();
		if(rs.next())
		{
			tot_checked_out =	rs.getInt("tot_checked_out");
			tot_assigned	=	rs.getInt("tot_assigned");
			tot_under_tmt	=	rs.getInt("tot_under_tmt");
			tot_consulted	=	rs.getInt("tot_consulted");
			tot_await_tmt	=	rs.getInt("tot_await_tmt");
			tot_under_tmt	-=	tot_checked_out;

			if(include_checkedout.equals("N"))
			{
				tot_assigned	-=	tot_checked_out;
				tot_consulted	-=	tot_checked_out;
			}
		}
		if(rs!=null)			rs.close();
        if(pstmt!=null)			pstmt.close();
		StringBuffer tmt_area_statistics	= new StringBuffer();
		tmt_area_statistics.append(" ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assigned.label","common_labels")+" : ");
		tmt_area_statistics.append(tot_assigned);
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels")+" : ");
		tmt_area_statistics.append(tot_under_tmt);
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Consulted.label","ae_labels")+" : ");
		tmt_area_statistics.append(tot_consulted);
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AwaitingTreatment.label","ae_labels")+" : ");
		tmt_area_statistics.append(tot_await_tmt);
		tmt_area_statistics.append(" )");
	
		return tmt_area_statistics.toString();
	} */


public String specialCharacter(String single){
				int i=0;
				
				
		if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
		}
	

		return single ;
			
			}	



	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue) {
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String loginUser			= checkForNull((String)session.getValue("login_user"));


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	try{

	Connection con				=	null;
	PreparedStatement pstmt		=	null;
	ResultSet rs				=	null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String locale				= (String)session.getAttribute("LOCALE");
	StringBuffer	query_patient_queue		= new StringBuffer();		String facility_id				=	"";
	String	clinic_code				=	"";
	String	practitioner_id			=	"", practitioner_full_name="";
	String	patient_id				=	"",		patient_name			=	"";
	String	waiting_time			=	"",		queue_status			=	"";
	String	classValue				=	"";
	String	treatment_area_code		=	"";
	String	treatment_area_desc		=	"",		triage_area				=	"";
	String	classValuePI			=	"";
	String	queue_date				=	"";
	String	encounter_id			=	"",		clinic_type				=	"";
	String	patient_gender			=	"";
	StringBuffer	whereClause		= new StringBuffer();
    StringBuffer  orderByClause		= new StringBuffer(); 
	String	priority				=	"";
	String	trauma_yn				=	"";
	String	tblrow_id				=	"",		queue_date_time			=	"";
	String	sys_date_time			=	"",		checkout_yn				=	"";
	String	brought_dead_yn			=	"";
	String	from 					=	"";
	String	assign_tmt_area_time	=	"";
	String	p_clinic_desc	        =   "";
	String	open_to_all_pract_yn	=	"";
	String service_code             =   "";
	String visit_type_code          =   "";
	String pract_type               =   "";
	String CAInstalled               =   "";
	// Added for MMS-QH-CRF-0126.2 by Dharma Start
	String action_on_pending_bill	= "";
	String visit_num				= "";
	String episode_id				= "";			
	// Added for MMS-QH-CRF-0126.2 by Dharma End
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 Start*/
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	String priority_zone_bgcolor		= "";
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 End*/

	String open_to_all_prac_for_clinic_yn	=	"";
	String p_cutoff_hours_prv_day_visit     =	"";
	String patient_class = "";
	String prev_visit = "";
	String oper_stn_id     =	(request.getParameter("oper_stn_id")==null)? "" : request.getParameter("oper_stn_id");


	String priority_zone="";
	//coming from criteria page
	String chk_Select1			=	request.getParameter("chk_Select1");
	

/************************/
String orderCriteria	=	(request.getParameter("orderCriteria")==null)	? "queueDate" : request.getParameter("orderCriteria");
String asc_desc	=	(request.getParameter("asc_desc")==null)	? " asc" : request.getParameter("asc_desc");

if(orderCriteria.equals("")) orderCriteria="queueDate" ;


	String login_user	= (String)session.getValue("login_user");
	if (login_user == null) login_user = "";
	String responsibility_id = (String)session.getValue("responsibility_id");
	if ( responsibility_id  == null) responsibility_id = "";
	int		rowIndex				=	1,		columnIndex				=	1;
//	int columnIndexSec = 1;
//	int		maxRecord				=	0;
	int     i		   = 1;
	int		start					=	0;


	from							=	request.getParameter("from") ;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	try
	{
		con				=	(Connection)	ConnectionManager.getConnection(request);
		/*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on 10th Apr 2018 Start*/
	Boolean waitingTimeIndYN			=	CommonBean.isSiteSpecific(con, "AE", "WAITING_TIME_INDICATOR");
	int p_waiting_time					= 0;
	String p_waiting_time_color			= "";
	int p_waiting_time_hours			= 0;
	int p_waiting_time_mins				= 0;
	String firststring     = "";
    String secondstring   = "";
	/*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on 10th Apr 2018 End*/
		facility_id		=	(String) session.getValue("facility_id");

		prev_visit			=	(request.getParameter("prev_visit")==null) ? "N" : request.getParameter("prev_visit");

		clinic_code			=	(request.getParameter("clinic_code")==null) ? "" : request.getParameter("clinic_code");
		clinic_type			=	(request.getParameter("clinic_type")==null) ? "" : request.getParameter("clinic_type");
		treatment_area_code	=	(!checkForNull(request.getParameter("treatment_area_code")).equals("")) ? request.getParameter("treatment_area_code") : checkForNull(request.getParameter("treatment_area_code1"));
		practitioner_id		=	(request.getParameter("practitioner_id")==null) ? "" : request.getParameter("practitioner_id");
		patient_id			=	(request.getParameter("patient_id")==null) ? "" : request.getParameter("patient_id");
		priority			=	(request.getParameter("priority")==null) ? "" : request.getParameter("priority");
		patient_gender		=	(request.getParameter("patient_gender")==null) ? "" : request.getParameter("patient_gender");
		checkout_yn	=	(request.getParameter("checkout_yn")==null)	? "" : request.getParameter("checkout_yn");
        p_cutoff_hours_prv_day_visit 	=	(request.getParameter("p_cutoff_hours_prv_day_visit")==null)	? "" : request.getParameter("p_cutoff_hours_prv_day_visit");
		priority_zone	=	(request.getParameter("priority_zone")==null)	? "" : request.getParameter("priority_zone");	
		
		//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
		String hide_pat_unauth_pract = "N";
	   	String access_res_pat_yn = "N";
		//String loginUser			= checkForNull((String)session.getValue("login_user"));
	    
	     pstmt = con.prepareStatement("select (select HIDE_PAT_UNAUTH_PRACT_YN from CA_PARAM_BY_FACILITY where facility_id = ?) hide_pat_unauth_pract_yn, (SELECT a.access_res_pat_yn FROM ca_access_view_restr_patient a WHERE a.practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = ?) AND a.facility_id = ? AND (   (    a.access_from_date IS NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) ))access_res_pat_yn from dual ");
	   	pstmt.setString(1, facility_id);
	   	pstmt.setString(2, loginUser);
	   	pstmt.setString(3, facility_id);
	   	rs = pstmt.executeQuery();
	   	rs.next();
	   	hide_pat_unauth_pract = checkForNull(rs.getString("hide_pat_unauth_pract_yn"),"N");
	   	access_res_pat_yn = checkForNull(rs.getString("access_res_pat_yn"),"N");
	   // System.out.println(hide_pat_unauth_pract + " : hide_pat_unauth_pract; " +access_res_pat_yn + " : access_res_pat_yn");
	    if(pstmt!=null) pstmt.close();
	    if(rs!=null) rs.close();
		//End of MMS-DM-CRF-0210
		

		if(!(clinic_code.equals("")))			whereClause.append(" and a.locn_code = ? and a.locn_type = ? ");
		if(!(treatment_area_code.equals("")))	whereClause.append(" and a.treatment_area_code = ? ");
		if(!(practitioner_id.equals("")))		whereClause.append(" and a.practitioner_id = ? ");
		if(!(patient_id.equals("")))			whereClause.append(" and a.patient_id = ? ");
		if(!(priority.equals("")))				whereClause.append(" and a.priority_indicator = ? ");
		if(!(patient_gender.equals("")))		whereClause.append(" and b.sex = ? ");
      /*  if(priority_zone.equals("R"))		whereClause.append(" and a.priority_zone = 'R' ");
		if(priority_zone.equals("Y"))		whereClause.append(" and a.priority_zone = 'Y' ");
		if(priority_zone.equals("G"))		whereClause.append(" and a.priority_zone = 'G' ");
	    if(priority_zone.equals("U"))		whereClause.append(" and a.priority_zone = 'U' ");*/
	    
	    if(!priority_zone.equals(""))
	    	whereClause.append(" and a.priority_zone = '"+priority_zone+"' ");


/*******order by creation logic**********************/

/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb Mar 6th 2014 Start*/
if(five_level_triage_appl_yn.equals("Y")){
		
	 PreparedStatement pstmt1		=	null;
	 ResultSet rs1					=	null;
	 int priority_zone_order;
	 String priority_zone_code		= "";
	 String priority_zone_orderby	 = "";
	 
	 String sql1="SELECT PRIORITY_ZONE,PRIORITY_ZONE_ORDER FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER asc";
	 pstmt1   = con.prepareStatement(sql1.toString());
	 pstmt1.setString(1,locale) ;
	 rs1	=	pstmt1.executeQuery();
	 while(rs1!=null && rs1.next()){
		 priority_zone_code		= rs1.getString("PRIORITY_ZONE");
		 priority_zone_order	= rs1.getInt("PRIORITY_ZONE_ORDER");
		 priority_zone_orderby = priority_zone_orderby + "'"+priority_zone_code+"',"+priority_zone_order+",";
	 }
		if (priority_zone_orderby.length() > 0 && priority_zone_orderby.charAt(priority_zone_orderby.length()-1)==',') {
			priority_zone_orderby = priority_zone_orderby.substring(0, priority_zone_orderby.length()-1);
		}
		
	 
	 if (pstmt1 != null){
			pstmt1.close();
		}
		if (rs1!=null){
			rs1.close();
		}
		orderByClause.append(" DECODE(priority_zone,"+priority_zone_orderby+")asc,queue_date_time desc, ");
}
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 End*/
orderByClause.append("locn_desc,treatment_area_code ");
	
if(orderCriteria.equals("practitioner"))
		{
			orderByClause.append(",practitioner_name"+asc_desc+" ");
		}
else if(orderCriteria.equals("queueDate"))
		{
			orderByClause.append(",queue_date_time"+asc_desc+" ");
		}
else if(orderCriteria.equals("patientName"))
		{
				orderByClause.append(",patient_name"+asc_desc+" ");
		}
else if(orderCriteria.equals("patientId"))
		{
				orderByClause.append(",patient_id"+asc_desc+" ");
		}
else if(orderCriteria.equals("priorityZone"))
		{
				orderByClause.append(" ,DECODE(priority_zone,'R',1,'Y',2,'G',3,'U',4)"+asc_desc+" ");
		}
		else if(orderCriteria.equals("waitingTime"))
		{
	        orderByClause.append(" ,queue_date_time ");
			orderByClause.append(" "+asc_desc+" ");
		}

       whereClause.append(" AND a.queue_date >= TO_DATE (TO_CHAR (SYSDATE - 1, 'dd/mm/yyyy') || ' 23:59:59','dd/mm/yyyy hh24:mi:ss'   )- ((1 / (24 * 60 * 60)) * 3600 * '"+p_cutoff_hours_prv_day_visit+"')"); 
	 
	    whereClause.append(" and  (a.locn_type, a.locn_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = '"+facility_id+"' and Oper_stn_id ='"+oper_stn_id+"' and  appl_user_id ='"+loginUser+"' ");
		
		whereClause.append((checkout_yn.equals("Y"))?"and checkout_pat_yn = 'Y'":"and manage_queue_yn = 'Y' ");

		whereClause.append(" )");
		//Added by Ajay Hatwate for MMS-DM-CRF-0210
		if(access_res_pat_yn.equals("N") && hide_pat_unauth_pract.equals("Y")){
			whereClause.append(" AND ((b.restrict_reinstate_yn = 'N' or b.restrict_reinstate_yn is null)  OR (b.restrict_reinstate_yn = 'Y' AND a.queue_status < '04')) ");
	    }
		//End of MMS-DM-CRF-0210
/**********orderby logic ends**************/		
 		//query_patient_queue.append("select a.locn_code, c.LONG_DESC locn_desc, a.locn_type, a.treatment_area_code, (select install_yn from sm_module where module_id='CA') CAInstalled,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn,  a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_full_name, a.priority_indicator, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'hh24:mi') check_in_date_time, to_char(a.ASSIGN_TMT_AREA_TIME,'hh24:mi') ASSIGN_TMT_AREA_TIME,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, a.patient_id, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex patient_gender, a.encounter_id, get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date, a.queue_status,  a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.priority_zone, a.visit_type_code,  a.AE_BED_NO bed_no, a.disaster_yn, a.TRAUMA_YN, a.pat_curr_locn_code, a.PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') CURR_LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"','1') pat_curr_locn_desc,a.service_code, DECODE(a.priority_indicator, Null, 'N', get_p_status (get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), a.queue_date), null)) priority_status,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PAT_PRIORITY_DESC  from  ae_current_patient a, mp_patient b,op_clinic_lang_vw c  where a.facility_id = ?   and a.patient_id = b.patient_id and c.language_id = '"+locale+"' and a.facility_id = c.facility_id  and a.locn_code = c.clinic_code  and a.AE_BED_NO is null ");
		
		//Modified for MMS-QH-CRF-0126.2 by Dharma
		//query_patient_queue.append("select a.locn_code, c.LONG_DESC locn_desc, a.locn_type, a.treatment_area_code, (select install_yn from sm_module where module_id='CA') CAInstalled,(select action_on_pending_bill  from ae_param where operating_facility_id = '"+facility_id+"') action_on_pending_bill,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn,  a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_full_name, a.priority_indicator, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'hh24:mi') check_in_date_time, to_char(a.ASSIGN_TMT_AREA_TIME,'hh24:mi') ASSIGN_TMT_AREA_TIME,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, a.patient_id, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex patient_gender, a.encounter_id, get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date, a.queue_status,  a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.priority_zone, a.visit_type_code,  a.AE_BED_NO bed_no, a.disaster_yn, a.TRAUMA_YN, a.pat_curr_locn_code, a.PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') CURR_LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"','1') pat_curr_locn_desc,a.service_code, DECODE(a.priority_indicator, Null, 'N', get_p_status (get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), a.queue_date), null)) priority_status,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PAT_PRIORITY_DESC,a.OP_EPISODE_VISIT_NUM,a.EPISODE_ID  from  ae_current_patient a, mp_patient b,op_clinic_lang_vw c  where a.facility_id = ?   and a.patient_id = b.patient_id and c.language_id = '"+locale+"' and a.facility_id = c.facility_id  and a.locn_code = c.clinic_code  and a.AE_BED_NO is null ");
		
		//Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014(PRIORITY_ZONE_COLOR added)
		query_patient_queue.append("select a.locn_code, c.LONG_DESC locn_desc, a.locn_type, a.treatment_area_code, (select install_yn from sm_module where module_id='CA') CAInstalled,(select action_on_pending_bill  from ae_param where operating_facility_id = '"+facility_id+"') action_on_pending_bill,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn,  a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_full_name, a.priority_indicator, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'hh24:mi') check_in_date_time, to_char(a.ASSIGN_TMT_AREA_TIME,'hh24:mi') ASSIGN_TMT_AREA_TIME,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, a.patient_id, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex patient_gender, a.encounter_id, get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date, a.queue_status,  a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.priority_zone, a.visit_type_code,  a.AE_BED_NO bed_no, a.disaster_yn, a.TRAUMA_YN, a.pat_curr_locn_code, a.PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') CURR_LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"','1') pat_curr_locn_desc,a.service_code, DECODE(a.priority_indicator, Null, 'N', get_p_status (get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), a.queue_date), null)) priority_status,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PAT_PRIORITY_DESC,a.OP_EPISODE_VISIT_NUM,a.EPISODE_ID ,(SELECT PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) PRIORITY_ZONE_COLOR " );

		if(waitingTimeIndYN){
			query_patient_queue.append(" ,(SELECT WAITING_TIME_COLOR FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) P_WAITING_TIME_COLOR,(SELECT WAITING_TIME FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) P_WAITING_TIME ");
		}
		
		query_patient_queue.append(" from  ae_current_patient a, mp_patient b,op_clinic_lang_vw c  where a.facility_id = ?   and a.patient_id = b.patient_id and c.language_id = '"+locale+"' and a.facility_id = c.facility_id  and a.locn_code = c.clinic_code  and a.AE_BED_NO is null ");
		
		query_patient_queue.append(whereClause);
		query_patient_queue.append(" and queue_status < '07' order by  ");
		query_patient_queue.append(orderByClause);
		
		pstmt		=	con.prepareStatement(query_patient_queue.toString());
		pstmt.setString	(	1,	facility_id		);
		if(!(clinic_code.equals("")))	
		{
			pstmt.setString	(	++columnIndex,	clinic_code	);
			pstmt.setString	(	++columnIndex,	clinic_type	);
		}
		if(!(treatment_area_code.equals("")))	
			pstmt.setString	(	++columnIndex,	treatment_area_code	);
		if(!(practitioner_id.equals("")))	
			pstmt.setString	(	++columnIndex,	practitioner_id	);
		if(!(patient_id.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_id	);
		if(!(priority.equals("")))	
			pstmt.setString	(	++columnIndex,	priority	);
		if(!(patient_gender.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_gender	);

		rs	=	pstmt.executeQuery();	

	
		
	/**********************************/	
       /* PreparedStatement pstmt11		=	con.prepareStatement(query_patient_queue.toString());

	
		pstmt11.setString	(	1,	facility_id		);

		if(!(clinic_code.equals("")))	
		{
			pstmt11.setString	(	++columnIndexSec,	clinic_code	);
			pstmt11.setString	(	++columnIndexSec,	clinic_type	);
		}
		if(!(treatment_area_code.equals("")))	
			pstmt11.setString	(	++columnIndexSec,	treatment_area_code	);
		if(!(practitioner_id.equals("")))	
			pstmt11.setString	(	++columnIndexSec,	practitioner_id	);
		if(!(patient_id.equals("")))	
			pstmt11.setString	(	++columnIndexSec,	patient_id	);
		if(!(priority.equals("")))	
			pstmt11.setString	(	++columnIndexSec,	priority	);
		if(!(patient_gender.equals("")))	
			pstmt11.setString	(	++columnIndexSec,	patient_gender	);

		ResultSet rs11	=	pstmt11.executeQuery();	

		while(rs11!=null && rs11.next())
		{
		  maxRecord ++;
        }
		
		if(rs11!=null) rs11.close();
		if(pstmt11!=null)			pstmt11.close();
		
		if (maxRecord==0){
		*/

		Boolean chkfrst=rs.isBeforeFirst();
		Boolean chklst=rs.isAfterLast();
		if(!chkfrst && !chklst){
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		}else{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

	String PRIORITY_STATUS="";
	String prev_header="";
	 //if ( start != 1 )
		// for( int j=1; j<start; i++,j++ )
		//{
		//	rs.next() ;
		//}   
		while ( rs!=null && rs.next() )//&& i<=end )   
		{
			classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;
			tblrow_id				=	"tblrow_id"+rowIndex;
			patient_class = rs.getString("patient_class");
			open_to_all_pract_yn	=	(rs.getString("open_to_all_pract_yn")==null)	?	""	: rs.getString("open_to_all_pract_yn");	

			CAInstalled			=	(rs.getString("CAInstalled")==null)	?	""	: rs.getString("CAInstalled");	
			
			
			// Added for MMS-QH-CRF-0126.2 by Dharma Start
			
			action_on_pending_bill	= (rs.getString("action_on_pending_bill")==null)	?	"N"	: rs.getString("action_on_pending_bill");
			visit_num 				= rs.getString("OP_EPISODE_VISIT_NUM");
			episode_id				= rs.getString("EPISODE_ID");
			
			// Added for MMS-QH-CRF-0126.2 by End
					
			clinic_code				=	(rs.getString("locn_code")==null)	?	""	: rs.getString("locn_code");	

			p_clinic_desc			=	(rs.getString("locn_desc")==null)	?	""	: rs.getString("locn_desc");	

			clinic_type			=	(rs.getString("locn_type")==null)	?	""	: rs.getString("locn_type");	

			treatment_area_code		=	(rs.getString("treatment_area_code")==null)	?	""	: rs.getString("treatment_area_code");	
			treatment_area_desc		=	(rs.getString("treatment_area_desc")==null)	?	""	: rs.getString("treatment_area_desc");	
			triage_area				=	(rs.getString("triage_area")==null)			?	""	: rs.getString("triage_area");	

			practitioner_id			=	(rs.getString("practitioner_id")==null)		?	""	: rs.getString("practitioner_id");
			practitioner_full_name		=	(rs.getString("practitioner_full_name")==null)	?	""	: rs.getString("practitioner_full_name");
			queue_date_time			=	(rs.getString("queue_date_time")==null)		?	""	: rs.getString("queue_date_time");
			sys_date_time			=	(rs.getString("sys_date_time")==null)		?	""	: rs.getString("sys_date_time");
			patient_id				=	(rs.getString("patient_id")==null)			?	""	: rs.getString("patient_id");
			patient_name			=	(rs.getString("patient_name")==null)		?	""	: rs.getString("patient_name");
			
			encounter_id			=	(rs.getString("encounter_id")==null)		?	""	: rs.getString("encounter_id");
			waiting_time			=	(rs.getString("waiting_time")==null)		?	""	: rs.getString("waiting_time");
			queue_date				=	(rs.getString("queue_date1")==null)			?	"&nbsp;"	: rs.getString("queue_date1");	
			queue_status			=	(rs.getString("queue_status")==null)		?	""	: rs.getString("queue_status");	
			
			trauma_yn				=	(rs.getString("trauma_yn")==null)			?	""	: rs.getString("trauma_yn");	
			patient_gender			=	(rs.getString("patient_gender")==null)		?	""			: rs.getString("patient_gender");	
			brought_dead_yn			=	(rs.getString("brought_dead_yn")==null)		?	"N"	: rs.getString("brought_dead_yn");	
			service_code=	(rs.getString("service_code")==null)		?	""	: rs.getString("service_code");

			PRIORITY_STATUS=	(rs.getString("PRIORITY_STATUS")==null)		?	""	: rs.getString("PRIORITY_STATUS");

			open_to_all_prac_for_clinic_yn=	(rs.getString("open_to_all_prac_for_clinic_yn")==null)	?	""	: rs.getString("open_to_all_prac_for_clinic_yn");	
			assign_tmt_area_time	=	(rs.getString("assign_date")==null)			?	""	: rs.getString("assign_date");	

			String priority_zone1=	(rs.getString("priority_zone")==null)		?	""	: rs.getString("priority_zone");

			String curr_location=	checkForNull(rs.getString("CURR_LOCN_TYPE_DESC")) + " / " + checkForNull(rs.getString("pat_curr_locn_desc"));

			visit_type_code     =	(rs.getString("visit_type_code")==null)		?	""	: rs.getString("visit_type_code");


			StringTokenizer wt = new StringTokenizer(waiting_time,":");
            if(wt.hasMoreTokens()){
				firststring = wt.nextToken();
				secondstring = wt.nextToken();
				if(!("").equals(firststring)){
					p_waiting_time_hours	= Integer.parseInt(firststring.trim());
					p_waiting_time_hours	= p_waiting_time_hours * 60;
				}
				if(!("").equals(secondstring))
					p_waiting_time_mins		= Integer.parseInt(secondstring.trim());
				
				p_waiting_time_mins			= p_waiting_time_hours+p_waiting_time_mins;
            }
			if(waitingTimeIndYN){
				p_waiting_time	= rs.getInt("P_WAITING_TIME");
				p_waiting_time_color	= checkForNull(rs.getString("P_WAITING_TIME_COLOR"));
			}

			
		
			/*if	(priority_zone1.equals("R"))		classValuePI	=	"RESUSCITATION";
			else if(priority_zone1.equals("Y"))		classValuePI	=	"OAYELLOW";
			else if(priority_zone1.equals("G"))		classValuePI	=	"URGENT";
			else if(priority_zone1.equals("U"))		classValuePI	=	"EMERGENT";
			else classValuePI	=	classValue;*/
		
			if(!priority_zone1.equals("")){
				priority_zone_bgcolor	= (rs.getString("PRIORITY_ZONE_COLOR")==null || rs.getString("PRIORITY_ZONE_COLOR")=="")?"": rs.getString("PRIORITY_ZONE_COLOR");
			}else{
				priority_zone_bgcolor	= "";
				classValuePI			=	classValue;
			}
			
			
			
		   if(patient_name.equals(" ")) patient_name="&nbsp;";

	       String Header= p_clinic_desc +"/"+ treatment_area_desc;		
			
			if(!(Header.equals(prev_header)))
			{
				
					
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Header));
            _bw.write(_wl_block18Bytes, _wl_block18);

				prev_header	=	Header;
			}
							
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);

	if (brought_dead_yn.equals("Y")){
   
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
if(chk_Select1.equals(patient_id+"*"+encounter_id+"*"+service_code+"*"+practitioner_id)	)
{

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block29Bytes, _wl_block29);

}else{


            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block30Bytes, _wl_block30);

}
}//brought_dead_yn condition end.

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValuePI));
            _bw.write(_wl_block32Bytes, _wl_block32);
if(!priority_zone_bgcolor.equals("")){ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(priority_zone_bgcolor));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(DateUtils.convertDate(queue_date_time,"DMYHM","en",locale)));
            _bw.write(_wl_block37Bytes, _wl_block37);
 

			if (checkout_yn.equals("N"))
			{
				if (!queue_status.equals("07"))
				{
			
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(java.net.URLEncoder.encode(p_clinic_desc)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(triage_area));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(trauma_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(java.net.URLEncoder.encode(practitioner_full_name)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(queue_date_time));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(assign_tmt_area_time));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(priority_zone1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(visit_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block46Bytes, _wl_block46);

				}
				else
				{  
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block52Bytes, _wl_block52);
 
				}
			}
			else 
			{  
				if (!queue_status.equals("07"))
				{
				
			
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block59Bytes, _wl_block59);

				}
				else
				{ 
				
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(brought_dead_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block59Bytes, _wl_block59);
	}
			
            _bw.write(_wl_block63Bytes, _wl_block63);
} if(brought_dead_yn.equals("Y")) {    
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
 }else { 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block63Bytes, _wl_block63);
if(PRIORITY_STATUS.equals("Y")){ 	
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block67Bytes, _wl_block67);
if(p_waiting_time !=0 && (p_waiting_time_mins > p_waiting_time) && !("").equals(p_waiting_time_color) && waitingTimeIndYN){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_waiting_time_color));
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(waiting_time));
            _bw.write(_wl_block37Bytes, _wl_block37);
}else{ 
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
if(p_waiting_time !=0 && (p_waiting_time_mins > p_waiting_time) && !("").equals(p_waiting_time_color) && waitingTimeIndYN){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_waiting_time_color));
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(waiting_time));
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(curr_location));
            _bw.write(_wl_block74Bytes, _wl_block74);

		i++;
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();

            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(CAInstalled));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(action_on_pending_bill));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(orderCriteria));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(asc_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);

	  
	  
	  }
	if(rs!=null)	rs.close();
	if(pstmt!=null)	pstmt.close();
	}
	catch(Exception e)
	{
			e.printStackTrace();
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block87Bytes, _wl_block87);

}catch(Exception e)
{
	e.printStackTrace();
} 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeIn.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.WaitTime.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.DateTimeIn.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.WaitTime.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.currentlocation.label", java.lang.String .class,"key"));
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
