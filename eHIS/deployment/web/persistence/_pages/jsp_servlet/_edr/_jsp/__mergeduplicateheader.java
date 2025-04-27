package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eDR.*;

public final class __mergeduplicateheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/MergeDuplicateHeader.jsp", 1733807833953L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/MergeDuplicates.js\'></script>\n\t<script language=\'javascript\' src=\'../../eDR/js/DuplicateRecord.js\'></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/rowcolor.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey()\' onLoad=\"callChk();\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<form name=\'group_header_form\' id=\'group_header_form\'>\n\t\t\t<table border=\'0\' width=\'100%\' cellspacing=\'0\'  id=\'tabz\' >\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'fields\' width=\'5%\'>\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'sel_all\' id=\'sel_all\' onClick=\'sel_all_chk()\'></td>\n\t\t\t\t\t<td class=\'label\' width=\'80%\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t<td class=\'label\' width=\'15%\'></td>\n\t\t\t\t\t<td class=\'label\'></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'5%\'></td>\n\t\t\t\t\t<td class=\'label\' width=\'75%\'></td>\n\t\t\t\t\t<td class=\'label\' width=\'20%\'></td>\n\t\t\t\t\t<td class=\'label\' ></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table border=0 width=\'100%\' cellspacing=\'0\'  id=\'tb1\' >\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'5%\'></td>\n\t\t\t\t\t<td class=\'label\' width=\'75%\'></td>\n\t\t\t\t\t<td class=\'label\' width=\'20%\'></td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script> \n\t\t\t\t\t\tvar ErrorText = \'\';\n\t\t\t\t\t\tparent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\";\n\t\t\t\t\t</script> \n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t\t\t\t\t\t<tr id=\'_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t\t\t\t\t<td class=\'fields\' valign=\'top\'><input type=checkbox name=\'selectpatient";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'selectpatient";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" value=\'\'  onclick=\"chk_slt_all(this,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\"><a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\'>+</a>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td colspan=\'2\' class=\'data\'><a name=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onClick=\'changeRowColor(this,3)\' href=\'javascript:callDupGroupDetails(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\",\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\")\' id=\'_a";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a><br>\n\t\t\t\t\t\t\t\t<font size=1>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font></td>\n\t\t\t\t\t\t\t\t<td  valign=top class=\'label\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" \n\t\t\t\t\t\t\t\t<input type=hidden name=\'dup_group_id";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'dup_group_id";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t</table>\n\t\t\t\t<input type=\'hidden\' name=\"p_patcount\" id=\"p_patcount\" value=\'0\'>\n\t\t\t\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'chkedVls\' id=\'chkedVls\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\"start\" id=\"start\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\"dupGroupId\" id=\"dupGroupId\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\"endd\" id=\"endd\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'groupTotal\' id=\'groupTotal\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'></input>\n\t\t        <input type=\'hidden\' name=\'index\' id=\'index\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'></input>\t\t\n\t\t\t</form>\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<script> \n\t\t\t\tdocument.getElementById(\'groupTotal\').value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\t\t\tdocument.getElementById(\'index\').value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\';\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'==\'true\') {\n\t\t\t\t\tdocument.getElementById(\'sel_all\').checked = true;\n\t\t\t\t} else {\n\t\t\t\t\tdocument.getElementById(\'sel_all\').checked = false;\n\t\t\t\t}\n\t\tif(parent.frames[1].document.getElementById(\'sel_all\').checked==true)\n \t {\n\t if(parent.parent.frames[1].frames[4].document.getElementById(\'start_now\'))\n\t\t {\n\t parent.parent.frames[1].frames[4].document.getElementById(\'start_now\').disabled=false;\n\t\t }\n\tif(parent.parent.frames[1].frames[4].document.getElementById(\'start_later\'))\n\t\t {\n\tparent.parent.frames[1].frames[4].document.getElementById(\'start_later\').disabled=false; \n\t\t }\n\t }else{\n\t     if(parent.parent.frames[1].frames[4].document.getElementById(\'\'))\n\t\t {\n\t\t parent.parent.frames[1].frames[4].document.getElementById(\'start_now\').disabled=true;\n\t     }\n\t\t if(parent.parent.frames[1].frames[4].document.getElementById(\'\'))\n\t\t {\n\t\t parent.parent.frames[1].frames[4].document.getElementById(\'start_later\').disabled=true; \n\t\t }\n\t }\n\t\t </script>\n\t     </body>\n         </html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	String facilityId = (String) session.getValue("facility_id");
    String locale = (String)session.getAttribute("LOCALE");
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str				= "";
	StringBuffer strsb		= null;
	String p_patient_id		= "";
	String p_patient_line	= "";
	String sql				= "";
	String p_order_by		= "";
	String chkStr1			= "";
	String groupTotal		= "";
	StringBuffer sb			= null;
	String chkSelAll        = "";

	int p_pat_count		= 0;
	int p_dup_group_id	= 0; 
	int p_pat_rec_cnt	= 0;
    int flag			= 0;

	String whereClause = request.getParameter("whereclause");
		
	ArrayList dupGroupId1 = new ArrayList(20);
	dupGroupId1.add(0,"000000000");

	String from = request.getParameter("from");
	String to	= request.getParameter("to");

	String chkBoxes[]	= new String[10];

    String chkStr		= request.getParameter("chkVls")==null?"":request.getParameter("chkVls");
	//out.println("chkStr-->"+chkStr);
	String dupGroupId	= request.getParameter("dupGroupId")==null?"":request.getParameter("dupGroupId");
	String groupIdIndex	= request.getParameter("groupIdIndex")==null?"0":request.getParameter("groupIdIndex");
    
	int index		= 0;
	int groupIndex	= Integer.parseInt(groupIdIndex);
    int stat = 0, en = 0;

	chkStr	= chkStr.trim();

	if(from == null) stat = 0 ;
	else stat = (Integer.parseInt( from ) - 1);

	if(to == null) en = 9;
	else en = (Integer.parseInt( to ));

	ArrayList dupGpId	= null;
	index				= (int)(en/9);

	try
	{
		sb		= new StringBuffer();
		strsb	= new StringBuffer();
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		dupGpId	= (ArrayList)session.getAttribute("dupGroupId");
		if(dupGpId != null && chkStr.equals(""))
		{
			session.removeAttribute("dupGroupId");
			dupGpId	= null;
		}	

		if(dupGpId != null)
		{
			int sz = dupGpId.size();
			if(sz > groupIndex) dupGpId.remove(groupIndex);//Here we can also use dupGpId.set(index,Object) method instead of removing.
			if(dupGpId.size()>0)
			dupGpId.add(groupIndex,dupGroupId);
			for(int i=0; i<dupGpId.size(); i++)
			{ 
				if(i == 0) 
				sb.append(((String)dupGpId.get(i)).toString());
				else
				{
					sb.append("~");
					sb.append(((String)dupGpId.get(i)).toString());

				}
			}
		}
		else
		{
			dupGpId	= new ArrayList(20);
			dupGpId.add(0,"000000000");
			session.setAttribute("dupGroupId",dupGpId);
		}
		session.setAttribute("dupGroupId",dupGpId);
        groupTotal=sb.toString();  
		String fromPage = request.getParameter("fromPage");
		String facility	= request.getParameter("facility1");

		if(fromPage == null) fromPage = "";
		if(facility == null) facility = "";
      
		 chkStr=chkStr+"000000000";
		if(chkStr != null && !chkStr.equals(""))
		{
			
			chkStr1	= chkStr.substring(stat,en); 
			
			for(int i=1; i<=9; i++)
			{
				
				if(chkStr1.indexOf(String.valueOf(i))!=-1) { chkBoxes[i]="CHECKED";  }
				else { chkBoxes[i]	= "UNCHECKED"; }
			}
		}
		else
		{ 
			for(int i=0; i<=9; i++) { chkBoxes[i]	= "UNCHECKED"; }
		}

		if((whereClause == null || whereClause.equals("")))
		{
			p_patient_id = request.getParameter("patient_id");
			if(p_patient_id == null) p_patient_id = "";

			if(fromPage.equals("2"))
			{
				sql = "WHERE dup_indicator = 'V' AND group_status = 'I' AND marked_for_merge_yn = 'N' AND added_facility_id = nvl('"+facility+"', added_facility_id) and patient_id = nvl('"+p_patient_id+"',patient_id)";
			}
			else
			{
				sql="WHERE dup_indicator = 'V' AND group_status = 'I' AND marked_for_merge_yn = 'N' AND added_facility_id = nvl('"+facilityId+"', added_facility_id) AND patient_id = nvl('"+p_patient_id+"', patient_id)";
			}
		} 
		else
		{
			sql = whereClause;
		}
		
		int x			= 0;
		int time_count	= 0;
		int start		= 0 ;
		int end			= 0 ;
		int i			= 1;

		if(from == null) start = 1;
		else start = Integer.parseInt(from);

		if(to == null) end = 9;
		else end = Integer.parseInt(to);
		
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				if(p_patient_id.length() > 0)
				{
					str = "select count(1) total from dr_dup_group_vw2 " + sql;
					rs = stmt.executeQuery(str);
					if (rs.next())
					{
						p_pat_rec_cnt = rs.getInt("total");
					} if(rs != null) rs.close();

					if(p_pat_rec_cnt == 0)
					{
						
            _bw.write(_wl_block11Bytes, _wl_block11);

					}
				}
				else
				{
					
            _bw.write(_wl_block12Bytes, _wl_block12);

				}

				str  = "SELECT decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle FROM dr_process_ctl " ;
				rs	 = stmt.executeQuery(str);
				if(rs.next())
				{
					p_order_by	= rs.getString("order_by_for_process_cycle");
					flag		= 1;
				} if(rs != null) rs.close();

				strsb.append("SELECT dup_group_id, patient_id, SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6)  patient_line, pat_count, mp_patient_added_date FROM dr_dup_group_vw2 ");
				 strsb.append(sql); 
               
			    if(flag == 1)
				{
					strsb.append( "order by ");
					strsb.append(p_order_by);
					strsb.append(" ");
				}
                
					rs	= stmt.executeQuery(strsb.toString());
				if(rs != null)
				{
					if(start != 1)
						for(int j=1; j<start; i++,j++)
						{	
							rs.next() ;						  
						}
						while(rs.next() && i <= end)
						{
							x = x + 1;
							time_count++;

							p_patient_id	= rs.getString("patient_id");
							p_pat_count		= rs.getInt("pat_count");
							p_patient_line	= rs.getString("patient_line");
							p_dup_group_id  = rs.getInt("dup_group_id");

							if(chkBoxes[x].equals("UNCHECKED"))
								chkSelAll = "false";
							else 
								chkSelAll = "true";
							
							
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(x));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(x));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(chkBoxes[x]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(x));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(x));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_pat_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_pat_count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(x));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(x));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block29Bytes, _wl_block29);

								i++;
						}
					} if (rs != null) rs.close();
					//out.println("dupGroupId-->"+dupGroupId);
					
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(x));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(start));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dupGroupId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(end));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(groupTotal));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(index));
            _bw.write(_wl_block36Bytes, _wl_block36);

			dupGroupId1.clear();
			dupGpId.clear();
			if(sb!=null || sb.length() >0)
			sb.setLength(0);
			if(strsb!=null || strsb.length() >0)
			strsb.setLength(0);
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception In MergeDuplicateHeader:"+e.getMessage());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(groupTotal));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(index));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chkSelAll));
            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDR.SelectAllCurrentPage.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${dr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
