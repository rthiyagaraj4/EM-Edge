/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eFM;

import java.io.Serializable;

public class FMFilesIssueDetail
    implements Serializable
{
    public FMFilesIssueDetail()
    {
        Index_Value = "";
        Request_From = "";
        Request_Date_Time = "";
        Curr_Facility_Id = "";
        Curr_Facility_Name = "";
        File_No = "";
        File_Type = "";
        Patient_Id = "";
        Patient_Line = "";
        Iss_Locn_Code = "";
        Iss_Locn_Desc = "";
        Iss_Locn_Identity = "";
        Rec_Locn_Code = "";
        Rec_Locn_Identity = "";
        Rec_Name = "";
        Rec_Name_Desc = "";
        Narration_Code = "";
        Movement_Narration = "";
        Iss_MR_Location = "";
        Rec_MR_Location = "";
        Remarks = "";
        Req_Remarks = "";
        Ret_Date_Time = "";
        Req_Facility_Id = "";
        Req_Facility_Name = "";
        Req_No = "";
        Src_User_Id = "";
        Src_Facility_Id = "";
        req_mode = "";
        transport_mode = "";
        carried_by = "";
        Volume_No = "";
        Third_Party_Name = "";
        Requesting_From = "";
		mlc_check = "";
		file_typedesc = "";
		requesting_from_desc="";
		req_pract="";
		 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
		Borrowing_Reason="";
		 /* end ML-MMOH-CRF-0393-IN057159  */
    }

    public FMFilesIssueDetail cloneFMFilesIssueDetail()
    {
        FMFilesIssueDetail fmfilesissuedetail = new FMFilesIssueDetail();
        fmfilesissuedetail.setIndex_Value(getIndex_Value());
        fmfilesissuedetail.setRequest_From(getRequest_From());
        fmfilesissuedetail.setRequest_Date_Time(getRequest_Date_Time());
        fmfilesissuedetail.setCurr_Facility_Id(getCurr_Facility_Id());
        fmfilesissuedetail.setCurr_Facility_Name(getCurr_Facility_Name());
        fmfilesissuedetail.setFile_No(getFile_No());
        fmfilesissuedetail.setFile_Type(getFile_Type());
        fmfilesissuedetail.setVolume_No(getVolume_No());
        fmfilesissuedetail.setThird_Party_Name(getThird_Party_Name());
        fmfilesissuedetail.setRequesting_From(getRequesting_From());
		 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
        fmfilesissuedetail.setBorrowing_Reason(getBorrowing_Reason());
		/* end ML-MMOH-CRF-0393-IN057159  */
        fmfilesissuedetail.setPatient_Id(getPatient_Id());
        fmfilesissuedetail.setPatient_Line(getPatient_Line());
        fmfilesissuedetail.setIss_Locn_Code(getIss_Locn_Code());
        fmfilesissuedetail.setIss_Locn_Desc(getIss_Locn_Desc());
        fmfilesissuedetail.setIss_Locn_Identity(getIss_Locn_Identity());
        fmfilesissuedetail.setRec_Locn_Code(getRec_Locn_Code());
        fmfilesissuedetail.setRec_Locn_Identity(getRec_Locn_Identity());
        fmfilesissuedetail.setRec_Name(getRec_Name());
        fmfilesissuedetail.setRec_Name_Desc(getRec_Name_Desc());
        fmfilesissuedetail.setNarration_Code(getNarration_Code());
        fmfilesissuedetail.setMovement_Narration(getMovement_Narration());
        fmfilesissuedetail.setIss_MR_Location(getIss_MR_Location());
        fmfilesissuedetail.setRec_MR_Location(getRec_MR_Location());
        fmfilesissuedetail.setRemarks(getRemarks());
        fmfilesissuedetail.setReq_Remarks(getReq_Remarks());
        fmfilesissuedetail.setRet_Date_Time(getRet_Date_Time());
        fmfilesissuedetail.setReq_Facility_Id(getReq_Facility_Id());
        fmfilesissuedetail.setReq_Facility_Name(getReq_Facility_Name());
        fmfilesissuedetail.setReq_No(getReq_No());
        fmfilesissuedetail.setSrc_User_Id(getSrc_User_Id());
        fmfilesissuedetail.setSrc_Facility_Id(getSrc_Facility_Id());
        fmfilesissuedetail.setREQ_MODE_1(getREQ_MODE_1());
        fmfilesissuedetail.setTransport_Mode(getTransport_Mode());
        fmfilesissuedetail.setCarried_By(getCarried_By());
		fmfilesissuedetail.setMLC_Check(getMLC_Check());
		fmfilesissuedetail.setRequesting_From_Desc(getRequesting_From_Desc());//added for MMS-QH-CRF-0146.1 [IN:045787] 
		fmfilesissuedetail.setReq_Pract(getReq_Pract()); //added for MMS-QH-CRF-0146.1 [IN:045787] 
		fmfilesissuedetail.setFile_Typedesc(getFile_Typedesc());
        return fmfilesissuedetail;
    }

    public void setSrc_User_Id(String s)
    {
        Src_User_Id = s;
    }
	//added for MMS-QH-CRF-0146.1 [IN:045787] 
 public void setRequesting_From_Desc(String s)
    {
    	requesting_from_desc = s;
    }
    

    public void setReq_Pract(String s)
    {
    	req_pract = s;
    }
    public String getRequesting_From_Desc()
    {
        return requesting_from_desc;
    }
    public String getReq_Pract()
    {
        return req_pract;
    }
	//End of  MMS-QH-CRF-0146.1 [IN:045787] 
    public void setSrc_Facility_Id(String s)
    {
        Src_Facility_Id = s;
    }

    public void setRequest_Date_Time(String s)
    {
        Request_Date_Time = s;
    }

    public void setIss_Locn_Desc(String s)
    {
        Iss_Locn_Desc = s;
    }

    public void setIndex_Value(String s)
    {
        Index_Value = s;
    }

    public void setRequest_From(String s)
    {
        Request_From = s;
    }

    public void setCurr_Facility_Id(String s)
    {
        Curr_Facility_Id = s;
    }

    public void setCurr_Facility_Name(String s)
    {
        Curr_Facility_Name = s;
    }

    public void setFile_No(String s)
    {
        File_No = s;
    }

	public void setFile_Type(String s)
    {
        File_Type = s;
    }

	public void setFile_Typedesc(String s)
    {
        file_typedesc = s;
    }

	public void setVolume_No(String s)
    {
        Volume_No = s;
    }
	
	public void setThird_Party_Name(String s)
	{
		Third_Party_Name = s;
	}

	public void setRequesting_From(String s)
	{
		Requesting_From = s;
	}

    public void setPatient_Id(String s)
    {
        Patient_Id = s;
    }

    public void setPatient_Line(String s)
    {
        Patient_Line = s;
    }

    public void setIss_Locn_Code(String s)
    {
        Iss_Locn_Code = s;
    }

    public void setIss_Locn_Identity(String s)
    {
        Iss_Locn_Identity = s;
    }

    public void setRec_Locn_Code(String s)
    {
        Rec_Locn_Code = s;
    }

    public void setRec_Locn_Identity(String s)
    {
        Rec_Locn_Identity = s;
    }

    public void setRec_Name(String s)
    {
        Rec_Name = s;
    }

    public void setRec_Name_Desc(String s)
    {
        Rec_Name_Desc = s;
    }

    public void setNarration_Code(String s)
    {
        Narration_Code = s;
    }

    public void setMovement_Narration(String s)
    {
        Movement_Narration = s;
    }

    public void setIss_MR_Location(String s)
    {
        Iss_MR_Location = s;
    }

    public void setRec_MR_Location(String s)
    {
        Rec_MR_Location = s;
    }

    public void setRemarks(String s)
    {
        Remarks = s;
    }

    public void setReq_Remarks(String s)
    {
        Req_Remarks = s;
    }

    public void setRet_Date_Time(String s)
    {
        Ret_Date_Time = s;
    }

    public void setReq_Facility_Id(String s)
    {
        Req_Facility_Id = s;
    }

    public void setReq_Facility_Name(String s)
    {
        Req_Facility_Name = s;
    }

    public void setReq_No(String s)
    {
        Req_No = s;
    }

    public void setREQ_MODE_1(String s)
    {
        req_mode = s;
    }

    public String getREQ_MODE_1()
    {
        return req_mode;
    }

    public void setTransport_Mode(String s)
    {
        transport_mode = s;
    }

    public String getTransport_Mode()
    {
        return transport_mode;
    }

    public void setCarried_By(String s)
    {
        carried_by = s;
    }	

    public String getCarried_By()
    {
        return carried_by;
    }

	 public void setMLC_Check(String s)
    {
        mlc_check = s;
    }
 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
	 public void setBorrowing_Reason(String s)
    {
	
        Borrowing_Reason = s;
    }
 /* end ML-MMOH-CRF-0393-IN057159  */
	public String getMLC_Check()
    {
        return mlc_check;
    }

    public String getSrc_User_Id()
    {
        return Src_User_Id;
    }

    public String getSrc_Facility_Id()
    {
        return Src_Facility_Id;
    }

    public String getRequest_Date_Time()
    {
        return Request_Date_Time;
    }

    public String getIss_Locn_Desc()
    {
        return Iss_Locn_Desc;
    }

    public String getIndex_Value()
    {
        return Index_Value;
    }

    public String getRequest_From()
    {
        return Request_From;
    }

    public String getCurr_Facility_Id()
    {
        return Curr_Facility_Id;
    }

    public String getCurr_Facility_Name()
    {
        return Curr_Facility_Name;
    }

    public String getFile_No()
    {
        return File_No;
    }

	public String getFile_Type()
    {
        return File_Type;
    }

	public String getFile_Typedesc()
    {
        return file_typedesc;
    }

	public String getVolume_No()
    {
        return Volume_No;
    }

	public String getThird_Party_Name()
	{
		return Third_Party_Name;
	}

	public String getRequesting_From()
	{
		return Requesting_From;
	}

    public String getPatient_Id()
    {
        return Patient_Id;
    }

    public String getPatient_Line()
    {
        return Patient_Line;
    }

    public String getIss_Locn_Code()
    {
        return Iss_Locn_Code;
    }

    public String getIss_Locn_Identity()
    {
        return Iss_Locn_Identity;
    }

    public String getRec_Locn_Code()
    {
        return Rec_Locn_Code;
    }

    public String getRec_Locn_Identity()
    {
        return Rec_Locn_Identity;
    }

    public String getRec_Name()
    {
        return Rec_Name;
    }

    public String getRec_Name_Desc()
    {
        return Rec_Name_Desc;
    }

    public String getNarration_Code()
    {
        return Narration_Code;
    }

    public String getMovement_Narration()
    {
        return Movement_Narration;
    }

    public String getIss_MR_Location()
    {
        return Iss_MR_Location;
    }

    public String getRec_MR_Location()
    {
        return Rec_MR_Location;
    }

    public String getRemarks()
    {
        return Remarks;
    }

    public String getReq_Remarks()
    {
        return Req_Remarks;
    }

    public String getRet_Date_Time()
    {
        return Ret_Date_Time;
    }

    public String getReq_Facility_Id()
    {
        return Req_Facility_Id;
    }

    public String getReq_Facility_Name()
    {
        return Req_Facility_Name;
    }

    public String getReq_No()
    {
        return Req_No;
    }
	
	 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
	public String getBorrowing_Reason()
	{
	
	return Borrowing_Reason;
	}
 /* end ML-MMOH-CRF-0393-IN057159  */
    String Index_Value;
    String Request_From;
    String Curr_Facility_Id;
    String Curr_Facility_Name;
    String File_No;
    String File_Type;
    String Volume_No;
    String Third_Party_Name;
    String Requesting_From;
    String Patient_Id;
    String Patient_Line;
    String Iss_Locn_Code;
    String Iss_Locn_Identity;
    String Rec_Locn_Code;
    String Rec_Locn_Identity;
    String Rec_Name;
    String Rec_Name_Desc;
    String Narration_Code;
    String Movement_Narration;
    String Iss_MR_Location;
    String Rec_MR_Location;
    String Remarks;
    String Req_Remarks;
    String Ret_Date_Time;
    String Req_Facility_Id;
    String Req_Facility_Name;
    String Req_No;
    String Request_Date_Time;
    String Iss_Locn_Desc;
    String Src_User_Id;
    String Src_Facility_Id;
    String req_mode;
    String transport_mode;
    String carried_by;
	String mlc_check;
	String file_typedesc;
	//added for MMS-QH-CRF-0146.1 [IN:045787] 
	String requesting_from_desc="";
	String req_pract="";
	 /*Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
	String Borrowing_Reason;
	 /* end ML-MMOH-CRF-0393-IN057159  */
}
