package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __stdcompreferraldetailsintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/STDCompReferralDetailsIntermediate.jsp", 1709115252390L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String listVal	= (String)hash.get("listVal");
	if(listVal == null)
		listVal = "L";
	String specialty	= (String)hash.get("specialty");
	if(specialty == null)
		specialty = "";
	String location_type	= (String)hash.get("location_type");
	if(location_type == null)
		location_type = "";

	String calledFrom = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String facilityID = (String)session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");

	PreparedStatement pstmt = null;
	ResultSet res = null;
	PreparedStatement pstatmnt = null;
	ResultSet resultset = null;

	Connection con = null; 

	String sql = "";
	String sqlLocn = "";
	String locationCode = "";
	String locationDesc = "";

	try
	{
		con = ConnectionManager.getConnection(request);

		if(calledFrom.equals("refSource"))
		{
			if(listVal.equals("L"))
			{
				sql = "select a.FACILITY_NAME referred_to_id_desc ,a.FACILITY_ID referred_to_id  from sm_facility_param a, am_hcare_setting_type b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = ? ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) order by a.facility_name";
			}
			else if(listVal.equals("E"))
			{
				sql ="select facility_name from sm_facility_param where facility_id = ? ";
			}
			else if(listVal.equals("X"))
			{
				sql = "Select a.SHORT_DESC referred_to_id_desc, a.REFERRAL_CODE referred_to_id from am_referral a, am_hcare_setting_type b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' order by a.short_desc";
			}
				
			try
			{
				pstmt = con.prepareStatement(sql);
				if(!listVal.equals("X"))
				{
					pstmt.setString(1,facilityID);
				}

				res = pstmt.executeQuery();

				while(res.next())
				{
					out.println("var selObj = parent.detailsFrame.document.createElement(\"OPTION\")");

					if(!listVal.equals("E"))
					{
						out.println("selObj.value = \""+res.getString(2)+"\"");
					}
					else
					{
						out.println("selObj.value = \""+facilityID+"\"");
					}
					out.println("selObj.text = \""+res.getString(1)+"\"");	
					out.println("parent.detailsFrame.document.refDetailsForm.referralSource.add(selObj);");
				}
					
				if(res != null) res.close();
				if(pstmt != null) pstmt.close();

				if(!listVal.equals("X"))
				{
					int ip=0;
					int op=0;

					StringBuffer sqlBuff = new StringBuffer();

					sqlLocn = "select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = ? ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";  

					try
					{
						pstmt=con.prepareStatement(sqlLocn);
						pstmt.setString(1,facilityID);
						res = pstmt.executeQuery();

						while(res.next())
						{
							ip= res.getInt("ip");
							op= res.getInt("op");
						}
						if(res != null) res.close();
						if(pstmt != null) pstmt.close();

						sqlBuff.append("select locn_type,short_desc from am_care_locn_type where care_locn_type_ind in (");
						
						if (op>0)
						{
							sqlBuff.append("'C',");
						}
						sqlBuff.append("'E','D'");
						if(ip>0)
						{
						  sqlBuff.append(",'N'");
						}
						sqlBuff.append(") and locn_type in(");
						if(op>0)
						{
						  sqlBuff.append("'C',");
						}
						sqlBuff.append("'E','Y' ");
						if(ip>0)
						{
						  sqlBuff.append(",'N'");
						}
						sqlBuff.append(" ) and sys_user_def_ind='S' order by 2");

						pstatmnt = con.prepareStatement(sqlBuff.toString());
						resultset = pstatmnt.executeQuery();

						while(resultset.next())
						{
							locationCode = resultset.getString("locn_type")==null?"":resultset.getString("locn_type");
							locationDesc = resultset.getString("short_desc")==null?"":resultset.getString("short_desc");
							out.println("var selObj = parent.detailsFrame.document.createElement(\"OPTION\")");
							out.println("selObj.value = \""+locationCode+"\"");
							out.println("selObj.text = \""+locationDesc+"\"");	
							out.println("parent.detailsFrame.document.refDetailsForm.locationVal.add(selObj);");
						}
						if(resultset != null) resultset.close();
						if(pstatmnt != null) pstatmnt.close();
					}
					catch(Exception e)
					{
						
						e.printStackTrace();
					}
				}
				else
				{
					out.println("parent.detailsFrame.document.refDetailsForm.locnText.style.display='inline';");
					out.println("parent.detailsFrame.document.refDetailsForm.locationVal.style.display='none';");
					out.println("parent.detailsFrame.document.refDetailsForm.locationValues2.style.display='none';");
				}
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
		}
		else if(calledFrom.equals("popuLocn"))
		{
			try
			{
				if(listVal.equals("L") || listVal.equals("E"))
				{
					if(location_type.equals("C"))
					{
						sql = "Select short_desc dat, clinic_code id from op_clinic where facility_id = ? and CARE_LOCN_TYPE_IND= 'C' and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = ? and clinic_type='C'  order by 1";
					}
					else if(location_type.equals("N"))
					{
						sql="Select a.short_desc dat, a.nursing_unit_code id from ip_nursing_unit a, ip_nurs_unit_for_specialty b  where a.facility_id = ? and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and locn_type='N' and appl_patient_class = 'IP' and a.facility_id = b.facility_id and b.specialty_code = ? order by 1";
					}
					else if(location_type.equals("Y"))
					{
						sql="Select short_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic where facility_id = ? and CARE_LOCN_TYPE_IND='D' and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = ? and clinic_type='Y'  order by 1 ";
					}
					else if(location_type.equals("E"))
					{
						sql="Select short_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic where facility_id = ? and CARE_LOCN_TYPE_IND='E' and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = ?  order by 1 "; 
					}
					else if(location_type.equals("W"))
					{
						sql="SELECT  SHORT_DESC dat,WING_CODE id, 'N' open_to_all_pract_yn FROM RD_WINGS WHERE  OPERATING_FACILITY_ID  = ? AND INT_OR_EXT= 'I' AND STATUS IS NULL";
					}	

					pstmt = con.prepareStatement(sql);
					
					if(location_type.equals("W"))
					{
						pstmt.setString(1,facilityID);
					}
					else
					{
						pstmt.setString(1,facilityID);
						pstmt.setString(2,specialty);
					}
	
					res = pstmt.executeQuery();
					
					while(res.next())
					{
						/***********modified by Deepa on 8/19/2009 at 4:34 PM for the incident IN013582 ******/
						//locationCode = res.getString("clinic_code")==null?"":res.getString("clinic_code");
						//locationDesc = res.getString("short_desc")==null?"":res.getString("short_desc");

						locationCode = res.getString("id")==null?"":res.getString("id");
						locationDesc = res.getString("dat")==null?"":res.getString("dat");
						/***********modified by Deepa on 8/19/2009 at 4:34 PM for the incident IN013582 ******/

						out.println("var selObj = parent.detailsFrame.document.createElement(\"OPTION\")");
						out.println("selObj.value = \""+locationCode+"\"");
						out.println("selObj.text = \""+locationDesc+"\"");	
						out.println("parent.detailsFrame.document.refDetailsForm.locationValues2.add(selObj)");
					}

					if(res!=null) res.close();
					if(pstmt!=null) pstmt.close();
				}
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
		}
	
	}
	catch(Exception e)
	{
		e.printStackTrace() ;		
	}
	finally
	{
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
