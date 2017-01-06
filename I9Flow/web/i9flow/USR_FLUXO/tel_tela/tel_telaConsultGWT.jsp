<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tel_telaJB" class="br.com.i9.flow.jb.Tel_telaConsultJB" scope="request"/>                                         
<jsp:setProperty name="tel_telaJB" property="*"/>                                         
<jsp:setProperty name="tel_telaJB" property="page" value="${pageContext}"/>                                         
${tel_telaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tel_telaJB.list}" var="item">
     ,{	"tel_nr_id":"${item.tel_nr_id}"
 ,	"tel_tx_nome":"${item.tel_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
