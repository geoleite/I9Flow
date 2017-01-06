<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tra_tramiteJB" class="br.com.i9.flow.jb.Tra_tramiteConsultJB" scope="request"/>                                         
<jsp:setProperty name="tra_tramiteJB" property="*"/>                                         
<jsp:setProperty name="tra_tramiteJB" property="page" value="${pageContext}"/>                                         
${tra_tramiteJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tra_tramiteJB.list}" var="item">
     ,{	"tra_nr_id":"${item.tra_nr_id}"
 ,	"des_nr_id":"${item.des_nr_id}"
 ,	"tid_nr_id":"${item.tid_nr_id}"
 ,	"usu_nr_id":"${item.usu_nr_id}"
 ,	"tra_tx_nome":"${item.tra_tx_nome}"
 ,	"tra_tx_automatico":"${item.tra_tx_automatico}"
  }
</c:forEach>
]}                                                                                
   
