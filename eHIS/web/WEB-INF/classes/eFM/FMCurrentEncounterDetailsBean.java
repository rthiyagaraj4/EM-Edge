/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

public class FMCurrentEncounterDetailsBean {
private String assigncareloctype;
private String patientclass;
private String nursingunit;
private String room;
private String bed;
private String specility; 
private String clinic; 
private String priorityzone;
private String treatmentarea;
private String assigncarecode;
private String dischargedatetime;

private String fromnursingunit;
private String fromroom;
private String frombed;

//Audit Trail
private String transaction;
private String datetime;
private String fsLocation;
private String by;
private String reason;
private String remarks;
private String forwhom;
private String modeoftransfer;
private String carriedbyname;

//File Movement History
private String issuedfsLocation;
private String recivedfsLocation;
private String reuestremarks;
private String issuedremarks;
private String returnedremarks;
private String receiveddatetime;
private String issueddatetime;

//Holiday for MRD
private String reasonforholiday;
private String fslocationcode;
private String fslocationdescription;
private String holidaydate;
//private String holidaydate;
//End Holiday for MRD
//Current Fs location
private String requestedby;
private String issuedby;
private String transferedby;
private String movementtype;
private String narration;
private String transportdesc;
private String carriedby;	
private String transferdatetime;

private String destlocnidentity;
private String srclocnidentity;

private String canceldischarge;
/* Below line(s) added by Venkatesh.s against ML-MMOH-CRF-0393 */
private String remarkforborrow; 
/*end ML-MMOH-CRF-0393 */

//End

public void setAssignCareType(String assigncareloctype){
    this.assigncareloctype=assigncareloctype; 
}
public String getAssignCareType(){
    return assigncareloctype; 
}

public void setPatientClass(String patientclass){
    this.patientclass=patientclass; 
}
public String getPatientClass(){
    return patientclass; 
}
public void setNursingUnit(String nursingunit){
   this.nursingunit=nursingunit;
}
public String getNursingUnit(){
    return nursingunit;
}
public void setRoom(String room){
   this.room=room;
}
public String getRoom(){
   return room;
}
public void setBed(String bed){
   this.bed=bed;
}
public String getBed(){
  return bed;
}
public void setSpecility(String specility){
   this.specility=specility;
}
public String getSpecility(){
   return specility;
}
public void setClinic(String clinic){
   this.clinic=clinic;
 }
public String getClinic(){
   return clinic;
 } 
public void setPriorityzone(String priorityzone){
    this.priorityzone=priorityzone;
  }
public String getPriorityzone(){
  return priorityzone;
}
public void setTreatmentarea(String treatmentarea){
   this.treatmentarea=treatmentarea;
}
public String getTreatmentarea(){
   return treatmentarea;
 }
 
 public void setFromnursingunit(String fromnursingunit){
     this.fromnursingunit=fromnursingunit;
 }
 public String getFromnursingunit(){
     return fromnursingunit;
 }
  public void setFromroom(String fromroom){
     this.fromroom=fromroom;
 }
 public String getFromroom(){
     return fromroom;
 }
  public void setFrombed(String frombed){
     this.frombed=frombed;
 }
 public String getFrombed(){
     return frombed;
 }
 /*Audit Trail*/
 public void setTransaction(String transaction){
     this.transaction=transaction;
 }
 public String getTransaction(){
     return transaction;
 }
 public void setDatetime(String datetime){
     this.datetime=datetime;
 }
 public String getDatetime(){
     return datetime;
 }
  public void setFsLocation(String fsLocation){
     this.fsLocation=fsLocation;
 }
 public String getFsLocation(){
     return fsLocation;
 }
 public void setBy(String by){
     this.by=by;
 }
 public String getBy(){
     return by;
 }
 public void setReason(String reason){
     this.reason=reason;
 }
 public String getReason(){
     return reason;
 }
  public void setRemarks(String remarks){
     this.remarks=remarks;
 }
 public String getRemarks(){
     return remarks;
 }
  public void setForwhom(String forwhom){
     this.forwhom=forwhom;
 }
 public String getForwhom(){
     return forwhom;
 }
  public void setModeoftransfer(String modeoftransfer){
     this.modeoftransfer=modeoftransfer;
 }
 public String getModeoftransfer(){
     return modeoftransfer;
 }
 public void setCarriedByName(String carriedbyname){
     this.carriedbyname=carriedbyname;
 }
 public String getCarriedByName(){
     return carriedbyname;
 }
 //End Audit trail
 //File Movement History
   public void setIssuedFsLocation(String issuedfsLocation){
     this.issuedfsLocation=issuedfsLocation;
 }
 public String getIssuedFsLocation(){
     return issuedfsLocation;
 }
 public void setReceivedFsLocation(String recivedfsLocation){
     this.recivedfsLocation=recivedfsLocation;
 }
  public String getReceivedFsLocation(){
     return recivedfsLocation;
 }
 public void setRequestRemarks(String reuestremarks){
     this.reuestremarks=reuestremarks;
 }
  public String getRequestRemarks(){
     return reuestremarks;
 }
 public void setIssueRemarks(String issuedremarks){
     this.issuedremarks=issuedremarks;
 }
   public String getIssueRemarks(){
     return issuedremarks;
 }
  public void setReturnRemarks(String returnedremarks){
     this.returnedremarks=returnedremarks;
 }
   public String getReturnRemarks(){
     return returnedremarks;
 }
 public void setIssuedDatetime(String issueddatetime){
     this.issueddatetime=issueddatetime;
 }
 public String getIssuedDatetime(){
     return issueddatetime;
 }
 public void setReceivedDatetime(String receiveddatetime){
     this.receiveddatetime=receiveddatetime;
 }
 public String getReceivedDatetime(){
     return receiveddatetime;
 }
 //Holiday for MRD
 public void setReasonforholiday(){
    this.reasonforholiday=reasonforholiday;
 }
 public String getReasonforholiday(){
    return reasonforholiday;
 }
 public void setFslocationcode(String fslocationcode){
    this.fslocationcode=fslocationcode;
 }
 public String getFslocationcode(){
    return fslocationcode;
 }
  public void setFslocationdescription(String fslocationdescription){
    this.fslocationdescription=fslocationdescription;
 }
 public String getFslocationdescription(){
    return fslocationdescription;
 }
 
  public void setHolidaydate(String holidaydate){
    this.holidaydate=holidaydate;
 }
 public String getHolidaydate(){
    return holidaydate;
 }
 
 //End Holiday for MRD
 
 //Current Fs Location
  public void setRequestedby(String requestedby){
    this.requestedby=requestedby;
 }
 public String getRequestedby(){
    return requestedby;
 }
  public void setIssuedby(String issuedby){
    this.issuedby=issuedby;
 }
 public String getIssuedby(){
    return issuedby;
 }
  public void setTransferedby(String transferedby){
    this.transferedby=transferedby;
 }
 public String getTransferedby(){
    return transferedby;
 }
 public void setMovementtype(String movementtype){
    this.movementtype=movementtype;
 }
 public String getMovementtype(){
    return movementtype;
 }
 public void setNarration(String narration){
    this.narration=narration;
 }
 public String getNarration(){
    return narration;
 }
 public void setTransportdesc(String transportdesc){
    this.transportdesc=transportdesc;
 }
 public String getTransportdesc(){
    return transportdesc;
 }
 public void setCarriedby(String carriedby){
    this.carriedby=carriedby;
 }
 public String getCarriedby(){
    return carriedby;
 }
 public void setTransferdatetime(String transferdatetime){
    this.transferdatetime=transferdatetime;
 }
 public String getTransferdatetime(){
    return transferdatetime;
 } 
 
 public void setAssigncarecode(String assigncarecode){
    this.assigncarecode=assigncarecode;
 }
 public String getAssigncarecode(){
    return assigncarecode;
 } 
 
 public void setDischargedatetime(String dischargedatetime){
    this.dischargedatetime=dischargedatetime;
 }
 public String getDischargedatetime(){
    return dischargedatetime;
 }
 
  public void setSourcelocnidentity(String srclocnidentity){
    this.srclocnidentity=srclocnidentity;
 }
 public String getSourcelocnidentity(){
    return srclocnidentity;
 }
 
  public void setDestlocnidentity(String destlocnidentity){
    this.destlocnidentity=destlocnidentity;
 }
 public String getDestlocnidentity(){
    return destlocnidentity;
 }
 
 
  public void setCanceldischarge(String canceldischarge){
    this.canceldischarge=canceldischarge;
 }
 public String getCanceldischarge(){
    return canceldischarge;
 }
 /* Below line(s) added by Venkatesh.s against ML-MMOH-CRF-0393 */
 public void setRemarkforBorrow(String remarkforborrow)
 {
 this.remarkforborrow=remarkforborrow;
 }
 
 public String getRemarkforBorrow()
 {
 return remarkforborrow;
 }
 /*end ML-MMOH-CRF-0393 */
 
 //End Current Fs location
}
