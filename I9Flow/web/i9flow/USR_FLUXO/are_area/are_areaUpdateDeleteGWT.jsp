<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="are_areaJB" class="br.com.i9.flow.jb.Are_areaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="are_areaJB" property="*"/>                                         
<jsp:setProperty name="are_areaJB" property="page" value="${pageContext}"/>                                         
${are_areaJB.execute}                                         
{"resultado":
{"msg":"${are_areaJB.msg}",
     "are_area":{	"are_nr_id":"${are_areaJB.are_areaT.are_nr_id}"
 ,	"are_tx_nome":"${are_areaJB.are_areaT.are_tx_nome}"
  }
    }
     
}                                                                                
   
