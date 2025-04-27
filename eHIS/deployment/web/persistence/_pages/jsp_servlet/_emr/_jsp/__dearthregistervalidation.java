package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import java.util.StringTokenizer;
import java.util.HashMap;
import com.ehis.util.DateUtils;

public final class __dearthregistervalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DearthRegisterValidation.jsp", 1729660927076L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


/*public static ArrayList  removeDuplicateWithOrder(ArrayList arlList){
 Set set = new HashSet();
 List newList = new ArrayList();
 for (Iterator iter = arlList.iterator();iter.hasNext(); ) {
 Object element = iter.next();
   if (set.add(element))
      newList.add(element);
    }
    arlList.clear();
    arlList.addAll(newList);
	return arlList;
}*/


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
            _bw.write(_wl_block0Bytes, _wl_block0);
 

	request.setCharacterEncoding("UTF-8"); 
	int max_pri			= 0;
	int max_oth			= 0;
	String locale					= checkForNull((String)session.getAttribute("LOCALE"));
	//String FacilityId				= checkForNull((String) session.getValue( "facility_id" ));
	String diag_codes			= checkForNull(request.getParameter("diag_codes"));
	String move_to_grp		= checkForNull(request.getParameter("move_to_grp"));
	String mode					= checkForNull(request.getParameter("mode"));
	String max_pri_diag		= checkForNull(request.getParameter("max_pri_diag"),"0");
	String max_oth_dis		= checkForNull(request.getParameter("max_oth_dis"),"0");
	max_pri						= Integer.parseInt(max_pri_diag);
	max_oth						= Integer.parseInt(max_oth_dis);

	Connection conn =null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	HashMap combined_map=(HashMap)session.getAttribute("combined_map");

try{
	//boolean proceed=true;
	conn=ConnectionManager.getConnection(request);
	if(combined_map==null){
		combined_map =new HashMap();
	}
/*
	FYI:(For Building Groups).
	1. Here in this Page building the groups taken care when the codes are selcted and moved to different groups.
	2.First geeting the Hashmap from session and taking the lists of seperate groups,removing the duplicate in other groups,
	adding new codes for the selected groups,putting the list into map and seeting the map into session again.
*/
if(move_to_grp!=null && !move_to_grp.equals("")){
	//HashMap diag_dates_map=(HashMap)session.getAttribute("diag_dates_map");//	HashMap indivisual_list	= new HashMap();
/*
	FYI:To remove the duplication in the same group the below code was written.
*/
	if(!combined_map.containsKey(move_to_grp)){
			combined_map.put(move_to_grp,new ArrayList());
		}
		if(move_to_grp.equals("C")){
			String Code="";
			//String chk_val="";
			ArrayList selected_code_list=(ArrayList)combined_map.get(move_to_grp);
			if(!diag_codes.equals("")){
			StringTokenizer st_tkn=new StringTokenizer(diag_codes,"~");
				while(st_tkn.hasMoreElements()){
						Code=st_tkn.nextToken();
							   if(!selected_code_list.contains(Code)){
									selected_code_list.add(Code);
					}
				}
			}
				combined_map.put(move_to_grp,selected_code_list);
/*
FYI:
	1.When codes are selected  and moved to Causeof death group the codes are also there in Others Group and General Groups. 
		Here below logic will  removing codes from Others Group and General Groups.Because those codes are moved to 
		Causeof Death Group.When page reloads the codes should be in this group only. The Same logic was followed to remaining groups also.
*/
				if(combined_map.containsKey("O")){
				ArrayList PrimaryDetails_list = (ArrayList)combined_map.get("O");
				int i=0;
				while(i<selected_code_list.size()){
					if(PrimaryDetails_list!=null && PrimaryDetails_list.contains(selected_code_list.get(i))){
						PrimaryDetails_list.remove(selected_code_list.get(i));
					}
				i++;
			}
		}
			if(combined_map.containsKey("R")){
			ArrayList PrimaryDetails_list	= (ArrayList)combined_map.get("R");
			int i=0;
			while(i<selected_code_list.size()){
				if(PrimaryDetails_list!=null && PrimaryDetails_list.contains(selected_code_list.get(i))){
					PrimaryDetails_list.remove(selected_code_list.get(i));
				}
			i++;
		}
	}
}else if(move_to_grp.equals("O")){
			String Code="";
			//String chk_val="";
			ArrayList selected_code_list=(ArrayList)combined_map.get(move_to_grp);
			if(!diag_codes.equals("")){
			StringTokenizer st_tkn=new StringTokenizer(diag_codes,"~");
				while(st_tkn.hasMoreElements()){
					Code=st_tkn.nextToken();
//					combined_map.remove("O");
						if(!selected_code_list.contains(Code)){
							selected_code_list.add(Code);
					   }
				}
			}
				combined_map.put(move_to_grp,selected_code_list);
				if(combined_map.containsKey("C")){
				ArrayList PrimaryDetails_list	= (ArrayList)combined_map.get("C");
				int i=0;
				while(i<selected_code_list.size()){
					if(PrimaryDetails_list!=null && PrimaryDetails_list.contains(selected_code_list.get(i))){
						PrimaryDetails_list.remove(selected_code_list.get(i));
//						diag_dates_map.remove(selected_code_list.get(i));
					}
				i++;
			}
		}
				if(combined_map.containsKey("R")){
				ArrayList PrimaryDetails_list	= (ArrayList)combined_map.get("R");
				int i=0;
				while(i<selected_code_list.size()){
					if(PrimaryDetails_list!=null && PrimaryDetails_list.contains(selected_code_list.get(i))){
						PrimaryDetails_list.remove(selected_code_list.get(i));
					}
				i++;
			}
		}				
		}else if(move_to_grp.equals("R")){
			String Code="";
			//String chk_val="";
			ArrayList selected_code_list=(ArrayList)combined_map.get(move_to_grp);

			if(!diag_codes.equals("")){
			StringTokenizer st_tkn=new StringTokenizer(diag_codes,"~");
				while(st_tkn.hasMoreElements()){
				   Code=st_tkn.nextToken();
				   if(!selected_code_list.contains(Code)){
						selected_code_list.add(Code);
				   }
				}
			}
				combined_map.put(move_to_grp,selected_code_list);
				if(combined_map.containsKey("C")){
				ArrayList PrimaryDetails_list	= (ArrayList)combined_map.get("C");
				int i=0;
				while(i<selected_code_list.size()){
					if(PrimaryDetails_list!=null && PrimaryDetails_list.contains(selected_code_list.get(i))){
						PrimaryDetails_list.remove(selected_code_list.get(i));
//						diag_dates_map.remove(selected_code_list.get(i));

					}
				i++;
			}
		}
				if(combined_map.containsKey("O")){
				ArrayList PrimaryDetails_list	= (ArrayList)combined_map.get("O");
				int i=0;
				while(i<selected_code_list.size()){
					if(PrimaryDetails_list!=null && PrimaryDetails_list.contains(selected_code_list.get(i))){
						PrimaryDetails_list.remove(selected_code_list.get(i));
					}
				i++;
			}
		}	
}
		session.setAttribute("combined_map",combined_map);
}
/*****************************Ends Of Building Groups***********************************************/
/*
	FYI: 
	1.Whenever  MDR window being closing or making clear the form  then the Session object is to be removed.
	2.The below code works in the same way 
*/
	if(mode.equals("RemoveSessionVals")){
		session.removeAttribute("combined_map");
		session.removeAttribute("diag_dates_map");
//		session.removeAttribute("diag_desc_map");
//		out.println(session.getAttribute("diag_dates_map")+""+session.getAttribute("combined_map"));
	}else if(mode.equals("SEQUENCING")){
/*
	FYI:When the user wants to re-sequence the cause of death group 
	1.All the items for that group,onset dates for that items and new seq-nos are taken.
	2.Making one Hashmap key as seq-no and value as item of cause of death.
	3.Looping through the hashmap size by the iterator value getting the value form the hash map and putting into the 
	original map that is Combined Map and setting into the Session.
	4.	The below code works in the same way For  mode.equals("SEQUENCING")
*/
		HashMap seq_map				= new HashMap();
		ArrayList seq_list	=new ArrayList();
		HashMap diag_dates_map1=(HashMap)session.getAttribute("diag_dates_map");
		int seq_no=0;
		String Code="";
		String diag_dates_record="";
//		String th_date="";
		if(!diag_codes.equals("")){
			StringTokenizer st_tkn=new StringTokenizer(diag_codes,"~");
				while(st_tkn.hasMoreElements()){
				String diag_cd=st_tkn.nextToken();
				StringTokenizer st_tkn_cd=new StringTokenizer(diag_cd,"$");
				seq_no=Integer.parseInt(st_tkn_cd.nextToken());
				Code=st_tkn_cd.nextToken();
				seq_map.put(seq_no,Code);
				diag_dates_record=st_tkn_cd.nextToken();
				if(diag_dates_record.equals("00")){
					diag_dates_record="";
				}
//				th_date=DateUtils.convertDate(diag_dates_record,"DMYHM" ,locale,"en");
				diag_dates_map1.put(Code,diag_dates_record);
			}
				for(int i=1;i<=seq_map.size();i++){
						seq_list.add(seq_map.get(i));
				}
				combined_map.put("C",seq_list);
				session.setAttribute("combined_map",combined_map);
				session.setAttribute("diag_dates_map",diag_dates_map1);


		}
	}else if(mode.equals("CERTIFIED_PRACT_DETAILS")){
			String certified_pract_id=request.getParameter("certified_pract_id");
			String citizen_code	 ="";
			String registration_no	 ="";
			String PRACT_DTLS_SQL="SELECT NATIONAL_ID_NUM, APC_NO FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID='"+certified_pract_id+"' AND LANGUAGE_ID='"+locale+"' ";
			pstmt=conn.prepareStatement(PRACT_DTLS_SQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				citizen_code=checkForNull(rs.getString("NATIONAL_ID_NUM"));
				registration_no=checkForNull(rs.getString("APC_NO"));
			}
			out.write(citizen_code+","+registration_no);
	}else if(mode.equals("SaveRecords")){
/*
	FYI:When the user clicks the Save Or Finalize Button after changing the onset dates the modified dates should go to back end. 
	1.All the items for that group,onset dates  are taken.
	2.And updating the appropriate item with changed date and updating the Combined map and seeting into the session.
	3.This is only for Cause Of  death Group only. 
	4.	The below code works in the same way For mode.equals("SaveRecords")
*/
			String Code="";
			String diag_dates_record="";
			HashMap diag_dates_map1=(HashMap)session.getAttribute("diag_dates_map");
			//ArrayList save_record_list	=new ArrayList();
			if(!diag_codes.equals("")){
				StringTokenizer st_tkn=new StringTokenizer(diag_codes,"~");
				while(st_tkn.hasMoreElements()){
					String diag_cd=st_tkn.nextToken();
					StringTokenizer st_tkn_cd=new StringTokenizer(diag_cd,"$");
					Code=st_tkn_cd.nextToken();
					diag_dates_record=st_tkn_cd.nextToken();
					if(diag_dates_record.equals("00")){
						diag_dates_record="";
					}
					diag_dates_map1.put(Code,diag_dates_record);
			}
				session.setAttribute("diag_dates_map",diag_dates_map1);
		}

	}else if(mode.equals("CALCULATEDOI")){
	/*
		FYI:Any time the user may change the onset date,based upon the changed dates the duration of illness should be updated. 
		1.Taking all dates if any one of the dates changed and making one string and exceuting the query for a value which is Duration of illness(DOI).
		2.And updating the appropriate item with changed date and updating the Combined map and seeting into the session.
		3.	The below code works in the same way For mode.mode.equals("CALCULATEDOI").
	*/
		try{
			String date="";
			String diag_illnes_date="";
			String hid_illnes_date="";
			String diag_onset_dates=request.getParameter("diag_onset_dates");
			if(!diag_onset_dates.equals("")){
			StringTokenizer st_tkn_dates=new StringTokenizer(diag_onset_dates,"~");
			String th_date="";
			while(st_tkn_dates.hasMoreElements()){
				date=st_tkn_dates.nextToken();
				if(!date.equals("00")){
					th_date=DateUtils.convertDate(date,"DMYHM" ,locale,"en");
					diag_illnes_date=diag_illnes_date+"to_date('"+th_date+"','dd/mm/yyyy hh24:mi'),";
				}
			}
			diag_illnes_date=diag_illnes_date.substring(0,diag_illnes_date.length()-1);
			String DATE_SQL="SELECT MP_CALCULATE_AGE_YMD(least("+diag_illnes_date+"),'YMDH',sysdate) ILLNESS_DATE FROM DUAL";
			 pstmt=conn.prepareStatement(DATE_SQL);
			 rs=pstmt.executeQuery();
			 while(rs.next()){
				hid_illnes_date=checkForNull(rs.getString("ILLNESS_DATE"));
			 }
		}
		out.println(hid_illnes_date);
	}catch(Exception ex){
		ex.printStackTrace();
		}
	}

}catch(Exception ex){
	ex.printStackTrace();
}finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
