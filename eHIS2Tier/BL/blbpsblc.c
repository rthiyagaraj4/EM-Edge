
/* Result Sets Interface */
#ifndef SQL_CRSR
#  define SQL_CRSR
  struct sql_cursor
  {
    unsigned int curocn;
    void *ptr1;
    void *ptr2;
    unsigned long magic;
  };
  typedef struct sql_cursor sql_cursor;
  typedef struct sql_cursor SQL_CURSOR;
#endif /* SQL_CRSR */

/* Thread Safety */
typedef void * sql_context;
typedef void * SQL_CONTEXT;

/* Object support */
struct sqltvn
{
  unsigned char *tvnvsn; 
  unsigned short tvnvsnl; 
  unsigned char *tvnnm;
  unsigned short tvnnml; 
  unsigned char *tvnsnm;
  unsigned short tvnsnml;
};
typedef struct sqltvn sqltvn;

struct sqladts
{
  unsigned int adtvsn; 
  unsigned short adtmode; 
  unsigned short adtnum;  
  sqltvn adttvn[1];       
};
typedef struct sqladts sqladts;

static struct sqladts sqladt = {
  1,1,0,
};

/* Binding to PL/SQL Records */
struct sqltdss
{
  unsigned int tdsvsn; 
  unsigned short tdsnum; 
  unsigned char *tdsval[1]; 
};
typedef struct sqltdss sqltdss;
static struct sqltdss sqltds =
{
  1,
  0,
};

/* File name & Package Name */
struct sqlcxp
{
  unsigned short fillen;
           char  filnam[30];
};
static const struct sqlcxp sqlfpn =
{
    29,
    "C:\\temp1\\ICN-DEMO\\Blbpsblc.pc"
};


static unsigned long sqlctx = 1480335501;


static struct sqlexd {
   unsigned int   sqlvsn;
   unsigned int   arrsiz;
   unsigned int   iters;
   unsigned int   offset;
   unsigned short selerr;
   unsigned short sqlety;
   unsigned int   occurs;
      const short *cud;
   unsigned char  *sqlest;
      const char  *stmt;
   sqladts *sqladtp;
   sqltdss *sqltdsp;
            void  **sqphsv;
   unsigned int   *sqphsl;
            int   *sqphss;
            void  **sqpind;
            int   *sqpins;
   unsigned int   *sqparm;
   unsigned int   **sqparc;
   unsigned short  *sqpadto;
   unsigned short  *sqptdso;
            void  *sqhstv[42];
   unsigned int   sqhstl[42];
            int   sqhsts[42];
            void  *sqindv[42];
            int   sqinds[42];
   unsigned int   sqharm[42];
   unsigned int   *sqharc[42];
   unsigned short  sqadto[42];
   unsigned short  sqtdso[42];
} sqlstm = {10,42};

/* SQLLIB Prototypes */
extern void sqlcxt (void **, unsigned long *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlcx2t(void **, unsigned long *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlbuft(void **, char *);
extern void sqlgs2t(void **, char *);
extern void sqlorat(void **, unsigned long *, void *);

/* Forms Interface */
static const int IAPSUCC = 0;
static const int IAPFAIL = 1403;
static const int IAPFTL  = 535;
extern void sqliem(char *, int *);

 static const char *sq0020 = 
"select RID ,RECPT_REFUND_IND ,DOC_TYPE_CODE ,DOC_NUMBER ,DOC_SRNO ,TRX_TYPE_\
CODE ,RECPT_NATURE_CODE ,DEBTOR_CATEGORY_CODE ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') \
,POST_MONTH ,POST_YEAR ,TRX_DATE_TIME ,NVL(EPISODE_TYPE,'R') ,PATIENT_ID ,NVL(\
EPISODE_ID,0) ,NVL(VISIT_ID,1) ,BILL_DOC_TYPE_CODE ,BILL_DOC_NUMBER ,CUSTOMER_\
CODE ,CASH_COUNTER_CODE ,SHIFT_ID ,DOC_AMT ,(DOC_AMT* (-1)) ,RECPT_TYPE_CODE ,\
SLMT_TYPE_CODE ,SLMT_DOC_REF_DESC ,TO_CHAR(SLMT_DOC_REF_DATE,'DD/MM/YYYY') ,SL\
MT_DOC_REMARKS ,BANK_RECON_REF ,nvl(PRINT_FLAG,'N') ,NVL(CANCELLED_IND,'N') ,N\
VL(POSTED_IND,'N') ,NARRATION ,CASH_CTRL_DOC_TYPE_CODE ,CASH_CTRL_DOC_NUMBER ,\
CASH_CTRL_DOC_DATE ,NVL(CONSOLIDATED_RECEIPT_YN,'N')  from BL_RECEIPT_REFUND_D\
TL_VW where (((OPERATING_FACILITY_ID=:b0 and DOC_DATE<=TO_DATE((:b1||' 23:59:5\
9'),'DD/MM/YYYY HH24:MI:SS')) and NVL(POSTED_IND,'N')<>'Y') and NVL(RECPT_NATU\
RE_CODE,'XX')<>'BI') order by RECPT_REFUND_IND desc ,CASH_COUNTER_CODE,SLMT_TY\
PE_CODE,DOC_TYPE_CODE,DOC_NUMBER            ";

 static const char *sq0021 = 
"select RID ,RECPT_REFUND_IND ,DOC_TYPE_CODE ,DOC_NUMBER ,TRX_TYPE_CODE ,RECP\
T_NATURE_CODE ,DEBTOR_CATEGORY_CODE ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,POST_MONT\
H ,POST_YEAR ,TRX_DATE_TIME ,NVL(EPISODE_TYPE,'R') ,PATIENT_ID ,NVL(EPISODE_ID\
,0) ,NVL(VISIT_ID,1) ,BILL_DOC_TYPE_CODE ,BILL_DOC_NUMBER ,CUSTOMER_CODE ,CASH\
_COUNTER_CODE ,SHIFT_ID ,DOC_AMT ,(DOC_AMT* (-1)) ,RECPT_TYPE_CODE ,SLMT_TYPE_\
CODE ,SLMT_DOC_REF_DESC ,TO_CHAR(SLMT_DOC_REF_DATE,'DD/MM/YYYY') ,SLMT_DOC_REM\
ARKS ,BANK_RECON_REF ,NVL(PRINT_FLAG,'N') ,NVL(CANCELLED_IND,'N') ,NVL(POSTED_\
IND,'N') ,NARRATION ,CASH_CTRL_DOC_TYPE_CODE ,CASH_CTRL_DOC_NUMBER ,CASH_CTRL_\
DOC_DATE ,NVL(CONSOLIDATED_RECEIPT_YN,'N')  from BL_RECEIPT_REFUND_DTL_VW wher\
e ((((OPERATING_FACILITY_ID=:b0 and DOC_DATE<=TO_DATE((:b1||' 23:59:59'),'DD/M\
M/YYYY HH24:MI:SS')) and NVL(POSTED_IND,'N')<>'Y') and NVL(CANCELLED_IND,'N')<\
>'Y') and NVL(RECPT_NATURE_CODE,'XX')='BI') order by RECPT_REFUND_IND desc ,CA\
SH_COUNTER_CODE,SLMT_TYPE_CODE,DOC_TYPE_CODE,DOC_NUMBER            ";

 static const char *sq0027 = 
"select DECODE(CASH_SLMT_FLAG,'A','CREDITCARD','B','CHEQUE','CASH')  from BL_\
SLMT_TYPE where SLMT_TYPE_CODE=:b0           ";

 static const char *sq0022 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,SUBLEDGER_GROUP_CODE ,SUBL\
EDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE  from BL_GL_ACCOUNT A ,\
BL_SLMT_CASH_COUNTER B ,BL_SLMT_CASH_COUNTER_INT C where ((((((((A.ACC_INT_COD\
E=C.SLMT_CTR_ACC_INT_CODE and B.SLMT_TYPE_CODE=:b0) and B.CASH_COUNTER_CODE=:b\
1) and B.OPERATING_FACILITY_ID=:b2) and B.SLMT_TYPE_CODE=C.SLMT_TYPE_CODE) and\
 B.CASH_COUNTER_CODE=C.CASH_COUNTER_CODE) and B.OPERATING_FACILITY_ID=C.OPERAT\
ING_FACILITY_ID) and TO_DATE(:b3,'DD/MM/YYYY') between NVL(C.EFF_FROM_DATE,TO_\
DATE('01/01/1900','DD/MM/YYYY')) and NVL(C.EFF_TO_DATE,SYSDATE)) and A.ACC_ENT\
ITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b\
2))           ";

 static const char *sq0023 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,SUBLEDGER_GROUP_CODE ,SUBL\
EDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE  from BL_GL_ACCOUNT A ,\
BL_RECEIPT_TYPE B ,BL_RECEIPT_TYPE_INT C where ((((((A.ACC_INT_CODE=C.RECEIPT_\
ACC_INT_CODE and B.RECEIPT_TYPE_CODE=:b0) and A.ACC_ENTITY_CODE=B.ACC_ENTITY_C\
ODE) and B.RECEIPT_TYPE_CODE=C.RECEIPT_TYPE_CODE) and B.ACC_ENTITY_CODE=C.ACC_\
ENTITY_CODE) and TO_DATE(:b1,'DD/MM/YYYY') between NVL(C.EFF_FROM_DATE,TO_DATE\
('01/01/1900','DD/MM/YYYY')) and NVL(C.EFF_TO_DATE,SYSDATE)) and A.ACC_ENTITY_\
CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b2)) \
          ";

 static const char *sq0026 = 
"select A.MAIN_ACC1_CODE ,A.MAIN_ACC2_CODE ,A.DEPT_CODE ,A.SUBLEDGER_GROUP_CO\
DE ,A.SUBLEDGER_LINE_CODE ,A.PRODUCT_GROUP_CODE ,A.PRODUCT_LINE_CODE  from BL_\
GL_ACCOUNT A ,BL_BILL_TYPE B ,BL_BILL_HDR C ,BL_BILL_TYPE_INT D where ((((((((\
(C.DOC_TYPE_CODE=:b0 and C.DOC_NUM=:b1) and B.BILL_TYPE_CODE=C.BILL_TYPE_CODE)\
 and A.ACC_INT_CODE=D.BL_RECV_ACC_INT_CODE) and C.OPERATING_FACILITY_ID=:b2) a\
nd A.ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_\
ENTITY_ID=:b2)) and B.ACC_ENTITY_CODE=A.ACC_ENTITY_CODE) and B.ACC_ENTITY_CODE\
=D.ACC_ENTITY_CODE) and B.BILL_TYPE_CODE=D.BILL_TYPE_CODE) and TRUNC(C.DOC_DAT\
E) between NVL(D.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(D.E\
FF_TO_DATE,SYSDATE))           ";

 static const char *sq0024 = 
"select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,SUBLEDGER_GROUP_CODE ,SUBL\
EDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CODE  from BL_GL_ACCOUNT A ,\
BL_RECEIPT_TYPE B ,BL_PATIENT_LEDGER C ,BL_RECEIPT_TYPE_INT D where ((((((((((\
(((C.EPISODE_TYPE=NVL(:b0,'R') and C.PATIENT_ID=:b1) and NVL(C.EPISODE_ID,0)=N\
VL(:b2,0)) and NVL(C.VISIT_ID,1)=DECODE(:b0,'I',NVL(C.VISIT_ID,1),'D',NVL(C.VI\
SIT_ID,1),nvl(:b4,1))) and C.ORG_DOC_TYPE_CODE=:b5) and C.ORG_DOC_NUM=:b6) and\
 B.RECEIPT_TYPE_CODE=C.RECPT_TYPE_CODE) and A.ACC_INT_CODE=D.RECEIPT_ACC_INT_C\
ODE) and C.OPERATING_FACILITY_ID=:b7) and A.ACC_ENTITY_CODE in (select ACC_ENT\
ITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b7)) and A.ACC_ENTITY_CODE=B\
.ACC_ENTITY_CODE) and B.ACC_ENTITY_CODE=D.ACC_ENTITY_CODE) and B.RECEIPT_TYPE_\
CODE=D.RECEIPT_TYPE_CODE) and TRUNC(C.ORG_DOC_DATE) between NVL(D.EFF_FROM_DAT\
E,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(D.EFF_TO_DATE,SYSDATE))         \
  ";

 static const char *sq0025 = 
"select A.MAIN_ACC1_CODE ,A.MAIN_ACC2_CODE ,A.DEPT_CODE ,A.SUBLEDGER_GROUP_CO\
DE ,A.SUBLEDGER_LINE_CODE ,A.PRODUCT_GROUP_CODE ,A.PRODUCT_LINE_CODE  from BL_\
GL_ACCOUNT A ,BL_BILL_TYPE B ,BL_DCP_PENDING_DOC C ,BL_BILL_TYPE_INT D where (\
(((((((((C.PATIENT_ID=:b0 and C.ORG_DOC_TYPE_CODE=:b1) and C.ORG_DOC_NUMBER=:b\
2) and B.BILL_TYPE_CODE=C.BILL_TYPE_CODE) and A.ACC_INT_CODE=D.DCP_RECV_ACC_IN\
T_CODE) and C.OPERATING_FACILITY_ID=:b3) and A.ACC_ENTITY_CODE in (select ACC_\
ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3)) and B.ACC_ENTITY_COD\
E=A.ACC_ENTITY_CODE) and B.ACC_ENTITY_CODE=D.ACC_ENTITY_CODE) and B.BILL_TYPE_\
CODE=D.BILL_TYPE_CODE) and TRUNC(C.ORG_DOC_DATE) between NVL(D.EFF_FROM_DATE,T\
O_DATE('01/01/1900','DD/MM/YYYY')) and NVL(D.EFF_TO_DATE,SYSDATE))           ";

 static const char *sq0057 = 
" for update of BILL_POSTED_FLAG ";

 static const char *sq0031 = 
"select MAN_DISC_AMT ,(-MAN_DISC_AMT) ,MAN_DISC_ACC_INT_CODE  from BL_BILL_LI\
NE where (((OPERATING_FACILITY_ID=:b0 and DOC_TYPE_CODE=:b1) and DOC_NUM=:b2) \
and NVL(MAN_DISC_AMT,0)>0)           ";

 static const char *sq0028 = 
"select distinct DOC_TYPE_CODE ,DOC_NUMBER ,PHYSICIAN_ID  from BL_PATIENT_CHA\
RGES_FOLIO where ((((OPERATING_FACILITY_ID=:b0 and BILL_DOC_TYPE_CODE=:b1) and\
 BILL_DOC_NUM=:b2) and NVL(DF_UPD_FLAG,'X')='Y') and NVL(DF_SERVICE_IND,'X')='\
D')           ";

 static const char *sq0029 = 
"_YN,'N') ,B.BILL_DOC_TYPE_CODE ,B.BILL_DOC_NUM  from BL_CANCELLED_BOUNCED_TR\
X A ,BL_BILLS_FOR_CONS_RCPT_CANC B where ((((((B.OPERATING_FACILITY_ID=:b0 and\
 A.DOC_TYPE_CODE=B.DOC_TYPE_CODE) and A.DOC_NUMBER=B.DOC_NUMBER) and A.ADDED_D\
ATE<=to_date((:b1||'235959'),'YYYYMMDDHH24MISS')) and NVL(B.POSTED_IND,'N')<>'\
Y') and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and NVL(A.CONSOLIDATE\
D_RECEIPT_YN,'N')='Y') order by 2,3,4            ";

 static const char *sq0030 = 
"select ROWID ,DOC_TYPE_CODE ,DOC_NUMBER ,TO_CHAR(NVL(ADDED_DATE,SYSDATE),'DD\
/MM/YYYY') ,CASH_CTRL_DOC_TYPE_CODE ,CASH_CTRL_DOC_NUMBER ,TO_CHAR(CASH_CTRL_D\
OC_DATE,'DD/MM/YYYY') ,SHIFT_ID ,CASH_COUNTER_CODE  from BL_CANCELLED_BILLS wh\
ere ((OPERATING_FACILITY_ID=:b0 and NVL(POSTED_IND,'N')<>'Y') and ADDED_DATE<=\
TO_DATE((:b1||' 23:59:59'),'DD/MM/YYYY HH24:MI:SS'))           ";

 static const char *sq0034 = 
"select A.MAIN_ACC1_CODE ,A.MAIN_ACC2_CODE ,A.DEPT_CODE ,A.SUBLEDGER_GROUP_CO\
DE ,A.SUBLEDGER_LINE_CODE ,A.PRODUCT_GROUP_CODE ,A.PRODUCT_LINE_CODE  from BL_\
GL_ACCOUNT A where (A.ACC_INT_CODE=:b0 and A.ACC_ENTITY_CODE in (select ACC_EN\
TITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b1))           ";

 static const char *sq0035 = 
"select A.MAIN_ACC1_CODE ,A.MAIN_ACC2_CODE ,A.DEPT_CODE ,A.SUBLEDGER_GROUP_CO\
DE ,A.SUBLEDGER_LINE_CODE ,A.PRODUCT_GROUP_CODE ,A.PRODUCT_LINE_CODE  from BL_\
GL_ACCOUNT A ,BL_BILL_HDR C ,BL_BILL_TYPE_INT D where (((((((C.OPERATING_FACIL\
ITY_ID=:b0 and C.DOC_TYPE_CODE=:b1) and C.DOC_NUM=:b2) and A.ACC_INT_CODE=D.BL\
_RECV_ACC_INT_CODE) and A.ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_\
ACC_ENTITY where ACC_ENTITY_ID=:b0)) and D.ACC_ENTITY_CODE=A.ACC_ENTITY_CODE) \
and C.BILL_TYPE_CODE=D.BILL_TYPE_CODE) and TRUNC(C.DOC_DATE) between NVL(D.EFF\
_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(D.EFF_TO_DATE,SYSDATE))\
           ";

 static const char *sq0036 = 
"select A.MAIN_ACC1_CODE ,A.MAIN_ACC2_CODE ,A.DEPT_CODE ,A.SUBLEDGER_GROUP_CO\
DE ,A.SUBLEDGER_LINE_CODE ,A.PRODUCT_GROUP_CODE ,A.PRODUCT_LINE_CODE  from BL_\
GL_ACCOUNT A ,BL_DCP_PENDING_DOC C ,BL_BILL_TYPE_INT D where ((((((((C.OPERATI\
NG_FACILITY_ID=:b0 and C.PATIENT_ID=:b1) and C.ORG_DOC_TYPE_CODE=:b2) and C.OR\
G_DOC_NUMBER=:b3) and A.ACC_INT_CODE=D.DCP_RECV_ACC_INT_CODE) and A.ACC_ENTITY\
_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b0))\
 and D.ACC_ENTITY_CODE=A.ACC_ENTITY_CODE) and C.BILL_TYPE_CODE=D.BILL_TYPE_COD\
E) and TRUNC(C.ORG_DOC_DATE) between NVL(D.EFF_FROM_DATE,TO_DATE('01/01/1900',\
'DD/MM/YYYY')) and NVL(D.EFF_TO_DATE,SYSDATE))           ";

 static const char *sq0032 = 
"select B.rowid  ,B.DOC_TYPE_CODE ,B.DOC_NUM ,B.DOC_SLNO ,TO_CHAR(B.DOC_DATE,\
'DD/MM/YYYY') ,NVL(B.DOC_AMT,0) ,((-1)* NVL(B.DOC_AMT,0)) ,B.ADJ_EXEMPT_ACC_IN\
T_CODE ,B.ADJUST_EXEMPT_IND ,NVL(B.POSTED_IND,'N') ,B.POST_MONTH ,B.POST_YEAR \
,B.UNPOSTED_REASON ,NVL(B.EPISODE_TYPE,'R') ,B.EPISODE_ID ,B.VISIT_ID ,B.ADJ_D\
OC_TYPE_CODE ,B.ADJ_DOC_NUM ,TO_CHAR(B.ADJ_DOC_DATE,'DD/MM/YYYY') ,B.REMARKS ,\
NVL(B.BILL_DCP_IND,'B') ,'4' TRX_TYPE_CODE ,A.BILL_TYPE_CODE ,A.CUST_CODE  fro\
m BL_BILL_ADJ_DTL B ,BL_BILL_HDR A where (((((A.DOC_TYPE_CODE=B.ADJ_DOC_TYPE_C\
ODE and A.DOC_NUM=B.ADJ_DOC_NUM) and B.OPERATING_FACILITY_ID=:b0) and B.DOC_DA\
TE<=TO_DATE((:b1||' 23:59:59'),'DD/MM/YYYY HH24:MI:SS')) and NVL(B.POSTED_IND,\
'N')<>'Y') and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID)           ";

 static const char *sq0033 = 
"select A.rowid  ,A.DOC_TYPE_CODE ,A.DOC_NUM ,A.DOC_SLNO ,TO_CHAR(A.CANCELLED\
_DATE,'DD/MM/YYYY') ,((-1)* NVL(B.DOC_AMT,0)) ,NVL(B.DOC_AMT,0) ,A.ADJ_EXEMPT_\
ACC_INT_CODE ,B.ADJUST_EXEMPT_IND ,NVL(A.POSTED_IND,'N') ,A.POST_MONTH ,A.POST\
_YEAR ,A.UNPOSTED_REASON ,NVL(A.EPISODE_TYPE,'R') ,A.EPISODE_ID ,A.VISIT_ID ,B\
.ADJ_DOC_TYPE_CODE ,B.ADJ_DOC_NUM ,TO_CHAR(B.ADJ_DOC_DATE,'DD/MM/YYYY') ,B.REM\
ARKS ,NVL(B.BILL_DCP_IND,'B') ,'4' TRX_TYPE_CODE ,C.BILL_TYPE_CODE ,C.CUST_COD\
E  from BL_BILL_ADJ_DTL_CANC A ,BL_BILL_ADJ_DTL B ,BL_BILL_HDR C where (((((((\
((A.OPERATING_FACILITY_ID=:b0 and TRUNC(A.CANCELLED_DATE)<=TO_DATE(:b1,'DD/MM/\
YYYY')) and NVL(A.POSTED_IND,'N')<>'Y') and A.OPERATING_FACILITY_ID=B.OPERATIN\
G_FACILITY_ID) and A.DOC_TYPE_CODE=B.DOC_TYPE_CODE) and A.DOC_NUM=B.DOC_NUM) a\
nd A.DOC_SLNO=B.DOC_SLNO) and A.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID)\
 and B.ADJ_DOC_TYPE_CODE=C.DOC_TYPE_CODE) and B.ADJ_DOC_NUM=C.DOC_NUM)        \
   ";

 static const char *sq0037 = 
"select A.rowid  ,A.DOC_TYPE_CODE ,A.DOC_NUM ,A.DOC_SLNO ,TO_CHAR(A.DOC_DATE,\
'DD/MM/YYYY') ,NVL(A.WO_APPROVED_AMT,0) ,((-1)* NVL(A.WO_APPROVED_AMT,0)) ,NVL\
(A.POSTED_IND,'N') ,NVL(A.EPISODE_TYPE,'R') ,A.EPISODE_ID ,A.VISIT_ID ,A.ORG_D\
OC_TYPE_CODE ,A.ORG_DOC_NUM ,TO_CHAR(A.ORG_DOC_DATE,'DD/MM/YYYY') ,A.REMARKS ,\
'4' TRX_TYPE_CODE ,B.BILL_TYPE_CODE ,B.CUST_CODE  from BL_WO_REQUEST_DTL A ,BL\
_BILL_DCP_DTL_VW B where ((((((B.OPERATING_FACILITY_ID=:b0 and A.OPERATING_FAC\
ILITY_ID=B.OPERATING_FACILITY_ID) and A.DOC_DATE<=TO_DATE((:b1||' 23:59:59'),'\
DD/MM/YYYY HH24:MI:SS')) and NVL(A.POSTED_IND,'N')<>'Y') and NVL(WO_APPROVED_Y\
N,'N')='Y') and A.ORG_DOC_TYPE_CODE=B.DOC_TYPE_CODE) and A.ORG_DOC_NUM=B.DOC_N\
UM)           ";

 static const char *sq0039 = 
"select A.MAIN_ACC1_CODE ,A.MAIN_ACC2_CODE ,A.DEPT_CODE ,A.SUBLEDGER_GROUP_CO\
DE ,A.SUBLEDGER_LINE_CODE ,A.PRODUCT_GROUP_CODE ,A.PRODUCT_LINE_CODE  from BL_\
GL_ACCOUNT A where (A.ACC_INT_CODE=:b0 and A.ACC_ENTITY_CODE in (select ACC_EN\
TITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b1))           ";

 static const char *sq0040 = 
"select A.MAIN_ACC1_CODE ,A.MAIN_ACC2_CODE ,A.DEPT_CODE ,A.SUBLEDGER_GROUP_CO\
DE ,A.SUBLEDGER_LINE_CODE ,A.PRODUCT_GROUP_CODE ,A.PRODUCT_LINE_CODE  from BL_\
GL_ACCOUNT A where (A.ACC_INT_CODE=:b0 and A.ACC_ENTITY_CODE in (select ACC_EN\
TITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b1))           ";

 static const char *sq0041 = 
"select A.rowid  ,A.DOC_TYPE_CODE ,A.DOC_NUM ,A.DOC_SLNO ,TO_CHAR(A.CANCELLED\
_DATE,'DD/MM/YYYY') ,((-1)* NVL(C.WO_APPROVED_AMT,0)) ,NVL(C.WO_APPROVED_AMT,0\
) ,NVL(A.POSTED_IND,'N') ,NVL(A.EPISODE_TYPE,'R') ,A.EPISODE_ID ,A.VISIT_ID ,A\
.ORG_DOC_TYPE_CODE ,A.ORG_DOC_NUM ,TO_CHAR(A.ORG_DOC_DATE,'DD/MM/YYYY') ,A.CAN\
CELLED_REMARKS ,'4' TRX_TYPE_CODE ,B.BILL_TYPE_CODE ,B.CUST_CODE  from BL_WO_R\
EQUEST_CANC_DTL A ,BL_BILL_DCP_DTL_VW B ,BL_WO_REQUEST_DTL C where (((((((((B.\
OPERATING_FACILITY_ID=:b0 and A.CANCELLED_DATE<=TO_DATE((:b1||' 23:59:59'),'DD\
/MM/YYYY HH24:MI:SS')) and NVL(A.POSTED_IND,'N')<>'Y') and A.ORG_DOC_TYPE_CODE\
=B.DOC_TYPE_CODE) and A.ORG_DOC_NUM=B.DOC_NUM) and A.OPERATING_FACILITY_ID=C.O\
PERATING_FACILITY_ID) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and\
 A.DOC_TYPE_CODE=C.DOC_TYPE_CODE) and A.DOC_NUM=C.DOC_NUM) and A.DOC_SLNO=C.DO\
C_SLNO)           ";

 static const char *sq0038 = 
"select A.rowid  ,A.DOC_TYPE_CODE ,A.DOC_NUM ,A.DOC_SLNO ,TO_CHAR(A.DOC_DATE,\
'DD/MM/YYYY') ,NVL(A.WO_APPROVED_AMT,0) ,((-1)* NVL(A.WO_APPROVED_AMT,0)) ,NVL\
(A.POSTED_IND,'N') ,NVL(B.EPISODE_TYPE,'R') ,B.EPISODE_ID ,B.VISIT_ID ,A.AGGR_\
DOC_TYPE_CODE ,A.AGGR_DOC_NUM ,TO_CHAR(A.AGGR_DOC_DATE,'DD/MM/YYYY') ,A.REMARK\
S ,'4' TRX_TYPE_CODE ,B.BILL_TYPE_CODE ,B.CUST_CODE  from BL_INST_WO_REQUEST_D\
TL A ,BL_BILL_DCP_DTL_VW B where ((((((B.OPERATING_FACILITY_ID=:b0 and A.OPERA\
TING_FACILITY_ID=B.OPERATING_FACILITY_ID) and A.DOC_DATE<=TO_DATE((:b1||' 23:5\
9:59'),'DD/MM/YYYY HH24:MI:SS')) and NVL(A.POSTED_IND,'N')<>'Y') and NVL(WO_AP\
PROVED_YN,'N')='Y') and A.AGGR_DOC_TYPE_CODE=B.DOC_TYPE_CODE) and A.AGGR_DOC_N\
UM=B.DOC_NUM)           ";

 static const char *sq0042 = 
"select A.rowid  ,A.DOC_TYPE_CODE ,A.DOC_NUM ,A.DOC_SLNO ,TO_CHAR(A.CANCELLED\
_DATE,'DD/MM/YYYY') ,((-1)* NVL(C.WO_APPROVED_AMT,0)) ,NVL(C.WO_APPROVED_AMT,0\
) ,NVL(A.POSTED_IND,'N') ,NVL(B.EPISODE_TYPE,'R') ,B.EPISODE_ID ,B.VISIT_ID ,A\
.AGGR_DOC_TYPE_CODE ,A.AGGR_DOC_NUM ,TO_CHAR(A.AGGR_DOC_DATE,'DD/MM/YYYY') ,A.\
CANCELLED_REMARKS ,'4' TRX_TYPE_CODE ,B.BILL_TYPE_CODE ,B.CUST_CODE  from BL_I\
NST_WO_REQUEST_CANC_DTL A ,BL_BILL_DCP_DTL_VW B ,BL_INST_WO_REQUEST_DTL C wher\
e (((((((((B.OPERATING_FACILITY_ID=:b0 and A.CANCELLED_DATE<=TO_DATE((:b1||' 2\
3:59:59'),'DD/MM/YYYY HH24:MI:SS')) and NVL(A.POSTED_IND,'N')<>'Y') and A.AGGR\
_DOC_TYPE_CODE=B.DOC_TYPE_CODE) and A.AGGR_DOC_NUM=B.DOC_NUM) and A.OPERATING_\
FACILITY_ID=C.OPERATING_FACILITY_ID) and A.OPERATING_FACILITY_ID=B.OPERATING_F\
ACILITY_ID) and A.DOC_TYPE_CODE=C.DOC_TYPE_CODE) and A.DOC_NUM=C.DOC_NUM) and \
A.DOC_SLNO=C.DOC_SLNO)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,123,0,258,479,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
32,0,0,2,0,0,286,488,0,0,0,0,0,1,0,
47,0,0,3,22,0,257,507,0,0,0,0,0,1,0,
62,0,0,4,0,0,285,614,0,0,0,0,0,1,0,
77,0,0,5,22,0,257,636,0,0,0,0,0,1,0,
92,0,0,6,0,0,285,674,0,0,0,0,0,1,0,
107,0,0,7,123,0,258,712,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
134,0,0,8,0,0,286,725,0,0,0,0,0,1,0,
149,0,0,9,1381,0,262,733,0,0,1,1,0,1,0,1,9,0,0,
168,0,0,10,101,0,260,786,0,0,2,1,0,1,0,2,1,0,0,1,9,0,0,
191,0,0,11,30,0,299,798,0,0,0,0,0,1,0,
206,0,0,12,251,0,260,829,0,0,9,3,0,1,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
257,0,0,13,123,0,258,850,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
284,0,0,14,303,0,260,879,0,0,9,1,0,1,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,9,0,0,
2,1,0,0,2,1,0,0,2,1,0,0,1,9,0,0,
335,0,0,15,0,0,283,917,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
366,0,0,16,149,0,260,936,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
401,0,0,17,117,0,260,956,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
428,0,0,18,220,0,261,973,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
463,0,0,19,216,0,261,989,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
498,0,0,43,258,0,260,1677,0,0,8,7,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
545,0,0,44,285,0,261,1693,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
588,0,0,45,181,0,260,1712,0,0,6,4,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
627,0,0,46,564,0,259,1744,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
714,0,0,47,245,0,261,1805,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
753,0,0,48,950,0,259,1836,0,0,30,30,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
888,0,0,49,244,0,260,1947,0,0,5,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,
0,
923,0,0,50,1019,0,259,1958,0,0,29,29,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1054,0,0,51,418,0,260,2051,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1085,0,0,52,334,0,260,2088,0,0,11,9,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1144,0,0,53,309,0,260,2114,0,0,10,8,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1199,0,0,54,632,0,259,2147,0,0,25,25,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1314,0,0,55,1108,0,259,2238,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1409,0,0,20,978,0,265,2347,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1432,0,0,20,0,0,269,2433,0,0,37,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,
1595,0,0,21,1001,0,265,2532,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1618,0,0,21,0,0,269,2619,0,0,36,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
1777,0,0,27,121,0,265,2740,0,0,1,1,0,1,0,1,9,0,0,
1796,0,0,27,0,0,269,2751,0,0,1,0,0,1,0,2,9,0,0,
1815,0,0,22,714,0,265,2789,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
1850,0,0,22,0,0,269,2794,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
1893,0,0,23,632,0,265,2851,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1920,0,0,23,0,0,269,2858,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
1963,0,0,23,0,0,271,2889,0,0,0,0,0,1,0,
1978,0,0,26,731,0,265,2894,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2009,0,0,26,0,0,269,2901,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
2052,0,0,26,0,0,271,2928,0,0,0,0,0,1,0,
2067,0,0,24,936,0,265,2933,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2118,0,0,24,0,0,269,2940,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
2161,0,0,24,0,0,271,2971,0,0,0,0,0,1,0,
2176,0,0,25,777,0,265,2977,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
2211,0,0,25,0,0,269,2984,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
2254,0,0,56,140,0,260,3000,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2285,0,0,25,0,0,271,3028,0,0,0,0,0,1,0,
2300,0,0,57,1056,0,265,3176,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
2339,0,0,58,22,0,257,3188,0,0,0,0,0,1,0,
2354,0,0,59,172,0,302,3227,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2377,0,0,57,0,0,271,3246,0,0,0,0,0,1,0,
2392,0,0,28,0,0,271,3247,0,0,0,0,0,1,0,
2407,0,0,57,0,0,269,3320,0,0,35,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
2562,0,0,31,191,0,265,3398,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
2589,0,0,31,0,0,269,3414,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
2616,0,0,28,0,0,269,3443,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
2643,0,0,60,252,0,260,3470,0,0,8,3,0,1,0,2,4,0,0,2,4,0,0,2,4,0,0,2,1,0,0,2,4,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
2690,0,0,61,126,0,260,3522,0,0,2,1,0,1,0,2,1,0,0,1,9,0,0,
2713,0,0,62,301,0,261,3592,0,0,7,7,0,1,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
2756,0,0,63,240,0,261,3622,0,0,6,6,0,1,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
2795,0,0,64,183,0,260,3648,0,0,5,3,0,1,0,2,4,0,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
2830,0,0,65,126,0,260,3689,0,0,2,1,0,1,0,2,1,0,0,1,9,0,0,
2853,0,0,66,278,0,261,3759,0,0,6,6,0,1,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
2892,0,0,67,248,0,261,3788,0,0,6,6,0,1,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
2931,0,0,68,571,0,259,4065,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3026,0,0,69,580,0,259,4124,0,0,21,21,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3125,0,0,70,457,0,259,4184,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3212,0,0,71,819,0,260,4289,0,0,29,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,1,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3343,0,0,72,270,0,261,4393,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
3386,0,0,73,316,0,260,4410,0,0,11,9,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3445,0,0,28,246,0,265,4430,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
3472,0,0,28,0,0,271,4451,0,0,0,0,0,1,0,
3487,0,0,74,446,0,260,4474,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
3522,0,0,75,300,0,260,4519,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
3573,0,0,76,309,0,260,4583,0,0,10,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3628,0,0,77,446,0,260,4645,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
3663,0,0,78,300,0,260,4691,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
3714,0,0,79,309,0,260,4760,0,0,10,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
3769,0,0,80,22,0,257,4850,0,0,0,0,0,1,0,
3784,0,0,81,254,0,261,4901,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
3823,0,0,82,251,0,261,4918,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
3862,0,0,29,0,0,271,4938,0,0,0,0,0,1,0,
3877,0,0,83,31,0,260,4946,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
3900,0,0,84,22,0,257,4962,0,0,0,0,0,1,0,
3915,0,0,85,220,0,261,5005,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
3950,0,0,86,216,0,261,5021,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
3985,0,0,87,31,0,260,5070,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
4008,0,0,88,244,0,260,5076,0,0,5,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,
0,
4043,0,0,89,22,0,257,5251,0,0,0,0,0,1,0,
4058,0,0,90,213,0,261,5280,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
4093,0,0,29,2485,0,265,5303,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
4124,0,0,29,0,0,269,5386,0,0,34,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
4275,0,0,30,373,0,265,5470,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
4298,0,0,30,0,0,269,5501,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
4349,0,0,91,1725,0,260,5609,0,0,42,8,0,1,0,1,3,0,0,1,3,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
4532,0,0,92,943,0,260,5712,0,0,40,6,0,1,0,1,3,0,0,1,3,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
4707,0,0,93,899,0,260,5904,0,0,32,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,1,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
4850,0,0,94,22,0,257,6005,0,0,0,0,0,1,0,
4865,0,0,95,238,0,261,6027,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
4904,0,0,96,30,0,299,6077,0,0,0,0,0,1,0,
4919,0,0,97,0,0,287,6083,0,0,0,0,0,1,0,
4934,0,0,98,156,0,262,6095,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,
4973,0,0,99,124,0,262,6117,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
5008,0,0,100,443,0,260,6141,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
5043,0,0,101,300,0,260,6186,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
5094,0,0,102,300,0,260,6256,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
5145,0,0,103,342,0,261,6431,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
5196,0,0,104,323,0,261,6451,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
5243,0,0,105,242,0,261,6473,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
5282,0,0,106,344,0,261,6492,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
5333,0,0,107,278,0,261,6510,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,
5376,0,0,108,238,0,261,6530,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
5415,0,0,109,30,0,299,6572,0,0,0,0,0,1,0,
5430,0,0,110,409,0,262,6580,0,0,6,6,0,1,0,1,97,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
5469,0,0,111,357,0,260,6602,0,0,5,4,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
5504,0,0,112,386,0,260,6647,0,0,6,5,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
5543,0,0,34,298,0,265,6682,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
5566,0,0,34,0,0,269,6687,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
5609,0,0,35,633,0,265,6742,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
5640,0,0,35,0,0,269,6750,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
5683,0,0,113,122,0,260,6770,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
5714,0,0,26,0,0,271,6806,0,0,0,0,0,1,0,
5729,0,0,36,679,0,265,6811,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
5764,0,0,36,0,0,269,6818,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
5807,0,0,114,122,0,260,6839,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
5838,0,0,25,0,0,271,6875,0,0,0,0,0,1,0,
5853,0,0,32,774,0,265,6890,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
5876,0,0,33,937,0,265,6897,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
5899,0,0,32,0,0,269,6958,0,0,24,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,3,
0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
6010,0,0,115,164,0,260,7016,0,0,6,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
6049,0,0,33,0,0,269,7082,0,0,24,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,3,
0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
6160,0,0,116,184,0,260,7144,0,0,6,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
6199,0,0,117,293,0,260,7223,0,0,9,8,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
6250,0,0,118,293,0,261,7240,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,3,0,0,1,9,0,0,
6297,0,0,119,181,0,260,7259,0,0,6,4,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
6336,0,0,120,589,0,259,7276,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
6431,0,0,121,245,0,261,7338,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
6470,0,0,122,924,0,259,7368,0,0,25,25,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
6585,0,0,123,22,0,257,7468,0,0,0,0,0,1,0,
6600,0,0,124,0,0,285,7513,0,0,0,0,0,1,0,
6615,0,0,125,22,0,257,7527,0,0,0,0,0,1,0,
6630,0,0,126,0,0,285,7564,0,0,0,0,0,1,0,
6645,0,0,127,210,0,261,7570,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
6680,0,0,128,215,0,261,7590,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
6715,0,0,37,714,0,265,7612,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
6738,0,0,37,0,0,269,7660,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,
6825,0,0,129,331,0,260,7716,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
6860,0,0,130,334,0,260,7758,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
6895,0,0,39,298,0,265,7796,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
6918,0,0,39,0,0,269,7801,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
6961,0,0,40,298,0,265,7855,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
6984,0,0,40,0,0,269,7860,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
7027,0,0,131,244,0,260,7969,0,0,5,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,
0,0,
7062,0,0,132,924,0,259,7979,0,0,25,25,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
7177,0,0,133,190,0,261,8072,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
7212,0,0,134,22,0,257,8101,0,0,0,0,0,1,0,
7227,0,0,135,0,0,285,8132,0,0,0,0,0,1,0,
7242,0,0,41,874,0,265,8141,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
7265,0,0,41,0,0,269,8186,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,
7352,0,0,136,331,0,260,52,1,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
7387,0,0,137,334,0,260,94,1,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
7422,0,0,138,195,0,261,119,1,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
7457,0,0,139,22,0,257,148,1,0,0,0,0,1,0,
7472,0,0,140,0,0,285,172,1,0,0,0,0,1,0,
7487,0,0,141,22,0,257,188,1,0,0,0,0,1,0,
7502,0,0,142,0,0,285,219,1,0,0,0,0,1,0,
7517,0,0,38,724,0,265,227,1,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
7540,0,0,38,0,0,269,275,1,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,
7627,0,0,143,331,0,260,331,1,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
7662,0,0,144,334,0,260,373,1,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
7697,0,0,145,195,0,261,395,1,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
7732,0,0,146,22,0,257,424,1,0,0,0,0,1,0,
7747,0,0,147,0,0,285,448,1,0,0,0,0,1,0,
7762,0,0,42,889,0,265,455,1,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
7785,0,0,42,0,0,269,500,1,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,
7872,0,0,148,331,0,260,558,1,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
7907,0,0,149,334,0,260,600,1,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
7942,0,0,150,200,0,261,625,1,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.10                                                 */
/************************************************************************/
/* PROGRAM NAME          : BLBPSBLC.PC                                  */
/* AUTHOR                : NITIN NAIK                                   */
/* Converted To Windows  : Prasad B G S 3/7/96                          */
/* DATE WRITTEN          : 10-SEP-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                               */ 
/*                                                                      */  
/*  FUNCTION             : Post Bills and Cashier Transactions          */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*       S. No.       TABLENAMES                 INPUT/OUTPUT           */
/*           1.       BL_RECEIPT_REFUND_DTL      Query/Update           */
/*           2.       BL_SLMT_CASH_COUNTER       Query                  */
/*           3.       BL_GL_ACCOUNT              Query                  */
/*           4.       BL_SLMT_TYPE               Query                  */
/*           5.       BL_DCP_TRN                 Insert                 */
/*           6.       BL_GL_DISTRIBUTION         Insert                 */
/*           7.       BL_PATIENT_LEDGER_TRN      Insert                 */
/*           8.       AR_REC_HDR                 Insert                 */
/*           9.       SY_PROG_PARAM              Query/Delete           */
/*          11.       BL_PARAMETERS              Query                  */
/*          12.       BL_BILLS_FOR_CONS_RECEIPT  Query/Update           */
/*          13.       BL_BILLS_FOR_CONS_RCPT_CANC Query/Update          */
/************************************************************************/
                   
/*
#define DEBUG         
*/

                 
#define RECORD_EXISTS  sqlca.sqlerrd[2]
#define LAST_ROW (sqlca.sqlcode == 1403)
#define ROW_COUNT (sqlca.sqlerrd[2])
#define BANK (0)
#define OTHER (1)
#define RECREF (0)
#define BILL (1)
#define RD (2)
#define DC (3)
#define VIEW_LOG_FILE 1

#include <stdio.h>  
#include <string.h>
#include <bl.h>

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd					[91],
            d_session_id			[20],
            d_pgm_date				[20],
	    nd_operating_facility_id	[3],
	    nd_cash_counter_code        [7] ,
	    nd_shift_id				    [2],
	    nd_reason_text				[51],
		nd_reason_text_for_update	[51],
        nd_date						[13]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[20]; } d_session_id;

struct { unsigned short len; unsigned char arr[20]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[7]; } nd_cash_counter_code;

struct { unsigned short len; unsigned char arr[2]; } nd_shift_id;

struct { unsigned short len; unsigned char arr[51]; } nd_reason_text;

struct { unsigned short len; unsigned char arr[51]; } nd_reason_text_for_update;

struct { unsigned short len; unsigned char arr[13]; } nd_date;
		

    /* STATIC INFORMATION */
    /* VARCHAR hosp_name				[30],
            date_time				[30],
            user_id					[40],
            blparam_post_month		[3],   
            blparam_post_year		[5],
			nd_acc_entity_code		[5]; */ 
struct { unsigned short len; unsigned char arr[30]; } hosp_name;

struct { unsigned short len; unsigned char arr[30]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[3]; } blparam_post_month;

struct { unsigned short len; unsigned char arr[5]; } blparam_post_year;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;



    long    next_doc_no				= 0,
            t_df_pay_alcn_num		= 0,   
            next_line_no			= 0;

            /* BL_RECEIPT_REFUND_DTL */

    /* VARCHAR recref_rowid				[21], 
		    nd_dcp_bill_type_code		[3],
            recref_recpt_refund_ind		[2],
            recref_doc_type_code		[7],
            recref_doc_number			[9],
			recref_doc_srno				[5],
            recref_trx_type_code		[2],
            recref_recpt_nature_code	[3],
            recref_debtor_category_code	[2],
            recref_doc_date				[13],
            recref_post_month			[3],
            recref_post_year			[5],	    
            recref_trx_date_time		[12],	 
            recref_episode_type			[2],
            recref_patient_id			[21],
            recref_episode_id			[9],
            recref_visit_id				[5],
            recref_bill_doc_type_code	[7],
            recref_bill_doc_number		[9],
            recref_customer_code		[9],
            recref_cash_counter_code	[7],
            recref_shift_id				[2],
            recref_doc_amt				[21],
            recref_doc_amt_negative		[21],
            recref_recpt_type_code		[4],
            recref_slmt_type_code		[3],
            recref_slmt_doc_ref_desc	[21],
            recref_slmt_doc_ref_date	[13],
            recref_slmt_doc_remarks		[31],
            recref_bank_recon_ref		[11],
            recref_print_flag			[2],
			t_bill_print_flag			[2],
            recref_cancelled_ind		[2],
			recref_dcp_ind				[2],
            recref_posted_ind			[2],
            recref_narration			[51],
			recref_cons_receipt_yn		[2],
            blsl_slmt_desc				[11],

            /o DERIVED FIELDS o/

		    disc_post_month				[3],
            disc_post_year				[5],

			wo_post_month				[3],
			wo_post_year				[5],

            bankac_main_acc1_code		[7],
            bankac_main_acc2_code		[5],
            bankac_dept_code			[11],
            bankac_subledger_group_code	[4],
            bankac_subledger_line_code	[9],
            bankac_product_group_code	[4],
            bankac_product_line_code	[5],	    

            othrac_main_acc1_code		[7],
            othrac_main_acc2_code		[5],
            othrac_dept_code			[11],
            othrac_subledger_group_code	[4],
            othrac_subledger_line_code	[9],
            othrac_product_group_code	[4],
            othrac_product_line_code	[5],
	    othrac_recpt_type_code			[3],
            dr_main_acc1_code			[7],
            dr_main_acc2_code			[5],
            dr_dept_code				[11],
            dr_subledger_group_code		[4],
            dr_subledger_line_code		[9],
            dr_product_group_code		[4],
            dr_product_line_code		[5],

            cr_main_acc1_code			[7],
            cr_main_acc2_code			[5],
            cr_dept_code				[11],
            cr_subledger_group_code		[4],
            cr_subledger_line_code		[9],
            cr_product_group_code		[4],  
            cr_product_line_code		[5],

            xxxxxx_main_acc1_code		[7],
            xxxxxx_main_acc2_code		[5],
            xxxxxx_dept_code			[11],
            xxxxxx_subledger_group_code	[4],
            xxxxxx_subledger_line_code	[9],
            xxxxxx_product_group_code	[4],
            xxxxxx_product_line_code	[5],    
            xxxxxx_doc_amt				[21],
            dflt_dept_code				[11],
            blpat_doc_amt				[21],
			nd_ws_no					[31],
			nd_doc_type					[7],
			nd_doc_num					[35],   
			nd_doc_date					[30],
			nd_dummy					[30],
			nd_bill_doc_type_code		[7],
			nd_bill_doc_num				[9]; */ 
struct { unsigned short len; unsigned char arr[21]; } recref_rowid;

struct { unsigned short len; unsigned char arr[3]; } nd_dcp_bill_type_code;

struct { unsigned short len; unsigned char arr[2]; } recref_recpt_refund_ind;

struct { unsigned short len; unsigned char arr[7]; } recref_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } recref_doc_number;

struct { unsigned short len; unsigned char arr[5]; } recref_doc_srno;

struct { unsigned short len; unsigned char arr[2]; } recref_trx_type_code;

struct { unsigned short len; unsigned char arr[3]; } recref_recpt_nature_code;

struct { unsigned short len; unsigned char arr[2]; } recref_debtor_category_code;

struct { unsigned short len; unsigned char arr[13]; } recref_doc_date;

struct { unsigned short len; unsigned char arr[3]; } recref_post_month;

struct { unsigned short len; unsigned char arr[5]; } recref_post_year;

struct { unsigned short len; unsigned char arr[12]; } recref_trx_date_time;

struct { unsigned short len; unsigned char arr[2]; } recref_episode_type;

struct { unsigned short len; unsigned char arr[21]; } recref_patient_id;

struct { unsigned short len; unsigned char arr[9]; } recref_episode_id;

struct { unsigned short len; unsigned char arr[5]; } recref_visit_id;

struct { unsigned short len; unsigned char arr[7]; } recref_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } recref_bill_doc_number;

struct { unsigned short len; unsigned char arr[9]; } recref_customer_code;

struct { unsigned short len; unsigned char arr[7]; } recref_cash_counter_code;

struct { unsigned short len; unsigned char arr[2]; } recref_shift_id;

struct { unsigned short len; unsigned char arr[21]; } recref_doc_amt;

struct { unsigned short len; unsigned char arr[21]; } recref_doc_amt_negative;

struct { unsigned short len; unsigned char arr[4]; } recref_recpt_type_code;

struct { unsigned short len; unsigned char arr[3]; } recref_slmt_type_code;

struct { unsigned short len; unsigned char arr[21]; } recref_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[13]; } recref_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[31]; } recref_slmt_doc_remarks;

struct { unsigned short len; unsigned char arr[11]; } recref_bank_recon_ref;

struct { unsigned short len; unsigned char arr[2]; } recref_print_flag;

struct { unsigned short len; unsigned char arr[2]; } t_bill_print_flag;

struct { unsigned short len; unsigned char arr[2]; } recref_cancelled_ind;

struct { unsigned short len; unsigned char arr[2]; } recref_dcp_ind;

struct { unsigned short len; unsigned char arr[2]; } recref_posted_ind;

struct { unsigned short len; unsigned char arr[51]; } recref_narration;

struct { unsigned short len; unsigned char arr[2]; } recref_cons_receipt_yn;

struct { unsigned short len; unsigned char arr[11]; } blsl_slmt_desc;

struct { unsigned short len; unsigned char arr[3]; } disc_post_month;

struct { unsigned short len; unsigned char arr[5]; } disc_post_year;

struct { unsigned short len; unsigned char arr[3]; } wo_post_month;

struct { unsigned short len; unsigned char arr[5]; } wo_post_year;

struct { unsigned short len; unsigned char arr[7]; } bankac_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } bankac_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } bankac_dept_code;

struct { unsigned short len; unsigned char arr[4]; } bankac_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } bankac_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } bankac_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } bankac_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } othrac_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } othrac_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } othrac_dept_code;

struct { unsigned short len; unsigned char arr[4]; } othrac_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } othrac_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } othrac_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } othrac_product_line_code;

struct { unsigned short len; unsigned char arr[3]; } othrac_recpt_type_code;

struct { unsigned short len; unsigned char arr[7]; } dr_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } dr_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } dr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } dr_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } dr_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } dr_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } dr_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } cr_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } cr_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } cr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } cr_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } cr_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } cr_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } cr_product_line_code;

struct { unsigned short len; unsigned char arr[7]; } xxxxxx_main_acc1_code;

struct { unsigned short len; unsigned char arr[5]; } xxxxxx_main_acc2_code;

struct { unsigned short len; unsigned char arr[11]; } xxxxxx_dept_code;

struct { unsigned short len; unsigned char arr[4]; } xxxxxx_subledger_group_code;

struct { unsigned short len; unsigned char arr[9]; } xxxxxx_subledger_line_code;

struct { unsigned short len; unsigned char arr[4]; } xxxxxx_product_group_code;

struct { unsigned short len; unsigned char arr[5]; } xxxxxx_product_line_code;

struct { unsigned short len; unsigned char arr[21]; } xxxxxx_doc_amt;

struct { unsigned short len; unsigned char arr[11]; } dflt_dept_code;

struct { unsigned short len; unsigned char arr[21]; } blpat_doc_amt;

struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type;

struct { unsigned short len; unsigned char arr[35]; } nd_doc_num;

struct { unsigned short len; unsigned char arr[30]; } nd_doc_date;

struct { unsigned short len; unsigned char arr[30]; } nd_dummy;

struct { unsigned short len; unsigned char arr[7]; } nd_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_bill_doc_num;


    /* VARCHAR patltr_rowid				[21],
            patltr_max_line_num			[10],
            pendoc_rowid				[21],
            pendoc_max_line_num			[10]; */ 
struct { unsigned short len; unsigned char arr[21]; } patltr_rowid;

struct { unsigned short len; unsigned char arr[10]; } patltr_max_line_num;

struct { unsigned short len; unsigned char arr[21]; } pendoc_rowid;

struct { unsigned short len; unsigned char arr[10]; } pendoc_max_line_num;

	 

    char    dummy,
	    d_pmnt_mode,
	    l_mesg[300],
	    nd_cash_control_use_flag,
	    d_pmnt_status;

    /******* TEMP **********/

		/* VARCHAR	t_doc_type_code     [7],
				t_doc_num           [9],
				t_doc_date          [13],
				t_dpf_doc_type_code [7],
				t_dpf_doc_number    [9],
				t_bill_type_code    [3],
                t_overall_int_code  [7],
                t_round_int_code    [7],
                t_man_int_code      [7],
                t_bill_type_int_code[7],
				t_bill_disc_recv_acc_int_code[7],
                t_tot_disc_char     [21],
                t_tot_disc_nega     [21],
                t_man_disc_char     [21],
                t_man_disc_nega     [21],
				t_physician_id      [16]; */ 
struct { unsigned short len; unsigned char arr[7]; } t_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } t_doc_num;

struct { unsigned short len; unsigned char arr[13]; } t_doc_date;

struct { unsigned short len; unsigned char arr[7]; } t_dpf_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } t_dpf_doc_number;

struct { unsigned short len; unsigned char arr[3]; } t_bill_type_code;

struct { unsigned short len; unsigned char arr[7]; } t_overall_int_code;

struct { unsigned short len; unsigned char arr[7]; } t_round_int_code;

struct { unsigned short len; unsigned char arr[7]; } t_man_int_code;

struct { unsigned short len; unsigned char arr[7]; } t_bill_type_int_code;

struct { unsigned short len; unsigned char arr[7]; } t_bill_disc_recv_acc_int_code;

struct { unsigned short len; unsigned char arr[21]; } t_tot_disc_char;

struct { unsigned short len; unsigned char arr[21]; } t_tot_disc_nega;

struct { unsigned short len; unsigned char arr[21]; } t_man_disc_char;

struct { unsigned short len; unsigned char arr[21]; } t_man_disc_nega;

struct { unsigned short len; unsigned char arr[16]; } t_physician_id;


    char	t_bill_posted_flag,
			t_bill_status;

    double      t_bill_drfee_tot_amt,
				t_bill_drfee_tot_outst_amt,
				t_bill_hosp_tot_outst_amt,
				t_drfee_amt,
                t_org_rec_amt,
                t_man_disc_amt,
                t_tot_disc_amt,
                t_overall_disc_amt,
				t_recpt_amt,
				tot_alloc_amt;

    double      rec_remaining_amt,
                df_pend_amt,
                cust_outst_amt,
                df_alloc_amt,
				t_round_amt;    

	
    /* VARCHAR	df_doc_type_code     [7],
			df_doc_num           [9],
			df_doc_date          [13],
			visit_id_fm          [5],
			visit_id_to          [5],
			df_physician_id      [16],
			t_sign_ind           [2]; */ 
struct { unsigned short len; unsigned char arr[7]; } df_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } df_doc_num;

struct { unsigned short len; unsigned char arr[13]; } df_doc_date;

struct { unsigned short len; unsigned char arr[5]; } visit_id_fm;

struct { unsigned short len; unsigned char arr[5]; } visit_id_to;

struct { unsigned short len; unsigned char arr[16]; } df_physician_id;

struct { unsigned short len; unsigned char arr[2]; } t_sign_ind;



    /* VARCHAR t_episode_type         [2],
	        t_patient_id           [21],
			t_episode_id           [9],
			t_visit_id             [5],
			t_bill_trx_type_code   [2],
			t_bill_nature_code     [2],
			t_bill_tot_amt         [23],
			t_bill_tot_outst_amt   [23],
			t_prv_bill_tot_outst_amt [23],
			t_added_by_id          [31],
			t_modified_by_id       [31],
			t_added_date           [31],
			t_modified_date        [31]; */ 
struct { unsigned short len; unsigned char arr[2]; } t_episode_type;

struct { unsigned short len; unsigned char arr[21]; } t_patient_id;

struct { unsigned short len; unsigned char arr[9]; } t_episode_id;

struct { unsigned short len; unsigned char arr[5]; } t_visit_id;

struct { unsigned short len; unsigned char arr[2]; } t_bill_trx_type_code;

struct { unsigned short len; unsigned char arr[2]; } t_bill_nature_code;

struct { unsigned short len; unsigned char arr[23]; } t_bill_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } t_bill_tot_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } t_prv_bill_tot_outst_amt;

struct { unsigned short len; unsigned char arr[31]; } t_added_by_id;

struct { unsigned short len; unsigned char arr[31]; } t_modified_by_id;

struct { unsigned short len; unsigned char arr[31]; } t_added_date;

struct { unsigned short len; unsigned char arr[31]; } t_modified_date;


   long t_ref_num,
		t_start_ref_num,
		ae_doc_slno,
		ae_post_month,
		ae_post_year,                              
		ae_episode_id,                             
		ae_visit_id,
		wo_doc_slno,
		wo_episode_id,
		wo_visit_id;
    
/* VARCHAR t_tmp_date			[9],
		nd_error_level		[10],
		nd_sys_message_id	[10],
		nd_error_text		[1000]; */ 
struct { unsigned short len; unsigned char arr[9]; } t_tmp_date;

struct { unsigned short len; unsigned char arr[10]; } nd_error_level;

struct { unsigned short len; unsigned char arr[10]; } nd_sys_message_id;

struct { unsigned short len; unsigned char arr[1000]; } nd_error_text;


    /* VARCHAR     c_recpt_refund_ind      [2],
                c_doc_type_code         [7],
                c_doc_number            [9],
				c_doc_srno              [5],
                c_cancelled_ind         [2],
                c_bounced_yn            [2],
                c_bounced_status_ind    [2],
                c_narration             [51],
				c_cancelled_date        [13],
				c_bounced_date          [13],
				c_bounced_status_date   [13],
				c_post_date             [13],
				c_trx_rowid				[21],
				c_cons_rec_yn			[2],
				c_bill_doc_type_code    [7],
				c_bill_doc_num			[9],
				ae_rowid				[30],
				ae_doc_type_code		[7],                   	       	                                      
				ae_doc_num				[20],
				ae_doc_date				[30],                                
				ae_adj_exempt_acc_int_code[7],                
				ae_adjust_exempt_ind	[2],                      
				ae_posted_ind			[2],	                                    	       
				ae_bill_type_code		[3],
				ae_unposted_reason		[51],                        
				ae_episode_type			[2],	       	       
				ae_adj_doc_type_code	[7],               	       
				ae_adj_doc_num			[30],
				ae_adj_doc_date			[30],
				ae_remarks				[201],                    	
				ae_bill_dcp_ind			[2],
				ae_trx_type_code		[2],
				ae_patient_id			[21],
				ae_doc_amt				[30],
				ae_doc_rev_amt			[30],
				ae_cancelled_ind		[2],
				ae_adj_exm_doc_ref		[31],
				ae_cust_code			[9],
				wo_rowid				[30],
				wo_doc_type_code		[7],
				wo_doc_num				[20],
				wo_doc_date				[30],	
				wo_posted_ind			[2],
				wo_episode_type			[2],
				wo_org_doc_type_code	[7],
				wo_org_doc_num			[30],
				wo_org_doc_date			[30],
				wo_remarks				[201],
				wo_trx_type_code		[2],
				wo_bill_type_code		[3],
				wo_bill_recv_int_code	[7],
				wo_int_code				[7],
				wo_patient_id			[21],
				wo_doc_amt				[30],
				wo_doc_rev_amt			[30],
				wo_org_num				[30],
				wo_cust_code			[9]; */ 
struct { unsigned short len; unsigned char arr[2]; } c_recpt_refund_ind;

struct { unsigned short len; unsigned char arr[7]; } c_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } c_doc_number;

struct { unsigned short len; unsigned char arr[5]; } c_doc_srno;

struct { unsigned short len; unsigned char arr[2]; } c_cancelled_ind;

struct { unsigned short len; unsigned char arr[2]; } c_bounced_yn;

struct { unsigned short len; unsigned char arr[2]; } c_bounced_status_ind;

struct { unsigned short len; unsigned char arr[51]; } c_narration;

struct { unsigned short len; unsigned char arr[13]; } c_cancelled_date;

struct { unsigned short len; unsigned char arr[13]; } c_bounced_date;

struct { unsigned short len; unsigned char arr[13]; } c_bounced_status_date;

struct { unsigned short len; unsigned char arr[13]; } c_post_date;

struct { unsigned short len; unsigned char arr[21]; } c_trx_rowid;

struct { unsigned short len; unsigned char arr[2]; } c_cons_rec_yn;

struct { unsigned short len; unsigned char arr[7]; } c_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } c_bill_doc_num;

struct { unsigned short len; unsigned char arr[30]; } ae_rowid;

struct { unsigned short len; unsigned char arr[7]; } ae_doc_type_code;

struct { unsigned short len; unsigned char arr[20]; } ae_doc_num;

struct { unsigned short len; unsigned char arr[30]; } ae_doc_date;

struct { unsigned short len; unsigned char arr[7]; } ae_adj_exempt_acc_int_code;

struct { unsigned short len; unsigned char arr[2]; } ae_adjust_exempt_ind;

struct { unsigned short len; unsigned char arr[2]; } ae_posted_ind;

struct { unsigned short len; unsigned char arr[3]; } ae_bill_type_code;

struct { unsigned short len; unsigned char arr[51]; } ae_unposted_reason;

struct { unsigned short len; unsigned char arr[2]; } ae_episode_type;

struct { unsigned short len; unsigned char arr[7]; } ae_adj_doc_type_code;

struct { unsigned short len; unsigned char arr[30]; } ae_adj_doc_num;

struct { unsigned short len; unsigned char arr[30]; } ae_adj_doc_date;

struct { unsigned short len; unsigned char arr[201]; } ae_remarks;

struct { unsigned short len; unsigned char arr[2]; } ae_bill_dcp_ind;

struct { unsigned short len; unsigned char arr[2]; } ae_trx_type_code;

struct { unsigned short len; unsigned char arr[21]; } ae_patient_id;

struct { unsigned short len; unsigned char arr[30]; } ae_doc_amt;

struct { unsigned short len; unsigned char arr[30]; } ae_doc_rev_amt;

struct { unsigned short len; unsigned char arr[2]; } ae_cancelled_ind;

struct { unsigned short len; unsigned char arr[31]; } ae_adj_exm_doc_ref;

struct { unsigned short len; unsigned char arr[9]; } ae_cust_code;

struct { unsigned short len; unsigned char arr[30]; } wo_rowid;

struct { unsigned short len; unsigned char arr[7]; } wo_doc_type_code;

struct { unsigned short len; unsigned char arr[20]; } wo_doc_num;

struct { unsigned short len; unsigned char arr[30]; } wo_doc_date;

struct { unsigned short len; unsigned char arr[2]; } wo_posted_ind;

struct { unsigned short len; unsigned char arr[2]; } wo_episode_type;

struct { unsigned short len; unsigned char arr[7]; } wo_org_doc_type_code;

struct { unsigned short len; unsigned char arr[30]; } wo_org_doc_num;

struct { unsigned short len; unsigned char arr[30]; } wo_org_doc_date;

struct { unsigned short len; unsigned char arr[201]; } wo_remarks;

struct { unsigned short len; unsigned char arr[2]; } wo_trx_type_code;

struct { unsigned short len; unsigned char arr[3]; } wo_bill_type_code;

struct { unsigned short len; unsigned char arr[7]; } wo_bill_recv_int_code;

struct { unsigned short len; unsigned char arr[7]; } wo_int_code;

struct { unsigned short len; unsigned char arr[21]; } wo_patient_id;

struct { unsigned short len; unsigned char arr[30]; } wo_doc_amt;

struct { unsigned short len; unsigned char arr[30]; } wo_doc_rev_amt;

struct { unsigned short len; unsigned char arr[30]; } wo_org_num;

struct { unsigned short len; unsigned char arr[9]; } wo_cust_code;
	

    int         amt_sign_ind;
				
    int         err_ctr = 0,
				l_dcp_trn_rec_exist = 0;

	int    		bl_mth,
	   			bl_yr,
	   			cur_mth,
	   			cur_yr,
           		nd_month,
           		nd_year;

    /* VARCHAR df_rct_doc_type_code[7],
			df_rct_doc_num      [9],
			df_rct_doc_date     [13],
			df_slmt_type_code   [3]; */ 
struct { unsigned short len; unsigned char arr[7]; } df_rct_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } df_rct_doc_num;

struct { unsigned short len; unsigned char arr[13]; } df_rct_doc_date;

struct { unsigned short len; unsigned char arr[3]; } df_slmt_type_code;

	
    double  df_interface_amt;

    char	d_ip_gl_yn,
			d_op_gl_yn,
			d_rf_gl_yn;

	char	string_var[1000];
	char	msg_str_var[1000];

    /***********************/

/* EXEC SQL END DECLARE SECTION; */ 


char msg_str[132];


 /* EXEC ORACLE OPTION(HOLD_CURSOR = YES); */ 

// EXEC ORACLE OPTION(REBIND = NO);

/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header: sqlca.h,v 1.3 1994/12/12 19:27:27 jbasu Exp $ sqlca.h 
 */

/* Copyright (c) 1985,1986, 1998 by Oracle Corporation. */
 
/*
NAME
  SQLCA : SQL Communications Area.
FUNCTION
  Contains no code. Oracle fills in the SQLCA with status info
  during the execution of a SQL stmt.
NOTES
  **************************************************************
  ***                                                        ***
  *** This file is SOSD.  Porters must change the data types ***
  *** appropriately on their platform.  See notes/pcport.doc ***
  *** for more information.                                  ***
  ***                                                        ***
  **************************************************************

  If the symbol SQLCA_STORAGE_CLASS is defined, then the SQLCA
  will be defined to have this storage class. For example:
 
    #define SQLCA_STORAGE_CLASS extern
 
  will define the SQLCA as an extern.
 
  If the symbol SQLCA_INIT is defined, then the SQLCA will be
  statically initialized. Although this is not necessary in order
  to use the SQLCA, it is a good pgming practice not to have
  unitialized variables. However, some C compilers/OS's don't
  allow automatic variables to be init'd in this manner. Therefore,
  if you are INCLUDE'ing the SQLCA in a place where it would be
  an automatic AND your C compiler/OS doesn't allow this style
  of initialization, then SQLCA_INIT should be left undefined --
  all others can define SQLCA_INIT if they wish.

  If the symbol SQLCA_NONE is defined, then the SQLCA variable will
  not be defined at all.  The symbol SQLCA_NONE should not be defined
  in source modules that have embedded SQL.  However, source modules
  that have no embedded SQL, but need to manipulate a sqlca struct
  passed in as a parameter, can set the SQLCA_NONE symbol to avoid
  creation of an extraneous sqlca variable.
 
MODIFIED
    lvbcheng   07/31/98 -  long to int
    jbasu      12/12/94 -  Bug 217878: note this is an SOSD file
    losborne   08/11/92 -  No sqlca var if SQLCA_NONE macro set 
  Clare      12/06/84 - Ch SQLCA to not be an extern.
  Clare      10/21/85 - Add initialization.
  Bradbury   01/05/86 - Only initialize when SQLCA_INIT set
  Clare      06/12/86 - Add SQLCA_STORAGE_CLASS option.
*/
 
#ifndef SQLCA
#define SQLCA 1
 
struct   sqlca
         {
         /* ub1 */ char    sqlcaid[8];
         /* b4  */ int     sqlabc;
         /* b4  */ int     sqlcode;
         struct
           {
           /* ub2 */ unsigned short sqlerrml;
           /* ub1 */ char           sqlerrmc[70];
           } sqlerrm;
         /* ub1 */ char    sqlerrp[8];
         /* b4  */ int     sqlerrd[6];
         /* ub1 */ char    sqlwarn[8];
         /* ub1 */ char    sqlext[8];
         };

#ifndef SQLCA_NONE 
#ifdef   SQLCA_STORAGE_CLASS
SQLCA_STORAGE_CLASS struct sqlca sqlca
#else
         struct sqlca sqlca
#endif
 
#ifdef  SQLCA_INIT
         = {
         {'S', 'Q', 'L', 'C', 'A', ' ', ' ', ' '},
         sizeof(struct sqlca),
         0,
         { 0, {0}},
         {'N', 'O', 'T', ' ', 'S', 'E', 'T', ' '},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0}
         }
#endif
         ;
#endif
 
#endif
 
/* end SQLCA */
/* EXEC SQL INCLUDE SQLDA.H;
 */ 
/*
 * $Header: sqlda.h 31-jul-99.19:34:41 apopat Exp $ sqlda.h 
 */

/***************************************************************
*      The SQLDA descriptor definition                         *
*--------------------------------------------------------------*
*      VAX/3B Version                                          *
*                                                              *
*  Copyright (c) 1987, 1997, 1998, 1999 by Oracle Corporation                    *
***************************************************************/


/* NOTES
  **************************************************************
  ***                                                        ***
  *** This file is SOSD.  Porters must change the data types ***
  *** appropriately on their platform.  See notes/pcport.doc ***
  *** for more information.                                  ***
  ***                                                        ***
  **************************************************************
*/

/*  MODIFIED
    apopat     07/31/99 -  [707588] TAB to blanks for OCCS
    lvbcheng   10/27/98 -  change long to int for sqlda
    lvbcheng   08/15/97 -  Move sqlda protos to sqlcpr.h
    lvbcheng   06/25/97 -  Move sqlda protos to this file
    jbasu      01/29/95 -  correct typo
    jbasu      01/27/95 -  correct comment - ub2->sb2
    jbasu      12/12/94 - Bug 217878: note this is an SOSD file
    Morse      12/01/87 - undef L and S for v6 include files
    Richey     07/13/87 - change int defs to long 
    Clare      09/13/84 - Port: Ch types to match SQLLIB structs
    Clare      10/02/86 - Add ifndef SQLDA
*/

#ifndef SQLDA_
#define SQLDA_ 1
 
#ifdef T
# undef T
#endif
#ifdef F
# undef F
#endif

#ifdef S
# undef S
#endif
#ifdef L
# undef L
#endif
 
struct SQLDA {
  /* ub4    */ int        N; /* Descriptor size in number of entries        */
  /* text** */ char     **V; /* Ptr to Arr of addresses of main variables   */
  /* ub4*   */ int       *L; /* Ptr to Arr of lengths of buffers            */
  /* sb2*   */ short     *T; /* Ptr to Arr of types of buffers              */
  /* sb2**  */ short    **I; /* Ptr to Arr of addresses of indicator vars   */
  /* sb4    */ int        F; /* Number of variables found by DESCRIBE       */
  /* text** */ char     **S; /* Ptr to Arr of variable name pointers        */
  /* ub2*   */ short     *M; /* Ptr to Arr of max lengths of var. names     */
  /* ub2*   */ short     *C; /* Ptr to Arr of current lengths of var. names */
  /* text** */ char     **X; /* Ptr to Arr of ind. var. name pointers       */
  /* ub2*   */ short     *Y; /* Ptr to Arr of max lengths of ind. var. names */
  /* ub2*   */ short     *Z; /* Ptr to Arr of cur lengths of ind. var. names */
  };
 
typedef struct SQLDA SQLDA;
 
#endif

/* ----------------- */
/* defines for sqlda */
/* ----------------- */

#define SQLSQLDAAlloc(arg1, arg2, arg3, arg4) sqlaldt(arg1, arg2, arg3, arg4) 

#define SQLSQLDAFree(arg1, arg2) sqlclut(arg1, arg2) 




#include <winproc.h>

void get_param(),
     sql_connect(),
     declare_cur(),
     open_recref_dtl(),
     ins_blgl_distrib(),
     ins_arrec_hdr(),
     ins_bldcp_trn(),
     ins_blpat_ledger_trn(),
     get_static_info(),
     get_slmt_desc(),
     get_bank_acc(),
     get_other_acc(int i),
     move_into_post_acc(int i),
     open_recref_dtl_bl(),
     init_old(),
     //declare_df_phys_ldgr_cur(),
    // open_df_phys_ldgr_cur(),
     update_recref_dtl(),
     open_bl_bill_adj_exempt_cur(), 
     open_bl_bill_adj_canc_cur(),
     get_bank_acc_ae(),
     get_other_acc_ae(int i),
     move_into_post_acc_ae(int i),
     update_bill_adj_exempt(),
     update_bill_adj_exempt_canc(),
     ins_blgl_distrib_ae(),
     ins_bldcp_trn_ae();

int  fetch_recref_dtl(),
     fetch_df_phys_ldgr(),
     insrt_df_pay_alcn(),
     fetch_recref_dtl_bl(),
     fetch_bl_bill_adj_exempt_cur(),
     fetch_bl_bill_adj_canc_cur();


char old_slmt_type_code[3],
     old_cash_counter_code[7];

int g_error;
int g_savepoint;

void proc_main(argc,argv)  
int argc;
char *argv[];
{

    if(argc < 7) {
	/*disp_message(ERR_MESG,argv[1]);
	disp_message(ERR_MESG,argv[2]);
	disp_message(ERR_MESG,argv[3]);
	disp_message(ERR_MESG,argv[4]);
	disp_message(ERR_MESG,argv[5]);
	disp_message(ERR_MESG,argv[6]);
	disp_message(ERR_MESG,argv[7]);*/
	disp_message(ERR_MESG,"Usage : BLBPSBLC userid/password session_id pgm_date Facility Ws-No");
        proc_exit();
    }

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    strcpy(g_pgm_id,"BLBPSTFL");
    strcpy(g_pgm_date,argv[3]);

    strcpy(nd_operating_facility_id.arr,argv[5]);
    nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);  
    strcpy(g_facility_id,nd_operating_facility_id.arr);

    strcpy(nd_ws_no.arr,argv[6]);
    nd_ws_no.len = strlen(nd_ws_no.arr);  

    sql_connect();    

    set_meduser_role();   

    start_prog_msg();

    /** NK **/
    t_start_ref_num = 0;

//disp_message(ERR_MESG,"After start prog mesg");

    get_param();

//disp_message(ERR_MESG,"After get param");

    get_static_info();

//disp_message(ERR_MESG,"After get  static info");

    declare_cur();

//disp_message(ERR_MESG,"After declare cur");

    cash_control_use_chec();
   
//disp_message(ERR_MESG,"After cash control use check...");

    process_dpf();

   //disp_message(ERR_MESG,"After  process DPF..");
   //disp_message(ERR_MESG,"nd_bill_doc_type_code:");
   //disp_message(ERR_MESG,nd_bill_doc_type_code.arr);

    if (nd_bill_doc_type_code.arr[0] != '\0')           /* Added the enhancement on 26-MAR-2007 */
			  {
						end_prog_msg();

						/* EXEC   SQL DELETE SY_PROG_PARAM
						WHERE  PGM_ID     = 'BLBPSTFL' 
						AND    PGM_DATE   = :d_pgm_date
						AND    SESSION_ID = :d_session_id
						AND    OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 3;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((PGM_ID='BLBPSTFL' \
and PGM_DATE=:b0) and SESSION_ID=:b1) and OPERATING_FACILITY_ID=:b2)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )5;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
      sqlstm.sqhstl[0] = (unsigned int  )22;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_session_id;
      sqlstm.sqhstl[1] = (unsigned int  )22;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
      sqlstm.sqhstl[2] = (unsigned int  )5;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



						if(OERROR) 
							err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 
 
						/* EXEC SQL COMMIT WORK RELEASE; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 3;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )32;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



						return; 
			  }

//disp_message(ERR_MESG,"After aggr doc type code if...");

    open_recref_dtl();

//disp_message(ERR_MESG,"After recref dtl...");
    g_error = 0;
    g_savepoint = 0;

    

    while(fetch_recref_dtl())
    { 
      if(g_error) do_rollback();

      /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 3;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "savepoint LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )47;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

     

      if (OERROR)
         err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

      g_savepoint = 1;

      upd_reasons_in_receipt_refund_for_unposting(1) ; 	 

      if (nd_reason_text.arr[0] != '\0')
         continue;      

      if (brk_slmt())
      {  
	 get_bank_acc();
	 if(g_error) continue;
             get_slmt_desc();
      }
      else if (brk_cash())
        get_bank_acc();

      if(g_error) continue;

      if ((strcmp(recref_recpt_nature_code.arr, "AD")==0) ||
         (strcmp(recref_recpt_nature_code.arr, "PR")==0)  ||
         (strcmp(recref_recpt_nature_code.arr, "RD")==0)  ||
         (strcmp(recref_recpt_nature_code.arr, "PD")==0)  ||
	 (strcmp(recref_recpt_nature_code.arr, "CR")==0)  ) {   

             if (recref_recpt_refund_ind.arr[0]=='R')
               get_other_acc(RECREF);
             else 
               get_other_acc (RD);	 
	     if(g_error) continue;

             move_into_post_acc(BANK);
             ins_blpat_ledger_trn();
	     if(g_error) continue;

             ins_blgl_distrib();
	     if(g_error) continue;

             move_into_post_acc(OTHER);
             ins_blgl_distrib();
	     if(g_error) continue;
          }
      else if (strcmp(recref_recpt_nature_code.arr, "CU")==0)
          {
             get_other_acc(RECREF);
	     if(g_error) continue;
             move_into_post_acc(BANK);
             ins_arrec_hdr();
	     if(g_error) continue;
             ins_blgl_distrib();
	     if(g_error) continue;
             move_into_post_acc(OTHER);
             ins_blgl_distrib();
	     if(g_error) continue;
          }
      else if (strcmp(recref_recpt_nature_code.arr, "DC")==0)
          {
             get_other_acc(DC);
	     if(g_error) continue;
             move_into_post_acc(BANK);
		
             //----This is for inserting record to BL_DCP_TRN----
	     recref_dcp_ind.arr[0] = '\0';
	     recref_dcp_ind.len = 0;
	     strcpy(recref_dcp_ind.arr,"N");
	     recref_dcp_ind.len = strlen(recref_dcp_ind.arr);
	     //--------------------------------------------------


             ins_bldcp_trn();
	     if(g_error) continue;
             ins_blgl_distrib();
	     if(g_error) continue;
             move_into_post_acc(OTHER);
             ins_blgl_distrib();
	     if(g_error) continue;
             if (recref_recpt_refund_ind.arr[0] == 'R') {
                process_dpf_rec_DC();
	        if(g_error) continue;
	     }
          }
      else if ((strcmp(recref_recpt_nature_code.arr, "MI")==0) ||
	  		 (strcmp(recref_recpt_nature_code.arr, "HC")==0) ) 
          {
             //move_into_post_acc(BANK);
             //ins_blgl_distrib();
	     //if(g_error) continue;

             get_other_acc(RECREF);
	     if(g_error) continue;
		
	     move_into_post_acc(BANK);
             ins_blgl_distrib();
	     if(g_error) continue;

             move_into_post_acc(OTHER);
             ins_blgl_distrib();
	     if(g_error) continue;

          }          

      update_recref_dtl();
      if(g_error) continue;
      /* EXEC SQL COMMIT; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 3;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )62;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

      
    }


    /* **** TEMP ****
    process_dpf();
    */

    init_old();
    open_recref_dtl_bl();

    g_error = 0;
    g_savepoint = 0;

    

    while(fetch_recref_dtl_bl())
     {       

      if(g_error) 
	  do_rollback();

      /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 3;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "savepoint LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )77;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      if(OERROR)
	  err_mesg("SAVEPOINT failed on LAST_DOC_REF",0,"");

      g_savepoint = 1;

      upd_reasons_in_receipt_refund_for_unposting(1);      

      if (nd_reason_text.arr[0] != '\0')
         continue;

      if (brk_slmt())
      {
         get_bank_acc();
	 if(g_error) continue;
         get_slmt_desc();
      }
      else if (brk_cash())
         get_bank_acc();
      
      if(g_error) continue;
      get_other_acc(BILL);
      if(g_error) continue;

      ins_blpat_ledger_trn();
      if(g_error) continue;
      move_into_post_acc(BANK);
      ins_blgl_distrib();
      if(g_error) continue;
      move_into_post_acc(OTHER);
      ins_blgl_distrib();
      if(g_error) continue;
      if (recref_recpt_refund_ind.arr[0] == 'R') {
         process_dpf_rec();
	 if(g_error) continue;
      }
      update_recref_dtl();
      if(g_error) continue;
      /* EXEC SQL COMMIT; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 3;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )92;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    }

    

    post_cancelled_trx();


    

    post_cancelled_bills();

    
		
    if ( nd_cash_control_use_flag = 'Y')
    { 
        post_cash_control_rcpts();
    }

    

    post_bill_adj_exempt();

    

    post_bill_adj_exempt_cancel();

    

    post_bill_wo();
    post_bill_wo_cancel();


    post_instl_wo();              /* Added the enhancement on 27-MAR-2007 */
    post_instl_wo_cancel();		  /* Added the enhancement on 27-MAR-2007 */	

    end_prog_msg();

    /* EXEC SQL DELETE SY_PROG_PARAM
    WHERE  PGM_ID     = 'BLBPSTFL' 
    AND    PGM_DATE   = :d_pgm_date
    AND    SESSION_ID = :d_session_id
    AND    OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 3;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((PGM_ID='BLBPSTFL' an\
d PGM_DATE=:b0) and SESSION_ID=:b1) and OPERATING_FACILITY_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )107;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[0] = (unsigned int  )22;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_session_id;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR) 
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 

    update_cons_rec();

    // Updating posted indicator 'Y' to consolidated receipts

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 3;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )134;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    return;
}


update_cons_rec()
{
   /* EXEC SQL EXECUTE
   BEGIN
	DECLARE
	     Cursor cons_rec is select rowid, doc_type_code, doc_number, doc_srno
	     from bl_receipt_refund_dtl
	     where operating_facility_id = :nd_operating_facility_id
	     and nvl(consolidated_receipt_yn,'N') = 'Y'
	     and nvl(posted_ind,'N') = 'N' 
	     for update of posted_ind;
		
	     cursor cons_rec_canc is select rowid,doc_type_code, doc_number, doc_srno
	     from bl_cancelled_bounced_trx
	     where operating_facility_id = :nd_operating_facility_id
	     and NVL(consolidated_receipt_yn,'N') = 'Y'
	     and nvl(posted_ind,'N') = 'N'
	     for update of posted_ind;
	Begin
	    for i in cons_rec loop
		update bl_receipt_refund_dtl
		set posted_ind = 'Y',
		unposted_reason = null
		where rowid = i.rowid
		and 0 = ( select count(*) from bl_bills_for_cons_receipt
			  where operating_facility_id = :nd_operating_facility_id
			  and doc_type_code = i.doc_type_code
			  and doc_number = i.doc_number
			  and doc_srno = i.doc_srno
			  and nvl(posted_ind,'N') = 'N'
			  and rownum = 1);
	   end loop;

	   for i in cons_rec_canc loop
		update bl_cancelled_bounced_trx
		set posted_ind = 'Y',
		unposted_reason = null
		where rowid = i.rowid
		and 0 = ( select count(*) from bl_bills_for_cons_rcpt_canc
			  where operating_facility_id = :nd_operating_facility_id
			  and doc_type_code = i.doc_type_code
			  and doc_number = i.doc_number
			  and doc_srno = i.doc_srno
			  and nvl(posted_ind,'N') = 'N'
			  and rownum = 1);
	   end loop;
	end;
   END;
   END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "begin DECLARE Cursor cons_rec is select rowid , doc_type_code , doc_nu\
mber , doc_srno from bl_receipt_refund_dtl where operating_facility_id = :nd\
_operating_facility_id and nvl ( consolidated_receipt_yn , 'N' ) = 'Y' and n\
vl ( posted_ind , 'N' ) = 'N' for update of posted_ind ; cursor cons_rec_can\
c is select rowid , doc_type_code , doc_number , doc_srno from bl_cancelled_\
bounced_trx where operating_facility_id = :nd_operating_facility_id and NVL \
( consolidated_receipt_yn , 'N' ) = 'Y' and nvl ( posted_ind , 'N' ) = 'N' f\
or update of posted_ind ; Begin for i in cons_rec loop update bl_receipt_ref\
und_dtl set posted_ind = 'Y' , unposted_reason = null where rowid = i . rowi\
d and 0 = ( select count ( * ) from bl_bills_for_cons_receipt where operatin\
g_facility_id = :nd_operating_facility_id and doc_type_code = i . doc_type_c\
ode and doc_number = i . doc_number and doc_srno = i . doc_srno and nvl ( po\
sted_ind , 'N' ) = 'N' and rownum = 1 ) ; end loop ; for i in cons_rec_canc \
loop update bl_cancelled_bounced_trx set p");
   sqlstm.stmt = "osted_ind = 'Y' , unposted_reason = null where rowid = i .\
 rowid and 0 = ( select count ( * ) from bl_bills_for_cons_rcpt_canc where ope\
rating_facility_id = :nd_operating_facility_id and doc_type_code = i . doc_typ\
e_code and doc_number = i . doc_number and doc_srno = i . doc_srno and nvl ( p\
osted_ind , 'N' ) = 'N' and rownum = 1 ) ; end loop ; end ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )149;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

cash_control_use_chec()
{
   nd_cash_control_use_flag = 'N'; 		
   
   /* EXEC SQL SELECT NVL(CASH_CTRL_RCPT_IN_USE_YN,'N') INTO :nd_cash_control_use_flag 
   FROM BL_PARAMETERS
   WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(CASH_CTRL_RCPT_IN_USE_YN,'N') into :b0  from BL\
_PARAMETERS where OPERATING_FACILITY_ID=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )168;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_cash_control_use_flag;
   sqlstm.sqhstl[0] = (unsigned int  )1;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if(OERROR) 
        err_mesg("SELECT failed on table BL_PARAMETERS",0,""); 
}

do_rollback()  
{

  if(g_savepoint) {
      /* EXEC SQL ROLLBACK WORK TO SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 3;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "rollback work  to LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )191;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      if (OERROR)
         err_mesg("ROLLBACK TO LAST_DOC_REF failed 1",0,""); 
      g_savepoint = 0;
  }

/*
  else {
      EXEC SQL ROLLBACK WORK;
      if (OERROR)
         err_mesg("ROLLBACK failed",0,""); 
  }
*/  

  g_error = 0;
}

void get_param()
{

    t_tmp_date.arr[0]       = '\0';
    nd_date.arr[0]   = '\0';
    t_tmp_date.len       = 0;
    nd_date.len          = 0;

// NEW ONE -- ASSIGNING ND_DATE IN YYYYMMDD ORDER. 21/02/98 VSK

     /*disp_message(ERR_MESG,nd_operating_facility_id.arr);
	 disp_message(ERR_MESG,d_pgm_date.arr);
	 disp_message(ERR_MESG,d_session_id.arr);*/

    /* EXEC SQL SELECT PARAM3,
                    PARAM1,
                    PARAM2,
		    TO_CHAR(TO_DATE(PARAM3,'DD/MM/YYYY'),'YYYYMMDD'),
			PARAM4,PARAM5
             INTO   :nd_date,
                    :nd_month,
                    :nd_year,
		            :t_tmp_date,
					:nd_bill_doc_type_code,
					:nd_bill_doc_num
             FROM   SY_PROG_PARAM
             WHERE   OPERATING_FACILITY_ID = :nd_operating_facility_id
	         and    PGM_ID     = 'BLBPSTFL'
             AND    PGM_DATE   = :d_pgm_date
             AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PARAM3 ,PARAM1 ,PARAM2 ,TO_CHAR(TO_DATE(PARAM3,'DD\
/MM/YYYY'),'YYYYMMDD') ,PARAM4 ,PARAM5 into :b0,:b1,:b2,:b3,:b4,:b5  from SY_P\
ROG_PARAM where (((OPERATING_FACILITY_ID=:b6 and PGM_ID='BLBPSTFL') and PGM_DA\
TE=:b7) and SESSION_ID=TO_NUMBER(:b8))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )206;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_date;
    sqlstm.sqhstl[0] = (unsigned int  )15;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_month;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_year;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_tmp_date;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_bill_doc_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_bill_doc_num;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[7] = (unsigned int  )22;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_session_id;
    sqlstm.sqhstl[8] = (unsigned int  )22;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR || NO_DATA_FOUND)
        err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");


       /* EXEC SQL DELETE SY_PROG_PARAM
    WHERE  PGM_ID     = 'BLBPSTFL' 
    AND    PGM_DATE   = :d_pgm_date
    AND    SESSION_ID = :d_session_id
    AND    OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 9;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((PGM_ID='BLBPSTFL'\
 and PGM_DATE=:b0) and SESSION_ID=:b1) and OPERATING_FACILITY_ID=:b2)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )257;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
       sqlstm.sqhstl[0] = (unsigned int  )22;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_session_id;
       sqlstm.sqhstl[1] = (unsigned int  )22;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
       sqlstm.sqhstl[2] = (unsigned int  )5;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR) 
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");

    nd_date.arr[nd_date.len]   = '\0';
	t_tmp_date.arr[t_tmp_date.len]   = '\0';
    nd_bill_doc_type_code.arr[nd_bill_doc_type_code.len] = '\0';
    nd_bill_doc_num.arr[nd_bill_doc_num.len] = '\0';
    
    /* EXEC SQL DELETE SY_PROG_PARAM
         WHERE  PGM_ID     = 'BLBPSBLC' 
         AND    PGM_DATE   = :d_pgm_date
         AND    SESSION_ID = :d_session_id;

    if(OERROR) 
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); */

    dflt_dept_code.arr[0]  = '\0';
    dflt_dept_code.len     = 0;

    d_ip_gl_yn       = '\0';
    d_op_gl_yn       = '\0';
    d_rf_gl_yn       = '\0';

   /* EXEC SQL SELECT CURRENT_PROC_ACC_MONTH,
		   CURRENT_PROC_ACC_YEAR,
		   TO_NUMBER(TO_CHAR(SYSDATE,'MM')),
		   TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')),
		   DEF_ACCT_DEPT_CODE,
		   NVL(IP_GL_REQD_YN,'N'),
		   NVL(OP_GL_REQD_YN,'N'),
		   NVL(RF_GL_REQD_YN,'N')
	    INTO   :bl_mth,
		   :bl_yr,
		   :cur_mth,
		   :cur_yr,
		   :dflt_dept_code,
		   :d_ip_gl_yn,
		   :d_op_gl_yn,
		   :d_rf_gl_yn
	    FROM   BL_PARAMETERS
	    WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CURRENT_PROC_ACC_MONTH ,CURRENT_PROC_ACC_YEAR ,TO_N\
UMBER(TO_CHAR(SYSDATE,'MM')) ,TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) ,DEF_ACCT_DEP\
T_CODE ,NVL(IP_GL_REQD_YN,'N') ,NVL(OP_GL_REQD_YN,'N') ,NVL(RF_GL_REQD_YN,'N')\
 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from BL_PARAMETERS where OPERATING_FACI\
LITY_ID=:b8";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )284;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_mth;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bl_yr;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&cur_mth;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&cur_yr;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&dflt_dept_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_ip_gl_yn;
   sqlstm.sqhstl[5] = (unsigned int  )1;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_op_gl_yn;
   sqlstm.sqhstl[6] = (unsigned int  )1;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_rf_gl_yn;
   sqlstm.sqhstl[7] = (unsigned int  )1;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[8] = (unsigned int  )5;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	err_mesg("SELECT failed on table BL_PARAMETERS",0,"");

    dflt_dept_code.arr[dflt_dept_code.len]  = '\0';

    if( (cur_yr > bl_yr) || (cur_yr==bl_yr && cur_mth > bl_mth) ) {
	nd_month = cur_mth;
	nd_year  = cur_yr;
    }
    else {
	nd_month = bl_mth;
	nd_year  = bl_yr;
    }

}

void sql_connect()
{

    /* EXEC SQL CONNECT :uid_pwd; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )10;
    sqlstm.offset = (unsigned int  )335;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
    sqlstm.sqhstl[0] = (unsigned int  )93;
    sqlstm.sqhsts[0] = (         int  )93;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR) {
        disp_message(ORA_MESG,"Unable to connect to oracle.");
        proc_exit();
    }
}
void get_static_info()
{

    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
	nd_acc_entity_code.arr[0]='\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;
	nd_acc_entity_code.len=0;

    /* EXEC SQL   SELECT ACC_ENTITY_CODE,ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
               USER
               INTO nd_acc_entity_code,:hosp_name,:date_time,:user_id
               FROM SY_ACC_ENTITY
	       WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_CODE ,ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,\
'DD/MM/YYYY HH24:MI') ,USER into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY where ACC\
_ENTITY_ID=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )366;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&hosp_name;
    sqlstm.sqhstl[1] = (unsigned int  )32;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&date_time;
    sqlstm.sqhstl[2] = (unsigned int  )32;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&user_id;
    sqlstm.sqhstl[3] = (unsigned int  )42;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[4] = (unsigned int  )5;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR || NO_DATA_FOUND) 
       err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

    hosp_name.arr[hosp_name.len]           = '\0';
    date_time.arr[date_time.len]           = '\0';
    user_id.arr[user_id.len]               = '\0';
	nd_acc_entity_code.arr[nd_acc_entity_code.len]='\0';
    
    blparam_post_month.arr[0] = '\0';
    blparam_post_year.arr[0]  = '\0';
    
    blparam_post_month.len    = 0;
    blparam_post_year.len     = 0;

    /* EXEC SQL SELECT CURRENT_PROC_ACC_MONTH, CURRENT_PROC_ACC_YEAR
             INTO   :blparam_post_month, :blparam_post_year
             FROM   BL_PARAMETERS
	     WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CURRENT_PROC_ACC_MONTH ,CURRENT_PROC_ACC_YEAR into\
 :b0,:b1  from BL_PARAMETERS where OPERATING_FACILITY_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )401;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&blparam_post_month;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&blparam_post_year;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR || NO_DATA_FOUND) 
       err_mesg("SELECT failed on table BL_PARAMETERS",0,"");


    blparam_post_month.arr[blparam_post_month.len] = '\0';
    blparam_post_year.arr[blparam_post_year.len]   = '\0';
}

void update_recref_dtl()
{
   if (strcmp(recref_cons_receipt_yn.arr,"Y") == 0)
   {
	/* EXEC SQL UPDATE BL_BILLS_FOR_CONS_RECEIPT
		SET POSTED_IND = 'Y',
		UNPOSTED_REASON	       = NULL,
		MODIFIED_BY_ID         = user,
		MODIFIED_DATE          = SYSDATE,
		ADDED_AT_WS_NO         = :nd_ws_no,
		ADDED_FACILITY_ID      = :nd_operating_facility_id,
		MODIFIED_AT_WS_NO      = :nd_ws_no,
		MODIFIED_FACILITY_ID   = :nd_operating_facility_id
              WHERE ROWID = :recref_rowid; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_BILLS_FOR_CONS_RECEIPT  set POSTED_IND='Y',UNPOSTE\
D_REASON=null ,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,AD\
DED_FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWID\
=:b4";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )428;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&recref_rowid;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR || NO_DATA_FOUND) 
		err_mesg("UPDATE failed on table BL_BILLS_FOR_CONS_RECEIPT",0,"");
   }
   else
   {
	/* EXEC SQL UPDATE BL_RECEIPT_REFUND_DTL
		SET POSTED_IND	       = 'Y',
		UNPOSTED_REASON	       = NULL,
		MODIFIED_BY_ID         = user,
		MODIFIED_DATE          = SYSDATE,
		ADDED_AT_WS_NO         = :nd_ws_no,
		ADDED_FACILITY_ID      = :nd_operating_facility_id,
		MODIFIED_AT_WS_NO      = :nd_ws_no,
		MODIFIED_FACILITY_ID   = :nd_operating_facility_id
              WHERE ROWID = :recref_rowid; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_RECEIPT_REFUND_DTL  set POSTED_IND='Y',UNPOSTED_RE\
ASON=null ,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED_\
FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWID=:b4";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )463;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&recref_rowid;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR || NO_DATA_FOUND) 
		err_mesg("UPDATE failed on table BL_RECEIPT_REFUND_DTL",0,"");
    }

    
}
void declare_cur()
{
     /* EXEC SQL DECLARE BL_RECEIPT_REFUND_DTL_CUR CURSOR FOR
               SELECT RID,
                      RECPT_REFUND_IND,
                      DOC_TYPE_CODE,
                      DOC_NUMBER,
					  DOC_SRNO,
                      TRX_TYPE_CODE,
                      RECPT_NATURE_CODE,
                      DEBTOR_CATEGORY_CODE,
                      TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                      POST_MONTH,
                      POST_YEAR,
                      TRX_DATE_TIME,
                      NVL(EPISODE_TYPE,'R'),
                      PATIENT_ID,
                      NVL(EPISODE_ID,0),
                      NVL(VISIT_ID,1),
                      BILL_DOC_TYPE_CODE,
                      BILL_DOC_NUMBER,
                      CUSTOMER_CODE,
                      CASH_COUNTER_CODE,
                      SHIFT_ID,
                      DOC_AMT,
                      DOC_AMT * (-1),
                      RECPT_TYPE_CODE,
                      SLMT_TYPE_CODE,
                      SLMT_DOC_REF_DESC,
                      TO_CHAR(SLMT_DOC_REF_DATE,'DD/MM/YYYY'),
                      SLMT_DOC_REMARKS,
                      BANK_RECON_REF,
                      nvl(PRINT_FLAG,'N'),
                      NVL(CANCELLED_IND,'N'),
                      NVL(POSTED_IND,'N'),
                      NARRATION,
	              CASH_CTRL_DOC_TYPE_CODE,
		      CASH_CTRL_DOC_NUMBER,   
		      CASH_CTRL_DOC_DATE,
		      NVL(CONSOLIDATED_RECEIPT_YN,'N')
                FROM  BL_RECEIPT_REFUND_DTL_VW		
     // View is for posting consolidated 'DC' receipt on 22/07/2004
                WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND DOC_DATE <= TO_DATE(:nd_date||' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')
                AND   NVL(POSTED_IND,'N') != 'Y'
		AND   NVL(RECPT_NATURE_CODE, 'XX') != 'BI'
//AND NVL(PRINT_FLAG, 'N') = 'Y'   /o Error will be displayed o/
                ORDER BY RECPT_REFUND_IND DESC, CASH_COUNTER_CODE, 
                      SLMT_TYPE_CODE, DOC_TYPE_CODE, DOC_NUMBER; */ 



     /* EXEC SQL DECLARE BL_RECEIPT_REFUND_DTL_BL_CUR CURSOR FOR
               SELECT RID,  // Rowid
                      RECPT_REFUND_IND,
                      DOC_TYPE_CODE,
                      DOC_NUMBER,
                      TRX_TYPE_CODE,
                      RECPT_NATURE_CODE,
                      DEBTOR_CATEGORY_CODE,
                      TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                      POST_MONTH,
                      POST_YEAR,
                      TRX_DATE_TIME,
                      NVL(EPISODE_TYPE,'R'),
                      PATIENT_ID,
                      NVL(EPISODE_ID,0),
                      NVL(VISIT_ID,1),
                      BILL_DOC_TYPE_CODE,
                      BILL_DOC_NUMBER,
                      CUSTOMER_CODE,
                      CASH_COUNTER_CODE,
                      SHIFT_ID,
                      DOC_AMT,
                      DOC_AMT * (-1),
                      RECPT_TYPE_CODE,
                      SLMT_TYPE_CODE,
                      SLMT_DOC_REF_DESC,
                      TO_CHAR(SLMT_DOC_REF_DATE,'DD/MM/YYYY'),
                      SLMT_DOC_REMARKS,
                      BANK_RECON_REF,
                      NVL(PRINT_FLAG,'N'),
                      NVL(CANCELLED_IND,'N'),
                      NVL(POSTED_IND,'N'),
                      NARRATION,
		      CASH_CTRL_DOC_TYPE_CODE,
		      CASH_CTRL_DOC_NUMBER,   
		      CASH_CTRL_DOC_DATE,
		      NVL(CONSOLIDATED_RECEIPT_YN,'N')
                FROM BL_RECEIPT_REFUND_DTL_VW
     // View is for posting consolidated receipts on 22/07/2004
                WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND DOC_DATE <= TO_DATE(:nd_date||' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')
                AND NVL(POSTED_IND,'N') != 'Y'
		//Comment removed, ie, cancelled entries will not be allowed to post.  Since posted
		//Receipts cannot be cancelled in the cancell receipt/refund function.
		//20/01/2004 Harish
		AND   NVL(CANCELLED_IND, 'N')     != 'Y'
		AND   NVL(RECPT_NATURE_CODE, 'XX') = 'BI'
		//AND   NVL(PRINT_FLAG, 'N')         = 'Y'		
                ORDER BY RECPT_REFUND_IND DESC, CASH_COUNTER_CODE, 
                         SLMT_TYPE_CODE, DOC_TYPE_CODE, DOC_NUMBER; */ 


     /* EXEC SQL DECLARE BL_GL_ACCOUNT_CUR CURSOR FOR
               SELECT MAIN_ACC1_CODE ,
                      MAIN_ACC2_CODE ,
                      DEPT_CODE,
                      SUBLEDGER_GROUP_CODE,
                      SUBLEDGER_LINE_CODE,
                      PRODUCT_GROUP_CODE,
                      PRODUCT_LINE_CODE
               FROM   BL_GL_ACCOUNT A, BL_SLMT_CASH_COUNTER B, BL_SLMT_CASH_COUNTER_INT C
               WHERE  A.ACC_INT_CODE      = C.SLMT_CTR_ACC_INT_CODE 
	       AND    B.SLMT_TYPE_CODE    = :recref_slmt_type_code
               AND    B.CASH_COUNTER_CODE = :recref_cash_counter_code
	       AND    B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	       AND    B.SLMT_TYPE_CODE    = C.SLMT_TYPE_CODE
	       AND    B.CASH_COUNTER_CODE = C.CASH_COUNTER_CODE
	       AND    B.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
	       AND    TO_DATE(:recref_doc_date,'DD/MM/YYYY') between 
		      NVL(C.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(C.EFF_TO_DATE,SYSDATE)   /o Effective date range is included ON 01/06/2004 o/
	       AND    A.ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					     WHERE ACC_ENTITY_ID = :nd_operating_facility_id); */ 


     /* EXEC SQL DECLARE BL_GL_ACCOUNT_OTHER_CUR CURSOR FOR
               SELECT MAIN_ACC1_CODE ,
                      MAIN_ACC2_CODE ,
                      DEPT_CODE,
                      SUBLEDGER_GROUP_CODE,
                      SUBLEDGER_LINE_CODE,
                      PRODUCT_GROUP_CODE,
                      PRODUCT_LINE_CODE
               FROM   BL_GL_ACCOUNT A, BL_RECEIPT_TYPE B, BL_RECEIPT_TYPE_INT C
               WHERE  A.ACC_INT_CODE      = C.RECEIPT_ACC_INT_CODE 
               AND    B.RECEIPT_TYPE_CODE = :recref_recpt_type_code
	       AND    A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE
	       AND    B.RECEIPT_TYPE_CODE = C.RECEIPT_TYPE_CODE
	       AND    B.ACC_ENTITY_CODE = C.ACC_ENTITY_CODE
	       AND    TO_DATE(:recref_doc_date,'DD/MM/YYYY') between 
		      NVL(C.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(C.EFF_TO_DATE,SYSDATE)   /o Effective date range is included ON 01/06/2004 o/
       	       AND    A.ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					     WHERE ACC_ENTITY_ID = :nd_operating_facility_id); */ 


     /* EXEC SQL DECLARE BL_GL_ACCOUNT_OTHER_RD_CUR CURSOR FOR
               SELECT MAIN_ACC1_CODE ,
                      MAIN_ACC2_CODE ,
                      DEPT_CODE,
                      SUBLEDGER_GROUP_CODE,
                      SUBLEDGER_LINE_CODE,
                      PRODUCT_GROUP_CODE,
                      PRODUCT_LINE_CODE			    
               FROM   BL_GL_ACCOUNT A, BL_RECEIPT_TYPE B, BL_PATIENT_LEDGER C, BL_RECEIPT_TYPE_INT D
               WHERE  C.EPISODE_TYPE = NVL(:recref_episode_type,'R')
               AND    C.PATIENT_ID = :recref_patient_id
               AND    NVL(C.EPISODE_ID,0) = NVL(:recref_episode_id,0)
	       AND    NVL(C.VISIT_ID,1) = 
	              DECODE(:recref_episode_type,'I',NVL(C.VISIT_ID,1),'D',NVL(C.VISIT_ID,1), nvl(:recref_visit_id,1))
               AND    C.ORG_DOC_TYPE_CODE = :recref_bill_doc_type_code
               AND    C.ORG_DOC_NUM = :recref_bill_doc_number
               AND    B.RECEIPT_TYPE_CODE = C.RECPT_TYPE_CODE
               AND    A.ACC_INT_CODE = D.RECEIPT_ACC_INT_CODE 
	       AND    C.OPERATING_FACILITY_ID = :nd_operating_facility_id 
	       AND    A.ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
		  			    FROM   SY_ACC_ENTITY 
					    WHERE  ACC_ENTITY_ID = :nd_operating_facility_id)
	       AND    A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE
	       AND    B.ACC_ENTITY_CODE = D.ACC_ENTITY_CODE
	       AND    B.RECEIPT_TYPE_CODE = D.RECEIPT_TYPE_CODE
	       AND TRUNC(C.ORG_DOC_DATE) between 
		      NVL(D.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(D.EFF_TO_DATE,SYSDATE)   /o Effective date range is included ON 01/06/2004 o/
		; */ 


     /* EXEC SQL DECLARE BL_GL_ACCOUNT_OTHER_DC_CUR CURSOR FOR
               SELECT A.MAIN_ACC1_CODE ,
                      A.MAIN_ACC2_CODE ,
                      A.DEPT_CODE,
                      A.SUBLEDGER_GROUP_CODE,
                      A.SUBLEDGER_LINE_CODE,
                      A.PRODUCT_GROUP_CODE,
                      A.PRODUCT_LINE_CODE
               FROM   BL_GL_ACCOUNT A, BL_BILL_TYPE B, BL_DCP_PENDING_DOC C, BL_BILL_TYPE_INT D
               WHERE  C.PATIENT_ID = :recref_patient_id
               AND    C.ORG_DOC_TYPE_CODE = :recref_bill_doc_type_code
               AND    C.ORG_DOC_NUMBER = :recref_bill_doc_number
               AND    B.BILL_TYPE_CODE = C.BILL_TYPE_CODE
               AND    A.ACC_INT_CODE = D.DCP_RECV_ACC_INT_CODE
	       AND    C.OPERATING_FACILITY_ID = :nd_operating_facility_id 
	       AND    A.ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					  FROM   SY_ACC_ENTITY 
					  WHERE  ACC_ENTITY_ID = :nd_operating_facility_id)
	       AND    B.ACC_ENTITY_CODE = A.ACC_ENTITY_CODE
	       AND    B.ACC_ENTITY_CODE = D.ACC_ENTITY_CODE
	       AND    B.BILL_TYPE_CODE = D.BILL_TYPE_CODE
	       AND TRUNC(C.ORG_DOC_DATE) between 
		      NVL(D.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(D.EFF_TO_DATE,SYSDATE)   /o Effective date range is included ON 01/06/2004 o/
	      ; */ 




     /* EXEC SQL DECLARE BL_GL_ACCOUNT_OTHER_BL_CUR CURSOR FOR
               SELECT A.MAIN_ACC1_CODE ,
                      A.MAIN_ACC2_CODE ,
                      A.DEPT_CODE,
                      A.SUBLEDGER_GROUP_CODE,
                      A.SUBLEDGER_LINE_CODE,
                      A.PRODUCT_GROUP_CODE,
                      A.PRODUCT_LINE_CODE

               FROM   BL_GL_ACCOUNT A, BL_BILL_TYPE B, BL_BILL_HDR C, BL_BILL_TYPE_INT D
               WHERE  C.DOC_TYPE_CODE  = :recref_bill_doc_type_code
               AND    C.DOC_NUM        = :recref_bill_doc_number
               AND    B.BILL_TYPE_CODE = C.BILL_TYPE_CODE
               AND    A.ACC_INT_CODE   = D.BL_RECV_ACC_INT_CODE
	       AND    C.OPERATING_FACILITY_ID = :nd_operating_facility_id 
	       AND    A.ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					  FROM   SY_ACC_ENTITY 
					  WHERE  ACC_ENTITY_ID = :nd_operating_facility_id)
	       AND    B.ACC_ENTITY_CODE = A.ACC_ENTITY_CODE
	       AND    B.ACC_ENTITY_CODE = D.ACC_ENTITY_CODE
	       AND    B.BILL_TYPE_CODE = D.BILL_TYPE_CODE
	       AND    TRUNC(C.DOC_DATE) between 
		      NVL(D.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(D.EFF_TO_DATE,SYSDATE)   /o Effective date range is included ON 01/06/2004 o/
	       ; */ 



     /* EXEC SQL DECLARE BL_SLMT_TYPE_CUR CURSOR FOR
               SELECT DECODE(CASH_SLMT_FLAG,'A','CREDITCARD','B','CHEQUE','CASH')
               FROM   BL_SLMT_TYPE
               WHERE  SLMT_TYPE_CODE = :recref_slmt_type_code; */ 


	

    /* EXEC SQL DECLARE T_PATIENT_FOLIO_CUR CURSOR FOR
	    SELECT  DISTINCT  DOC_TYPE_CODE,
			       DOC_NUMBER,
			       PHYSICIAN_ID
	    FROM     BL_PATIENT_CHARGES_FOLIO
	    WHERE    OPERATING_FACILITY_ID = :nd_operating_facility_id
	    AND	     BILL_DOC_TYPE_CODE = :t_doc_type_code
	    AND      BILL_DOC_NUM       = :t_doc_num
	    AND      NVL(DF_UPD_FLAG,'X') = 'Y'
	    AND      NVL(DF_SERVICE_IND,'X') = 'D'; */ 


    /* KGA Included the Shift Id, Cash Counter Code*/

    /* EXEC SQL DECLARE CANCEL_TRX_CUR CURSOR FOR
	    SELECT       A.ROWID,
		         A.RECPT_REFUND_IND,
                         A.DOC_TYPE_CODE,
                         A.DOC_NUMBER,
						 A.DOC_SRNO,
                         NVL(A.CANCELLED_IND,'N'),
                         NVL(A.BOUNCED_YN,'N'),
                         NVL(A.BOUNCED_STATUS_IND,'N'),
                         A.NARRATION,
		         TO_CHAR(NVL(A.CANCELLED_DATE,SYSDATE),'DD/MM/YYYY'),
		         TO_CHAR(NVL(A.BOUNCED_DATE,SYSDATE),'DD/MM/YYYY'),
		         TO_CHAR(NVL(A.BOUNCED_STATUS_DATE,SYSDATE),'DD/MM/YYYY'),
                         A.DR_MAIN_ACC1_CODE,
                         A.DR_MAIN_ACC2_CODE,
                         A.DR_DEPT_CODE,
                         A.DR_PRODUCT_GROUP_CODE,
          		 A.DR_PRODUCT_LINE_CODE,
			 A.DR_SUBLEDGER_GROUP_CODE,
			 A.DR_SUBLEDGER_LINE_CODE,
			 A.CR_MAIN_ACC1_CODE,
			 A.CR_MAIN_ACC2_CODE,
			 A.CR_DEPT_CODE,
			 A.CR_PRODUCT_GROUP_CODE,
			 A.CR_PRODUCT_LINE_CODE,
			 A.CR_SUBLEDGER_GROUP_CODE,
			 A.CR_SUBLEDGER_LINE_CODE,
			 A.CASH_CTRL_DOC_TYPE_CODE,
			 A.CASH_CTRL_DOC_NUMBER,   
			 A.CASH_CTRL_DOC_DATE,
			 A.SHIFT_ID,
			 A.CASH_COUNTER_CODE,
			 NVL(A.CONSOLIDATED_RECEIPT_YN, B.CONSOLIDATED_RECEIPT_YN),
			 B.BILL_DOC_TYPE_CODE,
			 B.BILL_DOC_NUMBER        
	      FROM BL_CANCELLED_BOUNCED_TRX A, BL_RECEIPT_REFUND_HDRDTL_VW B        /o Modified to HDRDTL View o/
	      WHERE B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	      AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE
	      AND A.DOC_NUMBER = B.DOC_NUMBER
		  AND A.DOC_SRNO   = B.DOC_SRNO
	      AND A.ADDED_DATE <= to_date(:t_tmp_date||'235959','YYYYMMDDHH24MISS') 
	      AND NVL(A.POSTED_IND,'N') != 'Y'
	      AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	      
	      AND NVL(A.CONSOLIDATED_RECEIPT_YN,'N') = 'N'
	UNION ALL
	      SELECT     B.ROWID,
		         A.RECPT_REFUND_IND,
                         B.DOC_TYPE_CODE,
                         B.DOC_NUMBER,
						 B.DOC_SRNO,
                         NVL(A.CANCELLED_IND,'N'),
                         NVL(A.BOUNCED_YN,'N'),
                         NVL(A.BOUNCED_STATUS_IND,'N'),
                         A.NARRATION,
		         TO_CHAR(NVL(A.CANCELLED_DATE,SYSDATE),'DD/MM/YYYY'),
		         TO_CHAR(NVL(A.BOUNCED_DATE,SYSDATE),'DD/MM/YYYY'),
		         TO_CHAR(NVL(A.BOUNCED_STATUS_DATE,SYSDATE),'DD/MM/YYYY'),
                         A.DR_MAIN_ACC1_CODE,
                         A.DR_MAIN_ACC2_CODE,
                         A.DR_DEPT_CODE,
                         A.DR_PRODUCT_GROUP_CODE,
          		 A.DR_PRODUCT_LINE_CODE,
			 A.DR_SUBLEDGER_GROUP_CODE,
			 A.DR_SUBLEDGER_LINE_CODE,
			 A.CR_MAIN_ACC1_CODE,
			 A.CR_MAIN_ACC2_CODE,
			 A.CR_DEPT_CODE,
			 A.CR_PRODUCT_GROUP_CODE,
			 A.CR_PRODUCT_LINE_CODE,
			 A.CR_SUBLEDGER_GROUP_CODE,
			 A.CR_SUBLEDGER_LINE_CODE,
			 A.CASH_CTRL_DOC_TYPE_CODE,
			 A.CASH_CTRL_DOC_NUMBER,   
			 A.CASH_CTRL_DOC_DATE,
			 A.SHIFT_ID,
			 A.CASH_COUNTER_CODE,
			 NVL(A.CONSOLIDATED_RECEIPT_YN,'N'),
			 B.BILL_DOC_TYPE_CODE,
			 B.BILL_DOC_NUM        
	      FROM BL_CANCELLED_BOUNCED_TRX A, BL_BILLS_FOR_CONS_RCPT_CANC B
// Added for posting Consolidated receipts
	      WHERE B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	      AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE
	      AND A.DOC_NUMBER = B.DOC_NUMBER
	      AND A.ADDED_DATE <= to_date(:t_tmp_date||'235959','YYYYMMDDHH24MISS') 
	      AND NVL(B.POSTED_IND,'N') != 'Y'
	      AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	      
	      AND NVL(A.CONSOLIDATED_RECEIPT_YN,'N') = 'Y'
	      ORDER BY 2,3,4; */ 

	      // A.RECPT_REFUND_IND,A.DOC_TYPE_CODE,A.DOC_NUMBER ;
	      // FOR UPDATE OF POSTED_IND;
              // TRUNC(ADDED_DATE) <= TO_DATE(:nd_date,'DD/MM/YYYY')


    /* EXEC SQL DECLARE CANCEL_BILL_CUR CURSOR FOR
	     SELECT  ROWID,DOC_TYPE_CODE,
                     DOC_NUMBER,
		     TO_CHAR(NVL(ADDED_DATE,SYSDATE),'DD/MM/YYYY'),
			 CASH_CTRL_DOC_TYPE_CODE ,       
			CASH_CTRL_DOC_NUMBER,           
			 TO_CHAR(CASH_CTRL_DOC_DATE,'DD/MM/YYYY'),
			 SHIFT_ID,
			 CASH_COUNTER_CODE       
	      FROM   BL_CANCELLED_BILLS
	      WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
	      AND    NVL(POSTED_IND,'N') != 'Y'
	      AND ADDED_DATE <= TO_DATE(:nd_date||' 23:59:59','DD/MM/YYYY HH24:MI:SS'); */ 

	      // FOR    UPDATE OF POSTED_IND;

    /* EXEC SQL DECLARE BL_BILL_LINE_CUR CURSOR FOR
	     SELECT  MAN_DISC_AMT,
		     -MAN_DISC_AMT,
		     MAN_DISC_ACC_INT_CODE
	     FROM    BL_BILL_LINE
	     WHERE   OPERATING_FACILITY_ID = :nd_operating_facility_id
	     AND     DOC_TYPE_CODE = :t_doc_type_code
	     AND     DOC_NUM       = :t_doc_num
	     AND     NVL(MAN_DISC_AMT,0) > 0; */ 


   

/*    EXEC SQL DECLARE BL_DF_INTERFACE_CUR CURSOR FOR
	     SELECT  RCT_DOC_TYPE_CODE,
		     RCT_DOC_NUM,
		     TO_CHAR(RCT_DOC_DATE,'DD/MM/YYYY'),
		     SLMT_TYPE_CODE,
		     DF_INTERFACE_AMT
	       FROM  BL_DF_INTERFACE
	      WHERE  BILL_DOC_TYPE_CODE = :t_doc_type_code
		AND  BILL_DOC_NUM       = :t_doc_num
		AND  OPERATING_FACILITY_ID = :nd_operating_facility_id;*/

 /* EXEC SQL DECLARE BL_BILL_ADJ_EXEMPT_CUR CURSOR FOR
	SELECT B.ROWID,
	       B.DOC_TYPE_CODE,                   
	       B.DOC_NUM,                         
	       B.DOC_SLNO,                               
	       TO_CHAR(B.DOC_DATE,'DD/MM/YYYY'),                        
	       NVL(B.DOC_AMT,0),                                
	       (-1) * NVL(B.DOC_AMT,0),
	       B.ADJ_EXEMPT_ACC_INT_CODE,                
	       B.ADJUST_EXEMPT_IND,                      
	       NVL(B.POSTED_IND,'N'),                             
	       B.POST_MONTH,                             
	       B.POST_YEAR,                              
	       B.UNPOSTED_REASON,                        
	       NVL(B.EPISODE_TYPE,'R'),                           
	       B.EPISODE_ID,                             
	       B.VISIT_ID,                               	       
	       B.ADJ_DOC_TYPE_CODE,               
	       B.ADJ_DOC_NUM,                     
	       TO_CHAR(B.ADJ_DOC_DATE,'DD/MM/YYYY'),
	       B.REMARKS,                                	
	       NVL(B.BILL_DCP_IND,'B'),                         
	       '4' TRX_TYPE_CODE,
	       A.BILL_TYPE_CODE,
		   A.CUST_CODE
	FROM BL_BILL_ADJ_DTL B, BL_BILL_HDR A
	WHERE A.DOC_TYPE_CODE = B.ADJ_DOC_TYPE_CODE
	AND A.DOC_NUM = B.ADJ_DOC_NUM
	AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND B.DOC_DATE <= TO_DATE(:nd_date||' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')
	AND NVL(B.POSTED_IND,'N') != 'Y'
	AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID; */ 



/* EXEC SQL DECLARE BL_BILL_ADJ_EXEMPT_CANC_CUR CURSOR FOR
	SELECT A.ROWID,
	       A.DOC_TYPE_CODE,                   
	       A.DOC_NUM,                         
	       A.DOC_SLNO,                               
	       TO_CHAR(A.CANCELLED_DATE,'DD/MM/YYYY'),                        
	       (-1) * NVL(B.DOC_AMT,0),                                
	       NVL(B.DOC_AMT,0),
	       A.ADJ_EXEMPT_ACC_INT_CODE,                
	       B.ADJUST_EXEMPT_IND,                      
	       NVL(A.POSTED_IND,'N'),                             
	       A.POST_MONTH,                             
	       A.POST_YEAR,                              
	       A.UNPOSTED_REASON,                        
	       NVL(A.EPISODE_TYPE,'R'),                           
	       A.EPISODE_ID,                             
	       A.VISIT_ID,                               	       
	       B.ADJ_DOC_TYPE_CODE,               
	       B.ADJ_DOC_NUM,                     
	       TO_CHAR(B.ADJ_DOC_DATE,'DD/MM/YYYY'),
	       B.REMARKS,                                	
	       NVL(B.BILL_DCP_IND,'B'),                         
	       '4' TRX_TYPE_CODE,
	       C.BILL_TYPE_CODE,
		   C.CUST_CODE
	FROM BL_BILL_ADJ_DTL_CANC A, BL_BILL_ADJ_DTL B,
	     BL_BILL_HDR C
	WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND TRUNC(A.CANCELLED_DATE) <= TO_DATE(:nd_date, 'DD/MM/YYYY')
	AND NVL(A.POSTED_IND,'N') != 'Y'
	AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE
	AND A.DOC_NUM = B.DOC_NUM
	AND A.DOC_SLNO = B.DOC_SLNO
	AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
	AND B.ADJ_DOC_TYPE_CODE = C.DOC_TYPE_CODE
	AND B.ADJ_DOC_NUM = C.DOC_NUM; */ 



/* EXEC SQL DECLARE BL_GL_ACCOUNT_AE_CUR CURSOR FOR
       SELECT A.MAIN_ACC1_CODE ,
	      A.MAIN_ACC2_CODE ,
	      A.DEPT_CODE,
	      A.SUBLEDGER_GROUP_CODE,
	      A.SUBLEDGER_LINE_CODE,
	      A.PRODUCT_GROUP_CODE,
	      A.PRODUCT_LINE_CODE
       FROM BL_GL_ACCOUNT A
       WHERE A.ACC_INT_CODE = :ae_adj_exempt_acc_int_code
       AND A.ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
				  WHERE ACC_ENTITY_ID = :nd_operating_facility_id); */ 


/* EXEC SQL DECLARE BL_GL_ACCOUNT_OTHER_AE_BL_CUR CURSOR FOR
               SELECT A.MAIN_ACC1_CODE,
                      A.MAIN_ACC2_CODE,
                      A.DEPT_CODE,
                      A.SUBLEDGER_GROUP_CODE,
                      A.SUBLEDGER_LINE_CODE,
                      A.PRODUCT_GROUP_CODE,
                      A.PRODUCT_LINE_CODE
               FROM BL_GL_ACCOUNT A, BL_BILL_HDR C, BL_BILL_TYPE_INT D
               WHERE C.OPERATING_FACILITY_ID = :nd_operating_facility_id 
	       AND C.DOC_TYPE_CODE  = :ae_adj_doc_type_code
               AND C.DOC_NUM        = :ae_adj_doc_num               
               AND A.ACC_INT_CODE   = D.BL_RECV_ACC_INT_CODE
	       AND A.ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					 FROM SY_ACC_ENTITY 
					 WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
	       AND D.ACC_ENTITY_CODE = A.ACC_ENTITY_CODE	      
	       AND C.BILL_TYPE_CODE = D.BILL_TYPE_CODE
	       AND TRUNC(C.DOC_DATE) between 
		   NVL(D.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		   NVL(D.EFF_TO_DATE,SYSDATE); */ 



/* EXEC SQL DECLARE BL_GL_ACCOUNT_OTHER_AE_DC_CUR CURSOR FOR
               SELECT A.MAIN_ACC1_CODE ,
                      A.MAIN_ACC2_CODE ,
                      A.DEPT_CODE,
                      A.SUBLEDGER_GROUP_CODE,
                      A.SUBLEDGER_LINE_CODE,
                      A.PRODUCT_GROUP_CODE,
                      A.PRODUCT_LINE_CODE
               FROM BL_GL_ACCOUNT A, BL_DCP_PENDING_DOC C, BL_BILL_TYPE_INT D
               WHERE C.OPERATING_FACILITY_ID = :nd_operating_facility_id 
	       AND C.PATIENT_ID = :ae_patient_id
               AND C.ORG_DOC_TYPE_CODE = :ae_adj_doc_type_code
               AND C.ORG_DOC_NUMBER = :ae_adj_doc_num               
               AND A.ACC_INT_CODE = D.DCP_RECV_ACC_INT_CODE
	       AND A.ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					 FROM SY_ACC_ENTITY 
					 WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
	       AND D.ACC_ENTITY_CODE = A.ACC_ENTITY_CODE	    
	       AND C.BILL_TYPE_CODE = D.BILL_TYPE_CODE
	       AND TRUNC(C.ORG_DOC_DATE) between 
		      NVL(D.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(D.EFF_TO_DATE,SYSDATE); */ 

		

 /* EXEC SQL DECLARE BL_BILL_WO_CUR CURSOR FOR
	  SELECT A.ROWID,
	       A.DOC_TYPE_CODE,                   
	       A.DOC_NUM,                         
	       A.DOC_SLNO,                               
	       TO_CHAR(A.DOC_DATE,'DD/MM/YYYY'),                        
	       NVL(A.WO_APPROVED_AMT,0),                                
	       (-1) * NVL(A.WO_APPROVED_AMT,0),
	       NVL(A.POSTED_IND,'N'),                             
	       NVL(A.EPISODE_TYPE,'R'),                           
	       A.EPISODE_ID,                             
	       A.VISIT_ID,                               	       
	       A.ORG_DOC_TYPE_CODE,			
	       A.ORG_DOC_NUM,                     
	       TO_CHAR(A.ORG_DOC_DATE,'DD/MM/YYYY'),
	       A.REMARKS,                                	
	       '4' TRX_TYPE_CODE,
	       B.BILL_TYPE_CODE,
		   B.CUST_CODE
	FROM BL_WO_REQUEST_DTL A, BL_BILL_DCP_DTL_VW B
	WHERE B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND A.DOC_DATE  <= TO_DATE(:nd_date||' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')
	AND NVL(A.POSTED_IND,'N')	  != 'Y'
	AND NVL(WO_APPROVED_YN, 'N')  = 'Y'
	AND A.ORG_DOC_TYPE_CODE = B.DOC_TYPE_CODE
	AND A.ORG_DOC_NUM = B.DOC_NUM; */ 


	/* EXEC SQL DECLARE BL_INSTL_WO_CUR CURSOR FOR
	  SELECT A.ROWID,
	       A.DOC_TYPE_CODE,                   
	       A.DOC_NUM,                         
	       A.DOC_SLNO,                               
	       TO_CHAR(A.DOC_DATE,'DD/MM/YYYY'),                        
	       NVL(A.WO_APPROVED_AMT,0),                                
	       (-1) * NVL(A.WO_APPROVED_AMT,0),
	       NVL(A.POSTED_IND,'N'),                             
	       NVL(B.EPISODE_TYPE,'R'),                           
	       B.EPISODE_ID,                             
	       B.VISIT_ID,                               	       
	       A.AGGR_DOC_TYPE_CODE,			
	       A.AGGR_DOC_NUM,                     
	       TO_CHAR(A.AGGR_DOC_DATE,'DD/MM/YYYY'),
	       A.REMARKS,                                	
	       '4' TRX_TYPE_CODE,
	       B.BILL_TYPE_CODE,
		   B.CUST_CODE
	FROM BL_INST_WO_REQUEST_DTL A, BL_BILL_DCP_DTL_VW B
	WHERE B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND A.DOC_DATE  <= TO_DATE(:nd_date||' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')
	AND NVL(A.POSTED_IND,'N')	  != 'Y'
	AND NVL(WO_APPROVED_YN, 'N')  = 'Y'
	AND A.AGGR_DOC_TYPE_CODE = B.DOC_TYPE_CODE
	AND A.AGGR_DOC_NUM = B.DOC_NUM; */ 


	/* EXEC SQL DECLARE BL_GL_ACCOUNT_WO_CUR CURSOR FOR
       SELECT A.MAIN_ACC1_CODE ,
	      A.MAIN_ACC2_CODE ,
	      A.DEPT_CODE,
	      A.SUBLEDGER_GROUP_CODE,
	      A.SUBLEDGER_LINE_CODE,
	      A.PRODUCT_GROUP_CODE,
	      A.PRODUCT_LINE_CODE
       FROM BL_GL_ACCOUNT A
       WHERE A.ACC_INT_CODE = :wo_int_code
       AND A.ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
				  WHERE ACC_ENTITY_ID = :nd_operating_facility_id); */ 



	/* EXEC SQL DECLARE BL_GL_ACCOUNT_BILL_RECV_CUR CURSOR FOR
        SELECT A.MAIN_ACC1_CODE ,
	      A.MAIN_ACC2_CODE ,
	      A.DEPT_CODE,
	      A.SUBLEDGER_GROUP_CODE,
	      A.SUBLEDGER_LINE_CODE,
	      A.PRODUCT_GROUP_CODE,
	      A.PRODUCT_LINE_CODE
       FROM BL_GL_ACCOUNT A
       WHERE A.ACC_INT_CODE = :wo_bill_recv_int_code
       AND A.ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
				  WHERE ACC_ENTITY_ID = :nd_operating_facility_id); */ 



	/* EXEC SQL DECLARE BL_BILL_WO_CANC_CUR CURSOR FOR
	  SELECT A.ROWID,
	       A.DOC_TYPE_CODE,                   
	       A.DOC_NUM,                         
	       A.DOC_SLNO,                               
	       TO_CHAR(A.CANCELLED_DATE,'DD/MM/YYYY'),                        	       
	       (-1) * NVL(C.WO_APPROVED_AMT,0),
	       NVL(C.WO_APPROVED_AMT,0),                                
	       NVL(A.POSTED_IND,'N'),                             
	       NVL(A.EPISODE_TYPE,'R'),                           
	       A.EPISODE_ID,                             
	       A.VISIT_ID,                               	       
	       A.ORG_DOC_TYPE_CODE,			
	       A.ORG_DOC_NUM,                     
	       TO_CHAR(A.ORG_DOC_DATE,'DD/MM/YYYY'),
	       A.CANCELLED_REMARKS,                                	
	       '4' TRX_TYPE_CODE,
	       B.BILL_TYPE_CODE,
		   B.CUST_CODE
	FROM BL_WO_REQUEST_CANC_DTL A, BL_BILL_DCP_DTL_VW B,
	     BL_WO_REQUEST_DTL C
	WHERE B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND A.CANCELLED_DATE <= TO_DATE(:nd_date||' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')
	AND NVL(A.POSTED_IND,'N')  != 'Y'
	AND A.ORG_DOC_TYPE_CODE = B.DOC_TYPE_CODE
	AND A.ORG_DOC_NUM = B.DOC_NUM
	AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
	AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE
	AND A.DOC_NUM = C.DOC_NUM
	AND A.DOC_SLNO = C.DOC_SLNO; */ 




	/* EXEC SQL DECLARE BL_INSTL_WO_CANC_CUR CURSOR FOR
	  SELECT A.ROWID,
	       A.DOC_TYPE_CODE,                   
	       A.DOC_NUM,                         
	       A.DOC_SLNO,                               
	       TO_CHAR(A.CANCELLED_DATE,'DD/MM/YYYY'),                        	       
	       (-1) * NVL(C.WO_APPROVED_AMT,0),
	       NVL(C.WO_APPROVED_AMT,0),                                
	       NVL(A.POSTED_IND,'N'),                             
	       NVL(B.EPISODE_TYPE,'R'),                           
	       B.EPISODE_ID,                             
	       B.VISIT_ID,                               	       
	       A.AGGR_DOC_TYPE_CODE,			
	       A.AGGR_DOC_NUM,                     
	       TO_CHAR(A.AGGR_DOC_DATE,'DD/MM/YYYY'),
	       A.CANCELLED_REMARKS,                                	
	       '4' TRX_TYPE_CODE,
	       B.BILL_TYPE_CODE,
		   B.CUST_CODE
	FROM BL_INST_WO_REQUEST_CANC_DTL A, BL_BILL_DCP_DTL_VW B,
	     BL_INST_WO_REQUEST_DTL C
	WHERE B.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND A.CANCELLED_DATE <= TO_DATE(:nd_date||' 23:59:59', 'DD/MM/YYYY HH24:MI:SS')
	AND NVL(A.POSTED_IND,'N')  != 'Y'
	AND A.AGGR_DOC_TYPE_CODE = B.DOC_TYPE_CODE
	AND A.AGGR_DOC_NUM = B.DOC_NUM
	AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
	AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE
	AND A.DOC_NUM = C.DOC_NUM
	AND A.DOC_SLNO = C.DOC_SLNO; */ 

}

void ins_bldcp_trn()
{
   l_dcp_trn_rec_exist = 0;   

   /* l_dcp_trn_rec_exist -> 1 means Record Exist.*/

   /* EXEC SQL SELECT 1 INTO :l_dcp_trn_rec_exist 
	    FROM BL_DCP_TRN
	    WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
	    AND PATIENT_ID = :recref_patient_id
	    AND ORG_DOC_TYPE_CODE = :recref_bill_doc_type_code
            AND ORG_DOC_NUMBER = :recref_bill_doc_number
	    AND DOC_TYPE_CODE = :recref_doc_type_code 
	    AND DOC_NUMBER = :recref_doc_number
	    AND NVL(CANCELLED_ENTRY_YN,'N') = NVL(:recref_dcp_ind,'N')
	    FOR UPDATE OF TRX_STATUS; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select 1 into :b0  from BL_DCP_TRN where ((((((OPERATING_F\
ACILITY_ID=:b1 and PATIENT_ID=:b2) and ORG_DOC_TYPE_CODE=:b3) and ORG_DOC_NUMB\
ER=:b4) and DOC_TYPE_CODE=:b5) and DOC_NUMBER=:b6) and NVL(CANCELLED_ENTRY_YN,\
'N')=NVL(:b7,'N')) for update of TRX_STATUS ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )498;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_dcp_trn_rec_exist;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&recref_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&recref_bill_doc_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&recref_bill_doc_number;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&recref_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&recref_doc_number;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&recref_dcp_ind;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	    

   if (NO_DATA_FOUND) 
	l_dcp_trn_rec_exist = 0;
		
   if (l_dcp_trn_rec_exist == 1)
   {
	  /* EXEC SQL UPDATE BL_DCP_TRN
	  SET POSTED_DATE = SYSDATE,
	      POSTED_BY_ID = USER
	  WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
	  AND PATIENT_ID = :recref_patient_id
	  AND ORG_DOC_TYPE_CODE = :recref_bill_doc_type_code
          AND ORG_DOC_NUMBER = :recref_bill_doc_number
	  AND DOC_TYPE_CODE = :recref_doc_type_code 
	  AND DOC_NUMBER = :recref_doc_number
	  AND POSTED_DATE IS NULL
	  AND NVL(CANCELLED_ENTRY_YN,'N') = NVL(:recref_dcp_ind,'N'); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update BL_DCP_TRN  set POSTED_DATE=SYSDATE,POSTED_BY_ID=US\
ER where (((((((OPERATING_FACILITY_ID=:b0 and PATIENT_ID=:b1) and ORG_DOC_TYPE\
_CODE=:b2) and ORG_DOC_NUMBER=:b3) and DOC_TYPE_CODE=:b4) and DOC_NUMBER=:b5) \
and POSTED_DATE is null ) and NVL(CANCELLED_ENTRY_YN,'N')=NVL(:b6,'N'))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )545;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&recref_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&recref_bill_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&recref_bill_doc_number;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&recref_doc_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&recref_doc_number;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&recref_dcp_ind;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    }
   else
   {	   
	   /* Rec/Ref fun. is inserting one record from front end. So, no need ti insert record here */

	   pendoc_max_line_num.arr[0] = '\0';
	   pendoc_max_line_num.len = 0;

	   /* EXEC SQL SELECT ROWID, nvl(max_line_num,0) + 1
		    INTO :pendoc_rowid, :pendoc_max_line_num
		    FROM BL_DCP_PENDING_DOC
		    WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		    AND PATIENT_ID = :recref_patient_id
		    AND ORG_DOC_TYPE_CODE = :recref_bill_doc_type_code
		    AND ORG_DOC_NUMBER = :recref_bill_doc_number; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ROWID ,(nvl(max_line_num,0)+1) into :b0,:b1  from \
BL_DCP_PENDING_DOC where (((OPERATING_FACILITY_ID=:b2 and PATIENT_ID=:b3) and \
ORG_DOC_TYPE_CODE=:b4) and ORG_DOC_NUMBER=:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )588;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&pendoc_rowid;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&pendoc_max_line_num;
    sqlstm.sqhstl[1] = (unsigned int  )12;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&recref_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&recref_bill_doc_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&recref_bill_doc_number;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

		

	   if (OERROR || NO_DATA_FOUND) 
	   {
	      log_mesg("SELECT failed on BL_DCP_PENDING_DOC",0,"");
	      return;
	   }

	   pendoc_max_line_num.arr[pendoc_max_line_num.len] = '\0';

	/******************* Commented by G Sriram ******************
		EXEC SQL UPDATE BL_PATIENT_FIN_DTLS
			SET TOT_DEF_PAT_OUTST_AMT = NVL(TOT_DEF_PAT_OUTST_AMT,0) -
			NVL(:recref_doc_amt, 0),
			MODIFIED_BY_ID         = USER,
			MODIFIED_DATE          = SYSDATE,
			ADDED_AT_WS_NO         = :nd_ws_no,
			ADDED_FACILITY_ID      = :nd_operating_facility_id,
			MODIFIED_AT_WS_NO      = :nd_ws_no,
			MODIFIED_FACILITY_ID   = :nd_operating_facility_id
			WHERE  PATIENT_ID = :recref_patient_id;

	   if (OERROR || NO_DATA_FOUND)
	      err_mesg("UPDATE failed on BL_PATIENT_FIN_DTLS",0,"");
	********************* End of Comment by G Sriram **************/

	/* EXEC SQL INSERT INTO BL_DCP_TRN
		     ( OPERATING_FACILITY_ID,
		       PATIENT_ID,
		       ORG_DOC_TYPE_CODE,
		       ORG_DOC_NUMBER,
		       LINE_NUM,
		       DOC_TYPE_CODE,
		       DOC_NUMBER,
		       DOC_DATE,
		       PAT_DOC_REFERENCE,
		       DOC_NATURE_CODE,
		       DOC_AMT,
		       TRX_TYPE_CODE,
		       NARRATION,
		       POST_MONTH,
		       POST_YEAR,
		       POSTED_DATE,
		       POSTED_BY_ID,
		       ADDED_BY_ID,
		       MODIFIED_BY_ID,         
		       ADDED_DATE,             
		       MODIFIED_DATE,          
		       ADDED_AT_WS_NO,         
		       ADDED_FACILITY_ID,      
		       MODIFIED_AT_WS_NO,      
		       MODIFIED_FACILITY_ID,
		       DOC_SRL_NO,             
		       CANCELLED_ENTRY_YN )
	    VALUES   ( :nd_operating_facility_id,
		       :recref_patient_id,
		       :recref_bill_doc_type_code,
		       :recref_bill_doc_number ,
		       :pendoc_max_line_num,
		       :recref_doc_type_code,
		       :recref_doc_number,
		       TO_DATE(:recref_doc_date,'DD/MM/YYYY'),
		       NULL,
		       NULL,
		       :recref_doc_amt_negative, 
		       :recref_trx_type_code,
		       :recref_narration,
		       :recref_post_month,
		       :recref_post_year,
		       NULL,
		       NULL,
		       user,
		       user,
		       sysdate,
		       sysdate,
		       :nd_ws_no,
		       :nd_operating_facility_id,
		       :nd_ws_no,
		       :nd_operating_facility_id,
		       NULL,
		       :recref_dcp_ind); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into BL_DCP_TRN (OPERATING_FACILITY_ID,PATIENT_ID,ORG\
_DOC_TYPE_CODE,ORG_DOC_NUMBER,LINE_NUM,DOC_TYPE_CODE,DOC_NUMBER,DOC_DATE,PAT_D\
OC_REFERENCE,DOC_NATURE_CODE,DOC_AMT,TRX_TYPE_CODE,NARRATION,POST_MONTH,POST_Y\
EAR,POSTED_DATE,POSTED_BY_ID,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DA\
TE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DOC\
_SRL_NO,CANCELLED_ENTRY_YN) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,TO_DATE(:b7,'D\
D/MM/YYYY'),null ,null ,:b8,:b9,:b10,:b11,:b12,null ,null ,user,user,sysdate,s\
ysdate,:b13,:b0,:b13,:b0,null ,:b17)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )627;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&recref_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&recref_bill_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&recref_bill_doc_number;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&pendoc_max_line_num;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&recref_doc_type_code;
 sqlstm.sqhstl[5] = (unsigned int  )9;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&recref_doc_number;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&recref_doc_date;
 sqlstm.sqhstl[7] = (unsigned int  )15;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&recref_doc_amt_negative;
 sqlstm.sqhstl[8] = (unsigned int  )23;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&recref_trx_type_code;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&recref_narration;
 sqlstm.sqhstl[10] = (unsigned int  )53;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&recref_post_month;
 sqlstm.sqhstl[11] = (unsigned int  )5;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&recref_post_year;
 sqlstm.sqhstl[12] = (unsigned int  )7;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[13] = (unsigned int  )33;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[14] = (unsigned int  )5;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[15] = (unsigned int  )33;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[16] = (unsigned int  )5;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&recref_dcp_ind;
 sqlstm.sqhstl[17] = (unsigned int  )4;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	   if (OERROR) {
	       log_mesg("INSERT failed on table BL_DCP_TRN",0,"");
	       return;
	   }

	   /* EXEC SQL UPDATE	BL_DCP_PENDING_DOC
		    SET		MAX_LINE_NUM = NVL(MAX_LINE_NUM,0) + 1,
				MODIFIED_BY_ID         = user,
				MODIFIED_DATE          = SYSDATE,
				ADDED_AT_WS_NO         = :nd_ws_no,
				ADDED_FACILITY_ID      = :nd_operating_facility_id,
				MODIFIED_AT_WS_NO      = :nd_ws_no,
				MODIFIED_FACILITY_ID   = :nd_operating_facility_id
		    WHERE	ROWID = :pendoc_rowid
		    AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_DCP_PENDING_DOC  set MAX_LINE_NUM=(NVL(MAX_LINE\
_NUM,0)+1),MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED_\
FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where (ROWID=:b\
4 and OPERATING_FACILITY_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )714;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&pendoc_rowid;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	   if (OERROR || NO_DATA_FOUND)
	   {
	      log_mesg("UPDATE failed on BL_DCP_PENDING_DOC",0,"");
	      return;
	   }
    }
}

void ins_blgl_distrib()
{    
    if( (recref_episode_type.arr[0] == 'I' && d_ip_gl_yn == 'N') ||
        (recref_episode_type.arr[0] == 'D' && d_ip_gl_yn == 'N') || 
        (recref_episode_type.arr[0] == 'O' && d_op_gl_yn == 'N') ||
        (recref_episode_type.arr[0] == 'E' && d_op_gl_yn == 'N') ||
        (recref_episode_type.arr[0] == 'R' && d_rf_gl_yn == 'N') ) 

	return;

	

   /* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION 
             ( OPERATING_FACILITY_ID,	
	           MAIN_ACC1_CODE,
               MAIN_ACC2_CODE,
               DEPT_CODE,
               PRODUCT_GROUP_CODE,
               PRODUCT_LINE_CODE,
               SUBLEDGER_GROUP_CODE,
               SUBLEDGER_LINE_CODE,
               POST_YEAR,
               POST_MONTH,
               TRX_DATE,
               TRX_DOC_REF,
               TRX_DOC_REF_LINE_NUM,
               TRX_DOC_REF_SEQ_NUM,
               EPISODE_TYPE,
               PATIENT_ID,
               EPISODE_ID,
               VISIT_ID,
               SOURCE_DOC_REF,
               SOURCE_DOC_DATE,
               NARRATION,
               TRX_TYPE_CODE,
               DISTRIBUTION_AMT,
               GL_INTERFACE_BY_ID,
               GL_INTERFACE_DATE,
               GL_INTERFACE_FLAG,
               DOC_REF,
	           ADDED_BY_ID,
	           MODIFIED_BY_ID,         
	           ADDED_DATE,             
               MODIFIED_DATE,          
               ADDED_AT_WS_NO,         
               ADDED_FACILITY_ID,      
               MODIFIED_AT_WS_NO,      
               MODIFIED_FACILITY_ID,
	       CASH_CTRL_DOC_TYPE,     
	       CASH_CTRL_DOC_NUMBER,   
	       CASH_CTRL_DOC_DATE,
	       CUST_CODE      
		)
    VALUES   ( :nd_operating_facility_id,
	       :xxxxxx_main_acc1_code,
               :xxxxxx_main_acc2_code,
               :xxxxxx_dept_code,
               :xxxxxx_product_group_code,
               :xxxxxx_product_line_code,
               :xxxxxx_subledger_group_code,
               :xxxxxx_subledger_line_code,
               :recref_post_year,
               :recref_post_month,
               TO_DATE(:recref_doc_date,'DD/MM/YYYY'),
               RPAD(:recref_doc_type_code,6)||
               SUBSTR(TO_CHAR(to_number(:recref_doc_number),'00000009'),2,8)||
			   SUBSTR(TO_CHAR(to_number(:recref_doc_srno),'0009'),1,4),
               0,
               0,
               :recref_episode_type,
               :recref_patient_id,
               :recref_episode_id,
               :recref_visit_id,
               NULL,
               NULL,
               :recref_narration,
               :recref_trx_type_code,
               :xxxxxx_doc_amt,
               NULL,
               NULL,
               'N',
               :recref_bank_recon_ref,		
	       user,
	       user,
	       sysdate,
	       sysdate,
	       :nd_ws_no,
	       :nd_operating_facility_id,
	       :nd_ws_no,
	       :nd_operating_facility_id,
	       :nd_doc_type,
	       :nd_doc_num,
	       :nd_doc_date,
	       :recref_customer_code
		); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (OPERATING_FACILITY_ID,MAIN\
_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,SUBLE\
DGER_GROUP_CODE,SUBLEDGER_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF,\
TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VI\
SIT_ID,SOURCE_DOC_REF,SOURCE_DOC_DATE,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT\
,GL_INTERFACE_BY_ID,GL_INTERFACE_DATE,GL_INTERFACE_FLAG,DOC_REF,ADDED_BY_ID,MO\
DIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIE\
D_AT_WS_NO,MODIFIED_FACILITY_ID,CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,CASH_C\
TRL_DOC_DATE,CUST_CODE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,TO_DAT\
E(:b10,'DD/MM/YYYY'),((RPAD(:b11,6)||SUBSTR(TO_CHAR(to_number(:b12),'00000009'\
),2,8))||SUBSTR(TO_CHAR(to_number(:b13),'0009'),1,4)),0,0,:b14,:b15,:b16,:b17,\
null ,null ,:b18,:b19,:b20,null ,null ,'N',:b21,user,user,sysdate,sysdate,:b22\
,:b0,:b22,:b0,:b26,:b27,:b28,:b29)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )753;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&xxxxxx_main_acc1_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&xxxxxx_main_acc2_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&xxxxxx_dept_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&xxxxxx_product_group_code;
   sqlstm.sqhstl[4] = (unsigned int  )6;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&xxxxxx_product_line_code;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&xxxxxx_subledger_group_code;
   sqlstm.sqhstl[6] = (unsigned int  )6;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&xxxxxx_subledger_line_code;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&recref_post_year;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&recref_post_month;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&recref_doc_date;
   sqlstm.sqhstl[10] = (unsigned int  )15;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&recref_doc_type_code;
   sqlstm.sqhstl[11] = (unsigned int  )9;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&recref_doc_number;
   sqlstm.sqhstl[12] = (unsigned int  )11;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&recref_doc_srno;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&recref_episode_type;
   sqlstm.sqhstl[14] = (unsigned int  )4;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&recref_patient_id;
   sqlstm.sqhstl[15] = (unsigned int  )23;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&recref_episode_id;
   sqlstm.sqhstl[16] = (unsigned int  )11;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&recref_visit_id;
   sqlstm.sqhstl[17] = (unsigned int  )7;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&recref_narration;
   sqlstm.sqhstl[18] = (unsigned int  )53;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&recref_trx_type_code;
   sqlstm.sqhstl[19] = (unsigned int  )4;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&xxxxxx_doc_amt;
   sqlstm.sqhstl[20] = (unsigned int  )23;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&recref_bank_recon_ref;
   sqlstm.sqhstl[21] = (unsigned int  )13;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[22] = (unsigned int  )33;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[23] = (unsigned int  )5;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[24] = (unsigned int  )33;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[25] = (unsigned int  )5;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&nd_doc_type;
   sqlstm.sqhstl[26] = (unsigned int  )9;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&nd_doc_num;
   sqlstm.sqhstl[27] = (unsigned int  )37;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&nd_doc_date;
   sqlstm.sqhstl[28] = (unsigned int  )32;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&recref_customer_code;
   sqlstm.sqhstl[29] = (unsigned int  )11;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




   if (OERROR) {
       log_mesg("INSERT failed on table BL_GL_DISTRIBUTION",0,"");
       return;
   }

}

void ins_blgl_distrib_bl()
{

    if( (t_episode_type.arr[0] == 'I' && d_ip_gl_yn == 'N') ||
        (t_episode_type.arr[0] == 'D' && d_ip_gl_yn == 'N') || 
        (t_episode_type.arr[0] == 'O' && d_op_gl_yn == 'N') ||
        (t_episode_type.arr[0] == 'E' && d_op_gl_yn == 'N') ||
        (t_episode_type.arr[0] == 'R' && d_rf_gl_yn == 'N'))

	return;

      
	disc_post_month.arr[0] = '\0';
	disc_post_month.len = 0;

        disc_post_year.arr[0] = '\0';
	disc_post_year.len = 0;


       /* exec sql select nvl(acc_per_year, to_char(to_date(:t_doc_date,'DD/MM/YYYY'),'YYYY')),
        nvl(acc_per_month,to_char(to_date(:t_doc_date,'DD/MM/YYYY'),'MM'))  
	into :disc_post_year, :disc_post_month
	from sy_acc_period_defn
	where to_date(:t_doc_date,'DD/MM/YYYY') 
	between acc_per_start_date and acc_per_end_date; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 30;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select nvl(acc_per_year,to_char(to_date(:b0,'DD/MM/YYY\
Y'),'YYYY')) ,nvl(acc_per_month,to_char(to_date(:b0,'DD/MM/YYYY'),'MM')) into \
:b2,:b3  from sy_acc_period_defn where to_date(:b0,'DD/MM/YYYY') between acc_p\
er_start_date and acc_per_end_date";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )888;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&t_doc_date;
       sqlstm.sqhstl[0] = (unsigned int  )15;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&t_doc_date;
       sqlstm.sqhstl[1] = (unsigned int  )15;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&disc_post_year;
       sqlstm.sqhstl[2] = (unsigned int  )7;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&disc_post_month;
       sqlstm.sqhstl[3] = (unsigned int  )5;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&t_doc_date;
       sqlstm.sqhstl[4] = (unsigned int  )15;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	

	disc_post_month.arr[disc_post_month.len] = '\0';
	disc_post_year.arr[disc_post_year.len] = '\0';
	

   /* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION 
             ( OPERATING_FACILITY_ID,
	       MAIN_ACC1_CODE,
               MAIN_ACC2_CODE,
               DEPT_CODE,
               PRODUCT_GROUP_CODE,
               PRODUCT_LINE_CODE,
               SUBLEDGER_GROUP_CODE,
               SUBLEDGER_LINE_CODE,
               POST_YEAR,
               POST_MONTH, 
               TRX_DATE,
               TRX_DOC_REF,
               TRX_DOC_REF_LINE_NUM,
               TRX_DOC_REF_SEQ_NUM,
               EPISODE_TYPE,
               PATIENT_ID,
               EPISODE_ID,
               VISIT_ID,
               SOURCE_DOC_REF,
               SOURCE_DOC_DATE,
               NARRATION,
               TRX_TYPE_CODE,
               DISTRIBUTION_AMT,
               GL_INTERFACE_BY_ID,
               GL_INTERFACE_DATE,
               GL_INTERFACE_FLAG,
               DOC_REF,
	       ADDED_BY_ID,
	       MODIFIED_BY_ID,         
	       ADDED_DATE,             
               MODIFIED_DATE,          
               ADDED_AT_WS_NO,         
               ADDED_FACILITY_ID,      
               MODIFIED_AT_WS_NO,      
               MODIFIED_FACILITY_ID,
	       CASH_CTRL_DOC_TYPE,     
	       CASH_CTRL_DOC_NUMBER,   
	       CASH_CTRL_DOC_DATE,
	       CUST_CODE   )

    VALUES   ( :nd_operating_facility_id,
	       :xxxxxx_main_acc1_code,
               :xxxxxx_main_acc2_code,
               :xxxxxx_dept_code,
               :xxxxxx_product_group_code,
               :xxxxxx_product_line_code,
               :xxxxxx_subledger_group_code,
               :xxxxxx_subledger_line_code,
	       nvl(:disc_post_year, TO_NUMBER(TO_CHAR(TO_DATE(:t_doc_date,'DD/MM/YYYY'),'YYYY'))),
	       nvl(:disc_post_month, TO_NUMBER(TO_CHAR(TO_DATE(:t_doc_date,'DD/MM/YYYY'),'MM'))), 
               TO_DATE(:t_doc_date,'DD/MM/YYYY'),
               RPAD(:t_doc_type_code,6)||SUBSTR(TO_CHAR(to_number(:t_doc_num),'00000009'),2,8),
               0,
               0,
               :t_episode_type,
               :t_patient_id,
               :t_episode_id,
               :t_visit_id,
               NULL,
               NULL,
               NULL,
               :t_bill_trx_type_code,
               :xxxxxx_doc_amt,
               NULL,
               NULL,
               'N',
               NULL,
	       user,
	       user,
	       sysdate,
	       sysdate,
	      :nd_ws_no,
	      :nd_operating_facility_id,
	      :nd_ws_no,
	      :nd_operating_facility_id,
	      :nd_doc_type,
	      :nd_doc_num,
	      :nd_doc_date,
	      :recref_customer_code
		); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (OPERATING_FACILITY_ID,MAIN\
_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,SUBLE\
DGER_GROUP_CODE,SUBLEDGER_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF,\
TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VI\
SIT_ID,SOURCE_DOC_REF,SOURCE_DOC_DATE,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT\
,GL_INTERFACE_BY_ID,GL_INTERFACE_DATE,GL_INTERFACE_FLAG,DOC_REF,ADDED_BY_ID,MO\
DIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIE\
D_AT_WS_NO,MODIFIED_FACILITY_ID,CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,CASH_C\
TRL_DOC_DATE,CUST_CODE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,nvl(:b8,TO_NUM\
BER(TO_CHAR(TO_DATE(:b9,'DD/MM/YYYY'),'YYYY'))),nvl(:b10,TO_NUMBER(TO_CHAR(TO_\
DATE(:b9,'DD/MM/YYYY'),'MM'))),TO_DATE(:b9,'DD/MM/YYYY'),(RPAD(:b13,6)||SUBSTR\
(TO_CHAR(to_number(:b14),'00000009'),2,8)),0,0,:b15,:b16,:b17,:b18,null ,null \
,null ,:b19,:b20,null ,null ,'N',null ,user,user,sysdate,sysdate,:b21,:b0,:b21\
,:b0,:b25,:b26,:b27,:b28)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )923;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&xxxxxx_main_acc1_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&xxxxxx_main_acc2_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&xxxxxx_dept_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&xxxxxx_product_group_code;
   sqlstm.sqhstl[4] = (unsigned int  )6;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&xxxxxx_product_line_code;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&xxxxxx_subledger_group_code;
   sqlstm.sqhstl[6] = (unsigned int  )6;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&xxxxxx_subledger_line_code;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&disc_post_year;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&t_doc_date;
   sqlstm.sqhstl[9] = (unsigned int  )15;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&disc_post_month;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&t_doc_date;
   sqlstm.sqhstl[11] = (unsigned int  )15;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&t_doc_date;
   sqlstm.sqhstl[12] = (unsigned int  )15;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&t_doc_type_code;
   sqlstm.sqhstl[13] = (unsigned int  )9;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&t_doc_num;
   sqlstm.sqhstl[14] = (unsigned int  )11;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&t_episode_type;
   sqlstm.sqhstl[15] = (unsigned int  )4;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&t_patient_id;
   sqlstm.sqhstl[16] = (unsigned int  )23;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&t_episode_id;
   sqlstm.sqhstl[17] = (unsigned int  )11;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&t_visit_id;
   sqlstm.sqhstl[18] = (unsigned int  )7;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&t_bill_trx_type_code;
   sqlstm.sqhstl[19] = (unsigned int  )4;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&xxxxxx_doc_amt;
   sqlstm.sqhstl[20] = (unsigned int  )23;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[21] = (unsigned int  )33;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[22] = (unsigned int  )5;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[23] = (unsigned int  )33;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[24] = (unsigned int  )5;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&nd_doc_type;
   sqlstm.sqhstl[25] = (unsigned int  )9;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&nd_doc_num;
   sqlstm.sqhstl[26] = (unsigned int  )37;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&nd_doc_date;
   sqlstm.sqhstl[27] = (unsigned int  )32;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&recref_customer_code;
   sqlstm.sqhstl[28] = (unsigned int  )11;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR) {
       err_mesg("INSERT failed on table BL_GL_DISTRIBUTION",0,"");
       return;
   }
}
get_disc_interface_for_bill()
{

t_bill_disc_recv_acc_int_code.arr[0]='\0';
t_bill_disc_recv_acc_int_code.len =0;

/* EXEC SQL SELECT B.BILL_DISC_RECV_ACC_INT_CODE
		  INTO   :t_bill_disc_recv_acc_int_code
        FROM BL_BILL_TYPE A, BL_BILL_TYPE_INT B
        WHERE A.BILL_TYPE_CODE = :t_bill_type_code
        AND   A.ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
				FROM   SY_ACC_ENTITY 
				WHERE  ACC_ENTITY_ID = :nd_operating_facility_id)
		AND  A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE
		AND  A.BILL_TYPE_CODE = B.BILL_TYPE_CODE
		AND TO_DATE(:t_doc_date,'DD/MM/YYYY') between 
		      NVL(B.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(B.EFF_TO_DATE,SYSDATE); */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 30;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select B.BILL_DISC_RECV_ACC_INT_CODE into :b0  from BL_BILL_T\
YPE A ,BL_BILL_TYPE_INT B where ((((A.BILL_TYPE_CODE=:b1 and A.ACC_ENTITY_CODE\
 in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b2)) and \
A.ACC_ENTITY_CODE=B.ACC_ENTITY_CODE) and A.BILL_TYPE_CODE=B.BILL_TYPE_CODE) an\
d TO_DATE(:b3,'DD/MM/YYYY') between NVL(B.EFF_FROM_DATE,TO_DATE('01/01/1900','\
DD/MM/YYYY')) and NVL(B.EFF_TO_DATE,SYSDATE))";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1054;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&t_bill_disc_recv_acc_int_code;
sqlstm.sqhstl[0] = (unsigned int  )9;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&t_bill_type_code;
sqlstm.sqhstl[1] = (unsigned int  )5;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
sqlstm.sqhstl[2] = (unsigned int  )5;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&t_doc_date;
sqlstm.sqhstl[3] = (unsigned int  )15;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

   /* Effective date range is included ON 01/06/2004 */

		if(OERROR)
	    err_mesg("SELECT failed on table BL_BILL_TYPE_INT",0,"");

        if(NO_DATA_FOUND)
		{  
		 sprintf(string_var,"Record - %s not found in BL_BILL_TYPE_INT",t_bill_type_code.arr);
	         err_mesg(string_var,0,"");
 		}   

        t_bill_disc_recv_acc_int_code.arr[t_bill_disc_recv_acc_int_code.len] = '\0';


}
void ins_blpat_ledger_trn()
{

     patltr_max_line_num.arr[0] = '\0';
     patltr_rowid.arr[0]        = '\0';

     patltr_max_line_num.len    = 0;
     patltr_rowid.len           = 0;

     if(!strcmp(recref_recpt_nature_code.arr,"BI")) {

         /* EXEC SQL SELECT ROWID, NVL(MAX_LINE_NUM,0) + 1
                  INTO   :patltr_rowid, :patltr_max_line_num
                  FROM   BL_PATIENT_LEDGER
                  WHERE  NVL(EPISODE_TYPE,'R') = NVL(:recref_episode_type,'R')
	            AND    OPERATING_FACILITY_ID = :nd_operating_facility_id		  
                  AND    PATIENT_ID = :recref_patient_id
                  AND    NVL(EPISODE_ID,0) = NVL(:recref_episode_id,0)
		  //AND    NVL(VISIT_ID,1) = DECODE(:recref_episode_type,'O',NVL(:recref_visit_id,VISIT_ID),VISIT_ID)
		  AND    NVL(VISIT_ID,1) = 
	    	         DECODE(:recref_episode_type,'O',NVL(:recref_visit_id,1),'E',NVL(:recref_visit_id,1),
        		 NVL(VISIT_ID,1))
                  AND    ORG_DOC_TYPE_CODE = :recref_bill_doc_type_code
                  AND    ORG_DOC_NUM = :recref_bill_doc_number; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 30;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "select ROWID ,(NVL(MAX_LINE_NUM,0)+1) into :b0,:b1  \
from BL_PATIENT_LEDGER where ((((((NVL(EPISODE_TYPE,'R')=NVL(:b2,'R') and OPER\
ATING_FACILITY_ID=:b3) and PATIENT_ID=:b4) and NVL(EPISODE_ID,0)=NVL(:b5,0)) a\
nd NVL(VISIT_ID,1)=DECODE(:b2,'O',NVL(:b7,1),'E',NVL(:b7,1),NVL(VISIT_ID,1))) \
and ORG_DOC_TYPE_CODE=:b9) and ORG_DOC_NUM=:b10)";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )1085;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&patltr_rowid;
         sqlstm.sqhstl[0] = (unsigned int  )23;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&patltr_max_line_num;
         sqlstm.sqhstl[1] = (unsigned int  )12;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&recref_episode_type;
         sqlstm.sqhstl[2] = (unsigned int  )4;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
         sqlstm.sqhstl[3] = (unsigned int  )5;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&recref_patient_id;
         sqlstm.sqhstl[4] = (unsigned int  )23;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&recref_episode_id;
         sqlstm.sqhstl[5] = (unsigned int  )11;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&recref_episode_type;
         sqlstm.sqhstl[6] = (unsigned int  )4;
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&recref_visit_id;
         sqlstm.sqhstl[7] = (unsigned int  )7;
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&recref_visit_id;
         sqlstm.sqhstl[8] = (unsigned int  )7;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&recref_bill_doc_type_code;
         sqlstm.sqhstl[9] = (unsigned int  )9;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqhstv[10] = (         void  *)&recref_bill_doc_number;
         sqlstm.sqhstl[10] = (unsigned int  )11;
         sqlstm.sqhsts[10] = (         int  )0;
         sqlstm.sqindv[10] = (         void  *)0;
         sqlstm.sqinds[10] = (         int  )0;
         sqlstm.sqharm[10] = (unsigned int  )0;
         sqlstm.sqadto[10] = (unsigned short )0;
         sqlstm.sqtdso[10] = (unsigned short )0;
         sqlstm.sqphsv = sqlstm.sqhstv;
         sqlstm.sqphsl = sqlstm.sqhstl;
         sqlstm.sqphss = sqlstm.sqhsts;
         sqlstm.sqpind = sqlstm.sqindv;
         sqlstm.sqpins = sqlstm.sqinds;
         sqlstm.sqparm = sqlstm.sqharm;
         sqlstm.sqparc = sqlstm.sqharc;
         sqlstm.sqpadto = sqlstm.sqadto;
         sqlstm.sqptdso = sqlstm.sqtdso;
         sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



         if (OERROR) {
            log_mesg("SELECT failed on BL_PATIENT_LEDGER",0,"");
	    return;
	 } 

         if (NO_DATA_FOUND)
            do_insrt();
	    if (g_error) return; // Added new

     }
     else {
    
         /* EXEC SQL SELECT ROWID, NVL(MAX_LINE_NUM,0) + 1
                  INTO   :patltr_rowid, :patltr_max_line_num
                  FROM   BL_PATIENT_LEDGER
                  WHERE  NVL(EPISODE_TYPE,'R') = NVL(:recref_episode_type,'R')
                  AND    PATIENT_ID = :recref_patient_id
	          AND    OPERATING_FACILITY_ID = :nd_operating_facility_id		  
                  AND    NVL(EPISODE_ID,0) = NVL(:recref_episode_id,0)
                  AND    NVL(VISIT_ID,1)  = NVL(:recref_visit_id,1)
                  AND    ORG_DOC_TYPE_CODE = :recref_doc_type_code
                  AND    ORG_DOC_NUM = :recref_doc_number
				  AND    ORG_DOC_SRNO = :recref_doc_srno; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 30;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "select ROWID ,(NVL(MAX_LINE_NUM,0)+1) into :b0,:b1  \
from BL_PATIENT_LEDGER where (((((((NVL(EPISODE_TYPE,'R')=NVL(:b2,'R') and PAT\
IENT_ID=:b3) and OPERATING_FACILITY_ID=:b4) and NVL(EPISODE_ID,0)=NVL(:b5,0)) \
and NVL(VISIT_ID,1)=NVL(:b6,1)) and ORG_DOC_TYPE_CODE=:b7) and ORG_DOC_NUM=:b8\
) and ORG_DOC_SRNO=:b9)";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )1144;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&patltr_rowid;
         sqlstm.sqhstl[0] = (unsigned int  )23;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&patltr_max_line_num;
         sqlstm.sqhstl[1] = (unsigned int  )12;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&recref_episode_type;
         sqlstm.sqhstl[2] = (unsigned int  )4;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&recref_patient_id;
         sqlstm.sqhstl[3] = (unsigned int  )23;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
         sqlstm.sqhstl[4] = (unsigned int  )5;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&recref_episode_id;
         sqlstm.sqhstl[5] = (unsigned int  )11;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&recref_visit_id;
         sqlstm.sqhstl[6] = (unsigned int  )7;
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&recref_doc_type_code;
         sqlstm.sqhstl[7] = (unsigned int  )9;
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&recref_doc_number;
         sqlstm.sqhstl[8] = (unsigned int  )11;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&recref_doc_srno;
         sqlstm.sqhstl[9] = (unsigned int  )7;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqphsv = sqlstm.sqhstv;
         sqlstm.sqphsl = sqlstm.sqhstl;
         sqlstm.sqphss = sqlstm.sqhsts;
         sqlstm.sqpind = sqlstm.sqindv;
         sqlstm.sqpins = sqlstm.sqinds;
         sqlstm.sqparm = sqlstm.sqharm;
         sqlstm.sqparc = sqlstm.sqharc;
         sqlstm.sqpadto = sqlstm.sqadto;
         sqlstm.sqptdso = sqlstm.sqtdso;
         sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



         if (OERROR||NO_DATA_FOUND) {
            log_mesg("SELECT failed on BL_PATIENT_LEDGER",0,"");
	    return;
	 }
    }
    

     patltr_max_line_num.arr[patltr_max_line_num.len] = '\0';
     patltr_rowid.arr[patltr_rowid.len] = '\0';

     if (recref_recpt_refund_ind.arr[0]=='R') /* RECEIPT */
     {
       strcpy(blpat_doc_amt.arr,recref_doc_amt_negative.arr);
       blpat_doc_amt.len = strlen(blpat_doc_amt.arr);
     }
     else /* REFUND CASE */
     {
       strcpy(blpat_doc_amt.arr,recref_doc_amt.arr);
       blpat_doc_amt.len = strlen(blpat_doc_amt.arr);
     }

     /* EXEC SQL INSERT INTO BL_PATIENT_LEDGER_TRN
                        ( OPERATING_FACILITY_ID,
		          EPISODE_TYPE,
                          PATIENT_ID,
                          EPISODE_ID,
                          VISIT_ID,
                          ORG_DOC_TYPE_CODE,
                          ORG_DOC_NUM,
                          LINE_NUM,
                          DOC_TYPE_CODE,
                          DOC_NUM,
                          DOC_DATE,
                          DOC_AMT,
                          TRX_TYPE_CODE,
                          BILL_TRX_TYPE_CODE,
                          BILL_NATURE_CODE,
                          RECPT_NATURE_CODE,
                          RECPT_TYPE_CODE,
                          NARRATION,
                          ADDED_BY_ID,
                          ADDED_DATE,
                          MODIFIED_BY_ID,
                          MODIFIED_DATE,
                          ADDED_AT_WS_NO,         
                          ADDED_FACILITY_ID,      
                          MODIFIED_AT_WS_NO,      
                          MODIFIED_FACILITY_ID    	
)
               VALUES   ( :nd_operating_facility_id,	
		          :recref_episode_type,
                          :recref_patient_id,
                          :recref_episode_id,
                          NVL(:recref_visit_id,0),
                          DECODE(:recref_recpt_nature_code,'BI',
                                 :recref_bill_doc_type_code,
                                 :recref_doc_type_code),
                          DECODE(:recref_recpt_nature_code,'BI',
                                 :recref_bill_doc_number,
                                 :recref_doc_number),
                          :patltr_max_line_num,
                          :recref_doc_type_code,
                          :recref_doc_number,
                          TO_DATE(:recref_doc_date,'DD/MM/YYYY'),
                          :blpat_doc_amt,
                          :recref_trx_type_code,
                          NULL,
                          NULL,
                          :recref_recpt_nature_code,
                          :recref_recpt_type_code,
                          :recref_narration,
                          USER,
                          TO_DATE(:date_time, 'DD/MM/YYYY HH24:MI'),
                          USER,
                          SYSDATE,
		   	  :nd_ws_no,
		          :nd_operating_facility_id,
		          :nd_ws_no,
		          :nd_operating_facility_id
			  ); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 30;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "insert into BL_PATIENT_LEDGER_TRN (OPERATING_FACILITY_ID\
,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,ORG_DOC_TYPE_CODE,ORG_DOC_NUM,LIN\
E_NUM,DOC_TYPE_CODE,DOC_NUM,DOC_DATE,DOC_AMT,TRX_TYPE_CODE,BILL_TRX_TYPE_CODE,\
BILL_NATURE_CODE,RECPT_NATURE_CODE,RECPT_TYPE_CODE,NARRATION,ADDED_BY_ID,ADDED\
_DATE,MODIFIED_BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_A\
T_WS_NO,MODIFIED_FACILITY_ID) values (:b0,:b1,:b2,:b3,NVL(:b4,0),DECODE(:b5,'B\
I',:b6,:b7),DECODE(:b5,'BI',:b9,:b10),:b11,:b7,:b10,TO_DATE(:b14,'DD/MM/YYYY')\
,:b15,:b16,null ,null ,:b5,:b18,:b19,USER,TO_DATE(:b20,'DD/MM/YYYY HH24:MI'),U\
SER,SYSDATE,:b21,:b0,:b21,:b0)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1199;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&recref_episode_type;
     sqlstm.sqhstl[1] = (unsigned int  )4;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&recref_patient_id;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&recref_episode_id;
     sqlstm.sqhstl[3] = (unsigned int  )11;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&recref_visit_id;
     sqlstm.sqhstl[4] = (unsigned int  )7;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&recref_recpt_nature_code;
     sqlstm.sqhstl[5] = (unsigned int  )5;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&recref_bill_doc_type_code;
     sqlstm.sqhstl[6] = (unsigned int  )9;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&recref_doc_type_code;
     sqlstm.sqhstl[7] = (unsigned int  )9;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&recref_recpt_nature_code;
     sqlstm.sqhstl[8] = (unsigned int  )5;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&recref_bill_doc_number;
     sqlstm.sqhstl[9] = (unsigned int  )11;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&recref_doc_number;
     sqlstm.sqhstl[10] = (unsigned int  )11;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&patltr_max_line_num;
     sqlstm.sqhstl[11] = (unsigned int  )12;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&recref_doc_type_code;
     sqlstm.sqhstl[12] = (unsigned int  )9;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&recref_doc_number;
     sqlstm.sqhstl[13] = (unsigned int  )11;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&recref_doc_date;
     sqlstm.sqhstl[14] = (unsigned int  )15;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&blpat_doc_amt;
     sqlstm.sqhstl[15] = (unsigned int  )23;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&recref_trx_type_code;
     sqlstm.sqhstl[16] = (unsigned int  )4;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&recref_recpt_nature_code;
     sqlstm.sqhstl[17] = (unsigned int  )5;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&recref_recpt_type_code;
     sqlstm.sqhstl[18] = (unsigned int  )6;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&recref_narration;
     sqlstm.sqhstl[19] = (unsigned int  )53;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&date_time;
     sqlstm.sqhstl[20] = (unsigned int  )32;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&nd_ws_no;
     sqlstm.sqhstl[21] = (unsigned int  )33;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[22] = (unsigned int  )5;
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&nd_ws_no;
     sqlstm.sqhstl[23] = (unsigned int  )33;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[24] = (unsigned int  )5;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if(OERROR) {
         log_mesg("INSERT failed on table BL_PATIENT_LEDGER_TRN",0,"");
	 return;
     }

/**************** Commented by G Sriram ***********************
     EXEC SQL UPDATE BL_PATIENT_LEDGER
              SET    MAX_LINE_NUM = MAX_LINE_NUM + 1,
                     DOC_OUTST_AMT = DECODE(:recref_recpt_nature_code,
                          'BI', NVL(DOC_OUTST_AMT,0) -:recref_doc_amt,
                          DOC_OUTST_AMT),
                     ADJ_AMT       = DECODE(:recref_recpt_nature_code,
                          'BI', NVL(ADJ_AMT,0) + :recref_doc_amt,
                          ADJ_AMT),
		    MODIFIED_BY_ID         = user,
	            MODIFIED_DATE          = SYSDATE,
		    ADDED_AT_WS_NO         = :nd_ws_no,
		    ADDED_FACILITY_ID      = :nd_operating_facility_id,
	            MODIFIED_AT_WS_NO      = :nd_ws_no,
		    MODIFIED_FACILITY_ID   = :nd_operating_facility_id
              WHERE  ROWID = :patltr_rowid	      ;	

     if (OERROR||NO_DATA_FOUND)
        err_mesg("UPDATE failed on BL_PATIENT_LEDGER",0,"");
******************************* End of Comment by G Sriram  *****/

}

void ins_arrec_hdr()
{

   /* EXEC SQL INSERT INTO AR_REC_HDR
                     (  ACC_ENTITY_CODE,
                        DOC_TYPE_CODE,
                        DOC_NUM,
                        LAST_LINE_NUM,
                        DOC_DATE,
                        DOC_REF,
                        CUST_CODE,
                        MAIN_ACC1_CODE,
                        MAIN_ACC2_CODE,
                        SUBLEDGER_GROUP_CODE,
                        SUBLEDGER_LINE_CODE,
                        DEPT_CODE,
                        PRODUCT_GROUP_CODE,
                        PRODUCT_LINE_CODE,
                        AMT_FOREIGN,
                        AMT_LOCAL,
                        NARRATION,
                        POST_MONTH,
                        POST_YEAR,
                        CURRENCY_CODE,
                        EXCHG_RATE,
                        BANK_DESC,
                        CHEQUE_NUM,
                        CHEQUE_DATE,
                        MISC_CUST_LONG_NAME,
                        MISC_CUST_SHORT_NAME,
                        MISC_CUST_ADD1_DESC,
                        MISC_CUST_ADD2_DESC,
                        MISC_CUST_ADD3_DESC,
                        MISC_CUST_ZIP_DESC,
                        MISC_CUST_LONG_NAME_CHINESE,
                        MISC_CUST_SHORT_NAME_CHINESE,
                        MISC_CUST_ADD1_DESC_CHINESE,
                        MISC_CUST_ADD2_DESC_CHINESE,
                        MISC_CUST_ADD3_DESC_CHINESE,
                        MISC_CUST_ZIP_DESC_CHINESE,
                        TEL_NUM,
                        CONTACT_NAME,
                        CONTACT_NAME_TITLE,

                        ERROR_FLAG,
                        PRINT_FLAG,
                        POSTED_FLAG,
                        INTERFACE_FLAG,
                        POSTED_DATE,
                        POSTED_BY_ID,
			ADDED_BY_ID    ,
			MODIFIED_BY_ID,
			ADDED_DATE     ,
			MODIFIED_DATE  )
             VALUES  (  :nd_acc_entity_code,
                        :recref_doc_type_code,
                        :recref_doc_number,
                        0,
                        TO_DATE(:recref_doc_date,'DD/MM/YYYY'),
                        :blsl_slmt_desc,
                        :recref_customer_code,
                        :othrac_main_acc1_code,
                        :othrac_main_acc2_code,
                        :othrac_subledger_group_code,
                        :othrac_subledger_line_code,
                        :othrac_dept_code,
                        :othrac_product_group_code,
                        :othrac_product_line_code,
                        0,
                        :recref_doc_amt,
                        :recref_narration,
                        :recref_post_month,
                        :recref_post_year,
                        NULL,
                        NULL,
                        :recref_slmt_doc_remarks,
                        substr(:recref_slmt_doc_ref_desc,1,10),
                        TO_DATE(:recref_slmt_doc_ref_date,'DD/MM/YYYY'),
                        NULL, /o :recref_misc_cust_long_name, o/
                        NULL, /o :recref_misc_cust_short_name, o/
                        NULL, /o :recref_misc_cust_add1_desc, o/
                        NULL, /o :recref_misc_cust_add2_desc, o/
                        NULL, /o :recref_misc_cust_add3_desc, o/
                        NULL, /o :recref_misc_cust_zip_desc, o/
                        NULL, /o :recref_misc_cust_long_name_chinese, o/
                        NULL, /o :recref_misc_cust_short_name_chinese, o/
                        NULL, /o :recref_misc_cust_add1_desc_chinese, o/
                        NULL, /o :recref_misc_cust_add2_desc_chinese, o/
                        NULL, /o :recref_misc_cust_add3_desc_chinese, o/
                        NULL, /o :recref_misc_cust_zip_desc_chinese, o/
                        NULL, /o:recref_tel_num, o/
                        NULL, /o:recref_contact_name, o/
                        NULL, /o:recref_contact_name_title, o/
                        NULL,
                        'Y',
                        NULL,
                        NULL,
                        NULL,
                        NULL,
			USER,
			USER,
			SYSDATE,
			SYSDATE); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "insert into AR_REC_HDR (ACC_ENTITY_CODE,DOC_TYPE_CODE,DOC_NUM,LAST_LIN\
E_NUM,DOC_DATE,DOC_REF,CUST_CODE,MAIN_ACC1_CODE,MAIN_ACC2_CODE,SUBLEDGER_GRO\
UP_CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,A\
MT_FOREIGN,AMT_LOCAL,NARRATION,POST_MONTH,POST_YEAR,CURRENCY_CODE,EXCHG_RATE\
,BANK_DESC,CHEQUE_NUM,CHEQUE_DATE,MISC_CUST_LONG_NAME,MISC_CUST_SHORT_NAME,M\
ISC_CUST_ADD1_DESC,MISC_CUST_ADD2_DESC,MISC_CUST_ADD3_DESC,MISC_CUST_ZIP_DES\
C,MISC_CUST_LONG_NAME_CHINESE,MISC_CUST_SHORT_NAME_CHINESE,MISC_CUST_ADD1_DE\
SC_CHINESE,MISC_CUST_ADD2_DESC_CHINESE,MISC_CUST_ADD3_DESC_CHINESE,MISC_CUST\
_ZIP_DESC_CHINESE,TEL_NUM,CONTACT_NAME,CONTACT_NAME_TITLE,ERROR_FLAG,PRINT_F\
LAG,POSTED_FLAG,INTERFACE_FLAG,POSTED_DATE,POSTED_BY_ID,ADDED_BY_ID,MODIFIED\
_BY_ID,ADDED_DATE,MODIFIED_DATE) values (:b0,:b1,:b2,0,TO_DATE(:b3,'DD/MM/YY\
YY'),:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,0,:b13,:b14,:b15,:b16,null ,null\
 ,:b17,substr(:b18,1,10),TO_DATE(:b19,'DD/MM/YYYY'),null ,null ,null ,null ,\
null ,null ,null ,null ,null ,null ,null ,");
   sqlstm.stmt = "null ,null ,null ,null ,null ,'Y',null ,null ,null ,null ,\
USER,USER,SYSDATE,SYSDATE)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1314;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&recref_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&recref_doc_number;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&recref_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )15;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&blsl_slmt_desc;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&recref_customer_code;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&othrac_main_acc1_code;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&othrac_main_acc2_code;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&othrac_subledger_group_code;
   sqlstm.sqhstl[8] = (unsigned int  )6;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&othrac_subledger_line_code;
   sqlstm.sqhstl[9] = (unsigned int  )11;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&othrac_dept_code;
   sqlstm.sqhstl[10] = (unsigned int  )13;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&othrac_product_group_code;
   sqlstm.sqhstl[11] = (unsigned int  )6;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&othrac_product_line_code;
   sqlstm.sqhstl[12] = (unsigned int  )7;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&recref_doc_amt;
   sqlstm.sqhstl[13] = (unsigned int  )23;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&recref_narration;
   sqlstm.sqhstl[14] = (unsigned int  )53;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&recref_post_month;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&recref_post_year;
   sqlstm.sqhstl[16] = (unsigned int  )7;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&recref_slmt_doc_remarks;
   sqlstm.sqhstl[17] = (unsigned int  )33;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&recref_slmt_doc_ref_desc;
   sqlstm.sqhstl[18] = (unsigned int  )23;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&recref_slmt_doc_ref_date;
   sqlstm.sqhstl[19] = (unsigned int  )15;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if(OERROR) {
       log_mesg("INSERT failed on table AR_REC_HDR",0,"");
       return;
   }
}
void open_recref_dtl()
{

   /* EXEC SQL OPEN BL_RECEIPT_REFUND_DTL_CUR ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0020;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1409;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
         err_mesg("OPEN failed on cursor PAT_TRN_HDR_CUR",0,"");
}

int fetch_recref_dtl()
{		      
   recref_rowid.arr[0]                = '\0';
   recref_recpt_refund_ind.arr[0]     = '\0';
   recref_doc_type_code.arr[0]        = '\0';
   recref_doc_number.arr[0]           = '\0';
   recref_doc_srno.arr[0]           = '\0';
   recref_trx_type_code.arr[0]        = '\0';
   recref_recpt_nature_code.arr[0]    = '\0';
   recref_debtor_category_code.arr[0] = '\0';
   recref_doc_date.arr[0]             = '\0';
   recref_post_month.arr[0]           = '\0';
   recref_post_year.arr[0]            = '\0';
   recref_trx_date_time.arr[0]        = '\0';
   recref_episode_type.arr[0]         = '\0';
   recref_patient_id.arr[0]           = '\0';
   recref_episode_id.arr[0]           = '\0';
   recref_visit_id.arr[0]             = '\0';
   recref_bill_doc_type_code.arr[0]   = '\0';
   recref_bill_doc_number.arr[0]      = '\0';
   recref_customer_code.arr[0]        = '\0';
   recref_cash_counter_code.arr[0]    = '\0';
   recref_shift_id.arr[0]             = '\0';
   recref_doc_amt.arr[0]              = '\0';
   recref_doc_amt_negative.arr[0]     = '\0';
   recref_recpt_type_code.arr[0]      = '\0';
   recref_slmt_type_code .arr[0]      = '\0';
   recref_slmt_doc_ref_desc.arr[0]    = '\0';
   recref_slmt_doc_ref_date.arr[0]    = '\0';
   recref_slmt_doc_remarks.arr[0]     = '\0';
   recref_bank_recon_ref .arr[0]      = '\0';
   recref_print_flag.arr[0]           = '\0';
   recref_cancelled_ind.arr[0]        = '\0';
   recref_posted_ind.arr[0]           = '\0';
   recref_narration.arr[0]            = '\0';
   recref_cons_receipt_yn.arr[0]      = '\0';


   nd_doc_type.arr[0]		      = '\0';
   nd_doc_num.arr[0]		      = '\0';
   nd_doc_date.arr[0]		      = '\0';

   recref_rowid.len                   = 0;
   recref_recpt_refund_ind.len        = 0;
   recref_doc_type_code.len           = 0;
   recref_doc_number.len              = 0;
   recref_doc_srno.len                = 0;
   recref_trx_type_code.len           = 0;
   recref_recpt_nature_code.len       = 0;
   recref_debtor_category_code.len    = 0;
   recref_doc_date.len                = 0;
   recref_post_month.len              = 0;
   recref_post_year.len               = 0;
   recref_trx_date_time.len           = 0;
   recref_episode_type.len            = 0;
   recref_patient_id.len              = 0;
   recref_episode_id.len              = 0;
   recref_visit_id.len                = 0;
   recref_bill_doc_type_code.len      = 0;
   recref_bill_doc_number.len         = 0;
   recref_customer_code.len           = 0;
   recref_cash_counter_code.len       = 0;
   recref_shift_id.len                = 0;
   recref_doc_amt.len                 = 0;
   recref_doc_amt_negative.len        = 0;
   recref_recpt_type_code.len         = 0;
   recref_slmt_type_code .len         = 0;
   recref_slmt_doc_ref_desc.len       = 0;
   recref_slmt_doc_ref_date.len       = 0;
   recref_slmt_doc_remarks.len        = 0;
   recref_bank_recon_ref .len         = 0;
   recref_print_flag.len              = 0;
   recref_cancelled_ind.len           = 0;
   recref_posted_ind.len              = 0;
   recref_narration.len               = 0;
   recref_cons_receipt_yn.len	      = 0;

   nd_doc_type.len = 0;
   nd_doc_num.len = 0;
   nd_doc_date.len = 0;

   /* EXEC SQL FETCH BL_RECEIPT_REFUND_DTL_CUR INTO
                  :recref_rowid,
                  :recref_recpt_refund_ind,
                  :recref_doc_type_code,
                  :recref_doc_number,
				  :recref_doc_srno,
                  :recref_trx_type_code,
                  :recref_recpt_nature_code,
                  :recref_debtor_category_code,
                  :recref_doc_date,
                  :recref_post_month,
                  :recref_post_year,
                  :recref_trx_date_time,
                  :recref_episode_type,
                  :recref_patient_id,
                  :recref_episode_id,
                  :recref_visit_id,
                  :recref_bill_doc_type_code,
                  :recref_bill_doc_number,
                  :recref_customer_code,
                  :recref_cash_counter_code,
                  :recref_shift_id,
                  :recref_doc_amt,
                  :recref_doc_amt_negative,
                  :recref_recpt_type_code,
                  :recref_slmt_type_code ,
                  :recref_slmt_doc_ref_desc,
                  :recref_slmt_doc_ref_date,
                  :recref_slmt_doc_remarks,
                  :recref_bank_recon_ref ,
                  :recref_print_flag,
                  :recref_cancelled_ind,
                  :recref_posted_ind,
                  :recref_narration,
		  :nd_doc_type,
		  :nd_doc_num,
		  :nd_doc_date,
		  :recref_cons_receipt_yn; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 37;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1432;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&recref_rowid;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&recref_recpt_refund_ind;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&recref_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&recref_doc_number;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&recref_doc_srno;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&recref_trx_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&recref_recpt_nature_code;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&recref_debtor_category_code;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&recref_doc_date;
   sqlstm.sqhstl[8] = (unsigned int  )15;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&recref_post_month;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&recref_post_year;
   sqlstm.sqhstl[10] = (unsigned int  )7;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&recref_trx_date_time;
   sqlstm.sqhstl[11] = (unsigned int  )14;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&recref_episode_type;
   sqlstm.sqhstl[12] = (unsigned int  )4;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&recref_patient_id;
   sqlstm.sqhstl[13] = (unsigned int  )23;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&recref_episode_id;
   sqlstm.sqhstl[14] = (unsigned int  )11;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&recref_visit_id;
   sqlstm.sqhstl[15] = (unsigned int  )7;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&recref_bill_doc_type_code;
   sqlstm.sqhstl[16] = (unsigned int  )9;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&recref_bill_doc_number;
   sqlstm.sqhstl[17] = (unsigned int  )11;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&recref_customer_code;
   sqlstm.sqhstl[18] = (unsigned int  )11;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&recref_cash_counter_code;
   sqlstm.sqhstl[19] = (unsigned int  )9;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&recref_shift_id;
   sqlstm.sqhstl[20] = (unsigned int  )4;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&recref_doc_amt;
   sqlstm.sqhstl[21] = (unsigned int  )23;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&recref_doc_amt_negative;
   sqlstm.sqhstl[22] = (unsigned int  )23;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&recref_recpt_type_code;
   sqlstm.sqhstl[23] = (unsigned int  )6;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&recref_slmt_type_code;
   sqlstm.sqhstl[24] = (unsigned int  )5;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&recref_slmt_doc_ref_desc;
   sqlstm.sqhstl[25] = (unsigned int  )23;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&recref_slmt_doc_ref_date;
   sqlstm.sqhstl[26] = (unsigned int  )15;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&recref_slmt_doc_remarks;
   sqlstm.sqhstl[27] = (unsigned int  )33;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&recref_bank_recon_ref;
   sqlstm.sqhstl[28] = (unsigned int  )13;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&recref_print_flag;
   sqlstm.sqhstl[29] = (unsigned int  )4;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&recref_cancelled_ind;
   sqlstm.sqhstl[30] = (unsigned int  )4;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&recref_posted_ind;
   sqlstm.sqhstl[31] = (unsigned int  )4;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&recref_narration;
   sqlstm.sqhstl[32] = (unsigned int  )53;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&nd_doc_type;
   sqlstm.sqhstl[33] = (unsigned int  )9;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&nd_doc_num;
   sqlstm.sqhstl[34] = (unsigned int  )37;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&nd_doc_date;
   sqlstm.sqhstl[35] = (unsigned int  )32;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&recref_cons_receipt_yn;
   sqlstm.sqhstl[36] = (unsigned int  )4;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

          
   

   if (OERROR)
      err_mesg("FETCH failed on BL_RECEIPT_REFUND_DTL_CUR",0,"");

   if (LAST_ROW) return (0);   

   recref_rowid.arr[recref_rowid.len]                               = '\0';
   recref_recpt_refund_ind.arr[recref_recpt_refund_ind.len]         = '\0';
   recref_doc_type_code.arr[recref_doc_type_code.len]               = '\0';
   recref_doc_number.arr[recref_doc_number.len]                     = '\0';
   recref_doc_srno.arr[recref_doc_srno.len]                     = '\0';
   recref_trx_type_code.arr[recref_trx_type_code.len]               = '\0';
   recref_recpt_nature_code.arr[recref_recpt_nature_code.len]       = '\0';
   recref_debtor_category_code.arr[recref_debtor_category_code.len] = '\0';
   recref_doc_date.arr[recref_doc_date.len]                         = '\0';
   recref_post_month.arr[recref_post_month.len]                     = '\0';
   recref_post_year.arr[recref_post_year.len]                       = '\0';
   recref_trx_date_time.arr[recref_trx_date_time.len]               = '\0';
   recref_episode_type.arr[recref_episode_type.len]                 = '\0';
   recref_patient_id.arr[recref_patient_id.len]                     = '\0';
   recref_episode_id.arr[recref_episode_id.len]                     = '\0';
   recref_visit_id.arr[recref_visit_id.len]                         = '\0';
   recref_bill_doc_type_code.arr[recref_bill_doc_type_code.len]     = '\0';
   recref_bill_doc_number.arr[recref_bill_doc_number.len]           = '\0';
   recref_customer_code.arr[recref_customer_code.len]               = '\0';
   recref_cash_counter_code.arr[recref_cash_counter_code.len]       = '\0';
   recref_shift_id.arr[recref_shift_id.len]                         = '\0';
   recref_doc_amt.arr[recref_doc_amt.len]                           = '\0';
   recref_doc_amt_negative.arr[recref_doc_amt_negative.len]         = '\0';
   recref_recpt_type_code.arr[recref_recpt_type_code.len]           = '\0';
   recref_slmt_type_code .arr[recref_slmt_type_code .len]           = '\0';
   recref_slmt_doc_ref_desc.arr[recref_slmt_doc_ref_desc.len]       = '\0';
   recref_slmt_doc_ref_date.arr[recref_slmt_doc_ref_date.len]       = '\0';
   recref_slmt_doc_remarks.arr[recref_slmt_doc_remarks.len]         = '\0';
   recref_bank_recon_ref .arr[recref_bank_recon_ref .len]           = '\0';
   recref_print_flag.arr[recref_print_flag.len]                     = '\0';
   recref_cancelled_ind.arr[recref_cancelled_ind.len]               = '\0';
   recref_posted_ind.arr[recref_posted_ind.len]                     = '\0';
   recref_narration.arr[recref_narration.len]                       = '\0';
   nd_doc_type.arr[nd_doc_type.len]	                            = '\0';
   nd_doc_num.arr[nd_doc_num.len]	                            = '\0';
   nd_doc_date.arr[nd_doc_date.len]	                            = '\0';
   recref_cons_receipt_yn.arr[recref_cons_receipt_yn.len]	    = '\0';

   if(!recref_trx_type_code.arr[0]) {
       if(recref_recpt_refund_ind.arr[0] == 'R')
	   strcpy(recref_trx_type_code.arr,"5");
       else if(recref_recpt_refund_ind.arr[0] == 'F')
	   strcpy(recref_trx_type_code.arr,"6");

      recref_trx_type_code.len = strlen(recref_trx_type_code.arr);
    }

   return 1;
}


void open_recref_dtl_bl()
{

   /* EXEC SQL OPEN BL_RECEIPT_REFUND_DTL_BL_CUR ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 37;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0021;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1595;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
         err_mesg("OPEN failed on cursor BL_RECEIPT_REFUND_DTL_BL_CUR",0,"");
}

int fetch_recref_dtl_bl()
{

   recref_rowid.arr[0]                = '\0';
   recref_recpt_refund_ind.arr[0]     = '\0';
   recref_doc_type_code.arr[0]        = '\0';
   recref_doc_number.arr[0]           = '\0';
   recref_doc_srno.arr[0]             = '\0';
   recref_trx_type_code.arr[0]        = '\0';
   recref_recpt_nature_code.arr[0]    = '\0';
   recref_debtor_category_code.arr[0] = '\0';
   recref_doc_date.arr[0]             = '\0';
   recref_post_month.arr[0]           = '\0';
   recref_post_year.arr[0]            = '\0';
   recref_trx_date_time.arr[0]        = '\0';
   recref_episode_type.arr[0]         = '\0';
   recref_patient_id.arr[0]           = '\0';
   recref_episode_id.arr[0]           = '\0';
   recref_visit_id.arr[0]             = '\0';
   recref_bill_doc_type_code.arr[0]   = '\0';
   recref_bill_doc_number.arr[0]      = '\0';
   recref_customer_code.arr[0]        = '\0';
   recref_cash_counter_code.arr[0]    = '\0';
   recref_shift_id.arr[0]             = '\0';
   recref_doc_amt.arr[0]              = '\0';
   recref_doc_amt_negative.arr[0]     = '\0';
   recref_recpt_type_code.arr[0]      = '\0';
   recref_slmt_type_code .arr[0]      = '\0';
   recref_slmt_doc_ref_desc.arr[0]    = '\0';
   recref_slmt_doc_ref_date.arr[0]    = '\0';
   recref_slmt_doc_remarks.arr[0]     = '\0';
   recref_bank_recon_ref .arr[0]      = '\0';
   recref_print_flag.arr[0]           = '\0';
   recref_cancelled_ind.arr[0]        = '\0';
   recref_posted_ind.arr[0]           = '\0';
   recref_narration.arr[0]            = '\0';

   nd_doc_type.arr[0]		      = '\0';
   nd_doc_num.arr[0]		      = '\0';
   nd_doc_date.arr[0]	              = '\0';
   recref_cons_receipt_yn.arr[0]      = '\0';

   recref_rowid.len                   = 0;
   recref_recpt_refund_ind.len        = 0;
   recref_doc_type_code.len           = 0;
   recref_doc_number.len              = 0;
   recref_doc_srno.len                = 0;
   recref_trx_type_code.len           = 0;
   recref_recpt_nature_code.len       = 0;
   recref_debtor_category_code.len    = 0;
   recref_doc_date.len                = 0;
   recref_post_month.len              = 0;
   recref_post_year.len               = 0;
   recref_trx_date_time.len           = 0;
   recref_episode_type.len            = 0;
   recref_patient_id.len              = 0;
   recref_episode_id.len              = 0;
   recref_visit_id.len                = 0;
   recref_bill_doc_type_code.len      = 0;
   recref_bill_doc_number.len         = 0;
   recref_customer_code.len           = 0;
   recref_cash_counter_code.len       = 0;
   recref_shift_id.len                = 0;
   recref_doc_amt.len                 = 0;
   recref_doc_amt_negative.len        = 0;
   recref_recpt_type_code.len         = 0;
   recref_slmt_type_code .len         = 0;
   recref_slmt_doc_ref_desc.len       = 0;
   recref_slmt_doc_ref_date.len       = 0;
   recref_slmt_doc_remarks.len        = 0;
   recref_bank_recon_ref .len         = 0;
   recref_print_flag.len              = 0;
   recref_cancelled_ind.len           = 0;
   recref_posted_ind.len              = 0;
   recref_narration.len               = 0;
   
   nd_doc_type.len = 0;
   nd_doc_num.len = 0;
   nd_doc_date.len = 0;
   recref_cons_receipt_yn.len = 0;


   /* EXEC SQL FETCH BL_RECEIPT_REFUND_DTL_BL_CUR INTO
                  :recref_rowid,
                  :recref_recpt_refund_ind,
                  :recref_doc_type_code,
                  :recref_doc_number,
                  :recref_trx_type_code,
                  :recref_recpt_nature_code,
                  :recref_debtor_category_code,
                  :recref_doc_date,
                  :recref_post_month,
                  :recref_post_year,
                  :recref_trx_date_time,
                  :recref_episode_type,
                  :recref_patient_id,
                  :recref_episode_id,
                  :recref_visit_id,
                  :recref_bill_doc_type_code,
                  :recref_bill_doc_number,
                  :recref_customer_code,
                  :recref_cash_counter_code,
                  :recref_shift_id,
                  :recref_doc_amt,
                  :recref_doc_amt_negative,
                  :recref_recpt_type_code,
                  :recref_slmt_type_code ,
                  :recref_slmt_doc_ref_desc,
                  :recref_slmt_doc_ref_date,
                  :recref_slmt_doc_remarks,
                  :recref_bank_recon_ref ,
                  :recref_print_flag,
                  :recref_cancelled_ind,
                  :recref_posted_ind,
                  :recref_narration,
		  :nd_doc_type,
		  :nd_doc_num,
		  :nd_doc_date,
		  :recref_cons_receipt_yn; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 37;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1618;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&recref_rowid;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&recref_recpt_refund_ind;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&recref_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&recref_doc_number;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&recref_trx_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&recref_recpt_nature_code;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&recref_debtor_category_code;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&recref_doc_date;
   sqlstm.sqhstl[7] = (unsigned int  )15;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&recref_post_month;
   sqlstm.sqhstl[8] = (unsigned int  )5;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&recref_post_year;
   sqlstm.sqhstl[9] = (unsigned int  )7;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&recref_trx_date_time;
   sqlstm.sqhstl[10] = (unsigned int  )14;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&recref_episode_type;
   sqlstm.sqhstl[11] = (unsigned int  )4;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&recref_patient_id;
   sqlstm.sqhstl[12] = (unsigned int  )23;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&recref_episode_id;
   sqlstm.sqhstl[13] = (unsigned int  )11;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&recref_visit_id;
   sqlstm.sqhstl[14] = (unsigned int  )7;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&recref_bill_doc_type_code;
   sqlstm.sqhstl[15] = (unsigned int  )9;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&recref_bill_doc_number;
   sqlstm.sqhstl[16] = (unsigned int  )11;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&recref_customer_code;
   sqlstm.sqhstl[17] = (unsigned int  )11;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&recref_cash_counter_code;
   sqlstm.sqhstl[18] = (unsigned int  )9;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&recref_shift_id;
   sqlstm.sqhstl[19] = (unsigned int  )4;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&recref_doc_amt;
   sqlstm.sqhstl[20] = (unsigned int  )23;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&recref_doc_amt_negative;
   sqlstm.sqhstl[21] = (unsigned int  )23;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&recref_recpt_type_code;
   sqlstm.sqhstl[22] = (unsigned int  )6;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&recref_slmt_type_code;
   sqlstm.sqhstl[23] = (unsigned int  )5;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&recref_slmt_doc_ref_desc;
   sqlstm.sqhstl[24] = (unsigned int  )23;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&recref_slmt_doc_ref_date;
   sqlstm.sqhstl[25] = (unsigned int  )15;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&recref_slmt_doc_remarks;
   sqlstm.sqhstl[26] = (unsigned int  )33;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&recref_bank_recon_ref;
   sqlstm.sqhstl[27] = (unsigned int  )13;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&recref_print_flag;
   sqlstm.sqhstl[28] = (unsigned int  )4;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&recref_cancelled_ind;
   sqlstm.sqhstl[29] = (unsigned int  )4;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&recref_posted_ind;
   sqlstm.sqhstl[30] = (unsigned int  )4;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&recref_narration;
   sqlstm.sqhstl[31] = (unsigned int  )53;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&nd_doc_type;
   sqlstm.sqhstl[32] = (unsigned int  )9;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&nd_doc_num;
   sqlstm.sqhstl[33] = (unsigned int  )37;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&nd_doc_date;
   sqlstm.sqhstl[34] = (unsigned int  )32;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&recref_cons_receipt_yn;
   sqlstm.sqhstl[35] = (unsigned int  )4;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
      err_mesg("FETCH failed on BL_RECEIPT_REFUND_DTL_BL_CUR",0,"");

   if (LAST_ROW) return (0);

   recref_rowid.arr[recref_rowid.len]                               = '\0';
   recref_recpt_refund_ind.arr[recref_recpt_refund_ind.len]         = '\0';
   recref_doc_type_code.arr[recref_doc_type_code.len]               = '\0';
   recref_doc_number.arr[recref_doc_number.len]                     = '\0';
   recref_trx_type_code.arr[recref_trx_type_code.len]               = '\0';
   recref_recpt_nature_code.arr[recref_recpt_nature_code.len]       = '\0';
   recref_debtor_category_code.arr[recref_debtor_category_code.len] = '\0';
   recref_doc_date.arr[recref_doc_date.len]                         = '\0';
   recref_post_month.arr[recref_post_month.len]                     = '\0';
   recref_post_year.arr[recref_post_year.len]                       = '\0';
   recref_trx_date_time.arr[recref_trx_date_time.len]               = '\0';
   recref_episode_type.arr[recref_episode_type.len]                 = '\0';
   recref_patient_id.arr[recref_patient_id.len]                     = '\0';
   recref_episode_id.arr[recref_episode_id.len]                     = '\0';
   recref_visit_id.arr[recref_visit_id.len]                         = '\0';
   recref_bill_doc_type_code.arr[recref_bill_doc_type_code.len]     = '\0';
   recref_bill_doc_number.arr[recref_bill_doc_number.len]           = '\0';
   recref_customer_code.arr[recref_customer_code.len]               = '\0';
   recref_cash_counter_code.arr[recref_cash_counter_code.len]       = '\0';
   recref_shift_id.arr[recref_shift_id.len]                         = '\0';
   recref_doc_amt.arr[recref_doc_amt.len]                           = '\0';
   recref_doc_amt_negative.arr[recref_doc_amt_negative.len]         = '\0';
   recref_recpt_type_code.arr[recref_recpt_type_code.len]           = '\0';
   recref_slmt_type_code .arr[recref_slmt_type_code .len]           = '\0';
   recref_slmt_doc_ref_desc.arr[recref_slmt_doc_ref_desc.len]       = '\0';
   recref_slmt_doc_ref_date.arr[recref_slmt_doc_ref_date.len]       = '\0';
   recref_slmt_doc_remarks.arr[recref_slmt_doc_remarks.len]         = '\0';
   recref_bank_recon_ref .arr[recref_bank_recon_ref .len]           = '\0';
   recref_print_flag.arr[recref_print_flag.len]                     = '\0';
   recref_cancelled_ind.arr[recref_cancelled_ind.len]               = '\0';
   recref_posted_ind.arr[recref_posted_ind.len]                     = '\0';
   recref_narration.arr[recref_narration.len]                       = '\0';
   nd_doc_type.arr[nd_doc_type.len]		                    = '\0';
   nd_doc_num.arr[nd_doc_num.len]		                    = '\0';
   nd_doc_date.arr[nd_doc_date.len]		                    = '\0';
   recref_cons_receipt_yn.arr[recref_cons_receipt_yn.len]	    = '\0';

   if(!recref_trx_type_code.arr[0]) {
       if(recref_recpt_refund_ind.arr[0] == 'R')
	   strcpy(recref_trx_type_code.arr,"5");
       else if(recref_recpt_refund_ind.arr[0] == 'P')
	   strcpy(recref_trx_type_code.arr,"6");

      recref_trx_type_code.len = strlen(recref_trx_type_code.arr);
    }


   return 1;
}

void init_old()
{
   old_cash_counter_code[0] = '\0';
   old_slmt_type_code[0]    = '\0';
}

int brk_cash()
{
   if (strcmp(old_cash_counter_code, recref_cash_counter_code.arr)!=0)
   {
      strcpy(old_cash_counter_code, recref_cash_counter_code.arr);
      return 1;
   }
   return 0;
}

int brk_slmt()
{
   if (strcmp(old_slmt_type_code, recref_slmt_type_code.arr)!=0)
   {
      strcpy(old_slmt_type_code, recref_slmt_type_code.arr);
      return 1;
   }
   return 0;
}

void get_slmt_desc()
{
    /* EXEC SQL OPEN BL_SLMT_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0027;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1777;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&recref_slmt_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR) {
       log_mesg("OPEN failed on BL_STMT_TYPE_CUR",0,"");
	return ;
    }   

    blsl_slmt_desc.arr[0] = '\0';

    blsl_slmt_desc.len    = 0;

    /* EXEC SQL FETCH BL_SLMT_TYPE_CUR INTO
                   :blsl_slmt_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1796;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&blsl_slmt_desc;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR) {
       log_mesg("FETCH failed on BL_STMT_TYPE_CUR",0,"");
       return;
    }

     if (ROW_COUNT == 0)
     {
	   sprintf(msg_str,"Record for %s  not found in BL_SLMT_TYPE",recref_slmt_type_code.arr);
	   disp_message(ERR_MESG,msg_str);
	   loc_log_msg(msg_str);
     }



    blsl_slmt_desc.arr[blsl_slmt_desc.len] = '\0';
}

void get_bank_acc()
{
    bankac_main_acc1_code.arr[0]       = '\0';
    bankac_main_acc2_code.arr[0]       = '\0';
    bankac_dept_code.arr[0]            = '\0';
    bankac_subledger_group_code.arr[0] = '\0';
    bankac_subledger_line_code.arr[0]  = '\0';
    bankac_product_group_code.arr[0]   = '\0';
    bankac_product_line_code.arr[0]    = '\0';

    bankac_main_acc1_code.len         = 0;
    bankac_main_acc2_code.len         = 0;
    bankac_dept_code.len              = 0;
    bankac_subledger_group_code.len   = 0;
    bankac_subledger_line_code.len    = 0;
    bankac_product_group_code.len     = 0;
    bankac_product_line_code.len      = 0;

    /* EXEC SQL OPEN BL_GL_ACCOUNT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0022;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1815;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&recref_slmt_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&recref_cash_counter_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&recref_doc_date;
    sqlstm.sqhstl[3] = (unsigned int  )15;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[4] = (unsigned int  )5;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
    if (OERROR)
       err_mesg("OPEN failed on BL_GL_ACCOUNT_CUR",0,"");

    /* EXEC SQL FETCH BL_GL_ACCOUNT_CUR INTO
                      :bankac_main_acc1_code ,
                      :bankac_main_acc2_code ,
                      :bankac_dept_code,
                      :bankac_subledger_group_code,
                      :bankac_subledger_line_code,
                      :bankac_product_group_code,
                      :bankac_product_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1850;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bankac_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bankac_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bankac_dept_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bankac_subledger_group_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bankac_subledger_line_code;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bankac_product_group_code;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bankac_product_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR) {
       log_mesg("FETCH failed on BL_GL_ACCOUNT_CUR",0,"");
       init_old();
       return;
		}

    if (ROW_COUNT == 0)
     {
	   sprintf(msg_str,"Record for %s - %s - %s not found in BL_SLMT_CASH_COUNTER_INT",
			  nd_operating_facility_id.arr,
			  recref_cash_counter_code.arr,
			  recref_slmt_type_code.arr
			  );
	  //disp_message(ERR_MESG,msg_str);
	  loc_log_msg(msg_str);
	  // log_mesg("msg_str",0,"");
	   return;
     }

    bankac_main_acc1_code.arr[bankac_main_acc1_code.len]             = '\0';
    bankac_main_acc2_code.arr[bankac_main_acc2_code.len]             = '\0';
    bankac_dept_code.arr[bankac_dept_code.len]                       = '\0';
    bankac_subledger_group_code.arr[bankac_subledger_group_code.len] = '\0';
    bankac_subledger_line_code.arr[bankac_subledger_line_code.len]   = '\0';
    bankac_product_group_code.arr[bankac_product_group_code.len]     = '\0';
    bankac_product_line_code.arr[bankac_product_line_code.len]       = '\0';
}

void get_other_acc(int i) /* 0 - RECEIPT REFUND 1 - BILLS  2 - RD  3 - DC */
{    
    othrac_main_acc1_code.arr[0]       = '\0';
    othrac_main_acc2_code.arr[0]       = '\0';
    othrac_dept_code.arr[0]            = '\0';
    othrac_subledger_group_code.arr[0] = '\0';
    othrac_subledger_line_code.arr[0]  = '\0';
    othrac_product_group_code.arr[0]   = '\0';
    othrac_product_line_code.arr[0]    = '\0';

    othrac_main_acc1_code.len         = 0;
    othrac_main_acc2_code.len         = 0;
    othrac_dept_code.len              = 0;
    othrac_subledger_group_code.len   = 0;
    othrac_subledger_line_code.len    = 0;
    othrac_product_group_code.len     = 0;
    othrac_product_line_code.len      = 0;

    switch (i) {
    case 0 :
        /* EXEC SQL OPEN BL_GL_ACCOUNT_OTHER_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0023;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1893;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&recref_recpt_type_code;
        sqlstm.sqhstl[0] = (unsigned int  )6;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&recref_doc_date;
        sqlstm.sqhstl[1] = (unsigned int  )15;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[2] = (unsigned int  )5;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
        if (OERROR) {
           log_mesg("OPEN failed on BL_GL_ACCOUNT_OTHER_CUR",0,"");
	   return;
	}     

        /* EXEC SQL FETCH BL_GL_ACCOUNT_OTHER_CUR INTO
                          :othrac_main_acc1_code ,
                          :othrac_main_acc2_code ,
                          :othrac_dept_code,
                          :othrac_subledger_group_code,
                          :othrac_subledger_line_code,
                          :othrac_product_group_code,
                          :othrac_product_line_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1920;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&othrac_main_acc1_code;
        sqlstm.sqhstl[0] = (unsigned int  )9;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&othrac_main_acc2_code;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&othrac_dept_code;
        sqlstm.sqhstl[2] = (unsigned int  )13;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&othrac_subledger_group_code;
        sqlstm.sqhstl[3] = (unsigned int  )6;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&othrac_subledger_line_code;
        sqlstm.sqhstl[4] = (unsigned int  )11;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&othrac_product_group_code;
        sqlstm.sqhstl[5] = (unsigned int  )6;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&othrac_product_line_code;
        sqlstm.sqhstl[6] = (unsigned int  )7;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



        if (OERROR) {    

           log_mesg("FETCH failed on BL_GL_ACCOUNT_OTHER_CUR",0,"");
	   return;
	}

       if (ROW_COUNT == 0)
       {          
	   sprintf(msg_str,"Record for %s - %s not found in BL_RECEIPT_TYPE_INT",
			  nd_operating_facility_id.arr,
			  recref_recpt_type_code.arr);
	   
	   //disp_message(ERR_MESG,msg_str);
	   //log_mesg(msg_str,0,"");

	   loc_log_msg(msg_str);
	   strcpy(msg_str_var,msg_str);
	   g_error = 1;	   	    
	   upd_recref_unpost_reason();	   
	  return;
       }     
		
        /* EXEC SQL CLOSE BL_GL_ACCOUNT_OTHER_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1963;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        break;

    case 1: 

        /* EXEC SQL OPEN BL_GL_ACCOUNT_OTHER_BL_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0026;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1978;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&recref_bill_doc_type_code;
        sqlstm.sqhstl[0] = (unsigned int  )9;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&recref_bill_doc_number;
        sqlstm.sqhstl[1] = (unsigned int  )11;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[2] = (unsigned int  )5;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
        if (OERROR) {
           log_mesg("OPEN failed on BL_GL_ACCOUNT_OTHER_BL_CUR",0,"");
	   return;
	}

        /* EXEC SQL FETCH BL_GL_ACCOUNT_OTHER_BL_CUR INTO
                          :othrac_main_acc1_code ,
                          :othrac_main_acc2_code ,
                          :othrac_dept_code,
                          :othrac_subledger_group_code,
                          :othrac_subledger_line_code,
                          :othrac_product_group_code,
                          :othrac_product_line_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2009;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&othrac_main_acc1_code;
        sqlstm.sqhstl[0] = (unsigned int  )9;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&othrac_main_acc2_code;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&othrac_dept_code;
        sqlstm.sqhstl[2] = (unsigned int  )13;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&othrac_subledger_group_code;
        sqlstm.sqhstl[3] = (unsigned int  )6;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&othrac_subledger_line_code;
        sqlstm.sqhstl[4] = (unsigned int  )11;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&othrac_product_group_code;
        sqlstm.sqhstl[5] = (unsigned int  )6;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&othrac_product_line_code;
        sqlstm.sqhstl[6] = (unsigned int  )7;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



        if (OERROR) {
           log_mesg("FETCH failed on BL_GL_ACCOUNT_OTHER_BL_CUR",0,"");
	   return;
	}
     if (ROW_COUNT == 0)     
      {
	   sprintf(msg_str,"Record for %s - %s not found in BL_BILL_TYPE_INT for the document %s - %s",
			  nd_operating_facility_id.arr,
			  t_bill_type_code.arr,
			  recref_bill_doc_type_code.arr,
			  recref_bill_doc_number.arr);
	   //disp_message(ERR_MESG,msg_str);
	   loc_log_msg(msg_str);
	   //log_mesg(msg_str,0,"");
	   g_error = 1;
	   return;
      }

         /* EXEC SQL CLOSE BL_GL_ACCOUNT_OTHER_BL_CUR; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 37;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )2052;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


         break;

    case 2:     

        /* EXEC SQL OPEN BL_GL_ACCOUNT_OTHER_RD_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0024;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2067;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&recref_episode_type;
        sqlstm.sqhstl[0] = (unsigned int  )4;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&recref_patient_id;
        sqlstm.sqhstl[1] = (unsigned int  )23;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&recref_episode_id;
        sqlstm.sqhstl[2] = (unsigned int  )11;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&recref_episode_type;
        sqlstm.sqhstl[3] = (unsigned int  )4;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&recref_visit_id;
        sqlstm.sqhstl[4] = (unsigned int  )7;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&recref_bill_doc_type_code;
        sqlstm.sqhstl[5] = (unsigned int  )9;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&recref_bill_doc_number;
        sqlstm.sqhstl[6] = (unsigned int  )11;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[7] = (unsigned int  )5;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[8] = (unsigned int  )5;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
        if (OERROR) {
           log_mesg("OPEN failed on BL_GL_ACCOUNT_OTHER_RD_CUR",0,"");
	   return;
	}

        /* EXEC SQL FETCH BL_GL_ACCOUNT_OTHER_RD_CUR INTO
                          :othrac_main_acc1_code ,
                          :othrac_main_acc2_code ,
                          :othrac_dept_code,
                          :othrac_subledger_group_code,
                          :othrac_subledger_line_code,
                          :othrac_product_group_code,
                          :othrac_product_line_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2118;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&othrac_main_acc1_code;
        sqlstm.sqhstl[0] = (unsigned int  )9;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&othrac_main_acc2_code;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&othrac_dept_code;
        sqlstm.sqhstl[2] = (unsigned int  )13;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&othrac_subledger_group_code;
        sqlstm.sqhstl[3] = (unsigned int  )6;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&othrac_subledger_line_code;
        sqlstm.sqhstl[4] = (unsigned int  )11;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&othrac_product_group_code;
        sqlstm.sqhstl[5] = (unsigned int  )6;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&othrac_product_line_code;
        sqlstm.sqhstl[6] = (unsigned int  )7;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        if (OERROR) {
           log_mesg("FETCH failed on BL_GL_ACCOUNT_OTHER_RD_CUR",0,"");
	   return;
	}

	if (ROW_COUNT == 0)
     {
	   sprintf(msg_str,"Record for %s - %s not found in BL_RECEIPT_TYPE_INT for the document %s - %s",
			  nd_operating_facility_id.arr,
			  recref_recpt_type_code.arr,
			  recref_bill_doc_type_code.arr,
			  recref_bill_doc_number.arr);

	   //disp_message(ERR_MESG,msg_str);
	   loc_log_msg(msg_str);
	   //log_mesg(msg_str,0,"");
	   g_error = 1;	   
	   upd_recref_unpost_reason();
	   return;
     }

     

        /* EXEC SQL CLOSE BL_GL_ACCOUNT_OTHER_RD_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2161;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        break;


    case 3: 

        /* EXEC SQL OPEN BL_GL_ACCOUNT_OTHER_DC_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0025;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2176;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&recref_patient_id;
        sqlstm.sqhstl[0] = (unsigned int  )23;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&recref_bill_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&recref_bill_doc_number;
        sqlstm.sqhstl[2] = (unsigned int  )11;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[4] = (unsigned int  )5;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
        if (OERROR) {
           log_mesg("OPEN failed on BL_GL_ACCOUNT_OTHER_DC_CUR",0,"");
	   return;
	}

        /* EXEC SQL FETCH BL_GL_ACCOUNT_OTHER_DC_CUR INTO
                          :othrac_main_acc1_code ,
                          :othrac_main_acc2_code ,
                          :othrac_dept_code,
                          :othrac_subledger_group_code,
                          :othrac_subledger_line_code,
                          :othrac_product_group_code,
                          :othrac_product_line_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2211;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&othrac_main_acc1_code;
        sqlstm.sqhstl[0] = (unsigned int  )9;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&othrac_main_acc2_code;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&othrac_dept_code;
        sqlstm.sqhstl[2] = (unsigned int  )13;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&othrac_subledger_group_code;
        sqlstm.sqhstl[3] = (unsigned int  )6;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&othrac_subledger_line_code;
        sqlstm.sqhstl[4] = (unsigned int  )11;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&othrac_product_group_code;
        sqlstm.sqhstl[5] = (unsigned int  )6;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&othrac_product_line_code;
        sqlstm.sqhstl[6] = (unsigned int  )7;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



        if (OERROR) {
           log_mesg("FETCH failed on BL_GL_ACCOUNT_OTHER_DC_CUR",0,"");
	   return;
	}
      nd_dcp_bill_type_code.arr[0] = '\0';
      nd_dcp_bill_type_code.len = 0;

      /* EXEC SQL SELECT BILL_TYPE_CODE INTO :nd_dcp_bill_type_code 
      FROM BL_DCP_PENDING_DOC 
      WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
      AND ORG_DOC_TYPE_CODE  = :recref_bill_doc_type_code
      AND  ORG_DOC_NUMBER     = :recref_bill_doc_number; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 37;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select BILL_TYPE_CODE into :b0  from BL_DCP_PENDING_DOC\
 where ((OPERATING_FACILITY_ID=:b1 and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUMB\
ER=:b3)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )2254;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_dcp_bill_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
      sqlstm.sqhstl[1] = (unsigned int  )5;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&recref_bill_doc_type_code;
      sqlstm.sqhstl[2] = (unsigned int  )9;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&recref_bill_doc_number;
      sqlstm.sqhstl[3] = (unsigned int  )11;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if (OERROR) {
           log_mesg("FETCH failed on BL_GL_ACCOUNT_OTHER_DC_CUR",0,"");
	   return;
	}
      nd_dcp_bill_type_code.arr[nd_dcp_bill_type_code.len] = '\0';

      if (ROW_COUNT == 0)
      {
	 sprintf(msg_str,"Record for %s - %s not found in BL_BILL_TYPE_INT for the document %s - %s",
			  nd_operating_facility_id.arr,
			  nd_dcp_bill_type_code.arr,
			  recref_bill_doc_type_code.arr,
			  recref_bill_doc_number.arr);
	   //disp_message(ERR_MESG,msg_str);
	   loc_log_msg(msg_str);
	   //log_mesg(msg_str,0,"");
	   g_error = 1;
	   upd_recref_unpost_reason();
	   return;
      }


        /* EXEC SQL CLOSE BL_GL_ACCOUNT_OTHER_DC_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2285;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        break;
    }

    othrac_main_acc1_code.arr[othrac_main_acc1_code.len]             = '\0';
    othrac_main_acc2_code.arr[othrac_main_acc2_code.len]             = '\0';
    othrac_dept_code.arr[othrac_dept_code.len]                       = '\0';
    othrac_subledger_group_code.arr[othrac_subledger_group_code.len] = '\0';
    othrac_subledger_line_code.arr[othrac_subledger_line_code.len]   = '\0';
    othrac_product_group_code.arr[othrac_product_group_code.len]     = '\0';
    othrac_product_line_code.arr[othrac_product_line_code.len]       = '\0';

}

void move_into_post_acc(int i /* 0 - BANK ; 1 - OTHER */)
{
   if (i==0)
   {
    strcpy(xxxxxx_main_acc1_code.arr,bankac_main_acc1_code.arr);
    xxxxxx_main_acc1_code.len = strlen(xxxxxx_main_acc1_code.arr);
    strcpy(xxxxxx_main_acc2_code.arr,bankac_main_acc2_code.arr);
    xxxxxx_main_acc2_code.len = strlen(xxxxxx_main_acc2_code.arr);
    strcpy(xxxxxx_dept_code.arr,bankac_dept_code.arr);
    xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);
    strcpy(xxxxxx_subledger_group_code.arr,bankac_subledger_group_code.arr);
    xxxxxx_subledger_group_code.len = strlen(xxxxxx_subledger_group_code.arr);
    strcpy(xxxxxx_subledger_line_code.arr,bankac_subledger_line_code.arr);
    xxxxxx_subledger_line_code.len = strlen(xxxxxx_subledger_line_code.arr);
    strcpy(xxxxxx_product_group_code.arr,bankac_product_group_code.arr);
    xxxxxx_product_group_code.len = strlen(xxxxxx_product_group_code.arr);
    strcpy(xxxxxx_product_line_code.arr,bankac_product_line_code.arr);
    xxxxxx_product_line_code.len = strlen(xxxxxx_product_line_code.arr);

    strcpy(xxxxxx_doc_amt.arr,recref_doc_amt.arr);
    xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);

    /*
    if (recref_recpt_refund_ind.arr[0]=='R')
    {
       strcpy(xxxxxx_doc_amt.arr,recref_doc_amt.arr);
       xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);
    }
    else
    {
       strcpy(xxxxxx_doc_amt.arr,recref_doc_amt_negative.arr);
       xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);
    }
    */

   }
   else
   {
    strcpy(xxxxxx_main_acc1_code.arr,othrac_main_acc1_code.arr);
    xxxxxx_main_acc1_code.len = strlen(xxxxxx_main_acc1_code.arr);
    strcpy(xxxxxx_main_acc2_code.arr,othrac_main_acc2_code.arr);
    xxxxxx_main_acc2_code.len = strlen(xxxxxx_main_acc2_code.arr);
    strcpy(xxxxxx_dept_code.arr,othrac_dept_code.arr);
    xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);
    strcpy(xxxxxx_subledger_group_code.arr,othrac_subledger_group_code.arr);
    xxxxxx_subledger_group_code.len = strlen(xxxxxx_subledger_group_code.arr);
    strcpy(xxxxxx_subledger_line_code.arr,othrac_subledger_line_code.arr);
    xxxxxx_subledger_line_code.len = strlen(xxxxxx_subledger_line_code.arr);
    strcpy(xxxxxx_product_group_code.arr,othrac_product_group_code.arr);
    xxxxxx_product_group_code.len = strlen(xxxxxx_product_group_code.arr);
    strcpy(xxxxxx_product_line_code.arr,othrac_product_line_code.arr);
    xxxxxx_product_line_code.len = strlen(xxxxxx_product_line_code.arr);

    strcpy(xxxxxx_doc_amt.arr,recref_doc_amt_negative.arr);
    xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);

/*
    if (recref_recpt_refund_ind.arr[0]=='R')
    {
       strcpy(xxxxxx_doc_amt.arr,recref_doc_amt_negative.arr);
       xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);
    }
    else
    {
       strcpy(xxxxxx_doc_amt.arr,recref_doc_amt.arr);
       xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);
    }
*/

   }
}

process_dpf()
{

//disp_message(ERR_MESG,nd_operating_facility_id.arr);
//disp_message(ERR_MESG,nd_date.arr);
//disp_message(ERR_MESG,nd_bill_doc_type_code.arr);
//disp_message(ERR_MESG,nd_bill_doc_num.arr);

    /* EXEC SQL DECLARE T_BILL_HDR_CUR CURSOR FOR
	     SELECT  EPISODE_TYPE,
		 PATIENT_ID,
		 NVL(EPISODE_ID,0),
		 NVL(VISIT_ID,1),
		 BILL_TRX_TYPE_CODE,
		 BILL_NATURE_CODE,
		 BILL_TOT_AMT,
		 BILL_TOT_OUTST_AMT,
		 BILL_PRV_OUTST_AMT,
		 ADDED_BY_ID,
		 MODIFIED_BY_ID,
		 ADDED_DATE,
		 MODIFIED_DATE,
		 DOC_TYPE_CODE,
		 DOC_NUM,
		 TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                 NVL(MAN_DISC_AMT,0),
                 NVL(OVERALL_DISC_AMT,0),
                 OVR_DISC_ACC_INT_CODE,
                 BILL_TYPE_CODE,
                 NVL(OVERALL_DISC_AMT,0),
                 NVL(OVERALL_DISC_AMT,0) * -1,  
			     NVL(BILL_DRFEE_AMT,0),
                 NVL(BILL_DRFEE_TOT_OUTST_AMT,0),
                 NVL(DRFEE_RECEIPT_AMT,0),
				 NVL(BILL_HOSP_TOT_OUTST_AMT,0),
				 NVL(BILL_ROUNDING_AMT,0) ROUND_AMT,
				 DECODE(SIGN(NVL(BILL_ROUNDING_AMT,0)),1,'+','-') SIGN_IND,
				 NVL(BILL_PRINT_FLAG,'N') PRINT_FLAG,
				 BILL_TYPE_CODE,
				 CASH_CTRL_DOC_TYPE_CODE,
                 CASH_CTRL_DOC_NUMBER   ,
                 CASH_CTRL_DOC_DATE,
				 CASH_COUNTER_CODE,
				 SHIFT_ID
	     FROM    BL_BILL_HDR
	     WHERE   NVL(BILL_POSTED_FLAG,'X') != 'Y'
	    /o //AND   NVL(BILL_PRINT_FLAG,'X')   = 'Y'
		 //Comment removed the above statement.  Cancelled bills are processed seperately.
		 //A. Harish 08/01/2004.o/
          AND     NVL(BILL_STATUS,'X') != 'C'
	      AND     OPERATING_FACILITY_ID = :nd_operating_facility_id
		  /o
		  AND     ((BILL_STATUS IS NULL) OR
				(BILL_STATUS = 'D') OR
				(BILL_TRX_TYPE_CODE = 'I' AND BILL_STATUS = 'S'))
		  o/
          AND    TRUNC(DOC_DATE) <= TO_DATE(:nd_date, 'DD/MM/YYYY')
		  AND    (:nd_bill_doc_type_code is null or (:nd_bill_doc_type_code is not null and 
		          DOC_TYPE_CODE =  :nd_bill_doc_type_code AND 
				  DOC_NUM = :nd_bill_doc_num))
	      FOR    UPDATE OF BILL_POSTED_FLAG; */ 


    /* EXEC SQL OPEN T_BILL_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select EPISODE_TYPE ,PATIENT_ID ,NVL(EPISODE_ID,0) ,NVL(VISIT_ID,1) ,\
BILL_TRX_TYPE_CODE ,BILL_NATURE_CODE ,BILL_TOT_AMT ,BILL_TOT_OUTST_AMT ,BILL\
_PRV_OUTST_AMT ,ADDED_BY_ID ,MODIFIED_BY_ID ,ADDED_DATE ,MODIFIED_DATE ,DOC_\
TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,NVL(MAN_DISC_AMT,0) ,NVL\
(OVERALL_DISC_AMT,0) ,OVR_DISC_ACC_INT_CODE ,BILL_TYPE_CODE ,NVL(OVERALL_DIS\
C_AMT,0) ,(NVL(OVERALL_DISC_AMT,0)* (-1)) ,NVL(BILL_DRFEE_AMT,0) ,NVL(BILL_D\
RFEE_TOT_OUTST_AMT,0) ,NVL(DRFEE_RECEIPT_AMT,0) ,NVL(BILL_HOSP_TOT_OUTST_AMT\
,0) ,NVL(BILL_ROUNDING_AMT,0) ROUND_AMT ,DECODE(SIGN(NVL(BILL_ROUNDING_AMT,0\
)),1,'+','-') SIGN_IND ,NVL(BILL_PRINT_FLAG,'N') PRINT_FLAG ,BILL_TYPE_CODE \
,CASH_CTRL_DOC_TYPE_CODE ,CASH_CTRL_DOC_NUMBER ,CASH_CTRL_DOC_DATE ,CASH_COU\
NTER_CODE ,SHIFT_ID  from BL_BILL_HDR where ((((NVL(BILL_POSTED_FLAG,'X')<>'\
Y' and NVL(BILL_STATUS,'X')<>'C') and OPERATING_FACILITY_ID=:b0) and TRUNC(D\
OC_DATE)<=TO_DATE(:b1,'DD/MM/YYYY')) and (:b2 is null  or ((:b2 is  not null\
  and DOC_TYPE_CODE=:b2) and DOC_NUM=:b5)))");
    sqlstm.stmt = sq0057;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2300;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_date;
    sqlstm.sqhstl[1] = (unsigned int  )15;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_bill_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_bill_doc_type_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_bill_doc_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_bill_doc_num;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
			err_mesg("FETCH failed on cursor T_BILL_HDR_CUR",0,"");

    while(fetch_bill_hdr()) 
	{
       //disp_message(ERR_MESG,"In while(fetch_bill_hdr())");
	    
		if(g_error) 
			do_rollback();

		/* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 37;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "savepoint LAST_DOC_REF";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2339;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		
		/*
		ins_pat_ledger_bill();
		ins_pat_ledger_trn_bill();
		*/
        if (t_bill_trx_type_code.arr[0] == 'I')
            ins_pat_inhouse_bill();

		/*	
		if(t_bill_drfee_tot_amt > 0)
			upd_phys_ledger();
		*/

		/*	
		if(t_org_rec_amt > 0)	
			process_dpf_rec_BI();
		*/

//disp_message(ERR_MESG,"Before update of reasons...");

	upd_reasons_in_receipt_refund_for_unposting(4); 		
	
		if (nd_reason_text.arr[0] != '\0')
			continue;

//disp_message(ERR_MESG,"After reason text is null...");

		post_discounts(0);
		if (g_error) continue; // Added new

//disp_message(ERR_MESG,"After postaccounts...");        

        if (t_round_amt != 0)
           post_rounding_amt(0);
	    if (g_error) continue;

//disp_message(ERR_MESG,"After post rounding amt...");        

		/* EXEC SQL UPDATE BL_BILL_HDR
				SET BILL_POSTED_FLAG		= 'Y',
				UNPOSTED_REASON			= NULL,
				MODIFIED_BY_ID			= user,
				MODIFIED_DATE			= SYSDATE,		    
				MODIFIED_AT_WS_NO		= :nd_ws_no,
				MODIFIED_FACILITY_ID	= :nd_operating_facility_id
				WHERE  
				CURRENT OF T_BILL_HDR_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 37;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_BILL_HDR  set BILL_POSTED_FLAG='Y',UNPOSTED_REASO\
N=null ,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b0,MODIFI\
ED_FACILITY_ID=:b1 where rowid = :x";
  sqlstm.iters = (unsigned int  )57;
  sqlstm.offset = (unsigned int  )2354;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )33;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )5;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if(OERROR)
			err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");

        post_dr_share();
 
  //disp_message(ERR_MESG,"end of while fetch bill_hdr");

    } /* end of while fetch bill_hdr */

    /* EXEC SQL CLOSE T_BILL_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2377;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE T_PATIENT_FOLIO_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2392;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    return 1;
}

fetch_bill_hdr()
{
    t_round_amt = 0;
    t_sign_ind.arr[0] = '\0';
    t_doc_type_code.arr[0]  = '\0';
    t_doc_num.arr[0]  = '\0';
    t_doc_date.arr[0]  = '\0';
    t_overall_int_code.arr[0] = '\0';
    t_bill_type_code.arr[0]   = '\0';
    t_tot_disc_char.arr[0]   = '\0';
    t_tot_disc_nega.arr[0]   = '\0';

    t_episode_type.arr[0]  = '\0';
    t_patient_id.arr[0]  = '\0';
    t_episode_id.arr[0]  = '\0';
    t_visit_id.arr[0]  = '\0';  
    t_bill_trx_type_code.arr[0]  = '\0';
    t_bill_nature_code.arr[0]  = '\0';
    t_bill_tot_amt.arr[0]  = '\0';
    t_bill_tot_outst_amt.arr[0]  = '\0';
    t_prv_bill_tot_outst_amt.arr[0]  = '\0';
    t_added_by_id.arr[0]  = '\0';
    t_modified_by_id.arr[0]  = '\0';
    t_added_date.arr[0]  = '\0';
    t_modified_date.arr[0]  = '\0';
    t_bill_print_flag.arr[0] = '\0';
    t_bill_type_code.arr[0]  = '\0';
    nd_doc_type.arr[0]  = '\0';
    nd_doc_num.arr[0]  = '\0';
    nd_doc_date.arr[0]  = '\0';

    t_doc_type_code.len     = 0;
    t_doc_num.len     = 0;
    t_doc_date.len     = 0;
    t_overall_int_code.len  = 0;
    t_bill_type_code.len    = 0;
    t_tot_disc_char.len     = 0;
    t_tot_disc_nega.len     = 0;

    t_episode_type.len     = 0;
    t_patient_id.len     = 0;
    t_episode_id.len     = 0;
    t_visit_id.len     = 0;
    t_bill_trx_type_code.len     = 0;
    t_bill_nature_code.len     = 0;
    t_bill_tot_amt.len     = 0;
    t_bill_tot_outst_amt.len     = 0;
    t_prv_bill_tot_outst_amt.len     = 0;
    t_added_by_id.len     = 0;
    t_modified_by_id.len     = 0;
    t_added_date.len     = 0;
    t_modified_date.len     = 0;

    t_bill_drfee_tot_amt = 0;
    t_man_disc_amt       = 0;
    t_overall_disc_amt   = 0;

    t_bill_drfee_tot_outst_amt  = 0;
    t_org_rec_amt               = 0;
    t_bill_hosp_tot_outst_amt   = 0;
    t_bill_print_flag.len = 0;
    t_bill_type_code.len  = 0;
    nd_doc_type.len=0;
    nd_doc_num.len=0;
    nd_doc_date.len=0;
   
    recref_cash_counter_code.arr[0]='\0';
    recref_shift_id.arr[0]='\0';

    /* EXEC SQL FETCH T_BILL_HDR_CUR
	  INTO :t_episode_type,
                   :t_patient_id,
                   :t_episode_id,
                   :t_visit_id,
                   :t_bill_trx_type_code,
                   :t_bill_nature_code,
                   :t_bill_tot_amt,
                   :t_bill_tot_outst_amt,
                   :t_prv_bill_tot_outst_amt,
                   :t_added_by_id,
                   :t_modified_by_id,
                   :t_added_date,
                   :t_modified_date,
		   :t_doc_type_code,
		   :t_doc_num,
		   :t_doc_date,
                   :t_man_disc_amt,
                   :t_overall_disc_amt,
                   :t_overall_int_code,
                   :t_bill_type_code,
                   :t_tot_disc_char,
                   :t_tot_disc_nega,
		   :t_bill_drfee_tot_amt,
	           :t_bill_drfee_tot_outst_amt,
                   :t_org_rec_amt,
		   :t_bill_hosp_tot_outst_amt,
		   :t_round_amt,
		   :t_sign_ind,
		   :t_bill_print_flag,
		   :t_bill_type_code,
                   :nd_doc_type,
                   :nd_doc_num,
                   :nd_doc_date,
		   :recref_cash_counter_code,
		   :recref_shift_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2407;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_episode_id;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_visit_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_bill_trx_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_bill_nature_code;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_bill_tot_amt;
    sqlstm.sqhstl[6] = (unsigned int  )25;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_bill_tot_outst_amt;
    sqlstm.sqhstl[7] = (unsigned int  )25;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&t_prv_bill_tot_outst_amt;
    sqlstm.sqhstl[8] = (unsigned int  )25;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&t_added_by_id;
    sqlstm.sqhstl[9] = (unsigned int  )33;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&t_modified_by_id;
    sqlstm.sqhstl[10] = (unsigned int  )33;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&t_added_date;
    sqlstm.sqhstl[11] = (unsigned int  )33;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&t_modified_date;
    sqlstm.sqhstl[12] = (unsigned int  )33;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[13] = (unsigned int  )9;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[14] = (unsigned int  )11;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&t_doc_date;
    sqlstm.sqhstl[15] = (unsigned int  )15;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&t_man_disc_amt;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&t_overall_disc_amt;
    sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&t_overall_int_code;
    sqlstm.sqhstl[18] = (unsigned int  )9;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&t_bill_type_code;
    sqlstm.sqhstl[19] = (unsigned int  )5;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&t_tot_disc_char;
    sqlstm.sqhstl[20] = (unsigned int  )23;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&t_tot_disc_nega;
    sqlstm.sqhstl[21] = (unsigned int  )23;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&t_bill_drfee_tot_amt;
    sqlstm.sqhstl[22] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&t_bill_drfee_tot_outst_amt;
    sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&t_org_rec_amt;
    sqlstm.sqhstl[24] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&t_bill_hosp_tot_outst_amt;
    sqlstm.sqhstl[25] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&t_round_amt;
    sqlstm.sqhstl[26] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&t_sign_ind;
    sqlstm.sqhstl[27] = (unsigned int  )4;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&t_bill_print_flag;
    sqlstm.sqhstl[28] = (unsigned int  )4;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&t_bill_type_code;
    sqlstm.sqhstl[29] = (unsigned int  )5;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&nd_doc_type;
    sqlstm.sqhstl[30] = (unsigned int  )9;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&nd_doc_num;
    sqlstm.sqhstl[31] = (unsigned int  )37;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&nd_doc_date;
    sqlstm.sqhstl[32] = (unsigned int  )32;
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&recref_cash_counter_code;
    sqlstm.sqhstl[33] = (unsigned int  )9;
    sqlstm.sqhsts[33] = (         int  )0;
    sqlstm.sqindv[33] = (         void  *)0;
    sqlstm.sqinds[33] = (         int  )0;
    sqlstm.sqharm[33] = (unsigned int  )0;
    sqlstm.sqadto[33] = (unsigned short )0;
    sqlstm.sqtdso[33] = (unsigned short )0;
    sqlstm.sqhstv[34] = (         void  *)&recref_shift_id;
    sqlstm.sqhstl[34] = (unsigned int  )4;
    sqlstm.sqhsts[34] = (         int  )0;
    sqlstm.sqindv[34] = (         void  *)0;
    sqlstm.sqinds[34] = (         int  )0;
    sqlstm.sqharm[34] = (unsigned int  )0;
    sqlstm.sqadto[34] = (unsigned short )0;
    sqlstm.sqtdso[34] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




    if(OERROR)
		err_mesg("FETCH failed on table T_BILL_HDR_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;
    t_sign_ind.arr[t_sign_ind.len] = '\0' ;    
    t_doc_type_code.arr[t_doc_type_code.len]  = '\0';
    t_doc_num.arr[t_doc_num.len]  = '\0';
    t_doc_date.arr[t_doc_date.len]  = '\0';
    t_overall_int_code.arr[t_overall_int_code.len] = '\0';
    t_bill_type_code.arr[t_bill_type_code.len] = '\0';
    t_tot_disc_char.arr[t_tot_disc_char.len] = '\0';
    t_tot_disc_nega.arr[t_tot_disc_nega.len] = '\0';
    t_episode_type.arr[t_episode_type.len]  = '\0';
    t_patient_id.arr[t_patient_id.len]  = '\0';
    t_episode_id.arr[t_episode_id.len]  = '\0';
    t_visit_id.arr[t_visit_id.len]  = '\0';
    t_bill_trx_type_code.arr[t_bill_trx_type_code.len]  = '\0';
    t_bill_nature_code.arr[t_bill_nature_code.len]  = '\0';
    t_bill_tot_amt.arr[t_bill_tot_amt.len]  = '\0';
    t_bill_tot_outst_amt.arr[t_bill_tot_outst_amt.len]  = '\0';
    t_prv_bill_tot_outst_amt.arr[t_prv_bill_tot_outst_amt.len]  = '\0';
    t_added_by_id.arr[t_added_by_id.len]  = '\0';
    t_modified_by_id.arr[t_modified_by_id.len]  = '\0';
    t_added_date.arr[t_added_date.len]  = '\0';
    t_modified_date.arr[t_modified_date.len]  = '\0';
    t_bill_print_flag.arr[t_bill_print_flag.len]  = '\0';
    t_bill_type_code.arr[t_bill_type_code.len] = '\0';
    nd_doc_type.arr[nd_doc_type.len]= '\0';
    nd_doc_num.arr[nd_doc_num.len]='\0';
    nd_doc_date.arr[nd_doc_date.len]='\0';

	recref_cash_counter_code.arr[recref_cash_counter_code.len]='\0';
	recref_shift_id.arr[recref_shift_id.len]='\0';
    
	return 1;
}

open_bill_line()
{
    /* EXEC SQL OPEN BL_BILL_LINE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0031;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2562;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	err_mesg("OPEN failed on CURSOR BL_BILL_LINE_CUR",0,"");
}

fetch_bill_line()
{
    t_man_disc_char.arr[0]  = '\0';
    t_man_disc_nega.arr[0]  = '\0';
    t_man_int_code.arr[0]   = '\0';

    t_man_disc_char.len     = 0;
    t_man_disc_nega.len     = 0;
    t_man_int_code.len      = 0;

    /* EXEC SQL FETCH BL_BILL_LINE_CUR 
	     INTO      :t_man_disc_char,
                   :t_man_disc_nega,
                   :t_man_int_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2589;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_man_disc_char;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_man_disc_nega;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_man_int_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	err_mesg("FETCH failed on cursor BL_BILL_LINE_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    t_man_disc_char.arr[t_man_disc_char.len]  = '\0';
    t_man_disc_nega.arr[t_man_disc_nega.len]  = '\0';
    t_man_int_code.arr[t_man_int_code.len]    = '\0';

    return 1;
}

fetch_folio()
{

    t_dpf_doc_type_code.arr[0]  = '\0';
    t_dpf_doc_number.arr[0]  = '\0';
    t_physician_id.arr[0]  = '\0';

    t_dpf_doc_type_code.len     = 0;
    t_dpf_doc_number.len     = 0;
    t_physician_id.len     = 0;

    /* EXEC SQL FETCH T_PATIENT_FOLIO_CUR 
	     INTO :t_dpf_doc_type_code,
		   :t_dpf_doc_number,
		   :t_physician_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2616;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_dpf_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_dpf_doc_number;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_physician_id;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	err_mesg("FETCH failed on cursor T_PATIENT_FOLIO_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    t_dpf_doc_type_code.arr[t_dpf_doc_type_code.len]  = '\0';
    t_dpf_doc_number.arr[t_dpf_doc_number.len]  = '\0';
    t_physician_id.arr[t_physician_id.len]  = '\0';

    return 1;
}

process_dpf_rec()
{

    t_bill_drfee_tot_outst_amt = 0;
    t_bill_hosp_tot_outst_amt = 0;
    t_org_rec_amt             = 0;

    t_bill_status = '\0';

    /* EXEC SQL SELECT NVL(BILL_DRFEE_TOT_OUTST_AMT,0),
                    NVL(DRFEE_RECEIPT_AMT,0),
		    NVL(BILL_HOSP_TOT_OUTST_AMT,0),
		    BILL_STATUS,
		    Nvl(BILL_ROUNDING_AMT,0)
	     INTO   :t_bill_drfee_tot_outst_amt,
                    :t_org_rec_amt,
		    :t_bill_hosp_tot_outst_amt,
		    :t_bill_status,
                    :t_round_amt  
	     FROM BL_BILL_HDR
	     WHERE DOC_TYPE_CODE = :recref_bill_doc_type_code
	     AND DOC_NUM = :recref_bill_doc_number
	     AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(BILL_DRFEE_TOT_OUTST_AMT,0) ,NVL(DRFEE_RECEIPT\
_AMT,0) ,NVL(BILL_HOSP_TOT_OUTST_AMT,0) ,BILL_STATUS ,Nvl(BILL_ROUNDING_AMT,0)\
 into :b0,:b1,:b2,:b3,:b4  from BL_BILL_HDR where ((DOC_TYPE_CODE=:b5 and DOC_\
NUM=:b6) and OPERATING_FACILITY_ID=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2643;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_bill_drfee_tot_outst_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_org_rec_amt;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_bill_hosp_tot_outst_amt;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_bill_status;
    sqlstm.sqhstl[3] = (unsigned int  )1;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_round_amt;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&recref_bill_doc_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&recref_bill_doc_number;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[7] = (unsigned int  )5;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR||NO_DATA_FOUND) {
	log_mesg("SELECT failed on table BL_BILL_HDR",0,"");
	return 0;
    }

    if(t_bill_status == 'D') 
	process_dpf_rec_DC();
    else {

        t_recpt_amt = atof(recref_doc_amt.arr);

        if( (t_recpt_amt > t_bill_hosp_tot_outst_amt) && 
        (t_bill_drfee_tot_outst_amt > 0) ) {

	t_drfee_amt = t_recpt_amt - t_bill_hosp_tot_outst_amt;
        t_drfee_amt = t_drfee_amt + t_org_rec_amt;

    /***************** New Code for Doctor's Fee Interface ** G Sriram *******/
    
    /***** Allocation of DF receipt amt will be done if DF system  *****/
    
/*	    EXEC SQL SELECT NVL(NEXT_REF_NUM,1) 
		     INTO   :t_ref_num
		     FROM   DF_PARAMETER;
    
	    if(OERROR) {
	        log_mesg("SELECT failed on table DF_PARAMETER",0,"");
	        return 0;
	    }*/
    
            t_df_pay_alcn_num = 0;
    
    /************ End of New Code for Doctor's Fee Interface * G Sriram *****/
    
	    d_pmnt_mode = '\0';
	    d_pmnt_status = '\0';
    
            /* EXEC SQL SELECT DECODE(CASH_SLMT_FLAG,'Y','1','A','3','B','2',
			          'C','1','D','1',' ')
		     INTO   :d_pmnt_mode
		     FROM   BL_SLMT_TYPE
		     WHERE  SLMT_TYPE_CODE = :recref_slmt_type_code; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 37;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "select DECODE(CASH_SLMT_FLAG,'Y','1','A','3','B',\
'2','C','1','D','1',' ') into :b0  from BL_SLMT_TYPE where SLMT_TYPE_CODE=:b1";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )2690;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_pmnt_mode;
            sqlstm.sqhstl[0] = (unsigned int  )1;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&recref_slmt_type_code;
            sqlstm.sqhstl[1] = (unsigned int  )5;
            sqlstm.sqhsts[1] = (         int  )0;
            sqlstm.sqindv[1] = (         void  *)0;
            sqlstm.sqinds[1] = (         int  )0;
            sqlstm.sqharm[1] = (unsigned int  )0;
            sqlstm.sqadto[1] = (unsigned short )0;
            sqlstm.sqtdso[1] = (unsigned short )0;
            sqlstm.sqphsv = sqlstm.sqhstv;
            sqlstm.sqphsl = sqlstm.sqhstl;
            sqlstm.sqphss = sqlstm.sqhsts;
            sqlstm.sqpind = sqlstm.sqindv;
            sqlstm.sqpins = sqlstm.sqinds;
            sqlstm.sqparm = sqlstm.sqharm;
            sqlstm.sqparc = sqlstm.sqharc;
            sqlstm.sqpadto = sqlstm.sqadto;
            sqlstm.sqptdso = sqlstm.sqtdso;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	    if(OERROR) {
	        log_mesg("SELECT failed on table BL_SLMT_TYPE",0,"");
	        return 0;
	    }
    
	    if(d_pmnt_mode == '1') 
	        d_pmnt_status = 'N';
	    else
	        d_pmnt_status = 'H';
    
/*	    EXEC SQL INSERT INTO DF_CUST_PMNT_INTERFACE_HDR
                            (    MODULE_ID,
                                 REF_NUM,
                                 AMOUNT,
                                 PMNT_DATE,
                                 PMNT_MODE,
			         PMNT_STATUS_FLAG,
                                 LAST_PAY_ALCN_LINE_NUM,
                                 RCT_DOC_TYPE_CODE,
                                 RCT_DOC_NUM,
			         EPISODE_TYPE,
			         EPISODE_ID,
			         VISIT_ID,
			         PATIENT_ID
			    )
		    VALUES  (    'BL',
			         :t_ref_num,
			         :t_drfee_amt,
			         TO_DATE(:recref_doc_date,'DD/MM/YYYY'),
			         :d_pmnt_mode,
			         :d_pmnt_status,
			         :t_df_pay_alcn_num,
			         :recref_doc_type_code,
			         :recref_doc_number,
                                 :recref_episode_type,
                                 :recref_episode_id,
                                 :recref_visit_id,
                                 :recref_patient_id
			    );
    
            if(OERROR) {
	        log_mesg("INSERT failed on table DF_CUST_PMNT_INTERFACE_HDR",0,"");
	        return 0;
	    }
    
            EXEC SQL INSERT INTO DF_CUST_PMNT_INTERFACE_LINE
                            (    MODULE_ID,
                                 REF_NUM,
                                 LINE_NUM,
                                 BILL_DOC_TYPE_CODE,
                                 BILL_NUM
			    )
		    VALUES  (    'BL',
			         :t_ref_num,
			         1,
                                 NULL,
                                 NULL
			    );
    
            if(OERROR) {
	        log_mesg("INSERT failed on table DF_CUST_PMNT_INTERFACE_LINE",0,"");
	        return 0;
	    }
*/
	    /* EXEC SQL UPDATE BL_BILL_HDR
		     SET    BILL_HOSP_TOT_OUTST_AMT = 0,
                            DRFEE_RECEIPT_AMT       = 0,
			    BILL_DRFEE_TOT_OUTST_AMT = 
			         NVL(BILL_DRFEE_TOT_OUTST_AMT,0) -
                                            :t_drfee_amt + :t_org_rec_amt,
		    	    MODIFIED_BY_ID         = user,
	            	    MODIFIED_DATE          = SYSDATE,		    	    
	                    MODIFIED_AT_WS_NO      = :nd_ws_no,
		            MODIFIED_FACILITY_ID   = :nd_operating_facility_id
	             WHERE  DOC_TYPE_CODE = :recref_bill_doc_type_code
	             AND    DOC_NUM       = :recref_bill_doc_number
	      	     AND    OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 37;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update BL_BILL_HDR  set BILL_HOSP_TOT_OUTST_AMT=0,DRFEE_\
RECEIPT_AMT=0,BILL_DRFEE_TOT_OUTST_AMT=((NVL(BILL_DRFEE_TOT_OUTST_AMT,0)-:b0)+\
:b1),MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b2,MODIFIED_\
FACILITY_ID=:b3 where ((DOC_TYPE_CODE=:b4 and DOC_NUM=:b5) and OPERATING_FACIL\
ITY_ID=:b3)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2713;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&t_drfee_amt;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&t_org_rec_amt;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
     sqlstm.sqhstl[2] = (unsigned int  )33;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&recref_bill_doc_type_code;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&recref_bill_doc_number;
     sqlstm.sqhstl[5] = (unsigned int  )11;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[6] = (unsigned int  )5;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	    if(OERROR) {
	        log_mesg("UPDATE failed on table BL_BILL_HDR",0,"");
	        return 0;
	    };
    
/*	    EXEC SQL UPDATE DF_PARAMETER
		     SET    NEXT_REF_NUM = NVL(NEXT_REF_NUM,1) +1;
    
	    if(OERROR) {
	        log_mesg("UPDATE failed on table DF_PARAMETER",0,"");
	        return 0;
	    }*/
    
        }
        else {
    
	    /* EXEC SQL UPDATE BL_BILL_HDR
		     SET    BILL_HOSP_TOT_OUTST_AMT = 
			        BILL_HOSP_TOT_OUTST_AMT - :t_recpt_amt,
		    MODIFIED_BY_ID         = user,
	            MODIFIED_DATE          = SYSDATE,
	            MODIFIED_AT_WS_NO      = :nd_ws_no,
		    MODIFIED_FACILITY_ID   = :nd_operating_facility_id
	             WHERE  DOC_TYPE_CODE = :recref_bill_doc_type_code
	             AND    DOC_NUM       = :recref_bill_doc_number
	      	     AND    OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 37;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update BL_BILL_HDR  set BILL_HOSP_TOT_OUTST_AMT=(BILL_HO\
SP_TOT_OUTST_AMT-:b0),MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS\
_NO=:b1,MODIFIED_FACILITY_ID=:b2 where ((DOC_TYPE_CODE=:b3 and DOC_NUM=:b4) an\
d OPERATING_FACILITY_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2756;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&t_recpt_amt;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
     sqlstm.sqhstl[1] = (unsigned int  )33;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&recref_bill_doc_type_code;
     sqlstm.sqhstl[3] = (unsigned int  )9;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&recref_bill_doc_number;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[5] = (unsigned int  )5;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	    if(OERROR) {
	        log_mesg("UPDATE failed on table BL_BILL_HDR",0,"");
	        return 0;
	    }
        }
    }
}

process_dpf_rec_DC()
{

    t_bill_drfee_tot_outst_amt = 0;
    t_bill_hosp_tot_outst_amt = 0;
    t_org_rec_amt             = 0;

    /* EXEC SQL SELECT NVL(DRFEE_CHG_OUTST_AMT,0),
		    NVL(HOSP_CHG_OUTST_AMT,0)
	     INTO   :t_bill_drfee_tot_outst_amt,
		    :t_bill_hosp_tot_outst_amt
	     FROM   BL_DCP_PENDING_DOC
	     WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
	     AND ORG_DOC_TYPE_CODE = :recref_bill_doc_type_code
	     AND    ORG_DOC_NUMBER    = :recref_bill_doc_number; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(DRFEE_CHG_OUTST_AMT,0) ,NVL(HOSP_CHG_OUTST_AMT\
,0) into :b0,:b1  from BL_DCP_PENDING_DOC where ((OPERATING_FACILITY_ID=:b2 an\
d ORG_DOC_TYPE_CODE=:b3) and ORG_DOC_NUMBER=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2795;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_bill_drfee_tot_outst_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_bill_hosp_tot_outst_amt;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&recref_bill_doc_type_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&recref_bill_doc_number;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	

    if(OERROR||NO_DATA_FOUND) {
	log_mesg("SELECT failed on table BL_BILL_HDR",0,"");
	return;
    }

    t_recpt_amt = atof(recref_doc_amt.arr);

    if( (t_recpt_amt > t_bill_hosp_tot_outst_amt) && 
        (t_bill_drfee_tot_outst_amt > 0) ) {

	t_drfee_amt = t_recpt_amt - t_bill_hosp_tot_outst_amt;
        t_drfee_amt = t_drfee_amt + t_org_rec_amt;

/***************** New Code for Doctor's Fee Interface ** G Sriram *******/

/*	EXEC SQL SELECT NVL(NEXT_REF_NUM,1) 
		 INTO   :t_ref_num
		 FROM   DF_PARAMETER;

	if(OERROR) {
	    log_mesg("SELECT failed on table DF_PARAMETER",0,"");
	    return;
	}
*/
        t_df_pay_alcn_num = 0;

/****************** End of New Code for Doctor's Fee Interface * G Sriram *****/

	d_pmnt_mode = '\0';
	d_pmnt_status = '\0';

        /* EXEC SQL SELECT DECODE(CASH_SLMT_FLAG,'Y','1','A','3','B','2',
			      'C','1','D','1',' ')
		 INTO   :d_pmnt_mode
		 FROM   BL_SLMT_TYPE
		 WHERE  SLMT_TYPE_CODE = :recref_slmt_type_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select DECODE(CASH_SLMT_FLAG,'Y','1','A','3','B','2',\
'C','1','D','1',' ') into :b0  from BL_SLMT_TYPE where SLMT_TYPE_CODE=:b1";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2830;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_pmnt_mode;
        sqlstm.sqhstl[0] = (unsigned int  )1;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&recref_slmt_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )5;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR) {
	    log_mesg("SELECT failed on table BL_SLMT_TYPE",0,"");
	    return;
	}

	if(d_pmnt_mode == '1') 
	    d_pmnt_status = 'N';
	else
	    d_pmnt_status = 'H';

/*	EXEC SQL INSERT INTO DF_CUST_PMNT_INTERFACE_HDR
                        (    MODULE_ID,
                             REF_NUM,
                             AMOUNT,
                             PMNT_DATE,
                             PMNT_MODE,
			     PMNT_STATUS_FLAG,
                             LAST_PAY_ALCN_LINE_NUM,
                             RCT_DOC_TYPE_CODE,
                             RCT_DOC_NUM,
			     EPISODE_TYPE,
			     EPISODE_ID,
			     VISIT_ID,
			     PATIENT_ID
			)
		VALUES  (    'BL',
			     :t_ref_num,
			     :t_drfee_amt,
			     TO_DATE(:recref_doc_date,'DD/MM/YYYY'),
			     :d_pmnt_mode,
			     :d_pmnt_status,
			     :t_df_pay_alcn_num,
			     :recref_doc_type_code,
			     :recref_doc_number,
                             :recref_episode_type,
                             :recref_episode_id,
                             :recref_visit_id,
                             :recref_patient_id
			);

        if(OERROR) {
	    log_mesg("INSERT failed on table DF_CUST_PMNT_INTERFACE_HDR",0,"");
	    return;
	}

        EXEC SQL INSERT INTO DF_CUST_PMNT_INTERFACE_LINE
                        (    MODULE_ID,
                             REF_NUM,
                             LINE_NUM,
                             BILL_DOC_TYPE_CODE,
                             BILL_NUM
			)
		VALUES  (    'BL',
			     :t_ref_num,
			     1,
                             NULL,
                             NULL
			);

        if(OERROR) {
	    log_mesg("INSERT failed on table DF_CUST_PMNT_INTERFACE_LINE",0,"");
	    return;
	}
*/
	/* EXEC SQL UPDATE BL_DCP_PENDING_DOC
		 SET    HOSP_CHG_OUTST_AMT = 0,
			DRFEE_CHG_OUTST_AMT = 
			     NVL(DRFEE_CHG_OUTST_AMT,0) - :t_drfee_amt,
		    MODIFIED_BY_ID         = user,
	            MODIFIED_DATE          = SYSDATE,
	            MODIFIED_AT_WS_NO      = :nd_ws_no,
		    MODIFIED_FACILITY_ID   = :nd_operating_facility_id
	         WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND ORG_DOC_TYPE_CODE = :recref_bill_doc_type_code
	         AND ORG_DOC_NUMBER    = :recref_bill_doc_number; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 37;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_DCP_PENDING_DOC  set HOSP_CHG_OUTST_AMT=0,DRFEE_CH\
G_OUTST_AMT=(NVL(DRFEE_CHG_OUTST_AMT,0)-:b0),MODIFIED_BY_ID=user,MODIFIED_DATE\
=SYSDATE,MODIFIED_AT_WS_NO=:b1,MODIFIED_FACILITY_ID=:b2 where ((OPERATING_FACI\
LITY_ID=:b2 and ORG_DOC_TYPE_CODE=:b4) and ORG_DOC_NUMBER=:b5)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2853;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&t_drfee_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&recref_bill_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&recref_bill_doc_number;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




	if(OERROR) {
	    log_mesg("UPDATE failed on table BL_DCP_PENDING_DOC",0,"");
	    return;
	}

/*	EXEC SQL UPDATE DF_PARAMETER
		 SET    NEXT_REF_NUM = NVL(NEXT_REF_NUM,1) +1;

	if(OERROR) {
	    log_mesg("UPDATE failed on table DF_PARAMETER",0,"");
	    return;
	}
*/
    }
    else {

	/* EXEC SQL UPDATE BL_DCP_PENDING_DOC
		 SET    HOSP_CHG_OUTST_AMT = 
 		        HOSP_CHG_OUTST_AMT - :t_recpt_amt,
		    MODIFIED_BY_ID         = user,
	            MODIFIED_DATE          = SYSDATE,
	            MODIFIED_AT_WS_NO      = :nd_ws_no,
		    MODIFIED_FACILITY_ID   = :nd_operating_facility_id
	         WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 and ORG_DOC_TYPE_CODE = :recref_bill_doc_type_code
	         AND ORG_DOC_NUMBER    = :recref_bill_doc_number; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 37;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_DCP_PENDING_DOC  set HOSP_CHG_OUTST_AMT=(HOSP_CHG_\
OUTST_AMT-:b0),MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1\
,MODIFIED_FACILITY_ID=:b2 where ((OPERATING_FACILITY_ID=:b2 and ORG_DOC_TYPE_C\
ODE=:b4) and ORG_DOC_NUMBER=:b5)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2892;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&t_recpt_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&recref_bill_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&recref_bill_doc_number;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR) {
	    log_mesg("UPDATE failed on table BL_DCP_PENDING_DOC",0,"");
	    return;
	}
    }

}

process_dpf_rec_BI()
{

/*    t_drfee_amt = t_org_rec_amt;

    EXEC SQL OPEN BL_DF_INTERFACE_CUR;

    if(OERROR)
	err_mesg("OPEN failed on cursor BL_DF_INTERFACE_CUR",0,"");

    while(fetch_bl_df_int()) {

	EXEC SQL SELECT NVL(NEXT_REF_NUM,1) 
		 INTO   :t_ref_num
		 FROM   DF_PARAMETER;

	if(OERROR) {
	    log_mesg("SELECT failed on table DF_PARAMETER",0,"");
	    return;
	}

        t_df_pay_alcn_num = 0;

	d_pmnt_mode = '\0';
	d_pmnt_status = '\0';

        EXEC SQL SELECT DECODE(CASH_SLMT_FLAG,'Y','1','A','3','B','2',
			      'C','1','D','1',' ')
		 INTO   :d_pmnt_mode
		 FROM   BL_SLMT_TYPE
		 WHERE  SLMT_TYPE_CODE = :df_slmt_type_code;

	if(OERROR) {
	    err_mesg("SELECT failed on table BL_SLMT_TYPE",0,"");
	}

	if(d_pmnt_mode == '1') 
	    d_pmnt_status = 'N';
	else
	    d_pmnt_status = 'H';

	EXEC SQL INSERT INTO DF_CUST_PMNT_INTERFACE_HDR
                        (    MODULE_ID,
                             REF_NUM,
                             AMOUNT,
                             PMNT_DATE,
                             PMNT_MODE,
			     PMNT_STATUS_FLAG,
                             LAST_PAY_ALCN_LINE_NUM,
                             RCT_DOC_TYPE_CODE,
                             RCT_DOC_NUM,
			     EPISODE_TYPE,
			     EPISODE_ID,
			     VISIT_ID,
			     PATIENT_ID
			)
		VALUES  (    'BL',
			     :t_ref_num,
			     :df_interface_amt,
			     TO_DATE(:df_rct_doc_date,'DD/MM/YYYY'),
			     :d_pmnt_mode,
			     :d_pmnt_status,
			     :t_df_pay_alcn_num,
			     :df_rct_doc_type_code,
			     :df_rct_doc_num,
                             :t_episode_type,
                             :t_episode_id,
                             :t_visit_id,
                             :t_patient_id
			);

        if(OERROR) {
	    log_mesg("INSERT failed on table DF_CUST_PMNT_INTERFACE_HDR",0,"");
	    return;
	}

        EXEC SQL INSERT INTO DF_CUST_PMNT_INTERFACE_LINE
                        (    MODULE_ID,
                             REF_NUM,
                             LINE_NUM,
                             BILL_DOC_TYPE_CODE,
                             BILL_NUM
			)
		VALUES  (    'BL',
			     :t_ref_num,
			     1,
                             NULL,
                             NULL
			);

        if(OERROR) {
	    log_mesg("INSERT failed on table DF_CUST_PMNT_INTERFACE_LINE",0,"");
	    return;
	}

	EXEC SQL UPDATE BL_BILL_HDR
		 SET    DRFEE_RECEIPT_AMT       = 0,
		        MODIFIED_BY_ID          = USER,      
			MODIFIED_DATE           = SYSDATE,       
			MODIFIED_AT_WS_NO       = :nd_ws_no,       
			MODIFIED_FACILITY_ID    = :nd_operating_facility_id_id      
	         WHERE  DOC_TYPE_CODE = :t_doc_type_code
	         AND    DOC_NUM       = :t_doc_num
		 AND    OPERATING_FACILITY_ID = :nd_operating_facility_id_id;

	if(OERROR) {
	    log_mesg("UPDATE failed on table BL_BILL_HDR",0,"");
	    return;
	}

	EXEC SQL UPDATE DF_PARAMETER
		 SET    NEXT_REF_NUM = NVL(NEXT_REF_NUM,1) +1;

	if(OERROR) {
	    log_mesg("UPDATE failed on table DF_PARAMETER",0,"");
	    return;
	}
    } 
*/
}

fetch_bl_df_int()
{

    df_rct_doc_type_code.arr[0] = '\0';
    df_rct_doc_num.arr[0]		= '\0';
    df_rct_doc_date.arr[0]		= '\0';
    df_slmt_type_code.arr[0]	= '\0';

    df_rct_doc_type_code.len    = 0;
    df_rct_doc_num.len			= 0;
    df_rct_doc_date.len			= 0;
    df_slmt_type_code.len		= 0;

    df_interface_amt = 0;

/*    EXEC SQL FETCH BL_DF_INTERFACE_CUR 
	      INTO :df_rct_doc_type_code,
                   :df_rct_doc_num,
                   :df_rct_doc_date,
                   :df_slmt_type_code,
		   :df_interface_amt;

    if(OERROR)
	err_mesg("FETCH failed on BL_DF_INTERFACE_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;
*/
    return 1;
}


void   declare_df_phys_ldgr_cur()
{
 /*    EXEC SQL DECLARE DF_PHYS_LDGR_CUR CURSOR FOR
         SELECT PHYSICIAN_ID,
                DOC_TYPE_CODE,
                DOC_NUM,
                TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                (NVL(PENDING_AMT,0)-NVL(SCHD_PAY_AMT,0)),
                CUST_OUTSTANDING_AMT  FROM DF_PHYSICIAN_LDGR
            WHERE
              PATIENT_ID = :recref_patient_id AND
              EPISODE_TYPE = :recref_episode_type AND
              NVL(EPISODE_ID,0)   = NVL(:recref_episode_id,0)   AND
              (VISIT_ID  BETWEEN :visit_id_fm AND :visit_id_to) AND
              (NVL(PENDING_AMT,0)-NVL(SCHD_PAY_AMT,0)) > 0
            ORDER BY TO_CHAR(SERVICE_DATE,'DDMMYYYYHH24MI')
            FOR UPDATE OF PHYSICIAN_ID;*/
	return;
}


void open_df_phys_ldgr_cur()
{

/*   EXEC SQL OPEN DF_PHYS_LDGR_CUR;
   if (OERROR)
         err_mesg("OPEN failed on cursor DF_PHYS_LDGR_CUR",0,"");
*/
return;
}


int fetch_df_phys_ldgr()
{

   df_physician_id.arr[0]       = '\0';
   df_doc_type_code.arr[0]      = '\0';
   df_doc_num.arr[0]            = '\0';
   df_doc_date.arr[0]           = '\0';
   df_pend_amt                  = 0;
   cust_outst_amt               = 0;

   df_physician_id.len          = 0;
   df_doc_type_code.len         = 0;
   df_doc_num.len               = 0;
   df_doc_date.len              = 0;

/*   EXEC SQL FETCH DF_PHYS_LDGR_CUR INTO
                  :df_physician_id,
                  :df_doc_type_code,
                  :df_doc_num,
                  :df_doc_date,
                  :df_pend_amt,
                  :cust_outst_amt;*/

   if (OERROR)
      err_mesg("FETCH failed on DF_PHYS_LDGR_CUR",0,"");

   if (LAST_ROW) return (0);

   df_physician_id.arr[df_physician_id.len]		= '\0';
   df_doc_type_code.arr[df_doc_type_code.len]	= '\0';
   df_doc_num.arr[df_doc_num.len]				= '\0';
   df_doc_date.arr[df_doc_date.len]				= '\0';

   if (rec_remaining_amt == 0)
     return (0);

   return 1;
}

int insrt_df_pay_alcn()
{
/*	EXEC SQL INSERT INTO DF_PAY_ALCN
                        (    MODULE_ID,
                             REF_NUM,
                             LINE_NUM,
                             DOC_TYPE_CODE,
                             DOC_NUM,
                             BILL_DOC_TYPE_CODE,
                             BILL_NUM,
                             CUST_OUTSTANDING_AMT,
                             ALLOCATED_AMT,
                             PHYSICIAN_ID
			)
		VALUES  (    'BL',
			     :t_ref_num,
                             :t_df_pay_alcn_num,
                             :df_doc_type_code,
                             :df_doc_num,
                             NULL,
                             NULL,
                             :cust_outst_amt,
                             :df_alloc_amt,
                             :df_physician_id
			);
*/

        if(OERROR)
	    err_mesg("INSERT failed on table DF_PAY_ALCN",0,"");

}

ins_pat_ledger_bill()
{
    /* EXEC SQL INSERT INTO BL_PATIENT_LEDGER
                 (    OPERATING_FACILITY_ID,
		      EPISODE_TYPE,
                      PATIENT_ID,
                      EPISODE_ID,
                      VISIT_ID,
                      ORG_DOC_TYPE_CODE,
                      ORG_DOC_NUM,
                      ORG_DOC_DATE,
                      TRX_TYPE_CODE,
                      BILL_TRX_TYPE_CODE,
                      BILL_NATURE_CODE,
                      RECPT_NATURE_CODE,
                      RECPT_TYPE_CODE,
                      MAX_LINE_NUM,
                      DOC_AMT,
                      DOC_OUTST_AMT,
                      ADDED_BY_ID,
                      ADDED_DATE,
                      MODIFIED_BY_ID,
                      MODIFIED_DATE,
		      ADDED_AT_WS_NO   ,              
		      ADDED_FACILITY_ID ,             
		      MODIFIED_AT_WS_NO ,             
		      MODIFIED_FACILITY_ID           
                 )
          values (    :nd_operating_facility_id,
		      :t_episode_type,
                      :t_patient_id,
                      :t_episode_id,
                      NVL(:t_visit_id,0),
                      :t_doc_type_code,
                      :t_doc_num,
                      TO_DATE(:t_doc_date,'DD/MM/YYYY'),
                      '1',
                      :t_bill_trx_type_code,
                      :t_bill_nature_code,
                      NULL,
                      NULL,
                      1,
                      :t_bill_tot_amt,
                      :t_bill_tot_amt,
                      :t_added_by_id,
                      TO_DATE(:t_added_date,'DD/MM/YYYY'),
                      :t_modified_by_id,
                      TO_DATE(:t_modified_date,'DD/MM/YYYY'),
		      :nd_ws_no,
		      :nd_operating_facility_id,
		      :nd_ws_no,
		      :nd_operating_facility_id
                 ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_PATIENT_LEDGER (OPERATING_FACILITY_ID,EPIS\
ODE_TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,ORG_DOC_TYPE_CODE,ORG_DOC_NUM,ORG_DOC_\
DATE,TRX_TYPE_CODE,BILL_TRX_TYPE_CODE,BILL_NATURE_CODE,RECPT_NATURE_CODE,RECPT\
_TYPE_CODE,MAX_LINE_NUM,DOC_AMT,DOC_OUTST_AMT,ADDED_BY_ID,ADDED_DATE,MODIFIED_\
BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIE\
D_FACILITY_ID) values (:b0,:b1,:b2,:b3,NVL(:b4,0),:b5,:b6,TO_DATE(:b7,'DD/MM/Y\
YYY'),'1',:b8,:b9,null ,null ,1,:b10,:b10,:b12,TO_DATE(:b13,'DD/MM/YYYY'),:b14\
,TO_DATE(:b15,'DD/MM/YYYY'),:b16,:b0,:b16,:b0)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2931;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_episode_id;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_visit_id;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_doc_date;
    sqlstm.sqhstl[7] = (unsigned int  )15;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&t_bill_trx_type_code;
    sqlstm.sqhstl[8] = (unsigned int  )4;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&t_bill_nature_code;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&t_bill_tot_amt;
    sqlstm.sqhstl[10] = (unsigned int  )25;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&t_bill_tot_amt;
    sqlstm.sqhstl[11] = (unsigned int  )25;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&t_added_by_id;
    sqlstm.sqhstl[12] = (unsigned int  )33;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&t_added_date;
    sqlstm.sqhstl[13] = (unsigned int  )33;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&t_modified_by_id;
    sqlstm.sqhstl[14] = (unsigned int  )33;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&t_modified_date;
    sqlstm.sqhstl[15] = (unsigned int  )33;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[16] = (unsigned int  )33;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[17] = (unsigned int  )5;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[18] = (unsigned int  )33;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[19] = (unsigned int  )5;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	err_mesg("INSERT failed on table BL_PATIENT_LEDGER",0,"");
}

ins_pat_ledger_trn_bill()
{

     /* EXEC SQL INSERT INTO BL_PATIENT_LEDGER_TRN
                        ( OPERATING_FACILITY_ID,
		          EPISODE_TYPE,
                          PATIENT_ID,
                          EPISODE_ID,
                          VISIT_ID,
                          ORG_DOC_TYPE_CODE,
                          ORG_DOC_NUM,
                          LINE_NUM,
                          DOC_TYPE_CODE,
                          DOC_NUM,
                          DOC_DATE,
                          DOC_AMT,
                          TRX_TYPE_CODE,
                          BILL_TRX_TYPE_CODE,
                          BILL_NATURE_CODE,
                          RECPT_NATURE_CODE,
                          RECPT_TYPE_CODE,
                          ADDED_BY_ID,
                          ADDED_DATE,
                          MODIFIED_BY_ID,
                          MODIFIED_DATE,
						  ADDED_AT_WS_NO ,                
						  ADDED_FACILITY_ID,              
						  MODIFIED_AT_WS_NO,              
						  MODIFIED_FACILITY_ID           
			  )
               VALUES   ( :nd_operating_facility_id,
						  :t_episode_type,
                          :t_patient_id,
                          :t_episode_id,
                          NVL(:t_visit_id,0),
                          :t_doc_type_code,
                          :t_doc_num,
                          1,
                          :t_doc_type_code,
                          :t_doc_num,
                          TO_DATE(:t_doc_date,'DD/MM/YYYY'),
                          :t_bill_tot_amt,
                          '1',
                          :t_bill_trx_type_code,
                          :t_bill_nature_code,
                          NULL,
                          NULL,
                          :t_added_by_id,
                          TO_DATE(:t_added_date,'DD/MM/YYYY'),
                          :t_modified_by_id,
                          TO_DATE(:t_modified_date,'DD/MM/YYYY'),
						  :nd_ws_no,
						  :nd_operating_facility_id,
						  :nd_ws_no,
						  :nd_operating_facility_id	
                        ); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 37;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "insert into BL_PATIENT_LEDGER_TRN (OPERATING_FACILITY_ID\
,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,ORG_DOC_TYPE_CODE,ORG_DOC_NUM,LIN\
E_NUM,DOC_TYPE_CODE,DOC_NUM,DOC_DATE,DOC_AMT,TRX_TYPE_CODE,BILL_TRX_TYPE_CODE,\
BILL_NATURE_CODE,RECPT_NATURE_CODE,RECPT_TYPE_CODE,ADDED_BY_ID,ADDED_DATE,MODI\
FIED_BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MO\
DIFIED_FACILITY_ID) values (:b0,:b1,:b2,:b3,NVL(:b4,0),:b5,:b6,1,:b5,:b6,TO_DA\
TE(:b9,'DD/MM/YYYY'),:b10,'1',:b11,:b12,null ,null ,:b13,TO_DATE(:b14,'DD/MM/Y\
YYY'),:b15,TO_DATE(:b16,'DD/MM/YYYY'),:b17,:b0,:b17,:b0)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )3026;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&t_episode_type;
     sqlstm.sqhstl[1] = (unsigned int  )4;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&t_patient_id;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&t_episode_id;
     sqlstm.sqhstl[3] = (unsigned int  )11;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&t_visit_id;
     sqlstm.sqhstl[4] = (unsigned int  )7;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&t_doc_type_code;
     sqlstm.sqhstl[5] = (unsigned int  )9;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&t_doc_num;
     sqlstm.sqhstl[6] = (unsigned int  )11;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&t_doc_type_code;
     sqlstm.sqhstl[7] = (unsigned int  )9;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&t_doc_num;
     sqlstm.sqhstl[8] = (unsigned int  )11;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&t_doc_date;
     sqlstm.sqhstl[9] = (unsigned int  )15;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&t_bill_tot_amt;
     sqlstm.sqhstl[10] = (unsigned int  )25;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&t_bill_trx_type_code;
     sqlstm.sqhstl[11] = (unsigned int  )4;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&t_bill_nature_code;
     sqlstm.sqhstl[12] = (unsigned int  )4;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&t_added_by_id;
     sqlstm.sqhstl[13] = (unsigned int  )33;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&t_added_date;
     sqlstm.sqhstl[14] = (unsigned int  )33;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&t_modified_by_id;
     sqlstm.sqhstl[15] = (unsigned int  )33;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&t_modified_date;
     sqlstm.sqhstl[16] = (unsigned int  )33;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&nd_ws_no;
     sqlstm.sqhstl[17] = (unsigned int  )33;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[18] = (unsigned int  )5;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&nd_ws_no;
     sqlstm.sqhstl[19] = (unsigned int  )33;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[20] = (unsigned int  )5;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if(OERROR)
         err_mesg("INSERT failed on table BL_PATIENT_LEDGER_TRN",0,"");
}

ins_pat_inhouse_bill()
{
    /* EXEC SQL INSERT INTO BL_INHOUSE_BILL
                 (    OPERATING_FACILITY_ID,
					  EPISODE_TYPE,
                      PATIENT_ID,
                      EPISODE_ID,
                      VISIT_ID,
                      DOC_TYPE_CODE,
                      DOC_NUMBER,
                      DOC_DATE,
                      BILL_TRX_TYPE_CODE,
                      BILL_NATURE_CODE,
                      DOC_AMT,
                      DOC_OUTST_AMT,
					  ADDED_BY_ID,
					  MODIFIED_BY_ID,         
					  ADDED_DATE,             
					  MODIFIED_DATE,          
                      ADDED_AT_WS_NO,         
					  ADDED_FACILITY_ID,      
                      MODIFIED_AT_WS_NO,      
					  MODIFIED_FACILITY_ID    
                 )
          values ( 
			:nd_operating_facility_id,
			:t_episode_type,
			:t_patient_id,
			:t_episode_id,
			NVL(:t_visit_id,0),
			:t_doc_type_code,
			:t_doc_num,
			TO_DATE(:t_doc_date,'DD/MM/YYYY'),
			:t_bill_trx_type_code,
			:t_bill_nature_code,
			:t_bill_tot_amt - :t_prv_bill_tot_outst_amt,
			:t_bill_tot_amt - :t_prv_bill_tot_outst_amt,
			user,
			user,
			sysdate,
			sysdate,
			:nd_ws_no,
			:nd_operating_facility_id,
			:nd_ws_no,
			:nd_operating_facility_id
                 ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_INHOUSE_BILL (OPERATING_FACILITY_ID,EPISOD\
E_TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,DOC_TYPE_CODE,DOC_NUMBER,DOC_DATE,BILL_T\
RX_TYPE_CODE,BILL_NATURE_CODE,DOC_AMT,DOC_OUTST_AMT,ADDED_BY_ID,MODIFIED_BY_ID\
,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,M\
ODIFIED_FACILITY_ID) values (:b0,:b1,:b2,:b3,NVL(:b4,0),:b5,:b6,TO_DATE(:b7,'D\
D/MM/YYYY'),:b8,:b9,(:b10-:b11),(:b10-:b11),user,user,sysdate,sysdate,:b14,:b0\
,:b14,:b0)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3125;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_episode_id;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_visit_id;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_doc_date;
    sqlstm.sqhstl[7] = (unsigned int  )15;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&t_bill_trx_type_code;
    sqlstm.sqhstl[8] = (unsigned int  )4;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&t_bill_nature_code;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&t_bill_tot_amt;
    sqlstm.sqhstl[10] = (unsigned int  )25;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&t_prv_bill_tot_outst_amt;
    sqlstm.sqhstl[11] = (unsigned int  )25;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&t_bill_tot_amt;
    sqlstm.sqhstl[12] = (unsigned int  )25;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&t_prv_bill_tot_outst_amt;
    sqlstm.sqhstl[13] = (unsigned int  )25;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[14] = (unsigned int  )33;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[15] = (unsigned int  )5;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[16] = (unsigned int  )33;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[17] = (unsigned int  )5;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	err_mesg("INSERT failed on table BL_INHOUSE_BILL",0,"");
}

do_insrt()
{

    t_doc_type_code.arr[0]  = '\0';
    t_doc_num.arr[0]  = '\0';
    t_doc_date.arr[0]  = '\0';
    t_overall_int_code.arr[0] = '\0';
    t_bill_type_code.arr[0]   = '\0';
    t_tot_disc_char.arr[0]   = '\0';
    t_tot_disc_nega.arr[0]   = '\0';

    t_episode_type.arr[0]  = '\0';
    t_patient_id.arr[0]  = '\0';
    t_episode_id.arr[0]  = '\0';
    t_visit_id.arr[0]  = '\0';
    t_bill_trx_type_code.arr[0]  = '\0';
    t_bill_nature_code.arr[0]  = '\0';
    t_bill_tot_amt.arr[0]  = '\0';
    t_bill_tot_outst_amt.arr[0]  = '\0';
    t_added_by_id.arr[0]  = '\0';
    t_modified_by_id.arr[0]  = '\0';
    t_added_date.arr[0]  = '\0';
    t_modified_date.arr[0]  = '\0';
    nd_doc_type.arr[0]  = '\0';
    nd_doc_num.arr[0]  = '\0';
    nd_doc_date.arr[0]  = '\0';

    t_doc_type_code.len     = 0;
    t_doc_num.len     = 0;
    t_doc_date.len     = 0;
    t_overall_int_code.len  = 0;
    t_bill_type_code.len    = 0;
    t_tot_disc_char.len     = 0;
    t_tot_disc_nega.len     = 0;

    t_episode_type.len     = 0;
    t_patient_id.len     = 0;
    t_episode_id.len     = 0;
    t_visit_id.len     = 0;
    t_bill_trx_type_code.len     = 0;
    t_bill_nature_code.len     = 0;
    t_bill_tot_amt.len     = 0;
    t_bill_tot_outst_amt.len     = 0;
    t_added_by_id.len     = 0;
    t_modified_by_id.len     = 0;
    t_added_date.len     = 0;
    t_modified_date.len     = 0;
    nd_doc_type.len   = 0;
    nd_doc_num.len   = 0;
    nd_doc_date.len  = 0;


    t_bill_drfee_tot_amt = 0;
    t_man_disc_amt       = 0;
    t_overall_disc_amt   = 0;

    /* EXEC SQL SELECT  EPISODE_TYPE,
		     PATIENT_ID,
		     NVL(EPISODE_ID,0),
		     NVL(VISIT_ID,1),
		     BILL_TRX_TYPE_CODE,
		     BILL_NATURE_CODE,
		     BILL_TOT_AMT,
		     BILL_TOT_OUTST_AMT,
		     ADDED_BY_ID,
		     MODIFIED_BY_ID,
		     TO_CHAR(ADDED_DATE,'DD/MM/YYYY'),
		     TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY'),
		     DOC_TYPE_CODE,
		     DOC_NUM,
		     TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                     NVL(MAN_DISC_AMT,0),
                     NVL(OVERALL_DISC_AMT,0),
                     OVR_DISC_ACC_INT_CODE,
                     BILL_TYPE_CODE,
                     NVL(MAN_DISC_AMT,0) + NVL(OVERALL_DISC_AMT,0),
                     (NVL(MAN_DISC_AMT,0) + NVL(OVERALL_DISC_AMT,0)) * -1,
		     NVL(BILL_DRFEE_AMT,0),
		     NVL(BILL_POSTED_FLAG,'N'),
		     CASH_CTRL_DOC_TYPE_CODE,
                     CASH_CTRL_DOC_NUMBER,
                     CASH_CTRL_DOC_DATE             
	     INTO  :t_episode_type,
                   :t_patient_id,
                   :t_episode_id,
                   :t_visit_id,
                   :t_bill_trx_type_code,
                   :t_bill_nature_code,
                   :t_bill_tot_amt,
                   :t_bill_tot_outst_amt,
                   :t_added_by_id,
                   :t_modified_by_id,
                   :t_added_date,
                   :t_modified_date,
	           :t_doc_type_code,
		   :t_doc_num,
		   :t_doc_date,
                   :t_man_disc_amt,
                   :t_overall_disc_amt,
                   :t_overall_int_code,
                   :t_bill_type_code,
                   :t_tot_disc_char,
                   :t_tot_disc_nega,
		   :t_bill_drfee_tot_amt,
		   :t_bill_posted_flag,
		   :nd_doc_type,
                   :nd_doc_num,
                   :nd_doc_date
	     FROM    BL_BILL_HDR
	     WHERE   DOC_TYPE_CODE = :recref_bill_doc_type_code
	     AND     DOC_NUM       = :recref_bill_doc_number
	     AND     OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select EPISODE_TYPE ,PATIENT_ID ,NVL(EPISODE_ID,0) ,NVL(V\
ISIT_ID,1) ,BILL_TRX_TYPE_CODE ,BILL_NATURE_CODE ,BILL_TOT_AMT ,BILL_TOT_OUTST\
_AMT ,ADDED_BY_ID ,MODIFIED_BY_ID ,TO_CHAR(ADDED_DATE,'DD/MM/YYYY') ,TO_CHAR(M\
ODIFIED_DATE,'DD/MM/YYYY') ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YY\
YY') ,NVL(MAN_DISC_AMT,0) ,NVL(OVERALL_DISC_AMT,0) ,OVR_DISC_ACC_INT_CODE ,BIL\
L_TYPE_CODE ,(NVL(MAN_DISC_AMT,0)+NVL(OVERALL_DISC_AMT,0)) ,((NVL(MAN_DISC_AMT\
,0)+NVL(OVERALL_DISC_AMT,0))* (-1)) ,NVL(BILL_DRFEE_AMT,0) ,NVL(BILL_POSTED_FL\
AG,'N') ,CASH_CTRL_DOC_TYPE_CODE ,CASH_CTRL_DOC_NUMBER ,CASH_CTRL_DOC_DATE int\
o :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:\
b17,:b18,:b19,:b20,:b21,:b22,:b23,:b24,:b25  from BL_BILL_HDR where ((DOC_TYPE\
_CODE=:b26 and DOC_NUM=:b27) and OPERATING_FACILITY_ID=:b28)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3212;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_episode_id;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_visit_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_bill_trx_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_bill_nature_code;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_bill_tot_amt;
    sqlstm.sqhstl[6] = (unsigned int  )25;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_bill_tot_outst_amt;
    sqlstm.sqhstl[7] = (unsigned int  )25;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&t_added_by_id;
    sqlstm.sqhstl[8] = (unsigned int  )33;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&t_modified_by_id;
    sqlstm.sqhstl[9] = (unsigned int  )33;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&t_added_date;
    sqlstm.sqhstl[10] = (unsigned int  )33;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&t_modified_date;
    sqlstm.sqhstl[11] = (unsigned int  )33;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[12] = (unsigned int  )9;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[13] = (unsigned int  )11;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&t_doc_date;
    sqlstm.sqhstl[14] = (unsigned int  )15;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&t_man_disc_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&t_overall_disc_amt;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&t_overall_int_code;
    sqlstm.sqhstl[17] = (unsigned int  )9;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&t_bill_type_code;
    sqlstm.sqhstl[18] = (unsigned int  )5;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&t_tot_disc_char;
    sqlstm.sqhstl[19] = (unsigned int  )23;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&t_tot_disc_nega;
    sqlstm.sqhstl[20] = (unsigned int  )23;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&t_bill_drfee_tot_amt;
    sqlstm.sqhstl[21] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&t_bill_posted_flag;
    sqlstm.sqhstl[22] = (unsigned int  )1;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&nd_doc_type;
    sqlstm.sqhstl[23] = (unsigned int  )9;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&nd_doc_num;
    sqlstm.sqhstl[24] = (unsigned int  )37;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&nd_doc_date;
    sqlstm.sqhstl[25] = (unsigned int  )32;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&recref_bill_doc_type_code;
    sqlstm.sqhstl[26] = (unsigned int  )9;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&recref_bill_doc_number;
    sqlstm.sqhstl[27] = (unsigned int  )11;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[28] = (unsigned int  )5;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	err_mesg("SELECT failed on table BL_BILL_HDR",0,"");

	   if(NO_DATA_FOUND)
		{  
	 sprintf(string_var,"Record %s - %s not found in BL_BILL_HDR",recref_bill_doc_type_code.arr,recref_bill_doc_number.arr);
	         err_mesg(string_var,0,"");
 		}   


    t_doc_type_code.arr[t_doc_type_code.len]  = '\0';
    t_doc_num.arr[t_doc_num.len]  = '\0';
    t_doc_date.arr[t_doc_date.len]  = '\0';
    t_overall_int_code.arr[t_overall_int_code.len] = '\0';
    t_bill_type_code.arr[t_bill_type_code.len] = '\0';
    t_tot_disc_char.arr[t_tot_disc_char.len] = '\0';
    t_tot_disc_nega.arr[t_tot_disc_nega.len] = '\0';
    t_episode_type.arr[t_episode_type.len]  = '\0';
    t_patient_id.arr[t_patient_id.len]  = '\0';
    t_episode_id.arr[t_episode_id.len]  = '\0';
    t_visit_id.arr[t_visit_id.len]  = '\0';
    t_bill_trx_type_code.arr[t_bill_trx_type_code.len]  = '\0';
    t_bill_nature_code.arr[t_bill_nature_code.len]  = '\0';
    t_bill_tot_amt.arr[t_bill_tot_amt.len]  = '\0';
    t_bill_tot_outst_amt.arr[t_bill_tot_outst_amt.len]  = '\0';
    t_added_by_id.arr[t_added_by_id.len]  = '\0';
    t_modified_by_id.arr[t_modified_by_id.len]  = '\0';
    t_added_date.arr[t_added_date.len]  = '\0';
    t_modified_date.arr[t_modified_date.len]  = '\0';
    nd_doc_type.arr[nd_doc_type.len]='\0';
    nd_doc_num.arr[nd_doc_num.len]='\0';
    nd_doc_date.arr[nd_doc_date.len]='\0';


    ins_pat_ledger_bill();
    ins_pat_ledger_trn_bill();

    if(t_bill_posted_flag != 'Y') {

/*        if(t_bill_drfee_tot_amt > 0)
	    upd_phys_ledger();
*/
    
        post_discounts(0);
	if (g_error) return; // Added new	

    
        /* EXEC SQL UPDATE BL_BILL_HDR
	         SET    BILL_POSTED_FLAG = 'Y',
			UNPOSTED_REASON	 = NULL,
		    MODIFIED_BY_ID         = user,
	            MODIFIED_DATE          = SYSDATE,
		    ADDED_AT_WS_NO         = :nd_ws_no,
		    ADDED_FACILITY_ID      = :nd_operating_facility_id,
	            MODIFIED_AT_WS_NO      = :nd_ws_no,
		    MODIFIED_FACILITY_ID   = :nd_operating_facility_id
	         WHERE   DOC_TYPE_CODE = :recref_bill_doc_type_code
	         AND     DOC_NUM       = :recref_bill_doc_number
		 AND     OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update BL_BILL_HDR  set BILL_POSTED_FLAG='Y',UNPOSTED\
_REASON=null ,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADD\
ED_FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ((DOC_\
TYPE_CODE=:b4 and DOC_NUM=:b5) and OPERATING_FACILITY_ID=:b1)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )3343;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
        sqlstm.sqhstl[0] = (unsigned int  )33;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[1] = (unsigned int  )5;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
        sqlstm.sqhstl[2] = (unsigned int  )33;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&recref_bill_doc_type_code;
        sqlstm.sqhstl[4] = (unsigned int  )9;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&recref_bill_doc_number;
        sqlstm.sqhstl[5] = (unsigned int  )11;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[6] = (unsigned int  )5;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	    if(OERROR)
	        err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");
    }

     /* EXEC SQL SELECT ROWID, nvl(MAX_LINE_NUM,0) + 1
              INTO   :patltr_rowid, :patltr_max_line_num
              FROM   BL_PATIENT_LEDGER
              WHERE  EPISODE_TYPE = :recref_episode_type
              AND    PATIENT_ID = :recref_patient_id
	      AND    OPERATING_FACILITY_ID = :nd_operating_facility_id        
              AND    NVL(EPISODE_ID,0) = NVL(:recref_episode_id,0)
	      AND    NVL(VISIT_ID,1) = 
	      DECODE(:recref_episode_type,'O',NVL(:recref_visit_id,1),
	      'E',NVL(:recref_visit_id,1),NVL(VISIT_ID,1))
              AND    ORG_DOC_TYPE_CODE = :recref_bill_doc_type_code
              AND    ORG_DOC_NUM = :recref_bill_doc_number; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 37;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select ROWID ,(nvl(MAX_LINE_NUM,0)+1) into :b0,:b1  from\
 BL_PATIENT_LEDGER where ((((((EPISODE_TYPE=:b2 and PATIENT_ID=:b3) and OPERAT\
ING_FACILITY_ID=:b4) and NVL(EPISODE_ID,0)=NVL(:b5,0)) and NVL(VISIT_ID,1)=DEC\
ODE(:b2,'O',NVL(:b7,1),'E',NVL(:b7,1),NVL(VISIT_ID,1))) and ORG_DOC_TYPE_CODE=\
:b9) and ORG_DOC_NUM=:b10)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )3386;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&patltr_rowid;
     sqlstm.sqhstl[0] = (unsigned int  )23;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&patltr_max_line_num;
     sqlstm.sqhstl[1] = (unsigned int  )12;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&recref_episode_type;
     sqlstm.sqhstl[2] = (unsigned int  )4;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&recref_patient_id;
     sqlstm.sqhstl[3] = (unsigned int  )23;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[4] = (unsigned int  )5;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&recref_episode_id;
     sqlstm.sqhstl[5] = (unsigned int  )11;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&recref_episode_type;
     sqlstm.sqhstl[6] = (unsigned int  )4;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&recref_visit_id;
     sqlstm.sqhstl[7] = (unsigned int  )7;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&recref_visit_id;
     sqlstm.sqhstl[8] = (unsigned int  )7;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&recref_bill_doc_type_code;
     sqlstm.sqhstl[9] = (unsigned int  )9;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&recref_bill_doc_number;
     sqlstm.sqhstl[10] = (unsigned int  )11;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
        err_mesg("SELECT failed on BL_PATIENT_LEDGER",0,"");

}

upd_phys_ledger()
{
        /* EXEC SQL OPEN T_PATIENT_FOLIO_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0028;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )3445;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[0] = (unsigned int  )5;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&t_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&t_doc_num;
        sqlstm.sqhstl[2] = (unsigned int  )11;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



        if(OERROR)
	        err_mesg("OPEN failed on cursor T_PATIENT_FOLIO_CUR",0,"");

	    while(fetch_folio()) 
		{

		/*EXEC SQL UPDATE DF_PHYSICIAN_LDGR
			 SET    BILL_DOC_TYPE_CODE = :t_doc_type_code,
				BILL_NUM           = :t_doc_num,
				BILL_DATE          = TO_DATE(:t_doc_date,'DD/MM/YYYY')
			 WHERE  PHYSICIAN_ID       = :t_physician_id
			 AND    DOC_TYPE_CODE      = :t_dpf_doc_type_code
			 AND    DOC_NUM            = :t_dpf_doc_number;*/

		if(OERROR)
		    err_mesg("UPDATE failed on table DF_PHYSICIAN_LDGR",0,"");

	    } /* end of while fetch foilo */

		/* EXEC SQL CLOSE T_PATIENT_FOLIO_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 37;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3472;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

post_discounts(cancel_flg)
int cancel_flg;
{

/*************** GL Posting of Bill Discounts  G Sriram ***********/
     if(cancel_flg) {
	 strcpy(t_doc_date.arr,c_post_date.arr);
	 t_doc_date.len = strlen(t_doc_date.arr);
          }      

        t_tot_disc_amt = 0;
        t_tot_disc_amt = t_man_disc_amt + t_overall_disc_amt;
        if (t_overall_disc_amt != 0)
          {
           t_bill_type_int_code.arr[0] = '\0';
           t_bill_type_int_code.len    = 0;
		   t_bill_disc_recv_acc_int_code.arr[0] = '\0';
           t_bill_disc_recv_acc_int_code.len    = 0;


           /* EXEC SQL SELECT B.BL_RECV_ACC_INT_CODE,B.BILL_DISC_RECV_ACC_INT_CODE 
		   INTO :t_bill_type_int_code,:t_bill_disc_recv_acc_int_code
           FROM BL_BILL_TYPE A, BL_BILL_TYPE_INT B
           WHERE A.BILL_TYPE_CODE = :t_bill_type_code
	   AND A.ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
	     			     WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
	   AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE
	   AND A.BILL_TYPE_CODE = B.BILL_TYPE_CODE
	   AND TO_DATE(:t_doc_date,'DD/MM/YYYY') between 
	       NVL(B.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
	       NVL(B.EFF_TO_DATE,SYSDATE)   /o Effective date range is included ON 01/06/2004 o/
	   ; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 37;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select B.BL_RECV_ACC_INT_CODE ,B.BILL_DISC_RECV_AC\
C_INT_CODE into :b0,:b1  from BL_BILL_TYPE A ,BL_BILL_TYPE_INT B where ((((A.B\
ILL_TYPE_CODE=:b2 and A.ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_AC\
C_ENTITY where ACC_ENTITY_ID=:b3)) and A.ACC_ENTITY_CODE=B.ACC_ENTITY_CODE) an\
d A.BILL_TYPE_CODE=B.BILL_TYPE_CODE) and TO_DATE(:b4,'DD/MM/YYYY') between NVL\
(B.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(B.EFF_TO_DATE,SYS\
DATE))";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )3487;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&t_bill_type_int_code;
           sqlstm.sqhstl[0] = (unsigned int  )9;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&t_bill_disc_recv_acc_int_code;
           sqlstm.sqhstl[1] = (unsigned int  )9;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&t_bill_type_code;
           sqlstm.sqhstl[2] = (unsigned int  )5;
           sqlstm.sqhsts[2] = (         int  )0;
           sqlstm.sqindv[2] = (         void  *)0;
           sqlstm.sqinds[2] = (         int  )0;
           sqlstm.sqharm[2] = (unsigned int  )0;
           sqlstm.sqadto[2] = (unsigned short )0;
           sqlstm.sqtdso[2] = (unsigned short )0;
           sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
           sqlstm.sqhstl[3] = (unsigned int  )5;
           sqlstm.sqhsts[3] = (         int  )0;
           sqlstm.sqindv[3] = (         void  *)0;
           sqlstm.sqinds[3] = (         int  )0;
           sqlstm.sqharm[3] = (unsigned int  )0;
           sqlstm.sqadto[3] = (unsigned short )0;
           sqlstm.sqtdso[3] = (unsigned short )0;
           sqlstm.sqhstv[4] = (         void  *)&t_doc_date;
           sqlstm.sqhstl[4] = (unsigned int  )15;
           sqlstm.sqhsts[4] = (         int  )0;
           sqlstm.sqindv[4] = (         void  *)0;
           sqlstm.sqinds[4] = (         int  )0;
           sqlstm.sqharm[4] = (unsigned int  )0;
           sqlstm.sqadto[4] = (unsigned short )0;
           sqlstm.sqtdso[4] = (unsigned short )0;
           sqlstm.sqphsv = sqlstm.sqhstv;
           sqlstm.sqphsl = sqlstm.sqhstl;
           sqlstm.sqphss = sqlstm.sqhsts;
           sqlstm.sqpind = sqlstm.sqindv;
           sqlstm.sqpins = sqlstm.sqinds;
           sqlstm.sqparm = sqlstm.sqharm;
           sqlstm.sqparc = sqlstm.sqharc;
           sqlstm.sqpadto = sqlstm.sqadto;
           sqlstm.sqptdso = sqlstm.sqtdso;
           sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            if(OERROR)
	       err_mesg("SELECT failed on table BL_BILL_TYPE_INT",0,"");

	      if(NO_DATA_FOUND)
	       {
	       sprintf(msg_str,"Record %s not found in BL_BILL_TYPE_INT",t_bill_type_code.arr);	 
	       //err_mesg(msg_str,0,"");
	       loc_log_msg(msg_str);
	       g_error = 1;
	       return;
	       }

            t_bill_type_int_code.arr[t_bill_type_int_code.len] = '\0';
			t_bill_disc_recv_acc_int_code.arr[t_bill_disc_recv_acc_int_code.len] = '\0';


           xxxxxx_main_acc1_code.arr[0]     = '\0';
           xxxxxx_main_acc2_code.arr[0]     = '\0';
           xxxxxx_dept_code.arr[0]     = '\0';
           xxxxxx_subledger_group_code.arr[0] = '\0';
           xxxxxx_subledger_line_code.arr[0] = '\0';
           xxxxxx_product_group_code.arr[0] = '\0';
           xxxxxx_product_line_code.arr[0] = '\0';

           xxxxxx_main_acc1_code.len                 = 0;
           xxxxxx_main_acc2_code.len                 = 0;
           xxxxxx_dept_code.len                      = 0;
           xxxxxx_subledger_group_code.len           = 0;
           xxxxxx_subledger_line_code.len            = 0;
           xxxxxx_product_group_code.len             = 0;
           xxxxxx_product_line_code.len              = 0;

           /* EXEC SQL SELECT MAIN_ACC1_CODE,
                  MAIN_ACC2_CODE,
                  DEPT_CODE,
                  SUBLEDGER_GROUP_CODE,
                  SUBLEDGER_LINE_CODE,
                  PRODUCT_GROUP_CODE,
                  PRODUCT_LINE_CODE     INTO
                  :xxxxxx_main_acc1_code,
                  :xxxxxx_main_acc2_code,
                  :xxxxxx_dept_code,
                  :xxxxxx_subledger_group_code,
                  :xxxxxx_subledger_line_code,
                  :xxxxxx_product_group_code,
                  :xxxxxx_product_line_code
                FROM BL_GL_ACCOUNT
                WHERE ACC_INT_CODE = :t_bill_type_int_code
	        AND   ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id); */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 37;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,\
SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CO\
DE into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from BL_GL_ACCOUNT where (ACC_INT_CODE=:b\
7 and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC\
_ENTITY_ID=:b8))";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )3522;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&xxxxxx_main_acc1_code;
           sqlstm.sqhstl[0] = (unsigned int  )9;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&xxxxxx_main_acc2_code;
           sqlstm.sqhstl[1] = (unsigned int  )7;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&xxxxxx_dept_code;
           sqlstm.sqhstl[2] = (unsigned int  )13;
           sqlstm.sqhsts[2] = (         int  )0;
           sqlstm.sqindv[2] = (         void  *)0;
           sqlstm.sqinds[2] = (         int  )0;
           sqlstm.sqharm[2] = (unsigned int  )0;
           sqlstm.sqadto[2] = (unsigned short )0;
           sqlstm.sqtdso[2] = (unsigned short )0;
           sqlstm.sqhstv[3] = (         void  *)&xxxxxx_subledger_group_code;
           sqlstm.sqhstl[3] = (unsigned int  )6;
           sqlstm.sqhsts[3] = (         int  )0;
           sqlstm.sqindv[3] = (         void  *)0;
           sqlstm.sqinds[3] = (         int  )0;
           sqlstm.sqharm[3] = (unsigned int  )0;
           sqlstm.sqadto[3] = (unsigned short )0;
           sqlstm.sqtdso[3] = (unsigned short )0;
           sqlstm.sqhstv[4] = (         void  *)&xxxxxx_subledger_line_code;
           sqlstm.sqhstl[4] = (unsigned int  )11;
           sqlstm.sqhsts[4] = (         int  )0;
           sqlstm.sqindv[4] = (         void  *)0;
           sqlstm.sqinds[4] = (         int  )0;
           sqlstm.sqharm[4] = (unsigned int  )0;
           sqlstm.sqadto[4] = (unsigned short )0;
           sqlstm.sqtdso[4] = (unsigned short )0;
           sqlstm.sqhstv[5] = (         void  *)&xxxxxx_product_group_code;
           sqlstm.sqhstl[5] = (unsigned int  )6;
           sqlstm.sqhsts[5] = (         int  )0;
           sqlstm.sqindv[5] = (         void  *)0;
           sqlstm.sqinds[5] = (         int  )0;
           sqlstm.sqharm[5] = (unsigned int  )0;
           sqlstm.sqadto[5] = (unsigned short )0;
           sqlstm.sqtdso[5] = (unsigned short )0;
           sqlstm.sqhstv[6] = (         void  *)&xxxxxx_product_line_code;
           sqlstm.sqhstl[6] = (unsigned int  )7;
           sqlstm.sqhsts[6] = (         int  )0;
           sqlstm.sqindv[6] = (         void  *)0;
           sqlstm.sqinds[6] = (         int  )0;
           sqlstm.sqharm[6] = (unsigned int  )0;
           sqlstm.sqadto[6] = (unsigned short )0;
           sqlstm.sqtdso[6] = (unsigned short )0;
           sqlstm.sqhstv[7] = (         void  *)&t_bill_type_int_code;
           sqlstm.sqhstl[7] = (unsigned int  )9;
           sqlstm.sqhsts[7] = (         int  )0;
           sqlstm.sqindv[7] = (         void  *)0;
           sqlstm.sqinds[7] = (         int  )0;
           sqlstm.sqharm[7] = (unsigned int  )0;
           sqlstm.sqadto[7] = (unsigned short )0;
           sqlstm.sqtdso[7] = (unsigned short )0;
           sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
           sqlstm.sqhstl[8] = (unsigned int  )5;
           sqlstm.sqhsts[8] = (         int  )0;
           sqlstm.sqindv[8] = (         void  *)0;
           sqlstm.sqinds[8] = (         int  )0;
           sqlstm.sqharm[8] = (unsigned int  )0;
           sqlstm.sqadto[8] = (unsigned short )0;
           sqlstm.sqtdso[8] = (unsigned short )0;
           sqlstm.sqphsv = sqlstm.sqhstv;
           sqlstm.sqphsl = sqlstm.sqhstl;
           sqlstm.sqphss = sqlstm.sqhsts;
           sqlstm.sqpind = sqlstm.sqindv;
           sqlstm.sqpins = sqlstm.sqinds;
           sqlstm.sqparm = sqlstm.sqharm;
           sqlstm.sqparc = sqlstm.sqharc;
           sqlstm.sqpadto = sqlstm.sqadto;
           sqlstm.sqptdso = sqlstm.sqtdso;
           sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            if(OERROR)
		{                 
	         err_mesg("SELECT failed on table BL_GL_ACCOUNT",0,"");
 		}

		if(NO_DATA_FOUND)
		{  
		 sprintf(string_var,"Record %s- %s not found in BL_GL_ACCOUNT",t_bill_type_code.arr,t_bill_type_int_code.arr);
	     err_mesg(string_var,0,"");
 		}

     xxxxxx_main_acc1_code.arr[xxxxxx_main_acc1_code.len] = '\0';
     xxxxxx_main_acc2_code.arr[xxxxxx_main_acc2_code.len] = '\0';
     xxxxxx_dept_code.arr[xxxxxx_dept_code.len]           = '\0';
     xxxxxx_subledger_group_code.arr[xxxxxx_subledger_group_code.len] = '\0';
     xxxxxx_subledger_line_code.arr[xxxxxx_subledger_line_code.len] = '\0';
     xxxxxx_product_group_code.arr[xxxxxx_product_group_code.len] = '\0';
     xxxxxx_product_line_code.arr[xxxxxx_product_line_code.len] = '\0';

     if(cancel_flg)
         strcpy(xxxxxx_doc_amt.arr,t_tot_disc_char.arr);
     else
         strcpy(xxxxxx_doc_amt.arr,t_tot_disc_nega.arr);

	   xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);

           ins_blgl_distrib_bl();

           xxxxxx_main_acc1_code.arr[0]     = '\0';
           xxxxxx_main_acc2_code.arr[0]     = '\0';
           xxxxxx_dept_code.arr[0]     = '\0';
           xxxxxx_subledger_group_code.arr[0] = '\0';
           xxxxxx_subledger_line_code.arr[0] = '\0';
           xxxxxx_product_group_code.arr[0] = '\0';
           xxxxxx_product_line_code.arr[0] = '\0';

           xxxxxx_main_acc1_code.len                 = 0;
           xxxxxx_main_acc2_code.len                 = 0;
           xxxxxx_dept_code.len                      = 0;
           xxxxxx_subledger_group_code.len           = 0;
           xxxxxx_subledger_line_code.len           = 0;
           xxxxxx_product_group_code.len           = 0;
           xxxxxx_product_line_code.len           = 0;

           /* EXEC SQL SELECT MAIN_ACC1_CODE,
                  MAIN_ACC2_CODE,
                  DEPT_CODE,
                  SUBLEDGER_GROUP_CODE,
                  SUBLEDGER_LINE_CODE,
                  PRODUCT_GROUP_CODE,
                  PRODUCT_LINE_CODE     INTO
                  :xxxxxx_main_acc1_code,
                  :xxxxxx_main_acc2_code,
                  :xxxxxx_dept_code,
                  :xxxxxx_subledger_group_code,
                  :xxxxxx_subledger_line_code,
                  :xxxxxx_product_group_code,
                  :xxxxxx_product_line_code
                FROM BL_GL_ACCOUNT
                WHERE ACC_INT_CODE = nvl(:t_overall_int_code,:t_bill_disc_recv_acc_int_code)
	        AND   ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id); */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 37;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,\
SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CO\
DE into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from BL_GL_ACCOUNT where (ACC_INT_CODE=nv\
l(:b7,:b8) and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY \
where ACC_ENTITY_ID=:b9))";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )3573;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&xxxxxx_main_acc1_code;
           sqlstm.sqhstl[0] = (unsigned int  )9;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&xxxxxx_main_acc2_code;
           sqlstm.sqhstl[1] = (unsigned int  )7;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&xxxxxx_dept_code;
           sqlstm.sqhstl[2] = (unsigned int  )13;
           sqlstm.sqhsts[2] = (         int  )0;
           sqlstm.sqindv[2] = (         void  *)0;
           sqlstm.sqinds[2] = (         int  )0;
           sqlstm.sqharm[2] = (unsigned int  )0;
           sqlstm.sqadto[2] = (unsigned short )0;
           sqlstm.sqtdso[2] = (unsigned short )0;
           sqlstm.sqhstv[3] = (         void  *)&xxxxxx_subledger_group_code;
           sqlstm.sqhstl[3] = (unsigned int  )6;
           sqlstm.sqhsts[3] = (         int  )0;
           sqlstm.sqindv[3] = (         void  *)0;
           sqlstm.sqinds[3] = (         int  )0;
           sqlstm.sqharm[3] = (unsigned int  )0;
           sqlstm.sqadto[3] = (unsigned short )0;
           sqlstm.sqtdso[3] = (unsigned short )0;
           sqlstm.sqhstv[4] = (         void  *)&xxxxxx_subledger_line_code;
           sqlstm.sqhstl[4] = (unsigned int  )11;
           sqlstm.sqhsts[4] = (         int  )0;
           sqlstm.sqindv[4] = (         void  *)0;
           sqlstm.sqinds[4] = (         int  )0;
           sqlstm.sqharm[4] = (unsigned int  )0;
           sqlstm.sqadto[4] = (unsigned short )0;
           sqlstm.sqtdso[4] = (unsigned short )0;
           sqlstm.sqhstv[5] = (         void  *)&xxxxxx_product_group_code;
           sqlstm.sqhstl[5] = (unsigned int  )6;
           sqlstm.sqhsts[5] = (         int  )0;
           sqlstm.sqindv[5] = (         void  *)0;
           sqlstm.sqinds[5] = (         int  )0;
           sqlstm.sqharm[5] = (unsigned int  )0;
           sqlstm.sqadto[5] = (unsigned short )0;
           sqlstm.sqtdso[5] = (unsigned short )0;
           sqlstm.sqhstv[6] = (         void  *)&xxxxxx_product_line_code;
           sqlstm.sqhstl[6] = (unsigned int  )7;
           sqlstm.sqhsts[6] = (         int  )0;
           sqlstm.sqindv[6] = (         void  *)0;
           sqlstm.sqinds[6] = (         int  )0;
           sqlstm.sqharm[6] = (unsigned int  )0;
           sqlstm.sqadto[6] = (unsigned short )0;
           sqlstm.sqtdso[6] = (unsigned short )0;
           sqlstm.sqhstv[7] = (         void  *)&t_overall_int_code;
           sqlstm.sqhstl[7] = (unsigned int  )9;
           sqlstm.sqhsts[7] = (         int  )0;
           sqlstm.sqindv[7] = (         void  *)0;
           sqlstm.sqinds[7] = (         int  )0;
           sqlstm.sqharm[7] = (unsigned int  )0;
           sqlstm.sqadto[7] = (unsigned short )0;
           sqlstm.sqtdso[7] = (unsigned short )0;
           sqlstm.sqhstv[8] = (         void  *)&t_bill_disc_recv_acc_int_code;
           sqlstm.sqhstl[8] = (unsigned int  )9;
           sqlstm.sqhsts[8] = (         int  )0;
           sqlstm.sqindv[8] = (         void  *)0;
           sqlstm.sqinds[8] = (         int  )0;
           sqlstm.sqharm[8] = (unsigned int  )0;
           sqlstm.sqadto[8] = (unsigned short )0;
           sqlstm.sqtdso[8] = (unsigned short )0;
           sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
           sqlstm.sqhstl[9] = (unsigned int  )5;
           sqlstm.sqhsts[9] = (         int  )0;
           sqlstm.sqindv[9] = (         void  *)0;
           sqlstm.sqinds[9] = (         int  )0;
           sqlstm.sqharm[9] = (unsigned int  )0;
           sqlstm.sqadto[9] = (unsigned short )0;
           sqlstm.sqtdso[9] = (unsigned short )0;
           sqlstm.sqphsv = sqlstm.sqhstv;
           sqlstm.sqphsl = sqlstm.sqhstl;
           sqlstm.sqphss = sqlstm.sqhsts;
           sqlstm.sqpind = sqlstm.sqindv;
           sqlstm.sqpins = sqlstm.sqinds;
           sqlstm.sqparm = sqlstm.sqharm;
           sqlstm.sqparc = sqlstm.sqharc;
           sqlstm.sqpadto = sqlstm.sqadto;
           sqlstm.sqptdso = sqlstm.sqtdso;
           sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            if(OERROR)
			{ //disp_message(ERR_MESG,t_overall_int_code.arr);
			         //disp_message(ERR_MESG, " 2 ");

	       err_mesg("SELECT failed on table BL_GL_ACCOUNT",0,"");
            }

	    if(NO_DATA_FOUND)
		{  
		 sprintf(string_var,"Record overall discount - %s not found in BL_GL_ACCOUNT",t_overall_int_code.arr);
	         err_mesg(string_var,0,"");
 		}

             xxxxxx_main_acc1_code.arr[xxxxxx_main_acc1_code.len] = '\0';
             xxxxxx_main_acc2_code.arr[xxxxxx_main_acc2_code.len] = '\0';
             xxxxxx_dept_code.arr[xxxxxx_dept_code.len]           = '\0';
     xxxxxx_subledger_group_code.arr[xxxxxx_subledger_group_code.len] = '\0';
     xxxxxx_subledger_line_code.arr[xxxxxx_subledger_line_code.len] = '\0';
     xxxxxx_product_group_code.arr[xxxxxx_product_group_code.len] = '\0';
     xxxxxx_product_line_code.arr[xxxxxx_product_line_code.len] = '\0';

    // strcpy(xxxxxx_dept_code.arr,dflt_dept_code.arr);
    // xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);

     if(cancel_flg)
         strcpy(xxxxxx_doc_amt.arr,t_tot_disc_nega.arr);
     else
         strcpy(xxxxxx_doc_amt.arr,t_tot_disc_char.arr);
     xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);

             ins_blgl_distrib_bl();

          }
/**** post manual disc seperately if any  added NK 02/06/94 ***/

    if (t_man_disc_amt != 0)
    {
        t_bill_type_int_code.arr[0] = '\0';
        t_bill_type_int_code.len    = 0;
		t_bill_disc_recv_acc_int_code.arr[0] = '\0';
        t_bill_disc_recv_acc_int_code.len    = 0;

        /* EXEC SQL SELECT B.BL_RECV_ACC_INT_CODE,B.BILL_DISC_RECV_ACC_INT_CODE 
		INTO :t_bill_type_int_code,
			 :t_bill_disc_recv_acc_int_code
        FROM BL_BILL_TYPE A, BL_BILL_TYPE_INT B
        WHERE A.BILL_TYPE_CODE = :t_bill_type_code
        AND   A.ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
				FROM   SY_ACC_ENTITY 
				WHERE  ACC_ENTITY_ID = :nd_operating_facility_id)
	AND  A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE
	AND  A.BILL_TYPE_CODE = B.BILL_TYPE_CODE
	AND TO_DATE(:t_doc_date,'DD/MM/YYYY') between 
		      NVL(B.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(B.EFF_TO_DATE,SYSDATE)   /o Effective date range is included ON 01/06/2004 o/
	; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select B.BL_RECV_ACC_INT_CODE ,B.BILL_DISC_RECV_ACC_I\
NT_CODE into :b0,:b1  from BL_BILL_TYPE A ,BL_BILL_TYPE_INT B where ((((A.BILL\
_TYPE_CODE=:b2 and A.ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_E\
NTITY where ACC_ENTITY_ID=:b3)) and A.ACC_ENTITY_CODE=B.ACC_ENTITY_CODE) and A\
.BILL_TYPE_CODE=B.BILL_TYPE_CODE) and TO_DATE(:b4,'DD/MM/YYYY') between NVL(B.\
EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(B.EFF_TO_DATE,SYSDAT\
E))";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )3628;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&t_bill_type_int_code;
        sqlstm.sqhstl[0] = (unsigned int  )9;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&t_bill_disc_recv_acc_int_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&t_bill_type_code;
        sqlstm.sqhstl[2] = (unsigned int  )5;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&t_doc_date;
        sqlstm.sqhstl[4] = (unsigned int  )15;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



        if(OERROR)
	    err_mesg("SELECT failed on table BL_BILL_TYPE_INT",0,"");

        if(NO_DATA_FOUND)
		{  
		 sprintf(string_var,"Record - %s not found in BL_BILL_TYPE_INT",t_bill_type_code.arr);
	         err_mesg(string_var,0,"");
 		}   

        t_bill_type_int_code.arr[t_bill_type_int_code.len] = '\0';
		t_bill_disc_recv_acc_int_code.arr[t_bill_disc_recv_acc_int_code.len] = '\0';

	open_bill_line();
	while(fetch_bill_line()) {

            xxxxxx_main_acc1_code.arr[0]       = '\0';
            xxxxxx_main_acc2_code.arr[0]       = '\0';
            xxxxxx_dept_code.arr[0]            = '\0';
            xxxxxx_subledger_group_code.arr[0] = '\0';
            xxxxxx_subledger_line_code.arr[0]  = '\0';
            xxxxxx_product_group_code.arr[0]   = '\0';
            xxxxxx_product_line_code.arr[0]    = '\0';
    
            xxxxxx_main_acc1_code.len              = 0;
            xxxxxx_main_acc2_code.len              = 0;
            xxxxxx_dept_code.len                   = 0;
            xxxxxx_subledger_group_code.len        = 0;
            xxxxxx_subledger_line_code.len         = 0;
            xxxxxx_product_group_code.len          = 0;
            xxxxxx_product_line_code.len           = 0;
    
            /* EXEC SQL SELECT MAIN_ACC1_CODE,
                            MAIN_ACC2_CODE,
                            DEPT_CODE,
                            SUBLEDGER_GROUP_CODE,
                            SUBLEDGER_LINE_CODE,
                            PRODUCT_GROUP_CODE,
                            PRODUCT_LINE_CODE     
		     INTO   :xxxxxx_main_acc1_code,
                            :xxxxxx_main_acc2_code,
                            :xxxxxx_dept_code,
                            :xxxxxx_subledger_group_code,
                            :xxxxxx_subledger_line_code,
                            :xxxxxx_product_group_code,
                            :xxxxxx_product_line_code
                     FROM   BL_GL_ACCOUNT
                     WHERE  ACC_INT_CODE = :t_bill_type_int_code
	             AND    ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
			    FROM   SY_ACC_ENTITY 
			    WHERE  ACC_ENTITY_ID = :nd_operating_facility_id); */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 37;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE \
,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_C\
ODE into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from BL_GL_ACCOUNT where (ACC_INT_CODE=:\
b7 and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where AC\
C_ENTITY_ID=:b8))";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )3663;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&xxxxxx_main_acc1_code;
            sqlstm.sqhstl[0] = (unsigned int  )9;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&xxxxxx_main_acc2_code;
            sqlstm.sqhstl[1] = (unsigned int  )7;
            sqlstm.sqhsts[1] = (         int  )0;
            sqlstm.sqindv[1] = (         void  *)0;
            sqlstm.sqinds[1] = (         int  )0;
            sqlstm.sqharm[1] = (unsigned int  )0;
            sqlstm.sqadto[1] = (unsigned short )0;
            sqlstm.sqtdso[1] = (unsigned short )0;
            sqlstm.sqhstv[2] = (         void  *)&xxxxxx_dept_code;
            sqlstm.sqhstl[2] = (unsigned int  )13;
            sqlstm.sqhsts[2] = (         int  )0;
            sqlstm.sqindv[2] = (         void  *)0;
            sqlstm.sqinds[2] = (         int  )0;
            sqlstm.sqharm[2] = (unsigned int  )0;
            sqlstm.sqadto[2] = (unsigned short )0;
            sqlstm.sqtdso[2] = (unsigned short )0;
            sqlstm.sqhstv[3] = (         void  *)&xxxxxx_subledger_group_code;
            sqlstm.sqhstl[3] = (unsigned int  )6;
            sqlstm.sqhsts[3] = (         int  )0;
            sqlstm.sqindv[3] = (         void  *)0;
            sqlstm.sqinds[3] = (         int  )0;
            sqlstm.sqharm[3] = (unsigned int  )0;
            sqlstm.sqadto[3] = (unsigned short )0;
            sqlstm.sqtdso[3] = (unsigned short )0;
            sqlstm.sqhstv[4] = (         void  *)&xxxxxx_subledger_line_code;
            sqlstm.sqhstl[4] = (unsigned int  )11;
            sqlstm.sqhsts[4] = (         int  )0;
            sqlstm.sqindv[4] = (         void  *)0;
            sqlstm.sqinds[4] = (         int  )0;
            sqlstm.sqharm[4] = (unsigned int  )0;
            sqlstm.sqadto[4] = (unsigned short )0;
            sqlstm.sqtdso[4] = (unsigned short )0;
            sqlstm.sqhstv[5] = (         void  *)&xxxxxx_product_group_code;
            sqlstm.sqhstl[5] = (unsigned int  )6;
            sqlstm.sqhsts[5] = (         int  )0;
            sqlstm.sqindv[5] = (         void  *)0;
            sqlstm.sqinds[5] = (         int  )0;
            sqlstm.sqharm[5] = (unsigned int  )0;
            sqlstm.sqadto[5] = (unsigned short )0;
            sqlstm.sqtdso[5] = (unsigned short )0;
            sqlstm.sqhstv[6] = (         void  *)&xxxxxx_product_line_code;
            sqlstm.sqhstl[6] = (unsigned int  )7;
            sqlstm.sqhsts[6] = (         int  )0;
            sqlstm.sqindv[6] = (         void  *)0;
            sqlstm.sqinds[6] = (         int  )0;
            sqlstm.sqharm[6] = (unsigned int  )0;
            sqlstm.sqadto[6] = (unsigned short )0;
            sqlstm.sqtdso[6] = (unsigned short )0;
            sqlstm.sqhstv[7] = (         void  *)&t_bill_type_int_code;
            sqlstm.sqhstl[7] = (unsigned int  )9;
            sqlstm.sqhsts[7] = (         int  )0;
            sqlstm.sqindv[7] = (         void  *)0;
            sqlstm.sqinds[7] = (         int  )0;
            sqlstm.sqharm[7] = (unsigned int  )0;
            sqlstm.sqadto[7] = (unsigned short )0;
            sqlstm.sqtdso[7] = (unsigned short )0;
            sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
            sqlstm.sqhstl[8] = (unsigned int  )5;
            sqlstm.sqhsts[8] = (         int  )0;
            sqlstm.sqindv[8] = (         void  *)0;
            sqlstm.sqinds[8] = (         int  )0;
            sqlstm.sqharm[8] = (unsigned int  )0;
            sqlstm.sqadto[8] = (unsigned short )0;
            sqlstm.sqtdso[8] = (unsigned short )0;
            sqlstm.sqphsv = sqlstm.sqhstv;
            sqlstm.sqphsl = sqlstm.sqhstl;
            sqlstm.sqphss = sqlstm.sqhsts;
            sqlstm.sqpind = sqlstm.sqindv;
            sqlstm.sqpins = sqlstm.sqinds;
            sqlstm.sqparm = sqlstm.sqharm;
            sqlstm.sqparc = sqlstm.sqharc;
            sqlstm.sqpadto = sqlstm.sqadto;
            sqlstm.sqptdso = sqlstm.sqtdso;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    
            if(OERROR)
	    {
			  //disp_message(ERR_MESG,t_bill_type_int_code.arr);
			    //               disp_message(ERR_MESG, " 3 ");

	         err_mesg("SELECT failed on table BL_GL_ACCOUNT",0,"");
	     }

	        if(NO_DATA_FOUND)
		{  
		 sprintf(string_var,"Record line level discount - %s not found in BL_GL_ACCOUNT for the document %s-%s",t_bill_type_int_code.arr,t_doc_type_code.arr,t_doc_num.arr);
	         err_mesg(string_var,0,"");
 		}   

    
            xxxxxx_main_acc1_code.arr[xxxxxx_main_acc1_code.len] = '\0';
            xxxxxx_main_acc2_code.arr[xxxxxx_main_acc2_code.len] = '\0';
            xxxxxx_dept_code.arr[xxxxxx_dept_code.len]           = '\0';
            xxxxxx_subledger_group_code.arr[xxxxxx_subledger_group_code.len] = '\0';
            xxxxxx_subledger_line_code.arr[xxxxxx_subledger_line_code.len] = '\0';
            xxxxxx_product_group_code.arr[xxxxxx_product_group_code.len] = '\0';
            xxxxxx_product_line_code.arr[xxxxxx_product_line_code.len] = '\0';
    
            if(cancel_flg)
                strcpy(xxxxxx_doc_amt.arr,t_man_disc_char.arr);
            else
                strcpy(xxxxxx_doc_amt.arr,t_man_disc_nega.arr);

            xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);

            ins_blgl_distrib_bl();

            xxxxxx_main_acc1_code.arr[0]       = '\0';
            xxxxxx_main_acc2_code.arr[0]       = '\0';
            xxxxxx_dept_code.arr[0]            = '\0';
            xxxxxx_subledger_group_code.arr[0] = '\0';
            xxxxxx_subledger_line_code.arr[0]  = '\0';
            xxxxxx_product_group_code.arr[0]   = '\0';
            xxxxxx_product_line_code.arr[0]    = '\0';
 
            xxxxxx_main_acc1_code.len          = 0;
            xxxxxx_main_acc2_code.len          = 0;
            xxxxxx_dept_code.len               = 0;
            xxxxxx_subledger_group_code.len    = 0;
            xxxxxx_subledger_line_code.len     = 0;
            xxxxxx_product_group_code.len      = 0;
            xxxxxx_product_line_code.len       = 0;

            /* EXEC SQL SELECT MAIN_ACC1_CODE,
                            MAIN_ACC2_CODE,
                            DEPT_CODE,
                            SUBLEDGER_GROUP_CODE,
                            SUBLEDGER_LINE_CODE,
                            PRODUCT_GROUP_CODE,
                            PRODUCT_LINE_CODE     
	             INTO   :xxxxxx_main_acc1_code,
                            :xxxxxx_main_acc2_code,
                            :xxxxxx_dept_code,
                            :xxxxxx_subledger_group_code,
                            :xxxxxx_subledger_line_code,
                            :xxxxxx_product_group_code,
                            :xxxxxx_product_line_code
                     FROM   BL_GL_ACCOUNT
                     WHERE  ACC_INT_CODE = nvl(:t_man_int_code,:t_bill_disc_recv_acc_int_code)
	             AND    ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
			    FROM   SY_ACC_ENTITY 
			    WHERE  ACC_ENTITY_ID = :nd_operating_facility_id); */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 37;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE \
,SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_C\
ODE into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from BL_GL_ACCOUNT where (ACC_INT_CODE=n\
vl(:b7,:b8) and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY\
 where ACC_ENTITY_ID=:b9))";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )3714;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&xxxxxx_main_acc1_code;
            sqlstm.sqhstl[0] = (unsigned int  )9;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&xxxxxx_main_acc2_code;
            sqlstm.sqhstl[1] = (unsigned int  )7;
            sqlstm.sqhsts[1] = (         int  )0;
            sqlstm.sqindv[1] = (         void  *)0;
            sqlstm.sqinds[1] = (         int  )0;
            sqlstm.sqharm[1] = (unsigned int  )0;
            sqlstm.sqadto[1] = (unsigned short )0;
            sqlstm.sqtdso[1] = (unsigned short )0;
            sqlstm.sqhstv[2] = (         void  *)&xxxxxx_dept_code;
            sqlstm.sqhstl[2] = (unsigned int  )13;
            sqlstm.sqhsts[2] = (         int  )0;
            sqlstm.sqindv[2] = (         void  *)0;
            sqlstm.sqinds[2] = (         int  )0;
            sqlstm.sqharm[2] = (unsigned int  )0;
            sqlstm.sqadto[2] = (unsigned short )0;
            sqlstm.sqtdso[2] = (unsigned short )0;
            sqlstm.sqhstv[3] = (         void  *)&xxxxxx_subledger_group_code;
            sqlstm.sqhstl[3] = (unsigned int  )6;
            sqlstm.sqhsts[3] = (         int  )0;
            sqlstm.sqindv[3] = (         void  *)0;
            sqlstm.sqinds[3] = (         int  )0;
            sqlstm.sqharm[3] = (unsigned int  )0;
            sqlstm.sqadto[3] = (unsigned short )0;
            sqlstm.sqtdso[3] = (unsigned short )0;
            sqlstm.sqhstv[4] = (         void  *)&xxxxxx_subledger_line_code;
            sqlstm.sqhstl[4] = (unsigned int  )11;
            sqlstm.sqhsts[4] = (         int  )0;
            sqlstm.sqindv[4] = (         void  *)0;
            sqlstm.sqinds[4] = (         int  )0;
            sqlstm.sqharm[4] = (unsigned int  )0;
            sqlstm.sqadto[4] = (unsigned short )0;
            sqlstm.sqtdso[4] = (unsigned short )0;
            sqlstm.sqhstv[5] = (         void  *)&xxxxxx_product_group_code;
            sqlstm.sqhstl[5] = (unsigned int  )6;
            sqlstm.sqhsts[5] = (         int  )0;
            sqlstm.sqindv[5] = (         void  *)0;
            sqlstm.sqinds[5] = (         int  )0;
            sqlstm.sqharm[5] = (unsigned int  )0;
            sqlstm.sqadto[5] = (unsigned short )0;
            sqlstm.sqtdso[5] = (unsigned short )0;
            sqlstm.sqhstv[6] = (         void  *)&xxxxxx_product_line_code;
            sqlstm.sqhstl[6] = (unsigned int  )7;
            sqlstm.sqhsts[6] = (         int  )0;
            sqlstm.sqindv[6] = (         void  *)0;
            sqlstm.sqinds[6] = (         int  )0;
            sqlstm.sqharm[6] = (unsigned int  )0;
            sqlstm.sqadto[6] = (unsigned short )0;
            sqlstm.sqtdso[6] = (unsigned short )0;
            sqlstm.sqhstv[7] = (         void  *)&t_man_int_code;
            sqlstm.sqhstl[7] = (unsigned int  )9;
            sqlstm.sqhsts[7] = (         int  )0;
            sqlstm.sqindv[7] = (         void  *)0;
            sqlstm.sqinds[7] = (         int  )0;
            sqlstm.sqharm[7] = (unsigned int  )0;
            sqlstm.sqadto[7] = (unsigned short )0;
            sqlstm.sqtdso[7] = (unsigned short )0;
            sqlstm.sqhstv[8] = (         void  *)&t_bill_disc_recv_acc_int_code;
            sqlstm.sqhstl[8] = (unsigned int  )9;
            sqlstm.sqhsts[8] = (         int  )0;
            sqlstm.sqindv[8] = (         void  *)0;
            sqlstm.sqinds[8] = (         int  )0;
            sqlstm.sqharm[8] = (unsigned int  )0;
            sqlstm.sqadto[8] = (unsigned short )0;
            sqlstm.sqtdso[8] = (unsigned short )0;
            sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
            sqlstm.sqhstl[9] = (unsigned int  )5;
            sqlstm.sqhsts[9] = (         int  )0;
            sqlstm.sqindv[9] = (         void  *)0;
            sqlstm.sqinds[9] = (         int  )0;
            sqlstm.sqharm[9] = (unsigned int  )0;
            sqlstm.sqadto[9] = (unsigned short )0;
            sqlstm.sqtdso[9] = (unsigned short )0;
            sqlstm.sqphsv = sqlstm.sqhstv;
            sqlstm.sqphsl = sqlstm.sqhstl;
            sqlstm.sqphss = sqlstm.sqhsts;
            sqlstm.sqpind = sqlstm.sqindv;
            sqlstm.sqpins = sqlstm.sqinds;
            sqlstm.sqparm = sqlstm.sqharm;
            sqlstm.sqparc = sqlstm.sqharc;
            sqlstm.sqpadto = sqlstm.sqadto;
            sqlstm.sqptdso = sqlstm.sqtdso;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



             if(OERROR)
			 {
			  //disp_message(ERR_MESG,t_man_int_code.arr);
			//	                 disp_message(ERR_MESG, " 4 ");

	        err_mesg("SELECT failed on table BL_GL_ACCOUNT",0,"");
			}

        if(NO_DATA_FOUND)
		{  
		   	 sprintf(string_var,"Record - %s not found in BL_GL_ACCOUNT",t_man_int_code.arr);
	         err_mesg(string_var,0,"");
 		 }   


             xxxxxx_main_acc1_code.arr[xxxxxx_main_acc1_code.len] = '\0';
             xxxxxx_main_acc2_code.arr[xxxxxx_main_acc2_code.len] = '\0';
             xxxxxx_dept_code.arr[xxxxxx_dept_code.len]           = '\0';
             xxxxxx_subledger_group_code.arr[xxxxxx_subledger_group_code.len] = '\0';
             xxxxxx_subledger_line_code.arr[xxxxxx_subledger_line_code.len] = '\0';
             xxxxxx_product_group_code.arr[xxxxxx_product_group_code.len] = '\0';
             xxxxxx_product_line_code.arr[xxxxxx_product_line_code.len] = '\0';

            // strcpy(xxxxxx_dept_code.arr,dflt_dept_code.arr);
            // xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);

             if(cancel_flg)
                 strcpy(xxxxxx_doc_amt.arr,t_man_disc_nega.arr);
             else
                 strcpy(xxxxxx_doc_amt.arr,t_man_disc_char.arr);
                 xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);

             ins_blgl_distrib_bl();

          }
    }
/*************** End of GL Posting   G Sriram *********************/
}

get_alloc_amt()
{

    tot_alloc_amt = 0;

   /* EXEC SQL SELECT SUM(ALLOCATED_AMT)
	     INTO   :tot_alloc_amt
	     FROM   DF_PAY_ALCN
	     WHERE  MODULE_ID     = 'BL'
	     AND    REF_NUM BETWEEN :t_start_ref_num AND :t_ref_num
	     AND    DOC_TYPE_CODE = :df_doc_type_code
             AND    DOC_NUM       = :df_doc_num;*/

    if(OERROR)
	err_mesg("SELECT failed on table DF_PAY_ALCN",0,"");
}

/****** NEW CODE ADDED NK ***********/

post_cancelled_trx()
{
    open_cancelled_trx();
    g_error = 0;
    g_savepoint = 0;
    while(fetch_cancelled_trx()) 
    {
	//  -added on 12/07/2003

	if(g_error) 
	  do_rollback();

    /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "savepoint LAST_DOC_REF";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3769;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
	err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

    g_savepoint = 1;

    //  added on 12/07/2003

    upd_reasons_in_receipt_refund_for_unposting(3);

    if (nd_reason_text.arr[0] != '\0')
         continue;

    amt_sign_ind = 0;	

    if(c_cancelled_ind.arr[0] == 'Y') 
	{
	   amt_sign_ind = -1;
	   strcpy(c_post_date.arr, c_cancelled_date.arr);
	}
    else if ((c_bounced_yn.arr[0] == 'Y') &&
                (c_bounced_status_ind.arr[0]  == 'N')) 
	{
	        amt_sign_ind = -1;
	        strcpy(c_post_date.arr, c_bounced_date.arr);
	}
     else if ((c_bounced_yn.arr[0] == 'Y') &&
                (c_bounced_status_ind.arr[0]  == 'C')) 
	{
	        amt_sign_ind = 1;
	        strcpy(c_post_date.arr, c_bounced_status_date.arr);
	}

	c_post_date.len = strlen(c_post_date.arr);
         
        	
	if(amt_sign_ind != 0) 
	{

	    // sprintf(string_var,"%s === %s ",c_doc_type_code.arr,c_doc_number.arr);
	    // disp_message(ERR_MESG,string_var);	    

	    process_cancel();	    

	    if(g_error) continue;  // added on 02/06/2004		    

	    if (nd_reason_text.arr[0] != '\0') continue;      // added on 02/06/2004	
	
	    if (strcmp(c_cons_rec_yn.arr,"Y") == 0)
	    {
		/* EXEC SQL UPDATE BL_BILLS_FOR_CONS_RCPT_CANC
				    SET POSTED_IND = 'Y',
					UNPOSTED_REASON = NULL,
					MODIFIED_BY_ID         = user,
					MODIFIED_DATE          = SYSDATE,
					ADDED_AT_WS_NO         = :nd_ws_no,
					ADDED_FACILITY_ID      = :nd_operating_facility_id,
					MODIFIED_AT_WS_NO      = :nd_ws_no,
					MODIFIED_FACILITY_ID   = :nd_operating_facility_id
				 WHERE  ROWID = :c_trx_rowid 
				   AND  OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 37;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_BILLS_FOR_CONS_RCPT_CANC  set POSTED_IND='Y',UNPO\
STED_REASON=null ,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0\
,ADDED_FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where (R\
OWID=:b4 and OPERATING_FACILITY_ID=:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3784;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&c_trx_rowid;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if(OERROR)
			err_mesg("UPDATE failed on table BL_BILLS_FOR_CONS_RCPT_CANC",0,"");

	    }
	    else
	    {
		/* EXEC SQL UPDATE BL_CANCELLED_BOUNCED_TRX
				    SET POSTED_IND = 'Y',
					UNPOSTED_REASON = NULL,
					MODIFIED_BY_ID         = user,
					MODIFIED_DATE          = SYSDATE,
					ADDED_AT_WS_NO         = :nd_ws_no,
					ADDED_FACILITY_ID      = :nd_operating_facility_id,
					MODIFIED_AT_WS_NO      = :nd_ws_no,
					MODIFIED_FACILITY_ID   = :nd_operating_facility_id
				 WHERE  ROWID = :c_trx_rowid 
				   AND  OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 37;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_CANCELLED_BOUNCED_TRX  set POSTED_IND='Y',UNPOSTE\
D_REASON=null ,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,AD\
DED_FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where (ROWI\
D=:b4 and OPERATING_FACILITY_ID=:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3823;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&c_trx_rowid;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if(OERROR)
			err_mesg("UPDATE failed on table BL_CANCELLED_BOUNCED_TRX",0,"");

	    }	    
	}
    		 //CURRENT OF CANCEL_TRX_CUR;

    }

    /* EXEC SQL CLOSE CANCEL_TRX_CUR ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3862;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
}

process_cancel()
{
    char t_amt[21];

    recref_doc_date.len                = 0;
    /* EXEC SQL SELECT :c_post_date INTO  :recref_doc_date  FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select :b0 into :b1  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3877;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&c_post_date;
    sqlstm.sqhstl[0] = (unsigned int  )15;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&recref_doc_date;
    sqlstm.sqhstl[1] = (unsigned int  )15;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    recref_doc_date.arr[recref_doc_date.len] = '\0';

    // new

    g_savepoint = 0;
    g_error = 0;

    //

    fetch_rec_ref_trx();

    //

    if(g_error) do_rollback();

    /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "savepoint LAST_DOC_REF";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3900;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
        err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

    g_savepoint = 1;

    if(recref_posted_ind.arr[0] != 'Y') 
    {
       upd_reasons_in_receipt_refund_for_unposting(1); 	 
    }

    if (nd_reason_text.arr[0] != '\0')  return;      

    // new

    get_bank_acc();
    if(g_error) return;  // added on 02/06/2004
    get_slmt_desc();    

    if(recref_posted_ind.arr[0] != 'Y') {

        if(amt_sign_ind == -1) 
	{
           strcpy(t_amt, recref_doc_amt.arr);
           strcpy(recref_doc_amt.arr, recref_doc_amt_negative.arr);
           strcpy(recref_doc_amt_negative.arr, t_amt);
	   recref_doc_amt.len = strlen(recref_doc_amt.arr);
	   recref_doc_amt_negative.len = strlen(recref_doc_amt_negative.arr);
	}	

	//----This is for inserting record to BL_DCP_TRN----
	     recref_dcp_ind.arr[0] = '\0';
	     recref_dcp_ind.len = 0;
	     strcpy(recref_dcp_ind.arr,"N");
	     recref_dcp_ind.len = strlen(recref_dcp_ind.arr);
	//--------------------------------------------------

	post_trx();
	if(g_error) return;  // added on 02/06/2004	

	if (strcmp(recref_cons_receipt_yn.arr,"Y") == 0)
	{
		/* EXEC SQL UPDATE BL_BILLS_FOR_CONS_RECEIPT
		    SET POSTED_IND = 'Y',
				UNPOSTED_REASON = NULL,
				MODIFIED_BY_ID         = user,
				MODIFIED_DATE          = SYSDATE,
				ADDED_AT_WS_NO         = :nd_ws_no,
				ADDED_FACILITY_ID      = :nd_operating_facility_id,
				MODIFIED_AT_WS_NO      = :nd_ws_no,
				MODIFIED_FACILITY_ID   = :nd_operating_facility_id
			 WHERE ROWID		= :recref_rowid; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 37;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_BILLS_FOR_CONS_RECEIPT  set POSTED_IND='Y',UNPOST\
ED_REASON=null ,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,A\
DDED_FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWI\
D=:b4";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3915;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&recref_rowid;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	 if(OERROR)
	    err_mesg("UPDATE failed on table BL_BILLS_FOR_CONS_RCPT_CANC",0,"");

	 }
	else
	 {	 
		/* EXEC SQL UPDATE BL_RECEIPT_REFUND_DTL
	         SET POSTED_IND			= 'Y' ,
		     UNPOSTED_REASON		= NULL,
		     MODIFIED_BY_ID		= user,
		     MODIFIED_DATE		= SYSDATE,
		     ADDED_AT_WS_NO		= :nd_ws_no,
		     ADDED_FACILITY_ID		= :nd_operating_facility_id,
		     MODIFIED_AT_WS_NO		= :nd_ws_no,
		     MODIFIED_FACILITY_ID	= :nd_operating_facility_id
		  WHERE ROWID			= :recref_rowid; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 37;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_RECEIPT_REFUND_DTL  set POSTED_IND='Y',UNPOSTED_R\
EASON=null ,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED\
_FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWID=:b\
4";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3950;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&recref_rowid;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	  if(OERROR)
	    err_mesg("UPDATE failed on table BL_RECEIPT_REFUND_DTL",0,"");
	 }        

        if(amt_sign_ind == -1) 
	{
           strcpy(t_amt, recref_doc_amt.arr);
           strcpy(recref_doc_amt.arr, recref_doc_amt_negative.arr);
           strcpy(recref_doc_amt_negative.arr, t_amt);
	   recref_doc_amt.len = strlen(recref_doc_amt.arr);
	   recref_doc_amt_negative.len = strlen(recref_doc_amt_negative.arr);

	}
    }

/*-- While posting the cancelled or bounced record the bounced date/month and
     year should go to bl_gl_distribution. VSK 14/06/1999 */

   recref_doc_date.arr[0]             = '\0';
   recref_post_month.arr[0]           = '\0';
   recref_post_year.arr[0]            = '\0';
   
   recref_doc_date.len                = 0;
   recref_post_month.len              = 0;
   recref_post_year.len               = 0;
	
	/*	
	EXEC SQL SELECT :c_post_date,
		   TO_CHAR(TO_DATE(:c_post_date,'DD/MM/YYYY'),'MM'),
		   TO_CHAR(TO_DATE(:c_post_date,'DD/MM/YYYY'),'YYYY') 
		   INTO 
		   :recref_doc_date,
		   :recref_post_month,
		   :recref_post_year
		   FROM DUAL;
	*/

   // Value from sy_acc_period_defn

   /* EXEC SQL SELECT :c_post_date
		   INTO  :recref_doc_date  FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 37;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select :b0 into :b1  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )3985;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&c_post_date;
   sqlstm.sqhstl[0] = (unsigned int  )15;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&recref_doc_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   recref_doc_date.arr[recref_doc_date.len]                         = '\0';


   /* exec sql select nvl(acc_per_year, to_char(to_date(:c_post_date,'DD/MM/YYYY'),'YYYY')),
		   nvl(acc_per_month,to_char(to_date(:c_post_date,'DD/MM/YYYY'),'MM'))  
	into :recref_post_year, :recref_post_month
	from sy_acc_period_defn
	where to_date(:recref_doc_date,'DD/MM/YYYY') 
	between acc_per_start_date and acc_per_end_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 37;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select nvl(acc_per_year,to_char(to_date(:b0,'DD/MM/YYYY'),\
'YYYY')) ,nvl(acc_per_month,to_char(to_date(:b0,'DD/MM/YYYY'),'MM')) into :b2,\
:b3  from sy_acc_period_defn where to_date(:b4,'DD/MM/YYYY') between acc_per_s\
tart_date and acc_per_end_date";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4008;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&c_post_date;
   sqlstm.sqhstl[0] = (unsigned int  )15;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&c_post_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&recref_post_year;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&recref_post_month;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&recref_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )15;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	

   recref_post_month.arr[recref_post_month.len]                     = '\0';
   recref_post_year.arr[recref_post_year.len]                       = '\0';  

   //----This is for inserting record to BL_DCP_TRN----
	     recref_dcp_ind.arr[0] = '\0';
	     recref_dcp_ind.len = 0;
	     strcpy(recref_dcp_ind.arr,"Y");
	     recref_dcp_ind.len = strlen(recref_dcp_ind.arr);
   //--------------------------------------------------

    if (c_bounced_yn.arr[0] == 'Y')
	post_trx();	 // post_trx_bounced();
    else
        post_trx();

    if(g_error) return;  // added on 02/06/2004
}

post_trx_bounced()
{
    strcpy(xxxxxx_main_acc1_code.arr,dr_main_acc1_code.arr);
    xxxxxx_main_acc1_code.len = strlen(xxxxxx_main_acc1_code.arr);
    strcpy(xxxxxx_main_acc2_code.arr,dr_main_acc2_code.arr);
    xxxxxx_main_acc2_code.len = strlen(xxxxxx_main_acc2_code.arr);
    strcpy(xxxxxx_dept_code.arr,dr_dept_code.arr);
    xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);
    strcpy(xxxxxx_subledger_group_code.arr,dr_subledger_group_code.arr);
    xxxxxx_subledger_group_code.len = strlen(xxxxxx_subledger_group_code.arr);
    strcpy(xxxxxx_subledger_line_code.arr,dr_subledger_line_code.arr);
    xxxxxx_subledger_line_code.len = strlen(xxxxxx_subledger_line_code.arr);
    strcpy(xxxxxx_product_group_code.arr,dr_product_group_code.arr);
    xxxxxx_product_group_code.len = strlen(xxxxxx_product_group_code.arr);
    strcpy(xxxxxx_product_line_code.arr,dr_product_line_code.arr);
    xxxxxx_product_line_code.len = strlen(xxxxxx_product_line_code.arr);

    if(amt_sign_ind == 1) {
        strcpy(xxxxxx_doc_amt.arr,recref_doc_amt.arr);
        xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);
    }
    else {
        strcpy(xxxxxx_doc_amt.arr,recref_doc_amt_negative.arr);
        xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);
    }
    ins_blgl_distrib();
    if(g_error) return;  // added on 02/06/2004

    strcpy(xxxxxx_main_acc1_code.arr,cr_main_acc1_code.arr);
    xxxxxx_main_acc1_code.len = strlen(xxxxxx_main_acc1_code.arr);
    strcpy(xxxxxx_main_acc2_code.arr,cr_main_acc2_code.arr);
    xxxxxx_main_acc2_code.len = strlen(xxxxxx_main_acc2_code.arr);
    strcpy(xxxxxx_dept_code.arr,cr_dept_code.arr);
    xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);
    strcpy(xxxxxx_subledger_group_code.arr,cr_subledger_group_code.arr);
    xxxxxx_subledger_group_code.len = strlen(xxxxxx_subledger_group_code.arr);
    strcpy(xxxxxx_subledger_line_code.arr,cr_subledger_line_code.arr);
    xxxxxx_subledger_line_code.len = strlen(xxxxxx_subledger_line_code.arr);
    strcpy(xxxxxx_product_group_code.arr,cr_product_group_code.arr);
    xxxxxx_product_group_code.len = strlen(xxxxxx_product_group_code.arr);
    strcpy(xxxxxx_product_line_code.arr,cr_product_line_code.arr);
    xxxxxx_product_line_code.len = strlen(xxxxxx_product_line_code.arr);

    if(amt_sign_ind == 1) {
        strcpy(xxxxxx_doc_amt.arr,recref_doc_amt_negative.arr);
        xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);
    }
    else {
        strcpy(xxxxxx_doc_amt.arr,recref_doc_amt.arr);
        xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);
    }
    ins_blgl_distrib();
    if(g_error) return;  // added on 02/06/2004

}

post_trx()
{
      if (
	 (strcmp(recref_recpt_nature_code.arr, "AD")==0)  ||
         (strcmp(recref_recpt_nature_code.arr, "PR")==0)  ||
         (strcmp(recref_recpt_nature_code.arr, "RD")==0)  ||
	 (strcmp(recref_recpt_nature_code.arr, "PD")==0)  ||
	 (strcmp(recref_recpt_nature_code.arr, "CR")==0)     ) 
      {
         if (recref_recpt_refund_ind.arr[0]=='R')
           get_other_acc (RECREF);
         else
           get_other_acc (RD);

	 if(g_error) return;  // added on 02/06/2004

         move_into_post_acc(BANK);
         ins_blgl_distrib();
	 if(g_error) return;  // added on 02/06/2004
         move_into_post_acc(OTHER);
         ins_blgl_distrib();
	 if(g_error) return;  // added on 02/06/2004
      }
      else if (strcmp(recref_recpt_nature_code.arr, "CU")==0)
      {
         get_other_acc(RECREF);
	 if(g_error) return;  // added on 02/06/2004
         move_into_post_acc(BANK);
         ins_blgl_distrib();
	 if(g_error) return;  // added on 02/06/2004
         move_into_post_acc(OTHER);
         ins_blgl_distrib();
	 if(g_error) return;  // added on 02/06/2004
      }
      else if (strcmp(recref_recpt_nature_code.arr, "DC")==0)
      {
         get_other_acc(DC);
	 if(g_error) return;  // added on 02/06/2004
         move_into_post_acc(BANK);
	 if(g_error) return;
	 ins_bldcp_trn();
	 if(g_error) return;
         ins_blgl_distrib();
	 if(g_error) return;  // added on 02/06/2004
         move_into_post_acc(OTHER);
         ins_blgl_distrib();
	 if(g_error) return;  // added on 02/06/2004

      }
      else if (strcmp(recref_recpt_nature_code.arr, "MI")==0)
      {
         //move_into_post_acc(BANK);
         //ins_blgl_distrib();
	 //if(g_error) return;  // added on 02/06/2004
	 
        get_other_acc(RECREF);
	if(g_error) return;  // added on 02/06/2004

	move_into_post_acc(BANK);
        ins_blgl_distrib();	
	if(g_error) return;  // added on 02/06/2004	

         move_into_post_acc(OTHER);
         ins_blgl_distrib();	 
	 if(g_error) return;  // added on 02/06/2004
	 
      }
      else if (strcmp(recref_recpt_nature_code.arr, "BI")==0)
      {
         get_other_acc(BILL);
	 if(g_error) return;  // added on 02/06/2004
         move_into_post_acc(BANK);
         ins_blgl_distrib();
	 if(g_error) return;  // added on 02/06/2004
         move_into_post_acc(OTHER);
         ins_blgl_distrib();
	 if(g_error) return;  // added on 02/06/2004
      }
}

post_cancelled_bills()
{

    open_cancelled_bill();
    while(fetch_cancelled_bill()) 
    {



//  added on 12/07/2003

	if(g_error) 
	  do_rollback();

      /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 37;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "savepoint LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )4043;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if (OERROR)
         err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

      g_savepoint = 1;

//  added on 12/07/2003

      upd_reasons_in_receipt_refund_for_unposting(2) ;

      if (nd_reason_text.arr[0] != '\0')
         continue;


	fetch_bill_dtls();
	if (g_error) continue; // Added new


	if (nd_reason_text.arr[0] != '\0')
         continue;

	post_discounts(1);
	if (g_error) continue; // Added new
	//KGA
	if  ( t_round_amt != 0 )
	  post_rounding_amt(1);
	  if (g_error) continue; // Added new

	/* EXEC SQL UPDATE BL_CANCELLED_BILLS
	        SET POSTED_IND				= 'Y',
		UNPOSTED_REASON			= NULL,
		MODIFIED_BY_ID			= user,
		MODIFIED_DATE			= SYSDATE,
		ADDED_AT_WS_NO			= :nd_ws_no,
		ADDED_FACILITY_ID		= :nd_operating_facility_id,
		MODIFIED_AT_WS_NO		= :nd_ws_no,
		MODIFIED_FACILITY_ID	= :nd_operating_facility_id
	        WHERE ROWID = :c_trx_rowid; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 37;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_CANCELLED_BILLS  set POSTED_IND='Y',UNPOSTED_REASO\
N=null ,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED_FAC\
ILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWID=:b4";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4058;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&c_trx_rowid;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		 
		 //CURRENT OF CANCEL_BILL_CUR;

	if(OERROR)
	    err_mesg("UPDATE failed on table BL_CANCELLED_BILLS",0,"");

    }

}

open_cancelled_trx()
{

    /* EXEC SQL OPEN CANCEL_TRX_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select A.rowid  ,A.RECPT_REFUND_IND ,A.DOC_TYPE_CODE ,A.DOC_NUMBER ,A\
.DOC_SRNO ,NVL(A.CANCELLED_IND,'N') ,NVL(A.BOUNCED_YN,'N') ,NVL(A.BOUNCED_ST\
ATUS_IND,'N') ,A.NARRATION ,TO_CHAR(NVL(A.CANCELLED_DATE,SYSDATE),'DD/MM/YYY\
Y') ,TO_CHAR(NVL(A.BOUNCED_DATE,SYSDATE),'DD/MM/YYYY') ,TO_CHAR(NVL(A.BOUNCE\
D_STATUS_DATE,SYSDATE),'DD/MM/YYYY') ,A.DR_MAIN_ACC1_CODE ,A.DR_MAIN_ACC2_CO\
DE ,A.DR_DEPT_CODE ,A.DR_PRODUCT_GROUP_CODE ,A.DR_PRODUCT_LINE_CODE ,A.DR_SU\
BLEDGER_GROUP_CODE ,A.DR_SUBLEDGER_LINE_CODE ,A.CR_MAIN_ACC1_CODE ,A.CR_MAIN\
_ACC2_CODE ,A.CR_DEPT_CODE ,A.CR_PRODUCT_GROUP_CODE ,A.CR_PRODUCT_LINE_CODE \
,A.CR_SUBLEDGER_GROUP_CODE ,A.CR_SUBLEDGER_LINE_CODE ,A.CASH_CTRL_DOC_TYPE_C\
ODE ,A.CASH_CTRL_DOC_NUMBER ,A.CASH_CTRL_DOC_DATE ,A.SHIFT_ID ,A.CASH_COUNTE\
R_CODE ,NVL(A.CONSOLIDATED_RECEIPT_YN,B.CONSOLIDATED_RECEIPT_YN) ,B.BILL_DOC\
_TYPE_CODE ,B.BILL_DOC_NUMBER  from BL_CANCELLED_BOUNCED_TRX A ,BL_RECEIPT_R\
EFUND_HDRDTL_VW B where (((((((B.OPERATING_FACILITY_ID=:b0 and A.DOC_TYPE_CO\
DE=B.DOC_TYPE_CODE) and A.DOC_NUMBER=B.DOC_");
    sqlbuft((void **)0, 
      "NUMBER) and A.DOC_SRNO=B.DOC_SRNO) and A.ADDED_DATE<=to_date((:b1||'2\
35959'),'YYYYMMDDHH24MISS')) and NVL(A.POSTED_IND,'N')<>'Y') and A.OPERATING\
_FACILITY_ID=B.OPERATING_FACILITY_ID) and NVL(A.CONSOLIDATED_RECEIPT_YN,'N')\
='N') union all select B.rowid  ,A.RECPT_REFUND_IND ,B.DOC_TYPE_CODE ,B.DOC_\
NUMBER ,B.DOC_SRNO ,NVL(A.CANCELLED_IND,'N') ,NVL(A.BOUNCED_YN,'N') ,NVL(A.B\
OUNCED_STATUS_IND,'N') ,A.NARRATION ,TO_CHAR(NVL(A.CANCELLED_DATE,SYSDATE),'\
DD/MM/YYYY') ,TO_CHAR(NVL(A.BOUNCED_DATE,SYSDATE),'DD/MM/YYYY') ,TO_CHAR(NVL\
(A.BOUNCED_STATUS_DATE,SYSDATE),'DD/MM/YYYY') ,A.DR_MAIN_ACC1_CODE ,A.DR_MAI\
N_ACC2_CODE ,A.DR_DEPT_CODE ,A.DR_PRODUCT_GROUP_CODE ,A.DR_PRODUCT_LINE_CODE\
 ,A.DR_SUBLEDGER_GROUP_CODE ,A.DR_SUBLEDGER_LINE_CODE ,A.CR_MAIN_ACC1_CODE ,\
A.CR_MAIN_ACC2_CODE ,A.CR_DEPT_CODE ,A.CR_PRODUCT_GROUP_CODE ,A.CR_PRODUCT_L\
INE_CODE ,A.CR_SUBLEDGER_GROUP_CODE ,A.CR_SUBLEDGER_LINE_CODE ,A.CASH_CTRL_D\
OC_TYPE_CODE ,A.CASH_CTRL_DOC_NUMBER ,A.CASH_CTRL_DOC_DATE ,A.SHIFT_ID ,A.CA\
SH_COUNTER_CODE ,NVL(A.CONSOLIDATED_RECEIPT");
    sqlstm.stmt = sq0029;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4093;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_tmp_date;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_tmp_date;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	err_mesg("OPEN failed on cursor CANCEL_TRX_CUR",0,"");

}

fetch_cancelled_trx()
{
    c_trx_rowid.arr[0] = '\0';
    c_recpt_refund_ind.arr[0]  = '\0';
    c_doc_type_code.arr[0]  = '\0';
    c_doc_number.arr[0]  = '\0';
	c_doc_srno.arr[0]  = '\0';
    c_cancelled_ind.arr[0]  = '\0';
    c_bounced_yn.arr[0]  = '\0';
    c_bounced_status_ind.arr[0]  = '\0';
    c_narration.arr[0]  = '\0';
    c_cancelled_date.arr[0]  = '\0';
    c_bounced_date.arr[0]  = '\0';
    c_bounced_status_date.arr[0]  = '\0';
    c_cons_rec_yn.arr[0] = '\0';
    c_bill_doc_type_code.arr[0] = '\0';
    c_bill_doc_num.arr[0] = '\0';
    

    dr_main_acc1_code.arr[0]  = '\0';
    dr_main_acc2_code.arr[0]  = '\0';
    dr_dept_code.arr[0]  = '\0';
    dr_subledger_group_code.arr[0]  = '\0';
    dr_subledger_line_code.arr[0]  = '\0';
    dr_product_group_code.arr[0]  = '\0';
    dr_product_line_code.arr[0]  = '\0';
    cr_main_acc1_code.arr[0]  = '\0';
    cr_main_acc2_code.arr[0]  = '\0';
    cr_dept_code.arr[0]  = '\0';
    cr_subledger_group_code.arr[0]  = '\0';
    cr_subledger_line_code.arr[0]  = '\0';
    cr_product_group_code.arr[0]  = '\0';
    cr_product_line_code.arr[0]  = '\0';

    nd_doc_type.arr[0]				     = '\0';
    nd_doc_num.arr[0]				     = '\0';
    nd_doc_date.arr[0]		              	     = '\0';
    recref_cash_counter_code.arr[0]             = '\0';
    recref_shift_id.arr[0]                             = '\0';

    dr_main_acc1_code.len     = 0;
    dr_main_acc2_code.len     = 0;
    dr_dept_code.len     = 0;
    dr_subledger_group_code.len     = 0;
    dr_subledger_line_code.len     = 0;
    dr_product_group_code.len     = 0;
    dr_product_line_code.len     = 0;
    cr_main_acc1_code.len     = 0;
    cr_main_acc2_code.len     = 0;
    cr_dept_code.len     = 0;
    cr_subledger_group_code.len     = 0;
    cr_subledger_line_code.len     = 0;
    cr_product_group_code.len     = 0;
    cr_product_line_code.len     = 0;
    c_trx_rowid.len = 0;
    c_recpt_refund_ind.len     = 0;
    c_doc_type_code.len     = 0;
    c_doc_number.len     = 0;
	c_doc_srno.len     = 0;
    c_cancelled_ind.len     = 0;
    c_bounced_yn.len     = 0;
    c_bounced_status_ind.len     = 0;
    c_narration.len     = 0;
    c_cancelled_date.len     = 0;
    c_bounced_date.len     = 0;
    c_bounced_status_date.len     = 0;
    c_cons_rec_yn.len = 0;
    c_bill_doc_type_code.len = 0;
    c_bill_doc_num.len = 0;

   nd_doc_type.len = 0;
   nd_doc_num.len = 0;
   nd_doc_date.len = 0;
   recref_cash_counter_code.len=0;
   recref_shift_id.len=0;
    
    /* EXEC SQL FETCH CANCEL_TRX_CUR 
	     INTO  :c_trx_rowid,
		   :c_recpt_refund_ind,
                   :c_doc_type_code,
                   :c_doc_number,
				   :c_doc_srno,
                   :c_cancelled_ind,
                   :c_bounced_yn,
                   :c_bounced_status_ind,
                   :c_narration,
                   :c_cancelled_date,
                   :c_bounced_date,
                   :c_bounced_status_date,
                   :dr_main_acc1_code,
                   :dr_main_acc2_code,
                   :dr_dept_code,
                   :dr_product_group_code,
                   :dr_product_line_code,
                   :dr_subledger_group_code,
                   :dr_subledger_line_code,
                   :cr_main_acc1_code,
                   :cr_main_acc2_code,
                   :cr_dept_code,
                   :cr_product_group_code,
                   :cr_product_line_code,
                   :cr_subledger_group_code,
                   :cr_subledger_line_code,
		   :nd_doc_type,
		   :nd_doc_num,
		   :nd_doc_date,
                   :recref_shift_id,
		   :recref_cash_counter_code,
		   :c_cons_rec_yn,
		   :c_bill_doc_type_code,
		   :c_bill_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4124;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&c_trx_rowid;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&c_recpt_refund_ind;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&c_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&c_doc_number;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&c_doc_srno;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&c_cancelled_ind;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&c_bounced_yn;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&c_bounced_status_ind;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&c_narration;
    sqlstm.sqhstl[8] = (unsigned int  )53;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&c_cancelled_date;
    sqlstm.sqhstl[9] = (unsigned int  )15;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&c_bounced_date;
    sqlstm.sqhstl[10] = (unsigned int  )15;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&c_bounced_status_date;
    sqlstm.sqhstl[11] = (unsigned int  )15;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&dr_main_acc1_code;
    sqlstm.sqhstl[12] = (unsigned int  )9;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&dr_main_acc2_code;
    sqlstm.sqhstl[13] = (unsigned int  )7;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&dr_dept_code;
    sqlstm.sqhstl[14] = (unsigned int  )13;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&dr_product_group_code;
    sqlstm.sqhstl[15] = (unsigned int  )6;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&dr_product_line_code;
    sqlstm.sqhstl[16] = (unsigned int  )7;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&dr_subledger_group_code;
    sqlstm.sqhstl[17] = (unsigned int  )6;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&dr_subledger_line_code;
    sqlstm.sqhstl[18] = (unsigned int  )11;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&cr_main_acc1_code;
    sqlstm.sqhstl[19] = (unsigned int  )9;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&cr_main_acc2_code;
    sqlstm.sqhstl[20] = (unsigned int  )7;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&cr_dept_code;
    sqlstm.sqhstl[21] = (unsigned int  )13;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&cr_product_group_code;
    sqlstm.sqhstl[22] = (unsigned int  )6;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&cr_product_line_code;
    sqlstm.sqhstl[23] = (unsigned int  )7;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&cr_subledger_group_code;
    sqlstm.sqhstl[24] = (unsigned int  )6;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&cr_subledger_line_code;
    sqlstm.sqhstl[25] = (unsigned int  )11;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&nd_doc_type;
    sqlstm.sqhstl[26] = (unsigned int  )9;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&nd_doc_num;
    sqlstm.sqhstl[27] = (unsigned int  )37;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&nd_doc_date;
    sqlstm.sqhstl[28] = (unsigned int  )32;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&recref_shift_id;
    sqlstm.sqhstl[29] = (unsigned int  )4;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&recref_cash_counter_code;
    sqlstm.sqhstl[30] = (unsigned int  )9;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&c_cons_rec_yn;
    sqlstm.sqhstl[31] = (unsigned int  )4;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&c_bill_doc_type_code;
    sqlstm.sqhstl[32] = (unsigned int  )9;
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&c_bill_doc_num;
    sqlstm.sqhstl[33] = (unsigned int  )11;
    sqlstm.sqhsts[33] = (         int  )0;
    sqlstm.sqindv[33] = (         void  *)0;
    sqlstm.sqinds[33] = (         int  )0;
    sqlstm.sqharm[33] = (unsigned int  )0;
    sqlstm.sqadto[33] = (unsigned short )0;
    sqlstm.sqtdso[33] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if(OERROR)
	err_mesg("FETCH failed on table CANCEL_TRX_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    c_trx_rowid.arr[c_trx_rowid.len] = '\0';
    c_recpt_refund_ind.arr[c_recpt_refund_ind.len]  = '\0';
    c_doc_type_code.arr[c_doc_type_code.len]  = '\0';
    c_doc_number.arr[c_doc_number.len]  = '\0';
	c_doc_srno.arr[c_doc_srno.len]  = '\0';
    c_cancelled_ind.arr[c_cancelled_ind.len]  = '\0';
    c_bounced_yn.arr[c_bounced_yn.len]  = '\0';
    c_bounced_status_ind.arr[c_bounced_status_ind.len]  = '\0';
    c_narration.arr[c_narration.len]  = '\0';
    c_cancelled_date.arr[c_cancelled_date.len]  = '\0';
    c_bounced_date.arr[c_bounced_date.len]  = '\0';
    c_bounced_status_date.arr[c_bounced_status_date.len]  = '\0';
    dr_main_acc1_code.arr[dr_main_acc1_code.len]  = '\0';
    dr_main_acc2_code.arr[dr_main_acc2_code.len]  = '\0';
    dr_dept_code.arr[dr_dept_code.len]  = '\0';
    dr_subledger_group_code.arr[dr_subledger_group_code.len]  = '\0';
    dr_subledger_line_code.arr[dr_subledger_line_code.len]  = '\0';
    dr_product_group_code.arr[dr_product_group_code.len]  = '\0';
    dr_product_line_code.arr[dr_product_line_code.len]  = '\0';
    cr_main_acc1_code.arr[cr_main_acc1_code.len]  = '\0';
    cr_main_acc2_code.arr[cr_main_acc2_code.len]  = '\0';
    cr_dept_code.arr[cr_dept_code.len]  = '\0';
    cr_subledger_group_code.arr[cr_subledger_group_code.len]    = '\0';
    cr_subledger_line_code.arr[cr_subledger_line_code.len]          = '\0';
    cr_product_group_code.arr[cr_product_group_code.len]         = '\0';
    cr_product_line_code.arr[cr_product_line_code.len]               = '\0';
    nd_doc_type.arr[nd_doc_type.len]	                                = '\0';
    nd_doc_num.arr[nd_doc_num.len]	                                = '\0';
    nd_doc_date.arr[nd_doc_date.len]	                                = '\0';
    recref_cash_counter_code.arr[recref_cash_counter_code.len] ='\0';
    recref_shift_id.arr[recref_shift_id.len]='\0';
    c_cons_rec_yn.arr[c_cons_rec_yn.len] = '\0';
    c_bill_doc_type_code.arr[c_bill_doc_type_code.len] = '\0';
    c_bill_doc_num.arr[c_bill_doc_num.len] = '\0';


    return 1;

}

open_cancelled_bill()
{

    /* EXEC SQL OPEN CANCEL_BILL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0030;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4275;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_date;
    sqlstm.sqhstl[1] = (unsigned int  )15;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	err_mesg("OPEN failed on cursor CANCEL_BILL_CUR",0,"");

}

fetch_cancelled_bill()
{
    c_trx_rowid.arr[0] = '\0';
    c_doc_type_code.arr[0]  = '\0';
    c_doc_number.arr[0]  = '\0';
    c_post_date.arr[0]  = '\0';
    nd_doc_type.arr[0]	= '\0';
    nd_doc_num.arr[0]	= '\0';
    nd_doc_date.arr[0]	= '\0';
    recref_cash_counter_code.arr[0]='\0';
    recref_shift_id.arr[0]='\0';


    c_trx_rowid.len		= 0;
    c_doc_type_code.len = 0;
    c_doc_number.len    = 0;
    c_post_date.len     = 0;
    nd_doc_type.len = 0;
    nd_doc_num.len = 0;
    nd_doc_date.len = 0;
	recref_cash_counter_code.len=0;
	recref_shift_id.len=0;

    
    /* EXEC SQL FETCH CANCEL_BILL_CUR 
	     INTO  :c_trx_rowid,
		       :c_doc_type_code,
               :c_doc_number,
			   :c_post_date,
		       :nd_doc_type,
			  :nd_doc_num,
			  :nd_doc_date,
			  :recref_shift_id,
			  :recref_cash_counter_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4298;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&c_trx_rowid;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&c_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&c_doc_number;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&c_post_date;
    sqlstm.sqhstl[3] = (unsigned int  )15;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_doc_type;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_doc_num;
    sqlstm.sqhstl[5] = (unsigned int  )37;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_doc_date;
    sqlstm.sqhstl[6] = (unsigned int  )32;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&recref_shift_id;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&recref_cash_counter_code;
    sqlstm.sqhstl[8] = (unsigned int  )9;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
		err_mesg("FETCH failed on table CANCEL_BILL_CUR",0,"");

    if(NO_DATA_FOUND)
		return 0;

    c_trx_rowid.arr[c_trx_rowid.len] = '\0';
    c_doc_type_code.arr[c_doc_type_code.len]  = '\0';
    c_doc_number.arr[c_doc_number.len]  = '\0';
	c_doc_srno.arr[c_doc_srno.len] = '\0';
    c_post_date.arr[c_post_date.len]  = '\0';

	nd_doc_type.arr[nd_doc_type.len]	                            = '\0';
    nd_doc_num.arr[nd_doc_num.len]	                                = '\0';
    nd_doc_date.arr[nd_doc_date.len]	                            = '\0';
	recref_cash_counter_code.arr[recref_cash_counter_code.len]='\0';
	recref_shift_id.arr[recref_shift_id.len]='\0';


    return 1;

}

fetch_rec_ref_trx()
{
   recref_rowid.arr[0]                = '\0';
   recref_recpt_refund_ind.arr[0]     = '\0';
   recref_doc_type_code.arr[0]        = '\0';
   recref_doc_number.arr[0]           = '\0';
   recref_doc_srno.arr[0]             = '\0';
   recref_trx_type_code.arr[0]        = '\0';
   recref_recpt_nature_code.arr[0]    = '\0';
   recref_debtor_category_code.arr[0] = '\0';
   recref_doc_date.arr[0]             = '\0';
   recref_post_month.arr[0]           = '\0';
   recref_post_year.arr[0]            = '\0';
   recref_trx_date_time.arr[0]        = '\0';
   recref_episode_type.arr[0]         = '\0';
   recref_patient_id.arr[0]           = '\0';
   recref_episode_id.arr[0]           = '\0';
   recref_visit_id.arr[0]             = '\0';
   recref_bill_doc_type_code.arr[0]   = '\0';
   recref_bill_doc_number.arr[0]      = '\0';
   recref_customer_code.arr[0]        = '\0';
   recref_cash_counter_code.arr[0]    = '\0';
   recref_shift_id.arr[0]             = '\0';
   recref_doc_amt.arr[0]              = '\0';
   recref_doc_amt_negative.arr[0]     = '\0';
   recref_recpt_type_code.arr[0]      = '\0';
   recref_slmt_type_code .arr[0]      = '\0';
   recref_slmt_doc_ref_desc.arr[0]    = '\0';
   recref_slmt_doc_ref_date.arr[0]    = '\0';
   recref_slmt_doc_remarks.arr[0]     = '\0';
   recref_bank_recon_ref .arr[0]      = '\0';
   recref_print_flag.arr[0]           = '\0';
   recref_cancelled_ind.arr[0]        = '\0';
   recref_posted_ind.arr[0]           = '\0';
   recref_narration.arr[0]            = '\0';
   recref_cons_receipt_yn.arr[0]      = '\0';

   recref_rowid.len                   = 0;
   recref_recpt_refund_ind.len        = 0;
   recref_doc_type_code.len           = 0;
   recref_doc_number.len              = 0;
   recref_doc_srno.len                = 0;
   recref_trx_type_code.len           = 0;
   recref_recpt_nature_code.len       = 0;
   recref_debtor_category_code.len    = 0;
   recref_doc_date.len                = 0;
   recref_post_month.len              = 0;
   recref_post_year.len               = 0;
   recref_trx_date_time.len           = 0;
   recref_episode_type.len            = 0;
   recref_patient_id.len              = 0;
   recref_episode_id.len              = 0;
   recref_visit_id.len                = 0;
   recref_bill_doc_type_code.len      = 0;
   recref_bill_doc_number.len         = 0;
   recref_customer_code.len           = 0;
   recref_cash_counter_code.len       = 0;
   recref_shift_id.len                = 0;
   recref_doc_amt.len                 = 0;
   recref_doc_amt_negative.len        = 0;
   recref_recpt_type_code.len         = 0;
   recref_slmt_type_code .len         = 0;
   recref_slmt_doc_ref_desc.len       = 0;
   recref_slmt_doc_ref_date.len       = 0;
   recref_slmt_doc_remarks.len        = 0;
   recref_bank_recon_ref .len         = 0;
   recref_print_flag.len              = 0;
   recref_cancelled_ind.len           = 0;
   recref_posted_ind.len              = 0;
   recref_narration.len               = 0;
   recref_cons_receipt_yn.len         = 0;

   if (strcmp(c_cons_rec_yn.arr,"Y") == 0)
   {
	/* EXEC SQL SELECT 
	     A.ROWID,
             D.RECPT_REFUND_IND,
             B.DOC_TYPE_CODE,
             B.DOC_NUMBER,
             B.DOC_SRNO,
             A.TRX_TYPE_CODE,
             A.RECPT_NATURE_CODE,
             A.DEBTOR_CATEGORY_CODE,
	     TO_CHAR(D.DOC_DATE,'DD/MM/YYYY'),
             D.POST_MONTH,
             D.POST_YEAR,
             D.TRX_DATE_TIME,
             A.EPISODE_TYPE,
             A.PATIENT_ID,
             NVL(A.EPISODE_ID,0),
             NVL(A.VISIT_ID,1),
             B.BILL_DOC_TYPE_CODE,
             B.BILL_DOC_NUM,
             D.CUSTOMER_CODE,
             D.CASH_COUNTER_CODE,
             D.SHIFT_ID,
             DECODE(:amt_sign_ind,1,A.SETTLED_AMT, -A.SETTLED_AMT),
             DECODE(:amt_sign_ind,1,-A.SETTLED_AMT,A.SETTLED_AMT),
             A.RECPT_TYPE_CODE,
             D.SLMT_TYPE_CODE,
             D.SLMT_DOC_REF_DESC,
             TO_CHAR(D.SLMT_DOC_REF_DATE,'DD/MM/YYYY'),
             D.SLMT_DOC_REMARKS,
             D.BANK_RECON_REF,
             NVL(D.PRINT_FLAG,'N'),
             NVL(D.CANCELLED_IND,'N'),
             NVL(A.POSTED_IND,'N'),
             D.NARRATION,
	     NVL(D.CONSOLIDATED_RECEIPT_YN,'N')	
    INTO     :recref_rowid,
             :recref_recpt_refund_ind,
             :recref_doc_type_code,
             :recref_doc_number,
			 :recref_doc_srno,
             :recref_trx_type_code,
             :recref_recpt_nature_code,
             :recref_debtor_category_code,
             :recref_doc_date,
             :recref_post_month,
             :recref_post_year,
             :recref_trx_date_time,
             :recref_episode_type,
             :recref_patient_id,
             :recref_episode_id,
             :recref_visit_id,
             :recref_bill_doc_type_code,
             :recref_bill_doc_number,
             :recref_customer_code,
             :recref_cash_counter_code,
             :recref_shift_id,
             :recref_doc_amt,
             :recref_doc_amt_negative,
             :recref_recpt_type_code,
             :recref_slmt_type_code ,
             :recref_slmt_doc_ref_desc,
             :recref_slmt_doc_ref_date,
             :recref_slmt_doc_remarks,
             :recref_bank_recon_ref ,
             :recref_print_flag,
             :recref_cancelled_ind,
             :recref_posted_ind,
             :recref_narration,
	     :recref_cons_receipt_yn
    FROM  BL_BILLS_FOR_CONS_RECEIPT A, BL_BILLS_FOR_CONS_RCPT_CANC B,
          BL_CANCELLED_BOUNCED_TRX C, BL_RECEIPT_REFUND_HDRDTL_VW D			/o Modified to HDRDTL_VW o/
    WHERE B.OPERATING_FACILITY_ID = :nd_operating_facility_id
    AND B.DOC_TYPE_CODE = :c_doc_type_code
    AND B.DOC_NUMBER    = :c_doc_number
	AND B.DOC_SRNO      = :c_doc_srno
	AND B.BILL_DOC_TYPE_CODE = :c_bill_doc_type_code
    AND B.BILL_DOC_NUM = :c_bill_doc_num
    AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
    AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE
    AND A.DOC_NUMBER = B.DOC_NUMBER
	AND A.DOC_SRNO   = B.DOC_SRNO
    AND A.BILL_DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE
    AND A.BILL_DOC_NUM= B.BILL_DOC_NUM
    AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
    AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE
    AND A.DOC_NUMBER = C.DOC_NUMBER
	AND A.DOC_SRNO   = C.DOC_SRNO
    AND C.OPERATING_FACILITY_ID = D.OPERATING_FACILITY_ID
    AND C.DOC_TYPE_CODE = D.DOC_TYPE_CODE
    AND C.DOC_NUMBER = D.DOC_NUMBER
	AND C.DOC_SRNO   = D.DOC_SRNO; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 42;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select A.rowid  ,D.RECPT_REFUND_IND ,B.DOC_TYPE_CODE ,B.DOC_NUMBER ,B.DO\
C_SRNO ,A.TRX_TYPE_CODE ,A.RECPT_NATURE_CODE ,A.DEBTOR_CATEGORY_CODE ,TO_CHA\
R(D.DOC_DATE,'DD/MM/YYYY') ,D.POST_MONTH ,D.POST_YEAR ,D.TRX_DATE_TIME ,A.EP\
ISODE_TYPE ,A.PATIENT_ID ,NVL(A.EPISODE_ID,0) ,NVL(A.VISIT_ID,1) ,B.BILL_DOC\
_TYPE_CODE ,B.BILL_DOC_NUM ,D.CUSTOMER_CODE ,D.CASH_COUNTER_CODE ,D.SHIFT_ID\
 ,DECODE(:b0,1,A.SETTLED_AMT,(-A.SETTLED_AMT)) ,DECODE(:b0,1,(-A.SETTLED_AMT\
),A.SETTLED_AMT) ,A.RECPT_TYPE_CODE ,D.SLMT_TYPE_CODE ,D.SLMT_DOC_REF_DESC ,\
TO_CHAR(D.SLMT_DOC_REF_DATE,'DD/MM/YYYY') ,D.SLMT_DOC_REMARKS ,D.BANK_RECON_\
REF ,NVL(D.PRINT_FLAG,'N') ,NVL(D.CANCELLED_IND,'N') ,NVL(A.POSTED_IND,'N') \
,D.NARRATION ,NVL(D.CONSOLIDATED_RECEIPT_YN,'N') into :b2,:b3,:b4,:b5,:b6,:b\
7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19,:b20,:b21,:b22,:\
b23,:b24,:b25,:b26,:b27,:b28,:b29,:b30,:b31,:b32,:b33,:b34,:b35  from BL_BIL\
LS_FOR_CONS_RECEIPT A ,BL_BILLS_FOR_CONS_RCPT_CANC B ,BL_CANCELLED_BOUNCED_T\
RX C ,BL_RECEIPT_REFUND_HDRDTL_VW D wher");
 sqlstm.stmt = "e (((((((((((((((((((B.OPERATING_FACILITY_ID=:b36 and B.DOC_\
TYPE_CODE=:b37) and B.DOC_NUMBER=:b38) and B.DOC_SRNO=:b39) and B.BILL_DOC_TYP\
E_CODE=:b40) and B.BILL_DOC_NUM=:b41) and A.OPERATING_FACILITY_ID=B.OPERATING_\
FACILITY_ID) and A.DOC_TYPE_CODE=B.DOC_TYPE_CODE) and A.DOC_NUMBER=B.DOC_NUMBE\
R) and A.DOC_SRNO=B.DOC_SRNO) and A.BILL_DOC_TYPE_CODE=B.BILL_DOC_TYPE_CODE) a\
nd A.BILL_DOC_NUM=B.BILL_DOC_NUM) and A.OPERATING_FACILITY_ID=C.OPERATING_FACI\
LITY_ID) and A.DOC_TYPE_CODE=C.DOC_TYPE_CODE) and A.DOC_NUMBER=C.DOC_NUMBER) a\
nd A.DOC_SRNO=C.DOC_SRNO) and C.OPERATING_FACILITY_ID=D.OPERATING_FACILITY_ID)\
 and C.DOC_TYPE_CODE=D.DOC_TYPE_CODE) and C.DOC_NUMBER=D.DOC_NUMBER) and C.DOC\
_SRNO=D.DOC_SRNO)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4349;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&amt_sign_ind;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&amt_sign_ind;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&recref_rowid;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&recref_recpt_refund_ind;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&recref_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&recref_doc_number;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&recref_doc_srno;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&recref_trx_type_code;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&recref_recpt_nature_code;
 sqlstm.sqhstl[8] = (unsigned int  )5;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&recref_debtor_category_code;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&recref_doc_date;
 sqlstm.sqhstl[10] = (unsigned int  )15;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&recref_post_month;
 sqlstm.sqhstl[11] = (unsigned int  )5;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&recref_post_year;
 sqlstm.sqhstl[12] = (unsigned int  )7;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&recref_trx_date_time;
 sqlstm.sqhstl[13] = (unsigned int  )14;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&recref_episode_type;
 sqlstm.sqhstl[14] = (unsigned int  )4;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&recref_patient_id;
 sqlstm.sqhstl[15] = (unsigned int  )23;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&recref_episode_id;
 sqlstm.sqhstl[16] = (unsigned int  )11;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&recref_visit_id;
 sqlstm.sqhstl[17] = (unsigned int  )7;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&recref_bill_doc_type_code;
 sqlstm.sqhstl[18] = (unsigned int  )9;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&recref_bill_doc_number;
 sqlstm.sqhstl[19] = (unsigned int  )11;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&recref_customer_code;
 sqlstm.sqhstl[20] = (unsigned int  )11;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&recref_cash_counter_code;
 sqlstm.sqhstl[21] = (unsigned int  )9;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&recref_shift_id;
 sqlstm.sqhstl[22] = (unsigned int  )4;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&recref_doc_amt;
 sqlstm.sqhstl[23] = (unsigned int  )23;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&recref_doc_amt_negative;
 sqlstm.sqhstl[24] = (unsigned int  )23;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&recref_recpt_type_code;
 sqlstm.sqhstl[25] = (unsigned int  )6;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&recref_slmt_type_code;
 sqlstm.sqhstl[26] = (unsigned int  )5;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&recref_slmt_doc_ref_desc;
 sqlstm.sqhstl[27] = (unsigned int  )23;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&recref_slmt_doc_ref_date;
 sqlstm.sqhstl[28] = (unsigned int  )15;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&recref_slmt_doc_remarks;
 sqlstm.sqhstl[29] = (unsigned int  )33;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&recref_bank_recon_ref;
 sqlstm.sqhstl[30] = (unsigned int  )13;
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&recref_print_flag;
 sqlstm.sqhstl[31] = (unsigned int  )4;
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&recref_cancelled_ind;
 sqlstm.sqhstl[32] = (unsigned int  )4;
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&recref_posted_ind;
 sqlstm.sqhstl[33] = (unsigned int  )4;
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&recref_narration;
 sqlstm.sqhstl[34] = (unsigned int  )53;
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&recref_cons_receipt_yn;
 sqlstm.sqhstl[35] = (unsigned int  )4;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[36] = (unsigned int  )5;
 sqlstm.sqhsts[36] = (         int  )0;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)&c_doc_type_code;
 sqlstm.sqhstl[37] = (unsigned int  )9;
 sqlstm.sqhsts[37] = (         int  )0;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)&c_doc_number;
 sqlstm.sqhstl[38] = (unsigned int  )11;
 sqlstm.sqhsts[38] = (         int  )0;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)&c_doc_srno;
 sqlstm.sqhstl[39] = (unsigned int  )7;
 sqlstm.sqhsts[39] = (         int  )0;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqhstv[40] = (         void  *)&c_bill_doc_type_code;
 sqlstm.sqhstl[40] = (unsigned int  )9;
 sqlstm.sqhsts[40] = (         int  )0;
 sqlstm.sqindv[40] = (         void  *)0;
 sqlstm.sqinds[40] = (         int  )0;
 sqlstm.sqharm[40] = (unsigned int  )0;
 sqlstm.sqadto[40] = (unsigned short )0;
 sqlstm.sqtdso[40] = (unsigned short )0;
 sqlstm.sqhstv[41] = (         void  *)&c_bill_doc_num;
 sqlstm.sqhstl[41] = (unsigned int  )11;
 sqlstm.sqhsts[41] = (         int  )0;
 sqlstm.sqindv[41] = (         void  *)0;
 sqlstm.sqinds[41] = (         int  )0;
 sqlstm.sqharm[41] = (unsigned int  )0;
 sqlstm.sqadto[41] = (unsigned short )0;
 sqlstm.sqtdso[41] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
      err_mesg("SELECT failed on BL_BILLS_FOR_CONS_RECEIPT",0,"");

    if(NO_DATA_FOUND)
    {  
	sprintf(string_var,"Record - %s/%s not found in BL_BILLS_FOR_CONS_RECEIPT",c_doc_type_code.arr,c_doc_number.arr);
	err_mesg(string_var,0,"");
    }   
}
else
{
	/* EXEC SQL SELECT 
	     ROWID,
             RECPT_REFUND_IND,
             DOC_TYPE_CODE,
             DOC_NUMBER,
			 DOC_SRNO,
             TRX_TYPE_CODE,
             RECPT_NATURE_CODE,
             DEBTOR_CATEGORY_CODE,
	     TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
             POST_MONTH,
             POST_YEAR,
             TRX_DATE_TIME,
             EPISODE_TYPE,
             PATIENT_ID,
             NVL(EPISODE_ID,0),
             NVL(VISIT_ID,1),
             BILL_DOC_TYPE_CODE,
             BILL_DOC_NUMBER,
             CUSTOMER_CODE,
             CASH_COUNTER_CODE,
             SHIFT_ID,
             DECODE(:amt_sign_ind,1,DOC_AMT, -DOC_AMT),
             DECODE(:amt_sign_ind,1,-DOC_AMT, DOC_AMT),
             RECPT_TYPE_CODE,
             SLMT_TYPE_CODE,
             SLMT_DOC_REF_DESC,
             TO_CHAR(SLMT_DOC_REF_DATE,'DD/MM/YYYY'),
             SLMT_DOC_REMARKS,
             BANK_RECON_REF,
             NVL(PRINT_FLAG,'N'),
             NVL(CANCELLED_IND,'N'),
             NVL(POSTED_IND,'N'),
             NARRATION,
	     NVL(CONSOLIDATED_RECEIPT_YN,'N')
    INTO     :recref_rowid,
             :recref_recpt_refund_ind,
             :recref_doc_type_code,
             :recref_doc_number,
			 :recref_doc_srno,
             :recref_trx_type_code,
             :recref_recpt_nature_code,
             :recref_debtor_category_code,
             :recref_doc_date,
             :recref_post_month,
             :recref_post_year,
             :recref_trx_date_time,
             :recref_episode_type,
             :recref_patient_id,
             :recref_episode_id,
             :recref_visit_id,
             :recref_bill_doc_type_code,
             :recref_bill_doc_number,
             :recref_customer_code,
             :recref_cash_counter_code,
             :recref_shift_id,
             :recref_doc_amt,
             :recref_doc_amt_negative,
             :recref_recpt_type_code,
             :recref_slmt_type_code ,
             :recref_slmt_doc_ref_desc,
             :recref_slmt_doc_ref_date,
             :recref_slmt_doc_remarks,
             :recref_bank_recon_ref ,
             :recref_print_flag,
             :recref_cancelled_ind,
             :recref_posted_ind,
             :recref_narration,
	     :recref_cons_receipt_yn
    FROM  BL_RECEIPT_REFUND_HDRDTL_VW
    WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
    AND DOC_TYPE_CODE = :c_doc_type_code
    AND DOC_NUMBER    = :c_doc_number
	AND DOC_SRNO      = :c_doc_srno; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 42;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ROWID ,RECPT_REFUND_IND ,DOC_TYPE_CODE ,DOC_NUMBER ,D\
OC_SRNO ,TRX_TYPE_CODE ,RECPT_NATURE_CODE ,DEBTOR_CATEGORY_CODE ,TO_CHAR(DOC_D\
ATE,'DD/MM/YYYY') ,POST_MONTH ,POST_YEAR ,TRX_DATE_TIME ,EPISODE_TYPE ,PATIENT\
_ID ,NVL(EPISODE_ID,0) ,NVL(VISIT_ID,1) ,BILL_DOC_TYPE_CODE ,BILL_DOC_NUMBER ,\
CUSTOMER_CODE ,CASH_COUNTER_CODE ,SHIFT_ID ,DECODE(:b0,1,DOC_AMT,(-DOC_AMT)) ,\
DECODE(:b0,1,(-DOC_AMT),DOC_AMT) ,RECPT_TYPE_CODE ,SLMT_TYPE_CODE ,SLMT_DOC_RE\
F_DESC ,TO_CHAR(SLMT_DOC_REF_DATE,'DD/MM/YYYY') ,SLMT_DOC_REMARKS ,BANK_RECON_\
REF ,NVL(PRINT_FLAG,'N') ,NVL(CANCELLED_IND,'N') ,NVL(POSTED_IND,'N') ,NARRATI\
ON ,NVL(CONSOLIDATED_RECEIPT_YN,'N') into :b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10\
,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19,:b20,:b21,:b22,:b23,:b24,:b25,:b\
26,:b27,:b28,:b29,:b30,:b31,:b32,:b33,:b34,:b35  from BL_RECEIPT_REFUND_HDRDTL\
_VW where (((OPERATING_FACILITY_ID=:b36 and DOC_TYPE_CODE=:b37) and DOC_NUMBER\
=:b38) and DOC_SRNO=:b39)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4532;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&amt_sign_ind;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&amt_sign_ind;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&recref_rowid;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&recref_recpt_refund_ind;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&recref_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&recref_doc_number;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&recref_doc_srno;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&recref_trx_type_code;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&recref_recpt_nature_code;
 sqlstm.sqhstl[8] = (unsigned int  )5;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&recref_debtor_category_code;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&recref_doc_date;
 sqlstm.sqhstl[10] = (unsigned int  )15;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&recref_post_month;
 sqlstm.sqhstl[11] = (unsigned int  )5;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&recref_post_year;
 sqlstm.sqhstl[12] = (unsigned int  )7;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&recref_trx_date_time;
 sqlstm.sqhstl[13] = (unsigned int  )14;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&recref_episode_type;
 sqlstm.sqhstl[14] = (unsigned int  )4;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&recref_patient_id;
 sqlstm.sqhstl[15] = (unsigned int  )23;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&recref_episode_id;
 sqlstm.sqhstl[16] = (unsigned int  )11;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&recref_visit_id;
 sqlstm.sqhstl[17] = (unsigned int  )7;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&recref_bill_doc_type_code;
 sqlstm.sqhstl[18] = (unsigned int  )9;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&recref_bill_doc_number;
 sqlstm.sqhstl[19] = (unsigned int  )11;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&recref_customer_code;
 sqlstm.sqhstl[20] = (unsigned int  )11;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&recref_cash_counter_code;
 sqlstm.sqhstl[21] = (unsigned int  )9;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&recref_shift_id;
 sqlstm.sqhstl[22] = (unsigned int  )4;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&recref_doc_amt;
 sqlstm.sqhstl[23] = (unsigned int  )23;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&recref_doc_amt_negative;
 sqlstm.sqhstl[24] = (unsigned int  )23;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&recref_recpt_type_code;
 sqlstm.sqhstl[25] = (unsigned int  )6;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&recref_slmt_type_code;
 sqlstm.sqhstl[26] = (unsigned int  )5;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&recref_slmt_doc_ref_desc;
 sqlstm.sqhstl[27] = (unsigned int  )23;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&recref_slmt_doc_ref_date;
 sqlstm.sqhstl[28] = (unsigned int  )15;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&recref_slmt_doc_remarks;
 sqlstm.sqhstl[29] = (unsigned int  )33;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&recref_bank_recon_ref;
 sqlstm.sqhstl[30] = (unsigned int  )13;
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&recref_print_flag;
 sqlstm.sqhstl[31] = (unsigned int  )4;
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&recref_cancelled_ind;
 sqlstm.sqhstl[32] = (unsigned int  )4;
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&recref_posted_ind;
 sqlstm.sqhstl[33] = (unsigned int  )4;
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&recref_narration;
 sqlstm.sqhstl[34] = (unsigned int  )53;
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&recref_cons_receipt_yn;
 sqlstm.sqhstl[35] = (unsigned int  )4;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[36] = (unsigned int  )5;
 sqlstm.sqhsts[36] = (         int  )0;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)&c_doc_type_code;
 sqlstm.sqhstl[37] = (unsigned int  )9;
 sqlstm.sqhsts[37] = (         int  )0;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)&c_doc_number;
 sqlstm.sqhstl[38] = (unsigned int  )11;
 sqlstm.sqhsts[38] = (         int  )0;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)&c_doc_srno;
 sqlstm.sqhstl[39] = (unsigned int  )7;
 sqlstm.sqhsts[39] = (         int  )0;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




    if (OERROR)
      err_mesg("SELECT failed on BL_RECEIPT_REFUND_DTL_CUR",0,"");

   if(NO_DATA_FOUND)
	{  
	sprintf(string_var,"Record %s - %s not found in BL_RECEIPT_REFUND_DTL",c_doc_type_code.arr,c_doc_number.arr);
	err_mesg(string_var,0,"");
	}   


}
  
   recref_rowid.arr[recref_rowid.len]                               = '\0';
   recref_recpt_refund_ind.arr[recref_recpt_refund_ind.len]         = '\0';
   recref_doc_type_code.arr[recref_doc_type_code.len]               = '\0';
   recref_doc_number.arr[recref_doc_number.len]                     = '\0';
   recref_doc_srno.arr[recref_doc_srno.len]                         = '\0';
   recref_trx_type_code.arr[recref_trx_type_code.len]               = '\0';
   recref_recpt_nature_code.arr[recref_recpt_nature_code.len]       = '\0';
   recref_debtor_category_code.arr[recref_debtor_category_code.len] = '\0';
   recref_doc_date.arr[recref_doc_date.len]                         = '\0';
   recref_post_month.arr[recref_post_month.len]                     = '\0';
   recref_post_year.arr[recref_post_year.len]                       = '\0';
   recref_trx_date_time.arr[recref_trx_date_time.len]               = '\0';
   recref_episode_type.arr[recref_episode_type.len]                 = '\0';
   recref_patient_id.arr[recref_patient_id.len]                     = '\0';
   recref_episode_id.arr[recref_episode_id.len]                     = '\0';
   recref_visit_id.arr[recref_visit_id.len]                         = '\0';
   recref_bill_doc_type_code.arr[recref_bill_doc_type_code.len]     = '\0';
   recref_bill_doc_number.arr[recref_bill_doc_number.len]           = '\0';
   recref_customer_code.arr[recref_customer_code.len]               = '\0';
   recref_cash_counter_code.arr[recref_cash_counter_code.len]       = '\0';
   recref_shift_id.arr[recref_shift_id.len]                         = '\0';
   recref_doc_amt.arr[recref_doc_amt.len]                           = '\0';
   recref_doc_amt_negative.arr[recref_doc_amt_negative.len]         = '\0';
   recref_recpt_type_code.arr[recref_recpt_type_code.len]           = '\0';
   recref_slmt_type_code .arr[recref_slmt_type_code .len]           = '\0';
   recref_slmt_doc_ref_desc.arr[recref_slmt_doc_ref_desc.len]       = '\0';
   recref_slmt_doc_ref_date.arr[recref_slmt_doc_ref_date.len]       = '\0';
   recref_slmt_doc_remarks.arr[recref_slmt_doc_remarks.len]         = '\0';
   recref_bank_recon_ref .arr[recref_bank_recon_ref .len]           = '\0';
   recref_print_flag.arr[recref_print_flag.len]                     = '\0';
   recref_cancelled_ind.arr[recref_cancelled_ind.len]               = '\0';
   recref_posted_ind.arr[recref_posted_ind.len]                     = '\0';
   recref_narration.arr[recref_narration.len]                       = '\0';
   recref_cons_receipt_yn.arr[recref_cons_receipt_yn.len]	    = '\0';

   if(!recref_trx_type_code.arr[0]) 
   {
	if(recref_recpt_refund_ind.arr[0] == 'R')
	   strcpy(recref_trx_type_code.arr,"5");
	else if(recref_recpt_refund_ind.arr[0] == 'F')
	   strcpy(recref_trx_type_code.arr,"6");

	recref_trx_type_code.len = strlen(recref_trx_type_code.arr);
   }

   strcpy(recref_narration.arr,c_narration.arr);
   recref_narration.len = strlen(c_narration.arr);
}


fetch_bill_dtls()
{
    t_doc_type_code.arr[0]  = '\0';
    t_doc_num.arr[0]  = '\0';
    t_doc_date.arr[0]  = '\0';
    t_overall_int_code.arr[0] = '\0';
    t_bill_type_code.arr[0]   = '\0';
    t_tot_disc_char.arr[0]   = '\0';
    t_tot_disc_nega.arr[0]   = '\0';
    t_bill_print_flag.arr[0] = '\0';

    t_episode_type.arr[0]  = '\0';
    t_patient_id.arr[0]  = '\0';
    t_episode_id.arr[0]  = '\0';
    t_visit_id.arr[0]  = '\0';
    t_bill_trx_type_code.arr[0]  = '\0';
    t_bill_nature_code.arr[0]  = '\0';
    t_bill_tot_amt.arr[0]  = '\0';
    t_bill_tot_outst_amt.arr[0]  = '\0';
    t_prv_bill_tot_outst_amt.arr[0]  = '\0';
    t_added_by_id.arr[0]  = '\0';
    t_modified_by_id.arr[0]  = '\0';
    t_added_date.arr[0]  = '\0';
    t_modified_date.arr[0]  = '\0';

    t_doc_type_code.len     = 0;
    t_doc_num.len     = 0;
    t_doc_date.len     = 0;
    t_overall_int_code.len  = 0;
    t_bill_type_code.len    = 0;
    t_tot_disc_char.len     = 0;
    t_tot_disc_nega.len     = 0;

    t_episode_type.len     = 0;
    t_patient_id.len     = 0;
    t_episode_id.len     = 0;
    t_visit_id.len     = 0;
    t_bill_trx_type_code.len     = 0;
    t_bill_nature_code.len     = 0;
    t_bill_tot_amt.len     = 0;
    t_bill_tot_outst_amt.len     = 0;
    t_prv_bill_tot_outst_amt.len     = 0;
    t_added_by_id.len     = 0;
    t_modified_by_id.len     = 0;
    t_added_date.len     = 0;
    t_modified_date.len     = 0;

    t_bill_drfee_tot_amt = 0;
    t_man_disc_amt       = 0;
    t_overall_disc_amt   = 0;
    t_bill_print_flag.len = 0;
   
    t_bill_posted_flag = '\0';

    /* EXEC SQL SELECT  EPISODE_TYPE,
		     PATIENT_ID,
		     NVL(EPISODE_ID,0),
		     NVL(VISIT_ID,1),
		     BILL_TRX_TYPE_CODE,
		     BILL_NATURE_CODE,
		     BILL_TOT_AMT,
		     BILL_TOT_OUTST_AMT,
		     BILL_PRV_OUTST_AMT,
		     ADDED_BY_ID,
		     MODIFIED_BY_ID,
		     TO_CHAR(ADDED_DATE,'DD/MM/YYYY'),
		     TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY'),
		     DOC_TYPE_CODE,
		     DOC_NUM,
		     TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
		     NVL(MAN_DISC_AMT,0),
		     NVL(OVERALL_DISC_AMT,0),
		     OVR_DISC_ACC_INT_CODE,
                     BILL_TYPE_CODE,
                     NVL(MAN_DISC_AMT,0) + NVL(OVERALL_DISC_AMT,0),
                     (NVL(MAN_DISC_AMT,0) + NVL(OVERALL_DISC_AMT,0)) * -1,
		     NVL(BILL_DRFEE_AMT,0),
		     NVL(BILL_POSTED_FLAG,'N'),
		     CASH_CTRL_DOC_TYPE_CODE,   
		     CASH_CTRL_DOC_NUMBER,           
		     CASH_CTRL_DOC_DATE ,
		     BILL_ROUNDING_AMT,
		     NVL(BILL_PRINT_FLAG,'N')
	     INTO  :t_episode_type,
                   :t_patient_id,
                   :t_episode_id,
                   :t_visit_id,
                   :t_bill_trx_type_code,
                   :t_bill_nature_code,
                   :t_bill_tot_amt,
                   :t_bill_tot_outst_amt,
                   :t_prv_bill_tot_outst_amt,
                   :t_added_by_id,
                   :t_modified_by_id,
                   :t_added_date,
                   :t_modified_date,
	           :t_doc_type_code,
		   :t_doc_num,
		   :t_doc_date,
                   :t_man_disc_amt,
                   :t_overall_disc_amt,
                   :t_overall_int_code,
                   :t_bill_type_code,
                   :t_tot_disc_char,
                   :t_tot_disc_nega,
		   :t_bill_drfee_tot_amt,
		   :t_bill_posted_flag,
		   nd_doc_type,
		   :nd_doc_num,                     
		   :nd_doc_date,
		   :t_round_amt,
		   :t_bill_print_flag
	     FROM   BL_BILL_HDR
	     WHERE   DOC_TYPE_CODE = :c_doc_type_code
	     AND     DOC_NUM       = :c_doc_number
	     AND     OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select EPISODE_TYPE ,PATIENT_ID ,NVL(EPISODE_ID,0) ,NVL(V\
ISIT_ID,1) ,BILL_TRX_TYPE_CODE ,BILL_NATURE_CODE ,BILL_TOT_AMT ,BILL_TOT_OUTST\
_AMT ,BILL_PRV_OUTST_AMT ,ADDED_BY_ID ,MODIFIED_BY_ID ,TO_CHAR(ADDED_DATE,'DD/\
MM/YYYY') ,TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY') ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHA\
R(DOC_DATE,'DD/MM/YYYY') ,NVL(MAN_DISC_AMT,0) ,NVL(OVERALL_DISC_AMT,0) ,OVR_DI\
SC_ACC_INT_CODE ,BILL_TYPE_CODE ,(NVL(MAN_DISC_AMT,0)+NVL(OVERALL_DISC_AMT,0))\
 ,((NVL(MAN_DISC_AMT,0)+NVL(OVERALL_DISC_AMT,0))* (-1)) ,NVL(BILL_DRFEE_AMT,0)\
 ,NVL(BILL_POSTED_FLAG,'N') ,CASH_CTRL_DOC_TYPE_CODE ,CASH_CTRL_DOC_NUMBER ,CA\
SH_CTRL_DOC_DATE ,BILL_ROUNDING_AMT ,NVL(BILL_PRINT_FLAG,'N') into :b0,:b1,:b2\
,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19\
,:b20,:b21,:b22,:b23,:b24,:b25,:b26,:b27,:b28  from BL_BILL_HDR where ((DOC_TY\
PE_CODE=:b29 and DOC_NUM=:b30) and OPERATING_FACILITY_ID=:b31)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4707;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&t_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&t_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&t_episode_id;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&t_visit_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&t_bill_trx_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&t_bill_nature_code;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&t_bill_tot_amt;
    sqlstm.sqhstl[6] = (unsigned int  )25;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&t_bill_tot_outst_amt;
    sqlstm.sqhstl[7] = (unsigned int  )25;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&t_prv_bill_tot_outst_amt;
    sqlstm.sqhstl[8] = (unsigned int  )25;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&t_added_by_id;
    sqlstm.sqhstl[9] = (unsigned int  )33;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&t_modified_by_id;
    sqlstm.sqhstl[10] = (unsigned int  )33;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&t_added_date;
    sqlstm.sqhstl[11] = (unsigned int  )33;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&t_modified_date;
    sqlstm.sqhstl[12] = (unsigned int  )33;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&t_doc_type_code;
    sqlstm.sqhstl[13] = (unsigned int  )9;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&t_doc_num;
    sqlstm.sqhstl[14] = (unsigned int  )11;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&t_doc_date;
    sqlstm.sqhstl[15] = (unsigned int  )15;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&t_man_disc_amt;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&t_overall_disc_amt;
    sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&t_overall_int_code;
    sqlstm.sqhstl[18] = (unsigned int  )9;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&t_bill_type_code;
    sqlstm.sqhstl[19] = (unsigned int  )5;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&t_tot_disc_char;
    sqlstm.sqhstl[20] = (unsigned int  )23;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&t_tot_disc_nega;
    sqlstm.sqhstl[21] = (unsigned int  )23;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&t_bill_drfee_tot_amt;
    sqlstm.sqhstl[22] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&t_bill_posted_flag;
    sqlstm.sqhstl[23] = (unsigned int  )1;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&nd_doc_type;
    sqlstm.sqhstl[24] = (unsigned int  )9;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&nd_doc_num;
    sqlstm.sqhstl[25] = (unsigned int  )37;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&nd_doc_date;
    sqlstm.sqhstl[26] = (unsigned int  )32;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&t_round_amt;
    sqlstm.sqhstl[27] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&t_bill_print_flag;
    sqlstm.sqhstl[28] = (unsigned int  )4;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&c_doc_type_code;
    sqlstm.sqhstl[29] = (unsigned int  )9;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&c_doc_number;
    sqlstm.sqhstl[30] = (unsigned int  )11;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[31] = (unsigned int  )5;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)
	err_mesg("FETCH failed on table T_BILL_HDR_CUR",0,"");

  	if(NO_DATA_FOUND)
		{  
	 sprintf(string_var,"Record - %s/%s not found in BL_BILL_HDR",c_doc_type_code.arr,c_doc_number.arr);
	         err_mesg(string_var,0,"");
 		}   


    t_doc_type_code.arr[t_doc_type_code.len]  = '\0';
    t_doc_num.arr[t_doc_num.len]  = '\0';
    t_doc_date.arr[t_doc_date.len]  = '\0';
    t_overall_int_code.arr[t_overall_int_code.len] = '\0';
    t_bill_type_code.arr[t_bill_type_code.len] = '\0';
    t_tot_disc_char.arr[t_tot_disc_char.len] = '\0';
    t_tot_disc_nega.arr[t_tot_disc_nega.len] = '\0';
    t_episode_type.arr[t_episode_type.len]  = '\0';
    t_patient_id.arr[t_patient_id.len]  = '\0';
    t_episode_id.arr[t_episode_id.len]  = '\0';
    t_visit_id.arr[t_visit_id.len]  = '\0';
    t_bill_trx_type_code.arr[t_bill_trx_type_code.len]  = '\0';
    t_bill_nature_code.arr[t_bill_nature_code.len]  = '\0';
    t_bill_tot_amt.arr[t_bill_tot_amt.len]  = '\0';
    t_bill_tot_outst_amt.arr[t_bill_tot_outst_amt.len]  = '\0';
    t_prv_bill_tot_outst_amt.arr[t_prv_bill_tot_outst_amt.len]  = '\0';
    t_added_by_id.arr[t_added_by_id.len]  = '\0';
    t_modified_by_id.arr[t_modified_by_id.len]  = '\0';
    t_added_date.arr[t_added_date.len]  = '\0';
    t_modified_date.arr[t_modified_date.len]  = '\0';
    t_bill_print_flag.arr[t_bill_print_flag.len] = '\0';
   

	//  GANESH

	if(g_error) 
	  do_rollback();

      /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "savepoint LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )4850;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



      if (OERROR)
         err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

      g_savepoint = 1;

//  GANESH

	//This procedure is only called by cancelled bills function.
	//Commented by Harish on 08/01/2004.
	upd_reasons_in_receipt_refund_for_unposting(4);

      if (nd_reason_text.arr[0] != '\0')
         return;


    if(t_bill_posted_flag != 'Y') 
	{
        post_discounts(0);
	if (g_error) return; // Added new

        /* EXEC SQL UPDATE BL_BILL_HDR
		SET BILL_POSTED_FLAG		= 'Y',
		UNPOSTED_REASON			= NULL,
		MODIFIED_BY_ID			= user,
		MODIFIED_DATE			= SYSDATE,
		ADDED_AT_WS_NO			= :nd_ws_no,
		ADDED_FACILITY_ID		= :nd_operating_facility_id,
		MODIFIED_AT_WS_NO		= :nd_ws_no,
		MODIFIED_FACILITY_ID	= :nd_operating_facility_id
		WHERE  DOC_TYPE_CODE			= :t_doc_type_code
		 AND  DOC_NUM					= :t_doc_num; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 42;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update BL_BILL_HDR  set BILL_POSTED_FLAG='Y',UNPOSTED\
_REASON=null ,MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADD\
ED_FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where (DOC_T\
YPE_CODE=:b4 and DOC_NUM=:b5)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )4865;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
        sqlstm.sqhstl[0] = (unsigned int  )33;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[1] = (unsigned int  )5;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
        sqlstm.sqhstl[2] = (unsigned int  )33;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&t_doc_type_code;
        sqlstm.sqhstl[4] = (unsigned int  )9;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&t_doc_num;
        sqlstm.sqhstl[5] = (unsigned int  )11;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	    if(OERROR)
	        err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");

    }

}

log_mesg(l_errmsg,l_errtype,l_errid)
int l_errtype;
char l_errmsg[],
     l_errid[];
/*  l_errtype = 1 for application errors  */
/*            = 0 for oracle errors       */
{
        char l_msg_desc[70],l_message_text[80];

	long l_sqlcode;
	char app_err_msg[79];

	l_sqlcode = sqlca.sqlcode;
	app_err_msg[0]='\0';

	if(l_errtype)  {
	     
		if(get_message(l_errid,l_msg_desc) == -1) 
		    disp_message(INFO_MESG,l_msg_desc);
		else {
		    strcpy(app_err_msg,"APP-");
		    strncat(app_err_msg,l_errid,6);
		    strncat(app_err_msg,"-",1);
		    strncat(app_err_msg,l_msg_desc,68);
		    disp_message(INFO_MESG,app_err_msg);
		}

	}
	else  
      g_error = 1;
      if(g_savepoint) {
          /* EXEC SQL ROLLBACK WORK TO SAVEPOINT LAST_DOC_REF; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 42;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "rollback work  to LAST_DOC_REF";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )4904;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


          if (OERROR)
             err_mesg("ROLLBACK TO LAST_DOC_REF failed 2",0,""); 
          g_savepoint = 0;
      }
      else {
          /* EXEC SQL ROLLBACK WORK; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 42;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )4919;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


          if (OERROR)
             err_mesg("ROLLBACK failed",0,""); 
      }
      return(0);   
}



post_cash_control_rcpts()
{

/* EXEC SQL EXECUTE
BEGIN
	BL_CASH_CONTROL_GL_POSTING(
		:nd_operating_facility_id,
		:nd_ws_no,
		:nd_date, 
		user,
		:nd_error_level,
		:nd_sys_message_id,
		:nd_error_text);
END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 42;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin BL_CASH_CONTROL_GL_POSTING ( :nd_operating_facility_id \
, :nd_ws_no , :nd_date , user , :nd_error_level , :nd_sys_message_id , :nd_err\
or_text ) ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )4934;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
sqlstm.sqhstl[0] = (unsigned int  )5;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
sqlstm.sqhstl[1] = (unsigned int  )33;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_date;
sqlstm.sqhstl[2] = (unsigned int  )15;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_error_level;
sqlstm.sqhstl[3] = (unsigned int  )12;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nd_sys_message_id;
sqlstm.sqhstl[4] = (unsigned int  )12;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&nd_error_text;
sqlstm.sqhstl[5] = (unsigned int  )1002;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

       

if (nd_error_text.arr[0])
	disp_message(ERR_MESG,nd_error_text.arr);

}


post_dr_share()
{

/* EXEC SQL EXECUTE
BEGIN
BL_INSERT_DR_SHARE(:nd_operating_facility_id,:t_doc_type_code,:t_doc_num,:nd_date,:nd_ws_no, user);

END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 42;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin BL_INSERT_DR_SHARE ( :nd_operating_facility_id , :t_doc\
_type_code , :t_doc_num , :nd_date , :nd_ws_no , user ) ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )4973;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
sqlstm.sqhstl[0] = (unsigned int  )5;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&t_doc_type_code;
sqlstm.sqhstl[1] = (unsigned int  )9;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&t_doc_num;
sqlstm.sqhstl[2] = (unsigned int  )11;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_date;
sqlstm.sqhstl[3] = (unsigned int  )15;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nd_ws_no;
sqlstm.sqhstl[4] = (unsigned int  )33;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

post_rounding_amt(cancel_flg)
int cancel_flg;
{

/*************** GL Posting of Bill Discounts  G Sriram ***********/
     if(cancel_flg) 
		{
		strcpy(t_doc_date.arr,c_post_date.arr);
		t_doc_date.len = strlen(t_doc_date.arr);
		}

        if (t_round_amt != 0)
          {
           t_bill_type_int_code.arr[0] = '\0';
           t_bill_type_int_code.len    = 0;
           /* EXEC SQL SELECT B.BL_RECV_ACC_INT_CODE,B.BL_ROUNDING_ACC_INT_CODE
                    INTO :t_bill_type_int_code, :t_round_int_code
             FROM BL_BILL_TYPE A, BL_BILL_TYPE_INT B
             WHERE A.BILL_TYPE_CODE = :t_bill_type_code
	     AND A.ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
	     			     WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
	     AND A.ACC_ENTITY_CODE = B.ACC_ENTITY_CODE
	     AND A.BILL_TYPE_CODE = B.BILL_TYPE_CODE
	     AND TO_DATE(:t_doc_date,'DD/MM/YYYY') between 
		      NVL(B.EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) AND 
		      NVL(B.EFF_TO_DATE,SYSDATE)   /o Effective date range is included ON 01/06/2004 o/
	    ; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 42;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select B.BL_RECV_ACC_INT_CODE ,B.BL_ROUNDING_ACC_I\
NT_CODE into :b0,:b1  from BL_BILL_TYPE A ,BL_BILL_TYPE_INT B where ((((A.BILL\
_TYPE_CODE=:b2 and A.ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_E\
NTITY where ACC_ENTITY_ID=:b3)) and A.ACC_ENTITY_CODE=B.ACC_ENTITY_CODE) and A\
.BILL_TYPE_CODE=B.BILL_TYPE_CODE) and TO_DATE(:b4,'DD/MM/YYYY') between NVL(B.\
EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(B.EFF_TO_DATE,SYSDAT\
E))";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )5008;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&t_bill_type_int_code;
           sqlstm.sqhstl[0] = (unsigned int  )9;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&t_round_int_code;
           sqlstm.sqhstl[1] = (unsigned int  )9;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&t_bill_type_code;
           sqlstm.sqhstl[2] = (unsigned int  )5;
           sqlstm.sqhsts[2] = (         int  )0;
           sqlstm.sqindv[2] = (         void  *)0;
           sqlstm.sqinds[2] = (         int  )0;
           sqlstm.sqharm[2] = (unsigned int  )0;
           sqlstm.sqadto[2] = (unsigned short )0;
           sqlstm.sqtdso[2] = (unsigned short )0;
           sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
           sqlstm.sqhstl[3] = (unsigned int  )5;
           sqlstm.sqhsts[3] = (         int  )0;
           sqlstm.sqindv[3] = (         void  *)0;
           sqlstm.sqinds[3] = (         int  )0;
           sqlstm.sqharm[3] = (unsigned int  )0;
           sqlstm.sqadto[3] = (unsigned short )0;
           sqlstm.sqtdso[3] = (unsigned short )0;
           sqlstm.sqhstv[4] = (         void  *)&t_doc_date;
           sqlstm.sqhstl[4] = (unsigned int  )15;
           sqlstm.sqhsts[4] = (         int  )0;
           sqlstm.sqindv[4] = (         void  *)0;
           sqlstm.sqinds[4] = (         int  )0;
           sqlstm.sqharm[4] = (unsigned int  )0;
           sqlstm.sqadto[4] = (unsigned short )0;
           sqlstm.sqtdso[4] = (unsigned short )0;
           sqlstm.sqphsv = sqlstm.sqhstv;
           sqlstm.sqphsl = sqlstm.sqhstl;
           sqlstm.sqphss = sqlstm.sqhsts;
           sqlstm.sqpind = sqlstm.sqindv;
           sqlstm.sqpins = sqlstm.sqinds;
           sqlstm.sqparm = sqlstm.sqharm;
           sqlstm.sqparc = sqlstm.sqharc;
           sqlstm.sqpadto = sqlstm.sqadto;
           sqlstm.sqptdso = sqlstm.sqtdso;
           sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            if(OERROR)
	       err_mesg("SELECT failed on table BL_BILL_TYPE",0,"");

	    if(NO_DATA_FOUND)
	       {
	       sprintf(msg_str,"Record %s not found in BL_BILL_TYPE_INT",t_bill_type_code.arr);	 
	       //err_mesg(msg_str,0,"");
	       loc_log_msg(msg_str);
	       g_error = 1;
	       return;
	       }
	       

            t_bill_type_int_code.arr[t_bill_type_int_code.len] = '\0';
            t_round_int_code.arr[t_round_int_code.len] = '\0';

           xxxxxx_main_acc1_code.arr[0]     = '\0';
           xxxxxx_main_acc2_code.arr[0]     = '\0';
           xxxxxx_dept_code.arr[0]     = '\0';
           xxxxxx_subledger_group_code.arr[0] = '\0';
           xxxxxx_subledger_line_code.arr[0] = '\0';
           xxxxxx_product_group_code.arr[0] = '\0';
           xxxxxx_product_line_code.arr[0] = '\0';

           xxxxxx_main_acc1_code.len                 = 0;
           xxxxxx_main_acc2_code.len                 = 0;
           xxxxxx_dept_code.len                      = 0;
           xxxxxx_subledger_group_code.len           = 0;
           xxxxxx_subledger_line_code.len           = 0;
           xxxxxx_product_group_code.len           = 0;
           xxxxxx_product_line_code.len           = 0;

           /* EXEC SQL SELECT MAIN_ACC1_CODE,
                  MAIN_ACC2_CODE,
                  DEPT_CODE,
                  SUBLEDGER_GROUP_CODE,
                  SUBLEDGER_LINE_CODE,
                  PRODUCT_GROUP_CODE,
                  PRODUCT_LINE_CODE     INTO
                  :xxxxxx_main_acc1_code,
                  :xxxxxx_main_acc2_code,
                  :xxxxxx_dept_code,
                  :xxxxxx_subledger_group_code,
                  :xxxxxx_subledger_line_code,
                  :xxxxxx_product_group_code,
                  :xxxxxx_product_line_code
                FROM BL_GL_ACCOUNT
                WHERE ACC_INT_CODE = :t_bill_type_int_code
	        AND   ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id); */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 42;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,\
SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CO\
DE into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from BL_GL_ACCOUNT where (ACC_INT_CODE=:b\
7 and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC\
_ENTITY_ID=:b8))";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )5043;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&xxxxxx_main_acc1_code;
           sqlstm.sqhstl[0] = (unsigned int  )9;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&xxxxxx_main_acc2_code;
           sqlstm.sqhstl[1] = (unsigned int  )7;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&xxxxxx_dept_code;
           sqlstm.sqhstl[2] = (unsigned int  )13;
           sqlstm.sqhsts[2] = (         int  )0;
           sqlstm.sqindv[2] = (         void  *)0;
           sqlstm.sqinds[2] = (         int  )0;
           sqlstm.sqharm[2] = (unsigned int  )0;
           sqlstm.sqadto[2] = (unsigned short )0;
           sqlstm.sqtdso[2] = (unsigned short )0;
           sqlstm.sqhstv[3] = (         void  *)&xxxxxx_subledger_group_code;
           sqlstm.sqhstl[3] = (unsigned int  )6;
           sqlstm.sqhsts[3] = (         int  )0;
           sqlstm.sqindv[3] = (         void  *)0;
           sqlstm.sqinds[3] = (         int  )0;
           sqlstm.sqharm[3] = (unsigned int  )0;
           sqlstm.sqadto[3] = (unsigned short )0;
           sqlstm.sqtdso[3] = (unsigned short )0;
           sqlstm.sqhstv[4] = (         void  *)&xxxxxx_subledger_line_code;
           sqlstm.sqhstl[4] = (unsigned int  )11;
           sqlstm.sqhsts[4] = (         int  )0;
           sqlstm.sqindv[4] = (         void  *)0;
           sqlstm.sqinds[4] = (         int  )0;
           sqlstm.sqharm[4] = (unsigned int  )0;
           sqlstm.sqadto[4] = (unsigned short )0;
           sqlstm.sqtdso[4] = (unsigned short )0;
           sqlstm.sqhstv[5] = (         void  *)&xxxxxx_product_group_code;
           sqlstm.sqhstl[5] = (unsigned int  )6;
           sqlstm.sqhsts[5] = (         int  )0;
           sqlstm.sqindv[5] = (         void  *)0;
           sqlstm.sqinds[5] = (         int  )0;
           sqlstm.sqharm[5] = (unsigned int  )0;
           sqlstm.sqadto[5] = (unsigned short )0;
           sqlstm.sqtdso[5] = (unsigned short )0;
           sqlstm.sqhstv[6] = (         void  *)&xxxxxx_product_line_code;
           sqlstm.sqhstl[6] = (unsigned int  )7;
           sqlstm.sqhsts[6] = (         int  )0;
           sqlstm.sqindv[6] = (         void  *)0;
           sqlstm.sqinds[6] = (         int  )0;
           sqlstm.sqharm[6] = (unsigned int  )0;
           sqlstm.sqadto[6] = (unsigned short )0;
           sqlstm.sqtdso[6] = (unsigned short )0;
           sqlstm.sqhstv[7] = (         void  *)&t_bill_type_int_code;
           sqlstm.sqhstl[7] = (unsigned int  )9;
           sqlstm.sqhsts[7] = (         int  )0;
           sqlstm.sqindv[7] = (         void  *)0;
           sqlstm.sqinds[7] = (         int  )0;
           sqlstm.sqharm[7] = (unsigned int  )0;
           sqlstm.sqadto[7] = (unsigned short )0;
           sqlstm.sqtdso[7] = (unsigned short )0;
           sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
           sqlstm.sqhstl[8] = (unsigned int  )5;
           sqlstm.sqhsts[8] = (         int  )0;
           sqlstm.sqindv[8] = (         void  *)0;
           sqlstm.sqinds[8] = (         int  )0;
           sqlstm.sqharm[8] = (unsigned int  )0;
           sqlstm.sqadto[8] = (unsigned short )0;
           sqlstm.sqtdso[8] = (unsigned short )0;
           sqlstm.sqphsv = sqlstm.sqhstv;
           sqlstm.sqphsl = sqlstm.sqhstl;
           sqlstm.sqphss = sqlstm.sqhsts;
           sqlstm.sqpind = sqlstm.sqindv;
           sqlstm.sqpins = sqlstm.sqinds;
           sqlstm.sqparm = sqlstm.sqharm;
           sqlstm.sqparc = sqlstm.sqharc;
           sqlstm.sqpadto = sqlstm.sqadto;
           sqlstm.sqptdso = sqlstm.sqtdso;
           sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




            if(OERROR)
			{
			 //disp_message(ERR_MESG,t_bill_type_int_code.arr);
			 //disp_message(ERR_MESG, " 5 ");

	       err_mesg("SELECT failed on table BL_GL_ACCOUNT",0,"");
		   }

	   if(NO_DATA_FOUND)
		{  
			 sprintf(string_var,"Record %s - %s not found in BL_GL_ACCOUNT",t_bill_type_code.arr, t_bill_type_int_code.arr);
	         err_mesg(string_var,0,"");
 		}   


             xxxxxx_main_acc1_code.arr[xxxxxx_main_acc1_code.len] = '\0';
             xxxxxx_main_acc2_code.arr[xxxxxx_main_acc2_code.len] = '\0';
             xxxxxx_dept_code.arr[xxxxxx_dept_code.len]           = '\0';
             xxxxxx_subledger_group_code.arr[xxxxxx_subledger_group_code.len] = '\0';
             xxxxxx_subledger_line_code.arr[xxxxxx_subledger_line_code.len] = '\0';
             xxxxxx_product_group_code.arr[xxxxxx_product_group_code.len] = '\0';
             xxxxxx_product_line_code.arr[xxxxxx_product_line_code.len] = '\0';

           //KGA 
           if  (cancel_flg)
             sprintf(xxxxxx_doc_amt.arr,"%f",(-1)*t_round_amt);
          else
	     sprintf(xxxxxx_doc_amt.arr,"%f",t_round_amt);

           xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);

            ins_blgl_distrib_bl();

           xxxxxx_main_acc1_code.arr[0]     = '\0';
           xxxxxx_main_acc2_code.arr[0]     = '\0';
           xxxxxx_dept_code.arr[0]     = '\0';
           xxxxxx_subledger_group_code.arr[0] = '\0';
           xxxxxx_subledger_line_code.arr[0] = '\0';
           xxxxxx_product_group_code.arr[0] = '\0';
           xxxxxx_product_line_code.arr[0] = '\0';

           xxxxxx_main_acc1_code.len                 = 0;
           xxxxxx_main_acc2_code.len                 = 0;
           xxxxxx_dept_code.len                      = 0;
           xxxxxx_subledger_group_code.len           = 0;
           xxxxxx_subledger_line_code.len           = 0;
           xxxxxx_product_group_code.len           = 0;
           xxxxxx_product_line_code.len           = 0;

           /* EXEC SQL SELECT MAIN_ACC1_CODE,
                  MAIN_ACC2_CODE,
                  DEPT_CODE,
                  SUBLEDGER_GROUP_CODE,
                  SUBLEDGER_LINE_CODE,
                  PRODUCT_GROUP_CODE,
                  PRODUCT_LINE_CODE     INTO
                  :xxxxxx_main_acc1_code,
                  :xxxxxx_main_acc2_code,
                  :xxxxxx_dept_code,
                  :xxxxxx_subledger_group_code,
                  :xxxxxx_subledger_line_code,
                  :xxxxxx_product_group_code,
                  :xxxxxx_product_line_code
                FROM BL_GL_ACCOUNT
                WHERE ACC_INT_CODE = :t_round_int_code
	        AND   ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE 
					FROM   SY_ACC_ENTITY 
					WHERE  ACC_ENTITY_ID = :nd_operating_facility_id); */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 42;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select MAIN_ACC1_CODE ,MAIN_ACC2_CODE ,DEPT_CODE ,\
SUBLEDGER_GROUP_CODE ,SUBLEDGER_LINE_CODE ,PRODUCT_GROUP_CODE ,PRODUCT_LINE_CO\
DE into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from BL_GL_ACCOUNT where (ACC_INT_CODE=:b\
7 and ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC\
_ENTITY_ID=:b8))";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )5094;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&xxxxxx_main_acc1_code;
           sqlstm.sqhstl[0] = (unsigned int  )9;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&xxxxxx_main_acc2_code;
           sqlstm.sqhstl[1] = (unsigned int  )7;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&xxxxxx_dept_code;
           sqlstm.sqhstl[2] = (unsigned int  )13;
           sqlstm.sqhsts[2] = (         int  )0;
           sqlstm.sqindv[2] = (         void  *)0;
           sqlstm.sqinds[2] = (         int  )0;
           sqlstm.sqharm[2] = (unsigned int  )0;
           sqlstm.sqadto[2] = (unsigned short )0;
           sqlstm.sqtdso[2] = (unsigned short )0;
           sqlstm.sqhstv[3] = (         void  *)&xxxxxx_subledger_group_code;
           sqlstm.sqhstl[3] = (unsigned int  )6;
           sqlstm.sqhsts[3] = (         int  )0;
           sqlstm.sqindv[3] = (         void  *)0;
           sqlstm.sqinds[3] = (         int  )0;
           sqlstm.sqharm[3] = (unsigned int  )0;
           sqlstm.sqadto[3] = (unsigned short )0;
           sqlstm.sqtdso[3] = (unsigned short )0;
           sqlstm.sqhstv[4] = (         void  *)&xxxxxx_subledger_line_code;
           sqlstm.sqhstl[4] = (unsigned int  )11;
           sqlstm.sqhsts[4] = (         int  )0;
           sqlstm.sqindv[4] = (         void  *)0;
           sqlstm.sqinds[4] = (         int  )0;
           sqlstm.sqharm[4] = (unsigned int  )0;
           sqlstm.sqadto[4] = (unsigned short )0;
           sqlstm.sqtdso[4] = (unsigned short )0;
           sqlstm.sqhstv[5] = (         void  *)&xxxxxx_product_group_code;
           sqlstm.sqhstl[5] = (unsigned int  )6;
           sqlstm.sqhsts[5] = (         int  )0;
           sqlstm.sqindv[5] = (         void  *)0;
           sqlstm.sqinds[5] = (         int  )0;
           sqlstm.sqharm[5] = (unsigned int  )0;
           sqlstm.sqadto[5] = (unsigned short )0;
           sqlstm.sqtdso[5] = (unsigned short )0;
           sqlstm.sqhstv[6] = (         void  *)&xxxxxx_product_line_code;
           sqlstm.sqhstl[6] = (unsigned int  )7;
           sqlstm.sqhsts[6] = (         int  )0;
           sqlstm.sqindv[6] = (         void  *)0;
           sqlstm.sqinds[6] = (         int  )0;
           sqlstm.sqharm[6] = (unsigned int  )0;
           sqlstm.sqadto[6] = (unsigned short )0;
           sqlstm.sqtdso[6] = (unsigned short )0;
           sqlstm.sqhstv[7] = (         void  *)&t_round_int_code;
           sqlstm.sqhstl[7] = (unsigned int  )9;
           sqlstm.sqhsts[7] = (         int  )0;
           sqlstm.sqindv[7] = (         void  *)0;
           sqlstm.sqinds[7] = (         int  )0;
           sqlstm.sqharm[7] = (unsigned int  )0;
           sqlstm.sqadto[7] = (unsigned short )0;
           sqlstm.sqtdso[7] = (unsigned short )0;
           sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
           sqlstm.sqhstl[8] = (unsigned int  )5;
           sqlstm.sqhsts[8] = (         int  )0;
           sqlstm.sqindv[8] = (         void  *)0;
           sqlstm.sqinds[8] = (         int  )0;
           sqlstm.sqharm[8] = (unsigned int  )0;
           sqlstm.sqadto[8] = (unsigned short )0;
           sqlstm.sqtdso[8] = (unsigned short )0;
           sqlstm.sqphsv = sqlstm.sqhstv;
           sqlstm.sqphsl = sqlstm.sqhstl;
           sqlstm.sqphss = sqlstm.sqhsts;
           sqlstm.sqpind = sqlstm.sqindv;
           sqlstm.sqpins = sqlstm.sqinds;
           sqlstm.sqparm = sqlstm.sqharm;
           sqlstm.sqparc = sqlstm.sqharc;
           sqlstm.sqpadto = sqlstm.sqadto;
           sqlstm.sqptdso = sqlstm.sqtdso;
           sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            if(OERROR)
			{
			 //disp_message(ERR_MESG,t_round_int_code.arr);
			   //               disp_message(ERR_MESG, " 6 ");

	       err_mesg("SELECT failed on table BL_GL_ACCOUNT",0,"");
		   }

		if(NO_DATA_FOUND)
		{  
			
			 sprintf(string_var,"Record %s - %s not found in BL_GL_ACCOUNT",t_bill_type_code.arr, t_round_int_code.arr);
	         err_mesg(string_var,0,"");
 		}   

             xxxxxx_main_acc1_code.arr[xxxxxx_main_acc1_code.len] = '\0';
             xxxxxx_main_acc2_code.arr[xxxxxx_main_acc2_code.len] = '\0';
             xxxxxx_dept_code.arr[xxxxxx_dept_code.len]           = '\0';
			 xxxxxx_subledger_group_code.arr[xxxxxx_subledger_group_code.len] = '\0';
			 xxxxxx_subledger_line_code.arr[xxxxxx_subledger_line_code.len] = '\0';
			 xxxxxx_product_group_code.arr[xxxxxx_product_group_code.len] = '\0';
			 xxxxxx_product_line_code.arr[xxxxxx_product_line_code.len] = '\0';

     //strcpy(xxxxxx_dept_code.arr,dflt_dept_code.arr);
     //xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);
     
     //KGA 
     if  (cancel_flg)
       sprintf(xxxxxx_doc_amt.arr,"%f",t_round_amt);
     else
        sprintf(xxxxxx_doc_amt.arr,"%f",(-1)*t_round_amt);

     xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);

 

             ins_blgl_distrib_bl();
    }
/*************** End of GL Posting   G Sriram *********************/
}

upd_reasons_in_receipt_refund_for_unposting(p_flag)
int p_flag ;
{
     nd_reason_text.arr[0]=  '\0';
	 nd_reason_text.len = 0;
     nd_reason_text_for_update.arr[0] = '\0';
	 nd_reason_text_for_update.len = 0;

     if (recref_cash_counter_code.arr[0] == '\0')
	 {
        strcpy(nd_reason_text.arr,"Cash counter code not available  ");
		strcpy(nd_reason_text_for_update.arr,"Cash counter code not available  ");
	 }
     else
     {   
		if (recref_shift_id.arr[0] == '\0')
        {   
			strcpy(nd_reason_text.arr,"Shift Id not available  ");     
			strcpy(nd_reason_text_for_update.arr,"Shift Id not available  ");     
        }
		else
		{
			if (nd_doc_type.arr[0] == '\0' && nd_cash_control_use_flag == 'Y')
			{   
			    //disp_message(ERR_MESG,nd_doc_type.arr);
    		    //disp_message(ERR_MESG,nd_cash_control_use_flag);

				strcpy(nd_reason_text.arr,"Cash Control Document Type not available  ");
				strcpy(nd_reason_text_for_update.arr,"Cash Control Document Type not available  ");
			} 
			else
			{
				if (nd_doc_num.arr[0] == '\0' && nd_cash_control_use_flag == 'Y')
				{
					strcpy(nd_reason_text.arr,"Cash Control Document Number not available  ");     
					strcpy(nd_reason_text_for_update.arr,"Cash Control Document Number not available  ");     
				}
				else
				{
					if (nd_doc_date.arr[0] == '\0' && nd_cash_control_use_flag == 'Y')
					{
						strcpy(nd_reason_text.arr,"Cash Control Document Date not available  ");     
						strcpy(nd_reason_text_for_update.arr,"Cash Control Document Date not available  ");     
					}
				}	
			}
		}
	}

	if ((p_flag == 1  &&  strcmp(recref_print_flag.arr,"N") == 0 )||
	    (p_flag == 4 && strcmp(t_bill_print_flag.arr ,"N") == 0 ))
	{
	 	strcpy(nd_reason_text.arr,"Document not printed  ");     
		strcpy(nd_reason_text_for_update.arr,"Document not printed  ");

	}

	nd_reason_text.len = strlen(nd_reason_text.arr);
	nd_reason_text_for_update.len = strlen(nd_reason_text_for_update.arr);

	if (nd_reason_text.arr[0] && p_flag == 1)
	{
		strcat(nd_reason_text.arr," Receipt/Refund ");
		nd_reason_text.len = strlen(nd_reason_text.arr);		
		strcat(nd_reason_text.arr,recref_doc_type_code.arr);
		nd_reason_text.len = strlen(nd_reason_text.arr);
		strcat(nd_reason_text.arr," / ");
		nd_reason_text.len = strlen(nd_reason_text.arr);
		strcat(nd_reason_text.arr,recref_doc_number.arr);
	}
	else if (nd_reason_text.arr[0] && p_flag == 2)
	{
		strcat(nd_reason_text.arr," Cancelled Bill ");
		nd_reason_text.len = strlen(nd_reason_text.arr);		
		strcat(nd_reason_text.arr,c_doc_type_code.arr);
		nd_reason_text.len = strlen(nd_reason_text.arr);
		strcat(nd_reason_text.arr," / ");
		nd_reason_text.len = strlen(nd_reason_text.arr);
		strcat(nd_reason_text.arr,c_doc_number.arr);
	}
	else if (nd_reason_text.arr[0] && p_flag == 3)
	{
		strcat(nd_reason_text.arr," Cancelled Receipt/Refund ");
		nd_reason_text.len = strlen(nd_reason_text.arr);		
		strcat(nd_reason_text.arr,c_doc_type_code.arr);
		nd_reason_text.len = strlen(nd_reason_text.arr);
		strcat(nd_reason_text.arr," / ");
		nd_reason_text.len = strlen(nd_reason_text.arr);
		strcat(nd_reason_text.arr,c_doc_number.arr);
	}
	else if (nd_reason_text.arr[0] && p_flag == 4)
	{
		strcat(nd_reason_text.arr," Bill ");
		nd_reason_text.len = strlen(nd_reason_text.arr);		
		strcat(nd_reason_text.arr,t_doc_type_code.arr);
		nd_reason_text.len = strlen(nd_reason_text.arr);
		strcat(nd_reason_text.arr," / ");
		nd_reason_text.len = strlen(nd_reason_text.arr);
		strcat(nd_reason_text.arr,t_doc_num.arr);
	}

	nd_reason_text.len = strlen(nd_reason_text.arr);

	if (nd_reason_text.arr[0])  
	{
		loc_log_msg(nd_reason_text.arr);		
	} 
	

	if (nd_reason_text.arr[0] && p_flag == 1)
	{
	   if (strcmp(recref_cons_receipt_yn.arr,"Y") == 0)
	   {

		/* EXEC SQL UPDATE	BL_BILLS_FOR_CONS_RECEIPT
			 SET	UNPOSTED_REASON			= :nd_reason_text_for_update,
				POSTED_IND			= 'N',  
				MODIFIED_BY_ID			= user,
				MODIFIED_DATE			= SYSDATE,
				MODIFIED_AT_WS_NO		= :nd_ws_no,
				MODIFIED_FACILITY_ID	= :nd_operating_facility_id 
			 WHERE OPERATING_FACILITY_ID	= :nd_operating_facility_id 
			 AND	DOC_TYPE_CODE			= :recref_doc_type_code
			 AND	DOC_NUMBER				= TO_NUMBER(:recref_doc_number) 
			 AND    DOC_SRNO				= TO_NUMBER(:recref_doc_srno)
			 //AND	TRUNC(DOC_DATE)			= to_date(:recref_doc_date,'DD/MM/YYYY')
			 AND    BILL_DOC_TYPE_CODE		= :recref_bill_doc_type_code
			 AND    BILL_DOC_NUM            = TO_NUMBER(:recref_bill_doc_number); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 42;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_BILLS_FOR_CONS_RECEIPT  set UNPOSTED_REASON=:b0,P\
OSTED_IND='N',MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1,\
MODIFIED_FACILITY_ID=:b2 where (((((OPERATING_FACILITY_ID=:b2 and DOC_TYPE_COD\
E=:b4) and DOC_NUMBER=TO_NUMBER(:b5)) and DOC_SRNO=TO_NUMBER(:b6)) and BILL_DO\
C_TYPE_CODE=:b7) and BILL_DOC_NUM=TO_NUMBER(:b8))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5145;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_reason_text_for_update;
  sqlstm.sqhstl[0] = (unsigned int  )53;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&recref_doc_type_code;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&recref_doc_number;
  sqlstm.sqhstl[5] = (unsigned int  )11;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&recref_doc_srno;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&recref_bill_doc_type_code;
  sqlstm.sqhstl[7] = (unsigned int  )9;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&recref_bill_doc_number;
  sqlstm.sqhstl[8] = (unsigned int  )11;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR)
		err_mesg("UPDATE failed on table BL_BILLS_FOR_CONS_RECEIPT",0,"");
	  }
	  else
	  {
		/* EXEC SQL UPDATE	BL_RECEIPT_REFUND_DTL
			 SET	UNPOSTED_REASON			= :nd_reason_text_for_update,
				POSTED_IND			= 'N',  
				MODIFIED_BY_ID			= user,
				MODIFIED_DATE			= SYSDATE,
				MODIFIED_AT_WS_NO		= :nd_ws_no,
				MODIFIED_FACILITY_ID	= :nd_operating_facility_id 
			 WHERE OPERATING_FACILITY_ID	= :nd_operating_facility_id 
			 AND	DOC_TYPE_CODE			= :recref_doc_type_code
			 AND	DOC_NUMBER			= TO_NUMBER(:recref_doc_number) 
			 AND    DOC_SRNO            = TO_NUMBER(:recref_doc_srno)
			 AND	trunc(DOC_DATE)			= to_date(:recref_doc_date,'DD/MM/YYYY') ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 42;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_RECEIPT_REFUND_DTL  set UNPOSTED_REASON=:b0,POSTE\
D_IND='N',MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1,MODI\
FIED_FACILITY_ID=:b2 where ((((OPERATING_FACILITY_ID=:b2 and DOC_TYPE_CODE=:b4\
) and DOC_NUMBER=TO_NUMBER(:b5)) and DOC_SRNO=TO_NUMBER(:b6)) and trunc(DOC_DA\
TE)=to_date(:b7,'DD/MM/YYYY'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5196;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_reason_text_for_update;
  sqlstm.sqhstl[0] = (unsigned int  )53;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&recref_doc_type_code;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&recref_doc_number;
  sqlstm.sqhstl[5] = (unsigned int  )11;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&recref_doc_srno;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&recref_doc_date;
  sqlstm.sqhstl[7] = (unsigned int  )15;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR)
		err_mesg("UPDATE failed on table BL_RECEIPT_REFUND_DTL",0,"");
	 }
	 
	}


	if (nd_reason_text.arr[0] && p_flag == 2)
	{
		/* EXEC SQL UPDATE	BL_CANCELLED_BILLS
					SET	UNPOSTED_REASON			= :nd_reason_text_for_update,
						POSTED_IND				= 'N',  
						MODIFIED_BY_ID			= user,
						MODIFIED_DATE			= SYSDATE,
						MODIFIED_AT_WS_NO		= :nd_ws_no,
						MODIFIED_FACILITY_ID	= :nd_operating_facility_id 
				  WHERE	OPERATING_FACILITY_ID	= :nd_operating_facility_id 
    				AND	DOC_TYPE_CODE			= :c_doc_type_code
					AND	DOC_NUMBER				= TO_NUMBER(:c_doc_number); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 42;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_CANCELLED_BILLS  set UNPOSTED_REASON=:b0,POSTED_I\
ND='N',MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1,MODIFIE\
D_FACILITY_ID=:b2 where ((OPERATING_FACILITY_ID=:b2 and DOC_TYPE_CODE=:b4) and\
 DOC_NUMBER=TO_NUMBER(:b5))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5243;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_reason_text_for_update;
  sqlstm.sqhstl[0] = (unsigned int  )53;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&c_doc_type_code;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&c_doc_number;
  sqlstm.sqhstl[5] = (unsigned int  )11;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR)
			err_mesg("UPDATE failed on table BL_CANCELLED_BILLS",0,"");
	}

	if (nd_reason_text.arr[0] && p_flag == 3)
	{
	      if (strcmp(c_cons_rec_yn.arr,"Y") == 0)
	      {
			/* EXEC SQL  UPDATE BL_BILLS_FOR_CONS_RCPT_CANC
				 SET UNPOSTED_REASON        = :nd_reason_text_for_update,
				 POSTED_IND             = 'N',  
				 MODIFIED_BY_ID         = user,
				 MODIFIED_DATE          = SYSDATE,
				 MODIFIED_AT_WS_NO	= :nd_ws_no,
				 MODIFIED_FACILITY_ID   = :nd_operating_facility_id 
			         WHERE OPERATING_FACILITY_ID  = :nd_operating_facility_id 
				 AND DOC_TYPE_CODE	= :c_doc_type_code
				 AND DOC_NUMBER		= TO_NUMBER(:c_doc_number)
				 AND DOC_SRNO       = TO_NUMBER(:c_doc_srno)
				 AND BILL_DOC_TYPE_CODE = :c_bill_doc_type_code
				 AND BILL_DOC_NUM = TO_NUMBER(:c_bill_doc_num); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update BL_BILLS_FOR_CONS_RCPT_CANC  set UNPOSTED_REASON=:b\
0,POSTED_IND='N',MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:\
b1,MODIFIED_FACILITY_ID=:b2 where (((((OPERATING_FACILITY_ID=:b2 and DOC_TYPE_\
CODE=:b4) and DOC_NUMBER=TO_NUMBER(:b5)) and DOC_SRNO=TO_NUMBER(:b6)) and BILL\
_DOC_TYPE_CODE=:b7) and BILL_DOC_NUM=TO_NUMBER(:b8))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5282;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_reason_text_for_update;
   sqlstm.sqhstl[0] = (unsigned int  )53;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&c_doc_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&c_doc_number;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&c_doc_srno;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&c_bill_doc_type_code;
   sqlstm.sqhstl[7] = (unsigned int  )9;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&c_bill_doc_num;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	
		if (OERROR)
		err_mesg("UPDATE failed on table BL_BILLS_FOR_CONS_RCPT_CANC",0,"");
	      }
	      else
	      {
			/* EXEC SQL UPDATE BL_CANCELLED_BOUNCED_TRX
				 SET UNPOSTED_REASON    = :nd_reason_text_for_update,
				 POSTED_IND             = 'N',  
				 MODIFIED_BY_ID         = user,
				 MODIFIED_DATE          = SYSDATE,
				 MODIFIED_AT_WS_NO	= :nd_ws_no,
				 MODIFIED_FACILITY_ID   = :nd_operating_facility_id 
			         WHERE OPERATING_FACILITY_ID  = :nd_operating_facility_id 
				 AND DOC_TYPE_CODE	= :c_doc_type_code
				 AND DOC_NUMBER		= TO_NUMBER(:c_doc_number)
				 AND DOC_SRNO       = TO_NUMBER(:c_doc_srno); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update BL_CANCELLED_BOUNCED_TRX  set UNPOSTED_REASON=:b0,P\
OSTED_IND='N',MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1,\
MODIFIED_FACILITY_ID=:b2 where (((OPERATING_FACILITY_ID=:b2 and DOC_TYPE_CODE=\
:b4) and DOC_NUMBER=TO_NUMBER(:b5)) and DOC_SRNO=TO_NUMBER(:b6))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5333;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_reason_text_for_update;
   sqlstm.sqhstl[0] = (unsigned int  )53;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&c_doc_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&c_doc_number;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&c_doc_srno;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

		  
		if (OERROR)
		err_mesg("UPDATE failed on table BL_CANCELLED_BOUNCED_TRX",0,"");
		}

	 
	}

	if (nd_reason_text.arr[0] && p_flag == 4)
	{
		/* EXEC SQL UPDATE BL_BILL_HDR
				    SET UNPOSTED_REASON			= :nd_reason_text_for_update,
						BILL_POSTED_FLAG		= 'N',  
						MODIFIED_BY_ID			= user,
						MODIFIED_DATE			= SYSDATE,
						MODIFIED_AT_WS_NO		= :nd_ws_no,
						MODIFIED_FACILITY_ID	= :nd_operating_facility_id 
				  WHERE OPERATING_FACILITY_ID	= :nd_operating_facility_id 
					AND DOC_TYPE_CODE			= :t_doc_type_code
					AND DOC_NUM					= TO_NUMBER(:t_doc_num); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 42;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_BILL_HDR  set UNPOSTED_REASON=:b0,BILL_POSTED_FLA\
G='N',MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=:b1,MODIFIED\
_FACILITY_ID=:b2 where ((OPERATING_FACILITY_ID=:b2 and DOC_TYPE_CODE=:b4) and \
DOC_NUM=TO_NUMBER(:b5))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5376;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_reason_text_for_update;
  sqlstm.sqhstl[0] = (unsigned int  )53;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&t_doc_type_code;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&t_doc_num;
  sqlstm.sqhstl[5] = (unsigned int  )11;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

		  

	 if (OERROR)
		err_mesg("UPDATE failed on table BL_BILL_HDR",0,"");
	}  
}

 
loc_log_msg(str)
char str[];
{
	  disp_message(INFO_MESG,str);
  
	  if (strlen(str) > 70)
		  str[70] = '\0';
  
	  if (err_ctr == 0)
	  continue_to_next_ref();
  
	  log_err_mesg(str,0,"");
	  err_ctr++;
}  

lock_msg(str)
char str[];
{
  if (strlen(str) > 70)
      str[70] = '\0';
  log_err_mesg(str,0,"");
}

continue_to_next_ref()
{
    /* EXEC SQL ROLLBACK WORK TO SAVEPOINT LAST_DOC_REF; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "rollback work  to LAST_DOC_REF";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5415;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
		err_mesg("ROLLBACK TO LAST_DOC_REF failed 3",0,""); 
}

upd_recref_unpost_reason()
{
/* EXEC SQL EXECUTE 
DECLARE
PRAGMA AUTONOMOUS_TRANSACTION;
BEGIN
	UPDATE	BL_RECEIPT_REFUND_DTL
		 SET	UNPOSTED_REASON			= SUBSTR(:msg_str_var,1,50)		
		 WHERE	OPERATING_FACILITY_ID		= :nd_operating_facility_id 
		 AND	DOC_TYPE_CODE			= :recref_doc_type_code
		 AND	DOC_NUMBER			= TO_NUMBER(:recref_doc_number) 
		 AND    DOC_SRNO            = TO_NUMBER(:recref_doc_srno)
		 AND	trunc(DOC_DATE)			= to_date(:recref_doc_date,'DD/MM/YYYY');
	commit;
END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 42;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare PRAGMA AUTONOMOUS_TRANSACTION ; BEGIN UPDATE BL_RECEI\
PT_REFUND_DTL SET UNPOSTED_REASON = SUBSTR ( :msg_str_var , 1 , 50 ) WHERE OPE\
RATING_FACILITY_ID = :nd_operating_facility_id AND DOC_TYPE_CODE = :recref_doc\
_type_code AND DOC_NUMBER = TO_NUMBER ( :recref_doc_number ) AND DOC_SRNO = TO\
_NUMBER ( :recref_doc_srno ) AND trunc ( DOC_DATE ) = to_date ( :recref_doc_da\
te , 'DD/MM/YYYY' ) ; commit ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )5430;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)msg_str_var;
sqlstm.sqhstl[0] = (unsigned int  )1000;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
sqlstm.sqhstl[1] = (unsigned int  )5;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&recref_doc_type_code;
sqlstm.sqhstl[2] = (unsigned int  )9;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&recref_doc_number;
sqlstm.sqhstl[3] = (unsigned int  )11;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&recref_doc_srno;
sqlstm.sqhstl[4] = (unsigned int  )7;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&recref_doc_date;
sqlstm.sqhstl[5] = (unsigned int  )15;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
}


get_acc_int_code()
{
		ae_adj_exempt_acc_int_code.arr[0] = '\0';
		ae_adj_exempt_acc_int_code.len = 0;

		/* EXEC SQL SELECT DECODE(:ae_adjust_exempt_ind,'E',EXEMPTION_RECV_ACC_INT_CODE,
				                             'A',ADJUSTMENT_RECV_ACC_INT_CODE)
		INTO :ae_adj_exempt_acc_int_code
		FROM BL_BILL_TYPE_INT
		WHERE ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					   WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
		AND BILL_TYPE_CODE  = :ae_bill_type_code
		AND to_date(:ae_doc_date,'DD/MM/YYYY') between 
		    NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) 
		AND NVL(EFF_TO_DATE,SYSDATE); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 42;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DECODE(:b0,'E',EXEMPTION_RECV_ACC_INT_CODE,'A',ADJUS\
TMENT_RECV_ACC_INT_CODE) into :b1  from BL_BILL_TYPE_INT where ((ACC_ENTITY_CO\
DE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b2) and\
 BILL_TYPE_CODE=:b3) and to_date(:b4,'DD/MM/YYYY') between NVL(EFF_FROM_DATE,T\
O_DATE('01/01/1900','DD/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5469;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&ae_adjust_exempt_ind;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&ae_adj_exempt_acc_int_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&ae_bill_type_code;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&ae_doc_date;
  sqlstm.sqhstl[4] = (unsigned int  )32;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		if (ROW_COUNT == 0)    
		{	   
		      sprintf(msg_str,"Record for %s - %s not found in BL_BILL_TYPE_INT",
				  nd_operating_facility_id.arr,
				  ae_bill_type_code.arr);
				  
		      loc_log_msg(msg_str);	   
		      g_error = 1;
		      return;
		}		

	       if (strcmp(ae_adj_exempt_acc_int_code.arr, "\0")==0) 	
		   {
                     if (ae_adjust_exempt_ind.arr[0] == 'A' )
			sprintf(msg_str,"Adjustment Account code is not defined for Bill Type %s",
				  ae_bill_type_code.arr);
		     else
			sprintf(msg_str,"Exemption Account code is not defined for Bill Type %s",
				  ae_bill_type_code.arr);
				  
		     loc_log_msg(msg_str);	   
		     g_error = 1;
		     return;
		   }
		   ae_adj_exempt_acc_int_code.arr[ae_adj_exempt_acc_int_code.len] = '\0';
}


get_acc_int_code_by_payer()
{
		ae_adj_exempt_acc_int_code.arr[0] = '\0';
		ae_adj_exempt_acc_int_code.len = 0;

		/* EXEC SQL SELECT DECODE(:ae_adjust_exempt_ind,'E',EXEMPTION_RECV_ACC_INT_CODE,
				                             'A',ADJUSTMENT_RECV_ACC_INT_CODE)
		INTO :ae_adj_exempt_acc_int_code
		FROM BL_BILL_TYPE_BY_PAYER_INT
		WHERE ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					   WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
		AND BILL_TYPE_CODE  = :ae_bill_type_code AND CUST_CODE = :ae_cust_code
		AND to_date(:ae_doc_date,'DD/MM/YYYY') between 
		    NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) 
		AND NVL(EFF_TO_DATE,SYSDATE); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 42;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DECODE(:b0,'E',EXEMPTION_RECV_ACC_INT_CODE,'A',ADJUS\
TMENT_RECV_ACC_INT_CODE) into :b1  from BL_BILL_TYPE_BY_PAYER_INT where (((ACC\
_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_I\
D=:b2) and BILL_TYPE_CODE=:b3) and CUST_CODE=:b4) and to_date(:b5,'DD/MM/YYYY'\
) between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) and NVL(EFF_TO\
_DATE,SYSDATE))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5504;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&ae_adjust_exempt_ind;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&ae_adj_exempt_acc_int_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&ae_bill_type_code;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&ae_cust_code;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&ae_doc_date;
  sqlstm.sqhstl[5] = (unsigned int  )32;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     
	   ae_adj_exempt_acc_int_code.arr[ae_adj_exempt_acc_int_code.len] = '\0';
}



void get_bank_acc_ae()
{
    bankac_main_acc1_code.arr[0]       = '\0';
    bankac_main_acc2_code.arr[0]       = '\0';
    bankac_dept_code.arr[0]            = '\0';
    bankac_subledger_group_code.arr[0] = '\0';
    bankac_subledger_line_code.arr[0]  = '\0';
    bankac_product_group_code.arr[0]   = '\0';
    bankac_product_line_code.arr[0]    = '\0';

    bankac_main_acc1_code.len         = 0;
    bankac_main_acc2_code.len         = 0;
    bankac_dept_code.len              = 0;
    bankac_subledger_group_code.len   = 0;
    bankac_subledger_line_code.len    = 0;
    bankac_product_group_code.len     = 0;
    bankac_product_line_code.len      = 0;

    
    /* EXEC SQL OPEN BL_GL_ACCOUNT_AE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0034;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5543;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&ae_adj_exempt_acc_int_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
    if (OERROR)
       err_mesg("OPEN failed on BL_GL_ACCOUNT_AE_CUR",0,"");

    /* EXEC SQL FETCH BL_GL_ACCOUNT_AE_CUR INTO
		      :bankac_main_acc1_code ,
		      :bankac_main_acc2_code ,
		      :bankac_dept_code,
		      :bankac_subledger_group_code,
		      :bankac_subledger_line_code,
		      :bankac_product_group_code,
		      :bankac_product_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5566;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bankac_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bankac_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bankac_dept_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bankac_subledger_group_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bankac_subledger_line_code;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bankac_product_group_code;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bankac_product_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR) {
	log_mesg("FETCH failed on BL_GL_ACCOUNT_AE_CUR",0,"");		
	return;}

  
   if (ROW_COUNT == 0)    
        {	   
	   sprintf(msg_str,"Record for %s - %s not found in BL_GL_ACCOUNT",
			  nd_operating_facility_id.arr,
			  ae_adj_exempt_acc_int_code.arr);
			  
	   loc_log_msg(msg_str);	   
	   g_error = 1;
	   return;
       }


   bankac_main_acc1_code.arr[bankac_main_acc1_code.len]             = '\0';
   bankac_main_acc2_code.arr[bankac_main_acc2_code.len]             = '\0';
   bankac_dept_code.arr[bankac_dept_code.len]                       = '\0';
   bankac_subledger_group_code.arr[bankac_subledger_group_code.len] = '\0';
   bankac_subledger_line_code.arr[bankac_subledger_line_code.len]   = '\0';
   bankac_product_group_code.arr[bankac_product_group_code.len]     = '\0';
   bankac_product_line_code.arr[bankac_product_line_code.len]       = '\0';
}

void get_other_acc_ae(int i) /* 1 - BILL, 3 - DC */
{    
    othrac_main_acc1_code.arr[0]       = '\0';
    othrac_main_acc2_code.arr[0]       = '\0';
    othrac_dept_code.arr[0]            = '\0';
    othrac_subledger_group_code.arr[0] = '\0';
    othrac_subledger_line_code.arr[0]  = '\0';
    othrac_product_group_code.arr[0]   = '\0';
    othrac_product_line_code.arr[0]    = '\0';

    othrac_main_acc1_code.len         = 0;
    othrac_main_acc2_code.len         = 0;
    othrac_dept_code.len              = 0;
    othrac_subledger_group_code.len   = 0;
    othrac_subledger_line_code.len    = 0;
    othrac_product_group_code.len     = 0;
    othrac_product_line_code.len      = 0;

    switch (i) {
    case 1: 

        /* EXEC SQL OPEN BL_GL_ACCOUNT_OTHER_AE_BL_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 42;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0035;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )5609;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[0] = (unsigned int  )5;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&ae_adj_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&ae_adj_doc_num;
        sqlstm.sqhstl[2] = (unsigned int  )32;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
        if (OERROR)
	{
       log_mesg("OPEN failed on BL_GL_ACCOUNT_OTHER_AE_BL_CUR",0,"");
	   return;
	}

        /* EXEC SQL FETCH BL_GL_ACCOUNT_OTHER_AE_BL_CUR INTO
		:othrac_main_acc1_code,
		:othrac_main_acc2_code,
		:othrac_dept_code,
		:othrac_subledger_group_code,
		:othrac_subledger_line_code,
		:othrac_product_group_code,
		:othrac_product_line_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 42;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )5640;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&othrac_main_acc1_code;
        sqlstm.sqhstl[0] = (unsigned int  )9;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&othrac_main_acc2_code;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&othrac_dept_code;
        sqlstm.sqhstl[2] = (unsigned int  )13;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&othrac_subledger_group_code;
        sqlstm.sqhstl[3] = (unsigned int  )6;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&othrac_subledger_line_code;
        sqlstm.sqhstl[4] = (unsigned int  )11;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&othrac_product_group_code;
        sqlstm.sqhstl[5] = (unsigned int  )6;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&othrac_product_line_code;
        sqlstm.sqhstl[6] = (unsigned int  )7;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



        if (OERROR) 
	{
           log_mesg("FETCH failed on BL_GL_ACCOUNT_OTHER_AE_BL_CUR",0,"");
	   return;
	}
        if (ROW_COUNT == 0)    
        {

	   nd_dcp_bill_type_code.arr[0] = '\0';
	   nd_dcp_bill_type_code.len = 0;

	   /* EXEC SQL SELECT BILL_TYPE_CODE INTO :nd_dcp_bill_type_code 
	   FROM BL_BILL_HDR
	   WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND DOC_TYPE_CODE = :ae_adj_doc_type_code
	   AND DOC_NUM = :ae_adj_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select BILL_TYPE_CODE into :b0  from BL_BILL_HDR where ((\
OPERATING_FACILITY_ID=:b1 and DOC_TYPE_CODE=:b2) and DOC_NUM=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5683;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_dcp_bill_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&ae_adj_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&ae_adj_doc_num;
    sqlstm.sqhstl[3] = (unsigned int  )32;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	   nd_dcp_bill_type_code.arr[nd_dcp_bill_type_code.len] = '\0';

	   if (OERROR)
	   {
		log_mesg("FETCH failed on BL_BILL_HDR",0,"");
		return;
	   }

	   if (ROW_COUNT == 0)
	   {
		sprintf(msg_str,"Record for %s - %s not found in BL_BILL_HDR",
				 ae_adj_doc_type_code.arr,
				 ae_adj_doc_num.arr);				
	   }	
	   else
	   {
		sprintf(msg_str,"SELECT failed for Bill Type %s - %s in BL_GL_ACCOUNT for the bill document %s - %s",
				 nd_operating_facility_id.arr,
				 nd_dcp_bill_type_code.arr,
				 ae_adj_doc_type_code.arr,
				 ae_adj_doc_num.arr);						
	   }		  


			  
	   loc_log_msg(msg_str);	   
	   g_error = 1;
	   return;
       }

         /* EXEC SQL CLOSE BL_GL_ACCOUNT_OTHER_BL_CUR; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 42;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )5714;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


         break;
    
    case 3: 

        /* EXEC SQL OPEN BL_GL_ACCOUNT_OTHER_AE_DC_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 42;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0036;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )5729;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[0] = (unsigned int  )5;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&ae_patient_id;
        sqlstm.sqhstl[1] = (unsigned int  )23;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&ae_adj_doc_type_code;
        sqlstm.sqhstl[2] = (unsigned int  )9;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&ae_adj_doc_num;
        sqlstm.sqhstl[3] = (unsigned int  )32;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[4] = (unsigned int  )5;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
        if (OERROR) {
           log_mesg("OPEN failed on BL_GL_ACCOUNT_OTHER_AE_DC_CUR",0,"");
	   return;
	}

        /* EXEC SQL FETCH BL_GL_ACCOUNT_OTHER_AE_DC_CUR INTO
                          :othrac_main_acc1_code ,
                          :othrac_main_acc2_code ,
                          :othrac_dept_code,
                          :othrac_subledger_group_code,
                          :othrac_subledger_line_code,
                          :othrac_product_group_code,
                          :othrac_product_line_code; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 42;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )5764;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&othrac_main_acc1_code;
        sqlstm.sqhstl[0] = (unsigned int  )9;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&othrac_main_acc2_code;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&othrac_dept_code;
        sqlstm.sqhstl[2] = (unsigned int  )13;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&othrac_subledger_group_code;
        sqlstm.sqhstl[3] = (unsigned int  )6;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&othrac_subledger_line_code;
        sqlstm.sqhstl[4] = (unsigned int  )11;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&othrac_product_group_code;
        sqlstm.sqhstl[5] = (unsigned int  )6;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&othrac_product_line_code;
        sqlstm.sqhstl[6] = (unsigned int  )7;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



        if (OERROR) {
           log_mesg("FETCH failed on BL_GL_ACCOUNT_OTHER_AE_DC_CUR",0,"");
	   return;
	}
	

	if (ROW_COUNT == 0)
	{
		
		nd_dcp_bill_type_code.arr[0] = '\0';
		nd_dcp_bill_type_code.len = 0;

		/* EXEC SQL SELECT BILL_TYPE_CODE INTO :nd_dcp_bill_type_code 
		FROM BL_BILL_HDR
		WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND DOC_TYPE_CODE = :ae_adj_doc_type_code
		AND DOC_NUM = :ae_adj_doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 42;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select BILL_TYPE_CODE into :b0  from BL_BILL_HDR where ((OP\
ERATING_FACILITY_ID=:b1 and DOC_TYPE_CODE=:b2) and DOC_NUM=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5807;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_dcp_bill_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&ae_adj_doc_type_code;
  sqlstm.sqhstl[2] = (unsigned int  )9;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&ae_adj_doc_num;
  sqlstm.sqhstl[3] = (unsigned int  )32;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	

		if (OERROR)
		{
			log_mesg("FETCH failed on BL_BILL_HDR",0,"");
			return;
		}

		nd_dcp_bill_type_code.arr[nd_dcp_bill_type_code.len] = '\0';

		if (ROW_COUNT == 0)
		{
		sprintf(msg_str,"Record for %s - %s not found in BL_BILL_HDR",
				 ae_adj_doc_type_code.arr,
				 ae_adj_doc_num.arr);				
		}	
		else
		{
			sprintf(msg_str,"SELECT failed for Bill Type %s - %s in BL_GL_ACCOUNT for the DCP document %s - %s",
				 nd_operating_facility_id.arr,
				 nd_dcp_bill_type_code.arr,
				 ae_adj_doc_type_code.arr,
				 ae_adj_doc_num.arr);								
		}	
			
		

	   loc_log_msg(msg_str);
	   g_error = 1;	   
	   return;
	}

        /* EXEC SQL CLOSE BL_GL_ACCOUNT_OTHER_DC_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 42;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )5838;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


        break;
    }

    othrac_main_acc1_code.arr[othrac_main_acc1_code.len]             = '\0';
    othrac_main_acc2_code.arr[othrac_main_acc2_code.len]             = '\0';
    othrac_dept_code.arr[othrac_dept_code.len]                       = '\0';
    othrac_subledger_group_code.arr[othrac_subledger_group_code.len] = '\0';
    othrac_subledger_line_code.arr[othrac_subledger_line_code.len]   = '\0';
    othrac_product_group_code.arr[othrac_product_group_code.len]     = '\0';
    othrac_product_line_code.arr[othrac_product_line_code.len]       = '\0';
}

void open_bl_bill_adj_exempt_cur()
{
   /* EXEC SQL OPEN BL_BILL_ADJ_EXEMPT_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0032;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5853;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
       err_mesg("OPEN failed on cursor BL_BILL_ADJ_EXEMPT_CUR",0,"");
}

void open_bl_bill_adj_canc_cur()
{
   /* EXEC SQL OPEN BL_BILL_ADJ_EXEMPT_CANC_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0033;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5876;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
       err_mesg("OPEN failed on cursor BL_BILL_ADJ_EXEMPT_CANC_CUR",0,"");
}



int fetch_bl_bill_adj_exempt_cur()
{
       ae_rowid.arr[0] = '\0';
       ae_doc_type_code.arr[0] = '\0';                   	       	                                      
       ae_doc_num.arr[0] = '\0';
       ae_doc_date.arr[0] = '\0';                                
       ae_adj_exempt_acc_int_code.arr[0] = '\0';                
       ae_adjust_exempt_ind.arr[0] = '\0';                      
       ae_posted_ind.arr[0] = '\0';	                                    	       
       ae_unposted_reason.arr[0] = '\0';                        
       ae_episode_type.arr[0] = '\0';
       ae_adj_doc_type_code.arr[0] = '\0';
       ae_adj_doc_num.arr[0] = '\0';
       ae_adj_doc_date.arr[0] = '\0';
       ae_remarks.arr[0] = '\0';
       ae_bill_dcp_ind.arr[0] = '\0';
       ae_trx_type_code.arr[0] = '\0';
       
       ae_doc_amt.arr[0] = '\0';
       ae_doc_rev_amt.arr[0] = '\0';
       //ae_cancelled_ind.arr[0] = '\0';
       //ae_adj_exm_doc_ref.arr[0] = '\0';
       ae_bill_type_code.arr[0] = '\0';
       ae_cust_code.arr[0] = '\0';

       ae_rowid.len = 0;
       ae_doc_type_code.len = 0;
       ae_doc_num.len = 0;
       ae_doc_date.len = 0;
       ae_adj_exempt_acc_int_code.len = 0;
       ae_adjust_exempt_ind.len = 0;
       ae_posted_ind.len = 0;
       ae_unposted_reason.len = 0;
       ae_episode_type.len = 0;
       ae_adj_doc_type_code.len = 0;
       ae_adj_doc_num.len = 0;
       ae_adj_doc_date.len = 0;
       ae_remarks.len = 0;
       ae_bill_dcp_ind.len = 0;
       ae_trx_type_code.len = 0;
       ae_cust_code.len = 0;

       ae_doc_amt.len = 0;
       ae_doc_rev_amt.len = 0;
       //ae_cancelled_ind.len = 0;
       //ae_adj_exm_doc_ref.len = 0;
       ae_bill_type_code.len = 0;

       ae_doc_slno = 0;
       ae_post_month = 0;
       ae_post_year = 0;
       ae_episode_id = 0;
       ae_visit_id = 0;

       /* EXEC SQL FETCH BL_BILL_ADJ_EXEMPT_CUR INTO	       
	       ae_rowid,
	       ae_doc_type_code,                   
	       ae_doc_num,                         
	       ae_doc_slno,                               
	       ae_doc_date,                      
	       ae_doc_amt,                                
	       ae_doc_rev_amt,
	       ae_adj_exempt_acc_int_code,                
	       ae_adjust_exempt_ind,                      
	       ae_posted_ind,                             
	       ae_post_month,                             
	       ae_post_year,                              
	       ae_unposted_reason,                        
	       ae_episode_type,
	       ae_episode_id,                             
	       ae_visit_id,                               	       
	       ae_adj_doc_type_code,               
	       ae_adj_doc_num,                     
	       ae_adj_doc_date,
	       ae_remarks,                                	
	       ae_bill_dcp_ind,
	       ae_trx_type_code,
	       ae_bill_type_code,
		   ae_cust_code; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 42;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )5899;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&ae_rowid;
       sqlstm.sqhstl[0] = (unsigned int  )32;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&ae_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&ae_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )22;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&ae_doc_slno;
       sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&ae_doc_date;
       sqlstm.sqhstl[4] = (unsigned int  )32;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&ae_doc_amt;
       sqlstm.sqhstl[5] = (unsigned int  )32;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&ae_doc_rev_amt;
       sqlstm.sqhstl[6] = (unsigned int  )32;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&ae_adj_exempt_acc_int_code;
       sqlstm.sqhstl[7] = (unsigned int  )9;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&ae_adjust_exempt_ind;
       sqlstm.sqhstl[8] = (unsigned int  )4;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&ae_posted_ind;
       sqlstm.sqhstl[9] = (unsigned int  )4;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&ae_post_month;
       sqlstm.sqhstl[10] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&ae_post_year;
       sqlstm.sqhstl[11] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&ae_unposted_reason;
       sqlstm.sqhstl[12] = (unsigned int  )53;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&ae_episode_type;
       sqlstm.sqhstl[13] = (unsigned int  )4;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&ae_episode_id;
       sqlstm.sqhstl[14] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&ae_visit_id;
       sqlstm.sqhstl[15] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&ae_adj_doc_type_code;
       sqlstm.sqhstl[16] = (unsigned int  )9;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&ae_adj_doc_num;
       sqlstm.sqhstl[17] = (unsigned int  )32;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&ae_adj_doc_date;
       sqlstm.sqhstl[18] = (unsigned int  )32;
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&ae_remarks;
       sqlstm.sqhstl[19] = (unsigned int  )203;
       sqlstm.sqhsts[19] = (         int  )0;
       sqlstm.sqindv[19] = (         void  *)0;
       sqlstm.sqinds[19] = (         int  )0;
       sqlstm.sqharm[19] = (unsigned int  )0;
       sqlstm.sqadto[19] = (unsigned short )0;
       sqlstm.sqtdso[19] = (unsigned short )0;
       sqlstm.sqhstv[20] = (         void  *)&ae_bill_dcp_ind;
       sqlstm.sqhstl[20] = (unsigned int  )4;
       sqlstm.sqhsts[20] = (         int  )0;
       sqlstm.sqindv[20] = (         void  *)0;
       sqlstm.sqinds[20] = (         int  )0;
       sqlstm.sqharm[20] = (unsigned int  )0;
       sqlstm.sqadto[20] = (unsigned short )0;
       sqlstm.sqtdso[20] = (unsigned short )0;
       sqlstm.sqhstv[21] = (         void  *)&ae_trx_type_code;
       sqlstm.sqhstl[21] = (unsigned int  )4;
       sqlstm.sqhsts[21] = (         int  )0;
       sqlstm.sqindv[21] = (         void  *)0;
       sqlstm.sqinds[21] = (         int  )0;
       sqlstm.sqharm[21] = (unsigned int  )0;
       sqlstm.sqadto[21] = (unsigned short )0;
       sqlstm.sqtdso[21] = (unsigned short )0;
       sqlstm.sqhstv[22] = (         void  *)&ae_bill_type_code;
       sqlstm.sqhstl[22] = (unsigned int  )5;
       sqlstm.sqhsts[22] = (         int  )0;
       sqlstm.sqindv[22] = (         void  *)0;
       sqlstm.sqinds[22] = (         int  )0;
       sqlstm.sqharm[22] = (unsigned int  )0;
       sqlstm.sqadto[22] = (unsigned short )0;
       sqlstm.sqtdso[22] = (unsigned short )0;
       sqlstm.sqhstv[23] = (         void  *)&ae_cust_code;
       sqlstm.sqhstl[23] = (unsigned int  )11;
       sqlstm.sqhsts[23] = (         int  )0;
       sqlstm.sqindv[23] = (         void  *)0;
       sqlstm.sqinds[23] = (         int  )0;
       sqlstm.sqharm[23] = (unsigned int  )0;
       sqlstm.sqadto[23] = (unsigned short )0;
       sqlstm.sqtdso[23] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	      if (OERROR)
	      err_mesg("FETCH failed on BL_BILL_ADJ_EXEMPT_CUR",0,"");

	      if (LAST_ROW) return (0);
	       
	       ae_rowid.arr[ae_rowid.len] = '\0';
	       ae_doc_type_code.arr[ae_doc_type_code.len] = '\0';                   	       	                                      
	       ae_doc_num.arr[ae_doc_num.len] = '\0';
	       ae_doc_date.arr[ae_doc_date.len] = '\0';                                
	       ae_adj_exempt_acc_int_code.arr[ae_adj_exempt_acc_int_code.len] = '\0';                
	       ae_adjust_exempt_ind.arr[ae_adjust_exempt_ind.len] = '\0';                      
	       ae_posted_ind.arr[ae_posted_ind.len] = '\0';	                                    	       
	       ae_unposted_reason.arr[ae_unposted_reason.len] = '\0';                        
	       ae_episode_type.arr[ae_episode_type.len] = '\0';
	       ae_adj_doc_type_code.arr[ae_adj_doc_type_code.len] = '\0';
	       ae_adj_doc_num.arr[ae_adj_doc_num.len] = '\0';
	       ae_adj_doc_date.arr[ae_adj_doc_date.len] = '\0';
	       ae_remarks.arr[ae_remarks.len] = '\0';
	       ae_bill_dcp_ind.arr[ae_bill_dcp_ind.len] = '\0';	
	       ae_trx_type_code.arr[ae_trx_type_code.len] = '\0';	       
	       ae_doc_amt.arr[ae_doc_amt.len] = '\0';
	       ae_doc_rev_amt.arr[ae_doc_rev_amt.len] = '\0';
	       ae_bill_type_code.arr[ae_bill_type_code.len] = '\0';

	       ae_patient_id.arr[0] = '\0';
	       ae_cancelled_ind.arr[0] = '\0';
	       ae_adj_exm_doc_ref.arr[0] = '\0';	       

	       ae_patient_id.len = 0;
	       ae_cancelled_ind.len = 0;
	       ae_adj_exm_doc_ref.len = 0;

	       /* EXEC SQL SELECT A.PATIENT_ID, 'N', A.ADJ_EXM_DOC_REF
			INTO :ae_patient_id, :ae_cancelled_ind, :ae_adj_exm_doc_ref
			FROM BL_BILL_ADJ_HDR A
			WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id			
			AND A.DOC_TYPE_CODE = :ae_doc_type_code
			AND A.DOC_NUM = :ae_doc_num; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 42;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select A.PATIENT_ID ,'N' ,A.ADJ_EXM_DOC_REF into :b0,\
:b1,:b2  from BL_BILL_ADJ_HDR A where ((A.OPERATING_FACILITY_ID=:b3 and A.DOC_\
TYPE_CODE=:b4) and A.DOC_NUM=:b5)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )6010;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&ae_patient_id;
        sqlstm.sqhstl[0] = (unsigned int  )23;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&ae_cancelled_ind;
        sqlstm.sqhstl[1] = (unsigned int  )4;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&ae_adj_exm_doc_ref;
        sqlstm.sqhstl[2] = (unsigned int  )33;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&ae_doc_type_code;
        sqlstm.sqhstl[4] = (unsigned int  )9;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&ae_doc_num;
        sqlstm.sqhstl[5] = (unsigned int  )22;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR)
	        err_mesg("SELECT failed on BL_BILL_ADJ_HDR",0,"");

		/* Cancelled always 'N' only */

		ae_patient_id.arr[ae_patient_id.len] = '\0';
		ae_cancelled_ind.arr[ae_cancelled_ind.len] = '\0';
	        ae_adj_exm_doc_ref.arr[ae_adj_exm_doc_ref.len] = '\0';

		return 1;
   }


int fetch_bl_bill_adj_canc_cur()
{
       ae_rowid.arr[0] = '\0';
       ae_doc_type_code.arr[0] = '\0';                   	       	                                      
       ae_doc_num.arr[0] = '\0';
       ae_doc_date.arr[0] = '\0';                                
       ae_adj_exempt_acc_int_code.arr[0] = '\0';                
       ae_adjust_exempt_ind.arr[0] = '\0';                      
       ae_posted_ind.arr[0] = '\0';	                                    	       
       ae_unposted_reason.arr[0] = '\0';                        
       ae_episode_type.arr[0] = '\0';
       ae_adj_doc_type_code.arr[0] = '\0';
       ae_adj_doc_num.arr[0] = '\0';
       ae_adj_doc_date.arr[0] = '\0';
       ae_remarks.arr[0] = '\0';
       ae_bill_dcp_ind.arr[0] = '\0';
       ae_trx_type_code.arr[0] = '\0'; 
       ae_doc_amt.arr[0] = '\0';
       ae_doc_rev_amt.arr[0] = '\0';  
       ae_bill_type_code.arr[0] = '\0';
       
       ae_rowid.len = 0;
       ae_doc_type_code.len = 0;
       ae_doc_num.len = 0;
       ae_doc_date.len = 0;
       ae_adj_exempt_acc_int_code.len = 0;
       ae_adjust_exempt_ind.len = 0;
       ae_posted_ind.len = 0;
       ae_unposted_reason.len = 0;
       ae_episode_type.len = 0;
       ae_adj_doc_type_code.len = 0;
       ae_adj_doc_num.len = 0;
       ae_adj_doc_date.len = 0;
       ae_remarks.len = 0;
       ae_bill_dcp_ind.len = 0;
       ae_trx_type_code.len = 0;
       ae_doc_amt.len = 0;
       ae_doc_rev_amt.len = 0;
       ae_bill_type_code.len = 0;
       
       ae_doc_slno = 0;
       ae_post_month = 0;
       ae_post_year = 0;
       ae_episode_id = 0;
       ae_visit_id = 0;

       /* EXEC SQL FETCH BL_BILL_ADJ_EXEMPT_CANC_CUR INTO	       
	       ae_rowid,
	       ae_doc_type_code,                   
	       ae_doc_num,                         
	       ae_doc_slno,                               
	       ae_doc_date,                      
	       ae_doc_amt,                                
	       ae_doc_rev_amt,
	       ae_adj_exempt_acc_int_code,                
	       ae_adjust_exempt_ind,                      
	       ae_posted_ind,                             
	       ae_post_month,                             
	       ae_post_year,                              
	       ae_unposted_reason,                        
	       ae_episode_type,
	       ae_episode_id,                             
	       ae_visit_id,                               	       
	       ae_adj_doc_type_code,               
	       ae_adj_doc_num,                     
	       ae_adj_doc_date,
	       ae_remarks,                                	
	       ae_bill_dcp_ind,
	       ae_trx_type_code,
	       ae_bill_type_code,
		   ae_cust_code; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 42;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )6049;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&ae_rowid;
       sqlstm.sqhstl[0] = (unsigned int  )32;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&ae_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&ae_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )22;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&ae_doc_slno;
       sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&ae_doc_date;
       sqlstm.sqhstl[4] = (unsigned int  )32;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&ae_doc_amt;
       sqlstm.sqhstl[5] = (unsigned int  )32;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&ae_doc_rev_amt;
       sqlstm.sqhstl[6] = (unsigned int  )32;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&ae_adj_exempt_acc_int_code;
       sqlstm.sqhstl[7] = (unsigned int  )9;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&ae_adjust_exempt_ind;
       sqlstm.sqhstl[8] = (unsigned int  )4;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&ae_posted_ind;
       sqlstm.sqhstl[9] = (unsigned int  )4;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&ae_post_month;
       sqlstm.sqhstl[10] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&ae_post_year;
       sqlstm.sqhstl[11] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&ae_unposted_reason;
       sqlstm.sqhstl[12] = (unsigned int  )53;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&ae_episode_type;
       sqlstm.sqhstl[13] = (unsigned int  )4;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&ae_episode_id;
       sqlstm.sqhstl[14] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&ae_visit_id;
       sqlstm.sqhstl[15] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&ae_adj_doc_type_code;
       sqlstm.sqhstl[16] = (unsigned int  )9;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&ae_adj_doc_num;
       sqlstm.sqhstl[17] = (unsigned int  )32;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&ae_adj_doc_date;
       sqlstm.sqhstl[18] = (unsigned int  )32;
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&ae_remarks;
       sqlstm.sqhstl[19] = (unsigned int  )203;
       sqlstm.sqhsts[19] = (         int  )0;
       sqlstm.sqindv[19] = (         void  *)0;
       sqlstm.sqinds[19] = (         int  )0;
       sqlstm.sqharm[19] = (unsigned int  )0;
       sqlstm.sqadto[19] = (unsigned short )0;
       sqlstm.sqtdso[19] = (unsigned short )0;
       sqlstm.sqhstv[20] = (         void  *)&ae_bill_dcp_ind;
       sqlstm.sqhstl[20] = (unsigned int  )4;
       sqlstm.sqhsts[20] = (         int  )0;
       sqlstm.sqindv[20] = (         void  *)0;
       sqlstm.sqinds[20] = (         int  )0;
       sqlstm.sqharm[20] = (unsigned int  )0;
       sqlstm.sqadto[20] = (unsigned short )0;
       sqlstm.sqtdso[20] = (unsigned short )0;
       sqlstm.sqhstv[21] = (         void  *)&ae_trx_type_code;
       sqlstm.sqhstl[21] = (unsigned int  )4;
       sqlstm.sqhsts[21] = (         int  )0;
       sqlstm.sqindv[21] = (         void  *)0;
       sqlstm.sqinds[21] = (         int  )0;
       sqlstm.sqharm[21] = (unsigned int  )0;
       sqlstm.sqadto[21] = (unsigned short )0;
       sqlstm.sqtdso[21] = (unsigned short )0;
       sqlstm.sqhstv[22] = (         void  *)&ae_bill_type_code;
       sqlstm.sqhstl[22] = (unsigned int  )5;
       sqlstm.sqhsts[22] = (         int  )0;
       sqlstm.sqindv[22] = (         void  *)0;
       sqlstm.sqinds[22] = (         int  )0;
       sqlstm.sqharm[22] = (unsigned int  )0;
       sqlstm.sqadto[22] = (unsigned short )0;
       sqlstm.sqtdso[22] = (unsigned short )0;
       sqlstm.sqhstv[23] = (         void  *)&ae_cust_code;
       sqlstm.sqhstl[23] = (unsigned int  )11;
       sqlstm.sqhsts[23] = (         int  )0;
       sqlstm.sqindv[23] = (         void  *)0;
       sqlstm.sqinds[23] = (         int  )0;
       sqlstm.sqharm[23] = (unsigned int  )0;
       sqlstm.sqadto[23] = (unsigned short )0;
       sqlstm.sqtdso[23] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	      if (OERROR)
	      err_mesg("FETCH failed on BL_BILL_ADJ_EXEMPT_CANC_CUR",0,"");

	      if (LAST_ROW) return (0);
	       
	       ae_rowid.arr[ae_rowid.len] = '\0';
	       ae_doc_type_code.arr[ae_doc_type_code.len] = '\0';                   	       	                                      
	       ae_doc_num.arr[ae_doc_num.len] = '\0';
	       ae_doc_date.arr[ae_doc_date.len] = '\0';                                
	       ae_adj_exempt_acc_int_code.arr[ae_adj_exempt_acc_int_code.len] = '\0';                
	       ae_adjust_exempt_ind.arr[ae_adjust_exempt_ind.len] = '\0';                      
	       ae_posted_ind.arr[ae_posted_ind.len] = '\0';	                                    	       
	       ae_unposted_reason.arr[ae_unposted_reason.len] = '\0';                        
	       ae_episode_type.arr[ae_episode_type.len] = '\0';
	       ae_adj_doc_type_code.arr[ae_adj_doc_type_code.len] = '\0';
	       ae_adj_doc_num.arr[ae_adj_doc_num.len] = '\0';
	       ae_adj_doc_date.arr[ae_adj_doc_date.len] = '\0';
	       ae_remarks.arr[ae_remarks.len] = '\0';
	       ae_bill_dcp_ind.arr[ae_bill_dcp_ind.len] = '\0';	
	       ae_trx_type_code.arr[ae_trx_type_code.len] = '\0';	       
	       ae_doc_amt.arr[ae_doc_amt.len] = '\0';
	       ae_doc_rev_amt.arr[ae_doc_rev_amt.len] = '\0';
	       ae_bill_type_code.arr[ae_bill_type_code.len] = '\0';
		   ae_cust_code.arr[ae_cust_code.len] = '\0';
		

	       ae_patient_id.arr[0] = '\0';
	       ae_cancelled_ind.arr[0] = '\0';
	       ae_adj_exm_doc_ref.arr[0] = '\0';

	       ae_patient_id.len = 0;
	       ae_cancelled_ind.len = 0;
	       ae_adj_exm_doc_ref.len = 0;
		   


	       /* EXEC SQL SELECT A.PATIENT_ID, NVL(A.CANCELLED_YN,'N'), A.ADJ_EXM_DOC_REF
			INTO :ae_patient_id, :ae_cancelled_ind, :ae_adj_exm_doc_ref
			FROM BL_BILL_ADJ_HDR A
			WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id			
			AND A.DOC_TYPE_CODE = :ae_doc_type_code
			AND A.DOC_NUM = :ae_doc_num; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 42;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select A.PATIENT_ID ,NVL(A.CANCELLED_YN,'N') ,A.ADJ_E\
XM_DOC_REF into :b0,:b1,:b2  from BL_BILL_ADJ_HDR A where ((A.OPERATING_FACILI\
TY_ID=:b3 and A.DOC_TYPE_CODE=:b4) and A.DOC_NUM=:b5)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )6160;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&ae_patient_id;
        sqlstm.sqhstl[0] = (unsigned int  )23;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&ae_cancelled_ind;
        sqlstm.sqhstl[1] = (unsigned int  )4;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&ae_adj_exm_doc_ref;
        sqlstm.sqhstl[2] = (unsigned int  )33;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[3] = (unsigned int  )5;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&ae_doc_type_code;
        sqlstm.sqhstl[4] = (unsigned int  )9;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&ae_doc_num;
        sqlstm.sqhstl[5] = (unsigned int  )22;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqphsv = sqlstm.sqhstv;
        sqlstm.sqphsl = sqlstm.sqhstl;
        sqlstm.sqphss = sqlstm.sqhsts;
        sqlstm.sqpind = sqlstm.sqindv;
        sqlstm.sqpins = sqlstm.sqinds;
        sqlstm.sqparm = sqlstm.sqharm;
        sqlstm.sqparc = sqlstm.sqharc;
        sqlstm.sqpadto = sqlstm.sqadto;
        sqlstm.sqptdso = sqlstm.sqtdso;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		ae_patient_id.arr[ae_patient_id.len] = '\0';
		ae_cancelled_ind.arr[ae_cancelled_ind.len] = '\0';
	        ae_adj_exm_doc_ref.arr[ae_adj_exm_doc_ref.len] = '\0';

		return 1;
   }



   void move_into_post_acc_ae(int i /* 0 - BANK ; 1 - OTHER */)
   {
   if (i==0)
   {
    strcpy(xxxxxx_main_acc1_code.arr,bankac_main_acc1_code.arr);
    xxxxxx_main_acc1_code.len = strlen(xxxxxx_main_acc1_code.arr);

    strcpy(xxxxxx_main_acc2_code.arr,bankac_main_acc2_code.arr);
    xxxxxx_main_acc2_code.len = strlen(xxxxxx_main_acc2_code.arr);

    strcpy(xxxxxx_dept_code.arr,bankac_dept_code.arr);
    xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);

    strcpy(xxxxxx_subledger_group_code.arr,bankac_subledger_group_code.arr);
    xxxxxx_subledger_group_code.len = strlen(xxxxxx_subledger_group_code.arr);

    strcpy(xxxxxx_subledger_line_code.arr,bankac_subledger_line_code.arr);
    xxxxxx_subledger_line_code.len = strlen(xxxxxx_subledger_line_code.arr);

    strcpy(xxxxxx_product_group_code.arr,bankac_product_group_code.arr);
    xxxxxx_product_group_code.len = strlen(xxxxxx_product_group_code.arr);

    strcpy(xxxxxx_product_line_code.arr,bankac_product_line_code.arr);
    xxxxxx_product_line_code.len = strlen(xxxxxx_product_line_code.arr);

    strcpy(xxxxxx_doc_amt.arr,ae_doc_amt.arr);
    xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);
   }
   else
   {
    strcpy(xxxxxx_main_acc1_code.arr,othrac_main_acc1_code.arr);
    xxxxxx_main_acc1_code.len = strlen(xxxxxx_main_acc1_code.arr);

    strcpy(xxxxxx_main_acc2_code.arr,othrac_main_acc2_code.arr);
    xxxxxx_main_acc2_code.len = strlen(xxxxxx_main_acc2_code.arr);

    strcpy(xxxxxx_dept_code.arr,othrac_dept_code.arr);
    xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);

    strcpy(xxxxxx_subledger_group_code.arr,othrac_subledger_group_code.arr);
    xxxxxx_subledger_group_code.len = strlen(xxxxxx_subledger_group_code.arr);

    strcpy(xxxxxx_subledger_line_code.arr,othrac_subledger_line_code.arr);
    xxxxxx_subledger_line_code.len = strlen(xxxxxx_subledger_line_code.arr);

    strcpy(xxxxxx_product_group_code.arr,othrac_product_group_code.arr);
    xxxxxx_product_group_code.len = strlen(xxxxxx_product_group_code.arr);

    strcpy(xxxxxx_product_line_code.arr,othrac_product_line_code.arr);
    xxxxxx_product_line_code.len = strlen(xxxxxx_product_line_code.arr);

    strcpy(xxxxxx_doc_amt.arr,ae_doc_rev_amt.arr);
    xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);

   }
}

void ins_bldcp_trn_ae()
{
   l_dcp_trn_rec_exist = 0;   

   /* l_dcp_trn_rec_exist -> 1 means Record Exist */

   /* EXEC SQL SELECT 1 INTO :l_dcp_trn_rec_exist 
	    FROM BL_DCP_TRN
	    WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
	    AND PATIENT_ID = :ae_patient_id
	    AND ORG_DOC_TYPE_CODE = :ae_adj_doc_type_code
            AND ORG_DOC_NUMBER = :ae_adj_doc_num 
	    AND DOC_TYPE_CODE = :ae_doc_type_code 
	    AND DOC_NUMBER = :ae_doc_num
	    AND NVL(DOC_SRL_NO,0) = NVL(:ae_doc_slno,0)
	    AND NVL(CANCELLED_ENTRY_YN,'N') = NVL(:ae_cancelled_ind,'N')
	    FOR UPDATE OF TRX_STATUS; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select 1 into :b0  from BL_DCP_TRN where (((((((OPERATING_\
FACILITY_ID=:b1 and PATIENT_ID=:b2) and ORG_DOC_TYPE_CODE=:b3) and ORG_DOC_NUM\
BER=:b4) and DOC_TYPE_CODE=:b5) and DOC_NUMBER=:b6) and NVL(DOC_SRL_NO,0)=NVL(\
:b7,0)) and NVL(CANCELLED_ENTRY_YN,'N')=NVL(:b8,'N')) for update of TRX_STATUS\
 ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )6199;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_dcp_trn_rec_exist;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ae_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ae_adj_doc_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ae_adj_doc_num;
   sqlstm.sqhstl[4] = (unsigned int  )32;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ae_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&ae_doc_num;
   sqlstm.sqhstl[6] = (unsigned int  )22;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&ae_doc_slno;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&ae_cancelled_ind;
   sqlstm.sqhstl[8] = (unsigned int  )4;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	    

   if (NO_DATA_FOUND) 
	l_dcp_trn_rec_exist = 0;
		
   if (l_dcp_trn_rec_exist == 1)
   {
	  /* EXEC SQL UPDATE BL_DCP_TRN
	  SET POSTED_DATE = SYSDATE,
	      POSTED_BY_ID = USER
	  WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
	  AND PATIENT_ID = :ae_patient_id
	  AND ORG_DOC_TYPE_CODE = :ae_adj_doc_type_code
          AND ORG_DOC_NUMBER = :ae_adj_doc_num 
	  AND DOC_TYPE_CODE = :ae_doc_type_code 
	  AND DOC_NUMBER = :ae_doc_num
	  AND NVL(DOC_SRL_NO,0) = NVL(:ae_doc_slno,0)
	  AND NVL(CANCELLED_ENTRY_YN,'N') = NVL(:ae_cancelled_ind,'N'); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update BL_DCP_TRN  set POSTED_DATE=SYSDATE,POSTED_BY_ID=US\
ER where (((((((OPERATING_FACILITY_ID=:b0 and PATIENT_ID=:b1) and ORG_DOC_TYPE\
_CODE=:b2) and ORG_DOC_NUMBER=:b3) and DOC_TYPE_CODE=:b4) and DOC_NUMBER=:b5) \
and NVL(DOC_SRL_NO,0)=NVL(:b6,0)) and NVL(CANCELLED_ENTRY_YN,'N')=NVL(:b7,'N')\
)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )6250;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ae_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ae_adj_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ae_adj_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )32;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ae_doc_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ae_doc_num;
   sqlstm.sqhstl[5] = (unsigned int  )22;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&ae_doc_slno;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&ae_cancelled_ind;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    }
   else
   {	   
	   /* Rec/Ref fun. is inserting one record from front end. So, no need to insert record here */

	   pendoc_max_line_num.arr[0] = '\0';
	   pendoc_max_line_num.len = 0;

	   /* EXEC SQL SELECT ROWID, nvl(max_line_num,0) + 1
		    INTO :pendoc_rowid, :pendoc_max_line_num
		    FROM BL_DCP_PENDING_DOC
		    WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		    AND PATIENT_ID = :ae_patient_id
		    AND ORG_DOC_TYPE_CODE = :ae_adj_doc_type_code
		    AND ORG_DOC_NUMBER = :ae_adj_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ROWID ,(nvl(max_line_num,0)+1) into :b0,:b1  from \
BL_DCP_PENDING_DOC where (((OPERATING_FACILITY_ID=:b2 and PATIENT_ID=:b3) and \
ORG_DOC_TYPE_CODE=:b4) and ORG_DOC_NUMBER=:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )6297;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&pendoc_rowid;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&pendoc_max_line_num;
    sqlstm.sqhstl[1] = (unsigned int  )12;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&ae_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&ae_adj_doc_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&ae_adj_doc_num;
    sqlstm.sqhstl[5] = (unsigned int  )32;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

		

	   if (OERROR || NO_DATA_FOUND) 
	   {
	      log_mesg("SELECT failed on BL_DCP_PENDING_DOC",0,"");
	      return;
	   }

	   pendoc_max_line_num.arr[pendoc_max_line_num.len] = '\0';


	/* EXEC SQL INSERT INTO BL_DCP_TRN
		     ( OPERATING_FACILITY_ID,
		       PATIENT_ID,
		       ORG_DOC_TYPE_CODE,
		       ORG_DOC_NUMBER,
		       LINE_NUM,
		       DOC_TYPE_CODE,
		       DOC_NUMBER,
		       DOC_DATE,
		       PAT_DOC_REFERENCE,
		       DOC_NATURE_CODE,
		       DOC_AMT,
		       TRX_TYPE_CODE,
		       NARRATION,
		       POST_MONTH,
		       POST_YEAR,
		       POSTED_DATE,
		       POSTED_BY_ID,
		       ADDED_BY_ID,
		       MODIFIED_BY_ID,         
		       ADDED_DATE,             
		       MODIFIED_DATE,          
		       ADDED_AT_WS_NO,         
		       ADDED_FACILITY_ID,      
		       MODIFIED_AT_WS_NO,      
		       MODIFIED_FACILITY_ID,
		       DOC_SRL_NO,             
		       CANCELLED_ENTRY_YN )

	    VALUES   ( :nd_operating_facility_id,
		       :ae_patient_id,
		       :ae_adj_doc_type_code,
		       :ae_adj_doc_num ,
		       :pendoc_max_line_num,
		       :ae_doc_type_code,
		       :ae_doc_num,
		       TO_DATE(:ae_doc_date,'DD/MM/YYYY'),
		       substr(:ae_adj_exm_doc_ref,1,10),
		       NULL,
		       :ae_doc_rev_amt, 
		       :ae_trx_type_code,
		       substr(:ae_remarks,1,50),
		       :ae_post_month,
		       :ae_post_year,
		       sysdate,
		       user,
		       user,
		       user,
		       sysdate,
		       sysdate,
		       :nd_ws_no,
		       :nd_operating_facility_id,
		       :nd_ws_no,
		       :nd_operating_facility_id,
		       :ae_doc_slno,
		       :ae_cancelled_ind); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 42;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into BL_DCP_TRN (OPERATING_FACILITY_ID,PATIENT_ID,ORG\
_DOC_TYPE_CODE,ORG_DOC_NUMBER,LINE_NUM,DOC_TYPE_CODE,DOC_NUMBER,DOC_DATE,PAT_D\
OC_REFERENCE,DOC_NATURE_CODE,DOC_AMT,TRX_TYPE_CODE,NARRATION,POST_MONTH,POST_Y\
EAR,POSTED_DATE,POSTED_BY_ID,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DA\
TE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DOC\
_SRL_NO,CANCELLED_ENTRY_YN) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,TO_DATE(:b7,'D\
D/MM/YYYY'),substr(:b8,1,10),null ,:b9,:b10,substr(:b11,1,50),:b12,:b13,sysdat\
e,user,user,user,sysdate,sysdate,:b14,:b0,:b14,:b0,:b18,:b19)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )6336;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ae_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ae_adj_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ae_adj_doc_num;
 sqlstm.sqhstl[3] = (unsigned int  )32;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&pendoc_max_line_num;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&ae_doc_type_code;
 sqlstm.sqhstl[5] = (unsigned int  )9;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&ae_doc_num;
 sqlstm.sqhstl[6] = (unsigned int  )22;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&ae_doc_date;
 sqlstm.sqhstl[7] = (unsigned int  )32;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&ae_adj_exm_doc_ref;
 sqlstm.sqhstl[8] = (unsigned int  )33;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&ae_doc_rev_amt;
 sqlstm.sqhstl[9] = (unsigned int  )32;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&ae_trx_type_code;
 sqlstm.sqhstl[10] = (unsigned int  )4;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&ae_remarks;
 sqlstm.sqhstl[11] = (unsigned int  )203;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&ae_post_month;
 sqlstm.sqhstl[12] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&ae_post_year;
 sqlstm.sqhstl[13] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[14] = (unsigned int  )33;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[15] = (unsigned int  )5;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[16] = (unsigned int  )33;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[17] = (unsigned int  )5;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&ae_doc_slno;
 sqlstm.sqhstl[18] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&ae_cancelled_ind;
 sqlstm.sqhstl[19] = (unsigned int  )4;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	   if (OERROR) {
	       log_mesg("INSERT failed on table BL_DCP_TRN",0,"");
	       return;
	   }

	   /* EXEC SQL UPDATE	BL_DCP_PENDING_DOC
		    SET		MAX_LINE_NUM = NVL(MAX_LINE_NUM,0) + 1,
				MODIFIED_BY_ID         = user,
				MODIFIED_DATE          = SYSDATE,
				ADDED_AT_WS_NO         = :nd_ws_no,
				ADDED_FACILITY_ID      = :nd_operating_facility_id,
				MODIFIED_AT_WS_NO      = :nd_ws_no,
				MODIFIED_FACILITY_ID   = :nd_operating_facility_id
		    WHERE	ROWID = :pendoc_rowid
		    AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_DCP_PENDING_DOC  set MAX_LINE_NUM=(NVL(MAX_LINE\
_NUM,0)+1),MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED_\
FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where (ROWID=:b\
4 and OPERATING_FACILITY_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )6431;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&pendoc_rowid;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	   if (OERROR || NO_DATA_FOUND)
	   {
	      log_mesg("UPDATE failed on BL_DCP_PENDING_DOC",0,"");
	      return;
	   }
    }
}


void ins_blgl_distrib_ae()
{    
    if( (ae_episode_type.arr[0] == 'I' && d_ip_gl_yn == 'N') ||
        (ae_episode_type.arr[0] == 'D' && d_ip_gl_yn == 'N') ||
        (ae_episode_type.arr[0] == 'O' && d_op_gl_yn == 'N') ||
	(ae_episode_type.arr[0] == 'E' && d_op_gl_yn == 'N') ||
        (ae_episode_type.arr[0] == 'R' && d_rf_gl_yn == 'N') ) 

	return;	

   /* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION 
             ( OPERATING_FACILITY_ID,	
	       MAIN_ACC1_CODE,
               MAIN_ACC2_CODE,
               DEPT_CODE,
               PRODUCT_GROUP_CODE,
               PRODUCT_LINE_CODE,
               SUBLEDGER_GROUP_CODE,
               SUBLEDGER_LINE_CODE,
               POST_YEAR,
               POST_MONTH,
               TRX_DATE,
               TRX_DOC_REF,
               TRX_DOC_REF_LINE_NUM,
               TRX_DOC_REF_SEQ_NUM,
               EPISODE_TYPE,
               PATIENT_ID,
               EPISODE_ID,
               VISIT_ID,
               SOURCE_DOC_REF,
               SOURCE_DOC_DATE,
               NARRATION,
               TRX_TYPE_CODE,
               DISTRIBUTION_AMT,
               GL_INTERFACE_BY_ID,
               GL_INTERFACE_DATE,
               GL_INTERFACE_FLAG,
               DOC_REF,
	       ADDED_BY_ID,
	       MODIFIED_BY_ID,         
	       ADDED_DATE,             
               MODIFIED_DATE,          
               ADDED_AT_WS_NO,         
               ADDED_FACILITY_ID,      
               MODIFIED_AT_WS_NO,      
               MODIFIED_FACILITY_ID,
	       CASH_CTRL_DOC_TYPE,     
	       CASH_CTRL_DOC_NUMBER,   
	       CASH_CTRL_DOC_DATE,
	       CUST_CODE      
	     )
    VALUES(    :nd_operating_facility_id,
	       :xxxxxx_main_acc1_code,
               :xxxxxx_main_acc2_code,
               :xxxxxx_dept_code,
               :xxxxxx_product_group_code,
               :xxxxxx_product_line_code,
               :xxxxxx_subledger_group_code,
               :xxxxxx_subledger_line_code,
               :ae_post_year,
               :ae_post_month,
               TO_DATE(:ae_doc_date,'DD/MM/YYYY'),
               RPAD(:ae_doc_type_code,6)||SUBSTR(TO_CHAR(to_number(:ae_doc_num),'00000009'),2,8),
               :ae_doc_slno,
               0,
               :ae_episode_type,
               :ae_patient_id,
               :ae_episode_id,
               :ae_visit_id,
               NULL,
               NULL,
               substr(:ae_remarks,1,50),
               :ae_trx_type_code,
               :xxxxxx_doc_amt,
               NULL,
               NULL,
               'N',
               null, /o :recref_bank_recon_ref, o/
	       user,
	       user,
	       sysdate,
	       sysdate,
	       :nd_ws_no,
	       :nd_operating_facility_id,
	       :nd_ws_no,
	       :nd_operating_facility_id,
	       null, // :nd_doc_type,
	       null, //:nd_doc_num,
	       null, //:nd_doc_date,
	       null //:recref_customer_code
	); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (OPERATING_FACILITY_ID,MAIN\
_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,SUBLE\
DGER_GROUP_CODE,SUBLEDGER_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF,\
TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VI\
SIT_ID,SOURCE_DOC_REF,SOURCE_DOC_DATE,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT\
,GL_INTERFACE_BY_ID,GL_INTERFACE_DATE,GL_INTERFACE_FLAG,DOC_REF,ADDED_BY_ID,MO\
DIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIE\
D_AT_WS_NO,MODIFIED_FACILITY_ID,CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,CASH_C\
TRL_DOC_DATE,CUST_CODE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,TO_DAT\
E(:b10,'DD/MM/YYYY'),(RPAD(:b11,6)||SUBSTR(TO_CHAR(to_number(:b12),'00000009')\
,2,8)),:b13,0,:b14,:b15,:b16,:b17,null ,null ,substr(:b18,1,50),:b19,:b20,null\
 ,null ,'N',null ,user,user,sysdate,sysdate,:b21,:b0,:b21,:b0,null ,null ,null\
 ,null )";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )6470;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&xxxxxx_main_acc1_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&xxxxxx_main_acc2_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&xxxxxx_dept_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&xxxxxx_product_group_code;
   sqlstm.sqhstl[4] = (unsigned int  )6;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&xxxxxx_product_line_code;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&xxxxxx_subledger_group_code;
   sqlstm.sqhstl[6] = (unsigned int  )6;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&xxxxxx_subledger_line_code;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&ae_post_year;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&ae_post_month;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&ae_doc_date;
   sqlstm.sqhstl[10] = (unsigned int  )32;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&ae_doc_type_code;
   sqlstm.sqhstl[11] = (unsigned int  )9;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&ae_doc_num;
   sqlstm.sqhstl[12] = (unsigned int  )22;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&ae_doc_slno;
   sqlstm.sqhstl[13] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&ae_episode_type;
   sqlstm.sqhstl[14] = (unsigned int  )4;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&ae_patient_id;
   sqlstm.sqhstl[15] = (unsigned int  )23;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&ae_episode_id;
   sqlstm.sqhstl[16] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&ae_visit_id;
   sqlstm.sqhstl[17] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&ae_remarks;
   sqlstm.sqhstl[18] = (unsigned int  )203;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&ae_trx_type_code;
   sqlstm.sqhstl[19] = (unsigned int  )4;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&xxxxxx_doc_amt;
   sqlstm.sqhstl[20] = (unsigned int  )23;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[21] = (unsigned int  )33;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[22] = (unsigned int  )5;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[23] = (unsigned int  )33;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[24] = (unsigned int  )5;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




   if (OERROR) 
   {
       log_mesg("INSERT failed on table BL_GL_DISTRIBUTION",0,"");
       return;
   }
}

post_bill_adj_exempt()
{
	open_bl_bill_adj_exempt_cur();
	g_error = 0;
	g_savepoint = 0;

	while(fetch_bl_bill_adj_exempt_cur())
	{
	     if(g_error) do_rollback();

	     /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "savepoint LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )6585;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	     if (OERROR)
		err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

             g_savepoint = 1;
	     
	     get_acc_int_code();
	     if(g_error) continue;

		if (ae_cust_code.arr[0] != '\0')
		   {
		     get_acc_int_code_by_payer(); /* New Enhancement 2007 */
				if (ROW_COUNT == 0) 
				get_acc_int_code();
			}
			else
			{
			get_acc_int_code();
			}

	     get_bank_acc_ae();
	     if(g_error) continue;

	     if (ae_bill_dcp_ind.arr[0] == 'D') 
		 get_other_acc_ae(DC);
	     else
		 get_other_acc_ae(BILL);

	     if(g_error) continue;

	     move_into_post_acc_ae(BANK);
	     if (ae_bill_dcp_ind.arr[0] == 'D' )
	     {
		ins_bldcp_trn_ae();
		if(g_error) continue;
             }
             ins_blgl_distrib_ae();
	     if(g_error) continue;
             move_into_post_acc_ae(OTHER);
             ins_blgl_distrib_ae();
	     if(g_error) continue;	
	     
	     update_bill_adj_exempt();
	     if(g_error) continue;

	     /* EXEC SQL COMMIT; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )6600;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
}

post_bill_adj_exempt_cancel()
{
	open_bl_bill_adj_canc_cur();
	g_error = 0;
	g_savepoint = 0;

	while(fetch_bl_bill_adj_canc_cur())
	{
	     if(g_error) do_rollback();

	     /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "savepoint LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )6615;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	     if (OERROR)
		err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

             g_savepoint = 1;

	     get_acc_int_code();
	     if(g_error) continue;

		 if (ae_cust_code.arr[0] != '\0')
		     get_acc_int_code_by_payer(); /* New Enhancement 2007 */

	     get_bank_acc_ae();
	     if(g_error) continue;

	     if (ae_bill_dcp_ind.arr[0] == 'D') 
		get_other_acc_ae(DC);
	     else
		get_other_acc_ae(BILL);

	     if(g_error) continue;

	     move_into_post_acc_ae(BANK);
	     if (ae_bill_dcp_ind.arr[0] == 'D' )
	     {
		ins_bldcp_trn_ae();
		if(g_error) continue;
             }
             ins_blgl_distrib_ae();
	     if(g_error) continue;
             move_into_post_acc_ae(OTHER);
             ins_blgl_distrib_ae();
	     if(g_error) continue;		     
	  
	     update_bill_adj_exempt_canc();
	     if(g_error) continue;

	     /* EXEC SQL COMMIT; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )6630;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
}

void update_bill_adj_exempt()
{
    /* EXEC SQL UPDATE BL_BILL_ADJ_DTL
	     SET POSTED_IND = 'Y',
	     UNPOSTED_REASON = NULL,
	     MODIFIED_BY_ID = USER,
	     MODIFIED_DATE  = SYSDATE,
	     ADDED_AT_WS_NO = :nd_ws_no,
	     ADDED_FACILITY_ID = :nd_operating_facility_id,
	     MODIFIED_AT_WS_NO = :nd_ws_no,
	     MODIFIED_FACILITY_ID = :nd_operating_facility_id
          WHERE ROWID = :ae_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_BILL_ADJ_DTL  set POSTED_IND='Y',UNPOSTED_REASO\
N=null ,MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED_FAC\
ILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWID=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )6645;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&ae_rowid;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR) 
       err_mesg("UPDATE failed on table BL_BILL_ADJ_DTL",0,"");
       
    if (sqlca.sqlerrd[2] == 0 )
       err_mesg("UPDATE failed on table BL_BILL_ADJ_DTL",0,"");
}

void update_bill_adj_exempt_canc()
{
    /* EXEC SQL UPDATE BL_BILL_ADJ_DTL_CANC
	     SET POSTED_IND = 'Y',
	     UNPOSTED_REASON = NULL,
	     MODIFIED_BY_ID = USER,
	     MODIFIED_DATE  = SYSDATE,
	     ADDED_AT_WS_NO = :nd_ws_no,
	     ADDED_FACILITY_ID = :nd_operating_facility_id,
	     MODIFIED_AT_WS_NO = :nd_ws_no,
	     MODIFIED_FACILITY_ID = :nd_operating_facility_id
          WHERE ROWID = :ae_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_BILL_ADJ_DTL_CANC  set POSTED_IND='Y',UNPOSTED_\
REASON=null ,MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDE\
D_FACILITY_ID=:b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWID=:\
b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )6680;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&ae_rowid;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR) 
       err_mesg("UPDATE failed on table BL_BILL_ADJ_DTL_CANC",0,"");
       
    if (sqlca.sqlerrd[2] == 0 )
       err_mesg("UPDATE failed on table BL_BILL_ADJ_DTL_CANC",0,"");
}

//added by deepali on 29/08/2004

void open_bl_bill_wo_cur()
{
   /* EXEC SQL OPEN BL_BILL_WO_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0037;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )6715;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
       err_mesg("OPEN failed on cursor BL_BILL_WO_CUR",0,"");
}

int fetch_bl_bill_wo_cur()
{
       wo_rowid.arr[0] = '\0';
       wo_doc_type_code.arr[0] = '\0';                   	       	                                      
       wo_doc_num.arr[0] = '\0';
       wo_doc_date.arr[0] = '\0';                                
       wo_posted_ind.arr[0] = '\0';	                                    	       
       wo_episode_type.arr[0] = '\0';
       wo_org_doc_type_code.arr[0] = '\0';
       wo_org_doc_num.arr[0] = '\0';
       wo_org_doc_date.arr[0] = '\0';
       wo_remarks.arr[0] = '\0';
       wo_trx_type_code.arr[0] = '\0';
       wo_bill_type_code.arr[0] = '\0';
	   wo_cust_code.arr[0] = '\0';

       wo_doc_amt.arr[0] = '\0';
       wo_doc_rev_amt.arr[0] = '\0';
       
       wo_rowid.len = 0;
       wo_doc_type_code.len = 0;
       wo_doc_num.len = 0;
       wo_doc_date.len = 0;
       wo_posted_ind.len = 0;
       wo_episode_type.len = 0;
       wo_org_doc_type_code.len = 0;
       wo_org_doc_num.len = 0;
       wo_org_doc_date.len = 0;
       wo_remarks.len = 0;
       wo_trx_type_code.len = 0;
	   wo_bill_type_code.len = 0;
	   wo_cust_code.len = 0;
	   	
       wo_doc_amt.len = 0;
       wo_doc_rev_amt.len = 0;

       wo_doc_slno = 0;
       //ae_post_month = 0;
       //ae_post_year = 0;
       wo_episode_id = 0;
       wo_visit_id = 0;


       /* EXEC SQL FETCH BL_BILL_WO_CUR INTO	       
	       wo_rowid,
	       wo_doc_type_code,                   
	       wo_doc_num,                         
	       wo_doc_slno,                               
	       wo_doc_date,                      
	       wo_doc_amt,                                
	       wo_doc_rev_amt,
	       wo_posted_ind,                             
	       //ae_post_month,                             
	       //ae_post_year,                              
	       //ae_unposted_reason,                        
	       wo_episode_type,
	       wo_episode_id,                             
	       wo_visit_id,                               	       
	       wo_org_doc_type_code,               
	       wo_org_num,                     
	       wo_org_doc_date,
	       wo_remarks,                                	
	       wo_trx_type_code,
		   wo_bill_type_code,
		   wo_cust_code; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 42;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )6738;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&wo_rowid;
       sqlstm.sqhstl[0] = (unsigned int  )32;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&wo_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&wo_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )22;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&wo_doc_slno;
       sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
       sqlstm.sqhstl[4] = (unsigned int  )32;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&wo_doc_amt;
       sqlstm.sqhstl[5] = (unsigned int  )32;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&wo_doc_rev_amt;
       sqlstm.sqhstl[6] = (unsigned int  )32;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&wo_posted_ind;
       sqlstm.sqhstl[7] = (unsigned int  )4;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&wo_episode_type;
       sqlstm.sqhstl[8] = (unsigned int  )4;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&wo_episode_id;
       sqlstm.sqhstl[9] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&wo_visit_id;
       sqlstm.sqhstl[10] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&wo_org_doc_type_code;
       sqlstm.sqhstl[11] = (unsigned int  )9;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&wo_org_num;
       sqlstm.sqhstl[12] = (unsigned int  )32;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&wo_org_doc_date;
       sqlstm.sqhstl[13] = (unsigned int  )32;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&wo_remarks;
       sqlstm.sqhstl[14] = (unsigned int  )203;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&wo_trx_type_code;
       sqlstm.sqhstl[15] = (unsigned int  )4;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&wo_bill_type_code;
       sqlstm.sqhstl[16] = (unsigned int  )5;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&wo_cust_code;
       sqlstm.sqhstl[17] = (unsigned int  )11;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	      if (OERROR)
	      err_mesg("FETCH failed on BL_BILL_WO_CUR",0,"");

	      if (LAST_ROW)
		return (0);
		
	       wo_rowid.arr[wo_rowid.len] = '\0';
	       wo_doc_type_code.arr[wo_doc_type_code.len] = '\0';                   	       	                                      
	       wo_doc_num.arr[wo_doc_num.len] = '\0';
	       wo_doc_date.arr[wo_doc_date.len] = '\0';                                
	       wo_posted_ind.arr[wo_posted_ind.len] = '\0';	                                    	       
	       wo_episode_type.arr[wo_episode_type.len] = '\0';
	       wo_org_doc_type_code.arr[wo_org_doc_type_code.len] = '\0';
	       wo_org_doc_num.arr[wo_org_doc_num.len] = '\0';
	       wo_org_doc_date.arr[wo_org_doc_date.len] = '\0';
	       wo_remarks.arr[wo_remarks.len] = '\0';
	       wo_trx_type_code.arr[wo_trx_type_code.len] = '\0';	       
		   wo_bill_type_code.arr[wo_bill_type_code.len] = '\0';
		   wo_cust_code.arr[wo_cust_code.len] = '\0';		
		   
		   wo_doc_amt.arr[wo_doc_amt.len] = '\0';
	       wo_doc_rev_amt.arr[wo_doc_rev_amt.len] = '\0';
			
	   	
		   //get control ac and write off account from BL_BILL_TYPE_INT	
		   wo_bill_recv_int_code.arr[0] = '\0';
		   wo_int_code.arr[0] = '\0';			

			
		   wo_bill_recv_int_code.len = 0;
		   wo_int_code.len = 0;			   
		   

		   /* EXEC SQL SELECT BL_RECV_ACC_INT_CODE, WAIVAL_RECV_ACC_INT_CODE  
					INTO   :wo_bill_recv_int_code, :wo_int_code		
					FROM   BL_BILL_TYPE_INT
					WHERE  ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
												WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
					AND    BILL_TYPE_CODE  = :wo_bill_type_code
					AND    to_date(:wo_doc_date,'dd/mm/yyyy')
					between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) 
					AND     NVL(EFF_TO_DATE,SYSDATE); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 42;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select BL_RECV_ACC_INT_CODE ,WAIVAL_RECV_ACC_INT_CODE in\
to :b0,:b1  from BL_BILL_TYPE_INT where ((ACC_ENTITY_CODE in (select ACC_ENTIT\
Y_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b2) and BILL_TYPE_CODE=:b3) an\
d to_date(:b4,'dd/mm/yyyy') between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD\
/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE))";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )6825;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&wo_bill_recv_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&wo_int_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&wo_bill_type_code;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
     sqlstm.sqhstl[4] = (unsigned int  )32;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		   if (ROW_COUNT == 0)    
		   {	   
		      sprintf(msg_str,"Record(WO) for %s - %s not found in BL_BILL_TYPE_INT",
				  nd_operating_facility_id.arr,
				  wo_bill_type_code.arr);
				  
		      loc_log_msg(msg_str);	   
		      g_error = 1;
		      return;
		   }
	
		   if (strcmp(wo_int_code.arr, "\0")==0) 	
		   {
		      sprintf(msg_str,"Write Off Account code is not defined for Bill Type %s",
				  wo_bill_type_code.arr);
				  
			  loc_log_msg(msg_str);	   
		      g_error = 1;
		      return;
		   }

		   wo_bill_recv_int_code.arr[wo_bill_recv_int_code.len] = '\0';
		   wo_int_code.arr[wo_int_code.len] = '\0';	


		 if (wo_cust_code.arr[0] != '\0')	 		/* Modified on 23-MAR-2007 for Enhancement */
		 {
		   
		   wo_int_code.arr[0] = '\0';			
		   wo_int_code.len = 0;
			 
			 /* EXEC SQL SELECT  WAIVAL_RECV_ACC_INT_CODE  
					INTO     :wo_int_code		
					FROM   BL_BILL_TYPE_BY_PAYER_INT
					WHERE  ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
												WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
					AND    BILL_TYPE_CODE  = :wo_bill_type_code
					AND	   CUST_CODE = :wo_cust_code
					AND    to_date(:wo_doc_date,'dd/mm/yyyy')
					between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) 
					AND     NVL(EFF_TO_DATE,SYSDATE); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select WAIVAL_RECV_ACC_INT_CODE into :b0  from BL_BILL_TY\
PE_BY_PAYER_INT where (((ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_A\
CC_ENTITY where ACC_ENTITY_ID=:b1) and BILL_TYPE_CODE=:b2) and CUST_CODE=:b3) \
and to_date(:b4,'dd/mm/yyyy') between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','\
DD/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )6860;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&wo_int_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&wo_bill_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&wo_cust_code;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



              wo_int_code.arr[wo_int_code.len] = '\0';	
		 }                                         /* Modified on 23-MAR-2007 for Enhancement */



		return 1;
}

void get_bank_acc_wo()
{
    bankac_main_acc1_code.arr[0]       = '\0';
    bankac_main_acc2_code.arr[0]       = '\0';
    bankac_dept_code.arr[0]            = '\0';
    bankac_subledger_group_code.arr[0] = '\0';
    bankac_subledger_line_code.arr[0]  = '\0';
    bankac_product_group_code.arr[0]   = '\0';
    bankac_product_line_code.arr[0]    = '\0';

    bankac_main_acc1_code.len         = 0;
    bankac_main_acc2_code.len         = 0;
    bankac_dept_code.len              = 0;
    bankac_subledger_group_code.len   = 0;
    bankac_subledger_line_code.len    = 0;
    bankac_product_group_code.len     = 0;
    bankac_product_line_code.len      = 0;

    
    /* EXEC SQL OPEN BL_GL_ACCOUNT_WO_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0039;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )6895;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&wo_int_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
    if (OERROR)
       err_mesg("OPEN failed on BL_GL_ACCOUNT_WO_CUR",0,"");

    /* EXEC SQL FETCH BL_GL_ACCOUNT_WO_CUR INTO
		      :bankac_main_acc1_code ,
		      :bankac_main_acc2_code ,
		      :bankac_dept_code,
		      :bankac_subledger_group_code,
		      :bankac_subledger_line_code,
		      :bankac_product_group_code,
		      :bankac_product_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )6918;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bankac_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bankac_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bankac_dept_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bankac_subledger_group_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bankac_subledger_line_code;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bankac_product_group_code;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bankac_product_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR) {
	log_mesg("FETCH failed on BL_GL_ACCOUNT_WO_CUR",0,"");		
	return;}

  
   if (ROW_COUNT == 0)    
        {	   
	   sprintf(msg_str,"Record for %s - %s not found in BL_GL_ACCOUNT",
			  nd_operating_facility_id.arr,
			  wo_int_code.arr);
			  
	   loc_log_msg(msg_str);	   
	   g_error = 1;
	   return;
       }


   bankac_main_acc1_code.arr[bankac_main_acc1_code.len]             = '\0';
   bankac_main_acc2_code.arr[bankac_main_acc2_code.len]             = '\0';
   bankac_dept_code.arr[bankac_dept_code.len]                       = '\0';
   bankac_subledger_group_code.arr[bankac_subledger_group_code.len] = '\0';
   bankac_subledger_line_code.arr[bankac_subledger_line_code.len]   = '\0';
   bankac_product_group_code.arr[bankac_product_group_code.len]     = '\0';
   bankac_product_line_code.arr[bankac_product_line_code.len]       = '\0';
}


void get_bank_acc_bill_recv_int()
{
    bankac_main_acc1_code.arr[0]       = '\0';
    bankac_main_acc2_code.arr[0]       = '\0';
    bankac_dept_code.arr[0]            = '\0';
    bankac_subledger_group_code.arr[0] = '\0';
    bankac_subledger_line_code.arr[0]  = '\0';
    bankac_product_group_code.arr[0]   = '\0';
    bankac_product_line_code.arr[0]    = '\0';

    bankac_main_acc1_code.len         = 0;
    bankac_main_acc2_code.len         = 0;
    bankac_dept_code.len              = 0;
    bankac_subledger_group_code.len   = 0;
    bankac_subledger_line_code.len    = 0;
    bankac_product_group_code.len     = 0;
    bankac_product_line_code.len      = 0;

    
    /* EXEC SQL OPEN BL_GL_ACCOUNT_BILL_RECV_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0040;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )6961;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&wo_bill_recv_int_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
    if (OERROR)
       err_mesg("OPEN failed on BL_GL_ACCOUNT_BILL_RECV_CUR",0,"");

    /* EXEC SQL FETCH BL_GL_ACCOUNT_BILL_RECV_CUR INTO
		      :bankac_main_acc1_code ,
		      :bankac_main_acc2_code ,
		      :bankac_dept_code,
		      :bankac_subledger_group_code,
		      :bankac_subledger_line_code,
		      :bankac_product_group_code,
		      :bankac_product_line_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )6984;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bankac_main_acc1_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bankac_main_acc2_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&bankac_dept_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&bankac_subledger_group_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&bankac_subledger_line_code;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&bankac_product_group_code;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&bankac_product_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR) {
	log_mesg("FETCH failed on BL_GL_ACCOUNT_BILL_RECV_CUR",0,"");		
	return;}

  
   if (ROW_COUNT == 0)    
        {	   
	   sprintf(msg_str,"Record for %s - %s not found in BL_GL_ACCOUNT",
			  nd_operating_facility_id.arr,
			  wo_bill_recv_int_code.arr);
			  
	   loc_log_msg(msg_str);	   
	   g_error = 1;
	   return;
       }


   bankac_main_acc1_code.arr[bankac_main_acc1_code.len]             = '\0';
   bankac_main_acc2_code.arr[bankac_main_acc2_code.len]             = '\0';
   bankac_dept_code.arr[bankac_dept_code.len]                       = '\0';
   bankac_subledger_group_code.arr[bankac_subledger_group_code.len] = '\0';
   bankac_subledger_line_code.arr[bankac_subledger_line_code.len]   = '\0';
   bankac_product_group_code.arr[bankac_product_group_code.len]     = '\0';
   bankac_product_line_code.arr[bankac_product_line_code.len]       = '\0';
}

void move_into_post_acc_wo(int i /* 0 - BANK ; 1 - OTHER */)
   {
   if (i==0)
   {
    strcpy(xxxxxx_main_acc1_code.arr,bankac_main_acc1_code.arr);
    xxxxxx_main_acc1_code.len = strlen(xxxxxx_main_acc1_code.arr);

    strcpy(xxxxxx_main_acc2_code.arr,bankac_main_acc2_code.arr);
    xxxxxx_main_acc2_code.len = strlen(xxxxxx_main_acc2_code.arr);

    strcpy(xxxxxx_dept_code.arr,bankac_dept_code.arr);
    xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);

    strcpy(xxxxxx_subledger_group_code.arr,bankac_subledger_group_code.arr);
    xxxxxx_subledger_group_code.len = strlen(xxxxxx_subledger_group_code.arr);

    strcpy(xxxxxx_subledger_line_code.arr,bankac_subledger_line_code.arr);
    xxxxxx_subledger_line_code.len = strlen(xxxxxx_subledger_line_code.arr);

    strcpy(xxxxxx_product_group_code.arr,bankac_product_group_code.arr);
    xxxxxx_product_group_code.len = strlen(xxxxxx_product_group_code.arr);

    strcpy(xxxxxx_product_line_code.arr,bankac_product_line_code.arr);
    xxxxxx_product_line_code.len = strlen(xxxxxx_product_line_code.arr);

    strcpy(xxxxxx_doc_amt.arr,wo_doc_amt.arr);
    xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);
   }
   else
   {
    strcpy(xxxxxx_main_acc1_code.arr,othrac_main_acc1_code.arr);
    xxxxxx_main_acc1_code.len = strlen(xxxxxx_main_acc1_code.arr);

    strcpy(xxxxxx_main_acc2_code.arr,othrac_main_acc2_code.arr);
    xxxxxx_main_acc2_code.len = strlen(xxxxxx_main_acc2_code.arr);

    strcpy(xxxxxx_dept_code.arr,othrac_dept_code.arr);
    xxxxxx_dept_code.len = strlen(xxxxxx_dept_code.arr);

    strcpy(xxxxxx_subledger_group_code.arr,othrac_subledger_group_code.arr);
    xxxxxx_subledger_group_code.len = strlen(xxxxxx_subledger_group_code.arr);

    strcpy(xxxxxx_subledger_line_code.arr,othrac_subledger_line_code.arr);
    xxxxxx_subledger_line_code.len = strlen(xxxxxx_subledger_line_code.arr);

    strcpy(xxxxxx_product_group_code.arr,othrac_product_group_code.arr);
    xxxxxx_product_group_code.len = strlen(xxxxxx_product_group_code.arr);

    strcpy(xxxxxx_product_line_code.arr,othrac_product_line_code.arr);
    xxxxxx_product_line_code.len = strlen(xxxxxx_product_line_code.arr);

    strcpy(xxxxxx_doc_amt.arr,wo_doc_rev_amt.arr);
    xxxxxx_doc_amt.len = strlen(xxxxxx_doc_amt.arr);

   }
}

void ins_blgl_distrib_wo()
{    
    if( (wo_episode_type.arr[0] == 'I' && d_ip_gl_yn == 'N') ||
        (wo_episode_type.arr[0] == 'D' && d_ip_gl_yn == 'N') ||
        (wo_episode_type.arr[0] == 'O' && d_op_gl_yn == 'N') ||
	(wo_episode_type.arr[0] == 'E' && d_op_gl_yn == 'N') ||
        (wo_episode_type.arr[0] == 'R' && d_rf_gl_yn == 'N') ) 

	return;	


	wo_post_month.arr[0] = '\0';
	wo_post_month.len = 0;

    wo_post_year.arr[0] = '\0';
	wo_post_year.len = 0;


    /* EXEC SQL SELECT nvl(acc_per_year, to_char(to_date(:wo_doc_date,'DD/MM/YYYY'),'YYYY')),
				    nvl(acc_per_month,to_char(to_date(:wo_doc_date,'DD/MM/YYYY'),'MM'))  
			 INTO   :wo_post_year, :wo_post_month
			 FROM   sy_acc_period_defn
			 WHERE  to_date(:wo_doc_date,'DD/MM/YYYY') 
					BETWEEN acc_per_start_date AND acc_per_end_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select nvl(acc_per_year,to_char(to_date(:b0,'DD/MM/YYYY')\
,'YYYY')) ,nvl(acc_per_month,to_char(to_date(:b0,'DD/MM/YYYY'),'MM')) into :b2\
,:b3  from sy_acc_period_defn where to_date(:b0,'DD/MM/YYYY') between acc_per_\
start_date and acc_per_end_date";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )7027;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&wo_doc_date;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&wo_doc_date;
    sqlstm.sqhstl[1] = (unsigned int  )32;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&wo_post_year;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&wo_post_month;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	

	wo_post_month.arr[wo_post_month.len] = '\0';
	wo_post_year.arr[wo_post_year.len]   = '\0';

   /* EXEC SQL INSERT INTO BL_GL_DISTRIBUTION 
             ( OPERATING_FACILITY_ID,	
			   MAIN_ACC1_CODE,
               MAIN_ACC2_CODE,
               DEPT_CODE,
               PRODUCT_GROUP_CODE,
               PRODUCT_LINE_CODE,
               SUBLEDGER_GROUP_CODE,
               SUBLEDGER_LINE_CODE,
               POST_YEAR,
               POST_MONTH,
               TRX_DATE,
               TRX_DOC_REF,
               TRX_DOC_REF_LINE_NUM,
               TRX_DOC_REF_SEQ_NUM,
               EPISODE_TYPE,
               PATIENT_ID,
               EPISODE_ID,
               VISIT_ID,
               SOURCE_DOC_REF,
               SOURCE_DOC_DATE,
               NARRATION,
               TRX_TYPE_CODE,
               DISTRIBUTION_AMT,
               GL_INTERFACE_BY_ID,
               GL_INTERFACE_DATE,
               GL_INTERFACE_FLAG,
               DOC_REF,
	           ADDED_BY_ID,
	           MODIFIED_BY_ID,         
	           ADDED_DATE,             
               MODIFIED_DATE,          
               ADDED_AT_WS_NO,         
               ADDED_FACILITY_ID,      
               MODIFIED_AT_WS_NO,      
               MODIFIED_FACILITY_ID,
	           CASH_CTRL_DOC_TYPE,     
	           CASH_CTRL_DOC_NUMBER,   
	           CASH_CTRL_DOC_DATE,
	           CUST_CODE      
	     )
    VALUES(    :nd_operating_facility_id,
			   :xxxxxx_main_acc1_code,
               :xxxxxx_main_acc2_code,
               :xxxxxx_dept_code,
               :xxxxxx_product_group_code,
               :xxxxxx_product_line_code,
               :xxxxxx_subledger_group_code,
               :xxxxxx_subledger_line_code,
               :wo_post_year,
               :wo_post_month,
               TO_DATE(:wo_doc_date,'DD/MM/YYYY'),
               RPAD(:wo_doc_type_code,6)||SUBSTR(TO_CHAR(to_number(:wo_doc_num),'00000009'),2,8),
               :wo_doc_slno,
               0,
               :wo_episode_type,
               :wo_patient_id,
               :wo_episode_id,
               :wo_visit_id,
               NULL,
               NULL,
               substr(:wo_remarks,1,50),
               :wo_trx_type_code,
               :xxxxxx_doc_amt,
               NULL,
               NULL,
               'N',
               null, /o :recref_bank_recon_ref, o/
			   user,
			   user,
	           sysdate,
	           sysdate,
	           :nd_ws_no,
	           :nd_operating_facility_id,
	           :nd_ws_no,
	           :nd_operating_facility_id,
	           null, // :nd_doc_type,
	           null, //:nd_doc_num,
	           null, //:nd_doc_date,
	           null //:recref_customer_code
	); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into BL_GL_DISTRIBUTION (OPERATING_FACILITY_ID,MAIN\
_ACC1_CODE,MAIN_ACC2_CODE,DEPT_CODE,PRODUCT_GROUP_CODE,PRODUCT_LINE_CODE,SUBLE\
DGER_GROUP_CODE,SUBLEDGER_LINE_CODE,POST_YEAR,POST_MONTH,TRX_DATE,TRX_DOC_REF,\
TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VI\
SIT_ID,SOURCE_DOC_REF,SOURCE_DOC_DATE,NARRATION,TRX_TYPE_CODE,DISTRIBUTION_AMT\
,GL_INTERFACE_BY_ID,GL_INTERFACE_DATE,GL_INTERFACE_FLAG,DOC_REF,ADDED_BY_ID,MO\
DIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIE\
D_AT_WS_NO,MODIFIED_FACILITY_ID,CASH_CTRL_DOC_TYPE,CASH_CTRL_DOC_NUMBER,CASH_C\
TRL_DOC_DATE,CUST_CODE) values (:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,TO_DAT\
E(:b10,'DD/MM/YYYY'),(RPAD(:b11,6)||SUBSTR(TO_CHAR(to_number(:b12),'00000009')\
,2,8)),:b13,0,:b14,:b15,:b16,:b17,null ,null ,substr(:b18,1,50),:b19,:b20,null\
 ,null ,'N',null ,user,user,sysdate,sysdate,:b21,:b0,:b21,:b0,null ,null ,null\
 ,null )";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )7062;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&xxxxxx_main_acc1_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&xxxxxx_main_acc2_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&xxxxxx_dept_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&xxxxxx_product_group_code;
   sqlstm.sqhstl[4] = (unsigned int  )6;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&xxxxxx_product_line_code;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&xxxxxx_subledger_group_code;
   sqlstm.sqhstl[6] = (unsigned int  )6;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&xxxxxx_subledger_line_code;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&wo_post_year;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&wo_post_month;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&wo_doc_date;
   sqlstm.sqhstl[10] = (unsigned int  )32;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&wo_doc_type_code;
   sqlstm.sqhstl[11] = (unsigned int  )9;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&wo_doc_num;
   sqlstm.sqhstl[12] = (unsigned int  )22;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&wo_doc_slno;
   sqlstm.sqhstl[13] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&wo_episode_type;
   sqlstm.sqhstl[14] = (unsigned int  )4;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&wo_patient_id;
   sqlstm.sqhstl[15] = (unsigned int  )23;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&wo_episode_id;
   sqlstm.sqhstl[16] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&wo_visit_id;
   sqlstm.sqhstl[17] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&wo_remarks;
   sqlstm.sqhstl[18] = (unsigned int  )203;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&wo_trx_type_code;
   sqlstm.sqhstl[19] = (unsigned int  )4;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&xxxxxx_doc_amt;
   sqlstm.sqhstl[20] = (unsigned int  )23;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[21] = (unsigned int  )33;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[22] = (unsigned int  )5;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[23] = (unsigned int  )33;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[24] = (unsigned int  )5;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




   if (OERROR) 
   {
       log_mesg("INSERT failed on table BL_GL_DISTRIBUTION",0,"");
       return;
   }
}


update_bill_wo()
{
    /* EXEC SQL UPDATE BL_WO_REQUEST_DTL
	     SET POSTED_IND = 'Y',
	     MODIFIED_BY_ID = USER,
	     MODIFIED_DATE  = SYSDATE,
	     ADDED_AT_WS_NO = :nd_ws_no,
	     ADDED_FACILITY_ID = :nd_operating_facility_id,
	     MODIFIED_AT_WS_NO = :nd_ws_no,
	     MODIFIED_FACILITY_ID = :nd_operating_facility_id
          WHERE ROWID = :wo_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_WO_REQUEST_DTL  set POSTED_IND='Y',MODIFIED_BY_\
ID=USER,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED_FACILITY_ID=:b1,MODIFIE\
D_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWID=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )7177;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&wo_rowid;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR) 
       err_mesg("UPDATE failed on table BL_WO_REQUEST_DTL",0,"");
       
    if (sqlca.sqlerrd[2] == 0 )
       err_mesg("UPDATE failed on table BL_WO_REQUEST_DTL",0,"");    
}


post_bill_wo()
{
	open_bl_bill_wo_cur();
	g_error = 0;
	g_savepoint = 0;

	while(fetch_bl_bill_wo_cur())
	{
	     
	     if(g_error) do_rollback();

	     /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "savepoint LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )7212;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	     if (OERROR)
		err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

             g_savepoint = 1;


	     get_bank_acc_wo();				//positive entry for waival account
	     if(g_error) continue;



	     move_into_post_acc_wo(BANK);
	     ins_blgl_distrib_wo();
	     if(g_error) continue;	


	     get_bank_acc_bill_recv_int();
	     if(g_error) continue;	



	     move_into_post_acc_wo(OTHER);
	     ins_blgl_distrib_wo();
	     if(g_error) continue;



	     update_bill_wo();
	     if(g_error) continue;

	     /* EXEC SQL COMMIT; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )7227;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	     if (OERROR)
		err_mesg("COMMIT failed",0,""); 
	}
}


void open_bl_bill_wo_canc_cur()
{
   /* EXEC SQL OPEN BL_BILL_WO_CANC_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0041;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )7242;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
       err_mesg("OPEN failed on cursor BL_BILL_WO_CANC_CUR",0,"");
}

int fetch_bl_bill_wo_canc_cur()
{
       wo_rowid.arr[0] = '\0';
       wo_doc_type_code.arr[0] = '\0';                   	       	                                      
       wo_doc_num.arr[0] = '\0';
       wo_doc_date.arr[0] = '\0';                                
       wo_posted_ind.arr[0] = '\0';	                                    	       
       wo_episode_type.arr[0] = '\0';
       wo_org_doc_type_code.arr[0] = '\0';
       wo_org_doc_num.arr[0] = '\0';
       wo_org_doc_date.arr[0] = '\0';
       wo_remarks.arr[0] = '\0';
       wo_trx_type_code.arr[0] = '\0';
       wo_bill_type_code.arr[0] = '\0';
	   wo_cust_code.arr[0] = '\0';

       wo_doc_amt.arr[0] = '\0';
       wo_doc_rev_amt.arr[0] = '\0';
       
       wo_rowid.len = 0;
       wo_doc_type_code.len = 0;
       wo_doc_num.len = 0;
       wo_doc_date.len = 0;
       wo_posted_ind.len = 0;
       wo_episode_type.len = 0;
       wo_org_doc_type_code.len = 0;
       wo_org_doc_num.len = 0;
       wo_org_doc_date.len = 0;
       wo_remarks.len = 0;
       wo_trx_type_code.len = 0;
       wo_bill_type_code.len = 0;
	   wo_cust_code.len = 0;
	   	
       wo_doc_amt.len = 0;
       wo_doc_rev_amt.len = 0;

       wo_doc_slno = 0;
       wo_episode_id = 0;
       wo_visit_id = 0;

       /* EXEC SQL FETCH BL_BILL_WO_CANC_CUR INTO	       
	       wo_rowid,
	       wo_doc_type_code,                   
	       wo_doc_num,                         
	       wo_doc_slno,                               
	       wo_doc_date,                      
	       wo_doc_amt,                                
	       wo_doc_rev_amt,
	       wo_posted_ind,                             
	       //ae_post_month,                             
	       //ae_post_year,                              
	       //ae_unposted_reason,                        
	       wo_episode_type,
	       wo_episode_id,                             
	       wo_visit_id,                               	       
	       wo_org_doc_type_code,               
	       wo_org_num,                     
	       wo_org_doc_date,
	       wo_remarks,                                	
	       wo_trx_type_code,
		   wo_bill_type_code,
		   wo_cust_code; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 42;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )7265;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&wo_rowid;
       sqlstm.sqhstl[0] = (unsigned int  )32;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&wo_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&wo_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )22;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&wo_doc_slno;
       sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
       sqlstm.sqhstl[4] = (unsigned int  )32;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&wo_doc_amt;
       sqlstm.sqhstl[5] = (unsigned int  )32;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&wo_doc_rev_amt;
       sqlstm.sqhstl[6] = (unsigned int  )32;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&wo_posted_ind;
       sqlstm.sqhstl[7] = (unsigned int  )4;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&wo_episode_type;
       sqlstm.sqhstl[8] = (unsigned int  )4;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&wo_episode_id;
       sqlstm.sqhstl[9] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&wo_visit_id;
       sqlstm.sqhstl[10] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&wo_org_doc_type_code;
       sqlstm.sqhstl[11] = (unsigned int  )9;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&wo_org_num;
       sqlstm.sqhstl[12] = (unsigned int  )32;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&wo_org_doc_date;
       sqlstm.sqhstl[13] = (unsigned int  )32;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&wo_remarks;
       sqlstm.sqhstl[14] = (unsigned int  )203;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&wo_trx_type_code;
       sqlstm.sqhstl[15] = (unsigned int  )4;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&wo_bill_type_code;
       sqlstm.sqhstl[16] = (unsigned int  )5;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&wo_cust_code;
       sqlstm.sqhstl[17] = (unsigned int  )11;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	      if (OERROR)
	      err_mesg("FETCH failed on BL_BILL_WO_CANC_CUR",0,"");



	      if (LAST_ROW) return (0);


	       
	       wo_rowid.arr[wo_rowid.len] = '\0';
	       wo_doc_type_code.arr[wo_doc_type_code.len] = '\0';                   	       	                                      
	       wo_doc_num.arr[wo_doc_num.len] = '\0';
	       wo_doc_date.arr[wo_doc_date.len] = '\0';                                
	       wo_posted_ind.arr[wo_posted_ind.len] = '\0';	                                    	       
	       wo_episode_type.arr[wo_episode_type.len] = '\0';
	       wo_org_doc_type_code.arr[wo_org_doc_type_code.len] = '\0';
	       wo_org_doc_num.arr[wo_org_doc_num.len] = '\0';
	       wo_org_doc_date.arr[wo_org_doc_date.len] = '\0';
	       wo_remarks.arr[wo_remarks.len] = '\0';
	       wo_trx_type_code.arr[wo_trx_type_code.len] = '\0';	       
		   wo_bill_type_code.arr[wo_bill_type_code.len] = '\0';	
		        
	       wo_doc_amt.arr[wo_doc_amt.len] = '\0';
	       wo_doc_rev_amt.arr[wo_doc_rev_amt.len] = '\0';
		   wo_cust_code.arr[wo_cust_code.len] = '\0';
	   	
		   //get control ac and write off account from BL_BILL_TYPE_INT	
		   wo_bill_recv_int_code.arr[0] = '\0';
		   wo_int_code.arr[0] = '\0';			

		   wo_bill_recv_int_code.len = 0;
		   wo_int_code.len = 0;	
		   


		   /* EXEC SQL SELECT BL_RECV_ACC_INT_CODE, WAIVAL_RECV_ACC_INT_CODE  
					INTO   :wo_bill_recv_int_code, :wo_int_code		
					FROM   BL_BILL_TYPE_INT
					WHERE  ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
												WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
					AND    BILL_TYPE_CODE  = :wo_bill_type_code
					AND    to_date(:wo_doc_date,'DD/MM/YYYY')
					between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) 
					AND     NVL(EFF_TO_DATE,SYSDATE); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 42;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select BL_RECV_ACC_INT_CODE ,WAIVAL_RECV_ACC_INT_CODE in\
to :b0,:b1  from BL_BILL_TYPE_INT where ((ACC_ENTITY_CODE in (select ACC_ENTIT\
Y_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b2) and BILL_TYPE_CODE=:b3) an\
d to_date(:b4,'DD/MM/YYYY') between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD\
/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE))";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )7352;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&wo_bill_recv_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&wo_int_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&wo_bill_type_code;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
     sqlstm.sqhstl[4] = (unsigned int  )32;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}





		   if (ROW_COUNT == 0)    
		   {	   
		      sprintf(msg_str,"Record(WO) for %s - %s not found in BL_BILL_TYPE_INT",
				  nd_operating_facility_id.arr,
				  wo_bill_type_code.arr);
				  
			  loc_log_msg(msg_str);	   
		      g_error = 1;
		      return;
		   }		

		   if (strcmp(wo_int_code.arr, "\0")==0) 	
		   {
		      sprintf(msg_str,"Write Off Account code is not defined for Bill Type %s",
				  wo_bill_type_code.arr);
				  
		      loc_log_msg(msg_str);	   
		      g_error = 1;
		      return;
		   }

		   wo_bill_recv_int_code.arr[wo_bill_recv_int_code.len] = '\0';
		   wo_int_code.arr[wo_int_code.len] = '\0';	

		    if (wo_cust_code.arr[0] != '\0')	 		/* Modified on 23-MAR-2007 for Enhancement */
		 {
		   
		   wo_int_code.arr[0] = '\0';			
		   wo_int_code.len = 0;
			 
			 /* EXEC SQL SELECT WAIVAL_RECV_ACC_INT_CODE  
					INTO    :wo_int_code		
					FROM   BL_BILL_TYPE_BY_PAYER_INT
					WHERE  ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
												WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
					AND    BILL_TYPE_CODE  = :wo_bill_type_code
					AND	   CUST_CODE = :wo_cust_code
					AND    to_date(:wo_doc_date,'dd/mm/yyyy')
					between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) 
					AND     NVL(EFF_TO_DATE,SYSDATE); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select WAIVAL_RECV_ACC_INT_CODE into :b0  from BL_BILL_TY\
PE_BY_PAYER_INT where (((ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_A\
CC_ENTITY where ACC_ENTITY_ID=:b1) and BILL_TYPE_CODE=:b2) and CUST_CODE=:b3) \
and to_date(:b4,'dd/mm/yyyy') between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','\
DD/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )7387;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&wo_int_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&wo_bill_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&wo_cust_code;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



           
		    wo_int_code.arr[wo_int_code.len] = '\0';	
		 }                                         /* Modified on 23-MAR-2007 for Enhancement */





		return 1;
}


void update_bill_canc_wo()
{
    /* EXEC SQL UPDATE BL_WO_REQUEST_CANC_DTL
	     SET POSTED_IND = 'Y',
	     MODIFIED_BY_ID = USER,
	     MODIFIED_DATE  = SYSDATE,
	     ADDED_AT_WS_NO = :nd_ws_no,
	     ADDED_FACILITY_ID = :nd_operating_facility_id,
	     MODIFIED_AT_WS_NO = :nd_ws_no,
	     MODIFIED_FACILITY_ID = :nd_operating_facility_id
         WHERE ROWID = :wo_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_WO_REQUEST_CANC_DTL  set POSTED_IND='Y',MODIFIE\
D_BY_ID=USER,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED_FACILITY_ID=:b1,MO\
DIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWID=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )7422;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&wo_rowid;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR) 
       err_mesg("UPDATE failed on table BL_WO_REQUEST_CANC_DTL",0,"");
       
    if (sqlca.sqlerrd[2] == 0 )
       err_mesg("UPDATE failed on table BL_WO_REQUEST_CANC_DTL",0,"");
}


post_bill_wo_cancel()
{
	open_bl_bill_wo_canc_cur();
	g_error = 0;
	g_savepoint = 0;

	while(fetch_bl_bill_wo_canc_cur())
	{
	   
	     if(g_error) do_rollback();

	     /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "savepoint LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )7457;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	     if (OERROR)
		err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

             g_savepoint = 1;


	     get_bank_acc_wo();				//-ve entry for waival account
	     if(g_error) continue;

		 move_into_post_acc_wo(OTHER);
		 ins_blgl_distrib_wo();
		 if(g_error) continue;	

		 get_bank_acc_bill_recv_int();
		 if(g_error) continue;	

		 move_into_post_acc_wo(BANK);
		 ins_blgl_distrib_wo();
		 if(g_error) continue;

		 update_bill_canc_wo();
		 if(g_error) continue;

	     /* EXEC SQL COMMIT; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )7472;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
}


post_instl_wo()
{
	open_bl_instl_wo_cur();
	g_error = 0;
	g_savepoint = 0;

	while(fetch_bl_instl_wo_cur())
	{
	     
	     if(g_error) do_rollback();

	     /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "savepoint LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )7487;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	     if (OERROR)
		err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

             g_savepoint = 1;


	     get_bank_acc_wo();				//positive entry for waival account
	     if(g_error) continue;



	     move_into_post_acc_wo(BANK);
	     ins_blgl_distrib_wo();
	     if(g_error) continue;	


	     get_bank_acc_bill_recv_int();
	     if(g_error) continue;	



	     move_into_post_acc_wo(OTHER);
	     ins_blgl_distrib_wo();
	     if(g_error) continue;



	     update_instl_wo();
	     if(g_error) continue;

	     /* EXEC SQL COMMIT; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )7502;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	     if (OERROR)
		err_mesg("COMMIT failed",0,""); 
	}
}

 open_bl_instl_wo_cur()
{
   /* EXEC SQL OPEN BL_INSTL_WO_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0038;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )7517;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
       err_mesg("OPEN failed on cursor BL_INSTL_WO_CUR",0,"");
}

int fetch_bl_instl_wo_cur()
{
       wo_rowid.arr[0] = '\0';
       wo_doc_type_code.arr[0] = '\0';                   	       	                                      
       wo_doc_num.arr[0] = '\0';
       wo_doc_date.arr[0] = '\0';                                
       wo_posted_ind.arr[0] = '\0';	                                    	       
       wo_episode_type.arr[0] = '\0';
       wo_org_doc_type_code.arr[0] = '\0';
       wo_org_doc_num.arr[0] = '\0';
       wo_org_doc_date.arr[0] = '\0';
       wo_remarks.arr[0] = '\0';
       wo_trx_type_code.arr[0] = '\0';
       wo_bill_type_code.arr[0] = '\0';
	   wo_cust_code.arr[0] = '\0';

       wo_doc_amt.arr[0] = '\0';
       wo_doc_rev_amt.arr[0] = '\0';
       
       wo_rowid.len = 0;
       wo_doc_type_code.len = 0;
       wo_doc_num.len = 0;
       wo_doc_date.len = 0;
       wo_posted_ind.len = 0;
       wo_episode_type.len = 0;
       wo_org_doc_type_code.len = 0;
       wo_org_doc_num.len = 0;
       wo_org_doc_date.len = 0;
       wo_remarks.len = 0;
       wo_trx_type_code.len = 0;
	   wo_bill_type_code.len = 0;
	   wo_cust_code.len = 0;
	   	
       wo_doc_amt.len = 0;
       wo_doc_rev_amt.len = 0;

       wo_doc_slno = 0;
       //ae_post_month = 0;
       //ae_post_year = 0;
       wo_episode_id = 0;
       wo_visit_id = 0;


       /* EXEC SQL FETCH BL_INSTL_WO_CUR INTO	       
	       wo_rowid,
	       wo_doc_type_code,                   
	       wo_doc_num,                         
	       wo_doc_slno,                               
	       wo_doc_date,                      
	       wo_doc_amt,                                
	       wo_doc_rev_amt,
	       wo_posted_ind,                             
	       //ae_post_month,                             
	       //ae_post_year,                              
	       //ae_unposted_reason,                        
	       wo_episode_type,
	       wo_episode_id,                             
	       wo_visit_id,                               	       
	       wo_org_doc_type_code,               
	       wo_org_num,                     
	       wo_org_doc_date,
	       wo_remarks,                                	
	       wo_trx_type_code,
		   wo_bill_type_code,
		   wo_cust_code; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 42;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )7540;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&wo_rowid;
       sqlstm.sqhstl[0] = (unsigned int  )32;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&wo_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&wo_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )22;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&wo_doc_slno;
       sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
       sqlstm.sqhstl[4] = (unsigned int  )32;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&wo_doc_amt;
       sqlstm.sqhstl[5] = (unsigned int  )32;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&wo_doc_rev_amt;
       sqlstm.sqhstl[6] = (unsigned int  )32;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&wo_posted_ind;
       sqlstm.sqhstl[7] = (unsigned int  )4;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&wo_episode_type;
       sqlstm.sqhstl[8] = (unsigned int  )4;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&wo_episode_id;
       sqlstm.sqhstl[9] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&wo_visit_id;
       sqlstm.sqhstl[10] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&wo_org_doc_type_code;
       sqlstm.sqhstl[11] = (unsigned int  )9;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&wo_org_num;
       sqlstm.sqhstl[12] = (unsigned int  )32;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&wo_org_doc_date;
       sqlstm.sqhstl[13] = (unsigned int  )32;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&wo_remarks;
       sqlstm.sqhstl[14] = (unsigned int  )203;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&wo_trx_type_code;
       sqlstm.sqhstl[15] = (unsigned int  )4;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&wo_bill_type_code;
       sqlstm.sqhstl[16] = (unsigned int  )5;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&wo_cust_code;
       sqlstm.sqhstl[17] = (unsigned int  )11;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	      if (OERROR)
	      err_mesg("FETCH failed on BL_INSTL_WO_CUR",0,"");

	      if (LAST_ROW)
		return (0);
		
	       wo_rowid.arr[wo_rowid.len] = '\0';
	       wo_doc_type_code.arr[wo_doc_type_code.len] = '\0';                   	       	                                      
	       wo_doc_num.arr[wo_doc_num.len] = '\0';
	       wo_doc_date.arr[wo_doc_date.len] = '\0';                                
	       wo_posted_ind.arr[wo_posted_ind.len] = '\0';	                                    	       
	       wo_episode_type.arr[wo_episode_type.len] = '\0';
	       wo_org_doc_type_code.arr[wo_org_doc_type_code.len] = '\0';
	       wo_org_doc_num.arr[wo_org_doc_num.len] = '\0';
	       wo_org_doc_date.arr[wo_org_doc_date.len] = '\0';
	       wo_remarks.arr[wo_remarks.len] = '\0';
	       wo_trx_type_code.arr[wo_trx_type_code.len] = '\0';	       
		   wo_bill_type_code.arr[wo_bill_type_code.len] = '\0';
		   wo_cust_code.arr[wo_cust_code.len] = '\0';		
		   
		   wo_doc_amt.arr[wo_doc_amt.len] = '\0';
	       wo_doc_rev_amt.arr[wo_doc_rev_amt.len] = '\0';
			
	   	
		   //get control ac and write off account from BL_BILL_TYPE_INT	
		   wo_bill_recv_int_code.arr[0] = '\0';
		   wo_int_code.arr[0] = '\0';			

			
		   wo_bill_recv_int_code.len = 0;
		   wo_int_code.len = 0;			   
		   

		   /* EXEC SQL SELECT BL_RECV_ACC_INT_CODE, WAIVAL_RECV_ACC_INT_CODE  
					INTO   :wo_bill_recv_int_code, :wo_int_code		
					FROM   BL_BILL_TYPE_INT
					WHERE  ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
												WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
					AND    BILL_TYPE_CODE  = :wo_bill_type_code
					AND    to_date(:wo_doc_date,'dd/mm/yyyy')
					between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) 
					AND     NVL(EFF_TO_DATE,SYSDATE); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 42;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select BL_RECV_ACC_INT_CODE ,WAIVAL_RECV_ACC_INT_CODE in\
to :b0,:b1  from BL_BILL_TYPE_INT where ((ACC_ENTITY_CODE in (select ACC_ENTIT\
Y_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b2) and BILL_TYPE_CODE=:b3) an\
d to_date(:b4,'dd/mm/yyyy') between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD\
/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE))";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )7627;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&wo_bill_recv_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&wo_int_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&wo_bill_type_code;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
     sqlstm.sqhstl[4] = (unsigned int  )32;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		   if (ROW_COUNT == 0)    
		   {	   
		      sprintf(msg_str,"Record(WO) for %s - %s not found in BL_BILL_TYPE_INT",
				  nd_operating_facility_id.arr,
				  wo_bill_type_code.arr);
				  
		      loc_log_msg(msg_str);	   
		      g_error = 1;
		      return;
		   }
	
		   if (strcmp(wo_int_code.arr, "\0")==0) 	
		   {
		      sprintf(msg_str,"Write Off Account code is not defined for Bill Type %s",
				  wo_bill_type_code.arr);
				  
			  loc_log_msg(msg_str);	   
		      g_error = 1;
		      return;
		   }

		   wo_bill_recv_int_code.arr[wo_bill_recv_int_code.len] = '\0';
		   wo_int_code.arr[wo_int_code.len] = '\0';	


		 if (wo_cust_code.arr[0] != '\0')	 		/* Modified on 23-MAR-2007 for Enhancement */
		 {
		   
		   wo_int_code.arr[0] = '\0';			
		   wo_int_code.len = 0;
			 
			 /* EXEC SQL SELECT  WAIVAL_RECV_ACC_INT_CODE  
					INTO     :wo_int_code		
					FROM   BL_BILL_TYPE_BY_PAYER_INT
					WHERE  ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
												WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
					AND    BILL_TYPE_CODE  = :wo_bill_type_code
					AND	   CUST_CODE = :wo_cust_code
					AND    to_date(:wo_doc_date,'dd/mm/yyyy')
					between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) 
					AND     NVL(EFF_TO_DATE,SYSDATE); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select WAIVAL_RECV_ACC_INT_CODE into :b0  from BL_BILL_TY\
PE_BY_PAYER_INT where (((ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_A\
CC_ENTITY where ACC_ENTITY_ID=:b1) and BILL_TYPE_CODE=:b2) and CUST_CODE=:b3) \
and to_date(:b4,'dd/mm/yyyy') between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','\
DD/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )7662;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&wo_int_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&wo_bill_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&wo_cust_code;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



              wo_int_code.arr[wo_int_code.len] = '\0';	
		 }                                         /* Modified on 23-MAR-2007 for Enhancement */



		return 1;
}


update_instl_wo()
{
    /* EXEC SQL UPDATE BL_INST_WO_REQUEST_DTL
	     SET POSTED_IND = 'Y',
	     MODIFIED_BY_ID = USER,
	     MODIFIED_DATE  = SYSDATE,
	     ADDED_AT_WS_NO = :nd_ws_no,
	     ADDED_FACILITY_ID = :nd_operating_facility_id,
	     MODIFIED_AT_WS_NO = :nd_ws_no,
	     MODIFIED_FACILITY_ID = :nd_operating_facility_id
          WHERE ROWID = :wo_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_INST_WO_REQUEST_DTL  set POSTED_IND='Y',MODIFIE\
D_BY_ID=USER,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED_FACILITY_ID=:b1,MO\
DIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWID=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )7697;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&wo_rowid;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR) 
       err_mesg("UPDATE failed on table BL_INST_WO_REQUEST_DTL",0,"");
       
    if (sqlca.sqlerrd[2] == 0 )
       err_mesg("UPDATE failed on table BL_INST_WO_REQUEST_DTL",0,"");    
}


post_instl_wo_cancel()
{
	open_bl_instl_wo_canc_cur();
	g_error = 0;
	g_savepoint = 0;

	while(fetch_bl_instl_wo_canc_cur())
	{
	   
	     if(g_error) do_rollback();

	     /* EXEC SQL SAVEPOINT LAST_DOC_REF; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "savepoint LAST_DOC_REF";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )7732;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	     if (OERROR)
		err_mesg("SAVEPOINT LAST_DOC_REF failed",0,""); 

             g_savepoint = 1;


	     get_bank_acc_wo();				//-ve entry for waival account
	     if(g_error) continue;

		 move_into_post_acc_wo(OTHER);
		 ins_blgl_distrib_wo();
		 if(g_error) continue;	

		 get_bank_acc_bill_recv_int();
		 if(g_error) continue;	

		 move_into_post_acc_wo(BANK);
		 ins_blgl_distrib_wo();
		 if(g_error) continue;

		 update_instl_canc_wo();
		 if(g_error) continue;

	     /* EXEC SQL COMMIT; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 42;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )7747;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
}


 open_bl_instl_wo_canc_cur()
{
   /* EXEC SQL OPEN BL_INSTL_WO_CANC_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 42;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0042;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )7762;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_date;
   sqlstm.sqhstl[1] = (unsigned int  )15;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
       err_mesg("OPEN failed on cursor BL_INSTL_WO_CANC_CUR",0,"");
}

int fetch_bl_instl_wo_canc_cur()
{
       wo_rowid.arr[0] = '\0';
       wo_doc_type_code.arr[0] = '\0';                   	       	                                      
       wo_doc_num.arr[0] = '\0';
       wo_doc_date.arr[0] = '\0';                                
       wo_posted_ind.arr[0] = '\0';	                                    	       
       wo_episode_type.arr[0] = '\0';
       wo_org_doc_type_code.arr[0] = '\0';
       wo_org_doc_num.arr[0] = '\0';
       wo_org_doc_date.arr[0] = '\0';
       wo_remarks.arr[0] = '\0';
       wo_trx_type_code.arr[0] = '\0';
       wo_bill_type_code.arr[0] = '\0';
	   wo_cust_code.arr[0] = '\0';

       wo_doc_amt.arr[0] = '\0';
       wo_doc_rev_amt.arr[0] = '\0';
       
       wo_rowid.len = 0;
       wo_doc_type_code.len = 0;
       wo_doc_num.len = 0;
       wo_doc_date.len = 0;
       wo_posted_ind.len = 0;
       wo_episode_type.len = 0;
       wo_org_doc_type_code.len = 0;
       wo_org_doc_num.len = 0;
       wo_org_doc_date.len = 0;
       wo_remarks.len = 0;
       wo_trx_type_code.len = 0;
       wo_bill_type_code.len = 0;
	   wo_cust_code.len = 0;
	   	
       wo_doc_amt.len = 0;
       wo_doc_rev_amt.len = 0;

       wo_doc_slno = 0;
       wo_episode_id = 0;
       wo_visit_id = 0;

       /* EXEC SQL FETCH BL_INSTL_WO_CANC_CUR INTO	       
	       wo_rowid,
	       wo_doc_type_code,                   
	       wo_doc_num,                         
	       wo_doc_slno,                               
	       wo_doc_date,                      
	       wo_doc_amt,                                
	       wo_doc_rev_amt,
	       wo_posted_ind,                             
	       //ae_post_month,                             
	       //ae_post_year,                              
	       //ae_unposted_reason,                        
	       wo_episode_type,
	       wo_episode_id,                             
	       wo_visit_id,                               	       
	       wo_org_doc_type_code,               
	       wo_org_num,                     
	       wo_org_doc_date,
	       wo_remarks,                                	
	       wo_trx_type_code,
		   wo_bill_type_code,
		   wo_cust_code; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 42;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )7785;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&wo_rowid;
       sqlstm.sqhstl[0] = (unsigned int  )32;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&wo_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&wo_doc_num;
       sqlstm.sqhstl[2] = (unsigned int  )22;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&wo_doc_slno;
       sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
       sqlstm.sqhstl[4] = (unsigned int  )32;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&wo_doc_amt;
       sqlstm.sqhstl[5] = (unsigned int  )32;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&wo_doc_rev_amt;
       sqlstm.sqhstl[6] = (unsigned int  )32;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&wo_posted_ind;
       sqlstm.sqhstl[7] = (unsigned int  )4;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&wo_episode_type;
       sqlstm.sqhstl[8] = (unsigned int  )4;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&wo_episode_id;
       sqlstm.sqhstl[9] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&wo_visit_id;
       sqlstm.sqhstl[10] = (unsigned int  )sizeof(long);
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&wo_org_doc_type_code;
       sqlstm.sqhstl[11] = (unsigned int  )9;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&wo_org_num;
       sqlstm.sqhstl[12] = (unsigned int  )32;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&wo_org_doc_date;
       sqlstm.sqhstl[13] = (unsigned int  )32;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&wo_remarks;
       sqlstm.sqhstl[14] = (unsigned int  )203;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&wo_trx_type_code;
       sqlstm.sqhstl[15] = (unsigned int  )4;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&wo_bill_type_code;
       sqlstm.sqhstl[16] = (unsigned int  )5;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&wo_cust_code;
       sqlstm.sqhstl[17] = (unsigned int  )11;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	      if (OERROR)
	      err_mesg("FETCH failed on BL_INSTL_WO_CANC_CUR",0,"");



	      if (LAST_ROW) return (0);


	       
	       wo_rowid.arr[wo_rowid.len] = '\0';
	       wo_doc_type_code.arr[wo_doc_type_code.len] = '\0';                   	       	                                      
	       wo_doc_num.arr[wo_doc_num.len] = '\0';
	       wo_doc_date.arr[wo_doc_date.len] = '\0';                                
	       wo_posted_ind.arr[wo_posted_ind.len] = '\0';	                                    	       
	       wo_episode_type.arr[wo_episode_type.len] = '\0';
	       wo_org_doc_type_code.arr[wo_org_doc_type_code.len] = '\0';
	       wo_org_doc_num.arr[wo_org_doc_num.len] = '\0';
	       wo_org_doc_date.arr[wo_org_doc_date.len] = '\0';
	       wo_remarks.arr[wo_remarks.len] = '\0';
	       wo_trx_type_code.arr[wo_trx_type_code.len] = '\0';	       
		   wo_bill_type_code.arr[wo_bill_type_code.len] = '\0';	
		        
	       wo_doc_amt.arr[wo_doc_amt.len] = '\0';
	       wo_doc_rev_amt.arr[wo_doc_rev_amt.len] = '\0';
		   wo_cust_code.arr[wo_cust_code.len] = '\0';
	   	
		   //get control ac and write off account from BL_BILL_TYPE_INT	
		   wo_bill_recv_int_code.arr[0] = '\0';
		   wo_int_code.arr[0] = '\0';			

		   wo_bill_recv_int_code.len = 0;
		   wo_int_code.len = 0;	
		   


		   /* EXEC SQL SELECT BL_RECV_ACC_INT_CODE, WAIVAL_RECV_ACC_INT_CODE  
					INTO   :wo_bill_recv_int_code, :wo_int_code		
					FROM   BL_BILL_TYPE_INT
					WHERE  ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
												WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
					AND    BILL_TYPE_CODE  = :wo_bill_type_code
					AND    to_date(:wo_doc_date,'DD/MM/YYYY')
					between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) 
					AND     NVL(EFF_TO_DATE,SYSDATE); */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 42;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select BL_RECV_ACC_INT_CODE ,WAIVAL_RECV_ACC_INT_CODE in\
to :b0,:b1  from BL_BILL_TYPE_INT where ((ACC_ENTITY_CODE in (select ACC_ENTIT\
Y_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b2) and BILL_TYPE_CODE=:b3) an\
d to_date(:b4,'DD/MM/YYYY') between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD\
/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE))";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )7872;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&wo_bill_recv_int_code;
     sqlstm.sqhstl[0] = (unsigned int  )9;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&wo_int_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&wo_bill_type_code;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
     sqlstm.sqhstl[4] = (unsigned int  )32;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}





		   if (ROW_COUNT == 0)    
		   {	   
		      sprintf(msg_str,"Record(WO) for %s - %s not found in BL_BILL_TYPE_INT",
				  nd_operating_facility_id.arr,
				  wo_bill_type_code.arr);
				  
			  loc_log_msg(msg_str);	   
		      g_error = 1;
		      return;
		   }		

		   if (strcmp(wo_int_code.arr, "\0")==0) 	
		   {
		      sprintf(msg_str,"Write Off Account code is not defined for Bill Type %s",
				  wo_bill_type_code.arr);
				  
		      loc_log_msg(msg_str);	   
		      g_error = 1;
		      return;
		   }

		   wo_bill_recv_int_code.arr[wo_bill_recv_int_code.len] = '\0';
		   wo_int_code.arr[wo_int_code.len] = '\0';	

		    if (wo_cust_code.arr[0] != '\0')	 		/* Modified on 23-MAR-2007 for Enhancement */
		 {
		   
		   wo_int_code.arr[0] = '\0';			
		   wo_int_code.len = 0;
			 
			 /* EXEC SQL SELECT WAIVAL_RECV_ACC_INT_CODE  
					INTO    :wo_int_code		
					FROM   BL_BILL_TYPE_BY_PAYER_INT
					WHERE  ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
												WHERE ACC_ENTITY_ID = :nd_operating_facility_id)
					AND    BILL_TYPE_CODE  = :wo_bill_type_code
					AND	   CUST_CODE = :wo_cust_code
					AND    to_date(:wo_doc_date,'dd/mm/yyyy')
					between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','DD/MM/YYYY')) 
					AND     NVL(EFF_TO_DATE,SYSDATE); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select WAIVAL_RECV_ACC_INT_CODE into :b0  from BL_BILL_TY\
PE_BY_PAYER_INT where (((ACC_ENTITY_CODE in (select ACC_ENTITY_CODE  from SY_A\
CC_ENTITY where ACC_ENTITY_ID=:b1) and BILL_TYPE_CODE=:b2) and CUST_CODE=:b3) \
and to_date(:b4,'dd/mm/yyyy') between NVL(EFF_FROM_DATE,TO_DATE('01/01/1900','\
DD/MM/YYYY')) and NVL(EFF_TO_DATE,SYSDATE))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )7907;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&wo_int_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&wo_bill_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&wo_cust_code;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&wo_doc_date;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



           
		    wo_int_code.arr[wo_int_code.len] = '\0';	
		 }                                         /* Modified on 23-MAR-2007 for Enhancement */





		return 1;
}


 update_instl_canc_wo()
{
    /* EXEC SQL UPDATE BL_INST_WO_REQUEST_CANC_DTL
	     SET POSTED_IND = 'Y',
	     MODIFIED_BY_ID = USER,
	     MODIFIED_DATE  = SYSDATE,
	     ADDED_AT_WS_NO = :nd_ws_no,
	     ADDED_FACILITY_ID = :nd_operating_facility_id,
	     MODIFIED_AT_WS_NO = :nd_ws_no,
	     MODIFIED_FACILITY_ID = :nd_operating_facility_id
         WHERE ROWID = :wo_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 42;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_INST_WO_REQUEST_CANC_DTL  set POSTED_IND='Y',MO\
DIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,ADDED_AT_WS_NO=:b0,ADDED_FACILITY_ID=:\
b1,MODIFIED_AT_WS_NO=:b0,MODIFIED_FACILITY_ID=:b1 where ROWID=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )7942;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&wo_rowid;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR) 
       err_mesg("UPDATE failed on table BL_INST_WO_REQUEST_CANC_DTL",0,"");
       
    if (sqlca.sqlerrd[2] == 0 )
       err_mesg("UPDATE failed on table BL_INST_WO_REQUEST_CANC_DTL",0,"");
}