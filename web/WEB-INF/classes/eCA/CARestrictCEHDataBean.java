/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/10/2019	IN069242		Sivabagyam			22/10/2019	Ramesh Goli			GHL-CRF-0567							
10/03/2022   29024          K.Pranay                                           unsed local variable[Common-ICN-0092]							
------------------------------------------------------------------------------------------------------------------------------------------------
*/  
package eCA;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import webbeans.eCommon.ConnectionManager;
import java.math.*;

import eCA.Common.CaAdapter;
public class CARestrictCEHDataBean extends CaAdapter implements Serializable {
	HashMap<String, String> restrictData=new HashMap<String,String>();
	
	public HashMap<String, String> getRestrictData() {
		return restrictData;
	}

	public void setRestrictData(HashMap<String, String> restrictData) {
		this.restrictData = restrictData;
	}

	public ArrayList getHistRecType(String locale) throws Exception {
		Connection con	= null;
		
		ArrayList histRecTypes = new ArrayList() ;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String qryCriteria	= "select hist_rec_type, short_desc from CR_HIS_RECTYP_LNG_VW where hist_rec_type not in('ALGY','MEDN','NBDT','FEVT','MHD') AND LANGUAGE_ID = ? order by 2"; //Added MHD for ML-MMOH-CRF-1759
		try{
			con = ConnectionManager.getConnection();
			stmt = con.prepareStatement(qryCriteria);
			stmt.setString(1, locale);
			rs = stmt.executeQuery(); 
		 
			if( rs != null ){
				while(rs.next())
				{
					String[] histList  = new String[2];
					histList[0] =(String)rs.getString("hist_rec_type");
					histList[1] =(String)rs.getString("short_desc")	;				
					histRecTypes.add(histList); 
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
		
		}finally{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		return histRecTypes;
	}
	public ArrayList getEventClass(String hist_type,String locale) throws Exception {
		Connection con		= null;
		PreparedStatement stmt = null;
		ResultSet rs			= null;
		ArrayList eventClassTypes=new ArrayList();

		try{
			con = ConnectionManager.getConnection();
			String sql="select EVENT_CLASS, SHORT_DESC from CR_EVENT_CLASS_LANG_VW where hist_rec_type=? and language_id = ? order by SHORT_DESC";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,hist_type);
			stmt.setString(2,locale);
			rs=stmt.executeQuery();
			if ( rs != null ){
				while(rs.next()){	
					String[] eventClass  = new String[2];
					eventClass[0]=(String)rs.getString("EVENT_CLASS");
					eventClass[1]=(String)rs.getString("SHORT_DESC");
					eventClassTypes.add(eventClass);
				}
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		return eventClassTypes;
	}
	public void getRestrictDataDetails(String restrictId) throws Exception {
		Connection con		= null;
		PreparedStatement stmt = null;
		ResultSet rs			= null;
	//	ArrayList eventClassTypes=new ArrayList();//Common-ICN-0092  
		HashMap <String ,String> restrictMap=new HashMap<String,String>();
		try{
			con = ConnectionManager.getConnection();
			String sql="SELECT RESTRICTION_ID,HIST_FUNCTION,RESTRICTION_TYPE,HIST_REC_TYPE,EVENT_CLASS,RESTRICTION_YN FROM CA_CEH_RESTRICT_DATA_DTL WHERE RESTRICTION_ID=? ";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,restrictId);
			rs=stmt.executeQuery();
			if ( rs != null ){
				while(rs.next()){			
					restrictMap.put(rs.getString("RESTRICTION_ID")+"|"+rs.getString("RESTRICTION_TYPE")+"|"+rs.getString("HIST_REC_TYPE")+"|"+rs.getString("EVENT_CLASS"),rs.getString("RESTRICTION_YN"));
				}			
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		setRestrictData(restrictMap); 
	}
	public void restrictDataSelectAll(String restrictId,String restrictType,String restrictHistyType,String local,String selectall) throws Exception {
	//	Connection con		= null;//Common-ICN-0092  
	//	PreparedStatement stmt = null;//Common-ICN-0092  
	//	ResultSet rs			= null;//Common-ICN-0092  
		ArrayList selectResult=new ArrayList();
		HashMap <String ,String> restrictMap=getRestrictData();
		try{
			if("H".equals(restrictType)){
				selectResult=(ArrayList)getHistRecType(local);
				if("Y".equals(selectall)){
					for(int i =0;i<selectResult.size();i++){
						String[] histyTypeDetails= (String[])selectResult.get(i);
						restrictMap.put(restrictId+"|"+restrictType+"|"+histyTypeDetails[0]+"|"+"*ALL","Y");
					}
				}else if("N".equals(selectall)){
					for(int i =0;i<selectResult.size();i++){
						String[] histyTypeDetails= (String[])selectResult.get(i);
						restrictMap.remove(restrictId+"|"+restrictType+"|"+histyTypeDetails[0]+"|"+"*ALL");
					}
				}
			}else if("E".equals(restrictType)){
				selectResult=(ArrayList)getEventClass(restrictHistyType,local);
				if("Y".equals(selectall)){
					for(int i =0;i<selectResult.size();i++){
						String[] histyTypeDetails= (String[])selectResult.get(i);
						restrictMap.put(restrictId+"|"+restrictType+"|"+restrictHistyType+"|"+histyTypeDetails[0],"Y");
					}
				}else if("N".equals(selectall)){
					for(int i =0;i<selectResult.size();i++){
						String[] histyTypeDetails= (String[])selectResult.get(i);
						restrictMap.remove(restrictId+"|"+restrictType+"|"+restrictHistyType+"|"+histyTypeDetails[0]);
					}
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		setRestrictData(restrictMap); 
		
	}
}