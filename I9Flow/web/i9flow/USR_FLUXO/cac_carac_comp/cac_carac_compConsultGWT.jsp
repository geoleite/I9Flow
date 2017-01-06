<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cac_carac_compJB" class="br.com.i9.flow.jb.Cac_carac_compConsultJB" scope="request"/>                                         
<jsp:setProperty name="cac_carac_compJB" property="*"/>                                         
<jsp:setProperty name="cac_carac_compJB" property="page" value="${pageContext}"/>                                         
${cac_carac_compJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cac_carac_compJB.list}" var="item">
     ,{	"tra_nr_id":"${item.tra_nr_id}"
 ,	"tel_nr_id":"${item.tel_nr_id}"
 ,	"cac_nr_id":"${item.cac_nr_id}"
 ,	"cac_tx_idcomponente":"${item.cac_tx_idcomponente}"
 ,	"cac_tx_visivel":"${item.cac_tx_visivel}"
 ,	"cac_tx_habilitado":"${item.cac_tx_habilitado}"
 ,	"cac_tx_editavel":"${item.cac_tx_editavel}"
  }
</c:forEach>
]}                                                                                
   
