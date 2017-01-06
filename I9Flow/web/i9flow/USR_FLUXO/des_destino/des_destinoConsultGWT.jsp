<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="des_destinoJB" class="br.com.i9.flow.jb.Des_destinoConsultJB" scope="request"/>                                         
<jsp:setProperty name="des_destinoJB" property="*"/>                                         
<jsp:setProperty name="des_destinoJB" property="page" value="${pageContext}"/>                                         
${des_destinoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${des_destinoJB.list}" var="item">
     ,{	"des_nr_id":"${item.des_nr_id}"
 ,	"des_tx_tipo":"${item.des_tx_tipo}"
 ,	"des_nr_idregistro":"${item.des_nr_idregistro}"
  }
</c:forEach>
]}                                                                                
   
