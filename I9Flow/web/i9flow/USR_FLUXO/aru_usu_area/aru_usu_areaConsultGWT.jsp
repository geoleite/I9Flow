<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="aru_usu_areaJB" class="br.com.i9.flow.jb.Aru_usu_areaConsultJB" scope="request"/>                                         
<jsp:setProperty name="aru_usu_areaJB" property="*"/>                                         
<jsp:setProperty name="aru_usu_areaJB" property="page" value="${pageContext}"/>                                         
${aru_usu_areaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${aru_usu_areaJB.list}" var="item">
     ,{	"usu_nr_id":"${item.usu_nr_id}"
 ,	"are_nr_id":"${item.are_nr_id}"
  }
</c:forEach>
]}                                                                                
   
