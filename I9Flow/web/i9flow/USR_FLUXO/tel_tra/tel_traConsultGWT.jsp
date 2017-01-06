<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tel_traJB" class="br.com.i9.flow.jb.Tel_traConsultJB" scope="request"/>                                         
<jsp:setProperty name="tel_traJB" property="*"/>                                         
<jsp:setProperty name="tel_traJB" property="page" value="${pageContext}"/>                                         
${tel_traJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tel_traJB.list}" var="item">
     ,{	"tra_nr_id":"${item.tra_nr_id}"
 ,	"tel_nr_id":"${item.tel_nr_id}"
  }
</c:forEach>
]}                                                                                
   
