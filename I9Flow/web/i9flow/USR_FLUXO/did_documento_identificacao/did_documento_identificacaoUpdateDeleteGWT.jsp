<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="did_documento_identificacaoJB" class="br.com.i9.flow.jb.Did_documento_identificacaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="did_documento_identificacaoJB" property="*"/>                                         
<jsp:setProperty name="did_documento_identificacaoJB" property="page" value="${pageContext}"/>                                         
${did_documento_identificacaoJB.execute}                                         
{"resultado":
{"msg":"${did_documento_identificacaoJB.msg}",
     "did_documento_identificacao":{	"did_nr_id":"${did_documento_identificacaoJB.did_documento_identificacaoT.did_nr_id}"
 ,	"flx_nr_id":"${did_documento_identificacaoJB.did_documento_identificacaoT.flx_nr_id}"
 ,	"did_tx_nomecoluna":"${did_documento_identificacaoJB.did_documento_identificacaoT.did_tx_nomecoluna}"
 ,	"did_tx_valor":"${did_documento_identificacaoJB.did_documento_identificacaoT.did_tx_valor}"
  }
    }
     
}                                                                                
   
