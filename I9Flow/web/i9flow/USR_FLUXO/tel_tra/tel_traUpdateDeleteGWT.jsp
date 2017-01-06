<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tel_traJB" class="br.com.i9.flow.jb.Tel_traUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tel_traJB" property="*"/>                                         
<jsp:setProperty name="tel_traJB" property="page" value="${pageContext}"/>                                         
${tel_traJB.execute}                                         
{"resultado":
{"msg":"${tel_traJB.msg}",
     "tel_tra":{	"tra_nr_id":"${tel_traJB.tel_traT.tra_nr_id}"
 ,	"tel_nr_id":"${tel_traJB.tel_traT.tel_nr_id}"
  }
    }
     
}                                                                                
   
