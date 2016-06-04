package clinica.service.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import clinica.model.Paziente;
import clinica.model.TipologiaEsame;
import clinica.service.impl.FacadePaziente;
import clinica.service.impl.FacadeTipologiaEsame;
@Component
public class EditorTipologiaEsame extends PropertyEditorSupport{
	private @Autowired FacadeTipologiaEsame facadeTipologiaEsame;
	
	 @Override
	    public void setAsText(String text) {
	        TipologiaEsame t = this.facadeTipologiaEsame.retrieveTipologiaEsame(Long.valueOf(text));

	        this.setValue(t);
	    }
}
