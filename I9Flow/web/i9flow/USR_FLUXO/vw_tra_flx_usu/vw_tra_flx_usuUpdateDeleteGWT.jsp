<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_tra_flx_usuJB" class="br.com.i9.flow.jb.Vw_tra_flx_usuUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_tra_flx_usuJB" property="*"/>                                         
<jsp:setProperty name="vw_tra_flx_usuJB" property="page" value="${pageContext}"/>                                         
${vw_tra_flx_usuJB.execute}                                         
{"resultado":
{"msg":"${vw_tra_flx_usuJB.msg}",
     "vw_tra_flx_usu":{	"tra_nr_id":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.tra_nr_id}"
 ,	"des_nr_id":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.des_nr_id}"
 ,	"tid_nr_id":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.tid_nr_id}"
 ,	"usu_nr_idowner":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.usu_nr_idowner}"
 ,	"tra_tx_nome":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.tra_tx_nome}"
 ,	"tra_tx_automatico":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.tra_tx_automatico}"
 ,	"flx_nr_id":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.flx_nr_id}"
 ,	"flx_dt_movimentacao":"<fmt:formatDate value="${vw_tra_flx_usuJB.vw_tra_flx_usuT.flx_dt_movimentacao}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"flx_tx_obs":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.flx_tx_obs}"
 ,	"flx_dt_finalizado":"<fmt:formatDate value="${vw_tra_flx_usuJB.vw_tra_flx_usuT.flx_dt_finalizado}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"flx_nr_idanterior":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.flx_nr_idanterior}"
 ,	"tra_nr_idorigem":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.tra_nr_idorigem}"
 ,	"tra_nr_iddestino":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.tra_nr_iddestino}"
 ,	"usu_nr_id":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.usu_nr_id}"
 ,	"usu_tx_nome":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.usu_tx_nome}"
 ,	"usu_tx_login":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.usu_tx_login}"
 ,	"usu_tx_status":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.usu_tx_status}"
 ,	"usu_tx_email":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.usu_tx_email}"
 ,	"ids":"${vw_tra_flx_usuJB.vw_tra_flx_usuT.ids}"
  }
    }
     
}                                                                                
   
