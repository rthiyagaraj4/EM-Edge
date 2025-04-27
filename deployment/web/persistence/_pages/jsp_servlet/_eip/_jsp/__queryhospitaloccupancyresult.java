package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.net.*;
import java.util.*;

public final class __queryhospitaloccupancyresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/QueryHospitalOccupancyResult.jsp", 1742452768008L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block2Bytes, _wl_block2);
String facilityid = (String)session.getValue("facility_id");
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		StringBuffer sql = new StringBuffer();
		//int total_count=0;
		int maxRecord=0;
		int start=1;
		int end=0;
		int records_to_show=14;

		String from = request.getParameter("from");
		String to = request.getParameter("to");
		StringBuffer whereClause= new StringBuffer("");
		whereClause.append(checkForNull(request.getParameter("whereclause")));
		String fromnursingunit	= checkForNull(request.getParameter("fr_nursing_unit"));
		String tonursingunit	= checkForNull(request.getParameter("to_nursing_unit"));
		String includeforcalc	= checkForNull(request.getParameter("include_for_calc"));		
		String locale			= (String)session.getAttribute("LOCALE");
		String className		= "";
		
		//Added by Santhosh for MOHE-CRF-0144
		String governorate = checkForNull(request.getParameter("governorate"));
		String facility = checkForNull(request.getParameter("facility"));
		String user_name = checkForNull(request.getParameter("user_name"));
		HashMap<String,String> governateDescMap = new HashMap();
		HashMap<String,String> facilityDescMap = new HashMap();
		HashMap<String,String> nursingUnitDescMap = new HashMap();
		String p_resp_id = checkForNull(request.getParameter("p_resp_id")) !="" ? request.getParameter("p_resp_id") :(String)session.getValue("responsibility_id");
		boolean repBasedOnGovernorate = false;
		HashMap<Integer,Integer> navigateMap = new HashMap();
		int fromRegion =  checkForNull(request.getParameter("fromRegion")) !="" ? Integer.parseInt(request.getParameter("fromRegion")):0;
		int fromFacility = checkForNull(request.getParameter("fromFacility")) !="" ? Integer.parseInt(request.getParameter("fromFacility")):0;
		int preRegion=0;
		int preFacility=0;
		int nextRegion=0;
		int nextFacility=0;
		//END
		
		int i = 0;

		if(!fromnursingunit.equals("") || !tonursingunit.equals(""))
			whereClause.append(" and a.nursing_unit_code BETWEEN  NVL('"+fromnursingunit+"','!') AND  NVL('"+tonursingunit+"','~') ");

		if(!includeforcalc.equals(""))
		{
			if(includeforcalc.equals("Y"))
				whereClause.append(" and c.incl_for_hosp_occup_calc_yn ='Y' ");
			else
				whereClause.append(" and c.incl_for_hosp_occup_calc_yn ='N' ");
		}
	
            _bw.write(_wl_block5Bytes, _wl_block5);

			try{
				
				//Added by Santhosh for MOHE-CRF-0144
				con =ConnectionManager.getConnection(request);
				repBasedOnGovernorate = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "VISIT_STAT_REP_GOVERNORATE");
				//repBasedOnGovernorate=true;
				if(repBasedOnGovernorate){
					
					//Get Governate long description
					String sql_gov = "select region_code, long_desc region_desc from mp_region_lang_vw where language_id = '"+locale+"' AND eff_status ='E' order by 2";
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql_gov);
					if(rs != null)
					{
					   while(rs.next())
					   {
						String gov_code = rs.getString("region_code");
						String gov_name = rs.getString("region_desc");
						governateDescMap.put(gov_code, gov_name);
					   }
					}
					
					//Get Facility long description
					String sql_facility = "select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ user_name+"' and p.language_id='"+locale+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";
					stmt = con.createStatement() ;
					rs=stmt.executeQuery(sql_facility);
					if(rs!=null)
					{
					   while(rs.next())
					   {
						String fid=rs.getString("facility_id");
						String fname=rs.getString("facility_name");
						facilityDescMap.put(fid, fname);
					   }
					}
					
					if(!governorate.equals("All"))
						whereClause.append(" and e.region_code='"+governorate+"' ");
					
					if(!facility.equals("All"))
						whereClause.append(" and a.facility_id='"+facility+"' ");
					
					sql.append("SELECT   a.facility_id,a.nursing_unit_code,ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"','2') nursing_unit,COUNT (bed_no) total_beds, COUNT (DECODE (current_status, 'O', 'Occupied')) occupied, ROUND (TO_NUMBER (TO_CHAR ((  COUNT (DECODE (current_status,  'O', 'Occupied' ) )/ COUNT (NVL (bed_no, 0)) * 100 ),'999.99' ),'999.99' ) ) per_occupied, e.region_code,e.facility_name,f.long_desc region_desc   FROM ip_nursing_unit_bed a, ip_nursing_unit c ,    sm_facility_for_user d ,sm_facility_param_lang_vw  e ,mp_region_lang_vw f    WHERE a.facility_id = e.facility_id     AND a.pseudo_bed_yn = 'N'    and a.facility_id = e.facility_id     and d.appl_user_id = '"+user_name+"'      and a.facility_id = d.facility_id     and   e.region_code=f.region_code and   e.LANGUAGE_ID='"+locale+"' and f.language_id='"+locale+"'"+whereClause.toString()+"     AND c.nursing_unit_code = a.nursing_unit_code     AND a.eff_status = 'E'         AND f.eff_status = 'E'              AND d.facility_id IN (SELECT DISTINCT facility_id FROM sm_facility_for_resp WHERE resp_id = 'IP')GROUP BY  a.facility_id,a.nursing_unit_code, ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', '2' ),e.region_code,e.facility_name,f.long_desc ORDER BY ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', '2' )");
					
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql.toString());
					HashMap<String,HashMap> regionMap = new HashMap<String,HashMap>();
					if(!rs.isBeforeFirst()){
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
					} else {
					   while(rs.next()) {
						String region=rs.getString("region_desc");
						String facilityName =rs.getString("facility_name");
						HashMap<String, Object> NUMap = new HashMap<String, Object>();
						
						//Get Nursing Unit long description 
						nursingUnitDescMap.put(rs.getString("nursing_unit_code"),rs.getString("nursing_unit"));
						   
						if(regionMap.get(region)!=null){
							HashMap<String,ArrayList> facilityMap = new HashMap<String,ArrayList>();
							facilityMap = regionMap.get(region);
							
							if(facilityMap.get(facilityName)!=null){
								ArrayList facilityList = new ArrayList();
								facilityList=facilityMap.get(facilityName);
																
								NUMap.put("Nursing_Unit",rs.getString("Nursing_Unit"));
								NUMap.put("Total_Beds",rs.getLong("Total_Beds"));
								NUMap.put("Occupied",rs.getString("Occupied"));
								NUMap.put("per_occupied",rs.getInt("per_occupied"));
								facilityList.add(NUMap);
							} else {
								HashMap newFacilitymap = new HashMap();
								newFacilitymap = regionMap.get(region);
								
								ArrayList newFacilityList = new ArrayList();
								NUMap.put("Nursing_Unit",rs.getString("Nursing_Unit"));
								NUMap.put("Total_Beds",rs.getLong("Total_Beds"));
								NUMap.put("Occupied",rs.getString("Occupied"));
								NUMap.put("per_occupied",rs.getInt("per_occupied"));
								newFacilityList.add(NUMap);
								newFacilitymap.put(facilityName,newFacilityList);
								regionMap.put(region,newFacilitymap);
							}
							
						} else {
							ArrayList list = new ArrayList();							
							HashMap map = new HashMap();
							
							NUMap.put("Nursing_Unit",rs.getString("Nursing_Unit"));
							NUMap.put("Total_Beds",rs.getLong("Total_Beds"));
							NUMap.put("Occupied",rs.getString("Occupied"));
							NUMap.put("per_occupied",rs.getInt("per_occupied"));
							list.add(NUMap);
							map.put(facilityName,list);
							regionMap.put(region,map);
						}
					   }
					   Integer regionCount=-1;
					   Iterator<String> itCount = regionMap.keySet().iterator();
					   while(itCount.hasNext()) {
						   regionCount++;
						   String regionKeyName=(String)itCount.next(); 
						   HashMap<String,ArrayList> facilityMapCount = new HashMap<String,ArrayList>();
						   facilityMapCount =regionMap.get(regionKeyName);
						   Iterator<String> itFacilityCount = facilityMapCount.keySet().iterator();
						   Integer facilityCount=-1;
						   while(itFacilityCount.hasNext()) {
							   String facilityKeyName=(String)itFacilityCount.next(); 
							   facilityCount++;
						   }
						   navigateMap.put(regionCount,facilityCount);
					   }
					   
					   //Navigate previous and Next data available check
					   if(fromFacility < navigateMap.get(fromRegion)){
							nextRegion=fromRegion;
						   							
						    nextFacility=fromFacility+1;
														
							if((navigateMap.get(fromRegion)-fromFacility)>0 && ( !(fromFacility <= 0) || !(fromRegion <= 0) ) ){
								preRegion=fromRegion-1;
								preFacility=navigateMap.get(fromRegion-1);							
							} else{
								preRegion=fromRegion;
								preFacility=fromFacility-1;
							}
						} else if(fromFacility >= navigateMap.get(fromRegion)){
							nextRegion=fromRegion+1;
							nextFacility=0;
						    if((navigateMap.get(fromRegion)-1)>=0 ){
								preFacility=navigateMap.get(fromRegion)-1;
								preRegion=fromRegion;
						    } else{
								preFacility = (fromRegion >= 1 && (navigateMap.get(fromRegion - 1) > 0)) ? navigateMap.get(fromRegion - 1) : 0;
								preRegion = fromRegion - 1;
							}

						}
					   
					//Previous and Next Button
					out.println("<p><table align='right'><tr>");
					if ( !(fromFacility <= 0) || !(fromRegion <= 0) )
                        out.println("<td id='prev'><A HREF='../jsp/QueryHospitalOccupancyResult.jsp?fromRegion="+(preRegion)+"&governorate="+governorate+"&facility="+facility+"&user_name="+user_name+"&fromFacility="+(preFacility)+"&fr_nursing_unit="+(fromnursingunit)+"&to_nursing_unit="+(tonursingunit)+"&include_for_calc="+(includeforcalc)+"& text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
					
					if( navigateMap.get(nextRegion) != null && (nextFacility <= navigateMap.get(nextRegion)))
                        out.println("<td id='next'><A HREF='../jsp/QueryHospitalOccupancyResult.jsp?fromRegion="+(nextRegion)+"&governorate="+governorate+"&facility="+facility+"&user_name="+user_name+"&fromFacility="+(nextFacility)+"&fr_nursing_unit="+(fromnursingunit)+"&to_nursing_unit="+(tonursingunit)+"&include_for_calc="+(includeforcalc)+"& text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					out.println("</tr></table></p>");
					out.println("<br><br>");
				 					
					//crunstruct table data for selected Governate,Facility and nursing unit 
					List<String> regionKeyList = new ArrayList<String>(regionMap.keySet());
					
					if(fromRegion < regionKeyList.size()) {
						String governateDesc = governorate.equals("All") ?"ALL":governateDescMap.get(governorate);
						String facilityDesc = facility.equals("All") ?"ALL":facilityDescMap.get(facility);
						String fromnursingunitDesc = fromnursingunit.equals("") ?"ALL":nursingUnitDescMap.get(fromnursingunit);
						String tonursingunitDesc =  tonursingunit.equals("") ?"ALL":nursingUnitDescMap.get(tonursingunit);
						
						out.println("<table style='BORDER-TOP: black 1px solid; BORDER-RIGHT: black 1px solid; BORDER-BOTTOM: black 1px solid; BORDER-LEFT: black 1px solid' align=center cellpadding=0 cellspacing=0 border=1 width='100%'>");
						out.println("<tr><th colspan='2' align=left Style='COLOR: navy; BACKGROUND-COLOR: white'>Governorate: &nbsp;"+governateDesc+"</th></tr>");
						out.println("<tr><th colspan='2' align=left Style='COLOR: navy; BACKGROUND-COLOR: white'>Facility: &nbsp;"+facilityDesc+"</th></tr>");
						out.println("<tr><th colspan='2' align=left Style='border-bottom-width: 1px; border-bottom-style: solid; COLOR: navy; BACKGROUND-COLOR: white'>Nursing unit: &nbsp;"+fromnursingunitDesc+" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Nursing unit: &nbsp;"+tonursingunitDesc+"</th></tr>");
						for(int k = fromRegion; k < regionKeyList.size(); k++) {
							String regionKey=regionKeyList.get(k);
							HashMap<String,ArrayList> facilityMap = regionMap.get(regionKey);
	
							out.println("<tr><td align=left Style='FONT-WEIGHT: bold; COLOR: navy; BACKGROUND-COLOR: peachPuff' width='20%' class='"+className+"'>"+regionKey+"</td><td colspan='4'></td></tr>");
							
							List<String> keyList = new ArrayList<String>(facilityMap.keySet());
							int count=0;
							for(int l = fromFacility; l < keyList.size(); l++) {
							    String key = keyList.get(l);
							    ArrayList<HashMap> value = facilityMap.get(key);
							    
								out.println("<tr><td align=left Style='FONT-WEIGHT: bold; COLOR: navy; BACKGROUND-COLOR: #D3D3D3' class='"+className+"'>"+key+"</td>");
								if(count==0){
									out.println("<td width='20%' class='"+className+"'></td>");
									out.println("<td align=left Style='COLOR: navy; BACKGROUND-COLOR: lemonChiffon' width='20%' class='"+className+"'>Beds</td>");
									out.println("<td align=left Style='COLOR: navy; BACKGROUND-COLOR: lemonChiffon' width='20%' class='"+className+"'>Occupied Beds</td>");
									out.println("<td align=left Style='COLOR: navy; BACKGROUND-COLOR: lemonChiffon' width='20%' class='"+className+"'>%</td></tr>");
								} else {
									out.println("<td width='20%' class='"+className+"'></td>");
									out.println("</tr>");
								}
								count++;
																
								int Total_Beds = 0;
								int Occupied = 0;
								int per_occupied = 0;
								float TB = 0.0f;
								float OCC = 0.0f;
								
								ArrayList<HashMap> facilityITList = new ArrayList<HashMap>();
								facilityITList=value;
								
								for(int j=0; j<facilityITList.size(); j++){
									HashMap NUBedMap = new HashMap();
									NUBedMap=facilityITList.get(j);
									
									//Total nursing unit calculation
									Total_Beds = Total_Beds+Integer.valueOf(NUBedMap.get("Total_Beds").toString());
									Occupied = Occupied+Integer.valueOf(NUBedMap.get("Occupied").toString());
									per_occupied = per_occupied+Integer.valueOf(NUBedMap.get("per_occupied").toString());
									TB = TB+Float.parseFloat(NUBedMap.get("Total_Beds").toString());
									OCC = OCC+Float.parseFloat(NUBedMap.get("Occupied").toString());
									
									out.println("<tr><td class='"+className+"'></td>");
									out.println("<td width='20%' align=left Style='COLOR: navy; BACKGROUND-COLOR: peachPuff' class='"+className+"'>"+NUBedMap.get("Nursing_Unit")+"</td>");
									out.println("<td width='20%' class='"+className+"'>"+NUBedMap.get("Total_Beds")+"</td>");
									out.println("<td width='20%' class='"+className+"'>"+NUBedMap.get("Occupied")+"</td>");
									out.println("<td width='20%' class='"+className+"'>"+NUBedMap.get("per_occupied")+"</td></tr>");
								}
								
								//Total nursing unit calculation showed row
								if(rs !=  null) rs.close();
								if(pstmt !=  null) pstmt.close();
								if(sql.length() > 0) sql.delete(0,sql.length());
								sql.append(" select round('"+((OCC/TB)*100)+"',2)percentOCC from dual ");
								pstmt = con.prepareStatement(sql.toString());
								rs = pstmt.executeQuery();
								rs.next();
								
								out.println("<tr><td class='querydata'></td>");
								out.println("<td align=left Style='FONT-WEIGHT: bold; COLOR: navy; BACKGROUND-COLOR: #D3D3D3' width='20%' class='"+className+"'>"+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+"</td>");
								out.println("<td align=left Style='FONT-WEIGHT: bold; COLOR: navy; BACKGROUND-COLOR: #D3D3D3' width='20%' class='"+className+"'>"+Total_Beds+"</td>");
								out.println("<td align=left Style='FONT-WEIGHT: bold; COLOR: navy; BACKGROUND-COLOR: #D3D3D3' width='20%' class='"+className+"'>"+Occupied+"</td>");
								out.println("<td align=left Style='FONT-WEIGHT: bold; COLOR: navy; BACKGROUND-COLOR: #D3D3D3' width='20%' class='"+className+"'>"+rs.getFloat("percentOCC")+"</td>");
								out.println("</tr>");
								break;
							}  
								out.println("</table>");	
								break;
						}  
					} else {
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
					}
					}					
				} else {
					sql.append("SELECT a.nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.nursing_unit_code,'"+locale+"','2') Nursing_Unit,COUNT(BED_NO) Total_Beds, COUNT(DECODE(CURRENT_STATUS,'O','Occupied')) Occupied, round(to_number(to_char((COUNT(DECODE(CURRENT_STATUS,'O','Occupied'))/Count(nvl(bed_no,0))*100),'999.99'),'999.99')) per_occupied FROM IP_NURSING_UNIT_BED A, IP_NURSING_UNIT C WHERE a.facility_id= '"+facilityid+"' and a.pseudo_bed_yn = 'N' "+whereClause.toString()+" and C.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE and a.eff_status='E' GROUP BY a.nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(A.facility_id,a.nursing_unit_code,'"+locale+"','2') ORDER BY IP_GET_DESC.IP_NURSING_UNIT(A.facility_id,a.nursing_unit_code,'"+locale+"','2')");
				
				//stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql.toString());
				/*if ( (rs != null) )
				{
					rs.last();
					total_count = rs.getRow();
					rs.beforeFirst();
				}*/

				if ( from == null )
                    start = 0 ;
                else
                    start = Integer.parseInt( from ) ;
                
                if ( to == null )
                    end = records_to_show ;
                else
                    end = Integer.parseInt( to ) ;

				if(start > 1)
					{
						for(int k=0; k < start ;k++)
							rs.next();
					}

					int z=0;
					int Total_Beds = 0;
					int Occupied = 0;
					int per_occupied = 0;

					float TB = 0.0f;
					float OCC = 0.0f;

				/*if(total_count==0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}
				else
				{*/
					while((z < records_to_show) && rs.next())
					{
					if(maxRecord==0)
					{
					out.println("<p><table align='right'><tr>");
					if ( !(start <= 0) )
                        out.println("<td id='prev'><A HREF='../jsp/QueryHospitalOccupancyResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
						" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

                    //if ( !((start+records_to_show) >= total_count ) )
                        out.println("<td id='next' style='visibility:hidden'><A HREF='../jsp/QueryHospitalOccupancyResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
						+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					out.println("</tr></table></p>");
					out.println("<br><br>");
	
					out.println("<br>");
					out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");
			
					out.println("<tr><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</th><th >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TotalBeds.label","ip_labels")+"</th><th >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Occupied.label","common_labels")+"</th><th >% "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Occupied.label","common_labels")+"</th></tr>");
						
					}
					//rs = stmt.executeQuery();
					/*if(start > 1)
					{
						for(int k=0; k < start ;k++)
							rs.next();
					}*/
					/*int z=0;
					int Total_Beds = 0;
					int Occupied = 0;
					int per_occupied = 0;

					float TB = 0.0f;
					float OCC = 0.0f;*/

					//while((z < records_to_show) && rs.next())
					//{
						z++;
						if(i%2 == 0)
							className = "QRYEVENCEN";
						else
							className = "QRYODDCEN";

						Total_Beds = Total_Beds+rs.getInt("Total_Beds");
						Occupied = Occupied+Integer.parseInt(rs.getString("Occupied"));
						per_occupied = per_occupied+rs.getInt("per_occupied");

						TB = TB+Float.parseFloat(rs.getString("Total_Beds"));
						OCC = OCC+Float.parseFloat(rs.getString("Occupied"));


						out.println("<tr><td class='"+className+"'>"+rs.getString("Nursing_Unit")+"</td>");
						out.println("<td width='20%' class='"+className+"'>"+rs.getLong("Total_Beds")+"</td>");
						out.println("<td width='20%' class='"+className+"'>"+rs.getString("Occupied")+"</td>");
						out.println("<td width='20%' class='"+className+"'>"+rs.getInt("per_occupied")+"</td></tr>");
						i++;
						maxRecord++;
					}
					out.println("</table>");

					if ( maxRecord < 14 || (!rs.next()) )
					{
						
            _bw.write(_wl_block6Bytes, _wl_block6);
 
					}
					else
					{
            _bw.write(_wl_block7Bytes, _wl_block7);

					}
					if(maxRecord==0)
					{
							out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
					}

					if(rs !=  null) rs.close();
					if(pstmt !=  null) pstmt.close();
					if(sql.length() > 0) sql.delete(0,sql.length());
					if(maxRecord>0)
					{
					sql.append(" select round('"+((OCC/TB)*100)+"',2)percentOCC from dual ");
					pstmt = con.prepareStatement(sql.toString());
					rs = pstmt.executeQuery();
					rs.next();
					
					out.println("<br>");
					out.println("<table  cellpadding=0 cellspacing=0 border=0 width='100%'>");
						out.println("<tr>");
						out.println("<td align=center class='querydata'>"+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"&nbsp;"+"</td>");
						out.println("<td align=center width='20%' class='querydata'>"+Total_Beds+"</td>");
						out.println("<td align=center width='20%' class='querydata'>"+Occupied+"</td>");
						out.println("<td align=center width='20%' class='querydata'>"+rs.getFloat("percentOCC")+"</td>");
						out.println("</tr>");
					out.println("</table>");
					}

				//}
				}
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (pstmt != null) pstmt.close();
			}catch(Exception e) 
			{
				out.println(e.toString());
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
								
				out.println("<script>if(parent.frames[1].document.forms[0] != null) parent.frames[1].document.forms[0].search.disabled = false;</script>");

			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
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
