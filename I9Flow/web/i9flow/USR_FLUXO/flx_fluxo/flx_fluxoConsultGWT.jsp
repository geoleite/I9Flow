<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="flx_fluxoJB" class="br.com.i9.flow.jb.Flx_fluxoConsultJB" scope="request"/>                                         
<jsp:setProperty name="flx_fluxoJB" property="*"/>                                         
<jsp:setProperty name="flx_fluxoJB" property="page" value="${pageContext}"/>                                         
${flx_fluxoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${flx_fluxoJB.list}" var="item">
     ,{	"flx_nr_id":"${item.flx_nr_id}"
 ,	"flx_dt_movimentacao":"<fmt:formatDate value="${item.flx_dt_movimentacao}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"usu_nr_id":"${item.usu_nr_id}"
 ,	"flx_tx_obs":"${item.flx_tx_obs}"
 ,	"flx_dt_finalizado":"<fmt:formatDate value="${item.flx_dt_finalizado}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"flx_nr_idanterior":"${item.flx_nr_idanterior}"
 ,	"tra_nr_idorigem":"${item.tra_nr_idorigem}"
 ,	"tra_nr_iddestino":"${item.tra_nr_iddestino}"
  }
</c:forEach>
]}                                                                                
   
