<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="opt_opcao_tramiteJB" class="br.com.i9.flow.jb.Opt_opcao_tramiteUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="opt_opcao_tramiteJB" property="*"/>                                         
<jsp:setProperty name="opt_opcao_tramiteJB" property="page" value="${pageContext}"/>                                         
${opt_opcao_tramiteJB.execute}                                         
{"resultado":
{"msg":"${opt_opcao_tramiteJB.msg}",
     "opt_opcao_tramite":{	"tra_nr_idorigem":"${opt_opcao_tramiteJB.opt_opcao_tramiteT.tra_nr_idorigem}"
 ,	"tra_nr_iddestino":"${opt_opcao_tramiteJB.opt_opcao_tramiteT.tra_nr_iddestino}"
 ,	"opt_nr_ordem":"${opt_opcao_tramiteJB.opt_opcao_tramiteT.opt_nr_ordem}"
 ,	"opt_tx_retorno":"${opt_opcao_tramiteJB.opt_opcao_tramiteT.opt_tx_retorno}"
 ,	"opt_tx_nome":"${opt_opcao_tramiteJB.opt_opcao_tramiteT.opt_tx_nome}"
  }
    }
     
}                                                                                
   
