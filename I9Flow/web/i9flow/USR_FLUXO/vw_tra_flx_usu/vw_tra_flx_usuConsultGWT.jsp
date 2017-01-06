<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_tra_flx_usuJB" class="br.com.i9.flow.jb.Vw_tra_flx_usuConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_tra_flx_usuJB" property="*"/>                                         
<jsp:setProperty name="vw_tra_flx_usuJB" property="page" value="${pageContext}"/>                                         
${vw_tra_flx_usuJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${vw_tra_flx_usuJB.list}" var="item">
     ,{	"tra_nr_id":"${item.tra_nr_id}"
 ,	"des_nr_id":"${item.des_nr_id}"
 ,	"tid_nr_id":"${item.tid_nr_id}"
 ,	"usu_nr_idowner":"${item.usu_nr_idowner}"
 ,	"tra_tx_nome":"${item.tra_tx_nome}"
 ,	"tra_tx_automatico":"${item.tra_tx_automatico}"
 ,	"flx_nr_id":"${item.flx_nr_id}"
 ,	"flx_dt_movimentacao":"<fmt:formatDate value="${item.flx_dt_movimentacao}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"flx_tx_obs":"${item.flx_tx_obs}"
 ,	"flx_dt_finalizado":"<fmt:formatDate value="${item.flx_dt_finalizado}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"flx_nr_idanterior":"${item.flx_nr_idanterior}"
 ,	"tra_nr_idorigem":"${item.tra_nr_idorigem}"
 ,	"tra_nr_iddestino":"${item.tra_nr_iddestino}"
 ,	"usu_nr_id":"${item.usu_nr_id}"
 ,	"usu_tx_nome":"${item.usu_tx_nome}"
 ,	"usu_tx_login":"${item.usu_tx_login}"
 ,	"usu_tx_status":"${item.usu_tx_status}"
 ,	"usu_tx_email":"${item.usu_tx_email}"
 ,	"ids":"${item.ids}"
  }
</c:forEach>
]}                                                                                
   
