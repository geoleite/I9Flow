<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="lgc_logicaJB" class="br.com.i9.flow.jb.Lgc_logicaConsultJB" scope="request"/>                                         
<jsp:setProperty name="lgc_logicaJB" property="*"/>                                         
<jsp:setProperty name="lgc_logicaJB" property="page" value="${pageContext}"/>                                         
${lgc_logicaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${lgc_logicaJB.list}" var="item">
     ,{	"lgc_nr_id":"${item.lgc_nr_id}"
 ,	"tra_nr_id":"${item.tra_nr_id}"
 ,	"lgc_tx_classe":"${item.lgc_tx_classe}"
 ,	"lgc_tx_status":"${item.lgc_tx_status}"
 ,	"lgc_nr_ordem":"${item.lgc_nr_ordem}"
 ,	"lgc_tx_descricao":"${item.lgc_tx_descricao}"
  }
</c:forEach>
]}                                                                                
   
