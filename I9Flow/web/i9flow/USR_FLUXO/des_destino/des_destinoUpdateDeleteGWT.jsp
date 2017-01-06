<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="des_destinoJB" class="br.com.i9.flow.jb.Des_destinoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="des_destinoJB" property="*"/>                                         
<jsp:setProperty name="des_destinoJB" property="page" value="${pageContext}"/>                                         
${des_destinoJB.execute}                                         
{"resultado":
{"msg":"${des_destinoJB.msg}",
     "des_destino":{	"des_nr_id":"${des_destinoJB.des_destinoT.des_nr_id}"
 ,	"des_tx_tipo":"${des_destinoJB.des_destinoT.des_tx_tipo}"
 ,	"des_nr_idregistro":"${des_destinoJB.des_destinoT.des_nr_idregistro}"
  }
    }
     
}                                                                                
   
