<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cac_carac_compJB" class="br.com.i9.flow.jb.Cac_carac_compUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cac_carac_compJB" property="*"/>                                         
<jsp:setProperty name="cac_carac_compJB" property="page" value="${pageContext}"/>                                         
${cac_carac_compJB.execute}                                         
{"resultado":
{"msg":"${cac_carac_compJB.msg}",
     "cac_carac_comp":{	"tra_nr_id":"${cac_carac_compJB.cac_carac_compT.tra_nr_id}"
 ,	"tel_nr_id":"${cac_carac_compJB.cac_carac_compT.tel_nr_id}"
 ,	"cac_nr_id":"${cac_carac_compJB.cac_carac_compT.cac_nr_id}"
 ,	"cac_tx_idcomponente":"${cac_carac_compJB.cac_carac_compT.cac_tx_idcomponente}"
 ,	"cac_tx_visivel":"${cac_carac_compJB.cac_carac_compT.cac_tx_visivel}"
 ,	"cac_tx_habilitado":"${cac_carac_compJB.cac_carac_compT.cac_tx_habilitado}"
 ,	"cac_tx_editavel":"${cac_carac_compJB.cac_carac_compT.cac_tx_editavel}"
  }
    }
     
}                                                                                
   
