<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tra_tramiteJB" class="br.com.i9.flow.jb.Tra_tramiteUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tra_tramiteJB" property="*"/>                                         
<jsp:setProperty name="tra_tramiteJB" property="page" value="${pageContext}"/>                                         
${tra_tramiteJB.execute}                                         
{"resultado":
{"msg":"${tra_tramiteJB.msg}",
     "tra_tramite":{	"tra_nr_id":"${tra_tramiteJB.tra_tramiteT.tra_nr_id}"
 ,	"des_nr_id":"${tra_tramiteJB.tra_tramiteT.des_nr_id}"
 ,	"tid_nr_id":"${tra_tramiteJB.tra_tramiteT.tid_nr_id}"
 ,	"usu_nr_id":"${tra_tramiteJB.tra_tramiteT.usu_nr_id}"
 ,	"tra_tx_nome":"${tra_tramiteJB.tra_tramiteT.tra_tx_nome}"
 ,	"tra_tx_automatico":"${tra_tramiteJB.tra_tramiteT.tra_tx_automatico}"
  }
    }
     
}                                                                                
   
