<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="did_documento_identificacaoJB" class="br.com.i9.flow.jb.Did_documento_identificacaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="did_documento_identificacaoJB" property="*"/>                                         
<jsp:setProperty name="did_documento_identificacaoJB" property="page" value="${pageContext}"/>                                         
${did_documento_identificacaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${did_documento_identificacaoJB.list}" var="item">
     ,{	"did_nr_id":"${item.did_nr_id}"
 ,	"flx_nr_id":"${item.flx_nr_id}"
 ,	"did_tx_nomecoluna":"${item.did_tx_nomecoluna}"
 ,	"did_tx_valor":"${item.did_tx_valor}"
  }
</c:forEach>
]}                                                                                
   
