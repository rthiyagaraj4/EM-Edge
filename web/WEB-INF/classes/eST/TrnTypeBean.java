/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
//import java.util.Properties;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
import eST.Common.StAdapter;
import eCommon.SingleTableHandler.*;

public class TrnTypeBean extends StAdapter implements Serializable {

private String trnTypeCode;

private String  grn_doc_date_modifiable_yn; 
private String  rtv_doc_date_modifiable_yn; 
private String  req_doc_date_modifiable_yn; 
private String  iss_doc_date_modifiable_yn; 
private String  urg_doc_date_modifiable_yn; 
private String	mfg_doc_date_modifiable_yn; 
private String	prt_doc_date_modifiable_yn; 
private String	tfr_doc_date_modifiable_yn; 
private String	ret_doc_date_modifiable_yn; 
private String	adj_doc_date_modifiable_yn; 
private String	sal_doc_date_modifiable_yn; 
private String	srt_doc_date_modifiable_yn;
private String	var_doc_date_modifiable_yn;
private String	obs_doc_date_modifiable_yn;
private String	con_doc_date_modifiable_yn;
private String	prq_doc_date_modifiable_yn;
private String	cbl_doc_date_modifiable_yn;
private String	spb_doc_date_modifiable_yn;
private String	ceb_doc_date_modifiable_yn;


private String	grn_item_class_based_yn ;
private String	rtv_item_class_based_yn ;
private String	req_item_class_based_yn ;
private String	iss_item_class_based_yn ;
private String	urg_item_class_based_yn ;
private String	mfg_item_class_based_yn ;
private String	prt_item_class_based_yn ;
private String	tfr_item_class_based_yn ;
private String	ret_item_class_based_yn ;
private String	adj_item_class_based_yn ;
private String	sal_item_class_based_yn ;
private String	srt_item_class_based_yn ;
private String	var_item_class_based_yn ;
private String	obs_item_class_based_yn ;
private String	con_item_class_based_yn ;
private String	prq_item_class_based_yn ;
private String	cbl_item_class_based_yn ;
private String	spb_item_class_based_yn ;
private String	ceb_item_class_based_yn ;

private String	grn_records_per_trn ;
private String	rtv_records_per_trn ;
private String	req_records_per_trn ;
private String	iss_records_per_trn ;
private String	urg_records_per_trn ;
private String	mfg_records_per_trn;
private String	prt_records_per_trn ;
private String	tfr_records_per_trn ;
private String	ret_records_per_trn ;
private String	adj_records_per_trn ;
private String	sal_records_per_trn ;
private String	srt_records_per_trn ;
private String	var_records_per_trn ;
private String	obs_records_per_trn ;
private String	con_records_per_trn ;
private String	prq_records_per_trn ;
private String	cbl_records_per_trn ;
private String	spb_records_per_trn ;
private String	ceb_records_per_trn ;

private String grn_item_class_wise_documents_yn;
private String rtv_item_class_wise_documents_yn;
private String req_item_class_wise_documents_yn;
private String iss_item_class_wise_documents_yn;
private String urg_item_class_wise_documents_yn;
private String mfg_item_class_wise_documents_yn;
private String prt_item_class_wise_documents_yn;
private String tfr_item_class_wise_documents_yn;
private String ret_item_class_wise_documents_yn;
private String adj_item_class_wise_documents_yn;
private String sal_item_class_wise_documents_yn;
private String srt_item_class_wise_documents_yn;
private String var_item_class_wise_documents_yn;
private String obs_item_class_wise_documents_yn;
private String con_item_class_wise_documents_yn;
private String prq_item_class_wise_documents_yn;
private String cbl_item_class_wise_documents_yn;
private String spb_item_class_wise_documents_yn;
private String ceb_item_class_wise_documents_yn;

private String	acc_entity_id ;


 
	
	/* getter and setter method */
	public void setAcc_entity_id(String acc_entity_id) {
		 this.acc_entity_id= acc_entity_id;
	}

	public String getAcc_entity_id( ) {
		 return acc_entity_id;
	}
    public void setTrnTypeCode(String trnTypeCode) {
		 this.trnTypeCode = trnTypeCode ;
	}
	public String getTrnTypeCode() {
		 return trnTypeCode;
	}
	/*public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
	/*		inserted by Abdul Sukkur on 05/06/2007 */
   public void setGRNRecords_per_trn(String grn_records_per_trn)
	{
	   this.grn_records_per_trn=grn_records_per_trn;
	}
	public String getGRNRecords_per_trn()
	{
	   return grn_records_per_trn;
	}
    public void setRTVRecords_per_trn(String rtv_records_per_trn)
	{
	   this.rtv_records_per_trn=rtv_records_per_trn;
	}
	public String getRTVRecords_per_trn()
	{
	   return rtv_records_per_trn;
	}
	public void setREQRecords_per_trn(String req_records_per_trn)
	{
	   this.req_records_per_trn=req_records_per_trn;
	}
	public String getREQRecords_per_trn()
	{
	   return req_records_per_trn;
	}
	public void setISSRecords_per_trn(String iss_records_per_trn)
	{
	   this.iss_records_per_trn=iss_records_per_trn;
	}
	public String getISSRecords_per_trn()
	{
	   return iss_records_per_trn;
	}
	public void setURGRecords_per_trn(String urg_records_per_trn)
	{
	   this.urg_records_per_trn=urg_records_per_trn;
	}
	public String getURGRecords_per_trn()
	{
	   return urg_records_per_trn;
	}
    public void setMFGRecords_per_trn(String mfg_records_per_trn)
	{
	   this.mfg_records_per_trn=mfg_records_per_trn;
	}
	public String getMFGRecords_per_trn()
	{
	   return mfg_records_per_trn;
	}
	public void setPRTRecords_per_trn(String prt_records_per_trn)
	{
	   this.prt_records_per_trn=prt_records_per_trn;
	}
	public String getPRTRecords_per_trn()
	{
	   return prt_records_per_trn;
	}
	public void setTFRRecords_per_trn(String tfr_records_per_trn)
	{
	   this.tfr_records_per_trn=tfr_records_per_trn;
	}
	public String getTFRRecords_per_trn()
	{
	   return tfr_records_per_trn;
	}
    public void setRETRecords_per_trn(String ret_records_per_trn)
	{
	   this.ret_records_per_trn=ret_records_per_trn;
	}
	public String getRETRecords_per_trn()
	{
	   return ret_records_per_trn;
	}
     public void setADJRecords_per_trn(String adj_records_per_trn)
	{
	   this.adj_records_per_trn=adj_records_per_trn;
	}
	public String getADJRecords_per_trn()
	{
	   return adj_records_per_trn;
	}
	 public void setSALRecords_per_trn(String sal_records_per_trn)
	{
	   this.sal_records_per_trn=sal_records_per_trn;
	}
	public String getSALRecords_per_trn()
	{
	   return sal_records_per_trn;
	}
    public void setSRTRecords_per_trn(String srt_records_per_trn)
	{
	   this.srt_records_per_trn=srt_records_per_trn;
	}
	public String getSRTRecords_per_trn()
	{
	   return srt_records_per_trn;
	}
    public void setVARRecords_per_trn(String var_records_per_trn)
	{
	   this.var_records_per_trn=var_records_per_trn;
	}
	public String getVARRecords_per_trn()
	{
	   return var_records_per_trn;
	}
	 public void setOBSRecords_per_trn(String obs_records_per_trn)
	{
	   this.obs_records_per_trn=obs_records_per_trn;
	}
	public String getOBSRecords_per_trn()
	{
	   return obs_records_per_trn;
	}
    public void setCONRecords_per_trn(String con_records_per_trn)
	{
	   this.con_records_per_trn=con_records_per_trn;
	}
	public String getCONRecords_per_trn()
	{
	   return con_records_per_trn;
	}

	 public void setPRQRecords_per_trn(String prq_records_per_trn)
	{
	   this.prq_records_per_trn=prq_records_per_trn;
	}
	public String getPRQRecords_per_trn()
	{
	   return prq_records_per_trn;
	}

	public void setCBLRecords_per_trn(String cbl_records_per_trn)
	{
	   this.cbl_records_per_trn=cbl_records_per_trn;
	}
	public String getCBLRecords_per_trn()
	{
	   return cbl_records_per_trn;
	}
	public void setSPBRecords_per_trn(String spb_records_per_trn)
	{
	   this.spb_records_per_trn=spb_records_per_trn;
	}
	public String getSPBRecords_per_trn()
	{
	   return spb_records_per_trn;
	}
	public void setCEBRecords_per_trn(String ceb_records_per_trn)
	{
	   this.ceb_records_per_trn=ceb_records_per_trn;
	}
	public String getCEBRecords_per_trn()
	{
	   return ceb_records_per_trn;
	}
	/* end abdul sukkur */

   /* for doc date modifiable Y/N  */

    public void setGRNDoc_date_modifiable_yn(String grn_doc_date_modifiable_yn) {
		 this.grn_doc_date_modifiable_yn = checkForNull(grn_doc_date_modifiable_yn,"N");
	}
	public String getGRNDoc_date_modifiable_yn() {
		 return grn_doc_date_modifiable_yn;
	}

    public void setRTVDoc_date_modifiable_yn(String rtv_doc_date_modifiable_yn) {
		 this.rtv_doc_date_modifiable_yn = checkForNull(rtv_doc_date_modifiable_yn,"N");
	}
	public String getRTVDoc_date_modifiable_yn() {
		 return rtv_doc_date_modifiable_yn;
	}

    public void setREQDoc_date_modifiable_yn(String req_doc_date_modifiable_yn) {
		 this.req_doc_date_modifiable_yn = checkForNull(req_doc_date_modifiable_yn,"N");
	}
	public String getREQDoc_date_modifiable_yn() {
		 return req_doc_date_modifiable_yn;
	}

    public void setISSDoc_date_modifiable_yn(String iss_doc_date_modifiable_yn) {
		 this.iss_doc_date_modifiable_yn = checkForNull(iss_doc_date_modifiable_yn,"N");
	}
	public String getISSDoc_date_modifiable_yn() {
		 return iss_doc_date_modifiable_yn;
	}

    public void setURGDoc_date_modifiable_yn(String urg_doc_date_modifiable_yn) {
		 this.urg_doc_date_modifiable_yn = checkForNull(urg_doc_date_modifiable_yn,"N");
	}
	public String getURGDoc_date_modifiable_yn() {
		 return urg_doc_date_modifiable_yn;
	}
   
    public void setMFGDoc_date_modifiable_yn(String mfg_doc_date_modifiable_yn) {
		 this.mfg_doc_date_modifiable_yn = checkForNull(mfg_doc_date_modifiable_yn,"N");
	}
	public String getMFGDoc_date_modifiable_yn() {
		 return mfg_doc_date_modifiable_yn;
	}

   public void setPRTDoc_date_modifiable_yn(String prt_doc_date_modifiable_yn) {
		 this.prt_doc_date_modifiable_yn = checkForNull(prt_doc_date_modifiable_yn,"N");
	}
	public String getPRTDoc_date_modifiable_yn() {
		 return prt_doc_date_modifiable_yn;
	}

    public void setTFRDoc_date_modifiable_yn(String tfr_doc_date_modifiable_yn) {
		 this.tfr_doc_date_modifiable_yn = checkForNull(tfr_doc_date_modifiable_yn,"N");
	}
	public String getTFRDoc_date_modifiable_yn() {
		 return tfr_doc_date_modifiable_yn;
	}

    public void setRETDoc_date_modifiable_yn(String ret_doc_date_modifiable_yn) {
		 this.ret_doc_date_modifiable_yn = checkForNull(ret_doc_date_modifiable_yn,"N");
	}
	public String getRETDoc_date_modifiable_yn() {
		 return ret_doc_date_modifiable_yn;
	}

    public void setADJDoc_date_modifiable_yn(String adj_doc_date_modifiable_yn) {
		 this.adj_doc_date_modifiable_yn = checkForNull(adj_doc_date_modifiable_yn,"N");
	}
	public String getADJDoc_date_modifiable_yn() {
		 return adj_doc_date_modifiable_yn;
	}

    public void setSALDoc_date_modifiable_yn(String sal_doc_date_modifiable_yn) {
		 this.sal_doc_date_modifiable_yn = checkForNull(sal_doc_date_modifiable_yn,"N");
	}
	public String getSALDoc_date_modifiable_yn() {
		 return sal_doc_date_modifiable_yn;
	}

    public void setSRTDoc_date_modifiable_yn(String srt_doc_date_modifiable_yn) {
		 this.srt_doc_date_modifiable_yn = checkForNull(srt_doc_date_modifiable_yn,"N");
	}
	public String getSRTDoc_date_modifiable_yn() {
		 return srt_doc_date_modifiable_yn;
	}

    public void setVARDoc_date_modifiable_yn(String var_doc_date_modifiable_yn) {
		 this.var_doc_date_modifiable_yn = checkForNull(var_doc_date_modifiable_yn,"N");
	}
	public String getVARDoc_date_modifiable_yn() {
		 return var_doc_date_modifiable_yn;
	}

    public void setOBSDoc_date_modifiable_yn(String obs_doc_date_modifiable_yn) {
		 this.obs_doc_date_modifiable_yn = checkForNull(obs_doc_date_modifiable_yn,"N");
	}
	public String getOBSDoc_date_modifiable_yn() {
		 return obs_doc_date_modifiable_yn;
	}

  public void setCONDoc_date_modifiable_yn(String con_doc_date_modifiable_yn) {
		 this.con_doc_date_modifiable_yn = checkForNull(con_doc_date_modifiable_yn,"N");
	}
	public String getCONDoc_date_modifiable_yn() {
		 return con_doc_date_modifiable_yn;
	}
	public void setPRQDoc_date_modifiable_yn(String prq_doc_date_modifiable_yn) {
		 this. prq_doc_date_modifiable_yn = checkForNull( prq_doc_date_modifiable_yn,"N");
	}
	public String getPRQDoc_date_modifiable_yn() {
		 return prq_doc_date_modifiable_yn;
	}

	public void setCBLDoc_date_modifiable_yn(String cbl_doc_date_modifiable_yn) {
		 this.cbl_doc_date_modifiable_yn = checkForNull(cbl_doc_date_modifiable_yn,"N");
	}
	public String getCBLDoc_date_modifiable_yn() {
		 return cbl_doc_date_modifiable_yn;
	}
	public void setSPBDoc_date_modifiable_yn(String spb_doc_date_modifiable_yn) {
		 this.spb_doc_date_modifiable_yn = checkForNull(spb_doc_date_modifiable_yn,"N");
	}
	public String getSPBDoc_date_modifiable_yn() {
		 return spb_doc_date_modifiable_yn;
	}
	public void setCEBDoc_date_modifiable_yn(String ceb_doc_date_modifiable_yn) {
		 this.ceb_doc_date_modifiable_yn = checkForNull(ceb_doc_date_modifiable_yn,"N");
	}
	public String getCEBDoc_date_modifiable_yn() {
		 return ceb_doc_date_modifiable_yn;
	}

    /* for ITEM CLASS BASED Y/N */



    public void setGRNItem_class_based_yn(String grn_item_class_based_yn) {
		 this.grn_item_class_based_yn = checkForNull(grn_item_class_based_yn,"N");
	}
	public String getGRNItem_class_based_yn() {
		 return grn_item_class_based_yn;
	}

    public void setRTVItem_class_based_yn(String rtv_item_class_based_yn) {
		 this.rtv_item_class_based_yn = checkForNull(rtv_item_class_based_yn,"N");
	}
	public String getRTVItem_class_based_yn() {
		 return rtv_item_class_based_yn;
	}

    public void setREQItem_class_based_yn(String req_item_class_based_yn) {
		 this.req_item_class_based_yn = checkForNull(req_item_class_based_yn,"N");
	}
	public String getREQItem_class_based_yn() {
		 return req_item_class_based_yn;
	}

    public void setISSItem_class_based_yn(String iss_item_class_based_yn) {
		 this.iss_item_class_based_yn = checkForNull(iss_item_class_based_yn,"N");
	}
	public String getISSItem_class_based_yn() {
		 return iss_item_class_based_yn;
	}

    public void setURGItem_class_based_yn(String urg_item_class_based_yn) {
		 this.urg_item_class_based_yn = checkForNull(urg_item_class_based_yn,"N");
	}
	public String getURGItem_class_based_yn() {
		 return urg_item_class_based_yn;
	}
   
    public void setMFGItem_class_based_yn(String mfg_item_class_based_yn) {
		 this.mfg_item_class_based_yn = checkForNull(mfg_item_class_based_yn,"N");
	}
	public String getMFGItem_class_based_yn() {
		 return mfg_item_class_based_yn;
	}

    public void setPRTItem_class_based_yn(String prt_item_class_based_yn) {
		 this.prt_item_class_based_yn = checkForNull(prt_item_class_based_yn,"N");
	}
	public String getPRTItem_class_based_yn() {
		 return prt_item_class_based_yn;
	}

    public void setTFRItem_class_based_yn(String tfr_item_class_based_yn) {
		 this.tfr_item_class_based_yn = checkForNull(tfr_item_class_based_yn,"N");
	}
	public String getTFRItem_class_based_yn() {
		 return tfr_item_class_based_yn;
	}

    public void setRETItem_class_based_yn(String ret_item_class_based_yn) {
		 this.ret_item_class_based_yn = checkForNull(ret_item_class_based_yn,"N");
	}
	public String getRETItem_class_based_yn() {
		 return ret_item_class_based_yn;
	}

    public void setADJItem_class_based_yn(String adj_item_class_based_yn) {
		 this.adj_item_class_based_yn = checkForNull(adj_item_class_based_yn,"N");
	}
	public String getADJItem_class_based_yn() {
		 return adj_item_class_based_yn;
	}

    public void setSALItem_class_based_yn(String sal_item_class_based_yn) {
		 this.sal_item_class_based_yn = checkForNull(sal_item_class_based_yn,"N");
	}
	public String getSALItem_class_based_yn() {
		 return sal_item_class_based_yn;
	}

    public void setSRTItem_class_based_yn(String srt_item_class_based_yn) {
		 this.srt_item_class_based_yn = checkForNull(srt_item_class_based_yn,"N");
	}
	public String getSRTItem_class_based_yn() {
		 return srt_item_class_based_yn;
	}

    public void setVARItem_class_based_yn(String var_item_class_based_yn) {
		 this.var_item_class_based_yn = checkForNull(var_item_class_based_yn,"N");
	}
	public String getVARItem_class_based_yn() {
		 return var_item_class_based_yn;
	}

    public void setOBSItem_class_based_yn(String obs_item_class_based_yn) {
		 this.obs_item_class_based_yn = checkForNull(obs_item_class_based_yn,"N");
	}
	public String getOBSItem_class_based_yn() {
		 return obs_item_class_based_yn;
	}
	public void setCONItem_class_based_yn(String con_item_class_based_yn) {
		 this.con_item_class_based_yn = checkForNull(con_item_class_based_yn,"N");
	}
	public String getCONItem_class_based_yn() {
		 return con_item_class_based_yn;
	}
	 public void setPRQItem_class_based_yn(String prq_item_class_based_yn) {
		 this.prq_item_class_based_yn = checkForNull(prq_item_class_based_yn,"N");
	}
	public String getPRQItem_class_based_yn() {
		 return prq_item_class_based_yn;
	}

	 public void setCBLItem_class_based_yn(String cbl_item_class_based_yn) {
		 this.cbl_item_class_based_yn = checkForNull(cbl_item_class_based_yn,"N");
	}
	public String getCBLItem_class_based_yn() {
		 return cbl_item_class_based_yn;
	}
	 public void setSPBItem_class_based_yn(String spb_item_class_based_yn) {
		 this.spb_item_class_based_yn = checkForNull(spb_item_class_based_yn,"N");
	}
	public String getSPBItem_class_based_yn() {
		 return spb_item_class_based_yn;
	}
	 public void setCEBItem_class_based_yn(String ceb_item_class_based_yn) {
		 this.ceb_item_class_based_yn = checkForNull(ceb_item_class_based_yn,"N");
	}
	public String getCEBItem_class_based_yn() {
		 return ceb_item_class_based_yn;
	}


 /* based on CRF 0775 related to this code... */

    public void setGRNITEM_CLASS_wise_documents_yn(String grn_item_class_wise_documents_yn) {
		 this.grn_item_class_wise_documents_yn = checkForNull(grn_item_class_wise_documents_yn,"N");
	}
	public String getGRNITEM_CLASS_wise_documents_yn() {
		 return grn_item_class_wise_documents_yn;
	}

    public void setRTVITEM_CLASS_wise_documents_yn(String rtv_item_class_wise_documents_yn) {
		 this.rtv_item_class_wise_documents_yn = checkForNull(rtv_item_class_wise_documents_yn,"N");
	}
	public String getRTVITEM_CLASS_wise_documents_yn() {
		 return rtv_item_class_wise_documents_yn;
	}
						 
    public void setREQITEM_CLASS_wise_documents_yn(String req_item_class_wise_documents_yn) {
		 this.req_item_class_wise_documents_yn = checkForNull(req_item_class_wise_documents_yn,"N");
	}
	public String getREQITEM_CLASS_wise_documents_yn() {
		 return req_item_class_wise_documents_yn;
	}

    public void setISSITEM_CLASS_wise_documents_yn(String iss_item_class_wise_documents_yn) {
		 this.iss_item_class_wise_documents_yn = checkForNull(iss_item_class_wise_documents_yn,"N");
	}
	public String getISSITEM_CLASS_wise_documents_yn() {
		 return iss_item_class_wise_documents_yn;
	}

    public void setURGITEM_CLASS_wise_documents_yn(String urg_item_class_wise_documents_yn) {
		 this.urg_item_class_wise_documents_yn = checkForNull(urg_item_class_wise_documents_yn,"N");
	}
	public String getURGITEM_CLASS_wise_documents_yn() {
		 return urg_item_class_wise_documents_yn;
	}
   
    public void setMFGITEM_CLASS_wise_documents_yn(String mfg_item_class_wise_documents_yn) {
		 this.mfg_item_class_wise_documents_yn = checkForNull(mfg_item_class_wise_documents_yn,"N");
	}
	public String getMFGITEM_CLASS_wise_documents_yn() {
		 return mfg_item_class_wise_documents_yn;
	}

    public void setPRTITEM_CLASS_wise_documents_yn(String prt_item_class_wise_documents_yn) {
		 this.prt_item_class_wise_documents_yn = checkForNull(prt_item_class_wise_documents_yn,"N");
	}
	public String getPRTITEM_CLASS_wise_documents_yn() {
		 return prt_item_class_wise_documents_yn;
	}

    public void setTFRITEM_CLASS_wise_documents_yn(String tfr_item_class_wise_documents_yn) {
		 this.tfr_item_class_wise_documents_yn = checkForNull(tfr_item_class_wise_documents_yn,"N");
	}
	public String getTFRITEM_CLASS_wise_documents_yn() {
		 return tfr_item_class_wise_documents_yn;
	}

    public void setRETITEM_CLASS_wise_documents_yn(String ret_item_class_wise_documents_yn) {
		 this.ret_item_class_wise_documents_yn = checkForNull(ret_item_class_wise_documents_yn,"N");
	}
	public String getRETITEM_CLASS_wise_documents_yn() {
		 return ret_item_class_wise_documents_yn;
	}

    public void setADJITEM_CLASS_wise_documents_yn(String adj_item_class_wise_documents_yn) {
		 this.adj_item_class_wise_documents_yn = checkForNull(adj_item_class_wise_documents_yn,"N");
	}
	public String getADJITEM_CLASS_wise_documents_yn() {
		 return adj_item_class_wise_documents_yn;
	}

    public void setSALITEM_CLASS_wise_documents_yn(String sal_item_class_wise_documents_yn) {
		 this.sal_item_class_wise_documents_yn = checkForNull(sal_item_class_wise_documents_yn,"N");
	}
	public String getSALITEM_CLASS_wise_documents_yn() {
		 return sal_item_class_wise_documents_yn;
	}

    public void setSRTITEM_CLASS_wise_documents_yn(String srt_item_class_wise_documents_yn) {
		 this.srt_item_class_wise_documents_yn = checkForNull(srt_item_class_wise_documents_yn,"N");
	}
	public String getSRTITEM_CLASS_wise_documents_yn() {
		 return srt_item_class_wise_documents_yn;
	}

    public void setVARITEM_CLASS_wise_documents_yn(String var_item_class_wise_documents_yn) {
		 this.var_item_class_wise_documents_yn = checkForNull(var_item_class_wise_documents_yn,"N");
	}
	public String getVARITEM_CLASS_wise_documents_yn() {
		 return var_item_class_wise_documents_yn;
	}

    public void setOBSITEM_CLASS_wise_documents_yn(String obs_item_class_wise_documents_yn) {
		 this.obs_item_class_wise_documents_yn = checkForNull(obs_item_class_wise_documents_yn,"N");
	}
	public String getOBSITEM_CLASS_wise_documents_yn() {
		 return obs_item_class_wise_documents_yn;
	}
	public void setCONITEM_CLASS_wise_documents_yn(String con_item_class_wise_documents_yn) {
		 this.con_item_class_wise_documents_yn = checkForNull(con_item_class_wise_documents_yn,"N");
	}
	public String getCONITEM_CLASS_wise_documents_yn() {
		 return con_item_class_wise_documents_yn;
	}
	 public void setPRQITEM_CLASS_wise_documents_yn(String prq_item_class_wise_documents_yn) {
		 this.prq_item_class_wise_documents_yn = checkForNull(prq_item_class_wise_documents_yn,"N");
	}
	public String getPRQITEM_CLASS_wise_documents_yn() {
		 return prq_item_class_wise_documents_yn;
	}

	 public void setCBLITEM_CLASS_wise_documents_yn(String cbl_item_class_wise_documents_yn) {
		 this.cbl_item_class_wise_documents_yn = checkForNull(cbl_item_class_wise_documents_yn,"N");
	}
	public String getCBLITEM_CLASS_wise_documents_yn() {
		 return cbl_item_class_wise_documents_yn;
	}
	 public void setSPBITEM_CLASS_wise_documents_yn(String spb_item_class_wise_documents_yn) {
		 this.spb_item_class_wise_documents_yn = checkForNull(spb_item_class_wise_documents_yn,"N");
	}
	public String getSPBITEM_CLASS_wise_documents_yn() {
		 return spb_item_class_wise_documents_yn;
	}
	 public void setCEBITEM_CLASS_wise_documents_yn(String ceb_item_class_wise_documents_yn) {
		 this.ceb_item_class_wise_documents_yn = checkForNull(ceb_item_class_wise_documents_yn,"N");
	}
	public String getCEBITEM_CLASS_wise_documents_yn() {
		 return ceb_item_class_wise_documents_yn;
	}// added surendra reddy



   	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setGRNDoc_date_modifiable_yn ((String) htRecordSet.get("grn_doc_date_modifiable_yn"));
		setRTVDoc_date_modifiable_yn ((String) htRecordSet.get("rtv_doc_date_modifiable_yn"));
		setREQDoc_date_modifiable_yn ((String) htRecordSet.get("req_doc_date_modifiable_yn"));
		setISSDoc_date_modifiable_yn ((String) htRecordSet.get("iss_doc_date_modifiable_yn"));
		setURGDoc_date_modifiable_yn ((String) htRecordSet.get("urg_doc_date_modifiable_yn"));
		setMFGDoc_date_modifiable_yn ((String) htRecordSet.get("mfg_doc_date_modifiable_yn"));
		setPRTDoc_date_modifiable_yn ((String) htRecordSet.get("prt_doc_date_modifiable_yn"));
		setTFRDoc_date_modifiable_yn ((String) htRecordSet.get("tfr_doc_date_modifiable_yn"));
		setRETDoc_date_modifiable_yn ((String) htRecordSet.get("ret_doc_date_modifiable_yn"));
		setADJDoc_date_modifiable_yn ((String) htRecordSet.get("adj_doc_date_modifiable_yn"));
		setSALDoc_date_modifiable_yn ((String) htRecordSet.get("sal_doc_date_modifiable_yn"));
		setSRTDoc_date_modifiable_yn ((String) htRecordSet.get("srt_doc_date_modifiable_yn"));
		setVARDoc_date_modifiable_yn ((String) htRecordSet.get("var_doc_date_modifiable_yn"));
		setOBSDoc_date_modifiable_yn ((String) htRecordSet.get("obs_doc_date_modifiable_yn"));
		setCONDoc_date_modifiable_yn ((String) htRecordSet.get("con_doc_date_modifiable_yn"));
        setPRQDoc_date_modifiable_yn ((String) htRecordSet.get("prq_doc_date_modifiable_yn")); 
		setCBLDoc_date_modifiable_yn ((String) htRecordSet.get("cbl_doc_date_modifiable_yn")); 
		setSPBDoc_date_modifiable_yn ((String) htRecordSet.get("spb_doc_date_modifiable_yn")); 
		setCEBDoc_date_modifiable_yn ((String) htRecordSet.get("ceb_doc_date_modifiable_yn")); 

		setGRNItem_class_based_yn ((String) htRecordSet.get("grn_item_class_based_yn"));
		setRTVItem_class_based_yn ((String) htRecordSet.get("rtv_item_class_based_yn"));
		setREQItem_class_based_yn ((String) htRecordSet.get("req_item_class_based_yn"));
		setISSItem_class_based_yn ((String) htRecordSet.get("iss_item_class_based_yn"));
		setURGItem_class_based_yn ((String) htRecordSet.get("urg_item_class_based_yn"));
		setMFGItem_class_based_yn ((String) htRecordSet.get("mfg_item_class_based_yn"));
		setPRTItem_class_based_yn ((String) htRecordSet.get("prt_item_class_based_yn"));
		setTFRItem_class_based_yn ((String) htRecordSet.get("tfr_item_class_based_yn"));
		setRETItem_class_based_yn ((String) htRecordSet.get("ret_item_class_based_yn"));
		setADJItem_class_based_yn ((String) htRecordSet.get("adj_item_class_based_yn"));
		setSALItem_class_based_yn ((String) htRecordSet.get("sal_item_class_based_yn"));
		setSRTItem_class_based_yn ((String) htRecordSet.get("srt_item_class_based_yn"));
		setVARItem_class_based_yn ((String) htRecordSet.get("var_item_class_based_yn"));
		setOBSItem_class_based_yn ((String) htRecordSet.get("obs_item_class_based_yn"));
		setCONItem_class_based_yn ((String) htRecordSet.get("con_item_class_based_yn"));
		setPRQItem_class_based_yn ((String) htRecordSet.get("prq_item_class_based_yn"));
		setCBLItem_class_based_yn ((String) htRecordSet.get("cbl_item_class_based_yn"));
		setSPBItem_class_based_yn ((String) htRecordSet.get("spb_item_class_based_yn"));
		setCEBItem_class_based_yn ((String) htRecordSet.get("ceb_item_class_based_yn"));

		setGRNRecords_per_trn((String) htRecordSet.get("grn_records_per_trn"));
	    setRTVRecords_per_trn((String) htRecordSet.get("rtv_records_per_trn"));
	    setREQRecords_per_trn((String) htRecordSet.get("req_records_per_trn"));
	    setISSRecords_per_trn((String) htRecordSet.get("iss_records_per_trn"));
	    setURGRecords_per_trn((String) htRecordSet.get("urg_records_per_trn"));
		setMFGRecords_per_trn((String) htRecordSet.get("mfg_records_per_trn"));
	    setPRTRecords_per_trn((String) htRecordSet.get("prt_records_per_trn"));
	    setTFRRecords_per_trn((String) htRecordSet.get("tfr_records_per_trn"));
	    setRETRecords_per_trn((String) htRecordSet.get("ret_records_per_trn"));
	    setADJRecords_per_trn((String) htRecordSet.get("adj_records_per_trn"));
	    setSALRecords_per_trn((String) htRecordSet.get("sal_records_per_trn"));
	    setSRTRecords_per_trn((String) htRecordSet.get("srt_records_per_trn"));
	   	setVARRecords_per_trn((String) htRecordSet.get("var_records_per_trn"));
	    setOBSRecords_per_trn((String) htRecordSet.get("obs_records_per_trn"));
		setCONRecords_per_trn((String) htRecordSet.get("con_records_per_trn"));
		setPRQRecords_per_trn((String) htRecordSet.get("prq_records_per_trn"));
		setCBLRecords_per_trn((String) htRecordSet.get("cbl_records_per_trn"));
		setSPBRecords_per_trn((String) htRecordSet.get("spb_records_per_trn"));
		setCEBRecords_per_trn((String) htRecordSet.get("ceb_records_per_trn"));


        setGRNITEM_CLASS_wise_documents_yn((String) htRecordSet.get("grn_item_class_wise_documents_yn"));
	    setRTVITEM_CLASS_wise_documents_yn((String) htRecordSet.get("rtv_item_class_wise_documents_yn"));
	    setREQITEM_CLASS_wise_documents_yn((String) htRecordSet.get("req_item_class_wise_documents_yn"));
	    setISSITEM_CLASS_wise_documents_yn((String) htRecordSet.get("iss_item_class_wise_documents_yn"));
	    setURGITEM_CLASS_wise_documents_yn((String) htRecordSet.get("urg_item_class_wise_documents_yn"));
	   	setMFGITEM_CLASS_wise_documents_yn((String) htRecordSet.get("mfg_item_class_wise_documents_yn"));
	    setPRTITEM_CLASS_wise_documents_yn((String) htRecordSet.get("prt_item_class_wise_documents_yn"));
	    setTFRITEM_CLASS_wise_documents_yn((String) htRecordSet.get("tfr_item_class_wise_documents_yn"));
	    setRETITEM_CLASS_wise_documents_yn((String) htRecordSet.get("ret_item_class_wise_documents_yn"));
	    setADJITEM_CLASS_wise_documents_yn((String) htRecordSet.get("adj_item_class_wise_documents_yn"));
	    setSALITEM_CLASS_wise_documents_yn((String) htRecordSet.get("sal_item_class_wise_documents_yn"));
	    setSRTITEM_CLASS_wise_documents_yn((String) htRecordSet.get("srt_item_class_wise_documents_yn"));
	    setVARITEM_CLASS_wise_documents_yn((String) htRecordSet.get("var_item_class_wise_documents_yn"));
	    setOBSITEM_CLASS_wise_documents_yn((String) htRecordSet.get("obs_item_class_wise_documents_yn"));
		setCONITEM_CLASS_wise_documents_yn((String) htRecordSet.get("con_item_class_wise_documents_yn"));
		setPRQITEM_CLASS_wise_documents_yn((String) htRecordSet.get("prq_item_class_wise_documents_yn"));
		setCBLITEM_CLASS_wise_documents_yn((String) htRecordSet.get("cbl_item_class_wise_documents_yn"));
		setSPBITEM_CLASS_wise_documents_yn((String) htRecordSet.get("spb_item_class_wise_documents_yn"));
		setCEBITEM_CLASS_wise_documents_yn((String) htRecordSet.get("ceb_item_class_wise_documents_yn"));


   }  


   public void clear(){
       super.clear();
       grn_doc_date_modifiable_yn="";
	   rtv_doc_date_modifiable_yn="";
	   req_doc_date_modifiable_yn="";
	   iss_doc_date_modifiable_yn="";
	   urg_doc_date_modifiable_yn="";
	   mfg_doc_date_modifiable_yn="";
	   prt_doc_date_modifiable_yn="";
	   tfr_doc_date_modifiable_yn="";
	   ret_doc_date_modifiable_yn="";
	   adj_doc_date_modifiable_yn="";
	   sal_doc_date_modifiable_yn="";
	   srt_doc_date_modifiable_yn="";
	   var_doc_date_modifiable_yn="";
	   obs_doc_date_modifiable_yn="";
	   con_doc_date_modifiable_yn="";
	   prq_doc_date_modifiable_yn="";
	   cbl_doc_date_modifiable_yn="";
	   spb_doc_date_modifiable_yn="";
	   ceb_doc_date_modifiable_yn="";

	   grn_item_class_based_yn="";
	   rtv_item_class_based_yn="";
	   req_item_class_based_yn="";
	   iss_item_class_based_yn="";
	   urg_item_class_based_yn="";
	   mfg_item_class_based_yn="";
	   prt_item_class_based_yn="";
	   tfr_item_class_based_yn="";
	   ret_item_class_based_yn="";
	   adj_item_class_based_yn="";
	   sal_item_class_based_yn="";
	   srt_item_class_based_yn="";
	   var_item_class_based_yn="";
	   obs_item_class_based_yn="";
	   con_item_class_based_yn="";
	   prq_item_class_based_yn="";
	   cbl_item_class_based_yn="";
	   spb_item_class_based_yn="";
	   ceb_item_class_based_yn="";

	   grn_records_per_trn="";
       rtv_records_per_trn="";
		req_records_per_trn="";
		iss_records_per_trn="" ;
		urg_records_per_trn="" ;
		mfg_records_per_trn="";
		prt_records_per_trn="" ;
		tfr_records_per_trn="";
		ret_records_per_trn="" ;
		adj_records_per_trn ="";
		sal_records_per_trn ="";
		srt_records_per_trn="" ;
		var_records_per_trn="" ;
		obs_records_per_trn="" ;
		con_records_per_trn="" ;
		prq_records_per_trn ="";
		cbl_records_per_trn ="";
		spb_records_per_trn ="";
		ceb_records_per_trn ="";

		grn_item_class_wise_documents_yn="";
		rtv_item_class_wise_documents_yn="";
		req_item_class_wise_documents_yn="";
		iss_item_class_wise_documents_yn="";
		urg_item_class_wise_documents_yn="";
		mfg_item_class_wise_documents_yn="";
		prt_item_class_wise_documents_yn="";
		tfr_item_class_wise_documents_yn="";
		ret_item_class_wise_documents_yn="";
		adj_item_class_wise_documents_yn="";
		sal_item_class_wise_documents_yn="";
		srt_item_class_wise_documents_yn="";
		var_item_class_wise_documents_yn="";
		obs_item_class_wise_documents_yn="";
		con_item_class_wise_documents_yn="";
		prq_item_class_wise_documents_yn="";
		cbl_item_class_wise_documents_yn="";
		spb_item_class_wise_documents_yn="";
		ceb_item_class_wise_documents_yn="";


   }
   
   public ArrayList loadData() throws Exception {
	
	String interface_to_external_po_yn= checkForNull((String)fetchRecord("SELECT NVL (INTERFACE_TO_EXTERNAL_PO_YN, 'N') INTERFACE_TO_EXTERNAL_PO_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",getAcc_entity_id()).get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");
	if(interface_to_external_po_yn.equals("Y")){
		return fetchRecords("SELECT TRN_TYPE, LONG_DESC, SHORT_DESC, ITEM_CLASS_BASED_YN,DOC_DATE_MODIFIABLE_YN, RECORDS_PER_TRN,ITEM_CLASS_WISE_DOCUMENTS_YN FROM ST_TRN_TYPE_LANG_VW ST_TRN_TYPE WHERE LANGUAGE_ID = ? AND TRN_TYPE NOT IN ('REQ') ORDER BY 3",getLanguageId());
		}else{
		return fetchRecords("SELECT TRN_TYPE, LONG_DESC, SHORT_DESC, ITEM_CLASS_BASED_YN,DOC_DATE_MODIFIABLE_YN, RECORDS_PER_TRN,ITEM_CLASS_WISE_DOCUMENTS_YN FROM ST_TRN_TYPE_LANG_VW ST_TRN_TYPE WHERE LANGUAGE_ID = ? AND TRN_TYPE NOT IN ('REQ','PRQ') ORDER BY 3",getLanguageId());
		}
   

   }

    public HashMap modify() {

		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		ArrayList	alModifyRecord=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
				
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
			
		alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getGRNItem_class_based_yn());
		alModifyRecord.add(getGRNDoc_date_modifiable_yn());
		alModifyRecord.add(getGRNRecords_per_trn());
		alModifyRecord.add(getGRNITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("GRN");
		alModifyData.add(alModifyRecord);

		alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getRTVItem_class_based_yn());
		alModifyRecord.add(getRTVDoc_date_modifiable_yn());
		alModifyRecord.add(getRTVRecords_per_trn());
		alModifyRecord.add(getRTVITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("RTV");
		alModifyData.add(alModifyRecord);

		alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getREQItem_class_based_yn());
		alModifyRecord.add(getREQDoc_date_modifiable_yn());
		alModifyRecord.add(getREQRecords_per_trn());
		alModifyRecord.add(getREQITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("REQ");
		alModifyData.add(alModifyRecord);

		alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getISSItem_class_based_yn());
		alModifyRecord.add(getISSDoc_date_modifiable_yn());
		alModifyRecord.add(getISSRecords_per_trn());
		alModifyRecord.add(getISSITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("ISS");
		alModifyData.add(alModifyRecord);

		alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getURGItem_class_based_yn());
		alModifyRecord.add(getURGDoc_date_modifiable_yn());
		alModifyRecord.add(getURGRecords_per_trn());
		alModifyRecord.add(getURGITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("URG");
		alModifyData.add(alModifyRecord);

        alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getMFGItem_class_based_yn());
		alModifyRecord.add(getMFGDoc_date_modifiable_yn());
		alModifyRecord.add(getMFGRecords_per_trn());
		alModifyRecord.add(getMFGITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("MFG");
		alModifyData.add(alModifyRecord);

        alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getPRTItem_class_based_yn());
		alModifyRecord.add(getPRTDoc_date_modifiable_yn());
		alModifyRecord.add(getPRTRecords_per_trn());
		alModifyRecord.add(getPRTITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("PRT");
		alModifyData.add(alModifyRecord);

        alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getTFRItem_class_based_yn());
		alModifyRecord.add(getTFRDoc_date_modifiable_yn());
		alModifyRecord.add(getTFRRecords_per_trn());
		alModifyRecord.add(getTFRITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("TFR");
		alModifyData.add(alModifyRecord);

        alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getRETItem_class_based_yn());
		alModifyRecord.add(getRETDoc_date_modifiable_yn());
		alModifyRecord.add(getRETRecords_per_trn());
		alModifyRecord.add(getTFRITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("RET");
		alModifyData.add(alModifyRecord);

        alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getADJItem_class_based_yn());
		alModifyRecord.add(getADJDoc_date_modifiable_yn());
		alModifyRecord.add(getADJRecords_per_trn());
		alModifyRecord.add(getADJITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("ADJ");
		alModifyData.add(alModifyRecord);

        alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getSALItem_class_based_yn());
		alModifyRecord.add(getSALDoc_date_modifiable_yn());
		alModifyRecord.add(getSALRecords_per_trn());
		alModifyRecord.add(getSALITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("SAL");
		alModifyData.add(alModifyRecord);

        alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getSRTItem_class_based_yn());
		alModifyRecord.add(getSRTDoc_date_modifiable_yn());
		alModifyRecord.add(getSRTRecords_per_trn());
		alModifyRecord.add(getSRTITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("SRT");
		alModifyData.add(alModifyRecord);

        alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getVARItem_class_based_yn());
		alModifyRecord.add(getVARDoc_date_modifiable_yn());
		alModifyRecord.add(getVARRecords_per_trn());
		alModifyRecord.add(getVARITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("VAR");
		alModifyData.add(alModifyRecord);

        alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getOBSItem_class_based_yn());
		alModifyRecord.add(getOBSDoc_date_modifiable_yn());
		alModifyRecord.add(getOBSRecords_per_trn());
		alModifyRecord.add(getOBSITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("OBS");
		alModifyData.add(alModifyRecord);

		alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getCONItem_class_based_yn());
		alModifyRecord.add(getCONDoc_date_modifiable_yn());
		alModifyRecord.add(getCONRecords_per_trn());
		alModifyRecord.add(getCONITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("CON");
		alModifyData.add(alModifyRecord);

		alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getCBLItem_class_based_yn());
		alModifyRecord.add(getCBLDoc_date_modifiable_yn());
		alModifyRecord.add(getCBLRecords_per_trn());
		alModifyRecord.add(getCBLITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("CBL");
		alModifyData.add(alModifyRecord);

		alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getSPBItem_class_based_yn());
		alModifyRecord.add(getSPBDoc_date_modifiable_yn());
		alModifyRecord.add(getSPBRecords_per_trn());
		alModifyRecord.add(getSPBITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("SPB");
		alModifyData.add(alModifyRecord);

		alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getCEBItem_class_based_yn());
		alModifyRecord.add(getCEBDoc_date_modifiable_yn());
		alModifyRecord.add(getCEBRecords_per_trn());
		alModifyRecord.add(getCEBITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("CEB");
		alModifyData.add(alModifyRecord);
		try{
		String result_yn =getInterface_to_external_po_yn(getAcc_entity_id());
		if(result_yn.equals("Y")){
		alModifyRecord=	new ArrayList()	;
	    alModifyRecord.add(getPRQItem_class_based_yn());
		alModifyRecord.add(getPRQDoc_date_modifiable_yn());
		alModifyRecord.add(getPRQRecords_per_trn());
		alModifyRecord.add(getPRQITEM_CLASS_wise_documents_yn());
		alModifyRecord.add(getLoginById());      
		alModifyRecord.add(getLoginAtWsNo());    
		alModifyRecord.add(getLoginFacilityId()); 
		alModifyRecord.add("PRQ");
		alModifyData.add(alModifyRecord);
		}
		}catch(Exception e)
		{
				e.printStackTrace() ;
		}
		hmSQLMap.put( "ModifySQL", getStRepositoryValue("SQL_ST_TRN_TYPE_UPDATE"));
		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);
		hmTableData.put("LanguageData",LanguageData);
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT_BATCH );
	}
	public String getInterface_to_external_po_yn(String acc_entity_id) throws Exception {
	
//	HashMap result = fetchRecord("select INTERFACE_TO_EXTERNAL_PO_YN from st_acc_entity_param where acc_entity_id=?",acc_entity_id);
	HashMap result = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),acc_entity_id);
	String result_yn = checkForNull((String)result.get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");
	return result_yn;
	}

	//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record
	public Boolean getRecordCountForTransactionTables() {
		
		String []stParameters=	{getLoginFacilityId()};
			HashMap hmRecord	=	null;
			try{
				hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_REQUEST_HDR WHERE req_authorized_by_id IS NULL  AND FACILITY_ID = ? ", stParameters);
			}catch(Exception e){
				e.printStackTrace();
				return true;
			}
			if(!((String)hmRecord.get("COUNT")).equals("0"))
				return true;
			else
				return false;
		}
	//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record ends


} //End here
