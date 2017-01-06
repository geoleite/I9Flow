<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="lgc_logicaJB" class="br.com.i9.flow.jb.Lgc_logicaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="lgc_logicaJB" property="*"/>                                         
<jsp:setProperty name="lgc_logicaJB" property="page" value="${pageContext}"/>                                         
${lgc_logicaJB.execute}                                         
{"resultado":
{"msg":"${lgc_logicaJB.msg}",
     "lgc_logica":{	"lgc_nr_id":"${lgc_logicaJB.lgc_logicaT.lgc_nr_id}"
 ,	"tra_nr_id":"${lgc_logicaJB.lgc_logicaT.tra_nr_id}"
 ,	"lgc_tx_classe":"${lgc_logicaJB.lgc_logicaT.lgc_tx_classe}"
 ,	"lgc_tx_status":"${lgc_logicaJB.lgc_logicaT.lgc_tx_status}"
 ,	"lgc_nr_ordem":"${lgc_logicaJB.lgc_logicaT.lgc_nr_ordem}"
 ,	"lgc_tx_descricao":"${lgc_logicaJB.lgc_logicaT.lgc_tx_descricao}"
  }
    }
     
}                                                                                
   
