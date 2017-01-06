<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="are_areaJB" class="br.com.i9.flow.jb.Are_areaConsultJB" scope="request"/>                                         
<jsp:setProperty name="are_areaJB" property="*"/>                                         
<jsp:setProperty name="are_areaJB" property="page" value="${pageContext}"/>                                         
${are_areaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${are_areaJB.list}" var="item">
     ,{	"are_nr_id":"${item.are_nr_id}"
 ,	"are_tx_nome":"${item.are_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
