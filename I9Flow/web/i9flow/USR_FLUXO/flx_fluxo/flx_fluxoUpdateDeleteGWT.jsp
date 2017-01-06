<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="flx_fluxoJB" class="br.com.i9.flow.jb.Flx_fluxoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="flx_fluxoJB" property="*"/>                                         
<jsp:setProperty name="flx_fluxoJB" property="page" value="${pageContext}"/>                                         
${flx_fluxoJB.execute}                                         
{"resultado":
{"msg":"${flx_fluxoJB.msg}",
     "flx_fluxo":{	"flx_nr_id":"${flx_fluxoJB.flx_fluxoT.flx_nr_id}"
 ,	"flx_dt_movimentacao":"<fmt:formatDate value="${flx_fluxoJB.flx_fluxoT.flx_dt_movimentacao}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"flx_tx_obs":"${flx_fluxoJB.flx_fluxoT.flx_tx_obs}"
 ,	"flx_dt_finalizado":"<fmt:formatDate value="${flx_fluxoJB.flx_fluxoT.flx_dt_finalizado}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"flx_nr_idanterior":"${flx_fluxoJB.flx_fluxoT.flx_nr_idanterior}"
 ,	"tra_nr_idorigem":"${flx_fluxoJB.flx_fluxoT.tra_nr_idorigem}"
 ,	"tra_nr_iddestino":"${flx_fluxoJB.flx_fluxoT.tra_nr_iddestino}"
 ,	"usu_nr_id":"${flx_fluxoJB.flx_fluxoT.usu_nr_id}"
  }
    }
     
}                                                                                
   
